class SortInfo:
    """
    Сортировки в Python
    Ссылки:
    6 примеров сортировки в Python с помощью функции sorted:
    http://python-3.ru/page/sorted
    """

    def sorted_help(self):
        """
        # Стандартная сортировка
        a = [3, 2, 5, 4, 7, 1]
        a = sorted(a)
        print(a)  # [1, 2, 3, 4, 5, 7]
        # Сортировка кортежа
        t = ('Zane', 'Bob', 'Janet')
        t = sorted(t)
        print(t)  # ['Bob', 'Janet', 'Zane']
        # Сортировка словаря
        d = {1: 'a', 2: 'b', 3: 'c'}
        d = sorted(d)
        print(d)  # [1, 2, 3]
        # функция sorted() возвращает список каждый раз, несмотря на то, какой тип был передан.
        # В случае со словарями, она возвращает отсортированный список словарных ключей.
        """


# Сортировка сложных структур с использованием ключа
class Person(object):
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __str__(self):
        return f"{self.name} {self.age}"

    def __repr__(self):
        # return f"Person('{self.name}', {self.age})"
        return f"{self.name} {self.age}"

if __name__ == '__main__':

    jack = Person('Jack', 19)
    adam = Person('Adam', 43)
    becky = Person('Becky', 11)
    people = [jack, adam, becky]

    def byName_key(person):
        return person.name

    def byAge_key(person):
        return person.age

    a = sorted(people, key=byName_key)
    b = sorted(people, key=byAge_key)

    print(people)

    print(a)
    print(b)


