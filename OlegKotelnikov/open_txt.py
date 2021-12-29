with open('dataset_3363_2.txt') as t:
    s = t.readline().strip()
def rep(symbol, iter): return symbol*int(iter)
i = 0
while i < len(s):
    iter = ''
    if s[i].isalpha():
        symbol = s[i]
        i += 1
        while s[i].isdigit():
            iter += s[i]
            if i == len(s)-1: break
            i += 1
        print(rep(symbol, iter),end='')
