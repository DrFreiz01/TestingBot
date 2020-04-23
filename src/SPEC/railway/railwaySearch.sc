theme: /railwaySearch



    state: railwaySearchNoInfo
        # 4EX: жд билет
        # 4EX: билет на поезд
        q!: * {[$direct] $ticket} * $railwayAll
        q!: {[$direct] $railwayTicket}
        # 4EX: Мне нужны билеты на поезд
        q!: * {($want/$need2) [$direct] $railwayTicket} [$markQuestion]
        q!: * {($want/$need2) [$direct] [$ticket] * $railwayAll} [$markQuestion]
        # 4EX: Хочу купить билеты на поезд
        q!: * {($buyInf/$buyNoun) * [$direct] $railwayTicket} [$markQuestion]
        q!: * {($buyInf/$buyNoun) * [$direct] [$ticket] * $railwayAll} [$markQuestion]
        # 4EX: Есть биоеты на поезд?
        q!: {([$exist] [ли]) [$direct] $railwayTicket} [$markQuestion]
        # 4EX: Найти жд билеты
        q!: * {($lookForV/$lookForN) [$direct] $railwayTicket} [$markQuestion]
        # 4EX: наличие жд билетов
        q!: * (наличие/наличее) {[$direct] $railwayTicket} [$markQuestion]
        q!: * {[$direct] $railwayTicket} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$markQuestion]
        # 4EX: Добрый вечер.Скажите пожалуйста вы сможете помочь в поиске жд билетов ?
        q!: * $help * {($lookForV/$lookForN) [$direct] $railwayTicket} [$markQuestion]
        # 4EX: Есть ли места плацкарт
        q!: * (мест*/$ticket) * {[$direct] [$ticket]} * $railwayAll [$markQuestion]
        # 4EX: цена билетов плацкарт
        q!: * $price * {[$direct] [$ticket]} * $railwayAll [$which] [$markQuestion]
        # 4EX: сколкьо стоят места плацкарт
        q!: * ($howMuch $cost) * {[$direct] [$ticket]} * $railwayAll *
        q!: * {[$direct] [$ticket]} * $railwayAll * ($howMuch $cost) *
        # 4EX: Здравствуйте, а как приобрести билеты через интернет на поезд?
        q!: * ($buyInf/$buyNoun) * {[$direct] $ticket $online ((в/на) $railwayAll)} [$markQuestion]
        q!: * [$direct] $ticket * {($buyInf/$buyNoun) $online ((в/на) $railwayAll)} [$markQuestion]
        # 4EX: Как купить жд билеты электронно?
        q!: * ($buyInf/$buyNoun) * {[$direct] ($railwayTicket/$railwayAll) $online} [$markQuestion]
        q!: * [$direct] ($railwayTicket/$railwayAll) * {($buyInf/$buyNoun) $online} [$markQuestion]
        # 4EX: Помогите приобрести и оплатить билет
        q!: * ($buyInf/$buyNoun) * {$payAll [$direct] $railwayTicket} [$markQuestion]
        q!: * $payAll * {($buyInf/$buyNoun) [$direct] $railwayTicket} [$markQuestion]
        q!: * {[$direct] $railwayTicket} * {$payAll [и] ($buyInf/$buyNoun)} [$markQuestion]
        #a: Так как цены и количество билетов меняются на сайте в режиме онлайн, то рекомендуем вам выбрать билеты на сайте самостоятельно.
        #a: Чтобы посмотреть билеты из Пункта А в Пункт Б: \n∙ Пройдите по ссылке: https://www.ozon.travel/railway \n∙ В поле «Откуда» напишите Пункт А \n∙ В поле «Куда» напишите Пункт Б \n∙ Затем выберите количество пассажиров. \n∙ В календаре рядом выберите даты вашей поездки и нажмите «Найти». В поиске появятся все поезда на выбранный вами день. Посмотрите, в какое время вам удобнее поехать, нажмите на это поле и приступайте к бронированию.
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /railwaySearchFunc/varsCleaning_DYN
        else:
            script:
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
                    go!: /railwaySearch/railwaySearchNoInfo/tripCityTo/tripCityFrom
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
                    q: * ($dateDig/$dateLetters/$thatDay) *
                    q: * $numberDate
                    # ИЛИ
                    q: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
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



    state: railwaySearchFromDest
        # 4EX: москва - питер мягкий вагон
        q!: * {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $railwayAll * {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * {[$direct] [$ticket]} * $railwayAll * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $railwayAll * {[$direct] [$ticket]} * [$to] [$cityPreName] $iataAndRailway::destCode *
        # 4EX: нужны жд билеты москва - питер
        q!: * {($want/$need2) * {[$direct] [$ticket]} * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) {[$direct] [$ticket]} * $railwayAll} *
        # 4EX: Хочу купить билеты на жд москва - питер
        q!: * {$buy * {[$direct] [$ticket]} * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buy * {[$direct] [$ticket]} * $railwayAll} *
        # 4EX: Есть биоеты в мужской вагон москва - питер?
        q!: {([$exist] [ли]) * {[$direct] [$ticket]} * $railwayAll} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) {[$direct] [$ticket]} * $railwayAll}
        # 4EX: Ищу купе Питер-Москва на троих
        q!: * {($lookForV/$lookForN) * {[$direct] [$ticket]} * $railwayAll} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) {[$direct] [$ticket]} * $railwayAll} *
        # 4EX: наличие мест в купе москва новосиб
        q!: * (наличие/наличее) * {[$direct] [$ticket]} * $railwayAll [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll *
        q!: * {[$direct] [$ticket]} * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена трех купе из тюмени в челябинск
        q!: * $price [на] {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) {[$direct] [$ticket]} * $railwayAll} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) {[$direct] [$ticket]} * $railwayAll} *
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
                go!: /railwaySearch/railwaySearchNoInfo/tripCityTo/tripCityFrom



    state: railwaySearchDestInfo
        # 4EX: Добрый день, билет на поезд в Москву, красная стрела
        q!: * $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode *
        # 4EX: Мне нужны жд билеты в омск
        q!: * {($want/$need2) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * {($want/$need2) $railwayAll} *
        # 4EX: Хочу купить жд билеты в омск
        q!: * {$buyAllExceptPast * $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll} *
        # 4EX: Есть жд биоеты в омск?
        q!: {([$exist] [ли]) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode [$markQuestion]
        q!: $iataAndRailway::destCode * {([$exist] [ли]) $railwayAll} [$markQuestion]
        # 4EX: Найти жд билеты в омск
        q!: * {($lookForV/$lookForN) $railwayAll} [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * {($lookForV/$lookForN) $railwayAll} *
        # 4EX: наличие жд билетов в омск
        q!: * (наличие/наличее) $railwayAll [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * (наличие/наличее) $railwayAll *
        q!: * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена жд билетов в москву
        q!: * $price [на] $railwayAll * $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * $price [на] $railwayAll *
        # 4EX: Здравствуйте я хочу узнать почем жд билет стоит в Санкт-Петербург
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * $iataAndRailway::destCode *
        q!: * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) $railwayAll} *
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
                go!: /railwaySearch/railwaySearchNoInfo/tripCityTo



    state: railwaySearchDatesInfo
        # 4EX: на 20 8 2019 купе или плацкарт
        q!: [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        # 4EX: Мне нужны жд билеты на 12 мая
        q!: * {($want/$need2) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) $railwayAll} *
        # 4EX: Хочу купить жд билеты на 12 мая
        q!: * {$buyAllExceptPast * $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll} *
        # 4EX: Есть жд-биоеты на 12 мая?
        q!: [$exist] [ли] $railwayAll [на] ($dateDig/$dateLetters/$thatDay) [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) [$exist] [ли] $railwayAll [$markQuestion]
        q!: [на] ($dateDig/$dateLetters/$thatDay) $railwayAll [$exist] [$markQuestion]
        # 4EX: Найти жд билеты на 12 мая
        q!: * {($lookForV/$lookForN) $railwayAll} [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) $railwayAll} *
        # 4EX: наличие жд билетов на 12 мая
        q!: * (наличие/наличее) $railwayAll [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) $railwayAll *
        q!: * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена жд билетов на 12 мая
        q!: * $price [на] $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $price [на] $railwayAll *
        # 4EX: сколкьо стоят жд билеты на 12 мая
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) $railwayAll} *
        # ИЛИ
        q!: [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $railwayAll * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion]
        # 4EX: Мне нужны жд билеты на 12 или 16 мая
        q!: * {($want/$need2) $railwayAll} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) $railwayAll} *
        # 4EX: Хочу купить жд билеты на 12 или 16 мая
        q!: * {$buyAllExceptPast * $railwayAll} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * $railwayAll} *
        # 4EX: Есть жд-биоеты на 12 или 16 мая?
        q!: [$exist] [ли] $railwayAll [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion]
        q!: [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$exist] [ли] $railwayAll [$markQuestion]
        q!: [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) $railwayAll [$exist] [$markQuestion]
        # 4EX: Найти жд билеты на 12 или 16 мая
        q!: * {($lookForV/$lookForN) $railwayAll} [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) $railwayAll} *
        # 4EX: наличие жд билетов на 12 или 16 мая
        q!: * (наличие/наличее) $railwayAll [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) $railwayAll *
        q!: * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена жд билетов на 12 или 16 мая
        q!: * $price [на] $railwayAll * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] $railwayAll *
        # 4EX: сколкьо стоят жд билеты на 12 или 16 мая
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) $railwayAll} *
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
                    $reactions.transition("/railwaySearch/railwaySearchDatesInfo/tripCityTo/tripCityFrom");
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



    state: railwaySearchDestDates
        # 4EX: завтра в магадан, мягкий вагон
        q!: * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        # 4EX: цена жд билетов на 12 декабря в магадан
        q!: * $price [на] $railwayAll * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $railwayAll *
        # 4EX: сколкьо стоят жд билеты на 12 декабря в магадан
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $railwayAll} *
        # ИЛИ
        q!: * $railwayAll * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $railwayAll * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        # 4EX: цена жд билетов на 12 или 13 декабря в магадан
        q!: * $price [на] $railwayAll * {([на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {([на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] $railwayAll *
        # 4EX: сколкьо стоят жд билеты на 12 или 13 декабря в магадан
        q!: * {($howMuch $cost/почем/почём) $railwayAll} * {([на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {([на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) $railwayAll} *
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



    state: railwaySearchFullInfo
        # 4EX: С Астаны до Шимкента на 14 декабря 2 пассажира на плацкарт
        # 4EX: москва питер мякий вагон на зватра
        q!: * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        # 4EX: Купить жд билет из краснодара в москву 12 октября
        q!: * $railwayAll * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *

        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        # 4EX: Купить жд билет в москву из краснодара 12 октября
        q!: * $railwayAll * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *

        q!: * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll *
        q!: * ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $iataAndRailway::fromCode *
        # 4EX: Краснодар купить жд бидеты из москвы 12 октября
        q!: * $railwayAll * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * $railwayAll *
        q!: * $iataAndRailway::destCode * $railwayAll * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode * $railwayAll * ([на] ($dateDig/$dateLetters/$thatDay))} *
        # 4EX: Нужен билет на поезд термез москва на завтра 10 января
        q!: * $railwayAll * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) * $railwayAll * [$direct] [$ticket]} *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($want/$need2) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        # 4EX: Хочу купить 2 купэ москва - питер на завтра
        q!: * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} *
        # 4EX: Есть биоеты в мягкий вагон москва - питер на завтра?
        q!: {([$exist] [ли]) * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay)
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: {([$exist] [ли]) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$exist] [ли]) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {([$exist] [ли]) [$direct] [$ticket]} *
        # 4EX: Найти билеты в женский вагон москва - питер на завтра
        q!: * $railwayAll * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * [на] ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} *
        # 4EX: наличие жд билетов москва - питер на завтра
        q!: * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} *
        # 4EX: ж/д билеты в наличие москва - питер на завтра
        q!: * $railwayAll * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        # 4EX: цена плацкарты москва - питер на завтра
        q!: * $railwayAll * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $price * $railwayAll * {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $price * $railwayAll * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] {[$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price * $railwayAll * {[$direct] [$ticket]} *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $price [на] {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * {[$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *
        # 4EX: сколкьо стоят билеты мск питер на завтра в плацкарт
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * ($dateDig/$dateLetters/$thatDay) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} *
        # ИЛИ
        q!: * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        # 4EX: Купить жд билет из краснодара в москву на 12 или 18 января
        q!: * $railwayAll * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * {($to [$cityPreName] $iataAndRailway::destCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) * $railwayAll * (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *

        q!: * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *
        # 4EX: Купить жд билет в москву из краснодара на 12 или 18 января
        q!: * $railwayAll * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} * $railwayAll *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$from] [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *

        q!: * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $to [$cityPreName] $iataAndRailway::destCode * $railwayAll * $iataAndRailway::fromCode *
        # 4EX: Краснодар купить жд бидеты из москвы на 12 или 18 января
        q!: * $railwayAll * {($from [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) * $railwayAll * (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($from [$cityPreName] $iataAndRailway::fromCode) (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} * $railwayAll *
        q!: * $iataAndRailway::destCode * $railwayAll * {$from [$cityPreName] $iataAndRailway::fromCode (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode * $railwayAll * (($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2))} *
        # 4EX: Нужен билет на поезд термез москва на 12 или 18 января
        q!: * $railwayAll * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * {($want/$need2) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) * $railwayAll * [$direct] [$ticket]} *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($want/$need2) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        # 4EX: Хочу купить 2 купэ москва - питер на 12 или 18 января
        q!: * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {$buyAllExceptPast * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$buyAllExceptPast * $railwayAll * [$direct] [$ticket]} *
        # 4EX: Есть биоеты в мягкий вагон москва - питер на 12 или 18 января?
        q!: {([$exist] [ли]) * $railwayAll * [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: {([$exist] [ли]) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {([$exist] [ли]) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) {([$exist] [ли]) [$direct] [$ticket]} * $railwayAll *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) {([$exist] [ли]) [$direct] [$ticket]} *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * {([$exist] [ли]) [$direct] [$ticket]} *
        # 4EX: Найти билеты в женский вагон москва - питер на 12 или 18 января
        q!: * $railwayAll * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($lookForV/$lookForN) * $railwayAll * [$direct] [$ticket]} *
        # 4EX: наличие жд билетов москва - питер на 12 или 18 января
        q!: * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) {[$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * (наличие/наличее) {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (наличие/наличее) * $railwayAll * {[$direct] [$ticket]} *
        # 4EX: ж/д билеты в наличие москва - питер на 12 или 18 января
        q!: * $railwayAll * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {[$direct] [$ticket]} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$from] [$cityPreName] $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * $railwayAll * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {[$direct] [$ticket]} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        # 4EX: цена плацкарты москва - питер на 12 или 18 января
        q!: * $railwayAll * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $price * $railwayAll * {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] {[$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $price [на] {[$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * $price * $railwayAll * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] {[$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * $price [на] {[$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $price * $railwayAll * {[$direct] [$ticket]} *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * $price [на] {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price * $railwayAll * {[$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {[$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        # 4EX: сколкьо стоят билеты мск питер на 12 или 18 января в плацкарт
        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *

        q!: * $railwayAll * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} * $railwayAll *
        q!: * $iataAndRailway::fromCode * $railwayAll * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $railwayAll * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * $railwayAll * {($howMuch $cost/почем/почём) [$direct] [$ticket]} *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($howMuch $cost/почем/почём) * $railwayAll * [$direct] [$ticket]} *
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




