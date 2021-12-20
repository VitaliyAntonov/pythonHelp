s=input()# put your python code here
a,ch=s[0],0
for x in s:
    if a==x:ch+=1
    else:
        print(a,end='');print(ch,end='');ch=1
    a=x
    while a==x:
        #ch+=1
        break
print(a,end='');print(ch,end='')