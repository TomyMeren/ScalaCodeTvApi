package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json._
import tv.codely.scala_http_api.module.course.infraestructure.marshaller.CourseMarshaller._
import tv.codely.scala_http_api.module.video.infraestructure.marshaller.VideoMarshaller._


import scala.concurrent.duration.DurationInt

/**
  * Definicion de rutas HTTP de la aplicacion
  * @param container
  */
final class Routes(container: EntryPointDependencyContainer) {

  private val status = get {
    path("status")(container.statusGetController.get())
  }

  private val users = get {
    path("users")(container.userGetController.get())
  }

  private val videos = get {
    path("videos")(container.videoGetController.get())
  } ~
    post {
      path("videos") {
        jsonBody { video =>
          container.videoPostController.post(
            video("id").convertTo[String],
            video("title").convertTo[String],
            video("duration_in_seconds").convertTo[Int].seconds,
            video("categoty").convertTo[String]
          )
        }
      }
    }

  val cursos = get {
    path("cursos")(container.courseGetController.get())
  } ~
    post {
      path("cursos") {
        jsonBody { curso =>
          container.coursePostController.post(
            curso("id").convertTo[String],
            curso("tittle").convertTo[String],
            curso("num_lecciones").convertTo[Int],
            curso("profesor").convertTo[String]
          )
        }
      }
    }

  val all: Route = status ~ users ~ videos ~ cursos

  private def jsonBody(handler: Map[String, JsValue] => Route): Route = {
    entity(as[JsValue])(json => handler(json.asJsObject.fields))
  }
}
