from requests import get
url_0 = open('/home/petrovich/Downloads/dataset_3378_3 (2).txt')
print('url_0', url_0)
url_0.readline().strip()
print('url_0', url_0)
url_0.close()
#print('url_0', url_0)#u r l _ 0 <_io.TextIOWrapper name='/home/petrovich/Downloads/dataset_3378_3 (2).txt' mode='r' encoding='UTF-8'>
print('url_0', url_0)

obl = get(url_0)
print('obl.text', obl.text) # Печать ответа на запрос в виде текста
z = 0
while not obl.text.startswith('We'):#line[:3] != 'We ':
    print(z, 'Wh obl.text', obl.text)  # Печать ответа на запрос в виде текста
    z +=1
    line = get('https://stepic.org/media/attachments/course67/3.6.3/' + obl.text)
    print('line-', line)
    continue
'''
from IPython.display import clear_output

{Заголовок цикла}:
    {Тело цикла - считывание очередного файла}
    clear_output(wait=True) # очистка экрана от предыдущего результата считывания
    print(next_file) # показ на экране результата последнего считывания
'''
'''
from requests import get
#with open("dataset_3378_3.txt", "r") as inf:
with open("/home/petrovich/Downloads/dataset_3378_3 (2).txt", "r") as inf:
    line = inf.readline().strip()# Строка из файла
    print('line-', line)
    obl = get(line)
    #print('line = get', line)
    print('obl.text', obl.text) # Печать ответа на запрос в виде текста
    #print(line[:3])
    #print(line[0].strip())
    z = 0
    while not obl.text.startswith('We'):#line[:3] != 'We ':
    #while not line.startswith('We'):
        #print('get(line)', get(line))

        #print('line = get', obl)#<Response [200]>
        print(z, 'Wh obl.text', obl.text)  # Печать ответа на запрос в виде текста
        z +=1
        #lien.append(obl.text)#213837.txt
        #print('line.text', line.text)  # Печать ответа на запрос в виде текста # AttributeError: 'str' object has no attribute 'text'
        #s = requests.get('https://stepic.org/media/attachments/course67/3.6.3/' + s.text)
        line = get('https://stepic.org/media/attachments/course67/3.6.3/' + obl.text)
        print('line-', line)
        line = line().strip()
        print('line-', line.text)
        obl = get([line])
        print('WL', line.text)
        continue
    #print('line.text', line.text)  # Печать ответа на запрос в виде текста
    #obl = get(line) # Запрос по строке из файла
    print(inf.readlines())#['/home/petrovich/PycharmProjects/pythonProject/pythonHelp/PetrovichIgor/3-я Неделя/TESTdataset.txt\n', 'We f,hf\n', 'rflf,hf']
    #print(inf)#<_io.TextIOWrapper name='dataset_3378_3.txt' mode='r' encoding='UTF-8'>
    print(*inf.readlines())
    print('obl.text', obl.text)

from IPython.display import clear_output

{Заголовок цикла}:
    {Тело цикла - считывание очередного файла}
    clear_output(wait=True) # очистка экрана от предыдущего результата считывания
    print(next_file) # показ на экране результата последнего считывания
'''
