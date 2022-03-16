P= input()
if P=='треугольник':
    [[print((p * (p - a) * (p - b) * (p - c))**0.5) for p in [(a + b + c) / 2]] for a, b, c in [[int(input()) for _ in 'abc']]]
elif P=='прямоугольник':
    [print(a*b) for a, b in [[int(input()) for _ in 'ab']]]
elif P=='круг':
    print(3.14*float(input())**2)