theme: /aviaCompanyKidsInfo


    state: issueTicketForKidOrderNumber
        # 4EX: здравствуйте, я хотела бы дозаказать билет для ребенка 8 лет на рейс SU 1628 из Москвы в Симферополь и обратно на рейс SU 1623 из Симферополя в Москву  заказ на взрослого оформлен под номером 169005310001
        q!: * $orderNumber * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))}
        q!: * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} * $orderNumber *
        go!: /aviaCompanyKidsInfoAns/confluenceUrlKids/confluenceUrlKids



    state: howToBuyAccompanyingСhild
        # 4EX: Как оплатить услугу сопровождение ребёнка???
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf) * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf) *
        a: Уточните, пожалуйста, номер заказа.
        go: /aviaCompanyKidsInfoAns/confluenceUrlKids



    state: accompanyingCheildFromDest
        # 4EX: у меня билеты мск спб. что там с детским сопровождением?
        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::destCode *
        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * [$ticket/$airplaneTicket] [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * [$ticket/$airplaneTicket] * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] [$from] [$cityPreName] $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::destCode *

        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::destCode * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * [$ticket/$airplaneTicket] *
        go!: /aviaCompanyKidsInfo/howToBuyAccompanyingСhild



    state: accompanyingCheildFromDest3Cities
        # 4EX: Добрый день! Подскажите, пожалуйста, есть ли услуга авиакомпании сопроводить девочку 13 лет по маршруту Грозный - Москва - Оренбург. Посадить в самолет, встретить в г.Москва, посадить на самолет?
        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        # 4EX: у меня билеты мск спб мск. что там с детским сопровождением?
        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * [$ticket/$airplaneTicket] [$from] [$cityPreName] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * [$ticket/$airplaneTicket] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * [$ticket/$airplaneTicket] * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *

        q!: * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$ticket/$airplaneTicket] * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ((сопровожден*/сопроводить) [для/доя/на] ($childAll/маотчик*/мальчик*/девочк*) [$ageWithNumb] / $childAdj (сопровожден*/сопроводить)) * [$ticket/$airplaneTicket] *
        go!: /aviaCompanyKidsInfo/howToBuyAccompanyingСhild



