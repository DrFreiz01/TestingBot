patterns:
    $morphNoun = $morph<С>
    $morphAdjNoun = ($morph<П> $morph<С> /$morph<С> $morph<П>)
    $morphVerbPast = $morph<Г прш>


theme: /test



    state: testRegex
        q!: testRegex ($depCode/$arrCode)
        a: {{toPrettyString($parseTree)}}



    state: getClientUrl
        q!: getClientUrl * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $depCode * $arrCode *
        q!: getClientUrl * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $depCode * $arrCode *
        q!: getClientUrl * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $depCode * $arrCode *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /aviaSearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                    // DEBUG
                    $reactions.answer(toPrettyString($parseTree));
                    /*
                    $reactions.answer('ДО: from: ' + $session.from + ', dest: ' + $session.dest + ', dates: ' + $session.dates + ', passengers: ' + $session.adults + ', direct: ' + $session.direct);
                    // проверяем, что дата не в прошлом
                    if ($session.dates && (datesComparison($session.dates) == false)) {
                        $reactions.answer("https://www.ozon.travel/");
                    } else {
                        // проверяем, что данных хватает
                        if (!$session.dates || !$session.from) {
                            if (!$session.from && $parseTree._depCode.match(/dep_code=[A-Z]{3}/)) {
                                $session.from = $parseTree._depCode.replace(/dep_code=([A-Z]{3})/, "$1");
                            }
                            if (!$session.dest && $parseTree._arrCode.match(/arr_code=[A-Z]{3}/)) {
                                $session.dest = $parseTree._arrCode.replace(/arr_code=([A-Z]{3})/, "$1");
                            }
                        }
                        if ($session.dates && $session.from && $session.dest && $session.from != $session.dest) {
                            var result = aviaSearchPost({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.direct);
                            $session.httpResponse = result.data;
                            $session.httpStatus = result.status;
                            $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults, direct: $session.direct, baggage: $session.baggage}, $session.yandex);
                        } else {
                            $reactions.answer("https://www.ozon.travel/");
                        }
                        // DEBUG
                        $reactions.answer('ПОСЛЕ: from: ' + $session.from + ', dest: ' + $session.dest + ', dates: ' + $session.dates + ', passengers: ' + $session.adults + ', direct: ' + $session.direct);
                        // проверяем, что есть ответ
                        if (result.isOk && (!isArrayEmpty($session.httpResponse.tariffs)) && result.status >= 200 && result.status < 300) {

                            var filterRes, tariffIndex, flightIndex, variantIndex;
                            // БАГАЖ и УТРО/ВЕЧЕР
                            if ($session.baggage && $session.dayTime) {
                                filterRes = dayTimeBaggFilter($session.httpResponse);
                                tariffIndex = filterRes.tariffIndex;
                                flightIndex = filterRes.flightIndex;
                                variantIndex = filterRes.variantIndex;
                                if (tariffIndex == undefined || flightIndex == undefined || variantIndex == undefined) {
                                    $reactions.answer("https://www.ozon.travel/");
                                }
                            }
                            // БАГАЖ
                            else if ($session.baggage) {
                                tariffIndex = baggageFilter($session.httpResponse);
                                flightIndex = 0;
                                variantIndex = 0;
                                if (tariffIndex == undefined) {
                                    $reactions.answer("https://www.ozon.travel/");
                                }
                            }
                            // УТРО ВЕЧЕР
                            else if ($session.dayTime) {
                                filterRes = dayTimeFilter($session.httpResponse);
                                tariffIndex = filterRes.tariffIndex;
                                flightIndex = filterRes.flightIndex;
                                variantIndex = filterRes.variantIndex;
                                if (tariffIndex == undefined || flightIndex == undefined || variantIndex == undefined) {
                                    $reactions.answer("https://www.ozon.travel/");
                                }

                            } else {
                                tariffIndex = 0;
                                flightIndex = 0;
                                variantIndex = 0;
                            }

                            if ($session.httpResponse.tariffs && $session.httpResponse.tariffs[tariffIndex] && $session.httpResponse.tariffs[tariffIndex].flights && $session.httpResponse.tariffs[tariffIndex].flights[flightIndex] && $session.httpResponse.tariffs[tariffIndex].flights[flightIndex].variants && $session.httpResponse.tariffs[tariffIndex].flights[flightIndex].variants[variantIndex]) {
                                // ОТВЕТ
                                if ($session.direct == true) {
                                    $reactions.transition("/aviaSearchAns/aviaDirectResults");
                                } else {
                                    $reactions.answer($session.urlOzon);
                                }
                            } else {
                                $reactions.answer("https://www.ozon.travel/");
                            }
                        } else {
                            $reactions.answer("https://www.ozon.travel/");
                        }
                    }
                    */



    state: call_external_callback
        event!: call_external_callback
        script:
            var call_external_callback = $request;
            if (call_external_callback && call_external_callback.data && call_external_callback.data.eventData) {
                $session.call_external_callback = call_external_callback.data.eventData;
            }



    state: testCallbackFunc
        q!: testCallbackFunc
        script:
            if ($session.call_external_callback) {
                $response.actions = [{
                   type:"call_external_callback",
                   callbackName:"testHandler",
                   args: [{argName1: "это успех"}]
                }];
            } else {
                $reactions.answer('у нас нет $session.call_external_callback');
            }



    state: testApiQuery
        q!: testApiQuery
        script:
            var headers = {
            };
            var result = $http.query("http://algvil.ru/test_json1.php", {
                method: "GET",
                headers: headers,
                query: $session,
                dataType: "json",
                timeout: 0 || 10000
            });
            $temp.httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $temp.httpResponse;
            if (result && result.status >= 200 && result.status < 300) {
                $reactions.answer($temp.httpResponse);
            } else {
                $reactions.answer("Oops");
                toPrettyString($parseTree);
            }


    state: testApiQueryWithVar
        q!: testApiQuery $testApi
        script:
            var part = $parseTree._testApi;
            var url = 'http://algvil.ru/test_' + part + '.php';
            var
            headers = {
            };
            var result = $http.query(url, {
                method: "c",
                headers: headers,
                query: $session,
                dataType: "json",
                timeout: 0 || 10000
            });
            $temp.httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $temp.httpResponse;
            if (result && result.status >= 200 && result.status < 300) {
                $reactions.answer($temp.httpResponse);
            } else {
                $reactions.answer("Oops");
                $reactions.answer(toPrettyString($parseTree));
            }



    state: testLibNames
        q!: testLibNames $namesRus
        a: {{toPrettyString($parseTree.namesRus)}}
        a: Это твое имя - {{$parseTree._namesRus.name}}?



    state: TestInflect
        q!: testinflect $cityCode
        script:
            $temp.с = $nlp.parseMorph($parseTree._cityCode.name);
            log("parseMorph:" + toPrettyString($nlp.parseMorph($parseTree._cityCode.name)));
            log("inflect:" + toPrettyString($nlp.inflect($temp.с.normalForm, "loct")));
        a: В {{ $nlp.inflect($temp.с.normalForm, "loct") }} неплохо кормят!



    state: TestInflectVerb
        q!: TestInflectVerb $morphVerbPast
        a: срочно к оператору!





    state: buttons
        q!: buttons magic test
        a: do you believe in magic?
        buttons:
            "кнопка1"
        buttons:
            "кнопка2"


    state: answersMultiple
        q!: answersMultiple test
        a: первый ответ
        a: второй ответ
        a: первый ответ (шутка)



    state: nightTimeTest
        q!: nightTimeTest
        script:
            $temp.time = parseInt($jsapi.dateForZone("Europe/Moscow","HH")) + 10;
        if: ($temp.time >= 20 && $temp.time <= 23) || ($temp.time >= 0 && $temp.time < 8)
            a: Сейчас в чате нет опереаторов. Они отвечают на вопросы с 8:00 до 20:00 по московскому времени. \nЕсли вы уже в аэропорту или на вокзале и нет врмени ждать, звоните : +7 495 787-28-88
        else:
            a: {{$temp.time}}
            a: не попали =(


    state: testwiki
        q!: test что такое ($morphNoun/$morphAdjNoun)
        if: $parseTree.morphNoun
            script:
                $temp.wiki = "https://ru.wikipedia.org/wiki/";
                $temp.google = "https://www.google.ru/search?newwindow=1&q=";
                $temp.word = $parseTree.morphNoun[0].words;
                $temp.wlink = $temp.wiki + $temp.word;
                $temp.glink = $temp.google + $temp.word;

        if: $parseTree.morphAdjNoun
            script:
                $temp.wiki = "https://ru.wikipedia.org/wiki/";
                $temp.google = "https://www.google.ru/search?newwindow=1&q=";
                $temp.word4wiki = $parseTree.morphAdjNoun[0].words[0] + "_" + $parseTree.morphAdjNoun[0].words[1];
                $temp.word4google = $parseTree.morphAdjNoun[0].words[0] + " " + $parseTree.morphAdjNoun[0].words[1];
                $temp.wlink = $temp.wiki + $temp.word4wiki;
                $temp.glink = $temp.google + $temp.word4google;

        if: $request.channelType == "telegram"
            a: {{answerCustomMode("html", "Почитай <a href=\"" + $temp.wlink + "\" target=\"_blank\">здесь</a> или <a href=\"" + $temp.glink + "\" target=\"_blank\">здесь</a>.")}}

        elseif: $request.channelType == "chatwidget" || $request.channelType == "incoming_webim"
            a: Почитай <a href="{{$temp.wlink}}" target="_blank" >здесь</a> или <a href="{{$temp.glink}}" target="_blank" >здесь</a>.
        else:
            a: Почитай по этим ссылкам: \n {{$temp.wlink}} \n {{$temp.glink}}



    state: testToday0
        q!: test сегодня в Антарктике
        script:
            $session.dates = $jsapi.dateForZone("Antarctica/Casey","YYYY-MM-dd");
            $session.time = $jsapi.dateForZone("Antarctica/Casey","HH");
        a: Сегодня в Антарктике {{$session.dates}}, {{$session.time}}



    state: testToday1
        q!: test сегодня
        script:
            $session.dates = $jsapi.dateForZone("Europe/Moscow","YYYY-MM-dd");
            $session.time = $jsapi.dateForZone("Europe/Moscow","HH");
        a: Сегодня {{$session.dates}}, {{$session.time}}



    state: testMappingWithAlias
        q!: testMappingWithAlias * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        a: {{toPrettyString($parseTree)}}



    state: testRequest
        q!: testRequest
        a: {{toPrettyString($request)}}


    state: testReplies
        q!: testReplies
        script:
            $response.replies = $response.replies || [];
            $response.replies.push( {
                type: "image",
                imageUrl: "https://images-eu.ssl-images-amazon.com/images/I/41OWzg0D-PL.jpg",
                text: "это ковбой"
            } );



    state: testOneWord
        q!: testOneWord [$oneWord] [$oneWord] [$oneWord] привет
        a: мы уложились в 5 слов



    state: testPatternsDates
        q!: testPatternsDates $forAdults
        script:
            $session.adults = $parseTree._NumberLett;
        a: ты сказала: {{toPrettyString($parseTree)}}
        a: {{$session.adults}}



    state: testRailwaySuggestion
        q!: testRailwaySuggestion $oneWord
        #a: {{toPrettyString($parseTree)}}
        script:
            $temp.station = (encodeURI($parseTree.words[1]));
            var headers = {
            };
            var result = $http.query('https://uniapi.ozon.travel/railway/suggestion/locations?word=' + $temp.station + '=&top=1', {
                method: "GET",
                headers: headers,
                timeout: 0 || 10000
            });
            $temp.httpResponse = result.data;
            $session.httpStatus = result.status;
            $session.httpResponse = $temp.httpResponse;
            if (result.isOk && result.status >= 200 && result.status < 300) {
                $reactions.transition('/test/testRailwaySuggestion/ans');
            } else {
                $reactions.answer('🤷‍♀️');
            }
        state: ans
            a: {{toPrettyString($session.httpResponse.locations[0].code)}}



    state: testRedirect2operatorMssg
        q!: testRedirect2operatorMssg
        a: Я собираюсь перевести разговор на оператора
        script:
            $response.actions = [{
               type:"close_chat",
               operatorId:"186470"
            }];
        # работает



    state: testCloseChatWithCategory
        q!: closechat
        a: Я закрыл чат с категорией TEST
        script:
            $response.actions = [{
                "type": "close_chat",
                "category": "TEST" //обязательно
                //если есть sub_category
                //"sub_category": "def" // необязательно
            }];
        # работает



    state: testOperatorSwitch
        q!: testOperatorSwitch
        script:
            $response.replies =  $response.replies || [];
            $response.replies.push({
                type:"switch"
                });
        # "has_answer": False, работает



    state: testRedirect2department
        q!: testRedirect2department
        a: Я собираюсь перевести разговор на отдел тестирования
        script:
            $response.actions = [{
               type:"redirect_to_department",
               departmentKey:"qa"
            }];
        # работает



#    state: userInfoForOperator
#        event!: for_operator
#        script:
#            $session.forOperator = $request;

#        a: 😈😈😈 kind for_operator:
#        a: {{toPrettyString($request)}}
        # работает (переход онлайн/офлайн/на другую страницу, закрытие чата пользователем)




    state: testnewChatStartedInfo
        # НЕ РБОТАЕТ
        q!: testnewChatStartedInfo
        script:
            if ($session.newChatStarted) {
                 $reactions.answer(toPrettyString($session.newChatStarted));
            }
            if ($session.landingTheme) {
                $reactions.answer($session.landingTheme);
            }
            /*
            {
               "livechatStatus":{
                  "enabled":false
               },
               "eventData":{
                  "visitor":{
                     "comment":"\n\t\t\tАктивные заявки: 0  \n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t-----------------------------------\n\t\t",
                     "info":"\n\t\t\tЗаказы ожидающие оплаты: 0  \n\t\t\t\n\n\n\n\n\t\t\t-----------------------------------\n\t\t\n\t\t\tЗаказы с отпр. в ближ. 36 ч: 0  \n\t\t\t\n\n\n\n\n\t\t\t-----------------------------------\n\t\t\n\t\t\tОстальные заказы: 0  \n\t\t\t\n\n\n\n  \n\t\t\t",
                     "name":"Любовь Мельникова",
                     "ip":"85.141.189.6",
                     "email":"lmelnikova@ozon.travel",
                     "phone":"79201566365",
                     "landing_page_url":"https://www.ozon.travel/",
                     "landing_page_title":"OZON.travel - бронирование билетов на самолет и ж/...",
                     "login":"VIP ",
                     "geo":"Россия, Москва http://maps.google.com/maps...",
                     "id":"869628746000",
                     "browser":"Chrome 78"
                  },
                  "location":"Persons",
                  "chat":{
                     "id":"40cee1ab51ec47c0bacb09d7707cb58e"
                  },
                  "event":"new_chat"
               },
               "chatId":"40cee1ab51ec47c0bacb09d7707cb58e"
            }
            /*


    state: testNewSearch
        q!: testNewSearch $iataAndRailway::fromCode $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay))
        if: $session.landingTheme == 'ЖД'
            go!: /railwaySearch/railwaySearchFullInfo
        else:
            go!: /aviaSearch/aviaSearchFullInfo



    state: testCountry
        q!: тест где $cityCode
        script:
            $session.country = $parseTree._cityCode.country;
        a: в стране {{$session.country}}



#    state: testTimeLimit
#        q!: timeout
#        script:
#            $reactions.timeout({interval: '120 seconds', targetState: '/test/testTimeLimit/testTimeLimitAns'});
#


    state: testchannelType
        q!: channelType
        a: channelType - {{$request.channelType}}



    state: testInnerCalendarApi
        q!: testInnerCalendarApi $iataAndRailway::fromCode $iataAndRailway::destCode
        # чистим переменные
        script:
            $session.score = undefined;
            $session.begin = undefined;
        # собираем переменные
        if: $temp.begin2 == undefined
            script:
                $temp.begin2 = true;
                $temp.begin0 = true;
                $client.executeState = $context.currentState;
            go!: /aviaSearchFunc/parsing4AviaSearch_DYN
        else:
            script:
                $temp.begin2 = undefined;
                $temp.begin0 = undefined;

                if ($session.from != $session.dest) {
                    var result = calendarSearchPost({from: $session.from, dest: $session.dest, passengers: $session.adults});
                    $session.httpResponse = result.data;
                    $session.httpStatus = result.status;
                    //проверяем, что есть ответ
                    if (result.isOk && (!isArrayEmpty($session.httpResponse.prices)) && result.status >= 200 && result.status < 300) {
                        $session.calendarList = [];
                        //проходим по календарю цен и собираем минимальные
                        for (var i = 0; i < $session.httpResponse.prices.length; i++) {
                            if ($session.httpResponse.prices[i].hasOwnProperty('isMin')) {
                                var minPrice = $session.httpResponse.prices[i].price;
                                var date = $session.httpResponse.prices[i].date;
                                var date4user = getDate4User(date);
                                $session.calendarList.push({'minprice': minPrice, 'date': date, 'date4user': date4user});
                            }
                        }
                    }
                    $session.dates = $session.calendarList[0].date;
                    $session.urlOzon = urlOzonAvia({from: $session.from, dest: $session.dest, date: $session.dates, passengers: $session.adults}, $session.yandex);
                    if ($session.calendarList.length > 1) {
                        var otherOptions = true;
                    }
                    $reactions.answer('Минимальная цена по вашему маршруту составляет ' + $session.calendarList[0].minprice + ' рублей. Вылет ' + $session.calendarList[0].date4user + '. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: ' + $session.urlOzon);
                    if (otherOptions == true) {
                        $reactions.answer('Есть и другие даты с такой же ценой. Хотите посмотреть?')
                    }
                } else {
                    $reactions.transition("/aviaSearchAns/aviaSearchError");
                }


        state: testYeah
            q: [$beginningWords] ($yes2/$yesAgreeTo/$certainly)
            q: [$beginningWords] ($yes2/$yesAgreeTo/$certainly) $please
            q: {[$beginningWords] [$yes2/$certainly] $wantAll [$checkLook]}
            q: {[$beginningWords] $perhaps ($yes2/$yesAgreeTo)}
            q: {[$beginningWords] $perhaps $wantAll [$checkLook]}
            q: [$beginningWords] ($how/где) это (сделать/сделат/делаетс*/делаетьс*)
            q: [$beginningWords] $how
            if: $session.begin == undefined
                script:
                    $session.begin = true;
                    $session.score = 0;
            else:
                script:
                    $session.score++;
            go!: /test/testInnerCalendarApi/testYeah/testShowingCalendarList

            state: testShowingCalendarList
                script:
                    var temparray = [];
                    var i,j,chunk = 5;
                    //проходим по минимальным ценам и бьем по 5
                    for (i=1,j=$session.calendarList.length; i<j; i+=chunk) {
                        temparray.push($session.calendarList.slice(i,i+chunk));
                    }
                    //DEBUG
                    //$reactions.answer('score: ' + $session.score + ', temparray.length: ' + temparray.length);
                    if (temparray.length >= $session.score && (temparray[$session.score].length > 0)) {
                        //выдаем кусок
                        for (var j = 0; j < temparray[$session.score].length; j++) {
                            var peice = temparray[$session.score];
                            $reactions.answer(peice[j].date4user + ': ' + urlOzonAvia({from: $session.from, dest: $session.dest, date: peice[j].date, passengers: $session.adults}, $session.yandex));
                        }
                        if ($session.score != temparray.length - 1) {
                            $reactions.answer('Показать еще?');
                        } else {
                            $reactions.answer('Это все доступные варианты. Я могу еще чем-то помочь?');
                        }
                    } else {
                        $reactions.answer('Это все доступные варианты. Я могу еще чем-то помочь?');
                    }
                go: /test/innerCalendarApi/testYeah



    state: testTrainEmoji
        q!: testTrainEmoji
        a: 🚆



    state: beatWeightedState
        q!: я купила билеты а они не приходят на почту
        script:
            $reactions.answer(JSON.stringify(c.nBest[0].score));
        a: успех



    state: orderInfoApiTest
        q!: orderInfoApiTest $orderNumber
        script:
            var orderNumber = $parseTree._orderNumber.replace(/(\d{8})[^\d]?(\d{4})/, "$1-$2");
            var url = 'https://chat-bot-api.ozon.travel/chatbot/order/' + orderNumber;
            var result1 = $http.query(url, {
                method: "GET",
                headers: {"Content-Type": "application/json", "Authorization": "Bearer 285D4CD477C1D5DFEB3BCBA5E0DF05D7E339D3E1"},
                timeout: 0 || 10000
            });
            $temp.httpResponse1 = result1.data;

            /*
            {
               "orderId":"4845542681000",
               "positions":[
                  {
                     "positionId":"4845542684000",
                     "positionName":"MOW - PRG",
                     "positionStateId":"921472000",
                     "positionStateSysName":"ClientOrderPositionAviaPerformed",
                     "positionStateName":"Исполнена",
                     "bookingId":"4845542627000",
                     "bookingName":"XHWTWW",
                     "bookingCondition":"Fare conditions...",
                     "airlineCode":"OK",
                     "airlineName":"Czech Airlines"
                  }
               ]
            }

            {
               "orderId":"5179312227000",
               "positions":[
                  {
                     "positionId":"5179312230000",
                     "positionName":"LED - MOW",
                     "positionStateId":"921464000",
                     "positionStateSysName":"ClientOrderPositionAviaExpectsPayment",
                     "positionStateName":"Ожидает оплаты",
                     "bookingId":"5179312148000",
                     "bookingName":"VXAHSI",
                     "bookingCondition":"Fare conditions...",
                     "airlineCode":"SU",
                     "airlineName":"Аэрофлот"
                  },
                  {
                     "positionId":"5179312231000",
                     "positionName":"SVX - LED",
                     "positionStateId":"921464000",
                     "positionStateSysName":"ClientOrderPositionAviaExpectsPayment",
                     "positionStateName":"Ожидает оплаты",
                     "bookingId":"5179312187000",
                     "bookingName":"JKPNPN",
                     "bookingCondition":"Fare conditions...",
                     "airlineCode":"U6",
                     "airlineName":"Уральские авиалинии"
                  }
               ]
            }
            */
        a: order api answer:
        a: bo: {{toPrettyString($temp.httpResponse1)}}



    state: testRoundtripFullInfo
        q!: testRoundtripFullInfo * ($dateDig::dateDig1/$dateLetters::dateLetters1) ($dateDig::dateDig2/$dateLetters::dateLetters2)
        a: попали


























