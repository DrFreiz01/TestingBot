

var Time = {
	isSpecialEvent: function(uptime_hh, uptime_mm){
		// Функция нужна для того, чтобы можно было поменять ответы для проверки лотерей в определенные праздники.
		// @uptime_hh, @uptime_mm: int: проверяемое время.
		// Функция возвращает true, если текущее время в определенный на 17 строке день меньше установленного.

		var currentHour = Number($jsapi.dateForZone("Europe/Moscow", "HH"));
		var currentMin = $jsapi.dateForZone("Europe/Moscow", "mm");
		var currentDay = $jsapi.dateForZone("Europe/Moscow", "dd.MM");

		if (testMode()){
			currentHour -= 3;
		}

		// День, в данный момент для НГ
		if (currentDay != '01.01'){
			return false;
		}

		if (currentHour < uptime_hh) {
			return true;
		}

		if (currentHour == uptime_hh && currentMin < uptime_mm) {
			return true;

		}

		return false;
	},

	//saturdayTimeIsGood: function () {
	//	var currentHour = Number($jsapi.dateForZone("Europe/Moscow", "HH"));
	//	var currentMin = $jsapi.dateForZone("Europe/Moscow", "mm");

	//	var currentDay = $jsapi.dateForZone("Europe/Moscow", "dd.MM")

	//	if (testMode()){
	//		currentHour -= 3;
	//	}

	//	if ((currentDay == '29.12') || (currentDay == '30.12')){
	//		return false
	//	}

	//	return (currentDate().isoWeekday() === 6 && currentHour >= 2 && currentHour < 10)
	//		|| (currentDate().isoWeekday() === 6 && currentHour === 10 && currentMin <= 19)
	//},

	sundayTimeIsGood: function () {
		var currentHour = Number($jsapi.dateForZone("Europe/Moscow", "HH"));
		var currentMin = $jsapi.dateForZone("Europe/Moscow", "mm");
		var currentDay = $jsapi.dateForZone("Europe/Moscow", "dd.MM");

		if (testMode()){
			currentHour -= 3;
		}

		if ((currentDay == '30.12') || (currentDay == '31.12')){
			return false;
		}

		return (currentDate().isoWeekday() === 7 && currentHour >= 2 && currentHour < 10)
			|| (currentDate().isoWeekday() === 7 && currentHour === 10 && currentMin <= 19);
	}

}

var Webim = {
	switch: function() {
		var $client = $jsapi.context().client;
		var $response = $jsapi.context().response;
		var $session = $jsapi.context().session;
		$session.CheckTicketCatchAll = false;

		if ($client.testMode || testMode()) {
			$reactions.answer('Перевод на оператора.');
		} else {
            $client.history = "Последний вопрос клиента: " + $session.nonsenseQuery;
            $response.replies = $response.replies || [];
            $response.replies
             .push({
                type:"switch",
                closeChatPhrases: ["/close", "вернуться в беседу с роботом"],
                firstMessage: $client.history,
            });
		}
	}
}

var Themes = {
	answerRandomThemes: function() {
        var themes = ['Как проверить билет?', 'Как изменить номер телефона?', 'Как заблокировать Личный Кабинет?', 'Как получить код выигрыша?', 'Не пришло письмо для завершения регистрации.', 'Как получить выигрыш?', 'Как восстановить пароль?', 'Где на билете номер тиража?', 'Где посмотреть билет, купленный без регистрации?', 'Как перевести деньги из Кошелька?', 'Где посмотреть результаты?', 'Как отписаться от рассылки?', 'Куда делись бонусы?', 'Перевел деньги из Кошелька Столото, но они не поступили.', 'Пополнил Кошелек Столото, но деньги не поступили.', 'Как принять участие в лотерее на сайте.', 'Не пришло СМС с паролем или для завершения регистрации.', 'Нет результатов на сайте.', 'Недоступна покупка билетов.', 'После оплаты билет не отобразился в Личном Кабинете', 'Недоступен баланс.', 'Проблемы с выплатой.']

        if (testMode()){
        	$reactions.answer(themes.slice(0,5).join('\n'))

        } else {
        	$reactions.answer(_.sample(themes, 5).join('\n'))
        }
	}
}


var Lotteries = {
	isLotteryAvailable: function(lottery, unavailableLotteries) {
		if (unavailableLotteries.toLowerCase().indexOf(lottery.toLowerCase()) > -1){
			return false
		}
		return true
	},

	allLotteriesAvailable: function($injector) {
		return $injector.russianLoto.isAvailable
				&& $injector.goldenShoe.isAvailable
				&& $injector.bingo75.isAvailable
				&& $injector['6of36'].isAvailable
				&& $injector.housingLottery.isAvailable
				&& $injector.zodiak.isAvailable
				&& $injector['4of20'].isAvailable
				&& $injector['5of36'].isAvailable
				&& $injector['6of45'].isAvailable
				&& $injector['7of49'].isAvailable
				&& $injector.matchball.isAvailable
				&& $injector.plusJoker.isAvailable
				&& $injector.rapido.isAvailable
				&& $injector['12of24'].isAvailable
				&& $injector.duel.isAvailable
				&& $injector.top3.isAvailable
				&& $injector.keno.isAvailable
				&& $injector.gosloto.isAvailable
	},

	getTargetLotteryPath: function($session){
		var ALLOWED_STATES = ['RussianLoto', 'GoldenShoe', 'Bingo75', 'HousingLottery', '6of36']
		var targetLottery = $session.lastLottery.charAt(0).toUpperCase() + $session.lastLottery.substr(1);

		if (ALLOWED_STATES.indexOf(targetLottery) > -1){
			return targetLottery
		}

		$jsapi.context().temp.targetLottery = $session.lastLottery;
		return "OtherNamedLottery"
	}
}

function createNewSession($request){
	$request.event = 'getRequestData'
	$reactions.newSession({request: $request});
}

function checkSameState($context){
    var session = $context.session;
    var response = $context.response;
    log(toPrettyString($context.currentState))
    log(toPrettyString(session.lastRecordedState))

    var repetition = false;
    if (session.lastRecordedState && session.lastRecordedState === $context.currentState) {
        repetition = true;
    }

    log(toPrettyString(repetition))

    session.lastRecordedState = $context.currentState;

    if (repetition){
    	if ($context.currentState && !session.askForOperator && !testMode() &&
            $context.currentState !== "/Thanks" && $context.currentState !== "/Hello" && $context.currentState !== "/Bye") {
   		    if (!$context.currentState.startsWith("/CatchAll") && !$context.currentState.endsWith('CatchAll')) {
	            // Переходы не работают в pre/postProcess
	            // Потому делаем все нужные действия прямо здесь
	            // 1. Стираем ответ выданый основным сценарием
	            response.replies = [];
	            response.answer = ""; //добавила, потому что Resterisk берет ответ из response.answer
	            // 2. Перетираем контекс
	            session.contextPath = "/CatchAll/SameAnswer"; // это путь контекста для разбора следующей фразы
	            $context.currentState = "/CatchAll/SameAnswer"; // это путь текущего состояния, который подставляется в ответ и далее проверяется в тесте
	            // 3. Формируем ответ
	            Webim.switch();

	        }
	    }
    }
}

function reactionCountdown($context){

	return
}


//function rusCitiestagConverter($parseTree){
//    var id = $parseTree.Cit[0].value;
//    return rusCities[id].value
//}



//function rusRegionstagConverter($parseTree){
//    var id = $parseTree.rusRegions[0].value;
//    return rusRegions[id].value
//}




