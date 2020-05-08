theme: /Ticket

    state: CheckTicket
        # Как проверить билет?
        q!: [$helloAll] $regexp<\d{1,15}> {есть $prizeLocal}
        q!: * какой $prizeLocal составил * $ticket *
        q!: [$helloAll] *скажит* [$sum] [$comMy] $prizeLocal
        q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal *
        q!: [$helloAll] ($sum/$result) [$comMy] $prizeLocal [интересует] [$ticket] [$number $Number]
        q!: [$helloAll] ставка $Number [$how/$comWhere] (проверять/проверить/про верить/проверит/пробить)
        q!: [$helloAll] можно [$li] (проверить/про верить/проверит/пробить)
        q!: [$helloAll] ($ticket/$ticketNumber) $Number ($ticketRun/$ticketRunNumber) $Number
        q!: * $want знать $sum [$comMy] $prizeLocal *
        q!: (CheckTicket/* Check Ticket/*Check-Ticket)
        q!: [$helloAll] я $winPastPerf
        q!: * ($checkTicket/посмотрите) [я] вроде [бы] $winPastPerf *
        q!: [$helloAll] [я] $want знать $win
        q!: * {[$how/$comWhere] * $checkTicket * $ticket} *
        q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win} *
        q!: * {[$how/$comWhere] * $checkTicket * $ticketRun} *
        q!: * {[$how/$comWhere] * $checkTicket * $lottery} *
        q!: * {[$how/$comWhere] * $findOutInf * $win} *
        q!: * {$findOutImp * $win} *
        q!: [$how/$comWhere] [его/их] (проверять/проверить/про верить/проверит/пробить)
        q!: {[мне/нам] $comNeed (проверять/проверить/про верить/проверит/пробить)}
        q!: * {~проверка * $ticket} *
        q!: * {~проверка * $ticketRun} *
        q!: * {~проверка * $lottery} *
        q!: * {$how * сыграл* * $ticket} *
        q!: * {$ticket * $comWhat * $winPastPerf} *
        q!: [сколько/скоко/сколька/сколка] {[~мой] $ticket $winPastPerf}
        q!: [$helloAll] $prizeWithoutMoney [по] $ticket
        q!: [$helloAll] $comWhat за $prizeWithoutMoney

        q!: * {[$how/$comWhere] * $findInf * $win} *
        q!: [$helloAll] {[я] $winPastPerf $something} [сегодня]
        q!: * [посмотреть] * $winPastPerf * ($or ($comNo/$comWhat)) *
        q!: * {выигрышн* $ticket} ($or ($comNo/$comWhat)) *
        q!: * {выйгрышн* $ticket} ($or ($comNo/$comWhat)) *
        q!: * ($findOutInf/$checkInf) ($winPastPerf $comNo) *
        q!: * {$winPastPerf * $or * проиграл*} *
        q!: * у меня $prizeLocal $or как
        q!: * есть ли $prizeLocal *
        q!: * $findOutInf есть [$li] * $win *
        q!: * $findOutInf [~какой] ~сумма [я] $win *
        q!: [$helloAll] {[$comWhat] я $winPastPerf}

        q!: [$helloAll] [$comMy] [$code $Number] {~какой [$comMy] $win}
        q!: [$helloAll] [$comMy] [$code $Number] как ой [$comMy] $prizeLocal
        q!: $Number $comWhat за $prizeLocal
        q!: * $tellImp [мне] [$please] ~сумма $prizeLocal ([по] $ticket) *
        q!: {$howMuch $prizeWithoutMoney [в] [$lottery/$stoloto]}
        q!: * {~какой у $me $win} *
        q!: * {~какой ((у/по) $ticket) $win} *
        q!: * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) *
        q!: * $howMuch [я] $winPastPerf *
        q!: * $howMuch (составил/составляет) $win *
        q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney)} *
        q!: * $comWhat [я] $winPastPerf *
        q!: * {($findOutInf/$checkInf) * $result} *
        q!: * $winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery)) *
        q!: $localMobilePhoneNumber этот $phoneAndNum $winPastPerf
        q!: * $ticketRun $Number $ticketNumber $Number $number $ticketPack $Number [~мой] ($ticket/$ticketRun/$lottery) $win *
        eg!: Ticket.CheckTicket
        a: Какая лотерея Вас интересует?

        state: RussianLoto
            q: * $russianLoto * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $russianLoto *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $russianLoto} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $russianLoto} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $russianLoto} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $russianLoto} *
            q!: * {$findOutInf * $win * $russianLoto} *
            q!: * {$findOutImp * $win * $russianLoto} *
            q!: * {~проверка * $ticket * $russianLoto} *
            q!: * {~проверка * $ticketRun * $russianLoto} *
            q!: * {~проверка * $lottery * $russianLoto} *
            q!: * {$how * сыграл* * $ticket * $russianLoto} *
            q!: * {$ticket * $comWhat * $winPastPerf * $russianLoto} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $russianLoto

            q!: * {[$how/$comWhere] * $findInf * $win * $russianLoto} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $russianLoto} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $russianLoto} *
            q!: * {$winPastPerf * $or * проиграл* * $russianLoto} *
            q!: * {(есть ли $prizeLocal) * $russianLoto} *
            q!: * {($findOutInf есть [$li]) * $win * $russianLoto} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $russianLoto} *

            q!: {~какой [$comMy] $win $russianLoto}
            q!: {$howMuch $prizeWithoutMoney [в] $russianLoto}
            q!: * {~какой у $me $win} * $russianLoto *
            q!: * $russianLoto * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $russianLoto *
            q!: * $russianLoto * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $russianLoto} *
            q!: * {($howMuch [я] $winPastPerf) * $russianLoto} *
            q!: * {($howMuch (составил/составляет) $win) * $russianLoto} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $russianLoto} *
            q!: * {($comWhat [я] $winPastPerf) * $russianLoto} *
            q!: * {($findOutInf/$checkInf) * $result * $russianLoto} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $russianLoto} *

            if: Time.isSpecialEvent(15, 30)
                a: Прямую трансляцию новогоднего тиража «Русского лото» смотрите первого января в 15:30 по московскому времени на НТВ.
            else:
                if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                    a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                else:
                    go!: ../Other

        state: GoldenShoe
            q: * $goldenShoe * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $goldenShoe *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $goldenShoe} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $goldenShoe} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $goldenShoe} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $goldenShoe} *
            q!: * {$findOutInf * $win * $goldenShoe} *
            q!: * {$findOutImp * $win * $goldenShoe} *
            q!: * {~проверка * $ticket * $goldenShoe} *
            q!: * {~проверка * $ticketRun * $goldenShoe} *
            q!: * {~проверка * $lottery * $goldenShoe} *
            q!: * {$how * сыграл* * $ticket * $goldenShoe} *
            q!: * {$ticket * $comWhat * $winPastPerf * $goldenShoe} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $goldenShoe

            q!: * {[$how/$comWhere] * $findInf * $win * $goldenShoe} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $goldenShoe} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $goldenShoe} *
            q!: * {$winPastPerf * $or * проиграл* * $goldenShoe} *
            q!: * {(есть ли $prizeLocal) * $goldenShoe} *
            q!: * {($findOutInf есть [$li]) * $win * $goldenShoe} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $goldenShoe} *

            q!: {~какой [$comMy] $win $goldenShoe}
            q!: {$howMuch $prizeWithoutMoney [в] $goldenShoe}
            q!: * {~какой у $me $win} * $goldenShoe *
            q!: * $goldenShoe * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $goldenShoe *
            q!: * $goldenShoe * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $goldenShoe} *
            q!: * {($howMuch [я] $winPastPerf) * $goldenShoe} *
            q!: * {($howMuch (составил/составляет) $win) * $goldenShoe} *
            q!: * {($comWhat [я] $winPastPerf) * $goldenShoe} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $goldenShoe} *
            q!: * {($findOutInf/$checkInf) * $result * $goldenShoe} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $goldenShoe} *

            if: Time.isSpecialEvent(10, 30)
                a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
            else:
                if: Time.sundayTimeIsGood()
                    a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                else:
                    go!: ../Other

        state: Bingo75
            q: * $bingo * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $bingo *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $bingo} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $bingo} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $bingo} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $bingo} *
            q!: * {$findOutInf * $win * $bingo} *
            q!: * {$findOutImp * $win * $bingo} *
            q!: * {~проверка * $ticket * $bingo} *
            q!: * {~проверка * $ticketRun * $bingo} *
            q!: * {~проверка * $lottery * $bingo} *
            q!: * {$how * сыграл* * $ticket * $bingo} *
            q!: * {$ticket * $comWhat * $winPastPerf * $bingo} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $bingo

            q!: * {[$how/$comWhere] * $findInf * $win * $bingo} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $bingo} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $bingo} *
            q!: * {$winPastPerf * $or * проиграл* * $bingo} *
            q!: * {(есть ли $prizeLocal) * $bingo} *
            q!: * {($findOutInf есть [$li]) * $win * $bingo} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $bingo} *

            q!: {~какой [$comMy] $win $bingo}
            q!: {$howMuch $prizeWithoutMoney [в] $bingo}
            q!: * {~какой у $me $win} * $bingo *
            q!: * $bingo * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $bingo *
            q!: * $bingo * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $bingo} *
            q!: * {($howMuch [я] $winPastPerf) * $bingo} *
            q!: * {($howMuch (составил/составляет) $win) * $bingo} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $bingo} *
            q!: * {($comWhat [я] $winPastPerf) * $bingo} *
            q!: * {($findOutInf/$checkInf) * $result * $bingo} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $bingo} *

            if: Time.isSpecialEvent(10, 30)
                a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
            else:
                if: Time.sundayTimeIsGood()
                    a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                else:
                    go!: ../Other

        state: 6of36
            q: * $6of36 * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $6of36 *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $6of36} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $6of36} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $6of36} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $6of36} *
            q!: * {$findOutInf * $win * $6of36} *
            q!: * {$findOutImp * $win * $6of36} *
            q!: * {~проверка * $ticket * $6of36} *
            q!: * {~проверка * $ticketRun * $6of36} *
            q!: * {~проверка * $lottery * $6of36} *
            q!: * {$how * сыграл* * $ticket * $6of36} *
            q!: * {$ticket * $comWhat * $winPastPerf * $6of36} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $6of36

            q!: * {[$how/$comWhere] * $findInf * $win * $6of36} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $6of36} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $6of36} *
            q!: * {$winPastPerf * $or * проиграл* * $6of36} *
            q!: * {(есть ли $prizeLocal) * $6of36} *
            q!: * {($findOutInf есть [$li]) * $win * $6of36} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $6of36} *

            q!: {~какой [$comMy] $win $6of36}
            q!: {$howMuch $prizeWithoutMoney [в] $6of36}
            q!: * {~какой у $me $win} * $6of36 *
            q!: * $6of36 * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $6of36 *
            q!: * $6of36 * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $6of36} *
            q!: * {($howMuch [я] $winPastPerf) * $6of36} *
            q!: * {($howMuch (составил/составляет) $win) * $6of36} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $6of36} *
            q!: * {($comWhat [я] $winPastPerf) * $6of36} *
            q!: * {($findOutInf/$checkInf) * $result * $6of36} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $6of36} *

            if: Time.isSpecialEvent(10, 30)
                a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
            else:
                if: Time.sundayTimeIsGood()
                    a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                else:
                    go!: ../Other

        state: HousingLottery
            q: * $housingLottery * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $housingLottery *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $housingLottery} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $housingLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $housingLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $housingLottery} *
            q!: * {$findOutInf * $win * $housingLottery} *
            q!: * {$findOutImp * $win * $housingLottery} *
            q!: * {~проверка * $ticket * $housingLottery} *
            q!: * {~проверка * $ticketRun * $housingLottery} *
            q!: * {~проверка * $lottery * $housingLottery} *
            q!: * {$how * сыграл* * $ticket * $housingLottery} *
            q!: * {$ticket * $comWhat * $winPastPerf * $housingLottery} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $housingLottery

            q!: * {[$how/$comWhere] * $findInf * $win * $housingLottery} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $housingLottery} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $housingLottery} *
            q!: * {$winPastPerf * $or * проиграл* * $housingLottery} *
            q!: * {(есть ли $prizeLocal) * $housingLottery} *
            q!: * {($findOutInf есть [$li]) * $win * $housingLottery} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $housingLottery} *

            q!: {~какой [$comMy] $win $housingLottery}
            q!: {$howMuch $prizeWithoutMoney [в] $housingLottery}
            q!: * {~какой у $me $win} * $housingLottery *
            q!: * $housingLottery * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $housingLottery *
            q!: * $housingLottery * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $housingLottery} *
            q!: * {($howMuch [я] $winPastPerf) * $housingLottery} *
            q!: * {($howMuch (составил/составляет) $win) * $housingLottery} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $housingLottery} *
            q!: * {($comWhat [я] $winPastPerf) * $housingLottery} *
            q!: * {($findOutInf/$checkInf) * $result * $housingLottery} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $housingLottery} *

            if: Time.isSpecialEvent(10, 30)
                a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
            else:
                if: Time.sundayTimeIsGood()
                    a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                else:
                    go!: ../Other

        state: OtherNamedLottery
            q: * $otherNamedLottery * || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $otherNamedLottery *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $otherNamedLottery} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $otherNamedLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $otherNamedLottery} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $otherNamedLottery} *
            q!: * {$findOutInf * $win * $otherNamedLottery} *
            q!: * {$findOutImp * $win * $otherNamedLottery} *
            q!: * {~проверка * $ticket * $otherNamedLottery} *
            q!: * {~проверка * $ticketRun * $otherNamedLottery} *
            q!: * {~проверка * $lottery * $otherNamedLottery} *
            q!: * {$how * сыграл* * $ticket * $otherNamedLottery} *
            q!: * {$ticket * $comWhat * $winPastPerf * $otherNamedLottery} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $otherNamedLottery

            q!: * {[$how/$comWhere] * $findInf * $win * $otherNamedLottery} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $otherNamedLottery} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $otherNamedLottery} *
            q!: * {$winPastPerf * $or * проиграл* * $otherNamedLottery} *
            q!: * {(есть ли $prizeLocal) * $otherNamedLottery} *
            q!: * {($findOutInf есть [$li]) * $win * $otherNamedLottery} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $otherNamedLottery} *

            q!: {~какой [$comMy] $win $otherNamedLottery}
            q!: {$howMuch $prizeWithoutMoney [в] $otherNamedLottery}
            q!: * {~какой у $me $win} * $otherNamedLottery *
            q!: * $otherNamedLottery * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $otherNamedLottery *
            q!: * $otherNamedLottery * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $otherNamedLottery} *
            q!: * {($howMuch [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {($howMuch (составил/составляет) $win) * $otherNamedLottery} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $otherNamedLottery} *
            q!: * {($comWhat [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {($findOutInf/$checkInf) * $result * $otherNamedLottery} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $otherNamedLottery} *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».

        state: Other
            q: * $multiTicketRun * || fromState = /Ticket/CheckTicket
            q: ($stoloto/спортлото/[спорт] лото) || fromState = /Ticket/CheckTicket
            q!: [$helloAll] [*скажит*] (какой/каков) [$comMy] $prizeLocal * $multiTicketRun *
            q!: * {[$how/$comWhere] * $checkTicket * $ticket * $multiTicketRun} *
            q!: * {[$how/$comWhere] * ($checkTicket/$checkInf) * $win * $multiTicketRun} *
            q!: * {[$how/$comWhere] * $checkTicket * $ticketRun * $multiTicketRun} *
            q!: * {[$how/$comWhere] * $checkTicket * [$lottery] * $multiTicketRun} *
            q!: * {$findOutInf * $win * $multiTicketRun} *
            q!: * {$findOutImp * $win * $multiTicketRun} *
            q!: * {~проверка * $ticket * $multiTicketRun} *
            q!: * {~проверка * $ticketRun * $multiTicketRun} *
            q!: * {~проверка * $lottery * $multiTicketRun} *
            q!: * {$how * сыграл* * $ticket * $multiTicketRun} *
            q!: * {$ticket * $comWhat * $winPastPerf * $multiTicketRun} *
            q!: [$helloAll] $prizeWithoutMoney [по] $ticket $multiTicketRun

            q!: * {[$how/$comWhere] * $findInf * $win * $multiTicketRun} *
            q!: * {$winPastPerf * ($or ($comNo/$comWhat)) * $multiTicketRun} *
            q!: * {(($findOutInf/$checkInf) ($winPastPerf $comNo)) * $multiTicketRun} *
            q!: * {$winPastPerf * $or * проиграл* * $multiTicketRun} *
            q!: * {(есть ли $prizeLocal) * $multiTicketRun} *
            q!: * {($findOutInf есть [$li]) * $win * $multiTicketRun} *
            q!: * {($findOutInf [~какой] ~сумма [я] $win) * $multiTicketRun} *

            q!: {~какой [$comMy] $win $multiTicketRun}
            q!: {$howMuch $prizeWithoutMoney [в] $multiTicketRun}
            q!: * {~какой у $me $win} * $multiTicketRun *
            q!: * $multiTicketRun * {~какой у $me $win} *
            q!: * {~какой ((у/по) $ticket) $win} * $multiTicketRun *
            q!: * $multiTicketRun * {~какой ((у/по) $ticket) $win} *
            q!: * {(~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $multiTicketRun} *
            q!: * {($howMuch [я] $winPastPerf) * $multiTicketRun} *
            q!: * {($howMuch (составил/составляет) $win) * $multiTicketRun} *
            q!: * {($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $multiTicketRun} *
            q!: * {($comWhat [я] $winPastPerf) * $multiTicketRun} *
            q!: * {($findOutInf/$checkInf) * $result * $multiTicketRun} *
            q!: * {($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $multiTicketRun} *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».

        state: CheckButtonIsNotActive
            # Кнопка Проверить не активна
            q!: * {$button $checkTicket [$ticket] $activeNe} *
            q!: * ($indicatePresSg1/$indicatePast) ($ticketRun/$ticketRunNumber) и ($ticket/$ticketNumber) * {$button $activeNe} *
            q!: * ($indicatePresSg1/$indicatePast) ($ticket/$ticketNumber) и ($ticketRun/$ticketRunNumber) * {$button $activeNe} *
            q: * {$button $activeNe} *
            eg: Ticket.CheckTicket.CheckButtonIsNotActive
            a: Сложность, о которой Вы пишете, может возникать на стороне Вашего браузера. Папки с копиями данных Вашего браузера (cache браузера) могут быть переполнены и подгружать старые страницы с информацией.\n\nОбновите, пожалуйста, страницу, с которой возникает сложность, круговой стрелкой или сочетанием кнопок ctrl+f5. Если все останется по-прежнему, то попробуйте почистить данные Вашего браузера или зайти и выполнить действие с другого браузера.\n\nИнструкция по очистке данных Вашего браузера находится по ссылке https://yandex.ru/support/common/browsers-settings/cache.html . Если ситуация повторится, то сообщите, пожалуйста, нам об этом.

        state: IDontRememberWhichLottery
            # Я не помню, какая лотерея
            q: * {[я] ($forgetPastPres/$knowNe/$lookPast3Ne) ((какая/какую/$comWhat за) $lottery)} *
            q: * ($forgetPastPres/$knowNe/$lookPast3Ne) (какую/что) $buyPastPres *
            q: * ($forgetPastPres/$knowNe/$lookPast3Ne) * в какой * $lottery *
            q: * {($forgetPastPres/$knowNe/$lookPast3Ne) * ($how [она] называет*)} *
            q: * {($forgetPastPres/$knowNe/$lookPast3Ne) * ~название} *
            q: * (вчерашн*/дешевая/сегодняшн*/сегоднящ*/утрен*) *
            q: * {$buyPastPres ((за/по) $numberRub)} *
            q: * {$ticket ((за/по) $numberRub)} *
            q: [за/по] $numberRub
            eg: Ticket.CheckTicket.IDontRememberWhichLottery
            go!: ../Other

        state: LocalCatchAll
            event: noMatch || fromState = /Ticket/CheckTicket
            script: Webim.switch();

        state: CatchLocalNoTicketRun || fromState = /Ticket/CheckTicket
            q: * $comNo * {$Number $ticketRun} *
            q: * $comNo * (этого/этому/этом/данного/данному/данном/~наш/~мой/~такой) $ticketRun *
            q: * $comWhere {$Number $ticketRun} *
            q: * (пишет/говорит/написано) $comNo $ticketRun *
            q: * {(в приложении) * $findPastPresNe * $ticketRun} *
            q: * ~архив $ticketRun *
            go!: /Lottery/WhereToFindResults

        state: ThereAreNoTicketRunNumberAndTicketNumber
            q: $comWhere * (его/это/он) *
            q: * это $comWhere *
            q: * серия $Number *
            q: * $ne ($number/$ticketNumber) $nothing *
            q: * $only ($number/$ticketNumber) и $code *
            q: * $comWhere (этот/эти) $number *
            q: * $comWhere эти $numeral *
            q: * {$forgetPastPres $number} *
            q: * $comNo этих данных *
            eg: Ticket.CheckTicket.ThereAreNoTicketRunNumberAndTicketNumber
            go!: /Ticket/ThereAreNoTicketRunNumberAndTicketNumber

        state: CheckByQrCode
            q: * {[$generalNamedLottery] * ($by $qrCode)} *
            a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.

        state: Coupon
            # у меня купон
            q: * ~купон *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: CheckTicketByQrCode
        # Проверить билет по Qr коду
        q!: * {$checkTicket * [$prizeLocal] * ([$by] $qrCode)} *
        q!: * $checkTicket * [$ticket] * [$generalNamedLottery] * ($by $qrCode) * [$ticket] *
        q!: * [$cantPastPres] * $checkTicket * [$ticket] * [$generalNamedLottery] * ($by $qrCode) *
        q!: * $cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$ticket] * [$generalNamedLottery] * ($by $qrCode) *
        q!: * ($by $qrCode) * $cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$ticket] * [$generalNamedLottery] *

        q!: * {$findOutInf * $win * [$generalNamedLottery] * ($by $qrCode)} *
        q!: * [$cantPastPres] * $findOutInf * $win * [$generalNamedLottery] * ($by $qrCode) *
        q!: * ($by $qrCode) * [$cantPastPres] * $findOutInf * $win * [$generalNamedLottery] *
        # Как отсканировать билет
        q!: $scanInf
        q!: * {[$how] * $scanInf * $ticketAll} *
        q!: * {[$how] * $scanInf * $lottery} *
        q!: * {[$how] * $scanInf * $qrCode} *
        q!: * {[$how] * $scanInf * $code} *
        eg!: Ticket.CheckTicketByQrCode
        a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.


    state: HowToCheckCoupon
        # Как проверить купон
        q!: * [$generalNamedLottery] * какой $prizeLocal составил * ~купон * [$generalNamedLottery] *
        q!: * {$checkTicket * ~купон * [$win] * [$generalNamedLottery]} *
        q!: * {$checkTicket * ~купон * [$win] * [$generalNamedLottery]} *
        q!: * {$checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$findOutImp * $win * ~купон * [$generalNamedLottery]} *
        q!: * {~проверка * ~купон * [$generalNamedLottery]} *
        q!: * {$how * сыграл* * ~купон * [$generalNamedLottery]} *
        q!: * {~купон * $comWhat * $winPastPerf * [$generalNamedLottery]} *
        q!: [$generalNamedLottery] {[~мой] ~купон $winPastPerf} [$generalNamedLottery]
        q!: [$helloAll] $prizeWithoutMoney [по] ~купон [$generalNamedLottery]
        q!: * [$generalNamedLottery] * {выигрышн* ~купон} ($or ($comNo/$comWhat)) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {выйгрышн* ~купон} ($or ($comNo/$comWhat)) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $tellImp [мне] [$please] ~сумма $prizeLocal ([по] ~купон) * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * {~какой ((у/по) ~купон) $win} * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $winPastPerf ($li) ~купон * [$generalNamedLottery] *

        q!: * {$cantPastPres * проверять * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверить * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверит * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * проверет * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * пробить * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * пробить * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $checkInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * понять * $win * ~купон * [$generalNamedLottery]} *
        q!: * {$checkTicketPresSgNe * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $findOutInf * $win * ~купон * [$generalNamedLottery]} *

        q!: * {$cantPastPres * ~проверка * ~купон * [$generalNamedLottery]} *
        q!: * {$cantPastPres * $how * сыграл* * ~купон * [$generalNamedLottery]} *
        q!: * никак ($ne (проверю/проверить/про верить)/непроверю/непроверить/нипроверю/нипроверить) ~купон * [$generalNamedLottery] *
        q!: * никак ~купон * [$generalNamedLottery] ($ne (проверю/проверить/про верить)/непроверю/непроверить/нипроверю/нипроверить) *
        q!: * {$cantPastPres * $findInf * $win * ~купон * [$generalNamedLottery]} *
        q!: * [$generalNamedLottery] * {~какой ((у/по) ~купон) $win} * $cantPastPres * [$generalNamedLottery] *
        q!: * [$generalNamedLottery] * $cantPastPres * {~какой ((у/по) ~купон) $win} * [$generalNamedLottery] *
        q!: * {$cantPastPres * ($winPastPerf ($li) ~купон) * [$generalNamedLottery]} *

        eg!: Ticket.HowToCheckCoupon
        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: TypesOfTickets
        q: * {$givePastNe * $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {$askPastNe * $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {$indicatePastNe * $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {$writeDownPastNe * $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * без [$receipt и] [указани*] $phoneAndNum * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {(забыл* (указать/записать)) * $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {($ne писали) $phoneAndNum} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale
        q: * {$phoneAndNum * ($ne привяз*)} * || fromState = /Lottery/HowToFindOutAUniqueKey/IBoughtInRetailPointOfSale

        q: * {$givePastNe * $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$askPastNe * $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$indicatePastNe * $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$writeDownPastNe * $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * без [$receipt и] [указани*] $phoneAndNum * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {(забыл* (указать/записать)) * $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {($ne писали) $phoneAndNum} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale
        q: * {$phoneAndNum * ($ne привяз*)} * || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber/IBoughtInRetailPointOfSale

        q: * {$givePastNe * $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * {$askPastNe * $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * ($ne требовал*/нетребовал*/нитребовал*) * || fromState = /Ticket/NoRegistrationTicket
        q: * {$indicatePastNe * $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * {$writeDownPastNe * $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * без [$receipt и] [указани*] $phoneAndNum * || fromState = /Ticket/NoRegistrationTicket
        q: * {(забыл* (указать/записать)) * $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * {($ne писали) $phoneAndNum} * || fromState = /Ticket/NoRegistrationTicket
        q: * {$phoneAndNum * ($ne привяз*)} * || fromState = /Ticket/NoRegistrationTicket

        a: Существует два вида билетов, которые Вы можете приобрести в точках распространения: с указанием номера мобильного телефона (электронные билеты) и без (типографские билеты, на лицевой стороне которых указана вся информация по билету). Ознакомиться с образцами билетов Вы можете на сайте, пройдя по ссылке http://www.stoloto.ru/ruslotto/rules . Если у Вас остались вопросы, пожалуйста, напишите нам.


    state: TypesOfTicketsFull
        # Нужно ли предъявлять чек при получении выигрыша?
        q!: * {$presentInf * $receipt * $prizeWithoutMoneyAllAndWinTicket} *
        q!: * {$presentInf * $receipt * $cashoutInf} *
        q!: * {$presentInf * $receipt * $winFutSg13} *
        q!: * {$presentInf * $receipt * $winFutSg2} *
        q!: * {$presentInf * $receipt * $winFutSg2} *
        q!: * {($comNeed [$li] $receipt) * $prizeWithoutMoneyAllAndWinTicket} *
        q!: * {($comNeed [$li] $receipt) * $cashoutInf} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg13} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg2} *
        q!: * {($comNeed [$li] $receipt) * $winFutSg2} *
        q!: * ($comNeed $li $receipt) * $paperTicketAll *
        q!: * ~получение $prizeWithoutMoney * {$presentInf [$only] [сам] $ticket} *
        q!: * (получить/забрать/отдали/выдали) $prizeWithoutMoney * {$presentInf [$only] [сам] $ticket} *
        q!: * ~получение $prizeWithoutMoney * кроме [самого] $ticket *
        q!: * (получить/забрать/отдали/выдали) $prizeWithoutMoney * кроме [самого] $ticket *

        q: * это купон * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * сказали * $registerInf * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * $paid * $retailPointOfSale * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * {$buyPastPres * $retailPointOfSale} * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * (предназнач*/нужен) * для $registration * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * у меня без $phoneAndNum * || fromState = /Ticket/IsItNecessaryToRegisterTicket
        q: * {$phoneAndNum * ($ne привяз*)} * || fromState = /Ticket/IsItNecessaryToRegisterTicket

        a: Существует два вида билетов: типографские и электронные.\n\nТипографские билеты, на лицевой стороне которых уже указан номер тиража. При покупке билета не указывается номер телефона. Основанием для получения выигрыша является сам билет.\n\nЭлектронные билеты, при покупке которых указывается номер телефона. При продаже оператор розничной точки, после уточнения номера телефона покупателя, регистрирует билет через специальный терминал и выдает черно-белую квитанцию, которая содержит всю информацию по билету, в том числе уникальный ключ и номер тиража. Основанием для получения выигрыша является уникальный ключ и код выигрыша (который поступает в смс на номер телефона, указанный при регистрации билета).\n\nОзнакомиться с образцами билетов Вы можете на сайте, пройдя по ссылке http://www.stoloto.ru/ruslotto/rules


    state: IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        # Пришло смс с выигрышем, проверяю, пишет, что билет без выигрыша
        q!: * {$smsComePast * $sms * $win} * $ticket без $prizeLocal *
        q!: * {$smsComePast * $code * $win} * $ticket без $prizeLocal *
        q!: * $ticket без $prizeLocal * {$smsComePast * $sms * $win} *
        q!: * $ticket без $prizeLocal * {$smsComePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * $ticket без $prizeLocal *
        q!: * {$receivePast * $code * $win} * $ticket без $prizeLocal *
        q!: * $ticket без $prizeLocal * {$receivePast * $sms * $win} *
        q!: * $ticket без $prizeLocal * {$receivePast * $code * $win} *
        q!: * {$smsComePast * $sms * $code} * $ticket без $prizeLocal *
        q!: * $ticket без $prizeLocal * {$smsComePast * $sms * $code} *
        q!: * {$receivePast * $sms * $code} * $ticket без $prizeLocal *
        q!: * $ticket без $prizeLocal * {$receivePast * $sms * $code} *
        q!: * {$smsComePast * $sms * $win} * $ticket $winPastPerfNe *
        q!: * {$smsComePast * $code * $win} * $ticket $winPastPerfNe *
        q!: * $ticket $winPastPerfNe * {$smsComePast * $sms * $win} *
        q!: * $ticket $winPastPerfNe * {$smsComePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * $ticket $winPastPerfNe *
        q!: * {$receivePast * $code * $win} * $ticket $winPastPerfNe *
        q!: * $ticket $winPastPerfNe * {$receivePast * $sms * $win} *
        q!: * $ticket $winPastPerfNe * {$receivePast * $code * $win} *
        q!: * {$smsComePast * $sms * $code} * $ticket $winPastPerfNe *
        q!: * $ticket $winPastPerfNe * {$smsComePast * $sms * $code} *
        q!: * {$receivePast * $sms * $code} * $ticket $winPastPerfNe *
        q!: * $ticket $winPastPerfNe * {$receivePast * $sms * $code} *
        q!: * {$smsComePast * $sms * $win} * $isWritten * без $prizeLocal *
        q!: * {$smsComePast * $code * $win} * $isWritten * без $prizeLocal *
        q!: * $isWritten * без $prizeLocal * {$smsComePast * $sms * $win} *
        q!: * $isWritten * без $prizeLocal * {$smsComePast * $code * $win} *
        q!: * {$smsComePast * $sms * $win} * $isWritten * $comNo $prizeLocal *
        q!: * {$smsComePast * $code * $win} * $isWritten * $comNo $prizeLocal *
        q!: * $isWritten * $comNo $prizeLocal * {$smsComePast * $sms * $win} *
        q!: * $isWritten * $comNo $prizeLocal * {$smsComePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * $isWritten * без $prizeLocal *
        q!: * {$receivePast * $code * $win} * $isWritten * без $prizeLocal *
        q!: * $isWritten * без $prizeLocal * {$receivePast * $sms * $win} *
        q!: * $isWritten * без $prizeLocal * {$receivePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * $isWritten * $comNo $prizeLocal *
        q!: * {$receivePast * $code * $win} * $isWritten * $comNo $prizeLocal *
        q!: * $isWritten * $comNo $prizeLocal * {$receivePast * $sms * $win} *
        q!: * $isWritten * $comNo $prizeLocal * {$receivePast * $code * $win} *
        q!: * {$smsComePast * $sms * $code} * $isWritten * без $prizeLocal *
        q!: * $isWritten * без $prizeLocal * {$smsComePast * $sms * $code} *
        q!: * {$receivePast * $sms * $code} * $isWritten * без $prizeLocal *
        q!: * $isWritten * без $prizeLocal * {$receivePast * $sms * $code} *
        q!: * {$smsComePast * $sms * $win} * $isWritten * $winPastPerfNe *
        q!: * {$smsComePast * $code * $win} * $isWritten * $winPastPerfNe *
        q!: * $isWritten * $winPastPerfNe * {$smsComePast * $sms * $win} *
        q!: * $isWritten * $winPastPerfNe * {$smsComePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * $isWritten * $winPastPerfNe *
        q!: * {$receivePast * $code * $win} * $isWritten * $winPastPerfNe *
        q!: * $isWritten * $winPastPerfNe * {$receivePast * $sms * $win} *
        q!: * $isWritten * $winPastPerfNe * {$receivePast * $code * $win} *
        q!: * {$smsComePast * $sms * $code} * $isWritten * $winPastPerfNe *
        q!: * $isWritten * $winPastPerfNe * {$smsComePast * $sms * $code} *
        q!: * {$receivePast * $sms * $code} * $isWritten * $winPastPerfNe *
        q!: * $isWritten * $winPastPerfNe * {$receivePast * $sms * $code} *
        q!: * {$smsComePast * $sms * $win} * ~проверка * $prizeLocal * $comNo *
        q!: * {$smsComePast * $code * $win} * ~проверка * $prizeLocal * $comNo *
        q!: * {$smsComePast * $sms * $win} * ~проверка * $comNo * $prizeLocal *
        q!: * {$smsComePast * $code * $win} * ~проверка * $comNo * $prizeLocal *
        q!: * ~проверка * $prizeLocal * $comNo * {$smsComePast * $sms * $win} *
        q!: * ~проверка * $prizeLocal * $comNo * {$smsComePast * $code * $win} *
        q!: * ~проверка * $comNo * $prizeLocal * {$smsComePast * $sms * $win} *
        q!: * ~проверка * $comNo * $prizeLocal * {$smsComePast * $code * $win} *
        q!: * {$receivePast * $sms * $win} * ~проверка * $prizeLocal * $comNo *
        q!: * {$receivePast * $code * $win} * ~проверка * $prizeLocal * $comNo *
        q!: * {$receivePast * $sms * $win} * ~проверка * $comNo * $prizeLocal *
        q!: * {$receivePast * $code * $win} * ~проверка * $comNo * $prizeLocal *
        q!: * ~проверка * $prizeLocal * $comNo * {$receivePast * $sms * $win} *
        q!: * ~проверка * $prizeLocal * $comNo * {$receivePast * $code * $win} *
        q!: * ~проверка * $comNo * $prizeLocal * {$receivePast * $sms * $win} *
        q!: * ~проверка * $comNo * $prizeLocal * {$receivePast * $code * $win} *
        q!: * {$smsComePast * $sms * $code} * ~проверка * $prizeLocal * $comNo *
        q!: * {$smsComePast * $sms * $code} * ~проверка * $comNo * $prizeLocal *
        q!: * ~проверка * $prizeLocal * $comNo * {$smsComePast * $sms * $code} *
        q!: * ~проверка * $comNo * $prizeLocal * {$smsComePast * $sms * $code} *
        q!: * {$receivePast * $sms * $code} * ~проверка * $prizeLocal * $comNo *
        q!: * {$receivePast * $sms * $code} * ~проверка * $comNo * $prizeLocal *
        q!: * ~проверка * $prizeLocal * $comNo * {$receivePast * $sms * $code} *
        q!: * ~проверка * $comNo * $prizeLocal * {$receivePast * $sms * $code} *
        q!: * $winTicket * $isWritten * без $prizeLocal *
        q!: * $winTicket * $isWritten * $comNo $prizeLocal *
        eg!: Ticket.IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        a: Уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.

        state: GetNumber || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: HowToExchangeAWinningTicketForANewOne
        # Как выигрышный билет обменять на новый?
        q!: * $playInf (снова/вновь/опять/заново/дальше) на $prizeWithoutMoneyAndWinTicket *
        q!: * {$payInf выигрышем} *
        q!: * {($win $ticketAll) * $exchangeInf} * на $new *
        q!: * $winPastPerf ($comMoney/$numberRub/~сумма) * {$exchangeInf * (на [$new] $ticketAll)} *
        q!: * $winPastPerf ($comMoney/$numberRub/~сумма) * {$exchangeInf * (на [$new] $ticketRun)} *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * (ей/ими/им/этой суммой) $payInf ([за] [$new] ($ticketAll/$ticketRun)) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * $payInf (ей/ими/им/этой суммой) ([за] [$new] ($ticketAll/$ticketRun)) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * ([за] [$new] ($ticketAll/$ticketRun)) (ей/ими/им/этой суммой) $payInf *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * ([за] [$new] ($ticketAll/$ticketRun)) $payInf (ей/ими/им/этой суммой) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * $payInf ([за] [$new] ($ticketAll/$ticketRun)) (ей/ими/им/этой суммой) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * (ей/ими/им/этой суммой) ([за] [$new] ($ticketAll/$ticketRun)) $payInf *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) [и] $want [на] [них/нее/него/эту сумму] $buyInf [на] [них/нее/него/эту сумму] [$new] ($ticketAll/$ticketRun) [на] [них/нее/него/эту сумму] *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) [и] $want [на] [них/нее/него/эту сумму] [$new] ($ticketAll/$ticketRun) [$new] [на] [них/нее/него/эту сумму] $buyInf *


        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * на (них/нее/него/эту сумму) $buyInf [$new] ($ticketAll/$ticketRun) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * $buyInf на (них/нее/него/эту сумму) [$new] ($ticketAll/$ticketRun) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * $buyInf [$new] ($ticketAll/$ticketRun) [$new] на (них/нее/него/эту сумму) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * на (них/нее/него/эту сумму) [$new] ($ticketAll/$ticketRun) [$new] $buyInf *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * ($ticketAll/$ticketRun) [$new] $buyInf [$new] на (них/нее/него/эту сумму) *
        q!: * ($winPastPerf/$prizeWithoutMoney) [состав*] ($comMoney/$numberRub/~сумма) * ($ticketAll/$ticketRun) [$new] на (них/нее/него/эту сумму) [$new] $buyInf *

        q!: * {$exchangeInf * ([$comMy] $prizeWithoutMoneyAndWinTicket)} на [$new] ($ticketAll/$ticketRun) *
        q!: * {($buyInf [$new/повторно/еще/еще один] ($ticketAll/$ticketRun)) * (на [$sum] $prizeWithoutMoneyAndWinTicket)} *
        q!: * {$buyInf ([$new/повторно/еще/еще один] ($ticketAll/$ticketRun)) (на [$sum] $prizeWithoutMoneyAndWinTicket)} *
        q!: * {($buyInf [$new/повторно] ($ticketAll/$ticketRun)) * (у меня $prizeWithoutMoney)} *

        q!: * $prizeWithoutMoneyAndWinTicket (на/для) $buyN $new [$ticketAll/$ticketRun/$lottery] *
        q!: * {$prizeWithoutMoneyAndWinTicket * $transferInfImp * ($buyN [$new] ($ticketAll/$ticketRun))} *
        q!: * {$prizeWithoutMoneyAndWinTicket * $useInf * ($buyN [$new] ($ticketAll/$ticketRun))} *
        q!: * {$prizeWithoutMoneyAndWinTicket * потратить * ($buyN [$new] ($ticketAll/$ticketRun))} *
        q!: * {$prizeWithoutMoneyAndWinTicket * потратить * (на $new ($ticketAll/$ticketRun))} *
        q!: * {$prizeWithoutMoneyAndWinTicket потратить (на $ticket)} *
        q!: * $winPastPerf ($comMoney/$numberRub/~сумма) * {$useInf * ($buyN [$new] ($ticketAll/$ticketRun))} *
        q!: * $winPastPerf ($comMoney/$numberRub/~сумма) * {потратить * ($buyN [$new] ($ticketAll/$ticketRun))} *
        q!: * $winPastPerf ($comMoney/$numberRub/~сумма) * {потратить * (на $new ($ticketAll/$ticketRun))} *
        q!: * {$payInf ([$comMy] $prizeWithoutMoneyAndWinTicket) ([за] [$new] ($ticketAll/$ticketRun))} *
        q!: * у меня * $prizeWithoutMoneyAndWinTicket * {(им/ими) $payInf ([за] [$new] ($ticketAll/$ticketRun))} *
        q!: * $payInf [$new] [$ticketAll/$ticketRun] ($comMoney/$numberRub/~сумма) ~который $winPastPerf *
        q!: * $buyInf [$new/повторно/еще/еще один] ($ticketAll/$ticketRun) * на ($comMoney/$numberRub/~сумма/$ticket) ~который $winPastPerf *
        q!: * ($ticketAll/$ticketRun) [$new/повторно/еще/еще один] $buyInf * на ($comMoney/$numberRub/~сумма/$ticket) ~который $winPastPerf *
        eg!: Ticket.HowToExchangeAWinningTicketForANewOne

        a: Уточните, пожалуйста, где Вы приобретали билет?

        state: IBoughtInRetailPointOfSale
            q: * $retailPointOfSale *
            q: * на руках *
            q: * совкомбанк* *
            q: * терминал* *
            q: * $geography *
            q!: {($win $paperTicketAll) * $exchangeInf} * на $new *
            a: При покупке билета Вы указывали номер телефона?

            state: Yes
                q: * (указывал*/указал*) *
                q: * $comYes *
                a: Если Вы приобретали билет в розничных точках продаж с указанием номера телефона, Вы можете получить выигрыш в точке продаж и там же приобрести новый билет либо можно получить свой выигрыш в Кошелек Столото и приобрести новый билет на сайте.\n\nДля этого нужно зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: No
                q: * $indicatePastNe *
                q: * $comNo *
                q: * без [указани*] ($telephoneNumber/$telephone) *
                q: * ($ne требовал*/нетребовал*/нитребовал*) *
                a: Если Вы приобретали билеты в розничных точках продаж без указания номера телефона, то Ваш выигрыш Вы можете получить в той же точке продаж или в лотерейной сети «БалтЛото», на Почте России, в киоске. С адресами точек продаж и лимитами выплат ознакомьтесь, пожалуйста, по ссылке http://www.stoloto.ru/map . Там же Вы сможете приобрести новые билеты.

            state: LocalCatchAll
                event: noMatch
                script: Webim.switch();

        state: IBoughtOnWebsite
            q: * $here *
            q: * $online *
            q: * (на/через/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: * по (~интернет/телефону) *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q!: {($win $eTicket) * $exchangeInf} * на $new *
            q!: * {$exchangeInf * $prizeWithoutMoneyAllAndWinTicket * (на [$new/еще один] $ticketAll) * $eTicket} *
            a: Уточните, пожалуйста, Вы приобретали билет через личный кабинет или без регистрации на сайте?

            state: IBoughtInAccount
                q: ($account/личный) [помоему/по моему/вроде [бы]]
                q: * {заводил* $account} *
                q: * в личном *
                q: * (на/через/черес/в/($with/при) ~помощь) ($account/личк*) *
                q: (через/черес/в/($with/при) ~помощь) ~личный
                q: * я $registered *
                q: $registered
                q: * ($with/по/после) $registration *
                q: после
                q: * $registration прошла *
                q: * пришлось $registerInfRefl *
                q: * $registerPastRefl3 *
                a: Если Вы приобретали билет через личный кабинет, Вы можете получить выигрыш в Кошелек Столото, а затем выигрышными средствами из Кошелька оплатить новый билет.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: IBoughtWithoutRegistration
                q: без
                q: * без $registration *
                q: * я $registeredNe *
                q: $registeredNe
                q: * $registerPastContReflSg3Ne *
                q: * ($ne заводил*/незаводил*/низаводил*) $account *
                q: * $account ($ne заводил*/незаводил*/низаводил*) *
                a: Если Вы приобретали билет на сайте без регистрации с указанием номера телефона, Вы можете получить свой выигрыш в Кошелек Столото, а затем выигрышными средствами из Кошелька оплатить новый билет.\n\nДля этого нужно зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nДля получения выигрыша в Кошелек Столото Вам необходимо зайти в Ваш личный кабинет, в раздел «Мои билеты». Выберите справа вкладку «Выигрышные». Затем необходимо нажать кнопку «Получить» с правой стороны (рядом с суммой Вашего выигрыша). Также Вы можете нажать на номер выигрышного билета и перейти на страницу квитанции. На странице счастливой квитанции нажмите кнопку «Перевести».\n\nМаксимальная сумма выигрыша к зачислению составляет 100 000 рублей для идентифицированных пользователей, 15 000 рублей для неидентифицированных​. Полная инструкция по получению выигрыша - по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста.

            state: LocalCatchAll
                event: noMatch
                script: Webim.switch();

        state: IBoughtOnWebsiteInAccount
            q: [$website] $account
            q: * (на/через/черес/в/($with/при) ~помощь) $account *
            q: * (на/через/черес/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) $with $registration *
            q: * по ~интернет $with $registration *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) $with $registration *
            q: * {$online ($with $registration)} *
            q: * $here ($with $registration) *
            go!: /Ticket/HowToExchangeAWinningTicketForANewOne/IBoughtOnWebsite/IBoughtInAccount

        state: IBoughtOnWebsiteWithoutRegistration
            q: * (на/через/черес/в/($with/при) ~помощь) [$this/ваш*] ($website/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) без $registration *
            q: * по ~интернет без $registration *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) без $registration *
            q: * {$online (без $registration)} *
            q: * $here (без $registration) *
            go!: /Ticket/HowToExchangeAWinningTicketForANewOne/IBoughtOnWebsite/IBoughtWithoutRegistration

        state: LocalCatchAll
            event: noMatch
            script: Webim.switch();


    state: GaveTicketHowToCheck
        # Подарили билет, как проверить выигрыш?
        q!: * {$giftPast * $ticketAll * $checkTicket} *
        q!: * {$giftPast * $ticketAll * ~проверка} *
        eg!: Ticket.GaveTicketHowToCheck
        script: Webim.switch();


    state: IBoughtATicketWhatIsNext
        # Купил билет, что делать дальше
        q!: * {$buyPastPres * ($ticketAll/$lottery)} * (дальше/делать/~действие) *
        q!: * {$payPast * ($ticketAll/$lottery)} * (дальше/делать/~действие) *
        q!: * (дальше/делать/~действие) * {$buyPastPres * ($ticketAll/$lottery)} *
        q!: * (дальше/делать/~действие) * {$payPast * ($ticketAll/$lottery)} *
        eg!: Ticket.IBoughtATicketWhatIsNext
        a: Билет принимает участие в тираже, на который он был оформлен. По ссылке https://www.stoloto.ru/lottery/onlinesale Вы можете ознакомиться, как принять участие в наших лотереях.


    state: IBoughtATicketInPyaterochkaWhatIsNext
        # Купил билет в Пятерочке, что дальше
        q!: * {$buyPastPres * $ticketAll * $retailPointOfSale} * (дальше/делать/~действие) *
        q!: * {$buyPastPres * $lottery * $retailPointOfSale} * (дальше/делать/~действие) *
        q!: * {$buyPastPres * $paperTicketAll} * (дальше/делать/~действие) *
        q!: * дали * ($ticketAll/$lottery) * $retailPointOfSale * (дальше/делать/~действие) *
        q!: * дали * $paperTicketAll * (дальше/делать/~действие) *
        q!: * (дальше/делать/~действие) * {$buyPastPres * $ticketAll * $retailPointOfSale} *
        q!: * (дальше/делать/~действие) * {$buyPastPres * $lottery * $retailPointOfSale} *
        q!: * (дальше/делать/~действие) * {$buyPastPres * $paperTicketAll} *
        eg!: Ticket.IBoughtATicketInPyaterochkaWhatIsNext
        a: Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты».\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации - по ссылке http://www.stoloto.ru/registration .\n\nЕсли после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.\n\nПроверить билет можно после проведения тиража.


    state: StarterTicket
        # Что такое стартовый тираж?
        q!: $starterTicket
        q!: * {$comWhat * ~стартовый [$ticketRun]} *
        q!: * {$tellMe * ~стартовый [$ticketRun]} *
        eg!: Ticket.StarterTicket
        a: В случае, если Вы приобретаете многотиражный билет, для корректной проверки квитанции необходимо указывать номер первого из тех тиражей, на которые приобретен билет.


    state: ThereAreNoTicketRunNumberAndTicketNumber
        # Где посмотреть стартовый тираж?
        q!: * {$comWhere * $starterTicket} *
        q!: * {($findInf/$findPastPresNe) * $starterTicket} *
        q!: * {($findOutInf/определить) * $starterTicket} *
        q!: * {($knowNe/$forgetPastPres) * $starterTicket} *
        q!: * {$comNeed * $starterTicket} *
        q!: * $comWhat [$here/$onTicket] $bePresSg3 $starterTicket *
        # Где на билете номер тиража?
        q!: $ticketRunNumber
        q!: * $comWhat такое $ticketRunNumber *
        q!: * $ticketRunNumber {$howMuch [там/это] $numeral} *
        q!: * в каком ($ticketRunNumber/$ticketRun) (он/они) $playPastPres *
        q!: [$helloAll] [$beginningWords] $ticketRunNumber [$comWhat] это *
        q!: [$helloAll] *скажи* [$please] [$beginningWords] $ticketRunNumber *
        q!: [$helloAll] $how $oneWord какой ($ticketRunNumber/$ticketRun)
        q!: * {$comWhere * [$onTicket] * $ticketRunNumber} *
        q!: * {$comWhere * $ticketRun * $onTicket} *
        q!: * {$comWhere $ticketRun (на нем)} *
        q!: * {$comWhere $indicatePartPas $ticketRun} *
        q!: * {$findInf * [$onTicket] * $ticketRunNumber} *
        q!: * {[$cantPastPres] $findInf $ticketRun} *
        q!: * {$checkInf * $ticketRunNumber} *
        q!: * {$forgetPastPres [[на] [~какой]] $ticketRun} *
        q!: * {$lookPast3Ne ($ticketRunNumber/$ticketRun)} *
        q!: * {[$buyPastPres] * [$onTicket/$ticket] * $writeDownPastNe * $ticketRunNumber} *
        q!: * {$writeDownPastNe $ticketRun} *
        q!: * {[$buyPastPres] * [$ticketAll/$onTicket] * ($findOutInf/определить) * $ticketRunNumber} *
        q!: * ($findOutInf/определить) $ticketRunNumber * {(куплен*/приобрет*) * $ticket} *
        q!: * [$how] {($findOutInf/определить) $ticketRun} *
        q!: * {$findPastPresNe * $onTicket * $ticketRun} *
        q!: * {$findPastPresNe нигде $ticketRun} *
        q!: * {$findPastPresNe * $onTicket * $ticketRunNumber} *
        q!: * {$findPastPresNe нигде $ticketRunNumber} *
        q!: * {$knowNe * $ticketRunNumber * [$checkTicket] * [$ticket]} *
        q!: * {$forgetPastPres * $ticketRunNumber * [$checkTicket] * [$ticket]} *
        q!: * {$knowNe * (~какой $ticketRun) * [$checkTicket] * [$ticket]} *
        q!: * {$forgetPastPres * (~какой $ticketRun) * [$checkTicket] * [$ticket]} *

        q!: * {($knowNe/$forgetPastPres) я $ticketRun} * [$checkTicket] * [$ticket] *
        q!: * [$checkTicket] * [$ticket] * {($knowNe/$forgetPastPres) я $ticketRun} *

        q!: * $comNeed ($ticketRunNumber/$ticketRun) *
        q!: * [$buyPastPres] * [$ticket] * {$comNo [на нем] $ticketRunNumber} * [$ticket] *
        q!: * [$buyPastPres] * [$ticket] * {$comNo $ticketRun} * [$ticket] *

        q!: * {$checkInf * [$ticket] * (без $ticketRunNumber)} *
        q!: * {$checkInf * $ticket * $comNo * $ticketRunNumber} *
        q!: * {$checkInf * $ticket * $comNo * $ticketRun} *
        q!: * {$checkInf * $ticket * $writtenNe * $ticketRunNumber} *
        q!: * {$checkInf * $ticket * $writtenNe * $ticketRun} *
        q!: * {$checkInf * $generalNamedLottery * $writtenNe * $ticketRunNumber} *
        q!: * {$checkInf * $generalNamedLottery * $writtenNe * $ticketRun} *
        q!: * {$checkInf * ($only $number $ticketPack)} *
        q!: * {$checkInf * (без $ticketRunNumber)} *
        q!: * {$checkInf * (без $ticketRun)} *

        q!: * [$checkTicket] * {[$generalNamedLottery] * [$ticket] * $writtenNe * $ticketRunNumber} * [$checkTicket] *
        q!: * [$checkTicket] * {[$generalNamedLottery] * [$ticket] * $writtenNe * $ticketRun} * [$checkTicket] *
        q!: * {(в ~какой $ticketRun) * $playPastPres * $ticket} *
        q!: * {(в ~какой $ticketRunNumber) * $playPastPres * $ticket} *
        q!: * (к ~какой $ticketRun) * относит* *
        q!: * какой это [был] $ticketRun *
        q!: * [у меня $ticketAll] без $ticketRunNumber *
        q!: * без $ticketRun *
        q!: * {$smsComePastNe (~какой $ticketRun)} *
        q!: * $comWhat [$here/$onTicket] $bePresSg3 $ticketRunNumber *
        q!: * $ticketRunNumber $unclear *
        # Где на билете указан номер билета?
        q!: $ticketNumber
        q!: * $comWhat такое $ticketNumber *
        q!: * (сколько/сколька/скока/скоко) $numeral * в $ticketNumber *
        q!: * $ticketNumber {$howMuch [там/это] $numeral} *
        q!: * $ticketNumber являет* $uniqueKey *
        q!: [$helloAll] [$beginningWords] $ticketNumber это *
        q!: [$helloAll] *скажи* [$please] [$beginningWords] $ticketNumber *
        q!: * {$comWhere * $seeInf * $ticketNumber} *
        q!: * {могу * $seeInf * $ticketNumber} *
        q!: * {$comWhere * [$receiveInf] * $ticketNumber} *
        q!: * {[$cantPastPres] * ($findInf/$findPastPresNe) * $ticketNumber * [$checkTicket]} *
        q!: * {$findPastPresNe нигде $ticketNumber} *
        q!: * {($findOutInf/определить) * $ticketNumber} *
        q!: * {$buyPastPres * $ticket} * {($findOutInf/определить) [его/их] $number} *
        q!: * {$buyPastPres * $ticket} * {$number * ($comWhere $seeInf)} *
        q!: * ($findOutInf/определить) $number * {(куплен*/приобрет*) * $ticket} *
        q!: * {$checkInf $ticketNumber} *
        q!: * {$comNo * $ticketNumber} *
        q!: * {$lookPast3Ne $ticketNumber} *
        q!: * {$writtenNe * $ticketNumber * [$checkTicket] * [$generalNamedLottery]} *
        q!: * {$forgetPastPres $ticketNumber} *
        q!: * {$buyPastPres * $ticket} * {$forgetPastPres [его/их] $number} *
        q!: * {$payPast * $ticket} * {$forgetPastPres [его/их] $number} *
        q!: * {$writeDownPastNe $ticketNumber} *
        q!: * {$buyPastPres * $ticket} * {$writeDownPastNe [его/их] $number} *
        q!: * {$payPast * $ticket} * {$writeDownPastNe [его/их] $number} *

        q!: * {$knowNe * $ticketNumber} *
        q!: * $comNeed $ticketNumber *
        q!: * {$ticketAll * $knowNe * ((его/их) $number)} *
        q!: * {$ticketAll * ($findOutInf/определить) * ((его/их) $number)} *
        q!: * $ticketAll * {$forgetPastPres [его/их] $number} *
        q!: * {$smsComePastNe (~какой $ticketNumber)} *
        q!: * {[я] $forgetPastPres [$comMy] $ticketNumber} *
        q!: * у меня $ticketAll без $number *

        q!: * {$comWhere * $onTicket * $number} *
        q!: * {$findInf * $onTicket * $number} *
        q!: * {$findOutInf * $onTicket * $number} *
        q!: * {$comNo * $onTicket * $number} *
        q!: * {$writeDownPastNe * $onTicket * $number} *
        q!: * {$writtenNe * $onTicket * $number} *
        q!: * $comWhat [$here/$onTicket] $bePresSg3 $ticketNumber *
        q!: * $ticketNumber $unclear *
        # На билете нет номера тиража и номера билета
        q!: * $comWhat такое {$ticketNumber и $ticketRunNumber} *
        q!: * {$comWhere * $ticketNumber * $ticketRunNumber} *
        q!: * {$comNo * $ticketNumber * $ticketRunNumber} *
        q!: * {($findInf/$findPastPresNe) * $ticketNumber * $ticketRunNumber} *
        q!: * {($findOutInf/определить) * $ticketNumber * $ticketRunNumber} *
        q!: * {$forgetPastPres * $ticketNumber * $ticketRunNumber} *
        q!: * {$writeDownPastNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$knowNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$writtenNe * $ticketNumber * $ticketRunNumber} *
        q!: * {$lookPast3Ne * $ticketNumber * $ticketRunNumber} *

        q!: * $comWhere посмотреть * {$number и $ticketRun} *
        q!: * {($ne ($number/$ticketNumber)) ($ne ($ticketRun/$ticketRunNumber))} *

        q!: * $comWhere * {$number $ticketRun и $ticket} *
        q!: * $comNo * {$number $ticketRun и $ticket} *
        q!: * $lookPast3Ne * {$number $ticketRun и $ticket} *
        q!: * ($findInf/$findPastPresNe) * {$number $ticketRun и $ticket} *
        q!: * ($findOutInf/определить) * {$number $ticketRun и $ticket} *
        q!: * $forgetPastPres * {$number $ticketRun и $ticket} *
        q!: * $writeDownPastNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $writeDownPastNe *
        q!: * $knowNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $knowNe *
        q!: * $writtenNe * {$number $ticketRun и $ticket} *
        q!: * {$number $ticketRun и $ticket} * $writtenNe *
        q!: * {$only серия и ($number $ticketPack)} *
        q!: * ($only/есть) $number $ticketPack *
        q!: * ($number/№/N) $ticketPack $Number серия $Number *
        q!: * (на/в) $ticket [$oneWord] {($number $ticketPack) [и] серия} *
        q!: * серия $ticket (есть/имеет*) $number $comNo *

        eg!: Ticket.ThereAreNoTicketRunNumberAndTicketNumber
        a: Уточните, пожалуйста, Вы приобретали билет в розничных точках продаж или через сайт?

        state: IBoughtInRetailPointOfSale || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber
            q: * $retailPointOfSale *
            q: * на руках *
            q: * терминал* *
            q: * $geography *
            q: * ~купон *
            q!: * $retailPointOfSale * {$comNo [на нем] $ticketRunNumber} *
            q!: * {$comNo [на нем] $ticketRunNumber} * $retailPointOfSale *
            q!: * {(на купон*) * $ticketRunNumber} *
            q!: * {(на купон*) * $ticketRun} *
            q!: * {(на купон*) * $ticketNumber} *
            a: Если Вы приобретали билет в розничных точках продаж и указывали номер телефона, номер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с этим номером телефона на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете. Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.

        state: IBoughtInInternet || fromState = /Ticket/ThereAreNoTicketRunNumberAndTicketNumber
            q: [$website] $account
            q: * (на/через/черес/в/(с/при) ~помощь) [$this/ваш*] ($website/$account/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: * по (~интернет/телефону) *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q: * $here *
            q: * $online *
            q!: * $online * {$findPastPresNe нигде $ticketRun} *
            q!: * {$findPastPresNe нигде $ticketRun} * $online *
            q!: * $online * {$findPastPresNe нигде $ticketRunNumber} *
            q!: * {$findPastPresNe нигде $ticketRunNumber} * $online *
            q!: * $online * {$findPastPresNe нигде $ticketNumber} *
            q!: * {$findPastPresNe нигде $ticketNumber} * $online *
            q!: * {$buyPastPres * [$ticket] * $online} * {$forgetPastPres [его/их] $number} *
            q!: * {$buyPastPres * [$ticket] * $website} * {$forgetPastPres [его/их] $number} *
            q!: * {$buyPastPres * [$ticket] * $online} * $comNeed [его/их] $number *
            q!: * {$buyPastPres * [$ticket] * $website} * $comNeed [его/их] $number *
            q!: * {$buyPastPres * $online * ($writeDownPastNe [его/их] $number)} *
            q!: * {$buyPastPres * $online * ($findOutInf [его/их] $number)} *
            q!: * {$buyPastPres * $website * ($writeDownPastNe [его/их] $number)} *
            q!: * без входа * ($findOutInf/определить) ($ticketNumber/$ticketRun/$ticketRunNumber) *
            q!: * $eTicket * ($writeDownPastNe/$smsComePastPerfNe) (его/их) $number *
            a: Если Вы приобретали билет через сайт, номер тиража и номер билета можно посмотреть в личном кабинете в разделе «Мои билеты». Если Вы приобретали билет через сайт, но у Вас еще нет регистрации, зарегистрируйтесь, пожалуйста, на сайте с номером телефона, указанным при покупке билета. Билет и вся информация о нем отобразятся в личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.


    state: IsItNecessaryToRegisterTicket
        # Как регистрировать бумажный билет и зачем?
        q!: * {$registerInf * $ticketAll} *
        eg!: Ticket.IsItNecessaryToRegisterTicket
        a: Все билеты фиксируются на тираж при покупке. Дополнительно регистрировать билет не требуется.


    state: NoRegistrationTicket
        # Где посмотреть билет, купленный без регистрации?
        q!: * {$buyPastPres * [$ticket] * (без $registration) * [$comWhere]} *
        q!: * {$buyPastPres * [$ticket] * (без $registration) * [$how]} *
        q!: * {$buyPastPres * [$ticket] * (без входа) * [$comWhere]} *
        q!: * {$buyPastPres * [$ticket] * (без входа) * [$how]} *
        q!: * {(куплен*/оплачен*) * (без $registration)} *
        q!: * {(куплен*/оплачен*) * (без входа)} *
        q!: * {$payPast * [$ticket] * (без $registration)} *
        q!: * {$payPast * [$ticket] * (без входа)} *
        q!: * $ticketAll * (без $registration) *

        q!: * {$buyPastPres * $ticketAll * $cantPastPres * $findInf} *
        q!: * {$buyPastPres * $ticketAll * $cantPastPres * посмотреть} *
        q!: * {$buyPastPres * $ticketAll * $online} * понять $comWhere он* *

        q!: * {$buyPastPres * $ticketAll * $comWhere * $findInf} *
        q!: * {$buyPastPres * $ticketAll * $comWhere * посмотреть} *
        q!: * {$payPast * $ticketAll * $comWhere * $findInf} *
        q!: * {$payPast * $ticketAll * $comWhere * посмотреть} *
        q!: * {$buyPastPres * ~пакет * $comWhere * $findInf} *
        q!: * {$buyPastPres * ~пакет * $comWhere * посмотреть} *
        q!: * {$payPast * ~пакет * $comWhere * $findInf} *
        q!: * {$payPast * ~пакет * $comWhere * посмотреть} *
        q!: * {$payPast * $online} * $comWhere $receiveInf $ticket *

        q!: * {$payPast * $ticketAll} * {$comWhere * ~информация * $ticketAll} *
        q!: * {$buyPastPres * $ticketAll} * {$comWhere * ~информация * $ticketAll} *

        q!: * {$buyPastPres * $ticketAll * $how * $findInf} *
        q!: * {$buyPastPres * $ticketAll * $how * посмотреть} *
        q!: * {$payPast * $ticketAll * $how * $findInf} *
        q!: * {$payPast * $ticketAll * $how * посмотреть} *
        q!: * {$buyPastPres * ~пакет * $how * $findInf} *
        q!: * {$buyPastPres * ~пакет * $how * посмотреть} *
        q!: * {$payPast * ~пакет * $how * $findInf} *
        q!: * {$payPast * ~пакет * $how * посмотреть} *
        q!: * {$buyPastPres * $ticketAll * $how * $appendInf} *
        q!: * {$payPast * $ticketAll * $how * $appendInf} *

        q!: * ($how/$comWhere) [я] [мне/$possiblePredic/могу] {$seeInf [$comMy] [$paid] $ticket} *
        q!: * {$how * $seeInf * $website * $ticket} *
        q!: * {$comWhere * $seeInf * $website * $ticket} *
        q!: * {$how * $seeInf * $account * $ticket} *
        q!: * {$comWhere * $seeInf * $account * $ticket} *
        q!: * {$how * $seeInf * интернет* * $ticket} *
        q!: * {$comWhere * $seeInf * интернет* * $ticket} *
        q!: * $comWhere * отображает* * $paid * $ticket *

        q!: * {$findInf [$comMy] $ticket (по $number $telephone)} *

        q!: * {$lostPast * [$comMy] * $ticket} *

        q!: * {$lostPast * $receipt * [$checkTicket] * [$ticket]} *
        q!: * {выбросил* * $receipt * [$checkTicket] * [$ticket]} *
        q!: * {выкинул* * $receipt * [$checkTicket] * [$ticket]} *
        q!: * [$ticket] * {($ne осталос*/неосталос*) $receipt} * [$ticket] *
        q!: * [$ticket] * {$comNo $receipt} * [$ticket] *

        q!: * {$checkInf * ($comNo $receipt) * $ticket} *
        q!: * {$checkInf * ($receipt $comNo) * $ticket} *
        q!: * {$checkInf * (без $receipt) * $ticket} *

        q!: * {$receipt * ($ne дали/недали)} *
        q!: * {$receipt * $forgetPastPres} *
        q!: * $cantPastPres найти $receipt *

        q!: * {$getPrizInf * $prize * ($comNo $receipt)} *
        q!: * {$getPrizInf * $prize * ($receipt $comNo)} *
        q!: * {$cashoutInf * $ticket * ($comNo $receipt)} *
        q!: * {$cashoutInf * $ticket * ($receipt $comNo)} *
        q!: * {~получение * $prize * ($comNo $receipt)} *
        q!: * {~получение * $prize * ($receipt $comNo)} *
        q!: * {~вывод * $prize * ($comNo $receipt)} *
        q!: * {~вывод * $prize * ($receipt $comNo)} *
        q!: * {~обналичивание * $prize * ($comNo $receipt)} *
        q!: * {~обналичивание * $prize * ($receipt $comNo)} *
        q!: * {~выведение * $prize * ($comNo $receipt)} *
        q!: * {~выведение * $prize * ($receipt $comNo)} *
        q!: * {~выдача * $prize * ($comNo $receipt)} *
        q!: * {~выдача * $prize * ($receipt $comNo)} *
        q!: * {$getPrizInf * $prize * (без $receipt)} *
        q!: * {$cashoutInf * $ticket * (без $receipt)} *
        q!: * {~получение * $prize * (без $receipt)} *
        q!: * {~вывод * $prize * (без $receipt)} *
        q!: * {~обналичивание * $prize * (без $receipt)} *
        q!: * {~выведение * $prize * (без $receipt)} *
        q!: * {~выдача * $prize * (без $receipt)} *
        q!: * {$getPrizInf * $prize * [$ticket] * $lostPast * $receipt} *
        q!: * {$cashoutInf * $ticket * $lostPast * $receipt} *
        q!: * {~получение * $prize * $lostPast * $receipt} *
        q!: * {~вывод * $prize * $lostPast * $receipt} *
        q!: * {~обналичивание * $prize * $lostPast * $receipt} *
        q!: * {~выведение * $prize * $lostPast * $receipt} *
        q!: * {~выдача * $prize * $lostPast * $receipt} *
        q!: * {$getPrizInf * $prize * (без $registration)} *
        q!: * {$cashoutInf * $ticket * (без $registration)} *
        q!: * {~получение * $prize * (без $registration)} *
        q!: * {~вывод * $prize * (без $registration)} *
        q!: * {~обналичивание * $prize * (без $registration)} *
        q!: * {~выведение * $prize * (без $registration)} *
        q!: * {~выдача * $prize * (без $registration)} *
        q!: * {$getPrizInf * $prize * $registeredNe} *
        q!: * {$cashoutInf * $ticket * $registeredNe} *
        q!: * {~получение * $prize * $registeredNe} *
        q!: * {~вывод * $prize * $registeredNe} *
        q!: * {~обналичивание * $prize * $registeredNe} *
        q!: * {~выведение * $prize * $registeredNe} *
        q!: * {~выдача * $prize * $registeredNe} *
        q!: * {[$how] $appendInf [$comMy] $ticketAll}
        q!: * $how {загрузить [$comMy] $ticketAll} *
        q!: * {[$me] $comNeed $appendInf [$comMy] $ticketAll}
        q!: * {$want $appendInf [$comMy] $ticketAll}
        q!: * {$appendInf [$comMy] $ticketAll $here} *
        q!: * {$appendInf * куплен* * $ticketAll} *
        q!: * {$appendInf * оплачен* * $ticketAll} *
        q!: * ($appendInf/загрузить) * $ticketAll * ((в/на/через) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) *
        q!: * ($appendInf/загрузить) * ((в/на/через/черес) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) * $ticketAll *
        q!: * $ticketAll * ($appendInf/загрузить) * ((в/на/через/черес) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) *
        q!: * $ticketAll * ((в/на/через/черес) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) * ($appendInf/загрузить) *
        q!: * ((в/на/через/черес) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) * ($appendInf/загрузить) * $ticketAll *
        q!: * ((в/на/через/черес) [$oneWord] ($account/~приложение/мои билеты/~программа)/сюда/сайт) * $ticketAll * ($appendInf/загрузить) *
        q!: * $insertInf их $number * $forTo * (отражалис*/отразилис*/появилис*/отобразилис*/отображалис*) в [$oneWord] ($account/~приложение/мои билеты/~программа) *
        eg!: Ticket.NoRegistrationTicket
        a: Если Вы приобретали билет на сайте без регистрации или в розничных точках продаж с указанием номера телефона, Вы можете зарегистрироваться на сайте с номером телефона, указанным Вами при покупке билета. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в личном кабинете, то напишите нам, пожалуйста.

        state: ProblemNotSolved || fromState = /Ticket/NoRegistrationTicket
            q: * $tryPast *
            q: * $cantPastPres *
            q: * $bonusComePastPresNe *
            q: * $smsComePastPresNe *
            q: * $comNo *
            q: * $receivePastNe *
            q: * $findPastPresNe *
            q: * $helpPastPresNe *
            q: * $problem *
            script: Webim.switch();


    state: UnavailableToBuyTicket
        # Недоступна покупка билетов
        q!: * {выходит оплатите позже} *
        q!: * {[$how] * $cantPastPresAll * $buyInf * [$ticketAndLottery]} *
        q!: * {[$how] * $cantPastPresAll * $payInf * [$ticketAndLottery]} *
        q!: * {$cantPastPresAll * ~ставка} *
        q!: * {$want * $buyInf} * (выкидывает/выбрасывает) *
        q!: * {$want * $payInf} * (выкидывает/выбрасывает) *
        q!: * $no ~возможность ($buyInf/$payInf) *
        q!: * {$button * $buyInf * $activeNe} *
        q!: * {~поле * $buyInf * $activeNe} *
        q!: * {$button * $payInf * $activeNe} *
        q!: * {~поле * $payInf * $activeNe} *
        q!: * {$payment * $activeNe} *
        q!: * {$buyInf * $activeNe} *
        q!: * {$payInf * $activeNe} *
        q!: * {$comNo (~окно ~вариант $payment)} *
        q!: * {$cantPastPres * $buyN} *
        q!: * {$cantPastPres * $payment} *
        q!: * $ne обрабатыв* $buyN *
        q!: * {($ne идет) * $payment} *
        q!: * {неидет * $payment} *
        q!: * {$produceNePresSg3 $payment} *
        q!: * $ticket * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $payment *
        q!: * $ticket * $payment * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $payment * $ticket *
        q!: * $payment * $ticket * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) *
        q!: * $payment * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * $ticket *
        q!: * $payment $comWhat пошло $ne так *
        q!: * {$acceptPresNe * $payment} *
        q!: * {$dismissPastPres * $payment} *
        q!: * {$confirmPres3Ne $payment} *
        q!: * {$workFut * $buyN} *
        q!: * {$workFut * $payment} *
        q!: * {$when * $buyInf} *
        q!: * {$when * $payInf} *
        q!: * {(~пустой ~экран) * $buyInf} *
        q!: * {(~пустой ~экран) * $payInf} *
        q!: * {$payPresNe * $ticketAndLottery} *
        q!: * {$payPresNe * $bet} *
        q!: [$helloAll] {$why $payPresNe}
        q!: * {([так] $slowly) $passPres $buyN} *
        q!: * {([так] $slowly) $passPres $payment} *
        q!: * {[$why] * $buyInfNe * $ticketAndLottery} *
        q!: * {[$why] * $payInfNe * $ticketAndLottery} *
        q!: [$helloAll] {$why $payInfNe}
        q!: * [$comMoney] * [$sendPastPres] * {$buyPresRefl3Ne * $ticket} *
        q!: * {$ticket * $buyPresRefl3 * долго} *
        q!: * $payment [за] $ticketAndLottery $delay *
        q!: * ($payment/$buyN/$buyInf/$payInf) * $error *
        q!: * $error * ($payment/$buyN/$buyInf/$payInf) *
        q!: * {$moneyTakeOffPastPres * $ticket * ($ne оплачен*)} *
        q!: * {$moneyTakeOffPastPres * $ticket * $buyPastRefl3Ne} *
        q!: * {$payPast * $ticket * ($ne оплачен*)} *
        q!: * {$payPast * $ticket * $buyPastRefl3Ne} *
        q!: * {оплач* * $ticket * ($ne оплачен*)} *
        q!: * {оплач* * $ticket * $buyPastRefl3Ne} *
        q!: * {(пыта* $payInf) * $ticket * ($ne оплачен*)} *
        q!: * {(пыта* $payInf) * $ticket * $buyPastRefl3Ne} *
        q!: * {$why * $nelzya * $buyInf} *
        q!: * {$why * $nelzya * $payInf} *
        q!: * недоступност* * платежн* систем* *
        q!: * {$inactive * (платежн* систем*)} *
        q!: * {$workPres3Ne * (платежн* систем*)} *
        q!: * {$workFut * (платежн* систем*)} *
        eg!: Ticket.UnavailableToBuyTicket
        if: $global.byuingTicketIsAvailable
            a: Уточните, пожалуйста, способ оплаты, а также на каком этапе и какая возникает сложность.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.
            #a: Мы уже работаем над возобновлением продажи билетов онлайн. Вы можете приобрести билет в одной из точек продаж лотерейных билетов, указанных на сайте «Столото», в лотерейном центре в Москве или дождаться возобновления продаж онлайн.

        state: GetAnswer
            event: noMatch
            script: Webim.switch();


    state: ICantBuyBingoLotteries
        # Не могу купить Бинго-игры
        q!: * {$cantPastPresAll * $buyInf * [$ticket] * $bingoLotteries} *
        q!: * {$cantPastPresAll * $buyInf * [$lottery] * $bingoLotteries} *
        q!: * {$cantPastPresAll * ~ставка * $bingoLotteries} *
        q!: * {$want * $buyInf * $bingoLotteries} * (выкидывает/выбрасывает) *
        q!: * $no ~возможность $buyInf * $bingoLotteries *
        q!: * {$button * $buyInf * $activeNe * $bingoLotteries} *
        q!: * {~поле * $buyInf * $activeNe * $bingoLotteries} *
        q!: * {$buyInf * $activeNe * $bingoLotteries} *
        q!: * {$cantPastPres * $buyN * $bingoLotteries} *
        q!: * {$workFut * $buyN * $bingoLotteries} *
        q!: * {$when * $buyInf * $bingoLotteries} *
        q!: * {(~пустой ~экран) * $buyInf * $bingoLotteries} *
        q!: * {[$why] * $buyInfNe * [$ticket] * $bingoLotteries} *
        q!: * {[$why] * $buyInfNe * [$lottery] * $bingoLotteries} *
        q!: * {$buyPresRefl3Ne * [$ticket] * $bingoLotteries} *
        q!: * {[$ticket] * $buyPresRefl3 * долго * $bingoLotteries} *
        q!: * ($buyN/$buyInf) * $bingoLotteries * $error *
        q!: * $error * ($buyN/$buyInf) * $bingoLotteries *
        q!: * {$why * $nelzya * $buyInf * $bingoLotteries} *
        q!: * (невозможност*/недоступност*) $buyN * $bingoLotteries *
        q!: * ($ne доступн*/недоступн*) ($buyN/$ticket/$lottery) $bingoLotteries *
        q!: * ($buyN/$ticket/$lottery) $bingoLotteries ($ne доступн*/недоступн*) *
        q!: * недоступност* ($ticket/$lottery) $bingoLotteries *
        eg!: Ticket.ICantBuyBingoLotteries
        if: $global.byuingBingoLotteriesIsAvailable
            script: Webim.switch();
        else:
            a: В системе онлайн-продаж произошло некорректное отображение информации. Мы работаем над возобновлением доступности игр.


    state: IBoughtTwoTimesTheSameTicket
        # Дважды купил один и тот же билет
        q!: * {повторно купилис* $ticketAndBet} *
        q!: * (программа/система) * продублировал* мою $bet *
        q!: * {$mistakenly $buyPastPres} $twoTickets *
        q!: * $ticket * {$buyPastPres дважды} *
        q!: * {$buyPastPres дважды} * $ticket *
        q!: * {$buyPastPres $ticket дважды} *
        q!: * {$buyPastPres ((один/1) [и тот же] $ticket) $twoTimes} *
        q!: * {$buyPastPres (одни и те же $ticket) $twoTimes} *
        q!: * {$buyPastPres (два $ticket) $twoTimes} *
        q!: * {$buyPastPres (одинаков* $ticketAndBet) $twoTimes} *
        q!: * {$buyPastPres ([одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {$buyPastPres * ($Number одинаков* $ticketAndBet)} *
        q!: * {$buyPastPres * ((дв*/три/четыре/пять/нескольк*) одинаков* $ticketAndBet)} *
        q!: * куплено ((од*/1) [и тот же] $ticketAndBet) $twoTimes *
        q!: * $twoTimes $buyPastPres одно и (то же/тоже) *
        q!: * $twoTimes $payPast [за] одно и (то же/тоже) *
        q!: * {$payPast ([за] [один/1] [и тот же] $ticket) $twoTimes} *
        q!: * {$payPast ([за] одни и те же $ticket) $twoTimes} *
        q!: * {$payPast ([за] два $ticket) $twoTimes} *
        q!: * {$payPast ([за] одинаков* $ticketAndBet) $twoTimes} *
        q!: * {$payPast ([за] [одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {набрал* ([за] [одну/1] [и ту же] $bet) $twoTimes} *
        q!: * {$payPast * ($Number одинаков* $ticketAndBet)} *
        q!: * {$payPast * ((дв*/три/четыре/пять/нескольк*) одинаков* $ticketAndBet)} *
        q!: * поставил* * ($Number одинаков* $ticketAndBet) *
        q!: * выбрал* одинаков* $bet *
        q!: * {случайно $buyPastPres $twoTimes} *
        q!: * {случайно $payPast $twoTimes} *
        q!: * случайно ($payPast/$buyPastPres) од* и (ту*/тот*/те*) *
        q!: * $ticket * {оплатилис* $twoTimes} *
        q!: * $ticket * {оплатилс* $twoTimes} *
        q!: * $ticketAndBet был* {$paid $twoTimes} *
        q!: * был* {$paid $twoTimes} $ticketAndBet *
        q!: * {$ticketAndBet $paid $twoTimes} *
        q!: * {$payment проходит $twoTimes} *
        q!: * {$payment прошла $twoTimes} *
        q!: * {$payment произошла $twoTimes} *
        q!: * {~списание произошло $twoTimes} *
        q!: * {$payment * $ticket * прошла * дважды} *
        q!: * {$payment снял* дважды} *
        q!: * {$payment списал* $twoTimes} *
        q!: * {(за [од*/1] $ticketAndBet) списан* ((двойн*/тройн*) $payment)} *
        q!: * {(за [од*/1] $ticketAndBet) списал* ((двойн*/тройн*) $payment)} *
        q!: * {$payment * $ticket * списал* * дважды} *
        q!: * {$buyN $ticket дважды} *
        q!: * {~сумма списал* дважды} *
        q!: * (уберите/убрать) $payment (за/на) повторн* $ticketAndBet *

        q!: * (~списание/снял*/списал*/списывал*) $twoTimes (за/на) ([од*/1] [и т* же] $ticketAndBet) *
        q!: * $twoTimes (~списание/снял*/списал*/списывал*) [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) *
        q!: * (~списание/снял*/списал*/списывал*) [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) $twoTimes *
        q!: * [$comMoney] (за/на) ([од*/1] [и т* же] $ticketAndBet) (снял*/списал*/списывал*) $twoTimes *

        q!: * $twoTimes (снял*/списал*/списывал*) $comMoney *
        q!: * взяли $twoTimes оплату *
        q!: * $comMoney (снял*/списал*/списывал*) $twoTimes *
        q!: * (снял*/списал*/списывал*) $comMoney $twoTimes *
        q!: * {$comMoney [был*] списан* $twoTimes} *
        q!: * {ставка прошла $twoTimes} *
        q!: * {$buyN совершен* дважды} *
        q!: * ~задвоение [одной и той же] $bet *
        q!: * ~задвоение $buyN $ticket *
        q!: * ~задвоение ($payment/$ticket) *
        q!: * {убрать ~задвоение} *
        q!: * (двойн*/тройн*) ~оплата од* и т* же ($ticket/$bet/$buyN/$lottery) *
        q!: * оказал* ($Number/две/три) одинаков* $buyN *
        q!: * ($buyPastPres/$payPast) $Number $ticket $with одинаков* $bet *

        eg!: Ticket.IBoughtTwoTimesTheSameTicket
        a: Удалить купленные на сайте квитанции невозможно. Каждая оплата подтверждается отдельно, все проведенные оплаты соответствуют подтверждениям Вами этих оплат. Если Вы неоднократно подтвердили оплату, то получили несколько раз оформленный билет, только так может возникнуть задвоение.\n\nОбратите, пожалуйста, внимание на следующее. Если в момент покупки билета появляется сообщение об ошибке или рекомендация попробовать позже, при этом квитанции остались неоплаченными и с Кошелька списали деньги, проверьте, пожалуйста, наличие билетов в разделе «Купленные квитанции» позже. Билеты должны будут появиться.\n\nБлагодарим за понимание.​


    state: HowToCancelATicketPurchase
        # Как отменить покупку билета?
        q!: * {отменить * $buyN * $ticket} *
        q!: * {отменить * $buyN * $lottery} *
        q!: * {отменить * продажу * $ticket} *
        q!: * {отменить * продажу * $lottery} *
        q!: * {отменить * $payment * $ticket} *
        q!: * {отменить * $payment * $lottery} *
        q!: * {отменить * $paid * $ticket} *
        q!: * {отменить * $paid * $lottery} *
        q!: * {вернуть * $paid * $ticket} *
        q!: * {вернуть * $paid * $lottery} *
        q!: * {$buyPastPres * $ticket * отменить} *
        q!: * {$buyPastPres * $lottery * отменить} *
        q!: * {$payPast * $ticket * отменить} *
        q!: * {$payPast * $lottery * отменить} *
        q!: * отказат* от $ticket и вернуть $comMoney *
        eg!: Ticket.HowToCancelATicketPurchase
        script: Webim.switch();


    state: FavoriteNumbers
        # Как выбрать любимые числа?
        q!: * {[выбрать/выбирать] * $favoriteNumbers} *
        q!: * набрать св* номера в $bingoLotteries *
        eg!: Ticket.FavoriteNumbers
        a: Билеты Бинго лотерей содержат готовую комбинацию чисел. При покупке данных билетов на сайте есть возможность выбрать любимые числа. В лотереях «Русское лото», «Золотая подкова» и «Жилищная лотерея» есть возможность выбрать до 7 любимых чисел. В лотерее «6 из 36» - до 3-х любимых чисел. Функция «Любимые числа» доступна только на основной версии сайта www.stoloto.ru.


    state: TicketDidntShowupInAccount
        # После оплаты билет не отобразился в ЛК
        q!: * {$error * ~отображение * $ticket} *
        q!: * {$problem * ~отображение * $ticket} *
        q!: * {$comNo [$again] [$comMy] [куплен*/оплачен*/никак*] $ticket (в $account)} *
        q!: * {$comWhere [находит*] [$again] [$comMy] [$Number] [куплен*/оплачен*] [мной/мною] $ticket} *
        q!: * $when * ($ticket/он/они) * отображен* * в [раздел*] (куплен*/оплачен*/приобретен*/$comMy $ticket) *
        q!: * {(в разделе купленны*) * $ticket * ($ne отмечен*)}*
        q!: * {$bonusComePastPresNe (в купленных)} *
        q!: * {$bonusComePastPresNe $buyN (в [$comMy] $ticket)} *
        q!: * $cantPastPresAll просмотреть [$comMy] [$Number] [куплен*/оплачен*] [мной/мною] $ticket *
        q!: * {[$comMy] $ticket $displayPresPl3Ne} *
        q!: * {[куплен*/оплачен*] [$Number] $ticket ($again/до сих [пор]/так и) $comNo} *
        q!: * {(куплен*/оплачен*) [$Number] $ticket отсутств*} *

        q!: * {$payPast * ($ticketAndLottery/~пакет) * [$payment]} * {$receivedNe * $ticketAndLottery} *
        q!: * {$payPast * ($ticketAndLottery/~пакет) * [$payment]} * {$comNo * ($ticketAndLottery/~пакет)} *

        q!: * {$buyN * $ticketAndLottery} * {$comNo * $ticketAndLottery} *
        q!: * {($buyN/транзакц*) * прошла} * {$comNo * $ticketAndLottery} *
        q!: * {($payment/~списание) * (прошл*/прошел/произош*)} * {$comNo * $ticketAndLottery} *
        q!: * {($buyN/транзакц*) * прошла} * {$bonusComePastPresNe * $ticketAndLottery} *
        q!: * {($payment/~списание) * (прошла/прошел/произош*)} * {$bonusComePastPresNe * $ticketAndLottery} *
        q!: * {$payPast * $comMoney} * {$comNo * $ticketAndLottery} *
        q!: * {$payPast * $comMoney} * {$bonusComePastPresNe * $ticketAndLottery} *
        q!: * {$payPast * $ticket} * {$comNo * (его/их/ничего/на сайте)} *
        q!: * {$payPast * $ticket} * {$findPastPresNe * $ticket} *
        q!: * {$payPast * $ticket} * {$findPastPresNe (его/их/ничего/на сайте/у меня [в] $account)} *
        q!: * {$payPast * $ticket} * куда * (делся/делись/деться/дется/девается/деваются) *
        q!: * {$payPast * $ticket} * {$receivePastNe * $ticket} *
        q!: * {$payPast * $ticket} * {$bonusComePastPresNe * ($ticket/он/они) * [$receipt]} *
        q!: * {$payPast * $ticket} * {$receivePastNe * (его/их/ничего) * [$receipt]} *
        q!: * {$findPastPresNe [я] [$comMy] $ticket} *
        q!: * {[так и/все еще] $findPastPresNe $ticket} *

        q!: * {$payPast * $ticketAndLottery} * тишина *
        q!: * {$buyPastPres * $ticketAndLottery} * тишина *
        q!: * {$payPast * $ticket} * отсутств* *
        q!: * {$buyPastPres * $ticket} * отсутств* *
        q!: * {$payPast * $ticket} * {$comWhere ($ticket/он/они)} *
        q!: * {$buyPastPres * $ticket} * {$comWhere ($ticket/он/они)} *

        q!: * {$buyPastPres * ($ticketAndLottery/~пакет) * [$payment]} * {$receivedNe * $ticketAndLottery} *
        q!: * {$buyPastPres * ($ticketAndLottery/~пакет)} * {$comNo * $ticketAndLottery} *
        q!: * {$buyPastPres * $ticket} * {$comNo * (его/их/ничего/на сайте)} *
        q!: * {беру $ticket} * {$comNo * (его/их/ничего/на сайте)} *
        q!: * {$buyPastPres * $ticket} * {$findPastPresNe * $ticket} *
        q!: * {$buyPastPres * $ticket} * {$bonusComePastPresNe * ($ticket/он/они) * [$receipt]} *
        q!: * {$buyPastPres * $ticket} * {$findPastPresNe (его/их/ничего/на сайте/у меня [в] $account)} *
        q!: * {$buyPastPres * $ticket} * куда * (делся/делись/деться/дется/девается/деваются) *
        q!: * {$buyPastPres * $ticket} * {$receivePastNe * $ticket} *
        q!: * {$buyPastPres * $ticket} * {$receivePastNe * (его/их/ничего) * [$receipt]} *

        q!: * {$buyPastPres * ~пакет} * {$findPastPresNe (его/их/ничего/на сайте/у меня [в] $account)} *
        q!: * {$payPast * ~пакет} * {$findPastPresNe (его/их/ничего/на сайте/у меня [в] $account)} *

        q!: * {$payPast * ($Number ($ticket/~пакет))} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*) [$only] ($Number/один) *
        q!: * {$buyPastPres * ($Number ($ticket/~пакет))} * ($bonusComePastPres/$displayPres3/добавил*/отображен*/высветилс*) [$only] ($Number/один) *
        q!: * {$payPast * ($Number ($ticket/~пакет))} * ($findPastPres/$receivePast) [$only] ($Number/один) *
        q!: * {$buyPastPres * ($Number ($ticket/~пакет))} * ($findPastPres/$receivePast) [$only] ($Number/один) *
        q!: * {$payPast * ($Number ($ticket/~пакет))} * в $account $ticket (~ноль/~нуль/0) *
        q!: * {$buyPastPres * ($Number ($ticket/~пакет))} * в $account $ticket (~ноль/~нуль/0) *

        q!: * {$comMoney * $ticket * $bonusDisappearPastPres} * {$bonusComePastPresNe * ($ticket/он/они)} *

        q!: * $payPast * {$ticket [мне] ($ne дали)} *
        q!: * {$ticket [мне] ($ne дали)} * $payPast *

        q!: * {$findPastPresNe $ticket} * ($payPast/$buyPastPres) *
        q!: * ($payPast/$buyPastPres) * {$findPastPresNe $ticket} *

        q!: * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * {$comNo * $ticketAndLottery} *
        q!: * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * {$bonusComePastPresNe * $ticket} *
        q!: * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * {$bonusComePastPresNe * $lottery} *

        q!: * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * {$comNo * $ticketAndLottery} *
        q!: * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * {$bonusComePastPresNe * $ticket} *
        q!: * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * {$bonusComePastPresNe * $lottery} *
        q!: * {$moneyTakeOffPastPres * $numberRub} * {$comNo * $ticketAndLottery} *
        q!: * {$moneyTakeOffPastPres * (за $ticketAndLottery)} * {$comNo * $ticketAndLottery} *

        q!: * {$moneyTakeOffPastPres * $ticket * $givePastPresPl3Ne} *
        q!: * {$moneyTakeOffPastPres * $comMoney} * {$ticket * $receivePastNe} *
        q!: * {$payPast * $ticket * $givePastPresPl3Ne} *
        q!: * {оплач* * $ticket * $givePastPresPl3Ne} *
        q!: * {(пыта* $payInf) * $ticket * $givePastPresPl3Ne} *
        q!: * {$comMoney * взяли} * {$ticket * $givePastPresPl3Ne} *

        q!: * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * {$findPastPresNe * $ticketAndLottery} *
        q!: * {$findPastPresNe * $ticketAndLottery} * {$comMoney [$fromWallet] $bonusDisappearPastPres} *
        q!: * {$comMoney [$fromWallet] $bonusDisappearPastPres} * {$findPastPresNe * $ticketAndLottery} *
        q!: * {$findPastPresNe * $ticketAndLottery} * {$comMoney [$fromWallet] $bonusDisappearPastPres} *
        q!: * {$payPast * ($comWhere [$oneWord] [$comMy] $ticket)} *
        q!: * {$payPast * $ticket} * ($comWhere (он/они)) *
        q!: * {$buyPastPres  * ($comWhere [$oneWord] [$comMy] $ticket)} *
        q!: * {$buyPastPres * $ticket} * ($comWhere (он/они)) *
        q!: * {$comMoney [$fromExternalResource] $bonusDisappearPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *
        q!: * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *
        q!: * {$comMoney [$fromExternalResource] $moneyTakeOffPastPres} * {$bonusComePastPresNe * $ticket} *
        q!: * {$comMoney [$fromWallet] $bonusDisappearPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *
        q!: * {$comMoney [$fromWallet] $moneyTakeOffPastPres} * ($comWhere [$oneWord] [$comMy] $ticket) *
        q!: * {$comMoney [$fromWallet] $moneyTakeOffPastPres} * {$bonusComePastPresNe * $ticket} *
        q!: * {$ticket * $bonusComePastPresNe * (в [$comMy] $account)} *
        q!: * {$cantPastPres * $findInf * $ticket} *
        q!: * $comWhere * $findInf * (куплен*/оплачен*) $ticket *
        q!: * {$findPastPresNe * $ticket * (в [$comMy] $account)} *
        q!: * {$payPast * $ticket * $bonusComePastPresNe} *
        q!: * {$payPast * $ticket * $usingExternalResource * [$comMoney] * $bonusComePastPresNe} *
        q!: * {$payment * $ticket * $usingExternalResource * [$comMoney] * $bonusComePastPresNe} *
        q!: * {$payPast * $ticket * $fromExternalResource * [$comMoney] * $bonusComePastPresNe} *
        q!: * {$payment * $ticket * $fromExternalResource * [$comMoney] * $bonusComePastPresNe} *
        q!: * {$buyN * $ticket * $fromExternalResource * [$comMoney] * $bonusComePastPresNe} *
        q!: * {$buyPastPres * $ticket * $bonusComePastPresNe} *
        q!: * {$payment * $ticket * $bonusComePastPresNe} *
        q!: * {(~возврат сум*) * $ticket * $bonusComePastPresNe} *
        q!: * {$ticket [так и/до сих пор/еще] $bonusComePastPresNe} *
        q!: * $comNo * {(куплен*/оплачен*) [$oneWord] $ticket} *
        q!: * {(куплен*/оплачен*) [$oneWord] $ticket} * $comNo *
        q!: * {$findPastPresNe * ((куплен*/оплачен*) [$oneWord] $ticket)} *
        q!: * {$bonusDisappearPastPres * $ticket} *
        q!: * {($ne $ticket) ($ne [~возврат] $comMoney)} *
        q!: * {($ne $ticket) ($ne $receipt)} *
        q!: * {$returnImp * ($or [$comMy] $comMoney) * ($or [$comMy] $ticket)} *
        q!: * {$giveImp * ($or [$comMy] $comMoney) * ($or [$comMy] $ticket)} *
        q!: * {$returnFutPl23 * ($or [$comMy] $comMoney) * ($or [$comMy] $ticket)} *
        q!: * ($returnImp/$askYou вернуть/$returnFutPl23) [$comMy] $comMoney ($or [$comMy] $ticket) *
        q!: * {$sendMeImp * ($or [$comMy] $comMoney) * ($or [$comMy] $ticket)} *
        q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * ($or [$comMy] $comMoney) * ($or [$comMy] $ticket)} *
        q!: * {$comMoney * $moneyTakeOffPastPres} * {$ticket $comNo} *
        q!: * {$ticket $comNo} * {$comMoney * $moneyTakeOffPastPres} *
        q!: * {$smsComePastNe * $ticket} * {[$sms] * [$smsComePast]} *

        eg!: Ticket.TicketDidntShowupInAccount
        if: $global.ticketInAccountIsAvailable
            script: Webim.switch();
            #a: На момент Вашего обращения были сложности с оплатой билетов на сайте. Сейчас все работает в штатном режиме. Если в течение суток билет не отобразился в Вашем личном кабинете, то в течение 5 рабочих дней средства за незарегистрированные билеты будут возвращены на счет, с которого происходила оплата. Пожалуйста, ожидайте.
        else:
            a: Отображение купленных билетов в личных кабинетах производится с задержкой. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.
            #a: Отображение купленных билетов в личных кабинетах производится с задержкой. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте ваши оплаты после того, как первая попытка не удалась. Наши специалисты уже работают над исправлением ситуации. Приносим извинения за доставленные неудобства.


    state: TheTicketIsRegisteredForALongTime
        # Задержка в регистрации билета
        q!: * идет $registration ваш* $buyN *
        q!: * жду $registration $buyN *
        q!: * {$error * ($registration $ticket)} *
        q!: * {$problem * ($registration $ticket)} *
        q!: * {$why * долго * оформляют* * $ticket} *
        q!: * {$why * долго * оформляют* * $lottery} *
        q!: * висит * $registration * ($ticket/$lottery/~ставка) *
        q!: * долго * $passPres * $registration * ($ticket/$lottery/~ставка) *
        q!: * $registration [$comMy] ($buyN/$ticket/$lottery/ставк*) * длит* более *
        q!: * $comNo $registration [$comMy] ($buyN/ставк*) *
        q!: * {$delay * $registration * $buyN} *
        q!: * {$delay * $registration * $ticket} *
        q!: * {$delay * $registration * $lottery} *
        q!: * {$delay * $registration * ставк*} *
        q!: * {$registerPres3Ne * $buyN} *
        q!: * {$registerPres3Ne * $ticket} *
        q!: * {$registerPres3Ne * ставк*} *
        q!: * {$buyN * $registerPresRefl3 * долго} *
        q!: * {$ticket * $registerPresRefl3 * долго} *
        q!: * {ставк* * $registerPresRefl3 * долго} *
        q!: * {$transferPartPas * $ticket * $registerPast3Ne} *
        q!: * {$moneyTakeOffPastPres * $ticket * $registerPast3Ne} *
        q!: * {$moneyTakeOffPastPres * $ticket * $registeredNe} *
        q!: * {$payPast * $ticket * $registerPast3Ne} *
        q!: * {$payPast * $ticket * $registeredNe} *
        q!: * {оплач* * $ticket * $registerPast3Ne} *
        q!: * {оплач* * $ticket * $registeredNe} *
        q!: * {(пыта* $payInf) * $ticket * $registerPast3Ne} *
        q!: * {(пыта* $payInf) * $ticket * $registeredNe} *
        q!: * ($buyN/транзакц*/$payment) * (прошла/прошел) * $ticket * ($registerPast3Ne/$registeredNe) *
        q!: * ($buyN/транзакц*/$payment) * (прошла/прошел) * ($registerPast3Ne/$registeredNe) * $ticket *
        q!: * (прошла/прошел) * ($buyN/транзакц*/$payment) * $ticket * ($registerPast3Ne/$registeredNe) *
        q!: * (прошла/прошел) * ($buyN/транзакц*/$payment) * ($registerPast3Ne/$registeredNe) * $ticket *
        q!: * ($registerPast3Ne/$registeredNe) * $ticket * ($buyN/транзакц*/$payment) * (прошла/прошел) *
        q!: * ($registerPast3Ne/$registeredNe) * $ticket * (прошла/прошел) * ($buyN/транзакц*/$payment) *
        q!: * $ticket * ($registerPast3Ne/$registeredNe) * ($buyN/транзакц*/$payment) * (прошла/прошел) *
        q!: * $ticket * ($registerPast3Ne/$registeredNe) * (прошла/прошел) * ($buyN/транзакц*/$payment) *
        q!: * $comMoney * $returnPastNe * {$registeredNe * $ticket} *
        q!: * $returnPastNe * $comMoney * {$registeredNe * $ticket} *
        q!: * {$registeredNe $ticket} * возникл* $error *
        q!: * {$registeredNe * $ticket} * $comMoney * $returnPastNe *
        q!: * {$registeredNe * $ticket} * $returnPastNe * $comMoney *
        q!: * {$comNo ($registration $ticket)} *
        q!: * {$cantPastPres * ($registration $ticket)} *
        q!: * $ticket ($ne (прошел/прошли)/непрошел/непрошли/нипрошел/нипрошли) $registration *
        q!: * $ticket $registration ($ne (прошел/прошли)/непрошел/непрошли/нипрошел/нипрошли) *
        eg!: Ticket.TheTicketIsRegisteredForALongTime
        if: $global.ticketRegistrationIsAvailable
            script: Webim.switch();
        else:
            a: На настоящий момент регистрация билетов в личном кабинете производится с задержкой. Ваш платеж может пройти успешно, и билет будет отображен в личном кабинете. Если в процессе регистрации билетов возникли ошибки, то средства за незарегистрированные билеты будут возвращены на счет, с которого происходила оплата. Наши специалисты уже работают над выяснением причины. Приносим извинения за доставленные неудобства.


    state: HowToGiveATicket
        # Как подарить билет
        q!: *дарить другу
        q!: $how *дарить [близким]
        q!: * {$how * *дарить * $ticket * [$buyInf]} *
        q!: * {$how * *дарить * $lottery} *
        q!: * {$want * *дарить * $ticket * [$buyInf]} *
        q!: * {$want * *дарить * $lottery} *
        q!: * {$possiblePredicAll * *дарить * $ticket * [$buyInf]} *
        q!: * {$possiblePredicAll * *дарить * $lottery} *
        q!: * {могу * *дарить * $ticket * [$buyInf]} *
        q!: * {могу * *дарить * $lottery} *
        eg!: Ticket.HowToGiveATicket
        a: Для этого есть два способа.\n\nНа странице лотереи: выберите числа или билет на странице лотереи, нажмите на кнопку «Подарить другу», после чего введите контакты получателя и отправьте подарочный билет.\n\nНа странице билета в мобильном приложении: выберите числа, нажмите на значок подарка, введите номер телефона друга и оплатите билет.\n\nВ разделе «Подари билет»: ссылка на раздел есть в нижней части главной страницы сайта. Подробную видеоинструкцию смотрите по ссылке https://www.youtube.com/watch?v=j6pmrIMTURU . В этом случае Вы можете подарить сразу несколько билетов и приложить к ним открытку.\n\nПожалуйста, проверяйте правильность указанного номера получателя, так как в дальнейшем данный телефонный номер невозможно будет изменить.


    state: HowToGiveAPaidTicket
        # Как подарить оплаченный билет
        q!: * {$how * *дарить * $paid * $ticket} *
        q!: * {$how * *дарить * $paid * $lottery} *
        q!: * {$want * *дарить * $paid * $ticket} *
        q!: * {$want * *дарить * $paid * $lottery} *
        q!: * {$possiblePredicAll * *дарить * $paid * $ticket} *
        q!: * {$possiblePredicAll * *дарить * $paid * $lottery} *
        q!: * {[могу] * *дарить * $paid * $ticket} *
        q!: * {[могу] * *дарить * $paid * $lottery} *
        q!: * (купил*/приобрел*/оплатил*) * ($ticket/$lottery) * *дарить *
        eg!: Ticket.HowToGiveAPaidTicket
        a: К сожалению, подарить уже приобретенный билет не представляется возможным.


    state: HowToDeleteTickets
        # Как удалить билеты?
        q!: * {$deleteInf * $ticket} *
        q!: * {$deleteInf * архив} *
        q!: * (очистить/отчистить) * (($old/$played) $ticket) *
        q!: * (($old/$played) $ticket) * (очистить/отчистить) *
        eg!: Ticket.HowToDeleteTickets
        a: Самостоятельное удаление квитанций невозможно: они автоматически перемещаются в архив по истечении 180 дней с момента проведения тиража.


    state: HowToDeleteTicketsFromBasket
        # Как удалить билеты из корзины
        q!: * {$deleteInf * $ticket * (из $basket)} *
        q!: * {$deleteInf * $ticket * ($with $basket)} *
        eg!: Ticket.HowToDeleteTicketsFromBasket
        script: Webim.switch();


    state: HowToPutATicketInTheBasket
        # Как положить билет в корзину
        q!: * {$putInf * $ticket * (в $basket)} *
        eg!: Ticket.HowToPutATicketInTheBasket
        a: Для того, чтобы положить билеты в Корзину, Вам необходимо выбрать понравившуюся Вам комбинацию в нужной лотерее. Например, в «6 из 45». Далее, справа, на странице формирования билета нажмите на кнопку «В корзину». Готово. Выбранная Вами комбинация теперь в Корзине, ждет оплаты. Если Вы не желаете ограничиваться одной комбинацией, можете повторить процедуру. В Корзину можно добавлять билеты разных лотерей.\n\nОбращаем Ваше внимание, что билеты таких лотерей, как «Золотая подкова», «6 из 36», «Жилищная лотерея», «Бинго-75» и «Русское лото» могут храниться в Корзине не более 24 часов.


    state: HowLongIsTheTicketStoredInTheBasket
        # Сколько времени хранится билет в корзине?
        q!: * {(сколько [по] времени) * $savePres3 * $ticketAndLotteryAll * $basket} *
        q!: * {(сколько [по] времени) * лежать * $ticketAndLotteryAll * $basket} *
        q!: * {(какое время) * $savePres3 * $ticketAndLotteryAll * $basket} *
        q!: * {(какое время) * лежать * $ticketAndLotteryAll * $basket} *
        q!: * {(сколько [часов]) * $savePres3 * $ticket * $basket} *
        q!: * {(сколько часов) * $savePres3 * $lottery * $basket} *
        q!: * {(сколько часов) * $savePres3 * лото * $basket} *
        q!: * {(сколько [часов]) * лежать * $ticket * $basket} *
        q!: * {(сколько часов) * лежать * $lottery * $basket} *
        q!: * {(сколько часов) * лежать * лото * $basket} *
        q!: * {(как долго) * $savePres3 * $ticketAndLotteryAll * $basket} *
        q!: * {(как долго) * лежать * $ticketAndLotteryAll * $basket} *
        q!: * {(долго $li) * $savePres3 * $ticketAndLotteryAll * $basket} *
        q!: * {(долго $li) * лежать * $ticketAndLotteryAll * $basket} *
        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $ticketAndLotteryAll * {$basket * пуст*} *
        q!: * $ticketAndLotteryAll * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * {$basket * пуст*} *
        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $ticketAndLotteryAll * $basket * их {там $comNo} *
        q!: * (ложил*/положил*/отложил*/сохранил*/помещал*/поместил*/собрал*) * $basket * $ticketAndLotteryAll * их {там $comNo} *
        q!: * {$ticketAndLotteryAll * $savePres3ReflNe * $basket} *
        eg!: Ticket.HowLongIsTheTicketStoredInTheBasket
        a: Положить билеты в Корзину могут только зарегистрированные пользователи. Для этого Вам необходимо авторизоваться на сайте Столото. Билеты лотерей с многомиллионными выигрышами хранятся в корзине до момента оплаты (но если Вы положили в корзину билет на спецвыпуск, то оплатить билет нужно до начала этого выпуска), билеты лотерей с ТВ-трансляцией хранятся не более 24 часов.


    #state: HowLongCanIBuyADistributionTicket
        # До какого времени можно купить билет на распределительный тираж
        #q!: * до ~какой (~время/~число/~день) * {$buyInf * ($distributionCirculation/$anniversaryDraw)} *
        #q!: * ($distributionCirculation/$anniversaryDraw) * до ~какой (~время/~число/~день) * $buyInf *
        #q!: * до скольки * {$buyInf * ($distributionCirculation/$anniversaryDraw)} *
        #eg!: Ticket.HowLongCanIBuyADistributionTicket
        #a: Приобрести билеты лотереи «Русское лото» на тираж 1306 Вы можете до 19.10.2019 19:20 мск.


    #state: WhyTheTicketWasIssuedForAnotherEdition
        # Билет РЛ оформился на другой тираж
        #q!: * {$why * $russianLoto * $registered * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registered * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registered * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $registerPres3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPres3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $registerPast3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $registerPast3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформлен* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформлен* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформлен* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформляют* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформляют* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформляют* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * оформил* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * оформил* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * оформил* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * продал* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * продал* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * продал* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * перенесен * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесен * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесен * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * перенесли * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * перенесли * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * перенесли * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * купилс* * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * купилс* * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * купилс* * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~другой $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~другой $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * ($ne на тот $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * ($ne на тот $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~следующий $ticketRun)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (~следующий $ticketRunNumber)} *
        #q!: * {$why * $russianLoto * $buyPresRefl3 * (на 1307 $ticketRun)} *

        #q!: * {$why * $russianLoto * ($ne на $anniversaryDraw)} *
        #q!: * {$why * $ticket * ($ne на $anniversaryDraw)} *
        #q!: * {$why * (в $ticket) * ($ne $anniversaryDraw)} *
        #q!: * {$why * (на $ticket) * ($ne $anniversaryDraw)} *

        #q!: * $buyPastPres * $anniversaryDraw * а [в] $ticket [на] 1307 $ticketRun *
        #q!: * $buyPastPres * $anniversaryDraw * а [в] $ticket [на] $ticketRun 1307 *
        #q!: * {$buyInf * [$ticket] * $anniversaryDraw} *
        #q!: * {$cantPastPresAll * $buyInf * [$ticket] * $anniversaryDraw} *
        #q!: * {$buyInfNe * [$ticket] * $anniversaryDraw} *
        #q!: * {(закрыт* продаж*) * $anniversaryDraw} *
        #q!: * {продают* * $anniversaryDraw} *
        #q!: * {продает* * $anniversaryDraw} *
        #q!: * {$buyInf * [$ticket] * $russianLoto * (20 10)} *
        #eg!: Ticket.WhyTheTicketWasIssuedForAnotherEdition
        #if: $client.testMode || Time.otherTicketRunTimeIsGood()
            #a: Приобрести билеты лотереи «Русское лото» на тираж 1306 можно было до 19.10.2019 19:20 мск. Билеты, приобретенные после закрытия продаж, оформляются на следующий тираж.
        #else:
            #script: Webim.switch();


    #state: HowToBuyANewYearTicket
        # Как купить билет на новогодний тираж?
        #q!: * {[$possiblePredicAll] * $buyInf * [$ticket] * $newYear} *
        #q!: * {[$possiblePredicAll] * $buyInf * [$ticket] * 1316} *
        #q!: * {[$possiblePredicAll] * $payInf * [$ticket] * $newYear} *
        #q!: * {[$possiblePredicAll] * $payInf * [$ticket] * 1316} *

        #q!: * {[$possiblePredicAll] * $buyInf * [$lottery] * $newYear} *
        #q!: * {[$possiblePredicAll] * $buyInf * [$lottery] * 1316} *
        #q!: * {[$possiblePredicAll] * $payInf * [$lottery] * $newYear} *
        #q!: * {[$possiblePredicAll] * $payInf * [$lottery] * 1316} *

        #q!: * {[$possiblePredicAll] * $buyInf * [лото] * $newYear} *
        #q!: * {[$possiblePredicAll] * $buyInf * [лото] * 1316} *
        #q!: * {[$possiblePredicAll] * $payInf * [лото] * $newYear} *
        #q!: * {[$possiblePredicAll] * $payInf * [лото] * 1316} *
        #eg!: Ticket.HowToBuyANewYearTicket
        #a: Продажи на новогодний тираж лотереи «Русское лото» уже закрыты.


    #state: HowLongCanIBuyANewYearTicket
        # До какого времени можно купить билет на новогодний тираж 1316 Русского лото
        #q!: * {$whatTime * $buyInf * [$ticket] * $newYear} *
        #q!: * {$whatTime * $payInf * [$ticket] * $newYear} *
        #q!: * {$whatTime * $buyInf * [$ticket] * 1316} *
        #q!: * {$whatTime * $payInf * [$ticket] * 1316} *
        #q!: * {$whatTime * $buyInf * [$lottery] * $newYear} *
        #q!: * {$whatTime * $payInf * [$lottery] * $newYear} *
        #q!: * {$whatTime * $buyInf * [$lottery] * 1316} *
        #q!: * {$whatTime * $payInf * [$lottery] * 1316} *
        #q!: * {$whatTime * $buyInf * [лото] * $newYear} *
        #q!: * {$whatTime * $payInf * [лото] * $newYear} *
        #q!: * {$whatTime * $buyInf * [лото] * 1316} *
        #q!: * {$whatTime * $payInf * [лото] * 1316} *
        #q!: * {$whatTime * продают* * $newYear} *
        #q!: * {$whatTime * продают* * 1316} *
        #q!: * {$whatTime * продает* * $newYear} *
        #q!: * {$whatTime * продает* * 1316} *
        #q!: * {$whatTime * продават* * $newYear} *
        #q!: * {$whatTime * продават* * 1316} *
        #q!: * {*канчивает* * ~продажа * $newYear} *
        #q!: * {*канчивают* * ~продажа * $newYear} *
        #q!: * {завершает* * ~продажа * $newYear} *
        #q!: * {завершают* * ~продажа * $newYear} *
        #q!: * {завершите * ~продажа * $newYear} *
        #q!: * {завершат* * ~продажа * $newYear} *
        #q!: * {закрывает* * ~продажа * $newYear} *
        #q!: * {закрывают* * ~продажа * $newYear} *
        #q!: * {закроете * ~продажа * $newYear} *
        #q!: * {закроют * ~продажа * $newYear} *
        #q!: * {~окончание * ~продажа * $newYear} *
        #q!: * {~завершение * ~продажа * $newYear} *
        #q!: * {~закрытие * ~продажа * $newYear} *
        #eg!: Ticket.HowLongCanIBuyANewYearTicket
        #a: Билеты на новогодний тираж 1316 «Русского лото» без указания номера телефона возможно будет приобрести до 21:00 31.12.2019. Билеты с указание номера телефона возможно будет купить до 11:00 01.01.2020.


    #state: WhereToBuyChristmasGiftSets
        # Где купить подарочные новогодние наборы РЛ?
        #q!: * {$buyInf * [подарочн*] * ~набор * $newYear * (рус* лото)} *
        #q!: * {$buyInf * [подарочн*] * ~набор * $newYear * рл} *
        #q!: * {$payInf * [подарочн*] * ~набор * $newYear * (рус* лото)} *
        #q!: * {$payInf * [подарочн*] * ~набор * $newYear * рл} *
        #q!: * {$buyInf * [подарочн*] * ~набор * $newYear * 1316} *
        #q!: * {$payInf * [подарочн*] * ~набор * $newYear * 1316} *
        #eg!: Ticket.WhereToBuyChristmasGiftSets
        #a: Новогодние подарочные наборы лотереи «Русское лото» можно приобрести в розничных пунктах продаж «Столото», отделениях «Почты России».




















