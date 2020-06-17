theme: /

    state: Test
        intent!: /Yes
        a: kdjhgdfkjghfdkjghfdjkghd
        
    state: tyu
        q!: asd
        script:
            var reply2 = {
                "type": "location",   
                "lat": 59.934280,     
                "lon": 30.335099      
            };

            $reactions.answer(JSON.stringify(reply2));
            
        a: {{ $session.reply2 }}