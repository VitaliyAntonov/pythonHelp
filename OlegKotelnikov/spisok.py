with open('dataset_3363_4.txt') as t:
    s = []
 #   a = sum(1 for _ in t)
    for i in t:
  #      s.append(t.readline(i).strip().split(';'))
        s.append(i)
#print(s)
for i in range(len(s)):
#    print((int(s[i][1]) + int(s[i][2]) + int(s[i][3]))/3)
    print(s[i][0], (int(s[i][1]) + int(s[i][2]) + int(s[i][3]))/3)
a1, a2, a3 = 0, 0, 0
for i in range(len(s)):
    a1 += (int(s[i][1]))
    a2 += (int(s[i][2]))
    a3 += (int(s[i][3]))
print(a1/len(s), a2/len(s),a3/len(s))