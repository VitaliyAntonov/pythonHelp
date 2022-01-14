class SetsInfo:
    """
    Множества (set и frozenset)
    Множество в python - "контейнер", содержащий не повторяющиеся элементы в случайном порядке.
    Ссылка:  https://pythonworld.ru/tipy-dannyx-v-python/mnozhestva-set-i-frozenset.html
    """

    def create_help(self):
        """ Создание множеств
        a = {"qw", "as", "de"}
        d = {1, 2, 3, 4, 5}
        e = set()     # пустое множество
        строка при создании множества делится на символы
        t = set("asdfr")  >>> {'s', 'r', 'd', 'a', 'f'}
        создание строки из нескольких слов
        iStr = set(s for s in "qWe asD zxc dE".lower().split()) >>> {'qwe', 'de', 'asd', 'zxc'}
        """
        pass

    def len_help(self):
        """len(s) - число элементов в множестве (размер множества)."""
    def x_in_help(self):
        """x in s - принадлежит ли x множеству s."""
    def isdisjoint_help(self):
        """set.isdisjoint(other) - истина, если set и other не имеют общих элементов."""
    def compare_help(self):
        """ Сравнение двух множеств
        set == other - все элементы set принадлежат other, все элементы other принадлежат set."""
    def issubset_help(self):
        """set.issubset(other) или set <= other - все элементы set принадлежат other."""
    def issuperset_help(self):
        """set.issuperset(other) или set >= other - все элементы other принадлежат set."""
    def union_help(self):
        """set.union(other, ...) или set | other | ... - объединение нескольких множеств."""
    def intersection_help(self):
        """set.intersection(other, ...) или set & other & ... - пересечение множеств."""
    def difference_help(self):
        """set.difference(other, ...) или set - other - ... - множество из всех элементов set,
        не принадлежащие ни одному из other."""
    def symmetric_difference_help(self):
        """set.symmetric_difference(other); set ^ other - множество из элементов,
        встречающихся в одном множестве, но не встречающиеся в обоих."""
    def copy_help(self):
        """set.copy() - копия множества."""

    # Операции, непосредственно изменяющие множество

    def update_help(self):
        """set.update(other, ...); set |= other | ... - объединение."""
    def intersection_update_help(self):
        """set.intersection_update(other, ...); set &= other & ... - пересечение."""
    def difference_update_help(self):
        """set.difference_update(other, ...); set -= other | ... - вычитание."""
    def symmetric_difference_update_help(self):
        """set.symmetric_difference_update(other); set ^= other - множество из элементов,
        встречающихся в одном множестве, но не встречающиеся в обоих."""
    def add_help(self):
        """set.add(elem) - добавляет элемент в множество."""
    def remove_help(self):
        """set.remove(elem) - удаляет элемент из множества. KeyError, если такого элемента не существует."""
    def discard_help(self):
        """set.discard(elem) - удаляет элемент, если он находится в множестве."""
    def pop_help(self):
        """set.pop() - удаляет первый элемент из множества.
        Так как множества не упорядочены, нельзя точно сказать, какой элемент будет первым."""
    def clear_help(self):
        """set.clear() - очистка множества."""


