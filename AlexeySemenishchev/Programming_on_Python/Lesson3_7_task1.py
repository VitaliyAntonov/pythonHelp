#программа нахождения среднего роста учащихся
file_name_in = "dataset_3380_5.txt"
file_name_out = "out.txt"

count_class = 11
S_height = [0] * count_class
S_cl = []

#открываем файл для чтения и запоминаем данные учащихся в списки:
#1) сколько всего учащихся в каждом из классов (для того, чтобы затем найти средний рост учащихся в каждом из классов)
#2) рост всех учащихся суммарно в каждом из классов
with open(file_name_in, 'r') as inf:
    for line in inf:
        line = line.strip()
        cl, sur, height = line.split('\t')      #номер класса, фамилия и рост учащегося через пробел
        cl = int(cl)
        height = int(height)
        S_cl.append(cl)
        S_height[cl - 1] += height

#находим средний рост учащихся путем деления на количество учащихся в каждом из классов и записываем в файл
ouf = open(file_name_out, 'w')
for i in range(count_class):
    if S_height[i] == 0:
        print(i + 1, '-')
        ouf.write(str(i + 1) + ' -\n')
    else:
        S_height[i] /= S_cl.count(i + 1)
        print(i + 1, S_height[i])
        ouf.write(str(i + 1) + ' ' + str(S_height[i]) + '\n')
ouf.close()
