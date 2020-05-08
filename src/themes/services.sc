theme: /Services

    state: HowToGetToThePremiumClub
        # Как попасть в Премиум клуб?
        q!: $premiumClub
        q!: * {~особенность * $premiumClub} *
        q!: * {$how * (попасть/попадают/войти) * $premiumClub} *
        q!: * $forTo * {(попасть/войти) * $premiumClub} *
        q!: * ($possiblePredicAll/могу) * {(попасть/войти) * $premiumClub} *
        q!: * {$want * (попасть/войти) * $premiumClub} *

        q!: * {$how * (вступить/вступают) * $premiumClub} *
        q!: * $forTo * {вступить * $premiumClub} *
        q!: * ($possiblePredicAll/могу) * {вступить * $premiumClub} *
        q!: * {$want * вступить * $premiumClub} *

        q!: * {$how * (стать (участником/членом)) * $premiumClub} *
        q!: * $forTo * (стать (участником/членом)) * $premiumClub *
        q!: * ($possiblePredicAll/могу) * (стать (участником/членом)) * $premiumClub *
        q!: * $want * (стать (участником/членом)) * $premiumClub *

        q!: * {$how * стать * ((премиум/премеум) участником)} *
        q!: * $forTo * {стать * ((премиум/премеум) участником)} *
        q!: * ($possiblePredicAll/могу) * {стать * ((премиум/премеум) участником)} *
        q!: * $want * {(стать/быть) * ((премиум/премеум) участником)} *

        q!: * {$how [мне/я] [могу] получить $premiumClub} *
        q!: * {$how * (получить ~приглашение) * $premiumClub} *
        q!: * $forTo * {получить $premiumClub} *
        q!: * $forTo * {(получить ~приглашение) * $premiumClub} *
        q!: * $forTo * {((быть/стать) приглашен*) * $premiumClub} *
        q!: * $forTo * (пригласили/позвали) * $premiumClub *
        q!: * ($possiblePredicAll/могу) * {получить $premiumClub} *
        q!: * {($possiblePredicAll/могу) * (получить ~приглашение) * $premiumClub} *
        q!: * {$want [мне/я] получить $premiumClub} *
        q!: * {$want * (получить ~приглашение) * $premiumClub} *
        q!: * {$want * ((быть/стать) приглашен*) * $premiumClub} *

        q!: * {$how * (получить членств*) * $premiumClub} *
        q!: * $forTo * {(получить членств*) * $premiumClub} *
        q!: * {($possiblePredicAll/могу) * (получить членств*) * $premiumClub} *
        q!: * {$want * (получить членств*) * $premiumClub} *

        q!: * для получения (~приглашение/членств*) * $premiumClub *

        eg!: Services.HowToGetToThePremiumClub
        a: Столото Премиум-Клуб открывает свои двери самым активным и увлеченным участникам наших лотерей. Тем, кто предан лотерее, как никто другой. Испытывайте удачу как можно чаще. Помните: к заветному моменту, когда Вы получите индивидуальное приглашение в Премиум-Клуб, Вас приближает каждый купленный билет​.


    #state: BurgerKing
        # Как получить скидку в Бургер кинг
        #q!: * {$burgerKing * [$buyInf] * [$ticket]} *
        #q!: * {~скидка * (45%/45 %/45 процентов)} *
        #q!: * {$burgerKing * [~скидка]} *
        #q!: * {~обед * ~скидка} *
        #eg!: Services.BurgerKing
        #a: Условия акции:\n\n1. Купите билет на 1312-й или 1313-й тираж «Русского лото».\n2. Сообщите номер вашего билета кассиру в ресторане Burger King.\n3. Получите комбо-обед со скидкой!\n\nВ комбо-обед входит воппер джуниор, маленькая картошка и напиток на выбор. Комбо-обед со скидкой можно получить в период с 01.12.2019 по 30.01.2020. Обращаем Ваше внимание, что для участия в акции неважно, выиграл билет или нет. Подробная информация - по [ссылке](https://www.stoloto.ru/press/news/2019/11/17/akciya-dlya-uchastnikov-1312-1313-tirazhej-russkogo-loto).


