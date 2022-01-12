import requests
addr = 'https://stepic.org/media/attachments/course67/3.6.3/'
with open('dataset_3378_3.txt') as t:
    r = t.read().strip()
while True:
    r1 = requests.get(r)
    if r1.text.startswith('We'):
        print(r1.text)
        break
    else:
        r = addr+r1.text

#--------------
import requests
url, name = 'https://stepic.org/media/attachments/course67/3.6.3/', '699991.txt'
while name[:2] != 'We':
    name = requests.get(url + name).text
print(name)






