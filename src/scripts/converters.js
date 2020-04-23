$global.$converters = $global.$converters || {};
var cnv = $global.$converters;

cnv.datesConv = function(parseTree) {
    var date = parseTree.datesLib[0].value;
    return $datesLib[date].value;
};

cnv.cityCodeConv = function(parseTree) {
    var code = parseTree.cityCodeLib[0].value;
    return $cityCodeLib[code].value;
};

cnv.rusNamesConverter = function(parseTree) {
    var id = parseTree.libJustNames[0].value;
    return $libJustNames[id].value;
};

cnv.railwayCodeConv = function(parseTree) {
    var code = parseTree.railrayCodeLib[0].value;
    return $railrayCodeLib[code].value;
};

cnv.numberConverterValue = function(parseTree) {
    return parseTree.value;
};

cnv.cityAllConv = function(parseTree) {
    var code = parseTree.IataRailwayLib[0].value;
    return $IataRailwayLib[code].value;
}