
def lcs(data):
    result=[1]*len(data)
    for i in range(1,len(data)):
        result[i]=1
        for j in range(0,i):
            if data[j]<data[i] and result[j]+1>result[i]:
                result[i]=result[j]+1
    return result


num=input()
data=map(lambda  x:int(x),raw_input().split(" "))
result1=lcs(data)
data.reverse()
result2 = lcs(data)
result2.reverse()
result=[]
for i in range(len(data)):
    result.append(result1[i]+result2[i])
man=max(result)-1
print num-man
