#!/bin/bash

echo "======[ ПАКЕТНОЕ ТЕСТИРОВАНИЕ ]======"

FILE=""
# DEV (default)
BOT_TOKEN="a8002655-f982-434d-b6f2-73b8c585e010"
BOT_URL="https://zenbot-dev.just-ai.com/chatadapter/chatapi/"
ZB_URL="https://213.87.4.186"
TIMEOUT=3
verbose=false
branch="dev"
OUTPUT_FILE=false

globalURL=false
varsQuery="testvars"
SEP=';'

# Перебор параметров для вычленения нужного
while [ -n "$1" ]
do
    case "$1" in
        --file)
            FILE="$2";;
        --timeout)
            TIMEOUT="$2";;
        --verbose | -v)
            verbose=true;;
        --branch)
            if [ $2 = "pre-master" ] ; then
                BOT_TOKEN="89423fd8-8f75-47f1-9a5e-cfac1f0fe5ca"
                BOT_URL=$ZB_URL"/chatapi/"
                branch=$2
            elif [ $2 = "master" ] ; then
                BOT_TOKEN="c7e1e3f3-f503-4028-a4ef-7526049d0880"
                BOT_URL=$ZB_URL"/chatapi/"
                branch=$2
            fi;;
        --testing)
            SEP='|';;
        --url)
            URL=$2
            globalURL=true;;
        --vars-query)
            # Длина строки > 0
            if [ -n $2 ] ; then
                varsQuery=$2
            fi;;
        # Модфикация входного параметра для тестирования
        --output_file)
            if [ -n $2 ] ; then
                OUTPUT_FILE=$2
            fi;;
    esac
        shift
done

# Если указан глоб.урл тогда НЕ используем компоновку из данных
if [ "$globalURL" = false ] ; then
    URL=$BOT_URL$BOT_TOKEN
fi

# проверка существования
if [ -z $FILE ]
    then
        echo "INFO: опущен параметр --file"
        exit
fi

# проверка не директория ли указана в параметре
if [ -d $FILE ]
    then
        echo "INFO: $FILE является директорией!"
        exit
fi

perl -pi -e 's/\r/\n/g' $FILE

SESSION_NAME=${FILE%.*}
RESPONSE_FILE="$SESSION_NAME-$branch.csv"

# Если присутствует глобальный урл - убираем ветку из имени рез.файла
if [ "$globalURL" = true ] ; then
    RESPONSE_FILE="$SESSION_NAME.csv"
fi

# Если присутствует имя выходного файла
# перенаправим вывод скрипта в него
# НЕ пересоздавая
if [ "$OUTPUT_FILE" != false ] ; then
    RESPONSE_FILE=$OUTPUT_FILE
fi


if [ "$verbose" = true ] ; then

    if [ "$globalURL" = false ] ; then
        echo "[DEBUG]: BOT_TOKEN     = $BOT_TOKEN"
        echo "[DEBUG]: BOT_URL       = $BOT_URL"
    fi
    echo "[DEBUG]: URL           = $URL"
    echo "[DEBUG]: FILE          = $FILE"
    echo "[DEBUG]: SESSION_NAME  = $SESSION_NAME"
    echo "[DEBUG]: RESPONSE_FILE = $RESPONSE_FILE"
fi


REQUEST=""

# Если выходной файл не переопределен,
# создаем файл, и записываем в него заголовок
if [ "$OUTPUT_FILE" = false ] ; then
    > $RESPONSE_FILE
    echo "'Запрос'$SEP'Ответ'$SEP'Стейт входа'$SEP'Стейт выхода'$SEP'Переменные'" >> $RESPONSE_FILE
fi

# Генерация JSON'a
generate_post_data()
{
    cat <<EOF
    {
        "clientId": "$SESSION_NAME",
        "query": "$request_string"
    }
EOF
}


# Обход файла
cat $FILE | while read request_string || [ -n "$request_string" ]
    do
        echo "==> Отправка запроса: $request_string"

        # Сохраняем оригинальный запрос
        ORIGINAL_QUERY=$request_string

        RESPONSE=$(
            curl -s -k \
                -H "Content-Type: application/json" \
                -X POST --data "$(generate_post_data)" \
                $URL
        )

        # echo "[DEBUG]: ORIGINAL_QUERY = $ORIGINAL_QUERY"

        if [ "$verbose" = true ] ; then
            echo "[DEBUG]: CURL     = curl -s -H \"Content-Type: application/json\" -X POST --data '$(generate_post_data)' $URL"
        fi

        echo "<== Компоновка ответа"
        export PYTHONIOENCODING=utf8
        PARSING_RESPONSE=`echo $RESPONSE | python -c "import sys, json; print (json.load(sys.stdin)['data']['answer'])"`
        PARSING_RESPONSE=`echo $PARSING_RESPONSE | sed -e "s/\\n//g; s/'//g"`
        PARSING_ENTER_STATE=`echo $RESPONSE | python -c "import sys, json; print (json.load(sys.stdin)['data']['replies'][0]['state'])"`
        PARSING_FINAL_STATE=`echo $RESPONSE | python -c "import sys, json; print (json.load(sys.stdin)['data']['replies'][-1]['state'])"`

        # ОБХОД объекта для вытаскивания кнопок
        BUTTONS=`node <<EOF
var resp = $RESPONSE["data"];
var buttonsJS = "";
for (var key in resp){
    for (var keyArray in resp[key]){

        if ( resp[key][keyArray]["type"] == "buttons" )
            buttonsJS += "["+ resp[key][keyArray]["buttons"][0]["text"] +"] ";

    }
}
console.log(" "+ buttonsJS);
EOF`

        # конкатенация с исходным ответом
        PARSING_RESPONSE=$PARSING_RESPONSE$BUTTONS

        if [ "$verbose" = true ] ; then
            echo "[DEBUG]: RESPONSE               = $RESPONSE"
            echo "[DEBUG]: PARSING_RESPONSE       = $PARSING_RESPONSE"
            echo "[DEBUG]: PARSING_ENTER_STATE    = $PARSING_ENTER_STATE"
            echo "[DEBUG]: PARSING_FINAL_STATE    = $PARSING_FINAL_STATE"
        fi

        # Отправка спец-запроса на переменные
        RESPONSE_VARS=""
        if [ -n $varsQuery ] ; then
            request_string=$varsQuery
            RESPONSE_VARS=$(
                curl -s -k \
                    -H "Content-Type: application/json" \
                    -X POST --data "$(generate_post_data)" \
                    $URL
            )

            export PYTHONIOENCODING=utf8
            PARSING_RESPONSE_VARS=`echo $RESPONSE_VARS | python -c "import sys, json; print (json.load(sys.stdin)['data']['answer'])"`
            PARSING_RESPONSE_VARS=`echo $PARSING_RESPONSE_VARS | sed -e "s/\\n//g; s/'//g"`


        fi

        echo "<== Ответ скомпонован"
        echo ""

        # Запись в результирующий файл
        echo "'$ORIGINAL_QUERY'$SEP'$PARSING_RESPONSE'$SEP'$PARSING_ENTER_STATE'$SEP'$PARSING_FINAL_STATE'$SEP'$PARSING_RESPONSE_VARS'" >> $RESPONSE_FILE

        sleep $TIMEOUT
done


echo "======[ ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ]======"
