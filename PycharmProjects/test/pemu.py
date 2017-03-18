def perms(elements):
    if len(elements) <=1:
        yield elements
    else:
        for perm in perms(elements[1:]):
            for i in range(len(elements)):
                yield perm[:i] + elements[0:1] + perm[i:]

def pemu(x):
    head=x[0]
    result=[]
    if len(x)==1:
        return [[head]]
    for i in range(len(x)):
        tmp=[]
        tmparray=[y for y in x]
        tmp.append(tmparray[i])
        del tmparray[i]
        for y in pemu(tmparray):
            z=[d for d in y]
            z.insert(0,tmp[0])
            tmp=z
            result.append(tmp)
    return  result
while True:
    try:
        data=raw_input().split(" ")
        for i in perms(data):
           print i
        print (len(perms(data)))
    except StandardError, e:
        print e
        break