def update(x,y,z):
	x[int(y)-1]=int(z)
	return x
def query(x,y,z):
	print  max(x[int(y)-1:int(z)])
while True:
	try:
		num=map(lambda x:int(x),raw_input().split(" "))
		socre=map(lambda x:int(x),raw_input().split(" "))
		for i in range(num[1]):
			way=raw_input().split(" ")
			if way[0]=='Q':
				query(socre,way[1],way[2])
			if way[0]=='U':
				socre=update(socre,way[1],way[2])
	except EOFError:
		break