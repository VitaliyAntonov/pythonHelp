# Проверка введённых данных
def pr_inp(x):# Проверка введённых данных на соотвествие условию и запрс на новые данные
    if x == sh:# если проверяется sh
        xy = 'ширину'# Выводить запрос на
    else:
        xy = 'высоту'# Выводить запрос на
    while x < 3: # Пока х < 3
        print('честной игры не получится'+'\n','минимальный размер поля 3х3')
        x = int(input('Введите '+xy+' поля >= 3')) #Ввод нового значения в цикле проверки
        continue # возрат к циклу проверки
    return x  # выход из функции с удовлетворительным результатом проверки
# Построчная печать списка
def prn_sps(x):
    for _ in x:# Поэлементный перебор списка
        print(_)# Печать строки списка
    return x
# Формирование игрового поля X & 0
igr_pol = []# Пустой список строк игрового поля
sh = int(input('Введите ширину поля >= 3')) # Ввод ширины игрового поля
sh = pr_inp(sh)#; print('sh=', sh)# Проверка коректности ввода с присвоением переменной коректного значения
igr_pol = [' '*(sh+1)*4]# Формирование пустой шапки поля
igr_pol += ['   -'+'-'*(sh)*4]# Формирование верхней границы поля
hh = int(input('Введите высоту поля >= 3'))
hh = pr_inp(hh)#; print('hh=', hh)# Проверка коректности ввода с присвоением переменной коректного значения
i = 0# Начальные данные цикла for
for _ in range(0,hh):# формирование тела поля
    i += 1# Счётчик циклов
    igr_pol += ['   |' * (sh + 1)]# Граници рабочего поля (строка)
    if i != hh:# Исключение нижней(последней) граници поля
        igr_pol += ['   |'+'-' * (sh - 1) * 4+'---|']# формирование средней межстрочной граници
    else:# i == hh:# Формирование нижней(последней) граници поля
        igr_pol += ['   -' + '-' * (sh) * 4]
#, and='\n','автоматическая маркировка'
print(igr_pol)# Печать списока строк игрового поля
prn_sps(igr_pol)# Печать игрового поля