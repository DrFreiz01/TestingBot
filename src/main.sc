# -----------------------------------------------------------------------------
# ------------------------ Подключение слот-филинга ---------------------------
# -----------------------------------------------------------------------------

#подключаем модуль слот-филлинга
require: slotfilling/slotFilling.sc
    module = sys.zb-common

# -----------------------------------------------------------------------------
# ------------------------ Подключение справочников ---------------------------
# -----------------------------------------------------------------------------

#Справочник функций javascript
require: scripts/functions.js

#Справочник цифр
require: number/number.sc
    module = common

#Справочник Бизнес-юнитов
require: dictionaries/bunits.csv
    name = bunit
    var = $bunit

#Справочник городов
require: dictionaries/cities-ru.csv
    name = city
    var = $city

#Справочник паттернов
require: scenarios/patterns.sc

# -----------------------------------------------------------------------------
# -------------------------- Подключение сценариев ----------------------------
# -----------------------------------------------------------------------------

require: scenarios/001-skill-SDD-SetDeliveryData.sc
require: scenarios/002-skill-GTI-GetTreatmentInfo.sc
require: scenarios/003-faq-Loyalty.sc

#require: scenarios/temp-dempo_for_ceo.sc
#require: scenarios/temp_edu02.sc
#require: scenarios/temp_razmetka.sc

# -----------------------------------------------------------------------------
# --------------------------- Скрипты-обработчики -----------------------------
# -----------------------------------------------------------------------------

init:

# Запрос переопределение всех ошибок

    bind("onAnyError", function($context) {
        $reactions.answer('К сожалению, по техническим причинам я не смогу сейчас помочь. Задайте другой вопрос или введите "[Переключи на оператора]"');
        $reactions.inlineButtons({text: "Переключить на оператора", transition: "/Operator"})
    });

# Глобальные таймауты при неответе клиента (300 сек = 5 мин)

    #Только, когда находимся в любом стейте, кроме прощания, оценки или закрытия сессии
    bind("postProcess", function() {
        if (!$jsapi.context().currentState.startsWith("/CloseSessionByTimeout")
        && !$jsapi.context().currentState.startsWith("/CloseSession")
        && !$jsapi.context().currentState.startsWith("/Оценка")
        && !$jsapi.context().currentState.startsWith("/Оценка/ОценкаКомментарий")
        && !$jsapi.context().currentState.startsWith("/Оценка/ОценкаКомментарий/ОценкаЗакрытие")
        && !$jsapi.context().currentState.startsWith("/Operator/Switch")) {
            $reactions.timeout({interval: 300, targetState: '/CloseSessionByTimeout'});
    }        
    });

    #Только, когда находимся в стейтах прощания или оценки
    bind("postProcess", function() {
        if ($jsapi.context().currentState.startsWith("/Bye")
        || $jsapi.context().currentState.startsWith("/Оценка")
        || $jsapi.context().currentState.startsWith("/Оценка/ОценкаКомментарий")
        || $jsapi.context().currentState.startsWith("/Оценка/ОценкаКомментарий/ОценкаЗакрытие")) {
            $reactions.timeout({interval: 300, targetState: '/CloseSession'});
    }        
    });

# Переопределение ответа бота, когда он начинает повторяться

    bind("postProcess", function($context) {
        var currentAnswer = $context.response.replies.reduce(function(allAnswers, reply) {
            allAnswers += reply.type === "text" ? reply.text : "";  
            return allAnswers;
        },"");
        if ($context.session.lastAnswer === currentAnswer) {
            $context.response.replies = [
            {
                "type":"text",
                "text":".."
            }
            ];
            $reactions.transition("/Operator");
        }
        $context.session.lastAnswer = currentAnswer;
    });

# Переопределение последовательнсоти матчера

    bind("selectNLUResult", function(ctx) {                 // задаем обработчик для фазы `selectNLUResult`
        log(ctx.nluResults);                                // выводим результаты в лог

    if (ctx.nluResults.intents.length > 0) {
      ctx.nluResults.selected = ctx.nluResults.intents[0];  // используем результат от интентов
      return;
    }

    if (ctx.nluResults.patterns.length > 0) {
      ctx.nluResults.selected = ctx.nluResults.patterns[0];  // если результата от интентов нет, используем паттерны
      return;
    }

    if (ctx.nluResults.examples.length > 0) {
      ctx.nluResults.selected = ctx.nluResults.examples[0];  // если результата от интентов и паттернов нет, используем примеры
    }

    })

# Глобальные конвертеры

    if (!$global.$converters) {
        $global.$converters = {};
    }
    $global.$converters
        .BunitCSVConverter = function(parseTree) {
            var id = parseTree.bunit[0].value;
            return $bunit[id].value;
        };
    $global.$converters
        .CityCSVConverter = function(parseTree) {
            var id = parseTree.city[0].value;
            return $city[id].value;
        };

# Сбор истории переписки для команды switch
# Запрос препроцесс собирает реплики клиента, а постпроцесс - реплики бота

    $jsapi.bind({
        type: "preProcess",
        name: "savingVisitorChatHistory",
        path: "/",
        handler: function($context) {
            $context.client.chatHistory = $context.client.chatHistory || [];
            var chatHistory = $context.client.chatHistory;
            if ($context.request.query) {
                chatHistory.push({type: "Клиент", text:$context.request.query});
            }
            chatHistory.splice(0, chatHistory.length - 10);
        }
    });
    $jsapi.bind({
        type: "postProcess",
        name: "savingBotChatHistory",
        path: "/",
        handler: function($context) {
            $context.client.chatHistory = $context.client.chatHistory || [];
            var chatHistory = $context.client.chatHistory;
            if ($context.response.replies) {
                $context.response.replies
                    .filter(function(val) { return val.type === "text"; })
                    .forEach(function(val) { chatHistory.push({ type:"BOT", text: val.text }); });
            }
            chatHistory.splice(0, chatHistory.length - 10);
        }
    });
    
# -----------------------------------------------------------------------------
# ----------------------------- Главный сценарий ------------------------------
# -----------------------------------------------------------------------------

theme: /

    state: Начало
        intent!: /Общие/MainMenu
        q!: (*start/*старт/*ыефке/*cnfhn)
        a: Здравствуйте! Я виртуальный помощник компании Hoff — быстро обучаюсь и уже могу:
           - ответить на вопросы о программе лояльности Hoff ([купоны], [сертификаты], бонусные и подарочные карты);
           - [уточнить статус обращения];
           - [назначить дату доставки] по заказу;
           - по остальным вопросам я подключаю к диалогу компетентных специалистов с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику работы горячей линии Hoff</a>. Продолжая диалог, Вы даёте своё согласие на [обработку персональных данных]. Для улучшения работы нашего сервиса диалог с Вами может быть сохранен.
           Какой у Вас вопрос?

        #Уточнение доступных навыков бота
        state: ЧтоТыУмеешь
            intent!: /Общие/ЧтоТыУмеешь
            q: * все навыки *
            script:
                sleep();
            a: Я могу:
               - [Назначить дату доставки] по заказу
               - [Уточнить статус обращения]
               - Ответить на вопросы по программе лояльности Hoff (по купонам, бонусам, сертификатам и подарочным картам)
               - По всем остальным вопросам я подключаю к беседе компетентных специалистов. Задайте мне любой вопрос о компании Hoff и я постараюсь ответить как можно быстрее.
        
        state: УточнитеВопрос
            intent!: /Общие/УточнитеВопрос
            script:
                sleep();
            random:
                a:  Уточните, пожалуйста, вопрос.
                a:  Прошу Вас уточнить вопрос.
                a:  Опишите подробнее Ваш вопрос.
        

# ------------------- Действие, если бот непонимает клиента -------------------
    
    #отлов всех нераспознанных фраз клиента
    state: CatchAll
        event!: noMatch
        script:
            sleep();
        #a: Вы сказали: {{ $request.query }}
        go!: /Operator

# ------------------------- Переключение на оператора -------------------------

    #можно просто написать "ожидайте, пожалуйста..." 
    state: Operator
        intent!: /Общие/Operator
        script:
            sleep();
        a: Ожидайте, пожалуйста...
           - подключаю к нашей бееседе оператора.
           Для возврата к виртуальному помощнику введите любую из команд без ковычек:
           - "/close", "/bot"
           - "/закрыть чат", "/вернуть бота"
        go!: ./Switch

        state: Switch
            script:
                $response.replies.push({
                    type:"switch",
                    appendCloseChatButton: true,
                    closeChatPhrases: ["/close", "/сдщыу",
                                        "/bot", "/ище","/бот", "/,jn",
                                        "/закрыть чат", "/pfrhsnm xfn", "/закройте чат", "/pfrhjqnt xfn", "/закрой чат", "/pfrh* xfn",
                                        "/вернуть бота", "/dthyenm ,jnf", "/верните бота", "/dthybnt ,jnf", "/верни бота", "/dthyb ,jnf",
                                        "\close", "\сдщыу",
                                        "\bot", "\ище","\бот", "\,jn",
                                        "\закрыть чат", "\pfrhsnm xfn", "\закройте чат", "\pfrhjqnt xfn", "\закрой чат", "\pfrh* xfn",
                                        "\вернуть бота", "\dthyenm ,jnf", "\верните бота", "\dthybnt ,jnf", "\верни бота", "\dthyb ,jnf",
                                        "закрыть чат", "pfrhsnm xfn", "закройте чат", "pfrhjqnt xfn", "закрой чат", "pfrh* xfn",
                                        "вернуть бота", "dthyenm ,jnf", "верните бота", "dthybnt ,jnf", "верни бота", "dthyb ,jnf"],
                    firstMessage: $context.client.chatHistory.map(function(val) {return val.type + "\n" + val.text;}).join("\n\n"),
                    lastMessage: "Мы ждем Вас снова!",
                    attributes: {
                        "LiveChatTranscript": "История чата",
                        "platform": "Платформа"
                    }
                });
            
            #Действие, если оператор закрыл чат или клиент послал закрывающую фразу
            state: livechatFinished
                event!: livechatFinished
                q: (*close | *сдщыу)
                q: (*bot | *ище | *бот | *,jn)
                q: (*закрыть чат | *pfrhsnm xfn | *закройте чат | *pfrhjqnt xfn | *закрой чат | *pfrh* xfn)
                q: (*вернуть бота | *dthyenm ,jnf | *верните бота | *dthybnt ,jnf | *верни бота | *dthyb ,jnf)
                a: ——— Оператор отключен ———
                   - с Вами снова виртуальный помощник
                go!: /Оценка
            
            #Действие, если нет доступных операторов в линии
            state: NoOperatorsOnline
                event!: noLivechatOperatorsOnline
                a: — Нет доступных операторов —
                   - с Вами снова виртуальный помощник
                   Напишите другой вопрос или попробуйте позже.

# ---------------- Реакции на системные события (ивенты)  ---------------------

    state:
        event!: sendFile
        a: ——— Ваш файл получен ———

# ------ Действие если пользователь написал, что у него есть вопрос   ---------

    state: ЕщеВопросы
        intent!: /Общие/ЕщеВопросы
        intent!: /Общие/Hello
        script:
            sleep();
        random:
            a: Чем могу помочь?
            a: Какой Ваш вопрос?
            a: Что бы Вы хотели обсудить?
            a: В чём Ваш вопрос?

# ---------------------- Прощание перед закрытием чата ------------------------
    
    #Прощание с клиентом
    state: Bye
        intent!: /Общие/Bye
        script:
            sleep();
        random:
            a: До свидания! Появятся вопросы - обращайтесь.
            a: Всего хорошего, будут вопросы - обращайтесь.
            a: Я прощаюсь с Вами, при возникновении вопросов - обращайтесь, буду рад помочь.
        go!: ../Оценка
    
    #Оценка удовлетворенности клиента
    state: Оценка
        intent!: /Общие/CloseSession
        script:
            sleep();
        a: Всё ли Вам понравилось?
           - поставьте, пожалуйста, оценку нашему диалогу от 1 до 5 (где 5 - Отлично), либо нажмите на кнопку ниже.
        inlineButtons:   
            {text:"5 Отлично 😁"}
            {text:"4 Хорошо 😉"}
            {text:"3 Норм 😐"}
            {text:"2 Плохо 😤"}
            {text:"1 Ужасно 😡"}
    
        state: ОценкаКомментарий
            q: *
            a: Ваша оценка принята.
               - при желании, напишите свой комменнтарий к оценке одним сообщением и мы его обязательно рассмотрим, либо просто закройте чат.
    
            state: ОценкаЗакрытие
                q: *
                a: Спасибо, что помогаете нам стать лучше! Рады видеть Вас снова.
                go!: /CloseSession

# ---------- Дейстивие, если клиент не отвечает (глобальный таймаут) ----------

    #Закрытие сессии по глобальному таймауту при неответе клиента
    state: CloseSessionByTimeout
        a: —— Время диалога истекло ——
        go!: /Bye

# ----------------------------- Закрытие сессии -------------------------------
    
    #Закрытие сессии
    state: CloseSession
        a: ——— Диалог завершён ———
           - для открытия нового диалога напишите свой вопрос в чат.
        script:
            $jsapi.stopSession();

# ----------------------------- Стейт для тестов  -----------------------------

    #Нужен, когда используется переопределение стейта чтобы в тестах бот не повторял ответы при проверке переходов в один и тот же стейт по синонимичным фразам клиентов
    state: антиповтор
        q!: антиповтор
        a: ....

# ------------------- Ответы на общие частые вопросы  -------------------------

    #Уточнение положений политики конфиденциальности
    state: Конфиденциальность
        intent!: /Общие/Конфиденциальность
        script:
            sleep();
        a: Политика конфиденциальности Hoff была разработана с целью защиты персональных данных клиентов Hoff и соблюдения законодательства Российской Федерации. С ней Вы можете ознакомиться по ссылке <a href="https://hoff.ru/services/privacy_policy/" target="_blank">https://hoff.ru/services/privacy_policy/</a>
