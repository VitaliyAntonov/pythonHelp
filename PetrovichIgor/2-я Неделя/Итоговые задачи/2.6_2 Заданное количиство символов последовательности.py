n=int(input())# put your python code here
nx,i,x=1,1,1
while i<=n:#len(sp)==n
#print(sp,end='?')
    if x>nx:
        print(x,end=' ');nx+=1;i+=1
    elif x==nx:
        print(x,end=' ');nx=1;x+=1;i+=1