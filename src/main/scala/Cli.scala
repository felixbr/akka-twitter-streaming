import core.TweetStreamerActor.StartStreaming
import core.{CoreActors, BootedCore}

import scala.annotation.tailrec
import Commands._

object Commands {
    val QuitCommand  = "quit"
    val TrackCommand = "track (.*)".r
}

object Cli extends App with BootedCore with CoreActors {

    @tailrec
    private def commandLoop() {
        Console.readLine() match {
            case QuitCommand         => System.exit(0)
            case TrackCommand(query) => tweetStreamerActor ! StartStreaming(query)
            case _                   => println("unknown command. try 'track <query>' or 'quit'.")
        }

        commandLoop()
    }

    //commandLoop()
    tweetStreamerActor ! StartStreaming("fuck")
}
