s=[int(y) for y in input().split()]# put your python code here
sx=sorted(s)
a,ch=sx[0],0
for x in sx:
    if a==x:ch+=1
    else:
        if ch>1:print(a,end=' ');ch=1
    a=x
    while a==x:
        ch+=0
        break
if ch>1:print(a,end='')