
def c_clean(num=1):
    """ Функция очищает указанное в num число строк в консоле """
    print('\033[F\033[K' * num + '\033[F')

def c_update(lst, delimh=' | ', delimv='', new=False):
    """ Функция принимает на вход список состоящий из строк
     каждая из которых может формироваться из вложенного списка
     символов или строк и выводит строки в консоль если задан
     аргумент new = True, елси new = False, то сначала происходит
     очистка строк от предыдущего вывода, а затем выводится
     обновленный массив строк.
     delimh - принимает символ разделителя данных в строке, если
     она передана в виде списка строк.
     delimv - принимает символ для разделения строк, если символ
     отсутствует то разделения строк симполом не производится. """
    if new:
        for s in lst:
            delimv_len = len(s)
            if type(s) == list:
                print(s[0], end='')
                for sh in s[1: delimv_len]:
                    print(delimh + sh, end='')
                print()
                if delimv > '':
                    print((delimv + ' ' * len(delimh)) * delimv_len)
            else:
                print(s)
                s_fnd = '' + s
                while delimh in s_fnd:
                    s_fnd = s_fnd.replace(delimh, '')
                if delimv > '':
                    print((delimv + ' ' * len(delimh)) * len(s_fnd))
    else:
        delimv_mul = 1
        if delimv > '':
            delimv_mul = 2
        #print('\033[F\033[K' * len(lst) * delimv_mul + '\033[F')
        c_clean(len(lst) * delimv_mul)
        c_update(lst, delimh, delimv, True)

