name := "akka-twitter-streaming"

version := "1.0"

libraryDependencies ++= Seq(
    "com.typesafe.akka"      %% "akka-actor"            % "2.2.3",
    "com.typesafe.akka"      %% "akka-slf4j"            % "2.2.3",
    "io.spray"                % "spray-can"             % "1.2.0",
    "io.spray"                % "spray-client"          % "1.2.0",
    "io.spray"                % "spray-routing"         % "1.2.0",
    "io.spray"               %% "spray-json"            % "1.2.5",
    "io.spray"                % "spray-testkit"         % "1.2.0"        % "test"
)