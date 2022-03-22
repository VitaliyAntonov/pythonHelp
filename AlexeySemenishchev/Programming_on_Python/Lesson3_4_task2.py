#Максимально используемое слово в тексте
file_name_in = "dataset_3363_3.txt"
file_name_out = "out.txt"

stroka = ""
spisok = []
with open(file_name_in, "r") as inf:
    for line in inf:
        line = line.strip()
        stroka = stroka + line + ' '
stroka = stroka.strip().lower()

#создаем список слов и составляем их в алфавитном порядке
spisok = [c for c in stroka.split()]
spisok.sort()

"""создаем два списка: ключ и его значение. Это имитация словаря. Имитируем словарь с помощью списков, 
так как словарь нельзя упорядочить, а список можно. (если слов окажется одинаковое количество,
то нужно вывести максимально используемое слово первое по алфавиту)"""
spisok_key = []
spisok_value = []

l = len(spisok)
k = 1         #счетчик одного используемого слова
for i in range(1, l):
    if spisok[i] == spisok[i - 1]:
        k += 1
    else:
        spisok_value.append(k)
        spisok_key.append(spisok[i - 1])
        k = 1
spisok_value.append(k)
spisok_key.append(spisok[-1])

max_value = max(spisok_value)
max_ind = spisok_value.index(max_value)

ouf = open(file_name_out, "w")
ouf.write(str(spisok_key[max_ind]) + " " + str(max_value))
ouf.close()

print(spisok_key[max_ind], max_value)
