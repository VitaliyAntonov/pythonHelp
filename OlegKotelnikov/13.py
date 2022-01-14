n = 0
for b in range(10):
    for c in range(20):
        for t in range(200):
            if b * 10 + c * 5 + t * 0.5 == 100 and b + c + t == 100:
                print(b, '- быков,', c, '- коров,', t, '- телят')
                n += 1
print(n)