so = []
with open('/home/petrovich/Downloads/dataset_3363_3 (2).txt') as inf:
     s = inf.readlines()#.split().strip()#.split()
     print(s)
     if so == []:
        #s = inf.readline().split() #.strip()
        #print(s)
     #while s == '':
        for sx in s:
        #sx.lower()
            so += sx.strip(' \n').split( )#.lower();print(so)
     #continue # s = inf.readline().split()#.strip()
so.sort()
print(so)
i, y, Mi, sr, sxy, d = 0, 0, 1, [], so[0], {}
cz = len(so)
for sy in so:
    #print(sy)
    #sr += sy
    if sxy.lower() == sy.lower():
        #print(Mi, sxy, '==', sy)
        i += 1
        y += 1
        #print('y=',y,'/',cz)
        if y == cz:
            #print('fin', Mi, i)
            i += 1
            if Mi == i:
                #print('if Mi == i:', Mi, '==', i)
                if d.get(Mi) == None:
                    d[Mi] = [sxy]  # ; print(d)#; return
                else:
                    d[Mi] += [sxy] * i
        continue
    #print(sxy, i)
    #sxy = sy
    #print(Mi, sxy, 'i=', i, sy)
    #print('if', Mi, '>', i, ':')
    if Mi > i:
        #print('continue', Mi, '>', i)
        i = 1
        y += 1
        sxy = sy
        continue
    #print('if Mi == i:', Mi, '==', i)
    #print(Mi, sxy, '-', i, sy)
    if Mi == i:
        #print('if Mi == i:', Mi, '==', i)
        if d.get(Mi) == None:
            d[Mi] = [sxy]  # ; print(d)#; return
            i = 1
            y += 1
            sxy = sy
        else:
            d[Mi] += [sxy]*i  # ; print(d)#; return
            i = 1
            y += 1
            sxy = sy        #return
    #print('else', Mi, sxy, 'i=', i, sy)
    else:
        Mi = i
        #print('else', Mi, '=', i)
        d = {}
        if d.get(Mi) == None:
            d[Mi] = [sxy]*i  # ; print(d)#; return
            i = 1
            y += 1
            #sxy = sy
        #d[Mi].append(sxy)
        i = 1
        y += 1
        sxy = sy
        #print(d[Mi])
    #print(Mi)
        #sr += sy + ' ' + i
sr = d[Mi]
#print(d[Mi])
sr.sort()
#print(sxy, i)
print(sr[0], Mi)
#zap = d[Mi:0]
#print(zap)
with open('/home/petrovich/Soft/pycharm-community-2021.3/TiachDonload/rez4_2.txt', 'w') as rez:
    rez.write(sr[0]+' '+str(Mi))
