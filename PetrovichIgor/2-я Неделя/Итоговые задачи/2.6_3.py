s=[y for y in input().split()]# put your python code here
x=input()
j=s.count(x)
if j==0:print('Отсутствует')
i=0
while i<j:
    d=s.index(x)#d=s.find(x)
    print(d+i,end=' ')
    del s[d]
    i+=1