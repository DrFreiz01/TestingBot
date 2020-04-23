theme: /roundtripProcessing


    state: roundtripFullInfo
        # жд / авиа
        if: $parseTree._railwayTicket || $parseTree._railwayAll || ($session.landingTheme == 'ЖД')
            script:
                $session.search = 'railway';
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            if: $session.search == 'railway'
                go!: /railwaySearchFunc/varsCleaning_DYN
            else:
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
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                    if (!$parseTree._doubleDate && !$parseTree._dateDig2 && !$parseTree._dateLetters2) {
                        $session.dates2 = $session.dates1;
                    }
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/railwaySearchRoundtrip
                else:
                    go!: /aviaSearchFunc/aviaSearchRoundtrip



    state: roundtripNoInfo
        # жд / авиа
        if: $parseTree._railwayTicket || $parseTree._railwayAll || ($session.landingTheme == 'ЖД')
            script:
                $session.search = 'railway';
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            if: $session.search == 'railway'
                go!: /railwaySearchFunc/varsCleaning_DYN
            else:
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
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                a: Уточните, пожалуйста, направление вашей поездки.



        state: tripCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
            q: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
            q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: $session.from && $session.dest && $session.dates1 && $session.dates2
                    if: $session.search == 'railway'
                        go!: /railwaySearchFunc/railwaySearchRoundtrip
                    else:
                        go!: /aviaSearchFunc/aviaSearchRoundtrip
                elseif: $session.from && $session.dest
                    go!: /roundtripProcessing/roundtripNoInfo/tripCityTo/tripCityFrom
                else:
                    a: Откуда вы едете?



            state: tripCityFrom
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
                q: [$from] [$cityPreName] $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode *
                # собираем переменные
                if: $temp.begin == undefined
                    script:
                        $temp.begin = true;
                        $client.executeState = $context.currentState;
                    if: $session.search == 'railway'
                        go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                    else:
                        go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                else:
                    script:
                        $temp.begin = undefined;
                    if: $session.from && $session.dates1 && $session.dates2
                        if: $session.search == 'railway'
                            go!: /railwaySearchFunc/railwaySearchRoundtrip
                        else:
                            go!: /aviaSearchFunc/aviaSearchRoundtrip
                    else:
                        a: На какие числа планируете поездку?



                state: tripDates
                    # 4EX: 15 и 20 января
                    q: * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$cheap/$cheaper/$cheapest] * [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] * [$cheap/$cheaper/$cheapest] * [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$cheap/$cheaper/$cheapest] *
                    # 4EX: 15 января по 20
                    q: * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig1/$dateLetters::dateLetters1) [$oneWord] [$oneWord] [на] $numberDate *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$cheap/$cheaper/$cheapest] * [$oneWord] [$oneWord] [на] $numberDate *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) [$oneWord] * [$cheap/$cheaper/$cheapest] * [$oneWord] [на] $numberDate *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) [$oneWord] [$oneWord] * [$cheap/$cheaper/$cheapest] * [на] $numberDate *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) [$oneWord] [$oneWord] [на] * [$cheap/$cheaper/$cheapest] * $numberDate *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) [$oneWord] [$oneWord] [на] $numberDate * [$cheap/$cheaper/$cheapest] *
                    q: * $doubleDate * [$cheap/$cheaper/$cheapest] *
                    q: * [$cheap/$cheaper/$cheapest] * $doubleDate *
                    q: * ($cheap/$cheaper/$cheapest) *
                    # 4EX: 25 февраля
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) *
                    # собираем переменные
                    if: $temp.begin == undefined
                        script:
                            $temp.begin = true;
                            $client.executeState = $context.currentState;
                        if: $session.search == 'railway'
                            go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                        else:
                            go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                    else:
                        script:
                            $temp.begin = undefined;
                        if: $session.dates1 && $session.dates2
                            if: $session.search == 'railway'
                                go!: /railwaySearchFunc/railwaySearchRoundtrip
                            else:
                                go!: /aviaSearchFunc/aviaSearchRoundtrip
                        else:
                            if: $session.dates1 && !$session.dates2
                                a: А обратно?
                            else:
                                if: $session.search == 'railway'
                                    go!: /railwaySearchFunc/railwaySearchRoundtrip
                                else:
                                    if: $session.search == 'railway'
                                        a: На какие числа планируете поездку?
                                        go: /roundtripProcessing/roundtripNoInfo/tripCityTo/tripCityFrom
                                    else:
                                        a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



                    state: tripDatesBack
                        q: * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                        # собираем переменные
                        if: $temp.begin == undefined
                            script:
                                $temp.begin = true;
                                $client.executeState = $context.currentState;
                            if: $session.search == 'railway'
                                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                            else:
                                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                        else:
                            script:
                                $temp.begin = undefined;
                            if: $session.search == 'railway'
                                go!: /railwaySearchFunc/railwaySearchRoundtrip
                            else:
                                go!: /aviaSearchFunc/aviaSearchRoundtrip



    state: roundtripFromDest
        # жд / авиа
        if: $parseTree._railwayTicket || $parseTree._railwayAll || ($session.landingTheme == 'ЖД')
            script:
                $session.search = 'railway';
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            if: $session.search == 'railway'
                go!: /railwaySearchFunc/varsCleaning_DYN
            else:
                go!: /aviaSearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            go!: /roundtripProcessing/roundtripNoInfo/tripCityTo/tripCityFrom



    state: roundtripDestDates
        # жд / авиа
        if: $parseTree._railwayTicket || $parseTree._railwayAll || ($session.landingTheme == 'ЖД')
            script:
                $session.search = 'railway';
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            if: $session.search == 'railway'
                go!: /railwaySearchFunc/varsCleaning_DYN
            else:
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
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                a: Откуда вы едете?



        state: tripCityFrom
            q: [$from] [$cityPreName] $iataAndRailway::fromCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
            q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode *
            q: [$from] [$cityPreName] $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate *
            q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate * [$from] [$cityPreName] $iataAndRailway::fromCode *
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: $session.from && $session.dest && $session.dates1 && $session.dates2
                    if: $session.search == 'railway'
                        go!: /railwaySearchFunc/railwaySearchRoundtrip
                    else:
                        go!: /aviaSearchFunc/aviaSearchRoundtrip
                else:
                    if: $session.search == 'railway'
                        go!: /railwaySearchAns/searchError
                    else:
                        go!: /aviaSearchAns/aviaSearchError



    state: roundtripDates
        # жд / авиа
        if: $parseTree._railwayTicket || $parseTree._railwayAll || ($session.landingTheme == 'ЖД')
            script:
                $session.search = 'railway';
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            if: $session.search == 'railway'
                go!: /railwaySearchFunc/varsCleaning_DYN
            else:
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
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                if: $session.from && $session.dest && $session.dates1 && $session.dates2
                    go!: /aviaSearchFunc/aviaSearchRoundtrip
                else:
                    a: Уточните, пожалуйста, направление вашей поездки.



        state: tripCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
            q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate *
            q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                if: $session.search == 'railway'
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: $session.from && $session.dest && $session.dates1 && $session.dates2
                    go!: /roundtripProcessing/roundtripDates/tripCityTo/tripCityFrom
                else:
                    a: Откуда вы едете?



            state: tripCityFrom
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
                q: [$from] [$cityPreName] $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode *
                q: [$from] [$cityPreName] $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate *
                q: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $numberDate * [$from] [$cityPreName] $iataAndRailway::fromCode *
                # собираем переменные
                if: $temp.begin == undefined
                    script:
                        $temp.begin = true;
                        $client.executeState = $context.currentState;
                    if: $session.search == 'railway'
                        go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                    else:
                        go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                else:
                    script:
                        $temp.begin = undefined;
                    if: $session.from && $session.dest && $session.dates1 && $session.dates2
                        if: $session.search == 'railway'
                            go!: /railwaySearchFunc/railwaySearchRoundtrip
                        else:
                            go!: /aviaSearchFunc/aviaSearchRoundtrip
                    else:
                        if: $session.search == 'railway'
                            go!: /railwaySearchAns/searchError
                        else:
                            go!: /aviaSearchAns/aviaSearchError
