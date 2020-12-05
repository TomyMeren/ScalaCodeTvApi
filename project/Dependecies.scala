import sbt._

object Dependecies {
  object version {
    val akka = "2.5.9"
    val akkaHttp = "10.0.11"
  }

  /** ********* PROD DEPENDENCIES **************** */
  val produccion = Seq(
    "com.github.nscala-time" %% "nscala-time" % "2.22.0",
    "com.lihaoyi" %% "pprint" % "0.5.6",
    "com.typesafe.akka" %% "akka-actor" % version.akka,
    "com.typesafe.akka" %% "akka-stream" % version.akka,
    "com.typesafe.akka" %% "akka-http" % version.akkaHttp,
    "com.typesafe.akka" %% "akka-http-spray-json" % version.akkaHttp
  )

  /** ********* TEST DEPENDENCIES **************** */
  val test = Seq(
    "org.scalatest" %% "scalatest" % "3.1.1" % Test,
    "org.scalamock" %% "scalamock" % "4.4.0" % Test,
    "com.typesafe.akka" %% "akka-testkit" % version.akka % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % version.akkaHttp % Test
  )
}
