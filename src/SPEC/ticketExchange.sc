theme: /ticketExchange



    state: wannaExchangeTicket
        # 4EX: можно ли обменять авиабилет
        # 4EX: Здравствуйте! Можно ли как-нибудь поменять билеты ?
        q!: * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($how/$want/$need2/$canSynPossible) [$markQuestion]
        q!: * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        # 4EX: Если это возможно, то сформируйте, пожалуйста, запрос на обмен.
        q!: * (сформируй*/оставь*/сделай*) [$please] (запрос*/заявк*/~заявление) (на/по/$about/к/$for) ~обмен [$my2/$ruSvoi/наш*] [$airplaneTicketAll]
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
                         $reactions.answer('Чтобы обменять билет, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-exchange/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                    } else {
                        $reactions.answer('Чтобы обменять билет, сделайте следующее: \n• Зайдите в личный кабинет: https://www.ozon.travel/my \n• Если рядом с заказом есть кнопка «Отменить», нажмите ее и подтвердите аннуляцию заказа, а затем оформите новый билет \n• Если кнопки «Отменить» нет, напротив номера заказа нажмите «Возврат и обмен» — «Обменять билет» \n• Затем выберите сегмент перелета и пассажира \nМы проверим, возможно ли обменять билет на нужную вам дату и сколько нужно будет доплатить. Ответ отправим на e-mail, также вы увидите его в личном кабинете.');
                    }
                }
            } else {
                $reactions.answer('Чтобы обменять билет, сделайте следующее: \n• Зайдите в личный кабинет: https://www.ozon.travel/my \n• Если рядом с заказом есть кнопка «Отменить», нажмите ее и подтвердите аннуляцию заказа, а затем оформите новый билет \n• Если кнопки «Отменить» нет, напротив номера заказа нажмите «Возврат и обмен» — «Обменять билет» \n• Затем выберите сегмент перелета и пассажира \nМы проверим, возможно ли обменять билет на нужную вам дату и сколько нужно будет доплатить. Ответ отправим на e-mail, также вы увидите его в личном кабинете.');
            }


        state: tariffRulesInEng
            # 4EX: там все на английском!
             q: * (инглиш*/englis*/inglis*/английск*) *
             a: Если информация о тарифе билета на английском, найдите подзаголовок CHANGES, под которым будет текст о правилах обмена авиабилета.



    state: wannaExchangeTicketOrderNumb
        # 4EX: Здравствуйте, 16383250-0006 могу ли я обратный билет поменять?
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        # 4EX: Здравствуйте хочу поменять дату вылета по этому заказу, №12218358-0035, как это сделать? делать возврат всех билетов или можно поменять только вылет?
        q!: * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * $orderNumber * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($how/$want/$need2/$canSynPossible) * $orderNumber * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($how/$want/$need2/$canSynPossible) * $orderNumber *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($how/$want/$need2/$canSynPossible) * $orderNumber *
        q!: * $orderNumber * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($how/$want/$need2/$canSynPossible) *
        q!: * $orderNumber * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($how/$want/$need2/$canSynPossible) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * ($how/$want/$need2/$canSynPossible) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * ($how/$want/$need2/$canSynPossible) *
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
                    $reactions.answer('Чтобы обменять билет, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-exchange/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.answer('Чтобы обменять билет, сделайте следующее: \n• Зайдите в личный кабинет: https://www.ozon.travel/my \n• Если рядом с заказом есть кнопка «Отменить», нажмите ее и подтвердите аннуляцию заказа, а затем оформите новый билет \n• Если кнопки «Отменить» нет, напротив номера заказа нажмите «Возврат и обмен» — «Обменять билет» \n• Затем выберите сегмент перелета и пассажира \nМы проверим, возможно ли обменять билет на нужную вам дату и сколько нужно будет доплатить. Ответ отправим на e-mail, также вы увидите его в личном кабинете.');
                }



    state: wannaExchangeTicketOrderNumbWhen
        # 4EX: Добрый день, можно поменять билет заказ № 14910039-0364 на время раньше? и как долго будет проходить процедура обмена?
        q!: * $howLong * $orderNumber * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $howLong * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong *
        q!: * $howLong * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber * $howLong *
        q!: * $howLong * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $howLong * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * $howLong * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong *
        q!: * $howLong * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $howLong * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber * $howLong *
        q!: * $howLong * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $howLong * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * $howLong * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong *
        q!: * $howLong * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $howLong * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $howLong * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $howLong * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $orderNumber * $howLong *
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
                    $reactions.answer('Чтобы обменять билет, войдите в аккаунт и пройдите по этой ссылке: https://www.ozon.travel/my/ticket-exchange/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.answer('Чтобы обменять билет, сделайте следующее: \n• Зайдите в личный кабинет: https://www.ozon.travel/my \n• Если рядом с заказом есть кнопка «Отменить», нажмите ее и подтвердите аннуляцию заказа, а затем оформите новый билет \n• Если кнопки «Отменить» нет, напротив номера заказа нажмите «Возврат и обмен» — «Обменять билет» \n• Затем выберите сегмент перелета и пассажира \nМы проверим, возможно ли обменять билет на нужную вам дату и сколько нужно будет доплатить. Ответ отправим на e-mail, также вы увидите его в личном кабинете.');
                }
            a: Пожалуйста, ожидайте ответа на почту. Все заявки рассматриваются по очереди в зависимости от даты вылета. Мы рассмотрим ваш запрос в течение суток.



    state: wannaChangeTicketParametersOrderNumbFromDest
        # 4EX: подскажите пожалуйста, могу ли я изменить дату вылета в билете из Екатеринбурга в Москву по заказу номер 14910039-0367
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        go!: /ticketExchange/wannaExchangeTicketOrderNumb



    state: wannaChangeTicketParametersOrderNumbDate1Date2
        # 4EX: Здравствуйте! Возможно ли поменять дату вылета по Заказу №16383250-0006. с 21.02 на 19.02 ?
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * $orderNumber * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($how/$want/$need2/$canSynPossible) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($how/$want/$need2/$canSynPossible) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * $orderNumber * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) * $orderNumber *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * $orderNumber * ($dateDig/$dateLetters) * ($dateDig/$dateLetters) *
        go!: /ticketExchange/wannaExchangeTicketOrderNumb



    state: wannaExchangeTicketDidntBuyTicket
        # 4EX: Здравствуйте, мы ошиблись в серии паспорта. Как бы нам быстро это изменить? Билет пока не оплачен
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($changeInfAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($changeInfAll/$exchangeAllExceptPast) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * ($changeInfAll/$exchangeAllExceptPast) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * ($ticket/$airplaneTicket) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * ($ticket/$airplaneTicket) * ($ne ($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * ($changeInfAll/$exchangeAllExceptPast) *
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: boughtTicketWrongParameters
        # 4EX: Здравствуйте купили белет не на ту дату. Билет нужен на сегодня как нам быть?
        q!: * {($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket/$flight)} * ($ne [на] (~тот/~та/~то/~этот/~эта/~это) / $wrong) (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * {($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket/$flight)} * ($ne [на] (~тот/~та/~то/~этот/~эта/~это) / $wrong) (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * {($want/$need2/$checkLookFor) ([$cheap] [$withBaggage] ($ticket/$airplaneTicket/$flight))} *
        go!: /ticketExchange/wannaExchangeTicket



    state: wannaChangeTicketParameters
        # 4EX: Могучи ли я сменить время перелёта?
        # 4EX: Здравствуйте. Как изменить дату билета
        q!: * ($changeInfAll/перенести/перинести) * ((~время/~дата/~число) $airplaneTicketAll) *
        # 4EX: Здравствуйте, хотел перенести вылет на среду тоесть 19.12.18г?
        q!: * ($changeInfAll/перенести/перинести) * $airplaneTicketAll на *
        # 4EX: Могу ли я поменять билет на тот же день, но на другой рейс с Шереметьево? Спасибо
        q!: * {$changeInfAll [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * на (другой/другую/другое/другие) ($flight/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число) *
        q!: * на (другой/другую/другое/другие) ($flight/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число) * {$changeInfAll [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        go!: /ticketExchange/wannaExchangeTicket



    state: changeTicketFromDateToDate
        # 4EX: Мне нужно поменять с Москвы на симферополь с 6 числа на 7 число
        q!: * {$changeInfAll [$oneDigit/$my2/$ruSvoi] [$ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс]} * $iataAndRailway::fromCode * $iataAndRailway::destCode * с ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) на ($dateDig::dateDig2/$dateLetters::dateLetters2) [$markQuestion] $weight<+1>
        go!: /ticketExchange/wannaExchangeTicket



    state: reissueTicketInOtherPersonsName
        # 4EX: Добрый день! Возможно ли переоформить оплаченный билет на другого человека? авиакомпания Победа и НордСтар Москва-Мин.Воды-Москва (25.08.2019-02.09.2019) если да, сколько это стоит?
        q!: * ($issueVerbInf/переоформить/перевыпустить) * ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс) на (другого/другую/другово/других) ($adults/человек*) * $weight<+1>
        go!: /ticketExchange/wannaExchangeTicket



    state: boughtTicketButMadeMistake
        # 4EX: Здравствуйте, я купила билеты на вашем сайте, но ошиблась в данных паспорта. Как можно исправить ошибку?
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        # 4EX: ДОБРЫЙ ВЕЧЕР Я ПО ОШИБКЕ КУПИЛ БИЛЕТЫ НЕ В ТУ СТОРОНЫ
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        go!: /ticketExchange/wannaExchangeTicket



    state: boughtTicketButMadeMistakeOrderNumb
        # 4EX: Добрый день, я купил авиабилеты и ошибся в одной букве в фамилии, заказ № 16383250-0006
        q!: * $orderNumber * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * $orderNumber * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * $orderNumber * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber *
        q!: * $orderNumber * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * $orderNumber * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * $orderNumber * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * (~время/~дата/~число/{(паспорт*/пасспорт*) [данны*/даны*]}) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * $orderNumber *
        # 4EX: ДОБРЫЙ ВЕЧЕР Я ПО ОШИБКЕ КУПИЛ БИЛЕТЫ НЕ В ТУ СТОРОНЫ, заказ № 16383250-0006
        q!: * $orderNumber * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * $orderNumber * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        q!: * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * $orderNumber *
        q!: * $orderNumber * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * $orderNumber * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) *
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * (ошибс*/ошиблас*/ошиблис*/ошибоч*/по (ошибк*/ошике)) * $orderNumber *
        go!: /ticketExchange/wannaExchangeTicketOrderNumb




    state: canIExchangeTicketsToDiffAviaCompany
        # 4EX: Здравствуйте, обмен возможен только в рамках одной авиакомпании? или можно обменять билет оть аэрофлота на билет победы?
        q!: * ($changeInfAll/$exchangeAllExceptPast) * ($possiblePredic/возможен) * (внутри/в [рамках]) одной (компани*/авиакомпани*) *
        q!: * ($possiblePredic/возможен) * ($changeInfAll/$exchangeAllExceptPast) * (внутри/в [рамках]) одной (компани*/авиакомпани*) *
        q!: * (внутри/в [рамках]) одной (компани*/авиакомпани*) * ($possiblePredic/возможен) * ($changeInfAll/$exchangeAllExceptPast) *
        q!: * (внутри/в [рамках]) одной (компани*/авиакомпани*) * ($changeInfAll/$exchangeAllExceptPast) * ($possiblePredic/возможен) *
        a: Обмен возможен только в рамках предложений одной авиакомпании. Если вы хотите лететь другой авиакомпанией, вы можете отменить этот билет в добровольном порядке с удержаниями и штрафами, предусмотренными тарифом, и оформить новый билет.



    state: exchangeWithPenaltyColours
        # 4EX: Не понимаю, чем отличаются билеты, где указаны "обмен со сборами", но в одном случае на зелёном форе, а в другом - на сером
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * обмен (со/с) сборами * (зелен*/зелён*) * сер* *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (зелен*/зелён*) * сер* * обмен (со/с) сборами *
        q!: * обмен (со/с) сборами * (зелен*/зелён*) * сер* * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) *
        q!: * обмен (со/с) сборами * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (зелен*/зелён*) * сер* *
        q!: * (зелен*/зелён*) * сер* * обмен (со/с) сборами * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) *
        q!: * (зелен*/зелён*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * сер* * обмен (со/с) сборами *
        a: Цветом выделены преимущества и недостатки билетов. В данном случае серым цветом выделен обмен со сборами Ozon.Travel и сборами авиакомпании. Зеленым выделен обмен со сборами Ozon.Travel, но без сборов авиакомпании.



    state: wannaChangeTicketFullInfo
        # 4EX: Можно ли поменять билет на рейсОрландо Нью-Йорк. НЬЮ-ЙОРК Москва на 18 февраля на другое число
        # 4 города
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        # 3 города
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        # 2 города
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *

        # 4EX: Здравствуйте! Приобрели у вас авиабилет Пхукет-Владивосток на 14 января рейс СА 822, хочу изменить дату вылета одного пассажира Khelemendik Bogdan на 12 января.
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $iataAndRailway::fromCode * [$roundTrip] * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$roundTrip] *

        # 4EX: нужно поменять два билета на самолет самара - прага на 04.04.19г. и обратно прага самара на 17.04.19г. все билеты должны включать багаж, рейсы только прямые
        q!: * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * {$changeInfAll [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        go!: /ticketExchange/wannaExchangeTicket



    state: wannaChangeTicketFromDest
        # 4EX: Изменить дату в билете Москва - Омск
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$replaceNoun) (~перелет/~перелёт/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число)} * [$ticket/$airplaneTicket/$flight] *
        q!: * {($changeInfAll/$replaceNoun) (~перелет/~перелёт/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число)} * [$ticket/$airplaneTicket/$flight] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        # 4EX: Поменять билет Москва - Омск
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$replaceNoun) [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$replaceNoun) [~время/~дата/~число] [$oneDigit/$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
         # 4EX: Добрый день Вчера покупал билеты Санкт-Петербург - Хельсинки Заказ  Уточните пожалуйста, есть ли возможность сделать замену на более поздний рейс в этот день?
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($changeInfAll/$replaceNoun) * (~перелет/~перелёт/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($changeInfAll/$replaceNoun) * (~перелет/~перелёт/~вылет/~отлет/~отлёт/~рейс/~время/~дата/~число) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll) ($ticket/$airplaneTicket)} *
        go!: /ticketExchange/wannaExchangeTicket



    state: wannaChangeTicketDates
        # 4EX: Купил билеты туда-обратно, но дата обратно неверная. По ошибке взял 13.6., когда должен буть 13.5. to же время. Mozhno поменять билет обратно?
        q!: * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight) * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $buyVerbPast * ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        go!: /ticketExchange/wannaExchangeTicket



    state: howLongWillItTakeToExchangeMyTicket
         # 4EX: сколько времени будет происходить обмен моего билета!!!
         q!: * $howLong * {($changeInfAll/$exchangeAllExceptPast/$replaceNoun) [$oneDigit/$my2/$ruSvoi] [$ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс]} *
         q!: * {($changeInfAll/$exchangeAllExceptPast/$replaceNoun) [$oneDigit/$my2/$ruSvoi] [$ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс]} * $howLong *
         go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: wannaChangeTicketDestDates
        # 4EX: Добрый день, пожалуйста, подскажите, есть ли шанс получить замену по рейсу в лиссабон на 23 сентября?
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $price [на] ($ticket/$airplaneTicket/$flight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {([на] ($dateDig/$dateLetters/$thatDay)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::destCode [на] ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $price [на] ($ticket/$airplaneTicket/$flight) * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * $price [на] ($ticket/$airplaneTicket/$flight) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * {(($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2)) ([$to] [$cityPreName] $iataAndRailway::destCode)} * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) $or [на] ($dateDig::dateDig2/$dateLetters::dateLetters2) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$to] [$cityPreName] $iataAndRailway::destCode * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс)} *
        go!: /ticketExchange/wannaExchangeTicket



    state: issuedTicketExchange
        # 4EX: Ещё раз доброго дня! Делал запрос на обмен билета
        q!: * {(сделал*/делал*/сделан*/оставил*/оставлял*/оставлен/отправил*/отправлял*/отправлен/отпрвлен/оформил*/оформлял*/оформлен) (~заявка/~запрос)} * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * {$issueVerbPast (~обмен ($ticket/$airplaneTicket/$flight/$order))} *
        go!: /faq/coronaVirus


#    state: ticketExchangeCost
#        # 4EX: сколько стоит обменять билет
#        q!: * $howMuch * $cost * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) *
#        q!: * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) * $howMuch * $cost *
#        # 4EX: во сколько обойдется обменять билет
#        q!: * $howMuch * (обойдется/обойдеться/обайдется/обайдеться) * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) *
#        q!: * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) * $howMuch * (обойдется/обойдеться/обайдется/обайдеться) *
#        # 4EX: цена обмена билета
#        q!: * $price * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) *
#        q!: * $price * ($ticket/$airplaneTicket/$flight) * ($changeAll/$exchangeAllExceptPast) *
#        q!: * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) * $price *
#        q!: * ($ticket/$airplaneTicket/$flight) * ($changeAll/$exchangeAllExceptPast) * $price *
#        # 4EX: штраф/сбор на обмен билета
#        q!: * (штраф*/сбор*) * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) *
#        q!: * (штраф*/сбор*) * ($ticket/$airplaneTicket/$flight) * ($changeAll/$exchangeAllExceptPast) *
#        q!: * ($changeAll/$exchangeAllExceptPast) * ($ticket/$airplaneTicket/$flight) * (штраф*/сбор*) *
#        q!: * ($ticket/$airplaneTicket/$flight) ($changeAll/$exchangeAllExceptPast) * (штраф*/сбор*) *
#        a: При обмене авиабилетов взимаются штрафы и сборы, предусмотренные авиакомпанией, плюс сбор Ozon.Travel за процедуру обмена в размере: \n• 1000 рублей с пассажира для билетов дороже 3000 рублей \n• 500 рублей с пассажира для билетов, дешевле 3000 рублей. \nЧтобы узнать точную стоимость обмена, отправьте запрос через личный кабинет - рядом с номером интересующего вас заказа нажмите на кнопку "Возврат и обмен", выберите опцию "Обменять билет" и оформите запрос.