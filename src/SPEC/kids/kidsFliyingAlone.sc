theme: /kidsFliyingAlone




    state: kidFlyingAloneUtair
        # 4EX: Добрый вечер! Можно ли компанией Ютейр перевозить не сопровождаемых детей
        q!: * $utair * {$transportationAll ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl)} * ($without (сопровождени*/взросл*/$parent)/одни*) *
        q!: * {$transportationAll ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl)} ($without (сопровождени*/взросл*/$parent)/одни*) * $utair *

        q!: * $utair * $transportationAll * ($ne сопровожд*/неспоровожд*/несопровожд*) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        q!: * $transportationAll * ($ne сопровожд*/неспоровожд*/несопровожд*) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $utair *
        a: Дети до 12 лет должны следовать на рейсах Utair в сопровождении совершеннолетнего пассажира. \nС 12 лет дети могут путешествовать самостоятельно. Обращаем ваше внимание, что при международных перелетах необходимо разрешение родителей на выезд за пределы РФ.



    state: kidFlyingAlone
        # 4EX: сколько лет должно быть ребенку чтобы он летел один?
        # 4EX: со скольких лет дети могут летать без сопровождение?
        q!: * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * ($ne сопровожд*/неспоровожд*) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        # 4EX: со скольки лет мы оформляем без сопровождения?
        q!: * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * ($buyAllExceptPast/$issueAllExceptPast/$bookInf/$orderVerbInf/$orderMoreVerbInf) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        # 4EX: дети с какова возраста могут лететь одни?
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ($ne сопровожд*/неспоровожд*) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) *
        # 4EX: дети могут лететь одни со скольких лет?
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $howMuch (лет/годов/годков) *
        q!: * ($ne сопровожд*/неспоровожд*) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $howMuch (лет/годов/годков) *
        # 4EX: со скольки лет можно отправлять ребёнок одного?
        q!: * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) * {(отправить/отправлять/атправить/*слать/*сылать) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl)} (один/одни*/одного/одному/одново/адново/адного/адному) *
        q!: * {(отправить/отправлять/атправить/*слать/*сылать) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl)} (один/одни*/одного/одному/одново/адново/адного/адному) * [со/с] (скольк* (лет/годов/годков/годка/годков/годиков/годика/года)/$which возраст*) *
        # 4EX: Может ли ребенок лететь один? Девочка 5,5 лет? Краснодар- самара
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $ageWithNumb *
        q!: * $ageWithNumb * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent))
        # 4EX: Здравствуйте может ли лететь ребёнок 9 лет без взрослого
        # 4EX: Добрый день. Ребенку 16 лет можно одному лететь на самолете? и нужны ли какие бумаги для этого?
        # 4EX: возможно ли мне отправить дочь 12-ти лет без сопровождения на самолете в Питер?  Её там встретят. И что мне нужно для этого из документов?
        # 4EX: Здравствуйте, скажите правило перелета ребенка 12 лет самостоятельно, нужно ли заказывать сопровождение или он может лететь один
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb *
        # 4EX: Сопровождение ребенка сколько есть и сколько стоит
        q!: * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $howMuch $cost *
        q!: * $howMuch $cost * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        # 4EX: Здравствуйте, скажите, как осуществляется перелет ребенка 12 лет самостоятельно, нужно ли заказывать сопровождение?
        q!: * $flight ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна) *
        # 4EX: Здравствуйте моему сыну  16 лет и скоро надо летит в Бишкек  он может  самостоятельно летит в Бишкек
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $ageWithNumb *
        if: parseInt($parseTree._ageWithNumb) <= 12
            a: От 5 до 12 лет вы уже можете отправить ребенка одного, но для этого обязательно потребуется оформлять услугу сопровождения. Стоимость будет зависеть от авиакомпании и направления.
        else:
            a: После 12 лет услуга сопровождения детей в некоторых авиакомпаниях является обязательной, а в некоторых - нет. В таком случае все будет зависеть от авиакомпании.



    state: kidFlyingAloneFromDest
        # 4EX: Здравствуйте, могу ли отправить ребёнка 12 лет одного? Москва Геленжик
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {(отправить/отправлять/атправить/*слать/*сылать) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) [$ageWithNumb]} (один/одни*/одного/одному/одново/адново/адного/адному) *
        q!: * {(отправить/отправлять/атправить/*слать/*сылать) ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) [$ageWithNumb]} (один/одни*/одного/одному/одново/адново/адного/адному) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * $ageWithNumb * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb *
        q!: * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb *
        q!: * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb *
        q!: * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $howMuch $cost *
        q!: * сопровожд* $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $howMuch $cost *
        q!: * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $howMuch $cost *
        q!: * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $howMuch $cost * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $howMuch $cost * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        q!: * $howMuch $cost * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        q!: * $howMuch $cost * сопровожд* $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) *
        q!: * $howMuch $cost * сопровожд* ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $flight ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна) *
        q!: * $flight ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна) *
        q!: * $flight ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $ageWithNumb * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        q!: * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode * $ageWithNumb *
        q!: * ($childSgPl/$childDaughter/$childSon/~дети/$boy/$girl) * {($flyInf/*летел/*летела/*летели/летит/летят) (самостоятельно/самастоятельно/самостоятельна/самастоятельна/самостаятельно/самостаятельна)} * $ageWithNumb * $iataAndRailway::fromCode {[$oneWord] [$to] [$cityPreName]} $iataAndRailway::destCode *
        go!: /kidsFliyingAlone/kidFlyingAlone



    state: ImKidFlyingAlone
        # 4EX: мне 13 лет могу ли я один полететь на самолёте без сопровождения ?
        q!: * мне * $ageWithNumb * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) *
        q!: * ({($flyInf/*летел/*летела/*летели/летит/летят) (один/одни*/одного/одному/одново/адново/адного/адному)}/ $without (сопровождени*/взросл*/$parent)) * мне * $ageWithNumb *
        if: parseInt($parseTree._ageWithNumb) <= 12
            a: От 5 до 12 можно лететь одному, но для этого обязательно потребуется оформлять услугу сопровождения. При оформлении этой услуги тариф оплачивается в полном объеме как на взрослого пассажира, дополнительно оплачивается и сама услуга. Стоимость будет зависеть от авиакомпании, направления и подкласса.
        else:
            a: После 12 лет услуга сопровождения в некоторых авиакомпаниях является обязательной, а в некоторых - нет. В таком случае все будет зависеть от авиакомпании.

