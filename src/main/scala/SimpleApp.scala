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
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
