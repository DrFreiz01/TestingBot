theme: /kidsFAQ


    state: kidsAge
        # 4EX: детский возраст до скольки лет?
        q!: * (детск* (возраст*/возрост*) / $childSgPl/$childDaughter/$childSon) * [со/с/до/после] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) [$markQuestion]
        q!: * [со/с/до/после] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * (детск* (возраст*/возрост*) / $childSgPl/$childDaughter/$childSon) [$markQuestion]
        a: При покупке билетов на самолет ✈️ действуют следующие категории: \n • До 2 лет - младенец. Оформляется «нулевой» билет без места. \n • С 2 до 12 лет - ребенок. Предоставляется отдельное пассажирское кресло. \n • С 12 лет - взрослый. \nПри покупке билетов на поезд 🚆: \n • До 5 лет - младенец без места. \n • С 5 до 9 лет - ребенок с местом. \n • С 10 лет - взрослый.



    state: buyTicketForKid
        # 4EX: Как купить билет для ребенка?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * {($ticket/$airplaneTicket/$flight) ([для] [$my2] ($childSgPl/$childDaughter/$childSon))} [$markQuestion]
        q!: * {($ticket/$airplaneTicket/$flight) ([для] [$my2] ($childSgPl/$childDaughter/$childSon))} * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$orderVerbInf/$checkAll/набрат*/$chooseInf) [$markQuestion]
        # 4EX: Как купить билет ребенку до 12 лет?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * {($ticket/$airplaneTicket/$flight) ([для] [$my2] ($childSgPl/$childDaughter/$childSon))} [со/с/до/после] $ageWithNumb [$markQuestion]
        q!: * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($ticket/$airplaneTicket/$flight) ([для] [$my2] ($childSgPl/$childDaughter/$childSon))} [со/с/до/после] $ageWithNumb [$markQuestion]
        q!: * ([для] [$my2] ($childSgPl/$childDaughter/$childSon)) ([со/с/до/после] $ageWithNumb) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * ($ticket/$airplaneTicket/$flight) [$markQuestion]
        q!: * ([для] [$my2] ($childSgPl/$childDaughter/$childSon)) ([со/с/до/после] $ageWithNumb) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($ticket/$airplaneTicket/$flight) * ($issueVerb/$buyInf/$orderVerbInf/$orderMoreVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) [$markQuestion]
        a: Билет на ребенка до 12 лет оформляется только вместе со взрослым пассажиром. Чтобы приобрести билет для ребенка, на странице поиска билетов, в графе «Количество пассажиров» нажмите на значок, обозначающий ребенка.



    state: issueTicketForKid
        # 4EX: Подскажите, как оформить билет на ребенка дополнительно к нашим билетам, уже купленным ранее.
        # 4EX: нужно купить билет в один конец на ребенка. взрослый билет я уже купил в оба конца
        # 4EX: Добрый день. Как заказать билет только на ребёнка, если билет на взрослого уже забронирован?
        q!: * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) *
        q!: * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) *

        # 4EX: Добрый день, хочу приобрести ребенку билет и отправить с мамой, программа не дает купить ребенку билет 10ти лет, подскажите пожалуйста, как быть?
        q!: * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) [$meDat] {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} $ageWithNumb *
        q!: * $childAll $ageWithNumb * {($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) ($ticket/$airplaneTicket)} *

        # 4EX: Добрый день. Можно ли приобрести билет для ребёнка отдельно?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} * (отдельно/отдкльно) [$markQuestion]
        q!: * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) ($ticket/$airplaneTicket)} ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $childAll * (отдельно/отдкльно) [$markQuestion]

        # 4EX: Добрый день, могу ли я докупить у Вас авиабилет на ребенка до 12 лет?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) (докупит*/докупат*) * (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket)) * $ageWithNumb *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket)) * $ageWithNumb * (докупит*/докупат*) *
        q!: * {(докупит*/докупат*) ($ticket/$airplaneTicket)} ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $childAll * $ageWithNumb *
        q!: * {(докупит*/докупат*) ($ticket/$airplaneTicket)} ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $ageWithNumb * $childAll *

        # 4EX: взрослый авиабилет был заказан через интернет,можно ли докупить к этому взрослому еще один детский билет
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) *

        # 4EX: Добрый день. Только что заказывала билеты у вас на сайте на сайте по ошибке заказала один взрослый, а нужно один взрослый один детский. Один детский билет не могу оформить ребёнку нет 12 лет. Подскажите, могу ли отменить заказ своего билета
        q!: * ($buyVerbPast/$bookPast/$orderPast) * взросл* * $childAdj [$ticket/$airplaneTicket] ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) *
        q!: * ($buyVerbPast/$bookPast/$orderPast) * взросл* * $childAdj * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит))
        q!: * ($buyVerbPast/$bookPast/$orderPast) * взросл* * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) * $childAdj [$ticket/$airplaneTicket]
        q!: * взросл* * ($buyVerbPast/$bookPast/$orderPast) * $childAdj [$ticket/$airplaneTicket] ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) *
        q!: * взросл* * ($buyVerbPast/$bookPast/$orderPast) * $childAdj * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит))
        q!: * взросл* * ($buyVerbPast/$bookPast/$orderPast) * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * ($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) * $childAdj [$ticket/$airplaneTicket]

        # 4EX: Здравствуйте. Купили билет на рейс u253. Как теперь докупить билет ребёнку на этот же рейс??
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) (($ticket/$airplaneTicket) * $childAll / $childAdj ($ticket/$airplaneTicket))} *
         # 4EX: Здравствуйте. Купила авиабилет. Полярный Москва на 5 июня. Сейчас хочу взять с собой ребенка .4 года. Как мне это сделать?
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $take * $childAll *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $take * $childAll *
        q!: * ($buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $childAll * $take *
        q!: * ($ticket/$airplaneTicket) * ($buyVerbPast/$bookPast/$orderPast) * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $childAll * $take *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $take * $childAll * ($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * $childAll * $take * ($buyVerbPast/$bookPast/$orderPast) ($ticket/$airplaneTicket) *
        # 4EX: как докупить билет на ребенка?
        # 4EX: как оформить отдельный билет на ребенка?
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * {($issueVerbInf/$buyInf/$orderVerbInf/$orderMoreVerbInf) отдельн* (($ticket/$airplaneTicket) * $childAll/[отдельн*] $childAdj ($ticket/$airplaneTicket))} [$markQuestion]
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) * {(докупит*/докупат*) (($ticket/$airplaneTicket) * $childAll/[отдельн*] $childAdj ($ticket/$airplaneTicket))} [$markQuestion]
        a: Если вы уже купили билет для взрослого и теперь вам нужно оформить билет на ребенка, вам необходимо: \n • Оформить для него билет как для взрослого и указать некорректную «взрослую» дату рождения, чтобы система позволила его забронировать. \n • Написать нам письмо, указав номер этого заказа, верную дату рождения ребенка, а также номер билета и ФИО взрослого пассажира, который полетит с ребенком. \n • Мы рассчитаем новую цену билета для ребенка. Вы получите сообщение о том, что стоимость заказа изменилась, если у авиакомпании есть детский тариф. \nТОЛЬКО ПОСЛЕ ЭТОГО МОЖНО ОПЛАТИТЬ БРОНЬ \nЕсли оплата поступит раньше, изменить категорию билета мы уже не сможем. \nЕсли вы приобретаете билеты а/к Победа, поменять категорию билета можно только обратившись напрямую в а/к.



    state: boughtTicketAddKid
        # 4EX: Здравствуйте . Я приобрел на сайте авиабилет Владивосток - Денпасар . Хотел бы добавить еще одного пассажира в этот билет - ребенка 6 лет . Как я могу это сделать ?
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (добавит*/внести/докупит*/докупат*) * $childAll *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode * (добавит*/внести/докупит*/докупат*) * $childAll *
        q!: * (добавит*/внести/докупит*/докупат*) * $childAll * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * (добавит*/внести/докупит*/докупат*) * $childAll * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * $iataAndRailway::fromCode * $iataAndRailway::destCode *
        q!: * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) * (добавит*/внести/докупит*/докупат*) * $childAll *
        q!: * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * (добавит*/внести/докупит*/докупат*) * $childAll *
        q!: * (добавит*/внести/докупит*/докупат*) * $childAll * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) * ($ticket/$airplaneTicket/$flight) *
        q!: * (добавит*/внести/докупит*/докупат*) * $childAll * ($ticket/$airplaneTicket/$flight) * ($issueVerbPast/$buyVerbPast/$bookPast/$orderPast) *
        go!: /kidsFAQ/issueTicketForKid
