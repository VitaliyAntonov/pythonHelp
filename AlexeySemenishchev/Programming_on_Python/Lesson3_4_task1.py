#Восстановление исходной строки обратно
file_name_in = "dataset_3363_2.txt"
file_name_out = "out.txt"

#Чтение из файла
inf = open(file_name_in, 'r')
s1 = inf.readline().strip()
inf.close()

i = 0
l = len(s1)
#Запись в файл
ouf = open(file_name_out, 'w')
while i < l:
    c = s1[i]
    i += 1
    val_str = ''
    while '0' <= s1[i] <= '9':
        val_str += s1[i]
        i += 1
        if i >= l:
            break
    val_int = int(val_str)
    for j in range(val_int):
        ouf.write(c)
ouf.close()