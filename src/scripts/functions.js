function getcity() {
    var $parseTree = $jsapi.context().parseTree;
    var $session = $jsapi.context().session;
    $session.ptrnCity = $parseTree._ptrnCity.name;
}

//Функция для таймаута ответа бота в милисекундах, со значением по умолчанию в 1500 миллисекунд
function sleep(milliseconds) { 
    milliseconds = typeof milliseconds !== 'undefined' ? milliseconds : '1500';
    var timeStart = new Date().getTime(); 
    while (true) { 
        var elapsedTime = new Date().getTime() - timeStart; 
        if (elapsedTime > milliseconds) { 
            break; 
        } 
    } 
}

//Функция универсальная для запроса на веб-сервис, запускается в сценарии по скрипту var $httpResponse = getStatus();
//перед запуском требует в сценарии определения переменных $session.wsUrl, $session.wsBody, $session.wsTransGood, $session.wsTransBad
function getStatus() {
    var $session = $jsapi.context().session;
    var url = $session.wsUrl;
    var options = {
        dataType: "json",
        method: "POST",
        headers: {},
        body: $session.wsBody
    };
    var result = $http.post(url, options);
    if (result.isOk && result.status >= 200 && result.status < 300) {
        return result.data;
    } else {
        $reactions.transition($session.wsTransBad);
    }
}

//Функция перебора элементов в массиве объектов (myArray) для поиска позиции объекта с известным именем (property) и значением (searchTerm)
function arrayObjectIndexOf(myArray, property, searchTerm) {
    for(var i = 0, len = myArray.length; i < len; i++) {
        if (myArray[i][property] === searchTerm) 
            return i;
    }
    return -1;
}
    
//          script:
//            var headers = {
//            };
//            var result = $http.query("http://95.181.203.86:88/SalesExternalWebServices/GetSalesOrders.ashx", {
//                method: "POST",
//                headers: headers,
//                query: $session,
//                body: _.template("{\r    \"RequestSource\" : \"BOT\",\r    \"SearchType\":\"ByAttributes\",\r    \"SearchData\":\r        {\r            \"TelephoneNum\" : \"{{$session.uid1Phone}}\",\r            \"OrderNum\" : \"{{$session.uid1}}\"\r        }\r}", {variable: '$session'})($session),
//                dataType: "json",
//                timeout: 0 || 10000
//            });
//            var $httpResponse = result.data;
//            $session.httpStatus = result.status;
//            $session.httpResponse = $httpResponse;
//            if (result.isOk && result.status >= 200 && result.status < 300) {
//                addClientVarToSession("RequestSource", $httpResponse.RequestSource);
//                addClientVarToSession("RequestStatus", $httpResponse.RequestStatus);
//                addClientVarToSession("RequestInfo", $httpResponse.RequestInfo);
//                addClientVarToSession("RequestInfoID", $httpResponse.RequestInfoID);
//                addClientVarToSession("AmountToPay", $httpResponse.AmountToPay);
//                addClientVarToSession("AmountTotal", $httpResponse.AmountTotal);
//                addClientVarToSession("DeliveryAddress", $httpResponse.DeliveryAddress);
//                addClientVarToSession("DeliveryServiceTelephoneNum", $httpResponse.DeliveryServiceTelephoneNum);
//                addClientVarToSession("OrderList", $httpResponse.OrderList);
//                $reactions.transition("/001/SDD/SDD-04-good");
//            } else {
//                $reactions.transition("/001/SDD/SDD-04-bad");
//            }