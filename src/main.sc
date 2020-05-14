require: _require.sc
require: dict/patterns.sc
#require: slotfilling/slotFilling.sc
#  module = sys.zb-common
theme: /
    init:
        // ПРЕ-матчер
        // вызывается перед классификатором интентов (матчером).
        bind("preMatch", function($context) {
            var $request   = $jsapi.context().request,
                $session   = $jsapi.context().session,
                $parseTree = $jsapi.context().parseTree,
                $score     = 0,
                $temp      = $jsapi.context().temp,
                query = $request.query;
            // Заменяем спецсимволы, которые стоят между словами, на пробелы
            if ($request.query &&
                (/[а-яё]([^а-яё\w\s]+)[а-яё]/i.test(query) ||
                 /[a-z]{2,}([^а-яё\w\s]+)[а-яё]{2,}/i.test(query) ||
                 /[a-z]{2,}([^а-яё\w\s]+)[a-z]{2,}/i.test(query) ||
                 /[а-яё]{2,}[0-9]/i.test(query) ||
                 /[0-9][а-яё]{2,}/i.test(query) ||
                 /[а-яё]{2,}[^а-яё\w\s]+[0-9]/i.test(query) ||
                 /[0-9][^а-яё\w\s]+[а-яё]{2,}/i.test(query) ||
                 /[.,+-/'"`~\]\[\\!@#$%^&*][а-я]/i.test(query) ||
                 /[а-яё]{2,}([^а-яё\w\s]+)[a-z]{2,}/i.test(query))
            ) {
                query = query.replace(/([а-яё])[^а-яё\w\s]+([а-яё])/gi, "$1 $2");
                query = query.replace(/([a-z]{2,})[^а-яё\w\s]+([а-яё]{2,})/gi, "$1 $2");
                query = query.replace(/([a-z]{2,})[^а-яё\w\s]+([a-z]{2,})/gi, "$1 $2");
                query = query.replace(/([а-яё])([0-9])/gi, "$1 $2");
                query = query.replace(/([0-9])([а-яё])/gi, "$1 $2");
                query = query.replace(/([а-яё]{2,})[^а-яё\w\s]+([0-9])/gi, "$1 $2");
                query = query.replace(/([0-9])[^а-яё\w\s]+([а-яё]{2,})/gi, "$1 $2");
                query = query.replace(/([.,+-/'"`~\]\[\\!@#$%^&*])([а-я])/gi, "$1 $2");
                //query = query.replace(/([0-9])\D{1,2}([0-9])/gi, "$1 $2");
                $request.query = query.replace(/([а-яё]{2,})[^а-яё\w\s]+([a-z]{2,})/gi, "$1 $2");
                //$request.query = query.replace(/([а-яё])[^а-яё\w\s]+([а-яё])/gi, "$1 $2");
                var result = $nlp.match($request.query, $session.contextPath || "/");
                if (result != null && result.targetState && $score < result.score) {
                    log("[JS-DEBUG] result: " + JSON.stringify(result));
                    // перезаписываем parseTree
                    for (var key in result.parseTree) {
                        $parseTree[key] = result.parseTree[key];
                    }
                    // сохраняем путь к стейту
                    $temp.targetState = result.targetState;
                }
            }
            // фикс раскладки
            if ($request.query) {
                var matchResults = $nlp.match($request.query, $session.contextPath || "/");
                if (matchResults != null && matchResults.targetState && matchResults.targetState.indexOf("/catchAll") !== -1) {
                    var fixedText = $nlp.fixKeyboardLayout($request.query);
                    if (fixedText) {
                        var matchResults2 = $nlp.match(fixedText, "/");
                        if (matchResults2 != null && matchResults2.targetState) {
                            $temp.targetState = matchResults2.targetState;
                        }
                    }
                }
            }
        });
        // препроцессинг
        bind("preProcess", function($context){
            preprocess($context);
            var $temp = $jsapi.context().temp;
            var theme = $context.currentState.slice(1).split('/');
            theme = theme.length > 0 ? theme[0] : '/';
            var getRuTheme = {
                'address': 'Контакты Ozon.Travel',
                'aviaSearch': 'Вопросы по наличию мест и ценам',
                'aviaSearchDirect': 'Вопросы по наличию мест и ценам',
                'aviaSearchDirectWithP': 'Вопросы по наличию мест и ценам',
                'aviaSearchRoundtrip': 'Вопросы по наличию мест и ценам',
                'aviaSearchRoundtripWithP': 'Вопросы по наличию мест и ценам',
                'aviaSearchWithPassengers': 'Вопросы по наличию мест и ценам',
                'baggage': 'Багаж',
                'bonuses': 'Оплата бонусами,сертификатами',
                'botQuestions': 'О боте',
                'checkIn': 'Вопросы по онлайн-регистрации',
                'contacts': 'Контакты Ozon.Travel',
                'documentsFaq': 'Как вводить паспортные данные',
                'kidsDocuments': 'Как вводить паспортные данные (дети)',
                'kidsFliyingAlone': 'Авиабилеты - Общие вопросы (дети)',
                'lkPassword': 'Проблемы с логином паролем',
                'paymentOptions': 'Оплата заказа',
                'railwayFaq': 'ЖД',
                'railwaySearch': 'ЖД',
                'railwaySearchRoundtrip': 'ЖД',
                'railwaySearchWithP': 'ЖД',
                'searchRoundtripWithP': 'Вопросы по наличию мест и ценам',
                'test': 'TEST',
                'ticketExchange': 'Обмен билета',
                'ticketReturn': 'Обмены, возвраты, аннуляции заказов',
                'ticketsFaq': 'Электронные билеты',
                'ticketsSubscription': 'Акции, спецпредложения, рассылки, скидки',
                'ticketSubsidiesDiscounts': 'Акции, спецпредложения, рассылки, скидки',
                //'chatClosingWithTopic': 'Бонусы Спасибо'
                //'ellipsis': 'Другое',
                //'helloBye': 'Другое',
                //'politeness': 'Другое',
                //'/': 'Другое',
                //'addressAns': 'Другое',
                //'faq': 'Другое',
                //'ticketProblems': 'Другое'
            };
            if (getRuTheme[theme]) {
                $context.client.topic = getRuTheme[theme];
            }
            //здороваемся с пользователем
            if ($context.contextPath === "/userInfoNewChat" && $context.temp.classifierTargetState != "/helloBye/hello") {
                $reactions.answer("Здравствуйте!");
            }
        });
        // ПОСТ-процессинг
        // стейт запущен
        // может быть использован для добавления дополнительных данных в ответ
        bind("postProcess", function($context) {
            postprocess($context);
            script:
                var $client = $jsapi.context().client;
                //if ($context.session.lastAnswer != 'ну и пака' && !testMode()) {
                //    $reactions.timeout({interval: '5 minutes', targetState: '/test/testTimeLimitAns'});
                //}
        });



    state: catchAll
        q!: *
        #event!: noMatch
        script:
            if (/^((😀)+|(😁)+|(😂)+|(😃)+|(😄)+|(🤣)+|(😅)+|(😆)+|(😇)+|(😉)+|(😊)+|(🙂)+|(🙃)+|(☺)+|(😋)+|(😌)+|(😍)+|(😘)+|(😗)+|(😙)+|(😚)+)$/.test($parseTree.text) == true) {
                $reactions.answer('😌');
            } else {
                $reactions.transition('/operator/goToOpeartor');
            }
        #if: ($temp.time >= 20 && $temp.time <= 23) || ($temp.time >= 0 && $temp.time < 8)
            #a: Прошу прощения, но я вас не понял, вам лучше дождаться оператора. Наши специалисты отвечают на вопросы в чате с 8:00 до 20:00 по московскому времени. \nЕсли вы уже в аэропорту или на вокзале и нет времени ждать, звоните : +7 495 787-28-88
        #else:
            #a: Непонятно. Я умею обрабатывать запросы вроде "Москва - Краснодар 1 января"



    state: NewSession
        q!: reset
        script:
            $reactions.newSession({message: "/start", data: $request.data});



    state: restartAns
        q!: start
        a: session restarted



    state: lengthLimit
        event!: lengthLimit
        go!: /operator/goToOpeartor



    state: timeLimit
        event!: timeLimit
        go!: /operator/goToOpeartor



    state: clientSentImg
        event!: imageEvent
        go!: /operator/goToOpeartor



    state: userInfoNewChat
        #работает, но нельзя сразу среагировать
        event!: newChatStarted
        script:
            var newChatStarted = $request;
            if (newChatStarted && newChatStarted.data && newChatStarted.data.eventData && newChatStarted.data.eventData.visitor && newChatStarted.data.eventData.visitor.landing_page_url) {
                //$session.newChatStarted = newChatStarted.data;
                $session.browser = newChatStarted.data.eventData.visitor.browser;
                $session.landing = newChatStarted.data.eventData.visitor.landing_page_url;
                $session.landing = $session.landing.toString();
                if (($session.landing.indexOf('ozon.travel/railway') != -1) || ($session.landing.indexOf('ozon.travel/help/railway')) != -1) {
                    $session.landingTheme = 'ЖД';
                } else {
                    $session.landingTheme = 'АВИА';
                }
            }
            if (newChatStarted && newChatStarted.data && newChatStarted.data.eventData && newChatStarted.data.eventData.visitor && newChatStarted.data.eventData.visitor.landing_page_url && newChatStarted.data.eventData.visitor.landing_page_title) {
                var landing_page_url = newChatStarted.data.eventData.visitor.landing_page_url;
                if (landing_page_url.match(/.+ozon\.travel\/flight\/search\/[A-Za-z]{6}.+/)) {
                    landing_page_url = landing_page_url.replace(/.+\/search\/([A-Za-z]{3})([A-Za-z]{3}).+/, '$1#$2');
                    landing_page_url = landing_page_url.split('#');
                    $session.from = landing_page_url[0];
                    $session.dest = landing_page_url[1];
                }
                var landing_page_title = newChatStarted.data.eventData.visitor.landing_page_title;
                if (landing_page_title.match(/.*Авиаперелёт [А-Яа-яё -]+ — [А-Яа-яё -]+[ ,].+/)) {
                    landing_page_title = landing_page_title.replace(/.*Авиаперелёт ([А-Яа-яё -]+) — ([А-Яа-яё -]+)[ ,].+/, '$1#$2');
                    landing_page_title = landing_page_title.split('#');
                    $session.from4User = landing_page_title[0];
                    $session.dest4User = landing_page_title[1];
                }
            }
            if (newChatStarted && newChatStarted.data && newChatStarted.data.eventData && newChatStarted.data.eventData.visitor && newChatStarted.data.eventData.visitor.info) {
                var orderNumb, neededIndex, orderList, numbSplitted;
                neededIndex = [];
                numbSplitted = [];
                orderList = [];
                orderNumb = [];
                var flag, order = newChatStarted.data.eventData.visitor.info;
                // регулярки
                var reDash = /-{2,}/gm;
                var reSpace = /\s+/gm;
                var reSideSpace = /^\s+(.+)\s+/gm;
                // делим по -----
                order = order.split(reDash);
                for (var i=0;i<order.length;i++) {
                    // чистим пробелы
                    order[i] = order[i].replace(reSpace,' ');
                    order[i] = order[i].replace(reSideSpace,'$1');
                    // отделяем цифры от букв
                    order[i] = order[i].split(': ');
                    if (order[i][1]!=0) {
                        neededIndex.push(i);
                    }
                }
                // кладем заказы в orderList
                for (var k=0;k<neededIndex.length;k++) {
                    orderList.push(order[neededIndex[k]]);
                }
                // выковыриваем номер заказа оттуда
                for (var l=0; l<orderList.length; l++) {
                    orderList[l][1] = orderList[l][1].split(reSpace);
                    for (var m=1; m<orderList[l][1].length; m = m+3) {
                        orderNumb.push(orderList[l][1][m]);
                    }
                }
                $client.orderList = orderNumb;
            }



    state: operatorChoseAnswer
        event!: operatorChoseAnswer
        a: Оператор выбрал подсказку №{{$request.data.selectedOption}}: {{$request.data.optionText}}



    state: sessionDataHardLimitExceeded
        event!: sessionDataHardLimitExceeded
        go!: /operator/goToOpeartor



    state: yandexData
        q!: * service * Organization URL in search * $weight<+1>
        q!: * service * User region * $weight<+1>
        q!: * service * User search * $weight<+1>
        script:
            $session.yandex = true;



    state: chatClosingWithTopic
        # закрывает чат, если бот не шлет ничего в догонку
        event!: for_operator
        script:
            if ($request.data.eventData.message.text == "Посетитель переведён в статус оффлайн.") {
                if ($client.topic) {
                    if ($client.topic == "TEST") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "TEST" //обязательно
                        }];
                    } else if ($client.topic == "Авиабилеты - Общие вопросы (дети)") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы" //обязательно
                        }];
                    } else if ($client.topic == "Акции, спецпредложения, рассылки, скидки") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Акции, спецпредложения, рассылки, скидки" //обязательно
                        }];
                    } else if ($client.topic == "Багаж") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы", //обязательно
                            "sub_category": "Багаж" // необязательно
                        }];
                    } else if ($client.topic == "Бонусы Спасибо") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Оплата заказа", //обязательно
                            "sub_category": "Бонусы Спасибо" // необязательно
                        }];
                    } else if ($client.topic == "Вопросы по наличию мест и ценам") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Вопросы по оформлению заказа", //обязательно
                            "sub_category": "Вопросы по наличию мест и ценам" // необязательно
                        }];
                    } else if ($client.topic == "Вопросы по онлайн-регистрации") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы",
                            "sub_category": "Вопросы по онлайн-регистрации"
                        }]
                    } else if ($client.topic == "ЖД") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "ЖД" //обязательно
                        }];
                    } else if ($client.topic == "Как вводить паспортные данные (дети)") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Вопросы по оформлению заказа", //обязательно
                            "sub_category": "Как вводить паспортные данные" // необязательно
                        }];
                    } else if ($client.topic == "Контакты Ozon.Travel") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Другое", //обязательно
                            "sub_category": "Контакты Ozon.Travel" // необязательно
                        }];
                    } else if ($client.topic == "Обмен билета") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Обмены, возвраты, аннуляции заказов", //обязательно
                            "sub_category": "Обмен билета" // необязательно
                        }];
                    } else if ($client.topic == "Обмены, возвраты, аннуляции заказов") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Обмены, возвраты, аннуляции заказов" //обязательно
                        }];
                    } else if ($client.topic == "Оплата бонусами,сертификатами") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Оплата заказа", //обязательно
                            "sub_category": "Оплата бонусами,сертификатами" // необязательно
                        }];
                    } else if ($client.topic == "Оплата заказа") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Оплата заказа" //обязательно
                        }];
                    } else if ($client.topic == "Проблемы с логином паролем") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Вопросы по оформлению заказа", //обязательно
                            "sub_category": "Проблемы с логином паролем" // необязательно
                        }];
                    } else if ($client.topic == "Трэвелмания") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Акции, спецпредложения, рассылки, скидки", //обязательно
                            "sub_category": "Трэвелмания" // необязательно
                        }];
                    } else if ($client.topic == "Электронные билеты") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы", //обязательно
                            "sub_category": "Электронные билеты" // необязательно
                        }];
                    } else if ($client.topic == "Вопросы по оформлению заказа") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Вопросы по оформлению заказа", //обязательно
                        }];
                    } else if ($client.topic == "Как вводить паспортные данные") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Вопросы по оформлению заказа", //обязательно
                            "sub_category": "Как вводить паспортные данные" // необязательно
                        }];
                    } else if ($client.topic == "Вопросы по онлайн-регистрации") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы", //обязательно
                            "sub_category": "Вопросы по онлайн-регистрации" // необязательно
                        }];
                    } else if ($client.topic == "Стыковки и транзит") {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Авиабилеты - Общие вопросы", //обязательно
                            "sub_category": "Стыковки и транзит" // необязательно
                        }];
                    } else {
                        $response.actions = [{
                            "type": "close_chat",
                            "category": "Другое", //обязательно
                        }];
                    }
                }
            }
