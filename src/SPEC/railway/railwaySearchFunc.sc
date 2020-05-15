theme: /railwaySearchFunc


    state: varsCleaning_DYN
        script:
            $session.adults = undefined;
            $session.category = undefined;
            $session.dates = undefined;
            $session.dates1 = undefined;
            $session.dates2 = undefined;
            $session.dates4User = undefined;
            $session.dates4User1 = undefined;
            $session.dates4User2 = undefined;
            $session.dest = undefined;
            $session.destTime = undefined;
            $session.destTime1 = undefined;
            $session.destTime2 = undefined;
            $session.direct = undefined;
            $session.from = undefined;
            $session.fromTime4User = undefined;
            $session.fromTime4User1 = undefined;
            $session.fromTime4User2 = undefined;
            $session.railwayPrice = undefined;
            $session.railwayPrice1 = undefined;
            $session.railwayPrice2 = undefined;
            $session.stationF = undefined;
            $session.stationF1 = undefined;
            $session.stationF2 = undefined;
            $session.stationT = undefined;
            $session.stationT1 = undefined;
            $session.stationT2 = undefined;
            $session.urlRailway = undefined;
            $session.urlRailway1 = undefined;
            $session.urlRailway2 = undefined;
        go!: {{$client.executeState0}}



    state: parsing4RailwaySearch_DYN
        script:
            if ($parseTree._fromCode) {
               $session.from = $parseTree._fromCode.statCode;
            }
            if ($parseTree._destCode) {
                $session.dest = $parseTree._destCode.statCode;
            }
            if ($parseTree._dateDig) {
                $session.dates = catchDate($parseTree._dateDig);
            }
            if ($parseTree._dateLetters) {
                $session.dates = dateLetters($parseTree.dateLetters[0].text,$parseTree._months);
            }
            if ($parseTree._doubleDate) {
                if (catchDate($parseTree._doubleDate)[1]) {
                    $session.dates1 = catchDate($parseTree._doubleDate)[0];
                    $session.dates2 = catchDate($parseTree._doubleDate)[1];
                } else {
                    $session.dates = catchDate($parseTree._doubleDate)[0];
                }
            }
            if ($parseTree._today) {
                $session.dates = $jsapi.dateForZone("Europe/Moscow","YYYY-MM-dd");
            }
            if ($parseTree._tomorrow) {
                $session.dates = operatingOnToday(1);
            }
            if ($parseTree._tomorrowDayAfter) {
                $session.dates = operatingOnToday(2);
            }
            if ($parseTree._dateDig1) {
                $session.dates1 = catchDate($parseTree._dateDig1);
            }
            if ($parseTree._dateDig2) {
                $session.dates2 = catchDate($parseTree._dateDig2);
            }
            if ($parseTree._dateLetters1) {
                $session.dates1 = dateLetters($parseTree.dateLetters1[0].text,$parseTree._months);
            }
            if ($parseTree._dateLetters2) {
                $session.dates2 = dateLetters($parseTree.dateLetters2[0].text,$parseTree._months);
            }
            if ($parseTree._forAdults) {
                if ($parseTree._NumberDigWithLett) {
                    $session.adults = $parseTree._NumberDigWithLett;
                } else if ($parseTree._NumberDig) {
                    $session.adults = $parseTree._NumberDig;
                } else if ($parseTree._NumberLett) {
                    $session.adults = $parseTree._NumberLett;
                } else if ($parseTree._NumberOfPeople) {
                    $session.adults = $parseTree._NumberOfPeople;
                }
                if ($session.adults > 4) {
                    $reactions.transition('/railwaySearchAns/limitedTicketsAns');
                }
            }
            if ($parseTree.numberDate) {
                var numb = $parseTree.numberDate[0].text;
                if ($session.dates1 && !$session.dates2) {
                    var dates1 = $session.dates1.split('-');
                    dates1[2] = addZero(numb);
                    $session.dates2 = dates1.join('-');
                }
                if ($session.dates2 && !$session.dates1) {
                    var dates2 = $session.dates2.split('-');
                    dates2[2] = addZero(numb);
                    $session.dates1 = dates2.join('-');
                }
                if (!$session.dates1 && !$session.dates2) {
                    $session.dates = operatingOnNumberDate(numb);
                }
            }
        go!: {{$client.executeState}}



    state: railwaySearch
        script:
            $session.search = undefined;
            // ДАТА1 ИЛИ ДАТА2
            if ($session.dates1 && $session.dates2 && !$session.dates) {
                // проверяем, что данных хватает
                if ($session.from && $session.dest && $session.from != $session.dest) {
                    // проверяем, что даты не в прошлом
                    if (datesComparison($session.dates1) == false && datesComparison($session.dates2) == false) {
                        $reactions.transition("/railwaySearchAns/tooLate");
                    }
                    // 1 запрос
                    if ((datesComparison($session.dates1) == true)) {
                        var result1 = railwaySearchPost({from: $session.from, dest: $session.dest, date: $session.dates1, passengers: $session.adults});
                        if (result1.data && result1.data.trips[0]) {
                            var httpResponse1 = result1.data.trips[0].tripOffers;
                        }
                        if (result1.isOk && (!isArrayEmpty(httpResponse1)) && result1.status >= 200 && result1.status < 300) {
                            var tripOfferNumb1 = getRailwayCategory(httpResponse1)[0];
                            var tariffNumb1 = getRailwayCategory(httpResponse1)[1];
                            var railwayPrice1 = httpResponse1[tripOfferNumb1].tariffs[tariffNumb1].minPrice;
                        }
                    }
                    // 2 запрос
                    if (datesComparison($session.dates2) == true) {
                        var result2 = railwaySearchPost({from: $session.from, dest: $session.dest, date: $session.dates2, passengers: $session.adults});
                        if (result2.data && result2.data.trips[0]) {
                            var httpResponse2 = result2.data.trips[0].tripOffers;
                        }
                        if (result2.isOk && (!isArrayEmpty(httpResponse2)) && result2.status >= 200 && result2.status < 300) {
                            var tripOfferNumb2 = getRailwayCategory(httpResponse2)[0];
                            var tariffNumb2 = getRailwayCategory(httpResponse2)[1];
                            var railwayPrice2 = httpResponse2[tripOfferNumb2].tariffs[tariffNumb2].minPrice;
                        }
                    }
                    // сравнение цен
                    if (railwayPrice1 == railwayPrice2 || railwayPrice1 < railwayPrice2) {
                        var neededResult = httpResponse1;
                        $session.railwayPrice = railwayPrice1;
                        $session.dates = $session.dates1;
                        var tripOfferNumb = tripOfferNumb1;
                        var tariffNumb = tariffNumb1;
                    } else {
                        var neededResult = httpResponse2;
                        $session.railwayPrice = railwayPrice2;
                        $session.dates = $session.dates2;
                        $session.dates4User = dates4User2;
                        var tripOfferNumb = tripOfferNumb2;
                        var tariffNumb = tariffNumb2;
                    }
                    if (isArrayEmpty(httpResponse1) && isArrayEmpty(httpResponse2)) {
                        $reactions.transition("/railwaySearchAns/searchNoTickets");
                    } else {
                        var dateTime = neededResult[tripOfferNumb].segments[0].departureTime.time.split('T');
                        var fromDate = dateTime[0];
                        var dates4User1 = getDate4User(fromDate);
                        $session.stationF = neededResult[tripOfferNumb].segments[0].departureStation.name;
                        $session.stationT = neededResult[tripOfferNumb].segments[0].arrivalStation.name;
                        var category = neededResult[tripOfferNumb].tariffs[tariffNumb].category;
                        $session.category = getCategory4User(category);
                        var dateTime = neededResult[tripOfferNumb].segments[0].departureTime.time.split('T');
                        var fromDate = dateTime[0];
                        $session.dates4User = getDate4User(fromDate);
                        // формируем ссылку на OZON
                        $session.urlRailway = urlOzonRailway({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults});

                        // переходим к ответу
                        if ($session.railwayPrice == -1) {
                            $reactions.transition("/railwaySearchAns/railwayResultsNoPrice");
                        } else {
                            $reactions.transition("/railwaySearchAns/railwayResults");
                        }
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchError");
                }
            } else {
                // 1 ДАТА

                // DEBUG
                //$reactions.answer('from: ' + $session.from + ', dest: ' + $session.dest + ', dates: ' + $session.dates + ', passengers: ' + $session.adults + ', direct: ' + $session.direct);

                //проверяем, что топонимы на месте и не одинаковые
                if ($session.from && $session.dest && $session.dates && ($session.from != $session.dest)) {
                    //проверяем, что даты не в прошлом
                    if (datesComparison($session.dates) == false) {
                        $reactions.transition('/railwaySearchAns/tooLate')
                    } else {
                        var result = railwaySearchPost({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults});
                        if (result.data && result.data.trips[0]) {
                            var tripOffersArray = result.data.trips[0].tripOffers;
                        } else {
                            $reactions.transition("/railwaySearchAns/searchError");
                        }
                        // проверяем, что есть ответ
                        if (result.isOk && (!isArrayEmpty(tripOffersArray)) && result.status >= 200 && result.status < 300) {
                            var tripOfferNumb = getRailwayCategory(tripOffersArray)[0];
                            var tariffNumb = getRailwayCategory(tripOffersArray)[1];
                            var dateTime = tripOffersArray[tripOfferNumb].segments[0].departureTime.time.split('T');
                            var fromDate = dateTime[0];
                            var fromTime = dateTime[1];
                            $session.dates4User = getDate4User(fromDate);
                            $session.fromTime4User = getTime4User(fromTime);
                            $session.stationF = tripOffersArray[tripOfferNumb].segments[0].departureStation.name;
                            $session.stationT = tripOffersArray[tripOfferNumb].segments[0].arrivalStation.name;
                            var category = tripOffersArray[tripOfferNumb].tariffs[tariffNumb].category;
                            $session.category = getCategory4User(category);
                            $session.railwayPrice = tripOffersArray[tripOfferNumb].tariffs[tariffNumb].minPrice;
                            //формируем ссылку на OZON
                            $session.urlRailway = urlOzonRailway({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults});

                            //переходим к ответу
                            if ($session.railwayPrice == -1) {
                                $reactions.transition("/railwaySearchAns/railwayResultsNoPrice");
                            } else {
                                $reactions.transition("/railwaySearchAns/railwayResults");
                            }

                        } else {
                            if (result.status === 409) {
                                var newText = result.error;
                                if (newText.indexOf('returned from handler: ') != -1) {
                                    var r = /[{}"']/;
                                    newText = newText.replace('{"error":"returned from handler: ', '');
                                    newText = newText.replace('"}', '');
                                }
                                //$reactions.answer(newText);
                                //{"error":"returned from handler: Указана некорректная дата: должна быть от 0 до 120 суток от текущего момента"}
                                //{"error":"returned from handler: В указанное время поездов нет. Измените условия."}
                                $reactions.transition("/railwaySearchAns/searchNoTickets");
                            } else {
                                $reactions.transition("/railwaySearchAns/searchError");
                            }
                        }
                    }
                } else {
                    $reactions.transition("/railwaySearchAns/searchError");
                }
            }



    state: railwaySearchRoundtrip
        script:
            $session.search = undefined;
            //проверяем, что обе даты на месте и топонимы не одинаковые
            if ($session.dates1 && $session.dates2 && ($session.from != $session.dest)) {
                //проверяем, что даты не в прошлом
                if ((datesComparison($session.dates1) == false) || (datesComparison($session.dates2) == false)) {
                    $reactions.transition("/railwaySearchAns/tooLate");
                } else {
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;

                    //ПОСЫЛАЕМ 1 ЗАПРОС
                    var result1 = railwaySearchPost({from: $session.from, dest: $session.dest, date: $session.dates1, passengers: $session.adults});
                    if (result1.data && result1.data.trips[0]) {
                        var tripOffersArray1 = result1.data.trips[0].tripOffers;
                    } else {
                        $reactions.transition("/railwaySearchAns/searchError");
                    }
                    //проверяем, что есть ответ
                    if (result1.isOk && (!isArrayEmpty(tripOffersArray1)) && result1.status >= 200 && result1.status < 300) {
                        var dateTime = tripOffersArray1[0].segments[0].departureTime.time.split('T');
                        var fromDate = dateTime[0];
                        var fromTime = dateTime[1];
                        $session.dates4User1 = getDate4User(fromDate);
                        $session.fromTime4User1 = getTime4User(fromTime);
                        $session.stationF1 = tripOffersArray1[0].segments[0].departureStation.name;
                        $session.stationT1 = tripOffersArray1[0].segments[0].arrivalStation.name;
                        $session.destTime1 = tripOffersArray1[0].segments[0].arrivalTime.time;
                        //ищем цены
                        var arrPrices1 = [];
                        for (var i = 0; i < tripOffersArray1.length; i++) {
                            var everyTrip = tripOffersArray1[i];
                            for (var k = 0; k < everyTrip.tariffs.length; k++) {
                                var everyTariff = everyTrip.tariffs[k];
                                for (var tariff in everyTariff) {
                                    if (tariff === 'minPrice') {
                                        arrPrices1.push(everyTariff[tariff]);
                                    }
                                }
                            }
                        }
                        //формируем ссылку на OZON
                        $session.urlRailway1 = urlOzonRailway({from: $session.from, dest: $session.dest, date: $session.dates1, passengers: $session.adults});
                    } else {
                        $reactions.transition("/railwaySearchAns/searchError");
                    }
                    //ПОСЫЛАЕМ 2 ЗАПРОС
                    var result2 = railwaySearchPost({from: $session.dest, dest: $session.from, date: $session.dates2, passengers: $session.adults});
                    if (result2.data && result2.data.trips[0]) {
                        var tripOffersArray2 = result2.data.trips[0].tripOffers;
                    } else {
                        $reactions.transition("/railwaySearchAns/searchError");
                    }

                    //проверяем, что есть ответ
                    if (result2.isOk && (!isArrayEmpty(tripOffersArray2)) && result2.status >= 200 && result2.status < 300) {
                        var dateTime = tripOffersArray2[0].segments[0].departureTime.time.split('T');
                        var fromDate = dateTime[0];
                        var fromTime = dateTime[1];
                        $session.dates4User2 = getDate4User(fromDate);
                        $session.fromTime4User2 = getTime4User(fromTime);
                        $session.stationF2 = tripOffersArray2[0].segments[0].departureStation.name;
                        $session.stationT2 = tripOffersArray2[0].segments[0].arrivalStation.name;
                        $session.destTime2 = tripOffersArray2[0].segments[0].arrivalTime.time;

                        //ищем цены
                        var arrPrices2 = [];
                        for (var i = 0; i < tripOffersArray2.length; i++) {
                            var everyTrip = tripOffersArray2[i];
                            for (var k = 0; k < everyTrip.tariffs.length; k++) {
                                var everyTariff = everyTrip.tariffs[k];
                                for (var tariff in everyTariff) {
                                    if (tariff === 'minPrice') {
                                        arrPrices2.push(everyTariff[tariff]);
                                    }
                                }
                            }
                        }
                        //ищем мин цены
                        if (arrPrices1 && arrPrices2) {
                            $session.railwayPrice1 = getMinValue(arrPrices1);
                            $session.railwayPrice2 = getMinValue(arrPrices2);
                            $session.railwayPrice = $session.railwayPrice1 + $session.railwayPrice2;
                        } else {
                             $reactions.transition("/railwaySearchAns/searchError");
                        }

                        //формируем 2 ссылку на OZON
                        $session.urlRailway2 = urlOzonRailway({from: $session.dest, dest: $session.from, date: $session.dates2, passengers: $session.adults});
                        //переходим к ответу
                        if ($session.railwayPrice1 == -1 || $session.railwayPrice2 == -1) {
                            $reactions.transition("/railwaySearchAns/railwayRoundtripResultsNoPrice");
                        } else {
                            $reactions.transition("/railwaySearchAns/railwayRoundtripResults");
                        }
                    } else {
                        $reactions.transition("/railwaySearchAns/searchError");
                    }
                }
            } else {
                $reactions.transition("/railwaySearchAns/searchError");
            }