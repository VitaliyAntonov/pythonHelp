# Служебные слова
# False class finally is return None continue for lambda try
# True def from nonlocal while and del global not with
# as elif if or yield assert else import pass
# break except in raise


import math

if __name__ == '__main__':
    print("sqrt(10) =", math.sqrt(10))
    print(34 // 4, 34 % 4)
    a = 4
    print('Square of', a, 'is', a * a, '.')  # результат: Square of 4 is 16 .

    def print_help():
        """ Вывод в консоль - варианты применения """
        # Вывод на экран числовых значений, затем символ окончания строки
        print(34 / 4)
        print(34 % 4)


    print_help()
