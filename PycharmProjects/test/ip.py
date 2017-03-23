def mip(x):
    if 256 in x:
        return False
    x="".join([totwo(i) for i in x])
    if (x=="1"*32)|(x=='0'*32):
        return False
    cmper='1'*(list(x).index('0'))+'0'*(32-list(x).index('0'))
    if cmp(x,cmper)>0:
        return False
    return True

def totwo(x):
    x=bin(x).replace('0b','')
    return '0'*(8-len(x))+x

def myint(x):
    try:
        x=int(x)
        return x
    except StandardError:
        return 256

def chgmip(mipdatas)   :
    index=[]
    for i in range(len(mipdatas)):
        if not  mip(mipdatas[i]):
            index.append(i)
    index.reverse()
    return  index

def iprange(datas):
    count=0
    record=[]
    for i in range(len(datas)):
        for j in datas[i]:
            if not j in range(0,256):
                count=count+1
                record.append(i)
                break
    return count,record

import sys
ipdatas=[]
mipdatas=[]
data=[x.strip() for x in list(sys.stdin.readlines())]
data=[(map(lambda i:myint(i),x.split("~")[0].split(".")),map(lambda i:myint(i),x.split("~")[1].split("."))) for x in data]
ipdatas=[x[0] for x in data]
mipdatas=[x[1] for x in data]
count=0
tmp=mipdatas
count=count+iprange(tmp)[0]
counttmp,record =iprange(ipdatas)
count=count+counttmp
for i in record:
    del ipdatas[i]
    del mipdatas[i]
counttmp,record =iprange(mipdatas)
count=count+counttmp
for i in record:
    del ipdatas[i]
    del mipdatas[i]
index=chgmip(mipdatas)
for i in index:
    del ipdatas[i]
    del mipdatas[i]
    count = count + 1


a=len(filter(lambda x:(x[0] <127)&(x[0]>0),ipdatas))
b=len(filter(lambda x:(x[0] <192)&(x[0] >127),ipdatas))
c=len(filter(lambda x:(x[0] <224)&(x[0] >=192),ipdatas))
d=len(filter(lambda x:(x[0] <240)&(x[0] >=224),ipdatas))
e=len(filter(lambda x:(x[0] <256)&(x[0]>=240),ipdatas))
x=len(filter(lambda x:(x[0] ==10),ipdatas))
y=len(filter(lambda x:(x[0] ==172)&(x[1]<32)&(x[1]>16),ipdatas))
z=len(filter(lambda x:(x[0] ==192)&(x[1]==168),ipdatas))
non=len(filter(lambda x:x[0]<1 or x[0]>255,ipdatas))
print a,b-y,c-z,d,e,count,x+y+z


