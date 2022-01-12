x=10
z=list(input())
while len(str(x))!=1:
    x=sum(map(int,z))
    z=list(str(x))
print(x)