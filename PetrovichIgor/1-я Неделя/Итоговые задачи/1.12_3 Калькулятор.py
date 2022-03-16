x=float(input())# put your python code here
y=float(input())
d=input()#(mod>=%,pow>=**,div>=//)
#R=()
if d=='pow':print(x ** y)# R=x**y
elif d=='*':print(x * y) #R=x*y
elif d=='+':print(x + y) #R=x+y
elif d=='-':print(x - y)# R=x-y
elif d=='mod' and y!=0:print(x % y) #R=x%y
elif d=='div'and y!=0:print(x // y) #R=x//y
elif d=='/' and y!=0:print(x / y) #R=x/y
#print(R)
else:
  print("Деление на 0!")