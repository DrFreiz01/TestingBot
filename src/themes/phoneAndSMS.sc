theme: /Phone

    state: PhoneNumberChange
        # Как изменить номер телефона?
        q!: * ($changeInf/$changeImp/отсоединит*) моб *
        q!: * отсоединит* ($telephone/$number $telephone) *

        q!: * {$changeInfImpAll * $phoneAndNum} * [$ne меняя $mail] * [$duringRegistration указ* другой] *

        q!: * ($correction/$changeNoun/$changeNe) * $phoneAndNum *
        q!: * $phoneAndNum * ($correction/$changeNoun/$changeNe) *

        q!: * {$wrong ($number $telephone)} *
        q!: * $incorrectly * ($number $telephone/$telephone) * [$mail $correct] *
        q!: * $phoneAndNum * $incorrectly * [$mail $correct] *
        q!: * {$belongPresSg3Ne * $phoneAndNum} *

        q!: [$helloAll] [$comMy] $correct $phoneAndNum $localMobilePhoneNumber
        q!: [$helloAll] [$comMy] [$correct] $phoneAndNum $localMobilePhoneNumber а $ne $localMobilePhoneNumber
        q!: [$helloAll] [$comMy] [$correct] $phoneAndNum $ne $localMobilePhoneNumber а $localMobilePhoneNumber
        q!: [$helloAll] $localMobilePhoneNumber [$comMy] [$correct] $phoneAndNum а $ne $localMobilePhoneNumber

        q!: * (вместо/заместо) $localMobilePhoneNumber $comNeed $localMobilePhoneNumber *
        q!: * {$indicatePartPas * ($notThat ($number $telephone/$telephone))} *

        q: * $telephone * || fromState = /Account/HowToChangeData
        q: * ({$number ($telephone/тлф/телефон*/тел)}/номертелефон*/тлф) * || fromState = /Account/HowToChangeData

        eg!: Phone.PhoneNumberChange
        a: Уточните, пожалуйста, Вы неверно указали номер при регистрации или хотите изменить номер телефона в личном кабинете?

        state: DuringRegistration
            q!: * $incorrectly набран* $phoneAndNum $duringRegistration *
            q!: * {$indicatePast * ($wrong $number) * $duringRegistration} *
            q!: * {$indicatePast * $incorrectly * $number * $duringRegistration} *
            q!: * {$phoneAndNum * $incorrectly * $indicatePast} *
            q!: * {$phoneAndNum * $mistakenly * $indicatePast} *

            q!: * {$indicatePartPas * $incorrectly * $number * $duringRegistration} *
            q!: * $duringRegistration * $indicatePartPas * $localMobilePhoneNumber * ($changeInf/$changeImp) *

            q!: * {$changeInfAll * $code * ($old $phoneAndNum)} *
            q!: * {$indicatePast * ($notThat $phoneAndNum)} *
            q!: * {$indicatePast * ($phoneAndNum $notThat)} *
            q!: * {$indicatePartPas * ($notThat ($number $telephone/$telephone)) * $duringRegistration} *
            q!: * $telephone $notThat после $registration *
            q!: * [$changeInfImpAll] * $indicatePast * {$wrong $number} * [$changeInfImpAll] *
            q!: * [$changeInfImpAll] * {$wrong $number} * $indicatePast * [$changeInfImpAll] *
            q!: * {$indicatePartPas * ($wrong $number) * $duringRegistration} *
            q!: * {$registration * $finishInf * ($wrong $phoneAndNum)} *
            q!: * {$registration * $finishInf * ($phoneAndNum $wrong)} *

            q!: * $changeInf $phoneAndNum $duringRegistration *

            q!: * [$changeInfAll] * {($makeAMistakePast/[$with] $mistake) ([в/$with] $telephoneNumber)} * [$changeInfAll] *
            q!: * {$makeAMistakePast * $numeral * ($telephone/$number $telephone) * [$duringRegistration]} *
            q!: * {($ne ту $numeral) * $phoneAndNum} *
            q!: * ошибочн* забит* ($telephone/$number $telephone) *
            q!: * $phoneAndNum $indicatePast ошибочн* *
            q!: * $phoneAndNum * $incorrectly * $numeral *
            q!: * {$mixUpPast3 * ($telephone/$number $telephone)} *
            q!: * (продолжаю/продолжить) $registration * $changeInfAll * $phoneAndNum *
            q!: * ввести верный ($telephone/$number $telephone) *
            q!: [$helloAll] $localMobilePhoneNumber [$comMy] [$correct] $phoneAndNum а $indicatePast $localMobilePhoneNumber
            q!: [$helloAll] [$comMy] [$correct] $phoneAndNum $localMobilePhoneNumber а $indicatePast $localMobilePhoneNumber

            q: первое
            q: * $duringRegistration *
            q: * когда * $registerPastRefl3 *
            q: * когда (проходил*/делал*) $registration *
            q: * когда (делал*/создавал*/заводил*) $account *
            q: * {$indicatePast * $incorrectly} *
            q: * $telephone * || fromState = /Account/HowToChangeDataAtRegistration
            q: * ({$number ($telephone/тлф/телефон*/тел)}/номертелефон*/тлф) * || fromState = /Account/HowToChangeDataAtRegistration

            eg!: Phone.PhoneNumberChange.DuringRegistration
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты, которые указывали при регистрации, а также верный номер телефона.

            state: GetUserData || fromState = /Phone/PhoneNumberChange/DuringRegistration
                q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$phoneAndNum] $localMobilePhoneNumber} *
                q: * [$helloAll] [$comMy] [$mail] $localEmail *
                q: * [$helloAll] [$comMy] [$phoneAndNum] $localMobilePhoneNumber *
                script: Webim.switch();

        state: InLK
            q!: * ~утрата ($number $telephone) *
            q!: * {((больше/уже) $belongPresSg3Ne) * $phoneAndNum} *
            q!: * [$duringRegistration] * $indicatePartPas * $phoneAndNum * давно закрыт* *
            q!: * пользуюс* новым $phoneAndNum * [$changeInfAll] *
            q!: * {$changeInfImpAll * $phoneAndNum} * (давно [уже] отсут*/$with которого [я] $registerPast3/{$phoneAndNum другой}/новый $phoneAndNum/заблокировал*/заблокирован*/~доступ к ~старый/на актуальный/указан* старый/старый на новый/(старый/прежний) (потерян/утерян/утерен/$existNeSg3)/$number * (больше/уже) ($ne обслужив*/$old/$usedPresNe/$existNeSg3)) *
            q!: * ($telephone/$number $telephone) (больше/уже) ($ne обслужив*/$old/$usedPresNe/$existNeSg3) *
            q!: * ($changeInf/$changeImp/отсоединит*) моб * $account *
            q!: * отсоединит* ($telephone/$number $telephone) * $account *
            q!: * {$changeInfImpAll * $phoneAndNum * $inLK} *
            q!: * {$correction * $phoneAndNum * $inLK} *
            q!: * {$changeNoun * $phoneAndNum * $inLK} *
            q!: * {$changeNe * $phoneAndNum * $inLK} *
            q!: * $changeInfImpAll * ($telephone/$number $telephone) * ($tiedM/относящ*/привяз*) * $account *
            q!: * $changeInfImpAll * ($telephone/$number $telephone) * $account * ($tiedM/относящ*/привяз*) *
            q!: * {$phoneAndNum * $incorrectly * $account} *
            q!: * {$phoneAndNum * $incorrectly * (на [$comMy] странице)} *
            q!: * {$phoneAndNum  * $belongPresSg3Ne * $account} *
            q!: * {$changeInf * (зарегестр* $phoneAndNum)} *
            q!: * {$changeInf * (привязан* [к $oneWord] $phoneAndNum)} *
            q!: * {$changeInf * ($phoneAndNum [который] привязан*)} *
            q!: * {$indicatePartPas * ($notThat ($number $telephone/$telephone)) * $account} *
            q!: * ($changeInfAll/отсоединит*/привязан) старый (моб/$phoneAndNum) *
            q!: * {$wrong ($number $telephone)} * $account *
            q!: * $account * {$wrong ($number $telephone)} *
            q!: * (потерян/утерян/утерен) $telephoneNumber (кот*/кат*) * ($tiedM/относящ*/привязан*) * $account *
            q!: * (потерян/утерян/утерен) $telephoneNumber (кот*/кат*) * $account * ($tiedM/относящ*/привязан*) *
            q!: * [$changeInfAll/отсоединит*] * {$changePast * $phoneAndNum} * [на новый] * [$changeInfAll/отсоединит*] *
            q!: * ($number $telephone) (прежний/старый) (потерян/утерян/утерен) *
            q!: * (потерян/утерян/утерен) ($number $telephone) *
            q!: * ($blockInf/$blockImpFut) * $phoneAndNum *
            q!: * $phoneAndNum * ($blockInf/$blockImpFut) *
            q!: * у меня обновилс* $phoneAndNum *
            q!: * $attachInf к другому $phoneAndNum $application *
            q!: * $phoneAndNum другой $mail (тот/та) же *
            q!: * $telephone [$number] [котор*/катор*] [был] (указан* в $account/[указан*] $duringRegistration) [уже/давно] ($old/$existNeSg3/заблокирован*) *
            q!: * {$changeInfAll * ($old $phoneAndNum)} *
            q!: * {(в анкет*) * ($old $phoneAndNum)} *
            q!: * ($old ($phoneAndNum/$simCard)) (потерян*/утерян*/утерен*) *
            q!: * {(у $meGen) * ($new $phoneAndNum)} *
            q!: * {$appendInf [$new/действующ*/актуальн*] $phoneAndNum} *
            q!: [$comMy] новый $phoneAndNum $localMobilePhoneNumber
            q!: * {перейти * (на другую $simCard)} *
            q!: * $simCard [больше/уже] $usedPresNe *
            q!: * этим ($number $telephone/$telephone) [больше/уже] $usedPresNe *
            q!: * $usedPresNe [больше/уже] эт* ($simCard/[$number] $telephone) *
            q!: {$comNo ~доступ} [к] [~старый/~прежний] $phoneAndNum
            q!: * {$comNo ~доступ} к (~старый/~прежний) $phoneAndNum *
            q!: [к] [~старый/~прежний] $phoneAndNum {$comNo ~доступ}
            q!: * $registerPast3 $with другим $phoneAndNum *
            q!: * (вместо/заместо) $localMobilePhoneNumber $comNeed $localMobilePhoneNumber * $account *
            q!: * $comNow [у меня] $phoneAndNum ($ne рабоч*/нерабоч*/нирабоч*) *

            q: второе
            q: * в [$comMy] ($account/анкет*/$application) *
            q: * на (сайте/[$comMy] странице) *
            q: * к старому ($comNo/потерял*/потерян*/утерян*/утерен*) доступ* *
            q: * старый недоступен *
            q: * старый на новый *
            q: * {старый * $lostPast} *
            q: [я] {[$want] $changeInf [$phoneAndNum]}
            q: * вличном *
            q: * $telephone * || fromState = /Account/HowToChangeDataInLK
            q: * ({$number ($telephone/тлф/телефон*/тел)}/номертелефон*/тлф) * || fromState = /Account/HowToChangeDataInLK

            eg!: Phone.PhoneNumberChange.InLK
            a: Номер мобильного телефона является главным идентификатором пользователя на сайте. Именно к этому номеру привязывается Ваш Кошелек. Поскольку замена номера, привязанного к Вашему счету в Кошельке, невозможна, то и номер в личном кабинете тоже изменить нельзя (замена номеров в Кошельках может привести к путанице в учетных записях и неверному зачислению денег). Об этом мы Вас обязательно предупреждаем на странице регистрации http://www.stoloto.ru/registration. Если у Вас нет доступа к номеру телефона, указанному при регистрации личного кабинета, то вам стоит пройти регистрацию с новым номером и дальше принимать участие в лотереях только с нового личного кабинета. Для регистрации нового личного кабинета Вам будет нужно указать другой адрес электронной почты. Если Вам пришлось завести новый адрес электронной почты специально для регистрации, настройте переадресацию писем на тот, который Вы чаще используете.

            state: NoNumber
                # Того номера нет
                q: * {$phoneAndNum * $comNo} *
                q: * {его * $comNo} *
                q: * {его * $usedPresNe} *
                q: * {$phoneAndNum * $usedPresNe} *
                q: * как * быть *
                q: * $comWhat * делать *
                q: * {$comNo * ~доступ} *
                a: Если у Вас более нет доступа к телефонному номеру, самое удобное решение - пройти регистрацию с новым номером и дальше принимать участие в лотереях только с новой учетной записи. Вам будет нужно указать другой адрес электронной почты. Если Вам пришлось завести новый адрес электронной почты специально для регистрации, настройте переадресацию писем на тот, который Вы чаще используете.


    state: IncorrectlyIndicatedThePhoneWhenBuyingATicket
        # Неправильно указала номер телефона при покупке билета
        q!: * {($ne ту $numeral) * $phoneAndNum * ($duringRegistration $ticketAll)} *
        q!: * {$makeAMistakePast * $numeral * $telephone * ($duringRegistration $ticketAll)} *
        q!: * {$makeAMistakePast * $numeral * ($number $telephone) * ($duringRegistration $ticketAll)} *
        q!: * {([$duringRegistration] $ticketAll) * $incorrectly * $telephone} *
        q!: * {($duringRegistration $ticketAll) * $telephone * опечат*} *
        q!: * {$retailPointOfSale * $incorrectly * $telephone} *
        q!: * $ticketAll $attachPast ($incorrectly/$mistakenly) к $other $phoneAndNum *
        q!: * {$salesman * $incorrectly * $indicatePast * $phoneAndNum} *
        q!: * {$salesman * $mixUpPast3 * $phoneAndNum * $ticketAll} *
        q!: * ($salesman/при $buyN/при покупке) * перепутан* * $phoneAndNum *
        q!: * {$salesman * $mistake * $phoneAndNum * [$ticketAll]} *
        q!: * {$retailPointOfSale * $buyPastPres} * $makeAMistakePast * $numeral *

        q!: * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] * {$incorrectly * $indicatePast * $phoneAndNum} *
        q!: * {$incorrectly * $indicatePast * $phoneAndNum} * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] *

        q!: * пробил* * $ticketAll * {$incorrectly * $indicatePast * $phoneAndNum} *
        q!: * $ticketAll * $winPastPerf * {$incorrectly * $indicatePartPas * $phoneAndNum} *
        q!: * $ticketAll * $winPastPerf * {$incorrectly * $indicatePast * $phoneAndNum} *

        q!: * {$salesman * $indicatePast * $wrong * $phoneAndNum} *
        q!: * {$salesman * $indicatePast * $notThat * $phoneAndNum} *
        q!: * {(при продаже) * $indicatePast * $wrong * $telephone} *
        q!: * {(при продаже) * $indicatePast * $notThat * $telephone} *
        q!: * {(при $buyN) * ($indicatePast другой $phoneAndNum)} *
        q!: * {(при продаже) * ($indicatePast другой $phoneAndNum)} *
        q!: * $salesman * $indicatePast другой $phoneAndNum *

        q!: * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] * {$indicatePast * $wrong * $phoneAndNum} *
        q!: * {$indicatePast * $wrong * $phoneAndNum} * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] *

        q!: * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] * {$indicatePast * $notThat * $phoneAndNum} *
        q!: * {$indicatePast * $notThat * $phoneAndNum} * [$ticketAll] * ($buyN/$buyPastPres) * [$ticketAll] *

        q!: * {$salesman * $makeAMistakePast * [$numeral] * $phoneAndNum} *
        q!: * {$buyPastPres * [$ticketAll] * ($makeAMistakePast * $phoneAndNum)} *
        q!: * {$buyPastPres * [$ticketAll] * ($phoneAndNum * $makeAMistakePast)} *
        q!: * {$buyN * [$ticketAll] * ($makeAMistakePast * $phoneAndNum)} *
        q!: * {$buyN * [$ticketAll] * ($phoneAndNum * $makeAMistakePast)} *

        q!: * {$ticketAll * $buyPastPres} * дал* другой $phoneAndNum *

        q!: * {(при $buyN) * $incorrectly * $indicatePartPas * $phoneAndNum} *
        q!: * {(при продаже) * $incorrectly * $indicatePartPas * $phoneAndNum} *
        q!: * {(при $buyN) * $indicatePartPas * ($notThat $phoneAndNum)} *
        q!: * {(при продаже) * $indicatePartPas * ($notThat $phoneAndNum)} *
        q!: * {(при $buyN) * $indicatePartPas * (другой $phoneAndNum)} *
        q!: * {(при продаже) * $indicatePartPas * (другой $phoneAndNum)} *
        q!: * (в/на) $receipt * $incorrectly * $indicatePartPas * $phoneAndNum *
        q!: * [$indicatePast/$indicatePartPas] * {((в/на) $receipt) ($notThat $phoneAndNum)} *

        eg!: Phone.IncorrectlyIndicatedThePhoneWhenBuyingATicket
        a: Смс с кодом выигрыша поступает только на тот номер телефона, который был указан при оформлении билета.\n\nБез кода выигрыша получить выигрыш Вы можете только через Центральный офис Столото. Выигрыш будет перечислен на Ваш лицевой счет.\n\nДля этого необходимо отправить почтой комплект документов:\n\n- заявление (образец заявления Вы можете скачать, пройдя по ссылке http://www.stoloto.ru/files/documents/zayav_2013/Zayavlenie_pri_nepravilnom_nomere.docx );\n- копию паспорта (2-я, 3-я стр. и страницу с пропиской);\n- квитанцию;\n- банковские реквизиты счета, на который Вы хотите получить выигрыш.\n\nАдрес для отправки: 109316, г. Москва, Волгоградский проспект, д. 43, корп. 3, Акционерное общество «Технологическая Компания «Центр».\n\nЕсли Вы договоритесь с владельцем телефона, который был указан в квитанции, чтобы он сообщил Вам код выигрыша, мы можем повторить код на его номер. Если такой вариант Вас устраивает, то сообщите нам, пожалуйста.


    state: RejectMailout
        # Как отписаться от рассылки?
        q!: * заспам* *
        q!: * {(отключиться/отключится/$rejectInf) * ($spam/$letterAll/новост*)} *
        q!: * (отписать/отпишите/отпешите) меня *
        q!: * $want (отписатьс*/отписатс*/отпесатьс*/отпесатс*/от писатьс*/от писатс*/от песатьс*/от песатс*/отписац*/от писац*) *
        q!: * {$rejectImp * [$me] * ($spam/$letterAll/новост*)} *
        q!: * {($rejectInf/$rejectImp) * (от вас)} *
        q!: * (вкладк*/$button) [для] отписк* *
        q!: * {снять $spam} *
        q!: * {запретить $spam} *
        q!: * {бомбить * $spam} *
        q!: * запрещаю ваш* $spam *
        q!: * {$spam мне (шлеш*/шлет*)} *
        q!: * долго * слать * фигню *

        q!: * {($annulInf/$annulImp) * ($spam/$letterAll)} *
        q!: * {$annoyPast * ($spam/$letterAll)} *

        q!: * {$sendImpNe * ($spam/$letterAll)} *
        q!: * {$sendImpNe * ($notification/$sms)} *

        q!: * {$stopDoingThat * ($spam/$letterAll)} *
        q!: * $stopDoingThat (присылать/слать) *
        q!: * {$stopWrite * [мне] * $mail} *
        q!: * {($turnOffInf/$turnOffImp) * ($spam/$letterAll)} *
        q!: * {$agreePastPresNe * $spam} *
        q!: * {$agreePastPresNe * ($sendInf/присылать) * $letterAll} *

        q!: * {$dontWant * получать * $spam} *
        q!: * {$dontWant * получать * $letterAll} *
        q!: * {$dontWant * получать * акции} *
        q!: * {$dontWant * получать * новости} *
        q!: * {$dontWant * получать * $sms * $onTelephone} *
        q!: * $dontWant * $forTo * (приходили/поступали/присылали) * ($spam/$letterAll/$sms) *
        q!: * $dontWant * $forTo * ($spam/$letterAll/$sms) * (приходили/поступали/присылали) *
        q!: * $forTo * {$sendPastContNe * $spam} *
        q!: * $forTo * {$sendPastContNe * $mail} *
        q!: * $forTo * {$sendPastContNe * акции} *
        q!: * $forTo * {$sendPastContNe * новости} *
        q!: * $forTo * {$sendPastContNe * $letter} *
        q!: * $forTo * {$sendPastContNe * $notification} *
        q!: * сделать * $forTo * {$sendPastContNe * $sms} *
        q!: * сделать * $forTo * ($ne (приходил*/присылал*)/неприходил*/неприсылал*/ниприходил*/ниприсылал) * $sms *
        q!: * $forTo * {$bonusComePastPresNe * $spam} *
        q!: * $forTo * {$bonusComePastPresNe * $letterAll * [$mail]} *
        q!: * $forTo * {$bonusComePastPresNe * $sms * $onTelephone} *
        q!: * $forTo * {$bonusComePastPresNe * $sms * надоел*} *
        q!: * $forTo * перестал* * (спамить/надоедать/$smsComeInf * ($spam/$letterAll/$sms)) *
        q!: * {($blockInf/$blockImpFut) * ($spam/$letterAll)} *
        q!: * {($blockInf/$blockImpFut) * $sms * $onTelephone} *
        q!: * ($how/$want) перестать получать ($spam/$letterAll/новост*/акции) *
        q!: * {(исключить/исключите) * ($telephone/$telephoneNumber) * (из [$oneWord] $spam)} *
        eg!: Phone.RejectMailout
        a: Отписаться от рассылки Вы можете самостоятельно на основной версии сайта www.stoloto.ru в разделе «Профиль» Вашего личного кабинета, во вкладке «Уведомления». Также Вы можете сейчас написать нам Ваши регистрационные данные (адрес электронной почты и номер телефона) или отправить эти данные на наш адрес электронной почты info@stoloto.ru. В обращении укажите, пожалуйста, какую рассылку Вы не хотите получать: по электронной почте или по SMS.

        state: LocalCatchAll
            event: noMatch || fromState = /Phone/RejectMailout
            script: Webim.switch();

        state: ThisIsMyUserData
            q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: IncorrectSMSMailing
        # Некорректная смс-рассылка
        q!: * {$wrong * ($sms рассылк*)} *
        q!: * {~странный * ($sms рассылк*)} *
        q!: * {~непонятный * ($sms рассылк*)} *
        q!: * {~ошибочный * ($sms рассылк*)} *
        q!: * $comWhat [это] за ($sms рассылк*) *
        q!: * {$wrong * ($sms оповещен*)} *
        q!: * {~странный * ($sms оповещен*)} *
        q!: * {~непонятный * ($sms оповещен*)} *
        q!: * {~ошибочный * ($sms оповещен*)} *
        q!: * $comWhat [это] за ($sms оповещен*) *
        q!: это ошибочн* (смс*/эс эм эс/эсэмэс*/эсмэс*/*sms*) *
        q!: * {$smsComePast * ~странный * $sms * $telephone} *
        q!: * {$smsComePast * ~непонятный * $sms * $telephone} *
        q!: * {$smsComePast * ~странный * $sms * $number} *
        q!: * {$smsComePast * ~непонятный * $sms * $number} *
        q!: * (смс*/эс эм эс/эсэмэс*/эсмэс*/*sms*) * это вы (послал*/рассылал*/посылал*) *
        q!: * {$smsComePast * ~странный * (смс*/*sms*)} *
        q!: * {$smsComePast * ~странный * (эс эм эс/эсэмэс*/эсмэс*)} *
        q!: * {$smsComePast * ~непонятный * (смс*/*sms*)} *
        q!: * {$smsComePast * ~непонятный * (эс эм эс/эсэмэс*/эсмэс*)} *
        q!: * $why [мне/я] $smsComePast (это/эти) (смс*/эс эм эс/эсэмэс*/эсмэс*/*sms*) *
        eg!: Phone.IncorrectSMSMailing
        if: $global.smsMailingIsCorrect
            script: Webim.switch();
        else:
            a: Приносим извинения за некорректное сообщение о ____________. Спасибо, что сообщили о нем. В системе рассылок произошел технический сбой. Мы уже работаем над его устранением.


    state: NoConfirmentSMS
        # Не пришло СМС с паролем для завершения регистрации
        q!: * {$delay * $sms * $registration} *
        q!: * {$delay * $code * $registration} *
        q!: * {$delay * $password * $registration} *
        q!: * {$sendMeImp * $sms * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $sms * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $sms * $registration} *
        q!: * {$sendMeImp * $code * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $code * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $code * $registration} *
        q!: * {$sendMeImp * $password * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $password * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $password * $registration} *

        q!: * {$smsComePastPresNe * $sms * ([$confirmation] $registration)} *
        q!: * {$sendPastPresNe * $sms * ([$confirmation] $registration)} *
        q!: * {$comNo * $sms * ([$confirmation] $registration)} *
        q!: * {$smsComePastPresNe * $code * ([$confirmation] $registration)} *
        q!: * {$sendPastPresNe * $code * ([$confirmation] $registration)} *
        q!: * {$smsComePastPresNe * $sms * ($confirmation $telephoneNumber)} *
        q!: * {$sendPastPresNe * $sms * ($confirmation $telephoneNumber)} *
        q!: * {$comNo * $sms * ($confirmation $telephoneNumber)} *
        q!: * {$smsComePastPresNe * $code * ($confirmation $telephoneNumber)} *
        q!: * {$sendPastPresNe * $code * ($confirmation $telephoneNumber)} *

        q!: * {$smsComePastPresNe * $password * $registration} *
        q!: * {$sendPastPresNe * $password * $registration} *
        q!: * {$smsComePastPresNe * $sms * $registerInfRefl} *
        q!: * {$sendPastPresNe * $sms * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $code * $registerInfRefl} *
        q!: * {$sendPastPresNe * $code * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $password * $registerInfRefl} *
        q!: * {$sendPastPresNe * $password * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $sms * $registerPresSg1} *
        q!: * {$sendPastPresNe * $sms * $registerPresSg1} *
        q!: * {$smsComePastPresNe * $code * $registerPresSg1} *
        q!: * {$sendPastPresNe * $code * $registerPresSg1} *
        q!: * {$smsComePastPresNe * $password * $registerPresSg1} *
        q!: * {$sendPastPresNe * $password * $registerPresSg1} *

        q!: * {$comWhere * $code * $registration} *
        q!: * {$comWhere * $sms * $registration} *
        q!: * {$comWhere * $password * $registration} *
        # Не пришел платежный пароль
        q!: * {[$cashoutInf/$getPrizInf/$transferInfImp/$sendInf] * $smsComePastPresNe * $paymentPassword} *
        q!: * {[$cashoutInf/$getPrizInf/$transferInfImp/$sendInf] * $sendPastPresNe * $paymentPassword} *
        q!: * {$getPrizInf * $comMoney * $smsComePastPresNe * $code} *
        q!: * {$getPrizInf * $comMoney * $sendPastPresNe * $code} *
        q!: $getPrizInf [$prize] $fromWallet $code $confirmation
        q!: $getPrizInf [$prize] $onExternalResource $code $confirmation
        q!: * {$sendMeImp * $paymentPassword} *
        q!: * {$askYouAll * $sendMeInfPerf * $paymentPassword} *
        q!: * {$askYouAll * присылать * $paymentPassword} *
        q!: * {$askYouAll * $duplicateInfPerf * $paymentPassword} *

        q!: * {$cantPastPresAll * $receiveInf * $paymentPassword * [$getPrizInf]} *
        q!: * {$cantPastPresAll * $receiveInf * $paymentPassword * [$transferInfImp]} *
        q!: * {$cantPastPresAll * $receiveInf * $paymentPassword * [$sendInf]} *
        q!: * {$cantPastPresAll * $receiveInf * $paymentPassword * [$moneyAddInf]} *
        q!: * {$cantPastPresAll * $receiveInf * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$cantPastPresAll * $receiveInf * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$cantPastPresAll * $receiveInf * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$cantPastPresAll * $receiveInf * $confirmation * $withdrawalAll * $moneyAndRub} *

        q!: * {$comNo * $paymentPassword} *
        q!: * {$bePastNe $paymentPassword} *
        q!: * {$askInf * $paymentPassword} *
        q!: * {$sendPresPl2Ne * $paymentPassword} *
        q!: * {$comWhere * $paymentPassword} *
        q!: * {задерж* * $paymentPassword} *

        q!: * {$smsComePastPresNe * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$sendPastPresNe * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $password * $withdrawInf * $moneyAndRub} *
        q!: * {$sendPastPresNe * $password * $withdrawInf * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $password * внести * $moneyAndRub} *
        q!: * {$sendPastPresNe * $password * внести * $moneyAndRub} *

        q!: * {$smsComePastPresNe * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$sendPastPresNe * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $sms * $withdrawInf * $moneyAndRub} *
        q!: * {$sendPastPresNe * $sms * $withdrawInf * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $sms * внести * $moneyAndRub} *
        q!: * {$sendPastPresNe * $sms * внести * $moneyAndRub} *

        q!: * {$smsComePastPresNe * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$sendPastPresNe * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $code * $withdrawInf * $moneyAndRub} *
        q!: * {$sendPastPresNe * $code * $withdrawInf * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $code * внести * $moneyAndRub} *
        q!: * {$sendPastPresNe * $code * внести * $moneyAndRub} *

        q!: * {$smsComePastPresNe * $confirmation * $withdrawalAll * $moneyAndRub} *
        q!: * {$sendPastPresNe * $confirmation * $withdrawalAll * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $confirmation * $withdrawInf * $moneyAndRub} *
        q!: * {$sendPastPresNe * $confirmation * $withdrawInf * $moneyAndRub} *
        q!: * {$smsComePastPresNe * $confirmation * внести * $moneyAndRub} *
        q!: * {$sendPastPresNe * $confirmation * внести * $moneyAndRub} *

        q!: * {$comNo * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$comNo * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$comNo * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$comNo * $confirmation * $withdrawalAll * $moneyAndRub} *

        q!: * {$comNo * $password * $withdrawInf * $moneyAndRub} *
        q!: * {$comNo * $sms * $withdrawInf * $moneyAndRub} *
        q!: * {$comNo * $code * $withdrawInf * $moneyAndRub} *
        q!: * {$comNo * $confirmation * $withdrawInf * $moneyAndRub} *
        q!: * {$comNo * $sms * внести * $moneyAndRub} *
        q!: * {$comNo * $code * внести * $moneyAndRub} *
        q!: * {$comNo * $confirmation * внести * $moneyAndRub} *

        q!: * {$comWhere * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$comWhere * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$comWhere * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$comWhere * $confirmation * $withdrawalAll * $moneyAndRub} *

        q!: * {$comWhere * $password * $withdrawInf * $moneyAndRub} *
        q!: * {$comWhere * $sms * $withdrawInf * $moneyAndRub} *
        q!: * {$comWhere * $code * $withdrawInf * $moneyAndRub} *
        q!: * {$comWhere * $confirmation * $withdrawInf * $moneyAndRub} *
        q!: * {$comWhere * $password * внести * $moneyAndRub} *
        q!: * {$comWhere * $sms * внести * $moneyAndRub} *
        q!: * {$comWhere * $code * внести * $moneyAndRub} *
        q!: * {$comWhere * $confirmation * внести * $moneyAndRub} *

        q!: * {$delay * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$delay * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$delay * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$delay * $confirmation * $withdrawalAll * $moneyAndRub} *

        q!: * {$delay * $password * $withdrawInf * $moneyAndRub} *
        q!: * {$delay * $sms * $withdrawInf * $moneyAndRub} *
        q!: * {$delay * $code * $withdrawInf * $moneyAndRub} *
        q!: * {$delay * $confirmation * $withdrawInf * $moneyAndRub} *
        q!: * {$delay * $password * внести * $moneyAndRub} *
        q!: * {$delay * $sms * внести * $moneyAndRub} *
        q!: * {$delay * $code * внести * $moneyAndRub} *
        q!: * {$delay * $confirmation * внести * $moneyAndRub} *

        q!: * {$sendMeImp * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $sendMeInfPerf * $password * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $duplicateInfPerf * $password * $withdrawalAll * $moneyAndRub} *

        q!: * {$sendMeImp * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $sendMeInfPerf * $sms * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $duplicateInfPerf * $sms * $withdrawalAll * $moneyAndRub} *

        q!: * {$sendMeImp * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $sendMeInfPerf * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $duplicateInfPerf * $code * $withdrawalAll * $moneyAndRub} *
        q!: * {$sendMeImp * $confirmation * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $sendMeInfPerf * $confirmation * $withdrawalAll * $moneyAndRub} *
        q!: * {$askYouAll * $duplicateInfPerf * $confirmation * $withdrawalAll * $moneyAndRub} *

        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe * $sms} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe * $code} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe * $password} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $bonusComePastPresNe * $confirmation} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $bonusComePastPresNe * $confirmation} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $sendPresPl2Ne * $sms} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $sendPresPl2Ne * $code} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $sendPresPl2Ne * $password} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $fromWallet * $sendPresPl2Ne * $confirmation} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $sendPresPl2Ne * $sms} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $sendPresPl2Ne * $code} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $sendPresPl2Ne * $password} *
        q!: * {(~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $prize * $onExternalResource * $sendPresPl2Ne * $confirmation} *

        q!: * {$transferInfImp * $prize * $bonusComePastPresNe * $code} *
        q!: * {$sendInf * $prize * $bonusComePastPresNe * $code} *
        q!: * {$moneyAddInf * $prize * $bonusComePastPresNe * $code} *

        q!: * {$transferInfImp * $prize * $bonusComePastPresNe * $password} *
        q!: * {$sendInf * $prize * $bonusComePastPresNe * $password} *
        q!: * {$moneyAddInf * $prize * $bonusComePastPresNe * $password} *

        q!: * {$transferInfImp * $prize * $sendPastPresNe * $code} *
        q!: * {$sendInf * $prize * $sendPastPresNe * $code} *
        q!: * {$moneyAddInf * $prize * $sendPastPresNe * $code} *

        q!: * {$transferInfImp * $prize * $sendPastPresNe * $password} *
        q!: * {$sendInf * $prize * $sendPastPresNe * $password} *
        q!: * {$moneyAddInf * $prize * $sendPastPresNe * $password} *

        q!: * {$transferInfImp * $prize * $smsComePastPresNe * $code} *
        q!: * {$sendInf * $prize * $smsComePastPresNe * $code} *
        q!: * {$moneyAddInf * $prize * $smsComePastPresNe * $code} *

        q!: * {$transferInfImp * $prize * $smsComePastPresNe * $password} *
        q!: * {$sendInf * $prize * $smsComePastPresNe * $password} *
        q!: * {$moneyAddInf * $prize * $smsComePastPresNe * $password} *

        q!: * {$cashoutInf * ($wallet/$prize) * $bonusComePastPresNe * $sms} *
        q!: * {$cashoutInf * ($wallet/$prize) * $bonusComePastPresNe * $code} *
        q!: * {$cashoutInf * ($wallet/$prize) * $bonusComePastPresNe * $password} *
        q!: * {$cashoutInf * ($wallet/$prize) * $bonusComePastPresNe * $confirmation} *
        q!: * {$cashoutInf * $fromWallet * $bonusComePastPresNe * $sms} *
        q!: * {$cashoutInf * $fromWallet * $bonusComePastPresNe * $code} *
        q!: * {$cashoutInf * $fromWallet * $bonusComePastPresNe * $password} *
        q!: * {$cashoutInf * $fromWallet * $bonusComePastPresNe * $confirmation} *

        q!: * {$cashoutInf * $fromAccount * $bonusComePastPresNe * $sms} *
        q!: * {$cashoutInf * $fromAccount * $bonusComePastPresNe * $code} *
        q!: * {$cashoutInf * $fromAccount * $bonusComePastPresNe * $password} *
        q!: * {$cashoutInf * $fromAccount * $bonusComePastPresNe * $confirmation} *
        q!: * {$withdrawInf * $fromAccount * $bonusComePastPresNe * $sms} *
        q!: * {$withdrawInf * $fromAccount * $bonusComePastPresNe * $code} *
        q!: * {$withdrawInf * $fromAccount * $bonusComePastPresNe * $password} *
        q!: * {$withdrawInf * $fromAccount * $bonusComePastPresNe * $confirmation} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $bonusComePastPresNe * $sms} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $bonusComePastPresNe * $code} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $bonusComePastPresNe * $password} *
        q!: * {$getPrizInf * [$prize] * $fromWallet * $bonusComePastPresNe * $confirmation} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {$getPrizInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $confirmation} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $bonusComePastPresNe * $sms} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $bonusComePastPresNe * $code} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $bonusComePastPresNe * $password} *
        q!: * {$transferInfImp * [$prize] * $fromWallet * $bonusComePastPresNe * $confirmation} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {$transferInfImp * [$prize] * $onExternalResource * $bonusComePastPresNe * $confirmation} *
        q!: * {$sendInf * [$prize] * $fromWallet * $bonusComePastPresNe * $sms} *
        q!: * {$sendInf * [$prize] * $fromWallet * $bonusComePastPresNe * $code} *
        q!: * {$sendInf * [$prize] * $fromWallet * $bonusComePastPresNe * $password} *
        q!: * {$sendInf * [$prize] * $fromWallet * $bonusComePastPresNe * $confirmation} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {$sendInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $confirmation} *

        q!: * {$prize * $getPrizInf} * {$bonusComePastPresNe * $sms} *
        q!: * {$comMoney * $getPrizInf} * {$bonusComePastPresNe * $code} *
        q!: * {$prize * $getPrizInf} * {$bonusComePastPresNe * $password} *
        q!: * {$prize * $getPrizInf} * {$bonusComePastPresNe * $confirmation} *

        q!: * {$bonusComePastPresNe * $sms} * {$prize * $getPrizInf} *
        q!: * {$bonusComePastPresNe * $code} * {$moneyAndRub * $getPrizInf} *
        q!: * {$bonusComePastPresNe * $password} * {$prize * $getPrizInf} *
        q!: * {$bonusComePastPresNe * $confirmation} * {$prize * $getPrizInf} *

        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {$moneyAddInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $confirmation} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $sms} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $code} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $password} *
        q!: * {$depositInf * [$prize] * $onExternalResource * $bonusComePastPresNe * $confirmation} *

        q: * {$smsComePastPresNe * $code} * || fromState = /Payments/HowToWithdrawMoney
        q: * {$smsComePastPresNe * $code} * || fromState = /Payments/WithdrawDoesntWork

        eg!: Phone.NoConfirmentSMS
        if: $global.confirmentSmsIsAvailable
            script: Webim.switch();
        else:
            a: По техническим причинам СМС для завершения регистрации и платежные пароли приходят с задержкой. Немного терпения, скоро все сообщения будут доставлены адресатам.
            #a: Спасибо, что сообщили о задержке. Мы уже работаем над возобновлением корректной работы системы рассылок.


    state: NoUnknownTypeCode
        # не пришло сообщение (без уточнения, о чем речь)
        q!: [$helloAll] $tellImp [повторно] $code
        q!: [$helloAll] {($possiblePredicAll/$comNeed) [мне] ($code/$sms/$sms $with $code) [$please]}
        q!: * {$sms $bePastNe} *
        q!: * {$code $bePastNe} *
        q!: [$helloAll] {($sms/$code) $smsComeFut} $or $comNo
        q!: [$helloAll] {($sms/$code) $waitInf} $or $comNo

        q!: * {$stopped * $smsComeInf * $sms} *
        q!: * {$stopped * $smsComeInf * $code} *
        q!: * {$stopped * $smsComeInf * $sms * $code} *

        q!: * {$smsComePastPresNe * $sms} *
        q!: * {$smsComePastPresNe * $code} *
        q!: * {$smsComePastPresNe * $sms * $code} *
        q!: * {$receivePresNe * $sms * $code} *
        q!: * {$sendPastPresNe * ($sms/$code) * $onTelephone} *
        q!: * {$wantPresSg3Ne приходить $code} *
        q!: * {$wantPresSg3Ne приходить $sms} *

        q!: * {($ne $findPastPres) * $sms} *
        q!: * {($ne $findPastPres) * $code} *
        q!: * {($ne $findPastPres) * $sms * $code} *

        q!: * {$lostPast * $sms} *
        q!: * {$lostPast * $code} *
        q!: * {$lostPast * $sms * $code} *
        q!: * $comWhat * (делать/сделать) * {$lostPast * $code} *
        q!: * {$lostPast * $code} * $comWhat * (делать/сделать) *

        q!: [$helloAll] {[я] ($how/$comNeed/$want) (восстановить/востановить) ($code/$sms)}

        q!: * {$sendMeImp * $sms} *
        q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $sms} *
        q!: * {$sendMeImp * $code} *
        q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $code} *
        q!: * {$sendMeImp * $sms * $code} *
        q!: * {$askYouAll * ($sendMeInfPerf/$duplicateInfPerf) * $sms * $code} *

        q!: * {$receiveInf * $code * [$telephone]} *
        q!: * {$receiveInf * $code * $telephoneNumber} *
        q!: * {$receiveInf * $sms * [$telephone]} *
        q!: * {$receiveInf * $sms * $telephoneNumber} *
        q!: * {$findInf * ($code/$sms)} *
        q!: * {узнать * ($code/$sms)} *
        q!: * {$askInf * ($code/$sms)} *

        q!: * {$how * $receiveInf * ($code/$sms)} * [$onTelephone] *
        q!: * {$how * $findInf * ($code/$sms)} *

        q!: * {$comWhere * $receiveInf * ($code/$sms)} *
        q!: * {$comWhere * $findInf * ($code/$sms)} *

        q!: * {$when * $smsComeFut * $sms} *
        q!: * {$when * $smsComeFut * $code} *

        q!: * {$comWhere * $code} *
        q!: * {$comWhere * $sms} *

        q!: * {$comNo [все равно] $sms} *
        q!: * {$comNo [никак*/$ne как*] $code} *
        q!: * {$comNo ($sms $with ($code/$confirmation))} *
        q!: * {($sms $with ($code/$confirmation)) $comNo} *
        q!: * долг* ($waitInf/ожидание) (~приход/~поступление) ($code/$sms) *

        q!: * {$resetInf * $sms * $code} *
        q!: * {$resetImp * $sms * $code} *
        q!: * {$resetNoun * $sms * $code} *

        q!: * $forTo ($sendPastPerf/$transferPast/приходил*) [$again] ($code/$sms) *
        eg!: Phone.NoUnknownTypeCode
        a: Уточните, пожалуйста, по какой операции не пришло СМС?

        state: GetWinCodeType || fromState = /Phone/NoUnknownTypeCode
            q: * $prizeWithoutMoneyAll *
            go!: /Lottery/ReceiveWinningCode

        state: GetRegistrationCodeType || fromState = /Phone/NoUnknownTypeCode
            q: * $registration [~пользователь/~участник] *
            q: * $registration на (~сайт/[~сайт] $stoloto) *
            q: * $registerInfRefl [в $stoloto/на (~сайт/[~сайт] $stoloto)] *
            q: * $paymentPassword *
            q: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $onExternalResource *
            q: * (~получение/~вывод/~перевод/~отправка/~обналичивание/~списание/~выведение/~выдача/~выплата) * $fromWallet *
            q: [по] (~вывод/~перевод) [$prize]
            q: * (по/на) (~вывод/~перевод) $prize *
            q: * {$getPrizInf * $prize} *
            q: * {$transferInfImp * $prizeWithoutMoney} *
            go!: /Phone/NoConfirmentSMS

        state: OtherCodeType || fromState = /Phone/NoUnknownTypeCode
            event: noMatch
            go!: /Lottery/DidntRecieveCodeOrSMS


    state: ContentBan
        # На номере установлена услуга Запрет контента
        q!: * {запрет * контент*} *
        q!: * {контент * $availableNe} *
        q!: * {[$win] * $code * запрет * контент*} * [$telephoneNumber/$telephone] *
        eg!: Phone.ContentBan
        a: Запрет контента - это услуга, которая блокирует прием/отправку смс-сообщений с коротких номеров. Для снятия ограничений по услуге «Запрет контента» обратитесь, пожалуйста, к Вашему сотовому оператору.


    state: InvalidRequestFormat
        # Неправильный формат запроса
        q!: * (~неправильный/$ne ~правильный) ~формат ~запрос *
        q!: * {$incorrectly $indicatePartPas (~формат ~запрос)} *
        #q!: * {$wrong * ~формат * $win} *
        eg!: Phone.InvalidRequestFormat
        a: Сообщите, пожалуйста, номер телефона, указанный при оформлении билета, и номер билета.

        state: GetUserPhoneNumber || fromState = /Phone/InvalidRequestFormat
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            q!: * {((~неправильный/$ne ~правильный) ~формат ~запрос) * $localMobilePhoneNumber} *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrTicketNumber
                a: Укажите, пожалуйста, номер билета.
            else:
                script: Webim.switch();

        state: GetUserTicketNumber || fromState = /Phone/InvalidRequestFormat
            q: * $ticketNumberNumeral *
            script:
                $session.usrTicketNumber = $parseTree._ticketNumberNumeral;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, номер телефона, на который был оформлен билет.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumberAndTicketNumber || fromState = /Phone/InvalidRequestFormat
            q: * {$localMobilePhoneNumber * $ticketNumberNumeral} *
            script: Webim.switch();


    state: WhatPhoneIsTiedToMyAccount
        # Какой номер сотового привязан к моему аккаунту?
        q!: * ~какой ($telephone/$telephoneNumber) в [$comMy] $account *
        q!: * ~какой {(у меня) ($telephone/$telephoneNumber)} * $account *
        q!: * ~какой * ($telephone/$telephoneNumber) * {$tiedM * $account} *
        q!: * ~какой {($telephone/$telephoneNumber) я} ($registerPastRefl3/$registered) *
        q!: * $findOutInf * ($telephone/$telephoneNumber) * {($tiedM/относящ*/привязан*/$registered/закреплен*) * $account} *
        q!: * $findOutInf * $telephone * ~который * привязан
        q!: * $findOutInf * ($telephone/$telephoneNumber) * (указал*/указывал*/указан) * $duringRegistration *
        q!: * *скажи* * ($telephone/$telephoneNumber) * {($tiedM/относящ*/привязан*/$registered/закреплен*) * $account} *
        q!: * $knowNe * ($telephone/$telephoneNumber) * {($tiedM/относящ*/привязан*/$registered/закреплен*) * $account} *
        q!: * (увидеть/посмотреть/проверить) * ~какой * ($telephone/$telephoneNumber) * {($registered/$tiedM/подключен) * $account} *
        q!: * (увидеть/посмотреть/проверить) * ~какой * ($telephone/$telephoneNumber) * {$registerPast3 * ($account/я)} *
        q!: * (увидеть/посмотреть/проверить) * ~какой * ($telephone/$telephoneNumber) * $duringRegistration *
        q!: * (увидеть/посмотреть/проверить) * (~какой/$comMy) ($telephone/$telephoneNumber) привязан* к (сайту/$stoloto) *
        q!: * (увидеть/посмотреть) * $telephoneNumber $account *
        q!: * $comWhere * (увидеть/посмотреть) $comMy [$number] $telephone *
        eg!: Phone.WhatPhoneIsTiedToMyAccount
        a: На основной версии сайта в личном кабинете, в разделе «Профиль» будет указан номер телефона.


    state: WhatPhoneDidIEnterDuringRegistration
        # Какой номер телефона я вводил при регистрации?
        q!: * [$localEmail] * ~какой * $telephone * {(вводил*/проходил*/производил*/указал*/указывал*) * $registration} * [$localEmail] *
        q!: * [$localEmail] * ~какой $telephoneNumber {(указал*/указывал*/использовал*) * $registration} * [$localEmail] *

        q!: * [$localEmail] * $findOutInf * $telephone * {(вводил*/проходил*/производил*/указал*/указывал*/указан) * $registration} * [$localEmail] *

        q!: * [$localEmail] * $knowNe * $telephone * {(вводил*/проходил*/производил*/указал*/указывал*/указан) * $registration} * [$localEmail] *

        q!: * [$localEmail] * $forgetPastPres * $telephone * {(вводил*/проходил*/производил*/указал*/указывал*/указан) * $registration} * [$localEmail] *
        q!: * [$localEmail] * $forgetPastPres $number * {(вводил*/проходил*/производил*/указал*/указывал*/указан) * $registration} * [$localEmail] *

        q!: * [$localEmail] * ~какой * $telephone * {$registered * ($account/я/страница)} * [$localEmail] *

        q!: * [$localEmail] * $findOutInf * $telephone * {$registered * ($account/я/страница)} * [$localEmail] *

        q!: * [$localEmail] * $knowNe * $telephone * {$registered * ($account/я/страница)} * [$localEmail] *

        q!: * [$localEmail] * $forgetPastPres * $telephone * {$registered * ($account/я/страница)} * [$localEmail] *

        q!: * [$localEmail] * ~какой ($telephone/$telephoneNumber) $registered * $mail * [$localEmail] *

        q!: * [$localEmail] * ~какой * $telephone * {$registerPast3 * ($account/я)} * [$localEmail] *

        q!: * [$localEmail] * $findOutInf * $telephone * {$registerPast3 * ($account/я)} * [$localEmail] *

        q!: * [$localEmail] * $knowNe * $telephone * {$registerPast3 * ($account/я)} * [$localEmail] *

        q!: * [$localEmail] * $forgetPastPres * $telephone * {$registerPast3 * ($account/я)} * [$localEmail] *

        q!: * [$localEmail] * ($forgetPastPres/$knowNe) * $telephone * $registerPastRefl3 * [$localEmail] *

        eg!: Phone.WhatPhoneDidIEnterDuringRegistration
        script:
            $session.usrEmail = $parseTree._localEmail;
        if: !$session.usrEmail
            a: Уточните, пожалуйста, адрес почты, с которым проводили регистрацию на сайте.
        else:
            script: Webim.switch();

        state: GetUserEmail || fromState = /Phone/WhatPhoneDidIEnterDuringRegistration
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script: Webim.switch();


    state: SuchPhoneNumberIsAlreadyRegistered
        # При регистрации пишут, что такой номер уже зарегистрирован
        q!: * [$isWritten что] {(~такой/токой/$this/$comMy) $phoneAndNum $yet ($registered/существует/есть)} *
        q!: * $isWritten [что] $yet ($registered/существует/есть) $account на (~такой/токой/$this/$comMy) $phoneAndNum *
        q!: * (~такой/токой/$this) $phoneAndNum существует *
        q!: * $isWritten [что] (~такой/токой/$this/$comMy) $phoneAndNum $registered *
        q!: * $phoneAndNum $isWritten [что] (~такой/токой) ($registered/существует/есть) *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $phoneAndNum * $registered} *
        q!: * {$isWritten * $phoneAndNum * $registered} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $phoneAndNum * $registered} *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $phoneAndNum * уже * (существует/есть)} *
        q!: * {$isWritten * $phoneAndNum * уже * (существует/есть)} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $phoneAndNum * уже * (существует/есть)} *

        q!: * {[~такой/токой/$this/$comMy] $phoneAndNum $yet $somebody $indicatePast $duringRegistration} *
        q!: * $phoneAndNum $yet (кем-то/кем то) указан $duringRegistration *
        q!: * $phoneAndNum ([был] использован*/использовал*) ~другой ~человек *
        q!: * (~такой/токой/$this/$comMy) $phoneAndNum [$localMobilePhoneNumber] [$yet] (указан как $registered/занят) *
        q!: * (кто-то/кто то) $yet $existPresSg3 $with [эт*/так*/дан*] $phoneAndNum *

        eg!: Phone.SuchPhoneNumberIsAlreadyRegistered
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Phone/SuchPhoneNumberIsAlreadyRegistered
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Phone/SuchPhoneNumberIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Phone/SuchPhoneNumberIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();





















