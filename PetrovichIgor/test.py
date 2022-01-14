print('test')
print('type(True)', type(True))
print('''type('False')''', type('False'))
print('type([str])', type([str]))
print('type(1.0)', type(1.0))
print(0.3+0.3+0.3 == 0.9) #False
print(0.3+0.3+0.3) #0.8999999999999999
n, i, z = 6, 2, 0
for i in range(n):
    while i<=4:
        i+=1
        z+=1
    else:
        i-=1
        break
    continue
print('i=', i,'итераций в цикле пока (while)', z)

print('Вводимые числа должны быть целыми')
A=int(input('Рекомендованое время сна, введите'))
B=int(input('Максимально допустимое время сна, введите'))
H=int(input('Время сна, введите'))# put your python code here
if A<=H<=B:
    print('Это нормально')
if H<A:
    print('Недосып')
else:print('Пересып')
