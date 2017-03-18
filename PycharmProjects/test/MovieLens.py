# from pyspark import SparkContext
import warnings
import matplotlib.pyplot as plt
import pylab as pl
import numpy as np
warnings.filterwarnings('ignore')
# sc = SparkContext()
lines = open("/home/yanbin/data.txt",'r').readlines()
x=[line.strip().split('\t')[0] for line in lines ]
y=[intern(line.strip().split('\t')[1]) for line in lines ]
print y
#print user_data.first()
# userfields = user_data.map(lambda line:line.split('\t')).map()
#
ax2 = plt.subplot(1,1,1)
#
#
#
print
x_axis =[x[i] for i in np.argsort(y)]
y_axis =[y[i] for i in np.argsort(y)]
print y_axis

pos = np.arange(len(x_axis))
width =1.0
ax2.set_xticks(pos+(width)/2)
ax2.set_xticklabels(x_axis)
ax2.bar(pos,y_axis,1.0,color='lightblue')
fig = plt.gcf()
fig.set_size_inches(30,30)
plt.show()