theme: /ticketReturn



    state: ticketReturnHow
        # 4EX: Как вернуть билет
        # 4EX: мне нужно отменить поездку
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: [$beginningWords] {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс))}
        # 4EX: Хотел возврат билета
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: [$beginningWords] хотел* {($annulInf/$returnInf/$return/сдать/отменить) ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        # 4EX: Я хотел бы произвести возврат билета
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        # 4EX: Добрый день. Хочу сделать возврат.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun [$markQuestion]
        # 4EX: как могу слать балеты?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($annulInf/$returnInf/сдать/слать/отменить) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} [$markQuestion]
        # 4EX: Задать можно билет
        q!: [$beginningWords] ($annulInf/$returnInf/сдать/задать/слать/отменить) ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) {[$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ)} [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ) ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        script:
            if ($client.orderList && $client.orderList.length == 1) {
                if ($temp.begin == undefined) {
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                    $temp.orderNumber = $client.orderList[0];
                    $reactions.transition('/orderInfo/getOrderInfo');
                } else {
                    $temp.begin = undefined;
                    if ($session.positionId) {
                         $reactions.answer('Чтобы вернуть билет, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                    } else {
                        $reactions.answer('Чтобы вернуть билет, перейдите в личный кабинет: https://www.ozon.travel/my\n • Если рядом с заказом вы видите кнопку «Отменить», нажмите ее и подтвердите аннуляцию заказа \n • Если вы видите кнопку «Возврат и обмен», нажмите ее, затем выберите опцию «Вернуть билет» и оформите запрос');
                    }
                }
            } else {
                $reactions.answer('Чтобы вернуть билет, перейдите в личный кабинет: https://www.ozon.travel/my\n • Если рядом с заказом вы видите кнопку «Отменить», нажмите ее и подтвердите аннуляцию заказа \n • Если вы видите кнопку «Возврат и обмен», нажмите ее, затем выберите опцию «Вернуть билет» и оформите запрос');
            }



    state: IntentReturn
        intent!: /Возврат
        a: Сработал интент
        go!: /ticketReturn/ticketReturnHow



    state: ticketRefuseHow
        # 4EX: Добрый день. Как отказаться от поездки?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (отказаться/атказаться/отказатся/откозаться/атказатся) от ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/поездк*) *
        # 4EX: мне отказ нужен я завтра не лечу 100%. Чтоб меня не искали.
        q!: * {($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) (~отказ/~атказ)} * $ne $depart *
        go!: /ticketReturn/ticketReturnHow



    state: ticketReturnApplication
        # 4EX: Здравствуйте. Мне произвели расчёт возврата авиабилета. Теперь надо заявление на возврат. Мне нужен образец заявления.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (заявление/заява) * $return *
        go!: /ticketReturn/ticketReturnHow



    state: cancelTicketOrder
        # 4EX: добрый день подскажите как отменить заказ на билет
        q!: * {$cancelInf (~заказ/~зоказ)} [на] ($ticket/$airplaneTicket/$flight) [$markQuestion]
        q!: * ($ticket/$airplaneTicket/$flight) {$cancelInf (~заказ/~зоказ)} [$markQuestion]
        # 4EX: Добрый день! Код брони BJUHEO турист Moiseeva Larisa  не может вылететь 31 декабря. В больнице ее мама. Взята страховка от невыезда. Просим помочь, как правильно аннулировать ее из заказа.
        q!: * $ne * $depart * $cancelInf * (~заказ/~зоказ) [$markQuestion]
        q!: * $ne * $depart * (~заказ/~зоказ) * $cancelInf [$markQuestion]
        q!: * $cancelInf * (~заказ/~зоказ) * $ne * $depart [$markQuestion]
        q!: * (~заказ/~зоказ) * $cancelInf * $ne * $depart [$markQuestion]
        go!: /ticketReturn/ticketReturnHow



    state: takeDownSeat
        # 4EX: снимите место
        q!: [$beginningWords] {(снемите/снимите) [$my2/$ruSvoi] (~место/$ticket/$airplaneTicket/$flight)} [$please] [$markQuestion]
        go!: /ticketReturn/ticketReturnHow



    state: ticketBuyThenReturn
        # 4EX: Здравствуйте, скажите пожалуйста, возможно ли купить авиабилеты онлайн, а случае изменения ситуации их сдать. Какая при этом потеря?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($buy/$payInf) ($ticket/$airplaneTicket)} * {их ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)} *
        a: Добровольный обмен платный, иногда это может стоить дороже, чем начальная цена билета. Заранее посчитать сумму невозможно, потому что она меняется в зависимости от даты возврата — чем ближе к вылету, тем выше сумма.



    state: returnAviaCompanysGuilt
        # 4EX: Рейс U6 уральские авиалинии ,номер билета 262-9435150672 возврат денег по вине авиакомпании
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * по вине (авиакомпани*/компани*/ак) *
        go!: /ticketReturn/ticketReturnHow



    state: returnTicketOneWay
        # 4EX: Добрый день, подскажите, пожалуйста, могу ли я сделать возврат билета только в одну сторону? И подскажите, пожалуйста, какой может быть штраф за это?
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket)} * (одн* (сторон*/направлен*)/туда/обратно) *
        q!: * (одн* (сторон*/направлен*)/туда/обратно) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket)} *
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: returnOneOfTickets
        # 4EX: Купила 2 билета в одном заказе. Как вернуть 1 билет?
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($annulInf/$returnInf/$return/сдать/отменить) (один/1)} *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($annulInf/$returnInf/$return/сдать/отменить) (один/1)} *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($annulInf/$returnInf/$return/сдать/отменить) ($ticket/$airplaneTicket/$flight)} * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) ($NumberOne/2/3) *
        # 4EX: Добрый вечер. Не могу оформить возврат билета по измененному авиакомпанией рейсу Краснодар- Москва. №298­6147503697 Остальные хочу оставить без изменений. Но в личном кабинете предлагают отменить все билеты.
        # не работает из-за faq/error
        q!: * {($annulInf/$returnInf/$return/сдать/отменить) ($ticket/$airplaneTicket/$flight)} * (остальные/оставльные/отсальные/другие) [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic] (оставить/$ne трогать) *
        a: Чтобы вернуть билет, перейдите в личный кабинет: https://www.ozon.travel/my \n • Напротив номера заказа нажмите на кнопку «Возврат и обмен», затем выберите опцию «Вернуть билет» \n • В открывшейся форме поставьте галочку рядом с именами пассажиров, отметьте нужные сегменты перелёта, и оформите запрос.



    state: ticketReturn2ndSegment
        # 4EX: Можно ли вернуть только обратный билет?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($cancelInf/$returnInf/здать/сдать) [ток*/тольк*] {(обратный/назад/домой) ($ticket/$airplaneTicket/$flight/~заказ/~зоказ)} *
        a: Вы уже пролетели по первому билету?

        state: yes
            # 4EX: да
            q: [$beginningWords] ($yes2/$yesAgreeTo)
            q: [$beginningWords] ($veryAll/весьма/висьма/весма/висма/вполне)
            q: [$beginningWords] (вроде/типа/тип) того
            q: [$beginningWords] {$yes2 ($yesAgreeTo/$yesAgreeWith)}
            q: [$beginningWords] [$yes2] бывает
            a: В таком случае сделайте следующее.
            go!: /ticketReturn/ticketReturnHow


        state: no
            # 4EX: нет же нинада
            q: [$beginningWords] $no2 [же] [$needNot]
            q: ($perhaps/пожалуй/вроде [бы/как]/вродебы) $no2 [$needNot]
            # 4EX: нет спасиба
            q: ($nee/$ne) {[$needNot] [$thanks2]}
            q: [$beginningWords] $thanks2 ($nee/$ne) [$needNot]
            q: $beginningWords ($nee/$ne) {[$needNot] [$thanks2]}
            # 4EX: Нет, спасибо
            q: $no2 {$thanks2 [$needNot]}
            q: ($beginningWords/$perhaps/пожалуй/вроде [бы/как]/вродебы) $no2 {$thanks2 [$needNot]}
            a: Обращаем ваше внимание: заявку на возврат нужно прислать сразу после того, как вы пролетите по первому билету. Но уже сейчас вы можете оставить заявку на расчет стоимости возврата: рядом с номером интересующего вас заказа нажмите на кнопку «Возврат и обмен», выберите опцию «Вернуть билет» и оформите заявку на расчет возврата: https://www.ozon.travel/my.



    state: tellMeOrderId
        a: Или вы можете назвать мне номер своего заказа.

        state: returnTicketUrl
            q: * $orderNumber * || fromState = .., onlyThisState = true
            go!: /ticketReturn/iWannaReturnOrder



    state: iWannaReturnOrderNumb
        # 4EX: Здравствуйте. Хочу вернуть деньги по заказу 17950737-0001.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber *
        q!: * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber *
        q!: * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        # 4EX: по заказу 11675002-0076 . У жены температура, нас не пустят в страну. необходимо отменять
        q!: * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $cancelInf *
        q!: * $orderNumber * $cancelInf * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $cancelInf * $orderNumber *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $cancelInf *
        q!: * $cancelInf * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber *
        q!: * $cancelInf * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        # 4EX: Добрый день! В связи с тем, что Вьетнам ограничил въезд и выдачу виз, мне бы хотелось вернуть купленные билеты. Перевозчики Аэрофлот и Вьетнамские авиалинии. Подскажите, пожалуйста, нам вернут деньги за билеты? Номер заказа 13453666-0003
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * [заказ*/злказ*/зоказ*] $orderNumber *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * [заказ*/злказ*/зоказ*] $orderNumber * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} *
        q!: * [заказ*/злказ*/зоказ*] $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} *
        # 4EX: Добрый день! Мной куплен авиабилет через Озон по направлению Москва-Барселона- Порту на 26 апреля. В виду того, что сейчас запретили вылету в Европу, я вынуждена отменить мою поездку и вернуть авиабилеты. Это не мое желание, а необходимость подчиниться правилам государства. Номер брони 10434575-0012.
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * $orderNumber *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * $orderNumber * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} *
        q!: * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * $orderNumber *
        q!: * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * $orderNumber * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} *
        q!: * $orderNumber * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        if: $temp.begin == undefined
            script:
                $temp.begin = true;
                $client.executeState = $context.currentState;
                $temp.orderNumber = $parseTree._orderNumber;
            go!: /orderInfo/getOrderInfo
        else:
            script:
                $temp.begin = undefined;
                if ($session.positionId) {
                    $reactions.answer('Чтобы вернуть билеты, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.transition('/ticketReturn/ticketReturnHow');
                }



    state: iWannaReturnOrderNumbFromDest
        # 4EX: Здравствуйте! Я покупала авиабилеты На рейс Улан-Удэ- Владивосток. Номер заказа 18098546-0001. Вчера меня экстренно прооперировали и я , к сожалению, не смогу лететь. Как я могу сдать билеты и вернуть деньги?
        q!: * $iataAndRailway * $iataAndRailway * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        go!: /ticketReturn/iWannaReturnOrderNumb




    state: ticketReturnSameDay
        # 4EX: Здравствуйте. Подскажите можно будет аннулировать данный Заказ № 14858650-0095 в день его оформления?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($orderNumber/~заказ) * (в тот же день /в день * (оформления/покупки)/тем же днем) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * (в тот же день /в день * (оформления/покупки)/тем же днем) * ($orderNumber/~заказ) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($orderNumber/~заказ) * ($annulInf/$returnInf/$return/сдать/отменить) * (в тот же день /в день * (оформления/покупки)/тем же днем) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($orderNumber/~заказ) * (в тот же день /в день * (оформления/покупки)/тем же днем) * ($annulInf/$returnInf/$return/сдать/отменить) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в тот же день /в день * (оформления/покупки)/тем же днем) * ($annulInf/$returnInf/$return/сдать/отменить) * ($orderNumber/~заказ) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в тот же день /в день * (оформления/покупки)/тем же днем) * ($orderNumber/~заказ) * ($annulInf/$returnInf/$return/сдать/отменить) *
        go!: /operator/goToOpeartor



    state: iHaveQuestionAboutReturn
        # 4EX: У меня вапрос по вазрату
        q!: [$beginningWords] [у $meGenAcc] $question2 [$about] [$my2/$ruSvoi] $return [$markQuestion]
        # 4EX: по поводу возврата билета
        q!: [$beginningWords] $about ($return/сдачу/сдачи/$annulNoun/отмены) {[$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] [$ticket/$airplaneTicket]} [$markQuestion]
        # 4EX: вопрос по возврату билета
        q!: [$beginningWords] [у ($meGenAcc/нас)] (вопрос*/вопроз*/ворпос*) ($about/$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket)} [$markQuestion]
        q!: [$beginningWords] ($about/$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket)} [у ($meGenAcc/нас)] (вопрос*/вопроз*/ворпос*) [$markQuestion]
        a: Чем я могу вам помочь?



    state: returnTicketError
        # 4EX: Добрый день! В связи с опасностью короновирусом отменилась поездка, пытался сдать билет, хотел понять итого почему он не сдался
        q!: * (хотел*/пыталс*/пыталас*/надеял*) * ($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * {(он/они) ($ne сдался)}
        q!: * (хотел*/пыталс*/пыталас*/надеял*) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($cancelInf/$returnInf/здать/сдать) * {(он/они) ($ne сдался)}
        q!: * (хотел*/пыталс*/пыталас*/надеял*) * ($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($succeedInNot/$cannotI) *
        q!: * (хотел*/пыталс*/пыталас*/надеял*) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($cancelInf/$returnInf/здать/сдать) * ($succeedInNot/$cannotI) *
        # 4EX: Здравствуйте,мне нужно вернуть билет,но он не отображается в личном кабинете
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $ne (вижу/видн*/виден/видны/отображ*/отоброж*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulInf/$returnInf/$return/сдать/отменить) * $ne (вижу/видн*/виден/видны/отображ*/отоброж*) *
        q!: * $ne (вижу/видн*/виден/видны/отображ*/отоброж*) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) *
        go!: /operator/goToOpeartor



    state: cancelTicketReturn
        # 4EX: прошу срочно восстановить отмененный рейс
        q!: * восстановит* ($cancelPast/$returnPast) ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)
        go!: /operator/goToOpeartor



    state: whatsUpWithMyReturn
        # 4EX: Можно поинтересоваться, как обстоят дела с моим возвратом денежных средств за билет?
        q!: * $how [обстоит/обстоят] (дело/дела) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $how [обстоит/обстоят] (дело/дела) *
        q!: [$beginningWords] $what2 [там] [с/по] [$my2/$ruSvoi] {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: [$beginningWords] [с/по] [$my2/$ruSvoi] {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)}  $what2 [там] [$markQuestion]
        # 4EX: Добрый день! можно ли узнать по возврату авиабилетов есть решение уже какое то?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ) * (статус*/решение) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (статус*/решение) * $return * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ) *
        #go!: /operator/goToOpeartor
        go!: /faq/coronaVirus



#    state: ticketReturnEmergency
#        # 4EX: можно ли вернуть авиабилет срочно
#        q!: * ($possiblePredic/$canSg1) * {$returnInf (срочно/срочна) ([$my2/$ruSvoi] ($ticket/$airplaneTicket))} *
#        a: Найдите в личном кабинете рядом с вашим заказом ссылку "Возврат и обмен" и заполните заявление: http://www.ozon.travel/my/orders. Чем раньше сделан возврат, тем больше шансов избежать максимальных потерь. Запрос на срочный возврат нужно присылать минимум за 4 часа до начала регистрации на рейс. В этом случае он гарантированно будет нами обработан. После начала регистрации начинают действовать повышенные штрафные санкции за возврат билета.




    state: ticketReturnCoronaV
        # 4EX: Добрый день. У меня куплены билеты в Милан на июль месяц. Туда и обратно. Как в связи с ситуацией в Италии с короновирусом сдать мои билеты с возрастом полной суммы денег.
        q!: * $coronaV * $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * $coronaV * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * $coronaV * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $iataAndRailway *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $iataAndRailway *
        q!: * $iataAndRailway * $coronaV * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) *
        q!: * $iataAndRailway * $coronaV * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $coronaV *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $coronaV * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $coronaV *
        q!: * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $coronaV * $iataAndRailway *
        q!: * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $iataAndRailway * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $coronaV * $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * $iataAndRailway * $coronaV * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $coronaV * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $iataAndRailway * $coronaV *
        # 4EX: Добрый день! Мы хотим отменить рейсы на 29 апреля-8 мая Ереван-Москва и обратно из-за сложившейся ситуации с короновирусом, просьба вернуть все дентги за билеты на Калачеву Марину и на Линовицкую Елену как быстро это можно сделать?
        q!: * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway *
        q!: * $coronaV * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * $coronaV *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $coronaV * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $coronaV * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $coronaV * $iataAndRailway * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters) * ($dateDig/$dateLetters/$numberDate) * $iataAndRailway * $iataAndRailway * $coronaV *
        # 4EX: Добрый день,  я купила билеты  на Москву на 20 марта и обратно на 5 апреля, с Москвы мы должны били ехать в Молдавию, но из за кароновируса с 17 марта закрывают сообщения между Россией, Украиной и Молдавией, как нам сдать билеты.
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV *
        q!: * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * $iataAndRailway * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $iataAndRailway * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * $coronaV *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * $iataAndRailway *
        q!: * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * $coronaV * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} *
        q!: * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway *
        q!: * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $coronaV * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway * $coronaV *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $coronaV * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $coronaV * $iataAndRailway * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $coronaV * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway * $iataAndRailway *
        a: • Убедитесь, что авиакомпания, которой вы летите, отменила рейс: https://www.ozon.travel/help/avia/coronavirus_news_from_airlines\n • Чтобы вернуть билет, перейдите в личный кабинет: https://www.ozon.travel/my, нажмите кнопку «Возврат и обмен», затем выберите опцию «Вернуть билет» и оформите вынужденный возврат



    state: ticketReturnFromDest
        # 4EX: Необходимо сдать билет Москва -Краснодар
        q!: * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket) *
        q!: * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * ($ticket/$airplaneTicket) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * ($ticket/$airplaneTicket) *
        q!: * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * ($ticket/$airplaneTicket) * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway *
        q!: * ($ticket/$airplaneTicket) * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        q!: * ($ticket/$airplaneTicket) * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway *

        q!: * $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway *
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway *
        # 4EX: нужны сдать билеты москва - питер
        q!: * {($want/$need2) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} * [$from] [$cityPreName] $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway *
        q!: * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * {($want/$need2) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} *
        # 4EX: Хочу сдать прямые билеты москва - питер
        q!: * {$buyVerbPast ($ticket/$airplaneTicket)} * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) * [$from] [$cityPreName] $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway *
        q!: * $iataAndRailway {[$oneWord] [$to] [$cityPreName]} $iataAndRailway * {$buyVerbPast ($ticket/$airplaneTicket)} * ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) *
        go!: /ticketReturn/ticketReturnHow



    state: ticketReturnDestDates
        # 4EX: хочу вернуть билет в Магадан на 14 февраля
        q!: * {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway * {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} [$to] [$cityPreName] $iataAndRailway *
        q!: * {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway [на] ($dateDig/$dateLetters/$thatDay) * {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *
        q!: * $iataAndRailway {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} [на] ($dateDig/$dateLetters/$thatDay) *
        # 4EX: цена на сдачу билета на 15 марта в Ереван
        q!: * $price [на] {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway)} * $price [на] $directFlight *
        # 4EX: сколкьо стоит аннулировать билеты на 12 октября в магадан
        q!: * {($howMuch $cost/почем/почём) {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway)} * {($howMuch $cost/почем/почём) {($annulInf/$returnInf/сдать/слать/$return/сдачу/сдачи/$annulNoun/отменить/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} *
        # 4EX: Здравствуйте! Как мне вернуть билет? Гейдар Алиев,терминал 2 ВЫЛЕТ В ЧЕТВЕРГ 19 марта в 19:00
        q!: * {($cancelInf/$returnInf/задать/здать/сдать) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~заказ/~зоказ/~поездка/~рейс)} * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        go!: /ticketReturn/ticketReturnHow



    state: ticketReturnFullInfo3cities
        # 4EX: Добрый день. Вчера приобрел билеты Самара-Москва-Самара. на 17.05-19.05. Нужно было вылететь из Москвы вечером 19.05. Но при заказе допустил ошибку и заказал билет на 00:40ч 19.05. Могу ли я вернуть билет Москва -Самара?
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) * [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) *
        q!: * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) *
        q!: * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] *
        q!: * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * [$ticket/$airplaneTicket] [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * [$ticket/$airplaneTicket] [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * [$ticket/$airplaneTicket] [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * [$ticket/$airplaneTicket] [$roundTrip] * ($dateDig/$dateLetters/$numberDate) * ($dateDig/$dateLetters) * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *
        # 4EX: москва питер москва 01.04-05.04 сдать билеты
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * $doubleDate [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate [$roundTrip] *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * $doubleDate [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * $doubleDate *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] * $doubleDate *
        q!: * $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * $doubleDate *
        q!: * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway * $doubleDate *
        q!: * [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate *


        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] *
        q!: * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * [$roundTrip] *
        q!: * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway * [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * $doubleDate [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * $doubleDate [$roundTrip] * $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *

        q!: * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} [$roundTrip] * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * [$ticket/$airplaneTicket] [$roundTrip] * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway *
        q!: * [$ticket/$airplaneTicket] [$roundTrip] * $doubleDate $iataAndRailway $iataAndRailway $iataAndRailway * {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *
        go!: /ticketReturn/ticketReturnHow
