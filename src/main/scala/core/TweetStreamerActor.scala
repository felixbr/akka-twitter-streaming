package core

import akka.actor.{Actor, ActorRef}
import akka.io.IO
import core.TweetStreamerActor.StartStreaming
import spray.can.Http
import spray.client.pipelining._
import spray.http._

object TweetStreamerActor {
    sealed trait StreamerMessage
    case class StartStreaming(query: String) extends StreamerMessage

    val twitterUri = Uri("https://stream.twitter.com/1.1/statuses/filter.json")
    //val twitterUri = Uri("https://google.com")
}

class TweetStreamerActor(processor: ActorRef) extends Actor with TweetMarshaller {
    this: TwitterAuthorization =>

    val io = IO(Http)(context.system)

    def receive = {
        case StartStreaming(query)   => connectToStreamingEndpoint(query)
        case ChunkedResponseStart(_) =>
        case MessageChunk(entity, _) => TweetUnmarshaller(entity).fold(_ => (), processor !) // fold Left and Right
        case a                       => println(a)
    }

    private def connectToStreamingEndpoint(query: String): Unit = {
        println("connecting to twitter...")
        val body = HttpEntity(ContentType(MediaTypes.`application/x-www-form-urlencoded`), s"track=$query")
        val rq = HttpRequest(HttpMethods.POST, uri = Uri("https://stream.twitter.com/1.1/statuses/filter.json"), entity = body) ~> authorize

        println(rq)

        sendTo(io).withResponsesReceivedBy(self)(rq)
    }
}
