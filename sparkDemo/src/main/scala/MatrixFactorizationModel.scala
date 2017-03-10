val rawData = sc.textFile("file:///home/yanbin/data/ml-100k/u.data")
rawData.first()
val rawRatings = rawData.map(_.split('\t').take(3))
rawRatings.first()
import org.apache.spark.mllib.recommendation.ALS
import org.apache.spark.mllib.recommendation.Rating

val ratings = rawRatings.map{case Array(user,movie,rating) => Rating(user.toInt,movie.toInt,rating.toDouble)}
ratings.first()
val model = ALS.train(rating,50,10,0.01)
model.userFeatures
model.userFeatures.count
model.productFeatures
model.productFeatures
val predictedRating = model.predict(789,123)


val rawData = hiveContext.sql("select * from yanbin.userdata")
val rawRatings=rawData.select("userid","movieid","socre")


