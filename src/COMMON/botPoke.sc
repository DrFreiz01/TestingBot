theme: /botPoke

    state: testPoke
        q!: (test/text/тест) [123]
        random:
            a: Я здесь
            a: Да-да?
            a: 👋
            #a: Какое-то неизвестное нам направление 😔 Попробуйте ещё раз!


    state: heyYou
        # 4EX: ну камон
        # 4EX: не спи
        # 4EX: КУКУ ЙОПТА?
        q!: [$beginningWords] {$poke [$botVocAll] [$interjections]}
        q!: [$beginningWords] ты $poke [$botVocAll]
        q!: [$beginningWords] $botVocAll $poke [$botVocAll]
        q!: [$beginningWords] [$botVocAll] [$poke] (послушай/слухай/слухай/внимай) [сюда/сюды][$botVocAll]
        q!: [$beginningWords] (нуже/ну же) [$botVocAll]
        q!: [$beginningWords] (камон/каммон) [$botVocAll]
        # 4EX: Алё, отзовитесь.
        q!: [$beginningWords] (алло/ало/але/алле/алое/алоэ) (отзови*/атзави*/слуш*/послуш*/слух*)
        q!: [$beginningWords] (алло/ало/але/алле/алое/алоэ) [гараж] [$botVocAll]
        q!: [$beginningWords] (куку/ку ку/ку-ку/ку) [гараж] [$botVocAll]
        q!: [$beginningWords] (прием/рпием/приме)[прием/рпием/приме] [$botVocAll]
        q!: [$beginningWords] (перв*/певр*) (перв*/певр*) я (второй/торой) (приме/прием/как слышно)
        q!: [$beginningWords] (глухар*/гухар*) (глухар*/гухар*) я (чайка/чака/чацка) (приме/прием/как слышно)
        q!: (ну/нуу/нууу) [$botVocAll]
        a: Я слушаю!



    state: tellMe
        # 4EX: скажи что-нибудь
        q!: (скажи что*нибудь/скажи что*нить/скажи чтонить/скажи чтонибудь/скажи что*нибуть)
        a: Да-да?



    state: toDiscussWithSmb
        # 4EX: хочу с кемнибудь переговорить
        q!: * с (кем/кемнибу*/кемнить/кемнебу*/кемнеьу*/кемниьу*) * $discuss *
        q!: * $discuss * с (кем/кемнибу*/кемнить/кемнебу*/кемнеьу*/кемниьу*) *
        q!: * (кому/комунибу*/комунить/комунебу*/комунеьу*/комуниьу*) * (обрати*/оброт*/оброща*/обраща*) *
        q!: * (обрати*/оброт*/оброща*/обраща*) * к (кому/комунибу*/комунить/комунебу*/комунеьу*/комуниьу*) *
        q!: *  {([с/к] ~кто-нибудь/[с/к] ~кто нибудь) * $discuss } *
        q!: *  {([с/к] ~кто-нибудь/[с/к] ~кто нибудь) * $discuss * ($want/$need2)} *
        # 4EX: давай поговорим
        q!: (давай/нужно) (~беседовать/~говорить/~обратится/~обратиться/~обсудить/~общаться/~переговорить/~перетереть/~побеседовать/~поговорить/~поконсультировать/~получить ~консультация/~пообсуждать/~пообщаться/~посоветоваться/~проконсультировать/~проконсультироваться/~разговаривать)
        q!: [я] ($want/$need2) (~беседовать/~говорить/~обратится/~обратиться/~обсудить/~общаться/~переговорить/~перетереть/~побеседовать/~поговорить/~поконсультировать/~получить ~консультация/~пообсуждать/~пообщаться/~посоветоваться/~проконсультировать/~проконсультироваться/~разговаривать)
        if: $context.currentState == $client.executeState
            go!: /operator/goToOpeartor
        else:
            a: Возможно, я смогу помочь. Вы можете задать свой вопрос здесь.



    state: heyRobot
        # 4EX: Робот!
        q!: [эй/эйты/слыш/слышь/тыслыш*/ау/ну/о] $botVocAll
        q!: [эй/эйты/слыш/слышь/тыслыш*/ау/ну/о] $repeat<$botVocAll>
        go!: /botPoke/heyYou



    state: areYouHere
        # 4EX: ты здесь или как
        q!: * (ты/вы) $here [$botVocAll]
        q!: * (ты/вы) $here или (нет/не/как)
        # 4EX: Вы онлайн?
        q!: [$beginningWords] (ты/вы) [$now2] $online
        a: Я здесь, внимательно вас слушаю



    state: randomRequest
        # 4EX: расскажи стишок
        q!: [$beginningWords] [$interjections][давай/двай] [$interjections][$please] $randomRequest [что ли/чоли/што ли/чтоли] [$beginningWords] [$interjections]
        a: 0011100010101000



    state: makeMeHappy
        # 4EX: порадуй меня чем-нибудь
        q!: * {*радуй * $meGenAcc} *
        a: ❀❀❀



    state: tellMeSmth
        # 4EX: что мне расскажешь?
        q!: [$beginningWords] $what2 * (*скажешь/*ведаешь/*сказать/*ведать) [$markQuestion]
        q!: [$beginningWords] $what2 * $meDat * (*скажешь/*ведаешь/*сказать/*ведать) [$markQuestion]
        q!: [$beginningWords] (*скажешь/*ведаешь/*сказать/*ведать/*скажи/*ведай) $meDat (что-нибудь/что нибудь/чтонить/чтонибудь/что-нить/что нить/чтонибуть/что-нибуть/что нибуть) [$markQuestion]
        go!: /botPoke/randomRequest



    state: dontSleep
        # 4EX: не спи
        q!: * не спи *
        go!: /botPoke/areYouHere



    state: youAreSleeping
        # 4EX: ты спишь
        q!: * ты (спиш/спишь) *
        q!: * (спиш/спишь) *
        go!: /botPoke/areYouHere



    state: iHaveQuestion
        # 4EX: Вопрос о ценах на билеты
        q!: * $question2 * $price * ($ticket/$airplaneTicket/$flight) [$markQuestion]
        q!: * $price * ($ticket/$airplaneTicket/$flight) * $question2 [$markQuestion]
        # 4EX: Хочу узнать по поводу авиабилетов
        q!: [$beginningWords] [я/йа] ($how/$want/$need2/$canSg1 [ли] [я/йа] / (я/йа) $canSg1/$possiblePredic) [$meDat] {$checkFindOut ($about ($ticket/$airplaneTicket/$flight))} [$markQuestion]
        # 4EX: у меня вопрос
        q!: [$beginningWords] [у $meGenAcc] $question2 [$exist] [$markQuestion]
        # 4EX: можно вопрос?
        q!: [$beginningWords] {$possiblePredic $question2} [$markQuestion]
        # 4EX: Могу уточнить у вас
        q!: [$beginningWords] ($how/$want/$need2/$canSg1 [ли] [я/йа] / (я/йа) $canSg1/$possiblePredic) $checkFindOut [у] [$youGenAcc] [$markQuestion]
        # 4EX: Мне нужно информация
        q!: [$beginningWords] [$meDat] {$need2 $information} [$markQuestion]
        # 4EX: Скажите, пожалуйса.
        q!: [$beginningWords] (скажи*/объясни*/разъясни*/поясни*) [$meDat] [$please] [$markQuestion]
        # 4EX: День добрый. Я хотел бы получить консультацию
        q!: [$beginningWords] [$hi] [$beginningWords] [я/йа] ($how/$want/$need2/$canSg1 [ли] [я/йа] / (я/йа) $canSg1/$possiblePredic) [$meDat] [получить] (конмультац*/консультац*)
        a: Чем я могу вам помочь?



    state: answerMe
        # 4EX: отвечай мне уже
        q!: [$beginningWords] $answerImp [$meDat] [давай/двай][уже][$interjections]
        q!: [$beginningWords] $answerImp [$meDat] [давай/двай][уже][$interjections] на [$my2] (вопрос*/ворпос*)
        # 4EX: Ответьте на мой вопрос
        # 4EX: а ну  отвечай мне быстро
        q!: [$beginningWords]
        q!: [$beginningWords] {$answerImp [$meDat] [$please]} быстр*
        q!: [$beginningWords] быстр* {$answerImp [$meDat] [$please]}
        # 4EX: Дайте прямой ответ, а не отвечайте вопросом.
        q!: [$beginningWords] (дай/дайте) [$meDat] (нормальн*/нармальн*/прямо*/адекватн*) (ответ/атвет/овтет/автет) *
        q!: [$beginningWords] ($want/$possiblePredic/$canSg1) [$meDat/я] (нормальн*/нармальн*/прямо*/адекватн*) (ответ/атвет/овтет/автет) *
        # 4EX: на вопрос мне пожалуйста ответьте
        q!: [$beginningWords] на [$my2] $question2 {$answerImp $meDat [$please]}
        q!: [$beginningWords] на [$my2] $question2 {$answerImp [$meDat] $please}
        # 4EX: мне могут хоть что-то ответить
        q!: [$beginningWords] [$poke] {$answerImp $meDat ($somebody)}
        q!: [$beginningWords]  [$interjections] $meDat {[$somebody] [хоть/хотя бы]} {[$something] ($canAll/могут)} (ответить/атветить/овтетить)  [$interjections]
        q!: [$beginningWords]  [$interjections] $meDat {($canAll/могут) [хоть/хотя бы]} {[$somebody] [$something]} (ответить/атветить/овтетить)  [$interjections]
        # 4EX: ответьте мне пожалуйста на вопрос
        q!: [$beginningWords] {$answerImp [$meDat] $please} на [$my2] $question2
        # 4EX: ответьте мне пожалуйста
        q!: [$beginningWords] {$answerImp [$meDat] $please}
        # 4EX: ответьте на мой вопрос мне пожалуйста
        # 4EX: Вы ответите мне на вопрос?
        q!: [$beginningWords] {$answerImp [$meDat] (на [$my2] $question2)} $please
        q!: [$beginningWords] [$you] {($answerImp/ответи*/атвети*) [$meDat] (на [$my2] $question2)}
        # 4EX: на мой вопрос ответ будет?
        # 4EX: На мой вопрос ответа не будет?
        q!: [$beginningWords] на [$my2] $question2 (ответ*/атвет*/овтет*) [$ne] (будет/бует/бут)[$whether] [$interjections]
        a: Повторите вопрос, пожалуйста.



    state: whenCanYouAnswerMe
        # 4EX: и когда можете ответить
        # 4EX: Когда мне ждать ответа?
        q!: [ну и/и/ну] ($when/$howLong) [я/$meDat] [от $youGenAcc] ($canSg1/$possiblePredic) (ждать/ждать/ожидать)
        q!: [ну и/и/ну] {$when [$you] ($canAll (ответить/атветить/овтетить/ответишь/ответите/атветишь/атветите))}
        q!: [ну и/и/ну] ($when/$howLong) [я/$meDat] {[от $youGenAcc] [$canSg1/$possiblePredic] (ждать/ждать/ожидать)} [$your2] (~ответ/атвет/отвкт)
        q!: [ну и/и/ну] ($when/$howLong) [я/$meDat] {[$canSg1/$possiblePredic] (ждать/ждать/ожидать) ([$your2] (~ответ/атвет/отвкт))}  [от $youGenAcc]
        # 4EX: когда мне ответят?
        q!: [ну и/и/ну] ($when/$howLong) [$meDat] (ответят/ответишь/ответите/атветишь/атветите/атветят)
        go!: /botPoke/answerMe



    state: whereDidYouGo
        # 4EX: ты куда пропал
        q!: * ты куда (пропал/исчез) *
        q!: * ты (пропал/исчез) *
        go!: /botPoke/areYouHere



    state: whatsWthYou
        # 4EX: что с тобой происходит?
        q!: [$beginningWords] $what2 [$interjections] с $youInstr [$interjections] [происход*/творитс*/творитьс*]
        q!: [$beginningWords] ты $what2 [$interjections]
        a: А в чем дело?




