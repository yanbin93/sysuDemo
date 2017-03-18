# def long(self,index):
#     return self[index:]+self[:index]
# import sys
# data=map(lambda  x:int(x.split("\n")[0]),sys.stdin.readlines())
# for j in data:
#     num=range(j)
#     i=0
#     while len(num) >2:
#         i=i+2
#         num.remove(num[i])
#         if len(num[i:])<3:
#             num=long(num,i)
#             i=0
#     if len(num)==2:
#         print num[1]
#     else:
#         print num[0]
def cmper(x,y):
    m=(x[0]=="j")|(x[0]=="J")
    n=(y[0]=="j")|(y[0]=="J")
    for i in range(1):
        if len(x)==11:
            return x
        if len(y)==11:
            return y
        if (len(x)==7)&(len(y)==7):
            return [x,x,y][cmp(x,y)]
        if (len(x)==7)&(len(y)!=7):
            return x
        if (len(y)==7)&(len(x)!=7):
            return y
        if (len(x) == 9) & (len(y) == 9):
            return [x, x, y][cmp(x, y)]
        if len(x)==5&len(y)==5:
            if (x=="joker")&(y=="JOKER"):
                return y
            if (y=="joker")&(x=="JOKER"):
                return x
            if (not m) & (not n):
                return [x, x, y][cmp(x, y)]
        if (len(x)==3)&(len(y)==3):
            return [x,x,y][cmp(x,y)]
        if (len(x)==1&n):
            return y
        if (len(y)==1&m):
            return x
        if (len(x)==1)&(len(y)==1):
            return [x,x,y][cmp(x,y)]
        return '0'
import sys
datas=map(lambda x:x[:-1].split("-"),sys.stdin.readlines())
for data in datas:
    for i in range(2):
        data[i]=data[i].replace('10','I')
        data[i]=data[i].replace('A','Y')
        data[i]=data[i].replace('2','Z')
    data=list([cmper(data[0],data[1])])
    data=[i.replace('I','10') for i in data]
    data=[i.replace('Y', 'A') for i in data]
    data=[i.replace('Z', '2') for i in data]
    if data[0]=='0':
        print "ERROR"
    else:
        print data[0]