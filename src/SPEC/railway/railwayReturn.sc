theme: /railwayReturn


    state: railwayReturnHow
        # 4EX: добрый день я бы хотела вернуть жд билет, поскольку он оформлен не на ту дату. как это сделать?
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) [$my2/$ruSvoi] $railwayTicket} *
        q!: * {($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) [$my2/$ruSvoi] $ticket} * $railwayAll *
        q!: * $railwayAll * {($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) [$my2/$ruSvoi] $ticket} *
        q!: * $ticket * $railwayAll * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) *
        q!: * $railwayAll * $ticket * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) *
        q!: * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/здать/сдать/сдача/сдачу) * $railwayAll * $ticket *
        q!: * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/здать/сдать/сдача/сдачу) * $ticket * $railwayAll *
        q!: * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/здать/сдать/сдача/сдачу) * $railwayTicket *
        q!: * $railwayTicket * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) ($annulNoun/$cancelInf/$return/$returnInf/здать/сдать/сдача/сдачу) *
        # 4EX: Зд-те,могу я онлайн,сделать возврат жд билета?
        q!: * (сделать/совершить/совершать) * {($returnNoun/$annulNoun) $railwayTicket}
        a: Чтобы вернуть билет, отправьте запрос через личный кабинет - рядом с номером интересующего вас заказа нажмите на кнопку «Возврат», затем выберите опцию «оформить возврат».



    state: railwayReturnMoney
        # 4EX: Как вернуть деньги за проезд на поезде
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $railwayAll *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $railwayAll * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $railwayAll *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $railwayAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $railwayAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $railwayAll * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        go!: /railwayReturn/railwayReturnHow



    state: ticketReturnBuyAvia
        # 4EX: Добрый вечер я хотел задать жд билет обратно и купить авиабилет
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($annulNoun/$cancelInf/$return/$returnInf/задать/здать/сдать/сдача/сдачу) [$my2/$ruSvoi] $railwayTicket} * {($buyInf/$buyNoun) * [$direct] ($airplaneTicket/$flight)} *
        a: Чтобы вернуть билет, отправьте запрос через личный кабинет - рядом с номером интересующего вас заказа нажмите на кнопку «Возврат», затем выберите опцию «оформить возврат».
        a: Чтобы купить авиабилет, назовите, пожалуйста, направление вашей поездки.
        go: /aviaSearch/aviaSearchNoInfo

