require: requirements.sc


theme: /
    state: Start
        q!: $regex</start>
        if: !$client.name
            a: Здравствуйте! Как я могу к вам обращаться?
            go!: /Start/GetName
        else:
            a: Здравствуйте! Чем я могу вам помочь?

        state: GetName
            state:
                q: * @pymorphy.name *
                script: $client.name = $parseTree.value
                a: Чем могу помочь, {{ $client.name }}?

            state:
                event: noMatch
                a: Чем я могу вам помочь?

    state:
       event!: noMatch
       a: Пожалуйста, уточните запрос.