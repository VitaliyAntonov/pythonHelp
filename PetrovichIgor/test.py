print('test')
print('type(True)', type(True))
print('''type('False')''', type('False'))
print('type([str])', type([str]))
print('type(1.0)', type(1.0))
print(0.3+0.3+0.3 == 0.9)
n, i, z = 6, 2, 0
for i in range(n):
    while i<=4:
        i+=1
        z+=1
    else:
        i-=1
        break
    continue
print(i, z)

A=int(input())
B=int(input())
H=int(input())# put your python code here
if A<=H<=B:
    print('Это нормально')
if H<A:
    print('Недосып')
else:print('Пересып')