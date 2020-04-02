require: pizza.sc
require: cart.sc

theme: /

    state: Welcome
        q!: * *start
        script:
            $context.session = {}
            $context.client = {}
            $context.temp = {}
            $context.response = {}
        a: Привет! Я электронный. 
        go!: /ChooseCity

    state: ChooseCity || modal = true
        a: Выберите свой город.
        buttons:
            "Санкт-Петербург" -> ./RememberCity
            "Москва" -> ./RememberCity

        state: RememberCity
            script:
                $client.city = $request.query;
                $session.cart = [];
            go!: /ChoosePizza  

        state: ClickButtons
            q: *
            a: Нажмите, пожалуйста, кнопку.
            go!: ..

    state: CatchAll
        q!: *
        a: Я вас не понимаю.
