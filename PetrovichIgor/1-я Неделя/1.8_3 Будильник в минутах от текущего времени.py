X=int(input('Введите количество минут для сна '))# put your python code here
H=int(input('текущие часы '))
M=int(input('текущие минуты '))
print('время пробуждения часы',(X+(H*60+M))//60)
print('минуты',(X+(H*60+M))%60)