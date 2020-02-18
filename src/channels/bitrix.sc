patterns:
    $bitrix = (битрикс*|~битрикс24|~битрикс 24|б24|б 24|~bitrix|~bitrix 24|откр* лин*)

theme: /

    state: HowConnectBitrix
        q!: * Как подключить $bitrix *
        a: Если вас интересует подключение Bitrix24, инструкцию можете найти [здесь](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).
    
#     state: bitrixBug
#        q!: * не (удает*|получ*|мог*|мож*) * подключить [бот*] * $bitrix * ошибк* *
#        a: Вы подключали канал по этой инструкции? https://help.aimylogic.com/ru/article/bitriks24-ib7uml/
#        a: Если вы следовали инструкции, но безуспешно, то сделайте, пожалуйста, следующее: 1) в Aimylogic удалите от всех ботов канал Битрикс24; 2) удалите приложение Aimylogic в вашем аккаунте Битрикс24; 3) заново по инструкции попробуйте подключить бота к Битрикс24 4) Если вы снова видите сообщение об ошибке, пожалуйста, сообщите точное время (по Москве) в которое возникает эта ошибка.
    
    state: NotWorkingBitrix
        q!: * $bitrix * $notworking *
        a: Вы подключали канал по [этой инструкции](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).
        
        state: YesContextBitrix
            q: * $yes *
            a: Опишите, пожалуйста, что конкретно идёт не так. Пожалуйста, пришлите скриншоты переписки с ботом. Наши операторы поддержки посмотрят и ответят вам в рабочее время. Могу еще предложить переподключить канал.
            
        state: YesConnectBitrix
            q: * $connect *
            a: Хм... Тогда, пожалуй, подождем оператора. Ваш диалог обязательно увидят и ответят в рабочее время.
          
        state: NoContextBitrix
            q: * $no *
            a: Предлагаю вам подключить все же по инструкции. Внимательно выполните все шаги. Подробная инструкция [тут](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).
     
    state: Bitrix
        q!: * $bitrix *
        a: Возможно, вам поможет [документация по работе с Bitrix24](https://help.aimylogic.com/ru/article/bitriks24-ib7uml).

# [$hi] * Как обстоят дела с [решением] проблемы перевод* на оператор*
 
    state: Bitrix24humanagentIssue
        q!: [$hi] * [подскажите] * {перевод* на оператор* * [в] $bitrix} * *раб* *
        q!: * {[какая] * ситуация с * перевод* на оператор* * [в] $bitrix} *
        q!: * (неполадк*|проблем*|сит*) [с] * перевод* на оператор* * [в] $bitrix * (устр*|*чин*|*фикс*|*лад*|*лаж*) *
        a: Если вы хотели бы делать перевод на оператора Bitrix24, то можете ознакомиться с [этой статьей](https://help.aimylogic.com/ru/article/perevod-na-operatora-1skld4l).
    
    state: Bitrix24humanagent
        q!: [$hi] * [подскажите] как * (настро*|подкл*)* {перевод на оператора * [в] $bitrix} *
        a: Чтобы использовать Перевод на оператора Bitrix24, ознакомьтесь, пожалуйста, с [этой статьей](https://help.aimylogic.com/ru/article/perevod-na-operatora-1skld4l).