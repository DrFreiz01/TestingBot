theme: /botQuestions




    state: whatsYourName
        # 4EX: Как вас зовут
        q!: * $how {$youGenAcc $call} *
        q!: * $youGenAcc $how $call *
        # 4EX: есть у тебя имя
        q!: * {(как/какк/ккак/каг/кка/как7/каке/какое/акак) $your2 (имя/имечко/имичко)} *
        q!: * {$your2 (~имя/~имечко)} *

        q!: * {[как/какк/ккак/каг/кка/как7/каке/какое/акак] (у $youGenAcc) (~имя/~имечко)} *
        q!: * {$sayImperative [$your2] (~имя/~имечко)} *
        q!: * {$sayImperative (свое/сое/сове) (~имя/~имечко)} *

        q!: * {(есть/есь) (у $youGenAcc) (~имя/~имечко)} *
        q!: * (есть/есь) ли (у $youGenAcc) (~имя/~имечко) *
        a: Я робот, живу в чате Ozon.Travel. Моя задача - помочь вам выбрать и купить билеты по самым выгодным условиям.



    # Фамилия
    state: surname
        # 4EX: какая у тебя фамилия?
        q!: [$beginningWords] [какая] [у $youGenAcc](~фамилия/фамилли*) [$markQuestion]
        go!: /botQuestions/whatsYourName



    # Твоя фамилия
    state: yourSurname
        # 4EX: давно хотел спросить, как у тебя фамилия
        q!: * {[$how] $your2 (~фамилия/фамилли*)} *
        q!: * {[$how] $youGenAcc (~фамилия/фамилли*)} *
        q!: * {$exist (у $youGenAcc) (~фамилия/фамилли*)} *
        go!: /botQuestions/whatsYourName



    # Имя
    state: nameStrict
        # 4EX: а имя
        q!: [$interjections] [$beginningWords] (~имя/имечк*) [$markQuestion]
        go!: /botQuestions/whatsYourName



    #  Отчество
    state: SecondName
        # 4EX: а отчество
        q!: [$beginningWords] (~отчество/очество)
        go!: /botQuestions/whatsYourName



    #  Как отчество
    state: YourSecondName
        # 4EX: как твоё отчество
        q!: * {[$how] $your2 (~отчество/очество)} *
        q!: * {[$how] $youGenAcc (~отчество/очество)} *
        q!: * {$exist (у $youGenAcc) (~отчество/очество)} *
        go!: /botQuestions/whatsYourName



    # Прозвище
    state: NickName
        # 4EX: есть кликуха
        q!: * {[$how] $your2 (~прозвище/ник/~кликуха/~кличка)} *
        q!: * {[$how] $youGenAcc (~прозвище/ник/~кликуха/~кличка)} *
        q!: * {$sayImperative $your2 (~прозвище/ник/~кликуха/~кличка)} *
        q!: * {$exist (у $youGenAcc) (~прозвище/ник/~кликуха/~кличка)} *
        go!: /botQuestions/whatsYourName



    # Странное имя
    state: OddName
        # 4EX: странное имя
        q!: * {(странно*/страно*/странны*/страным*/страный/странна*/необычн*/ниобычн*/непривычн*/бредов*) * (~имя/~имечко/~кличка/~кликуха/~прозвище)} *
        q!: * (ну и/нуи) (~имя/~имечко/~кличка/~кликуха/~прозвище) *
        q!: * (така*/таку*/тако*) (~имя/~имечко/~кличка/~кликуха/~прозвище) *
        go!: /botQuestions/whatsYourName



    # Как тебя лучше называть?
    state: CallYou
        # 4EX: Как тебя лучше называть?
        q!: * {$how $youGenAcc (лучше/лучьше/лутше/лудше/лутчше/лудчше/лучще/лучьще/лутще/лудще/лутчще/лудчще/луче) $call} *
        go!: /botQuestions/whatsYourName



    # Как к тебе обращаться?
    state: ReferToYou
        # 4EX: Как к тебе обращаться?
        q!: * $how к $youDat [лучше/лучьше/лутше/лудше/лутчше/лудчше/лучще/лучьще/лутще/лудще/лутчще/лудчще/луче] $call *
        q!: * $how [лучше/лучьше/лутше/лудше/лутчше/лудчше/лучще/лучьще/лутще/лудще/лутчще/лудчще/луче] к $youDat $call *
        q!: * $how я могу к $youDat $call *
        q!: * $how мне к $youDat $call *
        go!: /botQuestions/whatsYourName



    state: YouBot
        # 4EX: ты же бот
        q!: [$beginningWords] (ты/вы) [просто/$interjections] $botVocBot
        # 4EX: бот что ли?
        q!: [$beginningWords] {$botVocBot $whether}
        # 4EX: Здравствуйте. Это бот?
        q!: {[$hi/$hello2] [$beginningWords]} {[$interjections] $botAll}
        go!: /botQuestions/YouAreHuman



    state: AreYouABotOrAHumanBeing
        # 4EX: вы робот или человек
        q!: {[$beginningWords] [$interjections]} $you $botAll или [же] $human [$interjections]
        q!: {[$beginningWords] [$interjections]} $you $human или [же] $botAll [$interjections]
        go!: /botQuestions/YouAreHuman



    state: YouAreAI
        # 4EX: ты чатбот
        q!: [$beginningWords] {$you * (чатбот/чат бот/машина)}
        q!: [$beginningWords] (чатбот/чат бот)
        go!: /botQuestions/YouAreHuman



    state: YouAreHuman
        # 4EX: ты настоящий человек
        q!: [$beginningWords] $you [ж/же/ведь][живой/настоящ*] (человек/чловек) *
        a: Я бот, но очень человечный ☺️



    state: AreYouReal
        # 4EX: ты настоящий или нет
        q!: [$beginningWords] $you ([$ne/$interjections] (настоящий/натоящий)/ненастоящий/ненатоящий)
        random:
            a: Я настоящий!
            a: Я ненастоящий, конечно же 😉
