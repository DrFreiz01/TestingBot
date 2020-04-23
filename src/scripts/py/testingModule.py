import argparse
from os import path, makedirs
import json
from datetime import datetime
from time import sleep
import csv
import codecs
from pathlib import Path
from simplejson.errors import JSONDecodeError

import requests

conf = {
    'defaultEnv': 'dev',
    'header': {'Content-Type': 'application/json'},
    'defaultTimeout': 5,
    'minimumTimeout': 0.5,
    'defaultCsvDelimiter': ';',
    'defaultFileFilter': '*.txt',
    'defaultFolderRecurse': False,
    'priorKeysList': ['query', 'answer', 'stateList', 'response']
}


env = {
    'dev':
    {
        'token': 'a8002655-f982-434d-b6f2-73b8c585e010',
        'url': 'https://zenbot-dev.just-ai.com/chatadapter/chatapi/',
    },
    'master':
    {
        'token': 'a8002655-f982-434d-b6f2-73b8c585e010',
        'url': 'https://zb04.just-ai.com/chatadapter/chatapi/',
    },
}


def _get_buttons_from_resp(data):
    button_list = list()
    for item in data:
        if item.get('type') == 'buttons':
            button_list.append('text')
    return button_list


def _get_state_list(data):
    state_list = list()
    for item in data:
        if 'state' in item.keys():
            state_list.append(item.get('state'))
    return state_list


def _get_list_dist_keys(data):
    keys = list()
    for item in data:
        for key in item.keys():
            if key not in keys:
                keys.append(key)
    keys.sort()
    return keys


def _get_list_dist_keys_prior(data, prior_keys=None):
    src_keys = _get_list_dist_keys(data)
    if prior_keys is None:
        return src_keys

    result_keys = prior_keys.copy()
    # remove prior keys, that are not in dict
    for key in result_keys:
        if key not in result_keys:
            result_keys.remove(key)
    # fill result_key array with not prior src_keys
    for key in src_keys:
        if key not in result_keys:
            result_keys.append(key)
    return result_keys


def _append_data_to_csv(data, _file_path, delimiter, prior_keys=None):
    keys = _get_list_dist_keys_prior(data, prior_keys)
    file_is_empty = not file_len(_file_path)
    with codecs.open(_file_path, 'a', 'utf-8') as _f:
        w = csv.DictWriter(_f, keys, delimiter=delimiter, lineterminator='\n')
        if file_is_empty:
            w.writeheader()
        for item in data:
            w.writerow(item)
    return len(data)


def touch_file(_file_path, clear=False):
    basedir = path.dirname(_file_path)
    if basedir != '':
        makedirs(basedir, exist_ok=True)
    if clear:
        rights = 'w'
    else:
        rights = 'a'
    open(_file_path, rights).close()


def file_len(_file_path):
    return sum(1 for line in open(_file_path))


def json_dumps(json_data):
    return str(json.dumps(json_data, ensure_ascii=False).encode('utf8').decode('utf8'))


def ls(_path, _filter='*', recurse_scan=False):
    if recurse_scan:
        path_list = list(Path(_path).rglob(_filter))
    else:
        path_list = list(Path(_path).glob(_filter))
    _result_list = list()
    for item in path_list:
        _result_list.append(str(item))
    return _result_list


def parser_config():
    parser_object = argparse.ArgumentParser(
        formatter_class=argparse.RawDescriptionHelpFormatter,
        description='''Program info:
    Read file with client messages log and send them to bot API line by line.
    After all file it'll save responses to csv file.
''')
    parser_object.add_argument('inputPath', type=str, help='Path to input file')  # FILE
    parser_object.add_argument('--debug', type=bool, help='Print debug information. Set "--debug=True" for debug.', default=False)  # verbose
    parser_object.add_argument('--env', type=str, help=f'Bot env to use. Default env={conf.get("defaultEnv")}', default=conf.get('defaultEnv'))  # branch
    parser_object.add_argument('--botUrl', type=str, help='Bot url', default=None)  # BOT_URL
    parser_object.add_argument('--botToken', type=str, help='Token to auth in bot', default=None)  # BOT_TOKEN
    parser_object.add_argument('--outputFile', type=str, help='Set custom output file path', default=None)  # OUTPUT_FILE
    parser_object.add_argument('--reqTimeout', type=float, help=f'Pause between requests in seconds. Default={conf.get("defaultTimeout")}', default=conf.get('defaultTimeout'))  # TIMEOUT
    parser_object.add_argument('--reqMinimumTimeout', type=float, help=f'Minimum pause between response and new request. Default={conf.get("minimumTimeout")}', default=conf.get('minimumTimeout'))
    parser_object.add_argument('--csvDelimiter', type=str, help=f'Char to use to split output csv data. Default={conf.get("defaultCsvDelimiter")}', default=conf.get('defaultCsvDelimiter'))  # SEP
    parser_object.add_argument('--folderFilter', type=str, help=f'Filter for files, if inputPath is dir Default={conf.get("defaultFileFilter")}', default=conf.get('defaultFileFilter'))
    parser_object.add_argument('--scanFolderRecurse', type=bool, help=f'If inputPath is folder, use recourse folder scan. Default={conf.get("defaultFolderRecurse")}', default=conf.get('defaultFolderRecurse'))
    return parser_object


def dict_chain_exist(dict, *args):
    try:
        var_string = 'dict'
        for arg in args:
            var_string += f'.get(\'{arg}\')'
        eval(var_string)
        return True
    except AttributeError:
        return False


def real_timeout_time(start_time, end_time, need_wait_time, min_wait_time):
    real_sleep_time = need_wait_time - (end_time - start_time).total_seconds()
    if real_sleep_time < min_wait_time:
        return min_wait_time
    else:
        return real_sleep_time


def process_file(src_file, _env, debug_flag, req_timeout, req_min_timeout):
    with open(src_file) as f:
        content = f.readlines()
    lines = [x.strip() for x in content]

    if debug_flag is False:  # показываем, сколько строк
        print(f'[{len(lines)}]', end='', flush=True)

    _result_list = list()
    for line_num, line in enumerate(lines):
        try:
            if line.strip() == '':
                if debug_flag:
                    print(f'Line#{line_num + 1} in src file is empty, skipped')
                else:
                    print(f'S', end='', flush=True)
                continue

            # запрашиваем ответ у бота
            url = _env.get('url') + _env.get('token')
            payload = {
                'clientId': src_file,
                'query': line
            }
            pre_req_timestamp = datetime.now()
            resp = requests.post(url, json=payload, headers=conf.get('header'))
            if debug_flag:
                text = 'line_num={}, url={}, payload={}, resp_code={}, response={}'
                text = text.format(line_num, url, json_dumps(payload), resp.status_code,
                                   str(resp.text.encode("utf8").decode("utf8")))
                print(text)
            try:
                resp_json = resp.json()
            except JSONDecodeError:
                msg = f'Response is not json: response code={resp.status_code}, response={resp}'
                raise ValueError(msg)

            if resp.status_code != 200 and not debug_flag:
                text = '\nLine#{}, q:"{}", error[{}]: {} {} {}'.format(line_num + 1, line, resp.status_code,
                                                                       resp_json.get("error", ""),
                                                                       resp_json.get("exception", ""),
                                                                       resp_json.get("message", ""))
                print(text, end='', flush=True)

            # собираем строчку данных
            _result_item = _env.copy()
            _result_item['responseCode'] = resp.status_code
            _result_item['response'] = json_dumps(resp_json)
            _result_item['inputPath'] = src_file
            _result_item['query'] = line
            if dict_chain_exist(resp_json, 'data', 'answer'):
                _result_item['answer'] = resp_json.get('data').get('answer').replace('\n', '\\n')
            if dict_chain_exist(resp_json, 'data', 'replies'):
                _result_item['stateList'] = json_dumps(_get_state_list(resp_json.get('data').get('replies')))
                _result_item['buttons'] = json_dumps(_get_buttons_from_resp(resp_json.get('data').get('replies')))
            if dict_chain_exist(resp_json, 'timestamp'):
                _result_item['timestamp'] = resp_json.get('timestamp')
            _result_list.append(_result_item)

            if not debug_flag:  # показываем, что мы работаем, а не зависли
                print('.', end='', flush=True)

            real_wait_sec = real_timeout_time(pre_req_timestamp, datetime.now(), req_timeout, req_min_timeout)
            if debug_flag:
                print(f'real_wait_sec={real_wait_sec}')
            sleep(real_wait_sec)  # дадим боту выдохнуть
        except KeyboardInterrupt:
            print('\nKeyboardInterrupt! Saving already loaded data to file.')
            _result_list.append({'query': 'error:KeyboardInterrupt!'})
            _rows_count = _append_data_to_csv(_result_list, cmd_args.outputFile, cmd_args.csvDelimiter,
                                              prior_keys=conf.get('priorKeysList'))  # сохранить результат в файл
            print(f' {cmd_args.outputFile}:rows_count={_rows_count}')
            exit(1)

    return _result_list


if __name__ == '__main__':
    parser = parser_config()
    cmd_args = parser.parse_args()

    # валидация входных данных
    if path.isdir(cmd_args.inputPath):
        file_list = ls(cmd_args.inputPath, cmd_args.folderFilter, cmd_args.scanFolderRecurse)
    else:
        if path.isfile(cmd_args.inputPath):
            file_list = [cmd_args.inputPath]
        else:
            msg = f'Input path "{cmd_args.inputPath}" does not exist or not accessible'
            raise ValueError(msg)

    if cmd_args.env not in env.keys():
        msg = f'Env must be in list "{str(env.keys())}'
        raise ValueError(msg)

    # сборка параметров
    env = env.get(cmd_args.env)
    if cmd_args.botUrl:
        env['url'] = cmd_args.botUrl
    if cmd_args.botToken:
        env['token'] = cmd_args.botToken
    if cmd_args.outputFile is None:
        cmd_args.outputFile = f'{path.abspath(cmd_args.inputPath).split(path.sep)[-1]}-{cmd_args.env}.csv'

    if env['token'] == '':
        raise ValueError('Token cannot be null, fill the auth token')

    result_list = list()
    touch_file(cmd_args.outputFile, clear=False)  # проверить, что файл есть, но не очищать его
    # пробегаем по списку файлов
    for file_path in file_list:
        print(f'{file_path}:', end='', flush=True)
        # прогоняем файл построчно через бота
        result_item = process_file(file_path, env, cmd_args.debug, cmd_args.reqTimeout, cmd_args.reqMinimumTimeout)
        # сохранить результат в файл
        rows_count = _append_data_to_csv(result_item, cmd_args.outputFile, cmd_args.csvDelimiter,
                                         prior_keys=conf.get('priorKeysList'))
        print(f' {cmd_args.outputFile}:rows_count={rows_count}')
