theme: /operator

    state: goToOpeartor
        #a: В чате сейчас много обращений, вам ответит первый же свободный оператор. \nМы обязательно ответим на ваш вопрос как можно скорее. \nНадеемся на ваше понимание!
        script:
            if ($request.channelType == 'telegram' || $request.channelType == 'chatwidget') {
                $reactions.answer('Перевод на оператора')
            } else {
                $response.replies =  $response.replies || [];
                $reactions.answer('Перевод на оператора6547658765')
                $response.replies.push({
                    type:"switch"
                    });
            }


        state: waiting
            # 4EX: ок ждем
            # 4EX: Ок жду
            # 4EX: Спасибо, ожидаю
            # 4EX: Жду спасибо
            # 4EX: Хорошо, жду. Спасибо!
            # 4EX: хорошо спасибо
            # 4EX: Я всё ещё жду:)
            q: [$beginningWords] [$oneWord] [$yes2/$yesAgreeTo/хорошо/харошо][$veryAll/весьма/висьма/весма/висма/еще/все еще/уже/ужк] (жду/ждем/ожидаю/ожидаем) [$thanks2]
            # 4EX: Спасибо! Я жду
            q: [$beginningWords] [$thanks2] [$oneWord] [$yes2/$yesAgreeTo/хорошо/харошо][$veryAll/весьма/висьма/весма/висма/еще/все еще/уже/ужк] (жду/ждем/ожидаю/ожидаем)
            # 4EX: Спасибо буду ждать ответа
            q: [$beginningWords] [$thanks2] [$oneWord] (ждать/ждаьт/ожидать) (ответ*/сообщени*) [от] [вас/вашего/твоего/тебя]
            a: Спасибо!


        state: waitingForAnswer
            # 4EX: Очень жду вашего ответа
            # 4EX: ожидаю ответ
            q: [$beginningWords] [$oneWord] [$veryAll/весьма/висьма/весма/висма/еще/все еще/так] (жду/ждем/ожидаю/ожидаем) [от] [вас/вашего/твоего/тебя] (ответ*/сообщени*)
            # 4EX: прошу дать ответ
            q: [$beginningWords] прошу (дать ответ/ответить)
            # 4EX: Просьба ответить
            q: [$beginningWords] [больш*] просьба (дать ответ/ответить)
            # 4EX: пожалуйста ответьте, я уже час жду ответа
            q: [$beginningWords] [$please] (ответте/ответьте/ответь) * ($veryAll/весьма/висьма/весма/висма/еще/все еще/уже/ужк/так) [час/два часа/три часа/2 часа/3 часа/сутки/давно] (жду/ждем/ожидаю/ожидаем)
            # 4EX: Здравствуйте, вы не забыли про меня?, спасибо.
            q: [$beginningWords] (вы/ты) [там] {($ne забыл*) ((про/об/обо) ($meDat/$meGenAcc))} [$thanks2]
            # 4EX: Так долго!!!
            q: [$beginningWords] [$veryAll/весьма/висьма/весма/висма/еще/так] долго [уже/ужк/еще] [жду/ждем/ожидаю/ожидаем/ждать/ожидать]
            # 4EX: Когда будет ответ?
            q: [$beginningWords] $whenAll [$oneWord] [ждать/ожидать] (ответ*/сообщени*)
            # 4EX: Сколько можно тянуть время
            # 4EX: Сколько примерно ждать?
            a: Простите, что приходится так долго ждать. Вам ответит первый же свободный оператор.



        state: waitingForOperator
            # 4EX: Жду связи с оператором
            q: [$beginningWords] [$oneWord] [$veryAll/весьма/висьма/весма/висма/еще/все еще/до сих пор/по прежнему/попрежнему/попрежднему/так/так и/пока/пока что] (жду/ждем/ожидаю/ожидаем) (связ*/соединен*/ответ*) (оператор*/консультант*)
            # 4EX: Жду нормального консультанта!
            q!: [$beginningWords] [$veryAll/весьма/висьма/весма/висма/еще/все еще/до сих пор/по прежнему/попрежнему/попрежднему/так/так и/пока/пока что] (жду/ждем/ожидаю/ожидаем) [$oneWord] (оператор*/консультант*)
            # 4EX: Сколько ждать чата с оператором
            q: [$beginningWords] ($howLong/$howMuch) [$meDat/нам] (ждать/ожидать) (чат*/разговор*/ответ*) [с] (оператор*/консультант*)
            # 4EX: Когда появится живой оператор, чтобы мне ответить?????
            q: [$beginningWords] $when (появит*/будет/будит/придет/ответит) [$oneWord] (оператор*/консультант*) * {($meDat/нам) ответит*}
            # 4EX: До сих пор нет  свободных людей?
            q: [$beginningWords] [еще/все еще/до сих пор/по прежнему/попрежнему/попрежднему/так/так и/пока/пока что] $absent [свободн*/жив*/настоящ*] (людей/человек*/оператор*/консультант*)
            go!: /operator/waitingForAnswer



        state: emergency
            # 4EX: Пожалуйста мне нужно срочно
            # 4EX: Срочно надо
            q: [$beginningWords] [$please] [$meDat/нам] {срочн* [$need2]}
            # 4EX: Нужен срочно оператор
            q: [$beginningWords] {[$meDat/нам] {$need2 срочн*}} (оператор*/консультант*)
            script:
                if ($request.channelType == 'telegram' || $request.channelType == 'chatwidget') {
                    $reactions.answer('Перевод на оператора')
                } else {
                    $response.replies =  $response.replies || [];
                    $reactions.answer('Перевод на оператора6547658765')
                    $response.replies.push({
                        type:"switch"
                        });
                }



        state: neverMind
            # 4EX: Всё уже дозвонился
            q: [$beginningWords] [все] [уже] [йа/я/мы] дозвонил* [уже] [все]
            # 4EX: Отбой. Выясняем по телефону уже.
            q: [$beginningWords] [все] [уже] {отбой (выясн* по телефон*)} [уже] [все]
            # 4EX: Отбой...
            q: [$beginningWords] [все] [уже] отбой [уже] [все]
            a: Спасибо за общение, всего доброго!
            script:
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




