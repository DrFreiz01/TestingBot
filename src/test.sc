require: requirements.sc

theme: /
    state: Start
        q!: * *start
        
        script:
            $session = {}
            
            var output;
            
            var result = {
        
                "2020-04-03":
                    [{
                    "number": "059А",
                    "departureStationCode": "2000000",
                    "arrivalStationCode": "2060350",
                    "dapartureDate": "2020-04-03 02:15",
                    "departureTime": "02:15",
                    "categories": [
                    {
                    "type": "plazcard",
                    "count": 92,
                    "price": 1432
                    },
                    {
                    "type": "coupe",
                    "count": 95,
                    "price": 1540
                    },
                    {
                     "type": "lux",
                     "count": 18,
                     "price": 4019
                     }
                    ]
                    },
                    {
                    "number": "042Ч",
                    "departureStationCode": "2000000",
                    "arrivalStationCode": "2060000",
                    "dapartureDate": "2020-04-03 05:33",
                    "departureTime": "05:33",
                    "categories": [
                    {
                    "type": "plazcard",
                    "count": 96,
                    "price": 982
                    },
                    {
                    "type": "coupe",
                    "count": 40,
                    "price": 1552
                    },
                    {
                     "type": "lux",
                     "count": 12,
                     "price": 2945
                     },
                    {
                    "type": "soft",
                    "count": 4,
                    "price": 9505
                    }]
                    }
                    ],
                "2020-04-04":
                    [{
                    "number": "059А",
                    "departureStationCode": "2000000",
                    "arrivalStationCode": "2060350",
                    "dapartureDate": "2020-04-03 02:15",
                    "departureTime": "02:15",
                    "categories": [
                    {
                    "type": "plazcard",
                    "count": 92,
                    "price": 1000
                    },
                    {
                    "type": "coupe",
                    "count": 95,
                    "price": 1500
                    }]}
                    ]
                };
                
            var filters = {
                // "class": [],
                // "min_time": "23:00",
                // "max_time": "05:00"
            };
            
            output = process_results(result, filters);
            
            $session.output = output;

        
        a: Результаты
        a: {{ toPrettyString($session.output) }}