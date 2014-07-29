package core

import akka.actor.Actor
import domain.Tweet
import persistence.{AerospikeConnection, TweetSet}

object TweetProcessorActor {

}

class TweetProcessorActor extends Actor {
    def receive = {
        case tweet: Tweet =>
            println(tweet.text)

            TweetSet.create(tweet)
    }
}
