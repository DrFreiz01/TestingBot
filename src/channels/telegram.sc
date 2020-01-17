patterns:
    $telegram = (telegram*|телег*|тг|tg)

theme: /

    state: HowConnectTelegram
        q!: * как (подключ*|подклчюить) $telegram [*]
        a: Если вас интересует канал Telegram, рекомендую ознакомиться с [данной статьей](https://help.aimylogic.com/ru/article/telegram-1cccy3d).
        
    state: NotWorkingTelegram
        q!: * {[*] $telegram [*] $notworking [*]} *
        q!: * {[*] $notworking [*] $telegram [*]} *
        q!: * {не получается [*] подключить [*] [канал] $telegram}
        q!: * $notworking $telegram *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/ru/article/telegram-1cccy3d).
        
        state: YesContextTelegram
            q: * $yes *
            q: * $connect *
            a: Спасибо. Наши операторы технической поддержки помогут вам с этим вопросом в рабочее время. Вам придет оповещение об ответе на почту.
          
        state: NoContextTelegram
            q: * $no *
            a: Предлагаю вам подключить канал по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/telegram-1cccy3d).
     
#    state: Telegram
#        q!: * $telegram *
#        q!: * телег* *
#        a: Если вас интересует канал Telegram, рекомендую ознакомиться с данной статьёй: https://help.aimylogic.com/ru/article/telegram-1cccy3d/
