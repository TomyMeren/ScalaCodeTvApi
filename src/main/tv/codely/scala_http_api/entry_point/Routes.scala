package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json._
import tv.codely.scala_http_api.module.video.infraestructure.marshaller.VideoMarshaller._

import scala.concurrent.duration.DurationInt

/**
  * Definicion de rutas HTTP de la aplicacion
  * @param container
  */
final class Routes(container: EntryPointDependencyContainer) {

  val all: Route = get {
    path("status")(container.statusGetController.get()) ~
      path("users")(container.userGetController.get()) ~
      path("videos")(container.videoGetController.get())
  } ~
    post {
      path("videos") {
        jsonBody { body =>
          container.videoPostController.post(
            body("id").convertTo[String],
            body("title").convertTo[String],
            body("duration_in_seconds").convertTo[Int].seconds,
            body("categoty").convertTo[String]
          )
        }
      }
    }

  private def jsonBody(handler: Map[String, JsValue] => Route): Route = {
    entity(as[JsValue])(json => handler(json.asJsObject.fields))
  }

}
