package tv.codely.scala_http_api.entry_point

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import tv.codely.scala_http_api.module.course.infraestructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.scala_http_api.module.user.infraestructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.scala_http_api.module.video.infraestructure.dependency_injection.VideoModuleDependencyContainer

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

  val container = new EntryPointDependencyContainer(

    new UserModuleDependencyContainer,

    new VideoModuleDependencyContainer,

    new CourseModuleDependencyContainer
  )

  val routes = new Routes(container)

  val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(routes.all, host, port)

  println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
  StdIn.readLine()

  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
