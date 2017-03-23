def check(passwd):
    if len(passwd) < 8:
        return False
    count = []
    for x in passwd:
        if 'a' <= x <= 'z':
            count.append(1)
            continue
        elif 'A' <= x <= 'Z':
            count.append(2)
            continue
        elif '0' <= x <= '9':
            count.append(3)
            continue
        elif 1 <= ord(x) <= 127:
            count.append(4)
    if len(set(count)) < 3:
        return False
    return copy(passwd)


def copy(passwd):
    for i in range(len(passwd) - 2):
        for j in range(3, len(passwd) - i + 1):
            sub = passwd[i:i + j]
            sub1 = passwd[0:i]
            sub2 = passwd[i + j:len(passwd)]
            count=(sub1.count(sub) + sub2.count(sub))
            if count > 0:
                return False
    return True


while True:
    passwd = raw_input().strip()
    if check(passwd):
        print 'OK'
    else:
        print 'NG'
