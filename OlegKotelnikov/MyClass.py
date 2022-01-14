class My_class():
    def __init__(self):
        self.a = 10
        self.b = 0
    def func(self):
        print('пустой класс')


x = My_class()
print(type(x))
x.func()
x.a += 10
print(x.a)
x.b = 0
x.b += 5
print(x.b)