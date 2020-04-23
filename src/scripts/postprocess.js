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
        } else {
            $session.answerRepetition = 0;
        }
        if ($session.answerRepetition == 2) {
            $reactions.transition("/operator/goToOpeartor");
            //$response.replies = [];
            //$response.replies.push({
            //    type: "switch"
            //    });
        }
        $session.lastAnswer = answer;
    }
}