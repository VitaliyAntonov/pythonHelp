from requests import get
#inf = open('/home/petrovich/Downloads/dataset.txt')
#inf = open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/Prover004.txt')
#with open("/home/petrovich/Downloads/dataset_3378_2 (1).txt", "r") as inf:
with open('/home/petrovich/Downloads/dataset_3378_3.txt', 'r') as inf:
    line = inf.readline().strip()# Строка из файла
    print('line-', line)
    obl = get(line) # Запрос по строке из файла
    print('obl.text', obl.text) # Печать ответа на запрос в виде текста
    rez = len(obl.text.splitlines())
    print('obl-', obl)
    #print('obl.splitlines()', obl.splitlines())
    print('obl.text.splitlines()-', obl.text.splitlines())
    print(rez)
    '''with open("dataset.txt", "r") as inf:
        line = inf.readline().strip()'''
