package persistence

import aerospikez.{Namespace, AerospikeClient}

trait AerospikeConnection {
    lazy val aerospikeClient = AerospikeClient()
}

trait TweetSet {
    this: AerospikeConnection =>

    val tweets = aerospikeClient.setOf[String](Namespace(), name = "Tweets")
}


