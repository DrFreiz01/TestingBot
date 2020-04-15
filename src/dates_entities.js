// различные типы шаблонов
var rules = {
    "_DATE_NUMERIC": /\d{1,2}[^\d]{1,1}\d{1,2}[^\d]{0,2}\d{0,4}/,
    "_AFTER_TOMORROW": /после[\w|\s]{0,1}завтра|через день/,
    "_TOMORROW": /(на|в)?(завтра[а-я]*\s?(число|дату|день)?|следующ[а-я]* (число|дату|день))/,
    "_TODAY": /сегодня|сейчас|быстро|немедленно/,
    "_NEAREST": /ближайш[а-я]* (дни|день|дат[у|а|е]|числ[а-я]*|врем[а-я]*)/,
    "_THIS_WEEK": /(эту|этой|эта|ближайш[а-я]*|текущ[а-я]*)\sнедел[а-я]*/,
    "_NEXT_WEEK": /след[а-я]*\s{1,1}недел[а-я]*/,
    "_OVER_WEEK": /через\s{0,1}недел[а-я]{1,2}/,
    "_NEXT_WEEKENDS": /(след[а-я]*|через)\s(выходн[а-я]*|выхи)/,
    "_THIS_WEEKENDS": /(ближайши[ех]|этих|эти|текущи[хе])*\s*(выходны[хе]|выхи)/,
    "_DATE_OF_MONTH": /\d{1,2}(\s|-){0,1}(го|е){0,1}\s{0,1}((январ|феврал|март|апрел|ма|июн|июл|август|сентябр|октябр|ноябр|декабр)[a-я]{0,2}|числ[а|о])/,
    "_LETTERS_MONTH_DATE": /(перво|второ|третье|четверто|пято|шесто|седьмо|восьмо|девято|десято|оди[нн|н]адцато|двенадцато|тринадцато|четырнадцато|пятнадцато|шестнадцато|семнадцато|восемнадцато|девятнадцато|двадцато|двадцать перво|двадцать второ|двадцать третье|двадцать четверто|двадцать пято|двадцать шесто|двадцать седьмо|двадцать восьмо|двадцать девято|тридцато|тридцать перво)(е|го|ое|)\s(числ[о|а]\s?|)((январ|феврал|март|апрел|ма|июн|июл|август|сентябр|октябр|ноябр|декабр)(я|е|а)|)/,
    "_DAY_OF_WEEK": /понедельник[|у|е]|вторник[|у|е]|сред[у|е|а]|четверг[|у|е]|пятниц[а|у|е]|суббот[а|у|е]воскресень[а|у|е]/,
    "_DAYS_RANGE": /(\d{1,2}(\s|-|)(го|е|) (по|до)?\s?\d{1,2}(\s|-|)(го|е|)|\d{1,2}-\d{1,2})(\sчисл[а|о]|)\s{0,1}(январ|феврал|март|апрел|ма|июн|июл|август|сентябр|октябр|ноябр|декабр)?[a-я]{0,2}/,
    "_OVER_DAYS": /через (\d{1,2}|(один|два|три|четыре|пять|шесть|семь|восемь|девять|десять|одиннадцать|двенадцать|тринадцать|четырнадцать)) (дн[я|ей]|день)/
};

var over_days_max = 60;

var days_of_week_regexps = [/воскр/,/понед/,/вторн/,/сред/,/четв/,/пятн/,/суббот|cубот/];
var months_regexps = [/январ/,/феврал/,/март/,/апрел/,/ма/,/июн/,/июл/,/август/,/сентяб/,/октяб/,/нояб/,/декаб/];
var letter_days = [/(перв|один)/,/(втор|два)/,/(трет|три)/,/(четвер|четыре)/,/(пято|пять)/,/(шесто|шесть)/,/(седьмо|семь)/,/(восьмо|восемь)/,/(девято|девять)/,/(десято|десять)/,/(оди[нн|н]адцато|оди[нн|н]адцать)/,/(двенадцато|двенадцать)/,/(тринадцато|тринадцать)/,/(четырнадцато|четырнадцать)/,/пятнадцато/,/шестнадцато/,/семнадцато/,/восемнадцато/,/девятнадцато/,/двадцато/,/двадцать перво/,/двадцать второ/,/двадцать трет/,/двадцать четверто/,/двадцать пято/,/двадцать шесто/,/двадцать седьмо/,/двадцать восьмо/,/двадцать девято/,/тридцато/,/тридцать перво/];

// хотим понять, что именно срабатывает
function get_case(query) {
    try {
        var result = [];
        var matched_case = "";
        var dest_temp = "";
        Object.keys(rules).forEach(function(key) {
            // При отсутствии совпадений возвращается null
            result = query.match(rules[key]) || [];
            if (result.length !== 0) {
                var temp = result[0];
                if (temp.length > dest_temp.length) {
                    dest_temp = temp;
                    matched_case = key;
                }
            }
        });
        return [matched_case, dest_temp];
    } catch (e) {
        return null;
    }
}

// получить сегодняшнюю дату
function get_current_date() {
    var currentDate = new Date();    
    return currentDate;
}

// получить дату со сдвигом days
function get_following_day(days, currentDate) {
    
    var following_day = new Date(
        currentDate.getFullYear(),
        currentDate.getMonth(),
        currentDate.getDate() + days
    );

    return following_day;
}

// получить дату по дню недели без указания числа
function get_day_of_week(day_name) {
    var currentDate = get_current_date();

    // получим индекс текущего дня недели
    var current_day_idx = currentDate.getDay();
    var dest_day_idx = 0;
    var days = 0;

    // получим индекс требуемого дня недели
    for (var i = 0; i < days_of_week_regexps.length; i++) {
        var day_regex = days_of_week_regexps[i];
        if (day_name.match(day_regex)) {
            dest_day_idx = i;
            break;
        }   
    }

    if (current_day_idx < dest_day_idx) {
        days = dest_day_idx - current_day_idx;
    } else {
        days = dest_day_idx + (7 - current_day_idx);
    }
    
    var result = {
        "dates": [get_following_day(days, currentDate)],
        "relevant": true,
        "old": false
    };
    return result;
}

// для строки вида "number month_name/числа" получить дату
// 5е мая, 10го февраля, 4 июня, 15 числа 
function get_date_of_month(entity) {

    var currentDate = get_current_date();
    var dest_day_idx = get_day_index(entity);
    var dest_month_idx = get_month_index(entity);

    if (dest_month_idx === null) {
        dest_month_idx = currentDate.getMonth();
    }

    var destDate = new Date(currentDate.getFullYear(), dest_month_idx, dest_day_idx);

    var result = {
        "dates": [destDate],
        "relevant": check_date_relevance(dest_day_idx, dest_month_idx),
        "old": (destDate < currentDate)
    };
    return result;
}

// возвращаем диапазон дат ближайших выходных
// если сейчас суббота то возвращаем диапазон (сегодня, завтра), если воскресенье - то следующие выходные
function get_this_weekends() {
    var thisWeekendsStart = get_current_date();
    thisWeekendsStart.setDate(thisWeekendsStart.getDate() + (6 - thisWeekendsStart.getDay()));

    var thisWeekendsEnd = get_following_day(1, thisWeekendsStart);
    
    var result = {
        "dates": [thisWeekendsStart, thisWeekendsEnd],
        "relevant": true,
        "old": false
    };
    return result;
}

// возвращаем диапазон дат следующих выходных
function get_next_weekends() {
    var nextWeekendsStart= get_current_date();
    nextWeekendsStart.setDate(nextWeekendsStart.getDate() + (7 + 6 - nextWeekendsStart.getDay()));

    var nextWeekendsEnd = get_following_day(1, nextWeekendsStart);

    var result = {
        "dates": [nextWeekendsStart, nextWeekendsEnd],
        "relevant": true,
        "old": false
    };
    return result;
}

// возвращаем дату для числового представления
function get_date_numeric(entity) {
    var currentDate = get_current_date();
    var splits = entity.split(/[^\d]/);

    var year = currentDate.getFullYear();
    var month = parseInt(splits[1], 10) - 1;
    var day = parseInt(splits[0], 10);

    if (splits.length == 3) {
        year = splits[2];
        if (year.length != 4) {
            year = "20" + year;
        }
        year = parseInt(year, 10);
    } 
    var destDate = new Date(year, month, day);

    var result = {
        "dates": [destDate],
        "relevant": check_date_relevance(day, month),
        "old": (destDate < currentDate)
    };
    return result;
}

// возвращаем диапазон дат от завтрашнего дня до конца недели включительно
function get_this_week() {
    var currentDate = get_current_date();

    // начинаем с завтрашнего дня 
    var startDate = new Date(currentDate.setDate(currentDate.getDate() + 1));

    // // ищем ближайшее воскресенье
    var endWeek = new Date(currentDate.setDate(startDate.getDate() + (7 - startDate.getDay()))); 

    var result = {
        "dates": get_dates_range(startDate, endWeek),
        "relevant": true,
        "old": false
    };
    return result;
}

// возвращаем диапазон дат от следующего понедельника до следующего воскресенья включительно
function get_next_week() {
    var nextMonday = get_current_date();
    nextMonday.setDate(nextMonday.getDate() + (1 + 7 - nextMonday.getDay()) % 7);
    var nextSunday = get_following_day(6, nextMonday);

    var result = {
        "dates": get_dates_range(nextMonday, nextSunday),
        "relevant": true,
        "old": false
    };
    return result;
}

// возвращаем диапазон дат от дня через неделю до дня через две недели включительно
function get_over_week() {
    var currentDate = get_current_date();
    var overWeekStart = get_following_day(7, currentDate);
    var overWeekEnd = get_following_day(13, currentDate);

    var result = {
        "dates": get_dates_range(overWeekStart, overWeekEnd),
        "relevant": true,
        "old": false
    };
    return result;
}

// Получаем список дат для месяца
function get_month(month_name) {
    // индекс требуемого месяца
    var dest_month_idx = get_month_index(month_name) || 0;

    var currentDate = get_current_date();
    var firstDayOfMonth = new Date(currentDate.getFullYear(), dest_month_idx, 1);

    var lastDayOfMonth = new Date(firstDayOfMonth.getFullYear(), firstDayOfMonth.getMonth() + 1, 0);

    var result = {
        "dates": get_dates_range(firstDayOfMonth, lastDayOfMonth),
        "relevant": true,
        "old": false
    };
    return result;
}

// Получаем дату для письменного числа в конкретном месяце. Пример: двадцать пятое [число] [марта]
function get_letters_month_date(letters_month_day) {
    var currentDate = get_current_date();

    // индекс требуемого дня
    var dest_day_idx = get_day_index(letters_month_day) || 1;

    // извлекаем из строки месяц, если не можем, то берем текущий месяц
    var dest_month_idx = get_month_index(letters_month_day) || currentDate.getMonth();

    var destDate = new Date(currentDate.getFullYear(), dest_month_idx, dest_day_idx);

    var result = {
        "dates": [destDate],
        "relevant": true,
        "old": (destDate < currentDate)
    };
    return result;
}

// Получить даты в диапазоне 
function get_range_numeric(entity) {
    var currentDate = get_current_date();
    
    var splits = entity.split(/[^\d]/);
    var filtered = [];
    for (var index = 0; index < splits.length; index++) {
        var element = splits[index];
        if (element.length > 0){
            filtered.push(element);
        }
    }
    var start_day_idx = parseInt(filtered[0], 10);
    var end_day_idx = parseInt(filtered[1], 10);

    // если есть упоминание месяца в строке то получаем индекс месяца, если нет, то берем текущий
    var dest_month_idx = get_month_index(entity) || currentDate.getMonth();

    var startRange = new Date(currentDate.getFullYear(), dest_month_idx, start_day_idx);
    var endRange = new Date(currentDate.getFullYear(), dest_month_idx, end_day_idx);

    var result = {
        "dates": get_dates_range(startRange, endRange),
        // проверяем что оба конца диапазона релевантны (проверка внетри определенного месяца - dest_month_idx)
        "relevant": (check_date_relevance(start_day_idx, dest_month_idx) && check_date_relevance(end_day_idx, dest_month_idx)),
        "old": (endRange < currentDate)  // если конец диапазона раньше текущей даты
     };
    return result;
}

// получить дату через заданное или числом или словами кол-во дней 
function get_over_days(entity) {
    // получить индекс из слов
    var days = get_day_index(entity);
    var destDate = get_following_day(days + 1, get_current_date());

    var result = {
        "dates": [destDate],
        "relevant": (days < over_days_max), // если слишком большой прыдок по дням, то дата нерелевантна
        "old": false
    };
    return result;
}

///////////// Utils  ///////////////

// проверить индексы месяца и дня на релевантность 
function check_date_relevance(day_idx, month_idx) {
    var test_date = get_current_date();
    test_date.setMonth(month_idx);
    // если после установки даты месяц "перепрыгнет", то сичтаем даты нерелевантной для этого месяца
    test_date.setDate(day_idx);
    return test_date.getMonth() === month_idx;
}

// получить из строки индекс дня или кол-во дней для сдвига (нумерация с 1) или null
function get_day_index(str) {
    // индекс требуемого дня
    var dest_day_idx = null;
    var dest_temp = "";

    // получим индекс требуемого дня
    for (var i = 0; i < letter_days.length; i++) {
        var letter_day_regex = letter_days[i];
        var result = str.match(letter_day_regex) || [];
        if (result.length !== 0) {
            var temp = result[0];
            if (temp.length > dest_temp.length) {
                dest_temp = temp;
                dest_day_idx = i + 1; // нумерация с 1
            }
        }      
    }

    // если есть числовое предствление то выдаем его
    var result = str.match(/\d{1,2}/g);
    if (result) {
        dest_day_idx = parseInt(result[0], 10);
    };
    return dest_day_idx;
}

// Получить индекс месяца (нумерация с 0) или null
function get_month_index(str) {
    var dest_month_idx = null;
    var dest_temp = "";

    // получим индекс требуемого месяца
    for (var i = 0; i < months_regexps.length; i++) {
        var month_regex = months_regexps[i];
        var result = str.match(month_regex) || [];
        if (result.length !== 0) {
            var temp = result[0];
            if (temp.length > dest_temp.length) {
                dest_temp = temp;
                dest_month_idx = i;
            }
        }      
    }
    return dest_month_idx;
}

// форматируем дату под формат YYYY-MM-DD
function formatDate(date) {
    var month = '' + (date.getMonth() + 1);
    var day = '' + date.getDate();
    var year = date.getFullYear();

    if (month.length < 2) {
        month = '0' + month;
    } 
    if (day.length < 2) {
        day = '0' + day;
    }
    
    var arr = [];
    arr.push(year);
    arr.push(month);
    arr.push(day);
    
    return arr.join('-');
}

// возвращаем список дат между начальной (включая) и конечной (не включая) датами 
function get_dates_range(startDate, stopDate) {

    var dateArray = [];
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateArray.push(new Date (currentDate));
        currentDate = get_following_day(1, currentDate);
    }
    return dateArray;
}

// удалить из строки все цифры
function remove_all_digits(s) {
    return s.replace(/\d+/, '');
}

// оставить в строке только цифры
function remove_all_letters(s) {
    return s.replace(/[^\d]+/, '');
}

// добавить пробелы между числами и текстом, убрать лишние пробелы
function normalize_spaces(rawStr) {
    var normedStr = "";
    for (var index = 0; index < rawStr.length; index++) {
        var curLetter = rawStr.substring(index, index + 1);

        var nextLetter = "";
        if (index + 1 < rawStr.length) {
            nextLetter = rawStr.substring(index + 1, index + 2);
        }
        normedStr += curLetter;
        if ((/\d+/.test(curLetter) && /[а-я]+/.test(nextLetter)) || 
            (/[а-я]+/.test(curLetter) && /\d+/.test(nextLetter))) {
            normedStr += " ";
        }
    }
    return normedStr.replace(/\s\s+/g, ' ');;
}

// учитывая тип шаблона формируем нужную дату
function get_date(matched_case, entity, query) {
    // по дефолту возвращаем текущую дату
    try {
        var destDates = {
            "dates": [],
            "relevant": true,
            "old": false
        };
        var currentDate = get_current_date();
        
        switch(matched_case) {
            case "_TODAY":
                destDates = {
                    "dates": [currentDate],
                    "relevant": true,
                    "old": false
                };
                break;
            case "_TOMORROW":
                destDates = {
                    "dates": [get_following_day(1, currentDate)],
                    "relevant": true,
                    "old": false
                };
                break;
            case "_AFTER_TOMORROW":
                destDates = {
                    "dates": [get_following_day(2, currentDate)],
                    "relevant": true,
                    "old": false
                };
                break;
            case "_DAY_OF_WEEK":
                destDates = get_day_of_week(entity);
                break;
            case "_DATE_OF_MONTH":
                destDates = get_date_of_month(entity);
                break;
            case "_THIS_WEEKENDS":
                destDates = get_this_weekends();
                break;
            case "_NEXT_WEEKENDS":
                destDates = get_next_weekends();
                break;
            case "_DATE_NUMERIC":
                destDates = get_date_numeric(entity);
                break;
            case "_THIS_WEEK":
                destDates = get_this_week();
                break;
            case "_NEXT_WEEK":
                destDates = get_next_week();
                break;
            case "_OVER_WEEK":
                destDates = get_over_week();
                break;
            case "_MONTH":
                destDates = get_month(entity);
                break;
            case "_LETTERS_MONTH_DATE":
                destDates = get_letters_month_date(entity);
                break;
            case "_DAYS_RANGE":
                destDates = get_range_numeric(entity);
                break;
            case "_OVER_DAYS":
                destDates = get_over_days(entity);
                break;
            case "_NEAREST":
                destDates = {
                    "dates": [
                        get_following_day(1, currentDate), 
                        get_following_day(2, currentDate),
                        get_following_day(3, currentDate)
                    ],
                    "relevant": true,
                    "old": false
                };
                break;
            default:
                destDates["dates"].push(get_current_date());
        }

        for (var index = 0; index < destDates["dates"].length; index++) {
            destDates["dates"][index] = formatDate(destDates["dates"][index]);
        }
        return destDates;
    } catch (e) {
        return null;
    }
}

// главная функция-обработчик запроса
function handle_request(query) {
    try {
        query = query.toLowerCase();
        query = normalize_spaces(query);
        var res = get_case(query);
        var matched_case = res[0];
        var entity = res[1];

        return get_date(matched_case, entity, query);
    } catch(e) {
        return null;
    }
}
