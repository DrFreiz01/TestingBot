theme: /contacts


    state: howToCallYou
        # 4EX: как до вас дозвониться
        q!: * $how * (до (вас/вас)/вам/$ozonTravel) * (дозвон*/дозван*/позвон*/позван*/прозвон*) *
        q!: * $how * (дозвон*/дозван*/позвон*/позван*/прозвон*) * (до (вас/вас)/вам/$ozonTravel) *
        a: Вы можете задать свой вопрос в онлайн-чате, наши операторы вам быстро помогут. Также вы можете позвонить по телефону +7 495 787-28-88.



    state: hotLine
        # 4EX: Добрый день, у вас есть телефон горячей линии?
        # 4EX: Здравствуйте.если у вас горячая линия
        # 4EX: дайте номер горячей линии, пожалуйста.
        # 4EX: Мне нужен номер горячей линии
        # 4EX: у вас есть горячая линия?
        # 4EX: Номер телефона горячей линии
        # 4EX: Озон Трэвел номер горячей линии
        q!: * горяч* ~линия *
        go!: /faq/howToCallYou



    state: cantGetThrough
        # 4EX: не могу дозвониться
        q!: * (хер/хрен/чертос два/чортос два/чертосдва/чортосдва) [до вас] (дозвониш*/дозваниш*) *
        q!: * (хер/хрен/чертос два/чортос два/чертосдва/чортосдва) до ваш* * (дозвониш*/дозваниш*) *
        q!: * ($telephone/обзвонилс*/обзвонилис*) * (занят*/занит*) *
        q!: * ($telephone/обзвонилс*/обзвонилис*) * (занято/зането/занят/занет) *
        q!: * (горяч*/горч*) лин* [у вас/увас] $oneWord $oneWord (не/ен) (работ*/робот*) *
        q!: * (горяч*/горч*) лин* [у вас/увас] $oneWord (не/ен) (работ*/робот*) *
        q!: * (занят*/занит*) * ($telephone/обзвонилс*/обзвонилис*) *
        q!: * (занято/зането/занят/занет) * ($telephone/обзвонилс*/обзвонилис*) *
        q!: [$beginningWords] [йа/я] {$cannot2 (дозвони*/дозвани*/дозсвон*/дозсван*)}
        q!: * { $cannot2 * (дозвони*/дозвани*/дозсвон*/дозсван*) * (до вас/вам/$ozonTravel) } *
        q!: * {$impossibly * (дозвониться/прозвониться/дозвонится/прозвонится/дозвон*) * (до вас/вам/$ozonTravel)} *
        q!: * {(сложно/сложна) * (дозвониться/прозвониться/дозвонится/прозвонится/дозвон*) * (до вас/вам/$ozonTravel)} *
        q!: [$beginningWords] (написать/писать) [мне] $whereTo
        q!: [$beginningWords]($how/$whereTo/кому) [я] [могу/можу/могк] (написать/писать)
        q!: [$hello2/$hi] [$beginningWords] [$interjections] {(перезвони*/перизвони*/перзвони*) [$please]} [на [$telephoneNumber]] $mobilePhoneNumberDig
        if: $context.currentState == $client.executeState
            go!: /operator/goToOpeartor
        else:
            a: Возможно, я смогу помочь. Вы можете задать свой вопрос здесь.