theme: /aviaSearchWithP


    state: aviaNoInfoWithP
        # 4EX: Мне нужно 5 взросдых билетов
        q!: * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] *
        # 4EX: Хочу купить 6 билетов
        q!: * [$withBaggage] * {($buyInf/$buyNoun) * $forAdults} *
        q!: * {($buyInf/$buyNoun) * [$withBaggage] * $forAdults} *
        q!: * {($buyInf/$buyNoun) * $forAdults} * [$withBaggage] *
        # 4EX: Есть 3 биоета?
        # 4EX: Найти билеты 2 взрослых
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} *
        q!: * {($lookForV/$lookForN) $forAdults} * [$withBaggage] *
        # 4EX: наличие двух билетов
        q!: * [$withBaggage] * (наличие/наличее) $forAdults *
        q!: * (наличие/наличее) $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayNoInfoWithP
        else:
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
                    a: Уточните, пожалуйста, направление вашей поездки.


        state: tripCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $numberDate
            # собираем переменные
            if: $temp.begin == undefined
                script:
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: $parseTree._fromCode && $parseTree._destCode && ($parseTree._dateDig || $parseTree._dateLetters || $parseTree._thatDay || $parseTree._numberDate)
                    go!: /aviaSearchFunc/aviaSearch
                elseif: $parseTree._fromCode && $parseTree._destCode
                    go!: /aviaSearchWithP/aviaNoInfoWithP/tripCityTo/tripCityFrom
                else:
                    a: Откуда вы едете?



            state: tripCityFrom
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
                q: [$from] [$cityPreName] $iataAndRailway::fromCode [на] ($dateDig/$dateLetters/$thatDay) *
                q: [$from] [$cityPreName] $iataAndRailway::fromCode [на] $numberDate
                q: * [на] ($dateDig/$dateLetters/$thatDay/$numberDate) [$from] [$cityPreName] $iataAndRailway::fromCode *
                # собираем переменные
                if: $temp.begin == undefined
                    script:
                        $temp.begin = true;
                        $client.executeState = $context.currentState;
                    go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                else:
                    script:
                        $temp.begin = undefined;
                    if: $parseTree._fromCode && ($parseTree._dateDig || $parseTree._dateLetters || $parseTree._thatDay || $parseTree._numberDate)
                        go!: /aviaSearchFunc/aviaSearch
                    else:
                        script:
                            $session.from = $parseTree._fromCode.airport;
                        a: На какую дату планируете поездку?



                state: tripDates
                    q: [$cheap/$cheaper/$cheapest] [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$cheap/$cheaper/$cheapest] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] [$cheap/$cheaper/$cheapest] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} [$cheap/$cheaper/$cheapest] ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$cheap/$cheaper/$cheapest] [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [утром/вечером/днем/днём] [$cheap/$cheaper/$cheapest]
                    # 4EX: 15 и 20 января
                    q: * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$cheap/$cheaper/$cheapest] * [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] * [$cheap/$cheaper/$cheapest] * [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$cheap/$cheaper/$cheapest] *
                    # 4EX: мне без разницы дата главное дешевле
                    q: * ($cheap/$cheaper/$cheapest) *
                    # собираем переменные
                    if: $temp.begin == undefined
                        script:
                            $temp.begin = true;
                            $client.executeState = $context.currentState;
                        go!: /aviaSearchFunc/parsing4AviaSearch_DYN
                    else:
                        script:
                            $temp.begin = undefined;
                        if: $session.dates1 && $session.dates2
                            go!: /aviaSearchFunc/aviaSearchRoundtrip
                        elseif: $session.dates
                            go!: /aviaSearchFunc/aviaSearch
                        else:
                            a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



    state: aviaPriceWithP
        # 4EX: цена 3 взрослых билетов
        q!: * [$withBaggage] * $price [на] $forAdults *
        q!: * $price [на] $forAdults * [$withBaggage] *
        # 4EX: АВИАБИЛЕТЫ, 3, стоимость
        q!: * [$withBaggage] * $forAdults $price *
        q!: * $forAdults $price * [$withBaggage] *
        # 4EX: сколкьо стоит 1 билет
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        # чистим переменные
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayNoInfoWithP
        else:
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
                    go!: /aviaSearchWithP/aviaNoInfoWithP



    state: aviaDestInfoWithP
        # 4EX: Добрый день, 5 бидетов для взрослых в Москву
        q!: * [$withBaggage] * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Мне нужны 5 бидетов для взрослых в омск
        q!: * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {{($want/$need2) [$ticket]} $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * $iataAndRailway::destCode * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] *
        # 4EX: Хочу купить 5 бидетов для взрослых в омск
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $forAdults} *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} * [$withBaggage] *
        # 4EX: Есть 5 бидетов для взрослых в омск?
        q!: $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) $forAdults} [$markQuestion]
        # 4EX: Найти 5 бидетов для взрослых в омск
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($lookForV/$lookForN) $forAdults} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($lookForV/$lookForN) $forAdults} *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) $forAdults} * [$withBaggage] *
        # 4EX: наличие прямых билетов в омск
        q!: * [$withBaggage] * (наличие/наличее) $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) $forAdults [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::destCode * (наличие/наличее) $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена трёх билетов в москву
        q!: * [$withBaggage] * $price [на] $forAdults * $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $price [на] $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $price [на] $forAdults *
        q!: * $iataAndRailway::destCode * $price [на] $forAdults * [$withBaggage] *
        # 4EX: Здравствуйте я хочу узнать почем два взрослых в Санкт-Петербург
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayDestInfoWithP
        else:
            # чистим переменные
            if: $temp.begin0 == undefined
                script:
                    $temp.begin0 = true;
                    $client.executeState0 = $context.currentState;
                go!: /aviaSearchFunc/varsCleaning_DYN
            else:
                script:
                    $temp.begin0 = undefined;
                    $session.dest = $parseTree._destCode.airport;
                go!: /aviaSearchWithP/aviaNoInfoWithP/tripCityTo



    state: aviaFromDestWithP
        # 4EX: москва - питер втроём
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: нужно 5 бидетов для взрослых москва - питер
        q!: * [$withBaggage] * $forAdults * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} *
        q!: * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} *
        q!: * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) [$ticket]} *
        q!: * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) [$ticket]} * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [$withBaggage] * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($want/$need2) [$ticket]} *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($want/$need2) [$ticket]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($want/$need2) [$ticket]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {($want/$need2) [$ticket]} * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * [$withBaggage] * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * $forAdults * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($want/$need2) [$ticket]} * $forAdults * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Хочу купить 5 бидетов для взрослых москва - питер
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} * [$withBaggage] *
        # 4EX: Есть 5 бидетов для взрослых москва - питер?
        q!: {([$exist] [ли]) $forAdults} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) $forAdults}
        # 4EX: Найти 5 бидетов для взрослых москва - питер
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $forAdults} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $forAdults} * [$withBaggage] *
        # 4EX: наличие 2 билетов москва - питер
        q!: * [$withBaggage] * (наличие/наличее) $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена 7 взрослых билетов москва - питер
        q!: * [$withBaggage] * $price [на] $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят 5 бидетов для взрослых мск питер
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayFromDestWithP
        else:
            # чистим переменные
            if: $temp.begin0 == undefined
                script:
                    $temp.begin0 = true;
                    $client.executeState0 = $context.currentState;
                go!: /aviaSearchFunc/varsCleaning_DYN
            else:
                script:
                    $temp.begin0 = undefined;
                    $session.from = $parseTree._fromCode.airport;
                    $session.dest = $parseTree._destCode.airport;
                go!: /aviaSearchWithP/aviaNoInfoWithP/tripCityTo/tripCityFrom



    state: aviaDatesInfoWithP
        # 4EX: Мне нужны 5 бидетов для взрослых на 12 октября
        q!: * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {{($want/$need2) [$ticket]} $forAdults} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] *
        # 4EX: Хочу купить 5 бидетов для взрослых на 12 октября
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$withBaggage] * $forAdults} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults} * [$withBaggage] *
        # 4EX: Есть билеты на семерых биоеты на 12 октября?
        # 4EX: Найти 5 бидетов для взрослых на 12 октября
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $forAdults} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $forAdults} * [$withBaggage] *
        # 4EX: наличие билетов на семерых на 12 октября
        q!: * [$withBaggage] * (наличие/наличее) $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $forAdults [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов на семерых на 12 октября
        q!: * [$withBaggage] * $price [на] $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $price [на] $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price [на] $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят 5 бидетов для взрослых на 12 октября
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayDatesInfoWithP
        else:
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
                    a: Уточните, пожалуйста, направление вашей поездки.



        state: tripCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $numberDate
            script:
                if ($parseTree._fromCode && $parseTree._destCode) {
                    $reactions.transition("/aviaSearchFunc/aviaSearch");
                }
                $session.dest = $parseTree._destCode.airport;
            a: Откуда вы едете?

            state: tripCityFrom
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
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



    state: aviaDestDatesWithP
        # 4EX: завтра в магадан трое
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) $forAdults [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::destCode $forAdults [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: цена 2-х билетов на 12 октября в магадан
        q!: * [$withBaggage] * $price [на] $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] $forAdults * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $price [на] $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят 5 бидетов для взрослых на 12 октября в магадан
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayDestDatesWithP
        else:
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
                    a: Откуда вы едете?


        state: tripCityFrom
            # 4EX: из твери
            q: [$from] [$cityPreName] $iataAndRailway::fromCode
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



    state: aviaFullInfoWithP
        # 4EX: Краснодар Москва 12 октября четыре взрослых
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: 2 билеты на 13 февраля Москва-Вена
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить взрослый билет из краснодара в москву 12 октября
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) $forAdults * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: на завтра из копенгагена в москву взрослый
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить билеты в москву из краснодара 12 октября на двоих
        q!: * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: нужны 2 взрослых 17 февраля в Курильск из астаны
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $iataAndRailway::fromCode * [$withBaggage] *
        # 4EX: Краснодар купить 5 бидетов для взрослых из москвы 12 октября
        q!: * [$withBaggage] * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: на Гандинагар из Смоленска 15 марта взрослый
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode $forAdults ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: Нужен 2 билета термез москва на завтра 10 января
        q!: * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {{($want/$need2) [$ticket]} $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {{($want/$need2) [$ticket]} $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: Хочу купить 5 бидетов для взрослых москва - питер на завтра
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$withBaggage] * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults} * [$withBaggage] *
        # 4EX: Есть 5 бидетов для взрослых москва - питер на завтра?
        q!: {([$exist] [ли]) $forAdults} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $forAdults} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: {([$exist] [ли]) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $forAdults} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $forAdults} * [$withBaggage] *
        # 4EX: Найти 5 бидетов для взрослых москва - питер на завтра
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $forAdults} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $forAdults} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $forAdults} * [$withBaggage] *
        # 4EX: наличие билетов на пятерых москва - питер на завтра
        q!: * [$withBaggage] * (наличие/наличее) $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $forAdults * [$withBaggage] *
        # 4EX: 5 бидетов для взрослых в наличие москва - питер на завтра
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: цена пяти билетов москва - питер на завтра
        q!: * [$withBaggage] * $price [на] $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: сколкьо стоят 5 бидетов для взрослых мск питер на завтра
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $forAdults} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $forAdults} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $forAdults} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearchWithP/railwayFullInfoWithP
        else:
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
                    go!: /aviaSearchFunc/aviaSearch



