package core

import akka.actor.ActorSystem

trait Core {
    implicit def system: ActorSystem
}

trait BootedCore extends Core {
    implicit lazy val system = ActorSystem("akka-twitter-streaming")

    sys.addShutdownHook(system.shutdown())
}
