patterns:
    $chatapi = (~chat api|~api|~чат api|~чат апи|~апи)

theme: /

    state: HowConnectChatApi
        q!: * Как (подключить|использовать) $chatapi *
        a: У нас есть [инструкция](https://help.aimylogic.com/ru/article/chat-api-1wwrnj7) по использованию Chat API, которая поможет вам использовать его.
        
    state: NotWorkingChatApi
        q!: * $chatapi * $notworking *
        a: Вы подключали Chat API по [этой инструкции](https://help.aimylogic.com/ru/article/chat-api-1wwrnj7).
        
        state: YesContextChatApi
            q: * $yes *
            a: В таком случае оператор ответит вам в рабочее время, могу еще предложить переподключить канал :)
            
        state: YesConnectChatApi
            q: * $connect *
            a: Хм... Тогда ждем оператора. Ваш диалог обязательно увидят и ответят в рабочее время :)
          
        state: NoContextChatApi
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).
     
    state: ChatApi
        q!: * $chatapi *
        a: Документация по работе с каналом Chat API [тут](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).
