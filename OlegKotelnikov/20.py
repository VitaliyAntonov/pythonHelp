nameZ = {'global': ['',[],[]]}

def find_NS(name, var):
    if var in nameZ[name][2]:
        return name
    if name != 'global':
        return find_NS(nameZ[name][0], var)

for i in range(int(input())):
    order, name_sp, arg = input().split()
    if order == 'create':
        nameZ[arg][1].append(name_sp)
        nameZ[name_sp] = [arg, [], []]
    if order == 'add':
        nameZ[name_sp][2].append(arg)
    if order == 'get':
        print(find_NS(name_sp, arg))