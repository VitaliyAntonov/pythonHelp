#ввод чисел в список пока не встретится буквенный символ
c = []
while True:
    a = input().split()
    for i in range(len(a)):
        if a[i].isalpha():
            print(c)
            a = []
            break
    c.append(list(map(int, a)))


