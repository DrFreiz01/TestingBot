patterns:
    $sheets = (гугл табл*|google табл*|google sheet*|таблиц*)

# <a href="URL">ссылка</a>

theme: /

#Если вы хотите создать игру с помощью гугл-таблиц, то вам может помочь этот урок: https://help.aimylogic.com/ru/article/kak-sohranyat-informaciyu-o-polzovatele-eapoja
# И ещё есть такой урок (в этом уроке можете пройти только первую часть): https://help.aimylogic.com/ru/article/ispolzovanie-vebhukov-dlya-vychislenij-v-scenarii-47ii61
#<a href="https://help.aimylogic.com/ru/article/ispolzovanie-vebhukov-dlya-vychislenij-v-scenarii-47ii61">ссылка</a>

    state: arrayElements
        q!: Подскажите, есть ли возможность выводить сразу несколько строк из Гугл Таблицы?
        a: Возможно, вам будет интересен укро о том, как выводить сразу несколько элементов массива: https://help.aimylogic.com/ru/article/chtenie-iz-gugl-tablic-kak-vyvesti-neskolko-elementov-massiva-1og2q1x/
    
    state: readSpreadsheet
        q!: {читать из $sheets *}
        q!: * из таблицы гугл отправ* в бот*
        q!: * вывод* инф* из $sheets
        q!: * читать из [гугл] таблиц* *
        q!: * из * таблиц* отправить в бот* *
        q!: * вывод* * из [гугл] таблиц* *
        a: Если вас интересно, как читать данные из гугл таблиц, у нас есть статья об этом: https://help.aimylogic.com/ru/article/chtenie-dannyh-iz-google-tablic-erzuov/\nВ конце статьи вы найдете ссылки на пошаговые уроки
        
#здравствуйте! Подскажите, пожалуйста, какие уроки и статьи у вас на сайте мне лучше посмотреть, чтобы сделать на основе вашей платформы бота-викторину? С использованием гугл таблицы. Т.е бот рандомно вытаскивает из таблицы вопрос (в котором прописаны варианты ответа) и сверяет ответ пользователя с правильным вариантом ответа (который будет указан в той же гугл таблице в отдельном столбце

    state: spreadsheetGame
        q!: * {* викторин* * $sheets *}
        q!: * { * игр* $sheets *}
        a: Если вы хотите создать игру с помощью гугл-таблиц, то вам может помочь <a href="https://help.aimylogic.com/ru/article/kak-sohranyat-informaciyu-o-polzovatele-eapoja">этот урок</a>.
        a: И ещё есть <a href="https://help.aimylogic.com/ru/article/ispolzovanie-vebhukov-dlya-vychislenij-v-scenarii-47ii61">такой урок</a> (первая часть урока посвещена созданию сценария игры).
  
    #здравствуйте! подскажите, а можно взять из excel таблицы значение случайной ячейки (текстовое)
    state: spreadsheetRandom
        q!: * { * (рандом*|случ* *) * $sheets *} *
        a: Если вам нужно выводить случайную строку (ячейку) из таблицы, то это описано в этом уроке: https://help.aimylogic.com/ru/article/pechenki-s-predskazaniyami-lqz38l/