# put your python code here
c,d,a,b= (int(input())for _ in 'abcd') # присвоение переменным значений по порядку 'abcd'
x=a # Присвоение временной переменной "х" значения
while x<=b:
      print('\t',x,end='')
      x+=1
for c in range(c,d+1):
    print()
    print(c,'\t',end='')
    y=a
    while y<=b:
        print(y*c,'\t',end='')
        y+=1