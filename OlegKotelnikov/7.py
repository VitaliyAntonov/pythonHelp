t = 1
c = []
while t:
    a = input().split()
    if 'end' in a:
        t = 0
    else:
        c.append(list(map(int, a)))
print(c)
v = []
x = c
# ------------------------------------
for n in range(len(c)):
    nl, nr = n - 1, n + 1
    if n == 0:
        nl = (len(c) - 1)
    elif n == len(c) - 1:
        nr = 0
    else:
        nl, nr = n - 1, n + 1
    for i in range(len(c[0])):
        iu, id = i - 1, i + 1
        if i == 0:
            iu = (len(c[0]) - 1)
        elif i == len(c[0]) - 1:
            id = 0
        else:
            iu, id = i - 1, i + 1
        x = c[nl][i] + c[nr][i] + c[n][iu] + c[n][id]
        v.append(x)

print(v) 