with open('dataset_3363_4.txt') as t:
    s = []
    i = 0
    while True:
        a = t.readline()
        if a == '': break
        s.append(a.strip().split(';'))
        i += 1

with open('data.txt','a') as tt:
    for i in range(len(s)):
        tt.write(str(round((int(s[i][1]) + int(s[i][2]) + int(s[i][3])) / 3, 9)) + '\n')
a1, a2, a3 = 0, 0, 0
for i in range(len(s)):
    a1 += (int(s[i][1]))
    a2 += (int(s[i][2]))
    a3 += (int(s[i][3]))

with open('data.txt','a') as tt:
    tt.write(str(round(a1/len(s), 9))+' '+str(round(a2/len(s), 9))+' '+str(round(a3/len(s), 9)))


