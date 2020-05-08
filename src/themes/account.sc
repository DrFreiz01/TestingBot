theme: /Account

    state: HowToRegister
        # Как зарегистрироваться
        q!: [$helloAll] $registration
        q!: [$helloAll] {$want [я] $registerInfRefl} [в/на] [~сайт] [$stoloto]
        q!: [$helloAll] {могу [я] [$again] $registerInfRefl}
        q!: [$helloAll] $how $possiblePredic $registration
        q!: * {$how $doInf $registration} *
        q!: * {$how * пройти * $registration} *
        q!: * завести новую $registration *
        q!: * $registration (~пользователь/~участник) *
        q!: [$helloAll] $registration на (~сайт/[~сайт] $stoloto)
        q!: * $registerInfRefl на (~сайт/[~сайт] $stoloto) *
        q!: * $registerInfRefl в ($stoloto/$gosloto) *
        q!: * ($how/$comWhere) [я могу/могу/$possiblePredic/правильно/мне/$again] $registerInfRefl *
        q!: * $registerInfRefl ($how/$comWhere) *
        q!: * $how {$makeInf $account} *
        q!: [$helloAll] [мне] $comNeed помощ* (при/в) $registration
        eg!: Account.HowToRegister
        a: Для регистрации на сайте Вам необходимо перейти по ссылке http://www.stoloto.ru/registration в раздел «Регистрация».\n\nДалее заполните все необходимые поля, указав электронную почту, имя, пароль, номер телефона.\n\nОбязательно указывайте действующий адрес Вашей электронной почты и номер телефона.\nПароль Вам будет необходимо придумать и запомнить, так как в дальнейшем вход на сайт Вы будете осуществлять через него и электронный адрес, указанный при регистрации.\n\nОбращаем Ваше внимание на то, что номер телефона после прохождения регистрации изменить невозможно.\n\nПри выборе имени учитывайте, пожалуйста, следующие условия:\n\nРазрешены: латинские и кириллические буквы, буквы в любом сочетании с цифрами.\n\nЗапрещены: пробелы и специальные символы.\n\nЗатем внимательно ознакомьтесь с договором-офертой и примите его условия.\n\nС более подробной информацией Вы можете ознакомиться, пройдя по cсылке http://www.stoloto.ru/lottery/onlinesale#tag_how
        #script: $reactions.timeout({interval: 60, targetState: '/Timedout'});


    state: HowToBlockAccount
        # Как заблокировать ЛК?
        q!: * {($blockInf/$blockImpFut) * $accountAcc * [$makeInf]} *
        q!: * ($blockInf/$blockImpFut) * $accountAcc * $phoneAndNum *
        q!: * {обнулит* ([$comMy] $accountAcc)} *
        q!: * $blockIng [$comMy] [$oneWord] $accountGen *
        q!: * {($blockInf/$blockImpFut) $meGen} *
        q!: * {$blockInf себя} *
        q!: * $blockInf все свои страницы *
        q!: * {($blockInf/снять/$blockImpFut/$annulInf) * $registration} *
        q!: * ($blockInf/$blockImpFut) * данные [[с/из] [~база] [~ваш/~этот] сайта/отсюда/от сюда/$forever] [$how это сделать]
        q!: * ($blockInf/$blockImpFut) * данные (в/из) $stoloto [$how это сделать]
        q!: * $blockInf $stoloto *
        q!: * $how (удалитьс*/удалитс*) *
        q!: ($how/$want) [мне] $leaveInf [и $rejectInf] {[$localEmail] [$localMobilePhoneNumber]}
        q!: * {$leaveInf * (сайт/$with (сайта/страницы)/[от] вас/отсюда/от сюда/$stoloto)} *
        q!: * выйти $with этого $accountGen *
        q!: * {$leaveInf * $forever} *
        q!: * полностью $leaveInf *
        q!: * $forTo * {$blockPast * $accountAcc} *
        q!: * $forTo * {$blockPast * $meGen} *
        q!: * $forTo * {$blockPast * $registration} *
        q!: * (аннулировать/анулировать) [$comMy] $accountAcc *
        q!: * [$comMy] $accountAcc (аннулировать/анулировать) *
        q!: * {($annulInf/$annulImp) * $accountAcc} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {($annulInf/$annulImp) * $accountAcc} *
        q!: * {($blockInf/$blockImpFut) * $accountAcc} * {$changePast * $phoneAndNum} *
        q!: * {$changePast * $phoneAndNum} * {($blockInf/$blockImpFut) * $accountAcc} *
        eg!: Account.HowToBlockAccount
        a: В случае блокировки Вашего аккаунта доступ к денежным средствам, бонусам и к неразыгранным квитанциям будет невозможен. Проверьте, пожалуйста, нет ли у Вас активных подписок на лотереи и настроена ли функция автовыплаты в Кошелек. В случае принятия решения о блокировке кабинета отключите их, пожалуйста. Обращаем Ваше внимание на то, что личный кабинет будет заблокирован без возможности восстановления. Если Вы принимаете решение о блокировке, то сообщите, пожалуйста, данные от Вашего личного кабинета, который требуется заблокировать: электронную почту и телефон. По возможности укажите причину удаления личного кабинета. Это поможет нам улучшить качество нашей работы.

        state: LocalCatchAll
            event: noMatch
            script: Webim.switch();

        state: ThisIsMyUserData
            q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: WhereToEnterRegistrationCode
        # Куда вводить код регистрации
        q!: * {$comWhere * $insertInf * $code * $registration} *
        q!: * {$comWhere * $insertInf * $numeral * $registration} *
        q!: * {куда * $insertInf * $code * $registration} *
        q!: * {куда * $insertInf * $numeral * $registration} *
        q!: * {куда * набрать * $code * $registration} *
        q!: * {куда * набирать * $code * $registration} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $code * $registration} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $numeral * $registration} *
        q!: * {$comWhere * $insertInf * $code * $registerInfRefl} *
        q!: * {куда * $insertInf * $code * $registerInfRefl} *
        q!: * {(~какой (~место/граф*/~поле)) * $insertInf * $code * $registerInfRefl} *
        q!: * (куда/$comWhere) $insertInf ($code/$numeral) [для] $confirmation $telephoneNumber *
        q!: * {$insertInf * $code} * {подтвердить * $mail} *
        q!: * {подтвердить * $mail} * {$insertInf * $code} *
        # Как подтвердить почту
        # Не могу подтвердить почту
        q!: * {$how [мне] подтвердить [$comMy] $mail} *
        q!: * {$comWhere [мне] подтвердить [$comMy] $mail} *
        q!: * {$possiblePredic [мне] подтвердить [$comMy] $mail} *
        q!: * {$how подтверждать [$comMy] $mail} *
        q!: [$helloAll] {[$cantPastPresAll] подтвердить [$comMy] $mail}
        q!: * {$cantPastPresAll подтвердить [$comMy] $mail} *
        q: * {$comWhere * $insertInf * $code} * || fromState = /Account/HowToRegister
        q: * {куда * $insertInf * $code} * || fromState = /Account/HowToRegister
        q: * {(~какой (~место/граф*/~поле)) * $insertInf * $code} * || fromState = /Account/HowToRegister
        eg!: Account.WhereToEnterRegistrationCode
        a: При регистрации на сайте Вы указываете адрес электронной почты и номер мобильного телефона. После нажатия на кнопку «Зарегистрироваться» на указанную почту поступит письмо. После перехода по ссылке из письма откроется форма для ввода кода из смс. Инструкцию по регистрации можно посмотреть по ссылке https://www.stoloto.ru/lottery/onlinesale?int=sitemap \n\nЕсли в процессе подтверждения почты у Вас возникли сложности, напишите нам, пожалуйста.

        state: SomeDifficulties
            # не высветилось окно
            q!: * {подтвердить [$comMy] $mail} * (перебрасывает/перебрасывают/перекидывает/перекидывают/возвращает) * (на сайт) *
            q!: * $comNo (~окно/окошк*) * $code [для] $confirmation *
            q: * ($ne высветил*/невысветил*) * (~окно/окошк*) *
            q: * (~окно/окошк*) * ($ne высветил*/невысветил*) *
            q: * {(~окно/окошк*) [~такой] $comNo} *
            q: * куда $insertInf $comNo *
            q: * {удалил* * $letter} *
            q: * {удалил* * $link} *
            q: * (перебрасывает/перебрасывают/перекидывает/перекидывают/возвращает) * (на сайт) *
            q: * (на сайт) * (перебрасывает/перебрасывают/перекидывает/перекидывают/возвращает) *
            q: * выскакивает * глав* страница *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

            state: GetUserData
                q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
                script: Webim.switch();

            state: GetUserEmail
                q: * [$helloAll] [$comMy] [$mail] $localEmail *
                script:
                    $session.usrEmail = $parseTree._localEmail;
                if: !$session.usrPhoneNumber
                    a: Укажите, пожалуйста, Ваш номер телефона.
                else:
                    script: Webim.switch();

            state: GetUserPhoneNumber
                q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
                script:
                    $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
                if: !$session.usrEmail
                    a: Укажите, пожалуйста, Вашу электронную почту.
                else:
                    script: Webim.switch();

        state: LocalCatchAll
            event: noMatch || fromState = /Account/WhereToEnterRegistrationCode
            script: Webim.switch();


    state: EmailNotReceived
        # Не пришло письмо
        q!: [$helloAll] {[я] $findPastPresNe $letter}
        q!: * {$cantPastPres * $receiveInf * $letter * $mail} *
        q!: * {$cantPastPres * $receiveInf * $link * $mail} *
        q!: * {$cantPastPres * $receiveInf * $confirmation * $mail} *
        q!: * {$cantPastPres * $findInf * $letter * $mail} *
        q!: * {$cantPastPres * $findInf * $link * $mail} *
        q!: * {$cantPastPres * $findInf * $confirmation * $mail} *

        q!: * {$smsComePastPresNe * $letter * [$mail]} *
        q!: * {$smsComePastPresNe * $link * [$mail]} *
        q!: * {$smsComePastPresNe * $confirmation * $mail} *
        q!: * {$smsComePastPresNe * запрос * $mail} *

        q!: * {$smsComePastPresNe * $sms * ((в/на/до) [$comMy] $mail)} *

        q!: * {$smsComePastPresNe * $mail * $nothing} *
        q!: [$helloAll] {$comNo ((в/на) $mail) $nothing} [$repeat<$emoji>]
        q!: * {$comNo * $letter * $mail} *
        q!: * {$comNo * $link * $mail} *

        q!: [$helloAll] {$smsComePastPerfNe $mail}
        q!: * {$comWhere * ($letter/$link)} *
        q!: * {$sendMeImp * ($letter/$link)} *
        q!: * {$askYouAll * $sendMeInfPerf * $letter} *
        q!: * {$askYouAll * $sendMeInfPerf * $link} *
        q!: * {$askYouAll * $duplicateInfPerf * $letter} *
        q!: * {$askYouAll * $duplicateInfPerf * $link} *
        q!: * так ($letter/$link) и $bePastNe *
        q!: * {$comNo [~ваш] ($letter/$link)} *
        q!: * {жду [~ваш] ($letter/$link)} *
        q!: * {$comNo (от вас) $letter} *
        q!: * {$comNo (от вас) $link} *
        q!: * {$howMuch * $waitInf * $letter} *
        q!: * {$howMuch * $waitInf * $link} *
        q!: * {$howLong * $waitInf * $letter} *
        q!: * {$howLong * $waitInf * $link} *
        q!: * {долго $bonusComePastPres $letter} *
        q!: * {долго $bonusComePastPres $link} *
        q!: [$helloAll] {($letter/$link) $smsComeFut} $or $comNo
        q!: [$helloAll] {($letter/$link) $waitInf} $or $comNo
        q!: * {$delay * $link} *
        q!: * {$delay * $letter} *

        # Хотел восстановить пароль, но письмо на почту не приходит
        q!: * {$smsComePastPresNe * ~инструкция} *
        q!: * {$smsComePastPresNe * $code * ((в/на) $mail)} *
        q!: * {$smsComePastPresNe * $changeInf * $password} *
        q!: * {$smsComePastPresNe * $resetInf * $password} *
        q!: * {$smsComePastPresNe * $resetNoun * $password} *
        q!: * {$smsComePastPresNe * $changeNoun * $password} *
        q!: * {$smsComePastPresNe * $resetNoun * ~инструкция} *
        q!: * {$cantPastPres * $receiveInf * $password * [$toAccount]} *
        q!: * {$smsComePastPresNe * $password * $toAccount} *
        q!: * {$smsComePastPresNe * $password * ((в/на) $mail)} *
        q!: * {$comNo * $letter * $resetNoun * $password} *
        q!: * $comWhere * $letter * ($resetNoun/$changeNoun) * $password * [$nelzya] *
        q!: {$comNo $letter и $password}
        q!: * {$cantPastPres * $resetPres * $password} *
        q!: * {$resetPresNe * $password} *
        q!: * {$password $smsComePastPresNe} *
        q: * {$forgetPastPres * $password} * || fromState = /Phone/NoUnknownTypeCode
        q: * {$resetNoun * $password} * || fromState = /Phone/NoUnknownTypeCode
        eg!: Account.EmailNotReceived
        if: $global.letterDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: По техническим причинам письма по электронной почте с купленными билетами, подтверждением регистрации и прочие электронные сообщения от «Столото» доставляются с задержкой. Не волнуйтесь, очень скоро ситуация разрешится и все сообщения будут доставлены.

        #TODO!: ADD STATE TO GET QUERY TO SEND USER TO SMS-RELATED-STATE

        state: GetUserData || fromState = /Account/EmailNotReceived
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/EmailNotReceived
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/EmailNotReceived
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q!: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q!: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q!: [$helloAll] [все] {$comThanks $letter приш*} *
            q!: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказалос*/попал*] (в $spamFolder) *

            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*) *
            q: * ($letter/да) ушло туда *
            a: Была рада Вам помочь.

        state: PasswordOrLetterDidntCome
            q!: [$helloAll] {$password $comNo}
            q!: * $password так и $smsComePastPresNe *
            q!: * {(в $spamFolder) [$letter] $nothing} *
            q!: * {(в $spamFolder) [$letter] [$ne одного] $comNo} *
            q!: * {(в $spamFolder) [$letter] отсутству*} *
            q!: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q!: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q!: * {$comNo $letter} * (смотрел*/посмотрел*/проверил*) *
            q!: * (смотрел*/посмотрел*/проверил*) * {$comNo $letter} *
            q!: * {$comNo там $letter} *
            q!: * $comNo нигде никак* $letter *
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: RegistrationLetterDidntCome
        # Не пришло письмо для завершения регистрации
        q!: * {$cantPastPres * $receiveInf * $letter * $registration} *
        q!: * {$cantPastPres * $receiveInf * $link * $registration} *
        q!: * {$cantPastPres * $receiveInf * $confirmation * $registration} *
        q!: * {$cantPastPres * $findInf * $letter * $registration} *
        q!: * {$cantPastPres * $findInf * $link * $registration} *
        q!: * {$cantPastPres * $findInf * $confirmation * $registration} *

        q!: * {$cantPastPres * $registerInfRefl} *
        q!: * {$cantPastPres * $registration} *
        q!: * {$cantPastPres * $registerInf * $account} *
        q!: * {(помоги*/помож*) * $doInf * $registration} *
        q!: * {(помоги*/помож*/$how) * $finishInf * $registration} *
        q!: * {(помоги*/помож*) * $registerInfRefl} *

        q!: * {$smsComePastPresNe * $letter * $registration} *
        q!: * {$smsComePastPresNe * $link * $registration} *
        q!: * {$smsComePastPresNe * приглашение * $registration} *
        q!: * {$smsComePastPresNe * $confirmation * $registration} *
        q!: * {$smsComePastPresNe * $letter * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $link * $registerInfRefl} *
        q!: * {$smsComePastPresNe * $confirmation * $registerInfRefl} *

        q!: * {$smsComePastPresNe * ($notification о $registration) * ((в/на) $mail)} *
        q!: * {$smsComePastPresNe * $sms * ((в/на) $mail) * $registration} *
        q!: * {$smsComePastPresNe $mail (для $registration)} *
        q!: * {$howLong * $letter * $registration} *
        q!: * {$howLong * $link * $registration} *
        q!: * {$howLong * $confirmation * $registration} *
        q!: * {$comNo * $letter * $registration} *
        q!: * {$comNo * $link * $registration} *

        q!: * {$comWhere * $letter * $registration} *
        q!: * {$comWhere * $link * $registration} *
        q!: * {$sendMeImp * $letter * $registration} *
        q!: * {$sendMeImp * $link * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $letter * $registration} *
        q!: * {$askYouAll * $sendMeInfPerf * $link * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $letter * $registration} *
        q!: * {$askYouAll * $duplicateInfPerf * $link * $registration} *

        q!: * {$howMuch * $waitInf * $letter * $registration} *
        q!: * {$howMuch * $waitInf * $link * $registration} *
        q!: * {$howLong * $waitInf * $letter * $registration} *
        q!: * {$howLong * $waitInf * $link * $registration} *
        q!: * {долго $bonusComePastPres $letter} * $registration *
        q!: * {долго $bonusComePastPres $link} * $registration *
        q!: * $registration * {долго $bonusComePastPres $letter} *
        q!: * $registration * {долго $bonusComePastPres $link} *

        q!: * {$delay * $link * $registration} *
        q!: * {$delay * $letter * $registration} *
        q!: * {$delay * $confirmation * $registration} *
        q!: * {$delay * $mail * $registration} *

        q: * {$smsComePastPresNe * $letter} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$smsComePastPresNe * $link} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$comNo $letter} * || fromState = /Account/WhereToEnterRegistrationCode
        q: * {$comNo $link} * || fromState = /Account/WhereToEnterRegistrationCode

        eg!: Account.RegistrationLetterDidntCome
        if: $global.registrationLetterDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: Спасибо, что сообщили о задержке. Мы уже работаем над возобновлением корректной работы системы рассылок.

        state: GetUserData || fromState = /Account/RegistrationLetterDidntCome
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/RegistrationLetterDidntCome
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/RegistrationLetterDidntCome
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [все] {$comThanks $letter приш*} *
            q: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказалос*/попал*] (в $spamFolder) *
            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*) *
            q: * ($letter/да) ушло туда *
            a: Была рада Вам помочь.

        state: LetterDidntCome
            q: * {(в $spamFolder) [$letter] $nothing} *
            q: * {(в $spamFolder) [$letter] [$ne одного] $comNo} *
            q: * {(в $spamFolder) [$letter] отсутству*} *
            q: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q: * {$comNo $letter} * (смотрел*/посмотрел*/проверил*) *
            q: * (смотрел*/посмотрел*/проверил*) * {$comNo $letter} *
            q: * {$comNo там $letter} *
            q: * $comNo нигде никак* $letter *
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: ReceiptDidntCome
        # Не пришел чек об оплате билета
        q!: получить ($receipt/~отчет о $buyN)
        q!: * {(~отчет о $buyN) $smsComePastPresNe} *
        q!: * {$stopped $smsComeInf $receipt} *
        q!: * {$smsComePastPresNe $receipt ((об/о/по/после) $payment [за] [$ticket/$lottery/лото])} *
        q!: * {$receipt * $smsComePastPresNe * ((в/на) $mail)} *
        q!: * $receiveInf ($receipt/~отчет о $buyN) * куплен* *
        q!: * {$buyPastPres * ($ticket/$lottery/лото)} * {($how/$comWhere) $receiveInf $receipt} *
        q!: * {$payPast * ($ticket/$lottery/лото)} * {($how/$comWhere) $receiveInf $receipt} *
        q!: * {$buyPastPres * ($ticket/$lottery/лото)} * {$comWhere [$comMy] $receipt} *
        q!: * {$payPast * ($ticket/$lottery/лото)} * {$comWhere [$comMy] $receipt} *
        q!: * $buyPastPres * ($ticket/$lottery/лото) * {$receipt [(в/на) $mail]$smsComePastPresNe} *
        q!: * ($ticket/$lottery/лото) * $buyPastPres * {$receipt [(в/на) $mail]$smsComePastPresNe} *
        q!: * $payPast * ($ticket/$lottery/лото) * {$receipt [(в/на) $mail] $smsComePastPresNe} *
        q!: * ($ticket/$lottery/лото) * $payPast * {$receipt [(в/на) $mail] $smsComePastPresNe} *
        q!: * $comWhere * {$receipt * $buyN * $lottery} *
        q!: * $comWhere * {$receipt * $buyN * $ticket} *
        q!: * {$sendPastPresNe $receipt} *
        q!: * $comWhere ~остальной $receipt *
        q!: * $comNo $notification о приеме $bet *
        q!: * {$comNo инфо* ((о/по/про) $ticket) ((в/на) $mail)} *
        q!: * {$smsComePastPresNe * ($notification о приеме $bet)} *
        q!: * {$receipt * приходят * ($with задержкой)} *
        q!: [$helloAll] {$receipt $smsComeFut} $or $comNo
        q!: [$helloAll] {$receipt $waitInf} $or $comNo
        q!: * {долго $bonusComePastPres $receipt} *
        eg!: Account.ReceiptDidntCome
        if: $global.receiptDeliveryIsAvailable
            a: Проверьте, пожалуйста, папку «Спам»/«Нежелательная почта», письмо может быть определено в нее. Вы можете добавить адрес mailer@stoloto.ru в адресную книгу для гарантированного получения наших писем без перенаправления их в папки нежелательной почты. Если письмо не поступило, сообщите, пожалуйста, данные, по которым проводили регистрацию: email и номер телефона.
        else:
            a: Спасибо, что информируете нас. Технические специалисты «Столото» уже работают над восстановлением работы сервиса. Надеемся, что в самое ближайшее время Вы сможете им воспользоваться.

        state: GetUserData || fromState = /Account/ReceiptDidntCome
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/ReceiptDidntCome
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/ReceiptDidntCome
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();

        state: LetterWasInSpam
            # нашел письмо в спаме
            q: [$helloAll] {$letter [$aha] [ура] (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [$aha] {[$letter/все] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) (в $spamFolder) [$comThanks]} [$repeat<$emoji>]
            q: [$helloAll] [все] {$comThanks $letter приш*} *
            q: * (точно/действительно/правда) [пришло/висит/лежит/$findPastPres/был*/нашл*/нашел/оказалос*/попал*] (в $spamFolder) *
            q: {[$letter] [$aha] [ура] [там и/туда и] (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*/был*) [в $spamFolder] [$comThanks]} [$repeat<$emoji>]
            q: * $spamFolder (пришло/висит/лежит/$findPastPres/был*) *
            q: * ($letter/да/все) (пришло/дошло/поступило/$findPastPres/нашл*/нашел/оказалос*) *
            q: * ($letter/да) ушло туда *
            a: Была рада Вам помочь.

        state: ReceiptOrLetterDidntCome
            q: [$helloAll] {$receipt $comNo}
            q: * $receipt так и $smsComePastPresNe *
            q: * {(в $spamFolder) [$letter] $nothing} *
            q: * {(в $spamFolder) [$letter] [$ne одного] $comNo} *
            q: * {(в $spamFolder) [$letter] отсутству*} *
            q: * {[$letter] (в $spamFolder) $smsComePastPresNe} *
            q: * {[$letter] (в $spamFolder) $findPastPresNe} *
            q: * {$comNo $letter} * (смотрел*/посмотрел*/проверил*) *
            q: * (смотрел*/посмотрел*/проверил*) * {$comNo $letter} *
            q: * {$comNo там $letter} *
            q: * $comNo нигде никак* $letter *
            q: * {[в $spamFolder] [$letter] ($nothing/$comNo)} *
            q: * {[$letter] [в $spamFolder] $smsComePastPresNe} *
            q: * {[$letter] [в $spamFolder] $findPastPresNe} *
            a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.


    state: ScammersSendLetters
        # Мошенники рассылают письма
        q!: * мошен* рассылают $letter *
        q!: * вы отправляете приглашение (в/на) $mail *
        q!: * (1000/тысяча) бесплатн* $ticket *
        q!: * написали $with (суперлото/супер лото) *
        q!: * $comWhat $oneWord (суперлото/супер лото) *
        q!: * {рассылк* * $ticket * (юбилейн* $ticketRun)} *
        q!: * {рассылк* * $ticket * ~юбилей} *
        q!: * {рассылк* * [$ticket] * (25 лет*)} *
        q!: * {дарите * $ticket * (25 лет*)} *
        q!: * {подарили * $ticket * (25 лет*)} *
        q!: * {$letter * $smsComePast} * (якобы/тип*) * дарите * $ticket *
        q!: * {$letter * $smsComePast} * что * {дарят * $ticket * ~юбилей} *
        q!: * {$letter * $smsComePast} * что * {дарите * $ticket * ~юбилей} *
        q!: * {$letter * $smsComePast} * что * {дарят * $ticket * (25 лет*)} *
        q!: * {$letter * $smsComePast} * что * {дарите * $ticket * (25 лет*)} *
        q!: * {$letter * $smsComePast} * что * {подарили * $ticket * $RL} *
        q!: * {$letter * $smsComePast} * {предложен * $ticket} *
        q!: * {~сообщение * $smsComePast} * {предложен * $ticket} *
        q!: * {$letter * $smsComePastPres} * (якобы/тип*) от (вас/$stoloto/ваш* имени) *
        q!: * {$letter * $smsComePastPres} * от (вас/$stoloto/ваш* имени) (якобы/тип*) *
        q!: * $RL дарил* бесплат* $ticket *
        q!: * 1000 бесплат* $ticket в подарок *
        q!: * $link на {бесплат* подарочн*} розыгрыш* *
        q!: * {$smsComePast * (бесплатн* $ticket) * $RL} * это (правда/ваш сайт/имеет * отношение к вам/[очередн*] (развод/фикция/$lohotron/афер*/мошен*)) *
        q!: * {$smsComePast * (подарочн* $ticket) * $RL} * это (правда/ваш сайт/имеет * отношение к вам/[очередн*] (развод/фикция/$lohotron/афер*/мошен*)) *
        q!: * {$letter * $smsComePast} * подарочн* $ticket * *пошлин* *
        q!: * {(подарочн* $ticket) * (предлож* оплатить)} *
        q!: * $mail * {(подарочн* $ticket) * $smsComePast} * я $winPastPerf *
        q!: * {$letter * $smsComePast * (25 лет*)} * *пошлин* *
        q!: * {($winPastPerf/$prizeLocal) * (25 лет*)} * *пошлин* *
        q!: * [якобы] * ($winPastPerf/$prizeLocal) * [$RL] * [требуют/просят] * *пошлин* *
        q!: * {(требуют/просят) * *пошлин*} *
        q!: * $viber * ($winPastPerf/$prizeLocal) * *пошлин* *
        q!: * Заберите Ваш подарочный билет к юбилейному тиражу *
        q!: * {$smsComePast * $letterAll * $mail * (от $RL)} *
        q!: * {$smsComePast * (юбилейн* $ticket) * $RL} *
        q!: * {$smsComePastPres * $letterAll * (от мошен*)} *
        q!: * {$smsComePastPres * $letterAll * (от афер*)} *
        q!: * {$smsComePastPres * $letterAll * (сомнительн* содерж*)} *
        q!: * {$smsComePastPres * $letterAll * (со странн* $mail)} *
        q!: * $RL в честь юбилея дарит (бесплатн* [подарочн*] $ticket) *
        q!: * (25 лет*) * дарим * (бесплатн* [подарочн*] $ticket) *
        q!: * (25 лет*) * (раздавать/раздовать) * $ticket *
        q!: * {$distributePres3 * $ticket * (25 лет*)} *
        q!: * {$distributePres3 * $ticket * (юбилейн*)} *
        q!: * {$distributePres3 * (бесплатн* [подарочн*] $ticket [$RL])} *
        q!: * {подарил* * $ticket} * ($winPastPerf/$prizeLocal) * просят $bankCardAll *
        q!: * {~розыгрыш * $RL} * просят * $bankCardAll *
        q!: * {[подарил*] * [$ticket]} * ($winPastPerf/$prizeLocal) * $prizeSum [$rub] *
        q!: * {прислать * $ticket} * ($winPastPerf/$prizeLocal) * $prizeSum [$rub] *
        q!: * {$smsComePast * $ticket} * ($winPastPerf/$prizeLocal) * $prizeSum [$rub] *
        q!: * {~розыгрыш * $RL} * ($winPastPerf/$prizeLocal) * $prizeSum [$rub] *
        q!: * [$smsComePast] * [$letterAll] * {($winPastPerf/$prizeLocal) * RL} * $prizeSum [$rub] *
        q!: * (проводил*/проводит*) * розыгрыш* * (25 лет*) *
        q!: * {$viber * $ticket * (в честь юбилея)} *
        q!: * {$viber * $ticket * (25 лет*)} *
        q!: * {$viber * (подарочн* $ticket)} *
        q!: * {юбилейн* * ~розыгрыш * проводит*} *
        q!: * якобы ~розыгрыш [от] $RL *
        q!: * {$smsComePast $ticket} (как/якобы) подарочн* *
        q!: * $ticket $with (так называем*/якобы) подарочн* $ticket *
        eg!: Account.ScammersSendLetters
        a: Данная информация не имеет отношения к «Столото». Подробнее с информацией о видах мошенничества по телефону и в интернете Вы можете ознакомиться, пройдя по ссылке http://www.stoloto.ru/warning-lottery-scam?int=faq .\n\nУточните, пожалуйста, адрес почты, с которого и на который поступило письмо.

        state: GetAnswer
            q: * {[$localEmail] * [$localEmail]} *
            script: Webim.switch();


    state: HowToResetPassword
        # Как восстановить пароль
        q!: $comMy $password
        q!: $comNeed восстановить доступ
        q!: * (забылпарол*/забылапарол*) *
        q!: * {$lostPast * $password} *
        q!: * {$forgetPastPres * $password * [$getPrizInf] * [$prizeWithoutMoney]} *
        q!: * {$cantPastPres * вспомнить * $password} *
        q!: * {$cantPastPres настроит* $password} *
        q!: * {$cantPastPres восстановить [$comMy] $accountAcc} *
        q!: * {$changeInf * $password} *
        q!: * {$changeImp * $password} *
        q!: * {$resetInf * $password} *
        q!: * {$resetImp * $password} *
        q!: * {$resetNoun * $password} *
        q!: * {$changeNoun * $password} *
        q!: * {$wrong $password} *
        q!: * {$findOutInf * $password * ~вход} *
        q!: * {$comNeed * $password * ~вход} *
        q!: * {$receiveInf * $password * ~вход} *
        q!: * {$findOutInf * $password * ~доступ} *
        q!: * {$comNeed * $password * ~доступ} *
        q!: * {$receiveInf * $password * ~доступ} *
        q!: * $how * $loginInf *
        q!: * {$cantPastPres * $loginInf} *
        q!: * {$cantPastPres * попасть * $accountAcc} *
        q!: * $how попасть в $accountAcc *
        q!: * невойти (в/на) $accountAcc *
        q!: * {$cantPastPres * вход * $account} *
        q!: * {$comNeed * вход * $account} *
        q!: * {$cantPastPres * вход * ~сайт} *
        q!: * {$comNeed * вход * ~сайт} *
        q!: * {$cantPastPres * вход * $stoloto} *
        q!: * {$comNeed * вход * $stoloto} *
        q!: * ~проблема * ~вход * (~сайт/$stoloto/$account) *
        q!: [$helloAll] {$comNo ~вход (в $account)}
        q!: [$helloAll] ($cantPastPres/$how) $resetInf ~доступ
        q!: * {$comNeed * ~доступ * $account} *
        q!: * {$comNo * ~доступ * $account} *
        q!: * {$resetInf * ~доступ * $account} *
        q!: * {$resetImp * ~доступ * $account} *
        q!: * {$resetNoun * ~доступ * $account} *
        q!: * ($ne заходит/незаходит/низаходит) на (сайт/$stoloto) *
        eg!: Account.HowToResetPassword
        # Проверка iF MOBILE пока не реализована на сторое Webim
        if: $session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1'
            a: Если Вы не помните данные для входа в личный кабинет, то Вы можете воспользоваться функцией «Забыли пароль». Для того чтобы изменить пароль, пройдите, пожалуйста, по ссылке из письма, которое поступит на адрес электронной почты, указанный при регистрации личного кабинета, и введите новый пароль. В случае, если письмо не было Вам доставлено, проверьте, пожалуйста, папку «Спам» или «Нежелательная почта».
        else:
            a: Для восстановления пароля через мобильное приложение воспользуйтесь, пожалуйста, кнопкой «Забыли пароль». Далее в открывшемся поле введите Ваш адрес электронной почты, на который зарегистрирован Ваш кабинет, и нажмите «Сбросить пароль». На указанный Вами адрес электронной почты поступит письмо с кодом подтверждения. Данный код необходимо скопировать и вставить в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль». Обратите, пожалуйста, внимание, что иногда письма от Столото могут попадать в папку «Спам». Если при восстановлении пароля возникли сложности, напишите нам, пожалуйста.

        state: AlreadyTried || fromState = /Account/HowToResetPassword
            q: * $tryPast *
            q: уже
            q: * $cantPastPres *
            q: * $smsComePastPresNe *
            q: * $receivePastNe *
            q: * $findPastPresNe *
            q: * $helpPastPresNe *
            q: * $problem *
            script: Webim.switch();


    state: IForgotMyLogin
        # Я забыл свой логин
        q!: * {$forgetPastPres * $login} *
        eg!: Account.IForgotMyLogin
        a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.


    state: IForgotMyLoginAndPassword
        # Я забыл свой логин и пароль
        q!: * {$forgetPastPres * $login * $password} *
        q!: * $forgetPastPres [$comMy] данные [указан*] $duringRegistration *
        q!: * $wrong {$login (и/$or) $password} *

        eg!: Account.IForgotMyLoginAndPassword
        if: $session.location === 'default' || $session.location === 'premiumclub' || $session.location === 'autorised' || $session.location === 'notautorised' || $session.location === 'default' || $session.location === 'default_1'
            a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.\n\nЕсли Вы не помните пароль для входа в личный кабинет, то Вы можете воспользоваться функцией «Забыли пароль». Для того чтобы изменить пароль, пройдите, пожалуйста, по ссылке из письма, которое поступит на адрес электронной почты, указанный при регистрации личного кабинета, и введите новый пароль. В случае, если письмо не было Вам доставлено, проверьте, пожалуйста, папку «Спам» или «Нежелательная почта».
        else:
            a: Логином является адрес электронной почты или номер телефона, который Вы указывали при регистрации.\n\nДля восстановления пароля через мобильное приложение воспользуйтесь, пожалуйста, кнопкой «Забыли пароль». Далее в открывшемся поле введите Ваш адрес электронной почты, на который зарегистрирован Ваш кабинет, и нажмите «Сбросить пароль». На указанный Вами адрес электронной почты поступит письмо с кодом подтверждения. Данный код необходимо скопировать и вставить в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль». Обратите, пожалуйста, внимание, что иногда письма от Столото могут попадать в папку «Спам». Если при восстановлении пароля возникли сложности, напишите нам, пожалуйста.


    state: StrangeConfirmationCode
        # Странный код подтверждения
        q!: * (непонятн*/неадекватн*/$ne (понятн*/адекватн*)/странный/длинный) [такой/какой-то/какой то] $code $confirmation *
        q!: * $code $confirmation [такой/какой-то/какой то] (непонятн*/неадекватн*/$ne (понятн*/адекватн*)/странный/длинный) *
        q!: * [$password/$resetNoun/попасть/$smsComePastPres] * (много/множеств*/количеств*/числ*) {букв и ($numeral/чисел)} * [$password/$resetNoun/попасть/$smsComePastPres] *
        q!: * $code $confirmation * такой *
        q!: * $password для смены (непонятн*/неадекватн*/$ne (понятн*/адекватн*)/странный/длинный) *
        eg!: Account.StrangeConfirmationCode
        a: При восстановлении пароля через мобильное приложение Вам поступит код. Код подтверждения при смене пароля представляет собой длинную последовательность цифр и букв. Скопируйте, пожалуйста, данный код и вставьте в открывшемся окне на странице нашего сайта. Далее введите Ваш новый пароль и нажмите «Изменить пароль».


    state: HowToChangeEmail
        # Как поменять почту
        q!: * {$changePast $mail} *
        q!: * {$changePast * $mail * (на $localEmail)} *
        q!: * {$changePast $mail} * {$phoneAndNum * $former} *
        q!: * {$phoneAndNum * $former} * {$changePast $mail} *
        q!: * {$changeInf * $mail * (на номере)} *
        q!: [$helloAll] {$changeInfAll [$comMy] $mail}
        q!: [$helloAll] {[$how] ввести ~другой $mail}
        q!: * {$how [мне] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {($changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} на сайте *
        q!: * {$want ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {$comWhere [мне] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {$possiblePredicAll [мне] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {(могу [$li] [я]) [сам*] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {смогу [сам*] ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {$comNeed ([$somehow] $changeInfAll [$somehow]) [$comMy] [устаревш*] $mail} *
        q!: * {($changeInfAll [$somehow]) $inLK $mail} *
        q!: * $changeInf [$comMy] $mail на (новый/новую) *
        q!: * {$cantPastPresAll $changeInfAll [$comMy] [устаревш*] $mail} *
        q!: * {$how [мне] $attachInf ($new $mail)} *
        q!: * {$want $attachInf ($new $mail)} *
        q!: * {$comWhere [мне] $attachInf ($new $mail)} *
        q!: * {$possiblePredicAll [мне] $attachInf ($new $mail)} *
        q!: * {могу [сам*] $attachInf ($new $mail)} *
        q!: * {смогу [сам*] $attachInf ($new $mail)} *
        q!: * {$comNeed $attachInf ($new $mail)} *
        q!: * {$cantPastPresAll $attachInf ($new $mail)} *
        q!: * {$changeNe $mail} *
        q!: * {$mail [мне/ко мне] (больше/уже) $belongPresSg3Ne} *
        q!: * (у меня/теперь) ~новый $mail * [$changeInfAll] [$comMy] [$mail] *
        q!: * (теперь/сейчас) ~другой $mail * [$changeInfAll] [$comMy] [$mail] *
        q!: * $usedPresNe (больше/уже) (эту/этот/этой/этим) $mail *
        q!: * $mail * (больше/более) ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * {$registerInf ($new $mail) (на [$oneWord] $phoneAndNum)} *

        q: * $mail * || fromState = /Account/HowToChangeData
        q: * $mail * || fromState = /Account/HowToChangeDataInLK
        eg!: Account.HowToChangeEmail
        a: Изменить адрес электронной почты можно только на основной версии сайта www.stoloto.ru (вход осуществляется через браузер). Для изменения адреса почты, пожалуйста, войдите в раздел «Профиль» Вашего личного кабинета, далее «Анкета».\n\nШаги изменения следующие:\n- сначала вводите новый адрес почты, на который хотите произвести изменение (нельзя ввести адрес, который уже использован для другой регистрации на нашем сайте). На указанный Вами новый адрес высылается сообщение с ссылкой для подтверждения;\n- после перехода по ссылке (из сообщения, поступившего на новую почту) на номер телефона от личного кабинета высылается код подтверждения, его тут же нужно ввести в соответствующее поле, только после этого новый адрес вступит в силу.\n\nЕсли у Вас возникнут вопросы, напишите нам, пожалуйста.

        state: HowToResetPassword
            q: * {$lostPast * $password} *
            q: * {$forgetPastPres * $password} *
            q: * {$cantPastPres * вспомнить * $password} *
            q: * {$cantPastPres настроит* $password} *
            q: * {$changeInf * $password} *
            q: * {$changeImp * $password} *
            q: * {$resetInf * $password} *
            q: * {$resetImp * $password} *
            q: * {$resetNoun * $password} *
            q: * {$changeNoun * $password} *
            q: * {$wrong $password} *
            q: * {$findOutInf * $password * ~вход} *
            q: * {$comNeed * $password * ~вход} *
            q: * {$receiveInf * $password * ~вход} *
            q: * {$findOutInf * $password * ~доступ} *
            q: * {$comNeed * $password * ~доступ} *
            q: * {$receiveInf * $password * ~доступ} *
            q: * $how * $loginInf *
            q: * {$cantPastPres * $loginInf} *
            q: * {$cantPastPres * попасть * $accountAcc} *
            q: * $how попасть в $accountAcc *
            q: * {$cantPastPres * вход * $account} *
            q: * {$comNeed * вход * $account} *
            q: * {$cantPastPres * вход * ~сайт} *
            q: * {$comNeed * вход * ~сайт} *
            q: * {$cantPastPres * вход * $stoloto} *
            q: * {$comNeed * вход * $stoloto} *
            q: * ~проблема * ~вход * (~сайт/$stoloto/$account) *
            q: * {$comNeed * ~доступ * $account} *
            q: * {$comNo * ~доступ * $account} *
            q: * {$resetInf * ~доступ * $account} *
            q: * {$resetImp * ~доступ * $account} *
            q: * {$resetNoun * ~доступ * $account} *
            go!: /Account/EmailChangeResetPassword

        state: IncorrectEmailAtRegistration
            q: * {$incorrectly * $indicatePast * $duringRegistration} *
            q: * {$wrong * $indicatePast * $duringRegistration} *
            q: * {$incorrectly * $indicatePartPas * $duringRegistration} *
            q: * {$wrong * $indicatePartPas * $duringRegistration} *
            go!: /Account/IncorrectEmailAtRegistration

    state: IncorrectEmailAtRegistration
        # Неправильно указал почту при регистрации
        q!: * {$changeImpAll * $mail * [на $localEmail]} *
        q!: * {$askYou $changeInfAll [$comMy] [устаревш*] $mail} *
        #q!: * {($correction/$changeNoun) * $mail} *
        q!: * {$changeInfAll * $mail * завершить * $registration} *
        q!: * {$changeInfAll * $mail * ~завершение * $registration} *
        q!: * {$changeNe * $mail * завершить * $registration} *
        q!: * {$changeNe * $mail * ~завершение * $registration} *
        q!: * {$changeInfAll * $mail * (~полный $registration)} *
        q!: * {$changeInfAll * $mail * ($wrong $duringRegistration)} *
        q!: * {$changeNe * $mail * ($wrong $duringRegistration)} *
        q!: * {$changeInfAll $mail $duringRegistration} *
        q!: * {$changeNe $mail $duringRegistration} *
        q!: * {($ne ~тот $mail) * $duringRegistration} *
        q!: * [$changeInfAll] * {$wrong [$indicatePast] $mail [я]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$wrong $indicatePartPas $mail [~окончание]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$wrong введен* $mail} * [$changeInfAll] *
        q!: * [$changeInfAll] * {ошибочн* введен* $mail} * [$changeInfAll] *
        q!: * {$incorrectly * $mail * $registration} *
        q!: * {$incorrectly * $indicatePartPas * $mail * $duringRegistration} *
        q!: * {$incorrectly * $mail * $registerPast3} *
        q!: * {($old $mail) * $registration} *
        q!: * {($old $mail) * $registerPast3} *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] $mail $indicatePast [я]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] $mail $indicatePartPas [~окончание]} * [$changeInfAll] *
        q!: * [$changeInfAll] * {$incorrectly [$comMy] введен* [~окончание] $mail} * [$changeInfAll] *
        q!: * {$makeAMistakePast * $mail * [$changeInfAll]} *
        q!: * {$mistake * $mail * [$changeInfAll]} *
        q!: * {~буква * $mail * [$changeInfAll]} *
        q!: * {$numeral * $mail * [$changeInfAll]} *
        q!: * $duringRegistration $makeAMistakePast на (одну/1) букву *

        q!: * [$changeInfAll] * (пропустил*/пропущен*) $oneWord в $mail * [$changeInfAll] *
        q!: * [$changeInfAll/$registerInfRefl] * {($ne ~тот) $mail} * [$changeInfAll/$registerInfRefl] *
        q!: * [$changeInfAll] * {$indicatePast * (нету $mail)} * [$changeInfAll] *
        q!: [$helloAll] [$comMy] $correct $mail $localEmail
        q!: [$helloAll] [$comMy] [$correct] $mail $localEmail а $ne $localEmail
        q!: [$helloAll] [$comMy] [$correct] $mail $ne $localEmail а $localEmail
        #q!: * {$mail [$localEmail] сменен} *
        q!: * $localEmail (актуальный/актуальная/правильный/правильная) $localEmail *
        q!: * $attachInf к $phoneAndNum $localMobilePhoneNumber $mail $localEmail *
        q!: * $phoneAndNum [$indicatePast] (верн*/правильн*) а $mail $comNo *
        q!: $mail ($ne подтвержден*/неподтвержден*) * $changeInfAll *
        q: * $mail * || fromState = /Account/HowToChangeDataAtRegistration
        eg!: Account.IncorrectEmailAtRegistration
        a: Уточните, пожалуйста, номер телефона и адрес электронной почты, которые Вы указывали при регистрации, а также верный адрес почты, мы поможем Вам произвести замену.

        state: GetUserData || fromState = /Account/IncorrectEmailAtRegistration
            q: * [$helloAll] {[$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: EmailChangeResetPassword
        # Здравствуйте изменилась Почта, пароль можно восстановить по номеру телефона?
        q!: * [$how] * [$resetInf/$loginInf] * {[больше] [тоже] $comNo ~доступ ((к/ка/на) [указ*] $mail)} * [$how] * [$resetInf/$loginInf] *
        q!: * [$resetInf/$loginInf] * {[больше] [тоже] $havePresSg1Ne ~доступ ((к/ка/на) [указ*] $mail)} * [$resetInf/$loginInf] *
        q!: * {$comNo [эт*/той/того] $mail уже} *
        q!: * {$comNo [эт*/той/того] $mail больше} *
        q!: * {$havePresSg1Ne [эт*/той/того] $mail уже} *
        q!: * ($comNo/$havePresSg1Ne) (данной/данного/эт*) $mail $comNow *
        q!: * {$lostPast ~доступ (к [эт*] $mail)} *
        q!: * $mail давно ($other/$new) *
        q!: * {($mail отсутствует) * $resetInf * $password} *
        q!: * {($mail отсутствует) * $resetInf * доступ} *
        q!: * {$changePast * $mail * $resetInf * $password} *
        q!: * {$changePast * $mail * $resetInf * доступ} *
        q!: * {$changePast * $mail * $resetImp * $password} *
        q!: * {$changePast * $mail * $forgetPastPres * $password} *
        q!: * {$changePast * $mail * $changeInf * $password} *
        q!: * {$changePast * $mail * $resetNoun} *
        q!: * {$changePast * $mail * (невойти (в/на) $accountAcc)} *
        q!: * {$changePast * $mail} * {$sendMeImp * $sms * $code} *
        q!: * {$changeInf * $mail * ($resetNoun $password)} *
        q!: * {$changeInf * $mail * ($changeNoun $password)} *
        q!: * {$changePast $mail} * $how * $registerInfRefl *
        q!: * {($comNo (этой/этого/такой/такого) $mail) * $resetInf * $password} *
        q!: * {($comNo (этой/этого/такой/такого) $mail) * $resetImp * $password} *
        q!: * {($comNo (этой/этого/такой/такого) $mail) * $forgetPastPres * $password} *
        q!: * {($comNo (этой/этого/такой/такого) $mail) * $changeInf * $password} *
        q!: * {($comNo (этой/этого/такой/такого) $mail) * $resetNoun} *

        q!: * {($havePresSg1Ne (этой/этого/такой/такого) $mail) * $resetImp * $password} *
        q!: * {($havePresSg1Ne (этой/этого/такой/такого) $mail) * $forgetPastPres * $password} *
        q!: * {($havePresSg1Ne (этой/этого/такой/такого) $mail) * $changeInf * $password} *
        q!: * {($havePresSg1Ne (этой/этого/такой/такого) $mail) * $resetNoun} *
        q!: * указывал* $mail * ~доступ (к ней) ($comNo/$havePresSg1Ne) * $resetInf *
        q!: * указывал* $mail * (ей/ее) $usedPresNe * $resetInf *
        q!: * потерял* [$comMy] $mail * $resetInf [$comMy] ($password/аккаунт) *

        q!: * {($new $mail) * $resetInf * $password} *
        q!: * {($new $mail) * $resetInf * доступ} *
        q!: * {($new $mail) * $resetImp * $password} *
        q!: * {($new $mail) * $forgetPastPres * $password} *
        q!: * {($new $mail) * $changeInf * $password} *
        q!: * {($mail другой) * $resetInf * $password} *
        q!: * {($mail другой) * $resetInf * доступ} *
        q!: * {($mail другой) * $resetImp * $password} *
        q!: * {($mail другой) * $forgetPastPres * $password} *
        q!: * {($mail другой) * $changeInf * $password} *
        q!: * {($mail другая) * $resetInf * $password} *
        q!: * {($mail другая) * $resetInf * доступ} *
        q!: * {($mail другая) * $resetImp * $password} *
        q!: * {($mail другая) * $forgetPastPres * $password} *
        q!: * {($mail другая) * $changeInf * $password} *
        q!: * {$existNeSg3 * $mail * $resetInf * $password} *
        q!: * {$existNeSg3 * $mail * $resetInf * доступ} *
        q!: * {$existNeSg3 * $mail * $resetImp * $password} *
        q!: * {$existNeSg3 * $mail * $changeInf * $password} *
        q!: * {$existNeSg3 * $mail * $forgetPastPres * $password} *
        q!: * {$usedPresNe * $mail * $resetInf * $password} *
        q!: * {$usedPresNe * $mail * $resetImp * $password} *
        q!: * {$usedPresNe * $mail * $changeInf * $password} *
        q!: * {$usedPresNe * $mail * $forgetPastPres * $password} *
        q!: * {$forgetPastPres * $mail * $resetInf * $password} *
        q!: * {$forgetPastPres * $mail * $changeInf * $password} *
        q!: * {$forgetPastPres * $password} * {$forgetPastPres * $mail} *
        q!: * {$cantPastPres $loginInf} * {$changePast * $mail} *
        q!: * {$changePast * $mail} * {$cantPastPres [теперь] $loginInf} *
        q!: * {$how $loginInf} * {$changePast * $mail} *
        q!: * {$changePast * $mail} * {$how [теперь] $loginInf} *
        q!: * {$changeInf $mail} $forTo $loginInf * [$account] *
        q!: * {$cantPastPres $loginInf} * {$changeInfAll * $mail} *
        q!: * {$cantPastPres $loginInf} * {$forgetPastPres * $mail} *
        q!: * {$cantPastPres $loginInf} * {$makeAMistakePast * $mail} *
        q!: * {$cantPastPres $loginInf} * {$mistake * $mail} *
        q!: * {$cantPastPres $loginInf} * {~старый $mail} *
        q!: * {$cantPastPres * $loginInf} * (у меня/теперь) ~новый $mail *
        q!: * {$cantPastPres * $loginInf} * $mail * $existNeSg3 *
        q!: * {$cantPastPres * $loginInf} * $comNo возможн* $loginInf (в/на) $mail *
        q!: * {$how $loginInf} * {~старый $mail} *
        q!: * $how * $loginInf * [$account] * {$changeInf * $mail} *
        q!: * {$cantPastPres $loginInf ((на/в) $mail)} * {$resetInf * $password} *
        q!: * {$resetInf * $password} * {$cantPastPres $loginInf ((на/в) $mail)} *
        q!: * {$cantPastPres $loginInf ((на/в) $mail)} * {$changeInf * $password} *
        q!: * {$changeInf * $password} * {$cantPastPres $loginInf ((на/в) $mail)} *
        q!: * друг* $mail * {$cantPastPres $loginInf} *
        q!: * {$old * $mail * $resetInf * $password} *
        q!: * {$old * $mail * $resetInf * доступ} *
        q!: * {$old * $mail * $changeInf * $password} *
        q!: * {$wrong * $mail * $resetInf * $password} *
        q!: * {$wrong * $mail * $changeInf * $password} *
        q!: * {$incorrectly ([$comMy] $mail) $indicatePast [я]} * $resetNoun *
        q!: * {$incorrectly ([$comMy] $mail) $indicatePartPas [~окончание]} * $resetNoun *
        q!: * {$incorrectly введен* [~окончание] ([$comMy] $mail)} * $resetNoun *
        q!: * $resetNoun * {$incorrectly ([$comMy] $mail) $indicatePast [я]} *
        q!: * $resetNoun * {$incorrectly ([$comMy] $mail) $indicatePartPas [~окончание]} *
        q!: * $resetNoun * {$incorrectly введен* [~окончание] ([$comMy] $mail)} *
        q!: * {$belongPresSg3Ne * $mail * $resetInf * $password} *
        q!: * {$belongPresSg3Ne * $mail * $changeInf * $password} *
        q!: * {[больше] $comNo ~доступ ((к/на) $mail)} * {$resetInf * $password} *
        q!: * {$resetInf * $password} * {[больше] $comNo ~доступ ((к/на) $mail)} *
        q!: * {[больше] $comNo ~доступ ((к/на) $mail)} * {$changeInf * $password} *
        q!: * {$changeInf * $password} * {[больше] $comNo ~доступ ((к/на) $mail)} *
        q!: * {[больше] $comNo ~доступ ((к/на) $mail)} * {$forgetPastPres * $password} *
        q!: * {$forgetPastPres * $password} * {$comNo * (~доступ ((к/на) $mail))} *
        q!: * {[$changeInf] * $password * ($ne на ~мой $mail)} *

        q!: * $resetInf $by $telephoneNumber *
        q!: * {$resetInf * $password * (($by/на) $telephoneNumber)} *
        q!: * {$sendMeImp * $password * (($by/на) $telephoneNumber)} *
        q!: * {($resetNoun $password) * (($by/на) $telephoneNumber)} *
        q!: * {$askYouAll * $sendMeInfPerf * $password * (($by/на) $telephoneNumber)} *
        q!: * {$askYouAll * $duplicateInfPerf * $password * (($by/на) $telephoneNumber)} *
        q!: * {$possiblePredicAll * $password * (($by/на) $telephoneNumber)} *

        q!: * {$resetInf * $password * (($by/на) $telephone)} *
        q!: * {$sendMeImp * $password * (($by/на) $telephone)} *
        q!: * {$askYouAll * $sendMeInfPerf * $password * (($by/на) $telephone)} *
        q!: * {$askYouAll * $duplicateInfPerf * $password * (($by/на) $telephone)} *
        q!: * {$possiblePredicAll * $password * (($by/на) $telephone)} *

        q!: * {$resetInf * $password * (($by/на) $sms)} *
        q!: * {$sendMeImp * $password * (($by/на) $sms)} *
        q!: * {$askYouAll * $sendMeInfPerf * $password * (($by/на) $sms)} *
        q!: * {$askYouAll * $duplicateInfPerf * $password * (($by/на) $sms)} *
        q!: * {$possiblePredicAll * $password * (($by/на) $sms)} *

        q!: * {$resetInf * $code * $resetNoun * (($by/на) $telephone)} *
        q!: * {$sendMeImp * $code * $resetNoun * (($by/на) $telephone)} *
        q!: * {$askYouAll * $sendMeInfPerf * $code * $resetNoun * (($by/на) $telephone)} *
        q!: * {$askYouAll * $duplicateInfPerf * $code * $resetNoun * (($by/на) $telephone)} *
        q!: * {$possiblePredicAll * $code * $resetNoun * (($by/на) $telephone)} *
        q!: * {$cantPastPres * $loginInf} * $wrong [$oneWord] $mail *
        q!: * [$resetInf] * {$password * $smsComePres * (~другой $mail)} * [$resetInf] *
        q!: * [$resetInf] * {$password * $smsComePres * ($old $mail)} * [$resetInf] *
        q!: * [$resetInf] * {~информация * $smsComePres * ($old $mail)} * [$resetInf] *
        q!: * [$resetInf] * {$password * $sendPres3 * (~другой $mail)} * [$resetInf] *
        q!: * [$resetInf] * {$password * $sendPres3 * ($old $mail)} * [$resetInf] *
        q!: * [$resetInf] * {~информация * $sendPres3 * ($old $mail)} * [$resetInf] *

        q!: * {$resetInf * $password * ($mixUpPast3 [$comMy] $mail)} *
        q!: * {$resetInf * $password} * $mail * (больше/более) ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * {$forgetPastPres * $password} * $mail * (больше/более) ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * {$resetInf * $password} * $mail ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * {$forgetPastPres * $password} * $mail ($ne (доступн*/доступен/доступин/активн*/активен)/неактивн*/неактивен/недоступн*/недоступен/недоступин/нидоступн*/нидоступен/нидоступин/ниактивн*/ниактивен) *
        q!: * восстановить * $accountAcc * $cantPastPres * (попасть/войти) * $mail *

        q: * ввести ~другой $mail * || fromState = /Account/HowToResetPassword
        q: * {$changePast $mail} * || fromState = /Account/HowToResetPassword
        q: * {$changePast * $mail * (на $localEmail)} * || fromState = /Account/HowToResetPassword
        q: * {*менен* * $mail} * || fromState = /Account/HowToResetPassword
        q: * {$cantPastPres $resetInf $mail} * || fromState = /Account/HowToResetPassword
        q: * {$mail (взломал*/взломан*)} * || fromState = /Account/HowToResetPassword
        q: * {$forgetPastPres * $mail} * || fromState = /Account/HowToResetPassword
        q: * {$comNo $mail} * || fromState = /Account/HowToResetPassword
        q: * {$mail * ~старый} * || fromState = /Account/HowToResetPassword
        q: * {($ne имею) ~доступ (к эт* $mail)} * || fromState = /Account/HowToResetPassword

        q: * ввести ~другой $mail * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$changePast $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$changePast * $mail * (на $localEmail)} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {*менен* * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$cantPastPres $resetInf $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$mail (взломал*/взломан*)} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$forgetPastPres * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        q: {$comNo $mail} || fromState = /Account/IForgotMyLoginAndPassword
        q: * {$mail * ~старый} * || fromState = /Account/IForgotMyLoginAndPassword
        q: * {($ne имею) ~доступ (к эт* $mail)} * || fromState = /Account/IForgotMyLoginAndPassword

        eg!: Account.EmailChangeResetPassword
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/EmailChangeResetPassword
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/EmailChangeResetPassword
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/EmailChangeResetPassword
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: WhatEmailDidIEnterDuringRegistration
        # Какую почту я вводил при регистрации?
        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} *
        q!: * ~какой * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} *
        q!: * $findOutInf * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * $findOutInf * {$mail $tied ((к/за) ($telephone/$telephoneNumber) [$localMobilePhoneNumber])} *
        q!: * $findOutInf * {$mail $tied ((к/за) $localMobilePhoneNumber)} *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {(вводил*/проходил*/производил*) * $registration} *
        q!: * $knowNe * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} *
        q!: * $forgetPastPres * $mail * {(вводил*/проходил*/производил*/$indicatePast) * $registration} * [$localMobilePhoneNumber] *

        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {$registered * ($account/я/страница)} *
        q!: * ~какой * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {$registered * ($account/я/страница)} *
        q!: * $findOutInf * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {$registered * ($account/я/страница)} *
        q!: * $knowNe * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {$registered * ($account/я/страница)} *
        q!: * $forgetPastPres * $mail * {$registered * ($account/я/страница)} * [$localMobilePhoneNumber] *
        q!: * $findOutInf $mail * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf $mail * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} *
        q!: * [$localMobilePhoneNumber] * напомните * $mail ~который * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} *
        q!: * напомните * $mail ~который * {(указал*/указывал*/указан*/$indicatePast) * $duringRegistration} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres $mail * $duringRegistration * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * ~какой * $mail * {$registerPast3 * ($account/я)} *
        q!: * ~какой * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $findOutInf * $mail * {$registerPast3 * ($account/я)} *
        q!: * $findOutInf * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $knowNe * $mail * {$registerPast3 * ($account/я)} *
        q!: * $knowNe * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * $forgetPastPres * $mail * {$registerPast3 * ($account/я)} *
        q!: * $forgetPastPres * $mail * {$registerPast3 * ($account/я)} * [$localMobilePhoneNumber] *

        q!: * [$localMobilePhoneNumber] * ($forgetPastPres/$knowNe) * $mail * $registerPastRefl3 *
        q!: * ($forgetPastPres/$knowNe) * $mail * $registerPastRefl3 * [$localMobilePhoneNumber] *
        q!: * [$localMobilePhoneNumber] * {$forgetPastPres $mail} * [$localMobilePhoneNumber] *
        # Забыл пароль и почту
        q!: * $forgetPastPres {$mail и ($password [от [$comMy] $account])} *
        q!: * {утерян* $mail} * {$resetInf * $password} *
        q!: * {$resetInf * $password} * {утерян* $mail [тоже]} *
        q!: * {$cantPastPres * *спомнить * $password} * $mail [тоже]$forgetPastPres *
        q!: * {$cantPastPres * *спомнить * $password} * {утерян* $mail [тоже]} *
        q!: * {$cantPastPres * $loginInf} * {утерян* * $mail} *
        q: * {утерян* * $mail} * || fromState = /Account/HowToResetPassword
        q: * {утерян* * $mail} * || fromState = /Account/IForgotMyLoginAndPassword
        eg!: Account.WhatEmailDidIEnterDuringRegistration
        script:
            $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
        if: !$session.usrPhoneNumber
            a: Уточните, пожалуйста, номер телефона, с которым проводили регистрацию на сайте.
        else:
            script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/WhatEmailDidIEnterDuringRegistration
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script: Webim.switch();


    state: SuchEmailIsAlreadyRegistered
        # При регистрации пишут, что такая почта уже зарегистрирована
        q!: * [$isWritten] * {(~такой/токой/$this/$comMy) $mail $yet ($registered/существует/есть)} *
        q!: * $isWritten [что] $yet ($registered/существует/есть) $account на (~такой/токой/$this/$comMy) $mail *
        q!: * $mail $isWritten [что] (~такой/токой) ($registered/существует/есть) *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $mail * $registered} *
        q!: * {$isWritten * $mail * $registered} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $mail * $registered} *

        q!: * $registerPastContReflSg3Ne * {$isWritten * $mail * уже * (существует/есть)} *
        q!: * {$isWritten * $mail * уже * (существует/есть)} * $registerPastContReflSg3Ne *

        q!: * $indicatePresSg1 * {$isWritten * $mail * уже * (существует/есть)} *
        q!: * {[~такой/токой/$this/$comMy] $mail $yet $somebody $indicatePast $duringRegistration} *
        q!: * $mail $yet (кем-то/кем то) указан* $duringRegistration *
        q!: * $mail ([был*] использован*/использовал*) ~другой ~человек *
        q!: * (~такой/токой/$this/$comMy) $mail указан* как $registered *
        q!: * {$changeNe $mail} * $yet ($registered/существует/есть) *
        q!: * (кто-то/кто то) $yet $existPresSg3 $with [эт*/так*/дан*] $mail *
        eg!: Account.SuchEmailIsAlreadyRegistered
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/SuchEmailIsAlreadyRegistered
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: UserWithSuchDataAlreadyExists
        # Пользователь с такими данными уже есть в системе
        q!: * [$isWritten] * (такие/такой/такая/эти/этот/$comMy) {$phoneAndNum и ([$comMy] $mail)} [$yet] ($registered/существуют/есть/используют*) *
        q!: * $isWritten * (существует/существуют) [такие/такой/такая/эти/этот/$comMy]  {$phoneAndNum и ([$comMy] $mail)} *
        q!: * [$isWritten] * такие данные [$yet] ($registered/существуют/есть/используют*) *
        q!: * [$isWritten] * такой (пользователь/аккаунт) [$yet] ($registered/существует/есть) * [$cantPastPresAll] *
        q!: * (кто-то/кто то) $yet $existPresSg3 $with [эт*/так*/дан*] (данными/{$mail и $phoneAndNum}) *
        eg!: Account.UserWithSuchDataAlreadyExists
        a: Уточните, пожалуйста, Ваши регистрационные данные: номер телефона и адрес электронной почты.

        state: GetUserData || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * {[$helloAll] [$comMy] [$mail] $localEmail * [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber} *
            script: Webim.switch();

        state: GetUserEmail || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * [$helloAll] [$comMy] [$mail] $localEmail *
            script:
                $session.usrEmail = $parseTree._localEmail;
            if: !$session.usrPhoneNumber
                a: Укажите, пожалуйста, Ваш номер телефона.
            else:
                script: Webim.switch();

        state: GetUserPhoneNumber || fromState = /Account/UserWithSuchDataAlreadyExists
            q: * [$helloAll] [$comMy] [$telephoneNumber/$telephone] $localMobilePhoneNumber *
            script:
                $session.usrPhoneNumber = $parseTree._localMobilePhoneNumber;
            if: !$session.usrEmail
                a: Укажите, пожалуйста, Вашу электронную почту.
            else:
                script: Webim.switch();


    state: HowToSetUpMailForwarding
        # Как настроить переадресацию писем?
        q!: * (настроит*/сделат*/произвести) * $mailForwarding
        q!: * $mailForwarding * (настроит*/сделат*/произвести)
        q!: * {настроит* * $mailForwarding * $mail} *
        q!: * {настроит* * $mailForwarding * $letter} *
        q!: * {сделат* * $mailForwarding * $mail} *
        q!: * {сделат* * $mailForwarding * $letter} *
        q!: * {произвести * $mailForwarding * $mail} *
        q!: * {произвести * $mailForwarding * $letter} *
        eg!: Account.HowToSetUpMailForwarding
        a: Данную информацию Вы можете уточнить в службе поддержки Вашего почтового сервера.


    state: HowToChangeName
        # Как сменить имя
        # Как изменить фамилию
        q!: * {$changeInfImpAll * ~имя} *
        q!: * {$changeInfImpAll * ~фамилия} *
        q!: * {$incorrectly * $indicatePast * ~имя} *
        q!: * {$incorrectly * $indicatePast * ~фамилия} *
        q!: * {$changePast * ~фамилия} *
        q!: * $indicatePast $ne $comMy ~имя *
        q!: * $indicatePast $ne $comMy ~фамилия *
        q!: * $indicatePartPas ($ne $comMy/чужое) ~имя *
        q!: * $indicatePartPas ($ne $comMy/чужая) ~фамилия *
        q!: * ~фамилия $comMy а ~имя [отчество] ($ne $comMy/чужое) *
        q!: * я $ne $name (я/а) $name *
        q!: * меня зовут $ne $name (я/а) $name *
        q!: * $comMy ~имя $ne $name (я/а) $name *
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeData
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeDataInLK
        q: * (~имя/~фамилия) * || fromState = /Account/HowToChangeDataAtRegistration
        eg!: Account.HowToChangeName
        a: Изменить имя можно только на основной версии сайта www.stoloto.ru (вход осуществляется через браузер). Для изменения имени, пожалуйста, войдите в Ваш личный кабинет и нажмите на «Редактировать данные».


    state: HowToChangeData
        # Как изменить данные
        q!: * {$changeInf [$comMy] данные} *
        eg!: Account.HowToChangeData
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


    state: HowToChangeDataInLK
        # Как изменить данные в лк
        q!: * {$changeInf [$comMy] данные} * ($account/анкет*/$application/сайте/странице/настройках) *
        q!: * ($account/анкет*/$application/сайте/странице/настройках) * {$changeInf [$comMy] данные} *
        eg!: Account.HowToChangeDataInLK
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


    state: HowToChangeDataAtRegistration
        # Как изменить данные при регистрации
        q!: * {$changeInf [$comMy] данные $duringRegistration} *
        eg!: Account.HowToChangeDataAtRegistration
        a: Уточните, пожалуйста, какие данные Вы хотите изменить?


















