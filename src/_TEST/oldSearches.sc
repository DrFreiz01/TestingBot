theme: oldSearches
    state: oldAviaSearch
        script:
            //проверяем, что даты не в прошлом
            if ($session.dates && (datesComparison($session.dates) == false)) {
                $reactions.transition("/aviaSearchAns/tooLate");
            } else {
                //проверяем, что топонимы не одинаковые
                if ($session.from != $session.dest) {
                    $session.urlPartners = urlPartners({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults});
                    var headers = {
                    };
                    var result = $http.query($session.urlPartners, {
                        method: "GET",
                        headers: headers,
                        query: $session,
                        dataType: "json",
                        timeout: 0 || 10000
                    });
                    $session.httpResponse = result.data;
                    $session.httpStatus = result.status;
                    $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                    //проверяем, что есть ответ
                    if (result.isOk && (!isArrayEmpty($session.httpResponse.data)) && result.status >= 200 && result.status < 300) {
                        $session.airportF = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].from.code;
                        $session.cityF = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].from.city;
                        $session.prices = $session.httpResponse.data[0].prices[0];
                        //ищем пункты прибытия в пересадках
                        var neededIndex = getLastElInArray($session.httpResponse.data[0].segments[0].flights[0].flightLegs);
                        $session.cityT = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[neededIndex].to.city;
                        $session.airportT = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[neededIndex].to.code;
                        $session.fromTime = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].fromTime;
                        $reactions.transition("/aviaSearchAns/aviaResults");
                    } else {
                        $reactions.transition("/aviaSearchAns/aviaSearchError");
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchError");
                }
            }



    state: oldAviaSearchRoundtrip
        script:
            //проверяем, что обе даты на месте
            if ($session.dates1 && $session.dates2) {
                //проверяем, что даты не в прошлом
                if ((datesComparison($session.dates1) == false) || (datesComparison($session.dates2) == false)) {
                $reactions.transition("/aviaSearchAns/tooLate");
                } else {
                    //проверяем, что топонимы не одинаковые
                    if ($session.from != $session.dest) {
                        $session.urlPartners = urlPartners({from: $session.from, dest: $session.dest, dates1: $session.dates1, dates2: $session.dates2, passengers: $session.adults});
                        var headers = {
                        };
                        var result = $http.query($session.urlPartners, {
                            method: "GET",
                            headers: headers,
                            query: $session,
                            dataType: "json",
                            timeout: 0 || 20000
                        });
                        $session.httpResponse = result.data;
                        $session.httpStatus = result.status;
                        $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, dates1: $session.dates1, dates2: $session.dates2, passengers: $session.adults}, $session.yandex);
                        //проверяем, что есть ответ
                        if (result.isOk && (!isArrayEmpty($session.httpResponse.data)) && result.status >= 200 && result.status < 300) {
                            $session.airportF = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].from.code;
                            $session.cityF = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].from.city;
                            $session.prices = $session.httpResponse.data[0].prices[0];
                            //ищем пункты прибытия в пересадках
                            var neededIndex = getLastElInArray($session.httpResponse.data[0].segments[0].flights[0].flightLegs);
                            $session.cityT = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[neededIndex].to.city;
                            $session.airportT = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[neededIndex].to.code;
                            $session.fromTime1 = $session.httpResponse.data[0].segments[0].flights[0].flightLegs[0].fromTime;
                            $session.fromTime2 = $session.httpResponse.data[0].segments[1].flights[0].flightLegs[0].fromTime;
                            $reactions.transition("/aviaSearchAns/aviaRoundtripResults");
                        } else {
                            $reactions.transition("/aviaSearchAns/aviaSearchError");
                        }
                    } else {
                        $reactions.transition("/aviaSearchAns/aviaSearchError");
                    }
                }
            } else {
                $reactions.transition("/aviaSearchAns/aviaSearchError");
            }



    state: oldAviaSearchDirect
        script:
            //проверяем, что даты не в прошлом
            if ($session.dates && (datesComparison($session.dates)) == false) {
                $reactions.transition("/aviaSearchAns/tooLate");
            } else {
                //проверяем, что топонимы не одинаковые
                if ($session.from != $session.dest) {
                    $session.urlPartners = urlPartners({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults});
                    var headers = {
                    };
                    var result = $http.query($session.urlPartners, {
                        method: "GET",
                        headers: headers,
                        query: $session,
                        dataType: "json",
                        timeout: 0 || 10000
                    });
                    $session.httpResponse = result.data;
                    $session.httpStatus = result.status;
                    $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                    //проверяем, что есть ответ и что есть прямой рейс
                    if (result.isOk && (!isArrayEmpty($session.httpResponse.data)) && (ifFlightIsDirect($session.httpResponse)) && result.status >= 200 && result.status < 300) {
                        var res = (ifFlightIsDirect($session.httpResponse));
                        $session.airportF = res[0].flightLegs[0].from.code;
                        $session.cityF = res[0].flightLegs[0].from.city;
                        $session.prices = $session.httpResponse.data[res[1]].prices[0];
                        //ищем пункты прибытия в пересадках
                        var neededIndex = getLastElInArray(res[0].flightLegs);
                        $session.cityT = res[0].flightLegs[neededIndex].to.city;
                        $session.airportT = res[0].flightLegs[neededIndex].to.code;
                        $session.fromTime = res[0].flightLegs[0].fromTime;
                        $reactions.transition("/aviaSearchAns/aviaDirectResults");
                    } else {
                        $reactions.transition("/aviaSearchAns/aviaSearchDirectError/");
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchDirectError/");
                }
            }


    state: urlPartners
        script:
            // формирование ссылки партнеров

            //## ССЫЛКИ ОЗОН ###
            // -->
            // https://www.ozon.travel/flight/search/vozist/d2018-12-27?ServiceClass=ECONOMY
            // <-->
            // https://www.ozon.travel/flight/search/vozististvoz/d2019-02-27d2019-02-28?ServiceClass=ECONOMY//
            //## ССЫЛКИ ПАРТНЕРЫ ###
            // -->
            // http://partners.ozon.travel/search_v1_0/flight/?Flight=mowNYC&Date1=2019-01-01&Dlts=1
            // <-->
            // http://partners.ozon.travel/search_v1_0/flight/?Flight=PTPKULPTP&Date1=2019-02-20&Date2=2019-02-22&Dlts=1
            function urlPartners (obj) {
                if (obj) {
                    if (obj.passengers) {
                        if (obj.date) {
                            return 'http://partners.ozon.travel/search_v1_0/flight/?Flight=' + obj.from + obj.dest + '&Date1=' + obj.date + '&Dlts=' + obj.passengers;
                        } else if (obj.dates1 && obj.dates2) {
                            return 'http://partners.ozon.travel/search_v1_0/flight/?Flight=' + obj.from + obj.dest + obj.from + '&Date1=' + obj.dates1 + '&Date2=' + obj.dates2 + '&Dlts=' + obj.passengers;
                        }
                    } else {
                        if (obj.date) {
                            return 'http://partners.ozon.travel/search_v1_0/flight/?Flight=' + obj.from + obj.dest + '&Date1=' + obj.date + '&Dlts=1';
                        }
                        if (obj.dates1 && obj.dates2) {
                            return 'http://partners.ozon.travel/search_v1_0/flight/?Flight=' + obj.from + obj.dest + obj.from + '&Date1=' + obj.dates1 + '&Date2=' + obj.dates2 + '&Dlts=1';
                        }
                    }
                }
            };