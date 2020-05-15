theme: /railwaySearchAns


    state: railwayResults
        if: $session.category
            if: $session.adults
                a: Стоимость {{getTicketNumb4User($session.adults)}} {{$session.category}} {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} - от {{$session.railwayPrice}} руб. \nВсе варианты по ссылке: {{$session.urlRailway}}
            else:
                a: Стоимость билета {{$session.category}} {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} - от {{$session.railwayPrice}} руб. \nВсе варианты по ссылке: {{$session.urlRailway}}
        else:
            if: $session.adults
                a: Стоимость {{getTicketNumb4User($session.adults)}} {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} - от {{$session.railwayPrice}} руб. \nВсе варианты по ссылке: {{$session.urlRailway}}
            else:
                a: Стоимость билета {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} - от {{$session.railwayPrice}} руб. \nВсе варианты по ссылке: {{$session.urlRailway}}
        go: /railwaySearchAns/anotherSearch



    state: railwayRoundtripResults
        if: $session.adults
            a: Маршрут {{$session.stationF1}} - {{$session.stationT1}} - {{$session.stationT2}} \nСтоимость {{getTicketNumb4User($session.adults)}} - от {{$session.railwayPrice}} руб. \nВсе варианты на {{$session.dates4User1}}: \n{{$session.urlRailway1}} \nВсе варианты на {{$session.dates4User2}}: \n{{$session.urlRailway2}}
        else:
            a: Маршрут {{$session.stationF1}} - {{$session.stationT1}} - {{$session.stationT2}} \nСтоимость билетов - от {{$session.railwayPrice}} руб. \nВсе варианты на {{$session.dates4User1}}: \n{{$session.urlRailway1}} \nВсе варианты на {{$session.dates4User2}}: \n{{$session.urlRailway2}}



    state: railwayResultsNoPrice
        if: $session.category
            if: $session.adults
                a: Билеты {{$session.category}} {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} можно купить по ссылке: {{$session.urlRailway}}
            else:
                a: Купить билет {{$session.category}} {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} можно по ссылке: {{$session.urlRailway}}
        else:
            if: $session.adults
                a: Билеты {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} можно купить по ссылке: {{$session.urlRailway}}
            else:
                a: Купить билет {{$session.stationF}} - {{$session.stationT}} на {{$session.dates4User}} можно по ссылке: {{$session.urlRailway}}
        go: /railwaySearchAns/anotherSearch



    state: railwayRoundtripResultsNoPrice
        a: Билеты {{$session.stationF1}} - {{$session.stationT1}} - {{$session.stationT2}} на {{$session.dates4User1}}: \n{{$session.urlRailway1}} \nВсе варианты на {{$session.dates4User2}}: \n{{$session.urlRailway2}}



    state: anotherSearch
        state: anotherDateSearch
            # 4EX: 21 декабря вылет
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] ($dateDig/$dateLetters/$thatDay) [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] ($dateDig/$dateLetters/$thatDay) $departure [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] ($dateDig/$dateLetters/$thatDay) [$oneWord] $depart [$markQuestion]
            # 4EX: 28 12 18 сколько
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] ($dateDig/$dateLetters/$thatDay) $howMuch [$markQuestion]
            q: [$beginningWords] [если/есле/еси/есе/еле/елси] [на] ($dateDig/$dateLetters/$thatDay) $howMuch [$oneWord] $cost [$markQuestion]
            # 4EX: 10 февраля есть
            q: [$beginningWords] ($dateDig/$dateLetters/$thatDay) [$exist] [$markQuestion]
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                go!: /railwaySearchFunc/railwaySearch



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
            go!: /railwaySearchFunc/railwaySearch



    state: searchError
        if: $session.urlRailway
            a: Что-то пошло не так, и я не смог найти билеты. Поискать самостоятельно вы можете по этой ссылке: {{$session.urlRailway}}
        else:
            a: Что-то пошло не так, и я не смог найти билеты. Попробуйте поискать самостоятельно на нашем сайте: https://www.ozon.travel/railway.



    state: searchNoTickets
        a: Не могу найти билеты на эту дату. Возможно, их еще не начали продавать. Продажи начинаются: \nРоссия: за 90 дней до поездки, кроме Мск-Спб и обратно (там за 120 дней), СНГ - за 45 дней, заграница - за 30 дней.



    state: tooLate
        if: $session.dates
            a: Этот день остался в прошлом. Попробуйте еще раз!
            go: /railwaySearchAns/anotherSearch
        elseif: $session.dates1 && $session.dates2
            a: Эти дни остались в прошлом. Попробуйте еще раз!
            go: /railwaySearchRoundtrip/roundtripNoInfo/tripCityTo/tripCityFrom/tripDates
        else:
            go!: /railwaySearchAns/searchError



    state: limitedTicketsAns
        a: По правилам РЖД, за один раз можно забронировать максимум 4 взрослых билета.

