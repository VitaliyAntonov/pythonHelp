inf = open('/home/petrovich/Downloads/dataset_3363_4 (8).txt')
#inf = open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/Prover003.txt')
s = inf.readline().strip().split(';')  # ['Youmans', '59', '83', '45']
#s = inf.readlines()# ['Youmans;59;83;45\n', 'Larkins;55;44;31\n', 'Lawman;24;33;32\n',..., 'Bradberry;46;99;39\n']
lst, i, mat, fiz, rus = [], 0, 0, 0, 0
while s != ['']:
    #print('s=', s)

    #lst += s
    #print('lst=', lst)
    sri = round(((float(s[1])+float(s[2])+float(s[3]))/3), 9)

    with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/rez3_4_3 (8).txt', 'a') as rez:
        rez.write(str(sri)+'\n')# (round(sri),9)
    #print(sri)
    mat += float(s[1])
    fiz += float(s[2])
    rus += float(s[3])
    i += 1
    #print(mat, fiz, rus, i)
    s = inf.readline().strip().split(';')  # ['Youmans', '59', '83', '45']
#print(mat/i, fiz/i, rus/i)
srm = round((mat/i), 9)
srf = round((fiz/i), 9)
srr = round((rus/i), 9)
#print(srm, srf, srr)
with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/rez3_4_3 (8).txt', 'a') as rez:
    rez.write(str(round((mat/i), 9))+' '+str(round((fiz/i), 9))+' '+str(round((rus/i), 9))+'\n')
