patterns:
    $yandex = (~яндекс|~яндекс алиса|~алиса)

theme: /

    state: HowConnectYandex
        q!: * Как подключить $yandex *
        a: Подробная инструкция [тут](https://help.aimylogic.com/ru/article/yandeks-alisa-vsyo-o-kanale-1p76p3w).
        
    state: NotWorkingYandex
        q!: * $yandex * $notworking *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/ru/article/yandeks-alisa-vsyo-o-kanale-1p76p3w)?
        
        state: YesContextYandex
            q: * $yes *
            a: В таком случае оператор ответит вам в рабочее время, могу еще предложить переподключить канал.
            
        state: YesConnectYandex
            q: * $connect *
            a: Хм... Тогда ждем оператора. Ваш диалог обязательно увидят и ответят в рабочее время.
          
        state: NoContextYandex
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/yandeks-alisa-vsyo-o-kanale-1p76p3w).
    state: Yandex
        q!: * $yandex *
        a: Документация по работе с каналом Яндекс Алиса [тут](https://help.aimylogic.com/ru/article/yandeks-alisa-vsyo-o-kanale-1p76p3w).
