theme: /address


   # Одиночный запрос Адрес
    state: address0
        # 4EX: адрес?
        q!: {[$beginningWords] $address}
        go!: /addressAns/addressAns



    state: whatsYourAddress
        # 4EX: АДРЕС КАКОЙ?
        q!: * {$address ($whichSgM/$whichSgF)} [$markQuestion]
        go!: /addressAns/addressAns



    state: addressYour2
        # 4EX: у вас нету адреса?
        q!: * (у вас/увас) [какой/есть/нет/нету] $address *
        q!: * ваш* $address [$markQuestion]
        q!: * $address ваш* (дай*/скажи*/подскажи*/предоставь*) [$markQuestion]
        q!: * (какой/какие)(у вас/увас) $address *
        q!: * $what2 (у вас/увас) за $address *
        q!: * какой * {(у вас/увас/ваш*) * (адрес/адрис)} *
        go!: /addressAns/addressAns



#    state: addressLegal
#        #: Подскажите мне Ваш юридический адрес для направления письма
#        q!: * ваш* почт* $address *
#        q!: * ваш* (официал*/офиц/юр/юридич*) $address *
#        q!: * почт* $address ([$company] (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)/вашей $company) *
#        q!: * (официал*/офиц/юр/юридич*) $address ([$company] (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)/вашей $company) *
#        q!: * {$which * (увас/у (вас/[$company] (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)/вашей $company)) * ((официал*/офиц/юр/юридич*) $address)} *
#        #: Подскажите мне Ваш адрес для официальных писем
#        q!: * ваш* $address * [$send] (официал*/офиц) (письм*/писем/корреспонд*/переписк*) *
#        q!: * [$send] (официал*/офиц) (письм*/писем/корреспонд*/переписк*) * ваш* $address *
#        q!: * [$send] (официал*/офиц) (письм*/писем/корреспонд*/переписк*) * $address ([$company] (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)/вашей $company) *
#        q!: * [$send] (официал*/офиц) (письм*/писем/корреспонд*/переписк*) * $which * {(увас/у (вас/[$company] (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)/вашей $company)) * $address} *
#        #: куда можно направить официальное письмо
#        q!: * $whereTo * $send (официал*/офиц) (письм*/корреспонд*)
#        go!: /addressAns/addressAns



    state: addressWhereAreYou2
        #4EX: Где вы?
        q!: [$beginningWords] {$where вы}
        go!: /addressAns/addressAns



    state: addressMts
        #4EX: адрес озон трэвел
        q!: * $address (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel) *
        q!: [$beginningWords] {$where (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel) }
        go!: /addressAns/addressAns



    state: addressWhereSituatedMts
        #4EX: где находится озон трэвел??
        q!: * $where * {$addressSituatedVerb3 * (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)} *
        q!: * {$where * (озон/азон/ozon) (травел/трэвэл/травэл/травл/трэвл/тревл/трэвел/travel)} * $addressSituatedVerb3 *
        go!: /addressAns/addressAns



    state: addressWhereSituatedYou2
        #4EX: Где вы находитесь
        q!: * $where * {(находитес*/находетес*) * вы} *
        q!: * {$where * вы} * (находитес*/находетес*) *
        go!: /addressAns/addressAns



    state: addressWhereCanIFindYou2
        #4EX: Где вас искать?
        q!: * (как/где) * вас * (найти/найду) *
        q!: * где * вас * искать *
        go!: /addressAns/addressAns



    # Салон / Офис / магазин
    state: addressWhereIsShop
        # 4EX: магазин озон трэвел
        # 4EX: где ваш магазин
        q!: [$beginningWords] $shop
        q!: * ~ваш $shop *
        q!: * $where [$interjections] [$addressSituatedVerb3][$interjections] [ваш*][*ий/*ый/*ие/ые] $shop *
        go!: /addressAns/addressAns



    state: addressOfShop
        # 4EX: адреса салонов озон трэвел
        q!: * $address $shop *
        q!: * $address ваш* $shop *
        go!: /addressAns/addressAns



    state: addressLookingFor
        # 4EX: Найти магазин
        q!: * [$where/$how] (найти/искать/ищу/найду/найди/ищи/поищи/поищу) [~ваш] $shop *
        go!: /addressAns/addressAns



    state: addressClosest
        # 4EX: Ближайший офис озон трэвел
        q!: * ближайш* $shop *
        q!: * $shop (рядом/близко) *
        go!: /addressAns/addressAns



    state: addressToWhatOffice
        # 4EX: в каком из ваших магазинов можно это сделать
        q!: * в как* из [ваш*] $shop *
        q!: * в как* $shop *
        go!: /addressAns/addressAns



    state: addressMap
        # 4EX: карта ваших офисов
        q!: * ~карта [ваш*] (салонов/офисов) *
        go!: /addressAns/addressAns



    state: addressAreThereOfficesInCity
        # 4EX: Есть ли в Казани офисы озон трэвел?
        q!: * (есть ли/есь ли) * в $iataAndRailway * $shop *
        q!: * $shop * в $iataAndRailway *
        go!: /addressAns/addressAns



    state: addressOfficeAt
        # 4EX: Офис озон трэвел на тверской
        q!: * $shop на *
        go!: /addressAns/addressAns



    state: addressWhitchStreet
        # 4EX: В каком городе салон озон трэвел
        # 4EX: на какой улице салон озон трэвел
        q!: * [в/ф/на] $which (город*/горад*/град*/ули*/деревн*) * {$shop * $addressSituatedVerb3} *
        q!: * $shop * [в/ф/на] $which (город*/горад*/град*/ули*/деревн*) * $addressSituatedVerb3 *
        q!: * [в/ф/на] $which (город*/горад*/град*/ули*/деревн*) * {$shop $ozonTravel} [$markQuestion]
        q!: * {$shop $ozonTravel} * [в/ф/на] $which (город*/горад*/град*/ули*/деревн*) [$markQuestion]
        go!: /addressAns/addressAns



    state: addressWayTo
        # 4EX: схема проезда
        q!: * ~схема проезд* *
        q!: * ~карта проезд* *
        q!: * как *ехать в $shop *
        q!: * в $shop как *ехать *
        q!: * как добраться до $shop *
        q!: * до $shop как (добраться/добратся) *
        q!: * к вам *ехать *
        go!: /addressAns/addressAns



    state: shopContacts
        # 4EX: контакты салона
        q!: * {$contacts * ($shop)} *
        a: Вы можете задать свой вопрос в чате.