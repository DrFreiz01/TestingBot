theme: /

    state: Test
        intent!: /Yes
        a: kdjhgdfkjghfdkjghfdjkghd
        
    state: tyu
        q!: asd
        script:
            var lat_test = "59.934280";
            var lon_test = "30.335099";
            var reply2 = {
                "type": "location",   
                "lat": lat_test,     
                "lon": lon_test      
            };

            $reactions.answer(JSON.stringify(reply2));
            $response.replies.push(reply2);