for a in range(10, 60):
    aa = a ** 5
    for b in range(50, 90):
        bb = b ** 5
        for c in  range(80, 110):
            cc = c ** 5
            for d in range(100, 140):
                dd = d ** 5
                for e in range(110, 150):
                    ee = d ** 5
                    if aa + bb + cc + dd == ee:
                        print(a+b+c+d+e)