package tv.codely.ScalaHttpApi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn

object ScalaHttpApi extends App {

  val appConfig    = ConfigFactory.load("application")
  val serverConfig = ConfigFactory.load("http-server")

  val actorSystemName = appConfig.getString("main-actor-system.name")
  val host            = serverConfig.getString("http-server.host")
  val port            = serverConfig.getInt("http-server.port")

  implicit val system: ActorSystem                        = ActorSystem(actorSystemName)
  implicit val materializer: ActorMaterializer            = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(Routes.all, host, port)

  println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
  StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
