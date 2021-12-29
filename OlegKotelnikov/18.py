a = int(input())
b = int(input())
c = int(input())

if a == max(a,b,c):
    max = a
elif b == max(a,b,c):
    max = b
elif c == max(a,b,c):
    max = c
if a == min(a,b,c):
    min = a
elif b == min(a,b,c):
    min = b
elif c == min(a,b,c):
    min = c
if a == min or a == max:
    if b == min or b == max:
        avg = c
    else:
        avg = b
else:
        avg = a

print(max)
print(min)
print(avg)