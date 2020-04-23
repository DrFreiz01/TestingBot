theme: /paymentOptions



    state: paymentOptions
        # 4EX: как оплатить билеты
        q!: * ($how/$want/$need2/{$canSg1 [ли] (я/йа)}) * ($paymentAll/$payInf) [за] ($ticket/$airplaneTicket) [$markQuestion]
        q!: * ($how/$want/$need2/{$canSg1 [ли] (я/йа)}) * {($ticket/$airplaneTicket) ($paymentAll/$payInf)} *
        q!: {($ticket/$airplaneTicket) ($paymentAll/$payInf)} [$markQuestion]
        a: Заказ на Ozon.Travel можно оплатить любым удобным для вас способом: банковской картой, электронными деньгами, и наличными — через терминалы оплаты QIWI и «Элекснет», в салонах «Евросети», банковским переводом.


        state: creditCard
            q: [по/с пом/с помощью/при помощи/с] [банк*] (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой)
            go!: /paymentOptions/paymentCreditCard


        state: euroset
            q: [с пом/с помощью/при помощи/в/через/черес] (евросет*/евро ~сеть)
            go!: /paymentOptions/paymentEuroset


        state: webMoney
            q: [по/с пом/с помощью/при помощи/с/через/черес] $webMoney
            go!: /paymentOptions/paymentWebMoney


        state: qiwi
            q: [по/с пом/с помощью/при помощи/с/через/черес] $qiwi
            go!: /paymentOptions/paymentQiwi


        state: eleksnet
            q: [по/с пом/с помощью/при помощи/с/через/черес] $eleksnet
            go!: /paymentOptions/paymentEleksnet


        state: contact
            q: [по/с пом/с помощью/при помощи/с/через/черес] (contacr/contact/~контакт/~кконтакт)
            go!: /paymentOptions/paymentContact


        state: ozon
            q: [по/с пом/с помощью/при помощи/с/через/черес] (пользровательск* $accountSg/пользовательск* $accountSg)
            go!: /paymentOptions/paymentOzon



    state: paymentCreditCard
        # 4EX: как оплатить билет банковской картой online
        q!: * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} [по/с пом/с помощью/при помощи/с] [банк*] (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) *
        q!: * (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} *
        q!: * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} [по/с пом/с помощью/при помощи/с] [банк*] (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) *
        q!: * (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} *
        q!: * $paymentAll (принима*/берет*/береш*) * [по/с пом/с помощью/при помощи/с] [банк*] (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) [$markQuestion]
        q!: * [по/с пом/с помощью/при помощи/с] [банк*] (карте/карты/картой/катре/катры/катрой/кредитке/кредитки/кредиткой/кедитке/кедитки/кедиткой/креитке/креитки/креиткой/кридитке/кридитки/кридиткой) * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Мы принимаем к оплате карты всех типов, кроме Maestro (18 цифр в номере) и American Express. При оформлении заказа на этапе оплаты выберите «Банковская карта» и нажмите «Подтвердить». Вы будете перенаправлены на страницу платежной системы, где нужно будет ввести данные банковской карты и завершить платеж.



    state: paymentEuroset
        # 4EX: как оплатить билеты в салонах «Евросети»
        q!: * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} [с пом/с помощью/при помощи/в/через/черес] (евросет*/евро ~сеть) *
        q!: * (евросет*/евро ~сеть) {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} *
        q!: * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} [с пом/с помощью/при помощи/в/через/черес] (евросет*/евро ~сеть) *
        q!: * (евросет*/евро ~сеть) * {($paymentAll/$payInf/$buyInf/$buyNoun) [за] ($ticket/$airplaneTicket)} *
        q!: * $paymentAll (принима*/берет*/береш*) * (евросет*/евро ~сеть) [$markQuestion]
        q!: * (евросет*/евро ~сеть) * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Заказ можно оплатить наличными в любом салоне «Евросети» на территории РФ. Не забудьте взять с собой квитанцию на оплату или номер заказа. Заказ вы можете оплатить сами или попросить кого-то сделать это за вас. Обратите внимание, если сумма платежа больше 15 000 рублей, при себе необходимо иметь паспорт. \nНайти адрес ближайшего салона можно по ссылке: https://www.ozon.travel/actions/euroset



    state: paymentWebMoney
        # 4EX: способы заплатить за авиабилеты электронными деньгами
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * [по/с пом/с помощью/при помощи/с/через/черес] $webMoney *
        q!: * $webMoney * ($paymentAll/$payInf/$buyInf/$buyNoun) *
        # 4EX: вы webmoney к оплате принимаете?
        q!: * $paymentAll (принима*/берет*/береш*) * $webMoney [$markQuestion]
        q!: * $webMoney * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Перед оплатой убедитесь, что у вас есть пополненный кошелек на Яндекс Деньгах или WebMoney. Более подробную информацию можно найти по ссылке: https://www.ozon.travel/help/avia/how-to/pay



    state: paymentQiwi
        # 4EX: Оплата через терминалы QIWI и VISA QIWI WALLET
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * [по/с пом/с помощью/при помощи/с/через/черес] $qiwi *
        q!: * $qiwi * ($paymentAll/$payInf/$buyInf/$buyNoun) *
        q!: * $paymentAll (принима*/берет*/береш*) * $qiwi [$markQuestion]
        q!: * $qiwi * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Оплата со счета QIWI-кошелька (VISA QIWI WALLET) — без комиссий. Но за пополнение кошелька платежная система может удержать комиссию, ее размер зависит от способа пополнения. Счет VISA QIWI WALLET можно пополнить в терминалах QIWI и терминалах партнеров, в салонах сотовой связи, в супермаркетах, в банкоматах и через интернет-банк. Более подробную информацию можно найти по ссылке: https://www.ozon.travel/help/avia/how-to/pay



    state: paymentEleksnet
        # 4EX: Оплата через терминалы «Элекснет»
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * [по/с пом/с помощью/при помощи/с/через/черес] $eleksnet *
        q!: * $eleksnet * ($paymentAll/$payInf/$buyInf/$buyNoun) *
        q!: * $paymentAll (принима*/берет*/береш*) * $eleksnet [$markQuestion]
        q!: * $eleksnet * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Оплатить заказ можно наличными через любой терминал «Элекснет». Для этого: \n• Найдите ближайший к вам терминал «Элекснет». \n• Выберите в главном меню «Оплата услуг», в новом меню выберите «Билеты, транспорт, штрафы ГИБДД» в верхнем правом углу. \n• Выберите Ozon.Travel, введите номер своего заказа и подтвердите сумму платежа. Максимальная сумма платежа — 15 000 рублей, комиссии нет.



    state: paymentContact
        # 4EX: Оплата через систему платежей CONTACT
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * [по/с пом/с помощью/при помощи/с/через/черес] (contacr/contact) *
        q!: * (contacr/contact) * ($paymentAll/$payInf/$buyInf/$buyNoun) *
        q!: * $paymentAll (принима*/берет*/береш*) * (contacr/contact) [$markQuestion]
        q!: * (contacr/contact) * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: При оформлении заказа на этапе оплаты выберите CONTACT. После этого в Личном кабинете появится квитанция на оплату, распечатайте ее. Затем: \n• Найдите ближайший пункт приема платежей CONTACT: https://www.contact-sys.com/where/point/OZTP.html \n• В кассе покажите удостоверение личности, назовите номер заказа в Ozon.Travel и сумму платежа \n• Оплатите заказ и получите квитанцию об оплате



    state: paymentOzon
        # 4EX: Оплата с пользовательского счета Ozon.Travel
        q!: * ($paymentAll/$payInf/$buyInf/$buyNoun) * [по/с пом/с помощью/при помощи/с/через/черес] (пользровательск* $accountSg/пользовательск* $accountSg) *
        q!: * (пользровательск* $accountSg/пользовательск* $accountSg) * ($paymentAll/$payInf/$buyInf/$buyNoun) *
        q!: * $paymentAll (принима*/берет*/береш*) * (пользровательск* $accountSg/пользовательск* $accountSg) [$markQuestion]
        q!: * (пользровательск* $accountSg/пользовательск* $accountSg) * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: В вашем Личном кабинете на Ozon.Travel есть пользовательский счет: http://www.ozon.travel/my/account. На него зачисляются деньги при возврате или отказе от оплаченного заказа. Эти деньги вы можете использовать для оплаты других билетов — полностью или частично. \nДля этого при оформлении заказа на этапе оплаты выберите «Персональный счет». \nЧтобы оплатить заказ частично, в специальном поле введите сумму, которую вы хотите списать, и нажмите «Использовать». Обновите страницу заказа, итоговый счет будет автоматически пересчитан. Закончите оформление заказа и доплатите недостающую сумму любым удобным способом.



    state: googleSamsungApplePay
        # 4EX: Добрый день. Как купить билет РЖД через Google Pay или Samsung Pay через Ваше приложение?
        q!: * {($buyInf/$buyNoun) * ($ticket/$airplaneTicket)} * (gpay/(Google/apple/samsung/sumsung/android) pay/(аппл/эппл/самсунг/андроид/гугл) пэй) *
        q!: * (gpay/(Google/apple/samsung/sumsung/android) pay/(аппл/эппл/самсунг/андроид/гугл) пэй) * {($buyInf/$buyNoun) * ($ticket/$airplaneTicket)} *
        q!: * $paymentAll (принима*/берет*/береш*) * (gpay/(Google/apple/samsung/sumsung/android) pay/(аппл/эппл/самсунг/андроид/гугл) пэй) [$markQuestion]
        q!: * (gpay/(Google/apple/samsung/sumsung/android) pay/(аппл/эппл/самсунг/андроид/гугл) пэй) * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        go!: /operator/goToOpeartor



    state: paymentWithCash
        # 4EX: Здравствуйте наличными можно купить билеты ?
        q!: * $moneyCash * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($buy/$payInf) ($ticket/$airplaneTicket)} [$markQuestion]
        q!: * ($how/$want/$need2/$canSg1 ([ли] (я/йа)/ли [я/йа]) / (я/йа) $canSg1/$possiblePredic) * {($buy/$payInf) ($ticket/$airplaneTicket)} *  $moneyCash [$markQuestion]
        q!: * $paymentAll (принима*/берет*/береш*) * $moneyCash [$markQuestion]
        q!: * $moneyCash * $paymentAll (принима*/берет*/береш*) [$markQuestion]
        a: Вы можете оплатить заказ наличными в любом салоне «Евросети», через терминал QIWI или «Элекснет», а также через систему платежей CONTACT. Более подробную информацию можно найти по ссылке: https://www.ozon.travel/help/avia/how-to/pay

