name := "PrivateHome"

version := "0.1"

scalaVersion := "2.13.0"

maintainer := "RaHoni <honi2002suess@gmail.com>"

packageSummary := "This is a SmartHome system"

packageDescription := "This is a SmartHome project focused on design, security and expandability. It is programmed in Scala."

debianPackageDependencies  := Seq("java8-runtime-headless","mosquitto")
debianPackageRecommends := Seq("wiringPi")

lazy val akkaVersion = "2.6.8"

//pi4j java wrapper for WiringPI (deprecated by author may be continued be other)
libraryDependencies ++= Seq("com.pi4j" % "pi4j-core" % "1.2","com.pi4j" % "pi4j-parent" % "1.2")

//scala Test also used by Akka
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

//logback logger used by Akka and scalikejdbc maybe integrate in whole project
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

//Akka library for Webserver with Websockets Support
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.2.0",
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

//XML library for scala
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.2.0"

//MQTT library
resolvers += "MQTT Repository" at "https://repo.eclipse.org/content/repositories/paho-releases/"
libraryDependencies += "org.eclipse.paho" % "mqtt-client" % "0.4.0"

//scalikejdbc library for mysql (backend h2)
libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc"       % "3.4.0",
  "org.scalikejdbc" %% "scalikejdbc-test" % "3.4.0"   % "test",
  "com.h2database"  %  "h2"                % "1.4.200",
  "org.scalikejdbc" %% "scalikejdbc-config"  % "3.4.0"
)

//JSON library
libraryDependencies += "org.json4s" % "json4s-jackson_2.13" % "3.6.7"

//sbt-native-packaging Plugins for compiling to deb
enablePlugins(DebianPlugin)
enablePlugins(JavaServerAppPackaging)
