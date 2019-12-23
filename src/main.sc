require: functions.js

theme: /

    state: Welcome
        q!: * *start
        a: Привет! Я электронный помощник. Я могу сообщить вам текущую погоду в Санкт-Петербурге.
        go!: /GetWeather

    state: GetWeather
        script:
            openWeatherMapCurrent("metric", "ru", 30, 30).then(function (res) {
                if (res && res.weather) {
                    $reactions.answer("Сегодня в городе Санкт-Петербурге " + res.weather[0].description + ", " + Math.round(res.main.temp) + "°C" );
                } else {
                    $reactions.answer("Что-то сервер барахлит. Не могу узнать погоду.");
                }
            }).catch(function (err) {
                $reactions.answer("Что-то сервер барахлит. Не могу узнать погоду.");
            });

    state: CatchAll
        q!: *
        a: Извините, я вас не понимаю, зато могу рассказать о погоде
        go!: /GetWeather