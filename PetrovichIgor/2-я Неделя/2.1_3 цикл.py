i, z = 0, 0
while i < 5:
    print('*')
    z += 1
    if i % 2 == 0:
        print('**')
        z += 2
    if i > 2:
        print('***')
        z += 3
    i = i + 1
print(z)