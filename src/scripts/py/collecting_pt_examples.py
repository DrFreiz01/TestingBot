# -*- encoding: utf-8 -*-

import fnmatch
import os
import argparse


def get_files(path):
    '''
    Функция рекурсивно обходит указанную папку, собирает все файлы типа *.sc в список matches.
    PS. В python 3.5 можно воспользоваться вот такой конструкцией:
    matches = [filename for filename in glob.iglob('src/**/*.sc', recursive=True)]
    '''
    if os.path.isfile(path):
        return [path]

    matches = []
    for root, _, filenames in os.walk(path):
        for filename in fnmatch.filter(filenames, '*.sc'):
            matches.append(os.path.join(root, filename))
    return matches


def get_4EX_from_concrete_file(filename):
    '''
    Функция собирает 4EX из файла в список examples
    '''
    # завели переменную для 4Ex-ов
    examples = []

    # читаем входящий файл
    with open(filename, 'r', encoding="utf-8") as infile:
        for line in infile:
            # в каждой строке находим 4EX
            if line.find("4EX:") != -1:
                # собираем 4EX-ы в список
                examples.append(line.split("4EX:")[1].strip())

    return '\n'.join(examples)


def main(path, mask, all_in_one, output):
    # обошли папку с документами, собрали список путей
    matches = get_files(path)
    for file in matches:
        # если передан параметр mask, тогда возьмем название папки, в которой лежат файлы
        if mask:
            dirname = os.path.dirname(file).split('/')
            filename = dirname[0] if len(dirname) == 1 else dirname[-1]
        # если параметр all_in_one, тогда впишем общее название проекта
        elif all_in_one:
            filename = 'chatBot'
        else:
            # имя для записи файла по умолчанию соответствует названию файла
            filename = os.path.basename(file).split('.')[0]
        # собираем информацию о 4EX
        examples = get_4EX_from_concrete_file(file)
        # если нашлась какие-нибудь 4EX
        if len(examples) > 0:
            # запишем все в файлик
            with open(output + "/" + 'pt_' + filename + '.txt', 'a', encoding="utf-8") as infile:
                infile.write(examples)

if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('-f', '--file', type=str)
    parser.add_argument('-o', '--output', type=str, default="./res")
    parser.add_argument('--mask', action='store_true', default=False)
    parser.add_argument('--all', action='store_true', default=False)
    args = parser.parse_args()

    if not args.file:
        raise parser.error('Обязательный параметр --file не передан!')

    # подстрахуемся, если переданный для записи путь не существует, то создадим его
    if args.output and not os.path.exists(args.output):
        os.makedirs(args.output)

    # запустим основную функцию, передав ей все необходимые аргументы
    main(args.file, args.mask, args.all, args.output)
