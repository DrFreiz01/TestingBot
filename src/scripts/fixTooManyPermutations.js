var queries = [
'q!: * {$from [$cityPreName] $iataAndRailway::fromCode * [$withBaggage] * $forAdults * ([на] ($dateDig/$dateLetters/$thatDay))} [$cityPreName] $iataAndRailway::destCode *'
];
function permutator(inputArr) {
  var results = [];

  function permute(arr, memo) {
    var cur, memo = memo || [];

    for (var i = 0; i < arr.length; i++) {
      cur = arr.splice(i, 1);
      if (arr.length === 0) {
        results.push(memo.concat(cur));
      }
      permute(arr.slice(), memo.concat(cur));
      arr.splice(i, 0, cur[0]);
    }

    return results;
  }

  return permute(inputArr);
}
var permuteQueries = function(queries) {
    var res = [];
    //итерируемся по строкам
    for (var h = 0; h < queries.length; h++) {
        var tempRes = [];
        //каждая строка
        var query = queries[h];
        if (query.match(/.*{[^}]+ \* [^}]+ \* [^}]+ \* [^}]+}.*/)) {
            var permutChank = query.replace(/.*{([^}]+ \* [^}]+ \* [^}]+ \* [^}]+)}.*/, "$1");
            var beforeChank = query.replace(/(.*){[^}]+ \* [^}]+ \* [^}]+ \* [^}]+}(.*)/, "$1");
            var afterChank = query.replace(/(.*){[^}]+ \* [^}]+ \* [^}]+ \* [^}]+}(.*)/, "$2");
            if (permutChank.includes('((') || permutChank.includes('))')) {
                if (permutChank.includes('((')) {
                  permutChank = permutChank.replace(/(.*?\()\((.*?\))(.*?)\)(.*)/, '$1$2$3$4');
                } else {
                  permutChank = permutChank.replace(/\((.*?\(.*?\))\)(.*)/, '$1$2');
                }
            }
            //каждый паттерн в строке
            var pattern = permutChank.split(/ \* |\* | \*/);
            tempRes = permutator(pattern);
            for (i=0;i<tempRes.length;i++) {
                tempRes[i] = beforeChank + tempRes[i].join(' * ') + afterChank;
            }
            res.push(...tempRes);
        } else {
          res.push(query);
        }
    }
    var unique = new Set(res);
    res =  Array.from(unique);
    res = res.join('\n');
    return res;
};
console.log(permuteQueries(queries));