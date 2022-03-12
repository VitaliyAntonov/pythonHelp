t =[' ', '|',' ' , '|', " "]
t1=[' ', '|',' ' , '|', " "]
t2=[' ', '|',' ' , '|', " "]
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
    st1=[d[0][0],d[0][2],d[0][4]]
    st2=[d[2][0],d[2][2],d[2][4]]
    st3=[d[4][0],d[4][2],d[4][4]]
    st8=[d[0][0],d[2][0],d[4][0]]
    st4=[d[0][2],d[2][2],d[4][2]]
    st5=[d[0][4],d[2][4],d[4][4]]
    st6=[d[0][0],d[2][2],d[4][4]]
    st7=[d[4][0],d[2][2],d[0][4]]
    if r % 2 == 0:
        print('введите координаты x')
    else:
        print('введите координаты 0')
    y1, z1 = map(int,input().split())
    y=0
    z=0
    if y1 == 1:
        y=0
    if z1==1:
        z=0
    if y1 == 3:
        y = 4
    if z1 == 2:
        z = 2
    if y1 == 2:
        y = 2
    if z1 == 3:
        z = 4
    if d[y][z] == ' ':
        r += 1
        if r<5:
            if r % 2 == 0:
                tyan()
            else:
                yan()
        elif 9>r>=5:
            if r % 2 == 0:
                yan()
            else:
                tyan()
            if st1.count(st1[0]) == len(st1):
                print ('вы выйграли')
                break
            elif st2.count(st2[0]) == len(st2):
                print ('вы выйграли')
                break
            elif st3.count(st3[0]) == len(st3):
                print ('вы выйграли')
                break
            elif st4.count(st4[0]) == len(st4):
                print ('вы выйграли')
                break
            elif st5.count(st5[0]) == len(st5):
                print ('вы выйграли')
                break
            elif st6.count(st6[0]) == len(st6):
                print ('вы выйграли')
                break
            elif st7.count(st7[0]) == len(st7):
                print ('вы выйграли')
                break
            elif st8.count(st8[0]) == len(st8):
                print ('вы выйграли')
                break
        elif r==9:
            print('ничья')
    else:
        print('введите сново')