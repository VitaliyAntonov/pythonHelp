x, y, x1, y1 = map(int, input().split())
if abs(x1 - x) == abs(y - y1):
    print('можно')
else:
    print('нельзя')