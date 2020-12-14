package tv.codely.scala_http_api.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.StandardRoute
import tv.codely.scala_http_api.module.course.application.create.CourseCreate
import tv.codely.scala_http_api.module.course.domain.{CourseId, CourseNumLecciones, CourseProf, CourseTitle}
import akka.http.scaladsl.server.Directives.complete
import spray.json.DefaultJsonProtocol

final class CoursePostController(creator: CourseCreate) extends SprayJsonSupport with DefaultJsonProtocol {
  def post(id: String, title: String, numLecciones: Int, profesor: String): StandardRoute = {

    creator.create(CourseId(id), CourseTitle(title), CourseNumLecciones(numLecciones), CourseProf(profesor))

    complete(HttpResponse(StatusCodes.NoContent))
  }
}
