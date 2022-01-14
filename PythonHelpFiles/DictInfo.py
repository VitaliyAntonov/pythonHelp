class DictInfo:
    """
    Словари в Python - неупорядоченные коллекции произвольных объектов
    с доступом по ключу. Их иногда ещё называют ассоциативными массивами
    или хеш-таблицами.

    Ссылка: https://pythonworld.ru/tipy-dannyx-v-python/slovari-dict-funkcii-i-metody-slovarej.html
    """

    def create_help(self):
        """ Создание словарей

        через фигурные скобки {}:
        d = {}  # пустой словарь
        d = {'key1': 1, 'key2': 2}

        с помощью функции dict:
        d = dict(short='dict', long='dictionary')
        print(d)
        {'short': 'dict', 'long': 'dictionary'}
        d = dict([(1, 1), (2, 4)])
        print(d)
        {1: 1, 2: 4}

        с помощью метода fromkeys:
        d = dict.fromkeys(['a', 'b'])
        print(d)
        {'a': None, 'b': None}
        dict.fromkeys(['a', 'b'], 100)
        print(d)
        {'a': 100, 'b': 100}

        с помощью генераторов словарей (аналогично генератору списков):
        d = {a: a ** 2 for a in range(7)}
        print(d)
        {0: 0, 1: 1, 2: 4, 3: 9, 4: 16, 5: 25, 6: 36}