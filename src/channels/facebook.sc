patterns:
    $facebook = (~facebook|~fb|~фб|~фейсбук|~фбук)

theme: /

    state: HowConnectFacebook
        q!: * Как подключить $facebook *
        a: Подробная инструкция [тут](https://help.aimylogic.com/ru/article/facebook-55w8zq).
        
    state: NotWorkingVk
        q!: * $facebook * $notworking *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/ru/article/facebook-55w8zq).
        
        state: YesContextFacebook
            q: * $yes *
            a: В таком случае оператор ответит вам в рабочее время, могу еще предложить переподключить канал.
            
        state: YesConnectFacebook
            q: * $connect *
            a: Хм... Тогда ждем оператора. Ваш диалог обязательно увидят и ответят в рабочее время.
          
        state: NoContextFacebook
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/facebook-55w8zq).
     
    state: Facebook
        q!: * $facebook *
        a: Документация по работе с каналом Facebook [тут](https://help.aimylogic.com/ru/article/facebook-55w8zq).
