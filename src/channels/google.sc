patterns:
    $google = (~google|~google assistant|~гугл ассистент|~ассистент|~assistant)

theme: /

    state: HowConnectGoogle
        q!: * Как подключить $google *
        a: Подробная инструкция [тут](https://help.aimylogic.com/ru/article/google-assistant-b2jld2).
        
    state: NotWorkingGoogle
        q!: * $google * $notworking *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/ru/article/google-assistant-b2jld2).
        
        state: YesContextGoogle
            q: * $yes *
            a: В таком случае оператор ответит вам в рабочее время, могу еще предложить переподключить канал.
            
        state: YesConnectGoogle
            q: * $connect *
            a: Хм... Тогда ждем оператора. Ваш диалог обязательно увидят и ответят в рабочее время.
          
        state: NoContextGoogle
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/google-assistant-b2jld2).
     
    state: Google
        q!: * $google *
        a: Документация по работе с каналом Google Assistant [тут](https://help.aimylogic.com/ru/article/google-assistant-b2jld2).
