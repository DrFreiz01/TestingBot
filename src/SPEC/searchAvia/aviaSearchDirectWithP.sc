theme: /aviaSearchDirectWithP


    state: directTicketsNoInfoWithP
        q!: * [$withBaggage] * $directFlight * $forAdults *
        q!: * $directFlight * [$withBaggage] * $forAdults *
        q!: * $directFlight * $forAdults * [$withBaggage] *
        # 4EX: Мне нужны прямые билеты для троих
        q!: * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Хочу купить 6 прямых билетов
        q!: * [$withBaggage] * $forAdults * {($buyInf/$buyNoun) * $directFlight} *
        q!: * $forAdults * [$withBaggage] * {($buyInf/$buyNoun) * $directFlight} *
        q!: * $forAdults * {($buyInf/$buyNoun) * [$withBaggage] * $directFlight} *
        q!: * $forAdults * {($buyInf/$buyNoun) * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * {($buyInf/$buyNoun) * $forAdults * $directFlight} *
        q!: * ($buyInf/$buyNoun) * [$withBaggage] * $forAdults * $directFlight *
        q!: * ($buyInf/$buyNoun) * [$withBaggage] * $directFlight * $forAdults *
        q!: * ($buyInf/$buyNoun) * $forAdults * [$withBaggage] * $directFlight *
        q!: * ($buyInf/$buyNoun) * $forAdults * $directFlight * [$withBaggage] *
        q!: * ($buyInf/$buyNoun) * $directFlight * [$withBaggage] * $forAdults *
        q!: * ($buyInf/$buyNoun) * $directFlight * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * ($buyInf/$buyNoun) * $forAdults * $directFlight *
        q!: * [$withBaggage] * ($buyInf/$buyNoun) * $directFlight * $forAdults *
        q!: * [$withBaggage] * $forAdults * ($buyInf/$buyNoun) * $directFlight *
        q!: * [$withBaggage] * $forAdults * $directFlight * ($buyInf/$buyNoun) *
        q!: * [$withBaggage] * $directFlight * ($buyInf/$buyNoun) * $forAdults *
        q!: * [$withBaggage] * $directFlight * $forAdults * ($buyInf/$buyNoun) *
        q!: * $forAdults * ($buyInf/$buyNoun) * [$withBaggage] * $directFlight *
        q!: * $forAdults * ($buyInf/$buyNoun) * $directFlight * [$withBaggage] *
        q!: * $forAdults * [$withBaggage] * ($buyInf/$buyNoun) * $directFlight *
        q!: * $forAdults * [$withBaggage] * $directFlight * ($buyInf/$buyNoun) *
        q!: * $forAdults * $directFlight * ($buyInf/$buyNoun) * [$withBaggage] *
        q!: * $forAdults * $directFlight * [$withBaggage] * ($buyInf/$buyNoun) *
        q!: * $directFlight * ($buyInf/$buyNoun) * [$withBaggage] * $forAdults *
        q!: * $directFlight * ($buyInf/$buyNoun) * $forAdults * [$withBaggage] *
        q!: * $directFlight * [$withBaggage] * ($buyInf/$buyNoun) * $forAdults *
        q!: * $directFlight * [$withBaggage] * $forAdults * ($buyInf/$buyNoun) *
        q!: * $directFlight * $forAdults * ($buyInf/$buyNoun) * [$withBaggage] *
        q!: * $directFlight * $forAdults * [$withBaggage] * ($buyInf/$buyNoun) *
        q!: * {($buyInf/$buyNoun) * $forAdults * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * {($buyInf/$buyNoun) * $directFlight} * $forAdults *
        q!: * {($buyInf/$buyNoun) * [$withBaggage] * $directFlight} * $forAdults *
        q!: * {($buyInf/$buyNoun) * $directFlight} * [$withBaggage] * $forAdults *
        q!: * {($buyInf/$buyNoun) * $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Есть 2 взрослых биоета без пересадок?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults [$markQuestion]
        # 4EX: Найти прямые билеты на четверых
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: наличие прямые билетов на четверых
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] *
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



        state: directCityTo
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
                    script:
                        $session.direct = true;
                    go!: /aviaSearchFunc/aviaSearch
                    #go!: /aviaSearchFunc/oldAviaSearchDirect
                elseif: $parseTree._fromCode && $parseTree._destCode
                    go!: /aviaSearchDirectWithP/directTicketsNoInfoWithP/directCityTo/directCityFrom
                else:
                    a: Откуда вы едете?



            state: directCityFrom
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
                        script:
                            $session.direct = true;
                        go!: /aviaSearchFunc/aviaSearch
                        #go!: /aviaSearchFunc/oldAviaSearchDirect
                    else:
                        script:
                            $session.from = $parseTree._fromCode.airport;
                        a: На какую дату планируете поездку?



                state: directDates
                    q: [$cheap/$cheaper/$cheapest] [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$cheap/$cheaper/$cheapest] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] [$cheap/$cheaper/$cheapest] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} [$cheap/$cheaper/$cheapest] ($dateDig/$dateLetters/$thatDay/$numberDate) [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate) [$cheap/$cheaper/$cheapest] [утром/вечером/днем/днём]
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} ($dateDig/$dateLetters/$thatDay/$numberDate) [утром/вечером/днем/днём] [$cheap/$cheaper/$cheapest]
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
                        if: $session.dates
                            script:
                                $session.direct = true;
                            go!: /aviaSearchFunc/aviaSearch
                            #go!: /aviaSearchFunc/oldAviaSearchDirect
                        else:
                            a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



    state: directTicketsPriceWithP
        # 4EX: цена прямых билетов на четверых
        q!: * [$withBaggage] * $forAdults * $price [на] $directFlight *
        q!: * $forAdults * [$withBaggage] * $price [на] $directFlight *
        q!: * $forAdults * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $forAdults *
        q!: * $price [на] $directFlight * [$withBaggage] * $forAdults *
        q!: * $price [на] $directFlight * $forAdults * [$withBaggage] *
        # 4EX: прямые АВИАБИЛЕТЫ стоимость на четверых
        q!: * [$withBaggage] * $forAdults * $directFlight $price *
        q!: * $forAdults * [$withBaggage] * $directFlight $price *
        q!: * $forAdults * $directFlight $price * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight $price * $forAdults *
        q!: * $directFlight $price * [$withBaggage] * $forAdults *
        q!: * $directFlight $price * $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты на четверых
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] *
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
                go!: /aviaSearchDirectWithP/directTicketsNoInfoWithP



    state: directTicketsDestInfoWithP
        # 4EX: Добрый день, прямые Авиабилеты в Москву на четверых
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        # 4EX: Мне нужны прямые билеты в омск на четверых
        q!: * [$withBaggage] * $forAdults * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {($want/$need2) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($want/$need2) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($want/$need2) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * {($want/$need2) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight)} * $forAdults * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты в омск на четверых
        q!: * [$withBaggage] * $forAdults * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * [$withBaggage] * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * $forAdults * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * ($direct/$directFlight) * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * [$withBaggage] * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * ($direct/$directFlight) * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * ($direct/$directFlight) * [$withBaggage] * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * ($direct/$directFlight) * $forAdults * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * $forAdults * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * ($direct/$directFlight) * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $buyAllExceptPast * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ($direct/$directFlight) * $buyAllExceptPast * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * [$withBaggage] * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * ($direct/$directFlight) * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $buyAllExceptPast * ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * $buyAllExceptPast * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $buyAllExceptPast * [$withBaggage] * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $buyAllExceptPast * $forAdults * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $buyAllExceptPast * $forAdults [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * $buyAllExceptPast * [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $buyAllExceptPast [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {$buyAllExceptPast * ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$withBaggage] * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults * ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * $buyAllExceptPast * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * $buyAllExceptPast * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * ($direct/$directFlight) * [$withBaggage] *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * $buyAllExceptPast * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $buyAllExceptPast * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $buyAllExceptPast * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight)} * $forAdults * [$withBaggage] *
        # 4EX: Есть прямые биоеты в омск на четверых?
        q!: {([$exist] [ли]) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults [$markQuestion]
        q!: {([$exist] [ли]) ($direct/$directFlight)} * [$withBaggage] * $forAdults * $iataAndRailway::destCode [$markQuestion]
        q!: {([$exist] [ли]) ($direct/$directFlight)} * $forAdults * [$withBaggage] * $iataAndRailway::destCode [$markQuestion]
        q!: $iataAndRailway::destCode * [$withBaggage] * $forAdults * {([$exist] [ли]) ($direct/$directFlight)} [$markQuestion]
        q!: $iataAndRailway::destCode * $forAdults * [$withBaggage] * {([$exist] [ли]) ($direct/$directFlight)} [$markQuestion]
        q!: $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) ($direct/$directFlight)} * $forAdults [$markQuestion]
        q!: $iataAndRailway::destCode * {([$exist] [ли]) ($direct/$directFlight)} * [$withBaggage] * $forAdults [$markQuestion]
        # 4EX: Найти прямые билеты в омск на четверых
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) ($direct/$directFlight)} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * {($lookForV/$lookForN) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight)} * $forAdults * [$withBaggage] *
        # 4EX: наличие прямых билетов в омск на четверых
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * (наличие/наличее) ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * (наличие/наличее) ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * (наличие/наличее) ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * (наличие/наличее) ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * (наличие/наличее) ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] *
        # 4EX: цена прямых билетов в москву на четверых
        q!: * [$withBaggage] * $forAdults * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * $price [на] ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * $price [на] ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $price [на] ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * $price [на] ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * $price [на] ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * $price [на] ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * $price [на] ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * $price [на] ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $price [на] ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * $price [на] ($direct/$directFlight) * $forAdults * [$withBaggage] *
        # 4EX: Здравствуйте я хочу узнать почем прямой билет стоит в Санкт-Петербург на четверых
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * [$withBaggage] *

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
            go!: /aviaSearchDirectWithP/directTicketsNoInfoWithP/directCityTo



    state: directTicketsFromDestWithP
        # 4EX: москва - питер без пересадок на четверых
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        # 4EX: нужны прямые билеты москва - питер на четверых
        q!: * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты москва - питер на четверых
        q!: * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Есть прямые биоеты москва - питер на четверых?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults [$markQuestion]
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults [$markQuestion]
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {([$exist] [ли]) $directFlight}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {([$exist] [ли]) $directFlight}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {([$exist] [ли]) $directFlight}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {([$exist] [ли]) $directFlight}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) $directFlight}
        # 4EX: Найти прямые билеты москва - питер на четверых
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: наличие приямых билетов москва - питер на четверых
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] *
        # 4EX: цена прямых билетов москва - питер на четверых
        q!: * [$withBaggage] * $forAdults * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight * $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты мск питер на четверых
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] *

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
            go!: /aviaSearchDirectWithP/directTicketsNoInfoWithP/directCityTo/directCityFrom



    state: directTicketsDatesInfoWithP
        # 4EX: Мне нужны прямые билеты на 12 октября на четверых
        q!: * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты на 12 октября на четверых
        q!: * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Есть прямы биоеты на 12 октября на четверых?
        q!: [$exist] [ли] $directFlight * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [$exist] [ли] $directFlight * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [$exist] [ли] $directFlight [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$exist] [ли] $directFlight [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$exist] [ли] $directFlight [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) [$exist] [ли] $directFlight * [$withBaggage] * $forAdults [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $directFlight [$exist] [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $directFlight [$exist] [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) $directFlight * [$withBaggage] * $forAdults [$exist] [$markQuestion]
        # 4EX: Найти прямые билеты на 12 октября
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: наличие прямых билетов на 12 октября на четверых
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) $directFlight [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] *
        # 4EX: цена прямых билетов на 12 октября на четверых
        q!: * [$withBaggage] * $forAdults * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $price [на] $directFlight * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $price [на] $directFlight * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $price [на] $directFlight * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $price [на] $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $price [на] $directFlight *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты на 12 октября на четверых
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] *

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



        state: directCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $numberDate
            script:
                if ($parseTree._fromCode && $parseTree._destCode) {
                    $session.direct = true;
                    $reactions.transition("/aviaSearchFunc/aviaSearch");
                    //$reactions.transition("/aviaSearchFunc/oldAviaSearchDirect");
                }
                $session.dest = $parseTree._destCode.airport;
            a: Откуда вы едете?

            state: directCityFrom
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
                        $session.direct = true;
                    go!: /aviaSearchFunc/aviaSearch
                    #go!: /aviaSearchFunc/oldAviaSearchDirect



    state: directTicketsDestDatesWithP
        # 4EX: завтра в магадан прямой на четверых
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) ($direct/$directFlight) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode ($direct/$directFlight) [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        # 4EX: цена прямых билетов на 12 октября в магадан на четверых
        q!: * [$withBaggage] * $forAdults * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * [$withBaggage] * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * $price [на] ($direct/$directFlight) * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($direct/$directFlight) * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($direct/$directFlight) * [$withBaggage] * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($direct/$directFlight) * $forAdults * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($direct/$directFlight) * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $forAdults *
        q!: * $price [на] ($direct/$directFlight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight *
        q!: * $forAdults * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight *
        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $price [на] $directFlight *
        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * $price [на] $directFlight *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $forAdults * $price [на] $directFlight *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * [$withBaggage] * $price [на] $directFlight *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $price [на] $directFlight * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight * [$withBaggage] * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $directFlight * $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты на 12 октября в магадан на четверых
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * [$withBaggage] * $forAdults *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight)} * $forAdults * [$withBaggage] *

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


        state: directCityFrom
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
                    $session.direct = true;
                go!: /aviaSearchFunc/aviaSearch
                #go!: /aviaSearchFunc/oldAviaSearchDirect




    state: directTicketsFullInfoWithP
        # 4EX: Краснодар Москва 12 мая без пересадок на четверых
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        # 4EX: прямой билет на 13 мая Москва-Вена на четверых
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        # 4EX: Купить прямой билет из краснодара в москву 12 октября на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $iataAndRailway::fromCode [$withBaggage] * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode [$withBaggage] * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] *
        q!: * $iataAndRailway::fromCode $forAdults * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $forAdults * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] *
        q!: * $iataAndRailway::fromCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        # 4EX: на завтра прямой из копенгагена в москву на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        # 4EX: Купить прямой билет в москву из краснодара 12 октября на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        # 4EX: нужен прямой билет 17 июня в Курильск из астаны на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * $forAdults * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $forAdults *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * $forAdults * [$withBaggage] *
        # 4EX: Краснодар купить прямые бидеты из москвы 12 марта на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * [$withBaggage] * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * $forAdults * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        # 4EX: на Гандинагар из Смоленска прямой рейс 15 марта на троих
        q!: * [$withBaggage] * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $forAdults *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * [$withBaggage] *
        # 4EX: Нужен прямой билет термез москва на завтра 10 января на троих
        q!: * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты москва - питер на завтра
        q!: * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $forAdults * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$withBaggage] * $forAdults * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$withBaggage] * $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * $directFlight * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $directFlight * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $buyAllExceptPast * $forAdults * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $buyAllExceptPast * $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $buyAllExceptPast * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $directFlight * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $directFlight * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * $directFlight * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $buyAllExceptPast * $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $directFlight * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $directFlight * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * $buyAllExceptPast * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * $buyAllExceptPast * $forAdults * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * [$withBaggage] * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * [$withBaggage] * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * $forAdults * $buyAllExceptPast * [$withBaggage] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $directFlight * $forAdults * [$withBaggage] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Есть прямые биоеты москва - питер на завтра на троих?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} * $forAdults *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} * [$withBaggage] * $forAdults *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: Найти прямые билеты москва - питер на завтра на троих
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * $forAdults * [$withBaggage] *
        # 4EX: наличие прямых билетов москва - питер на завтра на троих
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * $forAdults * [$withBaggage] *
        # 4EX: прямые билеты в наличие москва - питер на завтра на троих
        q!: * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        # 4EX: цена прямых билетов москва - питер на завтра на троих
        q!: * [$withBaggage] * $forAdults * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *$price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *$price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты мск питер на завтра
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] *
        q!: * [$withBaggage] * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $forAdults * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $forAdults * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $forAdults *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * $forAdults * [$withBaggage] *

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
                    $session.direct = true;
                go!: /aviaSearchFunc/aviaSearch
                #go!: /aviaSearchFunc/oldAviaSearchDirect


