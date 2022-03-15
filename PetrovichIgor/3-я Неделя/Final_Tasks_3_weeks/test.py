# За победу команде начисляется 3 очка, за поражение — 0, за ничью — 1.
n = int(input())
def inp(n):# Блок считывания результатов игр по строчно
    #prov = open('Sample_input_3.7_1.txt') # Открытие файла с проверочными данными
    # Начальные переменные цикла for
    s_inp = [] # Создание пустого списка
    for _ in range(0,n): # цикл от 0 до n-1
        #s_inp.append(prov.readline().strip().split(';')) #Проверка из файла
        s_inp.append(input().strip().split(';')) #+= input('def for').strip().split(';') --> ['Спартак', '9', 'Зенит', '10']

    return s_inp#print(inp(n))#print(s_inp)
s = inp(n)#.strip().split(';')# Формирование двумерной матрици из результатов игр
print('s_inp',s)# Проверочный
#Формирование словаря d
d = {}
def up_d(d, key, value):#, key1, value1):
    zi, pb, nch, pr = 0, 0, 0, 0
    if d.get(key) != None:
        zi += 1
        return
    if d.get(key) == None:
        d[key] = [zi, pb, nch, pr, pb*3+nch*1]#; print(d)
        return #d[key*2].append(value)
    print('что - то не так')
    return
    print(zi, pb, nch, pr)
#Заполнение словаря
for i in range(0,n):
    #print('for',s)
    #print('pr',d,str(s[i][0]),(s[i][1]))
    up_d(d, str(s[i][0]), int(s[i][1]))
    up_d(d, (s[i][2]),int(s[i][3]))
    temp, temp2 = [], []
    if int(s[i][1]) < int(s[i][3]):
        temp = d[s[i][0]]
        temp[3] += 1
        temp[4] = temp[1]*3+temp[2]
        if d.get(s[i][0]) != None:
            temp[0] += 1
        temp2 = d[s[i][2]]
        temp2[1] += 1
        temp2[4] = temp2[1] * 3 + temp2[2]
        if d.get(s[i][2]) != None:
            temp2[0] += 1
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []

    elif int(s[i][1]) > int(s[i][3]):
        temp = d[s[i][0]]
        temp[1] += 1
        temp[4] = temp[2] * 3 + temp[2]
        if d.get(s[i][0]) != None:
            temp[0] += 1
        temp2 = d[s[i][2]]
        temp2[3] += 1
        temp2[4] = temp2[1] * 3 + temp2[2]
        if d.get(s[i][2]) != None:
            temp2[0] += 1
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []

    else:
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
        d[s[i][0]] = temp
        temp = []
        d[s[i][2]] = temp2
        temp2 = []
for k, v in d.items():
    print(k, end=':')
    print(*v)# put your python code here