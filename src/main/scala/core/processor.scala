package core

import akka.actor.Actor
import domain.Tweet

object TweetProcessorActor {

}

class TweetProcessorActor extends Actor {
    def receive = {
        case tweet: Tweet =>
            println(tweet.text)
    }
}
