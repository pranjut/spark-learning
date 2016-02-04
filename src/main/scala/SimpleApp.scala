import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.spark.SparkContext._

object SimpleApp {
  def main(args: Array[String]) {
    modified
  }

  def modified = {
    val logFile = "/home/pranjut/softwares/spark-1.6.0-bin-hadoop2.6/README.md" // Should be some file on your system
    val conf = new SparkConf().setMaster("local[*]").setAppName("Simple Application")
    val sc = new SparkContext(conf)
    //    val logData = sc.textFile(logFile, 2).cache()
    //    val numAs = logData.filter(line => line.contains("a")).count()
    //    val numBs = logData.filter(line => line.contains("b")).count()
    val lines = sc.textFile(logFile)
    val pairs = lines.map(x => (x.split(" ")(0), x))
    //    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println(".>>>>>>>>>>>2nd collect" + pairs.collect()(2))
    println("..................")
    println()
    println(".>>>>>>>>>>>pairs" + pairs.reduceByKey((a, b) => a + ".>>>>>>>>pairing<<<<<<<<." + b).first())
    println("..................")
    println()
    println(">>>>>>>only values" + pairs.values.first())
    println("..................")
    println()
    println(">>>>>>>keys" + pairs.keys.first())
    println("..................")
    println()
    println(">>>>>>>join" + pairs.keys)
    println("..................")
    println()
//    println(">>>>>>>join" + pairs.combine)
  }
}
