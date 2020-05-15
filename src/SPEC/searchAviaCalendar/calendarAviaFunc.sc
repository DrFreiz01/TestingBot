theme: /calendarAviaFunc


    state: neighborDates
        script:
            var result = calendarSearchPost({from: $session.from, dest: $session.dest, passengers: $session.adults});
            //проверяем, что есть ответ
            if (result.isOk && (!isArrayEmpty(result.data.prices)) && result.status >= 200 && result.status < 300) {
                var neighborDates = [];
                var index;
                // ищем дату пользователя
                for (var i = 0; i < result.data.prices.length; i++) {
                    if (result.data.prices[i].date == $session.dates) {
                        index = i;
                    }
                }
                // ищем подходящие даты вокруг
                for (i = index-7; i < index + 8; i++) {
                    if (result.data.prices[i] && result.data.prices[i].price < $session.prices && result.data.prices[i].date != $session.date) {
                        neighborDates.push(result.data.prices[i]);
                    }
                }
                //$reactions.answer('neighborDates: ' + toPrettyString(neighborDates));

                // если дат с билетами дешевле много, ищем ближайшую к дате клиента
                if (neighborDates && neighborDates.length > 1) {
                    var currDiff, bestDate;
                    var bestDiff = 7;
                    for (var i = 0; i < neighborDates.length; i++) {
                        var dateClient = new Date($session.dates);
                        var dateCalendar = new Date(neighborDates[i].date);
                        currDiff = absVal(dateCalendar - dateClient);
                        currDiff = currDiff / (60*60*24*1000);
                        if (currDiff < bestDiff) {
                            var bestDate = i;
                            //$reactions.answer('bestDate: ' + bestDate);
                            bestDiff = currDiff;
                        }
                    }

                    //$reactions.answer('bestDiff: ' + bestDiff);

                    if (typeof(bestDate) == 'number') {
                        //$reactions.answer('bestDate: ' + bestDate);
                        $session.otherCalendarOpt = neighborDates.splice(bestDate, 1);
                        $session.dates = neighborDates[bestDate].date;
                        $session.prices = neighborDates[bestDate].price;
                        $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                        $reactions.transition('/aviaSearchAns/calendarAviaResult');
                    } else {
                        $reactions.transition('/aviaSearchAns/noResNeighborDates');
                    }
                } else if (neighborDates && neighborDates.length == 1) {
                    $session.dates = neighborDates[0].date;
                    $session.prices = neighborDates[0].price;
                    $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                    $reactions.transition('/aviaSearchAns/calendarAviaResult');
                } else {
                    $reactions.transition('/aviaSearchAns/noResNeighborDates');
                }
            } else {
                $reactions.transition('/aviaSearchAns/noResNeighborDates');
            }



    state: moreCalenarOptions
        script:
            $session.otherCalendarOpt.sort(function(a, b) {
                a = new Date(a.dateModified);
                b = new Date(b.dateModified);
                return a>b ? -1 : a<b ? 1 : 0;
            });
            var temparray = [];
            var i,j,chunk = 5;
            for (i=0,j=$session.otherCalendarOpt.length; i<j; i+=chunk) {
                temparray.push($session.otherCalendarOpt.slice(i,i+chunk));
            }
            if (temparray.length > $session.score && (temparray[$session.score].length > 0)) {
                for (var j = 0; j < temparray[$session.score].length; j++) {
                    var peice = temparray[$session.score];
                    $reactions.answer(getDate4User(peice[j].date) + ': ' + urlOzonAvia({from: $session.from, dest: $session.dest, date: peice[j].date, passengers: $session.adults}, $session.yandex));
                }
                if ($session.score != temparray.length - 1) {
                        $reactions.transition('/aviaSearchAns/calendarShowMore');
                } else {
                    $reactions.answer('Это все доступные варианты. Я могу еще чем-то помочь?');
                }
            } else {
                $reactions.answer('Это все доступные варианты. Я могу еще чем-то помочь?');
            }



    state: theCheapest
        script:
            if ($session.from != $session.dest) {
                var result = calendarSearchPost({from: $session.from, dest: $session.dest, passengers: $session.adults});
                                //проверяем, что есть ответ
                if (result.isOk && (!isArrayEmpty(result.data.prices)) && result.status >= 200 && result.status < 300) {
                    $session.calendarList = [];
                    //проходим по календарю цен и собираем минимальные
                    for (var i = 0; i < result.data.prices.length; i++) {
                        if (result.data.prices[i].hasOwnProperty('isMin') && result.data.prices[i].isMin == true) {
                            $session.calendarList.push(result.data.prices[i]);
                        } else {
                            $reactions.transition("/aviaSearchAns/aviaSearchError");
                        }
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchError");
                }
                $session.dates = $session.calendarList[0].date;
                $session.prices = $session.calendarList[0].price;
                $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                if ($session.calendarList.length > 1) {
                    $session.calendarList.splice(0,1);
                    $session.otherCalendarOpt = $session.calendarList;
                }
                $reactions.transition('/aviaSearchAns/calendarAviaResult');
            } else {
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }



    state: monthCheapest
        script:
            $session.monthCheapest = true;
            var result = calendarSearchPost({from: $session.from, dest: $session.dest, passengers: $session.adults});
            if (result && result.data && result.data.prices) {
                var pricesArray = result.data.prices;
            } else {
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }
            //проверяем, что есть ответ
            if (result.isOk && (!isArrayEmpty(pricesArray)) && result.status >= 200 && result.status < 300) {
                // НАХОДИМ НУЖНЫЙ МЕСЯЦ
                var currentDate = new Date();
                var year = currentDate.getFullYear();
                currentDate.setDate(currentDate.getDate());
                var thisMonth = currentDate.getMonth() + 1;
                thisMonth = addZero(thisMonth.toString());
                if ($session.month < thisMonth) {
                    year = year + 1;
                }
                // СОБИРАЕМ СПИСОК НИЗКИХ ЦЕН
                var neededMonth = [];
                var lowestPrices = [];
                var isItRightDate = function (value) {
                    value.date = value.date.split('-');
                    if ($session.begOfMonth) {
                        if(value.date[0] == year && value.date[1] == $session.month && value.date[2] <= 10) {
                            value.date = value.date.join('-');
                            return value;
                        }
                    } else if ($session.endOfMonth) {
                        if(value.date[0] == year && value.date[1] == $session.month && value.date[2] >= 20) {
                            value.date = value.date.join('-');
                            return value;
                        }
                    } else {
                        if(value.date[0] == year && value.date[1] == $session.month) {
                            value.date = value.date.join('-');
                            return value;
                        }
                    }
                }
                neededMonth = pricesArray.filter(isItRightDate);

                // функции
                var isMin = function(value) {
                    if (value.hasOwnProperty('isMin')) {
                        return value;
                    }
                }
                var isLow = function(value) {
                    if (value.color == 'LOW') {
                        return value;
                    }
                }
                var isMed = function(value) {
                    if (value.color == 'MEDIUM') {
                        return value;
                    }
                }
                var isHigh = function(value) {
                    if (value.color == 'HIGH') {
                        return value;
                    }
                }
                lowestPrices = neededMonth.filter(isMin);
                if (lowestPrices.length == 0) {
                    lowestPrices = neededMonth.filter(isLow);
                }
                if (lowestPrices.length == 0) {
                    lowestPrices = neededMonth.filter(isMed);
                }
                if (lowestPrices.length == 0) {
                    lowestPrices = neededMonth.filter(isHigh);
                }
                //$reactions.answer('lowestPrices: ');
                //$reactions.answer(toPrettyString(lowestPrices));

                // НАХОДИМ САМЫЕ ДЕШЕВЫЕ В СПИСКЕ
                var lowestDate, neededIndex, lowestPrice = 1000000000;
                for (var i=0;i<lowestPrices.length;i++) {
                    if (lowestPrices[i].price < lowestPrice) {
                        lowestPrice = lowestPrices[i].price;
                        lowestDate = lowestPrices[i].date;
                        neededIndex = i;
                    }
                }
                lowestPrices.splice(neededIndex, 1);
                // составляем список остальных дешевых цен
                var isItRightPrice = function(value) {
                    if (value.price == lowestPrice) {
                        return value;
                    }
                }
                if (lowestPrices.length && lowestPrices.length > 0) {
                    lowestPrices = lowestPrices.filter(isItRightPrice);
                }
                if (lowestPrices.length && lowestPrices.length > 0) {
                    $session.otherCalendarOpt = lowestPrices;
                }
                $session.dates = lowestDate;
                $session.prices = lowestPrice;
                $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                $reactions.transition('/aviaSearchAns/calendarAviaResult');
            } else {
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }



    state: fromUntilCheapest
        script:
            var result = calendarSearchPost({from: $session.from, dest: $session.dest, passengers: $session.adults});
            if (result && result.data && result.data.prices) {
                var pricesArray = result.data.prices;
            } else {
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }
            if ($session.dates1) {
                var from = $session.dates1;
            }
            if ($session.dates2) {
                var until = $session.dates2;
            }
            if ($session.prices && ($parseTree._cheaper || $parseTree._cheapest)) {
                var price = true;
            }
            var isItRightDate = function (value) {
                if (price) {
                    if (from && until) {
                        if(value.date >= from && value.date <= until && value.price < $session.prices) {
                            return value;
                        }
                    } else if (from) {
                        if(value.date >= from && value.price < $session.prices) {
                            return value;
                        }
                    } else if (until) {
                        if (value.date <= until && value.price < $session.prices) {
                            return value;
                        }
                    }
                } else {
                    if (from && until) {
                        if(value.date >= from && value.date <= until) {
                            return value;
                        }
                    } else if (from) {
                        if(value.date >= from) {
                            return value;
                        }
                    } else if (until) {
                        if (value.date <= until) {
                            return value;
                        }
                    }
                }
            }
            var list = pricesArray.filter(isItRightDate);
            // НАХОДИМ САМЫЕ ДЕШЕВЫЕ В СПИСКЕ
            var lowestDate, neededIndex, lowestPrice = 1000000000;
            for (var i=0;i<list.length;i++) {
                if (list[i].price < lowestPrice) {
                    lowestPrice = list[i].price;
                    lowestDate = list[i].date;
                    neededIndex = i;
                }
            }
            var otherOptions = [];
            for (var j=0;j<list.length;j++) {
                if (list[j].price == list[neededIndex].price) {
                    otherOptions.push(list[j]);
                }
            }
            if (otherOptions && otherOptions.length > 1) {
                otherOptions.splice(0,1);
                $session.otherCalendarOpt = otherOptions;
            }
            if (!isArrayEmpty(list) && list[neededIndex] && list[neededIndex].date) {
                $session.dates = list[neededIndex].date;
                $session.prices = list[neededIndex].price;
                $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                $session.monthCheapest = true;
                $reactions.transition('/aviaSearchAns/calendarAviaResult');
            } else {
                $reactions.transition("/aviaSearchAns/noResFromUntilDates");
            }