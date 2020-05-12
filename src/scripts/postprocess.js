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
            var answerRegexp = new RegExp(".+text= .+, state=.+");
            if (answer.match(answerRegexp)) {
                var answerText = answer.replace(/.+text= (.+), state=.+/, "$1");
                var lastAnswerRegexp = new RegExp(".+text= Здравствуйте\! " + answerText + ".+");
                if ($session.lastAnswer.match(lastAnswerRegexp)) {
                    $session.answerRepetition += 1;
                } else {
                    $session.answerRepetition = 0;
                }
            }
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
        //if ($session.answerRepetition) {
        //    $reactions.answer('$session.answerRepetition: ' + $session.answerRepetition);
        //}
        //$session.lastAnswer = 'Reply(type=text, text= Здравствуйте! Чем я могу вам помочь?, state=/helloBye/hello, interval=null, targetState=null)';
    }
}