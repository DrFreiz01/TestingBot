theme: /ellipsis


    state: Yes
        # 4EX: да
        q!: [$beginningWords] ($yes2/$yesAgreeTo)
        q!: [$beginningWords] ($veryAll/весьма/висьма/весма/висма/вполне)
        q!: [$beginningWords] (вроде/типа/тип) того
        q!: [$beginningWords] {$yes2 ($yesAgreeTo/$yesAgreeWith)}
        q!: [$beginningWords] [$yes2] бывает
#        if: $client.clientQuery.query == $client.clientQuery.lastQuery && $client.clientQuery.query == $client.clientQuery.preLastQuery
#            go!: /StopQueryOnRepeat
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: 👌



        state: react_NotYet
            q: пока [что] ($ne/$no2) [очень]
            q: [beginningWords] [$no2] $notVery
            q: ($ne/$no2) [пока/пока что]
            q: а вот и ($ne/$no2)
            q: [$beginningWords] ($ne/$no2)
            a: Жаль!



    state: ISee
        # 4EX: ясно
        q!: (ясно/ясн/понятно/пнятно/поятно/понято/поняно/панятно/понятна/панятна/яясно/яяясно)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            go!: /ellipsis/Yes



    state: RuAtoZh
        # 4EX: гуд
        q!: [$beginningWords] (гоу/гуд/ато/атож/есть такое/а то ж/а тож)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо



    state: YesIAgree
        # 4EX: я полностью согласен
        q!: [$beginningWords] [я] [полност*] [с (тобой/тобою)] [полност*] $yesAgreeWith [с (тобой/тобою)]
        # 4EX: по рукам
        q!: [$beginningWords] [так и быть](по рукам/договорилис*/так и быть/ладно/лады/нулан/ну лан/нулаадно)
        # 4EX: да так и быть уговорил
        q!: [$beginningWords] ($yes2/$yesAgreeTo) (так и быть)[уговорил*]
        # 4EX: да уговорили
        q!: [$beginningWords] ($yes2/$yesAgreeTo) (уговорил*)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Отлично!



    state: YesVery
        # 4EX: да очень
        q!: [$beginningWords] $yes2 $veryAll
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            go!: /ellipsis/YesIAgree



    state: Certainly
        # 4EX: а как же
        q!: [$beginningWords] а как же [иначе]
        q!: [$beginningWords] $certainly [же]
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            go!: /ellipsis/YesIAgree



    state: AgreeTo
        # 4EX: все-все, согласен
        q!: [$beginningWords] $yesAgreeTo [так и быть][уговорил*]
        q!: [$beginningWords] все все ($yes2/$yesAgreeTo)[уговорил*]
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            go!: /ellipsis/YesIAgree



    state: No
        # 4EX: нет же нинада
        q!: [$beginningWords] $no2 [же] [$needNot]
        q!: ($perhaps/пожалуй/вроде [бы/как]/вродебы) $no2 [$needNot]
        # 4EX: нет спасиба
        q!: ($nee/$ne) {[$needNot] [$thanks2]}
        q!: [$beginningWords] $thanks2 ($nee/$ne) [$needNot]
        q!: $beginningWords ($nee/$ne) {[$needNot] [$thanks2]}
        # 4EX: Нет, спасибо
        q!: $no2 {$thanks2 [$needNot]}
        q!: ($beginningWords/$perhaps/пожалуй/вроде [бы/как]/вродебы) $no2 {$thanks2 [$needNot]}
#        if: $client.clientQuery.query == $client.clientQuery.lastQuery && $client.clientQuery.query == $client.clientQuery.preLastQuery
#            go!: /StopQueryOnRepeat
#        else:
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо. Я понял.



    state: OffcourseNo
        # 4EX: конечно нет
        q!: [$beginningWords] [$interjections](($certainly/однозначно) [же] $no2/не однозначно) [$interjections]
        # WARNING LENGTH
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо. Я понял.



    state: BeSokind
        # 4EX: будьте добры
        q!: [$beginningWords] (будте добры/будьте добры/будь добр)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо, конечно.



    state: NuVoot
        # 4EX: эээх
#       q!: (ой/эй а/эй ну/эй ну вот/эй ну а/ну воот/ну и ну/ну так/ну ладно/ну ладно тогда/ну ладно а/лан/ну лан/ну тогда/блин/а блин/да блин/ну блин/вот блин/да ну тебя) *
        q!: (эх/ээх/эээх)
        q!: [эх] ну (воот/воот/воод/вооод)
        q!: жаль
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: 😔



    state: IsItWell
        # 4EX: хорошо?
        q!: (хорошо/харошо) $markQuestion
        q!: $beginningWords (хорошо/харошо) $markQuestion
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Да



    state: Well
        # 4EX: атлична
        q!: (хорошо/харошо)
        q!: $beginningWords (хорошо/харошо)
        q!: [$beginningWords] (отлично/атлична/атлично)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: 👍



    state: Lets
        # 4EX: лавай
        q!: (лавай/лвай)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо



    state: IsItPossible
        # 4EX: возможно?
        q!: [это/эт][$interjections](возможно/вазможно/возможн/вазможн/вероятно/вероятн/вераятно/вераятн/вираятно/вираятн) $markQuestion



    state: Possible
        # 4EX: возможно
        q!: [это/эт][вполн*/оч/очен*/очин*/весьм*] (возможно/вазможно/возможн/вазможн/вероятно/вероятн/вераятно/вераятн/вираятно/вираятн)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Я тоже так думаю



    state: VeryPossible
        # 4EX: это вполне возможно
        q!: [это/эт](вполн*/оч/очен*/очин*/весьм*) (возможно/вазможно/возможн/вазможн/вероятно/вероятн/вераятно/вераятн/вираятно/вираятн)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Я тоже так думаю



    state: RuImenno
        # 4EX: вот именно
        q!: [вот] (именно/имено)
        q!: $beginningWords вот (именно/имено)
        q!: так и есть
        q!: $beginningWords так и есть
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            a: Хорошо




    state: RuTemLuchshe
        # 4EX: тем лучше
        q!: тем лучше
        q!: $beginningWords тем лучше
        a: Согласен




    state: Exactly
        # 4EX: точно
        q!: (точняк/точн/точно/точна)
        if: $client.executeState === undefined
            go!: /operator/goToOpeartor
        else:
            random:
                a: И я так считаю!
                a: И я того же мнения.
                a: Согласен

