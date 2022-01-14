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
        """
    def len_help(self):
        """len(d) - число ключей в словаре."""
    def x_in_help(self):
        """x in d - есть ли ключ x в словаре d."""
    def clear_help(self):
        """dict.clear() - очищает словарь."""
    def copy_help(self):
        """dict.copy() - возвращает копию словаря."""
    def fromkeys_help(self):
        """dict.fromkeys(seq[, value]) - создает словарь с ключами из seq и
        значением value (по умолчанию None). """
    # [, default] [, value] - необязательная часть метода, примеры написания:
    # d.fromkeys(s, 1)
    # d.get('key1', False)
    def get_help(self):
        """dict.get(key[, default]) - возвращает значение ключа, но если его
        нет, не бросает исключение, а возвращает default (по умолчанию None)."""
    def items_help(self):
        """dict.items() - возвращает пары (ключ, значение)."""
    def keys_help(self):
        """dict.keys() - возвращает ключи словаря."""
    def pop_help(self):
        """dict.pop(key[, default]) - удаляет ключ и возвращает его значение.
        Если ключа нет, возвращает default (по умолчанию бросает исключение)."""
    def popitem_help(self):
        """dict.popitem() - удаляет и возвращает последнюю введенную пару
        (ключ, значение). Если словарь пуст, бросает исключение KeyError."""
    def setdefault_help(self):
        """dict.setdefault(key[, default]) - возвращает значение ключа,
        но если его нет, не бросает исключение, а создает ключ со значением
        default (по умолчанию None)."""
    def update_help(self):
        """dict.update([other]) - обновляет словарь, добавляя пары
        (ключ, значение) из other, это может быть другой словарь или кортеж.
        Существующие ключи перезаписываются."""
    def values_help(self):
        """dict.values() - возвращает значения всех ключей в словаре."""


