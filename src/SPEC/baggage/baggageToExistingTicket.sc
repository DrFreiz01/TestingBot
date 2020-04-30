theme: /baggageToExistingTicket


    state: howToBuyBaggageOrderNumb
        # 4EX: Добрый день. Как оплатить багаж на обратном рейсе 26.03? Заказ 13261834-0010
        q!: * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $orderNumber * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll * $orderNumber *
        q!: * $orderNumber * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $orderNumber * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * $orderNumber * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $orderNumber *
        if: $temp.begin == undefined
            script:
                $temp.begin = true;
                $client.executeState = $context.currentState;
                $temp.orderNumber = $parseTree._orderNumber;
            go!: /orderInfo/getOrderInfo
        else:
            script:
                $temp.begin = undefined;
            a: Чтобы оплатить багаж, войдите в аккаунт и пройдите по ссылке: https://www.ozon.travel/my/add-service/luggage/?OrderNumber={{$session.orderId}}



    state: addBaggageToOrder
        # 4EX: Доброе утро. Требуется в заказе добавить багаж для 1 места. Это возможно?
        # 4EX: Как мне добавить в заказ ещё багаж до 10 кг ?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $baggageAll *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * $baggageAll * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        q!: * $baggageAll * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * (в/во/к/ко) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        go!: /baggageToExistingTicket/boughtTicketsHowToBuyBaggage



    state: addBaggageToFutureFlight
        # 4EX: Доброй ночи. Как я могу оформить одно место багажа на предстоящий перелет из минеральных вод в москву 21 февраля.
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway *
        q!: * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway *
        q!: * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $baggageAll * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll *
        q!: * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway *
        q!: * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway *
        q!: * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $baggageAll * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $baggageAll * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll *
        q!: * $iataAndRailway $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll *
        q!: * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll *
        q!: * $iataAndRailway * $iataAndRailway * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        q!: * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $iataAndRailway * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $iataAndRailway * $baggageAll * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) *
        q!: * $iataAndRailway * $iataAndRailway * $baggageAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/доплатит*/$bookInf/$orderVerbInf/набрат*/добавит*/$chooseInf/$take) * (предстоящ*/престоящ*/придстоящ*/пристоящ*/будущи*/завтрашн*) $flight *
        go!: /baggageToExistingTicket/boughtTicketsHowToBuyBaggage



    state: roundtripTicketsHowManyBaggage
        # 4EX: Если у меня билеты на самолёт туда и обратно, то я должен 1 багаж купить?
        q!: * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $roundTrip * {(должен/должна/должны/$need2) * (один/одного/одново/одну/одних/1) $baggageAll ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*)} *
        q!: * $roundTrip * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * (должен/должна/должны/$need2) * {(один/одного/одново/одну/одних/1) $baggageAll ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*)} *
        q!: * (должен/должна/должны/$need2) * {(один/одного/одново/одну/одних/1) $baggageAll ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*)} * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $roundTrip *
        q!: * (должен/должна/должны/$need2) * {(один/одного/одново/одну/одних/1) $baggageAll ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*)} * $roundTrip * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        script:
            if ($client.orderList && $client.orderList.length == 1) {
                if ($temp.begin == undefined) {
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                    $temp.orderNumber = $client.orderList[0];
                    $reactions.transition('/orderInfo/getOrderInfo');
                } else {
                    $temp.begin = undefined;
                    $reactions.answer('Чтобы оплатить багаж, войдите в аккаунт и пройдите по ссылке: https://www.ozon.travel/my/add-service/luggage/?OrderNumber=' + $session.orderId + '\nВы сможете добавить багаж в нужный сегмент перелета, выделив его галочкой.');
                }
            } else {
                $reactions.answer('После оформления заказа зайдите в Личный кабинет и напротив заказа нажмите «Дополнительные услуги» — «Дополнительный багаж». Вы сможете добавить багаж в нужный сегмент перелета, выделив его галочкой.');
            }



    state: iHaveTicketsHowToBuyBaggage
        # 4EX: Если у меня билеты на самолёт туда и обратно, то как мне багаж купить?
        q!: * {(у $meGenAcc) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * {$baggageAll ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*)} *
        # 4EX: Добрый день,подскажите пожалуйста ,можно поменять билет с багажом , т.к.у меня билет без
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) (с $baggageAll)} * {(у $meGenAcc) [$ticket/$airplaneTicket/$flight/$order/~поездка/~рейс]} без [него/его/ево/$baggageAll] [$markQuestion]
        go!: /baggageToExistingTicket/boughtTicketsHowToBuyBaggage



    state: byAccidentBoughtTicketsWithNoBaggage
        # 4EX: Здравствуйте. Я случайно взял билет без багажа
        q!: * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*)) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $without $baggageAll
        q!: * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*)) * $without $baggageAll * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)}
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*)) * $without $baggageAll
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $without $baggageAll * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*))
        q!: * $without $baggageAll * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*)) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)}
        q!: * $without $baggageAll * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * (случайн*/неспециальн*/неспецальн*/$ne (специальн*/спецальн*))
        go!: /baggageToExistingTicket/boughtTicketsHowToBuyBaggage




    state: boughtTicketsHowToBuyBaggage
        # 4EX: Для мен куплены билеты без багажа, как я могу докупить багаж?
        # 4EX: Добрый вечер! Купили авиа билеты на вашем сайте, был выбран минимальный по стоимости тариф, хотелось бы сразу купить места в самолете и оплатить ручную кладь, все это не входит в стоимость тарифа. Как это можно сделать?
        # 4EX: Добрый день. Оплатил билет, могу доплатить за багаж? Или уже нельзя?
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) ([за] $baggageAll)} *
        q!: * {($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*) [мест*] $baggageAll} * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        # 4EX: Могу ли я докупить в оформленный билет одно багажное место?
        # 4EX: Как заказать оплату багажа дополнительно к уже оплаченному заказу?
        q!: * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * {(куплен*/оформлен*/заказан*/оплачен*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $baggageAll *
        q!: * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggageAll * {(куплен*/оформлен*/заказан*/оплачен*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        # 4EX: Добрый день! Купили билеты без багажа. Хочу дозаказать. Как это сделать?
        q!: * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $without $baggageAll  * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$bookInf/набрат*/$chooseInf/добавит*) * {($buyVerbPast/$issueVerbPast/$bookPast/$orderPast/$payPastAll/взял*) ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $without $baggageAll  *
        script:
            if ($client.orderList && $client.orderList.length == 1) {
                if ($temp.begin == undefined) {
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                    $temp.orderNumber = $client.orderList[0];
                    $reactions.transition('/orderInfo/getOrderInfo');
                } else {
                    $temp.begin = undefined;
                    $reactions.answer('Чтобы оплатить багаж, войдите в аккаунт и пройдите по ссылке: https://www.ozon.travel/my/add-service/luggage/?OrderNumber=' + $session.orderId);
                }
            } else {
                $reactions.transition('/documentsFaqAns/tellMeYoutOrderNumb');
            }



    state: boughtTicketsIsBaggageIncluded
        # 4EX: Мы купили билет, хотели бы узнать входит ли у ребёнка без места ручная кладь
        q!: * {($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket)} * ((включен*/влючен*/входит/входет/входят) [ли]) * $baggageAll *
        q!: * {($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket)} * $baggageAll * ((включен*/влючен*/входит/входет/входят) [ли]) *
        q!: * $baggageAll * ((включен*/влючен*/входит/входет/входят) [ли]) * {($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket)} *
        q!: * ((включен*/влючен*/входит/входет/входят) [ли]) * $baggageAll * {($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket)} *
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: boughtTicketsHowMuchForAddingBaggage
        # 4EX: Добрый день. Я купила на вашем сайте Оzontravel авиабилеты для всей семьи,  в которых предусмотрена только ручная кладь. Могу ли я сейчас внести изменения хотя бы в один билет для ребёнка чтобы можно было взять багаж? И сколько это стоит?
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($howMuch * $cost/$price) *
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($howMuch * $cost/$price) *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($howMuch * $cost/$price) *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($howMuch * $cost/$price) *
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($howMuch * $cost/$price) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage *
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($howMuch * $cost/$price) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($howMuch * $cost/$price) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($howMuch * $cost/$price) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) *
        q!: * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($howMuch * $cost/$price) * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) *
        q!: * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($howMuch * $cost/$price) * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) *
        q!: * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($howMuch * $cost/$price) * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) *
        q!: * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($howMuch * $cost/$price) * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) *
        q!: * ($howMuch * $cost/$price) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) *
        q!: * ($howMuch * $cost/$price) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) *
        q!: * ($howMuch * $cost/$price) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * $baggage * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) *
        q!: * ($howMuch * $cost/$price) * $baggage * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/доплатит*/$take) * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) *
        script:
            if ($client.orderList && $client.orderList.length == 1) {
                if ($temp.begin == undefined) {
                    $temp.begin = true;
                    $client.executeState = $context.currentState;
                    $temp.orderNumber = $client.orderList[0];
                    $reactions.transition('/orderInfo/getOrderInfo');
                } else {
                    $temp.begin = undefined;
                    $reactions.answer('Чтобы оставить заявку на рассчет стоимости багажа, войдите в аккаунт и пройдите по ссылке: https://www.ozon.travel/my/add-service/luggage/?OrderNumber=' + $session.orderId);
                }
            } else {
                $reactions.answer('Направьте нам заявку, и мы рассчитаем стоимость багажа. Для этого нажмите на кнопку «Дополнительные услуги» напротив номера заказа в личном кабинете и заполните заявку. Мы пришлем ответ на вашу электронную почту.');
            }



    state: howMushDoesBaggageCostMyTicketFromDest
        # 4EX: Добрый вечер. Хотел бы уточнить стоимость провоза багажа на мой рейс Red Wings из СПБ в Стамбул и обратно.
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) *
        go!: /baggageToExistingTicket/boughtTicketsHowMuchForAddingBaggage



    state: howMushDoesBaggageCostMyTicketFullInfo
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($howMuch $cost/$price) * $baggage * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $baggage * ($howMuch $cost/$price) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * ($howMuch $cost/$price) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) *
        q!: * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * [на] ($dateDig/$dateLetters/$thatDay) * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) *
        q!: * $my2 ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * $my2 ($ticket/$airplaneTicket/$flight) * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $my2 ($ticket/$airplaneTicket/$flight) * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * $my2 ($ticket/$airplaneTicket/$flight) * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * $my2 ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode * [$to] [$cityPreName] $iataAndRailway::destCode * $baggage * ($howMuch $cost/$price) * [на] ($dateDig/$dateLetters/$thatDay) * $my2 ($ticket/$airplaneTicket/$flight) *
        go!: /baggageToExistingTicket/boughtTicketsHowMuchForAddingBaggage




