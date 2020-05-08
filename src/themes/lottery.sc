theme: /Lottery

#################################код выигрыша##########################

    state: IfIWinHowWillIKnow
        # Как я узнаю о выигрыше?
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13) * {($how/я) * узнаю} *
        q!: * {($how/я) * узнаю} * $if * $winFutSg13 *
        q!: * {$ticket выигрышный} * {($how/я) * узнаю} *
        q!: * {$how * узнаю * $prizeLocal} *

        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13/$prizeLocal) * {вы * (сообщите/оповестите)} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13/$prizeLocal) * {(мне/меня) * (сообщат/оповестят)} *
        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13/$prizeLocal) * {$bonusComeFut * $notification} *
        q!: * ($how/вы) * (сообщаете/оповещаете) * $prizeLocal *
        q!: * (вы/мне) * (сообщите/сообщат/оповестите) * $prizeLocal *
        q!: * меня * оповестят * $prizeLocal *

        q!: * ($if/вдруг) * ($winPastPerf/$winFutSg13/$prizeLocal) * {$smsComeFut * $sms} *
        q!: * {(пришлете/присылаете) * $sms * ((в случае/при) $prizeLocal)} *
        q!: * {$smsComeFut * $sms * ((в случае/при) $prizeLocal)} *
        q!: * {$smsComePres * $sms * ((в случае/при) $prizeLocal)} *

        q!: * должн* * {(приходить/прийти/придти) * $sms} * ((в случае/при) $prizeLocal) *
        q!: * должн* * ((в случае/при) $prizeLocal) * {(приходить/прийти/придти) * $sms} *
        eg!: Lottery.IfIWinHowWillIKnow
        a: Уточните, пожалуйста, где Вы приобретали билет, при покупке билета Вы указывали номер телефона?

        state: GetAnswer
            event: noMatch
            script: Webim.switch();


    state: ReceiveWinningCode
        # Не пришло сообщение с кодом выигрыша
        q!: {$win [для] [~получение] $code}
        q!: * {($code $win) $bePastNe} *
        q!: * {($win $code) $bePastNe} *
        q!: * {$comNeed * [~получение] * $win * $code} *
        q!: * {$comNeed * $code * $getPrizInf * $prizeLocal} *

        q!: * {$givePastPresPl3Ne * $prize} * {$askPresPl3 * $code} *
        q!: * {$askPresPl3 * $code} * {$givePastPresPl3Ne * $prize} *
        q!: * {$askPresPl3 * $code * (~получение $prizeLocal)} *

        q!: * {$smsComePastPresNe * $code * $cashoutInf} *
        q!: * {$bePastNe * $code * $cashoutInf} *
        q!: * [$win] * [$ticket] * [$win] * {$smsComePastPresNe * $code * $win} *
        q!: * [$win] * [$ticket] * [$win] * {$smsComePastPresNe * $code * $prizeLocal} *
        q!: * {$smsComePastPresNe * $sms * [$code] * $win} * [получить] *
        q!: * {$smsComePastPresNe * $code * $prizeLocal * $onTelephone} *
        q!: * {$smsComePastPresNe * $sms * $win * $ticket * $onTelephone} *
        q!: * {$smsComePastPresNe $code} $with $ticketRun *

        q!: * {($ne $findPastPres) * $code * $cashoutInf} *
        q!: * {($ne $findPastPres) * $code * $win} *
        q!: * {($ne $findPastPres) * $sms * [$code] * $win} *

        q!: * {$sendPartPasNe * $code * $win} *
        q!: * {$sendPartPasNe * $sms * [$code] * $win} *

        q!: * {$lostPast * $code * $cashoutInf} *
        q!: * {$lostPast * $code * ($win [$ticket])} * [$how] * [$receiveInf] *
        q!: * {$lostPast * $code * ($ticket $win)} *
        q!: * $winPastPerf * $ticket * [$sms] * {$lostPast * $code} *
        q!: * {$lostPast * $sms * ($win [$ticket]) * [$how] * [$receiveInf]} *
        q!: * {стер* * $sms * ($win [$ticket]) * [$how] * [$receiveInf]} *
        q!: * {$lostPast * $sms * $code * ($win [$ticket])} *
        q!: * $comWhat * (делать/сделать) * {$lostPast * $code * $win} *
        q!: * {$lostPast * $code * $win} * $comWhat * (делать/сделать) *
        q!: * {$getPrizInf * $prizeWithoutMoney * $lostPast * $code} *
        q!: * {$getPrizInf * $prizeWithoutMoney * удален * $code} *

        q!: * {$stopped * $smsComeInf * $code * $win} *
        q!: * {$stopped * идти * $code * $win} *
        q!: * {$stopped * $smsComeInf * $sms * [$code] * $win} *
        q!: * {$stopped * идти * $sms * [$code] * $win} *
        q!: * {$stopped * $smsComeInf * $notification * $win} *
        q!: * {$stopped * идти * $notification * $win} *

        q!: * {$sendMeImp * $code * $cashoutInf} *
        q!: * {$sendMeImp * $code * ($win [$ticket])} *
        q!: * {$sendMeImp * $sms * [$code] * ($win [$ticket])} *

        q!: * {$askYouAll * $sendMeInfPerf * $code * $cashoutInf} *
        q!: * {$askYouAll * $duplicateInfPerf * $code * $cashoutInf} *
        q!: * {$askYouAll * $sendMeInfPerf * $code * ($win [$ticket])} *
        q!: * {$askYouAll * $duplicateInfPerf * $code * ($win [$ticket])} *
        q!: * {$askYouAll * $sendMeInfPerf * $sms * [$code] * ($win [$ticket])} *
        q!: * {$askYouAll * $duplicateInfPerf * $sms * [$code] * ($win [$ticket])} *

        q!: * {[$how] * $duplicateInfPerf * $code * $cashoutInf} *
        q!: * {[$how] * $duplicateInfPerf * $code * ($win [$ticket])} *
        q!: * {$how * $duplicateInfPerf * $sms * [$code] * ($win [$ticket])} *

        # Как получить код выигрыша?
        q!: * [$how] * ($receiveInf/$sendInf) * ($code/$sms) * $win * [$ticket] * [$telephone/$telephoneNumber] *
        q!: * [$how] * ($receiveInf/$sendInf) * ($code/$sms) * ($telephone/$telephoneNumber) * ($win [$ticket]) *
        q!: * $findInf * ($code/$sms) * ($win [$ticket]) *
        q!: * [$how] * узнать * ($code/$sms) * ($win [$ticket]) *

        q!: * {$comWhere * ($win [$ticket]) * $code} *
        q!: * {$comWhere * $sms * [$code] * $win} *
        q!: * {$comWhere * $win * $notification} *

        q!: * {($possiblePredic повторно) * ($win [$ticket]) * $code} *

        q!: * {$resetInf * [$sms] * $code * $win} *
        q!: * {$resetImp * [$sms] * $code * $win} *
        q!: * {$resetNoun * [$sms] * $code * $win} *
        q!: * {заказать * $code * $win} *
        q!: * {$askInf * $code * $win} *

        q!: * {$win * $comNo * $notification} *
        q!: * {$win * $bePastNe * $notification} *
        q!: * {$win * $comNo * $sms * [$code]} *
        q!: * {$win * $bePastNe * $sms * [$code]} *
        q!: * {$win * $comNo * $code} *
        q!: * {$win * $bePastNe * $code} *

        q!: * {$sendPastPresNe * $sms * [$code] * $win} *
        q!: * {$sendPastPresNe * $code * $win} *
        q!: * {$sendPastPresNe * $notification * $win} *

        q!: * {$requirePastPres * $code * $comWhere * $receiveInf} *
        q!: * {$forgetPastPres $code ($win [$ticket])} *

        q!: * {$code $win $comNeed (на $postOffice)} *

        # Когда высылается код выигрыша?
        q!: * {$sms * $prizeLocal * $sendPres3} *
        q!: * {$notification * $prizeLocal * $sendPres3} *
        q!: * {$code * $prizeLocal * $sendPres3} *
        q!: * {$when * $smsComePres * $sms * $win} *
        q!: * {(в ~какой ~случай) * $smsComePres * $sms * $win} *
        q!: * {(всегда [ли]) * $smsComePres * $sms * $win} *
        q!: * {$when * $smsComePres * $notification * $win} *
        q!: * {(в ~какой ~случай) * $smsComePres * $notification * $win} *
        q!: * {(всегда [ли]) * $smsComePres * $notification * $win} *
        q!: * {$when * $smsComePres * $code * $win} *
        q!: * {(в ~какой ~случай) * $smsComePres * $code * $win} *
        q!: * {(всегда [ли]) * $smsComePres * $code * $win} *

        q!: * {((~какой/~любой) $prizeLocal) * $smsComePres * $sms} *
        q!: * {((~какой/~любой) $prizeLocal) * $smsComePres * $notification} *
        q!: * {((~какой/~любой) $prizeLocal) * $smsComePres * $code} *

        q!: * {($if [есть] $prizeLocal) * $sendPresPl2Ne * $sms} *
        q!: * {($if [есть] $prizeLocal) * $sendPresPl2Ne * $code} *
        q!: * {($if [есть] $prizeLocal) * $sendPresPl2Ne * $notification} *

        q!: * {($if {($ticket/я) $win}) * $sendPresPl2Ne * $sms} *
        q!: * {($if {($ticket/я) $win}) * $sendPresPl2Ne * $code} *
        q!: * {($if {($ticket/я) $win}) * $sendPresPl2Ne * $notification} *

        q!: * {($if {($ticket/я) $win}) * $sendPres3 * $sms} *
        q!: * {($if {($ticket/я) $win}) * $sendPres3 * $code} *
        q!: * {($if {($ticket/я) $win}) * $sendPres3 * $notification} *

        q!: * {$enableInfImp * $notification * $prizeLocal} *
        q!: {$localMobilePhoneNumber $localEmail} $code $win
        q!: $code $win {$localMobilePhoneNumber $localEmail}

        q!: * {$givePastPresPl3Ne * $prizeLocal * $retailPointOfSale} * $requirePastPres * $code *
        q!: * {$givePastPresPl3Ne * $prizeLocal * $lostPast * $code} *
        q!: * $forTo ($sendPastPerf/$transferPast/приходил*) [$again] $code $win *
        eg!: Lottery.ReceiveWinningCode
        if: $global.winningCodeIsAvailable
            a: Коды выигрышей по билетам, приобретенным на сайте или в мобильном приложении, с суммой выигрыша менее 15 000 рублей автоматически не отправляются. Приобретая билет на сайте или в мобильном приложении, Вы можете получать выигрыши в Кошелек Столото, для этого код выигрыша не требуется. Если Вы желаете получить выигрыш в розничной точке, то Вы можете запросить код самостоятельно, отправив sms-запрос с номера телефона, указанного при оформлении билета, на номер 9999 со словом «все» без кавычек. Вам придут коды всех невыплаченных выигрышей.
        else:
            a: Спасибо, что сообщили о задержке отправки СМС-сообщений. Мы уже работаем над возобновлением корректной работы системы рассылок.


    state: GaveTicketReceiveWinningCode
        # Добрый день, Подарили билет Русского лото, билет выиграл. Но у меня нет кода, как его получить?
        q!: * {$giftPast * $ticketAll * $code * [$win]} *
        q!: * {$giftPast * $ticketAll * $receiveInf * $code} *
        eg!: Lottery.GaveTicketReceiveWinningCode
        script: Webim.switch();


#########################уникальный ключ################################

    state: WhatIsUniqueKey || noContext = true
        # Что такое уникальный ключ
        # Зачем нужен уникальный ключ
        q!: * $comWhat ($oneWord/значит/значат/означает/означают) [в/на] [$receipt] [$numeral] $uniqueKey *
        q!: * $whatFor $oneWord [этот] $uniqueKey *
        q!: * (~какой ~цель) [$oneWord] $uniqueKey *
        q!: $uniqueKey $whatFor он $comNeed *
        q!: * $uniqueKey {это $comWhat} [значит/означает/такое]
        q!: {[$beginningWords] [в чем] [заключа*] смысл $uniqueKey}
        eg!: Lottery.WhatIsUniqueKey
        a: Уникальный ключ квитанции - это индивидуальный код идентификации квитанции в системе. В комплекте с номером квитанции он служит свидетельством того, что билет действительно оформлен. Именно поэтому он необходим при получении выигрыша, а также потребуется, если с квитанцией возникла сложность.


    state: HowToFindOutAUniqueKey
        # Как узнать уникальный ключ?
        q!: * ($receiveInf/уточнить) [$again/еще раз] $uniqueKey *
        q!: * {$comWhere $receiveInf $uniqueKey} *
        q!: * {$how $receiveInf $uniqueKey} *
        q!: * {помог* $receiveInf $uniqueKey} *
        q!: * {$want $receiveInf $uniqueKey} *
        q!: * {$fromWhere $receiveInf $uniqueKey} *
        q!: * {$cantPastPresAll $receiveInf $uniqueKey} *
        q!: * {$comWhere [я] [могу] $seeInf $uniqueKey} *
        q!: * {$comWhere написан* $uniqueKey} *
        q!: * {$how $seeInf $uniqueKey} *
        q!: * {$lostPast $uniqueKey} *
        q!: * [$prizeWithoutMoneyAllAndWinTicket] * ($comNeed [получит*] [~какой то/~какой-то]/~запрос/~получение) $uniqueKey *
        q!: * (сказал*/говорит/говорят) * $uniqueKey [~какой то/~какой-то] $comNeed *
        q!: * {$findOutInf * $uniqueKey} *
        q!: * {$findInf * $uniqueKey} *
        q!: * {$findPastPresNe * $uniqueKey} *
        q!: * {$askPresPl3 * $uniqueKey} *
        q!: * {вышлите * $uniqueKey} *
        q!: * {$getPastNe $uniqueKey} *
        q!: * {$writtenNe $uniqueKey} *
        q!: * {$requirePastPres * $uniqueKey} *
        q!: * {$askYouAll * $sendMeInfPerf * $uniqueKey} *
        q!: * {$askYouAll * $duplicateInfPerf * $uniqueKey} *
        q!: * {$resetInf * $uniqueKey} *
        q!: * [$prizeWithoutMoneyAllAndWinTicket] * {$comNo [у меня] [~такой] $uniqueKey} *
        q!: * {$smsComePastPerfNe $uniqueKey} *
        q!: [$helloAll] [$beginningWords] {$possiblePredic $uniqueKey}
        eg!: Lottery.HowToFindOutAUniqueKey
        a: Уточните, пожалуйста, Вы приобретали билет в розничных точках продаж или через сайт?

        state: IBoughtInRetailPointOfSale || fromState = /Lottery/HowToFindOutAUniqueKey
            q: * $retailPointOfSale *
            q: * на руках *
            q: * терминал* *
            q: * $geography *
            q: * ~купон *
            q!: * {(на купон*) * $uniqueKey} *
            q!: * {стерс* * $uniqueKey} *
            q!: * {$retailPointOfSale * [$receipt] * $uniqueKey} *
            q!: * {$lostPast * $receipt * $uniqueKey} *
            q!: * {$findInf * $receipt * $uniqueKey} *
            q!: * {$findOutInf * $receipt * $uniqueKey} *
            q!: * {$findPastPresNe * $receipt * $uniqueKey} *
            q!: * {$resetInf * $receipt * $uniqueKey} *
            q!: * {($ne взял*) * $receipt * $uniqueKey} *
            q!: * {выкинул* * $receipt * $uniqueKey * [$receiveInf]} *
            q!: * {$comNo * $receipt * $uniqueKey} *
            q!: * {$askPresPl3 * $uniqueKey * $receipt} *
            q!: * {$requirePastPres * $uniqueKey * $receipt} *
            q!: * {($cantPastPres найти $receipt) * $uniqueKey} *
            a: Если Вы приобретали билет в розничных точках продаж и указывали номер телефона, уникальный ключ Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с этим номером телефона на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты». Уникальный ключ можно посмотреть здесь же, открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр.\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.

        state: IBoughtInInternet || fromState = /Lottery/HowToFindOutAUniqueKey
            q: [$website] $account
            q: * (на/через/черес/в/(с/при) ~помощь) [$this/ваш*] ($website/$account/[$application] $stoloto/~интернет/$application/~программа/комп/~компьютер/моб* ~версия) *
            q: (электроно/электронно/по электронке/электронный/$eTicket)
            q: * по (~интернет/телефону) *
            q: * (по/через/черес) $sms *
            q: * (черезсайт/черезъсайт/черезьсайт/у вас/увас) *
            q: ({($website/$application) [$stoloto]}/[$stoloto] ~интернет)
            q: * $here *
            q: * $online *
            q!: * {$eTicket * $uniqueKey} *
            q!: * {((по/через/черес) $sms) * $uniqueKey} *
            q!: * {$buyPastPres * $online * $uniqueKey} *
            q!: * {$buyN * $online * $uniqueKey} *
            q!: * {$buyPastPres * $website * $uniqueKey} *
            q!: * {$buyPastPres * $application * $uniqueKey} *
            q!: * {$buyPastPres * ~интернет * $uniqueKey} *
            q!: * {$paid * $online * $uniqueKey} *
            q!: * {$resetInf * $uniqueKey * $eTicket} *
            a: Если Вы приобретали билет через сайт, уникальный ключ можно посмотреть в личном кабинете в разделе «Мои билеты», открыв саму квитанцию. Нажмите, пожалуйста, на номер билета, и в открывшемся окне Вы увидите информацию по уникальному ключу, состоящему из 9-ти или из 10-ти цифр. Если Вы приобретали билет через сайт, но у Вас еще нет регистрации, зарегистрируйтесь, пожалуйста, на сайте с номером телефона, указанным при покупке билета. Билет и вся информация о нем отобразятся в личном кабинете в разделе «Мои билеты».\n\nИнструкция как зарегистрироваться на сайте - по ссылке http://www.stoloto.ru/lottery/onlinesale#tag_withoutreg . Страница регистрации: http://www.stoloto.ru/registration . Если после успешной регистрации Вы не видите Ваш билет в Личном кабинете, напишите нам, пожалуйста.


    state: WhereToWriteUniqueKey
        # Куда писать уникальный ключ
        q!: * что [мне] [$comNeed] {делать (($with/в) [этим] $uniqueKey)} *
        q!: * (куд*/сюда/$here) * $insertInf [эт*] $uniqueKey *
        q!: * (куд*/сюда/$here) (писать/написать) $uniqueKey *
        q!: * {$uniqueKey * вам * предоставить} *
        q!: вам $comNeed [эт*] $uniqueKey
        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf) * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * (писать/написать/$sendMeInfPerf/$sendInf) * (куд*/сюда/$here/вам) *|| fromState = /Payments/CantWithdrawMoneyToPurse
        q: * (сюда/вам) * сообщить * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * что $with ним делать * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: * {$findPastPres * ключ*} * || fromState = /Payments/CantWithdrawMoneyToPurse
        q: есть такой || fromState = /Payments/CantWithdrawMoneyToPurse

        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf) * || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
        q: * (писать/написать/$sendMeInfPerf/$sendInf) * (куд*/сюда/$here/вам) *|| fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
        q: * (сюда/вам) * сообщить * || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
        q: * что $with ним делать * || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
        q: * {$findPastPres * ключ*} * || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto
        q: есть такой || fromState = /Payments/CantWithdrawMoneyToPurseRusLoto

        q: * (куд*/сюда/$here/вам) * (писать/написать/$sendMeInfPerf/$sendInf) * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * (писать/написать/$sendMeInfPerf/$sendInf) * (куд*/сюда/$here/вам) *|| fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * (сюда/вам) * сообщить * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * что $with ним делать * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: * {$findPastPres * ключ*} * || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin
        q: есть такой || fromState = /Ticket/IReceivedSMSWithWinCodeButTheySayThatTicketDidntWin

        a: Напишите, пожалуйста, уникальный ключ в ответном сообщении в данном чате.

        state: GetNumber || fromState = /Lottery/WhereToWriteUniqueKey
            q: * {[$uniqueKey] * $receiptKey} *
            script: Webim.switch();


###########################################################################


    state: DidntRecieveCodeOrSMS
        # Когда придет сообщение не могу авторизоваться (не пришло сообщение, но не о коде выигрыша)
        q!: * {$smsComePastPresNe * $sms * $loginInf} *
        q!: * {$smsComePastPresNe * $sms * $authorization} *
        q!: * {($comNo/пропал/отсутс*) * $mail * $sendMeImp * $sms} *
        q!: * {($comNo/пропал/отсутс*) * $mail * $askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $sms} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres * $loginInf} *
        q!: * {$when * $smsComeFut * $sms * $cantPastPres * $authorization} *
        eg!: Lottery.DidntRecieveCodeOrSMS
        a: Если смс не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.

        state: GetUserData || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localEmail * $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localEmail * $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localEmail} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localEmail} *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Lottery/DidntRecieveCodeOrSMS
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            q!: * {$smsComePastPresNe * $sms * $loginInf * $localMobilePhoneNumber} *
            q!: * {$smsComePastPresNe * $sms * $authorization * $localMobilePhoneNumber} *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LocalCatchAll || fromState = /Lottery/DidntRecieveCodeOrSMS
            event: noMatch
            script: Webim.switch();


    #state: WhenWillTheResultsOfTheNewYearRun
        # Когда будут результаты Новогоднего тиража?
        #q!: * {$when * $result * $newYear} *
        #q!: * {$tellImp * $result * $newYear} *
        #q!: * {(еще $comNo $result) * $newYear} *
        #q!: * {(есть $li $result) * $newYear} *
        #eg!: Lottery.WhenWillTheResultsOfTheNewYearRun
        #a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго 75» на сайте будут доступны 01.01.2020 после 10:30 по мск. Прямую трансляцию новогоднего тиража «Русского лото» смотрите первого января в 15:30 по московскому времени на НТВ.


    state: WhereToFindResults
        # Где посмотреть результаты
        q!: $result ~розыгрыш
        q!: * {$wrong * $ticketRun} *
        q!: * {$why $comNo $result} *
        q!: * {$when * $result} *
        q!: * {$comWhere * $result} *
        q!: * $how $seeInf $result *
        q!: * {$tellImp * $result * $ticketRun} *
        q!: * есть ли $result ($lottery/$ticketRun) *
        eg!: Lottery.WhereToFindResults

        if: Lotteries.allLotteriesAvailable($injector)
            if: Time.sundayTimeIsGood()
                if: $session.lastLottery
                    script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
                else:
                    a: Какая лотерея Вас интересует?
            else:
                a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
        else:
            if: $session.lastLottery
                script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
            else:
                a: Какая лотерея Вас интересует?

        state: RussianLoto
            q!: {$result ~розыгрыш $russianLoto}
            q!: * {$wrong * $ticketRun * $russianLoto} *
            q!: * {$why $comNo $result [по] $russianLoto} *
            q!: * {$when * $result * $russianLoto} *
            q!: * {$comWhere * $result * $russianLoto} *
            q!: * {($how $seeInf $result) * $russianLoto} *
            q!: * {$tellImp * $result * $ticketRun * $russianLoto} *
            q!: * есть ли $result [$lottery/$ticketRun] $russianLoto *
            q: * $russianLoto * || fromState = /Lottery/WhereToFindResults
            q: * 1316 * || fromState = /Lottery/WhereToFindResults
            #q: * (1306/$anniversaryDraw) * || fromState = /Lottery/WhereToFindResults

            if: $injector.russianLoto.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(15, 30)
                    a: Прямую трансляцию новогоднего тиража «Русского лото» смотрите первого января в 15:30 по московскому времени на НТВ.
                else:
                    if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: GoldenShoe
            q!: {$result ~розыгрыш $goldenShoe}
            q!: * {$wrong * $ticketRun * $goldenShoe} *
            q!: * {$why $comNo $result [по] $goldenShoe} *
            q!: * {$when * $result * $goldenShoe} *
            q!: * {$comWhere * $result * $goldenShoe} *
            q!: * {($how $seeInf $result) * $goldenShoe} *
            q!: * {$tellImp * $result * $ticketRun * $goldenShoe} *
            q!: * есть ли $result [$lottery/$ticketRun] $goldenShoe *
            q: * $goldenShoe * || fromState = /Lottery/WhereToFindResults

            if: $injector.goldenShoe.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Bingo75
            q!: {$result ~розыгрыш $bingo}
            q!: * {$wrong * $ticketRun * $bingo} *
            q!: * {$why $comNo $result [по] $bingo} *
            q!: * {$when * $result * $bingo} *
            q!: * {$comWhere * $result * $bingo} *
            q!: * {($how $seeInf $result) * $bingo} *
            q!: * {$tellImp * $result * $ticketRun * $bingo} *
            q!: * есть ли $result [$lottery/$ticketRun] $bingo *
            q: * $bingo * || fromState = /Lottery/WhereToFindResults

            if: $injector.bingo75.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: 6of36
            q!: {$result ~розыгрыш $6of36}
            q!: * {$wrong * $ticketRun * $6of36} *
            q!: * {$why $comNo $result [по] $6of36} *
            q!: * {$when * $result * $6of36} *
            q!: * {$comWhere * $result * $6of36} *
            q!: * {($how $seeInf $result) * $6of36} *
            q!: * {$tellImp * $result * $ticketRun * $6of36} *
            q!: * есть ли $result [$lottery/$ticketRun] $6of36 *
            q: * $6of36 * || fromState = /Lottery/WhereToFindResults

            if: $injector['6of36'].isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: HousingLottery
            q!: {$result ~розыгрыш $housingLottery}
            q!: * {$wrong * $ticketRun * $housingLottery} *
            q!: * {$why $comNo $result [по] $housingLottery} *
            q!: * {$when * $result * $housingLottery} *
            q!: * {$comWhere * $result * $housingLottery} *
            q!: * {($how $seeInf $result) * $housingLottery} *
            q!: * {$tellImp * $result * $ticketRun * $housingLottery} *
            q!: * есть ли $result [$lottery/$ticketRun] $housingLottery *
            q: * $housingLottery * || fromState = /Lottery/WhereToFindResults

            if: $injector.housingLottery.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: OtherNamedLottery
            q!: {$result ~розыгрыш $otherNamedLottery}
            q!: * {$wrong * $ticketRun * $otherNamedLottery} *
            q!: * {$why $comNo $result [по] $otherNamedLottery} *
            q!: * {$when * $result * $otherNamedLottery} *
            q!: * {$comWhere * $result * $otherNamedLottery} *
            q!: * {($how $seeInf $result) * $otherNamedLottery} *
            q!: * {$tellImp * $result * $ticketRun * $otherNamedLottery} *
            q!: * есть ли $result [$lottery/$ticketRun] $otherNamedLottery *
            q: * $otherNamedLottery * || fromState = /Lottery/WhereToFindResults
            # Если мы переходим по лотерее, названной отдельным запросом. Примеры в test/temp.xml
            if: $session.lastLottery
                if: $injector[$session.lastLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
            else:
                if: $injector[$parseTree._otherNamedLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Результаты тиражей Вы можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Other
            q!: {$result ~розыгрыш $multiTicketRun}
            q!: * {$wrong * $ticketRun * $multiTicketRun} *
            q!: * {$why $comNo $result [по] $multiTicketRun} *
            q!: * {$when * $result * $multiTicketRun} *
            q!: * {$comWhere * $result * $multiTicketRun} *
            q!: * {($how $seeInf $result) * $multiTicketRun} *
            q!: * {$tellImp * $result * $ticketRun * $multiTicketRun} *
            q!: * есть ли $result [$lottery/$ticketRun] $multiTicketRun *
            q: * $multiTicketRun * || fromState = /Lottery/WhereToFindResults
            q: ($stoloto/спортлото/[спорт] лото) || fromState = /Lottery/WhereToFindResults
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.


    state: CantCheckResult
        # Не могу проверить билет (стейт включает условия для периода массовых сложностей)
        q!: * $why ($ne показывает/непоказывает/нипоказывает) $prizeLocal
        q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket} *
        q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win} *
        q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun} *
        q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $lottery} *
        q!: * $checkTicketPresSgNe * ($ticket/$ticketRun/$lottery) *
        q!: * ($ticket/$ticketRun/$lottery) * $checkTicketPresSgNe *
        q!: * {$cantPastPres * $findOutInf * $win} *
        q!: $cantPastPres [его/их] (проверять/проверить/про верить/проверит/проверет/пробить)
        q!: * {$cantPastPres * ~проверка * $ticket} *
        q!: * {$cantPastPres * ~проверка * $ticketRun} *
        q!: * {$cantPastPres * ~проверка * $lottery} *
        q!: * {$cantPastPres * $how * сыграл* * $ticket} *
        q!: * никак ($ne (проверю/проверить)/непроверю/непроверить/нипроверю/нипроверить) ($ticket/$ticketRun/$lottery) *
        q!: * никак ($ticket/$ticketRun/$lottery) ($ne (проверю/проверить)/непроверю/непроверить/нипроверю/нипроверить) *
        q!: * {$cantPastPres * $findInf * $win} *
        q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat))} *
        q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo))} *
        q!: * {$cantPastPres * $winPastPerf * $or * проиграл*} *
        q!: * {$cantPastPres * (есть ли $prizeLocal)} *
        q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win} *
        q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win)} *

        q!: * {~какой у $me $win} * $cantPastPres *
        q!: * $cantPastPres * {~какой у $me $win} *
        q!: * {~какой ((у/по) $ticket) $win} * $cantPastPres *
        q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} *
        q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney)} *
        q!: * {$cantPastPres * ($howMuch [я] $winPastPerf)} *
        q!: * {$cantPastPres * ($howMuch (составил/составляет) $win)} *
        q!: * {$cantPastPres * ($comWhat [я] $winPastPerf)} *
        q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney)} *
        q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result} *
        q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery)))} *

        q!: * {$bonusComePastPresNe * $result * $lottery} *
        q!: * {$bonusComePastPresNe * $result * $website} *
        q!: * {$bonusComePastPresNe * $result * $ticketRun} *
        q!: * {$bonusComePastPresNe * $result * $lotteryShow} *
        q!: * {$comNo * $result * $website} *
        q!: * {$comNo * $result * $lotteryShow} *
        q!: * {$comNo * $result * $ticketRun} *
        q!: * {$comNo * $result * $lottery} *
        q!: * {$findPastPresNe * $result * $lottery} *
        q!: * {$findPastPresNe * $result * $website} *
        q!: * {$findPastPresNe * $result * $ticketRun} *
        q!: * {$findPastPresNe * $result * $lotteryShow} *
        eg!: Lottery.CantCheckResult
        if: Lotteries.allLotteriesAvailable($injector)
            if: Time.sundayTimeIsGood()
                if: $session.lastLottery
                    script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
                else:
                    a: Какая лотерея Вас интересует?
            else:
                a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                    Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
        else:
            if: $session.lastLottery
                script: $reactions.transition(Lotteries.getTargetLotteryPath($session))
            else:
                a: Какая лотерея Вас интересует?

        state: RussianLoto
            q: * $russianLoto * || fromState = /Lottery/CantCheckResult
            q: * 1316 * || fromState = /Lottery/CantCheckResult
            #q: * (1306/$anniversaryDraw) * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $russianLoto} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $russianLoto} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $russianLoto} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $russianLoto} *
            q!: * {$checkTicketPresSgNe * $russianLoto * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $russianLoto * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $russianLoto * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $russianLoto} *
            q!: * {$cantPastPres * ~проверка * $ticket * $russianLoto} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $russianLoto} *
            q!: * {$cantPastPres * ~проверка * $lottery * $russianLoto} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $russianLoto} *

            q!: * {$cantPastPres * $findInf * $win * $russianLoto} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $russianLoto} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $russianLoto} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $russianLoto} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $russianLoto} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $russianLoto} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $russianLoto} *

            q!: * $russianLoto * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $russianLoto *
            q!: * $russianLoto * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $russianLoto *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $russianLoto} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $russianLoto} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $russianLoto} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $russianLoto} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $russianLoto} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $russianLoto} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $russianLoto} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $russianLoto} *
            q!: * {$bonusComePastPresNe * $result * $website * $russianLoto} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $russianLoto} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $russianLoto} *
            q!: * {$comNo * $result * $website * $russianLoto} *
            q!: * {$comNo * $result * $lotteryShow * $russianLoto} *
            q!: * {$comNo * $result * $ticketRun * $russianLoto} *
            q!: * {$comNo * $result * $lottery * $russianLoto} *
            q!: * {$findPastPresNe * $result * $lottery * $russianLoto} *
            q!: * {$findPastPresNe * $result * $website * $russianLoto} *
            q!: * {$findPastPresNe * $result * $ticketRun * $russianLoto} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $russianLoto} *

            if: $injector.russianLoto.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(15, 30)
                    a: Прямую трансляцию новогоднего тиража «Русского лото» смотрите первого января в 15:30 по московскому времени на НТВ.
                else:
                    if: Time.sundayTimeIsGood() // Setting testMode to true via /setTestMode will enable sunday-like answer forever.
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.russianLoto.ticketRun }} тиража лотереи {{ $injector.russianLoto.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: GoldenShoe
            q: * $goldenShoe * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $goldenShoe} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $goldenShoe} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $goldenShoe} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $goldenShoe} *
            q!: * {$checkTicketPresSgNe * $goldenShoe * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $goldenShoe * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $goldenShoe * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $goldenShoe} *
            q!: * {$cantPastPres * ~проверка * $ticket * $goldenShoe} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $goldenShoe} *
            q!: * {$cantPastPres * ~проверка * $lottery * $goldenShoe} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $goldenShoe} *

            q!: * {$cantPastPres * $findInf * $win * $goldenShoe} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $goldenShoe} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $goldenShoe} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $goldenShoe} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $goldenShoe} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $goldenShoe} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $goldenShoe} *

            q!: * $goldenShoe * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $goldenShoe *
            q!: * $goldenShoe * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $goldenShoe *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $goldenShoe} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $goldenShoe} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $goldenShoe} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $goldenShoe} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $goldenShoe} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $goldenShoe} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $goldenShoe} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $goldenShoe} *
            q!: * {$bonusComePastPresNe * $result * $website * $goldenShoe} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $goldenShoe} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $goldenShoe} *
            q!: * {$comNo * $result * $website * $goldenShoe} *
            q!: * {$comNo * $result * $lotteryShow * $goldenShoe} *
            q!: * {$comNo * $result * $ticketRun * $goldenShoe} *
            q!: * {$comNo * $result * $lottery * $goldenShoe} *
            q!: * {$findPastPresNe * $result * $lottery * $goldenShoe} *
            q!: * {$findPastPresNe * $result * $website * $goldenShoe} *
            q!: * {$findPastPresNe * $result * $ticketRun * $goldenShoe} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $goldenShoe} *

            if: $injector.goldenShoe.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.goldenShoe.ticketRun }} тиража лотереи {{ $injector.goldenShoe.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Bingo75
            q: * $bingo * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $bingo} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $bingo} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $bingo} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $bingo} *
            q!: * {$checkTicketPresSgNe * $bingo * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $bingo * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $bingo * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $bingo} *
            q!: * {$cantPastPres * ~проверка * $ticket * $bingo} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $bingo} *
            q!: * {$cantPastPres * ~проверка * $lottery * $bingo} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $bingo} *

            q!: * {$cantPastPres * $findInf * $win * $bingo} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $bingo} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $bingo} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $bingo} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $bingo} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $bingo} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $bingo} *

            q!: * $bingo * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $bingo *
            q!: * $bingo * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $bingo *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $bingo} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $bingo} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $bingo} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $bingo} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $bingo} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $bingo} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $bingo} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $bingo} *
            q!: * {$bonusComePastPresNe * $result * $website * $bingo} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $bingo} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $bingo} *
            q!: * {$comNo * $result * $website * $bingo} *
            q!: * {$comNo * $result * $lotteryShow * $bingo} *
            q!: * {$comNo * $result * $ticketRun * $bingo} *
            q!: * {$comNo * $result * $lottery * $bingo} *
            q!: * {$findPastPresNe * $result * $lottery * $bingo} *
            q!: * {$findPastPresNe * $result * $website * $bingo} *
            q!: * {$findPastPresNe * $result * $ticketRun * $bingo} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $bingo} *

            if: $injector.bingo75.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.bingo75.ticketRun }} тиража лотереи {{ $injector.bingo75.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: 6of36
            q: * $6of36 * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $6of36} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $6of36} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $6of36} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $6of36} *
            q!: * {$checkTicketPresSgNe * $6of36 * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $6of36 * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $6of36 * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $6of36} *
            q!: * {$cantPastPres * ~проверка * $ticket * $6of36} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $6of36} *
            q!: * {$cantPastPres * ~проверка * $lottery * $6of36} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $6of36} *

            q!: * {$cantPastPres * $findInf * $win * $6of36} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $6of36} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $6of36} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $6of36} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $6of36} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $6of36} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $6of36} *

            q!: * $6of36 * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $6of36 *
            q!: * $6of36 * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $6of36 *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $6of36} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $6of36} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $6of36} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $6of36} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $6of36} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $6of36} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $6of36} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $6of36} *
            q!: * {$bonusComePastPresNe * $result * $website * $6of36} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $6of36} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $6of36} *
            q!: * {$comNo * $result * $website * $6of36} *
            q!: * {$comNo * $result * $lotteryShow * $6of36} *
            q!: * {$comNo * $result * $ticketRun * $6of36} *
            q!: * {$comNo * $result * $lottery * $6of36} *
            q!: * {$findPastPresNe * $result * $lottery * $6of36} *
            q!: * {$findPastPresNe * $result * $website * $6of36} *
            q!: * {$findPastPresNe * $result * $ticketRun * $6of36} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $6of36} *

            if: $injector['6of36'].isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector['6of36'].ticketRun }} тиража лотереи {{ $injector['6of36'].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: HousingLottery
            q: * $housingLottery * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $housingLottery} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $housingLottery} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $housingLottery} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $housingLottery} *
            q!: * {$checkTicketPresSgNe * $housingLottery * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $housingLottery * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $housingLottery * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $housingLottery} *
            q!: * {$cantPastPres * ~проверка * $ticket * $housingLottery} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $housingLottery} *
            q!: * {$cantPastPres * ~проверка * $lottery * $housingLottery} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $housingLottery} *

            q!: * {$cantPastPres * $findInf * $win * $housingLottery} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $housingLottery} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $housingLottery} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $housingLottery} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $housingLottery} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $housingLottery} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $housingLottery} *

            q!: * $housingLottery * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $housingLottery *
            q!: * $housingLottery * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $housingLottery *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $housingLottery} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $housingLottery} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $housingLottery} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $housingLottery} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $housingLottery} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $housingLottery} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $housingLottery} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $housingLottery} *
            q!: * {$bonusComePastPresNe * $result * $website * $housingLottery} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $housingLottery} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $housingLottery} *
            q!: * {$comNo * $result * $website * $housingLottery} *
            q!: * {$comNo * $result * $lotteryShow * $housingLottery} *
            q!: * {$comNo * $result * $ticketRun * $housingLottery} *
            q!: * {$comNo * $result * $lottery * $housingLottery} *
            q!: * {$findPastPresNe * $result * $lottery * $housingLottery} *
            q!: * {$findPastPresNe * $result * $website * $housingLottery} *
            q!: * {$findPastPresNe * $result * $ticketRun * $housingLottery} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $housingLottery} *

            if: $injector.housingLottery.isAvailable && $injector.isLotteriesAvailable
                if: Time.isSpecialEvent(10, 30)
                    a: Результаты новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» на сайте будут доступны 01.01.2020 после 10:30 по мск.
                else:
                    if: Time.sundayTimeIsGood()
                        a: Результатов на сайте еще нет. По лотереям «Русское лото», «Жилищная лотерея», «Золотая подкова», «Бинго-75» и «6 из 36» результаты появляются на нашем сайте после 10:20 по мск.
                    else:
                        a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить». Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
            else:
                a: По техническим причинам результаты {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                #a: Публикация {{ $injector.housingLottery.ticketRun }} тиража лотереи {{ $injector.housingLottery.lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: OtherNamedLottery
            q: * $otherNamedLottery * || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $otherNamedLottery} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $otherNamedLottery} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $otherNamedLottery} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $otherNamedLottery} *
            q!: * {$checkTicketPresSgNe * $otherNamedLottery * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $otherNamedLottery * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $otherNamedLottery * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $otherNamedLottery} *
            q!: * {$cantPastPres * ~проверка * $ticket * $otherNamedLottery} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $otherNamedLottery} *
            q!: * {$cantPastPres * ~проверка * $lottery * $otherNamedLottery} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $otherNamedLottery} *

            q!: * {$cantPastPres * $findInf * $win * $otherNamedLottery} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $otherNamedLottery} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $otherNamedLottery} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $otherNamedLottery} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $otherNamedLottery} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $otherNamedLottery} *

            q!: * $otherNamedLottery * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $otherNamedLottery *
            q!: * $otherNamedLottery * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $otherNamedLottery *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $otherNamedLottery} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $otherNamedLottery} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $otherNamedLottery} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $otherNamedLottery} *
            q!: * {$bonusComePastPresNe * $result * $website * $otherNamedLottery} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $otherNamedLottery} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $otherNamedLottery} *
            q!: * {$comNo * $result * $website * $otherNamedLottery} *
            q!: * {$comNo * $result * $lotteryShow * $otherNamedLottery} *
            q!: * {$comNo * $result * $ticketRun * $otherNamedLottery} *
            q!: * {$comNo * $result * $lottery * $otherNamedLottery} *
            q!: * {$findPastPresNe * $result * $lottery * $otherNamedLottery} *
            q!: * {$findPastPresNe * $result * $website * $otherNamedLottery} *
            q!: * {$findPastPresNe * $result * $ticketRun * $otherNamedLottery} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $otherNamedLottery} *

            if: $session.lastLottery
                if: $injector[$session.lastLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                        Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$session.lastLottery].ticketRun }} тиража лотереи {{ $injector[$session.lastLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.
            else:
                if: $injector[$parseTree._otherNamedLottery].isAvailable && $injector.isLotteriesAvailable
                    a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                        Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.
                else:
                    a: По техническим причинам результаты {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} будут опубликованы с задержкой. Мы работаем над скорейшим устранением проблемы.
                    #a: Публикация {{ $injector[$parseTree._otherNamedLottery].ticketRun }} тиража лотереи {{ $injector[$parseTree._otherNamedLottery].lotteryName }} задерживается в связи с большим количеством участников. На обработку данных потребовалось больше времени. Результаты будут опубликованы в ближайшее время.

        state: Other
            q: * $multiTicketRun * || fromState = /Lottery/CantCheckResult
            q: ($stoloto/спортлото/[спорт] лото) || fromState = /Lottery/CantCheckResult

            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticket * $multiTicketRun} *
            q!: * {$cantPastPres * (пробить/$checkInf/понять) * $win * $multiTicketRun} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * $ticketRun * $multiTicketRun} *
            q!: * {$cantPastPres * (проверять/проверить/про верить/проверит/проверет/пробить) * [$lottery] * $multiTicketRun} *
            q!: * {$checkTicketPresSgNe * $multiTicketRun * [$ticket]} *
            q!: * {$checkTicketPresSgNe * $multiTicketRun * $ticketRun} *
            q!: * {$checkTicketPresSgNe * $multiTicketRun * $lottery} *
            q!: * {$cantPastPres * $findOutInf * $win * $multiTicketRun} *
            q!: * {$cantPastPres * ~проверка * $ticket * $multiTicketRun} *
            q!: * {$cantPastPres * ~проверка * $ticketRun * $multiTicketRun} *
            q!: * {$cantPastPres * ~проверка * $lottery * $multiTicketRun} *
            q!: * {$cantPastPres * $how * сыграл* * $ticket * $multiTicketRun} *

            q!: * {$cantPastPres * $findInf * $win * $multiTicketRun} *
            q!: * {$cantPastPres * $winPastPerf * ($or ($comNo/$comWhat)) * $multiTicketRun} *
            q!: * {$cantPastPres * (($findOutInf/$checkInf) ($winPastPerf $comNo)) * $multiTicketRun} *
            q!: * {$cantPastPres * $winPastPerf * $or * проиграл* * $multiTicketRun} *
            q!: * {$cantPastPres * (есть ли $prizeLocal) * $multiTicketRun} *
            q!: * {$cantPastPres * ($findOutInf есть [$li]) * $win * $multiTicketRun} *
            q!: * {$cantPastPres * ($findOutInf [~какой] ~сумма [я] $win) * $multiTicketRun} *

            q!: * $multiTicketRun * {~какой [у $me] $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой [у $me] $win} * $multiTicketRun *
            q!: * $multiTicketRun * {~какой ((у/по) $ticket) $win} * $cantPastPres *
            q!: * $cantPastPres * {~какой ((у/по) $ticket) $win} * $multiTicketRun *
            q!: * {$cantPastPres * (~какой ~сумма) * ($winPastPerf/$prizeWithoutMoney) * $multiTicketRun} *
            q!: * {$cantPastPres * ($howMuch [я] $winPastPerf) * $multiTicketRun} *
            q!: * {$cantPastPres * ($howMuch (составил/составляет) $win) * $multiTicketRun} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * (($howMuch/~какой) [у меня] $prizeWithoutMoney) * $multiTicketRun} *
            q!: * {$cantPastPres * ($comWhat [я] $winPastPerf) * $multiTicketRun} *
            q!: * {$cantPastPres * ($findOutInf/$checkInf) * $result * $multiTicketRun} *
            q!: * {$cantPastPres * ($winPastPerf ($li) (я/[~мой] [$oneWord] ($ticket/$ticketRun/$lottery))) * $multiTicketRun} *

            q!: * {$bonusComePastPresNe * $result * $lottery * $multiTicketRun} *
            q!: * {$bonusComePastPresNe * $result * $website * $multiTicketRun} *
            q!: * {$bonusComePastPresNe * $result * $ticketRun * $multiTicketRun} *
            q!: * {$bonusComePastPresNe * $result * $lotteryShow * $multiTicketRun} *
            q!: * {$comNo * $result * $website * $multiTicketRun} *
            q!: * {$comNo * $result * $lotteryShow * $multiTicketRun} *
            q!: * {$comNo * $result * $ticketRun * $multiTicketRun} *
            q!: * {$comNo * $result * $lottery * $multiTicketRun} *
            q!: * {$findPastPresNe * $result * $lottery * $multiTicketRun} *
            q!: * {$findPastPresNe * $result * $website * $multiTicketRun} *
            q!: * {$findPastPresNe * $result * $ticketRun * $multiTicketRun} *
            q!: * {$findPastPresNe * $result * $lotteryShow * $multiTicketRun} *

            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».
                Результаты тиражей Вы также можете посмотреть на нашем сайте в Архиве тиражей интересующей Вас лотереи.

        state: CheckButtonIsNotActive
            # Кнопка Проверить не активна
            q: * {$button $checkTicket [$ticket] $activeNe} *
            q: * {$button $activeNe} *
            eg: Lottery.CantCheckResult.CheckButtonIsNotActive
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
            eg: Lottery.CantCheckResult.IDontRememberWhichLottery
            go!: ../Other

        state: ThereAreNoTicketRunNumberAndTicketNumber
            q: * это $comWhere *
            q: * серия $Number *
            q: * $ne ($number/$ticketNumber) $nothing *
            q: * $only ($number/$ticketNumber) и $code *
            q: * $comWhere (этот/эти) $number *
            q: * $comWhere эти $numeral *
            q: * {$forgetPastPres $number} *
            q: * $comNo этих данных *
            eg: Lottery.CantCheckResult.ThereAreNoTicketRunNumberAndTicketNumber
            go!: /Ticket/ThereAreNoTicketRunNumberAndTicketNumber

        state: CheckByQrCode
            q: * {[$generalNamedLottery] * ($by $qrCode)} *
            a: Отсканировать QR-код на билете Вы можете с помощью специальной программы-распознавателя или официального приложения «Столото» для iOS или Android.

        state: Coupon
            # у меня купон
            q: * ~купон *
            a: Для проверки билета, пожалуйста, перейдите по ссылке http://www.stoloto.ru/check-ticket . На странице http://www.stoloto.ru/check-ticket выберите из списка интересующую Вас лотерею, введите номер тиража (если у Вас многотиражная квитанция, то необходимо ввести номер стартового тиража) и номер билета, а далее нажмите на кнопку «Проверить».\n\nНомер тиража и номер билета Вы можете посмотреть на черно-белой квитанции, которую Вам выдали при покупке билета. Номер тиража указан в верхней части квитанции после слов «Билет действителен для 1 тиража (ей)». Если у Вас не сохранилась квитанция, Вы можете зарегистрироваться с номером телефона, указанным при покупке купона, на сайте. После завершения регистрации билет отобразится в Вашем личном кабинете в разделе «Мои билеты», там же Вы найдете всю информацию о билете.


    state: IDontSeeRusLotoResultsInMyTickets
        # Задержка в публикации результатов розыгрыша РЛ в "Мои билеты"
        q!: * {$bonusComePastPresNe * $result * $RL * (мои билеты)} *
        q!: * {$bonusComePastPresNe * $result * $RL * (моих билетах)} *
        q!: * {$comNo * $result * $RL * (мои билеты)} *
        q!: * {$comNo * $result * $RL * (моих билетах)} *
        q!: * {$findPastPresNe * $result * $RL * (мои билеты)} *
        q!: * {$findPastPresNe * $result * $RL * (моих билетах)} *
        q!: * {$delay * $result * $RL * (мои билеты)} *
        q!: * {$delay * $result * $RL * (моих билетах)} *
        q!: * {$inactive * $result * $RL * (мои билеты)} *
        q!: * {$inactive * $result * $RL * (моих билетах)} *
        q!: * {($when будут) * $result * $RL * (мои билеты)} *
        q!: * {($when будут) * $result * $RL * (моих билетах)} *
        q!: * {($when появят*) * $result * $RL * (мои билеты)} *
        q!: * {($when появят*) * $result * $RL * (моих билетах)} *
        q!: * {($when загруз*) * $result * $RL * (мои билеты)} *
        q!: * {($when загруз*) * $result * $RL * (моих билетах)} *
        q!: * {($when $waitInf) * $result * $RL * (мои билеты)} *
        q!: * {($when $waitInf) * $result * $RL * (моих билетах)} *
        q!: * {($when смогу $seeInf) * $result * $RL * (мои билеты)} *
        q!: * {($when смогу $seeInf) * $result * $RL * (моих билетах)} *
        q!: * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) * $result * $RL * (мои билеты/моих билетах) *
        q!: * $result * $RL * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) * (мои билеты/моих билетах) *
        eg!: Lottery.IDontSeeRusLotoResultsInMyTickets
        if: $global.rusLotoResultsInMyTicketsAreAvailable
            script: Webim.switch();
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня результаты розыгрыша могут быть опубликованы с задержкой. Все данные будут в вашем личном кабинете в ближайшее время.


    state: ResultsAreNotDisplayedCorrectly
        # некорректно отображается информация о результатах тиража
        q!: * {$incorrectly * $displayPres3 * $result} *
        q!: * {$result * $displayPres3 * ($with ~ошибка)} *
        q!: * {$incorrectly * $displayPres3 * (выпавш* ($numeral/числ*))} *
        q!: * {(выпавш* ($numeral/числ*)) * $displayPres3 * ($with ~ошибка)} *
        q!: * {$incorrectly * $displayPres3 * (инф* о $prizeLocal)} *
        q!: * {(инф* о $prizeLocal) * $displayPres3 * ($with ~ошибка)} *
        q!: * {$wrong * ~отображение * $result} *
        q!: * {$wrong * ~отображение * (выпавш* ($numeral/числ*))} *
        q!: * {$wrong * ~отображение * (инф* о $prizeLocal)} *
        q!: * {~отображение * $result * $incorrectly} *
        q!: * {~отображение * (выпавш* ($numeral/числ*)) * $incorrectly} *
        q!: * {~отображение * (инф* о $prizeLocal) * $incorrectly} *
        eg!: Lottery.ResultsAreNotDisplayedCorrectly
        if: $global.resultsAreDisplayedCorrectly
            script: Webim.switch();
        else:
            a: Результаты розыгрышей загружаются на сайт из тиражных таблиц, подтвержденных протоколами тиражной комиссии. Иногда при проверке билета может возникать некорректное отображение страниц, что никак не сказывается на результате тиража. Все победители в обязательном порядке получат свои выигрыши. Корректная информация будет опубликована в ближайшее время.


    state: WhyDidntPlayTheCirculation
        # Проблема с проведением тиража
        q!: * {$error * (проведени* [$Number] $ticketRun)} *
        q!: * {$error * (проведени* розыгрыш*)} *
        q!: * {$error * (проведени* игры)} *
        q!: * {~трудность * (проведени* [$Number] $ticketRun)} *
        q!: * {~трудность * (проведени* розыгрыш*)} *
        q!: * {~трудность * (проведени* игры)} *
        q!: * {$why * ($ne начинает*/неначинает*) * розыгрыш*} *
        q!: * {(розыгрыш*/$ticketRun) * отменили} *
        q!: * {(розыгрыш*/$ticketRun) * отменен} *
        q!: * {игру * (отменили/перенесли)} *
        q!: * {игра * (отменена/перенесена)} *
        q!: * {(розыгрыш*/$ticketRun) * перенесли} *
        q!: * {(розыгрыш*/$ticketRun) * перенесен} *
        q!: * {$why * $ticketRun * ($ne разыграли/неразыграли)} *
        q!: * {$why * $ticketRun * ($ne разыгран/неразыгран)} *
        q!: * {$why * $ticketRun * ($ne провели/непровели)} *
        q!: * {$why * $ticketRun * ($ne проведен/непроведен)} *
        q!: * (обещали/должны были) (провести/разыграть) [$Number] $ticketRun *
        eg!: Lottery.WhyDidntPlayTheCirculation
        if: $global.drawTakesPlaceOnTime
            script: Webim.switch();
        else:
            a: По техническим причинам время проведения тиража было изменено. Результаты розыгрыша, как обычно, будут загружаться на сайт и в мобильное приложение только после проведения тиража из таблиц, подтвержденных протоколами тиражной комиссии. Все выигрыши будут выплачены победителям в полном объеме.


    state: HowToPlay
        # Как принять участие в лотерее на сайте
        q!: * новичок *
        q!: * (первый раз/впервые) (участвую/учавствую/пробую играть/играю/$here) *
        q!: * (участвую/учавствую/пробую играть/играю/$here) (первый раз/впервые) *
        q!: [$helloAll] {[я] [$want] $playInf [в ($lottery/$stoloto)/$hereAll]}
        q!: * {$how * $playInf * [$lottery]} *
        q!: * {$whatToDoInf * $forTo * $playInf} *
        q!: [$helloAll] Купитьбилет

        q!: [$helloAll] {[я] [$want] $buyInf [$ticketAndLotteryAll]}
        q!: [$helloAll] {[я] помогите $buyInf [$ticketAndLotteryAll]}
        q!: [$helloAll] {[я] [$want] $payInf [$ticketAndLotteryAll]}

        #q!: * {$comWhere * $buyInf * $ticketAndLotteryAll} *
        q!: * {$comWhere * $payInf * $ticketAndLotteryAll} *
        q!: * $how $buyInf $buyN *
        q!: * {$how * $buyInf * $ticketAndLotteryAll} *
        q!: * {$how * $payInf * $ticketAndLotteryAll} *
        q!: * {могу * $buyInf * $ticketAndLotteryAll} *
        q!: * {могу * $payInf * $ticketAndLotteryAll} *
        q!: * {$possiblePredicAll * $buyInf * $ticketAndLotteryAll} *
        q!: * {$possiblePredicAll * $payInf * $ticketAndLotteryAll} *
        q!: * $how выбрать $ticketAndLotteryAll *
        q!: * $how $passPres $payment *
        q!: * {$how $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$possiblePredicAll $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$want $payInf} [$ticketAndLotteryAll] $by ($phoneAndNum/$sms) *
        q!: * {$how $payInf} [$ticketAndLotteryAll] $fromTelephone *
        q!: * {$possiblePredicAll $payInf} [$ticketAndLotteryAll] $fromTelephone *
        q!: * {$want $payInf} [$ticketAndLotteryAll] $fromTelephone *
        #q!: [$helloAll] {($how/$comWhere) $buyInf}
        q!: [$helloAll] {$how $buyInf}
        q!: [$helloAll] {($how/$comWhere) $payInf}

        q!: * {($how $passPres) * ($buyN $ticketAndLottery)} *
        q!: [$helloAll] {($buyInf/$payInf) [$ticketAndLottery] (без $registration)}
        q!: * {$how * ($buyInf/$payInf) * $ticketAndLotteryAll * (без $registration)} *
        q!: * может * летний * $playInf *
        eg!: Lottery.HowToPlay
        a: Ознакомиться с инструкцией, как принять участие в лотерее на сайте, Вы можете, пройдя по ссылке https://www.stoloto.ru/lottery/onlinesale


    state: Quarantine
        # Карантин
        q!: [$helloAll] {$comWhere $buyInf}
        q!: [$helloAll] вы (работаете/работайте)
        q!: * {$comWhere * $buyInf * $ticketAndLotteryAll} *
        q!: * {$buyInf * [$ticketAndLotteryAll] * $quarantine} *
        q!: * {$buyInf * [$ticketAndLotteryAll] * $quarantine} *
        q!: * {$buyInf * [$ticketAndLotteryAll] * (из дома)} *
        q!: * $when буд* продавать $ticketAndLotteryAll *
        q!: * {буд* * продавать * точк*} *
        q!: * {буд* * продавать * ~киоск} *
        q!: * {буд* * продавать * ~центр} *
        q!: * {буд* * продавать * ~пункт} *
        q!: * {буд* * продавать * ~ларек} *
        q!: * {буд* * работать * точк*} *
        q!: * {буд* * работать * ~киоск} *
        q!: * {буд* * работать * ~центр} *
        q!: * {буд* * работать * ~пункт} *
        q!: * {буд* * работать * ~ларек} *
        q!: * в услови* $quarantine *
        q!: * {$quarantine * работ* * точк*} *
        q!: * {$quarantine * работ* * ~киоск} *
        q!: * {$quarantine * работ* * ~центр} *
        q!: * {$quarantine * работ* * ~пункт} *
        q!: * {$quarantine * работ* * ~ларек} *
        q!: * {$quarantine * прода* * точк*} *
        q!: * {$quarantine * прода* * ~киоск} *
        q!: * {$quarantine * прода* * ~центр} *
        q!: * {$quarantine * прода* * ~пункт} *
        q!: * {$quarantine * прода* * ~ларек} *
        q!: * {$quarantine * вы * прода*} *
        q!: * {[$quarantine] * закр* * точк*} *
        q!: * {[$quarantine] * закр* * ~киоск} *
        q!: * {[$quarantine] * закр* * ~центр} *
        q!: * {[$quarantine] * закр* * ~пункт} *
        q!: * {[$quarantine] * закр* * ~ларек} *
        q!: * {$quarantine * вы * закр*} *
        q!: * {[$quarantine] * откр* * точк*} *
        q!: * {[$quarantine] * откр* * ~киоск} *
        q!: * {[$quarantine] * откр* * ~центр} *
        q!: * {[$quarantine] * откр* * ~пункт} *
        q!: * {[$quarantine] * откр* * ~ларек} *
        q!: * {продолжа* * работать * точк*} *
        q!: * {продолжа* * работать * ~киоск} *
        q!: * {продолжа* * работать * ~центр} *
        q!: * {продолжа* * работать * ~пункт} *
        q!: * {продолжа* * работать * ~ларек} *
        q!: * {продолжа* * прода* * точк*} *
        q!: * {продолжа* * прода* * ~киоск} *
        q!: * {продолжа* * прода* * ~центр} *
        q!: * {продолжа* * прода* * ~пункт} *
        q!: * {продолжа* * прода* * ~ларек} *
        q!: * {продолжа* * работу * точк*} *
        q!: * {продолжа* * работу * ~киоск} *
        q!: * {продолжа* * работу * ~центр} *
        q!: * {продолжа* * работу * ~пункт} *
        q!: * {продолжа* * работу * ~ларек} *
        q!: * {*останов* * ~работа * ~точка} *
        q!: * {*останов* * ~работа * ~киоск} *
        q!: * {*останов* * ~работа * ~центр} *
        q!: * {*останов* * ~работа * ~пункт} *
        q!: * {*останов* * ~работа * ~ларек} *
        q!: * {*останов* * ~продажа * ~точка} *
        q!: * {*останов* * ~продажа * ~киоск} *
        q!: * {*останов* * ~продажа * ~центр} *
        q!: * {*останов* * ~продажа * ~пункт} *
        q!: * {*останов* * ~продажа * ~ларек} *
        q!: * {встанет * ~работа * ~точка} *
        q!: * {встанет * ~работа * ~киоск} *
        q!: * {встанет * ~работа * ~центр} *
        q!: * {встанет * ~работа * ~пункт} *
        q!: * {встанет * ~работа * ~ларек} *
        q!: * {*работают * ~точка} *
        q!: * {*работают * ~киоск} *
        q!: * {*работают * ~центр} *
        q!: * {*работают * ~пункт} *
        q!: * {*работают * ~ларек} *
        q!: * {откроет* * ~точка} *
        q!: * {откроет* * ~киоск} *
        q!: * {откроет* * ~центр} *
        q!: * {откроет* * ~пункт} *
        q!: * {откроет* * ~ларек} *
        q!: * {откроют* * ~точка} *
        q!: * {откроют* * ~киоск} *
        q!: * {откроют* * ~центр} *
        q!: * {откроют* * ~пункт} *
        q!: * {откроют* * ~ларек} *
        q!: * {продают* * ~точка} *
        q!: * {продают* * ~киоск} *
        q!: * {продают* * ~центр} *
        q!: * {продают* * ~пункт} *
        q!: * {продают* * ~ларек} *
        q!: * пока карантин *
        q!: * сейчас (работает/закрыт*) $stoloto *
        q!: * (работающ*/рабоч*/продающ*) (~точка/~киоск/~центр/~пункт/~ларек) *
        q!: * {~розыгрыш * (штатн* режим*)} *
        q!: * {работаете * (штатн* режим*)} *
        q!: * {разыгрываете * (штатн* режим*)} *
        eg!: Lottery.Quarantine
        a: В связи с распространением коронавируса с 28 марта временно приостановлена продажа билетов и выплата выигрышей в московском лотерейном центре «Столото» на Волгоградском проспекте и в собственных точках продаж «Столото». Все выигрыши будут выплачены победителям в полном объеме. Обратиться за получением выигрыша можно в течение трех с половиной лет с даты публикации результатов тиража. Приобрести лотерейные билеты можно на сайте https://www.stoloto.ru/


    state: LotteryRules
        # Правила лотереи
        q!: [$helloAll] [какие] условия ($prizeLocal/~розыгрыш) [в] [$lottery/лото/~игра/~розыгрыш] [$lotteriesForRules]
        q!: * какие условия $prizeLocal [в] ($lottery/лото/~игра/~розыгрыш) *
        q!: * какие условия $prizeLocal [в] [$lottery/лото/~игра/~розыгрыш] $lotteriesForRules *
        q!: * {(~какой ~условие $possiblePredic $winInf) * [$lotteriesForRules]} *
        q!: * при ~какой ~условие [в/по] [$lotteriesForRules] $ticket * счит* выигрышн* *
        q!: [$helloAll] [какие] правила [$lottery/лото/игры/~розыгрыш] [$lotteriesForRules]
        q!: * какие правила ($lottery/лото/игры/~розыгрыш) *
        q!: * какие правила [$lottery/лото/игры/~розыгрыш] [в] $lotteriesForRules *
        q!: * какие правила в ($lottery/лото/игре/розыгрыше) *
        q!: * какие правила в [$lottery/лото/игре/розыгрыше] $lotteriesForRules *
        q!: * $comWhere [$oneWord] (правила/условия [$prizeLocal]) [в] ($lottery/лото/~игра/~розыгрыш) *
        q!: * $comWhere [$oneWord] (правила/условия [$prizeLocal]) [в] [$lottery/лото/~игра/~розыгрыш] $lotteriesForRules *
        q!: * (*скаж*/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*) * (~правило/~условие) ($lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш) *
        q!: * (~правило/~условие) ($lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш) * (*скаж*/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*/какие) *
        q!: * (*скаж*/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/~информация/объяснит*/ознакомит*) * (~правило/~условие) [$lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш] [в] $lotteriesForRules *
        q!: * (~правило/~условие) [$lottery/лото/игры/начисления выигрыш* комбин*/ * ~розыгрыш] [в] $lotteriesForRules * (*скаж*/$findOutInf/*читать/прочесть/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*/ознакомит*/какие) *
        q!: * по каким критериям $winPastPres3 [в] $lotteriesForRules *
        q!: * [$lotteriesForRules] * сколько $comNeed [$oneWord] ($numeral/чисел) для $prizeLocal * [$lotteriesForRules] *
        q!: * (подробнее/вопрос) [узнать] (о/об/про/по) [$lottery/лото/~игра] $lotteriesForRules *
        q!: * (принцип/смысл) ($lottery/лото/~игра) *
        q!: * (принцип/смысл) [$lottery/лото/~игра] $lotteriesForRules *
        q!: * (сколько/какое количество/много) (чисел/номеров) должно (совпасть/выпасть) *
        q!: * (сколько/какое количество/много) * (чисел/номеров) * собрать * [$lotteriesForRules] *
        q!: * ~число выпал* $ticket считает* *
        q!: * {$how зачеркивать числа} *
        q!: * {$lotteriesForRules * (какие $ticket $winPresPl3)} *
        q!: * кто $winPresSg3 в ($lottery/лото/~игра) *
        q!: * кто $winPresSg3 в [$lottery/лото/~игра] $lotteriesForRules *
        q!: * $how будет проходить ($lottery/лото/~игра) *
        eg!: Lottery.LotteryRules
        if: $parseTree._RL
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto
        elseif: $parseTree._bingo
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/bingo75/rules
        elseif: $parseTree._6of45
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x45/rules
        elseif: $parseTree._matchball
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x50/rules
        elseif: $parseTree._5of36
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x36plus/rules
        elseif: $parseTree._4of20
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/4x20/rules
        elseif: $parseTree._zodiak
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zodiac/rules
        elseif: $parseTree._rapido
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido/rules
        elseif: $parseTree._rapido20
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido2/rules
        elseif: $parseTree._12of24
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/12x24/rules
        elseif: $parseTree._duel
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/duel/rules
        elseif: $parseTree._plusJoker
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/joker/rules
        elseif: $parseTree._top3
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/top3/rules
        elseif: $parseTree._keno
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/quickgames/keno?int=right
        elseif: $parseTree._housingLottery
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/gzhl/rules
        elseif: $parseTree._6of36
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x36/rules
        elseif: $parseTree._goldenShoe
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zp/rules
        elseif: $parseTree._7of49
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/7x49/rules
        else:
            a: Уточните, пожалуйста, какая лотерея Вас интересует?

        state: RussianLoto
            q: * $RL *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/ruslotto

        state: Bingo
            q: * $bingo *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/bingo75/rules

        state: 6of45
            q: * $6of45 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x45/rules

        state: Matchball
            q: * $matchball *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x50/rules

        state: 5of36
            q: * $5of36 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/5x36plus/rules

        state: 4of20
            q: * $4of20 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/4x20/rules

        state: Zodiak
            q: * $zodiak *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zodiac/rules

        state: Rapido
            q: * $rapido *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido/rules

        state: Rapido20
            q: * $rapido20 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/rapido2/rules

        state: 12of24
            q: * $12of24 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/12x24/rules

        state: Duel
            q: * $duel *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/duel/rules

        state: Joker
            q: * $plusJoker *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/joker/rules

        state: Top3
            q: * $top3 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/top3/rules

        state: Keno
            q: * $keno *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/quickgames/keno?int=right

        state: HousingLottery
            q: * $housingLottery *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/gzhl/rules

        state: 6of36
            q: * $6of36 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/6x36/rules

        state: GoldenShoe
            q: * $goldenShoe *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/zp/rules

        state: 7of49
            q: * $7of49 *
            a: Пройдите, пожалуйста, по ссылке https://www.stoloto.ru/7x49/rules

        state: Kubishka
            q: * $kubishka *
            a: «Кубышка» - дополнительный розыгрыш, который проводится не в каждом тираже. В «Кубышке» выигрывает тот билет, в котором все 4 невыпавшие числа находятся в верхнем или нижнем игровом поле. Поэтому, если по окончании основных туров у Вас остались четыре незачеркнутых числа, не расстраивайтесь, пожалуйста. Ведь, если все они в одном поле, Вы выиграли денежный приз.\n\nПодробнее с информацией Вы можете ознакомиться по ссылке https://www.stoloto.ru/ruslotto/rules

        state: BonusPlay
            q: ~бонусный
            q: * $bonusPlay *
            a: Данная информация указана на странице бонусной программы. Ознакомиться с информацией Вы можете по данной ссылке: https://www.stoloto.ru/private/bonus


    state: CanForeignersPlay
        # Могут ли играть иностранцы?
        q!: * $countryNotRussia (может/$canPresSg3Ne) $playInf *
        q!: * {$foreigner * $playInf} *
        q!: * {$foreigner * ~игра} *
        q!: * {$bePresSg1Ne * $russian * $playInf} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $playInf} *
        q!: * {$bePresSg1Ne * $russian * ~игра} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * ~игра} *
        q!: * {(я $ne из $russia) * $playInf} *
        q!: * {(я $ne из $russia) * ~игра} *
        q!: * {(я из $countryNotRussia) * $playInf} *
        q!: * {(я из $countryNotRussia) * ~игра} *
        q!: * $with $countryNotRussia * $playInf *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $playInf} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * ~игра} *
        q!: * {(~гражданин $countryNotRussia) * $playInf} *
        q!: * {(~гражданин $countryNotRussia) * ~игра} *
        q!: * {(~гражданин $countryNotRussia) * ~шанс} *
        q!: * {$foreignCitizenship * $playInf} *
        q!: * {$foreignCitizenship * ~игра} *
        q!: * {$comNo [у меня] $russianCitizenship} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * ($playInf/~игра) *
        q!: * ($playInf/~игра) * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$foreigner * $registerInfRefl} *
        q!: * {$foreigner * $registration} *
        q!: * {$bePresSg1Ne * $russian * $registerInfRefl} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $registerInfRefl} *
        q!: * {$bePresSg1Ne * $russian * $registration} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $registration} *
        q!: * {(я $ne из $russia) * $registerInfRefl} *
        q!: * {(я $ne из $russia) * $registration} *
        q!: * {(я из $countryNotRussia) * $registerInfRefl} *
        q!: * {(я из $countryNotRussia) * $registration} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $registerInfRefl} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $registration} *
        q!: * {(~гражданин $countryNotRussia) * $registerInfRefl} *
        q!: * {(~гражданин $countryNotRussia) * $registration} *
        q!: * {$foreignCitizenship * $registerInfRefl} *
        q!: * {$foreignCitizenship * $registration} *
        q!: * {$comNo [у меня] $russianCitizenship} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * ($registerInfRefl/$registration) *
        q!: * ($registerInfRefl/$registration) * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$foreigner * $buyInf} *
        q!: * {$bePresSg1Ne * $russian * $buyInf} *
        q!: * {$bePresSg1Ne * (резидент* $russia) * $buyInf} *
        q!: * {(я $ne из $russia) * $buyInf} *
        q!: * {(я из $countryNotRussia) * $buyInf} *
        q!: * {(я $livePresSg1 в $countryNotRussia) * $buyInf} *
        q!: * {(~гражданин $countryNotRussia) * $buyInf} *
        q!: * {$foreignCitizenship * $buyInf} *
        q!: * {$comNo [у меня] $russianCitizenship} * $buyInf *
        q!: * $buyInf * {$comNo [у меня] $russianCitizenship} *
        q!: * {$havePresSg1Ne [я] $russianCitizenship} * $buyInf *
        q!: * $buyInf * {$havePresSg1Ne [я] $russianCitizenship} *
        q!: * {$comNo [у меня] $russianPassport} * $buyInf *
        q!: * $buyInf * {$comNo [у меня] $russianPassport} *
        q!: * {$havePresSg1Ne [я] $russianPassport} * $buyInf *
        q!: * $buyInf * {$havePresSg1Ne [я] $russianPassport} *

        q!: * {$possiblePredicAll * $playInf * $nationality} *
        q!: * {мог* * $playInf * $nationality} *
        q!: * {$possiblePredicAll * $registerInfRefl * $nationality} *
        q!: * {мог* * $registerInfRefl * $nationality} *
        q!: * {$possiblePredicAll * $buyInf * $nationality} *
        q!: * {мог* * $buyInf * $nationality} *
        q!: * {$possiblePredicAll * $playInf * $only * $russian} *
        q!: * {мог* * $playInf * $only * $russian} *
        q!: * {$possiblePredicAll * $buyInf * $only * $russian} *
        q!: * {мог* * $buyInf * $only * $russian} *
        eg!: Lottery.CanForeignersPlay
        a: Для участия в лотереях на сайте понадобится SIM-карта с номером российского, украинского, белорусского, таджикского, казахстанского, молдавского, узбекистанского, армянского, азербайджанского и грузинского операторов связи для возможности завершения регистрации и дальнейшего получения информации. Существует определенная специфика получения выигрышей и оплаты НДФЛ иностранными гражданами.\n\n​С информацией, как зарегистрироваться в системе с помощью других операторов связи (не РФ), ознакомьтесь, пожалуйста, в разделе «Как участвовать в лотереях на сайте stoloto.ru»: https://www.stoloto.ru/lottery/onlinesale


    state: AreThereAnyInstantLotteries
        # У вас есть моментальные лотереи?
        q!: [$helloAll] [про] {$instant $ticketAndLotteryAll}
        q!: [$helloAll] [$beginningWords] {((есть/$comNo) [$li]) $instant}
        q!: [$helloAll] [$beginningWords] {$instant $ticketAndLotteryAll $comNo}
        q!: интересуют $instant
        q!: * {есть * $instant * $ticketAndLotteryAll} *
        q!: * {будут * $instant * $ticketAndLotteryAll} *
        q!: * {$comWhere * $instant * $ticketAndLotteryAll} *
        q!: * {$playInf * $instant * $ticketAndLotteryAll} *
        q!: * {$buyInf * $instant * $ticketAndLotteryAll} *
        q!: * {верните * $instant * $ticketAndLotteryAll} *
        q!: * {представлены * $instant * $ticketAndLotteryAll} *
        q!: * {доступны * $instant * $ticketAndLotteryAll} *
        q!: * {($ne доступны) * $instant * $ticketAndLotteryAll} *
        q!: * {$findInf * $instant * $ticketAndLotteryAll} *
        q!: * $comWhere * $forTo * стирать *
        q!: * {$ticketAndLotteryAll * $need * стирать} *
        q!: * {~игра * $need * стирать} *
        q!: * {$ticketAndLotteryAll * можно * стирать} *
        q!: * {~игра * можно * стирать} *
        q!: * {есть * стирать * $ticketAndLotteryAll} *
        q!: * {есть * стирать * ~игра} *
        q!: * {$comWhere * стирать * $ticketAndLotteryAll} *
        q!: * {$comWhere * стирают* * $ticketAndLotteryAll} *
        q!: * {$buyInf * стирать * $ticketAndLotteryAll} *
        q!: * {есть * стиралк*} *
        q!: * {$playInf * стиралк*} *
        q!: * {$comWhere * стиралк*} *
        q!: * {$buyInf * стиралк*} *
        q!: * {есть * стирашк*} *
        q!: * {$playInf * стирашк*} *
        q!: * {$comWhere * стирашк*} *
        q!: * {$buyInf * стирашк*} *
        eg!: Lottery.AreThereAnyInstantLotteries
        a: На сайте отключена продажа билетов моментальных лотерей. О включении лотерей мы сообщим в новостях, а пока спешите приобретать билеты моментальных лотерей в розничных точках продаж.


    state: MultiStack
        q!: * $multistack *
        eg!: Lottery.MultiStack
        a: Мультиставка - это функция, позволяющая сделать сразу много автоматических ставок. Вам нужно выбрать только количество билетов и оплатить их, система расставит случайные числа.


    state: ExpandedStack
        q!: * развернут* ~ставка *
        eg!: Lottery.ExpandedStack
        a: Развернутая ставка - это ставка, которая в одном или двух игровых полях содержит больше одной минимальной комбинации. Например, более 4 чисел в поле 1 и более 4 чисел в поле 2 для «Гослото «4 из 20», более 5 чисел в поле 1 и более 1 числа в поле 2 для «Гослото «5 из 36», более 6 чисел для «Гослото «6 из 45» и так далее. При развернутой ставке выбранные числа будут представлены как максимально возможное число неповторяющихся минимальных комбинаций. Это существенно повышает вероятность выигрыша, но и увеличивает цену билета. Выбрать все числа на игровом поле нельзя. Для каждой лотереи существуют ограничения по количеству выбранных чисел. Они могут отличаться на сайте и при покупке в розничной точке (это связано с установленными лимитами платежей).


    state: WhatIsMultiplier
        # Что такое множитель?
        q!: $multiplier
        q!: * $comWhat $oneWord $multiplier *
        q!: * $whatFor $oneWord $multiplier *
        q!: * (~какой ~цель) [$oneWord] $multiplier *
        q!: $multiplier $whatFor она $comNeed *
        q!: $multiplier {это $comWhat}
        q!: {[$beginningWords] [в чем] [заключа*] смысл $multiplier}
        eg!: Lottery.WhatIsMultiplier
        a: Множитель - это дополнительная опция, которая позволяет увеличить выигрыш. Если Вы выберете множитель, то сумма Вашего выигрыша увеличится кратно его значению. Стоимость билета также увеличится. Лотереи, в правилах которых есть множитель: «Рапидо», «Рапидо 2.0»,«КЕНО-Спортлото», «12/24», «Топ-3», «Дуэль».\n\nМножители используются в лотереях:\n\n- «Рапидо»;\n- «КЕНО-Спортлото»;\n- «12/24»;\n- «Топ-3»;\n- «Дуэль»;\n- «Джокер».


    state: WhatIsDistributionCirculation
        # Что такое распределительный тираж?
        q!: $distributionCirculation
        q!: * как понять $distributionCirculation *
        q!: * $comWhat $oneWord $distributionCirculation *
        q!: * $whatFor $oneWord $distributionCirculation *
        q!: * (~какой ~цель) [$oneWord] $distributionCirculation *
        q!: {[$beginningWords] [в чем] [заключа*] смысл $distributionCirculation}
        q!: $distributionCirculation $whatFor он $comNeed *
        q!: $distributionCirculation {это $comWhat}
        eg!: Lottery.WhatIsDistributionCirculation
        a: Распределительный тираж - это розыгрыш, в котором накопленная сумма суперприза или его часть делится между победителями тиража, если никто из участников этого тиража не выиграл суперприз единолично. Периодичность таких тиражей регулируется ФЗ «О лотереях». Он предписывает их проведение не реже одного раза в год, если в течение всего года суперприз никто не выигрывает. В случае если выигрышная комбинация при проведении распределительного тиража угадывается одним человеком, вся сумма суперприза достается этому человеку.


    #state: WhenWillTheDistributionCirculation
        # Когда будет распределительный тираж?
        #q!: [$helloAll] [а] ($when/какого числа) [в $russianLoto] ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($when/какого числа) $anniversaryDraw *
        #q!: * ($when/какого числа) [в $russianLoto] ($distributionCirculation/$anniversaryDraw)
        #q!: * ($when/какого числа) ($distributionCirculation/$anniversaryDraw) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) *
        #q!: * ($when/какого числа) ($distributionCirculation/$anniversaryDraw) [в] $russianLoto *
        #q!: * ($when/какого числа) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) * ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($distributionCirculation/$anniversaryDraw) ($when/какого числа) *
        #q!: * ($distributionCirculation/$anniversaryDraw) * ($when/какого числа) (состоит*/пройдет/будет/будит/разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют) *
        #q!: * {$anniversaryDraw * посмотреть * ~эфир} *
        #q!: * {$anniversaryDraw * узнать * дату} *
        #q!: [а] ($distributionCirculation/$anniversaryDraw) (состоит*/пройдет/будет/будит) 20 октября
        #q!: * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * $billion *
        #q!: * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #q!: * $billion * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #q!: * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * ($when/какого числа/в каком ($ticketRun/$ticketRunNumber)) *
        #q!: * {$when * $beFutSgPl3 * розыг* * $anniversaryDraw} *
        #q!: * {$when * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {$when * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {$when * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(какого числа) * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * разыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * розыг* * $billion} *
        #q!: * {(в каком $ticketRun) * $beFutSgPl3 * распред* * $billion} *
        #q!: * {(в каком $ticketRunNumber) * $beFutSgPl3 * распред* * $billion} *
        #q!: * какой ($ticketRunNumber/$ticketRun) (праздничный/юбилейный) *
        #q!: * ($when/какого числа) * ~трансляция * ($distributionCirculation/$anniversaryDraw) *
        #q!: * ($when/какого числа/~какой ~канал/$comWhere/во сколько) * (~трансляция/~передача/~эфир) * $russianLoto *
        #q!: * ($comWhere/~какой ~канал) * [~трансляция] * ($distributionCirculation/$anniversaryDraw) *
        #q!: * был* ли розыгрыш * ($distributionCirculation/$anniversaryDraw) *
        #q!: * (во сколько/в какое время) * $anniversaryDraw *
        #q!: * $anniversaryDraw * (был/прошел/началс*) *
        #eg!: Lottery.WhenWillTheDistributionCirculation
        #a: Трансляция тиража 1306 пройдет 20.10.2019 в 14:00 на НТВ.


    #state: QuestionsAboutABillion
        # Откуда вы уверены, что никто не возьмет джекпот?
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * разыг* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * розыг* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * {$beFutSgPl3 * распред* * $billion} *
        #q!: * (в каком случае/при ~какой ~условие/$how) * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) * $billion *
        #q!: * (в каком случае/при ~какой ~условие/$how) * * $billion * (разыгрывает*/разыгрывают*/разыграете/розыграют/разыграют/распределяет*/распределит*/распределят) *
        #eg!: Lottery.QuestionsAboutABillion
        #a: 89-й ход и распределение части накопленного суперприза в размере 1 млрд рублей будут проведены в случае, если накопленный суперприз на начало тиража будет составлять 1 млрд рублей или более и в этом тираже не будет выигрышей в категории «Джекпот».


    state: WhatIsKubishka
        # Что такое кубышка?
        q!: [$helloAll] ~вопрос [про/о] $kubishka
        q!: * $comWhat $oneWord $kubishka * [$winInf] *
        q!: * $whatFor $oneWord $kubishka * [$winInf] *
        q!: * (~какой ~цель) [$oneWord] $kubishka *
        q!: $kubishka $whatFor она $comNeed *
        q!: $kubishka {это $comWhat}
        q!: * $how {разыгрыв* $kubishka} *
        q!: * {(~какой ~условие $possiblePredic $winInf) * $kubishka} *
        q!: * при ~какой ~условие [в/по] $kubishka $ticket * счит* выигрышн* *
        q!: * (правил*/услови*) $kubishka *
        q!: [$helloAll] [какие] условия ($prizeLocal/~розыгрыш) [в] [$lottery/лото/~игра] $kubishka
        q!: * какие условия $prizeLocal [в] [$lottery/лото/~игра] $kubishka *
        q!: [$helloAll] [какие] правила [$lottery/лото/игры] $kubishka
        q!: * какие правила [$lottery/лото/игры] [в] $kubishka *
        q!: * $comWhere [$oneWord] (правила/условия [$prizeLocal]) [в] [$lottery/лото/~игра] $kubishka *
        q!: * (*скаж*/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/~информация/объяснит*) * (~правило/~условие) [$lottery/лото/игры] [в] $kubishka *
        q!: * (~правило/~условие) [$lottery/лото/игры] [в] $kubishka * (*скаж*/$findOutInf/*читать/$link/*интерес*/посмотреть/поглядеть/уточнит*/объяснит*) *
        q!: * по каким критериям $winPastPres3 [в] $kubishka *
        q!: * [$kubishka] * сколько $comNeed [$oneWord] ($numeral/чисел) для $prizeLocal * [$kubishka] *
        q!: * (подробнее/вопрос) [узнать] (о/об/про) [$lottery/лото/~игра] $kubishka *
        q!: * (принцип/смысл) [$lottery/лото/~игра] $kubishka *
        q!: * {$kubishka * (какие $ticket $winPresPl3)} *
        q!: * кто $winPresSg3 в [$lottery/лото/~игра] $kubishka *
        eg!: Lottery.WhatIsKubishka
        a: «Кубышка» - дополнительный розыгрыш, который проводится не в каждом тираже. В «Кубышке» выигрывает тот билет, в котором все 4 невыпавшие числа находятся в верхнем или нижнем игровом поле. Поэтому, если по окончании основных туров у Вас остались четыре незачеркнутых числа, не расстраивайтесь, пожалуйста. Ведь, если все они в одном поле, Вы выиграли денежный приз.\n\nПодробнее с информацией Вы можете ознакомиться по ссылке https://www.stoloto.ru/ruslotto/rules


    state: IWantToWin
        # Хочу выиграть
        q!: * {$want $winInf} *
        q!: * {мечта $winInf} *
        q!: * {$want $million} *
        q!: * {$want $jackpot} *
        q!: * надеюсь * ($something $winInf/на ($jackpot/победу)) *
        q!: * {$when [же/ж/уже] мне повезет} *
        q!: * может {мне повезет} *
        q!: * принеси* * ~удача *
        q!: ($jackpot/$million) [$beFutSgPl3] (мой/моим) [$repeat<$emoji>]
        q!: {[$helloAll] $when я (выиграю/выйграю/выеграю) [$oneWord]} [$repeat<$emoji>]
        q!: * $when [же/ж] {уже я (выиграю/выйграю/выеграю)} *
        q!: * $when (же/ж) я (выиграю/выйграю/выеграю) *
        q!: $comThanks [вам] за игру [$repeat<$emoji>]
        q!: $comThanks [вам] [за то] что вы есть [$repeat<$emoji>]
        eg!: Lottery.IWantToWin
        a: Желаем Вам удачи и будущих побед.


    state: Scam
        # Лохотрон
        q!: * ($lohotron/$fraud) *
        q!: * {выигрывают * подставные} *
        q!: * ($ne ~честный/нечестн*/ничестн*) ~игра *
        q!: * $when $beFutSgPl3 ~честный (~игра/~розыгрыш) *
        q!: * у вас честные розыгрыш* *
        eg!: Lottery.Scam
        a: Обращаем Ваше внимание на то, что мы работаем строго в соответствии с законодательством Российской Федерации. Вся наша деятельность регламентируется законом «О лотереях».\n\nШансы на успех есть всегда. Покупка билета лотереи не гарантирует выигрыш, однако ожидание процесса розыгрыша всегда интересно и волнующе.\n\nМы никогда не знаем о том, как пройдет розыгрыш и кто станет победителем, ведь наши лотереи проводятся с использованием оборудования, исключающего любое внешнее вмешательство.\n\nКаждый желающий может посмотреть розыгрыши лотерей в прямом эфире или лично приехать в единственный в мире лотерейный центр и своими глазами увидеть, как формируется выигрышная комбинация.


    state: ICantToWin
        # Не вариант выиграть
        q!: * {($cantPastPres/$ne вариант) $winInf} *
        q!: * {$nothing $winInfNe} *
        q!: * $nothing $ne (выигрываетс*/выигрываетьс*) *
        q!: * $winPresSn1Ne *
        q!: * (хрен/хер/фиг) [$here] [$comWhat] $winFutSg2 *
        q!: * $comWhere $obsceneWord побед* *
        q!: * [вы] ($ne даете/недаете/нидаете) [мне/людям] $winInf *
        q!: * $winPastPres3 (одни и те же/только (свои/крупные города/армян*/москвич*/москва)/одна москва) *
        q!: * (одни и те же/только (свои/крупные города/армян*/москвич*/москва)/одна москва) * $winPastPres3 *
        q!: * $why * больш* $prizeLocal * в моск* *
        q!: * куплен* $online $ticket $winPresPl3 *

        q!: * (помоги*/помож*) * $winInf *
        q!: * (помоги*/помож*) * {(погасить/закрыть) (ипотек*/[ипотеч*] ~кредит)} *
        q!: * (помоги*/помож*) * {стать (миллионер*/милионер*/~богатый/богач*)} *
        q!: * подарите мне шанс *
        q!: * $prizeLocal поделим *
        q!: * (сделайте/сделаете) * $forTo я $winPastPerf *
        q!: * (дайт*/дай) * ~нормальный сумм* *
        q!: * (дайт*/дай/дадите) * $winInf *
        q!: * начнете (давать/довать) * $winInf *
        q!: * раз * {дали * $winInf} *
        q!: [$helloAll] вероятность ($winInf/$prizeLocal)
        q!: * (~какой/каков*) [~процент/%] (~вероятность/~шанс) * ($winInf/на $prizeLocal) *
        q!: * (~какой/каков*) [~процент/%] (~вероятность/~шанс) (получить/сорвать) $jackpot *
        q!: * (~какой/каков*) (~процент/%) $prizeLocal *

        q!: * {$how * $winInf} *
        q!: * ($whatToDoInf/сколько * потратить) * $forTo * $winInf *
        q!: * $howMuch [мне] $comNeed проиграть $forTo $winInf *
        q!: * играю {$Number лет} дайте $comMoney *
        q!: * (фиг/невозможно) у вас стало $winInf *
        q!: * процент $win (упал/снизилс*/понизилс*/уменьшилс*) *
        eg!: Lottery.ICantToWin
        a: Повлиять на результат розыгрыша невозможно. Тиражи наших лотерей проводятся с использованием специального оборудования, которое отвечает за случайность выпадения чисел и исключает какое-либо вмешательство в свою работу.\n\nМы никогда не знаем, как пройдет розыгрыш и кто станет победителем.\n\nБлагодаря современным технологиям Вы можете выбрать подходящий способ участия в лотереях, а также посмотреть розыгрыши лотерей в прямом эфире или лично приехать в единственный в мире лотерейный центр и своими глазами увидеть, как формируется выигрышная комбинация.\n\nОбращаем Ваше внимание на то, что мы работаем строго в соответствии с законодательством Российской Федерации. Вся наша деятельность регламентируется законом «О лотереях».


    state: IsItPossibleToWin
        # Реально ли выиграть
        q!: * {$possibly * $winInf} *
        q!: {$hereAll $winPastPres3} [$repeat<$emoji>]
        q!: {($generally/$really) $winPastPres3} [$repeat<$emoji>]
        q!: {(люди/что-нибудь) $winPastPres3} [$repeat<$emoji>]
        q!: {$somebody $winPastPres3} [$repeat<$emoji>]
        q!: * {$hereAll ($generally/$really/хотя бы/хоть) $winPastPres3} *
        q!: * {(люди/что-нибудь/$somebody) ($generally/$really/хотя бы/хоть/$sometime) $winPastPres3} *
        q!: * кто $winPastPres3 есть *
        q!: * есть какие (нибудь/то) шансы (на $prizeLocal/$winInf) *
        q!: * {$hereAll (люди/что-нибудь/$somebody/$sometime) $winPastPres3} *
        q!: * больше $Number $rub ($winInfNe/$comNo $prizeLocal) *
        q!: * {$nobody [$hereAll] $winPresSn3Ne} *
        eg!: Lottery.IsItPossibleToWin
        a: Благодаря всероссийским государственным лотереям каждую неделю в нашей стране появляется 15 новых миллионеров, ежедневно выигрывают свыше 200 тысяч билетов. Более миллиарда рублей выплачивается победителям лотерей ежемесячно.\n\nНа официальной странице сайта «Столото» есть раздел «Победители», перейдя по ссылке www.stoloto.ru/winners, Вы можете прочитать истории людей и разработать личную стратегию игры.


    state: LuckLeftMe
        # Везение меня покинуло
        q!: * {$luck меня $leavePastSg3} *
        q!: {[вот] $again [я] (без $prizeLocal)}
        q!: * $again $comMy $ticket ($ne выиграл*/невыиграл*/нивыиграл*) *
        q!: * я $only (проигрываю/продуваю) *
        q!: * (одни/постоянно) проигрыш* *
        q!: * ($ne везет/невезет) *
        q!: * {($ne [~один] раз*/нираз*) [$nothing] $winPastPerfNe} *
        q!: * (постоян*/пастаян*/всегда/стабильно) (проигрыш*/проиграш*) *
        eg!: Lottery.LuckLeftMe
        a: Участие в лотерее нельзя рассматривать как источник дохода или выгодное вложение, где обязательно должна настать окупаемость затрат. Лотерея - это не банк.\n\nВо всем мире лотереи являются увлекательной формой досуга, семейной традицией, реальной возможностью в одночасье стать миллионером и изменить свою жизнь.\n\nВыигрыш в лотерею не зависит от количества купленных билетов и того, сколько лет Вы принимаете участие в лотерее.\n\nУчастие в лотерее не гарантирует выигрыш, но дает Вам уникальный шанс испытать удачу.


    #state: HowManyBarrelsWillRemainInNewYearEdition
        # Сколько бочонков останется в новогоднем тираже?
        #q!: * {(сколько боч*) * $newYear * $ticketRun} *
        #q!: * {(сколько шаров) * $newYear * $ticketRun} *
        #q!: * {(сколько боч*) * $newYear * $RL} *
        #q!: * {(сколько шаров) * $newYear * $RL} *
        #q!: * {(сколько боч*) * $newYear * $lotteryShow} *
        #q!: * {(сколько шаров) * $newYear * $lotteryShow} *
        #q!: * {(сколько боч*) * 1316} *
        #q!: * {(сколько шаров) * 1316} *
        #eg!: Lottery.HowManyBarrelsWillRemainInNewYearEdition
        #a: В мешке останется 2 бочонка.


    #state: WhenWillNewYearEdition
        # Когда трансляция Новогоднего тиража Русского лото 1316?
        #q!: * {$when * ~трансляция * $newYear * [рус* лото]} *
        #q!: * {$when * ~трансляция * $newYear * [рл]} *
        #q!: * $when * пройдет * $newYear * [рл/рус* лото] *
        #q!: * {(какого числа) * ~трансляция * $newYear * [рус* лото]} *
        #q!: * {(какого числа) * ~трансляция * $newYear * [рл]} *
        #q!: * {$when * ~трансляция * 1316} *
        #q!: * {(какого числа) * ~передача * $newYear * [рус* лото]} *
        #q!: * {(какого числа) * ~передача * $newYear * [рл]} *
        #q!: * {$when * ~передача * 1316} *
        #q!: * {(какого числа) * ~трансляция * 1316} *
        #q!: * {$when * $newYear * $lotteryShow * [рус* лото]} *
        #q!: * {$when * $newYear * $lotteryShow * [рл]} *
        #q!: * {(какого числа) * $newYear * $lotteryShow * [рус* лото]} *
        #q!: * {(какого числа) * $newYear * $lotteryShow * [рл]} *
        #q!: * {$when * ~эфир * 1316} *
        #q!: * {(какого числа) * ~эфир * 1316} *
        #q!: * {(в какое время) * $RL * $januaryFirst} *
        #eg!: Lottery.WhenWillNewYearEdition
        #a: Телетрансляции розыгрышей лотерей «Русское лото», «Золотая подкова», «Жилищная лотерея», «Бинго-75» и «6 из 36» проводятся каждое воскресенье в 8:20 на телеканале НТВ, в телепередаче «У нас выигрывают». Время трансляций в Вашем регионе может отличаться от указанного. Следите за ТВ-программой.
        #Трансляция новогоднего тиража лотереи «Русское лото» будет проходить на канале НТВ в прямом эфире для всей России 1 января 2020 года в 15:30 мск.


    #state: WillNewYearEditionBeLiveOrNot
        # Прямой или непрямой эфир тиража 1316
        #q!: * {~эфир * ~прямой * $newYear} *
        #q!: * {~эфир * ($ne ~прямой) * $newYear} *
        #q!: * {~эфир * ~непрямой * $newYear} *
        #q!: * {~эфир * ~прямой * 1316} *
        #q!: * {~эфир * ($ne ~прямой) * 1316} *
        #q!: * {~эфир * ~непрямой * 1316} *
        #q!: * {~эфир * ~прямой * $RL * $januaryFirst} *
        #q!: * {~эфир * ($ne ~прямой) * $RL * $januaryFirst} *
        #q!: * {~эфир * ~непрямой * $RL * $januaryFirst} *
        #q!: * {~трансляция * ~прямой * $newYear} *
        #q!: * {~трансляция * ($ne ~прямой) * $newYear} *
        #q!: * {~трансляция * ~непрямой * $newYear} *
        #q!: * {~трансляция * ~прямой * 1316} *
        #q!: * {~трансляция * ($ne ~прямой) * 1316} *
        #q!: * {~трансляция * ~непрямой * 1316} *
        #q!: * {~трансляция * ~прямой * $RL * $januaryFirst} *
        #q!: * {~трансляция * ($ne ~прямой) * $RL * $januaryFirst} *
        #q!: * {~трансляция * ~непрямой * $RL * $januaryFirst} *
        #eg!: Lottery.WillNewYearEditionBeLiveOrNot
        #Трансляция новогоднего тиража лотереи «Русское лото» будет проходить на канале НТВ в прямом эфире для всей России 1 января 2020 года в 15:30 мск.


    #state: MoscowTimeForNewYearEditionOrNot
        # время новогоднего розыгрыша московское или нет
        #q!: * {$newYear * (по какому времени)} *
        #q!: * {1316 * (по какому времени)} *
        #q!: * {~время * моск* * $newYear} *
        #q!: * {~время * моск* * 1316} *
        #q!: * {~время * мск * $newYear} *
        #q!: * {~время * мск * 1316} *
        #q!: * {~время * ~местный * $newYear} *
        #q!: * {~время * ~местный * 1316} *
        #eg!: Lottery.MoscowTimeForNewYearEditionOrNot
        #Трансляция новогоднего тиража лотереи «Русское лото» будет проходить на канале НТВ в прямом эфире для всей России 1 января 2020 года в 15:30 мск.


    #state: WhenWillBingoEdition
        # Когда трансляция Новогоднего тиража бинго лотерей?
        #q!: * {$when * ~трансляция * $newYear * $bingo} *
        #q!: * {(какого числа) * ~трансляция * $newYear * $bingo} *
        #q!: * {$when * ~трансляция * $newYear * $housingLottery} *
        #q!: * {(какого числа) * ~трансляция * $newYear * $housingLottery} *
        #q!: * {$when * ~трансляция * $newYear * $goldenShoe} *
        #q!: * {(какого числа) * ~трансляция * $newYear * $goldenShoe} *
        #q!: * {$when * ~трансляция * $newYear * $6of36} *
        #q!: * {(какого числа) * ~трансляция * $newYear * $6of36} *

        #q!: * {$when * ~передача * $newYear * $bingo} *
        #q!: * {(какого числа) * ~передача * $newYear * $bingo} *
        #q!: * {$when * ~передача * $newYear * $housingLottery} *
        #q!: * {(какого числа) * ~передача * $newYear * $housingLottery} *
        #q!: * {$when * ~передача * $newYear * $goldenShoe} *
        #q!: * {(какого числа) * ~передача * $newYear * $goldenShoe} *
        #q!: * {$when * ~передача * $newYear * $6of36} *
        #q!: * {(какого числа) * ~передача * $newYear * $6of36} *

        #q!: * {$when * $lotteryShow * $newYear * $bingo} *
        #q!: * {(какого числа) * $lotteryShow * $newYear * $bingo} *
        #q!: * {$when * $lotteryShow * $newYear * $housingLottery} *
        #q!: * {(какого числа) * $lotteryShow * $newYear * $housingLottery} *
        #q!: * {$when * $lotteryShow * $newYear * $goldenShoe} *
        #q!: * {(какого числа) * $lotteryShow * $newYear * $goldenShoe} *
        #q!: * {$when * $lotteryShow * $newYear * $6of36} *
        #q!: * {(какого числа) * $lotteryShow * $newYear * $6of36} *

        #q!: * {(28/29) * $bingo} *
        #q!: * {(28/29) * $housingLottery} *
        #q!: * {(28/29) * $goldenShoe} *
        #q!: * {(28/29) * $6of36} *
        #eg!: Lottery.WhenWillBingoEdition
        #Трансляция новогоднего тиража «Жилищной лотереи», «6 из 36», «Золотой подковы», «Бинго-75» состоится 01.01.2020 в 8:20 мск на НТВ. Трансляция новогоднего тиража лотереи «Русское лото» состоится на НТВ в прямом эфире 1 января 2020 года в 15:30 мск.


    #state: WhatAreThePrizesOfTheNewYearEdition
        # Что будет разыграно в тираже 1316?
        #q!: * ($comWhat/$billion) $beFutSgPl3 (разыгран*/разыгрывать) * ($newYear/1316) *
        #q!: * {($comWhat разыгрывает*) * ($newYear/1316)} *
        #q!: * {($comWhat разыгрывают*) * ($newYear/1316)} *
        #q!: * {($comWhat могу выиграть) * ($newYear/1316)} *
        #q!: * {($comWhat $possiblePredic выиграть) * ($newYear/1316)} *
        #q!: * {~какой приз* * ($newYear/1316)} *
        #q!: * {(приз* ~фонд) * ($newYear/1316)} *
        #q!: * {(о призах) * ($newYear/1316)} *
        #eg!: Lottery.WhatAreThePrizesOfTheNewYearEdition
        #a: В новогоднем тираже «Русского лото» будет гарантированно разыгран 1 миллиард рублей. Вы выигрываете Миллиард, если у Вас на пятнадцатом ходу все пятнадцать чисел одного из двух игровых полей билета (верхнего или нижнего) совпадут с номерами бочонков, извлеченных из мешка. Если Джекпот не будет разыгран, то Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. В прошлом году миллиард разделили двое победителей. Так что место первого лотерейного миллиардера пока свободно! Также в тираже разыгрывается от 100 призов по 1 миллиону рублей и тысячи денежных призов, останется 2 бочонка – выигрывает каждый второй билет!


    state: WhatDoesItMeanEverySecondWins
        # Что значит Выигрывает каждый второй билет?
        q!: * (выигрывает/побеждает) каждый (второй/2 ой/2ой) *
        q!: * каждый (второй/2 ой/2ой) * (выигрывает/побеждает) *
        eg!: Lottery.WhatDoesItMeanEverySecondWins
        a: Фраза «Выигрывает каждый второй билет!» означает, что вероятность совпадения 30 чисел билета до 88-го хода (при общем количестве чисел в билете, равном 30, и общем количестве бочонков в мешке, равном 90) включительно лежит в диапазоне от 1 к 2,37 до 1 к 2,25.


    #state: WhoCanWinABillion
        # Кто может выиграть миллиард?
        #q!: * кто * $winInf [1/2] $billion *
        #q!: * кто * $billion * $winInf *
        #q!: * {((один/1) (человек/участник)) * $billion * $winInf} *
        #q!: * {((два/2) (человека/участника)) * $billion * $winInf} *
        #q!: * {(только один/два могут/двое могут) * $billion * $winInf} *
        #q!: * {((один/1) (человек/участник)) * $billion * выиграет} *
        #q!: * {((два/2) (человека/участника)) * $billion * выиграют} *
        #q!: * {(сколько (человек/участников)) * $billion * $winInf} *
        #q!: * {(несколько (человек/участников)) * $billion * $winInf} *
        #q!: * {(сколько (человек/участников)) * $billion * выиграют} *
        #q!: * {(несколько (человек/участников)) * $billion * выиграют} *
        #q!: * {(только один/два могут/двое могут/несколько могут) * $billion * $winInf} *
        #q!: * {(сколько победителей) * розыгрыш* * $billion} *
        #q!: * {(несколько победителей) * розыгрыш* * $billion} *
        #q!: * {(один победитель) * розыгрыш* * $billion} *
        #q!: * {(двое победителей) * розыгрыш* * $billion} *
        #q!: * сколько $ticket (может/могут) $winInf $billion *
        #eg!: Lottery.WhoCanWinABillion
        #a: Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. Если победителей в этом туре будет несколько, то миллиард будет поделен на количество победителей.


    #state: HowBillionWillBePlayed
        # Как будет разыгран 1 млрд
        #q!: * $how * {$billion * ((будет/будит) разыгран)} *
        #q!: * $billion * $how * ((будет/будит) разыгран) *
        #q!: * $how * {$billion * ((будет*/будит*) разыгрыват*)} *
        #q!: * $billion * $how * ((будет*/будит*) разыгрыват*) *
        #q!: * $how * {$billion * разыграете} *
        #q!: * $billion * $how * разыграете *
        #q!: * (правда/реально/серьезно) * {$billion * разыграете} *
        #eg!: Lottery.HowBillionWillBePlayed
        #a: В новогоднем тираже «Русского лото» будет гарантированно разыгран миллиард рублей. Миллиард выиграет билет или билеты, в которых раньше других совпадут все 15 чисел в одном из полей. В прошлом году миллиард разделили двое победителей. Так что место первого лотерейного миллиардера пока свободно! Также в розыгрыше от 100 призов по 1 миллиону рублей и тысячи денежных призов, останется 2 бочонка - выигрывает каждый второй билет.


    #state: WhyThePrizeFundIsTwoBillion
        # Почему призовой фонд не 1 млрд, а 2 млрд
        #q!: * {[$why] * (призов* фонд*) * ($comTwo $billion)} *
        #q!: * {[$why] * (призов* фонд*) * (больше [чем] (~один/1) $billion)} *
        #q!: * {($comTwo $billion) $or (один/1)} *
        #q!: * {((один/1) $billion) $or $comTwo} *
        #q!: * {$why * разыгрывает* * ($comTwo $billion)} *
        #q!: * {$why * разыграете * ($comTwo $billion)} *
        #q!: * {$why * разыгрывает* * (больше [чем] (~один/1) $billion)} *
        #q!: * {$why * разыграете * (больше [чем] (~один/1) $billion)} *
        #eg!: Lottery.WhyThePrizeFundIsTwoBillion
        #a: 2 млрд (2,5; 3 млрд) - это призовой фонд тиража 1316, т.е. сумма, полученная от продаж билетов на этот тираж. Из этой суммы будут выплачены выигрыши победителям данного тиража. А 1 миллиард будет сформирован из накопленного Джекпота и приза второго тура, сумма которого будет равна той сумме, которой недостаточно до миллиарда (например, Джекпот к началу новогоднего тиража 800 млн, значит приз второго тура будет 200 млн, итого выигрыш 1 миллиард).


    #state: HowWillAnotherBillionBeFormed
        # Откуда вы возьмете 1 миллиард?
        #q!: * $fromWhere * (возьмет*/сформирует*) * (один/1/дополнительн*/другой) $billion *
        #q!: * (один/1/дополнительн*/другой) $billion * $fromWhere * (возьмет*/сформирует*) *
        #q!: * $comWhere * возьмет* * (один/1/дополнительн*/другой) $billion *
        #q!: * (один/1/дополнительн*/другой) $billion * $comWhere * возьмет* *
        #q!: * ($how/за счет чего) сформирует* $billion *
        #q!: * {$how * сформирует* * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {$how * ((будет/будит) сформирован) * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {(за счет чего) * сформирует* * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #q!: * {(за счет чего) * ((будет/будит) сформирован) * (([еще] (один/1)/дополнительн*/другой) $billion)} *
        #eg!: Lottery.HowWillAnotherBillionBeFormed
        #a: Миллиард будет сформирован за счет накопленного джекпота + приза второго тура.


    #state: WhyAreYouClaimingThatBillionWillBePlayed
        # Почему вы утверждаете, что 1 миллиард будет точно разыгран?
        #q!: * $billion (будет/будит) точно разыгран *
        #q!: * {$why * уверены * ($billion (будет/будит) разыгран)} *
        #q!: * {~уверенность * ($billion (будет/будит) разыгран)} *
        #q!: * {$why * уверены * (разыграете $billion)} *
        #q!: * {~уверенность * (разыграете $billion)} *
        #q!: * (если/вдруг) $billion ($ne (будет/будит)/небудет/небудит/нибудет/нибудит) разыгран * (джек пота/джек-пота/джекпота/джэк пота/джэк-пота/джэкпота) *
        #q!: * (если/вдруг) $billion ($ne (разыграют)/неразыграют/ниразыграют) * (джек пота/джек-пота/джекпота/джэк пота/джэк-пота/джэкпота) *
        #eg!: Lottery.WhyAreYouClaimingThatBillionWillBePlayed
        #a: Если миллиард не будет разыгран в ходе розыгрыша Джекпота, то второй тур не остановится, пока не будет определен победитель (пока у кого-то из участников не закроется полностью одно из полей раньше других).


    #state: WhyWasOnlyOneBillionPlayed
        # Почему был разыгран 1 млрд., а обещали 2 млрд.
        #q!: * {$why * разыгран * ($only (1/один) $billion)} * 
        #q!: * {$why * разыграли * ($only (1/один) $billion)} * 
        #q!: * (разыгран/разыграли) * [$only] (1/один) $billion * (обещал*/обещан*) * (2/два) *
        #q!: * (разыгран/разыграли) * [$only] (1/один) (а/но/хотя) (обещал*/обещан*) * (2/два) $billion *
        #q!: * (обещал*/обещан*) * (2/два) $billion * (разыгран/разыграли) * [$only] (1/один) *
        #q!: * (обещал*/обещан*) * (2/два) (а/но) (разыгран/разыграли) * [$only] (1/один) $billion *
        #q!: * ($ne разыграл*/неразыграл*/$ne разыгран*/неразыгран*) * второй $billion *
        #q!: * второй $billion * ($ne разыграл*/неразыграл*/$ne разыгран*/неразыгран*) *
        #q!: * куда {дел* второй $billion} *
        #eg!: Lottery.WhyWasOnlyOneBillionPlayed
        #a: 2 млрд (2,5; 3 млрд) - это призовой фонд тиража 1316, т.е. сумма, полученная от продаж билетов на этот тираж. Из этой суммы будут выплачены выигрыши победителям данного тиража. А 1 миллиард  сформирован из накопленного Джекпота и приза второго тура, сумма которого равна той сумме, которой недостаточно до миллиарда.


    state: IsItAPrivateLotteryOrNot
        # Это частная лотерея или государственная?
        q!: * {частн* $or государствен*} (игра/$lottery/контора) *
        q!: * (частн*/государствен*/$ne государствен*/негосударствен*) (игра/$lottery/контора) $or *
        q!: * {частн* $or госигра} *
        q!: * {частн* $or гослотерея} *
        q!: * (игра/$lottery/контора) [эта/ваша] {частн* $or государствен*} *
        q!: * (игра/$lottery/контора) [эта/ваша] {частн* $or $comNo} *
        q!: * (игра/$lottery/контора) [эта/ваша] {государствен* $or $comNo} *
        q!: * (врете/правда) * это государствен* (игра/$lottery/контора) *
        q!: [$helloAll] [$beginningWords] [$stoloto] это (частн*/государствен*/$ne государствен*/негосударствен*) (игра/$lottery) [$or $comNo]
        q!: * руководит (государств*/частн*) *
        eg!: Lottery.IsItAPrivateLotteryOrNot
        a: Акционерное общество «Технологическая Компания «Центр» - частная компания-распространитель государственных лотерей. Наша компания объединяет все лотереи страны, организаторы которых - Министерство финансов РФ и Министерство спорта РФ. В правилах к каждой лотерее есть информация об ее организаторе. Также вся информация представлена в этом разделе: http://www.stoloto.ru/legal



































