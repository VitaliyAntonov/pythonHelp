# За победу команде начисляется 3 очка, за поражение — 0, за ничью — 1.
n = int(input())
def inp(n):# Блок считывания результатов игр по строчно
    #prov = open('Sample_input_3.7_1.txt') # Открытие файла с проверочными данными
    # Начальные переменные цикла for
    s_inp = [] # Создание пустого списка
    for _ in range(0,n): # цикл от 0 до n-1
        #s_inp.append(prov.readline().strip().split(';')) #Проверка из файла
        s_inp.append(input().strip().split(';')) #+= input('def for').strip().split(';') --> ['Спартак', '9', 'Зенит', '10']
        # += input('def for') --> ['Л', 'о', 'к', 'о', 'м', 'о', 'т', 'и', 'в', ';', '1', '2', ';', 'З', 'е', 'н', 'и', 'т', ';', '3']
        #s_inp.append(prov.readline().strip().split(';'))# s_inp = [] --> [['Спартак', '9', 'Зенит', '10'], ['Локомотив', '12', 'Зенит', '3'], ['Спартак', '8', 'Локомотив', '15']]
        #print(s_inp) # Проверочный
    return s_inp#print(inp(n))#print(s_inp)
    #s = inf.readline().strip().split(';')
s = inp(n)#.strip().split(';')# Формирование двумерной матрици из результатов игр
#print('s_inp',s)# Проверочный

#Формирование словаря d
d = {}
#pb, nch, pr = 0, 0, 0
def up_d(d, key, value):#, key1, value1):
    #d, key, value = {}, 1, -1
    zi, pb, nch, pr = 0, 0, 0, 0
    if d.get(key) != None:
        #d[key] += value#; print(d)#; return
        zi += 1
        #d[key] += [zi, value, pb, nch, pr, pb * 3 + nch * 1]
        return
  #b=key
    if d.get(key) == None:
        #zi = 1
        d[key] = [zi, pb, nch, pr, pb*3+nch*1]#; print(d)
        return #d[key*2].append(value)
    #d[b].append(value)#d[b] = [value]
    print('что - то не так')
    return
    print(zi, pb, nch, pr)
#Заполнение словаря
for i in range(0,n):
    print('i', s)
    up_d(d,str(s[i][0]),int(s[i][1]))#{'Спартак': 9}
    up_d(d,(s[i][2]),int(s[i][3]))#{'Спартак': 9, 'Зенит': 10}
    #print(s)

    temp, temp2 = [], []
    if int(s[i][1]) < int(s[i][3]):
        print(s[i][1], '<', s[i][3])
        #print(d.items())#s[i][3] = pb+1; s[i][1] = pr+1
        #print(*d[s[i][0]])
        temp = d[s[i][0]]
        temp[3] += 1
        temp[4] = temp[1]*3+temp[2]
        #print('get',d.get(s[i][0]))
        if d.get(s[i][0]) != None:
            temp[0] += 1
        #up_d(d, str(s[i][0]), int(s[i][1]))
        temp2 = d[s[i][2]]
        temp2[1] += 1
        temp2[4] = temp2[1] * 3 + temp2[2]
        if d.get(s[i][2]) != None:
            temp2[0] += 1
        #up_d(d, str(s[i][2]), int(s[i][3]))
        #up_d(d,pb += 1)
        #print('temp', temp,';',temp2)
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []
        #print('*', *d[s[i][0]],';',*d[s[i][2]])

    elif int(s[i][1]) > int(s[i][3]):
        print(s[i][1], '>', s[i][3])
        #print(d.items())  # s[i][3] = pb+1; s[i][1] = pr+1
        # print(*d[s[i][0]])
        temp = d[s[i][0]]
        temp[1] += 1
        temp[4] = temp[1] * 3 + temp[2]
        if d.get(s[i][0]) != None:
            temp[0] += 1
        temp2 = d[s[i][2]]
        temp2[3] += 1
        temp2[4] = temp2[1] * 3 + temp2[2]
        if d.get(s[i][2]) != None:
            temp2[0] += 1
        # up_d(d,pb += 1)
        #print('temp', temp, ';', temp2)
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []
        #print('*', *d[s[i][0]], ';', *d[s[i][2]])

    else:
        #int(s[i][1]) == int(s[i][3]):
        print(s[i][1], '==', s[i][3])
        temp = d[s[i][0]]
        temp[2] += 1
        temp[4] = temp[1] * 3 + temp[2]
        if d.get(s[i][0]) != None:
            temp[0] += 1
        temp2 = d[s[i][2]]
        temp2[2] += 1
        temp2[4] = temp2[1] * 3 + temp2[2]
        if d.get(s[i][2]) != None:
            temp2[0] += 1
        # up_d(d,pb += 1)
        #print('temp', temp, ';', temp2)
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []
        #print('*', *d[s[i][0]], ';', *d[s[i][2]])
        #i +=1
    #print('for d',d)#print((q+':'), *w, end='\n')
for k, v in d.items():
    print(k, end=':')
    print(*v)#, end='\n')
    #print(k+':'+(' '.join(str(list(*v)))))
'''
def obr(s):# Формирование матрици из результатов игр
    #lst = {}# Создние пустого словаря
    while s != ['']: #Читать до пустого символа
        up_d(d, str(s[0][0]), int(s[0][1]))  # {'Спартак': 9}
        up_d(d, (s[0][2]), int(s[0][3]))  # {'Спартак': 9, 'Зенит': 10}
        print('orb',d)
        lst = 1
#print(*s[1])#Локомотив 12 Зенит 3
#print(s[1])#['Локомотив', '12', 'Зенит', '3']
for k, v in d.items():
    print(k, *v)

    Вывод программы необходимо оформить следующим образом:
    Команда: Всего_игр Побед Ничьих Поражений Всего_очков
    Спартак:2 0 0 2 0
    Зенит:2 1 0 1 3
    Локомотив:2 2 0 0 6

    '''
'''# Блок проверки
if __name__ == '__main__':
  print('PyCharm')
  print(update_dictionary(d, 1, -1))
  print(d)
  update_dictionary(d, 2, -2)
  print(d)
  update_dictionary(d, 1, -3)
  print(d)
for _ in range(0,n): # цикл от 0 до n-1
    s_inp = input('for')
    print(s_inp)
    '''