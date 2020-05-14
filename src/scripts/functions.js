// ФУНКЦИИ

// авиапоиск: фильтр багаж
function baggageFilter(httpResponse) {
    var tariffIndex;
    for (var i = 0; i < httpResponse.tariffs.length; i++) {
        if (httpResponse.tariffs[i].shortFeatures.luggage.placesCount > 0) {
            tariffIndex = i;
            break;
        }
    }
    return tariffIndex;
}


// авиапоиск: фильтр утро/вечер
function dayTimeFilter(httpResponse) {
    var neededTime, tariffIndex, flightIndex, variantIndex, segmentIndex, exit_flag;
    exit_flag = false;
    // проходимся по выдаче
    for (var i = 0; i < httpResponse.tariffs.length; i++) {
        for (var j = 0; j < httpResponse.tariffs[i].flights.length; j++) {
            for (var k = 0; k < httpResponse.tariffs[i].flights[j].variants.length; k++) {
                if (isRightTime (httpResponse.tariffs[i].flights[j].variants[k].segments[0], $session.dayTime) == true) {
                    tariffIndex = i;
                    flightIndex = j;
                    variantIndex = k;
                    exit_flag = true;
                }
                if (exit_flag == true) {
                    break;
                }
            }
            if (exit_flag == true) {
                break;
            }
        }
        if (exit_flag == true) {
            break;
        }
    }
    return {tariffIndex: tariffIndex, flightIndex: flightIndex, variantIndex: variantIndex};
}


// авиапоиск: фильтр утро/вечер + багаж
function dayTimeBaggFilter (httpResponse) {
    var neededTime, tariffIndex, flightIndex, variantIndex, segmentIndex, exit_flag;
    exit_flag = false;
    // проходимся по выдаче
    for (var i = 0; i < httpResponse.tariffs.length; i++) {
        for (var j = 0; j < httpResponse.tariffs[i].flights.length; j++) {
            for (var k = 0; k < httpResponse.tariffs[i].flights[j].variants.length; k++) {
                if (isRightTime (httpResponse.tariffs[i].flights[j].variants[k].segments[0], $session.dayTime) == true && httpResponse.tariffs[i].shortFeatures.luggage.placesCount > 0) {
                    tariffIndex = i;
                    flightIndex = j;
                    variantIndex = k;
                    exit_flag = true;
                }
                if (exit_flag == true) {
                    break;
                }
            }
            if (exit_flag == true) {
                break;
            }
        }
        if (exit_flag == true) {
            break;
        }
    }
    return {tariffIndex: tariffIndex, flightIndex: flightIndex, variantIndex: variantIndex};
}



// категория жд билета для юзера
function getCategory4User (category) {
    if (category == 'LUXURY') {
        category =  'в СВ вагоне'
    }
    if (category == 'SOFT') {
        category =  'в вагоне люкс'
    }
    if (category == 'COMMON') {
        category =  'в общем вагоне'
    }
    if (category == 'RESERVED') {
        category =  'в плацкартном вагоне'
    }
    if (category == 'COMPARTMENT') {
        category =  'в купе'
    }
    if (category == 'SITTING') {
        category =  'в сидячем вагоне'
    }
    return category;
}


// находим нужный жд билет
function getRailwayCategory (httpResponse) {
    // кладем в объект tripOffer index и соответствующие ему цены
    var idPriceObj = {};
    for (var a = 0; a < httpResponse.length; a++){
        for (var b = 0; b < httpResponse[a].tariffs.length;b++) {
            var price = httpResponse[a].tariffs[b].minPrice;
            price = price.toString();
            idPriceObj[price] = [a, b];
        }
    }
    // cортируем
    var idPriceObjAsc = {};
    Object.keys(idPriceObj).sort().forEach(function(key) {
      idPriceObjAsc[key] = idPriceObj[key];
    });

    // идем от дешевых к дорогим и проверяем категорию, время суток, время в пути
    for (price in idPriceObjAsc) {
        var depTime = httpResponse[idPriceObjAsc[price][0]].segments[0].departureTime.time;
        depTime = depTime.split('T');
        depTime = depTime[1];
        depTime = depTime.split(':');
        depTime = depTime[0];
        if (parseInt(depTime) > 21 && parseInt(depTime) < 5) {
            var dayTime = 'night';
        } else {
            var dayTime = 'day';
        }
        if (httpResponse[idPriceObjAsc[price][0]].segments[0].duration < 18000 && dayTime == 'day' && httpResponse[idPriceObjAsc[price][0]].tariffs[idPriceObjAsc[price][1]].category == 'SITTING') {
            return idPriceObjAsc[price];
        } else if (httpResponse[idPriceObjAsc[price][0]].tariffs[idPriceObjAsc[price][1]].category != 'SITTING'){
            return idPriceObjAsc[price];
        }
    }
}


// ищем утро/вечер в авиавыдаче
function isRightTime (value, mode) {
    var time = value.departureTime.time.split('T');
    var hour = time[1].split(':');
    if (mode == 'утро') {
        if (parseInt(hour[0],10) >= 4 && parseInt(hour[0],10) <= 12) {
            return true;
        }
    } else if (mode == 'вечер') {
        if (parseInt(hour[0],10) >= 17 && parseInt(hour[0],10) <= 24) {
            return true;
        }
    } else {
        return null;
    }
    return false;
}


// внутренний календарь цен
function calendarSearchPost (obj) {
    if (!obj.passengers) {
        obj.passengers = 1;
    }
    var result = $http.query('https://uniapi.ozon.travel/flightcalendar/getprices/', {
        method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
        body: {
          "adults": obj.passengers,
          "arrivalCode": obj.dest,
          "children": 0,
          "departCode": obj.from,
          "infants": 0,
          "isRoundTrip": false
        },                        // тело запроса
        headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
        dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
        timeout: 15000        // таймаут выполнения запроса в мс
    });
    return result;
}


// поиск цен для ЖД
function getRailwayPrices (httpResponse) {
    var arrPrices = [];
    for (var i = 0; i < httpResponse.length; i++) {
        var everyTrip = httpResponse[i];
        for (var k = 0; k < everyTrip.tariffs.length; k++) {
            var everyTariff = everyTrip.tariffs[k];
            for (var tariff in everyTariff) {
                if (tariff === 'minPrice') {
                    arrPrices.push(everyTariff[tariff]);
                }
            }
        }
    }
    //получаем мин цену
    return getMinValue(arrPrices);
}


// новое авиа апи
function aviaSearchPost (obj,direct) {
    if (!obj.passengers) {
        obj.passengers = 1;
    }
    if (direct) {
        if (obj.date) {
            var result = $http.query('https://uniapi.ozon.travel/flight/search', {
                method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
                body: {
                  "routes": [
                    {
                      "from": obj.from,
                      "to": obj.dest,
                      "date": obj.date
                    }
                  ],
                  "adults": obj.passengers,
                  "serviceClass": "ECONOMY",
                  "onlyDirect": true,
                  "platform": "ANDROID"
                },                        // тело запроса
                headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
                dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
                timeout: 15000        // таймаут выполнения запроса в мс
            });
        }
        if (obj.dates1 && obj.dates2) {
            var result = $http.query('https://uniapi.ozon.travel/flight/search', {
                method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
                body: {
                  "routes": [
                    {
                      "from": obj.from,
                      "to": obj.dest,
                      "date": obj.dates1
                    },
                    {
                        "from": obj.dest,
                        "to": obj.from,
                        "date": obj.dates2
                    }
                  ],
                  "adults": obj.passengers,
                  "serviceClass": "ECONOMY",
                  "onlyDirect": true,
                  "platform": "ANDROID"
                },                        // тело запроса
                headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
                dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
                timeout: 15000        // таймаут выполнения запроса в мс
            });
        }
    } else {
        if (obj.date) {
            var result = $http.query('https://uniapi.ozon.travel/flight/search', {
                method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
                body: {
                  "routes": [
                    {
                      "from": obj.from,
                      "to": obj.dest,
                      "date": obj.date
                    }
                  ],
                  "adults": obj.passengers,
                  "serviceClass": "ECONOMY"
                },                        // тело запроса
                headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
                dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
                timeout: 15000        // таймаут выполнения запроса в мс
            });
        }
        if (obj.dates1 && obj.dates2) {
            var result = $http.query('https://uniapi.ozon.travel/flight/search', {
                method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
                body: {
                  "routes": [
                    {
                      "from": obj.from,
                      "to": obj.dest,
                      "date": obj.dates1
                    },
                    {
                        "from": obj.dest,
                        "to": obj.from,
                        "date": obj.dates2
                    }
                  ],
                  "adults": obj.passengers,
                  "serviceClass": "ECONOMY"
                },                        // тело запроса
                headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
                dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
                timeout: 30000        // таймаут выполнения запроса в мс
            });
        }
    }

    return result;
};


// жд поиск
function railwaySearchPost (obj) {
    if (!obj.passengers) {
        obj.passengers = 1;
    }
    var result = $http.query('https://uniapi.ozon.travel/railway/search', {
        method: "POST",     // http-метод запроса - GET, POST, PUT и т.д.
        body: {
          "adults": obj.passengers,
          "children": 0,
          "gds": "string",
          "infants": 0,
          "platform": "SITE",
          "routes": [
            {
              "date": obj.date,
              "from": obj.from,
              "to": obj.dest
            }
          ]
        },                        // тело запроса
        headers: {"x-o3-app-name": "chatBot-api"},     // http-заголовки
        dataType: "json",     // тип возвращаемых данных - json, xml или text. По умолчанию используется тип, соответствующий заголовку content-type в ответе
        timeout: 15000        // таймаут выполнения запроса в мс
    });
    return result;
};


// формирование авиа ссылки озон
function urlOzonAvia (obj,yandex) {
    if (obj) {
        var url = '';
        var yaTail = '';
        var directFilter = '';
        var baggageFilter = '';
        var search = 'https://www.ozon.travel/flight/search/';
        if (!obj.passengers) {
            obj.passengers = 1;
        }
        if (yandex) {
            yaTail = 'utm_source=yandex&utm_medium=chatbot&utm_content=link&utm_campaign=bot&';
        }
        if (obj.direct) {
            directFilter = '&filter.ssn=0';
        }
        if (obj.baggage) {
            baggageFilter = '&filter.lugg=1';
        }
        if (obj.date) {
            url = search + obj.from + obj.dest + '/d' + obj.date + '/?' + yaTail + 'Dlts=' + obj.passengers + '&BotName=Chatbot' + directFilter + baggageFilter;
        } else if (obj.dates1 && obj.dates2) {
            url = search + obj.from + obj.dest + obj.dest + obj.from + '/d' + obj.dates1 + 'd' + obj.dates2 + '/?' + yaTail + 'Dlts=' + obj.passengers + '&BotName=Chatbot' + directFilter + baggageFilter;
        }
    }
    return url;
};


// формирование жд ссылки озон
function urlOzonRailway (obj) {
    if (obj) {
        if (obj.passengers) {
            return "https://www.ozon.travel/railway/search/" + obj.from + obj.dest + '/d' + obj.date + '/?Dlts=' + obj.passengers + '&BotName=Chatbot';
        } else {
            return "https://www.ozon.travel/railway/search/" + obj.from + obj.dest + '/d' + obj.date + '?BotName=Chatbot';
        }
    }
};


// сравнение даты, введенной пользователем и сегодняшнего числа
function datesComparison (date) {
    var today = operatingOnToday(0).split('-');
    today = today.join('');
    date = date.split('-');
    date = date.join('');
    if (date < today) {
        return false;
    } else {
        return true;
    }
};


// обертка даты для юзера
function getDate4User (date) {
    date = date.replace(/(\d{4})-[0]?(\d+)-[0]?(\d+)/, "$3 $2 $1");
    date = date.split(' ');
    var monthDig = date[1]-1;
    var monthsLang = ['января', 'февраля', 'марта', 'апреля', 'мая', 'июня', 'июля', 'августа', 'сентября', 'октября', 'ноября', 'декабря'];
    date[1] = monthsLang[monthDig];
    return date.join(' ');
};


// обертка времени для юзера
function getTime4User (time) {
    if (time.match(/[0-9-]+T.+/)) {
        time = time.replace(/.+T(\d{2}:\d{2}).*/, "$1");
    } else {
        time = time.replace(/(\d{2}:\d{2}):\d{2}/, "$1");
    }
    return time;
};


// обертка количества билетов для юзера
function getTicketNumb4User (numb, age) {
    if (numb > 9) {
        return 'groupTicket';
    } else if (numb == 1) {
        return 'билета';
    } else {
        return numb + ' билетов';
    }
};


// отлов даты с буквами
function dateLetters (date, month) {
    if (date.match(/^числ. \d{1,2}$/i) || date.match(/^\d{1,2} +числ.$/i)) {
        // числа 16
        if (date.match(/^числ. \d{1,2}$/i)) {
            date = date.split(' ');
            var day = addZero(date[1]);
        }
        // 16 числа
        if (date.match(/^\d{1,2} +числ.$/i)) {
            var re = (/ +/);
            date = date.split(re);
            var day = addZero(date[0]);
        }
        var currentDate = new Date();
        currentDate.setDate(currentDate.getDate());
        var year = currentDate.getFullYear();
        if (month) {
            month = month.toString();
            month = addZero(month);
            date = year + '-' + month + '-' + day;
            if (datesComparison(date) == false) {
                year = addYear(year);
                var date = year + '-' + month + '-' + day;
            }
        } else {
            var month = currentDate.getMonth() + 1;
            month = month.toString();
            month = addZero(month);
            date = year + '-' + month + '-' + day;
            if (datesComparison(date) == false) {
                month = currentDate.getMonth() + 2;
                month = month.toString();
                month = addZero(month);
                var date = year + '-' + month + '-' + day;
            }
        }
    } else {
        if (date.match(/^\d{1,2}( |-)?(ого|го|uj|juj)? [а-яё]+ ?(20)?(\d{2})?г?$/i)) {
            var day = date.replace(/^(\d{1,2})( |-)?(ого|го|uj|juj)? [а-яё]+ ?(20)?(\d{2})?г?$/i, '$1');
            var year = date.replace(/^\d{1,2}( |-)?(ого|го|uj|juj)? [а-яё]+ ?(20)?(\d{2})?г?$/i, '$4');
        } else if (date.match(/^[а-яё]+ ?\d{1,2}( |-)?(ого|го|uj|juj)? ?(20)?(\d{2})?г?$/i)) {
            var day = date.replace(/^[а-яё]+ ?(\d{1,2})( |-)?(ого|го|uj|juj)? ?(20)?(\d{2})?г?$/i, '$1');
            var year = date.replace(/^[а-яё]+ ?\d{1,2}( |-)?(ого|го|uj|juj)? ?(20)?(\d{2})?г?$/i, '$4');
        }
        var day = addZero(day);
        if (year) {
            year = '20' + year;
        } else {
            var currentDate = new Date();
            var year = currentDate.getFullYear();
            var currentMonth = currentDate.getMonth() + 1;
            if (month < currentMonth) {
                year = year + 1;
            }
        }
        date = year + '-' + month + '-' + day;
    }
    return date;
};


// отлов даты с цифрами
function catchDate (date) {
    var currentDate = new Date();
    var year = currentDate.getFullYear();

    // 13.12.2019, 13 5 2019, 1.12.2019, 1 5 2019
    if (date.match(/^[0-3]?\d[   /,.-]+\d{1,2}[   /,.-]+20\d{2}г?$/)) {
        date = date.replace(/([0-3]?\d)[   /,.-]+(\d{1,2})[   /,.-]+(20\d{2})г?/, "$3-$2-$1");
        date = date.split(/-/);
        date[1] = addZero(date[1]);
        date[2] = addZero(date[2]);
        date = date.join('-');
        return date;
    }
    // 13.12.19, 13 5 19, 1.12.19, 1 5 19
    if (date.match(/^[0-3]?\d[   /,.-]+\d{1,2}[   /,.-]+\d{2}г?$/)) {
        date = date.replace(/([0-3]?\d)[   /,.-]+(\d{1,2})[   /,.-]+(\d{2})г?/, "20$3-$2-$1");
        date = date.split(/-/);
        date[1] = addZero(date[1]);
        date[2] = addZero(date[2]);
        date = date.join('-');
        return date;
    }
    // 2019.12.13, 2019.12.1, 2019 5 13, 2019 5 6
    if (date.match(/^20\d{2}[   /,.-]\d{1,2}[   /,.-]+[0-3]?\d$/)) {
        date = date.replace(/(20\d{2})[   /,.-](\d{1,2})[   /,.-]+([0-3]?\d)/, "$1-$2-$3");
        date = date.split(/-/);
        date[1] = addZero(date[1]);
        date[2] = addZero(date[2]);
        date = date.join('-');
        return date;
    }
    // 1.12, 01.12, 01 4, 1.4
    if (date.match(/^\d{1,2}[   /,.-]{1,3}\d{1,2}$/)) {
        date = date.split(/[   /,.-]{1,3}/);
        var day = addZero(date[0]);
        var month = addZero(date[1]);
        date = year + '-' + month + '-' + day;
        if (datesComparison(date) == false) {
            year = addYear(year);
            date = year + '-' + month + '-' + day;
        }
        return date;
    }
    // 1 декабря, 12 декабря
    if (date.match(/^\d{1,2} ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*)$/i)) {

        var month = date.replace(/^\d{1,2} ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*)$/i, "$1");

        month = month.toLowerCase();
        var months = [
            'январ',
            'феврал',
            'март',
            'апрел',
            'мая',
            'июн',
            'июл',
            'август',
            'сентябр',
            'октябр',
            'ноябр',
            'декабр'
        ];
        for (var k = 0; k < months.length; ++k) {
            var everyMonth = months[k];
            if (month.indexOf(everyMonth) != -1) {
                var monthDig = k + 1;
                monthDig < 10 ? monthDig = '0' + monthDig : monthDig = '' + monthDig;
            }
        }
        var day = date.replace(/(\d{1,2}) ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*)/i, "$1");
        day = addZero(date);
        date = year + '-' + monthDig + '-' + day;
        if (datesComparison(date) == false) {
            year = addYear(year);
            date = year + '-' + monthDig + '-' + day;
        }
        return date;
    }
    // декабрь 1, декабрь 12
    if (date.match(/^(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ?\d{1,2}$/i)) {
        var month = date.replace(/(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ?\d{1,2}/i, "$1");
        month = month.toLowerCase();
        var months = [
            'январ',
            'феврал',
            'март',
            'апрел',
            'мая',
            'июн',
            'июл',
            'август',
            'сентябр',
            'октябр',
            'ноябр',
            'декабр'
        ];
        for (var k = 0; k < months.length; ++k) {
            var everyMonth = months[k];
            if (month.indexOf(everyMonth) != -1) {
                var monthDig = k + 1;
                monthDig < 10 ? monthDig = '0' + monthDig : monthDig = '' + monthDig;
            }
        }
        var day = date.replace(/(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ?(\d{1,2})/i, "$2");
        day = addZero(date);
        date = year + '-' + monthDig + '-' + day;
        if (datesComparison(date) == false) {
            year = addYear(year);
            date = year + '-' + monthDig + '-' + day;
        }
        return date;
    }
    // 21 июня 2019
    if (date.match(/^(\d{1,2}) ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ((20)?\d{2})г?$/)) {
        var month = date.replace(/(\d{1,2}) ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ((20)?\d{2})г?/i, "$2");
        month = month.toLowerCase();
        var months = [
            'январ',
            'феврал',
            'март',
            'апрел',
            'мая',
            'июн',
            'июл',
            'август',
            'сентябр',
            'октябр',
            'ноябр',
            'декабр'
        ];
        for (var k = 0; k < months.length; ++k) {
            var everyMonth = months[k];
            if (month.indexOf(everyMonth) != -1) {
                var monthDig = k + 1;
                monthDig < 10 ? monthDig = '0' + monthDig : monthDig = '' + monthDig;
            }
        }
        date = date.replace(/(\d{1,2}) ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*) ?((20)?\d{2})г?/, "$3-"+ monthDig +"-$1");
        date = date.split('-');
        date[0].length == 2 ? date[0] = '20' + date[0] : date[0] = '' + date[0];
        date[2].length == 1 ? date[2] = '0' + date[2] : date[2] = '' + date[2];
        date = date.join('-');
        return date;
    }
    // 13.03.-17.03, 01.04-05.04
    if (date.match(/^(\d{1,2}[   /.-]{1,3}(01|02|03|04|05|06|07|08|09|10|11|12))([ /.,-]{1,3})(\d{1,2}[   /.-]{1,3}(01|02|03|04|05|06|07|08|09|10|11|12))$/)) {
        date = date.replace(/^(\d{1,2}[   /.-]{1,3}(01|02|03|04|05|06|07|08|09|10|11|12))([ /.,-]{1,3})(\d{1,2}[   /.-]{1,3}(01|02|03|04|05|06|07|08|09|10|11|12))$/, "$1#$4");
        date = date.split('#');

        if (date[0].match(/^\d{1,2}[   /.-]{1,3}\d{2}$/)) {
            var date1 = date[0].split(/[   /.-]{1,3}/);
            var month = date1[1];
            var day = addZero(date1[0]);
            date1 = year + '-' + month + '-' + day;
            if (datesComparison(date1) == false) {
                year = addYear(year);
                date1 = year + '-' + month + '-' + day;
            }
        }
        if (date[1].match(/^\d{1,2}[   /.-]{1,3}\d{2}$/)) {
            var date2 = date[1].split(/[   /.-]{1,3}/);
            var month = date2[1];
            var day = addZero(date2[0]);
            date2 = year + '-' + month + '-' + day;
            if (datesComparison(date2) == false) {
                year = addYear(year);
                date2 = year + '-' + month + '-' + day;
            }
        }
        return [date1, date2];
    }
    //10-11 мая
    if (date.match(/^\d{1,2}-\d{1,2} ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*)$/))
        date = date.replace(/(\d{1,2})-(\d{1,2}) ?(январ[а-яА-Я]*|феврал[а-яА-Я]*|март[а-яА-Я]*|апрел[а-яА-Я]*|мая|июн[а-яА-Я]*|июл[а-яА-Я]*|август[а-яА-Я]*|сентябр[а-яА-Я]*|октябр[а-яА-Я]*|ноябр[а-яА-Я]*|декабр[а-яА-Я]*)/, "$1#$2#$3");
        date = date.split('#');
        date[0] = addZero(date[0]);
        date[1] = addZero(date[1]);
        var month = date[2].toLowerCase();
        var months = [
            'январ',
            'феврал',
            'март',
            'апрел',
            'мая',
            'июн',
            'июл',
            'август',
            'сентябр',
            'октябр',
            'ноябр',
            'декабр'
        ];
        for (var k = 0; k < months.length; ++k) {
            var everyMonth = months[k];
            if (month.indexOf(everyMonth) != -1) {
                var monthDig = k + 1;
                monthDig < 10 ? monthDig = '0' + monthDig : monthDig = '' + monthDig;
            }
        }
        var date1 = year + '-' + monthDig + '-' + date[0];
        if (datesComparison(date1) == false) {
            year = addYear(year);
            var date1 = year + '-' + monthDig + '-' + date[0];
        }
        var date2 = year + '-' + monthDig + '-' + date[1];
        if (datesComparison(date2) == false) {
            year = addYear(year);
            var date2 = year + '-' + monthDig + '-' + date[1];
        }
        if (date[1] - date[0] == 1 || date[1] - date[0] == 2) {
            return [date1, false];
        } else {
            return [date1, date2];
        }
};


// операции с сегодняшим числом
function operatingOnToday (numb) {
    var currentDate = new Date();
    currentDate.setDate(currentDate.getDate() + numb);
    var day = currentDate.getDate();
    day = day.toString();
    day = addZero(day);
    var month = currentDate.getMonth() + 1;
    month = month.toString();
    month = addZero(month);
    var year = currentDate.getFullYear();
    return year + '-' + month + '-' + day;
};


// обработка голого числа
function operatingOnNumberDate (numb) {
    numb = addZero(numb);
    var currentDate = new Date();
    var year = currentDate.getFullYear();
    var month = currentDate.getMonth() + 1;
        month = month.toString();
    month = addZero(month);
    var year = currentDate.getFullYear();
    return year + '-' + month + '-' + numb;
};


// проверка, прямой ли рейс
function ifFlightIsDirect (object) {
    var a = object.data[0].segments[0].flights;
    var b = object.data;
    for (var indexA in a) {
        if (a[indexA].stops.length === 0) {
            return [a[indexA],0]
        } else {
            for (var indexB in b) {
                if (b[indexB].segments[0].flights[0].stops.length === 0) {
                    var c = b[indexB].segments[0].flights;
                    for (var indexC in c) {
                        if (c[indexC].stops.length === 0) {
                            return [c[indexC],indexB]
                        }
                    }
                }
            }
        }
    }
};

















































