#https://html5book.ru/html-lists

theme: /razmetka

    state: Разметка
    q!: разметка

        state: 1
            q: * 1 *
            a: Основной текст:
               1) пункт списка a
               2) пункт списка b
               - пункт списка c
               - пункт списка d
               
        state: 2
            q: * 2 *
            a: Основной текст:
               - пункт списка a
               - пункт списка b
               1) пункт списка c
               2) пункт списка d
               
        state: 3
            q: * 3 *
            a: Основной текст:
               1) пункт списка a
                  - вложенный пункт b
                    text c (часть пункта b перемещенная на строчку ниже)
               2) пункт списка d           
               
        state: 4
            q: * 4 *
            a: Основной текст:
               <ul>
                    <li>пункт a</li>
                    <li>пункт b</li>
                    <li>пункт c</li>
                    <li>пункт d</li>      
               </ul>
    
        state: 5
            q: * 5 *
            a: Основной текст:
               <ol>
                    <li>пункт a</li>
                    <li>пункт b</li>
                    <li>пункт c</li>
                    <li>пункт d</li>      
               </ol>
    
        state: 6
            q: * 6 *
            a: Основной текст:
               <dl>
                    <dd>пункт a</dd>
                    <dd>пункт b</dd>
                    <dd>пункт c</dd>
                    <dd>пункт d</dd>      
               </dl>