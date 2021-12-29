n = int(input())
if n % 10 == 1 and n % 100 not in range(5, 21):
    print(n, 'программист')
elif n % 10 in range(2, 5) and n % 100 not in range(5, 21):
    print(n, 'программиста')
elif n % 100 in range(5, 21) or n % 10 == 0 or n % 10 in range(5, 10):
    print(n, 'программистов')
#------------------------------------
num = input()

def nes(var):
    return num.endswith(var)

if nes("1") and not nes("11"):
    print(num, "программист")
elif (nes("2") or nes("3") or nes("4")) \
        and not (nes("12") or nes("13") or nes("14")):
    print(num, "программиста")
else:
    print(num, "программистов")
#----------------------------------------
print(('Обычный', 'Счастливый')[(lambda li: sum(li[:3]) == sum(li[-3:]))(list(map(int, input())))])
#----------------------------------------
n = [int(i) for i in input()    ]
print('Счастливый' if sum(n[3:]) == sum(n[:3]) else 'Обычный')