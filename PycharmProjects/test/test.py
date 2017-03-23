def wheather(x):
    if len(x)<2:
        return False
    dire=x[0]
    dis=x[1:]
    if dire not in ['A','S','W','D']:
        return False
    try:
        int(dis)
    except StandardError:
        return  False
    return True;

def move(pos,dire,dis):
    d={'A':(-1,0),'D':(1,0),'W':(0,1),'S':(0,-1)}
    tmp=[d.get(dire)[0]*dis,d.get(dire)[1]*dis]
    return [pos[0]+tmp[0],pos[1]+tmp[1]]
while True:
    try:
        raw_data=filter(lambda x:wheather(x),raw_input().split(";"))
        pos=[0,0]
        for data in raw_data:
            dire=data[0]
            dis=int(data[1:])
            pos=move(pos,dire,dis)
        print "{pos[0]},{pos[1]}".format(pos=pos)
    except StandardError:
        break