theme: /railwayExchange

    state: wannaExchangeTicket
        # 4EX: а можно поменять билеты с одного вагона на другой?
        q!: * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] $ticket} * $railwayAll *
        q!: * $railwayAll * ($how/$want/$need2/$canSynPossible) * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] $ticket} *
        q!: * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] $ticket} * $railwayAll * ($how/$want/$need2/$canSynPossible) [$markQuestion]
        q!: * $buyVerbPast * $ticket * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] $railwayAll} *
        q!: * $ticket * $buyVerbPast * {($changeInfAll/$exchangeAllExceptPast) [$my2/$ruSvoi] $railwayAll} *
        a: По правилам РЖД, обмен билетов запрещен. При необходимости вы можете произвести возврат билетов и оформить новые.



    state: wannaChangeTicketParameters
        # 4EX: Добрый день! Подскажите пожалуйста номер телефона по которому я могу изменить дату поездки сапсана
        q!: * $railwayAll * ($changeInfAll/перенести/перинести) * ((~время/~дата/~число) (~поездка/~отъезд/~выезд/~отправление)) *
        q!: * ($changeInfAll/перенести/перинести) * $railwayAll * ((~время/~дата/~число) (~поездка/~отъезд/~выезд/~отправление)) *
        q!: * ($changeInfAll/перенести/перинести) * ((~время/~дата/~число) (~поездка/~отъезд/~выезд/~отправление)) * $railwayAll *
        # 4EX: Здравствуйте, хотел перенести отправление поезда на среду тоесть 19.12.18г?
        q!: * $railwayAll * ($changeInfAll/перенести/перинести) * (~поездка/~отъезд/~выезд/~отправление/$railwayAll) на *
        q!: * ($changeInfAll/перенести/перинести) * $railwayAll * (~поездка/~отъезд/~выезд/~отправление/$railwayAll) на *
        q!: * ($changeInfAll/перенести/перинести) * (~поездка/~отъезд/~выезд/~отправление/$railwayAll) на * $railwayAll *
        # 4EX: нужно исправить пунк назначения в жд билетах
        q!: * ($changeInfAll/исправить) * ((пунк*/станци*/мест*/точк*) (назначени*/прибыти*/отбыти*/отправлени*/приезд*/отъезд*)) * $railwayAll [$markQuestion]
        q!: * $railwayAll * ($changeInfAll/исправить) * ((пунк*/станци*/мест*/точк*) (назначени*/прибыти*/отбыти*/отправлени*/приезд*/отъезд*)) [$markQuestion]
        go!: /railwayExchange/wannaExchangeTicket



    state: wannaExchangeTicketDate
        # 4EX: Могу ли я поменять жд билет с датой 30.12 на сегодня 29.12?
        q!: * ($changeInfAll/перенести/перинести) * $railwayAll * (с/на) ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $railwayAll * ($changeInfAll/перенести/перинести) * (с/на) ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * (с/на) ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($changeInfAll/перенести/перинести) * $railwayAll *
        q!: * (с/на) ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $railwayAll * ($changeInfAll/перенести/перинести) *
        go!: /railwayExchange/wannaExchangeTicket


