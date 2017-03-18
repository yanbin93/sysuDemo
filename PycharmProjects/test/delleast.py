import  sys
while True:
    try:
        data =sys.stdin.readline()[:-1]
        count=[]
        for x in set(data):
            count.append([x,data.count(x)])
        print count
        min1=min([x[1] for x in count])
        for x in count:
            if x[1]==min1:
                data=data.replace(x[0],'')
    except EOFError:
        break