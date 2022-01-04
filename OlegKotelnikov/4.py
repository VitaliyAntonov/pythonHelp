# сумма квадратов в диапазоне целых чисел
print('сумма квадратов')
n = (int(input('от ')))
nn = (int(input('до ')))
s = 0
step = 1
if n > nn:
    n, nn = nn, n
for i in range(n + 1, nn + 1):
    s += pow(i, 2)
print(f'Сумма квадратов от {n} до {nn} - равна {s}')