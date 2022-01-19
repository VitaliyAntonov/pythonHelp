t = [[0 for x in range(14)] for y in range(8)]
t[0] = [' ', ' ', ' ', 'A', ' ', ' ', ' ', 'B', ' ', ' ', ' ', 'C', ' ', ' ']
t[1] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
t[2] = ['1', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[3] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
t[4] = ['2', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[5] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
t[6] = ['3', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[7] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
n = 9
h = 0
winner = ''

def calc_table(x = '0', y = '0', s = ''):

    if x == 'A' or x == 'a':
        x = 3
    elif x == 'B' or x == 'b':
        x = 7
    elif x == 'C' or x == 'c':
        x = 11
    else:
        return print('координата X - A, B или С (можно a b c)')
    if y == '1':
        y = 2
    elif y == '2':
        y = 4
    elif y == '3':
        y = 6
    else:
        return print('координата Y - 1, 2 или 3')
    if s == 1:
        s = '0'
    else:
        s = 'X'
    if t[y][x] == ' ':
        t[y][x] = s
    else:
        return print('в тоже место ставить нельзя')
    print_table()
    win(s)
    global h
    h += 1

def print_table():
    for i in range(8):
        for j in range(14):
            print(t[i][j], end='')
        print()

def win(s):
    global winner
    for i in range(2, 7, 2):
        if t[i][3] == t[i][7] == t[i][11] == s:
            winner = s
            return
    for j in range(3, 12, 4):
        if t[2][j] == t[4][j] == t[6][j] == s:
            winner = s
            return
    if t[2][3] == t[4][7] == t[6][11] == s or t[6][3] == t[4][7] == t[2][11] == s:
        winner = s
        return


print('Пример ввода координат - a 1')
print_table()
while h < n:
    a = input('x y - ').split(' ')
    try:
        calc_table(a[0],a[1],h%2)
    except BaseException:
        print('ошибка ввода')
        continue
    if winner != '':
        print(f'Поздравляю {winner} с победой!')
        break
else:
    print('Ничья')