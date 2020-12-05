package tv.codely.scala_http_api.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.scala_http_api.module.video.application.searcher.VideoSearcher
import tv.codely.scala_http_api.module.video.infraestructure.marshaller.VideoMarshaller._

final class VideoGetController(searcher: VideoSearcher) extends SprayJsonSupport with DefaultJsonProtocol{

  def get(): StandardRoute = complete(searcher.all())
}