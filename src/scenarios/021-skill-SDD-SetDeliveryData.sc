#Сценарий по навыку Выбору даты доставки
#файл 021-skill-SDD-SetDeliveryData.sc

theme: /021

#SDD-01  уточнение номера заказа
#SDD-02  уточнение номера телефона
#SDD-03  отправка запроса на первый веб-сервис

    #SDD  навык выбора даты доставки по заказу
    state: SDD
        intent!: /021/SDD
        go!: ./SDD-01

# ----------------------------------------------------------------------------
# --------------------- SDD-01  уточнение номера заказа  ---------------------
# ----------------------------------------------------------------------------

    #SDD-01  уточнение номера заказа

        state: SDD-01
            script:
                sleep();
            if: (!$session.sddID) || ($session.sddID == undefined)
                a: Введите номер заказа. Я уточню информацию по нему.
    #            go: ./SDD-01-validcheck
            else:
                a:  Введите номер заказа. Я уточню информацию по нему.
                    <ul>
                        <li>ранее Вы вводили: {{$session.sddID}}</li>
                    </ul>    
    #            go: ./SDD-01-validcheck
            
            #SDD-01-validcheck  проверка валидности (соответствия стандарту) номера заказа
            state: SDD-01-validcheck
                q: *
                script:
                    $session.sddID = $request.query.toString().replace(/[^a-z0-9]+/gi, '');
                    $session.sddIDlen = $session.sddID.length;
                    if (($session.sddIDlen >= 7) && ($session.sddIDlen <= 10)) {
                        $reactions.transition("../../SDD-02");
                    } else {
                        $reactions.transition("../SDD-01-fail");
                    }
    
            #SDD-01-fail  предоставленные данные номера заказа не соответствуют стандарту
            state: SDD-01-fail
                script:
                    sleep();
                a:  Вы ввели некорректные данные:
                    <ul>
                        <li>ввести нужно номер не более одного заказа;</li>
                        <li>номер заказа может состоять только из цифр и латинских букв. А его длина может быть от 7 до 10 символов;</li>
                        <li>убедитесь, что Вы вводите данные на латинской раскладке клавиатуры.</li>
                    </ul>
                    Введите корректные данные или задайте другой вопрос и мы перейдем к его решению.
    #            go: ../SDD-01-validcheck
            
# ----------------------------------------------------------------------------
# -------------------- SDD-02  уточнение номера телефона  --------------------
# ----------------------------------------------------------------------------

        #SDD-02  уточнение номера телефона покупателя (четырех последних цифр), указанного в заказе
        #if  если телефон покупателя {{$session.sddIDPhone}} ранее вводился, то показать это значение.
        state: SDD-02
            script:
                sleep();
            if: !$session.sddIDPhone
                a: Введите последние четыре цифры номера телефона покупателя, указанного в заказе {{$session.sddID}}.
    #            go: ./SDD-02-validcheck
            else:
                a:  Введите последние четыре цифры номера телефона покупателя, указанного в заказе {{$session.sddID}}.
                    <ul>
                        <li>ранее Вы вводили: {{$session.sddIDPhone}}</li>
                    </ul>
    #            go: ./SDD-02-validcheck
            
            #SDD-02-validcheck  проверка валидности (соответствия стандарту) номера телефона покупателя (четырех последних цифр)
            state: SDD-02-validcheck
                q: *
                script:
                    $session.sddIDPhone = $request.query.toString().replace(/\D/g, '').slice(-4);
                    $session.sddIDPhoneLen = $session.sddIDPhone.length;
                    if ($session.sddIDPhoneLen === 4) {
                        $reactions.transition("../../SDD-03");
                    } else {
                        $reactions.transition("../SDD-02-fail");
                    }
            
            #SDD-02-fail  предоставленные данные (четыре последние цифры) не соответствуют стандарту
            state: SDD-02-fail
                script:
                    sleep();
                a:  Вы ввели некорректные данные:
                    <ul>
                        <li>ввести нужно не более одного телефонного номера или его последние четыре цифры;</li>
                        <li>ввести номер телефона можно в любом формате.</li>
                    </ul>
                    Введите корректные данные или задайте другой вопрос и мы перейдем к его решению.
    #            go: ../SDD-02-validcheck

# ----------------------------------------------------------------------------
# ------------------ SDD-03  отправка запроса на веб-сервис  -----------------
# ----------------------------------------------------------------------------

        #SDD-03  запрос на веб-сервис 1
        state: SDD-03
            a:  Ожидайте, пожалуйста...
                <ul>
                    <li>уточняю информацию (до 20 секунд);</li>
                    <li>ничего не пишите, я отвечу о результате.</li>
                </ul>
            script:
                $session.wsUrl = 'http://95.181.203.70:80/SalesExternalWebServices/GetSalesOrders.ashx';
                $session.wsMethod = "POST";
                $session.wsBody = { "RequestSource" : "BOT",
                                    "SearchType": "ByAttributes",
                                    "SearchData": { "OrderNum" : $session.sddID,
                                                    "TelephoneNum" : $session.sddIDPhone }
                };
                $session.wsTransGood = './SDD-03-preGood';
                $session.wsTransBad = './SDD-03-preBad';
                var $httpResponse = getStatus();
                    $session.RequestSource                  = $httpResponse.RequestSource;
                    $session.RequestStatus                  = $httpResponse.RequestStatus;
                    $session.RequestInfo                    = $httpResponse.RequestInfo;
                    $session.RequestInfoID                  = $httpResponse.RequestInfoID;
                    $session.AmountToPay                    = $httpResponse.AmountToPay;
                    $session.AmountTotal                    = $httpResponse.AmountTotal;
                    $session.DeliveryAddress                = $httpResponse.DeliveryAddress;
                    $session.DeliveryServiceTelephoneNum    = $httpResponse.DeliveryServiceTelephoneNum;
                    $session.OrderList                      = $httpResponse.OrderList;
                    $reactions.transition($session.wsTransGood);
    
    
            #SDD-03-bad  ответ веб-сервиса 1 получен с ошибкой
            state: SDD-03-preBad
                script:
                    sleep();
                a:  Ответ получен:
                    <ul>
                        <li>по техническим причинам информация по заказу {{$session.sddID}} временно недоступна, попробуйте позже.</li>
                    <ul>
                    Напишите "Повтори", чтобы попытаться еще раз или задайте другой вопрос и мы перейдем к его решению.
                go!: ./repeat
            
                state: repeat
                    intent: /Общий/Repeat
                    go!: ../../../SDD-03
                    
            #SDD-03-preGood  ответ веб-сервиса 1 получен c кодом 200 ОК
            #Спецификация по все ответам веб-сервисов опубликована по ссылке: ...
            state: SDD-03-preGood
                script:
                    sleep();
    #            a: Ответ от веб-сервиса получен:
    #                - RequestInfoID: {{$session.RequestInfoID}}
    #                - RequestSource: {{$session.RequestSource}}
    #                - RequestStatus: {{$session.RequestStatus}}
    #                - AmountToPay: {{$session.AmountToPay}}
    #                - AmountTotal: {{$session.AmountTotal}}
    #                - DeliveryAddress: {{$session.DeliveryAddress}}
    #                - DeliveryServiceTelephoneNum: {{$session.DeliveryServiceTelephoneNum}}
    #                - OrderList: {{$session.OrderList}}
                if: $session.RequestInfoID === '1'
                    #ОШИБКА. Веб-сервис получил данные, не соответствущие его спецификации
                    a: Ответ получен: 
                       - переданы некорректные данные. 
                       Необходимо ввести корректные данные и повторить запрос.
                elseif: $session.RequestInfoID === '2.1'
                    #ОШИБКА. По предоставленным данным НЕ найден заказ на услугу.
                    a: Ответ получен: 
                       - К сожалению, не найдена информация о возможности доставки по заказу с номером {{$session.sddID}}. 
                    go!: ../SDD-03-OrderNumCheck
                elseif: $session.RequestInfoID === '2.2'
                    #ОШИБКА. По предоставленным данным найден заказ на услугу, но не найдены строки доставки.
                    a: Ответ получен: 
                       - К сожалению, в заказе {{$session.sddID}} недостаточно информации для назначения доставки.
                       Пожалуйста, обратитесь в наш колл-центр с просьбой оформить доставку.
                elseif: $session.RequestInfoID === '2.3'
                    #ОШИБКА. По предоставленным данным найден заказ на услугу, но поле "Адрес" пустое.
                    a: Ответ получен:
                       - К сожалению, в заказе {{$session.sddID}} недостаточно информации для назначения доставки.
                       Пожалуйста, обратитесь в наш колл-центр с просьбой уточнить адрес доставки в Вашем заказе.
                elseif: $session.RequestInfoID === '2.4'
                    #ОШИБКА. По предоставленным данным найден заказ на услугу, но введенные цифры не соответствуют телефону покупателя.
                    a: Ответ получен:
                       - К сожалению, введенные Вами данные "{{$session.sddIDPhone}}" не соответствуют последним четырем цифрам телефона покупателя, указанного в заказе {{$session.sddID}}.
                    go!: ../SDD-03-PhoneNumCheck
                elseif: $session.RequestInfoID === '3'
                    #ОШИБКА. По предоставленным данным найден заказ, но он не оплачен, либо оплачен не полностью. это для розничных заказов, а в инет-магазине оплата не проверяется.
                    a: Ответ получен:
                       - К сожалению, по заказу {{$session.sddID}} нет полной оплаты.
                       Пожалуйста, обратитесь в магазин, где оформлена покупка, для полной оплаты Вашего заказа.
                elseif: $session.RequestInfoID === '4'
                    #ОШИБКА. По предоставленным данным найден заказ, но он не укомплектован.
                    a: Ответ получен:
                       - К сожалению, по заказу {{$session.sddID}} товары ещё не поступили на склад.
                       Пожалуйста, обратитесь в наш колл-центр и скажите, что Вам нужно уточнить сроки поступления товаров на склад..
                elseif: $session.RequestInfoID === '5'
                    #ОШИБКА. По предоставленным данным найден заказ, но в нём присутствует заказ на сборку.
                    a: Ответ получен:
                       - К сожалению, в заказе {{$session.sddID}} есть услуга "Сборка мебели", поэтому назначить дату доставки самостоятельно не получится.
                       Пожалуйста, обратитесь в наш колл-центр и скажите, что Вам нужно назначить доставку.
                elseif: $session.RequestInfoID === '6'
                    #УСПЕШНО. Заказ готов к назначению даты доставки (вариант 1)
                    a: Ответ получен:
                       - заказ {{$session.sddID}} найден. Вы можете приступить к просмотру доступных дат доставки.
                    go!: ../SDD-03-postGood
                elseif: $session.RequestInfoID === '7'
                    #УСПЕШНО. Заказ готов к назначению даты доставки (вариант 2)
                    a: Ответ получен: 
                       - по заказу {{$session.sddID}} доставка уже назначена, но Вы еще можете её поменять. Когда процесс доставки будет запущен, поменять её дату уже не получится.
                    go!: ../SDD-03-postGood
                elseif: $session.RequestInfoID === '8'
                    #ОШИБКА. По предоставленным данным найден заказ, но он уже передан в доставку и поэтому дату нельзя поменять.
                    a: Ответ получен: 
                       - по заказу {{$session.sddID}} процесс доставки уже запущен.
                       К сожалению, поменять дату доставки уже не получится.
        
            #SDD-03-OderNumCheck  сверка номера заказа, если заказ не найден
            state: SDD-03-OrderNumCheck
                script:
                    sleep();
                a:  Проверьте, правильность введенных данных:
                    <ul>
                        <li>{{$session.sddID}} - номер заказа.</li>
                    </ul>
                    Если Вы уверены в их корректности, то, пожалуйста, обратитесь в наш колл-центр с просьбой назначить услугу доставки.
                    Если Вы нашли ошибку, то введите корректные данные или напишите в чат другой вопрос и мы перейдем к его решению.
                go: ../../SDD-01
        
            #SDD-03-PhoneNumCheck  сверка номера телефона, если он не соответствует
            state: SDD-03-PhoneNumCheck
                script:
                    sleep();
                a:  Проверьте правильность введенного данных:
                    <ul>
                        <li>{{$session.sddIDPhone}} - четыре последние цифры телефона покупателя в заказе.</li>
                    </ul>    
                    Если Вы уверены в их корректности, то, пожалуйста, обратитесь в наш колл-центр с просьбой назначить услугу доставки.
                    Если Вы нашли ошибку, то в следующем сообщении отправьте верные данные или напишите в чат другой вопрос и мы перейдем к его решению.
                go: ../../SDD-02
        
            #SDD-03-postGood  отправка пользователю ссылки для установки даты доставки
            state: SDD-03-postGood
                script:
                    sleep();
                    $session.i = arrayObjectIndexOf($session.OrderList, "OrderType", "GoodsDelivery");
                    $session.sddUID = $session.OrderList[$session.i].OrderUID;
                    $session.sddUIDlink = 'https://hoff.ru/delivery/set-delivery/?uid=' + $session.sddUID;
                a:  Для выбора даты доставки пройдите по ссылке: <a href="{{$session.sddUIDlink}}" target="_blank">{{$session.sddUIDlink}}</a>

# ----------------------------------------------------------------------------
# ---------- #SDD-..  текст  -----------
# ----------------------------------------------------------------------------

