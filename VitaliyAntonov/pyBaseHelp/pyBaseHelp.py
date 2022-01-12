# Служебные слова
# False class finally is return None continue for lambda try
# True def from nonlocal while and del global not with
# as elif if or yield assert else import pass
# break except in raise


import math

if __name__ == '__main__':
    print("sqrt(10) =", math.sqrt(10))
    print(34 // 4, 34 % 4)
    a = 4
    print('Square of', a, 'is', a * a, '.')  # результат: Square of 4 is 16 .


    def visocos(god):
        """Високосный год"""
        # god = int(input())
        if (god % 4) == 0 and (god % 100) != 0:
            print("Високосный")
        elif (god % 400) == 0:
            print("Високосный")
        else:
            print("Обычный")


    def triangle_square(a, b, c):
        """Площадь треугольника по формуле Герона"""
        # a = int(input())
        # b = int(input())
        # c = int(input())
        p = (a + b + c) / 2
        square = math.sqrt(p * (p - a) * (p - b) * (p - c))
        return square


    def select_int(valInt):
        """1.12  True, если переданное значение попадает в интервал
        (−15,12]∪(14,17)∪[19,+∞) """
        # valInt = int(input())
        if (-15 < valInt <= 12) or (14 < valInt < 17) or (valInt >= 19) == True:
            print("True")
        else:
            print("False")


    def calc_input():
        """1.12 Калькулятор: первое число, второе число и операция"""
        aval = float(input())
        bval = float(input())
        action = str(input())
        rez = 0.0
        if action == "+":
            rez = aval + bval
        elif action == "-":
            rez = aval - bval
        elif action == "/":
            if bval == 0:
                rez = ("Деление на 0!")
            else:
                rez = aval / bval
        elif action == "*":
            rez = aval * bval
        elif action == "mod":
            if bval == 0:
                rez = ("Деление на 0!")
            else:
                rez = aval % bval
        elif action == "pow":
            rez = aval ** bval
        elif action == "div":
            if bval == 0:
                rez = ("Деление на 0!")
            else:
                rez = aval // bval
        print(rez)


    def square_room():
        """ Комнаты бывают треугольные, прямоугольные и круглые """
        # rez = 0.0
        sType = str(input())
        if sType == "треугольник":
            a = int(input())
            b = int(input())
            c = int(input())
            p = (a + b + c) / 2
            rez = (p * (p - a) * (p - b) * (p - c)) ** 0.5
        elif sType == "прямоугольник":
            a = int(input())
            b = int(input())
            rez = a * b
        elif sType == "круг":
            a = int(input())
            rez = 3.14 * a ** 2
        else:
            rez = "Нет такого слова"
        print(rez)


    def val_out_range():
        """1.12 сначала максимальное, потом минимальное, после чего оставшееся число """
        a = int(input())
        b = int(input())
        c = int(input())
        vMax = a
        if vMax < b:
            vMax = b
        if vMax < c:
            vMax = c
        vMin = a
        if vMin > b:
            vMin = b
        if vMin > c:
            vMin = c
        srVal = a + b + c - vMax - vMin
        print(vMax)
        print(vMin)
        print(srVal)


    def robot_language():
        """1.12 робот произносит вслух: "n программистов"."""
        count = int(input())
        name = "программист"
        endDigit = int(str(count)[-1])
        suf2 = int(str(count)[-2:])
        if endDigit == 0 or (5 <= endDigit <= 9) or (11 <= suf2 <= 19):
            name += "ов"
        elif 2 <= endDigit <= 4:
            name += "а"
        print(count, name)


    def ticket_num():
        """ 1.12 Счастливый билет """
        sNum = str(input())
        left = int(sNum[0]) + int(sNum[1]) + int(sNum[2])
        right = int(sNum[-3]) + int(sNum[-2]) + int(sNum[-1])
        if left == right:
            print("Счастливый")
        else:
            print("Обычный")


    def while_input():
        """2.1 после первого введенного нуля выводит сумму полученных на вход чисел"""
        exitStop = 0
        s = 0
        while exitStop == 0:
            inVal = int(input())
            if inVal != 0:
                s += inVal
            else:
                exitStop = 1
        print(s)


    def min_divide():
        """ 2.1 Наименьшее общее делимое """
        countA = int(input())
        countB = int(input())
        rez = int(0)
        exitStop = 0
        while exitStop == 0:
            rez += countA
            if rez % countB == 0:
                exitStop = 1
        print(rez)


    def control_input():
        """ 2.2 меньше 10 пропускаем; больше 100 прекращаем; остальные в консоль """
        a = 0
        while a <= 100:
            a = int(input())
            if 10 <= a <= 100:
                print(a)


    def mul_tab():
        """ 2.3 Блок таблицы умножения """
        a = int(input())
        b = int(input())
        c = int(input())
        d = int(input())
        sOut = ""
        head = ""
        for h in range(c, d + 1):
            head += "\t" + str(h)
        print(head)

        for i in range(a, b + 1):
            sOut = str(i)
            for k in range(c, d + 1):
                sOut += "\t" + str(k * i)
            print(sOut)


    def srednee3():
        """ 2.3 В консоль среднее арифметическое чисел из [a;b], кратных числу 3 """
        a = int(input())
        b = int(input())
        sum = int(0)
        num = int(0)
        for k in range(a, b + 1):
            if k % 3 == 0:
                num += 1
                sum += k
        print(sum / num)


    def procent_genom():
        """ 2.4 вычисляет процентное содержание символов G (гуанин) и C (цитозин) """
        inStr = str(input())
        cnt = inStr.lower().count('g') + inStr.lower().count('c')
        print(cnt / len(inStr) * 100)


    def string_pack(inStr):
        """2.4 группы одинаковых символов исходной строки заменяются на этот символ и количество
        его повторений в этой позиции строки"""
        # inStr = str(input())
        mems = inStr[0]  # текущий символ для проверки повторов
        cnt = 0  # счётчик повторов
        strOut = ""  # формируемая строка
        for k in range(len(inStr)):
            if inStr[k] == mems:  # повтор символа
                cnt += 1
            else:  # новый символ
                strOut += mems + str(cnt)
                mems = inStr[k]
                cnt = 1
        strOut += mems + str(cnt)  # добавляем последний
        print(strOut)


    def list_add(inStr):
        """ 2.5 Cтрока с целыми числами. Программа должна вывести сумму этих чисел """
        # inStr = str(input())
        listVal = inStr.split()
        sum = int(0)
        for value in listVal:
            sum += int(value)
        print(sum)


    def list_add2(inStr):
        """ 2.5 для каждого элемента списка вывести сумму двух его соседей """
        # inStr = str(input())
        listVal = inStr.split()
        strOut = ""
        if len(listVal) > 1:
            for k in range(len(listVal)):
                if k == (len(listVal) - 1):
                    right = listVal[0]
                else:
                    right = listVal[k + 1]
                vSum = int(listVal[k - 1]) + int(right)
                strOut += str(vSum) + " "
        else:
            strOut = listVal[0]
        print(strOut)


    def list_double_field(inStr):
        """2.5 Вывод в строку дублированных значений из списка """
        # inStr = str(input())
        listVal = []  # список чисел
        listScan = []  # список обработанных
        listDouble = []  # список дублей
        strOut = ""
        for s in inStr.split():  # заполняем список чисел
            listVal.append(int(s))

        for intVal in listVal:
            if intVal in listScan:  # проверяем обработано ли значение
                if intVal not in listDouble:  # нет в списке дублей
                    strOut += str(intVal) + " "
                    listDouble.append(intVal)
            else:
                listScan.append(intVal)  # при первом вхождении добаввляем в список обработанных

        print(strOut)


    def list_double_field2(inStr):
        """2.5 Вывод в строку дублированных значений из списка - решение с форума """
        a, c = [str(i) for i in inStr.split()], []
        for i in a:
            if i not in c and a.count(i) > 1:
                c.append(i)
                print(i, end=' ')


    def list_double_field3(inStr):
        """
        самое короткое
        set(a) - дает уникальные значения (без повторов)
        перебираем уникальные значения и удаляем их из входного списка
        итого у нас остаются только дубли во входном списке
        снова берем set(a) и выводим его
        """
        # a = input().split()
        a = inStr.split()
        [a.remove(i) for i in set(a)]
        print(*set(a))


    def inval_addnull_square():
        """ 2.6 Если сумма введённых чисел равна 0
        выводим сумму квадратов всех считанных чисел"""
        sum = int(0)
        squareSum = int(0)
        while 1:
            inVal = int(input())
            sum += inVal
            squareSum += inVal ** 2
            if sum == 0:
                break
        print(squareSum)


    def matrix_value_many(numOut):
        """ 2.6 часть последовательности 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 ...
        (число повторяется столько раз, чему равно).
        На вход программе передаётся неотрицательное
        целое число n — столько элементов последовательности
        должна отобразить программа """
        # numOut = int(input())
        k = 1  # число для печати
        count = 0  # счётчик распечатанных чисел
        while count < numOut:
            s = list([k] * k)
            if (count + k) >= numOut:  # последнее число в последовательности
                s = list([k] * (numOut - count))
            count += k
            k += 1
            print(*s, end=' ')


    def matrix_value_many2(n):
        """ 2.6
        Хочу поделиться интересным решением задачи вывода элементов
        списка через любой символ (см. последнюю строчку моего кода).
        По умолчанию выводится через пробел, но можно использовать параметр sep.
        Примечательно, что это решение работает из коробки  как для строковых,
        так и для числовых списков (в отличии от метода .join)
        Решение было найдено здесь:
        http://stackoverflow.com/questions/22556449/print-a-list-of-space-separated-elements-in-python-3
        """
        # n = int(input())
        a = []
        i = 0
        while len(a) < n:
            a += [i] * i
            i += 1
        print(*a[:n])


    def sym_position(inList, inVal):
        """ 2.6 выводит все позиции, на которых встречается число x в переданном списке lst """
        vList = [int(k) for k in inList.split()]
        vVal = inVal
        # vList = [int(k) for k in str(input()).split()]
        # vVal = int(input())
        lOut = []  # результат - список позиций
        vCount = vList.count(vVal)  # количество вхождений числа в список
        if vCount > 0:
            for i in range(vCount):
                vIndex = vList.index(vVal)
                lOut.append(vIndex)
                vList[vIndex] = vVal + 1  # заменяем значение в списке от повторного поиска
            print(*lOut)
        else:
            print("Отсутствует")


    def matrix_elite(matrix):
        """ 2.6
        Напишите программу, на вход которой подаётся прямоугольная матрица в виде
        последовательности строк. После последней строки матрицы идёт строка,
        содержащая только строку "end" (без кавычек, см. Sample Input).

        Программа должна вывести матрицу того же размера, у которой
        каждый элемент в позиции i, j равен сумме элементов первой матрицы на
        позициях (i-1, j), (i+1, j), (i, j-1), (i, j+1). У крайних символов соседний
        элемент находится с противоположной стороны матрицы.

        В случае одной строки/столбца элемент сам себе является соседом по соответствующему направлению.
        """
        matrix = []
        inStr = []
        # цикл ввода строк
        while 1:
            inStr = str(input())
            if inStr == 'end':
                break
            vStr = [int(k) for k in inStr.split()]
            matrix.append(vStr)

        mHeight = len(matrix)  # строк в матрице
        mWidth = len(matrix[0])  # столбцов в матрице
        result = []  # результат
        for row in range(mHeight):  # обход по строкам
            rRow = []  # строка результата
            for column in range(mWidth):  # обход по столбцам
                vLeft = matrix[row][column - 1]
                vRight = matrix[row][column - mWidth + 1]
                vUp = matrix[row - 1][column]
                vDown = matrix[row - mHeight + 1][column]
                rRow.append(vLeft + vRight + vUp + vDown)
            result.append(rRow)

        # печать результата
        for i in range(mHeight):
            print(*result[i])


    # sMatrix = [[9, 5, 3], [0, 7, -1], [-5, 2, 9]]
    # aMatrix = [[1]]
    # matrix_elite(sMatrix)
    # matrix_elite(aMatrix)

    def matrix_spirale(inNum):
        """
        2.6 Выведите таблицу размером n×n, заполненную числами от 1 до n^2
        по спирали, выходящей из левого верхнего угла и закрученной по часовой стрелке.
        """
        # inNum = int(input())
        # последовательность смены направлений обхода: 0-вправо, 1-вниз, 2-влево, 3-вверх
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        matrix = []
        for n in range(inNum):  # создаём матрицу, заполненную нулями
            matrix.append([0] * inNum)
        import copy
        filled = copy.deepcopy(matrix)  # копия нулевой матрицы для флагов заполненных ячеек
        dirNum = 0  # направление, начинаем вправо
        row = 0
        column = 0
        for num in range(1, inNum ** 2 + 1):  # заполняем матрицу по спирали
            matrix[row][column] = num  # значение в матрицу
            filled[row][column] = 1  # флаг заполнения
            nr = row + direction[dirNum][0]
            nc = column + direction[dirNum][1]
            # проверка, упёрлись ли в границу матрицы или в уже обработанное значение
            if not ((nc < inNum) and (nc >= 0) and (nr < inNum) and (nr >= 0) and (filled[nr][nc] == 0)):
                dirNum += 1  # смена направления
                if dirNum > 3: dirNum = 0
            row += direction[dirNum][0]  # следующие строка
            column += direction[dirNum][1]  # и столбец
        for mr in matrix:  # печать
            print(*mr)


    def function_def_value(x):
        """ 3.1 """
        if x <= -2:
            return 1 - (x + 2) ** 2
        elif -2 < x <= 2:
            return - x / 2
        else:
            return (x - 2) ** 2 + 1


    def modify_list(l):
        """
        3.1 принимает на вход список целых чисел, удаляет из него все нечётные значения, а чётные нацело делит на два
        """
        i = int(0)
        while i < len(l):
            if l[i] % 2 != 0:
                del l[i]
            else:
                l[i] = l[i] // 2
                i += 1


    def update_dictionary(d, key, value):
        """ 3.2 """
        if d.get(key) is None:
            if d.get(key * 2) is None:
                d[key * 2] = [value, ]
            else:
                d[key * 2].append(value)
        else:
            d[key].append(value)


    def unique_word_count(string):
        """ 3.2 выводить для каждого уникального слова в строке число его
        повторений (без учёта регистра) в формате "слово количество" """
        # string = str(input())
        dictWord = {}
        lw = list(w.lower() for w in string.split())
        for word in lw:
            dictWord[word] = dictWord.get(word, 0) + 1
        for key in dictWord.keys():
            print(key, dictWord[key])


    # unique_word_count("a aa abC aa ac abc bcd a")

    def f(x):
        """3.2"""
        return x * x


    def fun_save_f():
        """3.2"""
        count = int(input())
        saved = {}
        for k in range(count):
            vInput = int(input())
            if vInput in saved:
                # if saved.get(vInput) is not None:
                print(saved.get(vInput))
            else:
                rez = f(vInput)
                saved[vInput] = rez
                print(rez)


    def fun_de_pack():
        with open("/pythonHelp/VitaliyAntonov/pyBaseHelp/inputFile.txt") as ofile:
            inStr = ofile.readline()
        flag = 0
        symbol = ""
        number = ""
        outStr = ""
        symbol = inStr[0]
        for sym in inStr:
            if sym.isalpha():
                if flag != 0:  # считан символ и количество повторов
                    outStr += symbol * int(number)
                    number = ""
                    flag = 0
                    symbol = str(sym)
            elif sym.isdigit():
                number += sym
                flag = 1
        outStr += symbol * int(number)

        with open("/home/vitaliy/Desktop/result.txt", "w") as fSave:
            fSave.write(outStr)

        print(outStr)


    def parse_file(path):
        """
        выводит самое частое слово в этом тексте и через пробел то, сколько раз оно встретилось
        """
        with open(path) as ofile:
            inStr = ofile.read()
        import re
        listIn = re.split("[;|,|\n|.|)|(|’|‘ ]+", inStr)
        # listIn = inStr.split()

        for k in range(len(listIn)):  # приводим к нижнему регистру букв
            listIn[k] = listIn[k].lower()

        dictWord = {}  # словарь с количеством повторов для каждого слова в списке
        for word in listIn:
            dictWord[word] = dictWord.get(word, 0) + 1

        selectWord = ""
        countSelect = 0
        for word in dictWord.keys():
            if dictWord[word] > countSelect:
                countSelect = dictWord[word]
                selectWord = word
            elif dictWord[word] == countSelect:  # при одинаковом счётчике
                if selectWord > word:
                    selectWord = word

        print(dictWord)
        print(selectWord, countSelect)


    def student_rating(path):
        """3.4
        для каждого абитуриента записывает его среднюю оценку
        по трём предметам на отдельной строке,
        соответствующей этому абитуриенту, в файл с ответом.
        Также вычислите средние баллы по математике, физике и русскому языку
        по всем абитуриентам и добавьте полученные значения,
        разделённые пробелом, последней строкой в файл с ответом.
        """
        inData = []
        with open(path, 'r', encoding='utf-8') as fin:
            for line in fin:
                import re
                listIn = re.split("[;|,|\n|.|)|(|’|‘ ]+", line)
                listIn.remove('')
                inData.append(listIn)  # получен вложенный список вида:
                # [['Петров', '85', '92', '78'], ['Сидоров', '100', '88', '94'], ['Иванов', '58', '72', '85']]

        outList = str('')  # данные для вывода
        s1 = 0
        s2 = 0
        s3 = 0  # суммы оценок по предметам

        for student in inData:
            outList += str((int(student[1]) + int(student[2]) + int(student[3])) / 3) + "\n"
            s1 += int(student[1])
            s2 += int(student[2])
            s3 += int(student[3])

        num = len(inData)
        outList += str(s1 / num) + " " + str(s2 / num) + " " + str(s3 / num)

        with open("/home/vitaliy/Desktop/result.txt", "w") as fSave:
            fSave.write(outList)

        print(outList)


    # student_rating("/home/vitaliy/Desktop/inFile.txt")

    def circle(radius):
        """
        3.5
        подключает модуль math и, используя  pi из этого модуля,
        находит периметр этого круга
        """
        import math
        radius = float(input())
        print(2 * math.pi * radius)


    # circle(10)

    def console_script():
        """
        Напишите программу, которая запускается из консоли и печатает значения всех
        переданных аргументов на экран (имя скрипта выводить не нужно).
        Не изменяйте порядок аргументов при выводе.
        Для доступа к аргументам командной строки программы подключите
        модуль sys и используйте переменную argv из этого модуля.
        Пример работы программы:

        > python3 my_solution.py arg1 arg2
          arg1 arg2
        """
        import sys
        print(*sys.argv[1:])


    def download_file_num_rows(link):
        """ 3.6
        link - адрес другого файла, который нужно скачать с использованием модуля
        requests и посчитать число строк в нём.
        """
        import requests
        r = requests.get(link)
        inText = r.text

        # with open("/home/vitaliy/Desktop/result.txt", "w") as fSave:
        #     fSave.write(inText)

        lines = inText.splitlines()
        print("Строк: ", len(lines))
        for tag in lines:
            print(tag)


    # download_file_num_rows('https://stepic.org/media/attachments/course67/3.6.2/699.txt')


    def flast_in_str(instr, sym):
        """
        возвращает строку до последнего искомого символа включительно, из исходной строки
        :param instr: строка для преобразования
        :param sym:   искомый символ
        :return:
        """
        for cnt in range(-1, -len(instr), -1):
            if instr[cnt] == sym:
                return instr[:cnt + 1]


    def files_chain(link):
        """ 3.6
        Имеется набор файлов, каждый из которых, кроме последнего, содержит имя следующего файла.
        Первое слово в тексте последнего файла: "We".
        Скачайте предложенный файл. В нём содержится ссылка на первый файл из этого набора.
        Загрузите содержимое последнего файла из набора, как ответ на это задание.
        """
        import requests
        r = requests.get(link)
        inText = r.text
        lines = inText.splitlines()
        first_string = (lines[0].split())[0]  # первое слово в скачанном файле
        print(first_string)
        if first_string != "We":
            # формируем новый путь - заменяем имя файла в пути
            path = flast_in_str(link, "/") + first_string
            files_chain(path)  # рекурсивный вызов
        else:
            print("Строк: ", len(lines))
            for tag in lines:
                print(tag)


    # files_chain("https://stepic.org/media/attachments/course67/3.6.3/699991.txt")


    def football():
        """
        Формат ввода следующий:
        В первой строке указано целое число n — количество завершенных игр.
        После этого идет nn строк, в которых записаны результаты игры в следующем формате:
        Первая_команда;Забито_первой_командой;Вторая_команда;Забито_второй_командой

        Вывод программы необходимо оформить следующим образом:
        Команда:Всего_игр Побед Ничьих Поражений Всего_очков
        :return:
        """
        games = int(input())    # количество проведённых игр
        inData = []
        for n in range(games):  # таблица проведённых игр
            inData.append(str(input()).split(";"))
        outData = {}            # таблица вывода
        for inStr in inData:
            for nTag in range(0, 3, 2):
                if inStr[nTag] not in outData:
                    outData[inStr[nTag]] = [0, 0, 0, 0, 0]  # создаём строку вывода для команды
                outData[inStr[nTag]][0] += 1            # игр команды
                if int(inStr[nTag + 1]) > int(inStr[nTag - 1]):
                    outData[inStr[nTag]][1] += 1        # плюсуем победу
                    outData[inStr[nTag]][4] += 3        # плюсуем очки победы
                elif int(inStr[nTag + 1]) == int(inStr[nTag - 1]):
                    outData[inStr[nTag]][2] += 1        # ничья
                    outData[inStr[nTag]][4] += 1        # плюсуем очки
                else:   # поражение
                    outData[inStr[nTag]][3] += 1

        for cmd in outData.keys():
            strout = ""
            strout += cmd + ":"
            for d in outData[cmd]:
                strout += str(d) + " "
            print(strout)                   # печать


    def code_decode():
        """
        на вход две строки одинаковой длины, на первой строке записаны символы
        исходного алфавита, на второй строке — символы конечного алфавита,
        после чего идёт строка, которую нужно зашифровать переданным ключом,
        и ещё одна строка, которую нужно расшифровать
        :return:
        """
        source = [sim for sim in str(input())]
        code = [sim for sim in str(input())]
        toCode = [sim for sim in str(input())]
        toDecode = [sim for sim in str(input())]
        cipher = dict(zip(source, code))
        deCipher = dict(zip(code, source))
        strCode = ""
        for sym in toCode:
            strCode += cipher[sym]
        strDecode = ""
        for sym in toDecode:
            strDecode += deCipher[sym]
        print(strCode)
        print(strDecode)


    def dictionary():
        """ 3.7
        передаётся количество d известных нам слов, после чего на d строках
        указываются эти слова. Затем передаётся количество l строк текста для проверки,
        после чего l строк текста
        """
        dictCount = int(input())
        dictWord = []  # словарь
        for n in range(dictCount):
            dictWord += [s for s in str(input()).lower().split()]
        countStr = int(input())
        text = set()  # текст
        for n in range(countStr):
            iStr = set(s for s in str(input()).lower().split())
            text = text | iStr

        for word in text:
            if word not in dictWord:
                print(word)

        print("OK")


    def turtle():
        """ 3.7
        движение начинается в точке (0, 0), и движение на восток увеличивает первую координату,
        а на север — вторую.
        На вход число команд n, которые нужно выполнить черепашке,
        после чего n строк с самими командами. Вывести нужно два числа в одну строку:
        первую и вторую координату конечной точки черепашки. Все координаты целочисленные.
        """
        num = int(input())
        x = 0
        y = 0
        for n in range(num):
            step = [s for s in str(input()).split()]
            if step[0] == "север":
                y += int(step[1])
            elif step[0] == "юг":
                y -= int(step[1])
            elif step[0] == "восток":
                x += int(step[1])
            elif step[0] == "запад":
                x -= int(step[1])

        print(x, y)


    def student_growth(path):
        """ 3.7 """
        inData = []
        with open(path, 'r', encoding='utf-8') as fin:
            for line in fin:
                import re
                listIn = re.split("[;|,|\n|.|)|(|’|‘|\t| ]+", line)
                listIn.remove('')
                inData.append(listIn)

        out = [[d, 0, 0] for d in range(1, 12)]
        """результат: номер класса, суммарный рост, количество учеников"""
        for dstr in inData:
            out[int(dstr[0]) - 1][1] += int(dstr[2])
            out[int(dstr[0]) - 1][2] += 1

        for outstr in out:
            if outstr[2] == 0:
                print(str(outstr[0]), "-")
            else:
                print(str(outstr[0]), str(outstr[1] / outstr[2]))

        print("OK")

    # student_growth("/home/vitaliy/Desktop/inFile.txt")

    # 3.8 Библиотеки для анализа данных. NumPy
    def lib_numpy():
        """
        если вы используете pip:
        проверить что нужный пакет установлен:
        pip show имя_пакета
        установить если не установлен:
        pip install numpy
        pip install matplotlib
        библиотеки:
        1. Numpy - работа с числовыми значениями
        https://numpy.org/
        2. Matplotlib - построение графиков
        https://matplotlib.org/
        3. SciPy - функции для научных вычислений
        https://www.scipy.org/
        4. pandas - таблицы (как matrix и data.frame в R)
        https://pandas.pydata.org/
        5. Scikit-learn - алгоритмы машинного обучения
        https://scikit-learn.org/stable/
        6. PythonSeaborn - визуализация статистических данных
        https://seaborn.pydata.org/
        """
        import numpy as np

        a = np.array([1, 2, 3, 4, 5, 6])

        s = 0
        cnt = int(input())
        for n in range(cnt):
            s += int(input())

        print(s)


    print("OK")
