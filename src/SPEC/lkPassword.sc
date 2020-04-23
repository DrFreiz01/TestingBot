theme: /lkPassword




    state: forgotMyPassword
        # 4EX: как восстановить пароль
        q!: * {($recover/$findOut) $password} *
        # 4EX: не получается зайти в личный кабинет не правильный пароль
        q!: * {$wrong $password} *
        # 4EX: Как папасть в личный кабинет по емэйлу
        q!: * $enterInf * ($persCabinet/$persProfile/$website) [по/с пом/с помощью/при помощи/с] $email2 *
        q!: * ($persCabinet/$persProfile/$website) * $enterInf [по/с пом/с помощью/при помощи/с] $email2 *
        q!: * [по/с пом/с помощью/при помощи/с] $email2 * $enterInf *
        a: Вы можете восстановить пароль, пройдя по этой ссылке: https://www.ozon.travel/my/remind-password



    state: LkPasswordChange
        # 4EX: Как поменять пароль
        q!: * {$changeAll $password} *
        go!: /lkPassword/forgotMyPassword



    state: howToEnterLK_WithoutPassword
        # 4EX: Как войти в Личный кабинет без пароля?
        q!: * $enterInf в [$my2] ($persCabinet/$persProfile) * ($without [введ*/ввода] / $ne вводя) $password *
        q!: * в [$my2] ($persCabinet/$persProfile) $how [$meDat] $enterInf * ($without [введ*/ввода] / $ne вводя) $password *
        q!: * $how * {(в [$my2] ($persCabinet/$persProfile)) * $enterInf} * ($without [введ*/ввода] / $ne вводя) $password *
        q!: * в [$my2] ($persCabinet/$persProfile) * $how * $enterInf * ($without [введ*/ввода] / $ne вводя) $password *
        q!: * ($without [введ*/ввода] / $ne вводя) $password * $enterInf в [$my2] ($persCabinet/$persProfile) *
        q!: * ($without [введ*/ввода] / $ne вводя) $password * в [$my2] ($persCabinet/$persProfile) $how [$meDat] $enterInf *
        q!: * $how * {(в [$my2] ($persCabinet/$persProfile)) * $enterInf} *
        q!: * ($without [введ*/ввода] / $ne вводя) $password * $how * {(в [$my2] ($persCabinet/$persProfile)) * $enterInf} *
        q!: * в [$my2] ($persCabinet/$persProfile) * ($without [введ*/ввода] / $ne вводя) $password * $how * $enterInf *
        q!: * ($without [введ*/ввода] / $ne вводя) $password * в [$my2] ($persCabinet/$persProfile) * $how * $enterInf *
        go!: /lkPassword/forgotMyPassword



    state: cantEnterLK
        # 4EX: я не могу войти в личный кабинет
        q!: * {($cannot2/$ne выходит/$succeedInNot) $enterInf} * ($persCabinet/$persProfile)
        go!: /lkPassword/forgotMyPassword



    state: lKPassword
        # 4EX: какой у меня пароль
        q!: * $which [у меня/$my2] $password * [$persCabinet/$persProfile] *
        q!: * [$persCabinet/$persProfile] * {$which [у меня/$my2]} $password *
        q!: * {$checkFindOut [$ruSvoi/$my2] $password} * ($persCabinet/$persProfile) *
        q!: * ($persCabinet/$persProfile) * {$checkFindOut [$ruSvoi/$my2] $password} *
        # 4EX: как получить свой пароль
        # 4EX: как узнать свой пароль
        q!: * $how * {(получить/палучить/$checkFindOut) ([$ruSvoi/$my2] $password)} * [$persCabinet/$persProfile] *
        q!: * $how * [$persCabinet/$persProfile] * {([$ruSvoi/$my2] $password) (получить/палучить/$checkFindOut)} *
        q!: * [$persCabinet/$persProfile] * $how * {(получить/палучить/$checkFindOut) ([$ruSvoi/$my2] $password)} *
        # 4EX: лк пароль
        q!: * {($persCabinet/$persProfile) * $password} *
        go!: /lkPassword/forgotMyPassword



    state: lkLostPassword
        # 4EX: У меня был утерян пороль от личного кабинета, как его востоновить?
        q!: * {($lost/$forgot) * $password} * [в/от/для] ($persCabinet/$persProfile) * $how [$meDat] [его] ($recover/$checkFindOut) *
        q!: * $how [$meDat] {($recover/$checkFindOut) $password} * [в/от/для] ($persCabinet/$persProfile) * {($lost/$forgot)} (его/ево) *
        q!: * {($lost/$forgot) * $password} * [в/от/для] ($persCabinet/$persProfile) * $whatShouldIDo *
        q!: * $whatShouldIDo * {($lost/$forgot) * $password} * [в/от/для] ($persCabinet/$persProfile) *
        go!: /lkPassword/forgotMyPassword



    state: iForgotPassword
        # 4EX: старый парол забыл как войти в лк
        q!: * {$forgot ((стар*/предыд*/придыд*/прошл*) $password) } *
        # 4EX: Как сменить пароль если не помню старый
        q!: * $changeInfAll * $password * {$forgot (стар*/предыд*/придыд*/прошл*/его/ево)} *
        q!: * $password * $changeInfAll * {$forgot (стар*/предыд*/придыд*/прошл*/его/ево)} *
        q!: * {$forgot ((стар*/предыд*/придыд*/прошл*) $password)} * $changeInfAll *

        # 4EX: Что делать, если я забыл пароль
        # 4EX: Зобыл пороль што делать
        q!: * {$forgot * ([$my2/$ruSvoi] $password)} *

        # 4EX: какой у меня пароль я забыл
        q!: * $which {(у [$my2/$ruSvoi]) $password} * $forgot *
        q!: * $forgot * $which {(у [$my2/$ruSvoi]) $password} *
        go!: /lkPassword/forgotMyPassword



    state: lkPasswordRecover
        # 4EX: как восстановить пароль в ЛК
        q!: * $how * {($recover/$checkFindOut) $password} * ($persCabinet/$persProfile) *
        q!: * ($persCabinet/$persProfile) * $how * {($recover/$checkFindOut) $password} *
        q!: * ($persCabinet/$persProfile) * {($recover/$checkFindOut) $password} *
        q!: * {($recover/$checkFindOut) $password} * ($persCabinet/$persProfile) *
        q!: * $how * ($persCabinet/$persProfile) {($recover/$checkFindOut) $password} *
        # 4EX: Как зайти в личный кабинет,узнать пароль
        q!: * $how [$meDat] $enterInf * ($persCabinet/$persProfile) * {($recover/$checkFindOut) $password} *
        q!: * {($recover/$checkFindOut) $password} * $enterInf * ($persCabinet/$persProfile)
        # 4EX: не получается зайти в личный кабинет не правильный пароль
        q!: * ($cannot2/$ne выходит/$succeedInNot) $enterInf * ($persCabinet/$persProfile) * {($recover/$checkFindOut) $password} *
        q!: * {($recover/$checkFindOut) $password} * ($cannot2/$ne выходит/$succeedInNot) $enterInf * ($persCabinet/$persProfile) *
        q!: * ($cannot2/$ne выходит/$succeedInNot) $enterInf * ($persCabinet/$persProfile) * {$wrong $password} *
        q!: * {$wrong $password} * ($cannot2/$ne выходит/$succeedInNot) $enterInf * ($persCabinet/$persProfile) *
        # 4EX: Как получить пароль для входа в аккаунт
        q!: * $how * {(получить/палучить) $password} * ($persCabinet/$persProfile) *
        q!: * ($persCabinet/$persProfile) * $how * {(получить/палучить) $password} *
        q!: * ($persCabinet/$persProfile) * {(получить/палучить) $password} *
        q!: * $how * ($persCabinet/$persProfile) {(получить/палучить) $password} *
        # 4EX: как узнать свой старый пороль
        q!: * $checkFindOut {($my2/$ruSvoi) (стар*/прежн*/преждн*) $password} *
        go!: /lkPassword/forgotMyPassword



    state: iDontReceivePassword
        # 4EX: письмо с паролем не приходит
        q!: * письм* c $password * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        # 4EX: напоминание пароля не работает
        q!: * {(напомина* $password) ($doesntWorkSg/$doesntWorkPl)} *
        # 4EX: Я забыл король, а новый на почту не приходит. Ме уже срочно нужно оплатить заказ.
        q!: * {$forgot ([$oneWord] $password) } * новы* на ($mail/$email2) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        # 4EX: Здравствуйте , не получается зайти в личный кабинет . Надпись , что пароль не подходит , а для восстановления пароля ссылка не приходит
        q!: * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) [$meDat] $enterInf * ($persCabinet/$persProfile) * $password ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        # 4EX: не могу купить билет: я уже покупал на озоне, но не помню пароль, по ссылке выслать восстановление пароля на почту, получаю сообщение, что письмо выслано, но письмо не приходит...
        q!: * $password на ($mail/$email2) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        # 4EX: Почему на мой электронный адрес не приходит пароль для восстановления личного кабинета , при правильном ведении электр адреса ????? Уже минут 30 жду
        q!: * {($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) ($password [для восстановлен*])} *
        a: Уточните, пожалуйста, email, на который зарегистрирован ваш личный кабинет.



    state: didntGetPasswordRecoveryUrl
        # 4EX: Почему не отправляется ссылка для восстановления пароля? Я его забыла.
        q!: * {($ne отправля*) (~ссылка/ссыль/~сылка/сыль)} * $password *
        # 4EX: не помню пароль не могу войти в личный кабинет и ссылка на почту не приходит
        q!: * $password * (~ссылка/ссыль/~сылка/сыль) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        q!: * $password * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * (~ссылка/ссыль/~сылка/сыль) *
        q!: * (~ссылка/ссыль/~сылка/сыль) * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) * $password *
        q!: * (~ссылка/ссыль/~сылка/сыль) * $password * ($ne (пришла/пришел/пришёл/пришло/пришли/приходит/приходят/получил*/прислали)) *
        go!: /lkPassword/iDontReceivePassword



    state: iChangedPasswordCantLogIn
        # 4EX: привет! и пароль сенила а авторизация не проходит
        q!: * {($changePerf3/$replacePerf3) $password} * ($ne (проходит/проходет/принимает/вбивается/выбивается)/непроходит/непроходет/непропускает) *
        q!: * ($ne (проходит/проходет/принимает/вбивается/выбивается)/непроходит/непроходет/непропускает) * {($changePerf3/$replacePerf3) $password} *
        go!: /lkPassword/iDontReceivePassword



    state: cantChangePasswordWithUrl
        # 4EX: не могу поменять пароль. перехожу по ссылке в личный кабинет, где поменять. но чтобы поменять надо старый пароль. если бы он был, мне бы не нужно было менять его!!!!
        q!: * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) {($recover/$changeInfAll) $password} * (~ссылка/ссыль/~сылка/сыль) *
        q!: * (~ссылка/ссыль/~сылка/сыль) * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) {($recover/$changeInfAll) $password} *
        # 4EX: Перешли по Вашей ссылке, поменяли пароль и в очередной раз пишет, что неправильный логин или пароль!!!!
        q!: * (~ссылка/ссыль/~сылка/сыль) * {($recover/$changeInfAll) $password} * $wrong * $password *
        q!: * {($recover/$changeInfAll) $password} * (~ссылка/ссыль/~сылка/сыль) * $wrong * $password *
        q!: * $wrong * $password * (~ссылка/ссыль/~сылка/сыль) * {($recover/$changeInfAll) $password} *
        q!: * $wrong * $password * {($recover/$changeInfAll) $password} * (~ссылка/ссыль/~сылка/сыль) *
        go!: /lkPassword/iDontReceivePassword



    state: cantRecoverPassword
         # 4EX: Не получается восстановить пароль по ссылке
         q!: * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * {($recover/$changeInfAll) $password} * (~ссылка/ссыль/~сылка/сыль) *
         q!: * {($recover/$changeInfAll) $password} * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) * (~ссылка/ссыль/~сылка/сыль) *
         q!: * {($recover/$changeInfAll) $password} * (~ссылка/ссыль/~сылка/сыль) * ($succeedInNot/$cannot2/($ne (выходит/выходет/дает/даёт/выходит/выходет)/недает/недаёт/невыходит)) *
         go!: /lkPassword/iDontReceivePassword
