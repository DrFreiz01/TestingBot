theme: /aviaSearch



    state: aviaSearchNoInfo
        q!: {($ticket/$airplaneTicket/$flight) [$withBaggage]}
        # 4EX: Мне нужны билеты
        # 4EX: Мне нужна дешевле билет
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) { {[$withBaggage] [$cheap]} ($ticket/$airplaneTicket/$flight)} } [$markQuestion]
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) { {$withBaggage [$cheap/$cheaper/$cheapest]} ($ticket/$airplaneTicket/$flight)} } [$markQuestion]
        # 4EX: Хочу купить билеты
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($bookInf/$buyInf/$buyNoun) [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($bookInf/$buyInf/$buyNoun) [$withBaggage]} [$markQuestion]
        q!: {($ticket/$airplaneTicket/$flight) ($bookInf/$buyInf/$buyNoun)}
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($ticket/$airplaneTicket/$flight) ($bookInf/$buyInf) [$withBaggage]} [$markQuestion]
        # 4EX: Есть биоеты?
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        # 4EX: Найти билеты
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        # 4EX: наличие билетов
        q!: * (наличие/наличее) {($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$markQuestion]
        # 4EX: Добрый вечер.Скажите пожалуйста вы сможете помочь в поиске билетов ?
        q!: * $help * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        # 4EX: Здравствуйте, а как приобрести билеты через интернет на самолёт?
        q!: * ($bookInf/$buyInf/$buyNoun) * {{($ticket/$airplaneTicket/$flight) [$withBaggage]} $online ((в/на) (самолет*/самолёт*))} [$markQuestion]
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} * {($bookInf/$buyInf/$buyNoun) $online ((в/на) (самолет*/самолёт*))} [$markQuestion]
        # 4EX: Как купить билеты электронно?
        q!: * ($bookInf/$buyInf/$buyNoun) * {($ticket/$airplaneTicket/$flight) [$withBaggage] $online} [$markQuestion]
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} * {($bookInf/$buyInf/$buyNoun) $online} [$markQuestion]
        # 4EX: Помогите приобрести и оплатить билет
        q!: * ($bookInf/$buyInf/$buyNoun) * {$payAll ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        q!: * $payAll * {($bookInf/$buyInf/$buyNoun) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * {$payAll [и] ($bookInf/$buyInf/$buyNoun)} [$markQuestion]
        # 4EX: Дешевые билеты с багажом можно с пересадкой
        q!: $cheap {($ticket/$airplaneTicket/$flight) [$withBaggage]} * с пересадк* [$markQuestion]
        q!: [$cheap/$cheaper/$cheapest] {($ticket/$airplaneTicket/$flight) $withBaggage} * с пересадк* [$markQuestion]
        # 4EX: а можно ли купить билет без богажа по дешевле
        q!: * [$cheap] * ($ticket/$airplaneTicket/$flight) * (без/бес) $baggage [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * [$cheap] * (без/бес) $baggage [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * (без/бес) $baggage [$cheap] [$markQuestion]
        q!: * [$cheap] * ($ticket/$airplaneTicket/$flight) * $withBaggage [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * [$cheap] * $withBaggage [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) * $withBaggage [$cheap] [$markQuestion]
        # 4EX: Билете дешевле
        q!: [$beginningWords] {($ticket/$airplaneTicket/$flight) $cheap [$withBaggage]}
        q!: [$beginningWords] {($ticket/$airplaneTicket/$flight) ($cheap/$cheaper/$cheapest) $withBaggage}
        # 4EX: хочу кубить билет дешевый
        # 4EX: Как купит дешевые билкты, помогите
        q!: * ($bookInf/$buyInf/$buyNoun) * {($ticket/$airplaneTicket/$flight) [$withBaggage] $cheap} [$markQuestion]
        q!: * ($bookInf/$buyInf/$buyNoun) * {($ticket/$airplaneTicket/$flight) [$withBaggage] $cheap} * $help [$markQuestion]
        q!: * ($bookInf/$buyInf/$buyNoun) * {($ticket/$airplaneTicket/$flight) $withBaggage ($cheap/$cheaper/$cheapest)} [$markQuestion]
        q!: * ($bookInf/$buyInf/$buyNoun) * {($ticket/$airplaneTicket/$flight) $withBaggage ($cheap/$cheaper/$cheapest)} * $help [$markQuestion]
        # 4EX: Мне нужен самый дешевый билет,без багажа,возможно нвйти такой билет
        q!: * {($want/$need2/$checkLookFor) {[$cheap] [$withBaggage] ($ticket/$airplaneTicket/$flight)}} *
        q!: * {($want/$need2/$checkLookFor) {[$cheap/$cheaper/$cheapest] $withBaggage ($ticket/$airplaneTicket/$flight)}} *
        # 4EX: Нужна помощь в подборе маршрута
        q!: * ($want/$need2/$checkLookFor) * {(~подбор маршрут*) [$withBaggage]} *
        q!: * $help * {(~подбор маршрут*) [$withBaggage]} *
        q!: {(~подбор маршрут*) [$withBaggage]}
        # 4EX: Нужно только в один конец
        q!: * ($want/$need2/$checkLookFor) * ~один (конец/сторону) {[$bookInf/$buyInf/$buyNoun] [$ticket/$airplaneTicket/$flight] [$withBaggage]}

        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchNoInfo
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
            # 4EX: в москву!
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            # || fromState = /aviaSearch/aviaSearchNoInfo, onlyThisState = true   /aviaSearch/aviaSearchDestInfo
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
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
                    go!: /aviaSearch/aviaSearchNoInfo/tripCityTo/tripCityFrom
                else:
                    a: Откуда вы едете?



            state: tripCityFrom
                # 4EX: из питера
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
                q: [$from] [$cityPreName] $iataAndRailway::fromCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
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
                        a: На какую дату планируете поездку?



                state: tripDates
                    q: [$cheap/$cheaper/$cheapest] [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$morning/$evening/днем/днём]}
                    q: [$meDat] [$cheap/$cheaper/$cheapest] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$morning/$evening/днем/днём]}
                    q: [$meDat] [$need2] [$cheap/$cheaper/$cheapest] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$morning/$evening/днем/днём]}
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} [$cheap/$cheaper/$cheapest] {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$morning/$evening/днем/днём]}
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$cheap/$cheaper/$cheapest] [$morning/$evening/днем/днём]}
                    q: [$meDat] [$need2] {[примерно/премерно/приблизит*/преблизит*/преблезит*] [на]} {($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) [$morning/$evening/днем/днём] [$cheap/$cheaper/$cheapest]}
                    # 4EX: 15 и 20 января
                    q: * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [$cheap/$cheaper/$cheapest] * [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] * [$cheap/$cheaper/$cheapest] * [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] * [$cheap/$cheaper/$cheapest] * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) [$oneWord] [$oneWord] [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$cheap/$cheaper/$cheapest] *
                    # 4EX:  Мес август 10 или 14 август
                    q: * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [утром/вечером/днем/днём]
                    q: * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [утром/вечером/днем/днём]
                    q: * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [утром/вечером/днем/днём]
                    q: * [$cheap/$cheaper/$cheapest] * [на] [$cheap/$cheaper/$cheapest] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [утром/вечером/днем/днём]
                    q: * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$cheap/$cheaper/$cheapest] [утром/вечером/днем/днём]
                    q: * [$cheap/$cheaper/$cheapest] * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [утром/вечером/днем/днём] [$cheap/$cheaper/$cheapest]
                    # 4EX: мне без разницы дата главное дешевле
                    q: * ($cheap/$cheaper/$cheapest) *
                    q: * {($ticket/$airplaneTicket/$flight) ($cheaper/$cheapest)} *
                    # 4EX: В конце августа есть билеты
                    # 4EX: Есть ли на конец августа?
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
                        if: $session.dates1 && $session.dates2
                            if: $parseTree._or
                                go!: /aviaSearchFunc/aviaSearch
                            else:
                                go!: /aviaSearchFunc/aviaSearchRoundtrip
                        elseif: $session.dates
                            go!: /aviaSearchFunc/aviaSearch
                        elseif: $session.begOfMonth || $session.endOfMonth
                            go!: /calendarAviaFunc/monthCheapest
                        else:
                            go!: /calendarAviaFunc/theCheapest
                            #a: Чтобы найти билеты дешевле, воспользуйтесь нашим календарем цен. Для этого: \n∙ На странице поиска билетов укажите маршрут, дату поездки, количество пассажиров и нажмите «Найти». \n∙ Вы увидите страницу с результатами поиска, а на верхней строчке - календарь цен. Нажмите на него. \nВы узнаете, на какие даты можно купить самые дешевые билеты по вашему маршруту.



    state: aviaSearchPrice
        # 4EX: цена билетов
        q!: * $price [на] {($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        # 4EX: АВИАБИЛЕТЫ стоимость
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} $price [$markQuestion]
        # 4EX: сколкьо стоят билеты
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchNoInfo
        else:
            go!: /aviaSearch/aviaSearchNoInfo



    state: aviaSearchDestInfo
        # 4EX: Добрый день, Авиабилеты в Москву
        q!: * ($ticket/$airplaneTicket/$flight) * [$withBaggage] $to [$cityPreName] $iataAndRailway::destCode *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Мне нужны билеты в омск
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        # 4EX: Хочу купить билеты в омск
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Есть биоеты в омск?
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode [$markQuestion]
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} [$to] [$cityPreName] $iataAndRailway::destCode [$withBaggage] [$markQuestion]
        q!: [$beginningWords] [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$markQuestion]
        q!: [$beginningWords] [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} [$markQuestion]
        # 4EX: Найти билеты в омск
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: наличие билетов в омск
        q!: * (наличие/наличее) {($ticket/$airplaneTicket/$flight) [$withBaggage]} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * (наличие/наличее) {($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        q!: * [$withBaggage] * $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * {($ticket/$airplaneTicket/$flight) [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$withBaggage] [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * {($ticket/$airplaneTicket/$flight) [$withBaggage]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов в москву
        q!: * $price [на] {($ticket/$airplaneTicket/$flight) [$withBaggage]} * $iataAndRailway::destCode *
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * $price [на] {($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        q!: * [$withBaggage] * $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: Здравствуйте я хочу узнать почем билет стоит в Санкт-Петербург
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight) [$withBaggage]} * $iataAndRailway::destCode *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode * [$withBaggage] *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight) [$withBaggage]} *
        q!: * [$withBaggage] * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchDestInfo
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
                go!: /aviaSearch/aviaSearchNoInfo/tripCityTo



    state: aviaSearchFromDest
        # 4EX: москва - питер
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: нужны билеты москва - питер
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Хочу купить билеты москва - питер
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Есть биоеты москва - питер?
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)}
        # 4EX: Найти билеты москва - питер
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: наличие билетов москва - питер
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов москва - питер
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты мск питер
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Билет Санкт-Петербург Ош сколько стоит
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($howMuch $cost/почем/почём) *
        q!: * ($ticket/$airplaneTicket/$flight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($howMuch $cost/почем/почём) *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($howMuch $cost/почем/почём) *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * [$withBaggage] *
        q!: * [$withBaggage] * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) *
        q!: * ($howMuch $cost/почем/почём) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) *
        q!: * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($ticket/$airplaneTicket/$flight) *
        q!: * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: Я купил билеты мурманск москва москва махачкала через внукова яих анулировал надо поменят москва махачкала
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * $iataAndRailway * ($cancelPast/$returnPast/сдал/сдала/сдали) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * $iataAndRailway * ($cancelPast/$returnPast/сдал/сдала/сдали) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchFromDest
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
                go!: /aviaSearch/aviaSearchNoInfo/tripCityTo/tripCityFrom



    state: aviaSearchDatesInfo
        # 4EX: Мне нужны билеты на 12 октября
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Хочу купить билеты на 12 октября
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Есть биоеты на 12 октября?
        # 4EX: Найти билеты на 12 октября
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: наличие билетов на 12 октября
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов на 12 октября
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты на 12 октября
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Здравствуйте можно забранировать на 5 ого числа
        q!: * ($bookInf/$buyInf/$buyNoun) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($bookInf/$buyInf/$buyNoun) *
        # 4EX: Найдите мне дешевле самый дешевле билет хорошо 15-го июля
        q!: * [$withBaggage] * {($cheap/$cheaper/$cheapest) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($cheap/$cheaper/$cheapest) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($cheap/$cheaper/$cheapest) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} {($cheap/$cheaper/$cheapest) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} {($cheap/$cheaper/$cheapest) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Мне нужны билеты на 12 или 13 октября
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Хочу купить билеты на 12 или 13 октября
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Есть биоеты на 12 или 13 октября?
        # 4EX: Найти билеты на 12 или 13 октября
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {($lookForV/$lookForN) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)} * [$withBaggage] *
        # 4EX: наличие билетов на 12 или 13 октября
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов на 12 или 13 октября
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты на 12 или 13 октября
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchDatesInfo
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
                    if: $session.from && $session.dest && $session.dates
                        go!: /aviaSearchFunc/aviaSearch
                    #elseif: $session.landingFrom && $session.landingDest && $session.dates
                    else:
                        a: Уточните, пожалуйста, направление вашей поездки.



        state: tripCityTo
            q: [$to] [$cityPreName] $iataAndRailway::destCode
            q: [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
            q: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] $numberDate
            script:
                if ($parseTree._fromCode && $parseTree._destCode) {
                    $reactions.transition("/aviaSearch/aviaSearchDatesInfo/tripCityTo/tripCityFrom");
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



    state: aviaSearchDestDates
        # 4EX: завтра в магадан
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        # 4EX: цена билетов на 12 октября в магадан
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты на 12 октября в магадан
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: хочу билет до севастополя 10-11 апреля
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        # 4EX: цена билетов на 12 или 13 октября в магадан
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты на 12 или 13 октября в магадан
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] *
        q!: * [$withBaggage] * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: хочу билет до севастополя 10 или 11 апреля
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *

        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchDestDates
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



    state: aviaSearchFullInfo
        # 4EX: Краснодар Москва 12 октября
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Авиабилеты из СПб 01.08 в Нижневартовск
        q!: * [$withBaggage] * [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить билет из краснодара в москву 12 октября
        q!: * [$withBaggage] * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить билет в москву из краснодара 12 октября
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] *
        q!: * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        q!: * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        # 4EX: Краснодар купить бидеты из москвы 12 октября
        q!: * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) * [$withBaggage] *
        # 4EX: Нужен билет термез москва на завтра 10 января
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::destCode * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::destCode * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: хочу билет 9 октября вечером в веллингтон из екатеринбурга
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] *
        q!: * [$withBaggage] * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode  * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode  * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode  * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode  * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        # 4EX: Хочу купить билеты москва - питер на завтра
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * [$withBaggage] * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Есть биоеты москва - питер на завтра?
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: [$beginningWords] {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} *
        q!: [$beginningWords] [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: Найти билеты москва - питер на завтра
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        # 4EX: наличие билетов москва - питер на завтра
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: билеты в наличие москва - питер на завтра
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [$withBaggage] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [$withBaggage] *
        # 4EX: цена билетов москва - питер на завтра
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * [$withBaggage] *
        # 4EX: сколкьо стоят билеты мск питер на завтра
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [$withBaggage] * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$withBaggage] * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] *
        q!: * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Самые дешёвые Билеты на 27 сентября Москва- Стамбул
        q!: * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] *
        q!: * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] *
        q!: * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * [$withBaggage] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($cheap/$cheaper/$cheapest) [$ticket/$airplaneTicket/$flight]} * [$withBaggage] *
        # 4EX: Вильнюс - милан на 13.08. или 14.08
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] *
        q!: * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        q!: * [$withBaggage] * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate * [$withBaggage] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1) $or [на] $numberDate * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$withBaggage] *
        # 4EX: Купить авиабилет Москва-Пенза из Домодедово на 22.02.20
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$withBaggage] * $iataAndRailway [$cityPreName] $iataAndRailway::destCode [$departure] $from $iataAndRailway::fromCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} [$markQuestion]
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * $iataAndRailway [$cityPreName] $iataAndRailway::destCode [$departure] $from $iataAndRailway::fromCode [на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} [$withBaggage] [$markQuestion]

        if: ($session.landingTheme == 'ЖД') && (!$parseTree._airplaneTicket && !$parseTree._flight)
            go!: /railwaySearch/railwaySearchFullInfo
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



