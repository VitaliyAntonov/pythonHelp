from random import choice, randint

board = [" "] * 9  # создание доски

counter = 0
draw = False
some = {'A': -2, 'B': -1, 'C': 0}
computer = "X"
player = "X"


# вывод доски...
def draw_board(board):
    print("    A   B   C")
    print("  -------------")
    for i in range(3):
        print(i + 1, "|", board[3 * i], "|", board[3 * i + 1], "|", board[3 * i + 2], "|")
        print("  -------------")


draw_board(board)
helpful_movements = {"fst_zero": ("A1", "C1", "A3", "C3")}  # оптимальные ходы при центре
helpful2 = ('012', '021', '036', '048', '063', '084', '102', '120', '147', '174', '246',
            '264', '258', '285', '306', '345', '354', '360', '408', '417', '426', '435',
            '453', '462', '471', '480', '528', '582', '678', '687', '768', '786')


#  возможные комбинации по 2, совет, где размещать третий символ.

# распознавание хода вида A1, A2, ...
def rcgnz_m(hod, *args):
    if "Z" in hod:
        return int(hod[1])
    ind = 3 * int(hod[1]) + some[hod[0]] - 1
    args_inds = [ind]
    for elem in args:
        args_inds.append(elem)
    if not args:
        return ind
    else:
        return args_inds


# рисуем доску или возвращаем False, для последующего повторения хода
def draw_or_give_me_error(hod):
    ind = rcgnz_m(hod)
    if board[ind] != " ":
        return False
    else:
        board[ind] = "X" if counter % 2 == 0 else "0"
        return True


''' some_pc_predictive пробегаемся по helpful2 и ищем ситуации. Если компьютеру не хватает одного, то ставит он.
А если таких ситуаций нет, то мешает сопернику.
'''


def some_pc_predictive():
    for elem in helpful2:
        if computer in board[int(elem[0])] and computer in board[int(elem[1])] \
                and " " in board[int(elem[2])]:
            return f"Z{int(elem[2])}"

    for elem2 in helpful2:
        if player in board[int(elem2[0])] and player in board[int(elem2[1])] \
                and " " in board[int(elem2[2])]:
            return f"Z{int(elem2[2])}"
    return None


# проверяем победу, или ставим статус ничьи
def check_win(board):
    global draw
    win_coord = ("012", "345", "678", "036", "147", "258", "048", "246")
    for elem in win_coord:
        if board[int(elem[0])] == board[int(elem[1])] == board[int(elem[2])] != " ":
            return True
    if " " not in board:
        draw = True
    return False


# база.
def main():
    global counter, computer, player
    player = input("Введите, кем вы будете играть (X, 0): ")
    computer = "0" if player == "X" else "X"
    while True:
        if counter % 2 == 0 and player == 'X':
            hod = input("X, выбирайте клетку: ")
        elif counter % 2 != 0 and player == '0':
            hod = input("0, выбирайте клетку: ")
        else:
            if computer == "0" and board.count("X") == 1:
                print("Nice")
                hod = choice(helpful_movements["fst_zero"])
            elif board.count(" ") == 9:
                hod = "B2"
            else:
                hod = some_pc_predictive()
                if not hod:
                    if board[rcgnz_m("B2")] == " ":
                        hod = "B2"
                    elif player in (board[0], board[2]) and player in (board[6], board[8]):
                        hod = choice(("A2", "B1", "B3", "C2"))
                    else:
                        hod = f"Z{randint(0, 8)}"

        if len(hod) == 2:
            if (hod[0] in ('A', 'B', 'C') and hod[1] in ('1', '2', '3')) or "Z" in hod[0]:
                if draw_or_give_me_error(hod):
                    counter += 1
                    draw_board(board)
                    if check_win(board):
                        print("0 выиграл!" if counter % 2 == 0 else "X выиграл!")
                        break
                    elif draw:
                        print("Ничья!")
                        break
                else:
                    if counter % 2 == 0 and player == 'X' or counter % 2 == 1 and player == '0':
                        print("Клетка уже занята.")
            else:
                print("Вы сходили неверно. Ходите, например A1, B3, ...")
                continue
        else:
            print("Вы сходили неверно. Ходите, например A1, B3, ...")


if __name__ == '__main__':
    main()
