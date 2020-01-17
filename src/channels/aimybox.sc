patterns:
    $aimybox = (~aimybox|~аимибокс|~эмибокс|~эймибокс)

theme: /

    state: HowConnectAimybox
        q!: * Как подключить $aimybox *
        a: Подробная инструкция [тут](https://help.aimylogic.com/ru/article/aimybox-1tviugk).
        
    state: NotWorkingAimybox
        q!: * $aimybox * $notworking *
        a: Вы канал подключали по [этой инструкции](https://help.aimylogic.com/ru/article/aimybox-1tviugk)?
        
        state: YesContextAimybox
            q: * $yes *
            a: В таком случае оператор ответит вам в рабочее время. Попробуйте переподключить канал.
            
        state: YesConnectAimybox
            q: * $connect *
            a: В таком случае оператор ответит вам в рабочее время. Попробуйте переподключить канал.
          
        state: NoContextAimybox
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/aimybox-1tviugk).
    
    state: Aimybox
        q!: * $aimybox *
        a: Документация по работе с каналом Aimybox [тут](https://help.aimylogic.com/ru/article/aimybox-1tviugk).
