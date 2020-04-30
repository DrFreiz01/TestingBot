theme: /faq


    state: coronaVirus
        q!: * $coronaV *
        a: Из-за ситуации с коронавирусом у нас увеличилось количество заявок в очереди. Если вы еще не получили ответ, просим подождать, мы обязательно возьмем вашу заявку в работу и ответим. Сейчас срок обработки заявок может превышать 10 дней. В первую очередь будут обработаны заявки с вылетом в ближайшие 48 часов, остальные — в порядке очереди, с учетом времени вылета и приобретенного пакета услуг. \nСледите за новостями авиакомпаний на нашем сайте. \nЕсли вы хотите создать заявку на возврат или обмен, оформите ее через личный кабинет на нашем сайте. \nНе создавайте повторных заявок — дополнительный звонок или обращение в чат не ускорит решение вопроса. \nМы делаем все, что от нас зависит, чтобы помочь вам.



    state: wannaBuyThisTicket
        # 4EX: Хочц купить этот билет
        q!: [$beginningWords] [я/йа] ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) $buyInf {(этот/эти) ($ticket/$airplaneTicket/$flight)} [$markQuestion]
        if: $session.urlOzon || ( $session.landing &&  $session.landing.match(/.+ozon\.travel\/flight\/search\/[A-Za-z]{6}.+/) )
            a: Чтобы купить билет, нажмите на интересующий вас вариант. Вы будете перенаправлены на страницу оформления заказа. \nВведите паспортные данные пассажиров, свою электронную почту, контактный номер телефона и переходите к оплате билетов.
        else:
            go!: /faq/howToPlaceOrder



    state: buyTicketWithWarranty
        # 4EX: Здравствуйте, хочу купить билет с гарантией возврата и обмена https://www.ozon.travel/help/avia/ret-exc-guarantee/, но такой услуги при бронировании билета я не вижу
        q!: * ($bookInf/$buyInf/$buyNoun) * ($ticket/$airplaneTicket/$flight) * ~гарантия [на/для] ($returnNoun/~обмен) *
        q!: * ($ticket/$airplaneTicket/$flight) * ($bookInf/$buyInf/$buyNoun) * ~гарантия [на/для] ($returnNoun/~обмен) *
        go!: /operator/goToOpeartor



    state: howToBookTicket
        # 4EX: Как забронировать авиабилеты без оплаты
        q!: ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) [$meDat] {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} *
        q!: {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) *
        script:
            $client.topic = "Вопросы по оформлению заказа";
        a: После оформления заказа нажмите кнопку «Забронировать». Система определит время, в течение которого можно оплатить билет. Обычно это от 25 минут до 48 часов для авиабилетов и 15 минут – для ж/д билетов. Если в этот период не оплатить заказ, то он будет автоматически отменен.



    state: howToPlaceOrder
        # 4EX: как оформить заказ
        q!: ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) [$meDat] {$issueVerbInf $order} [$markQuestion]
        q!: {$issueVerbInf $order} [$meDat] ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) [$markQuestion]
        script:
            $client.topic = "Вопросы по оформлению заказа";
        a: Чтобы оформить заказ: \n∙ На сайте выберите «Авиабилеты» или «Железнодорожные билеты». \n∙ Заполните поля «Откуда» и «Куда».\n∙ Если вам нужен обратный билет, нажмите на кнопку «Обратно». \n∙ Укажите даты поездки, количество  пассажиров и нажмите «Найти». Вы окажетесь на странице с вариантами билетов. \n∙ Нажмите на интересующий вас вариант. Вы будете перенаправлены на страницу оформления заказа. \n∙ Чтобы завершить оформление и перейти к оплате билетов, введите паспортные данные пассажиров, свою электронную почту и контактный номер телефона.



    state: registerAndBuyTickets
        # 4EX: Как можно зарегистрироваться и оплатить билеты?
        # 4EX: Как можно зарегистрироваться и купить билеты?
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $registerInf * ($buyAllExceptPast/$payAll) * ($eTicket/$ticket/$airplaneTicket/$flight) *
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $registerInf * ($eTicket/$ticket/$airplaneTicket/$flight) * ($buyAllExceptPast/$payAll) *
        q!: * ($where/$how/$want/$need2/$canSynPossible) * ($buyAllExceptPast/$payAll) * ($eTicket/$ticket/$airplaneTicket/$flight) * $register *
        q!: * ($where/$how/$want/$need2/$canSynPossible) * ($eTicket/$ticket/$airplaneTicket/$flight) * ($buyAllExceptPast/$payAll) * $register *
        script:
            $client.topic = "Вопросы по оформлению заказа";
        a: Регистрация вашего личного кабинета пройдет автоматически при первом заказе, - логином для входа будет электронная почта, которую вы укажете как контактную. \nЛичный кабинет на Ozon.Travel будет зарегистрирован автоматически, когда вы оформите первый заказ. Там будут находиться ваши электронные билеты и подробная информация по заказам. Логин для входа в Личный кабинет — электронная почта, которую вы укажете как контактную, а пароль вам нужно будет задать самостоятельно. \nЕсли у вас есть Личный кабинет на сайте ozon.ru, то вы можете войти на Ozon.Travel, используя логин и пароль от ozon.ru.



    state: buyMoreThenXTickets
        # 4EX: Здравствуйте! Можно ли купить больше 10 билетов?
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $buyAllExceptPast {([больше/около/ок] $10to59) ($ticket/$airplaneTicket)} *
        q!: * ($where/$how/$want/$need2/$canSynPossible) [я/мы/йа] {([больше/около/ок] $10to59) ($ticket/$airplaneTicket)} * $buyAllExceptPast *
        q!: * $buyAllExceptPast [$meDat] {([больше/около/ок] $10to59) ($ticket/$airplaneTicket)} * ($where/$how/$want/$need2/$canSynPossible) [$meDat] [$markQuestion]
        q!: * {([больше/около/ок] $10to59) ($ticket/$airplaneTicket)} * ($where/$how/$want/$need2/$canSynPossible) [$meDat] $buyAllExceptPast [$markQuestion]
        go!: /faq/buyGroupTicket



    state: whyPriceKeepsChanginfFromDest
        # 4EX: Добрый день, подскажите почему при выборе авиабилета, в списке высвечивается авиабилет Москва-Баку по цене 10784 рубля, а когда кликаешь на него сумма выходит 11472 рубля
        q!: * $ruPochemu * $iataAndRailway::fromCode * $iataAndRailway::destCode * {$price $numberDig} * (а/но) $when (цыкаю/цыкаеш*/цикаю/цикаеш*/кликаю/кликаеш*/жму/жмешь/нажимаю/нажимаеш*) * (сумма/сума/$price) * $numberDig *
        script:
            $client.topic = "Авиабилеты - Общие вопросы";
        a: Цены и количество билетов постоянно меняются. Сколько билетов может быть продано по конкретному тарифу, определяет авиакомпания. Если билет исчезает из выдачи, скорее всего, его кто-то купил. Поэтому авиакомпания предлагает вам следующий по стоимости ценовой тариф.



    state: differentTicketsPrice
        # 4EX: разная цена билетов
        q!: {(разн*/другая/другие) ($price [на] ($ticket/$airplaneTicket/$flight))}
        # 4EX: Другая цена на сайте
        q!: {(разн*/другая/другие) ($price [на ($ticket/$airplaneTicket/$flight)]) на [друг*] сайт*}
        go!: /operator/goToOpeartor



    state: differentTicketsPriceFromDest
        # 4EX: Здравствуйте, на официальном сайте ювт аэро билет Казань - Омск стоит 5730,а почему у вас больше 6 т хотя написано что сбора за озон, тревел нет
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $cost * $ruPochemu * у $youGenAcc больше *
        go!: /operator/goToOpeartor



    state: aeroExpress
        # 4EX: можно ли купить билет на аэроэкспресс до шереметьево на ozonetravel?
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $buyAllExceptPast * (аэроэкспрес*/аэроэксперс*/аероэксперс*/аэро экспрес*/аэро эксперс*/аеро эксперс*) *
        a: Билеты на аэроэкспресс можно купить на последнем этапе оформления авиабилетов, при условии, что аэроэкспресс работает на момент вашего прибытия в Москву (или отъезда).



    state: buyGroupTicket
        # 4EX: Добрый день, интересует приобретение групповых авиабилетов
        q!: * $buyAllExceptPast * ({(группов*/групов*) ($ticket/$airplaneTicket)} / ($ticket/$airplaneTicket) [$oneWord] ~группа) *
        script:
            $client.topic = "Авиабилеты - Общие вопросы";
        a: Билеты на 10 человек и больше попадают в категорию «Групповое бронирование». По правилам авиакомпании для них могут быть открыты специальные тарифы. \nПоэтому, чтобы купить билеты на группу, напишите нам через форму обратной связи: https://www.ozon.travel/feedback. В тексте, пожалуйста, по возможности укажите количество пассажиров, маршрут, даты поездки и паспортные данные каждого человека.



    state: changePhoneNumb
        # 4EX: Как поменять регистрационные данные (номер телефона)
        q!: * ($how/$want/$need2/$canSynPossible) * $changeInfAll * ($telephoneNumber/$mobilePhoneNumberDig) [$markQuestion]
        q!: * ($how/$want/$need2/$canSynPossible) * ($telephoneNumber/$mobilePhoneNumberDig) * $changeInfAll [$markQuestion]
        q!: * ($telephoneNumber/$mobilePhoneNumberDig) * ($how/$want/$need2/$canSynPossible) * $changeInfAll [$markQuestion]
        q!: $changeInfAll [$my2/$ruSvoi] ($telephoneNumber/$mobilePhoneNumberDig) [$markQuestion]
        q!: [$my2/$ruSvoi] ($telephoneNumber/$mobilePhoneNumberDig) $changeInfAll [$markQuestion]
        a: Вы можете поменять свой номер телефона в личном кабинете на нашем сайте в разделе регистрационные данные.



    state: timeForTransfer
        # 4EX: Мы успеем на пересадку?
        q!: * (успею/успеем/успеим/успеть) [я/йа] ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) *
        q!: * ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) [я/йа] (успею/успеем/успеим/успеть) [$markQuestion]
        # 4EX: Этого времени хватит на пересадку?
        q!: * {времени [$meDat] (хватит/достаточно/достанет)} * ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) *
        q!: * ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) * {времени [$meDat] (хватит/достаточно/достанет)} [$markQuestion]
        # 4EX: пересадка 1ч 55мин- достаточное время для пересадки?
        q!: * {достаточно* (времени/время)} ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) [$markQuestion]
        q!: * достаточно* * (минут/часов/час/часа/минуты/мин) ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) [$markQuestion]
        q!: * (минут/часов/час/часа/минуты/мин) достаточно* * ((на/для) (пересадк*/трансфер*/трансфёр*)/[чтобы/чтоб] {(сделать/совершить/совершать) (пересадку/трансфер/трансфёр)}/пересесть) [$markQuestion]
        script:
            $client.topic = "Стыковки и транзит";
        a: Для рейсов, которые находятся в одном бронировании, время на пересадку просчитано заранее. \nЧтобы точно успеть на следующий рейс, советую пройти онлайн-регистрацию на сайте авиакомпании и заранее узнать, насколько далеко друг от друга находятся терминалы прилета и вылета. \nПри желании вы можете выбрать рейсы с более длинными стыковками.



    state: registerAsLegalEntity
        # 4EX: Хотели бы зарегистрироваться как юридическое лицо
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $register * $legalEntity [$markQuestion]
        # 4EX: Добрый день, подскажите с вами можно заключить договор на заказ авиабилетов для компании
        # 4EX: Добрый день, подскажите пожалуйста с кем можно связаться для заключения договора на покупку авиа и ж/д билетов для юр.лица
        q!: * {(заключит*/заключен*/хаключен*/подписат*/падписат*/подписани*) ~договор} * (оказан* услуг*/{($issueNoun/$buyNoun/$order/~оплата/~плата/~уплата/бронировани*/~бронь) ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket)}) *
        q!: * (оказан* услуг*/{($issueNoun/$buyNoun/$order/~оплата/~плата/~уплата/бронировани*/~бронь) ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket)}) * {(заключит*/заключен*/хаключен*/подписат*/падписат*/подписани*) ~договор} *
        a: Чтобы зарегистрироваться как юридическое лицо, перейдите по этой ссылке https://www.ozon.travel/corporate, заполните предложенную форму.



    state: buyTicketsAsLegalEntity
        # 4EX: то есть мне нужно оформить заказ на билеты и что бы их оплатила организация
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$issueAllExceptPast $order} * ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket) * $payAll * (организац*/компани*/$legalEntity/$ip) [$markQuestion]
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket) * {$issueAllExceptPast $order} * $payAll * (организац*/компани*/$legalEntity/$ip) [$markQuestion]
        # 4EX: Как я могу купить билеты через Юр. Лицо?
        # 4EX: Добрый день, мне необходимо создать личный кабинет, пополнить счет и купить билеты от ИП. Как это сделать?
        q!: * {($paymentAll/$payAll/$buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf) ([за] ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket))} * (через/с помощью/от [лица]/посредством/как) (организац*/компани*/$legalEntity/$ip) *
        q!: * (через/с помощью/от [лица]/посредством/как) (организац*/компани*/$legalEntity/$ip) * {($paymentAll/$payAll/$buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf) ([за] ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket))} *
        # 4EX: Добрый день. Можете ли выставить счет на юриличенское лицо на покупку авиабилетов? и можно ли оплатить с расчетного счета компании?
        # 4EX: как можно получить счет на организацию для оплаты билетов
        # 4EX: Добрый день! Можно ли заказать билеты и выписать счет на организацию?
        q!: * {(выставит*/получит*) ~счет} * (организац*/компани*/$legalEntity/$ip) * {($paymentAll/$payAll/$buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf) ([за] ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket))} *
        q!: * {($paymentAll/$payAll/$buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf) ([за] ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket))} * {(выставит*/получит*) ~счет} * (организац*/компани*/$legalEntity/$ip) *
        # 4EX: Добрый день. Возможна ли оплата железнодорожных билетов с расчетного счета организации?
        q!: * {($paymentAll/$payAll/$buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf) ([за] ($ticket/$airplaneTicket/$railwayTicket/$flight/авиа [и] $railwayTicket))} * (расчетн/расчотн) счет* * (организац*/компани*/$legalEntity/$ip) *
        # 4EX: Как можно оформить оплату организацией.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $issueAllExceptPast * $paymentAll * (организац*/компани*/$legalEntity/$ip) [$markQuestion]
        a: Сначала зарегистрируйтесь как юридическое лицо по ссылке https://www.ozon.travel/corporate. После этого для вас будет создан личный кабинет корпоративного клиента. В нем вы можете бронировать и оплачивать билеты как юридическое лицо.



    state: error
        # 4EX: Здравствуйте! возникает ошибка регистрации при покупке билета
        q!: * (возник*/выдае*/выдаё*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/вышл*/дает/даёт) * (~ошибка/ошибк*/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * $weight<+1>
        q!: * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * (возник*/выдает*/выдаёт*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/вышл*/дает/даёт) * $weight<+1>

        #q!: * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * (брон*) * $weight<+1>
        #q!: * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * (помоги*) * $weight<+1>
        #q!: * (помоги*) * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * $weight<+1>
        # 4EX: заказывал билет с волгограда в москву.  билет не был забронирован.  была ошибка какая то.  деньги с карточки сняли, а билет не забронировался.  позвонил оператору, она онулировала заказ и сказала, что деньги вернут в течении часа или суток. прошло больше суток, а деньги не пришли
        q!: * {$money ([$my2/$meDat] $ne [$oneWord] (пришел*/пришол*/пришл*/поступил*/поступал*/паступил*/паступал*/*чсилен*/*числен*/*числин*))} *
        # 4EX: Здравствуйте, у меня ошибка в имени на билетах, отправила заявку, отпета до сих пор нет
        q!: * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * заявк* * $weight<+1>
        q!: * (~заявка/~заявление) * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * $weight<+1>

        q!: * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * $payment * $weight<+1>
        q!: * $payment * (~ошибка/ошибс*/ошиблас*/некоррект*/не корректн*/~проблема) * $weight<+1>
        # 4EX: Здравствуйте. А почему не получилось зарегестрировать на рейс Рига - Москва?
        # 4EX: Написан билет за 14000, почему не могу купить?
        q!: * {($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) [$meDat] ($buyAllExceptPast/$buyVerbPast/$issueVerb/$bookInf/$order/$orderVerbInf/$registerInf)} * $weight<+1>
        # 4EX: Я так и делаю,но после нажатия "вернуть билет", окно резко становится не активным
        q!: * (окно/окошко/кнопка/поле) * (становится/превращается) [в] ($ne активн*/неактивн*) *
        go!: /operator/goToOpeartor



    state: doesntLoad
        # 4EX: Вот окошко укажите новый пароль у меня не показывает,уже и с моб.интернета и с вай фая пробовала,все равно не грузиться
        q!: * (окно/окошко/кнопка/поле) * $ne (возник*/выдает*/выдаёт*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/дает/даёт/происходит/происходет) * $ne (грузит*/загружает*)
        # 4EX: Пытаюсь вернуть билеты - минут 10 уже грузить и ничего не выдает(
        q!: * ($cancelInf/$returnInf/задать/здать/сдать) * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * {($NumberDig/$NumberDigWithLett/$NumberLett) (минут*/мин)} * (грузит*/загружает*) * ничего $ne (возник*/выдает*/выдаёт*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/дает/даёт/происходит/происходет) *
        q!: * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * ($cancelInf/$returnInf/задать/здать/сдать) * {($NumberDig/$NumberDigWithLett/$NumberLett) (минут*/мин)} * (грузит*/загружает*) * ничего $ne (возник*/выдает*/выдаёт*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/дает/даёт/происходит/происходет) *
        q!: * {($NumberDig/$NumberDigWithLett/$NumberLett) (минут*/мин)} (грузит*/загружает*) * ничего $ne (возник*/выдает*/выдаёт*/выдал*/произош*/произш*/показывает*/вываливает*/отображает*/пишет/пишут/показывает*/выходит/вылезает/вылазит/дает/даёт/происходит/происходет) *
        # 4EX: Понял. Спасибо. Что то не грузит документ.
        q!: * {($ne (грузит*/загружает*)) документ*}
        # 4EX: Я это сделала, только выйти с этого аккаунта я не могу, потому что не грузится страничка с личным кабинетом
        # 4EX: Здравствуйте! Не грузится личный кабинет
        q!: * ($ne (грузит*/загружает*)) {[$ruUMenya] ([$my2] [страниц*/страничк*]) ([с] $persCabinet)}
        q!: * {[$ruUMenya] ([$my2] [страниц*/страничк*]) ([с] $persCabinet)} ($ne (грузит*/загружает*))
        # 4EX: Я прописываю билет прописываю свои данные заново потому что я в личный кабинет не могу зайти а потом уже когда покупать билет он у меня опять же не грузится
        # 4EX: Я не могу зайти в личный кабинет для изменения пароля..сайт не грузится
        q!: * {([$to] $persCabinet) ($cannotI/$succeedInNot) $enterInf}  * ($ne (грузит*/загружает*)) *
        # 4EX: Она не грузиться ваша ссылка
        q!: * {($ne (грузит*/загружает*)) ([$your2] ссылк*) [$ruUMenya]}
        # 4EX: Ваша ссылка не грузится. По крайней мере на телефоне
        q!: * {($ne (грузит*/загружает*)) ([$your2] ссылк*) [$ruUMenya]} * на ($telephone/$telephoneMobile) *
        # 4EX: Вообще не грузит сайт
        # 4EX: Добрый день! Подскажите в какое время я буду в мск по этому рейсу. Сайт не грузится
        q!: * {(сайт [$your2]) [$ruUMenya] ($ne (грузит*/загружает*))}
        # 4EX: Не грузится
        # 4EX: И не грузится
        q!: [$beginningWords] ($ne (грузит*/загружает*))
        # 4EX: Ссылка на форму обратной связи не грузится.
        q!: * {(обратн*/обартн*) связ* ($ne (грузит*/загружает*))}
        # 4EX: Я хотела бы поменять хату перелёта, но у меня почему-то не грузит в билете ничего
        q!: * {($ne (грузит*/загружает*)) [в $ticket/$railwayTicket/$airplaneTicket] (ничего/ничево)}
        if: $session.browser && $session.browser.match(/Chrome.+/i)
            go!: /operator/goToOpeartor
        else:
            a: Наш сайт лучше всего работает в браузере Google Chrome, зайдите к нам через этот браузер и попробуйте еще раз.



    state: appDoesnLoad
        # 4EX: Смотрите, я купила билет на вашем сайте, решила установить после этого мобильное приложение чтобы регистрироваться на рейс онлайн, хотела создать личный кабинет, зарегистрироваться, но приложение не грузится
        # 4EX: Я то как раз хочу войти в личный кабинет, но не грузится в приложении
        # 4EX: Почему у меня не грузится приложение?
        q!: * {~приложение ($ne (грузит*/загружает*))} * $weight<+1>
        go!: /operator/goToOpeartor



#    state: georgia
#        q!: * (~грузия/тбилиси) * $weight<+1>
#        a: В связи c закрытием авиасообщения между Россией и Грузией с 8 июля 2019 года, российские авиакомпании разрешили вынужденный возврат ранее купленных билетов. Оформить возврат вы можете в личном кабинете на сайте Ozon.Travel. \nДля этого зайдите в ваш личный кабинет и напротив номера заказа выберите «Заявка на возврат», а в причине возврата укажите «вынужденный». Далее выберите признак «отмена рейса». \nБолее подробную информацию можно найти по ссылке: https://www.ozon.travel/help/avia/flights-to-Georgia



    #state: specificTime
    #    # 4EX: вылет туда в 5:15 утра
    #    q!: * $timeNumber * $weight<+1>
    #    go!: /operator/goToOpeartor

    state: didntGetMoney
        # 4EX: не вернулись деньги на карту по заказу 18073885-0001
        q!: * {($ne (вернули*/пришли/прислали/дошли)) (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} на карту *
        q!: * на карту {($ne (вернули*/пришли/прислали/дошли)) (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price)} *
        go!: /operator/goToOpeartor



    state: orderNumber
        q!: * $orderNumber *
        # 4EX: Здравствуйте! Получил информацию об отмене заказа, хотел бы вернуть деньги, в личном кабинете заказ не отображается. заказ 17991814-0001
        q!: * {$order ($ne (вижу/видн*/виден/видны/отображ*/отоброж*))} * $orderNumber *
        q!: * $orderNumber * {$order ($ne (вижу/видн*/виден/видны/отображ*/отоброж*))} *
        go!: /operator/goToOpeartor



    state: missedOneWayRoundTripBurns
        # 4EX: Добрый день, по заказ 15305927-0024 если пассажир не воспользуется билетом в Челябинск -Москва у, из Москвы в Челябинск билет аннулируется?
        q!: * $ne (воспользовал*/полетел*/сел/села/сели/улетел*) * $iataAndRailway * $iataAndRailway * $iataAndRailway * $iataAndRailway * ($cancelFut/пропадет/сгорит) *
        q!: * $ne (воспользовал*/полетел*/сел/села/сели/улетел*) * $iataAndRailway * $iataAndRailway * ($cancelFut/пропадет/сгорит) * $iataAndRailway * $iataAndRailway *
        q!: * $iataAndRailway * $iataAndRailway * ($cancelFut/пропадет/сгорит) * $ne (воспользовал*/полетел*/сел/села/сели/улетел*) * $iataAndRailway * $iataAndRailway *
        q!: * ($cancelFut/пропадет/сгорит) * $iataAndRailway * $iataAndRailway * $ne (воспользовал*/полетел*/сел/села/сели/улетел*) * $iataAndRailway * $iataAndRailway *
        go!: /operator/goToOpeartor



    state: animal
        q!: * (~собака/~собачка/~кошка/кот/котик/кота/котом/~крыса/~животное) * $weight<+1>
        go!: /operator/goToOpeartor



    state: bus
        # 4EX: здравствуйте. у меня куплены билеты: авиа из симферополя до воронежа и авто из воронежа в курск. Где будет ждать автбус в воронеже?
        q!: * ~автбус * $weight<+1>
        go!: /operator/goToOpeartor



    state: hotel
        # 4EX: Здравствуйте! Подскажите, подарочным сертификатом можно оплатить перелет и отель?
        q!: * ~отель * $weight<+1>
        go!: /operator/goToOpeartor



    state: newDesign
        q!: * {~новый ~дизайн} * $weight<+1>
        go!: /operator/goToOpeartor



    state: iSubmittedApplication
        # 4EX: Я сделала заявку на обмен билета на новую дату. Хотела бы проверить правильность изменений
        # 4EX: Здравствуйте! Я подавала заявку на возврат билета по заказу № 12262764-0016. Будет ли учтен при расчете суммы возврата тот факт, что в Казахстане с 16.03 введен режим ЧС, а границу Грузии и России закрыли?
        q!: * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*/подал*/подан*/подавал*) * ~заявка * $weight<+1>
        q!: * (~заявка/~заявление) * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*/подал*/подан*/подавал*) * $weight<+1>
        # 4EX: Добрый день. Я отправлял справку по болезни для вынужденного возврата авиабилетов. Хотел бы узнать ответ.
        q!: * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*/подал*/подан*/подавал*) * справк* * $weight<+1>
        #go!: /documentsFaqAns/tellMeYoutOrderNumb
        go!: /faq/coronaVirus



    state: whatsWithMyApplication
        # 4EX: Здравствуйте. Скажите пожалуйста паповоду вазврата что там
        q!: * $about $returnNoun $what2 [там]
        # 4EX: Добрый день! вы получили аннуляцию по  Заказ №16952770-0007?
        q!: * ($you/$youDat) (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали) [$my2] ($annulNoun/отмена/отмену) * $orderNumber
        q!: * ($you/$youDat) (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали) [$my2] ($annulNoun/отмена/отмену)
        go!: /faq/coronaVirus



    state: whenWillBeResponseToApplication
        # 4EX: Здравствуйте, когда можно ожидать ответ от авиакомпании по заявке на возврат авиа по заказу Заказ №10367441-0034?
        q!: * ответ* * (~заявка/~заявление) * $weight<+1>
        q!: * (~заявка/~заявление) * ответ* * $weight<+1>
        # 4EX: Добрый день. Оформила вчера заявки на возврат денежных средств за билеты. Когда они будут рассмотрены? Каков порядок?
        q!: * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*) * ~заявка * $whenAll *
        q!: * (~заявка/~заявление) * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*) * $whenAll *
        # 4EX: Хотелось бы узнать статус моей заявки на вынужденный возврат по заказу №17923715-0001. В каком она статусе и как скоро мне вернут денежные средства?
        q!: * $findOut * (статус*/решение) * (~заявка/~заявление) * $weight<+1>
        # 4EX: Здравствуйте, когда будет рассмотрена заявка на возврат билетов
        q!: * ($whenAll/срок/сроки) * (рассмотрен*/расмотрен*/рассмотрин*/расмотрин*/рассмотрят*/расмотрят*) (~заявка/~заявление) *
        #go!: /operator/goToOpeartor
        go!: /faq/coronaVirus



    state: iMadeReturnNoAnswer
        # 4EX: Я сделал возврат, но еще нет никакого ответа
        q!: * (сделал*/делал*/сделан*/оставил*/оставлял*/оставлен*/отправил*/отправлял*/отпрвлен*/оформил*/оформлял*/оформлен*) * ($returnNoun/~обмен) * {$absent [$oneWord] ответ*}
        go!: /faq/coronaVirus



    state: coutryCitizen
        # 4EX: здравствуйте, хочу забронировать билет на внутренний рейс для гражданина беларуссии. как правильно это сделать?
        q!: * ($ticket/$airplaneTicket/$flight) * (~гражданин/~гражданка) ($countryName/$iataAndRailway) *
        q!: * (~гражданин/~гражданка) ($countryName/$iataAndRailway) * ($ticket/$airplaneTicket/$flight) *
        go!: /operator/goToOpeartor



    state: pastVerbRoundtrip
        # 4EX: Здравствуйте, покупал билет на троих человек из мск в Краснодар и обратно. Можно ли вернуть билет только за двоих пассажиров?
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] *
        q!: * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] *
        q!: * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] *
        q!: * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway *
        q!: * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway *
        q!: * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$forAdults] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$roundTrip] *
        q!: * [$forAdults] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$roundTrip] *
        q!: * [$forAdults] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$to] $iataAndRailway *
        q!: * [$forAdults] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$to] $iataAndRailway *
        q!: * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] *
        q!: * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] *
        q!: * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * [$forAdults] * $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * [$forAdults] * $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * [$forAdults] * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$forAdults] * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * [$forAdults] * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$forAdults] * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$forAdults] * [$roundTrip] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * [$forAdults] * [$roundTrip] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * [$forAdults] * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$forAdults] * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] *
        q!: * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] *
        q!: * $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$roundTrip] *
        q!: * $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$roundTrip] *
        q!: * $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] *
        q!: * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] *
        q!: * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * [$forAdults] * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$forAdults] * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$forAdults] * [$roundTrip] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$roundTrip] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$roundTrip] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] * [$forAdults] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] * [$forAdults] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$roundTrip] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$roundTrip] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$to] $iataAndRailway * [$roundTrip] * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$forAdults] *
        q!: * $iataAndRailway * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$forAdults] *
        q!: * $iataAndRailway * [$roundTrip] * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$roundTrip] * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * $iataAndRailway * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$roundTrip] * [$forAdults] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] *
        q!: * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] *
        q!: * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway * [$roundTrip] * [$to] $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway *
        q!: * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway *
        q!: * [$roundTrip] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] *
        q!: * [$roundTrip] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] *
        q!: * [$roundTrip] * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$roundTrip] * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * [$to] $iataAndRailway *
        q!: * [$roundTrip] * [$forAdults] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * [$roundTrip] * [$forAdults] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * [$roundTrip] * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$roundTrip] * [$forAdults] * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * [$roundTrip] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] * [$to] $iataAndRailway *
        q!: * [$roundTrip] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] * [$to] $iataAndRailway *
        q!: * [$roundTrip] * $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway * [$forAdults] *
        q!: * [$roundTrip] * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway * [$forAdults] *
        q!: * [$roundTrip] * $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$to] $iataAndRailway *
        q!: * [$roundTrip] * $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$to] $iataAndRailway *
        q!: * [$roundTrip] * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$roundTrip] * $iataAndRailway * [$forAdults] * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * [$forAdults] *
        q!: * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * [$forAdults] *
        q!: * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * [$roundTrip] * $iataAndRailway * [$to] $iataAndRailway * [$forAdults] * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        go!: /operator/goToOpeartor



    state: pastVerb
        # 4EX: Здравствуйте. Купила билет до Екатеринбурга, распечатать не получается, файл повреждён. Помогите, пожалуйста.
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway *
        q!: * $issuedOrder * $iataAndRailway *
        q!: * $iataAndRailway * $issuedOrder *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        # 4EX: Вчера купил дочери билет на внутренний рейс , воспользовался автозаполнением. В электронном билете в графе отчество написанно слово "НЕТ". Следует ли беспокоится из за этого?
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway * ($ticket/$airplaneTicket/$flight) * $iataAndRailway *
        # 4EX: Добрый вечер, подскажите пожалуйста билет с Махачкалы в Ростов и обратно забронирован на Мугутдинову Ирайганат
        q!: * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        # 4EX: я купила авиабилет через ваш сервис из самары в сочи и обратно рейс туда выполняется победой, обратно авиакомпанией нордвинд
        # 4EX: Добрый день, купил билет москва казань, с7, домодедово, на почту билет не пришел
        # 4EX: Я заказал билет Тбилиси - Коломбо, при оплате заметил, что указано техническая посадка в Мале на один час
        # 4EX: Добрый день. У нас возникла ситуация оформили заказ пермь москва, аотом
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $issuedOrder *
        q!: * $issuedOrder * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        # 4EX: Здравствуйте, у меня куплен билет на сегодня в 13:55 из геленджика в Москву
        # 4EX: Здравствуйте, только что приобрел у вас билет на рейс кепервеем магадан на 23.03.2020 почему в билете стоит цена 30975,00, а списалось с карты 31222. где ещё 247 р.
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $issuedOrder * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $issuedOrder *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $issuedOrder * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * $issuedOrder * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        # 4EX: Я купил билет туда и обратно но обратно не успел там задержали салоёт и я обратно не успела
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $roundTrip *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $roundTrip * ($ticket/$airplaneTicket/$flight) *
        q!: * ($ticket/$airplaneTicket/$flight) * $roundTrip * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $roundTrip *
        q!: * $roundTrip * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        q!: * $roundTrip * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        go!: /operator/goToOpeartor



    state: expectingPriceChange
        # 4EX: добрый день!!! Ожидается ли снижение цен на авиабилеты Санкт-Петербург-Благовещенск на летнее время?
        q!: * (ожидать ли/ожидается/будет ли/ждать ли) * (~снидение/~снижение/~падение/~увеличение/~изменение/~изминение) $price * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * (ожидать ли/ожидается/будет ли/ждать ли) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~снидение/~снижение/~падение/~увеличение/~изменение/~изминение) $price *
        q!: * (ожидать ли/ожидается/будет ли/ждать ли) * $iataAndRailway::fromCode * (~снидение/~снижение/~падение/~увеличение/~изменение/~изминение) $price * $iataAndRailway::destCode *
        a: Цены и количество билетов постоянно меняются, поэтому предсказать заранее не представляется возможным. Рекомендумаем следить за результатами на сайте.



    state: disabledPeopleFullInfo
        # 4EX: Прошу заказать у авиаперевозчика сопровождение ребёнка-инвалида (2лет) до борта и встрече с борта самолёта по прибытию на рейс U178 21.08.2019 Москва-Симферополь.
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::destCode $iataAndRailway::fromCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        # 3 города
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$roundTrip] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * [($dateDig::dateDig2/$dateLetters::dateLetters2)] * $iataAndRailway::fromCode $iataAndRailway::destCode $iataAndRailway::fromCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        # 2 города
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] *
        q!: * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * [$roundTrip] * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode *
        q!: * [$roundTrip] * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * $iataAndRailway::destCode * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        q!: * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * $roundTrip * $iataAndRailway::destCode * $iataAndRailway::fromCode * ($dateDig::dateDig2/$dateLetters::dateLetters2) * (~инвалид/~колясочник/колясочниц*/дизабилити/disability/special needs/нетрудоспособ*/слепой/слепого/слепому/слепом/слепые/слепых/слепым/слкпой/слкпого/слкпому/слкпом/слкпые/слкпых/слкпым) *
        go!: /operator/goToOpeartor



    state: tariffsDiffFullInfo
        # 4EX: Добрый день! Рейс с Батуми до Красноярска 23.08.19. Чем отличается легкий-эконом от стандарт-эконом. Есть ли риски если один из рейсов отменять, что в этом случае делать
        q!: * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) (или/и/с) (эконом*/бизнес*) [$markQuestion]
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) (или/и/с) (эконом*/бизнес*) [$markQuestion]
        q!: * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * чем * ($dateDig/$dateLetters/$thatDay) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * ($dateDig/$dateLetters/$thatDay) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        go!: /faq/tariffsDiff



    state: tariffsDiff
        # 4EX: Чем отличается легкий-эконом от стандарт-эконом. Есть ли риски если один из рейсов отменять, что в этом случае делать
        q!: * (эконом*/бизнес*) (или/и/с)  (эконом*/бизнес*) [$markQuestion]
        q!: * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        q!: * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) * (эконом*/бизнес*) *
        q!: * (эконом*/бизнес*) * чем * (отлич*/отлеч*/отдича*/отичает*/отичия/отичие/различ*) * (эконом*/бизнес*) *
        go!: /operator/goToOpeartor



    state: whereIsPaymentButton
        # 4EX: Здравствуйте, не могу понять как оплатить билет. Не вижу кнопки
        q!: * {($ticket/$airplaneTicket) ($paymentAll/$payInf)} * $ne вижу (кнпок*/~кнопка) *
        q!: * $ne вижу (кнпок*/~кнопка) * {($ticket/$airplaneTicket) ($paymentAll/$payInf)} *
        # 4EX: где кнопка "оплатить билет"?
        q!: * $where (кнпок*/~кнопка) * {($ticket/$airplaneTicket) ($paymentAll/$payInf)} *
        q!: * {($ticket/$airplaneTicket) ($paymentAll/$payInf)} * $where (кнпок*/~кнопка) *
        a: Чтобы оплатить билеты, в личном кабинете выберите раздел «Заказы»: https://www.ozon.travel/my. Вы увидите зеленую кнопку «Выбрать способ оплаты».



    state: flightStatus
        # 4EX: Приобрели билет на вашем сайте. На вторник 16.03. Пн. Рейс номер dp832 Хотим уточнить статус рейса. Нет ли отмены или переноса. Спасибо
        q!: * (статус*/решение) [$about] ($flight/~рейс) * ($exist/$absent) [ли] (~отмена/~перенос) *
        # 4EX: Говорят что с завтрашнего дня закроют границу в Узбекистане.  Мы купили билет на 26 марта  . У вас есть  какая-нибудь информация об этом?
        q!: * {(закрыл*/закроют*) границ*} * ($exist/$absent) * $information *
        # 4EX: Сегодня закрыли все рейсы с Узбекистана значить деньги за билеты вернут 100%?
        # 4EX: Если отменят перелеты в Корею на апрель, я верну полную стоимость билетов?
        q!: * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * ($flight/~рейс) * $countryName * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * ($flight/~рейс) * $countryName * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * ($flight/~рейс) * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * $countryName * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * ($flight/~рейс) * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * $countryName * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * $countryName * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * ($flight/~рейс) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $countryName * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * ($flight/~рейс) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * $countryName * ($flight/~рейс) * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * $countryName * ($flight/~рейс) * (закрыл*/закроют*/отменяет*/отменяют*/$cancelFut/$cancelPast) * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        # 4EX: Границу закрыли всю стоимость мне вернут?
        q!: * {(закрыл*/закроют*) границ*} * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return *
        q!: * {(закрыл*/закроют*) границ*} * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) *
        q!: * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * $return * {(закрыл*/закроют*) границ*} *
        q!: * $return * (сумму/суму/сумма/сума/$money/[денеж*] средств*/$price) * {(закрыл*/закроют*) границ*} *
        # 4EX: Считается ли сдача билета вынужденной (Симферополь Москва), если отмены  дальнейшие перелеты до Америки.
        q!: * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} * (закрыл*/закроют*/отмен*) * ($flight/~рейс) * $countryName *
        q!: * (закрыл*/закроют*/отмен*) * ($flight/~рейс) * $countryName * {($annulNoun/$return/отмена/отмены/сдача) ([$my2/$ruSvoi] ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс))} *
        # 4EX: В новостях сказали, что Молдавия закрывает границы
        q!: * $countryName * {(закрыл*/закроют*/закрывает) границ*} *
        # 4EX: Ташкент Сочи рейс отменяется???
        q!: * $iataAndRailway * $iataAndRailway * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($flight/~рейс) *
        q!: * $iataAndRailway * $iataAndRailway * ($flight/~рейс) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) *
        # 4EX: Наш рейс отменяется ???
        q!: * ($flight/~рейс) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) *
        q!: * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($flight/~рейс) *
        # 4EX: Эйр франц отменяет рейсы из Москвы есть информация?добрый день!
        q!: * ($flight/~рейс) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($exist/$absent) * $information *
        q!: * ($flight/~рейс) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * $information * ($exist/$absent) *
        q!: * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($flight/~рейс) * ($exist/$absent) * $information *
        q!: * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($flight/~рейс) * $information * ($exist/$absent) *
        # 4EX: Добрый день. Подскажите, рейс Уральских авиалиний на 5 мая номер U6 845 отменён?
        q!: * (подскажи*/скажи*/поясни*/объясни*) * ($flight/~рейс) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) *
        q!: * (подскажи*/скажи*/поясни*/объясни*) * (закрыл*/закроют*/$cancelPast/$cancelFut/отменяет*/отменяют*) * ($flight/~рейс) *
        a: Пожалуйста, следите за информацией, которую предоставляют авиакомпании. Мы собрали актуальную информацию здесь: https://www.ozon.travel/help/avia/coronavirus_news_from_airlines



# 4EX: Здравствуйте Как регистрироватся онлайн
# 4EX: Как я могу зарегистрироваться на рейс онлайн и выбрать место?
# 4EX: Как забронировать билеты на 2 человек миста рядом
# 4EX: а регистарция электронная за которую вы говорили как ее сделать или она автоматически?
# 4EX: ЗДРАВСТВУЙТЕ. скажите пожалуйста как пройти онлайн регистпацию
#a: Вы можете пройти на сайт авиакомпании, осуществляющей перелет, и выбрать онлайн регистрациию. Далее указать данные из маршрутной квитанции и получить (скачать или распечатать) посадочный талон.
#a: Как правило, онлайн регистрация открывается за 24 часа до вылета рейса.

# 4EX: А вообще приходит смс оповещения о том что бы забронировать место?

