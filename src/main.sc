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

require: scenarios/003-faq-Loyalty.sc
require: scenarios/021-skill-SDD-SetDeliveryData.sc
require: scenarios/022-skill-GTI-GetTreatmentInfo.sc

# ---------------------------- архивные сценарии ------------------------------

#require: scenarios/archive/temp-dempo_for_ceo.sc
#require: scenarios/archive/temp_edu02.sc
#require: scenarios/archive/temp_razmetka.sc

# -----------------------------------------------------------------------------
# --------------------------- Скрипты-обработчики -----------------------------
# -----------------------------------------------------------------------------

init:

# Запрос переопределение всех ошибок

    bind("onAnyError", function($context) {
        $reactions.answer('К сожалению, по техническим причинам я не смогу сейчас помочь: <ul><li>Пожалуйста, задайте свой вопрос позже или обратитесь в Единую Информационную Службу Hoff с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику её работы</a></li></ul>.');
        $reactions.inlineButtons({text: "Контакты ЕИС Hoff", url: "https://hoff.ru/contacts/zagruzhennost-koll-tsentra/"});
    });

#    bind("onAnyError", function($context) {
#        $reactions.answer('К сожалению, по техническим причинам я не смогу сейчас помочь. Задайте другой вопрос или нажмите "[Переключить на оператора]"');
#        $reactions.inlineButtons({text: "Переключить на оператора", transition: "/Operator"})
#    });

        # или <a href="https://hoff.ru/feedback" target="_blank">отправить email в рубрику «Напишите нам» на сайте hoff.ru</a>
        # $reactions.inlineButtons({text: "Форма обращения по Email", url: "https://hoff.ru/feedback"});

# Глобальные таймауты при неответе клиента (120 = 2 мин | 180 = 3 мин | 300 сек = 5 мин)
# метод .startsWith(); проверяет текст, начиная с начала строки, поэтому все вложенные стейты тоже буду ему сответствовать.  

    #Только, когда находимся в любом стейте, кроме уточнения вопросов, прощания, оценки или закрытия сессии
    bind("postProcess", function() {
        if (!$jsapi.context().currentState.startsWith("/ВопросыОстались")                               // кроме стейта, уточняющего наличие доп вопросов у клиента
        &&  !$jsapi.context().currentState.startsWith("/ВопросПереформулируйте")                        // кроме стейта, с просьбой переформулировать вопрос
        &&  !$jsapi.context().currentState.startsWith("/ВопросУточните")                                // кроме стейта, с просьбой уточнить вопрос
        &&  !$jsapi.context().currentState.startsWith("/Начало")                                        // кроме стейта, с приветствием
        &&  !$jsapi.context().currentState.startsWith("/Operator")                                      // кроме стейта, переводящего на стейт Switch
        &&  !$jsapi.context().currentState.startsWith("/CloseSessionByTimeout")                         // кроме стейта, переводящего на стейт Bye по таймауту
        &&  !$jsapi.context().currentState.startsWith("/Bye")                                           // кроме стейта, переводящего на оценку удовлетворенности
        &&  !$jsapi.context().currentState.startsWith("/Оценка")                                        // кроме стейта, уточняющего уровень удовлетовренности у клиента (также на этот стейт попадаем, когда оператор закрывает чат)
        &&  !$jsapi.context().currentState.startsWith("/CloseSession")                                  // кроме стейта, закрывающего сессию
        &&  !testMode())
            {
                $reactions.timeout({interval: 120, targetState: '/ВопросыОстались'});
            }
    });

    #Только, когда находимся в стейте, с приветствием
    bind("postProcess", function() {
        if ($jsapi.context().currentState.startsWith("/Начало")                                         // когда в стейте, с приветствием
        &&  !testMode())
            {
                $reactions.timeout({interval: 600, targetState: '/CloseSession'});
            }
    });

    #Только, когда находимся в стейте, уточняющем не сотались ли еще вопросы
    bind("postProcess", function() {
        if ($jsapi.context().currentState.startsWith("/ВопросыОстались")                                // когда в стейте, уточняющем наличие доп вопросов у клиента
        ||  $jsapi.context().currentState.startsWith("/ВопросПереформулируйте")                         // когда в стейте, с просьбой переформулировать вопрос
        ||  $jsapi.context().currentState.startsWith("/ВопросУточните")                                 // когда в стейте, с просьбой уточнить вопрос
        &&  !testMode())
            {
                $reactions.timeout({interval: 180, targetState: '/CloseSessionByTimeout'});
            }
    });

    #Только, когда находимся в стейтах прощания или оценки
    bind("postProcess", function() {
        if ($jsapi.context().currentState.startsWith("/Bye")                                            // когда в стейте, переводящем на оценку удовлетворенности
        ||  $jsapi.context().currentState.startsWith("/Оценка")                                         // когда в стейте, уточняющем уровень удовлетовренности у клиента (также на этот стейт попадаем, когда оператор закрывает чат)
        &&  !testMode())
            {
                $reactions.timeout({interval: 300, targetState: '/CloseSession'});
            }
    });

# Препроцсс-обработчик, который предупреждает клиента о смене контекста

#    bind("preProcess", function(ctx) {
#        var currConxt = ctx.contextPath;
#        var currState = ctx.currentState;
#        var nextState = ctx.temp.classifierTargetState;
#        if (currState != "/"                                                                    // применить, если текущий контекст - любой...:
#        &&  currState != "/Начало"
#        &&  currState != "/CatchAll"
#        &&  currState != "/ContextChangeAcception")
#            {
#                if (nextState != "/"                                                          // применить, если текущий контекст - любой...:
#                &&  nextState != "/Начало"
#                &&  nextState != "/CatchAll"
#                &&  nextState != "/ContextChangeAcception"
#                &&  currConxt.split("/")[1] != nextState.split("/")[1])
#                    {
#                        ctx.session.lastState = currConxt;
#                        ctx.session.nextState = nextState;
#                        $reactions.transition("/ContextChangeAcception");
#                    }
#            }
#    });

     #пока не работает, непонятно почему
#    bind("preProcess", function(ctx) {
#        var currConxt = ctx.contextPath;
#        var currState = ctx.currentState;
#        var nextState = ctx.temp.classifierTargetState;
#        if (!currState.startsWith("/")                                              // применить, если сейчас мы находимся в любом стейте...:
#        &&  !currState.startsWith("/Начало")
#        &&  !currState.startsWith("/CatchAll")
#        &&  !currState.startsWith("/ContextChangeAcception")
#        &&  !currState.startsWith("/ВопросыОстались")                                   // кроме стейта, уточняющенр наличие доп вопросов у клиента
#        &&  !currState.startsWith("/ВопросПереформулируйте")                            // кроме стейта, с просьбой переформулировать вопрос
#        &&  !currState.startsWith("/ВопросУточните")                                    // кроме стейта, с просьбой уточнить вопрос
#        &&  !currState.startsWith("/Operator")                                          // кроме стейта, переводящего на стейт Switch
#        &&  !currState.startsWith("/Operator/Switch")                                   // кроме стейта, переключающего на оператора
#        &&  !currState.startsWith("/CloseSessionByTimeout")                             // кроме стейта, переводящего на стейт Bye по таймауту
#        &&  !currState.startsWith("/Bye")                                               // кроме стейта, переводящего на оценку удовлетворенности
#        &&  !currState.startsWith("/Оценка")                                            // кроме стейта, уточняющего уровень удовлетовренности у клиента (также на этот стейт попадаем, когда оператор закрывает чат)
#        &&  !currState.startsWith("/Оценка/ОценкаКомментарий")                          // кроме стейта, уточняющего текстовый отзыв у клиента
#        &&  !currState.startsWith("/Оценка/ОценкаКомментарий/ОценкаЗакрытие")           // кроме стейта, прощания с клиентом перед закрытием сессии
#        &&  !currState.startsWith("/CloseSession"))                                     // кроме стейта, закрывающего сессию        
#            {
#                if (nextState != "/Начало"                                                           // применить, если следующим стейтом будет любой...:
#                &&  nextState != "/CatchAll"
#                &&  nextState != "/ВопросыОстались"                                                      // кроме стейта, уточняющего наличие доп вопросов у клиента
#                &&  nextState != "/ВопросПереформулируйте"                                               // кроме стейта, с просьбой переформулировать вопрос
#                &&  nextState != "/ВопросУточните"                                                       // кроме стейта, с просьбой уточнить вопрос
#                &&  nextState != "/Operator"                                                             // кроме стейта, переводящего на стейт Switch
#                &&  nextState != "/Operator/Switch"                                                      // кроме стейта, переключающего на оператора
#                &&  nextState != "/CloseSessionByTimeout"                                                // кроме стейта, переводящего на стейт Bye по таймауту
#                &&  nextState != "/Bye"                                                                  // кроме стейта, переводящего на оценку удовлетворенности
#                &&  nextState != "/Оценка"                                                               // кроме стейта, уточняющего уровень удовлетовренности у клиента (также на этот стейт попадаем, когда оператор закрывает чат)
#                &&  nextState != "/Оценка/ОценкаКомментарий"                                             // кроме стейта, уточняющего текстовый отзыв у клиента
#                &&  nextState != "/Оценка/ОценкаКомментарий/ОценкаЗакрытие"                              // кроме стейта, прощания с клиентом перед закрытием сессии
#                &&  nextState != "/CloseSession"                                                         // кроме стейта, закрывающего сессию
#                &&  currConxt.split("/")[1] != nextState.split("/")[1])
#                    {
#                        ctx.session.lastState = currConxt;
#                        ctx.session.nextState = nextState;
#                        $reactions.transition("/ContextChangeAcception");
#                    }
#            }
#    });

# Препроцесс-обработчик, игнорирующий глобальные интенты в стейте с отзывом, чтобы не тупил.

    bind("preProcess", function(ctx) {
        var currState = ctx.currentState;
        var currContx = ctx.contextPath;
        var nextState = ctx.temp.classifierTargetState;
        if (currContx == "/Оценка"
        &&  nextState != "/Оценка/ОценкаКомментарий")
            {
                ctx.temp.classifierTargetState = "/Оценка/ОценкаКомментарий";
                $reactions.transition("/Оценка/ОценкаКомментарий");
            }
        if (currContx == "/Оценка/ОценкаКомментарий"
        &&  nextState != "/Оценка/ОценкаКомментарий/ОценкаЗакрытие")
            {
                ctx.temp.classifierTargetState = "/Оценка/ОценкаКомментарий/ОценкаЗакрытие";
                $reactions.transition("/Оценка/ОценкаКомментарий/ОценкаЗакрытие");
            }
    });

# Препроцсс-обработчик, который отлавливает стейт, с которого был переход на оператора

#    bind("preProcess", function(ctx) {
#        var currState = ctx.currentState;
#        var currContx = ctx.contextPath;
#        var nextState = ctx.temp.classifierTargetState;
#        if (currContx != "/Operator"
#        &&  currContx != "/CatchAll"
#        &&  currContx != "/ВопросыОстались")
#            {
#                if (nextState == "/Operator"
#                ||  nextState == "/CatchAll"
#                ||  nextState == "/ВопросыОстались")
#                    {
#                        ctx.session.smartSwitchLastState = currContx;
#                    }
#            }
#        //$reactions.answer("CS: "+currState);
#        //$reactions.answer("CC: "+currContx);
#        //$reactions.answer("NS: "+nextState);
#        //$reactions.answer(ctx.session.smartSwitchLastState);
#    });

# Переопределение ответа бота, когда он начинает повторяться

    bind("postProcess", function($context) {
        var currentAnswer = $context.response.replies.reduce(function(allAnswers, reply) {
            allAnswers += reply.type === "text" ? reply.text : "";  
            return allAnswers;
        },"");
        if ($context.session.lastAnswer === currentAnswer && !testMode()) {
            $context.response.replies = [
            {
                "type":"text",
                "text":"Потребуется помощь оператора."
            }
            ];
            $reactions.transition({value: "/Operator", deferred: false});       // deferred: false = go!:
        }
        $context.session.lastAnswer = currentAnswer;
    });

#    bind("postProcess", function($context) {
#        var currentAnswer = $context.response.replies.reduce(function(allAnswers, reply) {
#            allAnswers += reply.type === "text" ? reply.text : "";  
#            return allAnswers;
#        },"");
#        if ($context.session.lastAnswer === currentAnswer && !testMode()) {
#            $context.response.replies = [
#            {
#                "type":"text",
#                "text":"..."
#            }
#            ];
#            $reactions.transition("/Operator");
#        }
#        $context.session.lastAnswer = currentAnswer;
#    });

# Переопределение последовательнсоти матчера

    bind("selectNLUResult", function(ctx) {                                     // задаем обработчик для фазы `selectNLUResult`
        log(ctx.nluResults);                                                    // выводим результаты в лог
        if (ctx.nluResults.intents.length > 0)
            {
                ctx.nluResults.selected = ctx.nluResults.intents[0];            // используем результат от интентов
                return;
            }
        if (ctx.nluResults.patterns.length > 0)
            {
                ctx.nluResults.selected = ctx.nluResults.patterns[0];           // если результата от интентов нет, используем паттерны
                return;
            }
        if (ctx.nluResults.examples.length > 0)
            {
                ctx.nluResults.selected = ctx.nluResults.examples[0];           // если результата от интентов и паттернов нет, используем примеры
            }
    });

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
# В переменную $context.session.chatHistorySTAT нарастающим итогом записывается значение полного пути стейта, из которого взят ответ бота

    $jsapi.bind({
        type: "preProcess",
        name: "savingVisitorChatHistory",
        path: "/",
        handler: function($context) {
            $context.client.chatHistory = $context.client.chatHistory || [];
            var chatHistory = $context.client.chatHistory;
            if ($context.request.query) {
                chatHistory.push({type: "Клиент", state: "", text: $context.request.query});
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
                    .forEach(function(val) { chatHistory.push({ type: "BOT", state: "( Тема: "+$context.currentState+" )", text: val.text }); });
            }
            chatHistory.splice(0, chatHistory.length - 10);
            $context.session.chatHistorySTAT += $context.currentState;
        }
    });
    
# -----------------------------------------------------------------------------
# ----------------------------- Главный сценарий ------------------------------
# -----------------------------------------------------------------------------

theme: /

    state: Начало
        q!: ((*start *) | *старт | *ыефке | *cnfhn)
        a:  Здравствуйте! Я виртуальный помощник компании Hoff. Могу:
            <ul>
                <li>[назначить дату доставки и сборки] по заказу;</li>
                <li>ответить на [вопросы о программе лояльности Hoff] (купоны, сертификаты, бонусные и подарочные карты);</li>
                <li>[уточнить статус обращения];</li>
                <li>по остальным вопросам, пожалуйста, обращайтесь в Единую Информационную Службу Hoff с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику её работы</a>; продолжая диалог, вы даёте своё согласие на [обработку персональных данных]; для улучшения работы нашего сервиса диалог с вами может быть сохранен.</li>
            </ul>
            Внимание!
            <ul>
                <li>всем клиентам, у которых заканчивался срок действия подарочных карт в период с 01.03.2020 по 31.05.2020, продлили действие карт до 31.08.2020 (автоматически, без дополнительных обращений и заявок).</li>
            </ul>
        a:  Какой у вас вопрос?
        inlineButtons:
            {text:"Назначить дату доставки и сборки"}       -> /021/SDD/SDD-01
            {text:"Вопросы о программе лояльности Hoff"}    -> /003/ЛКБ/ЛКБ-00-00
            {text:"Уточнить статус обращения"}              -> /022/GTI/GTI-01

#        a:  Здравствуйте! Я виртуальный помощник компании Hoff. Могу:
#            - ответить на [вопросы о программе лояльности Hoff] (купоны, сертификаты, бонусные и подарочные карты);
#            - [назначить дату доставки] по заказу;
#            - [уточнить статус обращения];
#            - по остальным вопросам я подключаю к диалогу компетентных специалистов с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику работы горячей линии Hoff</a>. Продолжая диалог, вы даёте своё согласие на [обработку персональных данных]. Для улучшения работы нашего сервиса диалог с вами может быть сохранен.
#            Какой у вас вопрос?

#        script:
#            $reactions.answer(
#                {
#                    'type':'text',
#                    'text':'или <a href="https://hoff.ru/feedback" target="_blank">отправьте нам email в рубрике «Напишите нам»</a>',
#                    'markup':'html'
#                }
#            );
#            sleep();
#            $reactions.answer("Какой у вас вопрос?");
        
        #Уточнение доступных навыков бота
        state: ЧтоТыУмеешь || noContext=true
            intent!: /Общие/ЧтоТыУмеешь
            intent!: /Общие/MainMenu
            q: * {все * навыки} *
            script:
                sleep();

            a:  В качестве вашего виртуального помощника я могу:
                <ul>
                    <li>[назначить дату доставки и сборки] по заказу;</li>
                    <li>ответить на [вопросы о программе лояльности Hoff] (купоны, сертификаты, бонусные и подарочные карты);</li>
                    <li>[уточнить статус обращения];</li>
                    <li>по остальным вопросам, пожалуйста, обращайтесь в Единую Информационную Службу Hoff с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику её работы</a>.</li>
                </ul>
            a:  Какой у вас вопрос?
            inlineButtons:
                {text:"Назначить дату доставки и сборки"}       -> /021/SDD/SDD-01
                {text:"Вопросы о программе лояльности Hoff"}    -> /003/ЛКБ/ЛКБ-00-00
                {text:"Уточнить статус обращения"}              -> /022/GTI/GTI-01
                
#            a:  В качестве вашего виртуального помощника я могу:
#                - ответить на [вопросы о программе лояльности Hoff] (купоны, сертификаты, бонусные и подарочные карты);
#                - [назначить дату доставки] по заказу;
#                - [уточнить статус обращения];
#                - По всем остальным вопросам я подключаю к беседе компетентных специалистов. Задайте мне любой вопрос о компании Hoff и я постараюсь ответить как можно быстрее.

# ------------------- Действие, если бот непонимает клиента -------------------
    
    #отлов всех нераспознанных фраз клиента
    state: CatchAll || noContext=true
        event!: noMatch
        script:
            sleep();
        go!: /Operator

# ----------------------- Уведомление о смене контекста -----------------------

    state: ContextChangeAcception
        script:
            $response.replies = [];
        a:  — ВНИМАНИЕ —
            <ul>
                <li>Вы написали: "{{ $request.query }}"</li>
            </ul>
            Вы уверены, что хотите перейти к другому вопросу? (Да/Нет)
            <ul>
                <li>нажмите "[Да]" и работа по предыдущему вопросу прервётся, нажмите "[Нет]" и мы продожим рассмотрение предыдущего вопроса.</li>
            <ul>
        inlineButtons:
            {text:"Да"}  -> ./ContextChangeAcception-yes
            {text:"Нет"} -> ./ContextChangeAcception-no

        state: ContextChangeAcception-yes 
            intent: /Общие/Согласие
            go!: {{ $session.nextState }}
   
        state: ContextChangeAcception-no
            intent: /Общие/Отказ
            go!: {{ $session.lastState }}

# ------------------------- Переключение на оператора -------------------------

    #можно просто написать "ожидайте, пожалуйста..." 
    state: Operator || noContext=true
        intent!: /Общие/Operator
        script:
            sleep();

        a:  Обратитесь, пожалуйста, в Единую Информационную Службу Hoff с 10 до 22 (МСК) ежедневно <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">по графику её работы</a>.
            <ul>
                <li>также я могу помочь с ответом на другие [вопросы по программе Лояльности Hoff] при их наличии.</li>
                <li>[вернуться в главное меню].</li>
            </ul>
        inlineButtons:
            {text: "Контакты ЕИС Hoff", url: "https://hoff.ru/contacts/zagruzhennost-koll-tsentra/"}
            {text: "Вернуться в главное меню"} -> /Начало/ЧтоТыУмеешь
#            {text: "Форма обращения по Email", url: "https://hoff.ru/feedback"}

#        a:  — Подключаю оператора —
#            <ul>
#                <li>для возврата к виртуальному помощнику введите любую из команд: /close, /bot, /закрыть чат, /вернуть бота.</li>
#            </ul>
#            Ожидайте, пожалуйста...
#        go!: ./Switch

        state: Switch || noContext=true
            script:
                $context.session.ltxFirstMessage = "—————————————————" + "\n" + "ИСТОРИЯ ДИАЛОГА до переключения на оператора:" + "\n" + $context.client.chatHistory.map(function(val) {return val.type + "\n" + val.state + "\n" + val.text;}).join("\n\n") + "\n" + "—————————————————" + "\n" + "Рекомендации бота (тематики):" + "\n" + strSortNCount($context.session.chatHistorySTAT);
                $response.replies.push({
                    type:"switch",
                    appendCloseChatButton: false,
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
                    firstMessage: $context.session.ltxFirstMessage,
                    lastMessage: "— Диалог завершён —",
                    attributes: {
                        "Рекомендации бота (тематики)": strSortNCount($context.session.chatHistorySTAT),
                    }
                });
            
            #Действие, если оператор закрыл чат или клиент послал закрывающую фразу
            state: livechatFinished || noContext=true
                event!: livechatFinished
                q: (*close | *сдщыу)
                q: (*bot | *ище | *бот | *,jn)
                q: (*закрыть чат | *pfrhsnm xfn | *закройте чат | *pfrhjqnt xfn | *закрой чат | *pfrh* xfn)
                q: (*вернуть бота | *dthyenm ,jnf | *верните бота | *dthybnt ,jnf | *верни бота | *dthyb ,jnf)
                a:  — Оператор отключен —
                    <ul>
                        <li>с вами снова виртуальный помощник.</li>
                    </ul>
                go!: /Оценка
            
            #Действие, если нет доступных операторов в линии
            state: NoOperatorsOnline || noContext=true
                event!: noLivechatOperatorsOnline
                a:  — Нет доступных операторов —
                    <ul>
                        <li>график работы операторов с 10 до 22 (МСК) ежедневно;</li>
                        <li>рекомендуем выбрать время обращения в <a href="https://hoff.ru/contacts/zagruzhennost-koll-tsentra/" target="_blank">период меньшей загруженности Единой Информационной Службы Hoff</a>.</li>
                    </ul>    
                a:  — С вами снова виртуальный помощник —
                    <ul>
                        <li>напишите другой вопрос или попробуйте позже.</li>
                    </ul>

# ---------------- Реакции на системные события (ивенты)  ---------------------

    state: sendFileEvent || noContext=true
        event!: sendFile
        a: — Ваш файл получен —

# ---------------------- Прощание перед закрытием чата ------------------------
    
    #Прощание с клиентом
    state: Bye
        intent!: /Общие/Bye
        script:
            sleep();
        random:
            a: До свидания! Появятся вопросы — обращайтесь.
            a: Всего хорошего! Будут вопросы — обращайтесь.
            a: Я прощаюсь с вами. Будут вопросы — обращайтесь.
        go!: ../Оценка
    
    #Оценка удовлетворенности клиента
    state: Оценка
        intent!: /Общие/CloseSession
        intent!: /Общие/ОставитьОтзыв
        script:
            sleep();
        a:  Всё ли вам понравилось?
            <ul>
                <li>оцените, пожалуйста, наш диалог от 1 до 5 (5 - отлично). Оставить комментарий можно будет на следующем шаге.</li>
#                <li>оцените, пожалуйста, наш диалог от 1 до 5 (где 5 — отлично), либо нажмите на одну из кнопок ниже. Оставить комментарий можно будет на следующем шаге.</li>
            </ul>    
        inlineButtons:   
            {text:"5 ★★★★★"}
            {text:"4 ★★★★"}
#            {text:"3 ★★★"}
            {text:"2 ★★"}
            {text:"1 ★"}
#        inlineButtons:   
#            {text:"5 Отлично 😁"}
#            {text:"4 Хорошо 😉"}
#            {text:"3 Сносно 😐"}
#            {text:"2 Плохо 😤"}
#            {text:"1 Ужасно 😡"}

    
        # Создаем две переменных так как клиент может не ответить на этот стейт и тогда вторая переменная не будет создана
        state: ОценкаКомментарий
            intent: /Общие/Bye
            intent: /Общие/Согласие
            intent: /Общие/Отрицание
            q: *
            script:
                $session.sci = $request.query;
            a:  Ваша оценка принята.
                <ul>
                    <li>при желании, напишите свой комменнтарий к оценке одним сообщением, и мы его обязательно рассмотрим, либо просто закройте чат;</li>
                    <li>эта форма не предназначена для обращений, только для оценки удовлетворенности и качества работы сервиса.</li>
                </ul>

            state: ОценкаЗакрытие
                intent: /Общие/Bye
                intent: /Общие/Согласие
                intent: /Общие/Отрицание
                q: *
                script:
                    $session.sciComment = $request.query;
                a:  Ваш комментарий принят. Спасибо, что помогаете нам стать лучше. Рады видеть вас снова!
                go!: /CloseSession

# ---------------- Выявление и уточнение вопросов клиента   -------------------

    #Действие, если клиент присылает приветственную фразу, тогда бот пытается сразу вывести его на конкретику.
    #Действие, если пользователь написал, что у него остались еще вопросы, но не обозначил какие именно.
    state: ВопросУточните || noContext=true
        intent!: /Общие/Hello
        intent!: /Общие/УМеняЕщеВопросы
        script:
            sleep();
        random:
            a: Чем могу помочь?
            a: Какой ваш вопрос?
            a: Что бы вы хотели обсудить?
            a: В чём ваш вопрос?

    #Действие, если требуется переформулировать вопрос клиента (чаще всего, когда он задается в неявной форме, без важных деталей).
    state: ВопросПереформулируйте || noContext=true
        intent!: /Общие/ВопросПереформулируйте
        script:
            sleep();
        random:
            a:  Уточните, пожалуйста, вопрос.
            a:  Прошу вас уточнить вопрос.
            a:  Опишите подробнее ваш вопрос.

    #Действие, если перед закрытием чата необходимо узнать остались ли у клиента еще вопросы.
    state: ВопросыОстались || noContext=true
        script:
            sleep();
        random:
            a:  Остались ли у вас вопросы?
                <ul>
                    <li>вы можете продолжить диалог, ответив на предыдущее сообщение, или обратиться с другим вопросом;</li>
                    <li>нажмите "[Завершить диалог]", если вопросов не осталось, либо "[Поделиться впечатлением]" чтобы поделиться своим мнением о работе нашего сервиса.</li>
                    
                </ul>
            a:  У вас остались вопросы?
                <ul>
                    <li>вы можете продолжить диалог, ответив на предыдущее сообщение, или обратиться с другим вопросом;</li>
                    <li>нажмите "[Завершить диалог]", если вопросов не осталось, либо "[Поделиться впечатлением]" чтобы поделиться своим мнением о работе нашего сервиса.</li>
                </ul>
        inlineButtons:
            {text:"Завершить диалог"} -> /Bye
            {text:"Поделиться впечатлением"} -> /Оценка

# ---------- Дейстивие, если клиент не отвечает (глобальный таймаут) ----------

    #Закрытие сессии по глобальному таймауту при неответе клиента
    state: CloseSessionByTimeout
        a: — Время диалога истекло —
        go!: /Bye

# ----------------------------- Закрытие сессии -------------------------------
    
    #Закрытие сессии
    #Плюс отправка собранных (деперсонализированных) отзывов об оценке удовлетворенности пользоватеей на гугл-диск профиля aleksandr.strizhkov@hoff.ru 
    state: CloseSession
        a:  — Диалог завершён —
            <ul>
                <li>для открытия нового диалога напишите свой вопрос в чат или нажмите "[вернуться в главное меню]".</li>
            </ul>
        inlineButtons:
            {text:"Вернуться в главное меню"}               -> /Начало/ЧтоТыУмеешь
            {text:"Оставить отзыв / сообщить об ошибке"}    -> /Оценка
        script:
            // Создание переменной с путем на историю переписки по данной сессии:
            $session.sciLink = "https://zenbot-dev.just-ai.com/hoff_bot_prj01_maste-118482474-rCn/statistic/dialogs/";
            // Отправка отзыва клиента в гугл таблицу через вебхук на стороне сервиса IFTTT:
            $session.wsUrl = 'https://maker.ifttt.com/trigger/HoffBot-PRJ01-mainsc-CSI-Log/with/key/iawiiWUbHFs2L2Yf8oGU538Z62W_1kyS3xy252qWHAX';
            $session.wsMethod = "POST";
            $session.wsBody = { "value1" : "",
                                "value2" : $session.sci +" | "+ $session.sciComment +" | "+ $session.sciLink,
                                "value3" : $session.sciLink };
            $session.wsTransGood = {value: "/CloseSession", deferred: true};
            $session.wsTransBad  = {value: "/CloseSession", deferred: true};
            var $httpResponse = getStatus();
                $reactions.transition($session.wsTransGood);
            $jsapi.stopSession();

# ----------------------------- Стейт для тестов  -----------------------------

    #Нужен, когда используется переопределение стейта чтобы в тестах бот не повторял ответы при проверке переходов в один и тот же стейт по синонимичным фразам клиентов
#    state: антиповтор || noContext=true
#        q!: антиповтор
#        a: ....

#    #история переписки
#    state: история
#        q!: (история | bcnjhbz)
#        script:
#            $session.hist = "—————————————————" + "\n" + "ИСТОРИЯ ДИАЛОГА до переключения на оператора:" + "\n" + $context.client.chatHistory.map(function(val) {return val.type + "\n" + val.state + "\n" + val.text;}).join("\n\n") + "\n" + "—————————————————" + "\n" + "Рекомендации бота (тематики):" + "\n" + strSortNCount($context.session.chatHistorySTAT);
#        a: {{$session.hist}}
        
#    state: тест
#        q!: (тест | ntcn | test | еуые)
#        a:  тест 

# ------------------- Ответы на общие частые вопросы  -------------------------

    #Уточнение положений политики конфиденциальности
    state: Конфиденциальность || noContext=true
        intent!: /Общие/Конфиденциальность
        script:
            sleep();
        a:  Политика конфиденциальности Hoff была разработана с целью защиты персональных данных клиентов Hoff и соблюдения законодательства Российской Федерации. С ней вы можете ознакомиться по ссылке:
            <ul>
                <li><a href="https://hoff.ru/services/privacy_policy/" target="_blank">https://hoff.ru/services/privacy_policy/</a></li>
            </ul>