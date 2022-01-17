from AlexeyMescheryakov.MyFunction.debug import ms83
from AlexeyMescheryakov.MyFunction.ConsoleUpdate import c_update
from AlexeyMescheryakov.MyFunction.ConsoleUpdate import c_clean

lst = [[' ', 'A', 'B', 'C'], [1, 'X', '0', '0'], [2, '0', 'X', '0'], [3, '0', '0', 'X']]    # можно строки формировать из списков (так удобнее)
#lst = ['  | A | B | C', '1 | X | 0 | 0', '2 | 0 | X | 0', '3 | 0 | 0 | X']                 # а можно и сразу строки

c_update(lst, new=True)                 #Выводим lst впервые
c_update(lst)                           #Обновляем вывод lst
c_update(lst)                           #Обновляем вывод lst

print()

c_update(lst, ' || ', '~', new=True)    #Выводим lst впервые изменённым разделителем строк

x = input("Введите число ")             #Выведем сначало запрос на ввод числа, а после ввода запрос сотрём
c_clean()                               #Очищаем строку запроса
print(x)                                #Выводим в эту же строку введённое значение

c_update([input("Введите число ")])     #Вышенаписаное можно и так записать

c_update([], new=True)                  #Так пожно процесс бар организовать
for i in range(20000):
    c_update([str(i)])