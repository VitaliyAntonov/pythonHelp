b=input()# put your python code here
b1 = b[0]
b2 = ((int(b)//10000)%10)
b3 = b[2]
b4=((int(b)//100)%10)
b5=(int(b)%100)//10
b6=b[-1]
if int(b1)+b2+int(b3)==b4+b5+int(b6):print("Счастливый")
else:print('Обычный')