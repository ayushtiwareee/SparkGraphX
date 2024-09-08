import org.apache.spark.sql.SparkSession

object SparkSessionBuilder {

  @volatile private var sparkSession: Option[SparkSession] = None

  def get: SparkSession = this.synchronized {
    sparkSession match {
      case None =>
        sparkSession = Some( SparkSession.builder
          .appName("My Spark Application")
          .master("local[*]")
          .getOrCreate())
        sparkSession.get
      case Some(definedSparkSession) => definedSparkSession
    }
  }
}
