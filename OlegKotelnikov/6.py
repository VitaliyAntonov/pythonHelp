import keyword
print('список ключевых слов')
for i in range(len(keyword.kwlist)):
    e = '\n' if i % 5 == 4 else ' / '
    print(keyword.kwlist[i], end=e)
print()
print('*--*--'*25)
print()
import builtins
print('список встроенных идентификаторов')
for i in range(len(dir(builtins))):
    e = '\n' if i % 5 == 4 else ' / '
    print((dir(builtins)[i]), end=e)