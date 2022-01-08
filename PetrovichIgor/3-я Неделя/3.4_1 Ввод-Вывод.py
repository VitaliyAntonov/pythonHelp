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
y, tmpOut, x = str(0), str(), str()
for i in s: #hf: #(::-1):
    if '0' <= i <= '9':
        y += i
        continue
    tmpOut += x * int(y)
    x = i
    y = str(0)
tmpOut += x * int(y)
#print(tmpOut)
#shf.close()
#rez = open('home','petrovich','Soft','pycharm-community-2021.3','TiachDonload','rez.txt','w')
with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/rez.txt','w') as rez:
    rez.write(tmpOut)
    #rez = open(os.path.join('home','petrovich','Soft','ycharm-community-2021.3','TiachDonload','rez.txt'),'w') # Открытие файла для записи из каталога и подкаталога.
    #rez.write(tmpOut)
print(tmpOut) #, end='')
#rez.close()