n=int(input())# put your python code here
w=n**2
a=[[0 for j in range(n)]for i in range(n)]
c3,j,p=0,0,1
for i in range(j,n):#j=0
    a[j][i]=p;p+=1
n-=1;ci=c=1
while p<=w:
  for j in range(n):
    a[j+c][i+c3]=p;p+=1
  ci+=1;c3+=1
  for i in range(n):
    a[j+c][-i-ci]=p;p+=1
  i=-i-ci
  n-=1;c+=1
  for j in range(n):
    a[-j-c][i]=p;p+=1
  j=-j-c
  for i in range(n):#j=0
    a[j][i+c3]=p;p+=1
  n-=1 ;#c3+=1#;ci+=1
for i in range(len(a)):
  print(*a[i])