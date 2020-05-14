function postprocess($context) {
    var $client   = $jsapi.context().client,
        $request  = $jsapi.context().request,
        $response = $jsapi.context().response,
        $temp      = $jsapi.context().temp,
        $session  = $jsapi.context().session;

    // Сохраняем выполненный стейт
    $client.executeState = $context.currentState;

    // Сохранение реплик юзера
    if (!$client.hasOwnProperty("clientQuery")) $client.clientQuery = {};

    if ($request.query && typeof $request.query !== "undefined") {
        if ($client.clientQuery.hasOwnProperty("lastQuery")){
            $client.clientQuery.preLastQuery = $client.clientQuery.lastQuery;
            $client.clientQuery.lastQuery    = $request.query.toLowerCase();
        } else {
            $client.clientQuery.lastQuery = $request.query.toLowerCase();
        }
    }
    // Остановка бота на повторе
    if ($response.replies) {
        var answer = $response.replies.reduce (function (answers, current) {
            answers += " " + current.text;
            return answers;
        }, "");
        if ($session.lastAnswer && (answer == $session.lastAnswer)) {
            $session.answerRepetition = $session.answerRepetition || 0;
            $session.answerRepetition += 1;
        } else if ($session.lastAnswer) {
            var lastAnswerRegexp = new RegExp(" Здравствуйте\!" + answer);
            if ($session.lastAnswer.match(lastAnswerRegexp)) {
                log('💪💪💪💪💪💪💪💪💪 попали в lastAnswer.match(lastAnswerRegexp)');
                $session.answerRepetition += 1;
            } else {
                $session.answerRepetition = 0;
            }
        } else {
            $session.answerRepetition = 0;
        }
        if ($session.answerRepetition == 2) {
            $reactions.transition("/operator/goToOpeartor");
        }
        $session.lastAnswer = answer;
        //$session.lastAnswer:  Здравствуйте! Вы можете восстановить пароль, пройдя по этой ссылке: https://www.ozon.travel/my/remind-password
        //answer:  Вы можете восстановить пароль, пройдя по этой ссылке: https://www.ozon.travel/my/remind-password
    }
}




