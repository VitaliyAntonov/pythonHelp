#программа успеваемости абитуриентов
file_name_in = "dataset_3363_4.txt"
file_name_out = "out.txt"

spisok = []

mathematics = 0
physics = 0
Russian = 0
i = 0

inf = open(file_name_in, "r")
ouf = open(file_name_out, "w")
for line in inf:
    line = line.strip()
    spisok = [c for c in line.split(';')]

    spisok[1] = int(spisok[1])
    spisok[2] = int(spisok[2])
    spisok[3] = int(spisok[3])

    mathematics += spisok[1]
    physics += spisok[2]
    Russian += spisok[3]
    i += 1
    average = (spisok[1] + spisok[2] + spisok[3]) / 3

    print(average)
    ouf.write(str(average) + '\n')
inf.close()

mathematics /= i
physics /= i
Russian /= i
print(mathematics, physics, Russian)
ouf.write(str(mathematics) + ' ' + str(physics) + ' ' + str(Russian) + ' ')
ouf.close()


