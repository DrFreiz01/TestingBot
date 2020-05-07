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
    init:
        bind("preProcess", function($context) {
            var $session = $jsapi.context().session;
            $session.lastState = $context.contextPath;
        }, "/");
        
    state: Start
        q!: $regex</start>
        #a: Добрый день! Меня зовут Елена, отдел контроля качества сервиса Мэйджор Авто. Вам удобно уделить одну минуту?
        audio: https://www.dropbox.com/s/2i93u3h34n0srzq/1._%D0%94%D0%BE%D0%B1%D1%80%D1%8B%D0%B9%20%D0%B4%D0%B5%D0%BD%D1%8C%21%20%5B%D0%BF%D0%B0%D1%83%D0%B7%D0%B0%5D%20%D0%9C%D0%B5%D0%BD%D1%8F%20%D0%B7%D0%BE%D0%B2%D1%83%D1%82%20%D0%90%D0%BB%D0%B8%D0%BD%D0%B0%2C%20%D0%BE%D1%82%D0%B4%D0%B5%D0%BB%20%D0%BA%D0%BE%D0%BD%D1%82%D1%80%D0%BE%D0%BB%D1%8F%20%D0%BA%D0%B0%D1%87%D0%B5%D1%81%D1%82%D0%B2%D0%B0%20%D1%81%D0%B5%D1%80%D0%B2%D0%B8%D1%81%D0%B0%20%D0%9C%D1%8D%D0%B9%D0%B4%D0%B6%D0%BE%D1%80%20%D0%90%D0%B2%D1%82%D0%BE.%20%D0%92%D0%B0%D0%BC%20%D1%83%D0%B4%D0%BE%D0%B1%D0%BD%D0%BE%20%D1%83%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C%201%20%D0%BC%D0%B8%D0%BD%D1%83%D1%82%D1%83_2.wav?dl=1
        
        state: Accepted
            q: [ну](да|ага|давай*|удобн*)[*]
            # a: Спасибо! Скажите, остались ли Вы довольны последним посещением сервиса?
            audio: https://www.dropbox.com/s/shcvv37h05j05ar/2.%20%D1%81%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%20%D0%BE%D1%81%D1%82%D0%B0%D0%BB%D0%B8%D1%81%D1%8C%20%D0%BB%D0%B8%20%D0%B2%D1%8B%20%D0%B4%D0%BE%D0%B2%D0%BE%D0%BB%D1%8C%D0%BD%D1%8B%20%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BD%D0%B8%D0%BC%20%D0%BF%D0%BE%D1%81%D0%B5%D1%89%D0%B5%D0%BD%D0%B8%D0%B5%D0%BC%20%D1%81%D0%B5%D1%80%D0%B2%D0%B8%D1%81%D0%B0.wav?dl=1
            
            state: Satisfied
                q: [*] (да|[да] [*] (довол*|* устроил*|понравил*)) [*]
                # a: Оцените, пожалуйста, последнее посещение по 10-балльной шкале, где 10 баллов - это наилучшая оценка
                audio: https://www.dropbox.com/s/uba9i37bsd86mwv/3._%D0%9E%D1%86%D0%B5%D0%BD%D0%B8%D1%82%D0%B5%2C%20%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0%2C%20%D0%BF%D0%BE%D1%81%D0%BB%D0%B5%D0%B4%D0%BD%D0%B5%D0%B5%20%D0%BF%D0%BE%D1%81%D0%B5%D1%89%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BF%D0%BE%2010-%D0%B1%D0%B0%D0%BB%D0%BB%D1%8C%D0%BD%D0%BE%D0%B9%20%D1%88%D0%BA%D0%B0%D0%BB%D0%B5%2C%20%D0%B3%D0%B4%D0%B5%2010%20%D0%B1%D0%B0%D0%BB%D0%BB%D0%BE%D0%B2%2C%20%E2%80%94%20%D1%8D%D1%82%D0%BE%20%D0%BD%D0%B0%D0%B8%D0%BB%D1%83%D1%87%D1%88%D0%B0%D1%8F%20%D0%BE%D1%86%D0%B5%D0%BD%D0%BA%D0%B0..wav?dl=1
                
                state: ParseRating
                    q: [*] $NumberDigit::Rating [*]
                    if: $parseTree._Rating >= 9
                        # a: Остались ли у Вас пожелания или замечания в адрес компании?
                        audio: https://www.dropbox.com/s/hb9grhtyhkgxvkt/4._%D0%9E%D1%81%D1%82%D0%B0%D0%BB%D0%B8%D1%81%D1%8C%20%D0%BB%D0%B8%20%D1%83%20%D0%92%D0%B0%D1%81%20%D0%BF%D0%BE%D0%B6%D0%B5%D0%BB%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%B8%D0%BB%D0%B8%20%D0%B7%D0%B0%D0%BC%D0%B5%D1%87%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%B2%20%D0%B0%D0%B4%D1%80%D0%B5%D1%81%20%D0%BA%D0%BE%D0%BC%D0%BF%D0%B0%D0%BD%D0%B8%D0%B8_.wav?dl=1
                        go!: /Start/Accepted/Satisfied/ParseRating/GetCommentPos
                        
                    if: $parseTree._Rating < 9
                        # a: Расскажите, пожалуйста, на что нам стоит обратить внимание руководства?
                        audio: https://www.dropbox.com/s/uc3vnx5ehcsyl2t/%D0%A0%D0%B0%D1%81%D1%81%D0%BA%D0%B0%D0%B6%D0%B8%D1%82%D0%B5%20%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0%20%D0%BD%D0%B0%20%D1%87%D1%82%D0%BE%20%D0%BD%D0%B0%D0%BC%20%D1%81%D1%82%D0%BE%D0%B8%D1%82%20%D0%BE%D0%B1%D1%80%D0%B0%D1%82%D0%B8%D1%82%D1%8C%20%D0%B2%D0%BD%D0%B8%D0%BC%D0%B0%D0%BD%D0%B8%D0%B5%20%D1%80%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D0%B0.wav?dl=1
                        go!: /Start/Accepted/Satisfied/ParseRating/GetCommentNeg
                        
                    state: GetCommentPos
                        state: ParsePos
                            q: $repeat<$AnyWord>
                            script:
                                var $comment = $parseTree.text
                            go!: /GoodByeSatisfied
                            
                    state: GetCommentNeg
                        state: ParseNeg
                            q: $repeat<$AnyWord>
                            script:
                                $session.comment = $parseTree.text
                            go!: /GoodByeNotSatisfied
                            
            state: NotSatisfiedShort
                q: [не*] (нет|не* [*] (устроил* |понравил* |довол*))
                # a: Расскажите, пожалуйста, подробнее, что произошло?
                audio: https://www.dropbox.com/s/ntaoiddmggpeaqg/6._%D0%A0%D0%B0%D1%81%D1%81%D0%BA%D0%B0%D0%B6%D0%B8%D1%82%D0%B5%2C%20%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0%2C%20%D0%BF%D0%BE%D0%B4%D1%80%D0%BE%D0%B1%D0%BD%D0%B5%D0%B5%2C%20%D1%87%D1%82%D0%BE%20%D0%BF%D1%80%D0%BE%D0%B8%D0%B7%D0%BE%D1%88%D0%BB%D0%BE_.wav?dl=1
                
                state: ParseUnsatisfied
                    q: $repeat<$AnyWord>
                    script:
                        var $comment = $parseTree.text
                    #a: Спасибо за предоставленную информацию. Все ваши замечания будут переданы руководству. Всего доброго  
                    audio: https://www.dropbox.com/s/s1x95eextnzyigt/7._%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%20%D0%B7%D0%B0%20%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%BD%D1%83%D1%8E%20%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8E.%20%D0%92%D1%81%D0%B5%20%D0%B2%D0%B0%D1%88%D0%B8%20%D0%B7%D0%B0%D0%BC%D0%B5%D1%87%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%B1%D1%83%D0%B4%D1%83%D1%82%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B4%D0%B0%D0%BD%D1%8B%20%D1%80%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D1%83.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%B4%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE..wav?dl=1
                    
            state: NotSatisfiedLong
                q: не* * [*] [*] [*] [*] [*]
                script:
                    var $commentlong = $parseTree.text
                # a: Спасибо за предоставленную информацию. Все ваши замечания будут переданы руководству. Всего доброго  
                audio: https://www.dropbox.com/s/s1x95eextnzyigt/7._%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%20%D0%B7%D0%B0%20%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%BD%D1%83%D1%8E%20%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8E.%20%D0%92%D1%81%D0%B5%20%D0%B2%D0%B0%D1%88%D0%B8%20%D0%B7%D0%B0%D0%BC%D0%B5%D1%87%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%B1%D1%83%D0%B4%D1%83%D1%82%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B4%D0%B0%D0%BD%D1%8B%20%D1%80%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D1%83.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%B4%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE..wav?dl=1
            
    state: NotAccepted
        q: * (не*|не *) *
        # a: Когда Вам будет удобно уделить время для проведения опроса по процессу обслуживания?
        audio: https://www.dropbox.com/s/zx7cs1k6xcmr3k1/8._%D0%9A%D0%BE%D0%B3%D0%B4%D0%B0%20%D0%92%D0%B0%D0%BC%20%D0%BC%D0%BE%D0%B6%D0%BD%D0%BE%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B7%D0%B2%D0%BE%D0%BD%D0%B8%D1%82%D1%8C%20%D0%B4%D0%BB%D1%8F%20%D1%83%D1%82%D0%BE%D1%87%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D0%B8%20%D0%BF%D0%BE%20%D0%BF%D1%80%D0%BE%D1%86%D0%B5%D1%81%D1%81%D1%83%20%D0%BE%D0%B1%D1%81%D0%BB%D1%83%D0%B6%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F_.wav?dl=1
            
        state: CallLater
            q: * $DateTime *
            # a: Хорошо, мы свяжемся с вами в {{ $parseTree._DateTime.hour}} {{ $parseTree._DateTime.minute }}
            audio: https://www.dropbox.com/s/fpl4xow915b6zn7/10._%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%2C%20%D0%BC%D1%8B%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B7%D0%B2%D0%BE%D0%BD%D0%B8%D0%BC%20%D0%92%D0%B0%D0%BC%20%D0%B2%20%D1%83%D0%BA%D0%B0%D0%B7%D0%B0%D0%BD%D0%BD%D0%BE%D0%B5%20%D0%92%D0%B0%D0%BC%D0%B8%20%D0%B2%D1%80%D0%B5%D0%BC%D1%8F.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%94%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE%21.wav?dl=1
                
        state: ClientAvoids
            q: [*] (не*|не *) [*]
            #a: Это не займет много времени. Скажите, когда будет удобно, чтобы мы вам перезвонили?
            audio: https://www.dropbox.com/s/ekecqxaevve76ja/9._%D0%AD%D1%82%D0%BE%20%D0%BD%D0%B5%20%D0%B7%D0%B0%D0%B9%D0%BC%D0%B5%D1%82%20%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE%20%D0%B2%D1%80%D0%B5%D0%BC%D0%B5%D0%BD%D0%B8.%20%D0%A1%D0%BA%D0%B0%D0%B6%D0%B8%D1%82%D0%B5%2C%20%D0%BA%D0%BE%D0%B3%D0%B4%D0%B0%20%D0%B1%D1%83%D0%B4%D0%B5%D1%82%20%D1%83%D0%B4%D0%BE%D0%B1%D0%BD%D0%BE%2C%20%D1%87%D1%82%D0%BE%D0%B1%D1%8B%20%D0%BC%D1%8B%20%D0%B2%D0%B0%D0%BC%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B7%D0%B2%D0%BE%D0%BD%D0%B8%D0%BB%D0%B8_.wav?dl=1
                
            state: CallLater2ndTry
                q: [*] $DateTime [*]
                # a: Хорошо, мы свяжемся с вами в {{ $parseTree._DateTime.hour}} {{ $parseTree._DateTime.minute }}
                audio: https://www.dropbox.com/s/fpl4xow915b6zn7/10._%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%2C%20%D0%BC%D1%8B%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B7%D0%B2%D0%BE%D0%BD%D0%B8%D0%BC%20%D0%92%D0%B0%D0%BC%20%D0%B2%20%D1%83%D0%BA%D0%B0%D0%B7%D0%B0%D0%BD%D0%BD%D0%BE%D0%B5%20%D0%92%D0%B0%D0%BC%D0%B8%20%D0%B2%D1%80%D0%B5%D0%BC%D1%8F.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%94%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE%21.wav?dl=1
                
            state: AvoidsAtAll
                q: [*] (не*|не *) [*]
                # a: Извините за беспокойство. Всего доброго!
                audio: https://www.dropbox.com/s/1ln2lhgs9qnpih0/11._%D0%98%D0%B7%D0%B2%D0%B8%D0%BD%D0%B8%D1%82%D0%B5%20%D0%B7%D0%B0%20%D0%B1%D0%B5%D1%81%D0%BF%D0%BE%D0%BA%D0%BE%D0%B9%D1%81%D1%82%D0%B2%D0%BE.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%B4%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE%21.wav?dl=1

    state: GoodByeSatisfied
        # a: Спасибо за предоставленную информацию и уделенное время! Ваши комментарии и оценка будут переданы руководству. Благодарим вас за выбор компании Major! Всего доброго!
        audio: https://www.dropbox.com/s/rp4yar5n3ltwgcw/%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%20%D0%B7%D0%B0%20%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%BD%D1%83%D1%8E%20%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8E%20%D0%B8%20%D1%83%D0%B4%D0%B5%D0%BB%D0%B5%D0%BD%D0%BD%D0%BE%D0%B5%20%D0%B2%D1%80%D0%B5%D0%BC%D1%8F%20%D0%92%D0%B0%D1%88%D0%B8%20%D0%BA%D0%BE%D0%BC%D0%BC%D0%B5%D0%BD%D1%82%D0%B0%D1%80%D0%B8%D0%B8%20%D0%B8%20%D0%BE%D1%86%D0%B5%D0%BD%D0%BA%D0%B0%20%D0%B1%D1%83%D0%B4%D1%83%D1%82%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B4%D0%B0%D0%BD%D1%8B%20%D1%80%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D1%83.%20%D0%91%D0%BB%D0%B0%D0%B3%D0%BE%D0%B4%D0%B0%D1%80%D0%B8%D0%BC%20%D0%B2%D0%B0%D1%81%20%D0%B7%D0%B0%20%D0%B2%D1%8B%D0%B1%D0%BE%D1%80%20%D0%BA%D0%BE%D0%BC%D0%BF%D0%B0%D0%BD%D0%B8%D0%B8%20Major%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%B4%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE.wav?dl=1
        
    state: GoodByeNotSatisfied
        #a: Спасибо за предоставленную информацию и уделенное время! Ваши замечания и оценка будут переданы руководству. Всего доброго!
        audio: https://www.dropbox.com/s/s1x95eextnzyigt/7._%D0%A1%D0%BF%D0%B0%D1%81%D0%B8%D0%B1%D0%BE%20%D0%B7%D0%B0%20%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%BD%D1%83%D1%8E%20%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8E.%20%D0%92%D1%81%D0%B5%20%D0%B2%D0%B0%D1%88%D0%B8%20%D0%B7%D0%B0%D0%BC%D0%B5%D1%87%D0%B0%D0%BD%D0%B8%D1%8F%20%D0%B1%D1%83%D0%B4%D1%83%D1%82%20%D0%BF%D0%B5%D1%80%D0%B5%D0%B4%D0%B0%D0%BD%D1%8B%20%D1%80%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D1%83.%20%D0%92%D1%81%D0%B5%D0%B3%D0%BE%20%D0%B4%D0%BE%D0%B1%D1%80%D0%BE%D0%B3%D0%BE..wav?dl=1
    
    state: CatchAll || noContext = true
        event!: speechNotRecognized || noMatch
        audio: https://www.dropbox.com/s/7ns8nh3y9rxmis7/%D0%9D%D0%B5%20%D1%80%D0%B0%D1%81%D1%81%D0%BB%D1%8B%D1%88%D0%B0%D0%BB%D0%B0%20%D0%BF%D0%BE%D0%B2%D1%82%D0%BE%D1%80%D0%B8%D1%82%D0%B5%20%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0.wav?dl=1
        go!: {{ $session.lastState }}

    state: 
        event!: noMatch
        audio: https://www.dropbox.com/s/7ns8nh3y9rxmis7/%D0%9D%D0%B5%20%D1%80%D0%B0%D1%81%D1%81%D0%BB%D1%8B%D1%88%D0%B0%D0%BB%D0%B0%20%D0%BF%D0%BE%D0%B2%D1%82%D0%BE%D1%80%D0%B8%D1%82%D0%B5%20%D0%BF%D0%BE%D0%B6%D0%B0%D0%BB%D1%83%D0%B9%D1%81%D1%82%D0%B0.wav?dl=1
        go!: {{ $session.lastState }}   
        
