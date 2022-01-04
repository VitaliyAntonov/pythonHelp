a = int(input())
b = int(input())

def nod(n):
  nd = []
  for m in range(2,n+1):
    while n%m == 0:
      n = n / m
      nd.append(m)
  return nd

def od(x,y):
  c = list(set(x) & set(y))
  return c

list(set(x) & set(y))
print(od(nod(a),nod(b)))