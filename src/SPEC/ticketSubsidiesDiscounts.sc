theme: /ticketSubsidiesDiscounts



#    state: discountRailwayTickets4SchoolKids
#        # 4EX: Здравствуйте для школьников есть скидки на жд?
#        q!: * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * ($train/$railwayTicket) * школьни* *
#        q!: * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * школьни* * ($train/$railwayTicket) *
#        q!: * школьни* * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * ($train/$railwayTicket) *
#        q!: * школьни* * ($train/$railwayTicket) * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) *
#        q!: * ($train/$railwayTicket) * школьни* * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) *
#        q!: * ($train/$railwayTicket) * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * школьни* *
#        a: На нашем сайте льготные билеты для школьников не предоставляются, их можно купить только в кассах при наличии соответствующей справки.



    state: specialOffers
        # 4EX: скидки
        q!: (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) [$markQuestion]
        # 4EX: Какой нибудь акции есть
        # 4EX: У вас ест скидка ?
        q!: * (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * ($exist/ест) [$markQuestion]
        q!: * ($exist/ест) * (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) [$markQuestion]
        # 4EX: Скажите пож говорят иногда бывают акции на билеты
        q!: * (бывает/бывают) [ли] (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) [на/для] ($ticket/$airplaneTicket/$flight) *
        q!: * (бывает/бывают) [ли] [на/для] ($ticket/$airplaneTicket/$flight) (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) *
        # 4EX: Как получить скидку
        q!: * $how * {*получить $discount} [$markQuestion]
        q!: [$beginningWords] [$how/$want/$need2/$canSynPossible [ли] [я/йа]] {$oneWord ($discount/акци*/спецпредложен*/спецприедлжен*/спецкпредложен*/спец* ~предложние)} [$markQuestion]
        # 4EX: Когда акции слишком дорого
        q!: {$when (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение))} * дорого [$markQuestion]
        q!: дорого * {$when (~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение))} [$markQuestion]
        a: Все актуальные акции и спецпредложения вы можете найти здесь: https://www.ozon.travel/offers.



    state: promoCode
        # 4EX: ПРОМО КОД
        q!: $promo
        # 4EX: могу я воспользоваться промо кодом, который мне отправляли в январе 2019, и куда его надо указать при оформлении билетов
        q!: * ($how/$want/$need2/$canSynPossible) * ($use/применить/в бить/вбить/ввести/внести/вводить/вписать/напечатать/написать) * $promo *
        q!: * ($how/$want/$need2/$canSynPossible) * $promo * ($use/применить/в бить/вбить/ввести/внести/вводить/вписать/напечатать/написать) *
        # 4EX: Как зарегистрировать промокод от Макдоналдс на 500 рублей на первый заказ авиабилетов от 5000 рублей?
        # 4EX: Добрый день! Покупаю у Вас авиабилеты. Есть промокод на скидку в 500 р. от Макданальдс. Не могу найти поле, куда вводится промокод?
        q!: * ($promo/$discount) * (мак/маке/макдак*/макдачн*/макдональдс*/макдональдз*/макдоналдс*/макдоналдз*/мкдональдс*/мкдональдз*/мкдоналдс*/мкдоналдз*/мак (дональдс*/дональдз*/доналдс*/доналдз*)/madonalds/mcdonalds/mac donalds/mc donalds) *
        q!: * (мак/маке/макдак*/макдачн*/макдональдс*/макдональдз*/макдоналдс*/макдоналдз*/мкдональдс*/мкдональдз*/мкдоналдс*/мкдоналдз*/мак (дональдс*/дональдз*/доналдс*/доналдз*)/madonalds/mcdonalds/mac donalds/mc donalds/Макданальдс*) * ($promo/$discount) *
        a: Промокод можно будет ввести при оплате вашего первого заказа. Поле для ввода располагается либо посередине страницы оформления заказа, либо справа снизу. Поищите надпись «ВВЕСТИ ПРОМОКОД».



    state: discountTickets4Kids
        # 4EX: Добрый день. Подскажите, предоставляется скидка на билет школьникам (12лет) при наличии справки
        q!: * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * ($ticket/$airplaneTicket/$flight) * (школьни*/~ребенок/~ребёнок) *
        # 4EX: Здравствуйте для школьников есть льготы?
        q!: * (школьни*/~ребенок/~ребёнок) * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) *
        q!: * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * (школьни*/~ребенок/~ребёнок) *
        a: Обычно детские билеты продаются по специальным ценам. Чтобы узнать, есть ли детские тарифы по вашему маршруту: \n• На странице поиска билетов укажите маршрут и дату поездки \n• При выборе количества пассажиров укажите ребенка, нажав на специальный значок \nНа странице оформления заказа будет показана цена на детский билет.



    state: discountTickets4DisabledPeople
        # 4EX: Здравствуйте ,есть ли скидка ребенку инвалиду?
        q!: * ($exist/$no2) [ли] [у вас] (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * инвалид* *
        q!: * ($exist/$no2) * инвалид* * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) [$markQuestion]
        a: К сожалению, через наш сайт оформить такой билет со скидкой нельзя. Вы можете это сделать только напрямую в кассах авиакомпании.



    state: discountTickets4Elderly
        # 4EX: Здравствуйте, есть ли скидки на билеты для пенсионеров
        # 4EX: если я пенсионерка, как мне заказать билет со скидкой?
        # 4EX: У вас есть скидки для пенсионеров старше 60 лет?
        q!: * пенсион* * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) *
        q!: * (льгот*/~акция/$discount/~спецпредложение/спец (~предложение/~предлоэение)) * пенсион* *
        a: На нашем сайте льготные билеты для пенсионеров не предоставляются, их можно купить только в кассах при наличии пенсионного удостоверения.



    state: howToSubscribeToNewsletter
        # 4EX: получать сообщения об акциях
        # 4EX: как получать уведомления на скидки и акции по авиабилетам?
        q!: * {(получать/палучать/палучять/получять/полусать) ($message/$notification/$sms/$smsInforming)} * (акци*/$discount/~предложение/~спецпредложение) *
        q!: * (акци*/$discount/~предложение/~спецпредложение) * {(получать/палучать/палучять/получять/полусать) ($message/$notification/$sms/$smsInforming)} *
        q!: * (подписатьс*/подписатс*) * ($message/$notification/$sms/$smsInforming) * (акци*/$discount/~предложение/~спецпредложение) *
        q!: * (акци*/$discount/~предложение/~спецпредложение) * (подписатьс*/подписатс*) * ($message/$notification/$sms/$smsInforming) *
        q!: * (акци*/$discount/~предложение/~спецпредложение) * ($message/$notification/$sms/$smsInforming) * (подписатьс*/подписатс*) *
        a: Чтобы подписаться на рассылку, войдите в Личный кабинет, раздел «Управление подписками» (https://www.ozon.travel/my/subscribe), найдите пункт «Специальные акции, скидки и выгодные предложения» и поставьте галочку напротив.



    state: howToCancelSubscription
        # 4EX: Здравствуйте, подскажите пожалуйста, как отписать от рассылки озон тревел ?
        # 4EX: Прошу отписать меня от рассылок
        # 4EX: не получается отписаться от вашей расписки. Отключите, пожалуйста
        q!: * {($deleteAllExceptPast/отписать) * ($ruRassylka/расписк*)} *
        q!: * ($want/$need2/сделай*/делай) [так] чтоб* {(не было/удалил*/исчезл*/убил*/убрал*) * ($ruRassylka/расписк*)} *
        q!: * ($dontWant/$needNot) [$meDat][больше/болше][$morph<П>][$morph<МС-П>] ($ruRassylka/расписк*) *
        q!: * {$activatePast * ($deleteAllExceptPast/отписать) * ($ruRassylka/расписк*)} *
        q!: * {$activatePast * (($dontWant/$needNot) [$meDat][больше/болше][$morph<П>][$morph<МС-П>] ($ruRassylka/расписк*))} *
        q!: * $activatePast * {($deleteAllExceptPast/отписать) * ($ruRassylka/расписк*) } *
        q!: * $fedUpWith [$meDat] [$morph<П>][$morph<МС-П>] ($ruRassylka/расписк*) *
        q!: * ($ruRassylka/расписк*) [$meDat] [$morph<Н>] [$meDat] $fedUpWith *
        # 4EX: У меня вопрос: Почему Вы присылаете письма, когда я не подписан на вашу рассылку???
        q!: * (присылаете/присылаите/шлете/шлёте/приходят/приходит/придят/пирходят/призодят/проходят/поступают/получаю) (письм*/$email2) * $ne ($subscribePast/$subscribePastPas) * ($ruRassylka/расписк*) *
        q!: * $ne ($subscribePast/$subscribePastPas) * ($ruRassylka/расписк*) * (присылаете/присылаите/шлете/шлёте/приходят/приходит/придят/пирходят/призодят/проходят/поступают/получаю) (письм*/$email2) *
        # 4EX: Как отписаться от ваших электронных писем?
        q!: * ($deleteAllExceptPast/отписать) * (письм*/$email2) *
        q!: * (письм*/$email2) * ($deleteAllExceptPast/отписать) *
        a: В наших письмах обычно мы отправляем самые выгодные предложения. Но если вы действительно хотите от них отписаться, войдите в Личный кабинет, раздел «Управление подписками» (https://www.ozon.travel/my/subscribe) и выберите удобные вам параметры.
        a: Если вам приходят письма не про путешествия, скорее всего, вы хотите отписаться от рассылок Ozon.ru. Для этого войдите в Личный кабинет Ozon.ru и отпишитесь на этой странице: https://www.ozon.ru/context/mypersonal



    state: howToCancelSms
        # 4EX: Как отключить смс оповищения с озона
        q!: * $deleteAllExceptPast * ($sms/$smsInforming) * (озон*/ozon/$ozonTravel) *
        q!: * ($sms/$smsInforming) * $deleteAllExceptPast * (озон*/ozon/$ozonTravel) *
        q!: * (озон*/ozon/$ozonTravel) * ($sms/$smsInforming) * $deleteAllExceptPast *
        q!: * (озон*/ozon/$ozonTravel) * $deleteAllExceptPast * ($sms/$smsInforming) *
        a: Мы отправляем смс только с важной информацией, например, о статусе вашего бронирования или изменениях в рейсе. Если вы уверены, что хотите отписаться от смс, войдите в Личный кабинет, раздел «Управление подписками» (https://www.ozon.travel/my/subscribe), найдите пункт «СМС-оповещение» и снимите оттуда галочку.
        a: Если вы получаете смс не о путешествиях, скорее всего, вы хотите отписаться от сообщений Ozon.ru. Для этого перейдите по ссылке https://www.ozon.ru/context/mysms/ и следуйте инструкции.



    state: subsidizedTickets
        # 4EX: Добрый день. Подскажите, возможно ли забронировать сейчас билеты с субсидиями в Крым ?
        # 4EX: Доброе утро, как оформить билет с субсидий пенсионеру
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * {($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} *
        q!: * (~субсидия/субсиид*) *
        # 4EX: Мне нужны билеты с субсидий
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight) (субсидирован*/субседирован*)} *
        # 4EX: Как купить субсидированный билет
        q!: * {($buyInf/$buyNoun) * ($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} *
        q!: * {($buyInf/$buyNoun) * ($ticket/$airplaneTicket/$flight) (субсидирован*/субседирован*)} *
        # 4EX: Здравствуйте,а есть субсидии ?
        # 4EX: Здравствуйте! Есть субсидированный билет ы
        q!: * {([$exist] [ли]) ((~субсидия/субсиид*)/с (~субсидия/субсиид*)/(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight))} *
        # 4EX: Найти билеты с субсидиями
        q!: * {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} *
        # 4EX: наличие билетов с субсидиями
        q!: * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * (наличие/наличее) {($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * {($ticket/$airplaneTicket/$flight) (с (~субсидия/субсиид*))} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        a: Субсидированные билеты на нашем сайте не продаются, потому что для их покупки нужно предъявить оригинал документа, дающий право на льготу. Такие билеты вы можете купить только напрямую у авиакомпании или в специальных кассах.



    state: subsidizedTicketsFromDest
        # 4EX: Здравствуйте, на авиакомпанию якутия есть субсидированные авиабилеты с санкт-петербурга в якутск, 1 пенсионер и ребенок 5 лет
        # 4EX: Когда появятся субседированные билеты на рейс Магадан-Санкт-Петербург

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode *
        # 4EX: нужны субсидированные билеты москва - питер
        q!: * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Хочу купить субсидированные билеты москва - питер
        q!: * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Есть субсидированные биоеты москва - питер?
        q!: ([$exist] [ли]) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)}

        q!: * {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: наличие субсидированных билетов москва - питер
        q!: * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        # 4EX: цена субсидированных билетов москва - питер
        q!: * $price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: сколкьо стоят субсидированные билеты мск питер
        q!: * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        go!: /ticketSubsidiesDiscounts/subsidizedTickets


    state: subsidizedTicketsFullInfo
        # 4EX: Здравствуйте,  есть ли субсидированные билеты с Владиаостока в Екатеринбург или Новосибирск. На 27 мая
        # 4EX: Есть субсидированные билеты южно-сахалинск-хабаровск и обратно?
        # 4EX: Как воспользоваться субсидией на перелет Хабаровск-москва-хабаровск для многодетных от компании Аэрофлот?  Или субсидированные билеты только лично преобретаются?

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($dateDig/$dateLetters/$thatDay) *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$cityPreName] $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode *
        # 4EX: Купить субсидированный билет из краснодара в москву 12 октября
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($to [$cityPreName] $iataAndRailway::destCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($to [$cityPreName] $iataAndRailway::destCode) *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode *
        # 4EX: Купить билет с субсидиями в москву из краснодара 12 октября
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($dateDig/$dateLetters/$thatDay) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode *
        # 4EX: Краснодар купить субседированные бидеты из москвы 12 октября
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$cityPreName] $iataAndRailway::destCode *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ([на] ($dateDig/$dateLetters/$thatDay)) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * ($from [$cityPreName] $iataAndRailway::fromCode) *

        q!: * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        # 4EX: Хочу купить субсидированые билеты москва - питер на завтра
        q!: * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {$buyAllExceptPast * (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Есть субсидированые биоеты москва - питер на завтра?
        q!: {([$exist] [ли]) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: {([$exist] [ли]) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {([$exist] [ли]) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) {([$exist] [ли]) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Найти субсидированные билеты москва - питер на завтра
        q!: * {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * {($lookForV/$lookForN) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *

        q!: * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (наличие/наличее) {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *

        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * [на] ($dateDig/$dateLetters/$thatDay) *
        # 4EX: цена субседированных билетов москва - питер на завтра
        q!: * $price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *$price [на] {(субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        # 4EX: сколкьо стоят субсидированные билеты мск питер на завтра
        q!: * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) (субсидирован*/субседирован*) ($ticket/$airplaneTicket/$flight)} *
        go!: /ticketSubsidiesDiscounts/subsidizedTickets



    state: ticketsWithSubsidiesFromDest
        # 4EX: москва - питер субсидия
        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *
        # 4EX: нужны билеты с субсидиями москва - питер
        q!: * (~субсидия/субсиид*) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * {($want/$need2) ($ticket/$airplaneTicket/$flight)} *

        # 4EX: Хочу купить билеты с субсидиями москва - питер
        q!: * (~субсидия/субсиид*) * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * {$buyAllExceptPast * ($ticket/$airplaneTicket/$flight)} *

        # 4EX: Есть биоеты с субсидиями москва - питер?
        q!: * (~субсидия/субсиид*) * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode
        q!: {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) *
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)}
        q!: [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * {([$exist] [ли]) ($ticket/$airplaneTicket/$flight)}

        # 4EX: Найти билеты москва - питер с субсидиями
        q!: * (~субсидия/субсиид*) * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} *

        # 4EX: билеты в наличие москва - питер на завтра субсидия
        q!: * (~субсидия/субсиид*) * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * (наличие/наличее) * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (наличие/наличее) ($ticket/$airplaneTicket/$flight) [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * (наличие/наличее) ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (наличие/наличее) * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) *

        q!: * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * (в (наличие/наличее/наличии)/вначаличие/вналичее/вналичии) *

        # 4EX: цена билетов москва - питер субсидии
        q!: * (~субсидия/субсиид*) * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * $price * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $price [на] ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * $price [на] ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $price * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) *

        # 4EX: сколкьо стоят билеты мск питер с субсидией
        q!: * (~субсидия/субсиид*) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * {($howMuch $cost/почем/почём) * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * {($howMuch $cost/почем/почём) ($ticket/$airplaneTicket/$flight)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($howMuch $cost/почем/почём) * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight)} *
        go!: /ticketSubsidiesDiscounts/subsidizedTickets


    state: ticketsWithSubsidiesFullInfo
        # 4EX: наличие билетов с субсидией москва - питер на завтра
        # 4EX: Нужен билет термез москва на завтра 10 января субсидия
        # 4EX: Авиабилет на рейс Москва-Хабаровск 08.01.19. Субсидия
        # 4EX: Краснодар Москва 12 октября с субсидиями
        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) *

        q!: * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * (~субсидия/субсиид*) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * ($dateDig/$dateLetters/$thatDay)*(~субсидия/субсиид*) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        # 4EX: Смотрю билет в москву из краснодара 12 октября, а есть с субсидиями?
        q!: * (~субсидия/субсиид*) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * (~субсидия/субсиид*) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * (~субсидия/субсиид*) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) *
        q!: * ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * $iataAndRailway::fromCode *

        # 4EX: Краснодар Купил бидеты из москвы 12 октября с субсидиями
        q!: * (~субсидия/субсиид*) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::destCode * (~субсидия/субсиид*) * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * ([на] ($dateDig/$dateLetters/$thatDay)) *


        # 4EX: Нужен билетс субсиидей термез москва на завтра 10 января
        q!: * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) *
        q!: * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * ($ticket/$airplaneTicket/$flight) * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) *

        q!: * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) *
        q!: * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) * ($ticket/$airplaneTicket/$flight) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) *

        q!: * (~субсидия/субсиид*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) * (~субсидия/субсиид*) *
        q!: * $iataAndRailway::fromCode * (~субсидия/субсиид*) * $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (~субсидия/субсиид*) * ($ticket/$airplaneTicket/$flight) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket/$flight) * (~субсидия/субсиид*) * ($dateDig/$dateLetters/$thatDay) *
        go!: /ticketSubsidiesDiscounts/subsidizedTickets