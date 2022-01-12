import requests
with open('dataset_3378_2.txt') as t:
    r = requests.get(t.readline().strip())
    print(r)
with open('data.txt', mode='a') as t:
    t.write(str(len(r.text.splitlines())))
    print(str(len(r.text.splitlines())))
    #strip().