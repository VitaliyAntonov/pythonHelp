s = 'abcdefghijk'
s[3:6]
s[:6]
s[3:]
print(s[-1:-10:-2])

t = input().lower()
i = 0
n = 0
x = 1
for n in range (len(t)):
    while t[i] == t[x] and x < len(t):
        x += 1

    print(t[i:x]+str(x-i), sep='', end='')


