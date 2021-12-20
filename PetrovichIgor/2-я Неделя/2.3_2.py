a,b=(int(input())for _ in 'ab')#(int(x)for x in input().split())# put your python code here
while a%3!=0:
    a+=1
d,s=0,0
for a in range(a,b+1,3):
    s+=a
    d+=1
print(s/d)