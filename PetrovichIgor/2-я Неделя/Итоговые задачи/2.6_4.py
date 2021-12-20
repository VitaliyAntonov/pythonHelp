i,a=0,[0]
while a[i-1]!=['end']:# формирование входной матрици
    a[i]=[y for y in input().split()]
    if a[i]==['end']:# вхождение в цикл решения
        a.remove(['end'])#print('res')
        #print(a)
        break
    a.append([a[i]])
    i+=1# put your python code here

x,h=0,len(a)
#b=len(a[0]);if h>b:b,h=h,b
for y in range(h):
  #if y==h:print(int(a[y][x-1])+int(a[y][x+1])+int(a[y-1][x])+int(a[0][x]),end='&')
  b=len(a[y])
  while x<(b-1):
      if y==h-1:print(int(a[y][x-1])+int(a[y][x+1])+int(a[y-1][x])+int(a[0][x]),end=' ');x+=1;continue
      print(int(a[y][x-1])+int(a[y][x+1])+int(a[y-1][x])+int(a[y+1][x]),end=' ')
      x+=1
  #print(a[0][0])
  if b==1 and h==1:print(int(a[0][0])*4)
  else:
      if y==h-1:print(int(a[y][x-1])+int(a[y][0])+int(a[y-1][x])+int(a[0][x]));x=0;continue
      print(int(a[y][x-1])+int(a[y][0])+int(a[y-1][x])+int(a[y+1][x]));x=0
      y+=1