theme: /Site

    state: TechnicalProblems
        # Стейт для различных технических проблем. Запросы необходимо добавлять в классификатор в соответствующий класс TechnicalProblems2 (находится во вкладке Site), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

        eg!: Site.TechnicalProblems
        a: 


    state: TechnicalProblems2
        # Стейт для различных технических проблем. Запросы необходимо добавлять в классификатор в соответствующий класс TechnicalProblems2 (находится во вкладке Site), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

        eg!: Site.TechnicalProblems2
        a: 

    state: TechnicalProblems3
        # Стейт для различных технических проблем. Запросы необходимо добавлять в классификатор в соответствующий класс TechnicalProblems3 (находится во вкладке Site), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

        eg!: Site.TechnicalProblems3
        a: Условия проведения лотерей соблюдены и полностью соответствуют приказу Министерства спорта РФ и закону «О лотереях».

    state: TechnicalProblems4
        # Стейт для различных технических проблем. Запросы необходимо добавлять в классификатор в соответствующий класс TechnicalProblems4 (находится во вкладке Site), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

        eg!: Site.TechnicalProblems4
        a: Проведение тиражей «Гослото «5 из 36»» как с помощью ГСЧ, так и при помощи лототрона, полностью соответствует требованиям условий проведения лотереи, и не нарушает федеральный закон «О лотереях».

    state: TechnicalProblems5
        # Стейт для различных технических проблем. Запросы необходимо добавлять в классификатор в соответствующий класс TechnicalProblems5 (находится во вкладке Site), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

        eg!: Site.TechnicalProblems5
        a:

        state: Question1
            # Стейт для вопросов после ответа бота из стейта TechnicalProblems5. Запросы необходимо добавлять в классификатор в соответствующий класс Question1 (находится во вкладке Site, во вкладке TechnicalProblems5), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

            eg: Site.TechnicalProblems5.Question1
            a:

        state: Question2
            # Стейт для вопросов после ответа бота из стейта TechnicalProblems5. Запросы необходимо добавлять в классификатор в соответствующий класс Question2 (находится во вкладке Site, во вкладке TechnicalProblems5), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

            eg: Site.TechnicalProblems5.Question2
            a:

        state: Question3
            # Стейт для вопросов после ответа бота из стейта TechnicalProblems5. Запросы необходимо добавлять в классификатор в соответствующий класс Question3 (находится во вкладке Site, во вкладке TechnicalProblems5), а ответ нужно прописать здесь в теге a: (если ответ не прописан, бот будет молчать в ответ)

            eg: Site.TechnicalProblems5.Question3
            a:


    state: IsThisTheOfficialSite
        # Это официальный сайт?
        q!: * это [точно/правда/действительно] (офиц*/настоящий) сайт *
        q!: * это (точно/правда/действительно) сайт $stoloto *
        q!: * я [нахожус*] на (офиц*/настоящем) сайте *
        q!: * я (попал*/зашел*) на (офиц*/настоящий) сайт *
        q!: * точно на сайте $stoloto *
        q!: * это (точно/правда/действительно) $technicalSupport $stoloto *
        q!: * [$sendMeInfPerf/$duplicateInfPerf] * (ссылку/ссылкой) на (офиц*/настоящий) сайт * [$sendMeInfPerf/$duplicateInfPerf] *
        eg!: Site.IsThisTheOfficialSite
        a: Вы обратились в чат технической поддержки сайта «Столото». Наш официальный сайт: www.stoloto.ru\nЧем я могу Вам помочь?


    state: HowToSwitchToTheMainVersionOfTheSite
        # Как перейти на основную версию сайта?
        q!: * $downloadInf * (~основной (сайт/версию)) *
        q!: * (~основной (сайт/версию)) * $downloadInf *
        q!: * (перейти/выйти/пройти/попасть/переключитьс*/переключитс*) на (~основной (сайт/версию/страни*)) *
        q!: * на (~основной (сайт/версию/страни*)) * (перейти/выйти/пройти/попасть/переключитьс*/переключитс*) *
        q!: * $comWhere $oneWord (~основной (сайт/версия/версию/страни*)) *
        q!: * $link * (~основной (сайт*/~версия)) *

        q: * {[$here] $comNo $green $button} * || fromState = /Payments/HowToWithdrawMoney
        q: * {[$here] $findPastPresNe $green $button} * || fromState = /Payments/HowToWithdrawMoney

        q: из || fromState = /Payments/ThereIsNoGreenButton
        q: * $fromWallet * || fromState = /Payments/ThereIsNoGreenButton
        q: * $onExternalResource [$ne $toWalletAll] * || fromState = /Payments/ThereIsNoGreenButton
        q: $externalResource || fromState = /Payments/ThereIsNoGreenButton
        q: [на] (сторонний/сторонние) || fromState = /Payments/ThereIsNoGreenButton
        q: на ресурсы || fromState = /Payments/ThereIsNoGreenButton
        q: * (со/из) $stoloto * || fromState = /Payments/ThereIsNoGreenButton
        q: * с сайта * || fromState = /Payments/ThereIsNoGreenButton

        eg!: Site.HowToSwitchToTheMainVersionOfTheSite
        a: Попробуйте, пожалуйста, выполнить данные действия на основной версии сайта. Для этого необходимо пройти по ссылке https://www.stoloto.ru/ . Затем внизу экрана нажмите, пожалуйста, «Основная версия». Таким образом Вы можете зайти на основную версию сайта «Столото» через браузер Вашего устройства.


    state: HowToDownloadTheApplication
        # Как скачать приложение?
        q!: {$application $stoloto}
        q!: {$downloadInf $application [$link]}
        q!: [$how] $downloadInf на (устройство/телефон)
        q!: * {$how * $downloadInf * $application} *
        q!: * {$comNeed * $downloadInf * $application} *
        q!: * {$comWhere * $downloadInf * $application} *
        q!: * {$fromWhere * $downloadInf * $application} *
        q!: * {помоги* * $downloadInf * $application} *
        q!: * {обновить $application} *
        q!: {$downloadInf $stoloto [$link]}
        q!: {$downloadInf лото [$link]}
        q!: * ($how/$comWhere) * {$downloadInf ($stoloto/лото)} *
        q!: * {$downloadInf ($stoloto/лото)} * $how *
        q!: * {$stoloto * $playMarket} *
        q!: * {лото * $playMarket} *
        q!: * {[$cantPastPres] * [$downloadInf] * $application * $playMarket} *
        q!: * {$application $stoloto $existPresSg3} *
        q!: * {$application лото $existPresSg3} *
        q!: * {$link * скачивани* * $application} *
        q!: * $link на [$oneWord] $application *
        q!: * {$how называет* [ваше] $application} *
        q!: * $how {$findInf [ваше] ($application [$stoloto/лото])} *
        eg!: Site.HowToDownloadTheApplication
        a: Для того чтобы установить полную версию мобильного приложения «Столото», скачайте его, пожалуйста, с официального сайта www.stoloto.ru (через браузер).\n\nВ настоящий момент мобильное приложение «Столото» отсутствует в Google Play и Play Market. По правилам данных ресурсов запрещено предлагать контент и услуги лотерей, а также игр, в которых выигрышем являются денежные и другие ценные призы.\n\nСкачать приложение Вы можете по ссылке https://www.stoloto.ru/mobile-applications?bls=prilogenia_stoloto&int=podval


    state: ICantToDownloadTheApplication
        # Не получается скачать приложение
        q!: * {$cantPastPres * $downloadInf * $application * [$link]} *
        q!: * $cantPastPres * {$downloadInf $stoloto} *
        q!: * {$downloadInf $stoloto} * $cantPastPres *
        q!: * {$downloadPres3Ne * $application * [$link]} *
        q!: * {$link * скачивани* * $application * $inactive} *
        q!: * {($link на [$oneWord] $application) * $inactive} *
        q!: * $link $ne на скачивани* *
        q!: * {(файл* для скачивани*) * $comNo} *
        eg!: Site.ICantToDownloadTheApplication
        a: Для того чтобы установить полную версию мобильного приложения «Столото», скачайте его, пожалуйста, с официального сайта www.stoloto.ru (через браузер).\n\nВ настоящий момент мобильное приложение «Столото» отсутствует в Google Play и Play Market. По правилам данных ресурсов запрещено предлагать контент и услуги лотерей, а также игр, в которых выигрышем являются денежные и другие ценные призы.\n\nСкачать приложение Вы можете по ссылке https://www.stoloto.ru/mobile-applications?bls=prilogenia_stoloto&int=podval \n\nЕсли при скачивании приложения возникли трудности, уточните, пожалуйста, Ваши регистрационные данные (номер телефона и адрес электронной почты), данные Вашего устройства (платформу, версию ПО), а также опишите, пожалуйста, на каком этапе и какая возникает сложность.

        state: GetUserData || fromState = /Site/ICantToDownloadTheApplication
            q: * {[$helloAll] [$comMy] [$mail] [$localEmail] * [$comMy] [$telephoneNumber/$telephone] [$localMobilePhoneNumber]} *
            script: Webim.switch();


    state: ApplicationDoesntWork
        # Не открывается мобильное приложение
        q!: * {$application * $inactive} *
        q!: * {$application зависл*} *
        q!: * {$application * $workPres3SgNe} *
        q!: * {$application * $openPres3Ne} *
        q!: * {$cantPastPresAll * открыть * $application} *
        eg!: Site.ApplicationDoesntWork
        if: $global.applicationIsAvailable
            script: Webim.switch();
        else:
            a: Спасибо, что информируете нас. Технические специалисты «Столото» уже работают над восстановлением работы сервиса. Надеемся, что в самое ближайшее время Вы сможете им воспользоваться.


    state: HowToEnableCookies
        # Как включить куки?
        q!: * {$enableInfImp * $cookies} *
        q!: * (просит/просят/требует/требуют) * $cookies *
        eg!: Site.HowToEnableCookies
        a: Для того чтобы включить куки, нужно:\n\n1. Зайти в настройки Вашего браузера.*\n2. Выбрать в выпадающем окне меню «Общие настройки», «Параметры» или «Сервис» (в зависимости от используемого Вами браузера).\n3. Перейти во вкладку «Расширенные» (в Internet Explorer нужная Вам вкладка называется «Дополнительно», в Firefox - «Приватность»).\n4. Выбрать автоматическую обработку куки-файлов (или автоматическое запоминание истории).\n5. Если Вы используете Chrome, то в меню «Показать дополнительные настройки» Вам необходимо выбрать вкладку «Настройки содержания /Настройки контента» и установить флажок напротив «Разрешить сохранять локальные данные (рекомендуется)».\n6. Нажать на «Готово» и закрыть окно.\n\n*Последовательность действий при настройке куки-файлов может немного отличаться в зависимости от используемого браузера​.


    state: HowToAddAScreenshot
        # Как прикрепить скриншот
        q!: * $comWhat (такое/значит) $screenshot *
        q!: $screenshot {это $comWhat}
        q!: * {$how * $doInf * $screenshot} *
        q!: * {$how * приложить * $screenshot} *
        q!: * {$how * вложить * $screenshot} *
        q!: * {$how * передать * $screenshot} *
        q!: * {$how * добавить * $screenshot} *
        q!: * {$how отправить $screenshot} *
        q!: * {$how * $attachInf * $screenshot} *
        q!: * $how (сделаю/$putInf/$sendInf/$appendInf) $screenshot *
        q!: * $how * ($sendInf/$sendMeInfPerf) $screenshot *
        q!: * {~возможность * $doInf * $screenshot} *
        q!: * {~возможность * приложить * $screenshot} *
        q!: * {~возможность * вложить * $screenshot} *
        q!: * {~возможность * передать * $screenshot} *
        q!: * {~возможность * $sendInf * $screenshot} *
        q!: * {~возможность * $sendMeInfPerf * $screenshot} *
        q!: * {~возможность * $appendInf * $screenshot} *
        q!: * $how * {могу * $appendInf * $screenshot} *
        q!: * я могу * {приложить * $screenshot} *
        q!: * я могу * {вложить * $screenshot} *
        q!: * я могу * {передать * $screenshot} *
        q!: * я могу * {$sendInf * $screenshot} *
        q!: * я могу * {$sendMeInfPerf * $screenshot} *
        q!: * я могу * {$appendInf * $screenshot} *
        q!: * {$screenshot * $possiblePredic * $sendInf} *
        q!: * {$cantPastPres $doInf $screenshot} *
        q!: * {$cantPastPres приложить $screenshot} *
        q!: * {$cantPastPres вложить $screenshot} *
        q!: * {$cantPastPres $putInf $screenshot} *
        q!: * {$cantPastPres $sendInf $screenshot} *
        q!: * {$cantPastPres $sendMeInfPerf $screenshot} *
        q!: * {$cantPastPres $appendInf $screenshot} *
        q!: * {$cantPastPres * $attachInf * $screenshot} *
        q!: * $ne (передаетс*/передаетьс*) $screenshot *
        q!: * $screenshot * $ne (передаетс*/передаетьс*) *
        q!: * {$sendPastPresNe $screenshot} *
        q!: * {($ne умею) * $doInf * $screenshot} *
        q!: * {($ne умею) * приложить * $screenshot} *
        q!: * {($ne умею) * прикладывать * $screenshot} *
        q!: * {($ne умею) * вложить * $screenshot} *
        q!: * {($ne умею) * вкладывать * $screenshot} *
        q!: * {($ne умею) * передать * $screenshot} *
        q!: * {($ne умею) * передавать * $screenshot} *
        q!: * {($ne умею) * $putInf * $screenshot} *
        q!: * {($ne умею) * $sendInf * $screenshot} *
        q!: * {($ne умею) * $sendMeInfPerf * $screenshot} *
        q!: * {($ne умею) * $appendInf * $screenshot} *
        eg!: Site.HowToAddAScreenshot
        a: Скриншот - это точное изображение того, что Вы видите на экране монитора в данный момент.\n\nДля того, чтобы сделать скриншот, необходимо:\n\n• открыть в браузере ту страницу, изображение которой необходимо получить;\n• нажать на клавиатуре клавишу PrintScreen (PrtSc) - данная кнопка расположена чаще всего в правом верхнем углу клавиатуры, в одном ряду с функциональными кнопками F1—F​12;\n• открыть Paint либо документ Word;\n• выбрать пункт меню «Вставить» или же нажать сочетание клавиш Ctrl+V, после чего изображение появится в программе или на странице документа;\n• файл сохранить (желательно сохранить в формате doc или jpeg).\n\nПередать файл в данный чат можно через кнопку в виде скрепки (рядом с кнопкой «Отправить»).


    state: HowToPrintATicket
        # Как распечатать билет
        q!: {распечатать * $ticketAndLotteryAll}
        q!: {распечатать * $receipt}
        q!: * {распечатать $uniqueKey} *
        q!: * {$how * распечатать * $ticketAndLotteryAll} *
        q!: * {$how * распечатать * $receipt} *
        q!: * {$comWhere * распечатать * $ticketAndLotteryAll} *
        q!: * {$comWhere * распечатать * $receipt} *
        q!: * {$possiblePredicAll * распечатать * $ticketAndLotteryAll} *
        q!: * {$possiblePredicAll * распечатать * $receipt} *
        q!: * {могу * распечатать * $ticketAndLotteryAll} *
        q!: * {могу * распечатать * $receipt} *
        q!: * {$cantPastPresAll * распечатать * $ticketAndLotteryAll} *
        q!: * {$cantPastPresAll * распечатать * $receipt} *
        q!: * (~функция/~опция/~возможность) распечатк* ($ticketAndLotteryAll/$receipt) *
        q!: * {$ticketAndLotteryAll * (напечатан* ~вид)} *
        q!: * {$receipt * (напечатан* ~вид)} *
        eg!: Site.HowToPrintATicket
        a: Распечатать купленные билеты можно только через основную версию сайта.\n\nДля того чтобы распечатать квитанцию, Вам необходимо зайти в раздел «Мои билеты» в личном кабинете. На вкладке «Все билеты» выберите, пожалуйста, интересующую Вас квитанцию и нажмите на ее номер слева. В открывшейся квитанции кликните на кнопку «Распечатать информацию о билете».


    state: WhatAreAwards
        # Что такое награды?
        q!: ~награда
        q!: * {(дает*/дают*) * ~награда} *
        q!: * $comWhat $oneWord ~награда *
        q!: * {$whatFor [$oneWord] ~награда} *
        q!: * (~какой ~цель) [$oneWord] ~награда *
        q!: ~награда $whatFor он* $comNeed *
        q!: ~награда {это $comWhat}
        q!: * смысл ~награда *
        q!: * {~функция ~награда} *
        q!: * {~информация (о/про/по [поводу]) ~награда} *
        eg!: Site.WhatAreAwards
        a: Награда - это символ, который означает Вашу активность и достижения на нашем сайте. Каждая награда несет свою смысловую нагрузку. Она не подлежит перерасчету в денежном эквиваленте. Получайте награды и наслаждайтесь, делитесь с друзьями.\n\nС подробной информацией Вы можете ознакомиться в Вашем личном кабинете в разделе «Награды».


    state: WhereIsTheAwardSection
        # Где находится раздел Награды?
        q!: [раздел/вкладк*] награды
        q!: * {$comWhere * [наход*] * (~раздел награды)} *
        q!: * {$comWhere * [наход*] * (вкладк* награды)} *
        q!: * {$comWhere * [расположен*] * (~раздел награды)} *
        q!: * {$comWhere * [расположен*] * (вкладк* награды)} *
        q!: * $comWhere на (~сайт/[~сайт] $stoloto) (~раздел/вкладк*) награды *
        q!: {$comWhere наход* награды}
        q!: {$comWhere расположен* награды}
        q!: * {*смотреть * ([~раздел/вкладк*] награды)} *
        q!: * {увидеть * ([~раздел/вкладк*] награды)} *
        q!: * {найти * ([~раздел/вкладк*] награды)} *
        q!: * $comNo (~раздел/вкладк*) награды *
        q!: * {зайти * ((~раздел/вкладк*) награды)} *
        eg!: Site.WhereIsTheAwardSection
        a: Раздел «Награды» находится на основной версии сайта в личном кабинете.


    state: WhereIsTheProfile
        # Где находится профиль?
        q!: [раздел/вкладк*] профиль
        q!: * $comWhere (наход*/найти/расположен*) [раздел/вкладк*/слово] профиль *
        q!: * $comWhere (раздел/вкладк*/слово) профиль *
        q!: * (найти/отыскать) [раздел/вкладк*/слово] профиль *

        q: * {$cantPastPresAll * найти * [~профиль]} * || fromState = /Account/HowToChangeName
        q: * {$cantPastPresAll * отыскать * [~профиль]} * || fromState = /Account/HowToChangeName
        q: * {$cantPastPresAll * увидеть * [~профиль]} * || fromState = /Account/HowToChangeName
        q: * {$findPastPresNe * ~профиль} * || fromState = /Account/HowToChangeName
        q: * {$comWhere это} * || fromState = /Account/HowToChangeName
        q: * {$comWhere * ~профиль} * || fromState = /Account/HowToChangeName

        eg!: Site.WhereIsTheProfile
        a: Раздел «Профиль» Вы можете увидеть в личном кабинете, войдя в него на основной версии сайта https://www.stoloto.ru/. Для этого нажмите, пожалуйста, на Ваше имя в верхнем левом углу страницы.


    state: WhereToSeeLotteryAnnouncements
        # Где посмотреть анонсы тиражей
        q!: * {$seeInf * ~анонс * [$ticketRun]} *
        q!: * {$seeInf * ~анонс * [$lottery]} *
        q!: * {$findOutInf * ~анонс * [$ticketRun]} *
        q!: * {$findOutInf * ~анонс * [$lottery]} *
        q!: * {$findOutInf * (~будущий $ticketRun)} *
        q!: * {$findOutInf * (~будущий $lottery)} *
        q!: * {$findOutInf (о тиражах)} *
        eg!: Site.WhereToSeeLotteryAnnouncements
        a: Анонсы будущих тиражей Вы можете посмотреть на основной версии сайта. По лотереям «Золотая подкова» и «Жилищная лотерея» анонсы будущих тиражей Вы можете увидеть, нажав на интересующую Вас лотерею, выбрав вверху нужную вкладку. По лотерее «Русское лото» анонсы тиражей находятся во вкладке «О лотерее».


    state: HowToCallYou
        # Как позвонить вам
        q!: * $how [я/мне] [$possiblePredic/могу] (позвонить/связат*/дозвонит*) ([к] вам/с вами/свами) *
        q!: * $how [я/мне] [$possiblePredic/могу] ([к] вам/с вами/свами) (позвонить/связат*/дозвонит*) *
        q!: * $how [$possiblePredic/могу] [я/мне] (позвонить/связат*/дозвонит*) ([к] вам/с вами/свами) *
        q!: * $how [$possiblePredic/могу] [я/мне] ([к] вам/с вами/свами) (позвонить/связат*/дозвонит*) *
        q!: * $possiblePredicAll [я/мне] (позвонить/связат*/дозвонит*) ([к] вам/с вами/свами) *
        q!: * $possiblePredicAll [я/мне] ([к] вам/с вами/свами) (позвонить/связат*/дозвонит*) *
        q!: * [я/мне] $possiblePredicAll (позвонить/связат*/дозвонит*) ([к] вам/с вами/свами) *
        q!: * [я/мне] $possiblePredicAll ([к] вам/с вами/свами) (позвонить/связат*/дозвонит*) *
        q!: * могу [я] (позвонить/связат*/дозвонит*) ([к] вам/с вами/свами) *
        q!: * могу [я] ([к] вам/с вами/свами) (позвонить/связат*/дозвонит*) *
        q!: * ($how/могу) * {позвонить * $hotLine} *
        q!: * ($how/могу) * {позвонить * $technicalSupport} *
        q!: * ($how/могу) * {связат* * $hotLine} *
        q!: * ($how/могу) * {связат* * $technicalSupport} *
        q!: * ($how/могу) * {(по $telephone) * проконсультироват*} *
        q!: * ~какой ($phoneAndNum/н т) * (позвонить/связат*) * ($hotLine/$technicalSupport/вам/с вами/свами) *
        q!: * ~какой ($phoneAndNum/н т) * ($hotLine/$technicalSupport/вам/с вами/свами) * (позвонить/связат*) *
        q!: [$possiblePredicAll] [мне] $phoneAndNum ($hotLine/$technicalSupport)
        q!: * ($tellImp/дайте) * $phoneAndNum * ($hotLine/$technicalSupport) *
        q!: * $phoneAndNum * ($hotLine/$technicalSupport) * ($tellImp/дайте) *
        q!: * $sendMeImp * $phoneAndNum * ($hotLine/$technicalSupport) *
        q!: * {$askYouAll * $sendMeInfPerf * $telephoneNumber * $hotLine} *
        q!: * {$askYouAll * $sendMeInfPerf * $telephone * $hotLine} *
        q!: * {$askYouAll * $sendMeInfPerf * $telephoneNumber * $technicalSupport} *
        q!: * {$askYouAll * $sendMeInfPerf * $telephone * $technicalSupport} *
        q!: * {$askYouAll * $duplicateInfPerf * $telephoneNumber * $hotLine} *
        q!: * {$askYouAll * $duplicateInfPerf * $telephone * $hotLine} *
        q!: * {$askYouAll * $duplicateInfPerf * $telephoneNumber * $technicalSupport} *
        q!: * {$askYouAll * $duplicateInfPerf * $telephone * $technicalSupport} *
        q!: * $existPresSg3 $phoneAndNum ($hotLine/$technicalSupport) *
        q!: * {$existPresSg3 $hotLine} *
        q!: * {позвонить * $talkInf * $operator} *
        q!: * $phoneAndNum * {$talkInf * $operator} *
        eg!: Site.HowToCallYou
        a: Круглосуточная горячая линия для участников: 8 900 555-00-55.


    state: IsTheCallFree
        # Звонок бесплатный?
        q!: * {~звонок * *платн*} *
        q!: * {стоит* * ~звонок} *
        q!: * {~стоимость * ~звонок} *
        q: * это * *платн* * || fromState = /Site/HowToCallYou
        q: * это * стоит* * || fromState = /Site/HowToCallYou
        q: * это * *платн* * || fromState = /Payments/WithdrawDoesntWork
        q: * это * стоит* * || fromState = /Payments/WithdrawDoesntWork
        q: * это * *платн* * || fromState = /Payments/WithdrawDoesntWorkRusLoto
        q: * это * стоит* * || fromState = /Payments/WithdrawDoesntWorkRusLoto
        q: * это * *платн* * || fromState = /Payments/DepositDoesntWork
        q: * это * стоит* * || fromState = /Payments/DepositDoesntWork
        q: * это * *платн* * || fromState = /Payments/ICantGetPurseIdentification
        q: * это * стоит* * || fromState = /Payments/ICantGetPurseIdentification
        eg!: Site.IsTheCallFree
        a: Стоимость звонка согласно Вашему тарифному плану. По данному вопросу можете обратиться к Вашему оператору связи.


    state: ProblemWithBroadcastingOnTheSite
        # Проблема с трансляцией на сайте
        q!: * ~проблема $with ~трансляция *
        q!: * $comWhat $with ~трансляция *
        q!: * {$why * $inactive * ~трансляция} *
        q!: [$helloAll] {$inactive ~трансляция}
        q!: * $why [до сих пор] $comNo ~трансляция *
        q!: * $why $displayPresPl3Ne ~трансляция *
        q!: * $why $displayPresSg3Ne ~трансляция *
        q!: * прекратил* ~трансляция *
        q!: * ($ne (идет/идут)/неидет/неидут/ниидет/ниидут) ~трансляция *
        q!: * {зависл* ~трансляция} *
        q!: * {встал* ~трансляция} *
        q!: * {сдохл* ~трансляция} *
        q!: * {(исчезл*/пропал*) ~трансляция} *
        q!: * {~трансляция ($ne доступн*/недоступн*/нидоступн*)} *
        q!: * {$why * $seeInf * $cantPastPresAll * ~трансляция} *
        q!: * {$why * $nelzya * $seeInf * ~трансляция} *
        q!: * $when ($beFutSgPl3/станет/станут) доступн* ~трансляция *
        q!: * $when ~трансляция ($beFutSgPl3/станет/станут) доступн* *
        q!: $beginningWords $comWhere ~трансляция
        q!: * $why ($ne (транслирует*/транслируют*)/нетранслирует*/нетранслируют*/нитранслирует*/нитранслируют*) *
        eg!: Site.ProblemWithBroadcastingOnTheSite
        if: $global.broadcastIsAvailable
            script: Webim.switch();
        else:
            a: По техническим причинам трансляция временно приостановлена. Мы работаем над восстановлением этого сервиса. С результатами розыгрыша Вы можете ознакомиться на сайте или в мобильном приложении, куда они загружаются после проведения тиража из таблиц, подтвержденных протоколами тиражной комиссии. 


    state: ProblemWithPostingADrawOnTheSite
        # Задержка в публикации записи розыгрыша на сайте
        q!: * {$delay * публикац* * (~запись розыгрыш*) * $RL} *
        q!: * {$delay * публикац* * (~запись розыгрыш*) * $billion} *
        q!: * {$delay * публикац* * ролик* * $RL} *
        q!: * {$delay * публикац* * ролик* * $billion} *
        q!: * $comNo [публикац*] (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайте *
        q!: * $comWhat $with [публикац*] (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайте *
        q!: * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* *
        q!: * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* * ($ne опубликован*/неопубликован*/ниопубликован*/$ne опубликовал*/неопубликовал*/ниопубликовал*/$ne выложен*/невыложен*/нивыложен*/$ne выложил*/невыложил*/нивыложил*/$ne выкладываете/невыкладываете/нивыкладываете) *
        q!: * $when [вы] (выложите/загрузите/выгрузите/опубликуете) * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* *
        q!: * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* * $when [вы] (выложите/загрузите/выгрузите/опубликуете) *
        q!: * $when $beFutSgPl3 (выложен*/загружен*/выгружен*/опубликован*) * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* *
        q!: * (~запись розыгрыш*/ролик*) [по] ($RL/[нов*] $billion) на сайт* * $when $beFutSgPl3 (выложен*/загружен*/выгружен*/опубликован*) *
        eg!: Site.ProblemWithPostingADrawOnTheSite
        if: $global.sitePostIsAvailable
            script: Webim.switch();
        else:
            a: В этом году в новогоднем розыгрыше «Русского лото» принимает участие рекордное количество билетов. Многократно возросла нагрузка на все информационные системы, поэтому сегодня запись розыгрыша выходит с задержкой. Наши специалисты уже работают над устранением этой проблемы. Ролик будет загружен в ближайшее время.


    state: YouTubePostingDelay
        # Задержка публикации видеороликов на YouTube
        q!: * {задержк* * $youTube} *
        q!: * {(задерживает*/задерживают*) * $youTube} *
        q!: * $comNo [публикац*/видео*/$nothing/$tvShow] на $youTube *
        q!: * $comWhat $with публикац* * $youTube *
        q!: * $comWhat $with $youTube *
        q!: * $comWhat $with видео* * $youTube *
        q!: * $comWhat $with * $youTube *
        q!: * {$inactive * $youTube} *
        q!: * {($ne опубликован*/неопубликован*/ниопубликован*) * $youTube} *
        q!: * {($ne опубликовал*/неопубликовал*/ниопубликовал*) * $youTube} *
        q!: * {($ne выложен*/невыложен*/нивыложен*) * $youTube} *
        q!: * {($ne выложил*/невыложил*/нивыложил*) * $youTube} *
        q!: * {($ne выкладываете/невыкладываете/нивыкладываете) * $youTube} *
        q!: * {задержк* * $tvShow} *
        q!: * {(задерживает*/задерживают*) * $tvShow} *
        q!: * $comWhat $with $tvShow *
        q!: * {$inactive * $tvShow} *
        q!: * {($ne опубликован*/неопубликован*/ниопубликован*) * $tvShow} *
        q!: * {($ne опубликовал*/неопубликовал*/ниопубликовал*) * $tvShow} *
        q!: * {($ne выложен*/невыложен*/нивыложен*) * $tvShow} *
        q!: * {($ne выложил*/невыложил*/нивыложил*) * $tvShow} *
        q!: * {($ne выкладываете/невыкладываете/нивыкладываете) * $tvShow} *
        q!: * $when [вы] (выложите/загрузите/выгрузите/опубликуете) * $tvShow *
        q!: * $when [вы] (выложите/загрузите/выгрузите/опубликуете) * (видео*/ролик*) * $youTube *
        q!: * $when $beFutSgPl3 (выложен*/загружен*/выгружен*/опубликован*) * $tvShow *
        q!: * $when $beFutSgPl3 (выложен*/загружен*/выгружен*/опубликован*) * (видео*/ролик*) * $youTube *
        q!: * $when * появит* * $tvShow *
        eg!: Site.YouTubePostingDelay
        if: $global.youTubePostIsAvailable
            script: Webim.switch();
        else:
            a: Сегодня запись эфира программы «У нас выигрывают!» на youtube-канале выходит с задержкой по техническим причинам. Наши специалисты уже работают над устранением этой проблемы. Ролик будет загружен после (указать время).


    state: PageNewYearBillionDoesntLoad
        # Не грузится страница НГ миллиард
        q!: * {страниц* * ((нг/новогодн*) $billion) * $inactive} *
        q!: * {страниц* * ((нг/новогодн*) $billion) * (~белый ~экран)} *
        q!: [$helloAll] {$why ((нг/новогодн*) $billion) $inactive}
        q!: * вместо ((нг/новогодн*) $billion) (~белый ~экран) *
        eg!: Site.PageNewYearBillionDoesntLoad
        if: $global.pageNewYearBillionIsAvailable
            script: Webim.switch();
        else:
            a: Спасибо, что информируете нас. Технические специалисты «Столото» уже работают над восстановлением работы сервиса. Надеемся, что в самое ближайшее время Вы сможете им воспользоваться.




























