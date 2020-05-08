theme: /utilsTest

    #state: isSaturdayTimeGood
        #q!: justai тест времени суббота
        #script:
            #$reactions.answer(Time.saturdayTimeIsGood());

    state: isSundayTimeGood
        q!: justai тест времени воскресенье
        script:
            $reactions.answer(Time.sundayTimeIsGood());

    state: Test || noContext = true
        script:
            log($request.query);

    state: SetTestMode
        q!: * *setTestMode *
        a: Режим тестировки включен.
        script:
            $client.testMode = true

    state: DisableTestMode
        q!: * *disableTestMode *
        a: Режим тестировки отключен.
        script:
            $client.testMode = false

    state: Reset
        q!: *reset
        a: Сброс сессионных параметров пользователя.
        script:
            $session = {}
            $temp.pushGreeting = true

    state: RequestTest
        q!: justaiRequestTest
        a: {{toPrettyString($session.cachedRequest)}}

    # state: writeToSession
    #     q!: justai writeto session
    #     script:
    #         $session.test = $session.test || [];
    #         $session.test.push('Something')
    #     a: pushed something to session

    # state: logSession
    #     q!: justai log session
    #     script:
    #         log(toPrettyString($session))
    #     a: justai log session