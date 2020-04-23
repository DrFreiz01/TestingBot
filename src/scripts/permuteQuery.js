var queries = [
'q!: * $iataAndRailway $iataAndRailway ($dateDig/$dateLetters/$numberDate) * {$return ([$buyVerbPast] ($ticket/$airplaneTicket))} * $orderNumber *'
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
        if (query.match(/^q!:.+/)) {
          var strBeginning = 'q!: ';
          query = query.replace(/^q!:(.+)/, '$1');
        }
        if (query.match(/( \* | \*|[^А-Яа-я]\* )([^\1]*?( \* | \*|[^А-Яа-я]\* ))+/)) {
            //каждый паттерн в строке
            var pattern = query.split(/ \* |\* | \*/);
            for (var i = 0; i < pattern.length; i++) {
                if (pattern[i].length == 0) {
                    pattern.splice(i,1);
                }
            }
            tempRes = permutator(pattern);
            for (var j = 0; j<tempRes.length;j++) {
                tempRes[j] = tempRes[j].join(' * ');
                tempRes[j] = '* ' + tempRes[j] + ' *';
                if (strBeginning) {
                  tempRes[j] = strBeginning + tempRes[j];
                }
            }
            res = [...tempRes];
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
