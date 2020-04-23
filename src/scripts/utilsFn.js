///////////////////////////////
// УТИЛИТАРНЫЕ МИКРО-функции //
///////////////////////////////

/**
 * Добавление возможности использовать гиппперссылок в ответах бота
 * @param  {[type]} mode    [description]
 * @param  {[type]} message [description]
 * @return {[type]}         [description]
 */
function answerCustomMode(mode, message) {
    var $response = $jsapi.context().response;
    $reactions.answer(message);

    if (mode != "") {
        $response.replies[$response.replies.length - 1].markup = mode;
    }
}



/**
 * channelTypes - функция для ответов со ссылками в зависимости от канала связи
 *
 * CHANGED: определение глобального request ВНУТРИ функции
 * @param  {String} URL-ссылка или ссылка на файл _hardData.mtsServiceInfo
 * @param  {String} text, который должен стоять перед ссылкой
 * @param  {String} URLtext, текст ссылки
 * @param  {String} textAfterURL, текст после ссылки (при необходимости)
 * @return void
 * На выход мы получаем реакцию для одного из каналов.
 */
function channelTypes(URL, text, URLtext, textAfterURL) {
    var _fnName = 'channelTypes',
        request  = $jsapi.context().request;

    if (!URL) {
        $reactions.answer("[JS-ERROR] " + _fnName + ": не указаны обязательные параметры");
        return false;
    }

    text         = (!text) ? "" : text;
    URLtext      = (!URLtext) ? "" : URLtext;
    textAfterURL = (!textAfterURL) ? "" : textAfterURL;

    var template = '<a href="{{URL}}" target="_blank">{{URLtext}}</a>',
        answer   = text + "{{template}}" + textAfterURL;

    // <u> не выводится в telegram
    switch (request.channelType) {
        case 'telegram':
        case 'chatwidget':
            answer = answer.replace(/{{template}}/g, template);
            answer = answer.replace(/{{URL}}/g, URL);
            answer = answer.replace(/{{URLtext}}/g, URLtext);

            if (request.channelType == "telegram") {
                answerCustomMode("html", answer);
            } else {
                $reactions.answer(answer);
            }
        break;

        default:
            answer = answer.replace(/{{template}}/g, URLtext + ": " + URL);
            if (request.channelType != "chatapi")
                answer = answer.replace(/<\/?[i|b]>/g, "");
            if (request.channelType == "chatapi" && answer.endsWith('.'))
                answer = answer.replace(/\.$/, "");
            $reactions.answer(answer);
        break;
    }
}



/**
 * Проверка любого массива на пустоту
 *
 * @param  {obj}     array Массив для проверки
 * @return {Boolean}     True (пустой) / false (не пустой)
 */
function isArrayEmpty(array) {
  return !Array.isArray(array) || !array.length
}