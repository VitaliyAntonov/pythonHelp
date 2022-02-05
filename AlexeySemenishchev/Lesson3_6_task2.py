#программа перебора файлов с использованием GET-запроса
import requests

url = "https://stepic.org/media/attachments/course67/3.6.3/"

file_name_in = "dataset_3378_3.txt"
file_name_out = "out.txt"

#открываем файл для чтения и запоминаем ссылку файла, находящуюся в нем
with open(file_name_in, 'r') as inf:
    line = inf.readline().strip()

#перебираем файлы с использованием GET-запросов до тех пор, пока первое слово в этом файле не будет "We"
while True:
    r = requests.get(line)
    file_name_requests = r.text
    S = file_name_requests.split()
    if S[0] == "We":
        ouf = open(file_name_out, 'w')
        ouf.write(file_name_requests)
        ouf.close()
        print(file_name_requests)
        break
    else:
        line = url + file_name_requests
