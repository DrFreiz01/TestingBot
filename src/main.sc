require: common.js
    module = common
require: patterns.sc
    module = common
require: text/text.sc
    module = common
require: number/number.sc
    module = common
require: dateTime/dateTime.sc
    module = common

theme: /
    state: Start
        q!: * *start
        a: Добрый день, Евгений Олегович! Меня зовут Елена, отдел контроля качества сервиса Мэйджор Авто.
        go!: /IsPollAccepted

    state: IsPollAccepted
        a: Вам удобно уделить несколько минут?

        state: Accepted
            q:  (&yes|ага|удобно|давайте|)
            a: Оцените, пожалуйста, по десятибалльной шкале качество оказанных вам услуг.
            
            state: ParseRating
                q: $NumberDigit::Rating
                a: Рады что вам понравилось! {{ $parseTree._Rating }}
                go!: /GoodBye
            
        state: NotAccepted
            q: ($no|не удобно|нет, не сейчас|сейчас нет|не сейчас| сейчас не удобно|сейчас не удобно)
            a: Когда Вам можно перезвонить для уточнения информации по процессу обслуживания?
        
            state: CallLater
                q: * $DateTime
                a: Хорошо, мы свяжемся с вами в {{ $parseTree._DateTime.hour}} {{ $parseTree._DateTime.minute }}
                go!: /GoodBye

    state: UnacceptableCallTime
            a: Отдел контроля качества сервиса работает каждый день с 10:00 до 19:00, в том числе и в выходные дни. 
            a: Когда Вам будет удобно уделить время для проведения опроса по процессу обслуживания?
            q: * $AnyWord
            a: Спасибо, мы перезвоним позже
            a: Всего доброго!
            
    state: GoodBye
        a: Спасибо за информацию и уделенное время. Хорошего дня!
        
    state: CatchAll || noContext = true
        event!: speechNotRecognized || noMatch
        random:
            a: Извините. Я не расслышал.
            a: Не могли бы вы повторить?
            a: Не расслышал, повторите, пожалуйста.
            a: Повторите, пожалуйста, не расслышал.
            a: Извините. Я не смог расслышать ваш ответ.
        go: /ParseRating

    state: 
        eg!: Common.WorkHours
        a: Мы работаем с 9 до 18
    
    state: 
        eg!: Common.Location
        a: Мы находимся на Малом ПС д.5
        
        
