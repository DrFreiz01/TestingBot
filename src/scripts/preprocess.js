function preprocess($context) {

    var $client    = $jsapi.context().client,
        $temp      = $jsapi.context().temp,
        $request   = $jsapi.context().request,
        $parseTree = $jsapi.context().parseTree,
        $response  = $jsapi.context().response,
        $session   = $jsapi.context().session,
        query      = $request.query,
        $score     = 0;

    // Узнаем длину входящего запроса (делениe по пробелам)
    if ($request.query) {
        var stringLength = $request.query.split(" ").length;
        // запоминаем ДО срабатывания матчера
        if (stringLength >= 135) {
            $temp.targetState = '/operator/goToOpeartor';
        }
    }
    // сравнение сохраненных реплик юзера
    if ($client.hasOwnProperty("clientQuery")) {
        $client.clientQuery.query = $request.query;
    }
};