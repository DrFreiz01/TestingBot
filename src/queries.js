function getTicketsResult(fromCode, toCode, date) {
    var url = "http://tutu.ddecisions.ai";
    var options = {
        timeout: 15000,
        form: {
            "from": fromCode,
            "to": toCode,
            "dates": date.join(',')
            }
        };
    
    var result =  $http.post(url, options);
    return result.isOk ? result.data : false;
}

function generateTimetableURL(fromCode, toCode, date) {
    var url = "https://www.tutu.ru/poezda/rasp_d.php?nnst1=" + fromCode + "&nnst2=" + toCode + "&date=" + date;
    return shortURL(url);
}


function shortURL(url) {
    var shortener_url = 'https://www.tutu.ru/short_url_generator/?with_cc_labels=1';
    
    try {
        var res = $http.post( shortener_url, { form: { url: encodeURIComponent(url) } } );
        if( res.isOk ) {
            return res.data.short_url || url;
        }
    }
    catch(e) {
        return url;
    }
}
