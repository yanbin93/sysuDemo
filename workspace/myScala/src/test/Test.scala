package test
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._ 
import org.apache.spark.rdd.RDD
 /**
  * 统计字符出现次数
  */
object Test {
   def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println("Usage: <file>")
      System.exit(1)
    }
    val conf = new SparkConf()
    conf.setAppName("Test")
   //conf.setMaster("spark://master1:7077");
    //.set("spark.jars","/home/yanbin/hadoop-2.6/spark/jars/*");
    val sc = new SparkContext(conf)

    val line = sc.textFile(args(0))
    //输出到文件
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).saveAsTextFile(args(1))
    //输出到屏幕
    line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
//object Test {
//  def main(args: Array[String]): Unit={
//    val file = sc.textFile("file:///home/yanbin/log.txt")
//    println("Hello World!")
//  }
//}