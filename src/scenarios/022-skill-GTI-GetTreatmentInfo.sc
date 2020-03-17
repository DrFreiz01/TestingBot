#Сценарий по уточнению статуса обращения
#файл 022-skill-GTI-GetTreatmentInfo.sc

theme: /022

#GTI-01  уточнение номера UID обращения
#GTI-02  получение ответа от веб-сервиса

    #GTI  навык уточнения статуса обращения
    state: GTI
        intent!: /022/GTI
        script:
            sleep();
        a: Самостоятельно посмотреть статус обращения Вы можете только после того, как на Ваш мобильный телефон поступит смс c ссылкой, пройдя по которой, Вы увидите информацию по обращению.
        go!: ./GTI-01

# ----------------------------------------------------------------------------
# ----------------- GTI-01  уточнение номера UID обращения  ------------------
# ----------------------------------------------------------------------------

        #GTI-01  уточнение номера заказа
        state: GTI-01
            if: (!$session.gtiUID) || ($session.gtiUID == undefined)
                a:  Введите UID номер обращения. Я уточню информацию по нему.
                    <ul>
                        <li>UID - это последние 10 символов в ссылке, полученной по смс после создания обращения (все, что после символа "=")</li>
                    <ul>
#                go: ./GTI-01-validcheck
            else:
                a:  Введите номер заказа. Я уточню информацию по нему.
                    <ul>
                        <li>UID - это последние 10 символов в ссылке, полученной по смс после создания обращения (все, что после символа "=")</li>
                        <li>ранее Вы вводили: {{$session.gtiUID}}</li>
                    </ul>
#                go: ./GTI-01-validcheck
    
            #GTI-01-validcheck  проверка валидности (соответствия стандарту) номера заказа
            state: GTI-01-validcheck
                q: *
                script:
                    $session.gtiUID = $request.query.toString().replace(/[^a-z0-9]+/gi, '');
                    $session.gtiUIDLen = $session.gtiUID.length;
                    if ($session.gtiUIDLen === 10) {
                        $reactions.transition("../GTI-01-info");
                    } else {
                        $reactions.transition("../GTI-01-fail");
                    }
                    
            #GTI-01-fail  предоставленные данные номера заказа не соответствуют стандарту
            state: GTI-01-fail
                script:
                    sleep();
                a:  Вы ввели некорректный индентификатор обращения (UID):
                    <ul>
                        <li>ввести UID нужно не более одного обращения;</li>
                        <li>номер UID может состоять только из цифр и латинских букв. А его длина равна 10 символов;</li>
                        <li>убедитесь, что Вы вводите данные на латинской раскладке клавиатуры.</li>
                    </ul>
                    Отправьте корректный UID.
#                go: ../GTI-01-validcheck
                
            state: GTI-01-info
                a:  Ожидайте, пожалуйста...
                    <ul>
                        <li>уточняю информацию, это займёт до 20 секунд;</li>
                        <li>ничего не пишите, я Вас проинформирую о результате.</li>
                    </ul>    
                go!: ../../GTI-02
                
# ----------------------------------------------------------------------------
# ----------------- GTI-02  получение ответа от веб-сервиса  -----------------
# ----------------------------------------------------------------------------

        #GTI-02  запрос на веб-сервис
        state: GTI-02
            script:
                $session.wsUrl = 'http://95.181.203.70:80/SalesExternalWebServices/GetTreatmentInfo.ashx';
                $session.wsMethod = "POST";
                $session.wsBody = { "RequestSource" : "BOT",
                                    "SearchType" : "ByUID",
                                    "TreatmentUID" : $session.gtiUID };
                $session.wsTransGood = './GTI-02-postGood';
                $session.wsTransBad = './GTI-02-preBad';
                var $httpResponse = getStatus();
                    $session.RequestSource                  = $httpResponse.RequestSource;
                    $session.RequestStatus                  = $httpResponse.RequestStatus;
                    $session.RequestInfo                    = $httpResponse.RequestInfo;
                    $session.TreatmentUID                   = $httpResponse.TreatmentUID;
                    $session.TreatmentID                    = $httpResponse.TreatmentID;
                    $session.TreatmentStatus                = $httpResponse.TreatmentStatus;
                    $session.TreatmentContactName           = $httpResponse.TreatmentContactName;
                    $session.TreatmentContactMail           = $httpResponse.TreatmentContactMail;
                    $session.TreatmentContactPhone          = $httpResponse.TreatmentContactPhone;
                    $session.TreatmentContactStatus         = $httpResponse.TreatmentContactStatus;
                    $session.CommentList                    = $httpResponse.CommentList;
                    $reactions.transition($session.wsTransGood);
    
            #GTI-02-bad  ответ веб-сервиса 1 получен с ошибкой
            state: GTI-02-preBad
                a:  К сожалению, по техническим причинам, информация по вашему обращению временно недоступна, попробуйте позже.
                    Введите еще раз UID обращения, для повторной попытки или задайте другой вопрос, и мы перейдем к его рассмотрению.
                    go: ../../GTI-01/GTI-01-validcheck


    
            #GTI-02-good  ответ веб-сервиса 1 получен c кодом 200 ОК
            #Спецификация по все ответам веб-сервисов опубликована по ссылке: ...
#            state: GTI-02-preGood
#                a: Ответ от веб-сервиса получен:
#                   - RequestSource: {{$session.RequestSource}}
#                   - RequestStatus: {{$session.RequestStatus}}
#                   - RequestInfo: {{$session.RequestInfo}}
#                   - TreatmentUID: {{$session.TreatmentUID}}
#                   - TreatmentID: {{$session.TreatmentID}}
#                   - TreatmentStatus: {{$session.TreatmentStatus}}
#                   - TreatmentContactName: {{$session.TreatmentContactName}}
#                   - TreatmentContactMail: {{$session.TreatmentContactMail}}
#                   - TreatmentContactPhone: {{$session.TreatmentContactPhone}}
#                   - TreatmentContactStatus: {{$session.TreatmentContactStatus}}
#                   - CommentList: {{$session.CommentList}}
#                go!: ../GTI-02-postGood
                
            #GTI-02-postGood  отправка пользователю ссылки для ознакомления со статусом заказа
            state: GTI-02-postGood
                script:
                    sleep();
                    $session.gtiUIDLink = 'https://hoff.ru/status/?uid=' + $session.TreatmentUID;
                if: ($session.RequestStatus !== false)
                    a:  Ответ получен:
                        Для выбора даты доставки пройдите по ссылке: {{$session.gtiUIDLink}}
                else:
                    a:  Ответ получен:
                        <ul>
                            <li>К сожалению, информация по вашему обращению не найдена.</li>
                        <ul/>
                        Введите еще раз UID обращения, для повторной попытки или задайте другой вопрос, и мы перейдем к его рассмотрению.
                    go: ../../GTI-01/GTI-01-validcheck
                    
                    
                    #gettreatmeninfo.ashx
                    # real: http://95.181.203.70/SalesExternalWebServices/GetTreatmentInfo.ashx
                    # real: tt5k8wf9ds
                    # fake: http://95.181.203.86:88/SalesExternalWebServices/GetTreatmentInfo.ashx
                    # fake: dbk4mx0zlp