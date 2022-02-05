import requests
#программа нахождения количества строк с использованием GET-запроса
file_name_in = "dataset_3378_2.txt"
file_name_out = "out.txt"

#открываем файл для чтения и запоминаем ссылку, находящуюся в нем
inf = open(file_name_in, 'r')
line = inf.readline().strip()
inf.close()

#находим количество строк в тексте и записываем в файл
r = requests.get(line)
kol = len(r.text.splitlines())
print(kol)
with open(file_name_out, 'w') as ouf:
    ouf.write(str(kol))
