package tv.codely.scala_http_api.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.scala_http_api.module.course.application.searcher.CourseSearcher
import tv.codely.scala_http_api.module.course.infraestructure.marshaller.CourseMarshaller._

final class CourseGetController(searcher: CourseSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
