theme: /returnForced



    state: flightCanceled
        # 4EX: Добрый день. Наш рейс отменили, как я могу получить свои деньги обратно?
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) *
        # 4EX: Добрый день! Авиакомпания отменила рейс. Как вернуть денежные средства?
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($flight/~рейс) * ($cancelPast/$ne состоит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($cancelPast/$ne состоит*) * ($flight/~рейс) *
        # 4EX: Отменили рейс что делать теперь?
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) * $whatShouldIDo *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * $whatShouldIDo *
        # 4EX: Добрый вечер! Просим аннулировать обратный вылет, так как рейс Хельсинки-Спб отменили. Визы шенген у нас нет, и из Хельсинки не выбраться. Поэтому обратный билет не нужен. Напишите условия аннуляции и что для этого необходимо сделать.
        q!: * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * ($flight/~рейс) * ($cancelPast/$ne состоит*) *
        q!: * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * ($cancelPast/$ne состоит*) * ($flight/~рейс) *
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        q!: * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * ($flight/~рейс) * $iataAndRailway * $iataAndRailway * ($cancelPast/$ne состоит*) *
        q!: * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * ($cancelPast/$ne состоит*) * ($flight/~рейс) * $iataAndRailway * $iataAndRailway *
        q!: * ($flight/~рейс) * $iataAndRailway * $iataAndRailway * ($cancelPast/$ne состоит*) * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * $iataAndRailway * $iataAndRailway * {($cancelInf/$returnInf/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        # 4EX: Как мне оформить возврат в связи с тем что авиакомпания отменила рейс?
        # 4EX: Здравствуйте, в связи с отменой рейса S7 5869, хочу оформить возврат билетов.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun * ($cancelPast/$ne состоит*/~отмена) * ($flight/~рейс/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun * ($flight/~рейс/$order) * ($cancelPast/$ne состоит*/~отмена) *
        q!: * ($cancelPast/$ne состоит*/~отмена) * ($flight/~рейс/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun *
        q!: * ($flight/~рейс/$order) * ($cancelPast/$ne состоит*/~отмена) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun *
        a: Если ваш рейс был отменен, вам необходимо оформить вынужденный возврат. Заполните электронное заявление, нажав на кнопку «‎Возврат и обмен» на странице заказа в личном кабинете: https://www.ozon.travel/my



    state: flightCanceledOrderNumb
        # 4EX: Добрый день! Подскажите, пожалуйста, как оформить возврат стоимости билетов по заказу 14578312-0002, отменённого авиакомпанией S7?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun * ($cancelPast/$ne состоит*) * ($flight/~рейс/$order) * $orderNumber *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun * ($flight/~рейс/$order) * $orderNumber * ($cancelPast/$ne состоит*) *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс/$order) * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun *
        q!: * ($flight/~рейс/$order) * $orderNumber * ($cancelPast/$ne состоит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $returnNoun *
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
                    $reactions.answer('Если ваш рейс был отменен, вам необходимо оформить вынужденный возврат по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.transition('/returnForced/flightCanceled');
                }



    state: flightCanceledEarlierReplacement
        # 4EX: Добрый день. По закаазу 15716932-0694 Сочи Москва 11.02 рейс итменен и предложена альтернатива с более поздним вылетом.. А что то пораньше нет?
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) * (предложен*/предложил*) * ($flight/~рейс/$departure) * {(*раньше/*ранше) ($no2/$exist)} [$markQuestion]
        q!: * ($flight/~рейс) * ($cancelPast/$ne состоит*) * (предложен*/предложил*) * {(*раньше/*ранше) ($no2/$exist)} ($flight/~рейс/$departure) *
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * (предложен*/предложил*) * ($flight/~рейс/$departure) * {(*раньше/*ранше) ($no2/$exist)} [$markQuestion]
        q!: * ($cancelPast/$ne состоит*) * ($flight/~рейс) * (предложен*/предложил*) * {(*раньше/*ранше) ($no2/$exist)} ($flight/~рейс/$departure) *
        go!: /operator/goToOpeartor



    state: ticketReturnForced
        # 4EX: вынужденный возврат билетов
        q!: * вынужден* $return [$oneWord] [$my2/$ruSvoi] ($ticket/$airplaneTicket) *
        a: Вы можете вернуть купленный билет, оформив вынужденный или добровольный возврат. О том, как это сделать, и как понять, какой тип возврата оформлять, подробно описано на нашем сайте: https://www.ozon.travel/help/avia/how-to/return
        go!: /ticketReturn/tellMeOrderId


        state: ticketReturnForcedOther
            # 4EX: другое
            # 4EX: а по болезни?
            q: * (другое/еще/ещё/друг* ~случай) *
            q: * (~болезнь/~смерть/отказ* в виз*/не да* виз*) *
            a: Некоторые авиакомпании признают достаточным основанием для вынужденного возврата авиабилета: \n• официальный отказ в визе \n• болезнь пассажира, повлекшая госпитализацию \n• смерть близкого родственника пассажира \nБолее подробную информацию можно получить по ссылке: https://www.ozon.travel/help/avia/how-to/return.



    state: ticketReturnIllDead
        # 4EX: Хочу вернуть невозвратный билет, в связи с болезнью
        # 4EX: какой алгоритм возврата билетов, если супруга заболела?
        q!: * ($cancelInf/$returnInf/$returnNoun/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order) * (~болезнь/~заболевание/~смерть/заболел*/заболева*) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($cancelInf/$returnInf/$returnNoun/здать/сдать) * (~болезнь/~заболевание/~смерть/заболел*/заболева*) *
        q!: * (~болезнь/~заболевание/~смерть/заболел*/заболева*) * ($cancelInf/$returnInf/$returnNoun/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (~болезнь/~заболевание/~смерть/заболел*/заболева*) * ($ticket/$airplaneTicket/$flight/$order) * ($cancelInf/$returnInf/$returnNoun/здать/сдать) *
        a: В таком случае вам необходимо оформить вынужденный возврат. Заполните электронное заявление, нажав на кнопку «‎Возврат и обмен» на странице заказа в личном кабинете: https://www.ozon.travel/my



    state: ticketReturnForcedFullInfo
        # 4EX: вынужденный возврат по задержке рейса. Рейс № 403 Минводы - Москва 21 марта был задержан на 6 часов и мне пришлось улететь другим рейсом. Спасибо!
        q!: * (вынужден* $return) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * (вынужден* $return) *
        q!: * $iataAndRailway::fromCode * (вынужден* $return) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) * ($dateDig/$dateLetters/$thatDay) *

        q!: * (вынужден* $return) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (вынужден* $return) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * (вынужден* $return) * $iataAndRailway::destCode *

        # 4EX: Купил билет из краснодара в москву 12 октября, но теперь надо вынужденный возаврт сделать
        q!: * (вынужден* $return) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * (вынужден* $return) *
        q!: * $iataAndRailway::fromCode * (вынужден* $return) * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * (вынужден* $return) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * (вынужден* $return) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) *
        q!: * ($dateDig/$dateLetters/$thatDay)*(вынужден* $return) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * (вынужден* $return) * $iataAndRailway::destCode *

        # 4EX: Купил билет в москву из краснодара 12 октября, а можно сделать вынужденный возврат? у меня родственник помер
        q!: * (вынужден* $return) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * (вынужден* $return) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * (вынужден* $return) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * (вынужден* $return) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * (вынужден* $return) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (вынужден* $return) * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) * $iataAndRailway::fromCode *

        # 4EX: Краснодар Купил бидеты из москвы 12 октября, можно ли сделать вынужденный возаврт?
        q!: * (вынужден* $return) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * (вынужден* $return) *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * (вынужден* $return) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * (вынужден* $return) * $iataAndRailway::destCode *

        q!: * (вынужден* $return) * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * (вынужден* $return) *
        q!: * $iataAndRailway::destCode * (вынужден* $return) * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * (вынужден* $return) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        go!: /returnForced/ticketReturnForced



    state: flightCanceledFullInfo
        # 4EX: Добрый день! я приобрела билет через Вашу компанию на рейс Москва-Псков 21 февраля. Рейс был отменён. как я могу вернуть свои деньги?
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] *
        # 4EX: рейс отменили из краснодара в москву 12 октября
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * [$forAdults] * ($to [$cityPreName] $iataAndRailway::destCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay)*{($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults]*{($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay)*[$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay)*{($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay)*{($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay)*{($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] *
        # 4EX: Купил билет в москву из краснодара 12 октября, а рейс отменили
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] *
        q!: * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        q!: * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] *
        q!: * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode * [$forAdults] *
        # 4EX: Краснодар Купил бидеты из москвы 12 октября, рейс вот отменился
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::destCode * [$forAdults] * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * [$forAdults] * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ([на] ($dateDig/$dateLetters/$thatDay)) * [$forAdults] *
        # 4EX: отменили рейс москва ташкент на 5 февраля где деньги????
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$ticket/$airplaneTicket] *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$forAdults] *
        q!: * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        q!: * [$forAdults] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$forAdults] * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [$forAdults] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * {($flight/~рейс) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * [$forAdults] * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * {($flight/~рейс) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*)} * ($dateDig/$dateLetters/$thatDay) * [$forAdults] *
        # 4EX: Добрый день. Мне пришло оповещение, что мой рейс из Сургута в Спб 2-ого октября не состоится. Могу ли я вернуть деньги или сделать что-то еще?
        q!: * [$forAdults] * ($flight/~рейс) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*) *
        q!: * ($flight/~рейс) * [$forAdults] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*) *
        q!: * ($flight/~рейс) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [$forAdults] * [на] ($dateDig/$dateLetters/$thatDay) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*) *
        q!: * ($flight/~рейс) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$forAdults] * (отменил*/отмене*/атменил*/атменен*/$ne состоит*) *
        q!: * ($flight/~рейс) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (отменил*/отмене*/атменил*/атменен*/$ne состоит*) * [$forAdults] *
        go!: /returnForced/flightCanceled



    state: returnForcedOrderNumb
        # 4EX: Здравствуйте, заказ N 18018412—0001. Билеты были приобретены на самолёте авиакомпании аэрофлот в Польшу и обратно. Однако Польша запретила въезд на её территорию иностранных граждан. По информации аэрофлота мы можем оформить вынужденный возврат через Вас.
        q!: * $orderNumber * $countryName * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) * вынужден* $return *
        q!: * $orderNumber * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) * вынужден* $return *
        q!: * $orderNumber * вынужден* $return * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) *
        q!: * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) * $orderNumber * вынужден* $return *
        q!: * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) * вынужден* $return * $orderNumber *
        q!: * вынужден* $return * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) * $orderNumber *
        q!: * вынужден* $return * $orderNumber * ($issueVerbInf/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/воспользоват*/пользовать*/пользоватся) *
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
                    $reactions.answer('Чтобы оформить вынужденный возврат, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.answer('Чтобы оформить вынужденный возврат, перейдите в личный кабинет: https://www.ozon.travel/my\n Нажмите кнопку «Возврат и обмен», затем выберите опцию «Вернуть билет» и оформите запрос.');
                }



    state: returnMoneyForcedHowFullInfo
        # 4EX: Добрый день! Хотели бы вернуть денежные средства за авиабилеты Москва-Тенерифе рейс SU2548 на 22 апреля 2020, аэрофлот . Номер брони J7NHV5. Аэрофлот сказал, что это вынужденный возврат и мы можем вернуть деньги.  Как нам это сделать?
        q!: * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] *
        q!: * {вынужден* $return} * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * {вынужден* $return} * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] *
        q!: * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} * [$airplaneTicket] *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] * {вынужден* $return} *
        q!: * [$airplaneTicket] * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$airplaneTicket] * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) *
        q!: * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} *
        q!: * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * [$airplaneTicket] * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {вынужден* $return} * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} * [$airplaneTicket] *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * [$airplaneTicket] * {вынужден* $return} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay) * [$airplaneTicket] * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} *
        go!: /returnForced/returnMoneyForcedHow



    state: returnMoneyForcedHow
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {вынужден* $return} *
        q!: * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * {вынужден* $return} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} * {вынужден* $return} *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {вынужден* $return} * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        a: Чтобы оформить вынужденный возврат, перейдите в личный кабинет: https://www.ozon.travel/my\n Нажмите кнопку «Возврат и обмен», затем выберите опцию «Вернуть билет» и оформите запрос.
