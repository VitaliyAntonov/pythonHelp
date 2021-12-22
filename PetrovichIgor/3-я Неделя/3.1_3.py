lst = [-2, 2, 3, 3, 5, -0, 4, 5, 7, 6]
#print(modify_list(lst))  # None
#print(lst)
def modify_list(l):# put your python code here
    l=lst#[int(i) for i in input().split()]
    d=len(lst)
    i=0
    for j in range(d):#while j<=d:
        j-=i
        #print(lst[j])
        if lst[j]%2==0: lst.append(int(lst[j]/2));lst.pop(j);i+=1
        else:
            lst.pop(j);i+=1
    return lst
#lst = [1, 2, 3, 4, 5, 6]
print(modify_list(lst))
print(modify_list(lst))  # None
print(modify_list(lst))
#print(l)