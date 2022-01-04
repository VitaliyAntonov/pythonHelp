with open('dataset_3363_2.txt') as t:
    s = ''
    q = {}
    for _ in range(9):
        s += (t.readline().strip())
s = s.lower().split()
s.sort()

for i, e in enumerate(s):
    q.setdefault(s[i],s.count(e))
m = max(q.values())

for key, value in q.items():
    if m == value:
        print(key, m)
        break




#print(q.keys(m))
#print(q.keys(max(q.values())))

#print(len(s))
#print(s)

