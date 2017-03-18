def rs(x,y):
    z=x+y
    return ((jie(z)/jie(y))/jie(x))
def jie(x):
    if x==1:
        return 1
    return x*jie(x-1)
while True:
    try:
        data=raw_input().split(" ")
        print rs(int(data[0]),int(data[1]))
    except:
        break