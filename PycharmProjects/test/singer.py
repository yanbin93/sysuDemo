
def lcs(data):
    result=[1]*len(data)
    for i in range(1,len(data)):
        result[i]=1
        for j in range(0,i):
            if data[j]<data[i] and result[j]+1>result[i]:
                result[i]=result[j]+1
    return result
import sys
while True:
    try:
        num=input()
        data=sys.stdin.redline()
        data=map(lambda  x:int(x),raw_input().strip().split(" "))
        print len(data)
        result1=lcs(data)

        data.reverse()
        result2 = lcs(data)
        result2.reverse()
        result=[]
        for i in range(len(result1)):
            result.append(result1[i]+result2[i])
        man=max(result)-1
        print num-man
    except StandardError, e:
        break
