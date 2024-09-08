class CSVEndToEndExample {

  SparkSessionBuilder.get
    .read
    .option("inferSchema", "true")
    .option("header", "true")
    .csv("/data/flight-data/csv/2015-summary.csv")
}
