def value(x,p):
    price=0
    for i in range(len(p)):
        price=price+int(p[i])*x[i][1]
    return price

def value2(x,p):
    price=0
    print p
    for i in range(len(p)):
        price=price+int(p[i])*x[i][1]*x[i][2]
    return price

def wheather(x,money,p):
    #leadindex=[i for i in x if i[3]==0]
    #subindex=[i for i in x if i[3]!=0]
    for i in range(len(p)):
        if p[i]=='1':
            if x[i][3]!=0:
                if p[x[x[i][3]-1][0]-1] !='1':
                    flag=False
                    return 0
    price=value(x,p)
    if price<=money:
        return p
    else:
        return 0

def possibe(datas,money):
    finalpossible=[]
    for x in range(2**len(datas)):
        tmppossible=totwo(x,len(datas))
        print tmppossible
        result=wheather(datas,money,tmppossible)
        if result==0:
            continue
        else:
            finalpossible.append(result)
    return finalpossible

def totwo(x,nums):
    poss=list(bin(x).replace('0b', ""))
    if len(poss)<nums:
        poss=list('0'*(nums-len(poss)))+poss
    poss.reverse()
    return poss

raw=raw_input().split(" ")
money=int(raw[0])
nums=int(raw[1])
datas=[]
for i in range(nums):
    raw_data=map(lambda x:int(x),raw_input().split(" "))
    data=[i+1,raw_data[0],raw_data[1],raw_data[2]]
    datas.append(data)
print datas
finalpossible=possibe(datas,money)
price=[]
print "---------------------------------------"
for x in finalpossible:
    price.append(value2(datas,x))
finalprice=max(price)
index=price.index(finalprice)
print "---------------------------------------"
print len(finalpossible),len(price)
print finalpossible[index]
print finalprice
