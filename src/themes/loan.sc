theme: /Loaning
    state: Loan
        intent!: /LoanEarlyPayment
        script:
            $session.LoanType = $parseTree._LoanType
            $session.LoanSizeType = $parseTree._LoanSizeType
        if: $parseTree._LoanType === "ипотечный кредит"
            go!: /Loaning/MortgageMaternityCapital
        go!: /Loaning/OverduePayment

    state: MortgageMaternityCapital
        a: Ранее, для погашения данного кредита, вами был использован материнский капитал?

        state: Yes
            q: * @Agree *
            script: $session.maternalCapital = true
            a: К сожалению, через чат это сделать не получится. Обратитесь, пожалуйста, в отделение банка.

        state: No
            q: * @Disagree *
            script: $session.maternalCapital = false
            go!: /Loaning/OverduePayment

    state: OverduePayment
        a: На текущий момент у вас имеется просрочка?

        state: Yes
            q: * @Agree *
            script: $session.overdue = true
            a: В таком случае просим вас погасить задолженность, и после погашения повторно написать нам в чат.
            go!: /Loaning/Result

        state: No
            q: * @Disagree *
            script: $session.overdue = false
            a: Дата досрочного погашения возможна с ближайшего рабочего дня, если деньги размещены на счете.
            go!: /Loaning/GetDateAndAmount

    state: GetDateAndAmount
        a: Когда и какую сумму вы планируете погасить?

        state: GetArgs
            intent: /LoanDateAndAmount
            script:
                $session.time = $parseTree._time
                $session.amount = $parseTree._amount
            go!: /Loaning/Result

    state: Result
        a: Тип кредита: {{ $session.LoanType }}
        a: Размер погашения: {{ $session.LoanSizeType }}
        a: Материнский капитал: {{ $session.maternalCapital ? "использован" : "не использован" }}
        a: Просорчка: {{ $session.overdue }}
        a: Планируемое время погашения: {{ toPrettyString($session.time) }}
        a: Планируемая сумма погашения: {{ $session.amount }}