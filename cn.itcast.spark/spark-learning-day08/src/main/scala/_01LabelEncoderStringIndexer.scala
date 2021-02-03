import org.apache.spark.SparkConf
import org.apache.spark.ml.feature._
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.{DataFrame, SparkSession}



object _01LabelEncoderStringIndexer {


  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName(this.getClass().getSimpleName.toString.dropRight(1))

    println(this.getClass().getSimpleName.toString.dropRight(1))

    val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._

    val inputDF: DataFrame = spark.createDataFrame(
      Seq((0, "a"), (1, "b"), (2, "c"), (3, "a"), (4, "a"), (5, "c")))
    inputDF.printSchema()

    val turnDF: DataFrame = inputDF.toDF("id","category")
    turnDF.printSchema()
    turnDF.show()
    //+---+--------+
    //| id|category|
    //+---+--------+
    //|  0|       a|
    //|  1|       b|
    //|  2|       c|
    //|  3|       a|
    //|  4|       a|
    //|  5|       c|
    //+---+--------+

    //对category字段进行标签编码
    val indexer: StringIndexer = new StringIndexer().setInputCol("category").setOutputCol("indexerNum")
    //上述的代码是已经准备好了indexer的操作，但是由于spark是惰性求职需要获取触发操作
    val indexerModel: StringIndexerModel = indexer.fit(turnDF)
    //上述的代码训练得到模型
    val indexResultDF: DataFrame = indexerModel.transform(turnDF)
    indexResultDF.show()
    //+---+--------+----------+
    //| id|category|indexerNum|
    //+---+--------+----------+
    //|  0|       a|       0.0|
    //|  1|       b|       2.0|
    //|  2|       c|       1.0|
    //|  3|       a|       0.0|
    //|  4|       a|       0.0|
    //|  5|       c|       1.0|
    //+---+--------+----------+

    //对标签编码的字段进行反推
    val indexToString: IndexToString = new IndexToString()
      .setInputCol("indexerNum")
      .setOutputCol("beforeCatagory")
      .setLabels(indexerModel.labels)
    val CatagoryDF: DataFrame = indexToString.transform(indexResultDF)
    CatagoryDF.show()
     //+---+--------+----------+--------------+
    //| id|category|indexerNum|beforeCatagory|
    //+---+--------+----------+--------------+
    //|  0|       a|       0.0|             a|
    //|  1|       b|       2.0|             b|
    //|  2|       c|       1.0|             c|
    //|  3|       a|       0.0|             a|
    //|  4|       a|       0.0|             a|
    //|  5|       c|       1.0|             c|
    //+---+--------+----------+--------------+

    //这里要求独热编码的输入必须是经过stringindexer之后的结果，这里就是indexerNum
    val encoder: OneHotEncoder = new OneHotEncoder().setInputCol("indexerNum").setOutputCol("onehotIndexer").setDropLast(false)
    val encoderDF: DataFrame = encoder.transform(indexResultDF)
    encoderDF.show()

    //+---+--------+----------+-------------+
    //| id|category|indexerNum|onehotIndexer|
    //+---+--------+----------+-------------+
    //|  0|       a|       0.0|(3,[0],[1.0])|
    //|  1|       b|       2.0|(3,[2],[1.0])|
    //|  2|       c|       1.0|(3,[1],[1.0])|
    //|  3|       a|       0.0|(3,[0],[1.0])|
    //|  4|       a|       0.0|(3,[0],[1.0])|
    //|  5|       c|       1.0|(3,[1],[1.0])|
    //+---+--------+----------+-------------+

//数值型数据的归一化的几种操作
    //正准备数据集
    val dataFrame2 = spark.createDataFrame(Seq(
      (0, Vectors.dense(1.0, 0.5, -1.0)),
      (1, Vectors.dense(2.0, 1.0, 1.0)),
      (2, Vectors.dense(4.0, 10.0, 2.0))
    )).toDF("id", "features")
    dataFrame2.show()
//MinMaxScaler归一化,结果范围[0-1]
    val scaler = new MinMaxScaler()
      .setInputCol("features")
      .setOutputCol("scaledFeatures")

    // Compute summary statistics and generate MinMaxScalerModel
    val scalerModel = scaler.fit(dataFrame2)

    // rescale each feature to range [min, max].
    val scaledData = scalerModel.transform(dataFrame2)
    println(s"Features scaled to range: [${scaler.getMin}, ${scaler.getMax}]")
    scaledData.show()
    scaledData.select("features", "scaledFeatures").show(truncate = false)
    //Features scaled to range: [0.0, 1.0]

    //+--------------+-----------------------------------------------------------+
    //|features      |scaledFeatures                                             |
    //+--------------+-----------------------------------------------------------+
    //|[1.0,0.5,-1.0]|[0.0,0.0,0.0]                                              |
    //|[2.0,1.0,1.0] |[0.3333333333333333,0.05263157894736842,0.6666666666666666]|
    //|[4.0,10.0,2.0]|[1.0,1.0,1.0]                                              |
    //+--------------+-----------------------------------------------------------+

    //+--------------+--------------------+
    //|      features|      scaledFeatures|
    //+--------------+--------------------+
    //|[1.0,0.5,-1.0]|       [0.0,0.0,0.0]|
    //| [2.0,1.0,1.0]|[0.33333333333333...|
    //|[4.0,10.0,2.0]|       [1.0,1.0,1.0]|
    //+--------------+--------------------+
//maxAbsScaler归一化,结果范围[-1-1]
    val maxAbsScaler: MaxAbsScaler = new MaxAbsScaler()
      .setInputCol("features")
      .setOutputCol("MaxABSSclerResult")
    val model: MaxAbsScalerModel = maxAbsScaler.fit(dataFrame2)
    model.transform(dataFrame2).show(truncate = false)

    //+---+--------------+-----------------+
    //|id |features      |MaxABSSclerResult|
    //+---+--------------+-----------------+
    //|0  |[1.0,0.5,-1.0]|[0.25,0.05,-0.5] |
    //|1  |[2.0,1.0,1.0] |[0.5,0.1,0.5]    |
    //|2  |[4.0,10.0,2.0]|[1.0,1.0,1.0]    |
    //+---+--------------+-----------------+

   //连续值数据的离散化
   //数据切分
   val splits: Array[Double] = Array(Double.NegativeInfinity, -2, 0, 2, Double.PositiveInfinity)
    //准备数据
    val data = Array(-10, -5, -3, -0.3, 0.0, 0.2, 4, 5, 6)
    val dataFrame3 = spark.createDataFrame(data.map(Tuple1.apply)).toDF("features")
    dataFrame3.show()

    val bucketizer: Bucketizer = new Bucketizer()
      .setInputCol("features")
      .setOutputCol("buckrierFeatures")
      .setSplits(splits)
    val df: DataFrame = bucketizer.transform(dataFrame3)
    df.show()
//+--------+
    //|features|
    //+--------+
    //|   -10.0|
    //|    -5.0|
    //|    -3.0|
    //|    -0.3|
    //|     0.0|
    //|     0.2|
    //|     4.0|
    //|     5.0|
    //|     6.0|
    //+--------+
    //
    //+--------+----------------+
    //|features|buckrierFeatures|
    //+--------+----------------+
    //|   -10.0|             0.0|
    //|    -5.0|             0.0|
    //|    -3.0|             0.0|
    //|    -0.3|             1.0|
    //|     0.0|             2.0|
    //|     0.2|             2.0|
    //|     4.0|             3.0|
    //|     5.0|             3.0|
    //|     6.0|             3.0|
    //+--------+----------------+


//特征组合
    val dataset = spark.createDataFrame(
      Seq((0, 18, 1.0, Vectors.dense(0.0, 10.0, 0.5), 1.0))
    ).toDF("id", "hour", "mobile", "userFeatures", "clicked")
    //一个样本点对应的就是一个特征向量，一个特征向量中有很多列，称之为特征
    dataset.show(false)
    val assembler: VectorAssembler = new VectorAssembler()
      .setInputCols(Array("hour", "mobile", "userFeatures"))
      .setOutputCol("features")
    val df2: DataFrame = assembler.transform(dataset)
    df2.show(false)
    df2.printSchema()
    // |-- features: vector (nullable = true)


    //+---+----+------+--------------+-------+
    //|id |hour|mobile|userFeatures  |clicked|
    //+---+----+------+--------------+-------+
    //|0  |18  |1.0   |[0.0,10.0,0.5]|1.0    |
    //+---+----+------+--------------+-------+
    //
    //+---+----+------+--------------+-------+-----------------------+
    //|id |hour|mobile|userFeatures  |clicked|features               |
    //+---+----+------+--------------+-------+-----------------------+
    //|0  |18  |1.0   |[0.0,10.0,0.5]|1.0    |[18.0,1.0,0.0,10.0,0.5]|
    //+---+----+------+--------------+-------+-----------------------+
    //
    //root
    // |-- id: integer (nullable = false)
    // |-- hour: integer (nullable = false)
    // |-- mobile: double (nullable = false)
    // |-- userFeatures: vector (nullable = true)
    // |-- clicked: double (nullable = false)
    // |-- features: vector (nullable = true)



//特征选择  --卡方验证选择方式
    val data1 = Seq(
      (7, Vectors.dense(0.0, 0.0, 18.0, 1.0), 1.0),
      (8, Vectors.dense(0.0, 1.0, 12.0, 0.0), 0.0),
      (9, Vectors.dense(1.0, 0.0, 15.0, 0.1), 0.0)
    )

    val df1 = spark.createDataset(data1).toDF("id", "features", "clicked")
    //这里的卡方验证需要使用pearson相似度---类似于余弦相似度-------1《cos《1
    val selector: ChiSqSelector = new ChiSqSelector()
      .setFeaturesCol("features")
      .setLabelCol("clicked")
      .setNumTopFeatures(2)
    selector.fit(df1).transform(df1).show()

     //+---+------------------+-------+----------------------------------+
    //| id|          features|clicked|chiSqSelector_4cd983010f89__output|
    //+---+------------------+-------+----------------------------------+
    //|  7|[0.0,0.0,18.0,1.0]|    1.0|                        [18.0,1.0]|
    //|  8|[0.0,1.0,12.0,0.0]|    0.0|                        [12.0,0.0]|
    //|  9|[1.0,0.0,15.0,0.1]|    0.0|                        [15.0,0.1]|
    //+---+------------------+-------+----------------------------------+

    spark.stop()


  }

}
