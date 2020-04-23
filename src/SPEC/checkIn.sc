theme: /checkIn


    state: planeSeat
        # 4EX: как выбрать место?
        # 4EX: подскажите пожалуйста как и когда я могу выбрать места?
        q!: [$beginningWords] [$oneWord] [$please] $how [и $whenAll] [(я/йа) $canSg1/$possiblePredic [ли] [$meDat]] {$chooseInf (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел)} [$markQuestion]
        # 4EX: я могу выбрать место?
        q!: [$beginningWords] ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic [ли] [$meDat]/$ruNelzya [$meDat]) {$chooseInf (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел)} [$markQuestion]
        # 4EX: Подскажите, как выбрать место в самолёте.
        q!: * (выбор*/$chooseInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * ((в/на) (самолет*/самолёт*)/по $airplaneTicket/на борту/в салон*) *
        q!: * ((в/на) (самолет*/самолёт*)/по $airplaneTicket/на борту/в салон*) * ($chooseInf/выбор*) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) *
        # 4EX: Ясно. Еще такой вопрос, выбор места я не могу произвести?
        q!: * выбор* * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * (сделать/зделать/совершить/саверить/производить/произвести/произвезти) [$markQuestion]
        q!: * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * (сделать/зделать/совершить/саверить/производить/произвести/произвезти) * ($chooseInf/выбор*) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) [$markQuestion]
        # 4EX: То есть у вас заранее забронировать (купить) место нельзя?
        q!: * заранее (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) *
        q!: * (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * заранее * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) *
        q!: * (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * заранее *
        q!: * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * заранее (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) [$markQuestion]
        q!: * заранее * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) *
        q!: * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * (*бронировать/*бронить/$buyInf/$payInf) * заранее * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) *
        q!: * ((я/йа) [$ne] $canSg1/$canSg1 [ли] (я/йа)/$possiblePredic/$ruNelzya) * (*бронировать/*бронить/$buyInf/$payInf) * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * заранее [$markQuestion]
        # 4EX: подскажите как выбрать место на заказе№10618193-003
        q!: * (выбор*/$chooseInf) (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) [на/по] заказ* *
        q!: [на/по] заказ* * (выбор*/$chooseInf) (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) [$markQuestion]
        # 4EX: День добрый, как узнать какие места в самолёте остались ?
        q!: * (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * {((в/на) (самолет*/самолёт*)/по $airplaneTicket/на борту/в салон*) ($isLeft/осталис*)} *
        q!: * ((в/на) (самолет*/самолёт*)/по $airplaneTicket/на борту/в салон*) {(место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) ($isLeft/осталис*)} *
        # 4EX: а выбор мест уже на сайте
        q!: [$beginningWords] (выбор*/$chooseInf) (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * на $website [$oneWord] [$markQuestion]
        # 4EX: КУПИЛИ БИЛЕТ . ПОЧЕМУ НА ЭЛЕКТРОННОМ БИЛЕТЕ НЕТ НОМЕРОВ МЕСТА ?
        q!: * $ruPochemu на [$my2] [электрон*] ($ticket/$airplaneTicket) (нет*/$ne (вижу/видно/обозначен*/указан*)/неть/невижу/невидно/необозначен*/неуказан*) [~номер] (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) *
        q!: * $ruPochemu (нет*/$ne (вижу/видно/обозначен*/указан*)/неть/невижу/невидно/необозначен*/неуказан*) [~номер] (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел) * на [$my2] [электрон*] ($ticket/$airplaneTicket) *
        # 4EX: Могу ли я узнать своё место
        q!: [$beginningWords] ($how/$want/$need2/$canSg1 [ли] [я/йа] / (я/йа) $canSg1/$possiblePredic) $checkFindOut {[$my2/$ruSvoi] (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел)} [$markQuestion]
        q!: [$beginningWords] ($how/$want/$need2/$canSg1 [ли] [я/йа] / (я/йа) $canSg1/$possiblePredic) {[$my2/$ruSvoi] (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел)} $checkFindOut [$markQuestion]
        # 4EX: Добрый день! Подскажите, мы приобрели авиабилеты, как осуществить выбор мест? Тем более оzon travel осуществляет эту процедуру бесплатно?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {(пройти/проходит*/совершить/сделать/делать/осуществить) ((выбор*/$chooseInf) (место/места/мест/сидение/сидения/сидений/кресло/кресла/кресел))} *

        a: Если вы не оплатили место при покупке билета, вы сможете узнать его при онлайн-регистрации в мобильном приложении или на сайте (обычно за 24 часа до вылета) или на стойке в аэропорту (за 2-3 часа до вылета).
        a: А ещё в приложении вы можете включить бесплатную авторегистрацию. Просто активируйте услугу в личном кабинете, если она доступна для вашего рейса. Укажите предпочтения по местам, мы сами зарегистрируем вас на рейс и пришлем посадочные.



    state: checkInForFlight
        # 4EX: Как зарегистрироваться
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) {[$meDat] $register} [$markQuestion]
        # 4EX: Я могу регистрироваться на рейс и выбрать место?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) [$meDat] $register * ($flight/рейс*) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($flight/рейс*) * $register *
        # 4EX: как выбрать место на регистрации?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$chooseInf мест*} * $register *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $register * {$chooseInf мест*} *
        # 4EX: Здравствуйте. Как узнать места и как пройти регистрацию?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {(пройти/проходит*/совершить/сделать/делать/осуществить) ~регистрация} [$markQuestion]

        a: В мобильном приложении вы можете посмотреть, доступна ли по вашему рейсу авторегистрация. Перейдите в список заказов и активируйте услугу совершенно бесплатно!
        a: Или же после оформления и оплаты заказа вы сможете самостоятельно зарегистрироваться на рейс на сайте авиакомпании. При желании вы можете выбрать место. Онлайн-регистрацию на рейс можно пройти на сайте авиакомпании за 24 часа до вылета самолета.



    state: autoCheckIn
        # 4EX: Как провести автоматическую регестрацию
        # 4EX: Здравствуйте. Подскажите пожалуйста как сделать авторегистрацию на рейс?
        # 4EX: Как мне сделать автомотическую регистрацию
        # 4EX: Доброго времени суток, я купила билет, как можно включить автоматическую регистрацию?
        # 4EX: как сделать авторегистрацию
        # 4EX: Где найти автоматическую регистрацию на рейс?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа])/(я/йа) $canSg1/$possiblePredic) * {($issueVerbInf/$activate/$plugging/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/включить/воспользоват*/пользовать*/пользоватся) {[бесплатн*] (авторегистр*/авторегестр*/авторигестр*/автомат* (~регистрация/регестрац*/ригистрац*/ригестрац*))} } [на/$about/$for/по/в/во/к] [$my2/$ruSvoi/наш*] [$airplaneTicketAll/~зоказ/~заказ] [$markQuestion]
        # 4EX: Здравствуйте. Как бесплатно оформить регистрацию?
        # 4EX: Как воспользоваться бесплатной регистрацией?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа])/(я/йа) $canSg1/$possiblePredic) * {($issueVerbInf/$activate/$plugging/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/включить/воспользоват*/пользовать*/пользоватся) {[услуг*] (~регистрация/регестрац*/ригистрац*/ригестрац*) [бесплатн*]} ([на/$about/$for/по/в/во/к] [$my2/$ruSvoi/наш*] [$airplaneTicketAll/~зоказ/~заказ])} [$markQuestion]
        # 4EX: Как зарегистрироваться через приложение?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) $registerInf (через/с пом*/в) [мобил*] ~приложение [$markQuestion]
        # 4EX: Как мне подключить мой билет к онлайн регистрации
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($activate/$plugging/найти/включить/воспользоват*/пользовать*/пользоватся) {[$my2/$ruSvoi/наш*] ($airplaneTicketAll/~зоказ/~заказ)} [на/$about/$for/по/в/во/к] [онлайн/анлайн/он лайн] (~регистрация/регестрац*/ригистрац*/ригестрац*) [$markQuestion]
        # 4EX: Здравствуйте! Как активировать услугу он-лайн регистрации?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($activate/$plugging/найти/включить/воспользоват*/пользовать*/пользоватся) услуг* [онлайн/анлайн/он лайн] (~регистрация/регестрац*/ригистрац*/ригестрац*) [$markQuestion]
        # 4EX: Здравствуйте! Я купил электронный авиабилет. Как у Вас оформить он-лайн регистрацию на рейс?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerbInf/$activate/$plugging/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/включить/воспользоват*/пользовать*/пользоватся) (онлайн/анлайн/он лайн) (~регистрация/регестрац*/ригистрац*/ригестрац*) [на/$about/$for/по/в/во/к] [$my2/$ruSvoi/наш*] [$airplaneTicketAll/~зоказ/~заказ] [$markQuestion]
        # 4EX: Как воспользоваться бесплатной услугой Регистрация на рейс?
        q!: * ($how/$want/$where/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerbInf/$activate/$plugging/найти/пройти/проходит*/провести/совершить/сделать/делать/осуществить/включить/воспользоват*/пользовать*/пользоватся) бесплатн* услуг* (~регистрация/регестрац*/ригистрац*/ригестрац*) [на/$about/$for/по/в/во/к] [$my2/$ruSvoi/наш*] [$airplaneTicketAll/~зоказ/~заказ] [$markQuestion]

        a: Услуга авторегистрации доступна только в мобильном приложении. Если у вас уже оформлен заказ, перейдите в список заказов и активируйте услугу совершенно бесплатно! \nИли начните оформлять заказ, нажмите «Забронировать» и на следующем этапе можно будет выбрать авторегистрацию, если она доступна по вашему рейсу.



    state: IsThereAutoCheckIn
        # 4EX: Есть ли автоматически регистрация на наш рейс
        q!: [$beginningWords] {([$exist/доступн*] [ли]) {[бесплатн*] (авторегистр*/авторегестр*/авторигестр*/автомат* (~регистрация/регестрац*/ригистрац*/ригестрац*))} } [$markQuestion]
        q!: [$beginningWords] {([$exist/доступн*] [ли]) {[бесплатн*] (авторегистр*/авторегестр*/авторигестр*/автомат* (~регистрация/регестрац*/ригистрац*/ригестрац*))} } [на/$about/$for/по/в/во/к] {[$my2/$ruSvoi/наш*] ($airplaneTicketAll/~зоказ/~заказ)} [$markQuestion]
        # 4EX: Добрый день! Подскажите, как воспользоваться услугой Бесплатная регистрация на рейс? И доступна ли она к нашим заказам?
        q!: * {[услуг*] (~регистрация/регестрац*/ригистрац*/ригестрац*) [бесплатн*]} * ($exist/доступн*) ли [она/они] [на/$about/$for/по/в/во/к] {[$my2/$ruSvoi/наш*] ($airplaneTicketAll/~зоказ/~заказ)} [$markQuestion]
        q!: * {[услуг*] (~регистрация/регестрац*/ригистрац*/ригестрац*) [бесплатн*]} * ($exist/доступн*) [ли] (она/они) [на/$about/$for/по/в/во/к] {[$my2/$ruSvoi/наш*] ($airplaneTicketAll/~зоказ/~заказ)} [$markQuestion]
        # 4EX: Когда покупал билеты было написано, что бонусом бесплатная регистрация. Как я могу проверить доступна она или нет?
        q!: * {[услуг*] (~регистрация/регестрац*/ригистрац*/ригестрац*) [бесплатн*]} * ($exist/доступн*) ли [она/они] [или] [нет] [$markQuestion]
        q!: * {[услуг*] (~регистрация/регестрац*/ригистрац*/ригестрац*) [бесплатн*]} * ($exist/доступн*) [ли] (она/они) [или] [нет] [$markQuestion]
        a: Услуга авторегистрации доступна только в мобильном приложении. Чтобы узнать, доступна ли авторегистрация для вашего рейса, перейдите в список заказов и посмотрите, можно ли активировать услугу.




    state: checkInForFlightFullInfo
        # 4EX: Я могу регистрироваться на рейс и выбрать место? Если я лечу из Санкт-Петербурга в Челябинск 23.10. В 1:05, авиакомпанией ‘победа’.
        q!: * ($flight/рейс*) * $register * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($flight/рейс*) * $register * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * ($flight/рейс*) * $register * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($flight/рейс*) * $register * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($flight/рейс*) * $register * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * ($flight/рейс*) * $register * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($flight/рейс*) * $register * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register *
        q!: * ($flight/рейс*) * $register * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ($flight/рейс*) * $register * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($flight/рейс*) * $register * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) * ($flight/рейс*) * $register *

        q!: * $register * ($flight/рейс*) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $register * ($flight/рейс*) * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * $register * ($flight/рейс*) * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $register * ($flight/рейс*) * [$cityPreName] $iataAndRailway::destCode *
        q!: * [$cityPreName] $iataAndRailway::fromCode * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::fromCode ($to [$cityPreName] $iataAndRailway::destCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) * ($to [$cityPreName] $iataAndRailway::destCode) *
        q!: * $iataAndRailway::fromCode ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($to [$cityPreName] $iataAndRailway::destCode) * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $register * ($flight/рейс*) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) * ([$from] [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ([$from] [$cityPreName] $iataAndRailway::fromCode) * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $register * ($flight/рейс*) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * {($dateDig/$dateLetters/$thatDay) [$morning/$evening]} * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode *
        q!: * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode *
        q!: * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) [$cityPreName] $iataAndRailway::destCode * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * $register * ($flight/рейс*) * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) *
        q!: * $iataAndRailway::destCode * ($from [$cityPreName] $iataAndRailway::fromCode) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) *
        q!: * $register * ($flight/рейс*) * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * $register * ($flight/рейс*) * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * $register * ($flight/рейс*) * ($from [$cityPreName] $iataAndRailway::fromCode) *
        q!: * $iataAndRailway::destCode * ([на] {($dateDig/$dateLetters/$thatDay) [$morning/$evening]}) * ($from [$cityPreName] $iataAndRailway::fromCode) * $register * ($flight/рейс*) *
        go!: /checkIn/checkInForFlight