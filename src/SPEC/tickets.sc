theme: /tickets


    state: ticketPrint
        # 4EX: как распечатать купленный билет
        q!: * (распечата*/распичата*) * ($ticket/$airplaneTicket) *
        q!: * ($ticket/$airplaneTicket) * (распечата*/распичата*) *
        # 4EX: как скачать купленный билет
        q!: * ($how/$want/$need2/$canSg1/$possiblePredic) * скачат* * ($ticket/$airplaneTicket) [$markQuestion]
        q!: * ($how/$want/$need2/$canSg1/$possiblePredic) * ($ticket/$airplaneTicket) * скачат* [$markQuestion]
        q!: * ($ticket/$airplaneTicket) * скачат* ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) [$markQuestion]
        q!: * скачат* ($ticket/$airplaneTicket) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) [$markQuestion]
        a: Билеты (маршрутные квитанции) мы отправили на адрес электронной почты, который указан в Личном кабинете. Если билетов нет в папке «Входящие», пожалуйста, проверьте папку «Спам». \nА еще вы можете распечатать билеты из Личного кабинета. Для этого нажмите на желтую кнопку «Билеты и полисы».



    state: ticketPrintCharter
        # 4EX: как распечатать билет на чартерный рейс
        q!: * чартер* * (распечат*/распичат*) * ($ticket/$airplaneTicket) *
        q!: * (распечат*/распичат*) * ($ticket/$airplaneTicket) * чартер* *
        q!: * (распечат*/распичат*) * чартер* * ($ticket/$airplaneTicket) *
        q!: * ($ticket/$airplaneTicket) * чартер* * (распечат*/распичат*) *
        q!: * ($ticket/$airplaneTicket) * (распечат*/распичат*) * чартер* *
        a: Вы забронировали место на чартерном рейсе. Электронные билеты (маршрутные квитанции) мы отправим на адрес вашей электронной почты за 24 часа до вылета.



#    state: ticketPrintProblem
#        # 4EX: не могу распечатать билет
#        # 4EX: билет не распечатывается
#        q!: * $cannot2 * (распечат*/распичат*) [$my2/$ruSvoi] ($ticket/$airplaneTicket) *
#        q!: * (распечат*/распичат*) [$my2/$ruSvoi] ($ticket/$airplaneTicket) * $cannot2
#        a: Если вы не можете распечатать билет, это может быть связано с тем, что авиакомпания все еще формирует ваш билет.



    state: noItineraryReceiptOrderNumber
        # 4EX: Заказ 12240112-0812, нет маршрутной квитанции стамбул- краснодар 26.03
        q!: * {$absent (маршрутн* ~квитанция)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay/$numberDate/$doubleDate) * {$absent (маршрутн* ~квитанция)} *
        go!: /operator/goToOpeartor



    state: cantFindTicketsOnMail
        # 4EX: И маршрут квитанция не приходит
        # 4EX: Вчера оплатила авиабилеты (Чек № 2115 от 17.12.2018 22:21, ООО "Интернет Трэвел"), а билеты так пока и не получила...
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали) [все еще/пока что/до сих пор] ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        # 4EX: я указала не верный электронный адрес как исправить что бы распечатать авиа билет
        # 4EX: Здравствуйте!!!Я покупал у вас билет,забыл сохранить его,ещё электронную почту не ту написал...Можно будет билет электронный получить???
        q!: * {$wrong ($email2/$mail)} * ($how/$want/$need2/$canSg1/$possiblePredic) * (распечат*/распичат*/скачат*/*получить/*палучить) * ($ticket/$airplaneTicket/$eTicket) *
        q!: * {$wrong ($email2/$mail)} * ($ticket/$airplaneTicket/$eTicket) * ($how/$want/$need2/$canSg1/$possiblePredic) * (распечат*/распичат*/скачат*/*получить/*палучить) *
        # 4EX: Что делать,если при покупке  билета перепутала одну цифру в электронной почте?
        q!: * ($buyNoun/$buyVerbPast) ($ticket/$airplaneTicket/$eTicket) * (путал/*путала/ошибс*/ошиблас*/ошиблис*) * ($email2/$mail) *
        q!: * ($buyNoun/$buyVerbPast) ($ticket/$airplaneTicket/$eTicket) * ($email2/$mail) * (путал/*путала/ошибс*/ошиблас*/ошиблис*) *
        q!: * (путал/*путала/ошибс*/ошиблас*/ошиблис*) * ($email2/$mail) * ($buyNoun/$buyVerbPast) ($ticket/$airplaneTicket/$eTicket) *
        q!: * ($email2/$mail) * (путал/*путала/ошибс*/ошиблас*/ошиблис*) * ($buyNoun/$buyVerbPast) ($ticket/$airplaneTicket/$eTicket) *
        script:
            $temp.time = $jsapi.dateForZone("Europe/Moscow","HH");
        #if: ($temp.time >= 20 && $temp.time <= 23) || ($temp.time >= 0 && $temp.time < 8)
        #    a: Скорее всего, произошла небольшая техническая заминка, билеты на почту придут позже. Кроме того, ваши билеты есть и в Личном кабинете на сайте Ozon.Travel. Вы можете их посмотреть и распечатать, нажав на желтую кнопку «Билеты и полисы». \nЕсли билетов в Личном кабинете нет, пожалуйста, свяжитесь с нашими специалистами с 8:00 до 20:00 по московскому времени.
        #else:
        a: Уточните, пожалуйста, номер заказа.



    state: cantFindTicketsOnMailFullInfo
        # 4EX: Я заказала билет из Адлера в Волгоград на 10 июля 2019 г на имя Ефимова Наталья я Геннадьевна и Колесников Дмитрий Романович. На почту не пришел билет
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode *

        # 4EX: Купил билет из краснодара в москву 12 октября, а на почту он не пришел
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::fromCode {($to [$cityPreName] $iataAndRailway::destCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode * ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::fromCode * ($to [$cityPreName] $iataAndRailway::destCode) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * ($dateDig/$dateLetters/$thatDay)*($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode $to [$cityPreName] $iataAndRailway::destCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode *

        # 4EX: Купил билет в москву из краснодара 12 октября, но он так и не пришел
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $to [$cityPreName] $iataAndRailway::destCode {([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay))} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ([$from] [$cityPreName] $iataAndRailway::fromCode) ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $to [$cityPreName] $iataAndRailway::destCode ([$from] [$cityPreName] $iataAndRailway::fromCode) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ([на] ($dateDig/$dateLetters/$thatDay)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode [$from] [$cityPreName] $iataAndRailway::fromCode *
        q!: * ($dateDig/$dateLetters/$thatDay) * $to [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode *

        # 4EX: Краснодар Купил бидеты из москвы 12 октября, но вы их не прислали
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *
        q!: * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ([на] ($dateDig/$dateLetters/$thatDay)) [$cityPreName] $iataAndRailway::destCode *
        q!: * $from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} *
        q!: * $iataAndRailway::destCode * {$from [$cityPreName] $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay))} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode ([на] ($dateDig/$dateLetters/$thatDay)) *
        q!: * $iataAndRailway::destCode * $from [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ([на] ($dateDig/$dateLetters/$thatDay)) *


        # 4EX:  билет термез москва на завтра 10 января мне не пришел, хотя полностью оплачен
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * [$ticket/$airplaneTicket] * [$from] [$cityPreName] $iataAndRailway::fromCode * $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * [$from] [$cityPreName] $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) * [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [$ticket/$airplaneTicket] *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $iataAndRailway::fromCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::destCode * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * ($dateDig/$dateLetters/$thatDay) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $price [на] [$ticket/$airplaneTicket] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket/$airplaneTicket] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $price [на] [$ticket/$airplaneTicket] * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $price [на] [$ticket/$airplaneTicket] *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * $price [на] [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $price [на] [$ticket/$airplaneTicket] * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *$price [на] [$ticket/$airplaneTicket] * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        # 4EX: что делать если не пришел билет мск питер 27 мая?
        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *

        q!: * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * [на] ($dateDig/$dateLetters/$thatDay) * {($howMuch $cost/почем/почём) [$ticket/$airplaneTicket]} * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        go!: /tickets/cantFindTicketsOnMail




    state: whereAreTicketsIBought
        # 4EX: Где найти билеты которые я я у вас покупал
        q!: * $checkLookFor * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) [$markQuestion]
        q!: * $checkLookFor * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) [$markQuestion]
        q!: * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $checkLookFor [$markQuestion]
        q!: * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $checkLookFor [$markQuestion]
        # 4EX: Где посмотреть авиабилеты Красноярск-Минск,купленные 30.01.2019 г. На имя Агеенко юрия Ивановича
        q!: * $checkAll * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $checkAll * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode * $checkAll * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $iataAndRailway::destCode *

        q!: * $checkAll * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * $checkAll * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) *
        q!: * $iataAndRailway::fromCode * $checkAll * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $iataAndRailway::destCode *

        q!: * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $checkAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $checkAll *
        q!: * $iataAndRailway::fromCode * (куплен*/куплин*/$buyVerbPast) * ($ticket/$airplaneTicket) * $checkAll * $iataAndRailway::destCode *

        q!: * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $checkAll * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode [$to] [$cityPreName] $iataAndRailway::destCode * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $checkAll *
        q!: * $iataAndRailway::fromCode * ($ticket/$airplaneTicket) * (куплен*/куплин*/$buyVerbPast) * $checkAll * $iataAndRailway::destCode *
        a: Вы можете найти и распечатать билеты в Личном кабинете. Для этого нажмите на желтую кнопку «Билеты и полисы».



    state: cannotFindTickets
        # 4EX: не могу найти авиабилеты
        # 4EX: Здравствуйте не могу найти свой билет в почте помогите пожалуйста
        q!: * $cannotI * {$checkLookFor ([$ruSvoi/$my2] ($eTicket/~квитанция/$ticket/$airplaneTicket))} *
        q!: * {([$ruSvoi/$my2] ($eTicket/~квитанция/$ticket/$airplaneTicket)) $checkLookFor} * $cannotI *
        # 4EX: Мне нужны билеты не могу их найти
        q!: * {($want/$need2) ([$ruSvoi/$my2] ($ticket/$airplaneTicket))} * $cannotI * {$checkLookFor ($eTicket/~квитанция/$ticket/$airplaneTicket)} *
        q!: * {($want/$need2) ([$ruSvoi/$my2] ($ticket/$airplaneTicket))} * $cannotI * {$checkLookFor их}
        go!: /tickets/whereAreTicketsIBought



    state: sendMeTickets
        # 4EX: Здравствуйте вы могли бы мои билеты мнн прислать в файле
        q!: * (вышли/вышлите/перешли*/пришли/пришлит*/отправь*) [$meDat] ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        q!: * ($eTicket/~квитанция/$ticket/$airplaneTicket) [$meDat] (вышли/вышлите/перешли*/пришли/пришлит*/отправь*) *
        q!: * ($eTicket/~квитанция/$ticket/$airplaneTicket) {$meDat (прислать/выслать/оправить/переслать)} *
        q!: * {$meDat (прислать/выслать/оправить/переслать)} ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        go!: /tickets/whereAreTicketsIBought



    state: howToFindTicketsInLK
        # 4EX: как мне, находясь в Личном Кабинете, добраться до Маршрутной Квитанции. На электронку она не пришла. Спасибо!
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $persCabinet * ($checkAll/(добраться/добратся) до) ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        q!: * ($where/$how/$want/$need2/$canSynPossible) * $persCabinet * ($eTicket/~квитанция/$ticket/$airplaneTicket) * $checkAll *
        q!: * $persCabinet * ($where/$how/$want/$need2/$canSynPossible) * ($checkAll/(добраться/добратся) до) ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        q!: * $persCabinet * ($where/$how/$want/$need2/$canSynPossible) * ($eTicket/~квитанция/$ticket/$airplaneTicket) * $checkAll *
        go!: /tickets/whereAreTicketsIBought



    state: howToDownloadTickets
        # 4EX: здравствуйте! где я мог бы скачать свой электронный билет? на сайте авиакомпании не видно мое бронирование
        q!: * ($where/$how/$want/$need2/$canSynPossible) * скачат* * ($eTicket/~квитанция/$ticket/$airplaneTicket) *
        q!: * ($where/$how/$want/$need2/$canSynPossible) * ($eTicket/~квитанция/$ticket/$airplaneTicket) * скачат* *
        go!: /tickets/whereAreTicketsIBought



    state: boughtTicketSendItToMailFromDest
        # 4EX: Я купил билет 30.01.2019 и улетел но этого билета нужен электронные фото muhriddinkamalov 43@gmayl.com на почту отправьте пожалуста оформление билета Нижневартовск Россия.Ош Киргизия Saydullaev Axrorjon Saibjanovich AB6911876
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $send * ([на/в] ($email2/$mail)) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ([на/в] ($email2/$mail)) * $send * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * $send * ([на/в] ($email2/$mail)) *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ([на/в] ($email2/$mail)) * $send *
        q!: * $send * ([на/в] ($email2/$mail)) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ([на/в] ($email2/$mail)) * $send * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * $send * ([на/в] ($email2/$mail)) * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * ([на/в] ($email2/$mail)) * $send * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * $send * ([на/в] ($email2/$mail)) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ([на/в] ($email2/$mail)) * $send * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $send * ([на/в] ($email2/$mail)) *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ([на/в] ($email2/$mail)) * $send *
        go!: /operator/goToOpeartor



    state: boughtTicketSendItToMailFullInfo
        # 4EX: Добрый день! При оформлении покупки авиабилета по маршруту г.Новосибирск-г. Сургут 02.03.2019г. на электронный почтовый адрес vasilijgorev@yandex.ru был направлен только авиабилет. Прошу направить маршрут-квитанцию к билету № 421-2402836678.
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * ([на/в] ($email2/$mail)) * $send *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * $send * ([на/в] ($email2/$mail)) *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ([на/в] ($email2/$mail)) * $send *
        q!: * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ($dateDig/$dateLetters/$thatDay) * $iataAndRailway::fromCode * $iataAndRailway::destCode * $send * ([на/в] ($email2/$mail)) *

        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ($dateDig/$dateLetters/$thatDay) * ([на/в] ($email2/$mail)) * $send *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ($dateDig/$dateLetters/$thatDay) * $send * ([на/в] ($email2/$mail)) *

        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * ([на/в] ($email2/$mail)) * $send *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $send * ([на/в] ($email2/$mail)) *

        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * ([на/в] ($email2/$mail)) * $send * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * $send * ([на/в] ($email2/$mail)) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *

        q!: * ([на/в] ($email2/$mail)) * $send * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *
        q!: * $send * ([на/в] ($email2/$mail)) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) *

        q!: * ([на/в] ($email2/$mail)) * $send * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        q!: * $send * ([на/в] ($email2/$mail)) * $iataAndRailway::fromCode * $iataAndRailway::destCode * ($dateDig/$dateLetters/$thatDay) * {($buyVerbPast/$buyNoun) ($ticket/$airplaneTicket/$eTicket)} *
        go!: /operator/goToOpeartor



    state: findTicketsByOrderNumb
        # 4EX: Здравствуйте! Как мне найти билеты по номеру заказа?
        q!: {($lookForV/$lookForN) ($ticket/$airplaneTicket/$flight)} * $number $order [$markQuestion]
        go!: /documentsFaqAns/tellMeYoutOrderNumb


