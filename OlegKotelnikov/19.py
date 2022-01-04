t = input()
x = 1
p = ""
for n in range (len(t)-1):
    if t[n+1] == t[n]:
        x += 1
    else:
        p = p + (t[n]) + str(x)
        x = 1
p = p + (t[len(t)-1]) + str(x)
print(p)