theme: /aviaSearchAns


    state: aviaResults
        script:
            $temp.dates4User = getDate4User($session.dates);
            $temp.fromTime4User = getTime4User($session.fromTime);
        if: $session.adults
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена {{getTicketNumb4User($session.adults)}} с багажом - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена {{getTicketNumb4User($session.adults)}} - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
        else:
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена билета c багажом - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена билета - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
        go: /aviaSearchAns/anotherSearch



    state: aviaRoundtripResults
        script:
            $temp.dates4User1 = getDate4User($session.dates1);
            $temp.dates4User2 = getDate4User($session.dates2);
            $temp.fromTime4User1 = getTime4User($session.fromTime1);
            $temp.fromTime4User2 = getTime4User($session.fromTime2);
        if: $session.adults
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена {{getTicketNumb4User($session.adults)}} с багажом - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена {{getTicketNumb4User($session.adults)}} - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
        else:
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена билетов с багажом - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена перелета - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}



    state: aviaDirectRoundtripResults
        script:
            $temp.dates4User1 = getDate4User($session.dates1);
            $temp.dates4User2 = getDate4User($session.dates2);
            $temp.fromTime4User1 = getTime4User($session.fromTime1);
            $temp.fromTime4User2 = getTime4User($session.fromTime2);
        if: $session.adults
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена {{getTicketNumb4User($session.adults)}} без пересадок с багажом - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена {{getTicketNumb4User($session.adults)}} без пересадок - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
        else:
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена билетов без пересадок с багажом - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}} - {{$session.cityF}} {{$session.airportF}}. \nМинимальная цена билетов без пересадок - {{$session.prices}} руб. \nТуда: {{$temp.dates4User1}} в {{$temp.fromTime4User1}}. \nОбратно: {{$temp.dates4User2}} в {{$temp.fromTime4User2}}. \nРезультаты поиска здесь: {{$session.urlOzon}}



    state: aviaDirectResults
        script:
            $temp.dates4User = getDate4User($session.dates);
            $temp.fromTime4User = getTime4User($session.fromTime);
        if: $session.adults
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена {{getTicketNumb4User($session.adults)}} без пересадок c багажом - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена {{getTicketNumb4User($session.adults)}} без пересадок - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
        else:
            if: $session.baggage
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена прямых билетов с багажом - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
            else:
                a: Маршрут {{$session.cityF}} {{$session.airportF}} - {{$session.cityT}} {{$session.airportT}}.\nМинимальная цена без пересадок - {{$session.prices}} руб. \nВылет {{$temp.dates4User}} в {{$temp.fromTime4User}}. \nЦены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}



    state: anotherSearch
        state: anotherDateSearch
            # 4EX: 21 декабря вылет
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] {[$morning/$evening] ($dateDig/$dateLetters/$thatDay)} [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] {[$morning/$evening] ($dateDig/$dateLetters/$thatDay)} $departure [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] {[$morning/$evening] ($dateDig/$dateLetters/$thatDay)} [$oneWord] $depart [$markQuestion]
            # 4EX: 28 12 18 сколько
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] {[$morning/$evening] ($dateDig/$dateLetters/$thatDay)} $howMuch [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] {[$morning/$evening] ($dateDig/$dateLetters/$thatDay)} $howMuch [$oneWord] $cost [$markQuestion]
            # 4EX: 10 февраля есть
            q: [$beginningWords] ($dateDig/$dateLetters/$thatDay) [$exist] [$markQuestion]
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                go!: /aviaSearchFunc/aviaSearch



        state: anotherNumberSearch
            # 4EX: a если 2?
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] $numberDate [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] $numberDate $departure [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] $numberDate [$oneWord] $depart [$markQuestion]
            # 4EX: a 2 сколько?
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] $numberDate $howMuch [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] $numberDate $howMuch [$oneWord] $cost [$markQuestion]
            # 4EX: 10 февраля есть
            q: [$beginningWords] $numberDate [$exist] [$markQuestion]
            script:
                var dates = $session.dates;
                var dates = dates.split('-');
                if ($parseTree._numberDate.match(/0\d|\d{2}/)) {
                    dates[2] = $parseTree._numberDate;
                } else {
                    dates[2] = '0' + $parseTree._numberDate;
                }
                $session.dates = dates.join('-');
                $temp.begin = true;
            go!: /aviaSearchFunc/aviaSearch



        state: isThereAnyCheaper
            # 4EX: Дешевле нет
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ((нет/неиу/нету) [ли])} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ((нет/неиу/нету) [ли])} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ((нет/неиу/нету) [ли])} [$markQuestion]

            q: [$beginningWords] (нет/неиу/нету) [ли] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {((нет/неиу/нету) [ли]) ($cheap/$cheaper/$cheapest)} [$markQuestion]

            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ($exist/ест)} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ($exist/ест)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ($exist/ест)} [$markQuestion]

            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



        state: cheaperOnMorningEvening
            # 4EX:На вечером нету ещё какой-нибудь дешевле билет
            q: [$beginningWords] [на] ($morning/$evening) (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [$markQuestion]
            q: [$beginningWords] [на] ($morning/$evening) [$ticket/$airplaneTicket/$flight] (нет/неиу/нету/$exist/ест) * [$cheap/$cheaper/$cheapest] [$markQuestion]
            q: [$beginningWords] [на] ($morning/$evening) [$ticket/$airplaneTicket/$flight] [$cheap/$cheaper/$cheapest] * (нет/неиу/нету/$exist/ест) [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [на] ($morning/$evening) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] (нет/неиу/нету/$exist/ест) * [$cheap/$cheaper/$cheapest] [на] ($morning/$evening) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$cheap/$cheaper/$cheapest] * (нет/неиу/нету/$exist/ест) [на] ($morning/$evening) [$markQuestion]
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: ($parseTree._cheap || $parseTree._cheaper || $parseTree._cheapest)
                    a: Этот вариант самый дешевый на указанное число. Сейчас поищу для вас самый дешевый вариант на {{$session.dayTime}}.
                go!: /aviaSearchFunc/aviaSearch



        state: cheaperOntNeighborDates
            # 4EX: Есть подешевле, на соседние даты?
            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету)} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] (нет/неиу/нету)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) (нет/неиу/нету)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ((на/в) {(соседн*/ближайш*/близк*) дат*}) ли ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету) ли [$ticket/$airplaneTicket/$flight] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ((на/в) {(соседн*/ближайш*/близк*) дат*}) ли [$ticket/$airplaneTicket/$flight] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] (нет/неиу/нету) ли [$ticket/$airplaneTicket/$flight] ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] (нет/неиу/нету) ((на/в) {(соседн*/ближайш*/близк*) дат*}) ли ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] (нет/неиу/нету) ли ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] (нет/неиу/нету) ли ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) ($exist/ест)} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($exist/ест)} [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ($exist/ест)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ($exist/ест)} [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ($exist/ест)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] ($exist/ест)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($exist/ест)} [$markQuestion]
            q: [$beginningWords] {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ($exist/ест)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ($exist/ест)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) {($cheap/$cheaper/$cheapest) ($exist/ест)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($exist/ест)} [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] {($cheap/$cheaper/$cheapest) ($exist/ест)} ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible ((на/в) {(соседн*/ближайш*/близк*) дат*}) [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible ((на/в) {(соседн*/ближайш*/близк*) дат*}) [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$ticket/$airplaneTicket/$flight] [$oneWord] ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]

            q: [$beginningWords] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible ((на/в) {(соседн*/ближайш*/близк*) дат*}) [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$oneWord] ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ((на/в) {(соседн*/ближайш*/близк*) дат*}) ($cheap/$cheaper/$cheapest) [$markQuestion]
            q: [$beginningWords] [$ticket/$airplaneTicket/$flight] [$how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]] [$buy/$payInf] [$oneWord] ($cheap/$cheaper/$cheapest) ((на/в) {(соседн*/ближайш*/близк*) дат*}) [$markQuestion]
            if: $session.dates
                go!: /calendarAviaFunc/neighborDates
            else:
                go!: /aviaSearchAns/isThereAnyCheaper



        state: begEndOfMonth
            # 4EX: Ещё? Найдите пожалуйста дешевле билет конце Августа без разница какой день?
            q: * ($beginning/$end) $months *
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                go!: /calendarAviaFunc/monthCheapest



        state: cheaperFromUntil
            # 4EX: Извините ,до 10 июля,есть билеты по дешевле
            q: * [(с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate)] * до ($dateDig::dateDig2/$dateLetters::dateLetters2) * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [$markQuestion]
            q: * [(с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate)] * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * до ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * [(с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate)] * до ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * [(с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate)] * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * до ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * [(с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate)] * до ($dateDig::dateDig2/$dateLetters::dateLetters2) *  {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [$markQuestion]

            q: * (с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [до ($dateDig::dateDig2/$dateLetters::dateLetters2)] * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [$markQuestion]
            q: * (с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * [до ($dateDig::dateDig2/$dateLetters::dateLetters2)] [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * (с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [до ($dateDig::dateDig2/$dateLetters::dateLetters2)] [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * (с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} * [до ($dateDig::dateDig2/$dateLetters::dateLetters2)] [$markQuestion]
            q: * (нет/неиу/нету/$exist/ест) * (с/после) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [до ($dateDig::dateDig2/$dateLetters::dateLetters2)] *  {[$cheap/$cheaper/$cheapest] [$ticket/$airplaneTicket/$flight]} [$markQuestion]
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $session.urlOzon = undefined;
                    $temp.begin = undefined;
                go!: /calendarAviaFunc/fromUntilCheapest



    state: aviaSearchDirectError
        script:
            if ($session.urlOzon) {
                $reactions.answer('По моим данным, по этому маршруту нет билетов без пересадок. Поискать самостоятельно вы можете по этой ссылке: ' + $session.urlOzon);
            } else {
                $reactions.answer('Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel.');
            }



    state: aviaSearchBaggError
        script:
            if ($session.urlOzon) {
                $reactions.answer('По моим данным, по этому маршруту нет билетов с багажом. Поискать самостоятельно вы можете по этой ссылке: ' + $session.urlOzon);
            } else {
                $reactions.answer('Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel.');
            }



    state: aviaSearchDayTimeBaggError
        script:
            if ($session.urlOzon) {
                $reactions.answer('По моим данным, по этому маршруту на {{$session.dayTime}} нет билетов с багажом. Поискать самостоятельно вы можете по этой ссылке: ' + $session.urlOzon);
            } else {
                $reactions.answer('Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel.');
            }



    state: aviaSearchDayTimeError
        script:
            if ($session.urlOzon) {
                $reactions.answer('По моим данным, по этому маршруту нет билетов на {{$session.dayTime}}. Поискать самостоятельно вы можете по этой ссылке: ' + $session.urlOzon);
            } else {
                $reactions.answer('Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel.');
            }



    state: aviaSearchError
        if: $session.urlOzon
            a: Что-то пошло не так, и я не смог найти билеты. Поискать самостоятельно вы можете по этой ссылке: {{$session.urlOzon}}
        else:
            a: Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel.



    state: tooLate
        if: $session.dates
            a: Этот день остался в прошлом. Попробуйте еще раз!
            go: /aviaSearchAns/anotherSearch
        elseif: $session.dates1 && $session.dates2
            a: Эти дни остались в прошлом. Попробуйте еще раз!
            go: /aviaSearchRoundtrip/roundtripNoInfo/tripCityTo/tripCityFrom/tripDates



    state: noResNeighborDates
        a: Я проверил все варианты, но более дешевых билетов по этому направлению на соседние даты нет.



    state: noResFromUntilDates
        a: Я проверил все варианты, но не нашел подходящих билетов по этому направлению на выбранные даты.



    state: calendarAviaResult
        a: Я нашел для вас билет на {{getDate4User($session.dates)}} за {{$session.prices}} руб. Цены и количество билетов постоянно меняются, актуальные результаты смотрите по ссылке: {{$session.urlOzon}}
        if: $session.otherCalendarOpt
            if: $session.monthCheapest
                a: Есть и другие даты с такой же ценой. Хотите посмотреть?
                go: /aviaSearchAns/calendarShowMore/yesShowMoreCalendar
            else:
                go!: /aviaSearchAns/calendarShowMore



    state: calendarShowMore
        a: Показать еще?



        state: yesShowMoreCalendar
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
            go!: /calendarAviaFunc/moreCalenarOptions











