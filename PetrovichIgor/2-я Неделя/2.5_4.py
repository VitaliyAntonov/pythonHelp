a,x=[int(y) for y in input().split()],0
b=len(a)
while x<(b-1):
    print(a[x-1]+a[x+1],end=' ')
    x+=1
if b==1:print(a[0])
else:
    print(a[x-1]+a[0],end=' ')