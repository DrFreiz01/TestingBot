patterns:
    $alexa = (~alexa|~алекса|~amazon alexa)

theme: /

    state: HowConnectAlexa
        q!: * Как подключить $alexa *
        a: Подробная инструкция [тут](https://help.aimylogic.com/en/article/amazon-alexa-1ozbby9).
        
    state: NotWorkingAlexa
        q!: * $alexa * $notworking *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/en/article/amazon-alexa-1ozbby9).
        
        state: YesContextAlexa
            q: * $yes *
            q: * $connect *
            a: В таком случае оператор ответит вам в рабочее время.
          
        state: NoContextAlexa
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/en/article/amazon-alexa-1ozbby9).
    
    state: Alexa
        q!: * $alexa *
        a: Документация по работе с каналом Amazon Alexa [тут](https://help.aimylogic.com/en/article/amazon-alexa-1ozbby9).
