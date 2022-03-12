from numpy import array
from numpy import zeros
from numpy import arange
from numpy import linspace
from numpy import sin

a = array([2, 3, 4])        #создание одномерного массива из списка целых чисел
print(a)
print(a.ndim)               #размернсть массива
print(a.shape)              #размер массива. Количество элементов по каждой размерности
print()

b = array([(1.5, 2, 3), (4, 5, 6)]) #создание двумерного массива (матриц)
print(b)
print(b.size)                       #общее количество элементов
print()

z = zeros((3, 2))                   #заполнение массива (3, 2) нулями
print(z)
print()

print(arange(10, 30, 5))            #функция arange аналогична range, но возвращает массив,
                                    # а также шаг может быть дробным
print(linspace(0, 2, 9))            #генерация массива на указанном интервале с указанным количеством точек
print()

b = arange(12)                      #b = arange(12).reshape(4, 3)
b = b.reshape(4, 3)                 #преобразует любой размерности массив к другой размерности
print(b)
print()

#Операции между массивами
a = array([10, 20, 30])
b = arange(3)
print(a)
print(b)
print(a + b)
print(a - b)
print()

#общие арифметические операции
print(a ** 2)
print()

#передача массива функции, которая принимает одно число
print(2 * sin(a))
print()

#использование операций сравнения к массиву
print(a < 20)
