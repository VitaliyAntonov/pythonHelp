
# Python: основы и применение
# https://stepik.org/course/512/syllabus

if __name__ == '__main__':

    def different_object():
        """вычислить количество различных объектов в списке.
        Два объекта a и b считаются различными, если a is b равно False"""
        # objects = [1, 2, 1, 2, 3]
        objects = [1, 2, 1, 5, True, False, True, 'false', [], [1, 2], [1, 2]]

        un = set()
        for ob in objects:
            un.add(id(ob))

        answer = len(un)

        print(answer)

    # different_object()


if __name__ == '__main__':
    a = []

    def foo(arg1, arg2):
        a.append("foo")

    foo(a.append("arg1"), a.append("arg2"))

    print(a)
