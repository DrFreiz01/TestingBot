## Для работы скрипта нужно:  
- python >= 3.5  
- модуль requests (ставится командой: ```pip3 install requests```)  
  
## Запуск файла:  
```.bash  
python3 testingModule.py <файл с вопросами клиента построчно или каталог с файлами>  
```  
  
## Параметры запуска:  
```.bash  
-h -- встроенное описание флагов  
```  
  
## Важные моменты:  
- По-умолчанию стоит пауза между запросами в 3 секунды. Я думаю ее можно уменьшить до 0.5, я не менял значения по-умолчанию из материнского скрипта  
- Скрипт дописывает в конец файла, если файл уже существует  
- Скрипт игнорирует пустые строки в входном файле  
  