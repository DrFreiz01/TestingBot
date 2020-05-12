theme: /bonuses


    state: buyWithBonusesOT
        # 4EX: Как купить на бонусы
        q!: [$beginningWords] [$how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1] ($buy/$payInf) (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) [$markQuestion]
        a: Если у вас есть активные бонусы на счету, при оплате заказа сайт предложит их использовать. Вы сможете списать нужное количество бонусов из расчета 1 бонус = 1 рубль.
        #\nЕсли у вас есть промо-код - при оплате заказа введите его в соответствующее поле (рассказываем об ограничениях в доступных акциях - 1 заказ, сумма и т.д.). \nЕсли у вас есть сертификат, активируйте его в личном кабинете на вкладке «Бонусы и сертификаты», после чего вы сможете оплатить им заказ частично или полностью.



    state: buyWithBonusesOTfromDest
        # 4EX: Я хочу  купить на свои бонусы билет с Новосибирска в Томск
        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] [($need2/$buy) ($ticket/$airplaneTicket)] *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [на] [($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] $iataAndRailway::destCode * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] *

        q!: * [($need2/$buy) ($ticket/$airplaneTicket)] * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * [($need2/$buy) ($ticket/$airplaneTicket)] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) *
        q!: * [на] (($dateDig/$dateLetters/$thatDay)/($dateDig::dateDig1/$dateLetters::dateLetters1/$numberDate) * ($dateDig::dateDig2/$dateLetters::dateLetters2)) * [$from] [$cityPreName] [$iataAndRailway::fromCode] * [$to] [$cityPreName] [$iataAndRailway::destCode] * (за/на/нп/по/с пом/с помощью/при помощи/с) [$my2/$ruSvoi] ($bonus/$bonusPoint) * [($need2/$buy) ($ticket/$airplaneTicket)] *
        # чистим переменные
        if: $temp.begin0 == undefined
            script:
                $temp.begin0 = true;
                $client.executeState0 = $context.currentState;
            go!: /aviaSearchFunc/varsCleaning_DYN
        else:
            script:
                $temp.begin0 = undefined;
            # собираем переменные
            if: $temp.begin2 == undefined
                script:
                    $temp.begin2 = true;
                    $temp.begin0 = true;
                    $client.executeState = $context.currentState;

                go!: /aviaSearchFunc/parsing4AviaSearch_DYN
            else:
                script:
                    $temp.begin2 = undefined;
                    $temp.begin0 = undefined;

                a: Если у вас есть активные бонусы на счету, при оплате заказа сайт предложит их использовать. Вы сможете списать нужное количество бонусов из расчета 1 бонус = 1 рубль.
                if: $session.from && $session.dest && $session.dates1 && $session.dates2
                    go!: /aviaSearchFunc/aviaSearchRoundtrip
                elseif: $session.from && $session.dest && ($session.date || $session.dates)
                    go!: /aviaSearchFunc/aviaSearch
                elseif: $session.from && $session.dest
                    go!: /aviaSearch/aviaSearchFromDest
    #           elseif: ($parseTree._dateDig1 || $parseTree._numberDate) && $parseTree._dateDig2
    #           ???
                elseif: ($session.date || $session.dates)
                    go!: /aviaSearch/aviaSearchDatesInfo
                elseif: $session.dest
                    go!: /aviaSearch/aviaSearchDestInfo



    state: bonusSpasibo
        # 4EX: бонусные баллы спасибо от сбербанка
        q!: * ( ($bonus/$bonusPoint/~балл/~бал) ( (спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber) *
        q!: * (за/на/нп/по/с пом/с помощью/при помощи/с) ( ($bonus/$bonusPoint/~балл/~бал) ( (спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber) *
        # 4EX: Возможно ли оплата бонусами спасибо
        # 4EX: А можно часть оплатить бонусами спасибо?
        # 4EX: Подскажите, пожалуйста, можно ли расплатиться бонусами спасибо от Сбербанка при покупке авиабилетов?
        q!: * {($buy/$buyNoun/$payInf/$orderVerbInf/$orderMoreVerbInf) * ([за/на/нп/по/с пом/с помощью/при помощи/с] ($bonus/$bonusPoint/~балл/~бал) ((спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber) } *
        q!: * $how * { (оплатит*/опатит*/платит*/заплатит*/оплачив*) * (( ($bonus/$bonusPoint/~балл/~бал) ( (спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber) ) } *
        q!: * ( ($bonus/$bonusPoint/~балл/~бал) ( (спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber) * $how * (оплатит*/опатит*/платит*/заплатит*/оплачив*) *
        q!: * {~оплата * (( ($bonus/$bonusPoint/~балл/~бал) ( (спасибо/спасио) [[от] $bankSber]/[от] $bankSber)/(спасибо/спасио) [от] $bankSber))} *
        script:
            var $session = $jsapi.context().session;
            $client.topic = "Бонусы Спасибо";
        a: К сожалению, у нас на сайте бонусы «Спасибо от Сбербанка» к оплате не принимаются.



    state: whereAreMyBonuses
        # 4EX: Привет, как получить бонус
        q!: * $how * (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [$oneWord] ($bonus/$bonusPoint/~балл/~бал) [$markQuestion]
        # 4EX: как начисляют бонусы?
        q!: * $how * (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [$oneWord] ($bonus/$bonusPoint/~балл/~бал) [$markQuestion]
        # 4EX: Начисляются ли бонусы за покупку авиабилетов?
        q!: * (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [ли] [$meDat] ($bonus/$bonusPoint/~балл/~бал) (на/за/нп) *
        q!: * (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [ли] [$meDat] ($bonus/$bonusPoint/~балл/~бал) (на/за/нп) * ($buyNoun/купл*) ($ticket/$airplaneTicket) *
        # 4EX: Почему мне не начислили бонусы за купленные здесь авиабилеты?
        # 4EX: Добрый вечер, не могу понять, почему не получила бонусы за последние заказы?
        q!: * $ne (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [$oneWord] ($bonus/$bonusPoint/~балл/~бал) (на/за/нп) *
        q!: * (на/за/нп) * $ne (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) [$oneWord] ($bonus/$bonusPoint/~балл/~бал) *
        # 4EX: А бонусная программа за покупку билетов еще действует?
        q!: * ($bonusAdj $program/Трэвелмания/Тревелмания/Травелмания/Трэвлмания/Тревлмания/Травлмания) * ($exist/$workVPresSg/действует/действуют) [$markQuestion]
        # 4EX: получается сейчас за покупку билетов нет бонусов на скидку следующего Билета
        q!: * $now2 * $absent [$oneWord] ($bonus/$bonusPoint/~балл/~бал) (на/за/нп) *
        # 4EX: хотел узнать о бонусах за покупку авиабилетов, покупаю уже 3 раз а бунусов не получаю.. почему?
        q!: * ($buy/$buyNoun) * ($ticket/$airplaneTicket) * ($bonus/$bonusPoint/~балл/~бал) [$oneWord] $ne (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) *
        q!: * ($bonus/$bonusPoint/~балл/~бал) [$oneWord] $ne (*числен*/*числин*/*чсилен*/дали/дают/начисл*/паступал*/паступил*/получ*/получаю/получил*/полчил*/поступает/поступал*/поступают/поступил*/присла*/присыла*/приходит/пришел*/пришл*/пришол*) * ($buy/$buyNoun) * ($ticket/$airplaneTicket) *
        a: С 29 августа 2018 приостановлено действие программы лояльности «Трэвелмания» для всех клиентов. Если у вас есть активные бонусы на счету, при оплате заказа сайт предложит их использовать. А еще вы можете оформить карту, которая позволяет получать бонусы для заказов на Ozon.ru. Вы будете получать кэшбэк баллами, которые в дальнейшем можно будет использовать для оплаты заказов. Начисляется 1% за заказ билетов. Вот ссылка, по которой вы сможете оформить карту: https://www.ozon.ru/context/detail/id/149074294



    state: travelMania
        # 4EX: трэвелмания
        q!: * (~трэвеомания/~тревелмания/~трэвелмания/~тревеомания/~трэвлмания/~тревлмания) *
        script:
            var $session = $jsapi.context().session;
            $client.topic = "Трэвелмания";
        a: Бонусная программа «Трэвелмания» закончила свое действие 29 августа 2018 года. В настоящий момент баллы за заказы не начисляются. Но вы можете оформить карту, которая позволяет получать бонусы для заказов на Ozon.ru. Вы будете получать кэшбэк баллами, которые в дальнейшем можно будет использовать для оплаты заказов. Начисляется 1% за заказ билетов. Вот ссылка, по которой вы сможете оформить карту: https://www.ozon.ru/context/detail/id/149074294



    state: howToCheckCertificate
        # 4EX: Как проверить, действителен ли сертификат?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {$checkInf ((действителен/~действительность/$workVPresSg/$workVPresPl/работу/~работоспособность/рабочи*/работоспособны*) [ли] сертификат*)} *
        a: Укажите, пожалуйста, номер сертификата, и мы проверим его действительность.



        # Добрый день.какой срок существующих бонусов ?
        #a: 180 дней с момента перелета/поездки

        #a: В личном кабинете можно увидеть детализацию вашего бонусного счета

        # 56 бонусов это?

        # Бонусы на карту S7 будут начислены после совершения полета?
        #a: Если вы летели рейсом S7, мили автоматически поступят на ваш персональный счёт после полёта. Однако если аэропорты на вашем маршруте не оборудованы автоматизированными системами контроля отправки пассажиров, мили зачислятся в течение 45 дней. Подробнее лучше уточнить в авиакомпании S7