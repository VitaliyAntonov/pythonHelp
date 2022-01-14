f = 0
s = -1
n = int(input())
for _ in range(n):
    x = int(input())
    if x > f:
        s = f
        f = x
    elif x > s:
        s = x

print(f, s)