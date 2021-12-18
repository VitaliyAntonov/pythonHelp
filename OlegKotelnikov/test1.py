def numbers_range(n):
    for i in range(n):
        yield i
a = numbers_range(4)
print(type(a))
for b in a:
    print(b)