t =[' ', '|',' ' , '|', ' ']
t1=[' ', '|',' ' , '|', ' ']
t2=[' ', '|',' ' , '|', ' ']
a= ['_',' ','_',' ','_']
d=[t,a,t1,a,t2]
for i in range(5):
    for j in range(5):
        print(d[i][j],end=' ')
    print()
def yan():
    d[y][z]='x'
    for i in range(5):
        for j in range(5):
            print(d[i][j],end=' ')
        print()
def tyan():
    d[y][z]='0'
    for i in range(5):
        for j in range(5):
            print(d[i][j],end=' ')
        print()
r=0
while r<10:
    r+=1
    if r % 2 == 0:
        print('введите координаты 0')
    else:
        print('введите координаты х')
    y1, z1 = map(int,input().split())
    if y1 == 1:
        y = 0
    if z1 == 1:
        z = 0
    if y1 == 3:
        y = 4
    if z1 == 2:
        z = 2
    if y1 == 2:
        y = 2
    if z1 == 3:
        z = 4
    if d[y][z] == ' ':
        if r<=4:
            if r % 2 == 0:
                tyan()
            else:
                yan()
        elif 9>r>4:
            if r % 2 == 0:
                tyan()
            else:
                yan()
        st1 = [d[0][0], d[0][2], d[0][4]]
        st2 = [d[2][0], d[2][2], d[2][4]]
        st3 = [d[4][0], d[4][2], d[4][4]]
        st8 = [d[0][0], d[2][0], d[4][0]]
        st4 = [d[0][2], d[2][2], d[4][2]]
        st5 = [d[0][4], d[2][4], d[4][4]]
        st6 = [d[0][0], d[2][2], d[4][4]]
        st7 = [d[4][0], d[2][2], d[0][4]]
        st9 = ['0', '0', '0']
        st10 = ['x', 'x', 'x']
        if st1==st9 or  st1==st10:
            print ('вы выйграли')
            break
        elif st2==st9 or  st2==st10:
            print ('вы выйграли')
            break
        elif st3==st9 or  st3==st10:
            print ('вы выйграли')
            break
        elif st4==st9 or  st4==st10:
            print ('вы выйграли')
            break
        elif st5==st9 or  st5==st10:
            print ('вы выйграли')
            break
        elif st6==st9  or  st6==st10:
            print ('вы выйграли')
            break
        elif st7==st10 or  st7==st9:
            print ('вы выйграли')
            break
        elif st8==st9 or  st8==st10:
            print ('вы выйграли')
            break
        elif r==9:
            print('ничья')
            break
    else:
        print('введите сново')
        r-=1