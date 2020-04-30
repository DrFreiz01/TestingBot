theme: /documentsFaq


    state: howToFillInPassportAndMiddleName
        # 4EX: Добрый день,хочу у Вас приобрести авиабилет Симферополь-Москва.У меня 2 вопроса:надо ли вводить отчество и что писать в графе паспорт?
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * отчеств* * $passport *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $passport * отчеств* *
        q!: * отчеств* * $passport * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $passport * отчеств* * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        # 4EX: нужны билеты москва - питер У меня 2 вопроса:надо ли вводить отчество и что писать в графе паспорт?
        q!: * отчеств* * $passport * {($want/$need2) ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * отчеств* * $passport *
        q!: * $passport * отчеств* * {($want/$need2) ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {($want/$need2) ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $passport * отчеств* *

        q!: * отчеств* * $passport * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket)} * отчеств* * $passport *
        q!: * $passport * отчеств* * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($want/$need2) ($ticket/$airplaneTicket)} * $passport * отчеств* *
        # 4EX: Хочу купить билеты москва - питер У меня 2 вопроса:надо ли вводить отчество и что писать в графе паспорт?
        q!: * отчеств* * $passport * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * отчеств* * $passport *
        q!: * $passport * отчеств* * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $passport * отчеств* *

        q!: * отчеств* * $passport * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * отчеств* * $passport *
        q!: * $passport * отчеств* * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * $passport * отчеств* *
        a: Если вы видите поле «Отчество», значит его нужно заполнить. В тех случаях, когда отчество вводить не нужно, это поле не показывается.
        a: В поле «Паспорт» введите серию и номер документа без пробелов и дополнительных знаков.



    state: howToBookTicketWithoutPassport
        # 4EX: Могу я забронировать билет, если у меня еще нет загран паспорта? Он в процессе выпуска, номер не знаю.
        q!: * {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} * {$absent ($passport/загран*/загран* $passport)} *
        q!: * {$absent ($passport/загран*/загран* $passport)} * {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} *
        # 4EX: Могу ли я забронировать билет без паспорта? Дело в том, что в настоящее время он находится в процессе изготовления
        q!: * {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} * без ($passport/загран*/загран* $passport) *
        q!: * без ($passport/загран*/загран* $passport) * {(*бронировать/*бронить/бронятся/бронируются/броняться/пронируються/бронется/бронится/бронируется/бронируеться) ($ticket/$airplaneTicket/$flight)} *
        script:
            $client.topic = "Вопросы по оформлению заказа";
        go!: /operator/goToOpeartor
        #a: Вы можете забронировать билет со случайным номером паспорта и сроком действия, а при получении паспорта прислать нам заявку на изменение данных. Но я советую оформлять таким образом только если вы уверены в написании имени и фамилии на латинице. Изменения номера паспорта могут быть платными, но за изменение полей имени и фамилии сумма может быть еще больше.



    state: howToFillInPassportNumbAndSeries
        # 4EX: Добрый день! При вводе номера паспорта при покупке билета на внутренний рейс мне необходимо внести серию и номер или только номер паспорта?
        # 4EX: как заполнять паспортные данные, только серию и номер?
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*) * ~серия * ~номер *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*) * ~номер * ~серия *
        q!: * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*) * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*) * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * $passport * ~серия * ~номер * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * $passport * ~номер * ~серия * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        q!: * ($ticket/$airplaneTicket) * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*)($passport/загранпаспорт*/загран*/загранник*) *
        q!: * ($ticket/$airplaneTicket) * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*)($passport/загранпаспорт*/загран*/загранник*) *
        q!: * ($ticket/$airplaneTicket) * ($passport/загранпаспорт*/загран*/загранник*) * ~серия * ~номер *
        q!: * ($ticket/$airplaneTicket) * ($passport/загранпаспорт*/загран*/загранник*) * ~номер * ~серия *
        q!: * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) *
        q!: * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) *
        q!: * ($passport/загранпаспорт*/загран*/загранник*) * ~серия * ~номер * ($ticket/$airplaneTicket) *
        q!: * ($passport/загранпаспорт*/загран*/загранник*) * ~номер * ~серия * ($ticket/$airplaneTicket) *
        # 4EX: подскажите ,пожалуйста, в строке для указания данных паспорта указывать серию вместе с номером или только номер паспорта
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*) * ~серия * ~номер *
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*) * ~номер * ~серия *
        q!: * ~серия * ~номер * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * ~номер * ~серия * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * ($passport/загранпаспорт*/загран*/загранник*) * ~серия * ~номер *
        q!: * ($passport/загранпаспорт*/загран*/загранник*) * ~номер * ~серия *
        a: В поле «Паспорт» введите серию и номер документа без пробелов и дополнительных знаков.



    state: cantEnterPassportData
        # 4EX: Не принимает загран паспорт
        # 4EX: Не выбивается загранпаспорт
        q!: * {($ne (проходит/проходет/принимает/вбивается/выбивается)/непроходит/непроходет/непропускает/$wrong) ($passport/загранпаспорт*/загран*/загранник*)} *
        go!: /documentsFaq/howToFillInPassportNumbAndSeries



    state: cantEnterDocuments
        # 4EX: Здравствуйте, почему у меня не проходят данные доеументов
        q!: * {($ne (проходит/проходет/проходят/проходют/принимает/принимают/вбивается/вбиваются/выбивается/выбиваются)/непроходит/непроходят/непроходют/непроходет/непропускает/непропускают/$wrong) (документ*/доеумент*/(данн*/даные) (документ*/доеумент*))} *
        a: В поле «Паспорт» введите серию и номер документа без пробелов и дополнительных знаков.
        go!: /kidsDocuments/cantEnterBirthCertificate



    state: howToFillInPassportNumb
        # 4EX: Как вводить номера загран паспортов?
        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) * ~номер * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) * ~номер * ($passport/загранпаспорт*/загран*/загранник*) *
        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) * ($passport/загранпаспорт*/загран*/загранник*) * ~номер *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) * ($passport/загранпаспорт*/загран*/загранник*) * ~номер *
        go!: /documentsFaq/howToFillInPassportNumbAndSeries



    state: howToFillInPassportData
        # 4EX: Как вводить данные паспорта
        # 4EX: Как надо заполнить, где написано паспорт россии?
        # 4EX: Что писать на поле загранпаспорт
        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*/{(паспортн*/пасспортн*) (данн*/даные)}) *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * ($passport/загранпаспорт*/загран*/загранник*/{(паспортн*/пасспортн*) (данн*/даные)}) *
        go!: /documentsFaq/howToFillInPassportNumbAndSeries



    state: howToFillInPassportNameSurname
        # 4EX: Добрый день. Я хотела узнать заполнять поля фамилии и имя как в паспорте? Вот имя моё по латыни написано EVGENIA так и заполнять?
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * фамили* * имя * $how [в/во] ($passport/загранпаспорт*/загран*/загранник*) *

        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * фамили* * имя *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * фамили* * имя *

        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * фамили* *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * фамили* *

        q!: * ($how/$want/$need2/$what2) [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * имя *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) * имя *

        q!: * ($how/$want/$need2/$what2) [$meDat] фамили* * имя * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] фамили* * имя * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *

        q!: * ($how/$want/$need2/$what2) [$meDat] фамили* * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] фамили* * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *

        q!: * ($how/$want/$need2/$what2) [$meDat] имя * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        q!: [$beginningWords] [$how/$want/$need2/$what2] [$meDat] имя * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *

        q!: * фамили* * имя [$meDat] ($how/$want/$need2/$what2) (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        q!: * имя [$meDat] ($how/$want/$need2/$what2) (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        q!: * фамили* [$meDat] ($how/$want/$need2/$what2) (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать/заполнить/заполнять) *
        a: Заполните поля точно так же, как прописано в документе, по которому вы летите.


    state: iHaveCertificateNotPassport
        # 4EX: У меня например паспорта нет я со справкой Могу бронировать на сайте?
        q!: * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * справк* * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) *
        q!: * справк* * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) * справк* * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} *
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1] (*бронировать/*бронить/$buyInf/$payInf) * справк* * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * справк* *
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1] (*бронировать/*бронить/$buyInf/$payInf) * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * справк* *
        a: Если у вас справка вместо документа, удостоверяющего личность, вы можете оформить билет. Но перед этим обязательно позвоните в авиакомпанию и расскажите об этой ситуации. Если у вас нет на руках паспорта РФ, но есть загранпаспорт, вы можете лететь по загранпаспорту, в том числе в любой город России.



    state: iDontHavePassport
        q!: * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) *
        q!: * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) (*бронировать/*бронить/$buyInf/$payInf) * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} *
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1] (*бронировать/*бронить/$buyInf/$payInf) * {$absent ($passport/паспортн* данны*/пасспортн* данны*/данны* $passport)} *
        go!: /documentsFaq/iHaveCertificateNotPassport



    state: howToFillInPassportDara4Foreigners
        # 4EX: Вопрос ещё один.Как правильно оформить гражданина иностранца,гражданин Сирии?
        q!: * $how * $issue * ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) [$markQuestion]
        q!: * ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) * $how * $issue [$markQuestion]
        # 4EX: Здравствуйте, указано "паспорт России", а мы гр КЗ. Подскажите пожалуйста что писать. Спасибо.
        q!: * (я/йа/мы) ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) * ($what2/$how) (в бить/вбить/ввести/внести/вводить/писать/написать/указать/указывать/заполнить/заполнять) *
        q!: * ($what2/$how) (в бить/вбить/ввести/внести/вводить/писать/написать/указать/указывать/заполнить/заполнять) * (я/йа/мы) ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) *
        # 4EX: Добрый день. Могу ли я купить билет по документу иностранного гражданина?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) {(*бронировать/*бронить/$buyInf/$payInf) ($ticket/$airplaneTicket)} * ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) [$markQuestion]
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1] {(*бронировать/*бронить/$buyInf/$payInf) ($ticket/$airplaneTicket)} * ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) [$markQuestion]
        q!: * ((гражданин*/гр) $countryName/~иностранец/иностран* гражданин*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1) {(*бронировать/*бронить/$buyInf/$payInf) ($ticket/$airplaneTicket)} *
        a: Билет можно приобрести по паспорту любой страны. При заполнении данных о пассажире выберите нужную страну в графе ГРАЖДАНСТВО, а затем введите номер документа в точности так, как указано в вашем паспорте.



    state: myNameSurnameConvertedToEng
        # 4EX: Имя и фамилию я написал на русском а система сделала на латинице
        q!: * {(имя [и] фамили*/имя/фамили*) [я/йа/мы] (в бил*/вбил*/ввел*/внес*/внёс*/писал*/напечатал*/написал*/указал*/указывал*/заполнил*/заполнял*)} на (русск*/руск*) * (сделал*/превратил*/конвертнул*/изменил*/переменил*/поправил*/исправил*/трансформировал*) * (латиниц*/англ*) *
        q!: * (сделал*/превратил*/конвертнул*/изменил*/переменил*/поправил*/исправил*/трансформировал*) * (латиниц*/англ*) * {(имя [и] фамили*/имя/фамили*) [я/йа/мы] (в бил*/вбил*/ввел*/внес*/внёс*/писал*/напечатал*/написал*/указал*/указывал*/заполнил*/заполнял*)} на (русск*/руск*) *
        a: Иногда авиакомпания просит ввести данные пассажиров английскими буквами. Это происходит, потому что билеты забронированы через международную систему. Это не связано с типом паспорта и маршрутом поездки. Строгих норм для внесения данных в таких случаях нет, проблем при регистрации у вас не возникнет.



    state: shouldIspecifyWhoIssuedPassport
        # 4EX: нужно писать кем выдан поспорт?
        q!: * (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) {(кем/$who) (выдал*/выдан*/выдавал*) ($passport/загранпаспорт*/загран*/загранник*)} [$markQuestion]
        q!: * {(кем/$who) (выдал*/выдан*/выдавал*) ($passport/загранпаспорт*/загран*/загранник*)} (в бить/вбить/ввести/внести/вводить/писать/напечатать/написать/указать/указывать) [$markQuestion]
        a: Указывать, кем выдан паспорт, не нужно.


    state: foreignPassportFilledInAutomatically
        # 4EX: забронировал билет  Москва Симферополь Москва. графа "документ" заполнилась автоматически , вывелись данные из загранпаспорта. необходимо поменять ?
        q!: * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $iataAndRailway::fromCode * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * {($need2/$needNot) $changeInf} [$markQuestion]
        q!: * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $iataAndRailway::fromCode * {($need2/$needNot) $changeInf} [$markQuestion]
        q!: [$meDat] {($need2/$needNot) $changeInf} * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $iataAndRailway::fromCode *
        q!: [$meDat] {($need2/$needNot) $changeInf} * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode $iataAndRailway::fromCode * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) *

        q!: * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * {($need2/$needNot) $changeInf} [$markQuestion]
        q!: * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {($need2/$needNot) $changeInf} [$markQuestion]
        q!: [$meDat] {($need2/$needNot) $changeInf} * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$meDat] {($need2/$needNot) $changeInf} * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * {заполнил* (автоматически/автоматом/(само/сама) [по себе])} * (загранпаспорт*/загран*/загранник*) *
        a: Вы можете лететь по загранпаспорту, в том числе в любой город России. Если вы корректно ввели все данные загранпаспорта, то вносить изменения нет необходимости.



    state: buyTicketPassportExpired
        # 4EX: добрый день. Скажите смогу ли я купить билет на паспорт у которого истёк срок действия ?
        # 4EX: Хотим купить билет по данным старого загранпаспорта. Можем ли мы это сделать? Срок действия старого паспорта истек в 2018 году
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * ($ticket/$airplaneTicket) * $passport * (истек*/истёк*/устарел*/просроч*) *
        q!: * ($ticket/$airplaneTicket) * ($paymentAll/$payInf/$buyInf/$buyNoun) * (истек*/истёк*/устарел*/просроч*) * $passport *
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * ($ticket/$airplaneTicket) * (истек*/истёк*/устарел*/просроч*) * $passport *
        q!: * ($ticket/$airplaneTicket) * ($paymentAll/$payInf/$buyInf/$buyNoun) * $passport * (истек*/истёк*/устарел*/просроч*) *
        go!: /operator/goToOpeartor



    state: buyTicketPassportExpiredFromDest
        # 4EX: москва - питер в мае поездка не знаю что делать паспорт безнадежно устарел
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$passport * (истек*/истёк*/устарел*/просроч*)} *
        q!: * $iataAndRailway::fromCode * {$passport * (истек*/истёк*/устарел*/просроч*)} * $iataAndRailway::destCode *
        q!: * {$passport * (истек*/истёк*/устарел*/просроч*)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        # 4EX: нужны прямые билеты москва - питер но у меня паспорт истек
        q!: * {($want/$need2) * ($ticket/$airplaneTicket)} * {$passport * (истек*/истёк*/устарел*/просроч*)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($want/$need2) * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$passport * (истек*/истёк*/устарел*/просроч*)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($want/$need2) * ($ticket/$airplaneTicket)} * {$passport * (истек*/истёк*/устарел*/просроч*)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$passport * (истек*/истёк*/устарел*/просроч*)} * {($want/$need2) * ($ticket/$airplaneTicket)} *
        # 4EX: Хочу купить прямые билеты москва - питер с истёкшим пасспортом
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * {$passport * (истек*/истёк*/устарел*/просроч*)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * [$from] [$cityPreName] $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$passport * (истек*/истёк*/устарел*/просроч*)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$buyAllExceptPast * ($ticket/$airplaneTicket)} * {$passport * (истек*/истёк*/устарел*/просроч*)} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {$passport * (истек*/истёк*/устарел*/просроч*)} * {$buyAllExceptPast * ($ticket/$airplaneTicket)} *
        go!: /operator/goToOpeartor



    state: canIUseForeignPassport
        # 4EX: Здравствуйте. Можно лететь по заграничному паспорту, если перелет например из Москвы в Екатеринбург?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (загранпаспорт*/загран*/загранник*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic] (загранпаспорт*/загран*/загранник*) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * (загранпаспорт*/загран*/загранник*) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (загранпаспорт*/загран*/загранник*) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) [$markQuestion]
        # 4EX: Можно ли лететь из Москвы в Калининград по заграничному паспорту РФ?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (загранпаспорт*/загран*/загранник*) *
        a: Вы можете лететь по загранпаспорту, в том числе в любой город России.



    state: visa
        # 4EX: Добрый день, подскажите пожалуйста, могу ли я спокойно лететь Москва-Прага-Стамбул-Москва С чешской визой... Не возникнут ли трудности или нарушения визового порядка при вылете из Праги в Стамбул?
        # 4EX: Смотрю билет - Москва-Лима через Мадрид Нужна виза в Мадридеф?
        q!: * (с [$oneWord] визой / нужна [ли] виза) * $weight<+1>
        a: К сожалению, мы не консультируем по визовым вопросам. Дело в том, что правила в разных странах сильно отличаются. Поэтому рекомендую вам при бронировании заказа сначала узнать эту информацию в посольстве, консульстве или визовом центре страны, которая вас интересует, и только после этого принять решение по оформлению заказа.



    state: howToAddDocument
        # 4EX: как прикрепить документы
        # 4EX: Как прикрепить оправдательеые документы
        # 4EX: Добрый день. Подскажите, как мне подгрузить вложение на запрос. ранее подгрузил заключение, сейчас есть справка, которую не вижу куда вложить/прикрепить.
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {(подгрузит*/загрузит*/прикрепит*/прикрипит*/прекрипит*/прекрепит*) ([$oneWord] (~вложение/~документ/~файл/~скрин/~скриншот/~справка))} *
        # 4EX: Не могу прикрепить подтверждающий документ в заявлении о возврате билета из-за отмены рейса.
        # 4EX: Здравствуйте. Не могу прикрепить подтверждающий документ в заявлении о возврате билета из-за отмены рейса. Кнопка "выбрать файл" не работает
        q!: * ($cannot2/$cannotI) * {(подгрузит*/загрузит*/прикрепит*/прикрипит*/прекрипит*/прекрепит*) ([$oneWord] (~вложение/~документ/~файл/~скрин/~скриншот/~справка))} *
        q!: * {(подгрузит*/загрузит*/прикрепит*/прикрипит*/прекрипит*/прекрепит*) ([$oneWord] (~вложение/~документ/~файл/~скрин/~скриншот/~справка))} ($cannot2/$cannotI) *
        # 4EX: Здравствуйте. Не могу добавить файл в заявку на возврат билетов
        q!: * ($cannot2/$cannotI) * {(добавит*/подгрузит*/загрузит*/прикрепит*/прикрипит*/прекрипит*/прекрепит*) ([$oneWord] (~вложение/~документ/~файл/~скрин/~скриншот/~справка))} * (~заявка/~заявление) *
        q!: * (~заявка/~заявление) * ($cannot2/$cannotI) * {(добавит*/подгрузит*/загрузит*/прикрепит*/прикрипит*/прекрипит*/прекрепит*) ([$oneWord] (~вложение/~документ/~файл/~скрин/~скриншот/~справка))} *
        # 4EX: Можно вашу почту для пересылки белена с возвратом
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ваш* ~почта * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) * $return *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ваш* ~почта * $return * ($ticket/$airplaneTicket/$flight/$order/~поездка/~рейс) *
        a: Адрес нашей электронной почты: bilet@ozon.travel \nКроме того, любые документы вы можете прикрепить здесь, в чате. Для этого нажмите на три точки в окне чата и выберите функцию прикрепления файла.
