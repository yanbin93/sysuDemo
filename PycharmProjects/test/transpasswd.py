def lowertrans(x):
    d = {1: "1", 2: "abc",3:'def',4:"ghi",5:'jkl',6:"mno",7:"pqrs",8:"tuv",9:"wxyz",0:'0'}
    for i in range(len(d)):
        if x in d[i]:
            return str(d.keys()[i])
def uppertrans(x):
    if x=='Z':
        return  'a'
    else:
        return  chr(ord(x)+1).lower()

while True:
    try:
        data=list(raw_input().strip())
        for i in range(len(data)):
            if 'a'<=data[i]<='z':
                data[i]=lowertrans(data[i])
                continue
            if 'A' <= data[i] <= 'Z':
                data[i] = uppertrans(data[i])
                continue
        print  "".join(data)
    except EOFError:
        break