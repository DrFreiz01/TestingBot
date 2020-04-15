// проверка числа направлений в запросе (1 направление. туда-обратно, больше 1 направления)
function check_directions_count(entities, locationsArray) {
    var loctoCount = 0;
    var locfromCount = 0;
    var loctoArray = [];
    var locfromArray = [];
    var roundTrip = 0;
    var multiDirection = 0;
    
    var entitiesLength = 0;
    var locationsCount = 0;
    if (entities) entitiesLength = entities.length;
    if (locationsArray) locationsCount = locationsArray.length;

    for (var i = 0; i < entitiesLength; i++) {
        if (entities[i]["pattern"] == "LocationTo") {
            loctoCount++;
            loctoArray.push(entities[i]["value"]);
            }
        else if (entities[i]["pattern"] == "LocationFrom") {
            locfromCount++;
            locfromArray.push(entities[i]["value"]);
            }
        else if (entities[i]["pattern"] == "RoundTripWords") {
            roundTrip = 1;
        }
    }
    
    if (locationsCount > 2) {
        if (locationsCount == 3 && locationsArray[0].stations_codes == locationsArray[2].stations_codes) {
            roundTrip = 1;
            }
        else if (locationsCount == 4 && locationsArray[0].stations_codes == locationsArray[3].stations_codes
        && locationsArray[1].stations_codes == locationsArray[2].stations_codes) {
            roundTrip = 1;
            }
        else multiDirection = 1;
    }
    
    if ((loctoCount > 1 || locfromCount > 1) && (roundTrip === 0)) {
        multiDirection = 1;
    }
    
    return {
        multiDirection: multiDirection,
        roundTrip: roundTrip
    }
}

// проверка на новый запрос в переспросе
function check_new_query(entities) {
    var entitiesLength = 0;
    var locationsCount = 0;
    var locfromCount = 0;
    var loctoCount = 0;
    var locationsArray = [];
    var loctoArray = [];
    var locfromArray = [];
    
    var newQuery = 0;
    
    
    if (entities) entitiesLength = entities.length;
    
    for (var i = 0; i < entitiesLength; i++) {
        if (entities[i]["pattern"] == "LocationTo") {
            loctoCount++;
            loctoArray.push(entities[i]["value"]);
            }
        else if (entities[i]["pattern"] == "LocationFrom") {
            locfromCount++;
            locfromArray.push(entities[i]["value"]);
            }
        else if (entities[i]["pattern"] == "LocationNewDictionary") {
            locationsCount ++;
            locationsArray.push(entities[i]["value"]);
        }
    }
    
    if (locationsCount > 1) {
        newQuery = 1;
    }
    
    if (locfromCount + loctoCount > 1) {
        locationsArray = locfromArray.concat(loctoArray);
        newQuery = 1;
    }
    
    return newQuery;
}

function get_location_options(location) {
    var locNameOptions;
    var locNumberOptions;
    var locSuggestOptions;
    var chooseOptions = 0;
    
    if (location.number === "") {
        if (location.all_stations_from_same_city === 0) {
            chooseOptions = 1;
            locNameOptions = location.stations_names.split(",");
            locSuggestOptions = location.stations_suggests.split(",");
            locNumberOptions = location.stations_codes.split(",");
        }
        else {
            location.number = location.stations_codes;
        }
    }
    
    return {
        chooseOptions: chooseOptions,
        locNameOptions: locNameOptions,
        locSuggestOptions: locSuggestOptions,
        locNumberOptions: locNumberOptions
    }
}

function process_results(result, filters) {
    var min_price = -1;
    var date_result;
    var date_trains_count = 0;
    
    var train;
    var train_categories;
    var train_categories_count;
    var category;
    
    var filtered_result = {};
    var count_trains = 0;
    
    var train_features = ["number","departureStationCode","arrivalStationCode","departureTime","url"];

    for (var date in result) {
        date_result = result[date];
        date_trains_count = date_result.length;

        for (var i = 0; i < date_trains_count; i++) {
            train = date_result[i];
            var isTrainRelevant = 0;
            
            if (filters["min_time"] && filters["max_time"]) {
                if (filters["min_time"] < filters["max_time"]) {
                    if (train["departureTime"] < filters["min_time"] || train["departureTime"] > filters["max_time"]) {
                        continue;
                    }
                }
                else if (filters["min_time"] > filters["max_time"]) {
                    if (train["departureTime"] < filters["min_time"] && train["departureTime"] > filters["max_time"]) {
                        continue;
                    }
                }
            }
            
            train_categories = train["categories"];
            train_categories_count = train_categories.length;
            
            for (var j=0; j < train_categories_count; j++) {
                category = train_categories[j];
                
                if (filters["class"]) {
                    if (!isInArray(category["type"], filters["class"])) continue;
                }
                
                if (!isTrainRelevant) isTrainRelevant = 1;
                
                if (min_price < 0 && category["price"] > 0 && category["count"] > 0) {
                    min_price = category["price"];
                    filtered_result = addElements(train, category, train_features);
                }
                else if (min_price > 0 && category["price"] < min_price && category["count"] > 0)  {
                    min_price = category["price"];
                    filtered_result = addElements(train, category, train_features);
                }
            }
            count_trains += isTrainRelevant;
        }
        
        if (min_price > 0) {
            filtered_result["date"] = date;
            if (count_trains > 1) {
                filtered_result["url"] = generateTimetableURL(filtered_result["departureStationCode"], filtered_result["arrivalStationCode"], filtered_result["date"]); 
            }
            return filtered_result;
        }
    }

    return {};
}

function isInArray(value, array) {
  return array.indexOf(value) > -1;
}

function addElements(dictFrom, dictTo, array) {
    var res = dictTo;
    var array_len = array.length;
    var element;
    
    for (var i=0; i<array_len; i++) {
        element = array[i];
        res[element] = dictFrom[element];
    }
    return res;
}

