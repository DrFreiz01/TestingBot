theme: /railwayFaq



    state: serviceFee4Corporate
        # 4EX: каков размер сервисного сбора при покупке жд билетов для корпоративных клиентов?
        q!: * сервисн* сбор* * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] * $railwayTicket *
        q!: * сервисн* сбор* * $railwayTicket * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] *
        q!: * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] * сервисн* сбор* * $railwayTicket *
        q!: * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] * $railwayTicket * сервисн* сбор* *
        q!: * $railwayTicket * сервисн* сбор* * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] *
        q!: * $railwayTicket * (юридич*/юрик*/корпоративн*) [~лицо/~клиент/~заказ] * сервисн* сбор* *
        a: Сервисный сбор в заказах юридических лиц такой же, как для обычных заказов. Его размер можно посмотреть на этапе ввода данных пассажиров и после оформления заказа - в личном кабинете.


    state: railwayTicketPrint
        # 4EX: Здравствуйте,для посадки в поезд нужно ли распечатывать билеты. Спасибо
        q!: * (плацкарт*/купе/купэ/купейн*/купэйн*/$railwayTicket/$train/~станция/~вагон/ласточк*/красн* стрел*/сапсан*/стриж*/STRIZH/~лев толсто*) * (распечат*/распичат*) * $ticket *
        q!: * (плацкарт*/купе/купэ/купейн*/купэйн*/$railwayTicket/$train/~станция/~вагон/ласточк*/красн* стрел*/сапсан*/стриж*/STRIZH/~лев толсто*) * $ticket * (распечат*/распичат*) *
        q!: * (распечат*/распичат*) * $ticket * (плацкарт*/купе/купэ/купейн*/купэйн*/$railwayTicket/$train/~станция/~вагон/ласточк*/красн* стрел*/сапсан*/стриж*/STRIZH/~лев толсто*) *
        q!: * $ticket * (распечат*/распичат*) * (плацкарт*/купе/купэ/купейн*/купэйн*/$railwayTicket/$train/~станция/~вагон/ласточк*/красн* стрел*/сапсан*/стриж*/STRIZH/~лев толсто*) *
        q!: * (распечат*/распичат*) * $railwayTicket *
        q!: * $railwayTicket * (распечат*/распичат*) *
        a: Обычно, если вы прошли электронную регистрацию, при входе на поезд достаточно показать проводнику паспорт. Но мой вам совет: лучше держите при себе хотя бы фото электронного билета (на всякий случай). \nЕсли на электронном билете (контрольном купоне) стоит красная отметка о том, что нужен оригинал билета, обязательно подойдите с паспортом и номером билета в кассу или терминал самообслуживания на вокзале за этим оригиналом. Иначе вас просто не пустят в поезд.



    state: trainRoute
        # 4EX: Подскажите пожалуйста маршрут движение поезда
        q!: * (подскаж*/скаж*/*сказать) * ~маршрут * $railwayAll * $weight<+1> *
        q!: * ~маршрут * $railwayAll * (подскаж*/скаж*/*сказать) * $weight<+1> *
        # 4EX: Как узнать маршрут движения поезда
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) [$oneWord] ~маршрут * $railwayAll * $weight<+1> *
        q!: * $weight<+1> * ~маршрут * $railwayAll * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic [ли]) [$oneWord]
        # 4EX: Здравствуйте,а где посмотреть станции на которых будем останавливаться?
        q!: * $checkAll * станци* * (останов*/останав*) *
        a: Чтобы посмотреть маршрут поезда: \n∙ Пройдите по ссылке: https://www.ozon.travel/railway \n∙ Выберите пункт отправления и прибытия, количество пассажиров, дату поездки и нажмите «Найти». Вы увидите все поезда на выбранный вами день. \n∙ Выберите подходящий поезд и нажмите на стрелку. Рядом с временем отправления поезда будет кнопка «Маршрут», нажмите на нее. На экране появится маршрут вашего поезда.



    state: howToGetFromDestRailwayTicketsRoundtrip
        # 4EX: как купить жд билеты туда и обратно?
        # 4EX: Здравствуйте как заказать билеты на поезд туда и обратно
        # 4EX: Как посмотреть билеты на поезд туда и обратно
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $railwayTicket * $roundTrip *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $railwayAll * $roundTrip *

        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $railwayTicket * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $roundTrip *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $railwayAll * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $roundTrip *

        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $roundTrip * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $railwayTicket *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $roundTrip * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) * $railwayAll *

        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $roundTrip * $railwayTicket * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) *
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * $roundTrip * $railwayAll * ($issueVerb/$buyInf/$orderVerbInf/$payInf/$bookInf/$checkAll/набрат*/$chooseInf) *
        # 4EX: Здравствуйте как проложить маршрут на ЖД туда и обратно?
        q!: * $weight<+1> * ~маршрут * $railwayAll * $roundTrip *
        q!: * $weight<+1> * ~маршрут * $roundTrip * $railwayAll *
        q!: * $weight<+1> * $railwayAll * ~маршрут * $roundTrip *
        q!: * $weight<+1> * $railwayAll * $roundTrip * ~маршрут *
        q!: * $weight<+1> * $roundTrip * ~маршрут * $railwayAll *
        q!: * $weight<+1> * $roundTrip * $railwayAll * ~маршрут *
        a: Билеты можно купить только в одну сторону. Поэтому, чтобы купить билеты туда и обратно, вам нужно будет оформить два заказа.

