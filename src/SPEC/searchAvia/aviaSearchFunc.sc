theme: /aviaSearchFunc


    state: aviaSearch
        script:
            // ДАТА1 ИЛИ ДАТА2
            if ($session.dates1 && $session.dates2 && !$session.dates && $session.begin == undefined) {
                // проверяем, что данных хватает
                if ($session.from && $session.dest && $session.from != $session.dest) {
                    $session.begin = true;

                    // проверяем, что даты не в прошлом
                    if (datesComparison($session.dates1) == false && datesComparison($session.dates2) == false) {
                        $reactions.transition("/aviaSearchAns/tooLate");
                    }
                    // 1 запрос
                    if ((datesComparison($session.dates1) == true)) {
                        var result0 = aviaSearchPost({from: $session.from, dest: $session.dest, date: $session.dates1, passengers: $session.adults}, $session.direct);
                        if (result0.isOk && (!isArrayEmpty(result0.data.tariffs)) && result0.status >= 200 && result0.status < 300) {
                            $session.prices0 = result0.data.tariffs[0].price.rub;
                        }
                    }
                    // 2 запрос
                    if (datesComparison($session.dates2) == true) {
                        var result1 = aviaSearchPost({from: $session.from, dest: $session.dest, date: $session.dates2, passengers: $session.adults}, $session.direct);
                        if (result1.isOk && (!isArrayEmpty(result1.data.tariffs)) && result1.status >= 200 && result1.status < 300) {
                            $session.prices1 = result1.data.tariffs[0].price.rub;
                        }
                    }
                    // сравнение цен
                    if ($session.prices0 == $session.prices1 || $session.prices0 < $session.prices1) {
                        $session.prices = $session.prices0;
                        var neededResult = result0.data;
                        $session.dates = $session.dates1;
                    } else {
                        $session.prices = $session.prices1;
                        var neededResult = result1.data;
                        $session.dates = $session.dates2;
                    }
                    // ищем пункты прибытия в пересадках
                    var neededIndex = getLastElInArray(neededResult.tariffs[0].flights[0].variants[0].segments);
                    $session.airportF = neededResult.tariffs[0].flights[0].variants[0].segments[0].departureAirportCode;
                    $session.fromTime = neededResult.tariffs[0].flights[0].variants[0].segments[0].departureTime.time;
                    $session.airportT = neededResult.tariffs[0].flights[0].variants[0].segments[neededIndex].arrivalAirportCode;
                    $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults, direct: $session.direct, baggage: $session.baggage}, $session.yandex);
                    //ответ
                    if ($session.direct == true) {
                        $reactions.transition("/aviaSearchAns/aviaDirectResults");
                    } else {
                        $reactions.transition("/aviaSearchAns/aviaResults");
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchError");
                }
            } else {
            // ОДНА ДАТА
                // DEBUG
                //$reactions.answer('from: ' + $session.from + ', dest: ' + $session.dest + ', dates: ' + $session.dates + ', passengers: ' + $session.adults + ', direct: ' + $session.direct);
                // проверяем, что дата не в прошлом
                if ($session.dates && (datesComparison($session.dates) == false)) {
                    $reactions.transition("/aviaSearchAns/tooLate");
                } else {
                    // проверяем, что данных хватает
                    if ($session.dates && $session.from && $session.dest && $session.from != $session.dest) {
                        // DEBUG
                        // $reactions.answer('from: ' + $session.from + ', dest: ' + $session.dest + ', date: ' + $session.dates + ', passengers: ' + $session.adults + ', direct: ' + $session.direct);
                        var result = aviaSearchPost({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.direct);
                        $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults, direct: $session.direct, baggage: $session.baggage}, $session.yandex);
                    } else {
                        $reactions.transition("/aviaSearchAns/aviaSearchError");
                    }
                    // проверяем, что есть ответ
                    if (result.isOk && (!isArrayEmpty(result.data.tariffs)) && result.status >= 200 && result.status < 300) {

                        var filterRes, tariffIndex, flightIndex, variantIndex;
                        // БАГАЖ и УТРО/ВЕЧЕР
                        if ($session.baggage && $session.dayTime) {
                            filterRes = dayTimeBaggFilter(result.data);
                            tariffIndex = filterRes.tariffIndex;
                            flightIndex = filterRes.flightIndex;
                            variantIndex = filterRes.variantIndex;
                            if (tariffIndex == undefined || flightIndex == undefined || variantIndex == undefined) {
                                $reactions.transition("/aviaSearchAns/aviaSearchDayTimeBaggError");
                            }
                        }
                        // БАГАЖ
                        else if ($session.baggage) {
                            tariffIndex = baggageFilter(result.data);
                            flightIndex = 0;
                            variantIndex = 0;
                            if (tariffIndex == undefined) {
                                $reactions.transition("/aviaSearchAns/aviaSearchBaggError");
                            }
                        }
                        // УТРО ВЕЧЕР
                        else if ($session.dayTime) {
                            filterRes = dayTimeFilter(result.data);
                            tariffIndex = filterRes.tariffIndex;
                            flightIndex = filterRes.flightIndex;
                            variantIndex = filterRes.variantIndex;
                            if (tariffIndex == undefined || flightIndex == undefined || variantIndex == undefined) {
                                $reactions.transition("/aviaSearchAns/aviaSearchDayTimeError");
                            }

                        } else {
                            tariffIndex = 0;
                            flightIndex = 0;
                            variantIndex = 0;
                        }

                        if (result.data.tariffs && result.data.tariffs[tariffIndex] && result.data.tariffs[tariffIndex].flights && result.data.tariffs[tariffIndex].flights[flightIndex] && result.data.tariffs[tariffIndex].flights[flightIndex].variants && result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex]) {
                            // записываем результат
                            var segmentIndex = getLastElInArray(result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments);
                            $session.prices = result.data.tariffs[tariffIndex].price.rub;
                            $session.airportF = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[0].departureAirportCode;
                            $session.fromTime = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[0].departureTime.time;
                            $session.airportT = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[segmentIndex].arrivalAirportCode;
                            // ответ
                            if ($session.direct == true) {
                                $reactions.transition("/aviaSearchAns/aviaDirectResults");
                            } else {
                                $reactions.transition("/aviaSearchAns/aviaResults");
                            }
                        } else {
                            if ($session.direct == true) {
                                $reactions.transition("/aviaSearchAns/aviaSearchDirectError");
                            } else if ($session.dayTime && $session.baggage) {
                                $reactions.transition("/aviaSearchAns/aviaSearchDayTimeBaggError");
                            } else if ($session.dayTime) {
                                $reactions.transition("/aviaSearchAns/aviaSearchDayTimeError");
                            } else if ($session.baggage) {
                                $reactions.transition("/aviaSearchAns/aviaSearchBaggError");
                            } else {
                                $reactions.transition("/aviaSearchAns/aviaSearchError");
                            }
                        }
                    } else {
                        if ($session.direct == true) {
                            $reactions.transition("/aviaSearchAns/aviaSearchDirectError");
                        } else {
                            $reactions.transition("/aviaSearchAns/aviaSearchError");
                        }
                    }
                }
            }



    state: aviaSearchRoundtrip
        script:
            // DEBUG
            //$reactions.answer('from: ' + $session.from + ', dest: ' + $session.dest + ', dates1: ' + $session.dates1 + ', dates2: ' + $session.dates2 + ', passengers: ' + $session.adults + ', direct: ' + $session.direct, 'baggage: ' + $session.baggage);
            // проверяем, что обе даты на месте
            if ($session.dates1 && $session.dates2) {
                //проверяем, что даты не в прошлом
                if ((datesComparison($session.dates1) == false) || (datesComparison($session.dates2) == false)) {
                $reactions.transition("/aviaSearchAns/tooLate");
                } else {
                    // проверяем, что топонимы не одинаковые
                    if ($session.from != $session.dest) {
                        var result = aviaSearchPost({from: $session.from, dest: $session.dest, dates1: $session.dates1, dates2: $session.dates2, passengers: $session.adults}, $session.direct);
                        $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, dates1: $session.dates1, dates2: $session.dates2, passengers: $session.adults, direct: $session.direct, baggage: $session.baggage}, $session.yandex);
                        // проверяем, что есть ответ
                        if (result.isOk && (!isArrayEmpty(result.data.tariffs)) && result.status >= 200 && result.status < 300) {

                            // БАГАЖ
                            var filterRes, tariffIndex, flightIndex, variantIndex;
                            if ($session.baggage) {
                                tariffIndex = baggageFilter(result.data);
                                flightIndex = 0;
                                variantIndex = 0;
                                if (tariffIndex == undefined) {
                                    //$reactions.answer('tariffIndex = undefined');
                                    $reactions.transition("/aviaSearchAns/aviaSearchBaggError");
                                }
                            } else {
                                tariffIndex = 0;
                                flightIndex = 0;
                                variantIndex = 0;
                            }

                            if (result.data.tariffs && result.data.tariffs[tariffIndex] && result.data.tariffs[tariffIndex].flights && result.data.tariffs[tariffIndex].flights[flightIndex] && result.data.tariffs[tariffIndex].flights[flightIndex].variants && result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex]) {

                                // ищем пункты прибытия в пересадках
                                var segmentIndex = getLastElInArray(result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments);
                                $session.prices = result.data.tariffs[tariffIndex].price.rub;
                                $session.airportF = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[0].departureAirportCode;
                                $session.fromTime1 = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[0].departureTime.time;
                                $session.fromTime2 = result.data.tariffs[tariffIndex].flights[1].variants[variantIndex].segments[0].departureTime.time;
                                $session.airportT = result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex].segments[segmentIndex].arrivalAirportCode;

                                // ответ
                                if ($session.direct == true) {
                                    $reactions.transition("/aviaSearchAns/aviaDirectRoundtripResults");
                                } else {
                                    $reactions.transition("/aviaSearchAns/aviaRoundtripResults");
                                }

                            } else {
                                //$reactions.answer('не result.data.tariffs && result.data.tariffs[tariffIndex] && result.data.tariffs[tariffIndex].flights && result.data.tariffs[tariffIndex].flights[flightIndex] && result.data.tariffs[tariffIndex].flights[flightIndex].variants && result.data.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex]');
                                $reactions.transition("/aviaSearchAns/aviaSearchError");
                            }

                        } else {
                            //$reactions.answer('не result.isOk && (!isArrayEmpty(result.data.tariffs)) && result.status >= 200 && result.status < 300');
                            $reactions.transition("/aviaSearchAns/aviaSearchError");
                        }
                    } else {
                        //$reactions.answer('$session.from = $session.dest');
                        $reactions.transition("/aviaSearchAns/aviaSearchError");
                    }
                }
            } else {
                //$reactions.answer('не $session.dates1 && $session.dates2');
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }



    state: parsing4AviaSearch_DYN
        script:
            if ($parseTree._months) {
                $session.month = $parseTree._months;
            }
            if ($parseTree._fromCode) {
               $session.from = $parseTree._fromCode.airport;
               $session.cityF = $parseTree._fromCode.name;
            }
            if ($parseTree._destCode) {
                $session.dest = $parseTree._destCode.airport;
                $session.cityT = $parseTree._destCode.name;
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
                if ($parseTree.dateLetters1[0].value) {
                    $session.dates1 = dateLetters($parseTree.dateLetters1[0].text, $parseTree.dateLetters1[0].value);
                } else {
                    $session.dates1 = dateLetters($parseTree.dateLetters1[0].text, $parseTree._months);
                }
            }
            if ($parseTree._dateLetters2) {
                if ($parseTree.dateLetters2[0].value) {
                    $session.dates2 = dateLetters($parseTree.dateLetters2[0].text, $parseTree.dateLetters2[0].value);
                } else {
                    $session.dates2 = dateLetters($parseTree.dateLetters2[0].text, $parseTree._months);
                }
            }
            if ($parseTree._beginning) {
                $session.begOfMonth = true;
            }
            if ($parseTree._end) {
                $session.endOfMonth = true;
            }
            if ($parseTree._evening) {
                $session.dayTime = 'вечер';
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
                if (parseInt($session.adults) > 9) {
                    $reactions.transition("/faq/buyMoreThenXTickets");
                }
            }
            if ($parseTree._morning) {
                $session.dayTime = 'утро';
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
            if ($parseTree._withBaggage) {
                $session.baggage = true;
            }
            if ($parseTree._direct || $parseTree._directFlight) {
                $session.direct = true;
            }


        go!: {{$client.executeState}}



    state: varsCleaning_DYN
        script:
            $session.adults = undefined;
            $session.airportF = undefined;
            $session.airportT = undefined;
            $session.baggage = undefined;
            $session.begin = undefined;
            $session.begOfMonth = undefined;
            $session.calendarList = undefined;
            $session.cityF = undefined;
            $session.cityT = undefined;
            $session.dates = undefined;
            $session.dates1 = undefined;
            $session.dates2 = undefined;
            $session.dayTime = undefined;
            $session.dest = undefined;
            $session.direct = undefined;
            $session.endOfMonth = undefined;
            $session.from = undefined;
            $session.fromTime1 = undefined;
            $session.fromTime2 = undefined;
            $session.month = undefined;
            $session.monthCheapest = undefined;
            $session.otherCalendarOpt = undefined;
            $session.prices = undefined;
            $session.score = undefined;
            $session.urlOzon = undefined;
            $session.yandex = undefined;

        go!: {{$client.executeState0}}
