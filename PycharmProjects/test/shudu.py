import sys
def colm(m):
    col=[]
    for i in range(9):
        col.insert(i,[])
        for j in range(9):
            col[i].append(m[i][j])
    return col
def check(m):
    flag = True
    print "check!!!"
    # if m[6][7]==9:
    #     sys.exit()
    for i in range(9):
        if len(set(m[i]))!=9:
            flag =False
            return flag
        if len(set(colm(m)[i]))!=9:
            flag=False
            return flag
    return flag

def trycheck(m):
    flag = True
    print "trycheck!!!"
    # if m[6][7]==9:
    #     sys.exit()
    for i in range(9):
        for j in range(9):
            if m[i][j]!=0:
                if m[i].count(m[i][j])>1:
                    flag =False
                    return flag
    for i in range(9):
        for j in range(9):
                if colm(m)[i][j] != 0:
                    if colm(m)[i].count(colm(m)[i][j]) > 1:
                        flag = False
                        return flag
    return flag

def possibe(newdata,position):
    result=[]
    for i in range(len(position)):
            possible1=set([1,2,3,4,5,6,7,8,9])-set(newdata[position[i][0]])
            nopossible1=set([newdata[x][position[i][1]]for x in range(9)])
            possible1=possible1-(nopossible1&possible1)
            possible1=list(possible1)
            possible2=set([1,2,3,4,5,6,7,8,9])-set([newdata[x][position[i][1]]for x in range(9)])
            nopossible2=set(newdata[position[i][0]])
            possible2=possible2-(nopossible2&possible2)
            possible2=list(possible2)
            result.append(list(set(possible1+possible2)))
    return result

def tryit(m,x,y,r):
    for j in range(len(r)):
        m[x][y]=r[j]
        if check(m):
            return True
    return False

def updateposition(datas):
    position=[]
    for i in range(9):
        for j in range(9):
            if datas[i][j] == 0:
                position.append([i, j])
    return position

def wether(newdata,position,result):
    print len(result),result
    tmppossibe=result
    tmpdata=newdata
    tmpposition=position
    for i in tmpposition:
        if len(i)==2:
            index=tmpposition.index(i)
            tmp=[result[index][0],result[index][1]]
            tmppossibe[index] = [tmp[0]]
            # newdata[position[index][0]][position[index][1]]=tmppossibe[index][0]
            while trycheck(tmpdata):
                tmpdata=updatedatas(tmpdata,position,tmppossibe)
                tmpposition=updateposition(tmpdata)
                tmppossibe = possibe(tmpdata, tmpposition)
                if check(tmpdata):
                    return True,tmpdata,tmpposition,tmppossibe
                if len(tmpposition)==0:
                    break
                for i in  tmpdata:
                    print i
                print len(tmpposition),tmpposition
                print len(tmppossibe),tmppossibe
                flag=False
                for x in range(len(tmppossibe)):
                    if len(tmppossibe[x])==0:
                        flag=True
                print flag
                if flag:
                   break
            # while not check(newdata):

            print index,len(result),tmp,result
            result[index] = [tmp[1]]
            # newdata[position[index][0]][position[index][1]] = tmppossibe[index][0]
            newdata = updatedatas(newdata, position, result)
            position = updateposition(newdata)
            tmppossibe = possibe(newdata, position)
            print newdata
            print position
            print tmppossibe
            return False,newdata,position,tmppossibe
    return False,newdata,position,tmppossibe



def updatedatas(newdata,position,result):
    newdatas=newdata
    fuck = [len(x) for x in result]
    for i in range(len(fuck)):
        flag = True
        if fuck[i] == 1:
            print newdatas
            print position
            newdatas[position[i][0]][position[i][1]] = result[i][0]
            flag = False
    return newdatas
# while True:
#     try:
newdata=[]
position=[]
for i in range(9):
    data=map(lambda i:int(i),raw_input().split(" "))
    for j in range(len(data)):
        if data[j] == 0:
            position.append([i,j])
    newdata.append(data)
print newdata
print position
result=possibe(newdata,position)
print result
fuck=[len(x) for x in result]
print len(position),len(result),len(fuck)
print fuck
# for i in range(len(position)):
#      flag = tryit(newdata,position[i][0],position[i][1],result[i])
#      print flag
while not check(newdata):
    for i in  newdata:
        print  i
    print position
    position = updateposition(newdata)
    result = possibe(newdata, position)
    print result
    fuck = [len(x) for x in result]
    print len(position), len(result), len(fuck)
    print fuck
    flag = True
    for i in range(len(fuck)):
        if fuck[i] == 1:
            newdata[position[i][0]][position[i][1]] = result[i][0]
            flag=False
    if flag:
        flag1,newdata, position, result=wether(newdata,position,result)
        if  flag1:
            break
        else:
            newdata = updatedatas(newdata, position, result)
            position = updateposition(newdata)
            result =possibe(newdata,position)
if check(newdata):
    for i in range(len(newdata)):
        print newdata[i][0],newdata[i][1],newdata[i][2],newdata[i][3],newdata[i][4],newdata[i][5],newdata[i][6],newdata[i][7],newdata[i][8]
    # except EOFError:
    #         break

