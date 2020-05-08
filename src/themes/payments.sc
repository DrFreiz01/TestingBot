theme: /Payments

    state: WhereToPutWinCode
        # Куда вводить код выигрыша
        q!: * $comWhat $oneWord $code $prizeLocal *
        q!: * $whatFor $oneWord $code $prizeLocal *
        q!: $code $prizeLocal $whatFor (он/они) $comNeed *
        q!: $code $prizeLocal {это $comWhat}
        q!: * {$insertInf * $code * $win} *
        q!: [$helloAll] куда {$sendInf $code $win}
        q!: * {$useInf * $code * $win} *
        q!: * {$insertInf * $win * ~номер * $sms} *
        q!: * {$comWhere * $insertInf * $code * $win} *
        q!: * $comWhat (делать/сделать) $with $code $win *
        q!: * {$sms * $code * $checkInf} *
        q!: * {$sms * ~номер * $checkInf} *
        q!: * $sms * $win * $checkInf *
        q!: * {$win * $code * $checkInf} *
        q!: * {$smsComePast * $sms * $win * $checkInf} *
        q!: * {$smsComePast * $code * $checkInf} *
        q!: * {$smsComePast * $notification * $win * $checkInf} *
        q!: * $smsComePast * ($sms/$code) * $winPastPerf *
        q!: * $smsComePast * $sms * $with $ticketNumber * и $code *
        q!: * $smsComePast * $sms * есть [какой-то/какой то] $prizeLocal *
        q!: * {[$onTelephone/на тел] $smsComePast} ($sms/$notification/$code) [$with/о] [$code] $win [$Number] [в $sms] [$comWhat] [эт*] [значит/означает]
        q!: [$helloAll] [мне] {[$onTelephone/на тел] $smsComePast} ($sms/$notification) $comWhat (какой-то/какой то/у меня/есть) $win [$comWhat] [эт*] [значит/означает]
        q!: * $receivePast $code $win * {$comWhat $doInf (дальше/потом/после)} *
        q!: * {$comWhat $doInf (дальше/потом/после)} * $receivePast $code $win *
        q!: * $smsComePast $code $win * {$comWhat $doInf (дальше/потом/после)} *
        q!: * {$comWhat $doInf (дальше/потом/после)} * $smsComePast $code $win *
        q!: $code $win [$Number]
        q!: * ($smsComePast/$receivePast) * $sms * $prizeLocal в * $ticket $regexp<\d+> $code [$win] *
        q!: $prizeLocal в * $ticket $regexp<\d+> $code [$win] [№]$regexp<\d+> *
        q!: * $number $prizeLocal $Number $comWhat эт* (значит/означает) *
        eg!: Payments.WhereToPutWinCode
        a: Код выигрыша - это числовая комбинация, которая поступает в sms в случае выигрыша. Данный код необходим для получения выигрыша в точке продаж. Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».

        ####################Проблемы с оплатой########################

    state: IСantPayByCard
        # Не могу оплатить картой
        q!: * $why * {$fromBankCard $comNo $payment} *
        q!: * {$cantPastPresAll * $buyInf * [$ticketAndLottery] * $bankCardAndOther} *
        q!: * {$cantPastPresAll * $payInf * [$ticketAndLottery] * $bankCardAndOther} *
        q!: * {$cantPastPresAll * ~ставка * $bankCardAndOther} *
        q!: * {$want * $buyInf * $bankCardAndOther} * (выкидывает/выбрасывает) *
        q!: * {$want * $payInf * $bankCardAndOther} * (выкидывает/выбрасывает) *
        q!: * $no ~возможность ($buyInf/$payInf) * $bankCardAndOther *
        q!: * {$payment * $bankCardAndOther * $activeNe} *
        q!: * {$buyInf * $bankCardAndOther * $activeNe} *
        q!: * {$payInf * $bankCardAndOther * $activeNe} *
        q!: * {$buyInf * $bankCardAndOther} * $comWhat пошло $ne так *
        q!: * {$payInf * $bankCardAndOther} * $comWhat пошло $ne так *
        q!: * {$cantPastPres * $buyN * $bankCardAndOther} *
        q!: * {$cantPastPres * $payment * $bankCardAndOther} *
        q!: * {$cantPastPres * $ticket * $bankCardAndOther} *
        q!: * (невозможност*/недоступност*) ($buyN/$payment) * $bankCardAndOther *
        q!: * {($ne идет) * $payment * $bankCardAndOther} *
        q!: * {неидет * $payment * $bankCardAndOther} *
        q!: * {$produceNePresSg3 $payment ($by $bankCardAndOther)} *
        q!: * {$nelzya * $payInf * $bankCardAndOther} *
        q!: * {$nelzya * $buyInf * $bankCardAndOther} *

        q!: * {$acceptPresNe * $payment * $bankCardAndOther} *
        q!: * {$acceptPresNe карт*} *
        q!: * {$dismissPastPres * $payment * $bankCardAndOther} *
        q!: * {$confirmPres3Ne $payment $bankCardAndOther} *
        q!: * {$workFut * $buyN * $bankCardAndOther} *
        q!: * {$workFut * $payment * $bankCardAndOther} *
        q!: * {$when * $buyInf * $bankCardAndOther} *
        q!: * {$when * $payInf * $bankCardAndOther} *
        q!: * {(~пустой ~экран) * $buyInf * $bankCardAndOther} *
        q!: * {(~пустой ~экран) * $payInf * $bankCardAndOther} *
        q!: * {$payPresNe * $ticketAndLottery * $bankCardAndOther} *
        q!: * {$payPresNe * $bet * $bankCardAndOther} *
        q!: [$helloAll] {$why $payPresNe [$by] $bankCardAndOther}
        q!: * {([так] $slowly) $passPres $buyN ($by $bankCardAndOther)} *
        q!: * {([так] $slowly) $passPres $payment ($by $bankCardAndOther)} *
        q!: * {[$why] * $buyInfNe * [$ticketAndLottery] * $bankCardAndOther} *
        q!: * {[$why] * $payInfNe * [$ticketAndLottery] * $bankCardAndOther} *
        q!: [$helloAll] {$why $payInfNe $bankCardAndOther}
        q!: * {$buyPresRefl3Ne * [$ticket] * $bankCardAndOther} *
        q!: * {[$ticket] * $buyPresRefl3 * долго * $bankCardAndOther} *
        q!: * ($payment/$buyN/$buyInf/$payInf) * $bankCardAndOther * $error *
        q!: * $error * ($payment/$buyN/$buyInf/$payInf) * $bankCardAndOther *
        q!: * {$moneyTakeOffPastPres * $bankCardAndOther * $ticket * ($ne оплачен*)} *
        q!: * {$moneyTakeOffPastPres * $bankCardAndOther * $ticket * $buyPastRefl3Ne} *
        q!: * {$payPast * $bankCardAndOther * $ticket * ($ne оплачен*)} *
        q!: * {$payPast * $bankCardAndOther * $ticket * $buyPastRefl3Ne} *
        q!: * {оплач* * $bankCardAndOther * $ticket * ($ne оплачен*)} *
        q!: * {оплач* * $bankCardAndOther * $ticket * $buyPastRefl3Ne} *
        q!: * {(пыта* $payInf) * $bankCardAndOther * $ticket * ($ne оплачен*)} *
        q!: * {(пыта* $payInf) * $bankCardAndOther * $ticket * $buyPastRefl3Ne} *
        q!: * $why может $workInfNe $payment $bankCardAndOther *
        q!: ($ne оплачен*) $bankCardAndOther
        eg!: Payments.IСantPayByCard
        if: $global.byuingTicketIsAvailable
            if: $global.cardPaymentIsAvailable
                script: Webim.switch();
            else:
                a: Мы уже работаем над возобновлением оплаты по банковским картам. Сейчас Вы можете оплатить лотерейный билет любым другим способом, указанным на нашем сайте или в мобильном приложении.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.


    state: IСantPayFromWallet
        # Не могу оплатить из Кошелька
        q!: * $why * {$fromWallet $comNo $payment} *
        q!: * {$cantPastPresAll * $buyInf * [$ticketAndLottery] * $w1All} *
        q!: * {$cantPastPresAll * $payInf * [$ticketAndLottery] * $w1All} *
        q!: * {$want * $buyInf * $w1All} * (выкидывает/выбрасывает) *
        q!: * {$want * $payInf * $w1All} * (выкидывает/выбрасывает) *
        q!: * $no ~возможность ($buyInf/$payInf) * $w1All *
        q!: * {$buyInf * $w1All * $activeNe} *
        q!: * {$payInf * $w1All * $activeNe} *
        q!: * {$cantPastPres * $buyN * $w1All} *
        q!: * (невозможност*/недоступност*) $buyN * $w1All *
        q!: * {($ne идет) * $payment * $w1All} *
        q!: * {неидет * $payment * $w1All} *
        q!: * {$cantPastPres * $payment * $w1All} *
        q!: * {$produceNePresSg3 $payment ($by $w1All)} *
        q!: * {$nelzya * $payInf * $w1All} *
        q!: * {$nelzya * $buyInf * $w1All} *
        q!: * {$acceptPresNe * $payment * $w1All} *
        q!: * {$dismissPastPres * $payment * $w1All} *
        q!: * {$confirmPres3Ne $payment ($by $w1All)} *
        q!: * {$workFut * $buyN * $w1All} *
        q!: * {$workFut * $payment * $w1All} *
        q!: * {$error * $payment * $w1All} *
        q!: * {$when * $buyInf * $w1All} *
        q!: * {$when * $payInf * $w1All} *
        q!: * {(~пустой ~экран) * $buyInf * $w1All} *
        q!: * {(~пустой ~экран) * $payInf * $w1All} *
        q!: * {$payPresNe * $ticketAndLottery * $w1All} *
        q!: * {$payPresNe * $bet * $w1All} *
        q!: * {$payPresNe $fromWallet} *
        q!: [$helloAll] {$why $payPresNe [$by] $w1All}
        q!: * {([так] $slowly) $passPres $buyN ($by $w1All)} *
        q!: * {([так] $slowly) $passPres $payment ($by $w1All)} *
        q!: * {[$why] * $buyInfNe * [$ticketAndLottery] * $w1All} *
        q!: * {[$why] * $payInfNe * [$ticketAndLottery] * $w1All} *
        q!: [$helloAll] {$why $payInfNe [$by] $w1All}
        q!: * {$buyPresRefl3Ne * [$ticket] * $w1All} *
        q!: * {[$ticket] * $buyPresRefl3 * долго * $w1All} *
        q!: * ($payment/$buyN/$buyInf/$payInf) * $w1All * $error *
        q!: * $error * ($payment/$buyN/$buyInf/$payInf) * $w1All *
        q!: * {$moneyTakeOffPastPres * $w1All * $ticket * ($ne оплачен*)} *
        q!: * {$moneyTakeOffPastPres * $w1All * $ticket * $buyPastRefl3Ne} *
        q!: * {$payPast * $w1All * $ticket * ($ne оплачен*)} *
        q!: * {$payPast * $w1All * $ticket * $buyPastRefl3Ne} *
        q!: * {оплач* * $w1All * $ticket * ($ne оплачен*)} *
        q!: * {оплач* * $w1All * $ticket * $buyPastRefl3Ne} *
        q!: * {(пыта* $payInf) * $w1All * $ticket * ($ne оплачен*)} *
        q!: * {(пыта* $payInf) * $w1All * $ticket * $buyPastRefl3Ne} *
        q!: * $why может $workInfNe $payment ($with/из) $w1All *
        q!: ($ne оплачен*) ($with/из) $w1All
        eg!: Payments.IСantPayFromWallet
        if: $global.byuingTicketIsAvailable
            if: $global.paymentFromWalletIsAvailable
                script: Webim.switch();
            else:
                a: Мы уже работаем над возобновлением продажи билетов на нашем сайте. Сейчас вы можете оплатить лотерейный билет любым другим способом, указанным на нашем сайте или в мобильном приложении.
        else:
            a: По техническим причинам временно может быть недоступна оплата билетов. А пока мы работаем над устранением этой проблемы, пожалуйста, не дублируйте Ваши оплаты после того, как первая попытка не удалась. Мы просим немного Вашего терпения и обещаем, что очень скоро платежи станут проходить так же быстро, как и всегда.

        ##########################Баланс##############################

    state: BalanceUnavailable
        # Недоступен баланс
        q!: * $comNo данных [о/по] $balance *
        q!: * $comNo данных [о/по] $wallet *
        q!: * {$downloadPres3Ne (данные [о/по] [$comMy] ($balance/$wallet))} *
        q!: * {($wallet/$balance [$wallet]) [$oneWord] $cantPastPres} *
        q!: * {$cantPastPresAll $findInf (остаток [$comMoney] ($inWallet/$onBalanceLoc))} *
        q!: * {$cantPastPresAll (~информация (о/по) $balance)} *
        q!: * {$wallet * $problem} *
        q!: * {($balance/~счет) * $problem} *
        q!: * {$walletAll * $zero} *
        q!: * {$walletAll * $zeroAdj} *
        q!: * {$walletAll * обнул*} *
        q!: * ($comNo/пропал/отсутс*) $balance *
        q!: * {(после ~обновление) * ($comNo/$bonusDisappearPastPres) * $comMoney} *
        q!: * куда (делас*/подевалас*) сум* ($inWallet/$fromWallet) *
        q!: {$comNo $comMoney ($inWallet/$onBalanceLoc)}
        q!: * {$bonusComePastPresNe ([сум*] ([в] $wallet/[на] $balance [$wallet]))} *
        q!: * {$bonusComePastPresNe сум* ([в/на] [$comMy] $account)} *
        q!: * {$findPastPresNe * $balance} *
        q!: * {$findPastPresNe * $comMoney * ($onBillLoc/$account/$inWallet)} *
        q!: * {$displayPresPl3Ne * $comMoney * ($onBillLoc/$account/$inWallet/$onBalanceLoc)} *
        q!: * {$cantPastPres * $findInf * $balance} *
        q!: * $cantPastPresAll $checkInf [$comMy] $balance *
        q!: * {$cantPastPres * ~обновление * $walletAll} *
        q!: * {$cantPastPres * обновить * $walletAll} *
        q!: * {$balance * $changeNe} *
        q!: * {$changeNe $wallet} *
        q!: * {$wallet * завис} *
        q!: * $comWhat [$ne так/$happenPast] $with [~мой] $walletAll *
        q!: * {$walletAll * $updatePresSg3Ne} *
        q!: * {($balance/$wallet) $inactive} *
        q!: * ($balance/$wallet) * {он $inactive} *
        q!: * {$inactive * $comMoney * $wallet} *
        q!: * {$cantPastPres * $useInf * $comMoney} *
        q!: * {$bonusDisappearPastPres * $walletAll} *
        q!: * {$bonusDisappearPastPres $comMoney ([c/в/на] [~мой] $account)} *

        q!: * $walletAll (был*/лежал*) * ($comMoney/$rub) * их $comNo *
        q!: * {куда * $bonusDisappearPastPres * $comMoney} *
        q!: * {$comWhere * $moneyAndRub * $walletAll} *

        eg!: Payments.BalanceUnavailable
        if: $client.testMode || $global.balanceIsAvailable
            script: Webim.switch();
        else:
            a: В настоящий момент баланс Кошелька Столото может быть недоступен. Мы работаем над скорейшим устранением проблемы.


    state: IncorrectBalance
        # Некорректно отображается баланс
        q!: * {$wrong [на $wallet] $balance} *
        q!: * {$wrong ~отображение $balance} *
        q!: * {$balance * $displayPres3 * $incorrectly} *
        q!: * {$balance * отображен * $incorrectly} *
        q!: * {~отображение * $balance * $incorrectly} *
        q!: * {$wallet * $incorrectly * $comMoney * отображены} *
        q!: * {$wallet * $wrong * $comMoney} *
        q!: * {$balance * $wrong * $comMoney} *
        q!: * {$wallet * $displayPres3 * ($ne все $comMoney)} *
        q!: * {~счет * $displayPres3 * ($ne все $comMoney)} *
        q!: * {$balance * $displayPres3 * ($ne все $comMoney)} *
        eg!: Payments.IncorrectBalance
        if: $global.balanceIsCorrect
            script: Webim.switch();
        else:
            a: В данный момент мы обновляем информацию на сайте. Вы сможете посмотреть баланс своего Кошелька в кратчайшие сроки.


        ##########################Вопросы про банковские карты########


    state: HowToRemoveABancCard
        # Как отвязать банковскую карту?
        q!: * {$unpinInfImp * $bankCardAll} *
        q!: * {$blockInf * $bankCardAll * [$ticketAll]} *
        q!: * {$blockImpFut * $bankCardAll * [$ticketAll]} *
        eg!: Payments.HowToRemoveABancCard
        script: Webim.switch();


    state: HowToChangeABankCard
        # Как изменить банковскую карту?
        q!: * {$changeInfImpAll * $bankCardAll} *
        q!: * {$changePast $bankCardAll} *
        q!: * {$wrong $bankCardAll} *
        q!: * {вбить * $bankCardAll} *
        q!: * добавить [$new/еще] [одну/1] $bankCardAll *
        q!: * {$attachInf * $bankCardAll} *
        q!: * {$appendInf * ($new $bankCardAll)} *
        q!: * {ввести * ($new $bankCardAll)} *
        q!: * {(у $meGen) * ($new $bankCardAll)} *
        eg!: Payments.HowToChangeABankCard
        a: Для изменения данных банковской карты при пополнении Кошелька, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25. Кошелек Столото интегрирован в платформу Единого Кошелька, поэтому у нас, к сожалению, нет доступа к данной информации. При обращении сообщите, пожалуйста, номер Вашего Кошелька.\n\nЕсли Вы хотите оплатить билет другой картой, выберите способ оплаты «Банковская карта». После этого нажмите, пожалуйста, на кнопку «Использовать другую карту». В открывшемся окне необходимо ввести реквизиты новой карты, нажать «Далее». Таким образом Вы сможете произвести оплату другой картой.


    state: ICantToChangeABankCard
        # Не могу изменить банковскую карту
        q!: * {$changeInfImpAll * $bankCardAll * [$depositInf/~пополнение] *$cantPastPresAll} *
        q!: * {$changeInfImpAll * $bankCardAll * $payment * $wallet * $cantPastPresAll} *
        q!: * {$changeInfImpAll * $bankCardAll * ($buyInf/$buyN/$buyPastPres) * $cantPastPresAll} *
        q!: * {$changeInfImpAll * $bankCardAll * $payment * $ticketAll * $cantPastPresAll} *
        q!: * {$changeInfImpAll * $bankCardAll * ($payInf/$payPast) * $ticketAll * $cantPastPresAll} *

        q!: * {$attachInf * $bankCardAll * [$depositInf/~пополнение] * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * $payment * $wallet * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres) * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * $payment * $ticketAll * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * ($payInf/$payPast) * $ticketAll * $cantPastPresAll} *

        q!: * {$attachInf * $bankCardAll * [$depositInf/~пополнение] * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * $payment * $wallet * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres) * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * $payment * $ticketAll * $cantPastPresAll} *
        q!: * {$attachInf * $bankCardAll * ($payInf/$payPast) * $ticketAll * $cantPastPresAll} *

        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * [$depositInf/~пополнение] * $cantPastPresAll} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * $payment * $wallet * $cantPastPresAll} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * ($buyInf/$buyN/$buyPastPres) * $cantPastPresAll} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * $payment * $ticketAll * $cantPastPresAll} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * ($payInf/$payPast) * $ticketAll * $cantPastPresAll} *

        q!: * {вбить * $bankCardAll * [$depositInf/~пополнение] * $cantPastPresAll} *
        q!: * {вбить * $bankCardAll * $payment * $wallet * $cantPastPresAll} *
        q!: * {вбить * $bankCardAll * ($buyInf/$buyN/$buyPastPres) * $cantPastPresAll} *
        q!: * {вбить * $bankCardAll * $payment * $ticketAll * $cantPastPresAll} *
        q!: * {вбить * $bankCardAll * ($payInf/$payPast) * $ticketAll * $cantPastPresAll} *

        q!: * {$appendInf * ($new $bankCardAll) * $cantPastPresAll} *
        q!: * {ввести * ($new $bankCardAll) * $cantPastPresAll} *
        eg!: Payments.ICantToChangeABankCard
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToChangeABankCardToFillUpPurse
        # Как изменить банковскую карту для пополнения Кошелька?
        q!: * {$changeInfImpAll * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {$changeInfImpAll * $bankCardAll * $payment * $wallet} *

        q!: * {$wrong $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {$wrong $bankCardAll * $payment * $wallet} *

        q!: * {$attachInf * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {$attachInf * $bankCardAll * $payment * $wallet} *

        q!: * {вбить * $bankCardAll * ($depositInf/~пополнение)} *
        q!: * {вбить * $bankCardAll * $payment * $wallet} *

        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * ($depositInf/~пополнение)} *
        q!: * {(добавить [$new/еще] [одну/1] $bankCardAll) * $payment * $wallet} *
        eg!: Payments.HowToChangeABankCardToFillUpPurse
        a: Для изменения данных банковской карты при пополнении Кошелька, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25. Кошелек Столото интегрирован в платформу Единого Кошелька, поэтому у нас, к сожалению, нет доступа к данной информации. При обращении сообщите, пожалуйста, номер Вашего Кошелька.


    state: HowToChangeABankCardToPayForTickets
        # Как изменить банковскую карту для оплаты билетов
        q!: * {$changeInfImpAll * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {$changeInfImpAll * $bankCardAll * $payment * $ticketAll} *
        q!: * {$changeInfImpAll * $bankCardAll * ($payInf/$payPast) * $ticketAll} *

        q!: * {($wrong $bankCardAll) * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {($wrong $bankCardAll) * $payment * $ticketAll} *
        q!: * {($wrong $bankCardAll) * ($payInf/$payPast) * $ticketAll} *

        q!: * {$attachInf * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {$attachInf * $bankCardAll * $payment * $ticketAll} *
        q!: * {$attachInf * $bankCardAll * ($payInf/$payPast) * $ticketAll} *

        q!: * {вбить * $bankCardAll * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {вбить * $bankCardAll * $payment * $ticketAll} *
        q!: * {вбить * $bankCardAll * ($payInf/$payPast) * $ticketAll} *

        q!: * {(добавить [$new] $bankCardAll) * ($buyInf/$buyN/$buyPastPres)} *
        q!: * {(добавить [$new] $bankCardAll) * $payment * $ticketAll} *
        q!: * {(добавить [$new] $bankCardAll) * ($payInf/$payPast) * $ticketAll} *
        eg!: Payments.HowToChangeABankCardToPayForTickets
        a: Если Вы хотите оплатить билет другой картой, выберите способ оплаты «Банковская карта». После этого нажмите, пожалуйста, на кнопку «Использовать другую карту». В открывшемся окне необходимо ввести реквизиты новой карты, нажать «Далее». Таким образом Вы сможете произвести оплату другой картой.

        #####################Общие вопросы про деньги##############

    state: WhereIsTheMoney
        # Где деньги
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhere [$obsceneWord] [$comMy] $moneyAndRub}
        q!: [$helloAll] [$comYes] [$beginningWords] $comWhere [же] [$obsceneWord] [$comMy] $moneyAndRub
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhat [$obsceneWord] $with [$comMy] $moneyAndRub}
        q!: [$helloAll] {($returnImp/отдайте) [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [$comMy] $moneyAndRub (пропал*/исчезл*/потерялис*)
        q!: [$helloAll] (пропал*/исчезл*/потерялис*) [$comMy] $moneyAndRub
        q!: * (куда/где) (пропал*/исчезл*/потерялис*) [$comMy] $moneyAndRub *
        q!: [$helloAll] $why ($ne отдаете/неотдаете/ниотдаете) {[$comMy] $moneyAndRub}
        q!: [$helloAll] $why {[$comMy] $moneyAndRub} ($ne отдаете/неотдаете/ниотдаете)
        eg!: Payments.WhereIsTheMoney
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToTransferTheMoney
        # Как перевести деньги (без уточнения, куда)
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf [$comMy] $moneyAndRub} [$onBill]

        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $transferInfImp [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $sendInf [$comMy] $moneyAndRub} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $moneyAddInf [$comMy] $moneyAndRub} [$onBill]
        eg!: Payments.HowToTransferTheMoney
        a: Уточните, пожалуйста, Вы хотите пополнить Кошелек, перевести выигрыш на Кошелек или перевести выигрыш из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/HowToTransferTheMoney
            event: noMatch
            script: Webim.switch();


    state: HowToTransferTheMoneyToPurse
        # Как перевести деньги в Кошелек (без уточнения, выигрыш или пополнить)
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp [$comMy] $moneyAndRub $toWalletAll}
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf [$comMy] $moneyAndRub $toWalletAll}
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [$ne] [*скаж*/науч*] [$please] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf [$comMy] $moneyAndRub $toWalletAll}
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $transferInfImp [$comMy] $moneyAndRub $toWalletAll}
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $sendInf [$comMy] $moneyAndRub $toWalletAll}
        q!: [$helloAll] [извините] [меня] [$please] [$comYes] [$beginningWords] [*скаж*/$ne *скаж*] [$please] {[$how/$want] [я] [могу] $moneyAddInf [$comMy] $moneyAndRub $toWalletAll}
        eg!: Payments.HowToTransferTheMoneyToPurse
        a: Уточните, пожалуйста, Вы хотите пополнить Кошелек или перевести выигрыш на Кошелек?


    state: ICantToTransferTheMoney
        # Не могу перевести деньги (без уточнения, куда)
        q!: * {$cantPastPresAll * $transferInfImp * $moneyAndRub} *
        q!: * {$cantPastPresAll * $sendInf * $moneyAndRub} *
        q!: * {$cantPastPresAll * $moneyAddInf * $moneyAndRub} *

        q!: * {$transferInfNe * $moneyAndRub} *
        q!: * {$sendInfNe * $moneyAndRub} *
        q!: * {$moneyAddInfNe * $moneyAndRub} *

        q!: * {$moneyAddPastPresNe * $moneyAndRub} *
        q!: * {$moneyAddPartPasNe * $moneyAndRub} *
        q!: * {$smsComePastPerfNe * $moneyAndRub} *
        q!: * {$smsComePresNe * $moneyAndRub} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub} *

        q!: * {$howLong * $bonusComePastPres * $moneyAndRub} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub} *

        q!: * {$howLong * $bonusComeFut * $moneyAndRub} *
        q!: * {$when * $bonusComeFut * $moneyAndRub} *
        q!: * {$howLong * $transferFut * $moneyAndRub} *
        q!: * {$when * $transferFut * $moneyAndRub} *

        q!: * {$transferPastPres * $moneyAndRub} * $comWhere *
        q!: * {$sendPastPres * $moneyAndRub} * $comWhere *

        q!: [$helloAll] [$comYes] [$beginningWords] куда {$transferPast $moneyAndRub}
        q!: [$helloAll] [$comYes] [$beginningWords] как (быстро/долго) {доходят $comMoney}
        q!: [$helloAll] [$comYes] [$beginningWords] (быстро/долго) $li {доходят $comMoney}
        q!: [$helloAll] [$comYes] [$beginningWords] [за] сколько [по времени] {доходят $comMoney}
        q!: [$helloAll] {$why [мне] $onBill $smsComePastPerfNe}
        q!: [$helloAll] {$why [мне] $onBill $sendPastPresNe}
        q!: [$helloAll] {$why [мне] $onBill $transferPastPresNe}
        q!: [$helloAll] {$moneyAndRub $moneyTakeOffPastPres} (но/однако/а) [$moneyAndRub] ($onBalanceLoc/$onBillLoc) {$comNo [их/$nothing]} [$why]
        q!: [$helloAll] {$moneyAndRub $moneyAddPastPres} (но/однако/а) [$moneyAndRub] ($onBalanceLoc/$onBillLoc) {$comNo [их/$nothing]} [$why]
        q!: * куда * $sendPartPas * $moneyAndRub *
        q!: * куда [у меня] ушли [$comMy] $moneyAndRub *
        q!: * (каков/~какой) ~срок * (~начисление/~зачисление) * $moneyAndRub *
        q!: * $moneyAndRub {[$ne] сразу $smsComePres $onBill}

        eg!: Payments.ICantToTransferTheMoney
        a: Уточните, пожалуйста, у Вас не получается пополнить Кошелек, перевести выигрыш на Кошелек или перевести выигрыш из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/ICantToTransferTheMoney
            event: noMatch
            script: Webim.switch();

    state: ICantToTransferTheMoneyToPurse
        # Не могу перевести деньги в Кошелек (не уточнено, выигрыш или при пополнении)
        q!: * {$cantPastPresAll * $transferInfImp * $moneyAndRub * $toWalletAll} *
        q!: * {$cantPastPresAll * $sendInf * $moneyAndRub * $toWalletAll} *
        q!: * {$cantPastPresAll * $moneyAddInf * $moneyAndRub * $toWalletAll} *

        q!: * {$transferInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$sendInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$moneyAddInfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$transferPastPresNe * $moneyAndRub * $toWalletAll} *

        q!: * {$moneyAddPresNe * $moneyAndRub * $toWalletAll} *
        q!: * {$smsComePastPerfNe * $moneyAndRub * $toWalletAll} *
        q!: * {$smsComePresNe * $moneyAndRub * $toWalletAll} *

        q!: * {$smsComePastPerfNe * $moneyAndRub * (до [$comMy] $wallet)} *
        q!: * {$smsComePresNe * $moneyAndRub * (до [$comMy] $wallet)} *

        q!: * {$moneyAddPastPresNe * $moneyAndRub * $toWalletAll} *
        q!: * {$moneyAddPartPasNe * $moneyAndRub * $toWalletAll} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $toWalletAll} *

        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $toWalletAll} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $toWalletAll} *
        q!: * $howLong * {$bonusComePastPres * $moneyAndRub} * $inWallet *
        q!: * $when * {$bonusComePastPres * $moneyAndRub} * $inWallet *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $toWalletAll} *

        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $toWalletAll} *
        q!: * $howLong * {$bonusComeFut * $moneyAndRub} * $inWallet *
        q!: * $when * {$bonusComeFut * $moneyAndRub} * $inWallet *
        q!: * {$howLong * $transferFut * $moneyAndRub * $toWalletAll} *
        q!: * {$when * $transferFut * $moneyAndRub * $toWalletAll} *

        q!: * {$transferPastPres * $moneyAndRub * $toWalletAll} * $comWhere *
        q!: * {$sendPastPres * $moneyAndRub * $toWalletAll} * $comWhere *

        q!: * {$transferPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$transferInfImp * [$moneyAndRub] * $toWalletAll * $transferPastPresNe} *
        q!: * {$sendPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$moneyAddPastPres * [$moneyAndRub] * $toWalletAll * $bonusComePastPresNe} *
        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $toWalletAll *

        eg!: Payments.ICantToTransferTheMoneyToPurse
        a: Уточните, пожалуйста, у Вас не получается пополнить Кошелек или перевести выигрыш на Кошелек?

        #####################Получение выигрыша################################

    state: HowToGetPrize
        # Как получить выигрыш
        q!: [$helloAll] (~правило/~способ) ~получение $prizeWithoutMoney
        q!: * $how * (забираетс*/забираетьс*) * $prizeWithoutMoney *
        q!: * ~правило выплат* $prizeWithoutMoney *
        q!: * {[$how] * $getInf * $prize} *
        q!: * {$how * получают * $prize} *
        q!: * {$comWhere получают $prize} *
        q!: * {$how * $getInf * $prize * $bySms} *
        q!: * {$how * $getInf * $prize * $ticket} *
        q!: * {$comWhere * $getInf * $prize * $ticket} *
        q!: [$helloAll] {$how [я] получу $prizeWithoutMoney}
        q!: [$helloAll] {$how $receiveInf $prizeWithoutMoney}
        q!: [$helloAll] {($how/$comWhere) $getInf}
        # Где их обналичить
        q!: [$helloAll] {[$how/$comWhere] [его/ее/их] $cashoutInf}
        q!: * {$cashoutInf * $ticket} *
        # У меня выйгрыш, что сделать, чтобы забрать его
        q!: * (меня/я) * $win * $comWhat * (делать/сделать/дальше/потом) *
        q!: * $comWhat * (делать/сделать/дальше/потом) * ($me/я) * $win *
        # У меня выйгрыш, к кому я могу обратиться
        q!: * $win * (к кому/куда) * (обращат*/оброшатся/обратит*/идти) *
        q!: * (к кому/куда) * (обращат*/оброшатся/обратит*/идти) * $win *
        # Ссылка на получение выигрыша
        q!: [$helloAll] {(~получение/~обналичивание/~выдача/~выплата) $prizeWithoutMoney}
        q!: * (куда/$how) {($transferPres3/$sendPres3) $prize} *
        q!: * куда {$getPrizPresPlSg3 $prize} *
        q!: * подсказк* * ~получение $prizeWithoutMoney *
        q!: * {$winPastPerf * ($how/$comWhere) * $getInf} *
        q!: * {$winPastPerf * ($how/$comWhere) * $cashoutInf} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) * {куда выплату делают} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) * {$how выплату делают} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) * {куда оплату делают} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) * {$how оплату делают} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) (дальн*/дольн*) ~действие *
        q!: * ($if/вдруг) $prizeWithoutMoneyAllAndWinTicket (дальн*/дольн*) ~действие *
        q!: * $winTicket * $exchangeInf на $comMoney *
        eg!: Payments.HowToGetPrize
        a: Способ получения выигрыша зависит от способа оформления билета, вида лотереи и суммы выигрыша. Полная инструкция по получению выигрыша размещена по ссылке http://www.stoloto.ru/lottery/winning . Ознакомьтесь, пожалуйста. Если у Вас останутся вопросы, пожалуйста, обращайтесь.

        state: IBoughtInPyaterochka
            # Покупал в Пятерочке
            q: * {$buyPastPres * $pyaterochka} *
            q: * {взял* * $pyaterochka} *
            q: * ($ticket/$lottery/лото) из $pyaterochka *
            a: К сожалению, в магазинах «Пятерочка» выигрыш получить невозможно. Процедура получения выигрыша зависит от суммы выигрыша:\n\nдо 1 000 рублей – Вы сможете получить в салоне связи «Мегафон»;\nот 1 000 до 10 000 рублей – в салонах связи «Евросеть»/«Связной»;\nдо 10 000 рублей - в отделениях Почты России;\nдо 500 000 рублей – на нашем сайте, в Кошелек Столото.


    state: HowToGetPrizeIfTheNumberHasChanged
        # Как получить выигрыш, если номер изменился
        q!: * {$getPrizInf * $prize} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {$getPrizInf * $prize} *
        q!: * {$getPrizInf * $prize} * {утерян * $phoneAndNum} *
        q!: * {утерян * $phoneAndNum} * {$getPrizInf * $prize} *
        q!: * {$getPrizInf * $prize} * {(доступа к [$oneWord] $phoneAndNum) * $comNo} *
        q!: * {(доступа к [$oneWord] $phoneAndNum) * $comNo} * {$getPrizInf * $prize} *
        q!: * {$getPrizInf * $prize * ($wrong $phoneAndNum) * [$duringRegistration]} *
        q!: * {$getPrizInf * $prize * (~новый $phoneAndNum)} *
        q!: * {$getPrizInf * $prize * (сейчас * ~другой $phoneAndNum)} *
        q!: * {$getPrizInf * $prize * ($phoneAndNum $old)} *
        q: * {[$getPrizInf] * $comMoney} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {[$getPrizInf] * $prizeLocal} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {быть * $comMoney} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * {быть * $prizeLocal} * || fromState = /Phone/PhoneNumberChange/InLK
        q: * $comWhat * делать * ($comMoney/$prizeLocal) * || fromState = /Phone/PhoneNumberChange/InLK
        eg!: Payments.HowToGetPrizeIfTheNumberHasChanged
        a: Вам необходимо создать новый личный кабинет с новым номером телефона и перевести денежные средства из старого аккаунта в новый.\n\nДля перевода денежных средств из одного личного кабинета в другой необходимо, чтобы оба кабинета были идентифицированы.\n\nПройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nЕсли у Вас пройдена идентификация, то направьте, пожалуйста, на почту info@stoloto.ru следующие документы:\n- скан Вашего паспорта (страница с фото);\n- договор с оператором сотовой связи на Ваш старый номер телефона (можно запросить у оператора);\n- договор с оператором сотовой связи на Ваш новый номер телефона (можно запросить у оператора);\n- заявление в свободной форме о переводе денежных средств из старого кабинета в новый (написано от руки и отсканировано или сфотографировано).\n\nПример заявления:\n\nЯ, (ФИО в именительном падеже), (дата рождения), проживающая по адресу (адрес с индексом), (номер телефона), являюсь зарегистрированным пользователем на Вашем сайте www.stoloto.ru (указываете логин, почту и номер телефона от личного кабинета нашего сайта). На 01.11.2014 (дату заявления ставите) на счете Кошелька Столото № (номер Кошелька вышеуказанного кабинета) данного личного кабинета находятся (указываете баланс Кошелька) рублей. К сожалению, данными средствами нет возможности воспользоваться, номер телефона (указываете номер телефона от личного кабинета) более не работоспособен. Прошу помочь в разрешении данной ситуации. Прошу осуществить перевод средств из моего старого Кошелька Столото № (номер Кошелька вышеуказанного кабинета) в мой новый Кошелек Столото № (номер нового Кошелька нового кабинета) личного кабинета (указываете логин, почту и номер телефона от нового личного кабинета нашего сайта), где номер телефона работоспособен и я могу ими воспользоваться.\n(ниже дату, подпись и расшифровку подписи).\n\nВ случае, если у Вас нет возможности предоставить договор с оператором связи, то Вам необходимо пройти полную идентификацию с помощью скайпа в двух личных кабинетах. Пройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nНаправьте, пожалуйста, комплект документов на электронную почту info@stoloto.ru. В теме письма укажите «Перевод средств».


    state: WinDeadlines
        # Какие сроки получения выигрыша?
        q!: * {(~ограничение по времени) * (~получение $prizeWithoutMoney)} *
        q!: * (каков/~какой) ~срок * (~получение $prizeWithoutMoney) *
        q!: * есть ли сроки (~получение $prizeWithoutMoney) *
        q!: * сориентир* по срокам (~получение $prizeWithoutMoney) *
        eg!: Payments.WinDeadlines
        script: Webim.switch();


    state: GaveTicketHowToGetPrize
        # Подарили билет, он выиграл, как получить приз?
        q!: * {$giftPast * $ticketAll * $getPrizInf * $prize} *
        q!: * {$giftPast * $ticketAll * $cashoutInf} *
        q!: * {$giftPast * $ticketAll * (~получение/$withdrawalToPurse/~обналичивание/~выдача) * $prize} *
        q!: * {$giftPast * $ticketAll * $winPastPerf} *
        q!: * {$giftPast * $ticketAll * $win} *
        eg!: Payments.GaveTicketHowToGetPrize
        script: Webim.switch();


    state: ForeignerHowToGetPrize
        # Как получить выигрыш, если у тебя нет паспорта РФ и ты иностранец
        q!: * {$foreigner * $getPrizInf * $prize} *
        q!: * {$foreigner * $cashoutInf} *
        q!: * {$foreigner * (~получение/$withdrawalToPurse/~обналичивание/~выдача) * $prize} *
        q!: * {$foreigner * $ticketAll * $winPastPerf} *
        q!: * {$foreigner * $ticketAll * $win} *
        eg!: Payments.ForeignerHowToGetPrize
        script: Webim.switch();


    state: WhereIsThePrize
        # Где выигрыш
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhere [$obsceneWord] [$comMy] $prizeLocal}
        q!: [$helloAll] ($ne оплачивают/неоплачивают/ниоплачивают) $prizeLocal
        q!: [$helloAll] $prizeLocal ($ne оплачивают/неоплачивают/ниоплачивают)
        q!: [$helloAll] ~выплата ($ne прошл*/непрошл*/нипрошл*)
        q!: [$helloAll] ($ne прошл*/непрошл*/нипрошл*) ~выплата
        q!: * $comWhere еще $comMy $prizeLocal *
        q!: [$helloAll] [$comYes] [$beginningWords] $comWhere [же] [$obsceneWord] [$comMy] $prizeLocal
        q!: [$helloAll] [$comYes] {[$beginningWords] $comWhat [$obsceneWord] $with [$comMy] $prizeLocal}
        q!: [$helloAll] {($returnImp/отдайте) [$comMy] $prizeLocal} [$onBill]
        q!: * $winPastPerf а $comWhere (они/$comMoney) *
        eg!: Payments.WhereIsThePrize
        a: Опишите подробнее, пожалуйста, в чем у Вас возникла сложность?


    state: HowToTransferPrize
        # Как перевести выигрыш (без уточнения, куда)
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$please] [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $transferInfImp [$comMy] $prizeWithoutMoney} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$please] [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $sendInf [$comMy] $prizeWithoutMoney} [$onBill]
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$please] [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll/$comNeed] $moneyAddInf [$comMy] $prizeWithoutMoney [$onBill]}
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$please] [$beginningWords] {[$how/$want] [[в/$with] $generalNamedLottery] [мне] [$possiblePredicAll/$comNeed/могу/магу] [правильно] $withdrawInf [$comMy] [$prize] [$onBill]}
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$please] [$beginningWords] {[$how/$want] [[в/$with] $generalNamedLottery] [мне] [$possiblePredicAll/$comNeed/могу/магу] [правильно] $withdrawInf [$comMy] $moneyAndRub [$onBill]}
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $transferInfImp [$comMy] $prizeWithoutMoney} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $transferInfImp [$comMy] $moneyAndRub} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $sendInf [$comMy] $prizeWithoutMoney} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $sendInf [$comMy] $moneyAndRub} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $moneyAddInf [$comMy] $prizeWithoutMoney} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $moneyAddInf [$comMy] $moneyAndRub} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $getPrizInf [$comMy] $prize} [к] себе $onBill
        q!: * $ticket $win [$beginningWords] {[$how/$want] [мне] [$possiblePredicAll] $getPrizInf [$comMy] $moneyAndRub} [к] себе $onBill
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$beginningWords] вывод $prize $how
        q!: [$helloAll] [извините] [меня] [$please] [$ne] [*скаж*/науч*] [$beginningWords] $how [мне] (делать/сделать) вывод
        q!: * $prizeWithoutMoneyAll {[я] могу} [их/его] ($transferInfImp/$sendInf/$moneyAddInf/$withdrawInf)
        q!: * $prizeWithoutMoneyAll $how [мне] [их/его] ($transferInfImp/$sendInf/$moneyAddInf/$withdrawInf) [их/его]
        q!: * $moneyAndRub {[я] могу} [их/его] $withdrawInf
        q!: [$helloAll] {(~вывод/~выведение/~перевод/~отправка) $prizeWithoutMoney}
        q!: [$helloAll] {(~вывод/~выведение) $moneyAndRub}
        q!: * $how * (снимаютс*/снимаютьс*) *
        eg!: Payments.HowToTransferPrize
        a: Уточните, пожалуйста, Вы хотите перевести выигрыш в Кошелек Столото или из Кошелька Столото на сторонний ресурс?

        state: LocalCatchAll || fromState = /Payments/HowToTransferPrize
            event: noMatch
            script: Webim.switch();


    state: ThereIsNoGreenButton
        # Тут нет зеленой кнопки
        q!: * {[$here] $comNo $green $button} *
        q!: * {[$here] $findPastPresNe $green $button} *
        eg!: Payments.ThereIsNoGreenButton
        a: Уточните, пожалуйста, Вы хотите вывести выигрыш в Кошелек или из Кошелька на сторонний ресурс?

        state: LocalCatchAll || fromState = /Payments/ThereIsNoGreenButton
            event: noMatch
            script: Webim.switch();


    state: ICantToTransferPrize
        # Не могу перевести выигрыш (без уточнения, куда)
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoney} *
        q!: * {$cantPastPresAll * $sendInf * $prizeWithoutMoney} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeWithoutMoney} *
        q!: * {$cantPastPresAll * $getPrizInf * $prizeWithoutMoneyAndWinTicket} *
        q!: * {$cantPastPresAll * $withdrawInf * $moneyAndRub} *
        q!: * когда * $transferInfImp * $prizeWithoutMoney *
        q!: * когда * $sendInf * $prizeWithoutMoney *

        q!: * {$transferInfNe * $prizeWithoutMoney} *
        q!: * {$sendInfNe * $prizeWithoutMoney} *
        q!: * {$moneyAddInfNe * $prizeWithoutMoney} *

        q!: * {$withdrawPres3Ne * $prize} *
        q!: * {$withdrawPres3Ne * $moneyAndRub} *
        q!: * {$withdrawPastPerf3Ne * $prize} *
        q!: * {$getPrizPastPresNe * $prizeWithoutMoney} *

        q!: * {$moneyAddPastPresNe * $prizeWithoutMoneyAll} *
        q!: * {$moneyAddPartPasNe * $prizeWithoutMoneyAll} *
        q!: * {$smsComePastPerfNe * $prizeWithoutMoneyAll} *
        q!: * {$smsComePastPerfNe * $moneyAndRub * $winPastPerf} *
        q!: * {$smsComePresNe * $prizeWithoutMoneyAll} *
        q!: * {$transferPastPresNe * $prizeWithoutMoneyAll} *
        q!: * куда * {$bonusDisappearPastPres * $prizeWithoutMoney} *
        q!: * куда * (ушли/$sendPartPas/$transferPast) * $prizeWithoutMoney *

        q!: * {~вывод * $prize * $error} *
        q!: * {$cantPastPresAll * ~вывод * $prize} *

        q!: * {$howLong * $moneyAddPastPres * $prizeWithoutMoney} *
        q!: * {$slowly * $moneyAddPastPres * $prizeWithoutMoney} *
        q!: * {$when * $moneyAddPastPres * $prizeWithoutMoney} *

        q!: * {$howLong * $bonusComePastPres * $prizeWithoutMoney} *
        q!: * {$slowly * $bonusComePastPres * $prizeWithoutMoney} *
        q!: * {$when * $bonusComePastPres * $prizeWithoutMoney} *

        q!: * {$howLong * $bonusComeFut * $prizeWithoutMoney} *
        q!: * {$when * $bonusComeFut * $prizeWithoutMoney} *
        q!: * {$howLong * $transferFut * $prizeWithoutMoney} *
        q!: * {$when * $transferFut * $prizeWithoutMoney} *

        q!: * {$transferPastPres * $prizeWithoutMoney} * $comWhere *
        q!: * {$sendPastPres * $prizeWithoutMoney} * $comWhere *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeWithoutMoney *
        q!: * $winPastPerf * {$comMoney $findPastPresNe} *
        q!: * $winPastPerf * {$onBalance * $bonusComePastPresNe} *
        q!: * $winPastPerf * {$onBill * $bonusComePastPresNe} *
        q!: * $problem * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoney *
        q!: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoney * $problem *
        q!: * {$bonusComePastPresNe * $prizeWithoutMoney * $onBillLoc} *
        q!: * {$bonusComePastPresNe * $prizeWithoutMoney * $onBalanceLoc} *
        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoney *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoney *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoney *
        q!: * сколько * $waitInf $prizeWithoutMoney *
        q!: * долго * длит* * ~выплата *
        q!: * $prizeWithoutMoney {$ne сразу $smsComePres $onBill}
        q!: * $winPastPerf * {$comMoney $displayPresSg3Ne} *
        q!: [$helloAll] {$ticket ($ne выплачен)}
        q!: [$helloAll] {$prizeLocal ($ne выплачен)}
        q!: * куда {вывел* $prizeWithoutMoney} *
        q!: * куда {вывел* $moneyAndRub} *
        q!: $transferImp * $prizeWithoutMoney $onBill

        eg!: Payments.ICantToTransferPrize
        a: Уточните, пожалуйста, у Вас не получается перевести выигрыш на Кошелек или из Кошелька на сторонние ресурсы?

        state: LocalCatchAll || fromState = /Payments/ICantToTransferPrize
            event: noMatch
            script: Webim.switch();


    state: HowToWithdrawMoneyToPurse
        # Как перевести выигрыш в Кошелек?
        q!: * $comWhat [$oneWord] перевести $toWallet *
        q!: * [$how] $getPrizInf $toWallet *
        q!: * {[$how] $getPrizInf $prizeWithoutMoneyAndWinTicket [$with $ticket] $toWallet} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $onBalance} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $onBalance} *
        q!: [$helloAll] {$sendInf $prizeWithoutMoneyAllAndWinTicket ([$comMy] $walletNom)}
        q!: [$helloAll] {$moneyAddInf $prizeWithoutMoneyAllAndWinTicket ([$comMy] $walletNom)}
        q!: [$helloAll] {$transferInfImp $prizeWithoutMoneyAllAndWinTicket ([$comMy] $walletNom)}

        q!: * {внести * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {добавить * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {оформить * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *

        q!: * {$getPrizInf $prizeWithoutMoney [$with $ticket] $toAccount} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAll * $toAccount} *
        q!: * {$sendInf * $prizeWithoutMoneyAll * $toAccount} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAll * $toAccount} *

        q!: * {$depositInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *

        q!: * $forTo * {$getPrizPastPres $prizeWithoutMoney $toWallet} *
        q!: * $forTo * {$transferPastPres $prizeWithoutMoney $toWallet} *
        q!: * $forTo * {$sendPastPres $prizeWithoutMoney $toWallet} *
        q!: * $forTo * {$moneyAddPastPres $prizeWithoutMoney $toWallet} *
        q!: * $forTo * {$getPrizPastPres $prizeWithoutMoney $toAccount} *
        q!: * $forTo * {$transferPastPres $prizeWithoutMoney $toAccount} *
        q!: * $forTo * {$sendPastPres $prizeWithoutMoney $toAccount} *
        q!: * $forTo * {$moneyAddPastPres $prizeWithoutMoney $toAccount} *

        q!: * {$getPrizInf $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {$transferInfImp $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {$sendInf $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {$moneyAddInf $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {внести $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {$depositInf $comMoney ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * {$withdrawInf $moneyAndRub $toWalletAll} *

        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) $prizeWithoutMoneyAndWinTicket [$with $ticket] $toWalletAll
        q!: * ($comWhat $comNeed/помож*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAndWinTicket * $toWalletAll *

        q: $toWalletAll || fromState = /Payments/HowToGetPrize
        q: в [$stoloto] || fromState = /Payments/HowToTransferPrize
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/HowToTransferPrize
        q: * $toWalletAll * || fromState = /Payments/HowToTransferPrize

        q: {[я] [$want] $prizeWithoutMoneyAndWinTicket $toWallet} || fromState = /Payments/HowToTransferTheMoney
        q: {[я] [$want] $prizeWithoutMoneyAndWinTicket [$toWallet]} || fromState = /Payments/HowToTransferTheMoneyToPurse
        q: {[я] [$want] перевести} || fromState = /Payments/HowToTransferTheMoneyToPurse

        eg!: Payments.HowToWithdrawMoneyToPurse
        a: Получить выигрыш Вы можете в Ваш Кошелек Столото. Для этого Вам необходимо зайти на страницу Вашей квитанции, нажав на ее номер в разделе «Мои билеты». Далее Вы увидите большую зеленую кнопку «Перевести выигрыш в Кошелек». Нажмите на нее, пожалуйста. Код выигрыша для получения выигрыша в Кошелек Столото не нужен. Пройдя по ссылке https://www.stoloto.ru/private/tickets/type/winners , Вы сможете увидеть Ваши выигрышные квитанции. Инструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации - по ссылке http://www.stoloto.ru/registration

        state: NotETicket
            # С бумажного билета
            # Билет куплен на почте
            q: * {бумажн* $ticket} *
            q: * {типографск* $ticket} *
            q: * $notETicket *
            q: * $retailPointOfSale *
            q: * терминал* *

            a: Билеты, купленные в точках продаж без указания номера телефона, в системе сайта отображаться не будут: нет электронной привязки.\n\nЕсли Вы приобретали билеты в точках продаж, то Ваш выигрыш Вы можете получить в той же точке продаж или в лотерейной сети «БалтЛото», на Почте России, в киоске. С адресами точек продаж и лимитами выплат ознакомьтесь, пожалуйста, по ссылке http://www.stoloto.ru/map


    state: CantWithdrawMoneyToPurse
        # Билет не вывести на кошелек
        q!: * {$getPrizInfNe * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll} *
        q!: * {$transferInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$sendInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$moneyAddInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        # Деньги не выслали на кошелек
        q!: * {$toWallet * $bonusComePastPresNe * $moneyAndRub * $lotteriesWithoutRL} *
        q!: * {$moneyAndRub * $bonusComePastPresNe * $toWalletAll * (за [$oneWord] $ticketRun)} *
        q!: * {$getPrizPastPresNe * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll} *
        q!: * {$getPrizPastPresNe * $moneyAndRub * $toWalletAll} *
        q!: * $prizeWithoutMoneyAllAndWinTicket * {$toWallet * ($ne переш*)} *
        q!: * {[$transferInfImp] * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$getPrizInf * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$moneyAndRub * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$transferPastPresNe * $ticketRun * $toWallet} *
        q!: * {[$moneyAndRub] * $sendPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$sendPastPresNe * $ticketRun * $toWallet} *
        q!: * {[$moneyAndRub] * $moneyAddPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$moneyAddPastPresNe * $ticketRun * $toWallet} *
        q!: * {($ne попал*) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {($ne попад*) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {непопал* * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {непопад* * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {непопал* * $ticketRun * $toWallet} *
        q!: * {непопад* * $ticketRun * $toWallet} *
        q!: * {($ne попал*) * $ticketRun * $toWallet} *
        q!: * {($ne попад*) * $ticketRun * $toWallet} *
        q!: * {($ne выгрузил*) * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {($ne выгрузил*) * $ticketRun * $toWallet} *

        q!: * $prizeWithoutMoneyAllAndWinTicket * $smsComePastPerfNe [$comMy] $walletNom
        q!: * $comWhere * $prizeWithoutMoneyAllAndWinTicket * {$findPastPresNe * $inWallet} *
        # Не получается перевести выигрыш в Кошелек
        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll} *
        q!: * {$cantPastPresAll * $getPrizInf * $moneyAndRub * $toWalletAll} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $transferInfImp * $lotteriesWithoutRL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $sendInf * $lotteriesWithoutRL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $lotteriesWithoutRL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $onBalance} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $onBalance} *
        q!: * {$cantPastPresAll * внести * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * добавить * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {$cantPastPresAll * оформить * $prizeWithoutMoneyAllAndWinTicket * $toWallet} *
        q!: * {$cantPastPresAll * $depositInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$uniqueKey * $cantPastPresAll * $transferInfImp * $toWalletAll} *
        q!: * {$uniqueKey * $cantPastPresAll * $sendInf * $toWalletAll} *
        q!: * {$uniqueKey * $cantPastPresAll * $moneyAddInf * $toWalletAll} *

        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll *
        q!: * {$howLong * $transferPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *
        q!: * {$howLong * $sendPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *
        q!: * {$howLong * $getPrizPresPlSg3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *
        q!: * {долго * $transferPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *
        q!: * {долго * $sendPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *
        q!: * {долго * $getPrizPresPlSg3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll} *

        q!: * {$cantPastPresAll * ~получение * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~вывод * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~перевод * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~отправка * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~обналичивание * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~выведение * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~выдача * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~начисление * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~зачисление * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$cantPastPresAll * ~выплата * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * {$produceNePresSg3 * ~выплата * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll} *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeWithoutMoney * $toWalletAll *

        q!: * $cantPastPresAll * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *

        q!: * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *$cantPastPresAll *
        q!: * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *

        # Пытаюсь получить выигрыш в кошелек, но возникает ошибка
        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $error} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $error} *
        q!: * {$getPrizInf * $moneyAndRub * $toWallet * $error} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWallet * $error} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error} *
        q!: * {$getPrizInf * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$getPrizPastPres * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$sendInf * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $error} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAll * $toAccount * $error} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * долго} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $howLong} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAll * $toAccount * долго} *

        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * $error} *
        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * $howLong} *
        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * долго} *
        q!: * {$withdrawalToPurse * $toWallet * $cantPastPresAll} *
        q!: * {$withdrawalToPurse * $toWallet * $bonusComePastPresNe} *
        q!: * {$workFut * $withdrawalToPurse * $toWallet} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * сложности} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата/~перечисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $delay} *

        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * сложности} *
        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * $delay} *
        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * $error} *

        q!: * {$toWallet * $bonusComePastPresFut * $prizeWithoutMoneyAllAndWinTicket * ($howLong/$when)} *

        q!: * {($ne (весь/вс*) [$sum] [$comMoney] [$with] $prizeLocal) * $bonusComePastPres * $toWalletAll}

        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $bonusComePastPresNe} *
        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $transferPastPresNe} *
        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $sendPastPresNe} *
        q!: * $getPrizInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $transferInfImp $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $sendInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $moneyAddInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * внести $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $depositInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe} *

        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $comWhere} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWalletAll * $comWhere} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere} *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zeroAdj} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zeroAdj} *
        q!: * {$getPrizInf * $moneyAndRub * $toWallet * $zeroAdj} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWallet * $zeroAdj} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj} *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zero} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zero} *
        q!: * {$getPrizInf * $moneyAndRub * $toWallet * $zero} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWallet * $zero} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *

        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero} *

        q!: * {$getPrizPastPres * $prizeWithoutMoneyAndWinTicket} но {$inWallet * $comNo} *

        q!: * пиш* * я получил* $prizeWithoutMoney *
        q!: * {$isWritten $prizeWithoutMoney $received} *
        q!: * {$prizeWithoutMoney * (написано * уже $receivePast)} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $zero} *
        q!: * {~статус * $received * $walletAll * $zero} *
        q!: * {написано * $received * $walletAll * $zero} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $zeroAdj} *
        q!: * {~статус * $received * $walletAll * $zeroAdj} *
        q!: * {написано * $received * $walletAll * $zeroAdj} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $comNo} *
        q!: * {~статус * $received * $walletAll * $comNo} *
        q!: * {написано * $received * $walletAll * $comNo} *

        q!: * {$prizeWithoutMoney * $received * ($comMoney $comNo)} *
        q!: * {~статус * $received * ($comMoney $comNo)} *
        q!: * {написано * $received * ($comMoney $comNo)} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $updatePresSg3Ne} *
        q!: * {~статус * $received * $walletAll * $updatePresSg3Ne} *
        q!: * {написано * $received * $walletAll * $updatePresSg3Ne} *

        q!: * {выведен* * $toWallet} * {$walletAll * $zero} *
        q!: * {выведен* * $toWallet} * {$walletAll * $comNo} *
        q!: * {выведен* * $toWallet} * {$walletAll * $nothing} *

        q!: * {$transferPartPas * $toWallet} * {$walletAll * $zero} *
        q!: * {$transferPartPas * $toWallet} * {$walletAll * $comNo} *
        q!: * {$transferPartPas * $toWallet} * {$walletAll * $nothing} *

        q!: * {выведен* * $toWallet * ($only (по/за) $oneWord $ticket)} *
        q!: * {$transferPartPas * $toWallet * ($only (по/за) $oneWord $ticket)} *

        q!: * {($prizeWithoutMoney/~статус/написано) * $received * ($inWallet/$comMoney) * $bonusComePastPresNe} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $onBalanceLoc * $bonusComePastPresNe} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * ($inWallet/$comMoney) * $addPastPlSg3Ne} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $onBalanceLoc * $addPastPlSg3Ne} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * ($inWallet/$onBalanceLoc) * $nothing *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $smsComePastPresNe} *
        q!: * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $smsComePastPresNe} * {($prizeWithoutMoney/~статус/написано) * $received} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $receivePastNe} *
        q!: * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $receivePastNe} * {($prizeWithoutMoney/~статус/написано) * $received} *

        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * (кем/куда) * $received *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * кем и куда *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} а (куда/где он) *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * (это $ne так/как было так и остал*/(в/на) какой $wallet) *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * {$walletAll * $depositPastPresNe} *

        q!: * {$prizeWithoutMoney * выплатил*} * (это $ne так/как было так и остал*) *
        q!: * {$receivedNe $prizeWithoutMoney} * ($prizeWithoutMoney/~статус/написано/пишет) * $received *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received} * $balance [остал*] $former *
        q!: * $isWritten * {$prizeWithoutMoneyAllAndWinTicket уже $received} *

        q!: * {$prizeWithoutMoney * $toWallet * $button * $activeNe} *
        q!: * {$prizeWithoutMoney * $toAccount * $button * $activeNe} *
        q!: * {$button * $getPrizInf * $toWallet * ~серый} *
        q!: * {$button * $transferInfImp * $toWallet * ~серый} *
        q!: * {$button * $sendInf * $toWallet * ~серый} *

        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * [$howLong]} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * $when} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * $moneyAndRub} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $inWallet * [$moneyAndRub]} *
        # выиграл 100 рублей, а на кошельке всего 80 рублей

        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * $inWallet $only ($numberRub/$Number) *
        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * $why $inWallet ($numberRub/$Number) *
        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * {$inWallet (их/его) $comNo} *
        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * $toWalletAll $bonusComePastPres $only ($numberRub/$Number) *
        q!: * $winPastPerf $numberRub * (а/но/однако/только [вот]) $bonusComePastPres $prizeLocal $numberRub *
        q!: * $prizeWithoutMoneyAll ($numberRub/$Number) (а/но/однако/только [вот]) выплатил* ($numberRub/$Number) *

        q!: * $prizeWithoutMoneyAll * $toWalletAll * {$comMoney $comNo} *

        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * {($inWallet/$toWalletAll) ($nothing/его/их/$prizeWithoutMoney/$comMoney/они/так и) $bonusComePastPresNe} *
        q!: * $prizeWithoutMoneyAll * [$moneyAndRub] * в $account {$comNo $prizeLocal} *
        q!: * {$prizeLocal $displayPresSg3Ne (в $account)} *
        q!: * {$prizeLocal $displayPresPl3Ne (в $account)} *

        q!: * {$when * $prizeWithoutMoneyAndWinTicket * (выведут/$transferFut/$sendFut) * $toWalletAll} *
        q!: * ($prizeLocal/$winPastPerf) * ($balance/сумм*) [в] $wallet ($changePastNe/остал* прежн*) *
        q!: * (после $prizeLocal $wallet пустой) *
        q!: * {$prizeWithoutMoneyAllAndWinTicket * $inWallet * $findPastPresNe} *
        q!: * $Number $winTicket * $bonusComePastPres $only $numberRub *
        q!: * долго * длит* * ~выплата * $toWalletAll *
        q!: * [$moneyAndRub] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] * в какой $wallet *
        q!: * в какой $wallet * [$moneyAndRub] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] *
        q!: * $isWritten * (выплачено/выплатил*) $numberRub *
        q!: * $winPastPerf * (нигде/ни где) их $findFut1Ne *
        q!: * $prizeWithoutMoneyAllAndWinTicket * статус * получен* *
        q!: * {$prizeLocal * $moneyAddPartPas * неверно} *

        q: в || fromState = /Payments/ThereIsNoGreenButton
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/ThereIsNoGreenButton
        q: * $toWalletAll * || fromState = /Payments/ThereIsNoGreenButton

        q: * {$transferPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize
        q: * {$sendPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize
        q: * {$moneyAddPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/WhereIsThePrize

        q: в || fromState = /Payments/ICantToTransferPrize
        q: [$comMy] $walletNom [$stoloto] || fromState = /Payments/ICantToTransferPrize
        q: * $toWalletAll * || fromState = /Payments/ICantToTransferPrize
        q: * {$transferPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddPastPres * $toWalletAll * [$bonusComePastPresNe]} * || fromState = /Payments/ICantToTransferPrize
        q: * {[$transferInfImp] * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferPrize

        q: * {[$here] $comNo $green $button} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * $button $toWalletAll $activeNe * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {($ne горит/негорит) $green} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {[$here] $findPastPresNe $green $button} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {[$prizeWithoutMoneyAllAndWinTicket] * $transferPastPresNe} * || fromState = /Payments/HowToWithdrawMoneyToPurse
        q: * {$moneyAndRub * $transferPastPresNe} * || fromState = /Payments/HowToWithdrawMoneyToPurse

        q: второе || fromState = /Payments/ICantToTransferTheMoney
        q: * {[$transferInfImp] * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet} * || fromState = /Payments/ICantToTransferTheMoney
        q: [$helloAll] [$transferInfImp] $toWallet || fromState = /Payments/ICantToTransferTheMoney

        q: второе || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$getPrizInf * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {[$transferInfImp] * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddPastPresNe * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$moneyAddPartPasNe * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$smsComePastPerfNe * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$smsComePresNe * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * [$toWallet]} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$helloAll] [$transferInfImp] $toWallet || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$helloAll] $transferInfImp || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * $lotteriesWithoutRL * || fromState = /Payments/ICantToTransferTheMoneyToPurse

        eg!: Payments.CantWithdrawMoneyToPurse
        if: $global.withdrawalToPurseIsAvailable
            a: Если у Вас возникли проблемы с переводом выигрыша в Кошелек, уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.
        else:
            a: Мы уже работаем над выяснением причины этой проблемы. Как только будет получена актуальная информация, специалисты займутся устранением проблемы. Вы можете посмотреть свой баланс в ближайшее время.

        state: GetNumber || fromState = /Payments/CantWithdrawMoneyToPurse
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: CantWithdrawMoneyToPurseRusLoto
        # Не могу получить выигрыш в Кошелек (стейт только для Русского лото)
        # Билет не вывести на кошелек
        q!: * {$getPrizInfNe * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $RL} *
        q!: * {$transferInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$sendInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$moneyAddInfNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        # Деньги не выслали на кошелек
        q!: * {$toWallet * $bonusComePastPresNe * $moneyAndRub * $RL} *
        q!: * {$moneyAndRub * $bonusComePastPresNe * $toWalletAll * (за [$oneWord] $ticketRun) * $RL} *
        q!: * {$getPrizPastPresNe * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $RL} *
        q!: * {$getPrizPastPresNe * $moneyAndRub * $toWalletAll * $RL} *
        q!: * {$prizeWithoutMoneyAllAndWinTicket * $RL} * {$toWallet * ($ne переш*)} *
        q!: * {[$transferInfImp] * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$getPrizInf * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$moneyAndRub * $transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$transferPastPresNe * $ticketRun * $toWallet * $RL} *
        q!: * {[$moneyAndRub] * $sendPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$sendPastPresNe * $ticketRun * $toWallet * $RL} *
        q!: * {[$moneyAndRub] * $moneyAddPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$moneyAddPastPresNe * $ticketRun * $toWallet * $RL} *
        q!: * {($ne попал*) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {($ne попад*) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {непопал* * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {непопад* * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {непопал* * $ticketRun * $toWallet * $RL} *
        q!: * {непопад* * $ticketRun * $toWallet * $RL} *
        q!: * {($ne попал*) * $ticketRun * $toWallet * $RL} *
        q!: * {($ne попад*) * $ticketRun * $toWallet * $RL} *
        q!: * $comWhere * $prizeWithoutMoneyAllAndWinTicket * $RL * {$findPastPresNe * $inWallet} *
        q!: * {($ne выгрузил*) * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $RL} *
        q!: * {($ne выгрузил*) * $ticketRun * $toWallet * $RL} *

        # Не получается перевести выигрыш в Кошелек
        q!: * {$cantPastPresAll * $getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * $getPrizInf * $moneyAndRub * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $transferInfImp * $RL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $sendInf * $RL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $RL * $toWallet * [$moneyAndRub]} *
        q!: * {$cantPastPresAll * $moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $onBalance * $RL} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $onBalance * $RL} *
        q!: * {$cantPastPresAll * внести * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * добавить * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $RL} *
        q!: * {$cantPastPresAll * оформить * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $RL} *
        q!: * {$cantPastPresAll * $depositInf * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$uniqueKey * $cantPastPresAll * $transferInfImp * $toWalletAll * $RL} *
        q!: * {$uniqueKey * $cantPastPresAll * $sendInf * $toWalletAll * $RL} *
        q!: * {$uniqueKey * $cantPastPresAll * $moneyAddInf * $toWalletAll * $RL} *

        q!: * $howLong * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL *
        q!: * $when * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL *
        q!: * $waitInf * (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL *
        q!: * {$howLong * $transferPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *
        q!: * {$howLong * $sendPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *
        q!: * {$howLong * $getPrizPresPlSg3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *
        q!: * {долго * $transferPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *
        q!: * {долго * $sendPres3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *
        q!: * {долго * $getPrizPresPlSg3 * $prizeWithoutMoneyAllAndWinTicket $toWalletAll * $RL} *

        q!: * {$cantPastPresAll * ~получение * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~вывод * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~перевод * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~отправка * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~обналичивание * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~выведение * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~выдача * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~начисление * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~зачисление * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$cantPastPresAll * ~выплата * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * {$produceNePresSg3 * ~выплата * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $RL} *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeWithoutMoney * $toWalletAll * $RL *

        q!: * $RL * $cantPastPresAll * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *
        q!: * $RL * $cantPastPresAll * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *
        q!: * $RL * $cantPastPresAll * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *
        q!: * $RL * $cantPastPresAll * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *
        q!: * $RL * $cantPastPresAll * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *
        q!: * $RL * $cantPastPresAll * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} *
        q!: * $cantPastPresAll * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $RL *

        q!: * $RL * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$getPrizInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *
        q!: * $RL * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$transferInfImp $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *
        q!: * $RL * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$sendInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *
        q!: * $RL * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$moneyAddInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *
        q!: * $RL * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {внести $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *
        q!: * $RL * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll *
        q!: * {$depositInf $moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll} * $cantPastPresAll * $RL *

        # Пытаюсь получить выигрыш в кошелек, но возникает ошибка
        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $error * $RL} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $error * $RL} *
        q!: * {$getPrizInf * $moneyAndRub * $toWallet * $error * $RL} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWallet * $error * $RL} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $error * $RL} *
        q!: * {$getPrizInf * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$getPrizPastPres * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$sendInf * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $error * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAll * $toAccount * $error * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * долго * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $howLong * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAll * $toAccount * долго * $RL} *

        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * $error * $RL} *
        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * $howLong * $RL} *
        q!: * {$withdrawalToPurse * $comMoney * $toWalletAll * долго * $RL} *
        q!: * {$withdrawalToPurse * $toWallet * $cantPastPresAll * $RL} *
        q!: * {$withdrawalToPurse * $toWallet * $bonusComePastPresNe * $RL} *
        q!: * {$workFut * $withdrawalToPurse * $toWallet * $RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата/~перечисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * сложности * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~начисление/~зачисление/~выплата/~перечисление) * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $delay * $RL} *

        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * сложности * $RL} *
        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * $delay * $RL} *
        q!: * {(~начисление/~зачисление/~выплата) * $prizeWithoutMoneyAllAndWinTicket * $onW1 * $error * $RL} *

        q!: * {$toWallet * $bonusComePastPresFut * $prizeWithoutMoneyAllAndWinTicket * ($howLong/$when) * $RL} *

        q!: * {($ne (весь/вс*) [$sum] [$comMoney] [$with] $prizeLocal) * $bonusComePastPres * $toWalletAll * $RL}

        q!: * $RL * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $bonusComePastPresNe} *
        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $bonusComePastPresNe} * $RL *
        q!: * $RL * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $transferPastPresNe} *
        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $transferPastPresNe} * $RL *
        q!: * $RL * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $sendPastPresNe} *
        q!: * {$moneyAndRub ([вот] ($with/от) [$oneWord] [вот] $ticketGen) $toWalletAll $sendPastPresNe} * $RL *

        q!: * $RL * $getPrizInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $getPrizInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *
        q!: * $RL * $transferInfImp $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $transferInfImp $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *
        q!: * $RL * $sendInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $sendInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *
        q!: * $RL * $moneyAddInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $moneyAddInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *
        q!: * $RL * внести $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * внести $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *
        q!: * $RL * $depositInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error *
        q!: * $depositInf $moneyAndRub ($with/от) [$oneWord] $ticketGen $toWalletAll * $error * $RL *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $bonusComePastPresNe * $RL} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $bonusComePastPresNe * $RL} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWalletAll * $bonusComePastPresNe * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $bonusComePastPresNe * $RL} *

        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWalletAll * $comWhere * $RL} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWalletAll * $comWhere * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWalletAll * $comWhere * $RL} *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zeroAdj * $RL} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zeroAdj * $RL} *
        q!: * {$getPrizInf * $moneyAndRub * $toWallet * $zeroAdj * $RL} *
        q!: * {$getPrizPastPres * $moneyAndRub * $toWallet * $zeroAdj * $RL} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *
        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zeroAdj * $RL} *

        q!: * {$getPrizInf * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zero * $RL} *
        q!: * {$getPrizPastPres * [$prizeWithoutMoneyAndWinTicket] * $toWallet * $zero * $RL} *
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *
        q!: * {$transferPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *
        q!: * {$sendPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *

        q!: * {$moneyAddInf * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *
        q!: * {$moneyAddPastPres * $prizeWithoutMoneyAllAndWinTicket * $toWallet * $zero * $RL} *

        q!: * {$getPrizPastPres * $RL * $prizeWithoutMoneyAndWinTicket} но {$inWallet * $comNo} *

        q!: * {(пиш* * я получил* $prizeWithoutMoney) * $RL} *
        q!: * {($isWritten $prizeWithoutMoney $received) * $RL} *
        q!: * {$prizeWithoutMoney * (написано * уже $receivePast) * $RL} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $zero * $RL} *
        q!: * {~статус * $received * $walletAll * $zero * $RL} *
        q!: * {написано * $received * $walletAll * $zero * $RL} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $zeroAdj * $RL} *
        q!: * {~статус * $received * $walletAll * $zeroAdj * $RL} *
        q!: * {написано * $received * $walletAll * $zeroAdj * $RL} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $comNo * $RL} *
        q!: * {~статус * $received * $walletAll * $comNo * $RL} *
        q!: * {написано * $received * $walletAll * $comNo * $RL} *

        q!: * {$prizeWithoutMoney * $received * ($comMoney $comNo) * $RL} *
        q!: * {~статус * $received * ($comMoney $comNo) * $RL} *
        q!: * {написано * $received * ($comMoney $comNo) * $RL} *

        q!: * {$prizeWithoutMoney * $received * $walletAll * $updatePresSg3Ne * $RL} *
        q!: * {~статус * $received * $walletAll * $updatePresSg3Ne * $RL} *
        q!: * {написано * $received * $walletAll * $updatePresSg3Ne * $RL} *

        q!: * {выведен* * $toWallet * $RL} * {$walletAll * $zero} *
        q!: * {выведен* * $toWallet * $RL} * {$walletAll * $comNo} *
        q!: * {выведен* * $toWallet * $RL} * {$walletAll * $nothing} *

        q!: * {$transferPartPas * $toWallet * $RL} * {$walletAll * $zero} *
        q!: * {$transferPartPas * $toWallet * $RL} * {$walletAll * $comNo} *
        q!: * {$transferPartPas * $toWallet * $RL} * {$walletAll * $nothing} *

        q!: * {выведен* * $toWallet * ($only (по/за) $oneWord $ticket) * $RL} *
        q!: * {$transferPartPas * $toWallet * ($only (по/за) $oneWord $ticket) * $RL} *

        q!: * {($prizeWithoutMoney/~статус/написано) * $received * ($inWallet/$comMoney) * $bonusComePastPresNe * $RL} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $onBalanceLoc * $bonusComePastPresNe * $RL} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * ($inWallet/$comMoney) * $addPastPlSg3Ne * $RL} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $onBalanceLoc * $addPastPlSg3Ne * $RL} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $smsComePastPresNe} *
        q!: * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $smsComePastPresNe} * {($prizeWithoutMoney/~статус/написано) * $received * $RL} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * ($inWallet/$onBalanceLoc) * $nothing *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $receivePastNe} *
        q!: * {($nothing/его/их/$prizeWithoutMoney/$comMoney) * $receivePastNe} * {($prizeWithoutMoney/~статус/написано) * $received * $RL} *

        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * (кем/куда) * $received *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * кем и куда *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} а (куда/где он) *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * (это $ne так/как было так и остал*/(в/на) какой $wallet) *
        q!: * {$prizeWithoutMoney * выплатил* * $RL} * (это $ne так/как было так и остал*/(в/на) какой $wallet) *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * {$balance * $depositPastPresNe} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * {$wallet * $depositPastPresNe} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * {~счет * $depositPastPresNe} *
        q!: * {($prizeWithoutMoney/~статус/написано) * $received * $RL} * $balance [остал*] $former *
        q!: * $RL * {$receivedNe $prizeWithoutMoney} * ($prizeWithoutMoney/~статус/написано/пишет) * $received *
        q!: * {$receivedNe $prizeWithoutMoney} * ($prizeWithoutMoney/~статус/написано/пишет) * $received * $RL *
        q!: * $RL * $isWritten * {$prizeWithoutMoneyAllAndWinTicket уже $received} *

        q!: * {$prizeWithoutMoney * $toWallet * $button * $activeNe * $RL} *
        q!: * {$prizeWithoutMoney * $toAccount * $button * $activeNe * $RL} *
        q!: * {$button * $getPrizInf * $toWallet * ~серый * $RL} *
        q!: * {$button * $transferInfImp * $toWallet * ~серый * $RL} *
        q!: * {$button * $sendInf * $toWallet * ~серый * $RL} *

        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * [$howLong] * $RL} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * $when * $RL} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $toWallet * $moneyAndRub * $RL} *
        q!: * {$prizeWithoutMoneyAll * $bonusComePastPresNe * $inWallet * [$moneyAndRub] * $RL} *
        # выиграл 100 рублей, а на кошельке всего 80 рублей

        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * $inWallet $only ($numberRub/$Number) *
        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * $why $inWallet ($numberRub/$Number) *
        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * {$inWallet (их/его) $comNo} *
        q!: * {$RL * $prizeWithoutMoneyAll} * $toWalletAll * {$comMoney $comNo} *
        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * $toWalletAll $bonusComePastPres $only ($numberRub/$Number) *
        q!: * $RL * $winPastPerf $numberRub * (а/но/однако/только [вот]) $bonusComePastPres $prizeLocal $numberRub *
        q!: * $RL * $prizeWithoutMoneyAll ($numberRub/$Number) (а/но/однако/только [вот]) выплатил* ($numberRub/$Number) *

        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * {($inWallet/$toWalletAll) ($nothing/его/их/$prizeWithoutMoney/$comMoney/они/так и) $bonusComePastPresNe} *
        q!: * {$RL * $prizeWithoutMoneyAll} * [$moneyAndRub] * в $account {$comNo $prizeLocal} *

        q!: * $RL * {$prizeLocal $displayPresSg3Ne (в $account)} *
        q!: * {$prizeLocal $displayPresSg3Ne (в $account)} * $RL *
        q!: * $RL * {$prizeLocal $displayPresPl3Ne (в $account)} *
        q!: * {$prizeLocal $displayPresPl3Ne (в $account)} * $RL *

        q!: * {$when * $prizeWithoutMoneyAndWinTicket * (выведут/$transferFut/$sendFut) * $toWalletAll * $RL} *
        q!: * {$RL * ($prizeLocal/$winPastPerf)} * ($balance/сумм*) [в] $wallet ($changePastNe/остал* прежн*) *
        q!: * ($prizeLocal/$winPastPerf) * ($balance/сумм*) [в] $wallet ($changePastNe/остал* прежн*) * $RL *
        q!: * {(после $prizeLocal $wallet пустой) * $RL} *
        q!: * {$prizeWithoutMoneyAllAndWinTicket * $inWallet * $findPastPresNe * $RL} *
        q!: * {($Number $winTicket) * $RL} * $bonusComePastPres $only $numberRub *
        q!: * долго * длит* * ~выплата * $toWalletAll * $RL *
        q!: * $RL * [$moneyAndRub] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] * в какой $wallet *
        q!: * в какой $wallet * [$moneyAndRub] * ($moneyTakeOffPastPres/$transferPastPres/$sendPastPres) * [$moneyAndRub] * $RL *
        q!: * $isWritten * (выплачено/выплатил*) $numberRub * $RL *
        q!: * $RL * $isWritten * (выплачено/выплатил*) $numberRub *
        q!: * {$winPastPerf * $RL} * (нигде/ни где) их $findFut1Ne *
        q!: * {$prizeWithoutMoneyAllAndWinTicket * $RL} * статус * получен* *
        q!: * {$prizeLocal * $moneyAddPartPas * неверно * $RL} *

        q: * $RL * || fromState = /Payments/ICantToTransferTheMoneyToPurse

        eg!: Payments.CantWithdrawMoneyToPurseRusLoto
        if: $global.withdrawalRLToPurseIsAvailable
            a: Если у Вас возникли проблемы с переводом выигрыша в Кошелек, уточните, пожалуйста, уникальный ключ квитанции. Уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня начисление выигрышей может проходить с задержкой. Наши специалисты уже работают над этим. Выигрыш будет зачислен на Ваш баланс в ближайшее время.

        state: GetNumber || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


    state: HowToTransferMoneyToNewPurse
        # Как перевести деньги в новый кошелек
        q!: * {$transferInfImp * $prizeWithoutMoney * $toNewWalletAll} *
        q!: * {$transferInfImp * $moneyAndRub * $toNewWalletAll} *
        q!: * {$sendInf * $prizeWithoutMoney * $toNewWalletAll} *
        q!: * {$sendInf * $moneyAndRub * $toNewWalletAll} *
        q!: * {вывести * $prizeWithoutMoney * $toNewWalletAll} *
        q!: * {вывести * $moneyAndRub * $toNewWalletAll} *
        q!: * {$transferInfImp * [$prizeWithoutMoney] * ((из/со) старого * новый)} *
        q!: * {$transferInfImp * $moneyAndRub * ((из/со) старого * новый)} *
        q!: * {$sendInf * [$prizeWithoutMoney] * ((из/со) старого * новый)} *
        q!: * {$sendInf * $moneyAndRub * ((из/со) старого * новый)} *
        q!: * {$transferInfImp * [$prizeWithoutMoney] * ((из/$with) одного * другой)} *
        q!: * {$transferInfImp * $moneyAndRub * ((из/$with) одного * другой)} *
        q!: * {$sendInf * [$prizeWithoutMoney] * ((из/$with) одного * другой)} *
        q!: * {$sendInf * $moneyAndRub * ((из/$with) одного * другой)} *
        q!: * {$transferInfImp * $prizeWithoutMoney * (из старой $registration)} *
        q!: * {$transferInfImp * $moneyAndRub * (из старой $registration)} *
        eg!: Payments.HowToTransferMoneyToNewPurse
        a: Для перевода денежных средств из одного личного кабинета в другой необходимо, чтобы оба кабинета были идентифицированы.\n\nПройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nЕсли у Вас пройдена идентификация, то направьте, пожалуйста, на почту info@stoloto.ru следующие документы:\n- скан Вашего паспорта (страница с фото);\n- договор с оператором сотовой связи на Ваш старый номер телефона (можно запросить у оператора);\n- договор с оператором сотовой связи на Ваш новый номер телефона (можно запросить у оператора);\n- заявление в свободной форме о переводе денежных средств из старого кабинета в новый (написано от руки и отсканировано или сфотографировано).\n\nПример заявления:\n\nЯ, (ФИО в именительном падеже), (дата рождения), проживающая по адресу (адрес с индексом), (номер телефона), являюсь зарегистрированным пользователем на Вашем сайте www.stoloto.ru (указываете логин, почту и номер телефона от личного кабинета нашего сайта). На 01.11.2014 (дату заявления ставите) на счете Кошелька Столото № (номер Кошелька вышеуказанного кабинета) данного личного кабинета находятся (указываете баланс Кошелька) рублей. К сожалению, данными средствами нет возможности воспользоваться, номер телефона (указываете номер телефона от личного кабинета) более не работоспособен. Прошу помочь в разрешении данной ситуации. Прошу осуществить перевод средств из моего старого Кошелька Столото № (номер Кошелька вышеуказанного кабинета) в мой новый Кошелек Столото № (номер нового Кошелька нового кабинета) личного кабинета (указываете логин, почту и номер телефона от нового личного кабинета нашего сайта), где номер телефона работоспособен и я могу ими воспользоваться.\n(ниже дату, подпись и расшифровку подписи).\n\nВ случае, если у Вас нет возможности предоставить договор с оператором связи, то Вам необходимо пройти полную идентификацию с помощью скайпа в двух личных кабинетах. Пройти идентификацию Вы можете, находясь на странице с информацией, по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто необходимо нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.\n\nНаправьте, пожалуйста, комплект документов на электронную почту info@stoloto.ru. В теме письма укажите «Перевод средств».


    state: HowToWithdrawMoney
        # Как вывести выигрыш из Кошелька?
        q!: * {$cashoutInf * $wallet} *
        q!: * {$cashoutInf * $prize} *
        q!: * {$cashoutInf * $fromWallet} *

        q!: [$helloAll] {[$how] $prizeWithoutMoney $onExternalResource}
        q!: [$helloAll] [$beginningWords] {$how $fromWallet $onExternalResource}
        q!: [$helloAll] [$beginningWords] $possiblePredic [~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата] $onExternalResource
        q!: * {$appendInf * $onExternalResource} *

        q!: * {$prize $how $getPrizPresPlSg3} *
        q!: * $how * $getPrizPresPlSg3 * $prize *

        q!: * [$how] * {$getPrizInf * [$prize] * $fromWallet} *
        q!: * [$how] * {$getPrizInf * [$prize] * $onExternalResource} *
        q!: * {$withdrawInf * [$prize] * $fromAccount} *

        q!: * {$transferInfImp * [$prize] * $fromWallet} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource} *
        q!: [$helloAll] [$how] {$transferInfImp [$prize] (на тел)}
        q!: * {$transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$sendInf * [$prize] * $fromWallet} *
        q!: * {$sendInf * [$prize] * $onExternalResource} *
        q!: [$helloAll] [$how] {$sendInf [$prize] (на тел)}
        q!: * {$sendInf * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$moneyAddInf * [$prize] * $onExternalResource} *
        q!: [$helloAll] [$how] {$moneyAddInf [$prize] (на тел)}
        q!: * {$depositInf * [$prize] * $onExternalResource} *
        q!: [$helloAll] [$how] {$depositInf [$prize] (на тел)}
        q!: * {оформить * $prizeWithoutMoneyAllAndWinTicket * $onExternalResource} *

        q!: * $prizeWithoutMoney * ($payment ($telephone/моб* связи)) *
        q!: * {$fromWallet * ($payInf [за] моб* связь)} *
        # Хочу чтобы выигрыш переводился на телефон
        q!: * $forTo * {$getPrizPastPres * [$prize] * $onExternalResource} *
        q!: * $forTo * {$transferPastPres * [$prize] * $onExternalResource} *
        q!: * $forTo * {$sendPastPres * [$prize] * $onExternalResource} *
        q!: * $forTo * {$moneyAddPastPres * [$prize] * $onExternalResource} *
        q!: * $forTo * {$smsComePast * [$prize] * $onExternalResource} *
        q!: * $forTo * $prize * $onExternalResource *
        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) $onExternalResource [$comMy] $prize
        q!: * {$how * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *
        q!: [$helloAll] (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) $fromWallet [$comMy] $prize
        q!: * {$how * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *
        q!: * $comWhat $comNeed * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * $comWhat $comNeed * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * (помоч*/помог*) $with (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * (помоч*/помог*) $with (~получение/~вывод/~перевод/~отправка/~обналичивание/~выведение/~выдача/~выплата) * $fromWallet *
        # Выигрыш в Кошельке, как оттуда вывести
        q!: * ($prizeWithoutMoney $inWallet/$toWalletAll) * {($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * {[$toWalletAll] * $fromExternalResource} * {обратно * $getPrizInf} *
        q!: * {$inWallet $prizeWithoutMoney} * $how * $getPrizInf *
        q!: * {$inWallet $numberRub} * $how * $getPrizInf *

        q!: * {($getPrizInf/$transferInfImp) [$comMy] $prizeWithoutMoney} (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *
        q!: * $getPrizInf $prizeWithoutMoney (~переведенный/~выведенный/~отправленный/~перечисленный) $toWalletAll *
        q!: * ($getPrizPastPres/$sendPastPerf/$moneyAddPastPres/$transferPastPres) * $toWallet * {дальше $how получить} *

        q!: * {$mistakenly $depositPastPres} ($wallet/$toWalletAll/$w1/$onW1) * $how отозвать *

        q: $fromWallet || fromState = /Payments/HowToGetPrize
        q: $onExternalResource [$ne $toWalletAll] || fromState = /Payments/HowToGetPrize

        q: из || fromState = /Payments/HowToTransferPrize
        q: * $fromWallet * || fromState = /Payments/HowToTransferPrize
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/HowToTransferPrize
        q: $externalResource || fromState = /Payments/HowToTransferPrize
        q: [на] (сторонний/сторонние) || fromState = /Payments/HowToTransferPrize
        q: на ресурсы || fromState = /Payments/HowToTransferPrize
        q: * (со/из) $stoloto * || fromState = /Payments/HowToTransferPrize
        q: * с сайта * || fromState = /Payments/HowToTransferPrize

        q: из || fromState = /Payments/HowToTransferTheMoney
        q: * $fromWallet * || fromState = /Payments/HowToTransferTheMoney
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/HowToTransferTheMoney
        q: $externalResource || fromState = /Payments/HowToTransferTheMoney
        q: [на] (сторонний/сторонние) || fromState = /Payments/HowToTransferTheMoney
        q: на ресурсы || fromState = /Payments/HowToTransferTheMoney
        q: * (со/из) $stoloto * || fromState = /Payments/HowToTransferTheMoney
        q: * с сайта * || fromState = /Payments/HowToTransferTheMoney

        eg!: Payments.HowToWithdrawMoney
        a: Перевести из Кошелька Столото возможно только выигранные деньги, через основную или мобильную версию сайта www.stoloto.ru (вход осуществляется через браузер). Выполнить данную процедуру через мобильное приложение невозможно. Для того, чтобы перевести денежные средства из Кошелька Столото, в личном кабинете в разделе «Кошелек» нажмите, пожалуйста, зеленую кнопку «Перевести». Далее Вам нужно получить платежный пароль, нажав на кнопку запроса. Пароль поступит на тот номер телефона, который был указан в Вашем личном кабинете. Введите, пожалуйста, код, полученный в sms, в соответствующее поле. Далее нажмите кнопку «Подтвердить». У Вас откроются все варианты для перевода средств из Кошелька, и Вы сможете выбрать нужный Вам.


    state: WithdrawDoesntWork
        # Не могу обналичить кошелек (кроме Русского лото)
        q!: * {$cantPastPresAll * $cashoutInf * $wallet} *
        q!: * {$cantPastPresAll * $cashoutInf * $prize} *

        q!: * {$cantPastPresAll * $cashoutInf * $fromWallet} *
        q!: * {$cantPastPresAll * $cashoutInf * $fromAccount} *
        q!: * {$cantPastPresAll * $withdrawInf * $fromAccount} *
        q!: * ($ne вывести/невывести/нивывести) * $fromAccount *
        q!: * $fromAccount * ($ne вывести/невывести/нивывести) *

        q!: * {$cantPastPresAll * $getPrizInf * [$prize] * $fromWallet} *
        q!: * {$cantPastPresAll * $getPrizInf * [$prize] * $onExternalResource} *

        q!: * {$cantPastPresAll * $appendInf * $onExternalResource} *

        q!: * {$cantPastPresAll * $transferInfImp * [$prize] * $fromWallet} *
        q!: * {$cantPastPresAll * $transferInfImp * [$prize] * $onExternalResource} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$cantPastPresAll * $sendInf * [$prize] * $fromWallet} *
        q!: * {$cantPastPresAll * $sendInf * [$prize] * $onExternalResource} *
        q!: * {$cantPastPresAll * $sendInf * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$cantPastPresAll * $moneyAddInf * [$prize] * $onExternalResource} *
        q!: * {$cantPastPresAll * $depositInf * [$prize] * $onExternalResource} *
        q!: * {$cantPastPresAll * оформить * $prizeWithoutMoneyAllAndWinTicket * $onExternalResource} *

        q!: * $cantPastPresAll * $prizeWithoutMoney * ($payment $telephone) *

        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *
        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeWithoutMoney * $onExternalResource *

        # Не обналичивается кошелек
        q!: * {$cashoutPastPresNe * $wallet} *
        q!: * {$cashoutPastPresNe * $prize} *
        q!: * {$cashoutPastPresNe * $fromWallet} *

        q!: * {$getPrizPastPresNe * [$prize] * $fromWallet} *
        q!: * {$getPrizPastPresNe * [$prize] * $onExternalResource} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromWallet} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $onExternalResource} *
        q!: * {$withdrawPres3Ne * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromAccount} *

        q!: * {$transferPastPresNe * [$prize] * $fromWallet} *
        q!: * {$transferPastPresNe * [$prize] * $onExternalResource} *
        q!: * {$transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$sendPastPresNe * [$prize] * $fromWallet} *
        q!: * {$sendPastPresNe * [$prize] * $onExternalResource} *
        q!: * {$sendPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $fromAccount} *

        q!: * {$moneyAddPastPresNe * [$prize] * $onExternalResource} *

        # Перевел средства из Кошелька Столото, не поступили
        q!: * {$cashoutPastPres * $wallet * $bonusComePastPresNe} *
        q!: * {$cashoutPastPres * $prize * $bonusComePastPresNe} *

        q!: * {$moneyTakeOffPastPres * $fromWallet} * {$prize * $bonusComePastPresNe} *

        q!: * {$getPrizPastPres * [$prize] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$transferPastPres * [$prize] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$sendPastPres * [$prize] * $fromWallet * $bonusComePastPresNe} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe} *

        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe} *
        q!: * {($comMoney/$rub) * $onExternalResource * $bonusComePastPresNe} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * сложности} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * сложности} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $delay} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $delay} *
        # Обналичил кошелек где деньги
        q!: * {$cashoutPastPres * $wallet * $comWhere * $prize} *

        q!: * {$getPrizPastPres * $fromWallet * $comWhere * [$prize]} *
        q!: * {$transferPastPres * $fromWallet * $comWhere * [$prize]} *
        q!: * {$sendPastPres * $fromWallet * $comWhere * [$prize]} *

        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $comWhere} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $comWhere} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $comWhere} *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $comWhere} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $comWhere} *

        q!: * {$transferPastPres * [$prize] * $onExternalResource} * $when *
        q!: * {$sendPastPres * [$prize] * $onExternalResource} * $when *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource} * $when *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource} * $when *
        q!: * {$depositPastPres * [$prize] * $onExternalResource} * $when *

        q!: * {$transferPastPres * [$prize] * $onExternalResource} * $comNo *
        q!: * {$sendPastPres * [$prize] * $onExternalResource} * $comNo *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource} * $comNo *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource} * $comNo *
        q!: * {$depositPastPres * [$prize] * $onExternalResource} * $comNo *

        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $error} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $error} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $error} *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $error} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $error} *

        q!: * {$getPrizPastPres * [$prize] * $fromWallet * $error} *
        q!: * {$transferPastPres * [$prize] * $fromWallet * $error} *
        q!: * {$sendPastPres * [$prize] * $fromWallet * $error} *
        q!: * {$moneyAddPastPres * [$prize] * $fromWallet * $error} *
        q!: * {$depositPastPres * [$prize] * $fromWallet * $error} *

        q!: * {$cashoutInf * $wallet * $error} *
        q!: * {$cashoutInf * $prize * $error} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $error} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $error} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $error} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $error} *
        q!: * {$sendInf * [$prize] * $fromWallet * $error} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $error} *
        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $error} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $error} *

        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *
        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet} *

        q!: * {$onExternalResource * $bonusComePastPresFut * $prize * ($howLong/$when)} *
        q!: * {$prizeWithoutMoney * $bonusComePastPresNe * $onExternalResource} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $fromWallet} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $onExternalResource} *
        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $fromWallet} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $fromWallet} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $fromWallet} *
        q!: * {$when * $transferFut * $moneyAndRub * $fromWallet} *
        q!: * $onExternalResource * $bonusComePastPres $Number *

        q!: * {~время * $prize * $onExternalResource} *
        q!: * $getPrizPastPres * [$prize] * $onExternalResource * (как (быстро/долго)/в течени*) *
        q!: * {(как (быстро/долго)/в течени*/~время) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $comWhere} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($ne (весь/все) $prize) * $fromWallet * $bonusComePastPres} *
        q!: * {$onExternalResource * ($ne (весь/все) $prize) * $bonusComePastPres} *

        q!: * $prizeWithoutMoney $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * {$cantPastPresAll ($getPrizInf/$transferInfImp) [$comMy] $prizeWithoutMoney} (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *

        q!: * долго * длит* * ~выплата * $fromWallet *
        q!: * долго * длит* * ~выплата * $onExternalResource *

        q: из || fromState = /Payments/ICantToTransferPrize
        q: * $fromWallet * || fromState = /Payments/ICantToTransferPrize
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/ICantToTransferPrize
        q: $externalResource || fromState = /Payments/ICantToTransferPrize
        q: [на] (сторонний/сторонние) || fromState = /Payments/ICantToTransferPrize
        q: на ресурсы || fromState = /Payments/ICantToTransferPrize
        q: * {$transferInfImp * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * {$sendInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * {$moneyAddInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferPrize
        q: * (со/из) $stoloto * || fromState = /Payments/ICantToTransferPrize
        q: * с сайта * || fromState = /Payments/ICantToTransferPrize

        q: (третье/последнее) || fromState = /Payments/ICantToTransferTheMoney
        q: из || fromState = /Payments/ICantToTransferTheMoney
        q: * $fromWallet * || fromState = /Payments/ICantToTransferTheMoney
        q: * $onExternalResource * || fromState = /Payments/ICantToTransferTheMoney
        q: $externalResource || fromState = /Payments/ICantToTransferTheMoney
        q: [на] (сторонний/сторонние) || fromState = /Payments/ICantToTransferTheMoney
        q: на ресурсы || fromState = /Payments/ICantToTransferTheMoney
        q: * (со/из) $stoloto * || fromState = /Payments/ICantToTransferTheMoney
        q: * с сайта * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$transferInfImp * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$sendInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney
        q: * {$moneyAddInf * ($fromWallet/$onExternalResource)} * || fromState = /Payments/ICantToTransferTheMoney

        eg!: Payments.WithdrawDoesntWork
        a: По вопросам перевода средств из Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.


    state: WithdrawDoesntWorkRusLoto
        # Не могу обналичить кошелек (стейт только для Русского лото)
        q!: * {$cantPastPresAll * $cashoutInf * $wallet * $RL} *
        q!: * {$cantPastPresAll * $cashoutInf * $prize * $RL} *

        q!: * {$cantPastPresAll * $cashoutInf * $fromWallet * $RL} *
        q!: * {$cantPastPresAll * $cashoutInf * $fromAccount * $RL} *
        q!: * {$cantPastPresAll * $withdrawInf * $fromAccount * $RL} *
        q!: * {($ne вывести/невывести/нивывести) * $fromAccount * $RL} *

        q!: * {$cantPastPresAll * $getPrizInf * [$prize] * $fromWallet * $RL} *
        q!: * {$cantPastPresAll * $getPrizInf * [$prize] * $onExternalResource * $RL} *

        q!: * {$cantPastPresAll * $transferInfImp * [$prize] * $fromWallet * $RL} *
        q!: * {$cantPastPresAll * $transferInfImp * [$prize] * $onExternalResource * $RL} *
        q!: * {$cantPastPresAll * $transferInfImp * $prizeWithoutMoneyAllAndWinTicket * $fromAccount * $RL} *

        q!: * {$cantPastPresAll * $sendInf * [$prize] * $fromWallet * $RL} *
        q!: * {$cantPastPresAll * $sendInf * [$prize] * $onExternalResource * $RL} *
        q!: * {$cantPastPresAll * $sendInf * $prizeWithoutMoneyAllAndWinTicket * $fromAccount * $RL} *

        q!: * {$cantPastPresAll * $moneyAddInf * [$prize] * $onExternalResource * $RL} *
        q!: * {$cantPastPresAll * $depositInf * [$prize] * $onExternalResource * $RL} *
        q!: * {$cantPastPresAll * оформить * $prizeWithoutMoneyAllAndWinTicket * $onExternalResource * $RL} *

        q!: * {$cantPastPresAll * $prizeWithoutMoney * ($payment $telephone) * $RL} *

        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * $RL} *
        q!: * {$cantPastPresAll * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $RL} *

        q!: * $RL * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $RL * $fromWallet *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * $RL *

        q!: * $RL * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $RL * $onExternalResource *
        q!: * ($ne (прошел/прошл*)/непрошел/непрошл*/нипрошел/нипрошл*) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $RL *
        q!: * $comNo * (~начисление/~зачисление/~перечисление) $prizeWithoutMoney * $onExternalResource * $RL *

        # Не обналичивается кошелек
        q!: * {$cashoutPastPresNe * $wallet * $RL} *
        q!: * {$cashoutPastPresNe * $prize * $RL} *
        q!: * {$cashoutPastPresNe * $fromWallet * $RL} *

        q!: * {$getPrizPastPresNe * [$prize] * $fromWallet * $RL} *
        q!: * {$getPrizPastPresNe * [$prize] * $onExternalResource * $RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromWallet * $RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $onExternalResource * $RL} *
        q!: * {$withdrawPres3Ne * $prizeWithoutMoneyAllAndWinTicket * $fromAccount * $RL} *
        q!: * {$withdrawPres3Ne * $moneyAndRub * $fromAccount * $RL} *

        q!: * {$transferPastPresNe * [$prize] * $fromWallet * $RL} *
        q!: * {$transferPastPresNe * [$prize] * $onExternalResource * $RL} *
        q!: * {$transferPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $fromAccount * $RL} *

        q!: * {$sendPastPresNe * [$prize] * $fromWallet * $RL} *
        q!: * {$sendPastPresNe * [$prize] * $onExternalResource * $RL} *
        q!: * {$sendPastPresNe * $prizeWithoutMoneyAllAndWinTicket * $fromAccount * $RL} *

        q!: * {$moneyAddPastPresNe * [$prize] * $onExternalResource * $RL} *

        # Перевел средства из Кошелька Столото, не поступили
        q!: * {$cashoutPastPres * $wallet * $bonusComePastPresNe * $RL} *
        q!: * {$cashoutPastPres * $prize * $bonusComePastPresNe * $RL} *

        q!: * $RL * {$moneyTakeOffPastPres * $fromWallet} * {$prize * $bonusComePastPresNe} *
        q!: * {$moneyTakeOffPastPres * $fromWallet} * {$prize * $bonusComePastPresNe} * $RL *

        q!: * {$getPrizPastPres * [$prize] * $fromWallet * $bonusComePastPresNe * $RL} *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe * $RL} *

        q!: * {$transferPastPres * [$prize] * $fromWallet * $bonusComePastPresNe * $RL} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe * $RL} *

        q!: * {$sendPastPres * [$prize] * $fromWallet * $bonusComePastPresNe * $RL} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe * $RL} *

        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe * $RL} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $bonusComePastPresNe * $RL} *
        q!: * {($comMoney/$rub) * $onExternalResource * $bonusComePastPresNe * $RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * сложности * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * сложности * $RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $delay * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $delay * $RL} *
        # Обналичил кошелек где деньги
        q!: * {$cashoutPastPres * $wallet * $comWhere * $prize * $RL} *

        q!: * {$getPrizPastPres * $fromWallet * $comWhere * [$prize] * $RL} *
        q!: * {$transferPastPres * $fromWallet * $comWhere * [$prize] * $RL} *
        q!: * {$sendPastPres * $fromWallet * $comWhere * [$prize] * $RL} *

        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $comWhere * $RL} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $comWhere * $RL} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $comWhere * $RL} *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $comWhere * $RL} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $comWhere * $RL} *

        q!: * {$transferPastPres * [$prize] * $onExternalResource * $RL} * $when *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $RL} * $when *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $RL} * $when *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $RL} * $when *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $RL} * $when *

        q!: * {$transferPastPres * [$prize] * $onExternalResource * $RL} * $comNo *
        q!: * {$transferPastPres * [$prize] * $onExternalResource} * $comNo * $RL *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $RL} * $comNo *
        q!: * {$sendPastPres * [$prize] * $onExternalResource} * $comNo * $RL *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $RL} * $comNo *
        q!: * {$getPrizPastPres * [$prize] * $onExternalResource} * $comNo * $RL *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $RL} * $comNo *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource} * $comNo * $RL *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $RL} * $comNo *
        q!: * {$depositPastPres * [$prize] * $onExternalResource} * $comNo * $RL *

        q!: * {$getPrizPastPres * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$transferPastPres * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$sendPastPres * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$moneyAddPastPres * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$depositPastPres * [$prize] * $onExternalResource * $error * $RL} *

        q!: * {$getPrizPastPres * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$transferPastPres * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$sendPastPres * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$moneyAddPastPres * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$depositPastPres * [$prize] * $fromWallet * $error * $RL} *

        q!: * {$cashoutInf * $wallet * $error * $RL} *
        q!: * {$cashoutInf * $prize * $error * $RL} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$sendInf * [$prize] * $fromWallet * $error * $RL} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $error * $RL} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $error * $RL} *

        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $RL} *
        q!: * {$error * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet * $RL} *

        q!: * {$onExternalResource * $bonusComePastPresFut * $prize * ($howLong/$when) * $RL} *
        q!: * {$prizeWithoutMoney * $bonusComePastPresNe * $onExternalResource * $RL} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $fromWallet * $RL} *
        q!: * {($howLong/долго) * ($transferPres3/$sendPres3/$getPrizPresPlSg3) * $onExternalResource * $RL} *
        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $fromWallet * $RL} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $fromWallet * $RL} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $fromWallet * $RL} *
        q!: * {$when * $transferFut * $moneyAndRub * $fromWallet * $RL} *

        q!: * {~время * $prize * $onExternalResource * $RL} *

        q!: * $RL * $getPrizPastPres * [$prize] * $onExternalResource * (как (быстро/долго)/в течени*) *
        q!: * $getPrizPastPres * [$prize] * $RL * $onExternalResource * (как (быстро/долго)/в течени*) *
        q!: * $getPrizPastPres * [$prize] * $onExternalResource * (как (быстро/долго)/в течени*) * $RL *

        q!: * {(как (быстро/долго)/в течени*/~время) * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource * $RL} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $comWhere * $RL} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * ($ne (весь/все) $prize) * $fromWallet * $bonusComePastPres * $RL} *
        q!: * {$onExternalResource * ($ne (весь/все) $prize) * $bonusComePastPres * $RL} *

        q!: * $RL * $prizeWithoutMoney [по] [$ticket] $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * $prizeWithoutMoney [по] [$ticket] $RL $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} *
        q!: * $prizeWithoutMoney [по] [$ticket] $inWallet * {$cantPastPresAll * ($cashoutInf/$getPrizInf/$transferInfImp) * $fromThere} * $RL *

        q!: * {$cantPastPresAll ($getPrizInf/$transferInfImp) [$comMy] $prizeWithoutMoney} [по] [$ticket] $RL (который/которые) ($transferPastPres/$moneyAddPastPres/$sendPastPres) $toWalletAll *

        q!: * долго * длит* * ~выплата * $fromWallet * $RL *
        q!: * долго * длит* * ~выплата * $onExternalResource * $RL *

        eg!: Payments.WithdrawDoesntWorkRusLoto
        if: $global.withdrawalFromPurseRLIsAvailable
            a: По вопросам перевода средств из Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня выплаты могут происходить с задержкой. Наши специалисты уже работают над этим. Средства будет перечислены на Ваш счет в ближайшее время.

        ##################Кошелек#############################################

    state: HowToCreateAPurse
        # Как создать Кошелек
        q!: [$helloAll] {($makeInf/установить) $wallet}
        q!: * {$how [$possiblePredic] [мне/себе] $makeInf $wallet} *
        q!: * {$how [$possiblePredic] [мне/себе] установить $wallet} *
        eg!: Payments.HowToCreateAPurse
        a: Кошелек формируется автоматически при регистрации личного кабинета.


    state: HowToFindAPurse
        # Как найти Кошелек
        q!: [$helloAll] {(*смотреть/увидеть/найти) [этот/эту] [$comMy] [~раздел/вкладк*] $wallet}
        q!: * [$prizeWithoutMoneyAndWinTicket] * $how [мне] {(*смотреть/увидеть/найти) [этот/эту] [~сам] [$comMy] [~раздел/вкладк*] $wallet [то]} *
        q!: * $cantPastPres {найти [~сам] [этот/эту] [$comMy] [~раздел/вкладк*] $wallet} *
        q!: * $findFut1Ne [~сам] [этот/эту] [$comMy] [~раздел/вкладк*] $wallet *
        q!: [$helloAll] [$beginningWords] $comWhere [$comMy] [$electronic] $wallet
        q!: * $comWhere [~сам] [этот/эта] [$comMy] (~раздел/вкладк*) $wallet *
        q!: * $comWhere * (наход*/расположен*) [~сам] [этот/эта] [$comMy] [~раздел/вкладк*] $wallet *
        q!: * $comWhere * на (~сайт/[~сайт] $stoloto) [~сам] [этот/эта] [$comMy] [~раздел/вкладк*] $wallet *
        q!: * $comWhere ~сам [~раздел/вкладк*] $wallet *
        q!: * в какой $wallet вывод* ($prizeWithoutMoneyAndWinTicket/$prize) *
        eg!: Payments.HowToFindAPurse
        a: Кошелек Столото находится в личном кабинете в разделе «Кошелек».


    state: HowToFindOutNumberOfPurse
        # Как узнать номер Кошелька
        q!: * {($how/$comWhere/$cantPastPres) * $findInf * $walletNumber} *
        q!: * {($how/$comWhere/$cantPastPres) * $findOutInf * $walletNumber} *
        q!: * {($how/$comWhere) * $checkInf * $walletNumber} *
        q!: * {($how/$comWhere) * $receiveInf * $walletNumber} *
        q!: * $comWhere * (написан*/записан*) * $walletNumber *
        q!: $comWhere [$oneWord] $walletNumber
        q!: * {$comNeed [$comMy] $walletNumber} *
        q!: {[$comMy] $walletNumber [просит/просят]}
        q!: *скажи* [мне] [$please] $walletNumber
        q!: * {[я] $forgetPastPres [$comMy] $walletNumber} *
        q!: * ~какой {(у меня) $walletNumber} * $account *
        q!: * ~какой * $walletNumber * {$tiedM * $account} *
        q!: * $findOutInf * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * *скажи* * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * $knowNe * $walletNumber * {($tiedM/относящ*/привязан*/$registered) * $account} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * {$registered * $account} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * {$registerPast3 * ($account/я)} *
        q!: * (увидеть/посмотреть) * ~какой * $walletNumber * $duringRegistration *
        q!: * (увидеть/посмотреть) * $walletNumber $account *
        q!: * {$displayPresSg3Ne $walletNumber} *
        eg!: Payments.HowToFindOutNumberOfPurse
        a: Раздел «Кошелек» находится в Вашем личном кабинете. Номер Кошелька можно найти в левом верхнем углу раздела «Кошелек», под суммой Вашего баланса.


    state: HowToFillUpPurse
        # Как пополнить кошелек
        q!: $how $depositInf
        q!: * {$depositInf [на сайте] [$comMy] $walletAll} *
        q!: * $how (пополнить/пополнять) $stoloto *
        q!: * {$depositInf $moneyAndRub $toWallet} *
        q!: * ~пополнение [~счет] ($walletAll/$account) *
        q!: * {$depositInf * $fromExternalResource} *
        q!: * {$moneyAddInf * $fromExternalResource} *
        q!: * {~пополнение * $fromExternalResource} *
        q!: * {~начисление * $fromExternalResource} *
        q!: * {~зачисление * $fromExternalResource} *
        q!: * {$transferInfImp * $fromExternalResource} *

        q: {[я] [$want] пополнить} || fromState = /Payments/HowToTransferTheMoney
        q: {[я] [$want] пополнить} || fromState = /Payments/HowToTransferTheMoneyToPurse

        eg!: Payments.HowToFillUpPurse
        a: Вы можете пополнить баланс Кошелька Столото доступными на сайте способами в разделе «Кошелек» личного кабинета.


    state: DepositDoesntWork
        # Пополнил Кошелек Столото, деньги не поступили
        q!: * $when * (пополнитс*/пополнитьс*) *
        q!: * сколько * времени * ~пополнение *
        q!: * {$waitInf * (~пополнение [~счет] ($walletAll/$account))} *
        q!: * {~пополнение * ($comNo (начислен*/зачислен*))} *
        q!: {$comWhere ~пополнение [$localMobilePhoneNumber]}
        q!: * {$depositPastPres * [$comMoney] * $bonusComePastPresNe * [$application]} *
        q!: * {$depositPastPres * ~сумма * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $numberRub * $bonusComePastPresNe} *
        q!: * {$depositPastPres * [$comMoney] * $transferPastPresNe} *
        q!: * {$depositPastPres * ~сумма * $transferPastPresNe} *
        q!: * {$depositPastPres * $numberRub * $transferPastPresNe} *
        q!: * $depositPastPres * $addPastPlSg3Ne *
        q!: * {$depositPastPres * $howLong * [$moneyAndRub]} *
        q!: * {$depositPastPres * $howLong * ~сумма} *
        q!: * {$depositPastPres * $howLong * ~начисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $howLong * ~зачисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * ~начисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * ~зачисление * [$moneyAndRub]} *
        q!: * {$depositPastPres * $when * $moneyAndRub} *
        q!: * {$depositPastPres * $when * $bonusComePastPres * [$moneyAndRub]} *

        q!: * $depositPastPres * больше $Number мин* *
        q!: * {$depositPastPres * $bonusComePastPresNe * $onBill} *
        q!: * $depositPastPres * $ne на счету *

        q!: * {$depositPastPres * $moneyAndRub * $comNo} *
        q!: * {$depositPastPres * ~сумма * $comNo} *
        q!: * {$depositPastPres * $moneyAndRub * $comWhere} *
        q!: * {$depositPastPres * ~сумма * $comWhere} *
        q!: * {$depositPastPres * $moneyAndRub * куда} *
        q!: * {$depositPastPres * ~сумма * куда} *
        q!: * {$depositPastPres * $moneyAndRub * $zero} *
        q!: * {$depositPastPres * ~сумма * $zero} *
        q!: * {$depositPastPres * $moneyAndRub * тишина} *
        q!: * {$depositPastPres * ~сумма * тишина} *
        q!: * {$depositPastPres * ~сумма * $increasePastPresNe} *
        q!: * {$depositPastPres * $balance * $increasePastPresNe} *
        q!: * {$depositPastPres * ~сумма * $changePastNe} *
        q!: * {$depositPastPres * $balance * $changePastNe} *
        q!: * {$depositPastPres * $walletAll * $comNo} *
        q!: * {$depositPastPres * $walletAll * $comWhere} *
        q!: * {$depositPastPres * $walletAll * куда} *
        q!: * {$depositPastPres * $walletAll * $zero} *
        q!: * {$depositPastPres * $walletAll * тишина} *
        q!: * {$depositPastPres * $walletAll * $zeroAdj} *
        q!: * {$depositPastPres * $walletAll * $when} *
        q!: * $depositPastPres * (долго/сколько) $waitInf *
        q!: * {~пополнение * $walletAll * $when} *
        q!: * $depositPastPres * (на сайте) $zero *

        q!: * ($sendPastPres/$transferPastPres) * $moneyAndRub * $walletAll * [$inWallet] * ($updatePresPlSg3Ne/$updatePresPastNe) *
        q!: * {$depositPastPres * $walletAll} * [$inWallet] * ($updatePresPlSg3Ne/$updatePresPastNe/$findPastPres) *

        q!: * {списание * $fromExternalResource} * $walletAll * ($zero/$comNo/$zeroAdj) *
        q!: * {$depositPastPres * $fromExternalResource} * $nothing $cantPastPres *

        q!: * сколько $depositPresRefl *
        q!: * {$slowly * $depositPresRefl * $walletAll} *
        q!: * {$howLong * $depositPresRefl * $walletAll} *

        q!: * {$howLong * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$howLong * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$howLong * ~пополнение * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$when * ~пополнение * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~начисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~зачисление * $fromExternalResource * [$toWalletAll]} *
        q!: * {$slowly * ~пополнение * $fromExternalResource} *
        q!: * {$howLong * ~пополнение * $moneyAndRub} *
        q!: * {$howLong * ~пополнение * $walletAll} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * ~пополнение} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * ~пополнение} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * ~пополнение} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * ~пополнение} *

        q!: * {~пополнение * $moneyAndRub * $bonusComeFut} *
        q!: * {~пополнение * $moneyAndRub * $transferFut} *
        q!: * {$depositPastPres * [$when] * $moneyAndRub * $bonusComeFut} *
        q!: * {$depositPastPres * [$when] * $moneyAndRub * $transferFut} *
        q!: * {$depositPastPres * $howLong * $moneyAndRub * $bonusComeFut} *
        q!: * {$depositPastPres * $howLong * $moneyAndRub * $transferFut} *
        q!: * {$fromExternalResource * [$when] * $moneyAndRub * $bonusComeFut} * [$inWallet] *
        q!: * {$fromExternalResource * [$when] * $moneyAndRub * $transferFut} *

        q!: * {$fromExternalResource * $howLong * $moneyAndRub * $bonusComeFut} * [$inWallet] *
        q!: * {$fromExternalResource * $howLong * $moneyAndRub * $transferFut} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $fromExternalResource} *

        q!: * {$howLong * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$when * $moneyAddPastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *
        q!: * {$when * $bonusComePastPres * $toWalletAll * [$moneyAndRub] *$fromExternalResource} *

        q!: * {$howLong * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$slowly * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $moneyAddPastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$slowly * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $bonusComePastPres * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $bonusComeFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $bonusComeFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$howLong * $transferFut * $moneyAndRub * $usingExternalResource} *
        q!: * {$when * $transferFut * $moneyAndRub * $usingExternalResource} *

        q!: * {$cantPastPresAll * внести * $moneyAndRub * $toWallet} *
        q!: * {$cantPastPresAll * внести * ~сумма * $toWallet} *
        q!: * {$cantPastPresAll * внести * $moneyAndRub * $onBalance} *
        q!: * {$cantPastPresAll * внести * ~сумма * $onBalance} *
        q!: * {$cantPastPresAll * внести * $moneyAndRub * $onBill} *
        q!: * {$cantPastPresAll * внести * ~сумма * $onBill} *
        q!: * {$cantPastPresAll * $depositInf * $walletAll} *
        q!: * {$cantPastPresAll * $depositInf * $moneyAndRub * $toWallet} *
        q!: * {$cantPastPresAll * (~пополнение [~счет] ($walletAll/$account))} *
        q!: {$cantPastPresAll [$moneyAndRub] $depositInf}
        q!: * {$cantPastPresAll ~пополнение} *
        q!: * {($ne $depositInf) * $walletAll} *

        q!: * {$cantPastPresAll * $depositInf * [$toWallet] * $fromExternalResource} *
        q!: * {$cantPastPresAll * $moneyAddInf * $fromExternalResource} *
        q!: * {$cantPastPresAll * $transferInfImp * [$moneyAndRub] * $fromExternalResource * [$wallet]} *
        q!: * {$cantPastPresAll * ~пополнение * $fromExternalResource} *
        q!: * {$cantPastPresAll * ~начисление * $fromExternalResource} *
        q!: * {$cantPastPresAll * ~зачисление * $fromExternalResource} *
        q!: * {$cantPastPresAll * $depositInf * $error} *
        q!: * {$depositInf * $walletAll * $error} *

        q!: {$error $with ~пополнение}
        q!: [$helloAll] $comWhat $with ~пополнение
        q!: * {(~пополнение [~счет] ($walletAll/$account)) * $error} *
        q!: * {$depositInf * $fromExternalResource * $error} *
        q!: * {$moneyAddInf * $fromExternalResource * $error} *
        q!: * {~пополнение * $fromExternalResource * $error} *
        q!: * {~начисление * $fromExternalResource * $error} *
        q!: * {~зачисление * $fromExternalResource * $error} *

        q!: * $when $workFut ~пополнение *
        q!: * {$comMoney $depositPastPresNe} *
        q!: * {$comMoney * $bonusDisappearPastPres} * $bonusComePastPresNe *
        q!: * {$comMoney * $bonusDisappearPastPres} * $depositPastPresNe *
        q!: * {$comMoney * $bonusDisappearPastPres} * $inWallet $comNo *
        q!: * {$bonusComePastPresNe ~оплата $toWallet} *

        q!: * {$fromExternalResource * $transferPastPres * $toWallet * $bonusComePastPresNe * [$moneyAndRub]} *

        q!: * {$bonusComePastPresNe * $fromExternalResource * [$moneyAndRub] * [$toWallet]} *

        q!: * {$bonusComePastPresNe * [$moneyAndRub] * ~пополнение} *
        q!: * {$bonusComePastPresNe * (пополнен* $moneyAndRub) * [$toWalletAll]} *

        q!: * {$fromExternalResource * $transferPastPres * $when * $bonusComeFut} *
        q!: * {$howLong * $fromExternalResource * $toWallet * [$moneyAndRub]} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $inWallet * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $inWallet * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $inWallet * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $inWallet * $zero} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBalanceLoc * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $onBalanceLoc * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBalanceLoc * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $onBalanceLoc * $zero} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBillLoc * $comNo} *
        q!: * {$fromExternalResource * $transferPastPres * $onBillLoc * $comNo} *
        q!: * {$fromExternalResource * $moneyTakeOffPastPres * $onBillLoc * $zero} *
        q!: * {$fromExternalResource * $transferPastPres * $onBillLoc * $zero} *

        q!: * {$fromExternalResource * $transferPastPres * [$toWalletAll]} * {(их/$comMoney) * $comNo} *

        q!: * {$fromExternalResource * $moneyTakeOffPastPres} * ($balance на нуле/пишет $zero/$zeroAdj) *
        q!: * {$fromExternalResource * $transferPastPres} * ($balance на нуле/пишет $zero/$zeroAdj) *
        q!: * $depositInf * {$fromExternalResource * $moneyTakeOffPastPres} *

        q!: * ($depositPastPres/$transferPastPres) * $usingExternalResource * {$comNo * ((на/в) $walletAll)} *
        q!: * {$transferPastPres * $usingExternalResource * [$wallet] * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $usingExternalResource * [$wallet] * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$transferPastPres * $numberRub * $toWallet} * {$findPastPresNe * их} *
        q!: * {$comMoney $moneyTakeOffPastPres} (а/но/однако) $wallet пуст* *
        q!: * $payPast * {$comNo * ((на/в) $walletAll)} *
        q!: * ($payPast/депозит) * {$bonusComePastPresNe * ((на/в) $walletAll)} *

        q!: * {$depositInf * $wallet * $comMoney * [$moneyTakeOffPastPres] * $bonusComePastPresNe} *
        q!: * {$depositPastPres * $wallet * $comMoney * [$moneyTakeOffPastPres] * $bonusComePastPresNe} *

        q!: * {$payPast * $fromExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$payPast * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$payment * $fromExternalResource * $moneyAndRub * $bonusComePastPresNe} *
        q!: * {$payment * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$sendPastPres * $toWalletAll * $usingExternalResource * $moneyAndRub * $bonusComePastPresNe} *

        q!: * {$fromExternalResource * $toWallet * $slowly} *
        q!: * {$fromExternalResource * $toWallet * быстро} *
        q!: * {$fromExternalResource * $toWallet * $when} *
        q!: * {$fromExternalResource * $toWallet * скоро} *
        q!: * {$fromExternalResource * $onBalance * $slowly} *
        q!: * {$fromExternalResource * $onBalance * быстро} *
        q!: * {$fromExternalResource * $onBalance * $when} *
        q!: * {$fromExternalResource * $onBalance * скоро} *
        q!: * {$fromExternalResource * $onBill * $slowly} *
        q!: * {$fromExternalResource * $onBill * быстро} *
        q!: * {$fromExternalResource * $onBill * $when} *
        q!: * {$fromExternalResource * $onBill * скоро} *
        q!: * {$fromExternalResource * $walletAll * $updatePresSg3Ne} *
        q!: * {$fromExternalResource  * $toWallet * $changeNe} *
        q!: * {$fromExternalResource * $onBalance * $changeNe} *
        q!: * {$fromExternalResource * $onBill * $changeNe} *
        q!: * {$fromExternalResource  * $toWallet * $bonusComeFut} *
        q!: * {$fromExternalResource * $onBalance * $bonusComeFut} *
        q!: * {$fromExternalResource * $onBill * $bonusComeFut} *
        q!: * {$fromExternalResource * $inWallet * $findPastPresNe} *
        q!: * {$transferPastPresNe * $comMoney * $fromExternalResource} *
        q!: * {$findPastPresNe * ~пополнение} *
        q!: * [$fromExternalResource] * {$walletAll * $depositPastPresNe} *
        q!: * {$inWallet $comNo $moneyAndRub переведен* $fromExternalResource} *
        q!: * {$inWallet $comNo $moneyAndRub переведен* $poExternalResource} *
        q!: * {$inWallet $findPastPresNe $moneyAndRub переведен* $fromExternalResource} *
        q!: * {$inWallet $findPastPresNe $moneyAndRub переведен* $poExternalResource} *
        q!: * {$inWallet $displayPresSg3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$inWallet $displayPresPl3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$onBalanceLoc $displayPresSg3Ne ((внесен*) $payment [$numberRub])} *
        q!: * {$onBalanceLoc $displayPresPl3Ne ((внесен*) $payment [$numberRub])} *
        q!: * $depositPastPres * $bonusComePastPres $only $Number *
        q!: * $depositPastPres * ($payment/$numberRub) * ($bonusComePastPres/$moneyAddPartPas/$displayPres3) * ($numberRub/$zero) *
        q!: * $depositPastPres (но/однако) $walletAll $displayPres3 *
        q!: * ($depositPastPres/$fromExternalResource) * $balance * ($former/как и был) *
        q!: * $transferPastPres $numberRub [на ваш счет] (а/но) $balance показывает [$only] $numberRub *
        q!: * внес* * $by (евро сет*/евросет*) * {$comMoney * $bonusComePastPresNe} *
        q!: * {$fromExternalResource * $transferPastPres} * $comWhere [$comMy] $comMoney *

        q: {$comMoney $comNo} || fromState = /Payments/HowToFillUpPurse

        q: первое || fromState = /Payments/ICantToTransferTheMoney
        q: [$comYes] {[я] [$want] $depositInf ($walletAll [$stoloto])} || fromState = /Payments/ICantToTransferTheMoney
        q: * {$want $depositInf} * || fromState = /Payments/ICantToTransferTheMoney
        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/ICantToTransferTheMoney
        q: * пополн* * || fromState = /Payments/ICantToTransferTheMoney
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/ICantToTransferTheMoney

        q: первое || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: [$comYes] {[я] [$want] $depositInf ($walletAll [$stoloto])} || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * {$want $depositInf} * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * пополн* * || fromState = /Payments/ICantToTransferTheMoneyToPurse
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/ICantToTransferTheMoneyToPurse

        q: {[я] [$cantPastPresAll] $depositInf} || fromState = /Payments/WhereIsTheMoney
        q: * пополн* * || fromState = /Payments/WhereIsTheMoney
        q: * [~пополнение] * $fromExternalResource * || fromState = /Payments/WhereIsTheMoney
        q: * (через/черес) [банк*] карт* * || fromState = /Payments/WhereIsTheMoney
        eg!: Payments.DepositDoesntWork
        a: По вопросам пополнения баланса Кошелька Столото, пожалуйста, обратитесь в службу поддержки компании ООО РНКО «Единая касса» (support@w1.ru) или по номеру телефона 8-495-777-11-25.


    #############################идентификация#############################


    state: HowToGetIdentification
        # Что такое идентификация
        # Зачем нужна идентификация
        q!: [$helloAll] ~вопрос [про/о/об] $identification
        q!: * $comWhat $oneWord $identification *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $identification * [$ne могу понять] *
        q!: $identification $whatFor (она/ее) *
        q!: $identification {это $comWhat}
        q!: $identification $comWhat дает *
        q!: * {$identification * влияет} *
        q!: * {$identification * пройти} *
        q!: * {$identification * проходить} *
        q!: * {$identification * подтвердить} *
        q!: * $identificateInf [$comMy] [личн*] данные *
        q!: * чем *лич* $identification через заполнение анкеты *
        q!: * куда * по поводу $identification *
        q!: * {$how $identificateInf} *
        eg!: Payments.HowToGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, о каком виде идентификации Вы хотели бы узнать подробнее?


    state: HowToGetPurseIdentification
        # Что такое идентификация кошелька
        # Зачем нужна идентификация кошелька
        q!: [$helloAll] [~вопрос] [про/о/об] $purseIdentification
        q!: [$helloAll] $possiblePredic $purseIdentification
        q!: * $comWhat $oneWord $purseIdentification *
        q!: * $comWhat $oneWord * статус * (упрощ*/частичн*) $identificateAll *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $purseIdentification * [$ne могу понять] *
        q!: * как понять $purseIdentification *
        q!: * (~какой ~цель) [$oneWord] $purseIdentification *
        q!: $purseIdentification $whatFor (она/ее) *
        q!: $purseIdentification {это $comWhat}
        q!: $purseIdentification $comWhat [она] дает *
        q!: * чем *лич* (полн*/упрощен*/видео) $identification *
        q!: * чем *лич* (видеоидентификац*/видеоинформац*/видеоиндефикац*) *
        q!: * чем *лич* $identification $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * {$purseIdentification * влияет} *
        q!: * {$purseIdentification * пройти} *
        q!: * {$purseIdentification * проходить} *
        q!: * {$purseIdentification * подтвердить} *
        q!: * {пройти * $identification * (на сайте)} *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * {$identificateInf * $w1All} *
        q!: * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe *
        q!: статус [$comMy] $w1All $identificateAllNe
        q!: * $w1All $identificateAllNe * $how * это сделать *
        q!: * {$cantPastPresAll * $payInf} * (из за/из-за) $identification *
        q!: * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification *
        q!: * куда * по поводу $purseIdentification *

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/HowToGetIdentification
        q: * ~первый * || fromState = /Payments/HowToGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentification
        q: * {$identificateAllNe * $w1All} * || fromState = /Payments/HowToWithdrawMoney
        q: * ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *  || fromState = /Payments/HowToGetIdentification
        eg!: Payments.HowToGetPurseIdentification
        a: Идентификация Кошелька - это быстрый процесс, который позволяет установить, что именно Вы (реальный человек с именем, фамилией и паспортом) являетесь владельцем Кошелька «Столото».\n\nЗаконодательство РФ устанавливает ограничения на электронные платежи для анонимных пользователей. Идентификация нужна для того, чтобы расширить возможности по использованию Кошелька «Столото». Идентификацию Кошелька проводит ООО РНКО «Единая касса». Прохождение идентификации Вы осуществляете на свое усмотрение.\n\nИдентификация не влияет на работоспособность Кошелька «Столото». Вы сможете переводить выигрыши в Кошелек и оплачивать билеты, но от идентификации зависят его лимиты и возможность перевода средств на сторонние ресурсы. Ознакомьтесь, пожалуйста, с таблицей статусов пользователей по ссылке https://www.stoloto.ru/wallet_identification .​\n\nПройти идентификацию Вы можете, находясь на странице с информацией по ссылке: https://www.stoloto.ru/wallet_identification . Вам просто нужно нажать на желтую кнопку «Пройти идентификацию» и далее следовать инструкциям.


    state: HowToGetStolotoIdentification
        # Что такое идентификация для получения крупного выигрыша
        q!: [$helloAll] ~вопрос [про/о/об] $stolotoIdentification
        q!: * $comWhat $oneWord $stolotoIdentification *
        q!: * [$ne могу понять] * $whatFor [$oneWord] $oneWord $stolotoIdentification * [$ne могу понять] *
        q!: * как понять $stolotoIdentification *
        q!: * (~какой ~цель) [$oneWord] $stolotoIdentification *
        q!: $stolotoIdentification $whatFor (она/ее) *
        q!: $stolotoIdentification {это $comWhat}
        q!: $stolotoIdentification $comWhat дает *
        q!: * {$stolotoIdentification * влияет} *
        q!: * {$stolotoIdentification * пройти} *
        q!: * {$stolotoIdentification * проходить} *
        q!: * {$stolotoIdentification * подтвердить} *
        q!: * куда * по поводу $stolotoIdentification *
        q: * получени* [крупн*/больш*] $prizeLocal * || fromState = /Payments/HowToGetIdentification
        q: * (крупн*/больш*) $prizeLocal * || fromState = /Payments/HowToGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/HowToGetIdentification
        q: * ~второй * || fromState = /Payments/HowToGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/HowToGetIdentification
        q: $stoloto || fromState = /Payments/HowToGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentification
        eg!: Payments.HowToGetStolotoIdentification
        a: Согласно федеральному закону от 07.08.2001 N 115-ФЗ, при выплате выигрыша по лотерейному билету от 15 000 рублей необходимо пройти процедуру идентификации всем участникам.\n\nИдентификация проходит в несколько этапов:\n1. Необходимо заполнить анкету по данной ссылке https://www.stoloto.ru/private/ident .\n2. Подтвердить Ваши персональные данные из анкеты в одной из розничных точек. Обязательно возьмите с собой документ, удостоверяющий личность.\n3. После успешного подтверждения данных Вы сможете получать выигрыши любого размера.\n\nЕсли Ваши данные из анкеты изменятся, проходить процедуру идентификации придется повторно.


    state: ICantGetIdentification
        # Не могу пройти идентификацию
        q!: * {$cantPastPresAll * $identification * пройти} *
        q!: * {$cantPastPresAll * $identification * проходить} *
        q!: * {$cantPastPresAll * $identification * подтвердить} *
        q!: * {долго * $identification * проходит*} *
        q!: * {скоро * $identification * пройдет} *
        q!: * {$cantPastPresAll * $identificateInf} *
        q!: * прошла * $identification * $or $comNo *
        q!: * $identification ($ne проходит/непроходит/нипроходит) *
        q!: * ($ne проходит/непроходит/нипроходит) $identification *
        q!: * {$identification * ($ne пройдена)} *

        eg!: Payments.ICantGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, при прохождении какого вида идентификации у Вас возникли трудности?


    state: ICantGetPurseIdentification
        # Не могу пройти идентификацию Кошелька
        q!: * InnPassportValidationError *
        q!: * {$cantPastPresAll * $purseIdentification * пройти} *
        q!: * {$cantPastPresAll * $purseIdentification * проходить} *
        q!: * {$cantPastPresAll * $purseIdentification * подтвердить} *
        q!: * {долго * $purseIdentification * проходит*} *
        q!: * {скоро * $purseIdentification * пройдет} *
        q!: * {$cantPastPresAll * пройти * $identification * (на сайте)} *
        q!: * жду * $purseIdentification *
        q!: * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll *
        q!: * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll *
        q!: * {$cantPastPresAll * $identificateInf * $w1All} *
        q!: * {$w1All $identificateAllNe} *
        q!: * $w1All * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe *
        q!: * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe * $w1All *
        q!: * {$identification * $w1All * (до сих пор $comNo)} *
        q!: * отправил* * час назад * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe *
        q!: * $why * {$w1All * $identificateAllNe} *
        q!: * {проверить * заявку * $identification} *
        q!: * (прох*/прош*) $identification * {$w1All * $identificateAllNe} *
        q!: * {$w1All * $identificateAllNe} * (прох*/прош*) $identification *
        q!: * $purseIdentification * $ne *звонил* *
        q!: * $identification $oneWord (1/один) час * (никак*/$comNo) результ* *
        q!: * $identification * в течен* часа *
        q!: * {$identification * ($more (час/часа)/около часа)} *
        q!: * {$identification * ((почти/$more) ($someHours ~час/~сутки))} *
        q!: * ошибк* при $purseIdentification *
        q!: * {($ne проходит) [$comMy] $mail} * $purseIdentification *
        q!: * $purseIdentification * {($ne проходит) [$comMy] $mail} *
        q!: * $purseIdentification ($ne проходит/непроходит/нипроходит) *
        q!: * ($ne проходит/непроходит/нипроходит) $purseIdentification *
        q!: * {$purseIdentification * ($ne пройдена)} *
        q!: * {пройти * $identification * ($comNo инн)} *
        q!: * должны были позвонить * $skype *

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/ICantGetIdentification
        q: * ~первый * || fromState = /Payments/ICantGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/ICantGetIdentification
        q: * ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * || fromState = /Payments/ICantGetIdentification
        eg!: Payments.ICantGetPurseIdentification
        a: Идентификацию Кошелька проводит ООО РНКО «Единая касса».\n\nПо вопросам, возникшим в процессе прохождения процедуры идентификации, обратитесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25.


    state: ICantGetStolotoIdentification
        q: * получени* [крупн*/больш*] $prizeLocal * || fromState = /Payments/ICantGetIdentification
        q: * (крупн*/больш*) $prizeLocal * || fromState = /Payments/ICantGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/ICantGetIdentification
        q: * ~второй * || fromState = /Payments/ICantGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/ICantGetIdentification
        q: $stoloto || fromState = /Payments/ICantGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/ICantGetIdentification
        eg!: Payments.ICantGetStolotoIdentification
        script: Webim.switch();


    state: HowToGetIdentificationIfIAmAForeigner
        # Как пройти идентификацию, если я иностранец
        q!: [$helloAll] ~вопрос [про/о/об] $identification для $foreigner
        q!: * {($comWhat $oneWord $identification) * $foreigner} *
        q!: * {($whatFor [$oneWord] $oneWord $identification) * $foreigner} *
        q!: $identification для $foreigner $whatFor (она/ее) *
        q!: $identification для $foreigner {это $comWhat}
        q!: $identification для $foreigner $comWhat дает *
        q!: * {$identification * пройти * $foreigner} *
        q!: * {$identification * проходить * $foreigner} *
        q!: * {$identification * подтвердить * $foreigner} *
        q!: * {($identificateInf [$comMy] [личн*] данные) * $foreigner} *
        q!: * {(куда * по поводу $identification) * $foreigner} *
        q!: * {$how $identificateInf} * $foreigner *
        q!: * $foreigner * {$how $identificateInf} *
        eg!: Payments.HowToGetIdentificationIfIAmAForeigner
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, о каком виде идентификации Вы хотели бы узнать подробнее?


    state: IAmAForeignerICantGetIdentification
        # Я иностранец, не могу пройти идентификацию
        q!: * {$cantPastPresAll * $identification * пройти * $foreigner} *
        q!: * {$cantPastPresAll * $identification * проходить * $foreigner} *
        q!: * {$cantPastPresAll * $identification * подтвердить * $foreigner} *
        q!: * {долго * $identification * проходит* * $foreigner} *
        q!: * {скоро * $identification * пройдет * $foreigner} *
        q!: * {$cantPastPresAll * $identificateInf * $foreigner} *
        q!: * $foreigner * прошла * $identification * $or $comNo *
        q!: * прошла * $identification * $or $comNo * $foreigner *
        q!: * $foreigner * $identification ($ne проходит/непроходит/нипроходит) *
        q!: * $identification ($ne проходит/непроходит/нипроходит) * $foreigner *
        q!: * $foreigner * ($ne проходит/непроходит/нипроходит) $identification *
        q!: * ($ne проходит/непроходит/нипроходит) $identification * $foreigner *
        q!: * {$identification * ($ne пройдена) * $foreigner} *
        eg!: Payments.IAmAForeignerICantGetIdentification
        a: Существует два вида идентификации.\n\nИдентификация Кошелька «Столото» проводится ООО РНКО «Единая касса» и служит для увеличения его лимитов.\n\nИдентификация «Столото» - для получения выигрыша по лотерейному билету от 15 000 рублей.\n\nУточните, пожалуйста, при прохождении какого вида идентификации у Вас возникли трудности?


    state: IdentificationOfPurseForForeigner
        # Как идентифицировать кошелек, если я иностранец
        q!: [$helloAll] [~вопрос] [про/о/об] $purseIdentification для $foreigner
        q!: [$helloAll] $possiblePredic $purseIdentification для $foreigner
        q!: * $comWhat $oneWord $purseIdentification для $foreigner *
        q!: * как понять $purseIdentification для $foreigner *
        q!: $purseIdentification для $foreigner {это $comWhat}
        q!: $purseIdentification для $foreigner $comWhat [она] дает *
        q!: * {$purseIdentification * пройти * $foreigner} *
        q!: * {$purseIdentification * проходить * $foreigner} *
        q!: * {$purseIdentification * подтвердить * $foreigner} *
        q!: * {пройти * $identification * (на сайте) * $foreigner} *
        q!: * $foreigner * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $foreigner *
        q!: * $foreigner * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $foreigner *
        q!: * {$identificateInf * $w1All * $foreigner} *
        q!: * $foreigner * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * $comWhat (значит/означает/такое) [статус] [$comMy] $w1All $identificateAllNe * $foreigner *
        q!: * $foreigner * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe *
        q!: * как (понять/понимать) [статус] [$comMy] $w1All $identificateAllNe * $foreigner *
        q!: * $foreigner * $w1All $identificateAllNe * $how * это сделать *
        q!: * $w1All $identificateAllNe * $how * это сделать * $foreigner *
        q!: * $foreigner * {$cantPastPresAll * $payInf} * (из за/из-за) $identification *
        q!: * {$cantPastPresAll * $payInf} * (из за/из-за) $identification * $foreigner *
        q!: * $foreigner * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification *
        q!: * ($payPast/оплачиваю) * (потребовал*/требуют) * $identification * $foreigner *
        q!: * $foreigner * куда * по поводу $purseIdentification *
        q!: * куда * по поводу $purseIdentification * $foreigner *

        q!: * {InnPassportValidationError * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * пройти * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * проходить * $foreigner} *
        q!: * {$cantPastPresAll * $purseIdentification * подтвердить * $foreigner} *
        q!: * {долго * $purseIdentification * проходит* * $foreigner} *
        q!: * {скоро * $purseIdentification * пройдет * $foreigner} *
        q!: * {$cantPastPresAll * пройти * $identification * (на сайте) * $foreigner} *
        q!: * $foreigner * жду * $purseIdentification *
        q!: * жду * $purseIdentification * $foreigner *
        q!: * $foreigner * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * $cantPastPresAll * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $foreigner *
        q!: * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll * $foreigner *
        q!: * $foreigner * (подтвердить/$identificateInf) [$comMy] [личн*] данные $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll *
        q!: * $foreigner * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *
        q!: * $cantPastPresAll * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $foreigner *
        q!: * $foreigner * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll *
        q!: * $identificateInf $by ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * $cantPastPresAll * $foreigner *
        q!: * {$cantPastPresAll * $identificateInf * $w1All * $foreigner} *
        q!: * $foreigner * {$w1All $identificateAllNe} *
        q!: * {$w1All $identificateAllNe} * $foreigner *
        q!: * {$foreigner * ($w1All * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe)} *
        q!: * {$foreigner * ((все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe * $w1All)} *

        q!: * {$foreigner * $identification * $w1All * (до сих пор $comNo)} *
        q!: * {$foreigner * (отправил* * час назад * (все равно/до сих пор/по прежнему/по-прежнему) $identificateAllNe)} *
        q!: * $foreigner * $why * {$w1All * $identificateAllNe} *
        q!: * {$foreigner * проверить * заявку * $identification} *
        q!: * $foreigner * (прох*/прош*) $identification * {$w1All * $identificateAllNe} *
        q!: * (прох*/прош*) $identification * {$w1All * $identificateAllNe} * $foreigner *
        q!: * $foreigner * {$w1All * $identificateAllNe} * (прох*/прош*) $identification *
        q!: * {$w1All * $identificateAllNe} * (прох*/прош*) $identification * $foreigner *
        q!: * $foreigner * $purseIdentification * $ne *звонил* *
        q!: * $purseIdentification * $ne *звонил* * $foreigner *
        q!: * $foreigner * $identification $oneWord (1/один) час * (никак*/$comNo) результ* *
        q!: * $identification $oneWord (1/один) час * (никак*/$comNo) результ* * $foreigner *
        q!: * $foreigner * $identification * в течен* часа *
        q!: * $identification * в течен* часа * $foreigner *
        q!: * $foreigner * {$identification * ($more (час/часа)/около часа)} *
        q!: * {$identification * ($more (час/часа)/около часа)} * $foreigner *
        q!: * $foreigner * {$identification * ((почти/$more) ($someHours ~час/~сутки))} *
        q!: * {$identification * ((почти/$more) ($someHours ~час/~сутки))} * $foreigner *
        q!: * {$foreigner * (ошибк* при $purseIdentification)} *
        q!: * $foreigner * {($ne проходит) [$comMy] $mail} * $purseIdentification *
        q!: * {($ne проходит) [$comMy] $mail} * $purseIdentification * $foreigner *
        q!: * $foreigner * $purseIdentification * {($ne проходит) [$comMy] $mail} *
        q!: * $purseIdentification * {($ne проходит) [$comMy] $mail} * $foreigner *
        q!: * {$foreigner * ($purseIdentification ($ne проходит/непроходит/нипроходит))} *
        q!: * {$foreigner * (($ne проходит/непроходит/нипроходит) $purseIdentification)} *
        q!: * {$purseIdentification * ($ne пройдена) * $foreigner} *
        q!: * {пройти * $identification * ($comNo инн) * $foreigner} *
        q!: * {(должны были позвонить * $skype) * $foreigner} *

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ~первый * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) *  || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner

        q: * ($w1All/$purseIdentification/(по/через/черес) инн/един* кас*) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ~первый * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (до/менее/меньше) (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ($skype/$viber/$gosuslugi/видео ~звонок/видеозвонок/видеозвонк*) * || fromState = /Payments/IAmAForeignerICantGetIdentification

        eg!: Payments.IdentificationOfPurseForForeigner
        a: Для нерезидентов Российской Федерации доступна только полная идентификация по видеозвонку через Skype или Viber. Для создания заявки на видеоидентификацию Вы можете прислать на почту support@w1.ru свои актуальные паспортные данные, а также второй документ, удостоверяющий Вашу личность. Например: Снилс, ИНН, водительское удостоверение, загранпаспорт, полис медицинского страхования. После отправки документов будет создана заявка на видеоидентификацию. Специалисты с Вами свяжутся для ее проведения.\n\nОбращаем Ваше внимание, что идентификацию Кошелька проводит платежная система ООО РНКО «Единая касса». При возникновении трудностей и дополнительных вопросов обращайтесь, пожалуйста, в службу поддержки компании ООО РНКО «Единая касса» по адресу электронной почты support@w1.ru или по номеру телефона 8-495-777-11-25.


    state: StolotoIdentificationForForeigner
        q: * получени* [крупн*/больш*] $prizeLocal * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (крупн*/больш*) $prizeLocal * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * ~второй * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * $identification $stoloto * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: $stoloto || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/HowToGetIdentificationIfIAmAForeigner

        q: * получени* [крупн*/больш*] $prizeLocal * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (крупн*/больш*) $prizeLocal * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * {получ* (в [розн*] точк*)} * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * ~второй * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * $identification $stoloto * || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: $stoloto || fromState = /Payments/IAmAForeignerICantGetIdentification
        q: * (15000/15 (000/тыс*/тыщ*)) * || fromState = /Payments/IAmAForeignerICantGetIdentification
        script: Webim.switch();


    state: WhereToPutIdentificationCode
        # Куда вводить код подтверждения идентификации
        q!: * $comWhat $oneWord $code $confirmation $identification *
        q!: * $whatFor $oneWord $code $confirmation $identification *
        q!: $code $confirmation $identification $whatFor (он/они) $comNeed *
        q!: $code $confirmation $identification {это $comWhat}
        q!: * {$insertInf * ($code $confirmation $identification)} *
        q!: [$helloAll] куда {$sendInf ($code $confirmation $identification)}
        q!: * {$useInf * ($code $confirmation $identification)} *
        q!: * $comWhat (делать/сделать) $with ($code $confirmation $identification) *
        q!: * ~анкета * $smsComePast $code $confirmation *
        q!: * {$smsComePast * ($code $confirmation $identification)} *
        eg!: Payments.WhereToPutIdentificationCode
        a: Если Вы заполнили анкету на сайте, то Вам необходимо обратиться в розничную точку с паспортом и данным кодом, чтобы завершить идентификацию. Код необходимо сообщить продавцу розничной точки.


    #################### Оферта #####################################

    state: HowToConfirmTheOffer
        # Как подтвердить оферту
        q!: * {подтвердит* * ~оферта} *
        q!: * {подписат* * ~оферта} *
        eg!: Payments.HowToConfirmTheOffer
        a: Для подтверждения оферты Кошелька пройдите, пожалуйста, по ссылке http://www.stoloto.ru/oferta/accept . Ознакомиться с текстом оферты Вы можете по ссылке https://www.stoloto.ru/wallet_agreement_loto .


    state: ICantConfirmTheOffer
        # Не могу подтвердить оферту
        q!: * {$cantPastPresAll * подтвердит* * ~оферта} *
        q!: * {$cantPastPresAll * ~подтверждение * ~оферта} *
        q!: * {$cantPastPresAll * подписат* * ~оферта} *
        q!: * {подтвердит* * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{долго * (грузит*/загруж*)}) *
        q!: * {~подтверждение * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{долго * (грузит*/загруж*)}) *
        q!: * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{долго * (грузит*/загруж*)}) * {~подтверждение * ~оферта} *
        q!: * {подписат* * ~оферта} * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{долго * (грузит*/загруж*)}) *
        q!: * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) * ~оферта *
        q!: * ~оферта * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) *
        q: * (завис*/виснет/висит/тормозит/глючит/крутит*/$inactive/{долго * (грузит*/загруж*)}) * || fromState = /Payments/HowToConfirmTheOffer
        q: * ($ne (подтверждает*/подписывает*)/неподтверждает*/ниподтверждает*/неподписывает*/ниподписывает*) * || fromState = /Payments/HowToConfirmTheOffer
        eg!: Payments.ICantConfirmTheOffer
        a: Попробуйте, пожалуйста, подтвердить договор оферты на основной версии сайта, перейдя по ссылке https://www.stoloto.ru/oferta/accept .\n\nЧтобы попасть на основную версию сайта, пройдите по ссылке https://www.stoloto.ru/ . Затем внизу экрана нажмите «Основная версия».


    ##################### проблемы с выплатами #####################

    state: WinningsDontShowUp
        # Проблемы с выплатой
        q!: * {~выплата * $bonusComePastPresNe * [$lotteriesWithoutRL]} *
        q!: * {$problem * ~выплата * [$lotteriesWithoutRL]} *
        q!: * {$comNo * ~выплата * [$lotteriesWithoutRL]} *
        q!: * {$getPastNe * $prizeWithoutMoney * [$lotteriesWithoutRL]} *
        q!: * $when $waitInf ~выплата * [$lotteriesWithoutRL] *
        eg!: Payments.WinningsDontShowUp

        script:
            if ($parseTree._lotteriesWithoutRL){
                $temp.thisLotteryName = $injector[$parseTree._lotteriesWithoutRL].lotteryName
            }

        if: $injector.walletPaymentIsAvailable.allPaymentsUnavailable
            a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотереям. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.
        else:
            if: $client.testMode || $global.walletPaymentIsAvailable.isAvailable
                script: Webim.switch();
            else:
                if: $temp.thisLotteryName
                    go!: LotteryNameCatch
                else:
                    a: Какая лотерея Вас интересует?

        state: LotteryNameCatch || fromState = /Payments/WinningsDontShowUp
            q: * $lotteriesWithoutRL *
            script:
                if ($parseTree.value){
                    $temp.thisLotteryName = $injector[$parseTree.value].lotteryName;
                }
                $temp.unavailableLotteries = $injector.walletPaymentIsAvailable.unavailableLotteries;
            if: $injector.walletPaymentIsAvailable.allPaymentsUnavailable
                a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотереям. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.
            else:
                if: Lotteries.isLotteryAvailable($temp.thisLotteryName, $temp.unavailableLotteries)
                    script: Webim.switch();
                else:
                    a: В настоящий момент могут быть проблемы с выплатой выигрышей по лотерее {{ $temp.thisLotteryName }}. Не волнуйтесь, все победители смогут получить выигрыши чуть позже. Наши специалисты уже работают над исправлением ситуации.

        state: RussianLoto || fromState = /Payments/WinningsDontShowUp
            q: * $RL *
            if: $global.paymentsRLIsAvailable
                script: Webim.switch();
            else:
                a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Поэтому для начисления и выплаты выигрышей нам потребуется больше времени. 2 января мы гарантированно будем готовы к выплатам. Спасибо, что проводите эти новогодние праздники вместе с нами! «Столото» желает Вам счастья, радости и, конечно, удачи в наступившем 2020 году!


    state: WinningsDontShowUpRusLoto
        # Проблемы с выплатой (Русское Лото)
        q!: * {~выплата * $bonusComePastPresNe * $RL} *
        q!: * {$problem * ~выплата * $RL} *
        q!: * {$comNo * ~выплата * $RL} *
        q!: * {$getPastNe * $prizeWithoutMoney * $RL} *
        q!: * $when $waitInf ~выплата * $RL *
        eg!: Payments.WinningsDontShowUpRusLoto
        if: $global.paymentsRLIsAvailable
            script: Webim.switch();
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Поэтому для начисления и выплаты выигрышей нам потребуется больше времени. 2 января мы гарантированно будем готовы к выплатам. Спасибо, что проводите эти новогодние праздники вместе с нами! «Столото» желает Вам счастья, радости и, конечно, удачи в наступившем 2020 году!


 ######################################Автовыплаты############################

    state: WhatIsAutopayment
        # Что такое автовыплата
        q!: $autopayment
        q!: * $comWhat $oneWord $autopayment *
        q!: * $whatFor $oneWord $autopayment *
        q!: * $autopayment * ($comWhat это такое) *
        q!: * {$autopayment * ($comWhat * за функция)} *
        q!: * $how (работает/работают) $autopayment *
        q!: * $autopayment $how (работает/работают) *
        eg!: Payments.WhatIsAutopayment
        a: Функция «Автовыплата» позволяет автоматически переводить выигрыш в Кошелек в рамках установленной Вами суммы до 10 000 рублей. Хотелось бы отметить, что по правилам быстрых лотерей выигрыши до 100 000 рублей всегда автоматически переводятся в Кошелек Столото. Если функция не будет включена, то Вы сможете получить выигрыш как в Кошелек Столото, так и наличными в розничной точке.


    state: HowToDisableAutopayment
        # Как отключить Автовыплату?
        q!: * {$turnOffInf * $autopayment} *
        q!: * {$annulInf * $autopayment} *
        q!: * {$rejectInf * $autopayment} *
        q!: * {$deleteInf * $autopayment} *
        q!: * $dontWant $forTo $prizeLocal ($moneyAddPastPres/$transferPastPres/$sendPastPres/поступал*/попадал*) ($toWalletAll/$onBalance) *
        q!: * {$turnOffInf * ~опция * $prizeLocal * $toWalletAll} *
        q!: * {$turnOffInf * ~опция * $prizeLocal * $onBalance} *
        q!: * $forTo $prize ($ne (переносил*/переходил*/уходил*)/непереносил*/непереходил*/неуходил*/нипереносил*/нипереходил*/ниуходил*) $toWalletAll [после розыгрыша] *
        q!: * установить лимит [на/для] ($autopayment/$auto ~перевод/((~перевод/~перечисление) $prizeWithoutMoney $toWalletAll)) *
        q!: * $comWhere * (снять/снят/убрать) гал* $with $autopayment *
        q!: * {изменить * $autopayment} *
        eg!: Payments.HowToDisableAutopayment
        a: Вы можете отключить функцию «Автовыплаты» в личном кабинете в разделе «Кошелек». Вам необходимо будет снять галочку и нажать кнопку «Сохранить». При нажатии на кнопку «Изменить» у Вас есть возможность изменить сумму автовыплат.


    state: AutopaymentDoesntWork
        # Автовыплата не работает
        q!: * {$autopayment * $workPres3Ne} *
        q!: * {$prizeLocal $transferPastPresNe $toWallet автомат*} *
        q!: * {$prizeLocal $smsComePresNe $toWallet автомат*} *
        q!: * {$prizeLocal ($ne попад*) $toWallet автомат*} *
        q!: * {$prizeLocal ($ne попал*) $toWallet автомат*} *
        q!: * {$prizeLocal (непопад*) $toWallet автомат*} *
        q!: * {$prizeLocal (непопал*) $toWallet автомат*} *
        q!: * {$prizeLocal $sendPastPresNe $toWallet автомат*} *
        q!: * {$prize $getPrizPastPresNe $toWallet автомат*} *
        q!: * {$prizeLocal $moneyAddPastPresNe $toWallet автомат*} *
        q!: * {$prizeLocal $moneyAddPartPasNe $toWallet автомат*} *
        eg!: Payments.AutopaymentDoesntWork
        script: Webim.switch();


    state: AutopaymentDoesntWorkRusLoto
        # Автовыплата не работает
        q!: * {$autopayment * $workPres3Ne * $RL} *
        q!: * {$prizeLocal * $RL * $transferPastPresNe * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * $smsComePresNe * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * ($ne попад*) * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * ($ne попал*) * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * (непопад*) * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * (непопал*) * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * $sendPastPresNe * $toWallet * автомат*} *
        q!: * {$prize * $RL * $getPrizPastPresNe * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * $moneyAddPastPresNe * $toWallet * автомат*} *
        q!: * {$prizeLocal * $RL * $moneyAddPartPasNe * $toWallet * автомат*} *
        eg!: Payments.AutopaymentDoesntWorkRusLoto
        if: $global.autopaymentRLIsWorking
            script: Webim.switch();
        else:
            a: Функционал автовыплат временно не работает. Наши специалисты сейчас заняты восстановлением этого сервиса. Надеемся, он будет доступен в ближайшие дни. Приносим извинения за возникшие неудобства.


    state: AutopaymentDoesntTurnOff
        # Автовыплата не выключается
        q!: * {$autopayment * $turnOffPresRefl3Ne} *
        q!: * {(до сих пор/все равно) * автомат* * $transferPres3 * $toWallet} *
        q!: * {(до сих пор/все равно) * автомат* * выплачив* * $toWallet} *
        q!: * {(до сих пор/все равно) * автомат* * $sendPres3 * $toWallet} *
        q!: * {(до сих пор/все равно) * автомат* * $moneyAddPastPres * $toWallet} *

        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $transferPres3 * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $transferPast * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $transferPartPas * $toWallet} *
        q!: * {автомат* * $transferPres3 * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * $transferPast * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * $transferPartPas * $toWallet} * {($autopayment/~функция) * $turnOffPast} *

        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * выплатил* * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * выплачив* * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * выплачен* * $toWallet} *

        q!: * {автомат* * выплатил* * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * выплачив* * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * выплачен* * $toWallet} * {($autopayment/~функция) * $turnOffPast} *

        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $sendPres3 * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $sendPastPerf * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $sendPartPas * $toWallet} *

        q!: * {автомат* * $sendPres3 * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * $sendPastPerf * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * $sendPartPas * $toWallet} * {($autopayment/~функция) * $turnOffPast} *

        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $moneyAddPastPres * $toWallet} *
        q!: * {($autopayment/~функция) * $turnOffPast} * {автомат* * $moneyAddPartPas * $toWallet} *

        q!: * {автомат* * $moneyAddPastPres * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        q!: * {автомат* * $moneyAddPartPas * $toWallet} * {($autopayment/~функция) * $turnOffPast} *
        eg!: Payments.AutopaymentDoesntTurnOff
        script: Webim.switch();


    state: WhyIsThePrizeAutomaticallySentToWallet
        # Почему выигрыш автоматически отправлен в Кошелек?
        q!: * {$why * $prizeLocal * автомат* * $transferPres3 * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * $transferPast * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * $transferPartPas * $toWallet} *
        q!: * {$why * $prizeLocal * падает * $toWallet} *

        q!: * {$prizeLocal * (без $comMy ~согласие) * $transferPres3 * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * $transferPast * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * $transferPartPas * $toWallet} *

        q!: * {$why * $prizeLocal * автомат* * выплатил* * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * выплачив* * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * выплачен* * $toWallet} *

        q!: * {$prizeLocal * (без $comMy ~согласие) * выплатил* * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * выплачив* * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * выплачен* * $toWallet} *

        q!: * {$why * $prizeLocal * автомат* * $sendPres3 * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * $sendPastPerf * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * $sendPartPas * $toWallet} *

        q!: * {$prizeLocal * (без $comMy ~согласие) * $sendPres3 * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * $sendPastPerf * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * $sendPartPas * $toWallet} *

        q!: * {$why * $prizeLocal * автомат* * $moneyAddPastPres * $toWallet} *
        q!: * {$why * $prizeLocal * автомат* * $moneyAddPartPas * $toWallet} *

        q!: * {$prizeLocal * (без $comMy ~согласие) * $moneyAddPastPres * $toWallet} *
        q!: * {$prizeLocal * (без $comMy ~согласие) * $moneyAddPartPas * $toWallet} *

        q!: * {$why (сработал*/срабатывает) $autopayment} *
        eg!: Payments.WhyIsThePrizeAutomaticallySentToWallet
        script: Webim.switch();

############################################################################

    state: HowToFindOutTotalWinnings
        # Как узнать общую сумму выигрышей
        q!: * {($findOutInf/$findInf) * (~общий ~сумма [все*] $prizeWithoutMoney)} *
        q!: * {$comNeed * (~общий ~сумма [все*] $prizeWithoutMoney)} *
        q!: * {$getPrizInf * $referenceNDFL} *
        eg!: Payments.HowToFindOutTotalWinnings
        script: Webim.switch();


###########################################################################

    state: Tax
        # Налог
        q!: * (~налог/налогообложен*/налого обложен*/~налоговый) *
        q!: * {[$how] * [$payInf] * ~налог} *
        q!: * ~какой (~процент/%/~размер) ндфл *
        q!: * сколько * ндфл *
        q!: * {ндфл * $win} *
        eg!: Payments.Tax
        a: Налог на доход физических лиц начисляется с любой суммы выигрыша.\n\nВ случае, когда сумма выигрыша не превышает 15 000 рублей, налог необходимо оплачивать самостоятельно в налоговом органе по месту жительства. Налогоплательщики обязаны самостоятельно исчислить суммы налога исходя из полученных сумм выигрышей по ставке, установленной пунктом 1 статьи 224 Налогового кодекса РФ, и представить в налоговый орган по месту своего учета налоговую декларацию по налогу на доходы физических лиц не позднее 30 апреля года, следующего за истекшим налоговым периодом, согласно статье 229, пункт 1. Согласно статье 228, пункт 4, НК РФ, суммы налога, подлежащие уплате в соответствующий бюджет, исчисленные исходя из налоговой декларации, уплачиваются по месту жительства налогоплательщиков в срок не позднее 15 июля года, следующего за истекшим налоговым периодом.\n\nВ ситуации, когда сумма выигрыша превышает 15 000 рублей, победителю нет необходимости оплачивать налог самостоятельно. Согласно изменениям, внесенным в Налоговый кодекс РФ федеральным законом от 27.11.2017 г. № 354-ФЗ при выплате выигрышей в размере от 15 000 рублей удерживается налог в размере 13% с резидентов РФ.\n\nПодробная информация - по ссылке https://www.stoloto.ru/about/tax?int=faq