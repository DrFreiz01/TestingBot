theme: /ticketsSubscription

    state: howToSubscribeToAviaPricingChanges
        # 4EX: Как подписаться на уведомления об изменения цены на авиабилеты?
        q!: * (подписатьс*/подписатс*) * ($message/$notification/$sms/$smsInforming) * $changeNoun * $price * ($ticket/$airplaneTicket) *
        q!: * {(получать/палучать/палучять/получять/полусать) ($message/$notification/$sms/$smsInforming)} * $changeNoun * $price * ($ticket/$airplaneTicket) *
        q!: * $changeNoun * $price * ($ticket/$airplaneTicket) * (подписатьс*/подписатс*) * ($message/$notification/$sms/$smsInforming) *
        q!: * $changeNoun * $price * ($ticket/$airplaneTicket) * {(получать/палучать/палучять/получять/полусать) ($message/$notification/$sms/$smsInforming)} *
        a: Сейчас у нас нет такой функции, но она появится в скором времени! Пока вы можете самостоятельно следить за изменением цен на сайте.
        #a: Чтобы подписаться на изменение цены: \n• Введите, куда и когда вы хотите поехать, и нажмите «Найти». Вам откроется страница с вариантами перелета. \n• В правом верхнем углу появится предложение «Отслеживать цены». Нажмите на нее. \nГотово! Мы будем отправлять уведомления в течение двух недель.



    state: whenTcketsToCountryWillGetCheaper
        # 4EX: Когда подешевеют билеты в Болгарию?
        q!: * $when * ($ticket/$airplaneTicket/$flight) * $countryName * [будут/будет] ($cheap/$cheaper/$cheapest) [$markQuestion]
        q!: * $when * [будут/будет] ($cheap/$cheaper/$cheapest) * ($ticket/$airplaneTicket/$flight) * $countryName [$markQuestion]
        go!: /ticketsSubscription/howToSubscribeToAviaPricingChanges



    state: whenTheTicketsWillGetCheaper
        # 4EX: КАК МОЖНО СДЕЛАТЬ. ЗАПРОС    ЧТОБЫ УЗНАТЬ КОГДА НА ДАННЫЙ РЕЙС  ПО ДЕШЕВЛЕ БУДЕТ ЦЕНА.  МОЖНО БЕЗ БАГАЖА
        q!: * $when * ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс) * ($cheap/$cheaper/$cheapest) *
        q!: * $when * ($cheap/$cheaper/$cheapest) * ($ticket/$airplaneTicket/$flight/~вылет/~отлет/~отлёт/~рейс) *
        go!: /ticketsSubscription/howToSubscribeToAviaPricingChanges