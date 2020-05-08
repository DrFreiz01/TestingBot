theme: /Bonuses

    state: WhatAreBonuses
        # Что такое бонусы
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $bonus [$ne] [*скаж*/науч*]
        q!: * {$howMuch * $bonus} *
        q!: * {~функция $bonus} *
        q!: * {$findOutInf [$oneWord] (о/про/по поводу) $bonus} *
        q!: * {~информация (о/про/по [поводу]) $bonus} *
        q!: * $comWhat $oneWord $bonus *
        q!: * $whatFor $oneWord $bonus *
        q!: * (~какой ~цель) [$oneWord] $bonus *
        q!: $bonus $whatFor (она/они) $comNeed *
        q!: $bonus {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $bonus}
        q!: * {($comWhere/$how) * ($receiveInf/$earnInf) * $bonus} *
        q!: * {$how * $saveUp * $bonus} *
        q!: * {$how * $useInf * $bonus} *
        q!: * {$how * $buyInf * $bonus} *
        q!: * {$how (начисляю*/начисляе*) $bonus} *
        q!: * {$how пополнить $bonus} *
        q!: * {($comWhere/$how) * $checkInf * $bonus} *
        q!: * инф* по моим $bonus *
        eg!: Bonuses.WhatAreBonuses
        a: Бонус - это виртуальное вознаграждение, которое Вы получаете за каждый купленный билет, приглашение друзей, участие в бонусных играх и акциях. Количество бонусов, которые начисляются за покупку, указано на игровом поле под кнопкой оплаты. Сумма уже заработанных бонусов отображена рядом с балансом Вашего Кошелька. Учитываются билеты, купленные на основной и мобильной версии сайта, в мобильных приложениях «Столото» и по СМС. Не учитываются билеты, оплаченные специальными бонусами и бонусами. При покупке билетов в розничных точках продаж бонусные баллы не начисляются. ​Бонусы можно потратить на покупку лотерейных билетов, товаров из каталога подарков «Столото» и участие в бонусных играх. Подробнее о бонусах - в разделе «Бонусы» в личном кабинете. Для просмотра авторизуйтесь или зарегистрируйтесь на stoloto.ru.


    state: WhatIsTheBonusValue
        # Чему равен бонус
        q!: * (чему/скольк*) * (равен/равняетс*/равняетьс*) * $bonus *
        q!: * ~номинал [у] $bonus *
        q!: * $bonus (равен/равняетс*/равняетьс*) [$oneWord] $rub *
        q!: * скольк* {$rub (в [$oneWord] $bonus)} *
        q!: * $Number $bonus это скольк* *
        eg!: Bonuses.WhatIsTheBonusValue
        a: За каждые 33 рубля вы получите 1 бонус. Подробная информация содержится в правилах бонусной программы (раздел «Бонусы» личного кабинета), а также в новостях на сайте.


    state: HowToAddBonusesToPurse
        # Как добавить бонусы в кошелек
        q!: * {$transferInfImp * $bonus * $toWallet} *
        q!: * {$sendInf * $bonus * $toWallet} *
        q!: * {$appendInf * $bonus * $toWallet} *
        q!: * {$putInf * $bonus * $toWallet} *
        q!: * {$transferInfImp * $bonus * (в ($comMoney/рубли))} *
        q!: * {преобразовать * $bonus * (в ($comMoney/рубли))} *
        q!: * {$exchangeInf * $bonus * (на ($comMoney/рубли))} *
        eg!: Bonuses.HowToAddBonusesToPurse
        a: Перевести бонусные баллы в Кошелек или преобразовать в рубли технически невозможно.\n\nБонусная программа - это система поощрения, подразумевающая под собой накопление определенного количества бонусных баллов за покупки на сайте «Столото», а также возможность использования этих баллов для приобретения лотерейных билетов, подарков и участия в бонусных играх.\n\nБонусы начисляются всем зарегистрированным пользователям сайта.\n\nБонусные баллы начисляются за покупку лотерейных билетов, а также некоторые другие действия на сайте stoloto.ru, мобильной версии сайта, в мобильном приложении или по SMS​. При покупке билетов в розничных точках продаж бонусные баллы не начисляются.\n\nПодробная информация содержится в правилах бонусной программы (раздел «Бонусы» личного кабинета), а также в новостях на сайте.


    state: WhatCanIBuyForBonuses
        # Что можно купить за бонусы
        q!: * {$comWhat * $buyInf * ((на/за) [$Number] $bonus)} *
        q!: * {$comWhat * $spendInf * $bonus} *
        q!: * {$how * $spendInf * $bonus} *
        q!: * куда * {$spendInf * $bonus} *
        q!: * {$payInf * $bonus} *
        q!: * $comWhat * (делать/сделать) * ($with $bonus) *
        q!: * у меня $Number $bonus $comWhat $with ними делать *
        q: * смысл их (накапливать/копить/собирать) * || fromState = /Bonuses/WhereAreMyBonuses
        q: * смысл их (накапливать/копить/собирать) * || fromState = /Bonuses/WhatAreBonuses
        eg!: Bonuses.WhatCanIBuyForBonuses
        a: Вы можете потратить бонусы на бесплатное оформление билетов на stoloto.ru: у каждой лотереи есть номинал в бонусах. Другие варианты: бонусные игры, где можно весело провести время и выиграть до 5 000 бонусов. Срок действия бонусов: 6 месяцев со дня начисления. В некоторых акциях этот срок меньше. Внимательно читайте условия акции.


    state: HowToBuyATicketForBonuses
        # Как купить билет с помощью бонусов
        q!: * {[$how] * $buyInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $buyInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$how] * $payInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $payInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$how] * $spendInf * $ticketAndLotteryAll * $bonus} *
        q!: * {[$possiblePredicAll] * $spendInf * $ticketAndLotteryAll * $bonus} *
        q!: * {$buyN * $ticket * $bonus} *
        q!: * {~оплата * $ticket * $bonus} *
        q!: * {$exchangeInf * $ticket * $bonus} *
        q!: * {$comWhere * $payInf * $bonus} *
        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatCanIBuyForBonuses
        q: * {$exchangeInf * (на [$oneWord] $ticket)} * || fromState = /Bonuses/WhatAreBonuses

        eg!: Bonuses.HowToBuyATicketForBonuses
        a: Приобрести билеты лотерей за бонусы Вы можете на сайте stoloto.ru. Для оплаты билета бонусами Вам необходимо нажать на кнопку «Все способы оплаты», далее выбрать способ оплаты «Бонусы».\n\nОбратите внимание, что при покупке билета соотношение одного бонуса к номинальному значению в рублях разнится в зависимости от лотереи (подробная информация содержится в правилах бонусной программы в разделе «Бонусы» личного кабинета).\n\nВажно! За билеты, оплаченные бонусами или подарочными кодами, бонусы не начисляются. Срок действия бонусов: 6 месяцев со дня начисления. По окончании этого срока бонусы сгорают и не могут быть использованы.\n\nБолее подробно ознакомиться с условиями Бонусной программы Вы можете по ссылке http://www.stoloto.ru/bonus?bls=bonus&service=bonus


    state: HowToBuyATicketForSpasibo
        # Как купить билет за бонус Спасибо от Сбербанка
        q!: * {активировать * $ticket * $spasibo} *
        q!: * {[$how] * $buyInf * $ticketAndBet * $spasibo} *
        q!: * {[$how] * $buyInf * $lottery * $spasibo} *
        q!: * {[$how] * $buyInf * лото * $spasibo} *
        q!: * {[$possiblePredicAll] * $buyInf * $ticketAndBet * $spasibo} *
        q!: * {[$possiblePredicAll] * $buyInf * $lottery * $spasibo} *
        q!: * {[$possiblePredicAll] * $buyInf * лото * $spasibo} *
        q!: * {[$how] * $payInf * $ticketAndBet * $spasibo} *
        q!: * {[$how] * $payInf * $lottery * $spasibo} *
        q!: * {[$how] * $payInf * [лото] * $spasibo} *
        q!: * $payInf ~купон спасибо *
        q!: * {[$possiblePredicAll] * $payInf * $ticketAndBet * $spasibo} *
        q!: * {[$possiblePredicAll] * $payInf * $lottery * $spasibo} *
        q!: * {[$possiblePredicAll] * $payInf * лото * $spasibo} *
        q!: * {[$how] * $spendInf * $ticketAndBet * $spasibo} *
        q!: * {[$how] * $spendInf * $lottery * $spasibo} *
        q!: * {[$how] * $spendInf * лото * $spasibo} *
        q!: * {[$possiblePredicAll] * $spendInf * $ticketAndBet * $spasibo} *
        q!: * {[$possiblePredicAll] * $spendInf * $lottery * $spasibo} *
        q!: * {[$possiblePredicAll] * $spendInf * лото * $spasibo} *
        q!: * {$buyN * $ticketAndBet * $spasibo} *
        q!: * {~оплата * $ticketAndBet * $spasibo} *
        q!: * {$buyN * $useInf * $spasibo} *
        q!: * {~оплата * $useInf * $spasibo} *
        q!: [$helloAll] $how {$useInf спасибо}
        q!: * {$exchangeInf * $ticket * $spasibo} *
        q!: * {$exchangeInf * [~купон] * $spasibo} *
        q!: * {$comWhere * $payInf * $spasibo} *
        q!: * {$how * получить * $ticket * $spasibo} *
        q!: * {$how * получить * $lottery * $spasibo} *
        q!: * {$how * получить * лото * $spasibo} *
        q!: * {применить * $spasibo} *
        q!: * ($buyPastPres/есть) * $spasibo * (оформить/активировать/$useInf/ввести) *
        q!: * (оформить/активировать/$useInf/ввести/вести) * $buyPastPres * $spasibo *
        q!: * {$buyInf * $specialBonus * $spasibo} *
        q!: * {$payInf * $specialBonus * $spasibo} *
        q!: * {ввести * $specialBonus * $spasibo} *
        q!: * {вводить * $specialBonus * $spasibo} *
        q!: * {$buyN * $specialBonus * $spasibo} *
        q!: * {~оплата * $specialBonus * $spasibo} *
        q!: * {$spendInf * $specialBonus * $spasibo} *
        q!: * {$useInf * $specialBonus * $spasibo} *
        q!: * $comWhat * (делать/сделать) * ($with $specialBonus) * $spasibo *
        q!: * ~оплата [$ticket] $specialBonus * $spasibo *
        q!: * {$inactive * (~способ оплаты) * $specialBonus * $spasibo} *
        q!: * {($comNo такого способа оплаты) * $spasibo} *
        q!: * {$how * $useInf * $spasibo} *
        q!: * {$how * $useInf * (промокод*/промо ~код)} *
        q!: * обменял* * $spasibo * вводить *
        q!: * получил* (промокод*/промо ~код) * $spasibo * что [д*] дальше *
        q!: * $buyPastPres (промокод*/промо ~код) [в/от/у] (сбербанк*/сбер банк*/сбера/сбере) *
        eg!: Bonuses.HowToBuyATicketForSpasibo
        a: В рамках Акции клиенты «Спасибо» могут приобрести на площадке «Спасибо» промокод на покупку лотерейных билетов. Промокод - это наш специальный бонус, который необходимо активировать на нашем сайте/мобильной версии/мобильном приложении.\n\nЧтобы оплатить билет специальным бонусом, сформируйте, пожалуйста, комбинацию или выберите билет на официальной странице сайта «Столото» (www.stoloto.ru). Номинал билета не должен превышать сумму специального бонуса. Далее необходимо нажать на кнопку «Все способы».\n\nПосле этого Вы перейдете к списку ресурсов оплаты. Выберите, пожалуйста, из списка «Специальный бонус». Далее Вам нужно ввести специальный бонус и нажать кнопку «Добавить». Инструкцию для оплаты кодом Вы можете посмотреть по ссылке https://www.stoloto.ru/private/infospecbonus


    state: HowToActivateSpasibo
        # Как активировать бонус Спасибо?
        q!: * {активировать * $spasibo} *
        q!: * {активировать * (~купон спасибо)} *
        q!: * {активировать * ~купон * сбербанк*} *
        q!: * {активировать * ~купон * (сбер банк*)} *
        q!: * {(~неправильный код активации) * $spasibo} *
        q!: * {ввести * промокод* * $spasibo} *
        q!: * {ввести * ([промо] ~код) * $spasibo} *
        q!: * {ввести * ~купон * $spasibo} *
        q!: * {вводить * промокод* * $spasibo} *
        q!: * {вводить * ([промо] ~код) * $spasibo} *
        q!: * {вставить * промокод* * $spasibo} *
        q!: * {вставить * ([промо] ~код) * $spasibo} *
        q!: * {вводить * $number * $spasibo} *
        q!: * {вводить * ~купон * $spasibo} *
        q!: * {вставить * $number * $spasibo} *
        q!: * {вставить * ~купон * $spasibo} *
        q!: * (ввести/вводить/вставить) (промокод*/[промо] ~код) спасибо *
        q!: * (ввести/вести/вводить/вставить) * (промокод*/промо ~код) * [$ticketAndBet] *
        q!: * (промокод*/промо ~код) * (ввести/вести/вводить/вставить) *
        eg!: Bonuses.HowToActivateSpasibo
        a: Откройте, пожалуйста, вкладку «Специальный бонус» в личном кабинете на нашем сайте https://www.stoloto.ru/\n\nВведите специальный бонус из письма в поле «Добавить новый». Введите код проверки с картинки и нажмите «Добавить».


    state: IDidntGetBonuses
        # Где мои бонусы?
        q!: * {$comWhere [$comMy/~заработанный/обещан*/акцион*] [$Number] $bonus} *
        q!: * {$comWhere * $ticket * $bonus} *
        q!: * {$bonus * $bonusComePastPresNe} *
        q!: * {[$buyPastPres] * $ticket * $bonus * $bonusComePastPresNe} *
        q!: * {($ne получил*/неполучил*/ниполучил*) [$comMy/~заработанный/обещан*/акцион*] [$Number] $bonus} *
        q!: * {$ticket * ($ne получил*/неполучил*/ниполучил*) * $bonus} *
        q!: * {$bonus $comNo} *
        q!: * {$ticket * [$buyPastPres] * $bonus * $comNo} *
        q!: * {$when * $bonusComeFut * $bonus} *
        q!: * ($when/$howMuch) * {$waitInf [$comMy/~заработанный/обещан*/акцион*/подарочн*] [$Number] $bonus} *
        q!: * {$bonus $bonusDoesntRise} *
        q!: * {обещал* * ([$Number] $bonus) * ($comWhere/$when)} *
        q!: * {должны * $moneyAddInf * $bonus} * $comWhere * (они/$bonus) *
        q!: * {$winPastPerf * ([$Number] $bonus) * ($comWhere/$when)} *
        eg!: Bonuses.IDidntGetBonuses
        a: Если бонусы не начислились, уточните, пожалуйста, регистрационные данные, название лотереи, способ оплаты, дату и время покупки билета.

        state: GetInformation || fromState = /Bonuses/IDidntGetBonuses
            q: * {[$localMobilePhoneNumber] * [$localEmail]} *
            script: Webim.switch();


    state: WhereAreMyBonuses
        # Куда делись бонусы?
        q!: * {$bonus * $bonusDisappearPastPres} *
        q!: * {$bonus * воруют*} *
        q!: * был* накоплен* * $bonus * (сегодня/сейчас) *
        q!: * {(неизвестно куда) * $moneyTakeOffPastPres * $bonus} *
        q!: * $why * ($moneyTakeOffPastPres/тратятся/тратяться) $bonus *
        q!: * было [более] $Number [накопл*] $bonus * (сегодня/сейчас) [показывает] [только] $Number *
        q!: * было $bonus более $Number * (сегодня/сейчас) [показывает] [только] $Number *
        q!: * $bonus было * $Number * [вдруг] * стало $Number *
        q!: * было * $Number [накопл*] $bonus * [вдруг] * стало $Number * [$why] *
        q!: * $bonus было * $Number * в остатке $Number *
        q!: * было * $Number $bonus * в остатке $Number *
        q!: * {связано * уменьшение * $bonus} *
        q!: * {$bonus могут исчезать} *
        eg!: Bonuses.WhereAreMyBonuses
        a: Бонусные баллы имеют срок действия 6 месяцев и сгорают по истечении этого времени. Данная информация указана в правилах Бонусной программы. В разделе «Бонусы» во вкладке «История транзакций» Бонусной программы можно посмотреть, когда накопленные баллы сгорят.


    state: ICantToUseBonuses
        # Не могу воспользоваться бонусами
        q!: * {$cantPastPres * $useInf * $bonus} *
        q!: * {$cantPastPres * $spendInf * $bonus} *
        q!: * {$cantPastPres * сделать * $bonus} *
        q!: * {$cantPastPres * делать * $bonus} *

        q!: * {$cantPastPres * $buyInf * [$ticket] * $bonus} *
        q!: * {$cantPastPres * $payInf * [$ticket] * $bonus} *
        q!: * {$cantPastPres * $exchangeInf * $bonus} *
        q!: * {$cantPastPres * $buyN * $bonus} *
        q!: * {$cantPastPres * $payment * $bonus} *

        q!: * {$why * $nelzya * $buyInf * $bonus} *
        q!: * {$why * $nelzya * $payInf * $bonus} *

        q!: * {$when * $buyInf * $bonus} *
        q!: * {$when * $payInf * $bonus} *

        q!: * {$payPresNe * [$ticketAndLottery] * $bonus} *

        q!: * {$buyInfNe * [$ticket] * $bonus} *
        q!: * {$payInfNe * [$ticket] * $bonus} *

        q!: * {$workPres3Ne $bonus} *
        q!: * {$acceptPresNe * $bonus} *
        q!: * {$comNo * ($payment $bonus)} *
        q!: * {$registerPres3Ne * $buyN * $bonus} *

        q!: * {$payment * $bonus * $error} *
        q!: * {$buyN * $bonus * $error} *
        q!: * {$buyInf * $bonus * $error} *
        q!: * {$payInf * $bonus * $error} *
        eg!: Bonuses.ICantToUseBonuses
        script: Webim.switch();


    state: ToUseBonusesAndMoneyToPay
        # Как я могу бонусы прибавить к деньгам в кошельке, чтобы купить билет?
        q!: * {$addInf * $bonus * $comMoney * [$ticket]} *
        q!: * {$addInf * $bonus * ~рубль * [$ticket]} *
        # Могу ли я оплатить часть стоимости билета бонусами?
        q!: * {$payInf * $partOfCost * $bonus * [$ticket]} *
        q!: * {вносить * $partOfCost * $bonus * [$ticket]} *
        q!: * {внести * $partOfCost * $bonus * [$ticket]} *
        q!: * {$bonus * (~оплата $partOfCost) * [$ticket]} *
        q!: * $bonus доплатить за $ticket *
        q!: * {$payInf * [$ticketAndLotteryAll] * ($fromWallet и $bonus)} *
        q!: * {$payInf * [$ticketAndLotteryAll] * ($bonus и $fromWallet)} *
        eg!: Bonuses.ToUseBonusesAndMoneyToPay
        a: Оплатить бонусами часть стоимости билета нельзя.

    #########################Бонусный баланс#################################

    state: IncorrectBonusBalance
        # Некорректный бонусный баланс
        q!: * {$wrong ~отображение [$sum] $bonus} *
        q!: * {$wrong [$sum] $bonus $balance} *
        q!: * {$wrong [~отображение] (бонусн* $balance)} *
        q!: * {~отображение * $bonus * $balance * $incorrectly} *
        q!: * {[$balance] * $bonus * $displayPres3 * $incorrectly} *
        q!: * {(бонусн* $balance) * $displayPres3 * $incorrectly} *
        q!: * {$balance * $bonus * отображен * $incorrectly} *
        q!: * {(бонусн* $balance) * отображен * $incorrectly} *
        q!: * {$incorrectly * $bonus * отображены} *
        q!: * {[~счет] * $displayPres3 * ($ne все [$sum] $bonus)} *
        q!: * {[$balance] * $displayPres3 * ($ne все [$sum] $bonus)} *
        eg!: Bonuses.IncorrectBonusBalance
        if: ($session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1')
            if: $global.bonusBalanceIsCorrect
                script: Webim.switch();
            else:
                a: В данный момент мы обновляем информацию на сайте. Вы сможете посмотреть свой баланс в кратчайшие сроки.
        else:
            if: $global.mobileBonusBalanceIsCorrect
                script: Webim.switch();
            else:
                a: По техническим причинам баланс бонусов в мобильном приложении отображается некорректно. Мы работаем над восстановлением корректного отображения. Информация обновится в ближайшее время.


    state: IncorrectMobileBonusBalance
        # Некорректный бонусный баланс в мобильном приложении
        q!: * $application * {$wrong ~отображение [$sum] $bonus} *
        q!: * {$wrong ~отображение [$sum] $bonus} * $application *
        q!: * $application * {$wrong [$sum] $bonus $balance} *
        q!: * {$wrong [$sum] $bonus $balance} * $application *
        q!: * $application * {$wrong [~отображение] (бонусн* $balance)} *
        q!: * {$wrong [~отображение] (бонусн* $balance)} * $application *
        q!: * {~отображение * $bonus * [$balance] * $incorrectly * $application} *
        q!: * {[$balance] * $bonus * $displayPres3 * $incorrectly * $application} *
        q!: * {(бонусн* $balance) * $displayPres3 * $incorrectly * $application} *
        q!: * {$balance * $bonus * отображен * $incorrectly * $application} *
        q!: * {(бонусн* $balance) * отображен * $incorrectly * $application} *
        q!: * {$incorrectly * $bonus * отображены * $application} *
        q!: * {[~счет] * $displayPres3 * ($ne все $bonus) * $application} *
        q!: * {[$balance] * $displayPres3 * ($ne все $bonus) * $application} *
        eg!: Bonuses.IncorrectMobileBonusBalance
        if: $global.mobileBonusBalanceIsCorrect
            script: Webim.switch();
        else:
            a: По техническим причинам баланс бонусов в мобильном приложении отображается некорректно. Мы работаем над восстановлением корректного отображения. Информация обновится в ближайшее время.


    ##########################Бонусные игры###################################


    state: WhatIsBonusPlay
        # Что такое бонусные игры
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $bonusPlay [$ne] [*скаж*/науч*]
        q!: * $comWhat $oneWord $bonusPlay *
        q!: * $whatFor [$oneWord] $bonusPlay *
        q!: * (~какой ~цель) [$oneWord] $bonusPlay *
        q!: $bonusPlay $whatFor (она/они) $comNeed *
        q!: $bonusPlay {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $bonusPlay}
        q!: * в чем суть $bonusPlay *
        q!: * {~информация (о/про/по [поводу]) $bonusPlay} *
        q!: * $comWhat ($possiblePredic/$possibly) ($getPrizInf/$winInf) ($with/в) $bonusPlay *
        eg!: Bonuses.WhatIsBonusPlay
        a: Бонусная игра нужна для того, чтобы у Вас была возможность увеличивать Ваши бонусы. Для того чтобы сделать ход, купите билет на паровозик, который едет по доске, после этого Вы получаете возможность сыграть в бонусную игру. Основной смысл игры - увеличить количество Ваших бонусов.


    state: HowToPlayBonusPlay
        # Как играть в бонусные игры
        q!: * $playInf ((на/за) [$comMy] [$Number] $bonus/забонус*/набонус*) *
        q!: * {$how * $playInf * $bonusPlay} *
        q!: * {$how * $playInf * (полет фортуны)} *
        # Как использовать бонусы в бонусных играх
        q!: * {$how * $useInf * $bonus * $bonusPlay} *
        eg!: Bonuses.HowToPlayBonusPlay
        script: Webim.switch();


    state: BonusPlayDoesntWork
        # Не работает бонусная игра
        q!: * {$bonusPlay * $inactive} *
        q!: * {($bonusPlay/игры) $openPres3Ne} *
        q!: * {$cantPastPres * ($playInf/запустить/загрузить/$buyInf/$useInf) * $bonusPlay} *
        q!: * {([на/за] [$comMy] [$Number] $bonus) * $cantPastPres * $playInf} *
        q!: * {$when * $bonusComeFut * $bonusPlay} *
        q!: * $bonus * $bonusDisappearPastPres * игра * ($ne (начин*/начал*)/неначин*/неначал*) *
        eg!: Bonuses.BonusPlayDoesntWork
        script: Webim.switch();


    state: WhatAreChipsInBonusPlaysFor
        q!: * ($whatFor/$comWhat) $oneWord $chips *
        q!: * {$whatFor * $chips * $bonusPlay} *
        q!: * $comWhat (делать/сделать) $with $chips *
        q!: * $chips ($whatFor/$comWhat $with) *
        q!: * {$chips * ($whatFor они дают)} *
        q!: * {$useInf * $chips} *
        q!: * {(~какой ~функция) * $chips} *
        eg!: Bonuses.WhatAreChipsInBonusPlaysFor
        a: Фишки используются в бонусных играх, чтобы делать ход. Смысловой нагрузки данные фигуры не несут: они заменяют стандартную фигуру в виде паровозика.

    ##########################Спецбонусы###################################

    state: WhatAreSpecialBonuses
        # Что такое спецбонусы
        # Где взять спецбонусы
        q!: [$ne] [*скаж*/науч*] [о/про/по [поводу]] $specialBonus [$ne] [*скаж*/науч*]
        q!: * {~функция $specialBonus} *
        q!: * {$findOutInf $oneWord (о/про/по поводу) $specialBonus} *
        q!: * {~информация (о/про/по [поводу]) $specialBonus} *
        q!: * $comWhat $oneWord $specialBonus *
        q!: * $whatFor $oneWord $specialBonus *
        q!: * (~какой ~цель) [$oneWord] $specialBonus *
        q!: $specialBonus $whatFor (она/они) $comNeed *
        q!: $specialBonus {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $specialBonus}
        q!: * {$how (начисляю*/начисляе*) $specialBonus} *
        q!: * {($comWhere/$how) * ($receiveInf/$earnInf) * $specialBonus} *
        eg!: Bonuses.WhatAreSpecialBonuses
        a: Специальные бонусы начисляются за победу в викторинах, которые мы проводим в наших группах в соцсетях. Также их можно получить за участие в акциях, о начале которых мы сообщаем в новостях и информационных рассылках. Способов много. Поэтому подписывайтесь на наши рассылки и сообщества, следите за новостями на сайте, участвуйте в акциях и получайте специальные бонусы.\n\nОтличие специального бонуса от обычного заключается в том, что специальный можно использовать на оплату только определенных лотерей.


    state: HowToBuyForSpecialBonuses
        # Оплата спецбонусами
        #как купить билет за спецбонус
        q!: * {$how * $buyInf * $specialBonus} *
        q!: * {$how * $payInf * $specialBonus} *
        q!: * {$how * ($buyN/~оплата) * $specialBonus} *
        q!: * {$how * $spendInf * $specialBonus} *
        q!: * {$how * $useInf * $specialBonus} *
        q!: * $comWhat * (делать/сделать) * ($with $specialBonus) *
        q!: * ~оплата [$ticket] $specialBonus *
        eg!: Bonuses.HowToBuyForSpecialBonuses
        a: Спецбонус можно использовать для оплаты билета на определенную лотерею.\n\n1. Выберите числа (или билет) на странице лотереи. Если у вас есть спецбонусы для оплаты выбранной лотереи, под кнопкой оплаты появится надпись «Доступна оплата специальными бонусами». Нажмите кнопку «Все способы оплаты».\n\n2. На странице способов оплаты выберите «Специальный бонус».\n\n3. Из списка спецбонусов, доступных для данной лотереи, выберите тот, которым оплатите билет.\n\n4. Оплатить развернутую ставку спецбонусами нельзя.\n\n5. Если у вас есть специальный бонус, который не указан в списке, добавьте его, используя кнопку «Добавить».\nВведите специальный бонус и код проверки. Нажмите «Добавить». Спецбонус появится в списке.\n\n6. Все действующие спецбонусы вы можете видеть в разделе «Специальные бонусы» личного кабинета.


    state: IDidntGetSpecialBonuses
        # На почту спецбонус так и не пришел
        q!: * {$comWhere [$comMy/~заработанный/обещан*/акцион*] [$Number] $specialBonus} *
        q!: * {$specialBonus * ($bonusComePastPresNe/$smsComePastNe)} *
        q!: * {($ne (дали/дают)/недали/недают/$receivePastNe) * $specialBonus} *
        q!: * {$specialBonus $comNo} *
        q!: * {$findPastPresNe * $specialBonus} *
        q!: * {$sendPastPresNe * $specialBonus} *
        q!: * {$when * $bonusComeFut * $specialBonus} *
        q!: * ($when/$howMuch) * {$waitInf [$comMy/~заработанный/обещан*/акцион*/подарочн*] [$Number] $specialBonus} *
        q!: * {$cantPastPres * получить * $specialBonus} *
        q!: * {([больше/более] [чем] $thirtySixHours) * прошло} *
        q!: * {([больше/более] [чем] $thirtySixHours) * прошли} *
        q!: * {$smsComePastPresNe * $sms * $thirdTicket} *
        q!: * {$smsComePastPresNe * $sms * $thirtySixHours} *
        q!: * {$smsComePastNe * $ticket * $thirtySixHours} *
        eg!: Bonuses.IDidntGetSpecialBonuses
        script: Webim.switch();


    #state: IDidntGetSpecialBonusForBuyingTwoTickets
        # Я до сих пор не получил спецбонус на покупку третьего билета
        #q!: * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe) * {($specialBonus/$bonus) * $thirdTicket} *
        #q!: * {($specialBonus/$bonus) * $thirdTicket} * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe) *

        #q!: * {$specialBonus * $bonusComePastPresNe * ((~два/2) $ticket)} *

        #q!: * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) * ($specialBonus/$bonus) * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) * (~два/2) [$oneWord] [$oneWord] $ticket * ($specialBonus/$bonus) *
        #q!: * ($specialBonus/$bonus) * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * ($specialBonus/$bonus) * (~два/2) [$oneWord] [$oneWord] $ticket * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) * ($specialBonus/$bonus) *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * ($specialBonus/$bonus) * ($ne (дали/дают)/недали/недают/$comNo/$bonusComePastPresNe/$receivePastNe/$findPastPresNe) *

        #q!: * {$when * $bonusComeFut * ($specialBonus/$bonus)} * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * {$when * $bonusComeFut * ($specialBonus/$bonus)} *

        # Как получить спецбонус за два купленных билета в одной лотерее? Третий в подарок.
        #q!: * {($receiveInf/получу) * ($specialBonus/$bonus) * ((~два/2) [$oneWord] [$oneWord] $ticket)} *
        # Дайте спецбонус за два купленных билета
        #q!: * {$giveImp * $specialBonus} * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * {$sendMeImp * $specialBonus} * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $specialBonus} * (~два/2) [$oneWord] [$oneWord] $ticket *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * {$giveImp * $specialBonus} *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * {$sendMeImp * $specialBonus} *
        #q!: * (~два/2) [$oneWord] [$oneWord] $ticket * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $specialBonus} *

        #q!: * {((~два/2) [$oneWord] [$oneWord] $ticket) * (обещан* $ticket)} *

        #q!: * {($how/$comWhere) * ($receiveInf/$buyInf/получу) * $thirdTicket} *
        #q!: * {($how/$comWhere/$when) * ($specialBonus/$bonus) * $thirdTicket} *

        #q!: подарочн* $ticket
        #q!: * {($how/$comWhere/$when) * (подарочн* $ticket)} *
        #q!: * {($how/$comWhere/$when) * бесплатн* * $ticket} *
        #q!: * {$receivePastNe * (подарочн* $ticket)} *

        #q!: * $comWhere * $thirdTicket *
        #q!: * {$thirdTicket * (в подарок)} *
        #q!: * {$thirdTicket бесплатно} *
        #q!: * $thirdTicket * ($ne подарили/неподарили/ниподарили) *
        #q!: * ($ne подарили/неподарили/ниподарили) * $thirdTicket *

        #q!: * $freeTicket *

        #q!: * {$buyPastPres * $twoTickets * ($ticket в подарок)} *
        #q!: * {$payPast * $twoTickets * ($ticket в подарок)} *
        #q!: * {$buyN * $twoTickets * ($ticket в подарок)} *

        #q!: * {$buyPastPres * $twoTickets * $comWhere * [$findInf] * $thirdAll} *
        #q!: * {$payPast * $twoTickets * $comWhere * [$findInf] * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * жду * $thirdAll} *
        #q!: * {$payPast * $twoTickets * жду * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * $comNo * $thirdAll} *
        #q!: * {$payPast * $twoTickets * $comNo * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * $smsComePastNe * $thirdAll} *
        #q!: * {$payPast * $twoTickets * $smsComePastNe * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * $giftPastPresNe * $thirdAll} *
        #q!: * {$payPast * $twoTickets * $giftPastPresNe * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * ~подарок * $thirdAll} *
        #q!: * {$payPast * $twoTickets * ~подарок * $thirdAll} *

        #q!: * {$buyPastPres * $twoTickets * ($bonus/$specialBonus) * $third} *
        #q!: * {$payPast * $twoTickets * ($bonus/$specialBonus) * $third} *

        #q!: * $buyPastPres * $twoTickets * {$receiveInf * $thirdAll} *
        #q!: * $payPast * $twoTickets * {$receiveInf * $thirdAll} *

        #q!: * $buyPastPres * $twoTickets * {$receiveInf * $freeTicket} *
        #q!: * $payPast * $twoTickets * {$receiveInf * $freeTicket} *

        #q!: * $buyPastPres * $twoTickets * {~подарок $comNo} *
        #q!: * $payPast * $twoTickets * {~подарок $comNo} *

        #q!: * {$buyPastPres * $twoTickets * ~подарок * 3} *
        #q!: * {$payPast * $twoTickets * ~подарок * 3} *

        #q!: * $buyPastPres * $twoTickets * {$comWhat ($with $thirdAll)} *
        #q!: * $payPast * $twoTickets * {$comWhat ($with $thirdAll)} *

        #q!: * {$buyPastPres * $twoTickets * $comWhere * ~подарок} *
        #q!: * {$payPast * $twoTickets * $comWhere * ~подарок} *
        #q!: * {$buyFut * $twoTickets * $comWhere * ~подарок} *
        #q!: * {$payFut * $twoTickets * $comWhere * ~подарок} *

        #q!: * {$buyPastPres * $twoTickets * ~акция} *
        #q!: * {$payPast * $twoTickets * ~акция} *

        #q!: * {$buyPastPres * $twoTickets * бонусного * $findPastPresNe} *
        #q!: * {$payPast * $twoTickets * бонусного * $findPastPresNe} *
        #q!: * $twoTickets [$beginningWords] $comWhere бонусный *

        #q!: * ($buyPastPres/$payPast) * $twoTickets * $comNeed выбрать еще (один/1) *
        #q!: * $thirdAll идет в подарок *
        #q!: * $why $comNo $thirdAll $ticket *
        #q!: * 2билета покупаешь 3в подарок *
        #q!: * что (подарят/подарите) $third *
        #q!: * $comTwo (плюс/+) (1/один) *
        #q!: * $comWhere [же] $third как (было обещано/обещал*) *
        #q!: * [$buyInf] {$third бесплатн*} по акции *

        #q!: * {подтвердил* $mail} * {$buyPastPres * $twoTickets} *
        #q!: * {подтвердил* $mail} * {$payPast * $twoTickets} *
        #q!: * {$buyPastPres * $twoTickets} * $comWhere $comMy ~бесплатный *
        #q!: * {$payPast * $twoTickets} * $comWhere $comMy ~бесплатный *

        #eg!: Bonuses.IDidntGetSpecialBonusForBuyingTwoTickets
        #a: Спецбонус на покупку 3-го билета будет отправлен по электронной почте в течение 36 часов после окончания проведения акции. С подробными условиями акции Вы можете ознакомиться, пройдя по ссылке http://free-ticket.stoloto.ru . Напишите нам, пожалуйста, если по прошествии 36 часов спецбонус не поступит.
        #script: Webim.switch();




















































