require: slotfilling/slotFilling.sc
    module = sys.zb-common
    
patterns:
    $test

theme: /

    state: Start
        q!: $regex</start>
        a: Добрый день!
        go!: /Start/GetService

        state: GetService
            a: Что вы хотите заказать ?

            state:
                q: * @service *
                script:
                    $session.service = $parseTree.value.title;
                    var variations = $parseTree.value.variations;
                    
                    // variations for ask
                    var varchoice = '';
                    
                    // pattern for compare answer: {$var1|$var2...|varN}
                    var varpat = '{';

                    for (var i = 0; i < variations.length; i++) {
                        if (i > 0) {
                            varchoice = varchoice + ', ';
                            varpat =  varpat + '|'; 
                        }
                        varchoice = varchoice + variations[i].name;
                        varpat = varpat + variations[i].name;
                    }
                    varpat = varpat + '}';
                    
                    $session.variations = variations;
                    $session.varchoice = varchoice;
                    $session.varpat = varpat;
                go!: /Start/GetVariant
                    
                state:
                    event: noMatch
                    a: Я не понял service.
                    go!: /Start/GetService

        state: GetVariant
            a: Какой из вариантов вы хотите выбрать: {{ $session.varchoice }} ?
            a: Паттерн для обработки {{ $session.varpat }} 
            
            state:
                q: * $test  *
                script:
                a: Вы сказали  {{$request.query}}
                
            state:
                event: noMatch
                a: Я не понял variant.
                go!: /Start/GetVariant

    state:
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
