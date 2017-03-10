import random
record=list()
usernamerange="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ_-."
passwordrange="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ."
for x in xrange(1,1000000):
	username=""
	password=""
	for i in range(random.randint(1,10)):
		username=username+random.choice(usernamerange)
	for i in range(random.randint(1,10)):
		password=password+random.choice(passwordrange)
	record.append(username+"\t"+password+"\t"+str(x))

f = open('/home/yanbin/test.txt', 'w')
for x in xrange(len(record)):
	f.write(record[x]+"\n")
f.close()
	#print  record[x]
print len(record)