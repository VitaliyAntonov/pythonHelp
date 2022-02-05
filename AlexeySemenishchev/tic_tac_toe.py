#Игра крестики-нолики
print("Игра крестики-нолики")
print()

print("Пример ввода координат - c 2")
print()
print("   a b c", end='')

#инициализация поля пробелами
field = [[' ' for j in range(3)] for i in range(3)]


step = 0           #чей ход: 0 - крестики, 1 - нолики


#изначальное построение поля
for i in range(3):
    print()
    print(i + 1, end=' ')
    print('|', end='')
    for j in range(3):
            print(" |", end='')
print()
print()



while True:
    if step == 0:
        print("Крестики ходят:")
    elif step == 1:
        print("Нолики ходят:")

    coord = input("x y - ")
    #Проверка на наличие ошибок ввода
    if len(coord) != 3 or coord[0] < "a" or coord[0] > "c" or coord[1] != " " or coord[2] < "1" or coord[2] > "3":
        print("Ошибка ввода данных!")
        continue

    # переводим переменные из пользовательского формата в формат программы
    if coord[0] == 'a':
        y_element = 0
    if coord[0] == 'b':
        y_element = 1
    if coord[0] == 'c':
        y_element = 2
    x_element = int(coord[2]) - 1

    # Проверка на возможность поставить кристик или нолик в ячейке с введенными координатами
    if field[x_element][y_element] == 'X' or field[x_element][y_element] == '0':
        print("Данная ячейка уже занята крестиком или ноликом. Введите координаты пустой ячейки!")
        continue




    # в зависимости от очередности хода ставится либо крестик, либо нолик
    if step == 0:
        field[x_element][y_element] = 'X'
    else:
        field[x_element][y_element] = '0'

    # построение поля в соответствии с переменной field[i][j]
    print("   a b c", end='')
    for i in range(3):
        print()
        print(i + 1, end=' ')
        print('|', end='')
        for j in range(3):
            print(field[i][j], end='|')

    #проверка на победу
    #проверка на победу (3 крестика или 3 нолика по горизонтали)
    win_x = False
    win_0 = False
    for i in range(3):
        win_count_x = 1
        win_count_0 = 1
        for j in range(1, 3):
            if field[i][j] == field[i][j - 1] and field[i][j] == 'X':
                win_count_x += 1
            if field[i][j] == field[i][j - 1] and field[i][j] == '0':
                win_count_0 += 1
            if win_count_x == 3:
                win_x = True
            if win_count_0 == 3:
                win_0 = True

    #проверка на победу (3 крестика или 3 нолика по вертикали)
    for j in range(3):
        win_count_x = 1
        win_count_0 = 1
        for i in range(1, 3):
            if field[i][j] == field[i - 1][j] and field[i][j] == 'X':
                win_count_x += 1
            if field[i][j] == field[i - 1][j] and field[i][j] == '0':
                win_count_0 += 1
            if win_count_x == 3:
                win_x = True
            if win_count_0 == 3:
                win_0 = True

    # проверка на победу (3 крестика или 3 нолика по диагонали)
    win_count_x = 1
    win_count_0 = 1
    for i in range(1, 3):
        if field[i][i] == field[i - 1][i - 1] and field[i][j] == 'X':
            win_count_x += 1
        if field[i][i] == field[i - 1][i - 1] and field[i][j] == '0':
            win_count_0 += 1
        if win_count_x == 3:
            win_x = True
        if win_count_0 == 3:
            win_0 = True

    win_count_x = 1
    win_count_0 = 1
    for i in range(1, 3):
        if field[3 - i][3 - i] == field[2 - i][2 - i] and field[i][j] == 'X':
            win_count_x += 1
        if field[3 - i][3 - i] == field[2 - i][2 - i] and field[i][j] == '0':
            win_count_0 += 1
        if win_count_x == 3:
            win_x = True
        if win_count_0 == 3:
            win_0 = True

    #проверка на ничью
    win_draw = True
    for i in range(3):
        for j in range(3):
            if field[i][j] == ' ' or win_x == True or win_0 == True:
                win_draw = False

    if win_x == True:
        print("\n\nКрестики победили!")
        break
    elif win_0 == True:
        print("\n\nНолики победили!")
        break
    elif win_draw == True:
        print("\n\nНичья!")
        break


    #Смена хода
    step = 1 - step
    print()
    print()

