from pyspark import SparkContext
sc = SparkContext("local[2]")
data = sc.textFile("file:///home/yanbin/data/UserPurchaseHistory.csv").map(lambda line:line.split(",")).map(lambda record:(record[0],record[1],record[2]))
print "the times of puchase: "
print data.count()
customer =  data.map(lambda record:(record[0],1)).distinct()
print "the num of customer: "
print  customer.count()
print "the total cost is : %2.2f $" % data.map(lambda  record:float(record[2])).sum()
goods =  data.map(lambda record:(record[1],1)).reduceByKey(lambda x,y:x+y).collect()
print "the most popular goods is: "
print  sorted(goods,key=lambda x:x[1],reverse=True)[0]
