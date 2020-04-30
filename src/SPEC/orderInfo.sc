theme: /orderInfo

    state: getOrderInfo
        script:
            var url = 'https://chat-bot-api.ozon.travel/chatbot/order/' + $temp.orderNumber;
            var result = $http.query (url, {
                method: "GET",
                headers: {"Content-Type": "application/json", "Authorization": "Bearer 285D4CD477C1D5DFEB3BCBA5E0DF05D7E339D3E1"},
                timeout: 0 || 10000
            });
            if (result && result.data) {
                var $httpResponse = result.data;
                if (result.data.orderId) {
                    $session.orderId = result.data.orderId;
                }
                if (result.data.positions.length == 1) {
                    $session.positionId = result.data.positions[0].positionId;
                }
            } else {
                $reactions.transition("/operator/goToOpeartor");
            }
        go!: {{$client.executeState}}