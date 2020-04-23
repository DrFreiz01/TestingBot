theme: /aviaSearchDirect


    state: directTicketsNoInfo
        q!: {$directFlight [$withBaggage]}
        # 4EX: Мне нужны прямые билеты
        q!: * {($want/$need2) $directFlight [$withBaggage]} *
        # 4EX: Хочу купить прямые билеты
        q!: * {($buyInf/$buyNoun) * $directFlight [$withBaggage]} *
        # 4EX: Есть биоеты без пересадок?
        q!: {([$exist] [ли]) $directFlight [$withBaggage]} [$markQuestion]
        # 4EX: Найти прямые билеты
        q!: * {($lookForV/$lookForN) $directFlight [$withBaggage]} *
        # 4EX: наличие прямые билетов
        q!: * (наличие/наличее) {$directFlight [$withBaggage]} *
        q!: * {$directFlight [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
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
                if: $session.from && $session.dest && $session.dates
                    go!: /aviaSearchFunc/aviaSearch
                elseif: $session.from && $session.dest
                    go!: /aviaSearchDirect/directTicketsFromDest
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
                        go!: /aviaSearchFunc/aviaSearch
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
                    q: * (дешев*/дешёв*/подешев*/подешёв*) *
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
                            go!: /aviaSearchFunc/aviaSearch
                        else:
                            a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



    state: directTicketsPrice
        # 4EX: цена прямых билетов
        q!: * $price [на] {$directFlight [$withBaggage]} *
        # 4EX: прямые АВИАБИЛЕТЫ стоимость
        q!: * {$directFlight [$withBaggage]} $price *
        # 4EX: сколкьо стоят прямые билеты
        q!: * {($howMuch $cost/почем/почём) $directFlight [$withBaggage]} *
        go!: /aviaSearchDirect/directTicketsNoInfo



    state: directTicketsDestInfo
        # 4EX: Добрый день, прямые Авиабилеты в Москву
        q!: * {($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Мне нужны прямые билеты в омск
        q!: * {($want/$need2) ($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($want/$need2) ($direct/$directFlight) [$withBaggage]} *
        # 4EX: Хочу купить прямые билеты в омск
        q!: * [$withBaggage] * {$buyAllExceptPast * ($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * ($direct/$directFlight) [$withBaggage]} *
        # 4EX: Есть прямые биоеты в омск?
        q!: {([$exist] [ли]) ($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * [$markQuestion]
        q!: $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) ($direct/$directFlight) [$withBaggage]} [$markQuestion]
        # 4EX: Найти прямые билеты в омск
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($lookForV/$lookForN) ($direct/$directFlight) [$withBaggage]} *
        # 4EX: наличие прямых билетов в омск
        q!: * [$withBaggage] * (наличие/наличее) {($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * (наличие/наличее) {($direct/$directFlight) [$withBaggage]} *
        q!: * {($direct/$directFlight) [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена прямых билетов в москву
        q!: * [$withBaggage] * $price {([на] ($direct/$directFlight)) [$withBaggage]} * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $price {([на] ($direct/$directFlight)) [$withBaggage]} *
        # 4EX: Здравствуйте я хочу узнать почем прямой билет стоит в Санкт-Петербург
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight) [$withBaggage]} * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight) [$withBaggage]} *
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
            go!: /aviaSearchDirect/directTicketsNoInfo/directCityTo



    state: directTicketsFromDest
        # 4EX: москва - питер без пересадок
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: нужны прямые билеты москва - питер
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты москва - питер
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        # 4EX: Есть прямые биоеты москва - питер?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) $directFlight}
        # 4EX: Найти прямые билеты москва - питер
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        # 4EX: наличие приямых билетов москва - питер
        q!: * [$withBaggage] * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена прямых билетов москва - питер
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] $directFlight * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты мск питер
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *

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
                go!: /aviaSearchDirect/directTicketsNoInfo/directCityTo/directCityFrom



    state: directTicketsDatesInfo
        # 4EX: Мне нужны прямые билеты на 12 октября
        q!: * {($want/$need2) $directFlight [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight [$withBaggage]} *
        # 4EX: Хочу купить прямые билеты на 12 октября
        q!: * {$buyAllExceptPast * $directFlight [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight [$withBaggage]} *
        # 4EX: Есть прямы биоеты на 12 октября?
        q!: [$exist] [ли] {$directFlight [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) [$exist] [ли] {$directFlight [$withBaggage]} [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) {$directFlight [$withBaggage]} [$exist] [$markQuestion]
        # 4EX: Найти прямые билеты на 12 октября
        q!: * {($lookForV/$lookForN) $directFlight [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight [$withBaggage]} *
        # 4EX: наличие прямых билетов на 12 октября
        q!: * (наличие/наличее) {$directFlight [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) {$directFlight [$withBaggage]} *
        q!: * {$directFlight [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$directFlight [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена прямых билетов на 12 октября
        q!: * $price {([на] $directFlight) [$withBaggage]} * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price {([на] $directFlight) [$withBaggage]} *
        # 4EX: сколкьо стоят прямые билеты на 12 октября
        q!: * {($howMuch $cost/почем/почём) $directFlight [$withBaggage]} * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight [$withBaggage]} *
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
                    go!: /aviaSearchFunc/aviaSearch
                    #go!: /aviaSearchFunc/oldAviaSearchDirect




    state: directTicketsDestDates
        # 4EX: завтра в магадан прямой
        q!: * {($direct/$directFlight) [$withBaggage]} * ($dateDig/$dateLetters/$thatDay) [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($direct/$directFlight) [$withBaggage]} * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * {($direct/$directFlight) [$withBaggage]} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode * {($direct/$directFlight) [$withBaggage]} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) {($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) {($direct/$directFlight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode *

        q!: * {($direct/$directFlight) [$withBaggage]} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($direct/$directFlight) [$withBaggage]} *
        q!: *[$withBaggage] * $iataAndRailway::destCode {($direct/$directFlight) [$withBaggage]} [на] ($dateDig/$dateLetters/$thatDay) *
        # 4EX: цена прямых билетов на 12 октября в магадан
        q!: * [$withBaggage] * $price {([на] ($direct/$directFlight)) [$withBaggage]} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price {([на] ($direct/$directFlight)) [$withBaggage]} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price {([на] $directFlight) [$withBaggage]} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price {([на] $directFlight) [$withBaggage]} * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты на 12 октября в магадан
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($direct/$directFlight) [$withBaggage]} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($direct/$directFlight) [$withBaggage]} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($direct/$directFlight) [$withBaggage]} *
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
                go!: /aviaSearchFunc/aviaSearch
                #go!: /aviaSearchFunc/oldAviaSearchDirect



    state: directTicketsFullInfo
        # 4EX: Краснодар Москва 12 октября без пересадок
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: прямой билет на 13 февраля Москва-Вена
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить прямой билет из краснодара в москву 12 октября
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * ($direct/$directFlight) * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: на завтра прямой из копенгагена в москву
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить прямой билет в москву из краснодара 12 октября
        q!: * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: нужен прямой билет 17 февраля в Курильск из астаны
        q!: * [$withBaggage] * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($direct/$directFlight) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($direct/$directFlight) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * $iataAndRailway::fromCode * [$withBaggage] *
        # 4EX: Краснодар купить прямые бидеты из москвы 12 октября
        q!: * [$withBaggage] * ($direct/$directFlight) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * [$withBaggage] * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * [$withBaggage] * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) * $from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($direct/$directFlight) * [$withBaggage] * $from [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode * ($direct/$directFlight) * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: на Гандинагар из Смоленска прямой рейс 15 марта
        q!: * [$withBaggage] * ($direct/$directFlight) * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * ($direct/$directFlight) * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] * ($direct/$directFlight) *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($direct/$directFlight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($direct/$directFlight) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($direct/$directFlight) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * ($direct/$directFlight) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ($direct/$directFlight) ([на] ($dateDig/$dateLetters/$thatDay))} * [$withBaggage] *
        # 4EX: Нужен прямой билет термез москва на завтра 10 января
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты москва - питер на завтра
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        # 4EX: Есть прямые биоеты москва - питер на завтра?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) $directFlight} * [$withBaggage] *
        # 4EX: Найти прямые билеты москва - питер на завтра
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        # 4EX: наличие прямых билетов москва - питер на завтра
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $directFlight * [$withBaggage] *
        # 4EX: прямые билеты в наличие москва - питер на завтра
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $directFlight * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: цена прямых билетов москва - питер на завтра
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты мск питер на завтра
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *

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
                #go!: /aviaSearchFunc/oldAviaSearchDirect



    state: aviaSearchDirectRoundtripFullInfo
        # 2 города
        # 4EX: москва питер 14 16 марта прямой
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        # 4EX: Узбекистан Самарканд прилетать сколько будет от санкт-петербурга туда-обратно 17 числа до конца ноября 30 числа
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        # 4EX: какие будут цены 1.02.19 на Тенерифе из Казани и 14.02.19 обратно
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * [$withBaggage] * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $directFlight * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight * [$withBaggage] *
        # 4EX: нужно купить два билета на самолет самара - прага на 04.04.19г. и обратно прага самара на 17.04.19г. все билеты должны включать багаж рейсы только прямые
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        # 4EX: Краснодар Москва 01.04-05.04
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate *
        q!: * $directFlight * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $doubleDate *
        q!: * $directFlight * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight * $doubleDate *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight * $doubleDate *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] * $doubleDate *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight * $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate * $directFlight *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $doubleDate * $directFlight *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $doubleDate * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * $doubleDate * [$withBaggage] * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * $directFlight * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * [$withBaggage] * $directFlight * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * $directFlight * [$withBaggage] * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * $directFlight * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * $doubleDate * [$withBaggage] * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * $doubleDate * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        # 4EX: Купить билет из краснодара в москву 01.04-05.04
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) *
        q!: * $directFlight * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] * ([на] $doubleDate) *
        q!: * $directFlight * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight * ([на] $doubleDate) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] * $directFlight * ([на] $doubleDate) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight * [$withBaggage] * ([на] $doubleDate) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) * $directFlight *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] * ([на] $doubleDate) * $directFlight *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] $doubleDate) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $directFlight * $iataAndRailway::fromCode ([на] $doubleDate) * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $directFlight * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode ([на] $doubleDate) * $directFlight * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * [$withBaggage] * $directFlight * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * $directFlight * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * $directFlight * ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode ([на] $doubleDate) * ($to [$cityPreName] $iataAndRailway::destCode) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * [$withBaggage] * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $doubleDate * $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $directFlight * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $directFlight * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) *
        q!: * $directFlight * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * $directFlight * ([на] $doubleDate) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight * [$withBaggage] * ([на] $doubleDate) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * [$withBaggage] * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * [$withBaggage] * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * $directFlight * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * $directFlight * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * [$withBaggage] * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * $directFlight *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] $doubleDate) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $directFlight * [$withBaggage] * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $directFlight * $doubleDate * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $directFlight * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * $directFlight * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $doubleDate * [$withBaggage] * $directFlight * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $doubleDate * $directFlight * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $doubleDate * $directFlight * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $directFlight *
        q!: * $doubleDate * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $directFlight *
        q!: * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $directFlight *
        q!: * $doubleDate * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $directFlight * [$withBaggage] *
        # 4EX: Краснодар купить бидеты из москвы 01.04-05.04
        q!: * [$withBaggage] * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * $directFlight * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * [$withBaggage] * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * ([на] $doubleDate) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $directFlight * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ([на] $doubleDate) * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] $doubleDate) * [$withBaggage] * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] $doubleDate) * $directFlight * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] $doubleDate) * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * ([на] $doubleDate) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * $directFlight *
        q!: * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $directFlight * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) *
        q!: * $directFlight * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * $directFlight * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * [$withBaggage] * ([на] $doubleDate) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * ([на] $doubleDate) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * $directFlight *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * $directFlight *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] $doubleDate) * $directFlight *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] $doubleDate) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $directFlight * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * $directFlight * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * $directFlight * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::destCode * ([на] $doubleDate) * ($from [$cityPreName] $iataAndRailway::fromCode) * $directFlight * [$withBaggage] *
        # 4EX: москва питер 19 августа туда 26 обратно на троих
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * $directFlight * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$withBaggage] * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$roundTrip] * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * [$roundTrip] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$roundTrip] * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * $directFlight * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $iataAndRailway::destCode * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * [$withBaggage] * $directFlight *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $iataAndRailway::destCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $price *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] * $directFlight *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $directFlight * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $price * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $price *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * $price * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $price * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * [$withBaggage] * $directFlight *
        q!: * $price * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $price * $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $directFlight * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $directFlight * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $directFlight * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * [$withBaggage] * $from $iataAndRailway::fromCode * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $directFlight * $from $iataAndRailway::fromCode * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $price *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $directFlight * $price * [$withBaggage] *
        q!: * [$withBaggage] * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * [$withBaggage] * $from $iataAndRailway::fromCode * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * [$withBaggage] * $price * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * [$withBaggage] * $directFlight *
        q!: * $price * ($dateDig::dateDig1/$dateLetters::dateLetters1) * ((на/по) $numberDate/$numberDate обратно) * $to $iataAndRailway::destCode * $from $iataAndRailway::fromCode * $price * $directFlight * [$withBaggage] *
        # 4EX: нужно купить прямые билеты на самолет самара - прага на 04.04.20г. и обратно прага самара на 17 все билеты должны включать багаж рейсы только прямые
        q!: * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $directFlight * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $directFlight * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $directFlight * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $directFlight * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $directFlight * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $directFlight * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * $directFlight * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * $directFlight * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * [$withBaggage] * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * [$withBaggage] * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * [$withBaggage] * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * [$withBaggage] * ((на/по) $numberDate/$numberDate обратно) * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * [$withBaggage] * $directFlight *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ((на/по) $numberDate/$numberDate обратно) * $directFlight * [$withBaggage] *
        # 4EX: Нужен прямой билет термез москва 01.04-05.04
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * {($want/$need2) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {($want/$need2) $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * {($want/$need2) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {($want/$need2) $directFlight} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($want/$need2) $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) $directFlight} * [на] $doubleDate * [$withBaggage] *
        # 4EX: Хочу купить прямые билеты москва - питер на 01.04-05.04
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        # 4EX: Купить прямой билет в москву из краснодара 01.04-05.04
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] $doubleDate *
        q!: * {$buyAllExceptPast * $directFlight} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] $doubleDate * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] $doubleDate * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * {$buyAllExceptPast * $directFlight} * [на] $doubleDate *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * {$buyAllExceptPast * $directFlight} * [на] $doubleDate *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * {$buyAllExceptPast * $directFlight} * [на] $doubleDate *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * {$buyAllExceptPast * [$withBaggage] * $directFlight} * [на] $doubleDate *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * {$buyAllExceptPast * $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * {$buyAllExceptPast * $directFlight} * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * {$buyAllExceptPast * $directFlight} *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * {$buyAllExceptPast * $directFlight} *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] $doubleDate * {$buyAllExceptPast * $directFlight} *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * [$withBaggage] * {$buyAllExceptPast * $directFlight} *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * {$buyAllExceptPast * [$withBaggage] * $directFlight} *
        q!: * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] $doubleDate * {$buyAllExceptPast * $directFlight} * [$withBaggage] *
        # 4EX: Есть биоеты москва - питер на 01.04-05.04?
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: {([$exist] [ли]) $directFlight} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: {([$exist] [ли]) $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) $directFlight} * [на] $doubleDate * [$withBaggage] *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate {([$exist] [ли]) $directFlight} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate {([$exist] [ли]) $directFlight} * [$withBaggage] *
        # 4EX: Найти билеты москва - питер на 01.04-05.04
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * {($lookForV/$lookForN) $directFlight} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $directFlight} * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) $directFlight} * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $doubleDate * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $doubleDate * [$withBaggage] * {($lookForV/$lookForN) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $doubleDate * {($lookForV/$lookForN) $directFlight} * [$withBaggage] *
        # 4EX: наличие билетов москва - питер на 01.04-05.04
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * (наличие/наличее) $directFlight * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) $directFlight * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) $directFlight * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) $directFlight * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) $directFlight * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * (наличие/наличее) $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * (наличие/наличее) $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $directFlight (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] $doubleDate * [$withBaggage] *
        # 4EX: цена прямых билетов москва - питер на 01.04-05.04
        q!: * [$withBaggage] * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * $price [на] $directFlight * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * $price [на] $directFlight * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] $directFlight * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [$withBaggage] * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] $doubleDate * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] $directFlight * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * $price [на] $directFlight *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * $price [на] $directFlight * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *$price [на] $directFlight * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] $directFlight * [на] $doubleDate * [$withBaggage] *
        # 4EX: сколкьо стоят прямые билеты мск питер на 01.04-05.04
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] * [на] $doubleDate *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $directFlight} * [на] $doubleDate * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] $doubleDate * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * [$withBaggage] * {($howMuch $cost/почем/почём) $directFlight} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] $doubleDate * {($howMuch $cost/почем/почём) $directFlight} * [$withBaggage] *

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
                go!: /aviaSearchFunc/aviaSearchRoundtrip