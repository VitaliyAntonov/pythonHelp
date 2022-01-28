import random

t = [[0 for x in range(14)] for y in range(8)]
t[0] = [' ', ' ', ' ', 'A', ' ', ' ', ' ', 'B', ' ', ' ', ' ', 'C', ' ', ' ']
t[1] = [' ', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-']
t[2] = ['1', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[3] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
t[4] = ['2', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[5] = [' ', '|', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '|']
t[6] = ['3', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|']
t[7] = [' ', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-']
n = 9
h = 0
winner = ''
valid_t = [[2, 3],[2, 7],[2, 11],[4, 3],[4, 11],[4, 7],[6, 3],[6, 7],[6, 11]]
nonvalid_t = []
def calc_table(x = '0', y = '0', s = ''):

    if x == 'A' or x == 'a' or x == 3:
        x = 3
    elif x == 'B' or x == 'b' or x == 7:
        x = 7
    elif x == 'C' or x == 'c' or x == 11:
        x = 11
    else:
        return print('координата X - A, B или С (можно a b c)')
    if y == '1' or y == 2:
        y = 2
    elif y == '2' or y == 4:
        y = 4
    elif y == '3' or y == 6:
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
    nonvalid_t.append([y ,x, s])
    valid_t.remove([y, x])
    print_table()
    win(s)
    global h
    h += 1

def good_move(s):
    a = random.choice(valid_t)
    calc_table(a[1], a[0], s)

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

print('Первый игрок (крестики):')
print('Человек  - 1')
print('Тупой ИИ - 2\n')
while True:
    player1 = input('введите 1 или 2 - ')
    if player1 == '1' or player1 == '2':
        if player1 == '1':
            player1 = 0
        break
print()
print('Второй игрок (нолики):')
print('Человек  - 1')
print('Тупой ИИ - 2\n')
while True:
    player2 = input('введите 1 или 2 - ')
    if player2 == '1' or player2 == '2':
        if player2 == '1':
            player2 = 1
        break
print()
print('Пример ввода координат - a 1')
print_table()
while h < n:
    if winner != '':
        print(f'Поздравляю {winner} с победой!')
        break
    if player1 == h % 2 or player2 == h % 2:
        a = input('x y - ').split(' ')
        try:
            calc_table(a[0], a[1], h % 2)
        except BaseException:
            print('ошибка ввода')
            continue
    if player1 == '2' and h % 2 == 0:
        good_move(0)
    if player2 == '2' and h % 2 == 1 and h < n - 1:
        good_move(1)
else:
    print('Ничья')