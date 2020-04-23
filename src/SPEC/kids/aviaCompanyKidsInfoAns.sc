theme: /aviaCompanyKidsInfoAns

    state: confluenceUrlKids
        state: confluenceUrlKids
            q: * $orderNumber *
            script:
                var orderNumber = $parseTree._orderNumber.replace(/(\d{8})[^\d]?(\d{4})/, "$1-$2");
                var url = 'https://chat-bot-api.ozon.travel/chatbot/order/' + orderNumber;
                var result1 = $http.query(url, {
                    method: "GET",
                    headers: {"Content-Type": "application/json", "Authorization": "Bearer 285D4CD477C1D5DFEB3BCBA5E0DF05D7E339D3E1"},
                    timeout: 0 || 10000
                });
                $temp.httpResponse1 = result1.data;
                $session.aviaCompanyAA = result1.data.positions[0].airlineCode;
            a: Ссылка на информацию о детях: {{'https://confluence.ozon.ru/display/REG/'+ $session.aviaCompanyAA + '+Children'}}