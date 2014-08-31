package core

import akka.actor.Props

trait CoreActors {
  this: Core =>

  val tweetProcessorActor = system.actorOf(Props(new TweetProcessorActor()))
  val tweetStreamerActor = system.actorOf(Props(new TweetStreamerActor(tweetProcessorActor) with OAuthTwitterAuthorization))
}
