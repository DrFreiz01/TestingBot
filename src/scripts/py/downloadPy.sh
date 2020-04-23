#!/bin/bash

#chmod a+x ./downloadPy.sh

set -euo pipefail
IFS=$'\n\t'

echo "======[ Начинаем установку необходимых инструментов ]======"

EXIST=false

if [ -n $(which brew) ]
then
    #EXIST=true

    brew list python3 &>/dev/null || brew install python3
    pip3 install pymorphy2
    pip3 install -U pymorphy2-dicts-ru

    echo "======[ Установка завершена ]======"
elif [ -n $(which port) ]
then
    #EXIST=true

    sudo port install python36
    sudo port select --set python python36
    pip install pymorphy2
    pip install -U pymorphy2-dicts-ru

    echo "======[ Установка завершена ]======"
else
    echo "Не найден модуль для установки python"
fi

