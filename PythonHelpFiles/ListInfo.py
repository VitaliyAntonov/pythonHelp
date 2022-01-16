class ListInfo:
    """
    Списки в Python - упорядоченные изменяемые коллекции объектов произвольных типов
    (почти как массив, но типы могут отличаться).
    Ссылка:     https://pythonworld.ru/tipy-dannyx-v-python/spiski-list-funkcii-i-metody-spiskov.html
    """

    def create_help(self):
        """ Создание списков
        через квадратные скобки []:
        s = []  # пустой список
        l = ['s', 'p', ['isok'], 2]  #  список может содержать любое количество любых объектов
        с помощью функции list (строка при создании списка делится на символы):
        l = list("spisok")  >>> ['s', 'p', 'i', 's', 'o', 'k']
        с помощью генераторов списков:
        c = [c * 3 for c in 'list']  >>> ['lll', 'iii', 'sss', 'ttt']
        c = [c * 3 for c in 'list' if c != 'i']  >>> ['lll', 'sss', 'ttt']
        c = [c + d for c in 'list' if c != 'i' for d in 'spam' if d != 'a']
                                    >>> ['ls', 'lp', 'lm', 'ss', 'sp', 'sm', 'ts', 'tp', 'tm']
        """
        pass

    def len_help(self):
        """len(s) - число элементов в списке (размер списка)."""
    def x_in_help(self):
        """x in s - принадлежит ли x списку s."""
    def min_help(self):
        """min(s) - нахождение минимального элемента в списке (первого в алфавитном порядке)."""
    def max_help(self):
        """max(s) - нахождение максимального элемента в списке (последнего в алфавитном порядке)."""
    def append_help(self):
        """list.append(x) - добавляет элемент в конец списка."""
    def extend_help(self):
        """list.extend(L) - расширяет список list, добавляя в конец все элементы списка L."""
    def insert_help(self):
        """list.insert(i, x) - вставляет на i-ый элемент значение x."""
    def remove_help(self):
        """list.remove(x) - удаляет первый элемент в списке, имеющий значение x.
        ValueError, если такого элемента не существует."""
    def pop_help(self):
        """list.pop([i]) - удаляет i-ый элемент и возвращает его.
        Если индекс не указан, удаляется последний элемент."""
    # [i] - необязательная часть метода, примеры написания:
    # l = ['cccc', 'aa', 'b', 'aa', 'ddd']  >>> ['cccc', 'aa', 'b', 'aa', 'ddd']
    # x = l.pop(3)
    # print(l)  >>> ['cccc', 'aa', 'b', 'ddd']
    # print(x)  >>> 'aa'
    def index_help(self):
        """list.index(x, [start [, end]]) - возвращает положение первого элемента со значением x
        (при этом поиск ведется от start до end)."""
    # [start [, end]] - необязательная часть метода, примеры написания:
    # l = ['cccc', 'aa', 'b', 'b', 'aa', 'ddd']  >>> ['cccc', 'aa', 'b', 'b', 'aa', 'ddd']
    # x = l.index('aa', 2)  >>> 4
    # y = l.index('b', 1, 3)  >>> 2
    def count_help(self):
        """list.count(x) - возвращает количество элементов со значением x."""
    def sort_help(self):
        """list.sort([key=функция]) - сортирует список на основе функции."""
    # [key=функция] - необязательная часть метода, примеры написания:
    # l = ['cccc', 'aa', 'b', 'ddd']  >>> ['cccc', 'aa', 'b', 'ddd']
    # l.sort(key = len)  >>> ['b', 'aa', 'ddd', 'cccc']
    def reverse_help(self):
        """list.reverse() - разворачивает список."""
    def copy_help(self):
        """list.copy() - поверхностная копия списка."""
    def clear_help(self):
        """list.clear() - очищает список."""
