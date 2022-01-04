import time

def numbers_range(n):
    for i in range(1, n + 1):
        yield i

print('Таймер', end=' ')
a = numbers_range(int(input('на сколько секунд? ')))
#a = (int(input('на сколько секунд? ')))

for b in a:
    print(b, end='')
    time.sleep(1)
    print('  ', end='\r')
