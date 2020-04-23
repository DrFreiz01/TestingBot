//МИКРО-ФУНКЦИИ

// отслеживаем начало и конец сессии
function stopSession() {
    return $jsapi.stopSession();
}

function startSession() {
    return $jsapi.startSession();
}

// ищем последний элемент массива
function getLastElInArray (array) {
    var counter = [];
    for (var el in array) {
        counter.push(el);
    }
    return counter.length - 1;
}

// получаем минимальное значение массива
function getMinValue (array) {
    var min = array[0];
    for (var i = 0; i < array.length; i++) {
        if (min > array[i]) min = array[i];
    }
    return min;
}

// формат месяца
function addZero (date) {
    if (date.length == 1) {
        date = "0" + date;
    }
    return date;
}

// парсинг возраста
function ageParsing (numb) {
    numb = parseInt(numb);
    if (numb < 2) {
        return 'todler'
    }
    else if ((numb >= 2) && (numb < 12)) {
        return 'child';
    }
    else {
        return 'adult';
    }
}

// абсолютное значение
function absVal(integer) {
  return integer < 0 ? -integer : integer;
}

// год + 1
function addYear(numb) {
    numb = numb + 1;
    return numb;
}