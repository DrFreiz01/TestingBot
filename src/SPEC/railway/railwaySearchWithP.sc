theme: /railwaySearchWithP



    state: railwayNoInfoWithP
        q!: [$ticket] * $forAdults * $railwayAll *
        q!: [$ticket] * $railwayAll * $forAdults *
        # 4EX: Мне нужны билеты на поезд для двоих
        q!: * $forAdults * {($want/$need2) [$ticket] * $railwayAll} *
        q!: * {($want/$need2) [$ticket] * $forAdults * $railwayAll} *
        q!: * {($want/$need2) [$ticket] * $railwayAll} * $forAdults *
        # 4EX: Хочу купить билеты на поезд на троих
        q!: * $forAdults * {($buyInf/$buyNoun) * [$ticket] * $railwayAll} *
        q!: * ($buyInf/$buyNoun) * $forAdults * [$ticket] * $railwayAll *
        q!: * ($buyInf/$buyNoun) * $forAdults * $railwayAll * [$ticket] *
        q!: * ($buyInf/$buyNoun) * [$ticket] * $forAdults * $railwayAll *
        q!: * ($buyInf/$buyNoun) * [$ticket] * $railwayAll * $forAdults *
        q!: * ($buyInf/$buyNoun) * $railwayAll * $forAdults * [$ticket] *
        q!: * ($buyInf/$buyNoun) * $railwayAll * [$ticket] * $forAdults *
        q!: * $forAdults * ($buyInf/$buyNoun) * [$ticket] * $railwayAll *
        q!: * $forAdults * ($buyInf/$buyNoun) * $railwayAll * [$ticket] *
        q!: * $forAdults * [$ticket] * ($buyInf/$buyNoun) * $railwayAll *
        q!: * $forAdults * [$ticket] * $railwayAll * ($buyInf/$buyNoun) *
        q!: * $forAdults * $railwayAll * ($buyInf/$buyNoun) * [$ticket] *
        q!: * $forAdults * $railwayAll * [$ticket] * ($buyInf/$buyNoun) *
        q!: * [$ticket] * ($buyInf/$buyNoun) * $forAdults * $railwayAll *
        q!: * [$ticket] * ($buyInf/$buyNoun) * $railwayAll * $forAdults *
        q!: * [$ticket] * $forAdults * ($buyInf/$buyNoun) * $railwayAll *
        q!: * [$ticket] * $forAdults * $railwayAll * ($buyInf/$buyNoun) *
        q!: * [$ticket] * $railwayAll * ($buyInf/$buyNoun) * $forAdults *
        q!: * [$ticket] * $railwayAll * $forAdults * ($buyInf/$buyNoun) *
        q!: * $railwayAll * ($buyInf/$buyNoun) * $forAdults * [$ticket] *
        q!: * $railwayAll * ($buyInf/$buyNoun) * [$ticket] * $forAdults *
        q!: * $railwayAll * $forAdults * ($buyInf/$buyNoun) * [$ticket] *
        q!: * $railwayAll * $forAdults * [$ticket] * ($buyInf/$buyNoun) *
        q!: * $railwayAll * [$ticket] * ($buyInf/$buyNoun) * $forAdults *
        q!: * $railwayAll * [$ticket] * $forAdults * ($buyInf/$buyNoun) *
        q!: * {($buyInf/$buyNoun) * [$ticket] * $railwayAll} * $forAdults *
        # 4EX: Есть четыре биоеты на поезд?
        q!: ([$exist] [ли]) * $forAdults * $railwayTicket [$markQuestion]
        q!: ([$exist] [ли]) $railwayTicket * $forAdults * [$markQuestion]
        q!: $railwayTicket ([$exist] [ли]) * $forAdults * [$markQuestion]
        q!: $railwayTicket * $forAdults * ([$exist] [ли]) [$markQuestion]
        # 4EX: Найти жд билеты на пятерых
        q!: * $forAdults * {($lookForV/$lookForN) $railwayTicket} *
        q!: * {($lookForV/$lookForN) $railwayTicket} * $forAdults *
        # 4EX: наличие пяти жд билетов
        q!: * $forAdults * (наличие/наличее) $railwayTicket *
        q!: * (наличие/наличее) $railwayTicket * $forAdults *

        q!: * $forAdults * $railwayTicket (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayTicket (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        # 4EX: Есть ли места плацкарт на двух
        q!: * $forAdults * (мест*/$ticket) * [$ticket] * $railwayAll *
        q!: * (мест*/$ticket) * $forAdults * [$ticket] * $railwayAll *
        q!: * (мест*/$ticket) * [$ticket] * $forAdults * $railwayAll *
        q!: * (мест*/$ticket) * [$ticket] * $railwayAll * $forAdults *
        # 4EX: цена трех билетов плацкарт
        q!: * $forAdults * $price * [$ticket] * $railwayAll *
        q!: * $price * $forAdults * [$ticket] * $railwayAll *
        q!: * $price * [$ticket] * $forAdults * $railwayAll *
        q!: * $price * [$ticket] * $railwayAll * $forAdults *
        # 4EX: сколкьо стоят места плацкарт 3 взрослых 1 ребенок
        q!: * $forAdults * ($howMuch $cost) * [$ticket] * $railwayAll *
        q!: * ($howMuch $cost) * $forAdults * [$ticket] * $railwayAll *
        q!: * ($howMuch $cost) * [$ticket] * $forAdults * $railwayAll *
        q!: * ($howMuch $cost) * [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * [$ticket] * $railwayAll * ($howMuch $cost) *
        q!: * [$ticket] * $forAdults * $railwayAll * ($howMuch $cost) *
        q!: * [$ticket] * $railwayAll * $forAdults * ($howMuch $cost) *
        q!: * [$ticket] * $railwayAll * ($howMuch $cost) * $forAdults *
        # 4EX: жд билеты на 5-х
        q!: * $forAdults * [$ticket] * $railwayAll *
        q!: * [$ticket] * $forAdults * $railwayAll *
        q!: * [$ticket] * $railwayAll * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
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
                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin = undefined;
                if: $parseTree._fromCode && $parseTree._destCode && ($parseTree._dateDig || $parseTree._dateLetters || $parseTree._thatDay || $parseTree._numberDate)
                    go!: /railwaySearchFunc/railwaySearch
                elseif: $parseTree._fromCode && $parseTree._destCode
                    go!: /railwaySearchWithP/railwayNoInfoWithP/tripCityTo/tripCityFrom
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
                    go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
                else:
                    script:
                        $temp.begin = undefined;
                    if: $parseTree._fromCode && ($parseTree._dateDig || $parseTree._dateLetters || $parseTree._thatDay || $parseTree._numberDate)
                        go!: /railwaySearchFunc/railwaySearch
                    else:
                        script:
                            $session.from = $parseTree._fromCode.statCode;
                        a: На какую дату планируете поездку?



                state: tripDates
                    q: * ($dateDig/$dateLetters/$thatDay/$numberDate) *
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



    state: railwayDestInfoWithP
        # 4EX: Добрый день, 5 бидетов для взрослых на поезд в Москву, красная стрела
        q!: * $forAdults * $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        # 4EX: Мне нужны жд билеты в омск, на четверых
        q!: * $forAdults * {($want/$need2) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {($want/$need2) $railwayAll} *
        q!: * $iataAndRailway::destCode * $forAdults * {($want/$need2) $railwayAll} *
        q!: * $iataAndRailway::destCode * {($want/$need2) $railwayAll} * $forAdults *
        # 4EX: Хочу купить жд билеты на четверых в омск
        q!: * $forAdults * {$buyAllExceptPast * $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll} *
        q!: * $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $railwayAll} *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * $railwayAll} *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll} * $forAdults *
        # 4EX: Есть жд пять биоетов в омск?
        q!: {([$exist] [ли]) $railwayAll $forAdults} [$to] [$cityPreName] $iataAndRailway::destCode [$markQuestion]
        q!: {([$exist] [ли]) $railwayAll} * $forAdults * $iataAndRailway::destCode [$markQuestion]
        q!: $iataAndRailway::destCode * $forAdults * {([$exist] [ли]) $railwayAll} [$markQuestion]
        q!: $iataAndRailway::destCode * {([$exist] [ли]) $railwayAll} * $forAdults [$markQuestion]
        # 4EX: Найти 5 жд бидетов для взрослых в омск
        q!: * $forAdults * {($lookForV/$lookForN) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {($lookForV/$lookForN) $railwayAll} *
        q!: * $iataAndRailway::destCode * $forAdults * {($lookForV/$lookForN) $railwayAll} *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) $railwayAll} * $forAdults *
        # 4EX: наличие трех жд билетов в омск
        q!: * $forAdults * (наличие/наличее) $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * (наличие/наличее) $railwayAll *
        q!: * $iataAndRailway::destCode * $forAdults * (наличие/наличее) $railwayAll *
        q!: * $iataAndRailway::destCode * (наличие/наличее) $railwayAll * $forAdults *

        q!: * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::destCode * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        # 4EX: цена двух жд билетов в москву
        q!: * $forAdults * $price [на] $railwayAll * $iataAndRailway::destCode *
        q!: * $price [на] $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * $price [на] $railwayAll * $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * $price [на] $railwayAll *
        q!: * $iataAndRailway::destCode * $forAdults * $price [на] $railwayAll *
        q!: * $iataAndRailway::destCode * $price [на] $railwayAll * $forAdults *
        # 4EX: Здравствуйте я хочу узнать почем два жд билета стоят в Санкт-Петербург
        q!: * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                go!: /railwaySearchWithP/railwayNoInfoWithP/tripCityTo



    state: railwayFromDestWithP
        # 4EX: москва - питер вдвоем мягкий вагон
        q!: * $forAdults * [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * [$ticket] * $railwayAll * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $forAdults * [$ticket] * $railwayAll * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$ticket] * $forAdults * $railwayAll * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$ticket] * $railwayAll * $forAdults * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$ticket] * $railwayAll * [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        # 4EX: нужны 2 жд билета москва - питер
        q!: * $forAdults * {($want/$need2) * [$ticket] * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *

        q!: * ($want/$need2) * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($want/$need2) * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($want/$need2) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * ($want/$need2) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($want/$need2) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($want/$need2) * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($want/$need2) * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * ($want/$need2) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * ($want/$need2) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($want/$need2) * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($want/$need2) * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($want/$need2) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * ($want/$need2) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) * [$ticket] * $railwayAll} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) * [$ticket] * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket] * $forAdults * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket] * $railwayAll} * $forAdults *
        # 4EX: Хочу купить 2 билета на жд москва - питер
        q!: * $forAdults * {$buy * [$ticket] * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buy * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buy * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buy * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $buy * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * $buy * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $buy * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $buy * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $buy * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $buy * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $buy * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $buy * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * $buy * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $buy * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * $buy * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buy * [$ticket] * $railwayAll} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buy * [$ticket] * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buy * [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {$buy * [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * [$ticket] * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buy * $railwayAll * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $buy * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $buy * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $buy * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * $buy * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $buy * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $buy * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $buy * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $buy * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $buy * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $buy * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * $buy * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $buy * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * $buy *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buy * [$ticket] * $railwayAll} * $forAdults *
        # 4EX: Есть два биоета в мужской вагон москва - питер?
        q!: ([$exist] [ли]) * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: ([$exist] [ли]) * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: ([$exist] [ли]) * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: ([$exist] [ли]) * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: ([$exist] [ли]) * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: ([$exist] [ли]) * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * ([$exist] [ли]) * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * ([$exist] [ли]) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * [$ticket] * ([$exist] [ли]) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * [$ticket] * $railwayAll * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * $railwayAll * ([$exist] [ли]) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $forAdults * $railwayAll * [$ticket] * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * ([$exist] [ли]) * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * ([$exist] [ли]) * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * $forAdults * ([$exist] [ли]) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * $forAdults * $railwayAll * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * $railwayAll * ([$exist] [ли]) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$ticket] * $railwayAll * $forAdults * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * ([$exist] [ли]) * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * ([$exist] [ли]) * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * $forAdults * ([$exist] [ли]) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * $forAdults * [$ticket] * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * [$ticket] * ([$exist] [ли]) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: $railwayAll * [$ticket] * $forAdults * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: {([$exist] [ли]) * [$ticket] * $railwayAll} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {([$exist] [ли]) [$ticket] * $railwayAll}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) [$ticket] * $forAdults * $railwayAll}
        # 4EX: Ищу купе Питер-Москва на троих
        q!: * $forAdults * {($lookForV/$lookForN) * [$ticket] * $railwayAll} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $forAdults * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $forAdults * $railwayAll * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * [$ticket] * $forAdults * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * [$ticket] * $railwayAll * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $railwayAll * $forAdults * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $railwayAll * [$ticket] * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($lookForV/$lookForN) * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($lookForV/$lookForN) * $railwayAll * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * ($lookForV/$lookForN) * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($lookForV/$lookForN) * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($lookForV/$lookForN) * $forAdults * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($lookForV/$lookForN) * $railwayAll * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * ($lookForV/$lookForN) * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * ($lookForV/$lookForN) * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($lookForV/$lookForN) * $forAdults * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($lookForV/$lookForN) * [$ticket] * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($lookForV/$lookForN) * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * ($lookForV/$lookForN) * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) * [$ticket] * $railwayAll} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket] * $forAdults * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket] * $railwayAll} * $forAdults *
        # 4EX: наличие  трех мест в купе москва новосиб
        q!: * $forAdults * (наличие/наличее) * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $forAdults * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * [$ticket] * $forAdults * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * (наличие/наличее) [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * [$ticket] * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        # 4EX: цена трех купе из тюмени в челябинск
        q!: * $forAdults * $price [на] [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $price [на] [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket] * $forAdults * $railwayAll} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket] * $forAdults * $railwayAll} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket] * $railwayAll} * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                go!: /railwaySearchWithP/railwayNoInfoWithP/tripCityTo/tripCityFrom



    state: railwayDatesInfoWithP
        # 4EX: Мне нужны 2 жд билета на 12 октября
        q!: * $forAdults * {($want/$need2) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $railwayAll} * $forAdults *
        # 4EX: Хочу купить два жд билета на 12 октября
        q!: * $forAdults * {$buyAllExceptPast * $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll} * $forAdults *
        # 4EX: Есть два жд-биоеты на 12 октября?
        q!: [$exist] [ли] $forAdults * $railwayAll [на] ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [$exist] [ли] $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [$exist] [ли] $railwayAll [на] ($dateDig/$dateLetters/$thatDay) * $forAdults [$markQuestion]

        q!: $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$exist] [ли] $railwayAll [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$exist] [ли] $railwayAll [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) [$exist] [ли] $railwayAll * $forAdults [$markQuestion]

        q!: $forAdults * [на] ($dateDig/$dateLetters/$thatDay) $railwayAll [$exist] [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll [$exist] [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) $railwayAll * $forAdults [$exist] [$markQuestion]
        # 4EX: Найти 3 жд билета на 12 октября
        q!: * $forAdults * {($lookForV/$lookForN) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $railwayAll} * $forAdults *
        # 4EX: наличие двух жд билетов на 12 октября
        q!: * $forAdults * (наличие/наличее) $railwayAll [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) $railwayAll [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $railwayAll * $forAdults *

        q!: * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *
        # 4EX: цена 2 жд билетов на 12 октября
        q!: * $forAdults * $price [на] $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $price [на] $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price [на] $railwayAll * $forAdults *
        # 4EX: сколкьо стоят 3 жд билета на 12 октября
        q!: * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
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
                    $reactions.transition("/railwaySearchWithP/railwayDatesInfoWithP/tripCityTo/tripCityFrom");
                }
                $session.dest = $parseTree._destCode.statCode;
            a: Откуда вы едете?



            state: tripCityFrom
                q: [$from] [$cityPreName] $iataAndRailway::fromCode
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



    state: railwayDestDatesWithP
        # 4EX: завтра в магадан, мягкий вагон
        q!: * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *

        q!: * $railwayAll * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        # 4EX: цена 3-х жд билетов на 12 октября в магадан
        q!: * $forAdults * $price [на] $railwayAll * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] $railwayAll * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] $railwayAll * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *

        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $railwayAll *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * $price [на] $railwayAll *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $railwayAll * $forAdults *
        # 4EX: сколкьо стоят три жд билета на 12 октября в магадан
        q!: * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults *

        q!: * $forAdults * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $forAdults * {($howMuch $cost/почем/почём) $railwayAll} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $railwayAll} * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
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
                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin = undefined;
            go!: /railwaySearchFunc/railwaySearch



    state: railwayFullInfoWithP
        # 4EX: С Астаны до Шимкента на 14 декабря 2 пассажира на плацкарт
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *
        # 4EX: Купить жд билет из краснодара в москву 12 октября на двих
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode * $railwayAll * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll *
        q!: * $iataAndRailway::fromCode $forAdults * $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll *
        q!: * $iataAndRailway::fromCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $iataAndRailway::fromCode $railwayAll * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults *
        q!: * $iataAndRailway::fromCode $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ($to [$cityPreName] $iataAndRailway::destCode) * $forAdults *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *
        # 4EX: Купить 2 жд билета в москву из краснодара 12 октября
        q!: * $forAdults * $railwayAll * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $forAdults *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $forAdults * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $forAdults *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *
        q!: * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults *
        q!: * $forAdults * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $forAdults * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $iataAndRailway::fromCode * $forAdults *
        # 4EX: Краснодар купить две жд бидеты из москвы 12 октября
        q!: * $forAdults * $railwayAll * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * ($from [$cityPreName] $iataAndRailway::fromCode) * $forAdults [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * $railwayAll * $forAdults * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $railwayAll * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $iataAndRailway::destCode * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * $railwayAll * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * $railwayAll * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $railwayAll * $forAdults * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $railwayAll * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $forAdults *

        q!: * $forAdults * $iataAndRailway::destCode * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $forAdults * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * {$forAdults * $railwayAll} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * {$railwayAll * $forAdults} * $from [$cityPreName] $iataAndRailway::fromCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay)) * $forAdults *
        # 4EX: Нужен билет на поезд термез москва на завтра 10 января
        q!: * $forAdults * $railwayAll * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * {($want/$need2) * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($want/$need2) * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($want/$need2) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($want/$need2) * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * ($want/$need2) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * [$ticket] * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * ($want/$need2) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $railwayAll * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * ($want/$need2) * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * ($want/$need2) * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * ($want/$need2) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * [$ticket] * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * ($want/$need2) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $forAdults * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * ($want/$need2) * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * ($want/$need2) * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * ($want/$need2) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $railwayAll * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * ($want/$need2) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $forAdults * ($want/$need2) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($want/$need2) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($want/$need2) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($want/$need2) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($want/$need2) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($want/$need2) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($want/$need2) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($want/$need2) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($want/$need2) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * {($want/$need2) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($want/$need2) [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($want/$need2) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * $railwayAll * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($want/$need2) * [$ticket] * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($want/$need2) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($want/$need2) * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * ($want/$need2) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * [$ticket] * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * ($want/$need2) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * $railwayAll * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($want/$need2) * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($want/$need2) * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * ($want/$need2) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * [$ticket] * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * ($want/$need2) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * $forAdults * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($want/$need2) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($want/$need2) * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * ($want/$need2) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * $railwayAll * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * ($want/$need2) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * $forAdults * ($want/$need2) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) * $railwayAll * [$ticket]} * $forAdults *
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($want/$need2) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($want/$need2) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($want/$need2) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($want/$need2) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($want/$need2) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($want/$need2) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($want/$need2) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($want/$need2) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($want/$need2) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($want/$need2) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($want/$need2) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($want/$need2) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($want/$need2) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($want/$need2) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($want/$need2) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($want/$need2) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($want/$need2) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * ($want/$need2) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * ($want/$need2) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        # 4EX: Хочу купить 2 купэ москва - питер на завтра
        q!: * $forAdults * $railwayAll * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {$buyAllExceptPast * $forAdults * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: * $forAdults * {$buyAllExceptPast * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * $buyAllExceptPast * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * [$ticket] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $buyAllExceptPast * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $railwayAll * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $buyAllExceptPast * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $buyAllExceptPast * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $buyAllExceptPast * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * [$ticket] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $buyAllExceptPast * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $buyAllExceptPast * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $buyAllExceptPast * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $railwayAll * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $buyAllExceptPast * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $buyAllExceptPast * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $buyAllExceptPast * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $buyAllExceptPast * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * [$ticket] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $buyAllExceptPast * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * $buyAllExceptPast * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * [$ticket] * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $buyAllExceptPast * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $railwayAll * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $buyAllExceptPast * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $buyAllExceptPast * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $buyAllExceptPast * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $forAdults * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $buyAllExceptPast * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $railwayAll * $buyAllExceptPast * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *

        q!: * $forAdults * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $buyAllExceptPast * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $buyAllExceptPast * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * $buyAllExceptPast * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $buyAllExceptPast * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $buyAllExceptPast * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $buyAllExceptPast * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * $buyAllExceptPast * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $buyAllExceptPast * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $buyAllExceptPast * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $buyAllExceptPast * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * $forAdults * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $buyAllExceptPast * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $buyAllExceptPast * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * $buyAllExceptPast * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $buyAllExceptPast * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $buyAllExceptPast * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $buyAllExceptPast * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * $buyAllExceptPast * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $buyAllExceptPast * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $buyAllExceptPast * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $buyAllExceptPast * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $buyAllExceptPast * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * $buyAllExceptPast * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $forAdults * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $forAdults * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$ticket]} * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {$buyAllExceptPast * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * $railwayAll * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $buyAllExceptPast * [$ticket] * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $buyAllExceptPast * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $buyAllExceptPast * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * [$ticket] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * $buyAllExceptPast * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * $railwayAll * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $buyAllExceptPast * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $buyAllExceptPast * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $buyAllExceptPast * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * [$ticket] * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $buyAllExceptPast * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $buyAllExceptPast * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * $buyAllExceptPast * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * $railwayAll * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * $buyAllExceptPast * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * $forAdults * $buyAllExceptPast *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll * [$ticket]} * $forAdults *
        # 4EX: Есть биоеты в мягкий вагон москва - питер на завтра?
        q!: ([$exist] [ли]) * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: ([$exist] [ли]) * $forAdults * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: ([$exist] [ли]) * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: ([$exist] [ли]) * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: ([$exist] [ли]) * [$ticket] * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: ([$exist] [ли]) * [$ticket] * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * ([$exist] [ли]) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * ([$exist] [ли]) * [$ticket] * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * $railwayAll * ([$exist] [ли]) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * $railwayAll * [$ticket] * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * [$ticket] * ([$exist] [ли]) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $forAdults * [$ticket] * $railwayAll * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * ([$exist] [ли]) * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * ([$exist] [ли]) * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * $forAdults * ([$exist] [ли]) * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * $forAdults * [$ticket] * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * [$ticket] * ([$exist] [ли]) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: $railwayAll * [$ticket] * $forAdults * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * ([$exist] [ли]) * $forAdults * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * ([$exist] [ли]) * $railwayAll * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * $forAdults * ([$exist] [ли]) * $railwayAll * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * $forAdults * $railwayAll * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * $railwayAll * ([$exist] [ли]) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: [$ticket] * $railwayAll * $forAdults * ([$exist] [ли]) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: {([$exist] [ли]) * $railwayAll * [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: {([$exist] [ли]) * $railwayAll * [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay)
        q!: {([$exist] [ли]) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: {([$exist] [ли]) [$ticket]} * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: {([$exist] [ли]) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: {([$exist] [ли]) [$ticket]} * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: ([$exist] [ли]) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: ([$exist] [ли]) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: ([$exist] [ли]) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: ([$exist] [ли]) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: ([$exist] [ли]) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: ([$exist] [ли]) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * ([$exist] [ли]) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * ([$exist] [ли]) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * $railwayAll * ([$exist] [ли]) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * $railwayAll * [$ticket] * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * [$ticket] * ([$exist] [ли]) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $forAdults * [$ticket] * $railwayAll * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * ([$exist] [ли]) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * ([$exist] [ли]) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * $forAdults * ([$exist] [ли]) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * $forAdults * [$ticket] * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * [$ticket] * ([$exist] [ли]) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: $railwayAll * [$ticket] * $forAdults * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * ([$exist] [ли]) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * ([$exist] [ли]) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * $forAdults * ([$exist] [ли]) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * $forAdults * $railwayAll * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * $railwayAll * ([$exist] [ли]) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$ticket] * $railwayAll * $forAdults * ([$exist] [ли]) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: {([$exist] [ли]) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$exist] [ли]) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$exist] [ли]) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $forAdults * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $railwayAll * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$ticket]} * $forAdults *

        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * {([$exist] [ли]) [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {([$exist] [ли]) [$ticket]} * $forAdults *
        # 4EX: Найти билеты в женский вагон для двоих москва - питер на завтра
        q!: * $forAdults * $railwayAll * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * {($lookForV/$lookForN) * $railwayAll * [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * $forAdults * $railwayAll * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * $forAdults * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * $railwayAll * $forAdults * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * $railwayAll * [$ticket] * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * [$ticket] * $forAdults * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($lookForV/$lookForN) * [$ticket] * $railwayAll * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($lookForV/$lookForN) * $railwayAll * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * ($lookForV/$lookForN) * [$ticket] * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * ($lookForV/$lookForN) * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * $railwayAll * [$ticket] * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * ($lookForV/$lookForN) * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $forAdults * [$ticket] * $railwayAll * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * ($lookForV/$lookForN) * $forAdults * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * ($lookForV/$lookForN) * [$ticket] * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * ($lookForV/$lookForN) * [$ticket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * [$ticket] * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * ($lookForV/$lookForN) * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] * $forAdults * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * ($lookForV/$lookForN) * $forAdults * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * ($lookForV/$lookForN) * $railwayAll * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * ($lookForV/$lookForN) * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $railwayAll * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * ($lookForV/$lookForN) * $forAdults [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $forAdults * ($lookForV/$lookForN) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * {($lookForV/$lookForN) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($lookForV/$lookForN) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($lookForV/$lookForN) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($lookForV/$lookForN) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($lookForV/$lookForN) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * ($lookForV/$lookForN) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($lookForV/$lookForN) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($lookForV/$lookForN) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($lookForV/$lookForN) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * ($lookForV/$lookForN) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($lookForV/$lookForN) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($lookForV/$lookForN) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * ($lookForV/$lookForN) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * ($lookForV/$lookForN) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode ($lookForV/$lookForN) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * ($lookForV/$lookForN) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * ($lookForV/$lookForN) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * $railwayAll * ($lookForV/$lookForN) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * $railwayAll * [$ticket] * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * [$ticket] * ($lookForV/$lookForN) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $forAdults * [$ticket] * $railwayAll * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * ($lookForV/$lookForN) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * ($lookForV/$lookForN) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * $forAdults * ($lookForV/$lookForN) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * $forAdults * [$ticket] * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * [$ticket] * ($lookForV/$lookForN) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $railwayAll * [$ticket] * $forAdults * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * ($lookForV/$lookForN) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * ($lookForV/$lookForN) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * $forAdults * ($lookForV/$lookForN) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * $forAdults * $railwayAll * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * $railwayAll * ($lookForV/$lookForN) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [$ticket] * $railwayAll * $forAdults * ($lookForV/$lookForN) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$ticket]} * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $railwayAll * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($lookForV/$lookForN) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * $railwayAll * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($lookForV/$lookForN) * [$ticket] * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($lookForV/$lookForN) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($lookForV/$lookForN) * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * ($lookForV/$lookForN) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * [$ticket] * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * ($lookForV/$lookForN) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * $railwayAll * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($lookForV/$lookForN) * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($lookForV/$lookForN) * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * ($lookForV/$lookForN) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * [$ticket] * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * ($lookForV/$lookForN) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * $forAdults * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($lookForV/$lookForN) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($lookForV/$lookForN) * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * ($lookForV/$lookForN) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * $railwayAll * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * ($lookForV/$lookForN) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * $forAdults * ($lookForV/$lookForN) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) * $railwayAll * [$ticket]} * $forAdults *
        # 4EX: наличие двух жд билетов москва - питер на завтра
        q!: * $forAdults * $railwayAll * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * (наличие/наличее) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) * $forAdults * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) * $railwayAll * $forAdults * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) [$ticket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *

        q!: * $forAdults * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) [$ticket] * $forAdults *

        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * (наличие/наличее) [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (наличие/наличее) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $railwayAll * [$ticket] * $forAdults *
        # 4EX: ж/д билеты в наличие москва - питер на завтра трое
        q!: * $railwayAll * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $forAdults * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * [$ticket] (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        # 4EX: цена плацкарты москва - питер на завтра
        q!: * $forAdults * $railwayAll * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $price [на] [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $price [на] [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $price * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price * $forAdults * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price * $railwayAll * $forAdults * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price * $railwayAll * [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *


        q!: * $forAdults * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *

        q!: * $forAdults * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] [$ticket] *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * $price [на] [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $price [на] [$ticket] * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $price * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $price * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price * $railwayAll * [$ticket] * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $price [на] [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $price [на] [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] [$ticket] * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        # 4EX: сколкьо стоят билеты мск питер на завтра в плацкарт
        q!: * $forAdults * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $forAdults * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * [$ticket] * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $forAdults * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket] * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults *

        q!: * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults *


        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *

        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket] * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults *
        q!: * $forAdults * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $railwayAll * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $railwayAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $railwayAll * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $forAdults * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $forAdults * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $forAdults * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * {($howMuch $cost/почем/почём) [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($howMuch $cost/почем/почём) [$ticket]} * $forAdults *
        q!: * $forAdults * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $forAdults * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $forAdults * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * ($howMuch $cost/почем/почём) * [$ticket] * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) * [$ticket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $forAdults * [$ticket] * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($howMuch $cost/почем/почём) * $forAdults * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * ($howMuch $cost/почем/почём) * $railwayAll * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * ($howMuch $cost/почем/почём) * $railwayAll *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $forAdults * $railwayAll * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * ($howMuch $cost/почем/почём) * $forAdults *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket] * $railwayAll * $forAdults * ($howMuch $cost/почем/почём) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) * $railwayAll * [$ticket]} * $forAdults *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /railwaySearchFunc/parsing4RailwaySearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;
                go!: /railwaySearchFunc/railwaySearch