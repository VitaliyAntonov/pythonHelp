a,b,c,=[int(input()) for _ in 'abc']# put your python code here
if b<=a>=c: print(a);Ma=a
elif a<=b>=c: print(b);Ma=b
else: print(c);Ma=c
if a>=b<=c: Mi=b;print(b)
elif b>=a<=c: Mi=a;print(a)
else: print(c);Mi=c
if Ma>c>Mi:print(c)
elif Ma>b>Mi:print(b)
elif Ma>a>Mi:print(a)
elif a==b:print(b)
elif b==c:print(c)
else: print(a)