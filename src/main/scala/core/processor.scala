package core

import akka.actor.Actor
import domain.Tweet
import persistence.{AerospikeConnection, TweetSet}

object TweetProcessorActor {

}

class TweetProcessorActor extends Actor with TweetSet with AerospikeConnection{
    def receive = {
        case tweet: Tweet =>
            println(tweet.text)

            tweets.put(tweet.id, tweet.text).run
    }
}
