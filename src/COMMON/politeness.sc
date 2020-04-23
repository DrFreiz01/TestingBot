theme: /politeness


    state: thanks
        # 4EX: спасиба
        q!: [$beginningWords/о] [$yes2] $thanks2 [$youDat] [$botVocAll]
        q!: [$beginningWords/о] [$yes2] $thanks2 [$youDat][$botVocAll] за *
        q!: [$beginningWords/о] $thanks2 [$youDat][$botVocAll] $what2 *
        # 4EX: понятно, спасибо
        q!: * (ясно/ясн/понятн*/понял*/панятн*) $thanks2 *
        a: Всегда пожалуйста!



    state: thanksNotNeeded
        # 4EX: Спасибо не надо
        q!: [$beginningWords/о] $thanks2 {[$meDat][уже][оно/он/она/это]} $needNot
        a: Если появятся еще вопросы, пожалуйста, пишите.



    state: thanksUnderstood
        # 4EX: спасибо нашла
        q!: [$beginningWords] [$yes2] $thanks2 * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar)
        # 4EX: ну да спасибо понял я
        q!: [$beginningWords] [$yes2] $thanks2 * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) (я/йа/мы/ми)
        # 4EX: ну да спасибо понял уже
        q!: [$beginningWords] [$yes2] $thanks2 * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) (уже/уж/уш/уше/$now2)
        # 4EX: да спасибо нашла сама
        q!: [$beginningWords] [$yes2] $thanks2 * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) (сам/сама/само/сами)
        # 4EX: ну да спасибо ознакомлюсь сам
        q!: [$beginningWords] [$yes2] $thanks2 * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) {(уже/уж/уш/уше/тепер*) (сам/сама/само/сами)}
        # 4EX: Спасибо попробую
        q!: [$beginningWords] [$yes2] $thanks2 * (попробую/попробуем)
        # 4EX: ну да понял спасибо за помощь
        q!: * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) * $thanks2
        q!: * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) * $thanks2 ($youBotAll/$youDat/$vocativeMan/$vocativeGirl/вам)
        q!: * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) * $thanks2 за $oneWord
        q!: * (понял*/нашел*/нашла*/нашли*/нашло*/увидел*/$checkLookFut/$checkLookSynsFar) * $thanks2 {($youBotAll/$youDat/$vocativeMan/$vocativeGirl) (за $oneWord)}
        a: Отлично!



    state: sorry
        # 4EX: сорян
        q!: [$beginningWords] {$sorry [$botVocAll] [$please]}
        a: Ничего страшного



    state: sorryIbotheredYou
        # 4EX: Извините что я вас беспокойл
        q!: [$beginningWords] $sorry * (за беспокойств*/(беспокою/беспокоил*/беспокойл*/побеспокоил*/побеспокойл*))
        a: Я здесь, чтобы отвечать на ваши вопросы.



    state: noOffence
        # 4EX: не обижайся
        q!: * $ne (обижайс*/абижайс*/обежайс*/абежайс*/обижайтес*/абижайтес*/обежайтес*/абежайтес*/обижайтис*/абижайтис*/обежайтис*/абежайтис*) *
        # 4EX: не хотел обидеть!
        q!: * (не хотел*/ни хотел*/нехотел*/нихотел*/не хател*/ни хател*/нехател*/нихател*) * (обидеть/обидить/обижать/обежать/абидеть/абидить/абижать/абежать) *
        # 4EX: я нечаянно
        q!: * (я/мну/йа) * (нечаянно/нечаяно/ничаянно/ничаяно/нечаенно/нечаено/ничаенно/ничаено/не нарочн*/ненарочн*/ни нарочн*/нинарочн*/не нарошн*/ненарошн*/ни нарошн*/нинарошн*/не специальн*/неспециальн*/ни специальн*/ниспециальн*/не спецеальн*/неспецеальн*/ни спецеальн*/ниспецеальн*/ не спициальн*/неспициальн*/ни спициальн*/ниспициальн*/не спицеальн*/неспицеальн*/ни спицеальн*/ниспицеальн*)
        # 4EX: необижайся
        q!: * (необижайс*/необежайс*) *
        # 4EX: не сердись
        q!: *  не (сердись/сердис/дуйся) *
        random:
            a: Ничего страшного
            a: Всё в порядке



    state: doMeAFavor
        # 4EX: да уж будьте добры
        q!: [$beginningWords] [$yes2 [уж]](будь/будьте/будте) (добры/добр)
        a: Сделаю всё, что в моих силах!
