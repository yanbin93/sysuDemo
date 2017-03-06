package test
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._ 
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf

object rizhiCount {
  def main(args:Array[String]) ={
    val inputPath = "file:///home/yanbin/log.txt"
    val outputPath = "hdfs://master1:9002/tmp/test/rizhiCount2"
    val conf = new SparkConf().setAppName("count")
    val sc = new SparkContext(conf)
    val file = sc.textFile(inputPath)
    val tokenized = file.map(line => line.split(" ")).filter(x => x.size >2 && (x(2) =="INFO"||x(2) == "ERROR"||x(2) == "WARN"))
    val counts = tokenized.map(x => (x(2),1)).reduceByKey(_+_)
   
    val choose =counts.foreach(println)
     counts.saveAsTextFile(outputPath)
  }
}