from pyspark.sql import HiveContext,functions
from pyspark import SparkContext
import re
sc = SparkContext()
hiveCtx = HiveContext(sc)
def length(name):
    return len(name)
hiveCtx.registerFunction("length",length,IntegerType())
results = hiveCtx.sql("select length(username) from yanbin.username").collect()
for result in results:
    print repr(result)
    #print re.findall(r".*u'(.*)'.*",repr(result))
