a = int(input())
b = int(input())
s=[]
for i in range (a, b+1):
    if not i%3:
        s.append(i)
print(s)
print(len(s))
print(sum(s)/len(s))