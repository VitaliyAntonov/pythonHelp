n= int(input())# put your python code here
#if 0<=n<=1000:
if n%10==0 or 5<=n%100<=20 : print(n,'программистов')
elif  n%10==1  :print(n,'программист')#or n%1000==1
elif 2<=n%10<=4 and n%10!=11 and n%10!=12 and n%10!=13 and n%10!=14:print(n,'программиста')
elif 5<=n%10<=9: print(n,'программистов')
#else: print ('вне интервала')