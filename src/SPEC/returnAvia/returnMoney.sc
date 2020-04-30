theme: /returnMoney


    state: ticketReturnMoney
        # 4EX: Возврат денежных средств за билет
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) *
        # 4EX: Здравствуйте скажите билет можно аннулировать и вернуть деньги.?
        # 4EX: Как вернуть деньги за билет
        # 4EX: Можно вернуть стоимость билетов?
        # 4EX: Здравствуйте, помогите пожалуйста, у нас в семье случилась беда: Умерла Бабушка сегодня, вы можете помочь, чтобы отменить авиабилеты и сделать возврат денежных средств ?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) *
        # 4EX: Мы опаздали на рейс и хотим вернуть деньги
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        # 4EX: Как сделать возврат сумму
        # 4EX: Как возвращать сумму
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($return/$returnInf) [$my2/$ruSvoi] (сумму/суму/сумма/сума/$money/средств*/$price)} *
        # 4EX: Здравствуйте, куда послать заявление на возврат средств за авиаперелет?
        q!: * $whereTo * $claim * $return * (сумму/суму/сумма/сума/$money/средств*/$price) *
        q!: * $whereTo * $return * (сумму/суму/сумма/сума/$money/средств*/$price) * $claim *
        go!: /ticketReturn/ticketReturnHow



    state: returnMoneyCoronaV
        # 4EX: Здравствуйте. Возможно ли вернуть полную стоимость билета, если поездка отменилась из-за введённого карантина по короновирусу?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $return * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $coronaV *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * $return * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) * $return *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * $coronaV * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return *
        q!: * $coronaV * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) *
        go!: /ticketReturn/ticketReturnCoronaV



    state: returnMoneyFullInfoOrderNumb
        # 4EX: Добрый день. Билеты на 22.04 2020 Москва Берлин компании ЮТэйр были отменены. Номер заказа 16342895-0002  2 билета. Прошу произвести возврат денежных средств.
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * $orderNumber *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber *
        q!: * $iataAndRailway * $iataAndRailway * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber *
        q!: * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $orderNumber * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway *
        q!: * $orderNumber * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * $orderNumber *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber * $iataAndRailway * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $orderNumber *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $orderNumber * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
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



    state: sumOfReturnsTotal
        # 4EX: Добрый день, подскажите, пожалуйста, какова общая ожидаемая сумма возврата билетов на данном аккаунте?
        q!: * (~сумма/~сума) $return ($ticket/$airplaneTicket) * ~аккаунт [$markQuestion]
        a: Уточните, пожалуйста, номера заказов, по которым ожидается возврат, и я проверю информацию.



    state: returnCostCalculationOrderNumb
        # 4EX: Здравствуйте! Не могли бы Вы рассчитать сумму возврата билетов по заказу 13546782-0035
        q!: * ({(рассчитай*/посчитатй*/расчитай*/рассчитат*/расчитат*) ([$price/~сумма/~сума] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $orderNumber *
        q!: * $orderNumber * ({(рассчитай*/посчитатй*/расчитай*/рассчитат*/расчитат*) ([$price/~сумма/~сума] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        # 4EX: Какой штраф взымается за отмену билета по брони 14312289-0014? Хотим сдать билет
        q!: * ($which/$howMuch) * (штраф*/удержани*) * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} * $orderNumber *
        q!: * $orderNumber * ($which/$howMuch) * (штраф*/удержани*) * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} *
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
                    $reactions.answer('Вы можете оформить заявку на рассчет возврата по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId + ' \nЕсли вы не видите кнопку «Рассчитать возврат», значит, добровольный возврат по вашему заказу невозможен.');
                } else {
                    $reactions.transition('/returnMoney/returnCostCalculationFullInfo');
                }



    state: returnCostCalculation
        # 4EX: Добрый день, Уточните, пжл, как узнать сколько будет штраф за возврат авиабилета? И как узнать возвратный билет или нет?
        q!: * ($which/$howMuch) * (штраф*/удержани*) * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} *
        q!: * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} * ($which/$howMuch) * (штраф*/удержани*) *
        go!: /returnMoney/returnCostCalculationFullInfo



    state: howToMakeMoneyReturnToUserAcc
        # 4EX: Добрый день! у нас был возврат билетов. Нужно чтоб деньги отразились на пользовательском счете. что нужно сделать?
        q!: * $return * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) * $money * (пользровательск* $accountSg/пользовательск* $accountSg) *
        q!: * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) * $return * $money * (пользровательск* $accountSg/пользовательск* $accountSg) *
        q!: * ($how/$want/$need2/$canSynPossible [ли] [я/йа/$meDat]) * $money * (пользровательск* $accountSg/пользовательск* $accountSg) * $return *
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: returnMoneyMethod
        # 4EX: Здравствуйте,  в связи с закрытием границ Победа мне возвращает деньги за билеты, купленные через ваш сервис. Хочу уточнить, возврат будет на карту или на пользовательский счет?
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * на [кредит*/банковск*/$my2/$ruSvoi] карт* * (пользровательск* $accountSg/пользовательск* $accountSg) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * на [$my2/$ruSvoi] (пользровательск* $accountSg/пользовательск* $accountSg) * карт* *
        q!: * на [кредит*/банковск*/$my2/$ruSvoi] карт* * (пользровательск* $accountSg/пользовательск* $accountSg) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * на [$my2/$ruSvoi] (пользровательск* $accountSg/пользовательск* $accountSg) * карт* * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        a: Вы сможете выбрать наиболее удобный способ при оформлении возврата. Можно вернуть деньги на пользовательский счет или на ту карту, с которой вы оплачивали заказ.



    state: iHaveQuestionAboutReturnCost
        # 4EX: Добрый день, вопрос по стоимости обмена и возврата билета
        q!: * (вопрос*/вопроз*/ворпос*) * ($howMuch $cost/почем/почём) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) ([$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket))} [$markQuestion]
        q!: * ($howMuch $cost/почем/почём) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) ([$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket))} * (вопрос*/вопроз*/ворпос*) [$markQuestion]
        q!: * (вопрос*/вопроз*/ворпос*) * $price * ($return/сдачу/сдачи/$annulNoun/отмены) ([$my2/$ruSvoi/один/одного/одному/одним/одном/одна/одной/одну] ($ticket/$airplaneTicket)) [$markQuestion]
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: moneyDidntReturn
        # 4EX: Увы, я до сих пор жду визу и пришлось возвратить билеты. Пришел отчет что деньги возвращены но на карту они не поступили
        q!: * {(сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) $returnPast} * {(на (карту/карта/счет/счета)) [$oneWord] [$my2/$meDat]} $ne [$oneWord] (пришел*/пришол*/пришл*/поступил*/поступал*/паступил*/паступал*/*чсилен*/*числен*/*числин*) *
        a: После того, как мы высылаем вам деньги, они могут идти на карту до 7 рабочих дней. Скорость зависит от скорости работы банка.



    state: wouldMoneyReturnFully
        # 4EX: Хочу вернуть билеты из за переноса времени вылета. Вернут ли мне полную стоимость?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($annulInf/$returnInf/$return/сдать/отменить) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) *
        go!: /documentsFaqAns/tellMeYoutOrderNumb



    state: wouldMoneyReturnIfFlightCanceled
        # 4EX: Если отменят полеты в страны Евросоюза смогу ли рассчитывать на возврат стоимости билета
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) *
        go!: /faq/flightStatus



    state: wouldMoneyReturnIfFlightCanceledFullInfo
        # 4EX: Если отменят полеты в страны Евросоюза смогу ли рассчитывать на возврат стоимости билета. Москва-Лиссабон 17.02.20 заказ № 178234440
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * ($returnFut/возаврт/возврат) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * если * $cancelFut * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) *
        q!: * если * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $cancelFut * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$numberDate) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($returnFut/возаврт/возврат) *
        go!: /faq/flightStatus



    state: ticketReturnWhenWillIGetMyMoney
        # 4EX: Добрый день. Хотела бы узнать, когда будут перечислены денежные средства в сумме 5106 руб., за возврат билета заказ №18056808-0005.
        q!: * $whenAll * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * {($annulNoun/$cancelPast/$return/отмен*/сдач*) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order)} *
        q!: * $whenAll * {(сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) ((за/по) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order))} *
        # 4EX: Уточните, когда ждать возврат денежных средств по заказу 17808997-0028
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $whenAll * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $whenAll * ($ticket/$airplaneTicket/$flight/$order) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $whenAll * ($ticket/$airplaneTicket/$flight/$order) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        # 4EX: Добрый день. Заказ №17338393-0002 уточните пожалуйста, поступила ли информация от авиалинии о возврате денежных средств за билет, ввиду отмены рейса по инициативе авиакомпании
        q!: * $orderNumber * информац* * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * информац* * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight/$order) * $orderNumber *
        # 4EX: Когда я узнаю о решении о возврате стоимости оплаты за отмененный рейс? Заказ №16938242-0004
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $orderNumber *
        q!: * $whenAll * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * $orderNumber *
        q!: * $orderNumber * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        # 4EX: По заказу 11539344-0013 от 07.02.2020 когда ожидать возврата денег?
        q!: * $orderNumber * $whenAll * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        # 4EX: Подскажите, пожалуйста 11736414-0003 когда переведут деньги?
        q!: * $orderNumber * $whenAll * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) [$markQuestion]
        q!: * $orderNumber * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $whenAll [$markQuestion]
        # 4EX: :прошу вернуть средства по моим запросам о возврате :
        q!: * (прошу * $returnInf / $returnImperat) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * (~заявка/~заявление/~запрос) * $returnNoun *
        q!: * (прошу * $returnInf / $returnImperat) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $returnNoun * (~заявка/~заявление/~запрос) *
        # 4EX: Добрый вечер. Вчера направила заявление на возврат билетов и возврат денежных средств. Подскажите, срок рассмотрения и возврата денежных средств на карту..
        q!: * (~заявка/заявлени*) * $return * ($whenAll/срок/сроки) * (рассмотрен*/расмотрен*/рассмотрин*/расмотрин*/рассмотрят*/расмотрят*) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * (~заявка/заявлени*) * ($whenAll/срок/сроки) * (рассмотрен*/расмотрен*/рассмотрин*/расмотрин*/рассмотрят*/расмотрят*) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * (~заявка/заявлени*) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($whenAll/срок/сроки) * (рассмотрен*/расмотрен*/рассмотрин*/расмотрин*/рассмотрят*/расмотрят*) *
        # 4EX: Здравствуйте, прошу дать ответ по возврату денежных средств
        q!: * прошу (дать (ответ/атвет) / ответить) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        # 4EX: Я отменила билеты в Прагу (компания Аэрофлот) в связи с короновирусом. Когда мне вернутся деньги ?
        q!: * {($cancelPast/$returnPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * {($cancelPast/$returnPast) [$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс)} *
        # 4EX: когда будет решение по возврату денежных средств !?
        q!: * $whenAll * (статус*/решение) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * (статус*/решение) *
        # 4EX: Здравствуйте! Я приобретал билеты на Кипр, но в связи с коронавирусом въезд с 15.03.20 запрещён. Когда мне вернут деньги?
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $whenAll * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        #go!: /operator/goToOpeartor
        go!: /faq/coronaVirus



    state: ticketReturnWhereMoneyGo
        # 4EX: здравствуйте! я хочу вернуть билет по заказу №13546782-0035. деньги вернуться на карту?
        q!: * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) [$meDat] $return * (карт*/счет) [$markQuestion]
        q!: * $orderNumber * ($annulInf/$returnInf/$return/сдать/отменить) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) [$meDat] $return * (карт*/счет) [$markQuestion]
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) [$meDat] $return * (карт*/счет) * ($annulInf/$returnInf/$return/сдать/отменить) * $orderNumber *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) [$meDat] $return * (карт*/счет)* $orderNumber  * ($annulInf/$returnInf/$return/сдать/отменить) *
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
                    $reactions.answer('Вы можете выбрать способ возврата денег, пройдя по этой ссылке: https://www.ozon.travel/my/ticket-return/?OrderNumber=' + $session.orderId + '&PositionId=' + $session.positionId);
                } else {
                    $reactions.answer('В заявке на возврат средств вы можете выбрать, каким образом вам вернутся деньги. Возможные способы возврата можно найти по ссылке: https://www.ozon.travel/help/avia/how-to/return');
                }



    state: returnCostCalculationFullInfo
        # 4EX: Рассчитайте возврат билета пассажира Куренков Владимир Сергеевич от 2.10.19г Магадан Анадырь
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::fromCode * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * [на] ($dateDig/$dateLetters/$thatDay) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] ($dateDig/$dateLetters/$thatDay) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        a: Чтобы рассчитать стоимость возврата, отправьте запрос через личный кабинет - рядом с номером интересующего вас заказа нажмите на кнопку «Возврат и обмен», выберите опцию «Вернуть билет» и оформите заявку на расчет возврата: https://www.ozon.travel/my



    state: returnCostCalculationFromDest
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::fromCode * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) * [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} * ({(рассчитай*/посчитатй*/расчитай*) ([$price] $return)} / {($howMuch $cost/почем/почём) ($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены)}) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Здравствуйте! При возврате билетов из Москвы в Петропавловск-Камчатский, какая сумма вернётся?
        q!: * {($annulNoun/$return/отмене/отмени/сдаче/сдачи) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (сумма/сума) *
        q!: * [$from] [$cityPreName] $iataAndRailway::fromCode * {($annulNoun/$return/отмене/отмени/сдаче/сдачи) ($ticket/$airplaneTicket/$flight)} * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * (сумма/сума) *
        q!: * (сумма/сума) * {($annulNoun/$return/отмене/отмени/сдаче/сдачи) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * (сумма/сума) * [$from] [$cityPreName] $iataAndRailway::fromCode * {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($annulNoun/$return/отмене/отмени/сдаче/сдачи) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: цена сдачи прямых билетов москва - питер
        q!: * $price [на] {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)} *
        # 4EX: сколкьо стоит сдать прямые билеты мск питер
        q!: * {($howMuch $cost/почем/почём) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) {($annulNoun/$cancelInf/$return/$returnInf/сдать/сдачу/сдачи/отмены) [$my2/$ruSvoi] ($ticket/$airplaneTicket)}} *
        go!: /returnMoney/returnCostCalculationFullInfo



    state: ticketReturnMoneyFullInfo
        # 4EX: добрый день. подскажите как сделать возврат денежных средств? 28 декабря были куплены билеты омск-москва(домодедово), с 1.01-3.01.
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * $iataAndRailway *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * $iataAndRailway * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway * $iataAndRailway * ($ticket/$airplaneTicket/$flight/$order) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} * ($ticket/$airplaneTicket/$flight/$order) *
        q!: * $iataAndRailway * $iataAndRailway * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight/$order) * {$return (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        # 4EX: Как можно получить возврат денежных средст по брони L949SF  авиркомпания победа отменила рейс и написали, что возврат сделали и деньги нужнополучить через вас
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) по ~бронь *
        go!: /ticketReturn/ticketReturnHow

