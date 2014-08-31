package persistence

import aerospikez.{Bin, Namespace, AerospikeClient}
import domain.Tweet

trait AerospikeConnection {
  lazy val aerospikeClient = AerospikeClient()
}

object TweetSet extends AerospikeConnection {
  private val tweets = aerospikeClient.setOf[String](Namespace(), name = "Tweets")

  def create(tweet: Tweet): Unit = {
    //val place: Option[String] = tweet.place.map(_.toString)
    val place: String = tweet.place.map(_.toString).getOrElse("")

    tweets.put(tweet.id: String, Bin("text", Option(tweet.text): Option[String])).run
    //tweets.put("blubb", Some("bla"): Option[String]).run
    tweets.put("blubb", Bin("text", Some("bla"): Option[String])).run
    tweets.put("blubb", Bin("text", Option("bla"))).run
    //tweets.put("blubb", Bin("text", Some("bla"))).run

    //tweets.put("blubb", Bin("text", Option("bla"))).run
  }
}


