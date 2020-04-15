require: requirements.sc

theme: /
    state: Start
        q!: * *start
        a: Привет! Могу подобрать билеты на поезд. Напишите, откуда, куда и когда вы собираетесь поехать?
        script: $session = {}

        state:
            q!: (привет|приветствую|приветики)
            q!: (здравствуйте|здраствуйте|здрасьте|здрасте)
            q!: (здорово|здоров|дарова|даров)
            q!: (добрый|доброго)
            q!: (добрый день|доброго дня|день добрый)
            q!: (добрый вечер|доброго вечера|вечер добрый)
            q!: (доброе утро|доброго утра|утро доброе)
            q!: (доброй ночи)
            a: Укажите, пожалуйста, город отправления, город прибытия и дату поездки^hello
        
    state: GetTrainSchedule
        intent!: /GetRawDirection
        
        # a: Parsed Tree: {{ toPrettyString($parseTree) }}
        a: All entities: {{ toPrettyString($entities) }}

        script:
            $session = {}
            $session.retryParam = 2; // параметр число переспросов
            $session.retry = 0;
            $session.result = ""
            var loc0;
            var loc1;
            var locationsCount = 0;
            var datesCount = 0;
            var date_result = {};
            var datereturn_result = {};

            
            var locations = [];
            var locationsFrom = [];
            var locationsTo = [];
            var dates = [];
            
            var locationsCount = 0;
            var loctoCount = 0;
            var locfromCount = 0;
            var datesCount = 0;
            var roundTrip = 0;
            
            // parse entities
            if ($entities) {
                var entities_count = $entities.length;
                for (var i=0; i<entities_count; i++) {
                    if ($entities[i]["pattern"] == "LocationNewDictionary") locations.push($entities[i]["value"]);
                    if ($entities[i]["pattern"] == "LocationTo") locationsTo.push($entities[i]["value"]);
                    if ($entities[i]["pattern"] == "LocationFrom") locationsFrom.push($entities[i]["value"]);
                    if ($entities[i]["pattern"] == "Date") dates.push($entities[i]["value"]);
                    
                    if ($entities[i]["pattern"] == "ReservedSeatTicket") $session.reserved_ticket = 1;
                    if ($entities[i]["pattern"] == "RegularSeatTicket") $session.regular_ticket = 1;
                    if ($entities[i]["pattern"] == "LuxeSeatTicket") $session.lux_ticket = 1;
                    
                    if ($entities[i]["pattern"] == "MorningTime") $session.morning_time = 1;
                    if ($entities[i]["pattern"] == "DayTime") $session.day_time = 1;
                    if ($entities[i]["pattern"] == "EveningTime") $session.evening_time = 1;
                    if ($entities[i]["pattern"] == "NightTime") $session.night_time = 1;
                    
                    if ($entities[i]["pattern"] == "ChildTicket") $session.child_ticket = 1;
                    
                    if ($entities[i]["pattern"] == "RoundTripWords") roundTrip = 1;
                }
                    
                locationsCount = locations.length;
                loctoCount = locationsTo.length;
                locfromCount = locationsFrom.length;
                datesCount = dates.length;
            }
            
            // check directions count    
            var multiDirection = 0;
            if (locationsCount > 2) {
                if (locationsCount == 3 && locations[0].stations_codes == locations[2].stations_codes) {
                    roundTrip = 1;
                    }
                else if (locationsCount == 4 && locations[0].stations_codes == locations[3].stations_codes
                && locations[1].stations_codes == locations[2].stations_codes) {
                    roundTrip = 1;
                    }
                else multiDirection = 1;
            }
            
            if ((loctoCount > 1 || locfromCount > 1) && (roundTrip === 0)) {
                if (loctoCount == 2 && locfromCount == 2 && locationsFrom[0].stations_codes == locationsTo[1].stations_codes 
                    && locationsFrom[1].stations_codes == locationsTo[0].stations_codes) roundTrip = 1;
                else  multiDirection = 1;
            }
            
            if ((loctoCount + locationsCount > 2 || locfromCount + locationsCount > 2) && (roundTrip === 0)) {
                multiDirection = 1;
            }
            
            $session.multiDirection = multiDirection;
            $session.roundTrip = roundTrip;
            
            $session.locations = locations;
            $session.locationsTo = locationsTo;
            $session.locationsFrom = locationsFrom;
            $session.dates = dates;
            
            // parse locations
            if (!multiDirection) {
                if (locationsFrom) $session.from = locationsFrom[0];
                if (locationsTo) $session.to = locationsTo[0];
                
                if (locations) {
                    loc0 = locations[0];
                    if (locationsCount > 1) loc1 = locations[1];
                }
                
                if ($session.to === undefined && $session.from === undefined && loc0 && loc1) {
                    $session.from = loc0;
                    $session.to = loc1;
                }
                
                if ($session.to === undefined && $session.from && loc1) {
                    if (loc1.stations_codes != $session.from.stations_codes) {
                        $session.to = loc1;
                    }
                }
                
                if ($session.from === undefined && $session.to && loc0) {
                    if (loc0.stations_codes != $session.to.stations_codes) {
                        $session.from = loc0;
                    }
                }
            }
            
            // parse dates
            if (dates) {
                if ($session.roundTrip == 0) {
                    if (datesCount == 1) {
                        date_result = handle_request(toPrettyString(dates[0]));
                        $session.date_relevant = date_result["relevant"];
                        $session.date_old = date_result["old"];
                        $session.date_list = date_result["dates"];
                        }
                    else if (datesCount > 1) $session.multiDate = 1;
                }
                
                if ($session.roundTrip == 1) {
                    date_result = handle_request(toPrettyString(dates[0]));
                    $session.date_relevant = date_result["relevant"];
                    $session.date_old = date_result["old"];
                    $session.date_list = date_result["dates"];
                    
                    if (datesCount == 2) {
                        datereturn_result = handle_request(toPrettyString(dates[1]));
                        $session.datereturn_relevant = datereturn_result["relevant"];
                        $session.datereturn_old = datereturn_result["old"];
                        $session.datereturn_list = datereturn_result["dates"];
                    }
                    else if (datesCount > 2) $session.multiDate = 1;
                    
                }
            }
            
            log($session);
            
        a: locations: {{ toPrettyString($session.locations) }}
        a: locationsTo: {{ toPrettyString($session.locationsTo) }}
        a: locationsFrom: {{  toPrettyString($session.locationsFrom) }}
        a: dates: {{ $session.dates }}
        
        a: multiDate: {{ $session.multiDate }}
        a: multiDirection: {{ $session.multiDirection }}
        a: roundTrip: {{ $session.roundTrip }}
        a: From: {{ toPrettyString($session.from) }}
        a: To: {{ toPrettyString($session.to) }}

                    
        if: $session.multiDate
            go!: /MultiDirection
        
        if: $session.multiDirection
            go!: /MultiDirection
            
        if: $session.date_list
            if: !$session.date_relevant
                a: Указана некорректная дата. Уточните, пожалуйста, свой запрос.
            elseif: $session.date_old
                a: Указанная дата уже прошла. Уточните, пожалуйста, свой запрос.
            elseif: $session.date_list
                script: $session.date = $session.date_list
            
        if: $session.datereturn_list
            if: !$session.datereturn_relevant
                a: Указана некорректная дата для поездки обратно. Уточните, пожалуйста, свой запрос.
            elseif: $session.datereturn_old
                a: Указанная дата для поездки обратно уже прошла. Уточните, пожалуйста, свой запрос.
            elseif: $session.datereturn_list
                script: $session.datereturn = $session.datereturn_list

        go!: /ChooseStationOptions
        
    state: ChooseStationOptions
        script:  
            var locFromDict = {};
            var locToDict = {};
            
            if ($session.from) locFromDict = get_location_options($session.from);
            if ($session.to) locToDict = get_location_options($session.to);
            
            $session.chooseFromOptions = locFromDict["chooseOptions"];
            $session.chooseToOptions = locToDict["chooseOptions"];
            
            if ($session.chooseFromOptions === 1) {
                $session.locfromNameOptions = locFromDict["locNameOptions"];
                $session.locfromNumberOptions = locFromDict["locNumberOptions"];
                $session.locfromSuggestOptions = locFromDict["locSuggestOptions"];
            }
            
            if ($session.chooseToOptions === 1) {
                $session.loctoNameOptions = locToDict["locNameOptions"];
                $session.loctoNumberOptions = locToDict["locNumberOptions"];
                $session.loctoSuggestOptions = locToDict["locSuggestOptions"];
            }

        if: $session.chooseFromOptions == 1
            script: 
                $session.retry = $session.retryParam
            go!: /ChooseStationOptionFrom
            
        if: $session.chooseToOptions == 1
            script: 
                $session.retry = $session.retryParam
            go!: /ChooseStationOptionTo
            
        if: $session.from
            if: $session.to
                if: $session.from.number == $session.to.number
                    go!: /EqualFromTo 
            
        go!: /FillSlots
        
            
    state: ChooseStationOptionFrom
        script: $session.retry = $session.retry - 1
        
        a: Уточните, пожалуйста, станцию отправления (введите номер станции из списка)

        script: 
            $session.optionsFrom = "";
            $session.optionsFromCount = $session.locfromSuggestOptions.length;
            
            for (var i=0;i<$session.optionsFromCount;i++) {
                $session.optionsFrom += i + " - " + $session.locfromSuggestOptions[i] + "\n";
            }
            
        a: {{ $session.optionsFrom }}
        
        state: GetStation
            q: @OptionNumber
            
            if: $parseTree._OptionNumber > $session.optionsFromCount - 1
                go!: /ChooseStationOptionFrom/nomatch
                
            if: $session.to
                if: $session.to.number == $session.locfromNumberOptions[$parseTree._OptionNumber]
                    a: Выбранная станция отправления совпадает со станцией назначения.
                    script: $session.samestationfrom = 1
                    go!: /ChooseStationOptionFrom/nomatch
            
            script: 
                $session.from.name = $session.locfromNameOptions[$parseTree._OptionNumber]
                $session.from.station_suggests = $session.locfromSuggestOptions[$parseTree._OptionNumber]
                $session.from.number = $session.locfromNumberOptions[$parseTree._OptionNumber]
            a: Вы выбрали станцию {{ $session.from.name }}, {{ $session.from.number }}
            
            if: $session.to
                if:  $session.to.number == ""
                    script: $session.retry = $session.retryParam
                    go!: /ChooseStationOptionTo
            go!: /FillSlots 
            
        state: nomatch
            event: noMatch
            
            if: !$session.samestationfrom
                a: Не могу найти подходящую станцию.
            
            if: $session.retry > 0
                go!: /ChooseStationOptionFrom
            else:
                go!: /nomatch
        
        
    state: ChooseStationOptionTo
        script: $session.retry = $session.retry - 1
        
        a: Уточните, пожалуйста, станцию назначения (введите номер станции из списка)
        script: 
            $session.optionsTo = "";
            $session.optionsToCount = $session.loctoSuggestOptions.length;
            
            for (var i=0;i<$session.optionsToCount;i++) {
                $session.optionsTo += i + " - " + $session.loctoSuggestOptions[i] + "\n";
            }
            
        a: {{ $session.optionsTo }}
        
        state: GetStation
            q: @OptionNumber
            
            if: $parseTree._OptionNumber > $session.optionsToCount - 1
                go!: /ChooseStationOptionTo/nomatch
                
            if: $session.from
                if: $session.from.number == $session.loctoNumberOptions[$parseTree._OptionNumber]
                    a: Выбранная станция назначения совпадает со станцией отправления.
                    script: $session.samestationto = 1
                    go!: /ChooseStationOptionTo/nomatch

            script: 
                $session.to.name = $session.loctoNameOptions[$parseTree._OptionNumber]
                $session.to.station_suggests = $session.loctoSuggestOptions[$parseTree._OptionNumber]
                $session.to.number = $session.loctoNumberOptions[$parseTree._OptionNumber]
            a: Вы выбрали станцию {{ $session.to.name }}, {{ $session.to.number }}
            go!: /FillSlots 
            
        state: nomatch
            event: noMatch
            
            if: !$session.samestationto
                a: Не могу найти подходящую станцию.
            
            if: $session.retry > 0
                go!: /ChooseStationOptionTo
            else:
                go!: /nomatch
                
    state: EqualFromTo
        a: Станция отправления и станция назначения совпадают.
        script:
            $session.from = (function () { return; })();
            $session.to = (function () { return; })();
            
        go!: /FillSlots
            
    
    state: FillSlots
        if: !$session.from
            script: $session.retry = $session.retryParam
            go!: /GetFrom
        
        if: !$session.to
            script: $session.retry = $session.retryParam
            go!: /GetTo
            
        if: $session.roundTrip == 1
            if: !$session.datereturn
                go!: /RoundTrip
            
        if: !$session.date
            script: $session.retry = $session.retryParam
            go!: /GetDate
        
        go!: /Result
    
    state: GetFrom
        script: $session.retry = $session.retry - 1
        random:
            a: Откуда поедете?
            a: Укажите, пожалуйста, пункт отправления
        
        state: get
            q: * @LocationNewDictionary *
            
            script:
                var newQuery = 0;
                
                // проверка на новый запрос в переспросе 
                newQuery = check_new_query($entities);
                $session.newQuery = newQuery;
                
            if: $session.newQuery
                a: Кажется, вы хотите подобрать билеты по другому направлению. Уточните, пожалуйста, ваш запрос.
                go!: /GetTrainSchedule
                
            if: $session.to
                if: $session.to.all_stations_from_same_city
                    if: $parseTree._LocationNewDictionary.all_stations_from_same_city
                        if: $parseTree._LocationNewDictionary.stations_codes == $session.to.stations_codes
                            a: Введенная станция отправления совпадает со станцией назначения.
                            if: $session.retry > 0
                                go!: /GetFrom
                            else: 
                                go!: /nomatch

            script: $session.from = $parseTree._LocationNewDictionary

            go!: /ChooseStationOptions
            
        state: newQuery
            q: * @Date *
            q: * @NewQueryWords *
            a: Кажется, вы хотите подобрать другие билеты. Уточните, пожалуйста, ваш запрос.
            go!: /GetTrainSchedule
            
        state:
            event: noMatch
            a: Не могу распознать город

            if: $session.retry > 0
                go!: /GetFrom
            else: 
                go!: /nomatch
        
    state: GetTo
        script: $session.retry = $session.retry - 1
        random:
            a: Куда собираетесь поехать?
            a: Введите, пожалуйста, пункт назначения
        
        state: get
            q: * @LocationNewDictionary *
            
            script:
                var newQuery = 0;
                
                // проверка на новый запрос в переспросе 
                newQuery = check_new_query($entities);
                $session.newQuery = newQuery;
                
            if: $session.newQuery
                a: Кажется, вы хотите подобрать билеты по другому направлению. Уточните, пожалуйста, ваш запрос.
                go!: /GetTrainSchedule
                
            if: $session.from
                if: $session.from.all_stations_from_same_city
                    if: $parseTree._LocationNewDictionary.all_stations_from_same_city
                        if: $parseTree._LocationNewDictionary.stations_codes == $session.from.stations_codes
                            a: Введенная станция назначения совпадает со станцией отправления.
                            if: $session.retry > 0
                                go!: /GetTo
                            else: 
                                go!: /nomatch

            script: $session.to = $parseTree._LocationNewDictionary

            go!: /ChooseStationOptions
            
        state: newQuery
            q: * @Date *
            q: * @NewQueryWords *
            a: Кажется, вы хотите подобрать другие билеты. Уточните, пожалуйста, ваш запрос.
            go!: /GetTrainSchedule
            
        state:
            event: noMatch
            a: Не могу распознать город прибытия

            if: $session.retry > 0
                go!: /GetTo
            else: 
                go!: /nomatch
            
    state: GetDate
        script: $session.retry = $session.retry - 1
        random:
            a: Укажите дату поездки
            a: На какой день нужны билеты?
        
        state: get
            q: * @Date *
            script: 
                var date_result = handle_request(toPrettyString($parseTree._Date));
                $session.date_relevant = date_result["relevant"];
                $session.date_old = date_result["old"];
                $session.date_list = date_result["dates"];
                
            if: !$session.date_relevant
                a: Указана некорректная дата. 
                go!: /GetDate/nomatch

            elseif: $session.date_old
                a: Указанная дата уже прошла. 
                go!: /GetDate/nomatch

            elseif: $session.date_list
                script: $session.date = $session.date_list

            go!: /FillSlots
            
        state: newQuery
            q: * @LocationNewDictionary *
            q: * @NewQueryWords *
            
            a: Кажется, вы хотите подобрать билеты по другому направлению. Уточните, пожалуйста, ваш запрос.
            go!: /GetTrainSchedule
        
        state: nomatch
            event: noMatch
            
            if: !$session.date_list
                a: Не могу распознать дату

            if: $session.retry > 0
                go!: /GetDate
            else: 
                go!: /nomatch
            
    state: MultiDirection
        if: $session.multiDate
            a: В запросе задано несколько дат, перевожу на оператора.^multiDate
        else:
            a: В запросе задано несколько направлений, перевожу на оператора.^multiDirection
        
    state: RoundTrip
        a: Запрос билетов туда-обратно.

        if: !$session.datereturn
            script: $session.retry = $session.retryParam
            go!: /RoundTrip/GetDate
        go!: /ChooseStationOptions
            
        state: GetDate
            script: $session.retry = $session.retry - 1
            a: Уточните, пожалуйста, дату поездки туда 
            
            state: get
                q: * @Date *
                script: 
                    var date_result = handle_request(toPrettyString($parseTree._Date));
                    $session.date_relevant = date_result["relevant"];
                    $session.date_old = date_result["old"];
                    $session.date_list = date_result["dates"];
                    
                if: !$session.date_relevant
                    a: Указана некорректная дата. 
                    go!: /RoundTrip/GetDate/nomatch
    
                elseif: $session.date_old
                    a: Указанная дата уже прошла. 
                    go!: /RoundTrip/GetDate/nomatch
    
                elseif: $session.date_list
                    script: $session.date = $session.date_list
                
                
                script: $session.retry = $session.retryParam
                go!: /RoundTrip/GetDateReturn
                
            state: nomatch
                event: noMatch
                if: !$session.date_list
                    a: Не могу распознать дату
    
                if: $session.retry > 0
                    go!: /RoundTrip/GetDate
                else: 
                    go!: /nomatch
                    
        state: GetDateReturn
            script: $session.retry = $session.retry - 1
            a: Уточните, пожалуйста, дату поездки обратно 
            
            state: get
                q: * @Date *
                script: 
                    var datereturn_result = handle_request(toPrettyString($parseTree._Date));
                    $session.datereturn_relevant = datereturn_result["relevant"];
                    $session.datereturn_old = datereturn_result["old"];
                    $session.datereturn_list = datereturn_result["dates"];
                    
                if: !$session.datereturn_relevant
                    a: Указана некорректная дата. 
                    go!: /RoundTrip/GetDateReturn/nomatch
    
                elseif: $session.datereturn_old
                    a: Указанная дата уже прошла. 
                    go!: /RoundTrip/GetDateReturn/nomatch
    
                elseif: $session.datereturn_list
                    script: $session.datereturn = $session.datereturn_list
                    
                go!: /ChooseStationOptions
                
            state: nomatch
                event: noMatch
                if: !$session.datereturn_list
                    a: Не могу распознать дату
    
                if: $session.retry > 0
                    go!: /RoundTrip/GetDateReturn
                else: 
                    go!: /nomatch
                    
        state: newQuery
            q: * @LocationNewDictionary *
            q: * @NewQueryWords *
            
            a: Кажется, вы хотите подобрать билеты по другому направлению. Уточните, пожалуйста, ваш запрос.
            go!: /GetTrainSchedule

        a: Date: {{ $session.date }} 
        a: DateReturn: {{ $session.datereturn }}
        

    state: OtherTransport
        q!: * (на чём|как) [можно] [было бы] (добраться|уехать|доехать) *
        q!: * (автобус*|автомоб*) *
        q!: * (самолет*|авиа)* *
        q!: * (электричк*|электричек*) *
        q!: * метро* *
        q!: * (машина|машины|машину|машине) *
        a: У меня есть информация только о поездах, посмотреть билеты по этому запросу?^otherTransport

        state: Exit
            q: * @No *
            a: До встречи!
                
        state: NewQuery
            q: * @Yes *
            go!: /GetTrainSchedule


    state: Troubles
        q!: * не (могу|можем|смог|смогла|смогли) *
        q!: * не (получилось|получается|вышло|выходит) *
        q!: * не (ясно|понятно|понимаю|очевидно) *
        q!: * (непонятно|неясно|объясните|поясните|разъясните|объяснить|пояснить|разъяснить) *
        q!: * не (ищет|находит|нахожу|вижу|наблюдаю|видел|находил) *
        q!: * (скидки|скидка|льгот|льгота|льготы|скидос|скидок) *
        q!: * (написано|написали|позвонили|звоню|позвонить|позвоните|созвонимся|созвониться|дозвониться) *
        q!: * (услуг*|сервис*) *
        a: Проблемные вопросы обсудите с оператором.^troubles


    state: OtherQuestions
        q!: * [по] (права*|удостоверен*|паспорт*|свидетельств*|документ*)
        q!: * (задержка|задерживается|задержался|задержится|задержите) *
        q!: * стыковк *
        q!: * (по всем дням|как ходит|по каким дням|в какие дни) * [поезд] * 
        q!: * сколько (часов|времени) [будет ехать|будет идти|ехать|идет|едет] *
        q!: * (во сколько|воскольк*) * (прибудет|прибывает|прибыл|приедет|приезжает|приехал|доезжает|доехал|доедет) *
        q!: * (в какое время|когда) * (прибудет|прибывает|прибыл|приедет|приезжает|приехал|доезжает|доехал|доедет) *
        q!: * (ко скольки|в каком часу) * (прибудет|прибывает|прибыл|приедет|приезжает|приехал|доезжает|доехал|доедет) *
        q!: * когда (начнется|начинается|старт) продаж* [билетов] *
        q!: * [точное] время (прибытия|отправления) *
        q!: * сколько [времени|по времени] [длится|идет] (пересадк*|остановк*) *
        q!: * с [какими|какой] (пересадками|пересадкой) *
        q!: * (есть|где|будет) пересадка *
        q!: * (прицепн*|дополнительн*) вагон* *
        q!: * на (какой|какие) (путь|пути) *
        q!: * (нумерация|нумерацией|нумерации) *
        q!: * маршрут поезда *
        q!: * какие (города|станции|остановки) (проезжает поезд|на маршруте) *
        q!: * (где|сколько) (стоит|останавливается) поезд *
        q!: * (почему|зачем|по какой причине|по какому праву|для чего|это что|что это такое|что такое) *
        q!: * в (январе|феврале|марте|апреле|мае|июне|июле|августе|сентябре|октябре|ноябре|декабре) *
        q!: * на (январь|февраль|март|апрель|май|июнь|июль|август|сентябрь|октябрь|ноябрь|декабрь) *
        q!: * на (следующий месяц|следующий год|следуюущую неделю|следущий месяц|следущий год|следуущую неделю) *
        q!: * (собак|собака|собаки|собаку|пёс|пса) *
        q!: * (кот|кота|коты|коту|кошка|кошки|кошку|кошек) *
        q!: * (животное|животные|животных|живность|живности) *
        q!: * (требования|правила|провоз|провозки|перевоз|перевозки|пронос|перевозить|проносить) *
        # ToDo(mel-lain): ближайшие нужно обрабатывать отдельно при наличии нормального парсера дат и диапазонов дат
        #q!: * ближайший (поезд|рейс) *
        #q!: * ближайш(ее|ие|ую|ий) (время|час|часы|дни|недели|месяцы|месяц|год|годы|лето|зиму|весну|осень|вариант) *
        q!: * ближайш(ее|ие|ую|ий) (недели|месяцы|месяц|год|годы|лето|зиму|весну|осень) *
        q!: * (как можно быстрее|срочно|горит) *
        q!: * (на [вашем] сайте|на [ваш] сайт|у [вас] [на] сайте) *
        q!: * (не ищет|не нахожу|не могу найти|не получается найти) *
        q!: * (каждый|каждые|каждую|каждой) (день|выходные|понедельник|вторник|среда|среду) *
        q!: * (каждый|каждые|каждую|каждой) (четверг|пятница|пятницу|суббота|субботу|воскресенье) *
        q!: * по (понедельникам|вторникам|средам|четвергам|пятницам|субботам) *
        q!: * по (воскресеньям|воскресениям) *
        q!: * по (четным|нечетным|не четным) дням *
        q!: * (нужно ли|надо ли|должен ли|стоит ли|обязан ли|требуется ли|положено ли|необходимо ли) *
        q!: * (бронь|броня|брони|бронирование|бронировать|бронировал|бронирирую|бронируйте|бронируй|бронил) *
        q!: * (забронь|заброни|забронирование|забронировать|забронировал|забронирирую|забронируйте|забронируй|забронил) *
        q!: * (по каким числам|по каким дням|в какие дни|с какой периодичностью|как часто|насколько часто) *
        q!: * (в какие числа|в каких числах|по каким дням|с какой регулярность|регулярно|регулярный) *
        q!: * (окна|против движения|спиной|лицом|туалет*|боковое|боковушка|боковушку|боковушки|боковые) *
        a: Не могу подсказать, перевожу на оператора^otherQuestions

    state: Result
        a: Откуда: {{ $session.from.name }}, {{ $session.from.number }}
        a: Куда: {{ $session.to.name }}, {{ $session.to.number }}
        a: Когда: {{ toPrettyString($session.date) }}
        
        if: $session.roundTrip
            a: Обратная поездка
            a: Откуда: {{ $session.to.name }}, {{ $session.to.number }}
            a: Куда: {{ $session.from.name }}, {{ $session.from.number }}
            a: Когда: {{ toPrettyString($session.datereturn) }}
            
        if: $session.class
            a: Класс билетов: {{ $session.class }}
            
        a: Все правильно?
        
        state: Yes
            q: (@Yes [спасибо] [верно|правильно|ок] | верно | правильно | ок)
            a: Хорошо! Сейчас посмотрю билеты.
            a: Запрос в api.
            go!: /Result/Yes/Query
            
            state: Query
                script:
                    var response;
                    var result;
                    
                    var filters = {};
                    
                    // фильтры класс билетов
                    var class_list = []; 
                    
                    if ($session.reserved_ticket) class_list.push("plazcard");
                    if ($session.regular_ticket) class_list.push("coupe");
                    if ($session.lux_ticket) class_list.push("lux");
                    
                    if (class_list.length > 0) filters["class"] = class_list;
                    
                    // фильтры время
                    var min_time;
                    var max_time;
                    
                    if ($session.morning_time) {
                        min_time = "05:00";
                        max_time = "11:00";
                        }
                    if ($session.day_time) {
                        if (!min_time) min_time = "11:00";
                        max_time = "17:00";
                        }
                    if ($session.evening_time) {
                        if (!min_time) min_time = "17:00";
                        max_time = "22:00";
                        }
                    if ($session.night_time) {
                        min_time = "22:00";
                        if (!max_time) max_time = "05:00";
                        }
                    if (min_time && max_time) {
                        filters["min_time"] = min_time;
                        filters["max_time"] = max_time;
                    }
                    
                    
                    response = getTicketsResult($session.from.number, $session.to.number, $session.date);
                    if (response) result = process_results(response, filters);
                    
                    $session.result = result;
                    $session.response = response;
                    
                    if ($session.roundTrip) {
                        var response_return = getTicketsResult($session.to.number, $session.from.number, $session.datereturn);
                        var result_return = process_results(response_return, filters);
                        $session.result_return = result_return;
                        $session.response_return = response_return;
                    }
                    
                    $session.filters = filters;
                    
                    // $session.result = "Tickets data";
                
                if: $session.result
                    a: Filters: {{ toPrettyString($session.filters) }} 
                    # a: Response {{ toPrettyString($session.response) }}
                    a: Result: {{ toPrettyString($session.result) }} 
                    
                    if: $session.result.price
                        script: 
                            var params;
                            var params_list = [];
                            
                            var child_param = 0.6;
                            
                            var class_map = {
                                "coupe": "купе",
                                "plazcard": "плацкарт",
                                "lux": "люкс"
                            }
                            
                            if ($session.filters.class) {
                                $session.printClass = 1;
                                params_list.push("класс билетов: " + class_map[$session.result.type]);
                            }
                            if ($session.filters.min_time) {
                                $session.printTime = 1;
                                params_list.push("время отправления: " + $session.result.departureTime);
                            }
                            
                            if (params_list.length > 0) params = " (" + params_list.join(", ") + ")";
                            
                            $session.additional_params = params;
                            
                            if ($session.child_ticket) $session.additional_price = " (стоимость детского билета от " + Math.ceil(child_param * $session.result.price) + " рублей)"; 
                            
                        a: Билеты есть в наличии{{ $session.additional_params }}, стоимость от {{ $session.result.price }} рублей{{$session.additional_price}}. Посмотреть билеты можно по ссылке: {{ $session.result.url }}
                        
                        if: $session.result_return
                            a: Обратная поездка
                            a: Result return: {{ toPrettyString($session.result_return) }} 
                            
                            if: $session.result_return.price
                                a: Билеты есть в наличии, стоимость от {{ $session.result_return.price }} рублей. Посмотреть билеты можно по ссылке: {{ $session.result_return.url }}
                            else:
                                a: Для указанных параметров билеты не найдены.
                        go!: /Result/Yes/moreQueries
                    else:
                        a: Для указанных параметров билеты не найдены.
                        go!: /Result/Yes/moreQueries
                else:
                    a: Не могу найти информацию о билетах.
                
            state: moreQueries   
                a: Хотите посмотреть другие билеты?
            
                state: Exit
                    q: * @No *
                    a: До встречи!
                    
                state: NewQuery
                    q: (@Yes [спасибо | пожалуйста] [хочу] | хочу | давай[те])
                    a: Укажите, пожалуйста, откуда, куда и на какую дату искать билеты.
            
        state: No
            q: * @No *
            a: Уточните, пожалуйста, запрос.
            go!: /GetTrainSchedule
            
    state: hello 
        q!: (привет|приветствую|приветики)
        q!: (здравствуйте|здраствуйте|здрасьте|здрасте)
        q!: (здорово|здоров|дарова|даров)
        q!: (добрый|доброго)
        q!: (добрый день|доброго дня|день добрый)
        q!: (добрый вечер|доброго вечера|вечер добрый)
        q!: (доброе утро|доброго утра|утро доброе)
        q!: (доброй ночи)
        a: Привет! Могу помочь купить билет на поезд. Что вас интересует?
        
    state: goodbye
        intent!: /Goodbye
        a: До встречи!
        
    state: newQuery
        q!: * @NewQueryWords * 
        a: Кажется, вы хотите подобрать другие билеты. Уточните, пожалуйста, ваш новый запрос.
        go!: /GetTrainSchedule
    
    state: nomatch
       event!: noMatch
       a: {{ toPrettyString($context.entities) }}
       
       a: Не понял, перевожу запрос на оператора.^noMatch

