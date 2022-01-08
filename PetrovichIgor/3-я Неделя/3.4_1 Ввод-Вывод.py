#import os
#shf = open(os.path.join('/','home','petrovich','Soft','pycharm-community-2021.3','TiachDonload','dataset_3363_2.txt'),'r')
#s = shf.readline()

#os.path.join('home','petrovich','Soft','ycharm-community-2021.3','TiachDonload','Prover001') # Открытие файла из каталога и подкаталога.
#shf = 'S15V8J10Q6j19N19k17J16c10Z2w10o4h8t9g5I6u8I2F15y17W6d2t5e9' # Проверочная строка
#/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/
#'/','home','petrovich','Soft','pycharm-community-2021.3','TiachDonload','Prover001.txt'),'r') # Открытие файла
s = open("/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/Prover002", "r").readline()
#with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/dataset_3363_2.txt') as inf:
#     s = inf.readline()
y, tmpOut, x = str(0), str(), str() # Создание пустых строк
for i in s: # Перебор всех символов строки "s" по порядку
    if '0' <= i <= '9': # Проверка очередного символа на число
        y += i # Если число то сливается с "y='0'+'i'"
        continue # Переход к следущему символу
    tmpOut += x * int(y) # Запись в файл символа "х" "у" раз (в первый цикл пустая строка 0 раз)
    x = i # Запоминание не цифры
    y = str(0) # Обнуление индекса не цифры
tmpOut += x * int(y) # Запись в файл последнего символа "х" "у" раз
#print(tmpOut)
#shf.close()
#rez = open('home','petrovich','Soft','pycharm-community-2021.3','TiachDonload','rez.txt','w')
with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/rez.txt','w') as rez: # Открытие файла для записи
    rez.write(tmpOut) # Запись строки в файл
    #rez = open(os.path.join('home','petrovich','Soft','ycharm-community-2021.3','TiachDonload','rez.txt'),'w') # Открытие файла для записи из каталога и подкаталога.
    #rez.write(tmpOut)
print(tmpOut) # Проверочная строка результата
#rez.close()