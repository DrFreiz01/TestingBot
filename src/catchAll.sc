require: emotionClassifier.sc
require: catchAll/catchAllClassifier.js
    module = common

theme: /
    init:
        $global.catchAll = {
            dontKnowAnAnswerState: "/CatchAll/Switch",
            livechatFinished: "/CatchAll/BackToBot",
            closeChatPhrases: ["вернуться в беседу с роботом"]
        };

    state: CatchAll || noContext = true
        q!: $catchAll
        if: $parseTree.words.length === 1
            go!: /WhatsWrong?
        else:
            script:
                // инициализируем переменные
                $session.catchAll = $session.catchAll || {};
                $session.catchAll.repetition = $session.catchAll.repetition || 0;

                // определяем класс
                var clazz = catchAllClassifier.check($parseTree);
                var res = $nlp.match($parseTree._Root, "/CatchAll/EmotionClassifier");
                if (res.targetState.equals("/CatchAll/EmotionClassifier/Negative")) {
                    $reactions.transition("/CatchAll/NegativeEmotion");
                } else {
                    $reactions.transition(clazz);
                }


        state: Nonsense
            a: Уточните, пожалуйста, какой у Вас вопрос?

        state: ProbablyNonsense
            if: $session.catchAll.repetition == 1
                script:
                    if ($session.nonsenseQuery){
                        $session.nonsenseQuery = $session.nonsenseQuery + '\n\n' + $parseTree.text;
                    } else {
                        $session.nonsenseQuery = '\n\n' + $parseTree.text;
                    }
                a: Уточните, пожалуйста, какой у Вас вопрос?

            else:
                go!: /CatchAll/DoYouWannaSwitch?

        state: Transliteration
            go!: {{ $session.catchAll.transliterationState }}

        state: SeemsMeaningful
            q!: * (*кредит*/*страхов*) *
            script:
                if ($session.nonsenseQuery){
                    $session.nonsenseQuery = $session.nonsenseQuery + '\n\n' + $parseTree.text;
                } else {
                    $session.nonsenseQuery = '\n\n' + $parseTree.text;
                }
                Webim.switch();

        state: NegativeEmotion
            script: Webim.switch();

