require: themes/account.sc
require: themes/bonuses.sc
require: themes/lottery.sc
require: themes/payments.sc
require: themes/phoneAndSMS.sc
require: themes/services.sc
require: themes/site.sc
require: themes/ticket.sc
require: stolotoPatterns.sc
#require: catchAll.sc

require: dictionaries/rusCities.csv
    name = rusCities
    var = rusCities

require: dictionaries/rusRegions.csv
    name = rusRegions
    var = rusRegions

require: dictionaries/moscowMetroStations.csv
    name = moscowMetroStations
    var = moscowMetroStations

require: dictionaries/countriesWithoutRussia.csv
    name = countriesWithoutRussia
    var = countriesWithoutRussia

require: utilsTest.sc

require: scripts/utils.js
require: patterns.sc
  module = common
require: namesRu/names-ru.csv
  module = common
  name = namesRu
  var = namesRu


# require: dateTime/moment.min.js
#   module = common


init:

    bind("preProcess", function($context) {
        // if ($context.request && $context.request.query && $context.request.query.indexOf("/test") > -1) {
        //     $context.temp.targetState = "/utilsTest/Test";
        // }

        if ($context.session.askForOperator){
            $context.temp.targetState = "/AskedForSwitch";
            $context.session.askForOperator = false;
        }

    });

    bind("postProcess", function($context) {
        if ($jsapi.context().session.lastState === '/ConversationStart' ||
            (!$jsapi.context().session.clientGreeted && !$jsapi.context().temp.pushGreeting)){
            var HelloMsg = {
                  "type": "text",
                  "text": "Здравствуйте!",
                  "state": "ConversationStart"
                }

            if (!testMode() || $jsapi.context().session.location == "test_location"){
                $jsapi.context().response.replies.unshift(HelloMsg);
            }
            $jsapi.context().session.clientGreeted = true;
        }

        //
        if ($jsapi.context().session.lastLottery && !$jsapi.context().temp.thisRequestLottery){
            $jsapi.context().session.lastLottery = false;
        }

        $jsapi.context().session.lastState = $jsapi.context().currentState;
        checkSameState($context);
    });

    $global.checkTicketIsAvailable = $injector.checkTicketIsAvailable;
    $global.confirmentSmsIsAvailable = $injector.confirmentSmsIsAvailable;
    $global.byuingTicketIsAvailable = $injector.byuingTicketIsAvailable;
    $global.ticketInAccountIsAvailable = $injector.ticketInAccountIsAvailable;
    $global.balanceIsAvailable = $injector.balanceIsAvailable;
    $global.balanceIsCorrect = $injector.balanceIsCorrect;
    $global.walletPaymentIsAvailable = $injector.walletPaymentIsAvailable;
    $global.letterDeliveryIsAvailable = $injector.letterDeliveryIsAvailable;
    $global.broadcastIsAvailable = $injector.broadcastIsAvailable;
    $global.youTubePostIsAvailable = $injector.youTubePostIsAvailable;
    $global.bonusBalanceIsCorrect = $injector.bonusBalanceIsCorrect;
    $global.mobileBonusBalanceIsCorrect = $injector.mobileBonusBalanceIsCorrect;
    $global.smsMailingIsCorrect = $injector.smsMailingIsCorrect;
    $global.drawTakesPlaceOnTime = $injector.drawTakesPlaceOnTime;
    $global.autopaymentRLIsWorking = $injector.autopaymentRLIsWorking;
    $global.applicationIsAvailable = $injector.applicationIsAvailable;
    $global.sitePostIsAvailable = $injector.sitePostIsAvailable;
    $global.pageNewYearBillionIsAvailable = $injector.pageNewYearBillionIsAvailable;
    $global.winningCodeIsAvailable = $injector.winningCodeIsAvailable;
    $global.withdrawalToPurseIsAvailable = $injector.withdrawalToPurseIsAvailable;
    $global.withdrawalRLToPurseIsAvailable = $injector.withdrawalRLToPurseIsAvailable;
    $global.withdrawalFromPurseRLIsAvailable = $injector.withdrawalFromPurseRLIsAvailable;
    $global.receiptDeliveryIsAvailable = $injector.receiptDeliveryIsAvailable;
    $global.registrationLetterDeliveryIsAvailable = $injector.registrationLetterDeliveryIsAvailable;
    $global.resultsAreDisplayedCorrectly = $injector.resultsAreDisplayedCorrectly;
    $global.cardPaymentIsAvailable = $injector.cardPaymentIsAvailable;
    $global.paymentFromWalletIsAvailable = $injector.paymentFromWalletIsAvailable;
    $global.rusLotoResultsInMyTicketsAreAvailable = $injector.rusLotoResultsInMyTicketsAreAvailable;
    $global.byuingBingoLotteriesIsAvailable = $injector.byuingBingoLotteriesIsAvailable;
    $global.paymentsRLIsAvailable = $injector.paymentsRLIsAvailable
    $global.ticketRegistrationIsAvailable = $injector.ticketRegistrationIsAvailable


theme: /
    state: Start
        q: *start
        a: Здравствуйте. Если вопрос технический ― пожалуйста, будьте готовы сообщить номер телефона и электронный адрес, указанные при регистрации на stoloto.ru.
        script:
            $temp.pushGreeting = true;


    state: AskedForSwitch
        script:
            var res = $nlp.match($request.query, "/AskedForSwitch");
            $reactions.transition(res.targetState);

        state: Yes
            q: * $agree *
            script: Webim.switch();

        state: No
            q: * $disagree *
            a: Как я могу Вам помочь?

        state: LocalCatchAll
            q: *
            a: Пока моей компетенции недостаточно для того, чтобы удовлетворить Ваш запрос. Соединить с оператором?


    state: ConversationStart || noContext = true
        event: newChatStarted
        script:
            $session.startNewSession = true;
            if ($session.startNewSession){
                createNewSession($request)
            }
            $session.location = $request.rawRequest.location;
            $session.clientGreeted = false;
            $temp.pushGreeting = true;

# Ивент пробрасывается через newSession: utils.js > createNewSession
    state: GetRequestData
        event: getRequestData
        script:
            $session.location = $request.rawRequest.location;
            $session.clientGreeted = false;
            $temp.pushGreeting = true;


    state: CatchAll || noContext = true
        event!: noMatch
        script: Webim.switch();

    state: Hello || noContext = true
        q!: $helloAll [уважаем*]
        q!: {$repeat<$helloAll> [$repeat<$emoji>]}
        q!: $helloAll [и] $with [наступ*] (нг/нов* [вас] год*/праздник*/праздничк*/рождеств*/крещ*/маслен*/днем защитника отечества/23 февр*) [$repeat<$emoji>]
        q!: {$helloAll [$youDat] [$stoloto/$alica/$operator]} [$repeat<$emoji>]
        q!: [$helloAll] [$alica/ау/$operator] {$youNom ([$ne] ($here/$onlineLoc/на сайте)/$comWhere)} [$repeat<$emoji>]
        q!: [$helloAll] [$alica/ау] $youNom $online [$repeat<$emoji>]
        q!: [вы] $ne спите [$repeat<$emoji>]
        q!: * [вы] {$canYou говорить} *
        q!: * есть (кто/$somebody) живой *
        q!: * {есть [$here] (кто/$somebody)} *
        q!: кто ($here/$onlineLoc) [$repeat<$emoji>]
        q!: {$alica [$repeat<$emoji>]}
        q!: {[$allo] $kyky [$repeat<$emoji>]}
        q!: {($allo/ау) [гараж/$alica/$operator]} [$repeat<$emoji>]
        q!: (тук тук/стук стук/туктук) [$repeat<$emoji>]
        eg!: Hello
        intent!: /Hello
        
        a: Чем я могу Вам помочь?


    state: WhatsWrong? || noContext = true
        q!: $stoloto
        q!: $ticket
        q!: $generalNamedLottery
        q!: * {все плохо} *
        q!: $regexp<\d{1,10}>
        q!: [$helloAll] [да/$comGood] [я] конечно
        q!: [$helloAll] [да/$comGood] [я] (готов/готова) [сообщить] [вам] [$comMy] [$telephoneNumber/$telephone/$mail/[рег*] данные/данную инф*] [при необходимости/если $comNeed]
        q!: (да/$comGood) $helloAll
        eg!: WhatsWrong?
        if: $parseTree._generalNamedLottery
            script:
                $session.lastLottery = $parseTree._generalNamedLottery;
                $temp.thisRequestLottery = true;
        random:
            a: Уточните, пожалуйста, какой у Вас вопрос?
            a: Уточните, пожалуйста, что бы Вы хотели узнать?


    state: UserEmailWithoutContext || noContext = true
        q!: [$helloAll] {[$comMy] [$mail]} [указ* при] [$registration] $localEmail {[$comMy] [$mail]} [указ* при] [$registration]
        a: Уточните, пожалуйста, в чем заключается Ваш вопрос?


    state: UserMobilePhoneNumberWithoutContext || noContext = true
        q!: [$helloAll] [$comMy] [$telephoneNumber/$telephone/т/мобильный] [указ* при] [$registration] [$comMy] $localMobilePhoneNumber [$comMy] [$telephoneNumber/$telephone/т/мобильный] [указ* при] [$registration]
        a: Уточните, пожалуйста, в чем заключается Ваш вопрос?


    state: UserDataWithoutContext || noContext = true
        q!: [$helloAll] [$comGood] [вот] [$comMy] [рег*] [данные] [по $registration] {[$comMy] [$mail] $localEmail [и/а] [$comMy] [$telephoneNumber/$telephone/т/мобильный] $localMobilePhoneNumber} [вот] [$comMy] [рег*] [данные] [по $registration]
        q!: [$helloAll] я $registerPastRefl3 по [$telephoneNumber/$telephone/т/мобильный] $localMobilePhoneNumber [и] [$mail] $localEmail
        q!: [$helloAll] [я] уже ($indicatePast/сообщал*) {[$comMy] [$mail] $localEmail [и] [$comMy] [$telephoneNumber/$telephone/т/мобильный] $localMobilePhoneNumber}
        q!: [$helloAll] [$comMy] [данные] (указ* при $registration) ($telephoneNumber/$telephone/т/мобильный) $localMobilePhoneNumber [и/а] $mail $localEmail
        q!: [$helloAll] ($telephoneNumber/$telephone/т/мобильный) и $mail (указ* при $registration) на (stoloto ru/$stoloto) {$localMobilePhoneNumber $localEmail}
        a: Уточните, пожалуйста, в чем заключается Ваш вопрос?


    state: Bye || noContext = true
        q!: {[$aha] [$goodAll] [$comThanks] $comBye [$repeat<$emoji>]}
        q!: $comThanks и $comBye [$repeat<$emoji>]
        eg!: Bye
        a: Была рада Вам помочь.


    state: Thanks || noContext = true
        q!: $comThanks [$comThanks] [$helloAll] [$repeat<$emoji>]
        q!: [$goodAll] {$sadAll $comThanks} [$repeat<$emoji>]
        q!: [$beginningWords] {$comThanks [$repeat<$emoji>]}
        q!: [$beginningWords] {$comThanks $goodLuck} [$repeat<$emoji>]
        q!: $goodAll
        q!: [$beginningWords] {$goodAll [$repeat<$emoji>]}
        q!: {($goodAll [$goodAll]) [$repeat<$emoji>]}
        q!: {[$aha] $goodAll [$repeat<$emoji>]}
        q!: [$aha] $goodAll $repeat<$emoji> $comThanks $repeat<$emoji>
        q!: {[$aha] [$goodAll] $comThanks} [$sorry] [$repeat<$emoji>]
        q!: [$beginningWords] {[$goodAll] $comThanks} [$repeat<$emoji>]
        q!: {$goodAll $goodAll $comThanks} [$repeat<$emoji>]
        q!: [$helloAll] {[$stoloto/$alica] $comThanks [$goodAll] [$haveAGoodDay]} [$repeat<$emoji>]
        q!: {[$youNom/$stoloto] $super ($comThanks/$goodAll) [$goodAll]} [$repeat<$emoji>]
        q!: [$aha/$helloAll] {[$comNow/уже/$atLast] все $comGood [$comThanks]} *

        q!: [$aha] [вот] {[$comNow/уже/$atLast] [все] ($clear/быстро) [$comThanks]} [$repeat<$emoji>]
        q!: [все] [$comNow/уже/$atLast] (нашел*/нашла/нашол*/$seeIntoPast/выяснил*/справил*/поступил*)
        q!: все пришл*
        q!: [$beginningWords] [$aha] $comThanks [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/понял*/справил*/$transferPast/наладил*/разрешил*/появил*/получил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/[$application] заработал*/сработал*/вывел*/$bonusComePastPres/скачал*/оплатил*/обновилис*/кажетс* есть/перешли/успешно) *
        q!: [$beginningWords] [$helloAll] [$sorry] [$aha] [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/[это] понял*/справил*/$transferPast/наладил*/разрешил*/появил*/получил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/[$application] заработал*/сработал*/$bonusComePastPres [$with] [опоздан*/задерж*]/скачал*/оплатил*/(нашел/нашл*) [и сделал*]/пополнил*/вижу/перешли) $comThanks [$sorry] [$holidays] [$comBye]
        q!: [$beginningWords] [$helloAll] [$aha] [$iSgPl] [$comNow/уже/$atLast] [все] [$comNow/уже/$atLast] [удачно/успешно] (отправил*/увидел*/решил*/сделал*/[это] понял*/справил*/$transferPast/наладил*/разрешил*/появил*/получил*/зашел/зашл*/вошел/вошл*/$registerPast3/$seeIntoPast/выяснил*/заработал*/$bonusComePastPres/скачал*/оплатил*/пополнил*) $sorry
        q!: [$aha] {[$goodAll] [$comNow/уже/$atLast] [я] [вас] понял* [$comThanks]} [$repeat<$emoji>]
        q!: [$sorry] [$aha] {[$goodAll] [$comNow/уже/$atLast] [$iSgPl] [$with/$v] [всем/[возникш*] $problem] $seeIntoPast [$comThanks]} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] [$comThanks] [я] $considerFutSgPl1} *

        q!: [$aha] {[$goodAll] [$comThanks] [$youNom] [мне] [очень] помогл*} [$repeat<$emoji>]
        q!: {принято $comThanks}
        q!: [$helloAll] $comThanks [$youDat] [за то] что [$youNom] (помогли/решили [$comMy] [~вопрос/~проблема]) *
        q!: $comThanks [я] так и (думала/есть)
        q!: $comThanks $with уважением *
        q!: [я] так и (*думала/есть) $comThanks
        q!: $comThanks а то я *
        q!: $comThanks [я] ($ne знал*/незнал*/низнал*) *
        q!: {$comThanks ($problem исчерпан*)}
        q!: $comThanks все [очень/предельно] (подробно/$clear/доступно)
        q!: [$aha] {[$goodAll] [$comThanks] [я] (так и сделаю)} [$repeat<$emoji>]

        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast/тогда/пока что/пока] (все [в] порядке)} *
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] [у меня] [все] (получилос*/удалос*)} *
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] [у меня] [все] (работает/заработало)} [$repeat<$emoji>]

        q!: * $comThanks * (~вопрос/~проблема) [$comNow/уже/$atLast] (решил*/решен/решена) *
        q!: * (~вопрос/~проблема) [$comNow/уже/$atLast] (решил*/решен/решена) * $comThanks *

        q!: [$aha] {[$goodAll] $comThanks [все] [$comNow/уже/$atLast] (исправил*)} [$repeat<$emoji>]

        q!: [$aha] {[$goodAll] $comThanks установил* [$application]} [$repeat<$emoji>]

        q!: [$aha] {[$goodAll] $comThanks [я] [$comNow/уже/$atLast] проверил*} [$repeat<$emoji>]
        q!: {[$aha] [$goodAll] $comThanks [я] [$comNow/уже/$atLast] (нашл*/нашел*) [все]} [$repeat<$emoji>]

        q!: {[$aha] [$goodAll] $comThanks [$comNow/уже/$atLast] отобразил* [все/[$comMy] $ticket]} *
        q!: [$helloAll] [все] {$comThanks $ticket [уже] появил*} *
        q!: [$helloAll] [все] {$comThanks $ticket приш*} *
        q!: [$helloAll] [все] {$comThanks $ticket ($findPastPres/на месте)} *
        q!: [$helloAll] [$aha] {[$goodAll] $comThanks [я] (нашл*/нашел*) ([$comMy] $ticket)} *
        q!: [$helloAll] [все] {$comThanks ($password/$prizeLocal) приш*} *
        q!: [$helloAll] [все] {$comThanks $password получил*} *
        q!: [$aha] {[$goodAll] $comThanks [я] [$comNow/уже/$atLast] [все/$password] $resetPast} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [я] [$comNow/уже/$atLast] $password $changePast} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $sms $smsComePast} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $prizeLocal $smsComePast} *
        q!: [$helloAll] [все] {$comThanks $prizeLocal $transferPast} *
        q!: [$helloAll] [все] {$comThanks $prizeLocal $transferPartPas} *
        q!: [$helloAll] [все] {$comThanks $prizeLocal $moneyAddPartPas} *
        q!: * {$prizeLocal $bonusComePastPres} $comThanks [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks *числен* произошл*}
        q!: [$helloAll] [все] {$comThanks $bonus $smsComePast} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $specialBonus $smsComePast} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $bonus $bonusComePastPres} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $specialBonus $bonusComePastPres} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks $payment [за] [$ticket/$lottery] прош*} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $payment производит*} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] ($comMoney/все/[$comMy] $ticket) $returnPast} [$repeat<$emoji>]
        q!: [$helloAll] [все] {$comThanks $comMoney $returnPast} *
        q!: [$helloAll] [все] {$comThanks $comMoney $moneyAddPartPas} *
        q!: [$helloAll] [все] {$comThanks $comMoney пришли} *
        q!: [$helloAll] [все] {$comThanks $receipt приш*} *
        q!: [$helloAll] [все] {$comThanks $wallet пополнилс*} *
        q!: [$helloAll] [все] {$comThanks $balance пополнилс*} *
        q!: [$helloAll] [все] {$comThanks ~счет пополнилс*} *

        q!: [$aha] {[$goodAll] $comThanks [я] [$comNow] $registerFutReflSg1} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [я] $enterPastSg3 [на сайт]} [$repeat<$emoji>]

        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] [$comMoney/все/$code] $smsComePast} *
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] $comMoney нашл*} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] ($comMoney/все/[$comMy] $ticket) $returnPast} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [$comNow/уже/$atLast] ($comMoney/все) перевел*} [$repeat<$emoji>]
        q!: * обновил* пришл*
        q!: {$comThanks [$comThanks] [$goodAll]} [и] [вас] $holidays *
        q!: {$comThanks [$comThanks] [$goodAll]} [и] ($with наступ*/удачи/счастья и здоровья) *
        q!: {$comThanks [$comThanks] [$goodAll]} (так и (сделаю/сделаем)/обязательно $beFutSgPl1/сразу бы так) *
        q!: [$comThanks] {(нашл*/нашел*) [[на/в] $receipt] ($ticketRunNumber/$ticketRun)} [$comThanks]
        eg!: Thanks
        a: Была рада Вам помочь.


    state: TrashQuestions
        q!: * {$how * (погод*/дела/делишк*)} *
        q!: * {$comWhat * погод*} *
        q!: * ~погода в *
        eg!: TrashQuestions
        script: Webim.switch();
        # a: Простите, я должна придерживаться исключительно рабочих тем. Чем я могу Вам помочь?


    state: YouDidntAnswer
        q!: {$youNom [мне] $answerPastNe}
        q!: {$youNom [мне] $helpPastPresNe}
        q!: {(~ответ [на [$comMy] ~вопрос]) [я] $getPrizPastPresNe}
        eg!: YouDidntAnswer
        script: Webim.switch();


    state: IHaveAQuestion
        q!: [$helloAll] [$operator] [я/мне] [$oneWord] [бы] [$oneWord] ($findOutInf/спросит/спросить/знать) [у] [$youAcc]
        q!: [$helloAll] [$operator] [$comYes] (есть/у меня/$possiblePredicAll) [к] [$oneWord] [$youDat] [$Number] вопрос* [о/по/про/по поводу] [$ticketAll/$lottery/выплат*] [$generalNamedLottery]
        q!: [$helloAll] [$operator] [$comYes] (есть/у меня) [$oneWord] проблем*
        q!: {[$helloAll] (могу/$possiblePredicAll/$want) [я] [$youDat] вопрос задать}
        q!: [$helloAll] [$operator] {[мне] $comNeed [ваш*] (~информация/~подсказка/~помощь/~совет/~консультация)} [о/по/про/по поводу] [$ticketAll/$lottery/выплат*] [$generalNamedLottery]
        q!: {[$helloAll] [$please] *скажи* [мне]}
        q!: {[$helloAll] [$please] (може*/[$ne] могли бы) [$youNom] [мне] (помочь/(ответить/дать ответ) [на вопрос])} [о/по/про/по поводу] [$ticketAll/$lottery/выплат*] [$generalNamedLottery]
        q!: {[$helloAll] [$please] помоги* [мне] [понять/разобрат*]} [о/по/про/по поводу] [$ticketAll/$lottery] [$generalNamedLottery]
        q!: [$helloAll] [$comYes/$comGood/$comNo] [~вопрос] [скоре* всего] [$ne] (техническ*/технис*)
        q!: [$helloAll] [$sorry] ~вопрос есть
        q!: [$helloAll] [я к вам] [по/$with/по поводу] {~такой (~вопрос/~проблема)}
        q!: [$helloAll] {таков* (~вопрос/~проблема)}
        q!: [$helloAll] проблема $with $ticketAll
        eg!: IHaveAQuestion
        random:
            a: Что бы Вы хотели узнать?
            a: Какой у Вас вопрос?


    state: IDontHaveQuestions
        # Вопросов нет
        q!: [$comThanks] у (матрос*/меня) {~вопрос $comNo} [$repeat<$emoji>]
        q!: {[$comThanks] [все $goodAll] [никак*] ~вопрос $comNo} [$repeat<$emoji>]
        q!: {[$comThanks] [$goodAll все] [никак*] ~вопрос $comNo} [$repeat<$emoji>]
        q!: {[$comThanks] [все $goodAll] ~вопрос (снят/снимаю/снимает*)} [$repeat<$emoji>]
        q!: {[$comThanks] [$goodAll все] ~вопрос (снят/снимаю/снимает*)} [$repeat<$emoji>]
        q!: * {[$comThanks] ~вопрос (больше/пока [что]/покуда/уже) $comNo} *
        q!: * {[$comThanks] ~проблема (больше/пока [что]/покуда) $comNo} *
        q!: {[$comNo] [$comThanks] [пока/уже] [что] (ничего/$ne чего) ($ne $comNeed)} [$repeat<$emoji>]
        q!: [я] никак* ~вопрос [$ne (задавал*/спрашивал*)] [$repeat<$emoji>]
        q!: я (ничего/нечего/$ne чего) $ne спрашивал* [$repeat<$emoji>]
        q!: {([пока/уже/больше] (ничего/нечего/$ne чего/ничем/$ne чем)) [$sorry] [$comThanks] [$repeat<$emoji>]}
        q!: {([пока/уже/больше] (ничего/нечего/$ne чего/ничем/$ne чем)) $comThanks} *
        q!: $comThanks (ничего/$ne чего/это все) $comBye [$repeat<$emoji>]
        q!: $comThanks это все [$repeat<$emoji>]
        q!: {[$aha] [$goodAll] (если что) [я] обращусь} [$repeat<$emoji>]
        q!: (никакой/никакого) [$repeat<$emoji>]
        q!: {[$aha] [$goodAll] [значит] $waitPresFut [$comThanks]} [$repeat<$emoji>]
        q!: {[$comNow] [$goodAll] [я] (ознакомлюсь/почитаю/прочитаю/*изучаю/изучу) [по $link/[$with] инструкц*] [$comThanks]} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] [я] (проверю/$seeFutSg1/поищу) (в архиве)} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] [я] (проверю/$seeFutSg1/поищу) ([в] $spamFolder)} [$repeat<$emoji>]
        q!: [$aha] $goodAll [$comNow] (проверю/$seeFutSg1/поищу) *
        q!: [$aha] {[$goodAll] $comThanks} ($beFutSgPl1 (проверять/надея*)/$waitPresFut) *
        q!: [$aha] {[$goodAll] $comThanks [я] (проверю/$seeFutSg1) [$after]} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [я] (проверю/$seeFutSg1/поищу) (в архиве)} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks [я] (проверю/$seeFutSg1/поищу) ([в] $spamFolder)} [$repeat<$emoji>]
        q!: [$aha] {[$goodAll] $comThanks} [$comNow] (проверю/$seeFutSg1/поищу) *
        q!: [$aha] [понял*] {[$goodAll] [$comThanks] [я] [$comNow] $tryFutSgPl1} *
        q!: * {$comThanks * $tryFutSgPl1} *
        q!: {[$helloAll] $comThanks ([пока] $comNo)}
        q!: $comThanks [мне/вы] уже (помогли/ответили)
        q!: [$goodAll] $comThanks (жду/ожидаю) ($letter/~игра/$sms)
        q!: [$goodAll] (жду/ожидаю) [$with нетерп*] ($letter/~игра/$sms) [$comThanks]
        q!: [$goodAll] $comThanks надеюс* [что] все $beFutSgPl3 $comGood [$repeat<$emoji>]
        q!: [мне/вы] уже (помогли/ответили) $comThanks
        q!: пока все $clear [и нормальн*]
        q!: $helloAll [я/мы] $seeIntoPast [$repeat<$emoji>]
        q!: $helloAll {[все/$password] $resetPast} [$repeat<$emoji>]
        q!: все ($comGood/на месте) $sorry
        q!: $sorry все ($comGood/на месте/нашел*/нашл*/$bonusComePastPres) *
        q!: {$sorry $comMoney $smsComePast}
        eg!: IDontHaveQuestions
        a: Если у Вас возникнут вопросы, пожалуйста, напишите нам.


    state: Obscene || noContext = true
        q!: $stupid
        q!: $obsceneWord [$strictYou]
        script: Webim.switch();


    state: ToOperator
        q!: [на] $operator
        q!: * $real (~человек/$operator) *
        q!: * $possiblePredicAll мне (~человек/$operator) *
        q!: * {($askYou/$possiblePredicAll) [мне] позвать (~человек/$operator)} *
        q!: * {(~живой/люди) * есть} *
        q!: * $with [$real] человеком *
        q!: * $talkInf * (людьми/$operator) *
        q!: * $switchImp * $operator *
        q!: * связь $with $operator *
        q!: * $robot *
        q!: * (издеваетесь/*издеваться) *
        q!: * унижаться *
        q!: * {позови* (человека/$operator)} *
        script: Webim.switch();


    state: TvShowQuestions
        q!: * $tvShow *
        q!: * {$attend * (~трансляция/~шоу/сьемк*/съемк*)}
        script: Webim.switch();


    state: WishMeGoodLuck
        # Пожелайте мне удачи
        q!: * {пожелай* [мне/нам] $luck} *
        q!: * {пожелай* [мне/нам] $win} *
        q!: * пожелай* [мне/нам] всего самого *лучшего *
        q!: я $youAcc люблю
        q!: [$goodAll] $comThanks за (игру/то что вы есть *)
        q!: [$helloAll] когда [уже] я $winFutSg13 [$comMy] ($million/$billion)
        q!: [поздравляю] [$youAcc] $holidays [$repeat<$emoji>]
        a: Желаем Вам удачи и будущих побед.


    state: TimeLimit
        event: timeLimit
        script: Webim.switch();


    state: LengthLimit
        event: lengthLimit
        script: Webim.switch();


    state: FileReceived
        event!: fileEvent
        script: Webim.switch();


    state: Timedout || noContext = true
        a: Скажите, пожалуйста, помог ли мой ответ?

        state: Yes || noContext = true
            q: * $agree *
            a: Была рада помочь.

        state: No || noContext = true
            q: * $disagree *
            script: Webim.switch();


    state: GoTo || noContext = true
        q!: justai goto $Text
        a: Выполняется переход в состояние /{{$parseTree.Text[0].value}}.
        go!: /{{$parseTree.Text[0].value}}


    state: LidsOperators
        eg!: LidsOperators
        script: Webim.switch();


    #state: CatchUrl
        #q!: *service (Organization URL in search/User region) *
        #a:
        #script:
            #$temp.pushGreeting = true;





















