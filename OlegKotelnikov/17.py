koll, a1, b1, c1 = 0, 0, 0, 0
with open('dataset_3363_4.txt', 'r') as inf:
    for line in inf:
        line = line.strip().split(';')
        a, b, c = int(line[1]), int(line[2]), int(line[3])
        print(line[0], (a+b+c)/3)
        koll += 1
        a1 += a
        b1 += b
        c1 += c
print((a1/koll), (b1/koll), (c1/koll))