a = input()
c = int(a[-1])
if len(a) > 1:
    cc = int(a[-2]+a[-1])
else:
    cc = c
if (c == 1) and (cc != 11):
     x = "программист"
elif c == 0 or 5 <= c <= 9 or 11 <= cc <= 14:
     x = "программистов"
else:
     x = "программиста"
print(a + " " + x)
