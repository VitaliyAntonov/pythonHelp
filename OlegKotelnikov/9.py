x, y = map(int,input().split())
if x > y:
    x, y = y, x

#если нечетное такое и остается, если четное становится нечетным -1
for i in range((y // 2 + y % 2) * 2 - 1, x - 1, -2):
    print(i)
