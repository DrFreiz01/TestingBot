function getcity() {
    var $parseTree = $jsapi.context().parseTree;
    var $session = $jsapi.context().session;
    $session.ptrnCity = $parseTree._ptrnCity.name;
}

//Функция для таймаута ответа бота в милисекундах, со значением по умолчанию в 1500 миллисекунд
function sleep(milliseconds) { 
    milliseconds = typeof milliseconds !== "undefined" ? milliseconds : "1500";
    var timeStart = new Date().getTime(); 
    while (true) { 
        var elapsedTime = new Date().getTime() - timeStart; 
        if (elapsedTime > milliseconds) { 
            break; 
        } 
    } 
}

//Функция универсальная для запроса на веб-сервис, запускается в сценарии по скрипту var $httpResponse = getStatus();
//перед запуском требует в сценарии определения переменных $session.wsUrl, $session.wsBody, $session.wsTransGood, $session.wsTransBad
function getStatus() {
    var $session = $jsapi.context().session;
    var url = $session.wsUrl;
    var options = {
        dataType: "json",
        method: $session.wsMethod,
        headers: {},
        body: $session.wsBody
    };
    var result = $http.post(url, options);
    if (result.isOk && result.status >= 200 && result.status < 300) {
        return result.data;
    } else {
        $reactions.transition($session.wsTransBad);
    }
}

//Функция перебора элементов в массиве объектов (myArray) для поиска позиции объекта с известным именем (property) и значением (searchTerm)
function arrayObjectIndexOf(myArray, property, searchTerm) {
    for(var i = 0, len = myArray.length; i < len; i++) {
        if (myArray[i][property] === searchTerm) 
            return i;
    }
    return -1;
}

//Функция подсчета и сортировки повторяющихся элементов в строке "str", разбиваемой в массив символом "/"
function strSortNCount(str) {
    str = typeof str !== "undefined" ? str : "/";                   //на случай ошибки (TypeError: Cannot read property "split" from undefined)
    var arr = str.split("/");                                       //делим строку, содержащую полный путь стейта по разделителю в кавычках
    for (var len = arr.length, i = len; --i >= 0;) {                //объединяем повторяющиеся элементы массива и считаем их частотность
      if (arr[arr[i]]) {
        arr[arr[i]] += 1;
        arr.splice(i, 1);
      } else {
        arr[arr[i]] = 1;
      }
    }
    arr.sort(function(a, b) {                                       //сортируем элементы массива по убыванию их частотности
      return arr[b] - arr[a];
    });                                                             //задаем массив с элементами, по которым будет фильтрация
    var toRemove = ["ИОБ","ИКО","ИТО","ИУО","ИУД","ИУС","ИУК","ЛОБ","ЛКБ","ЗОБ","ЗСТ","ЗСГ","ЗИМ","СОБ","СНА","СКО","ПОБ","КОБ","КВЫ","КНА","КНЕ","МОБ","МБО","МНД","МНЦ","МТТ"];
    arr = arr.filter(function(x) {                                  //оставляем в массиве только те элементы, которые перечислены в массиве toRemove
        return toRemove.indexOf(x) !== -1;                           
    });
//    var stringResult = JSON.stringify(arr, function(k, v) {       //выводим названия стейтов и их частотность с переносом на следующую строку
//      if (k === '') return v;
//      return `${arr[v]} - ${v}`;
//    },1);
    var stringResult = arr.join(", ");                              //выводим названия стейтов в виде строки без переноса на следующую строку
    return stringResult;
}

