package tv.codely.scala_http_api.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.scala_http_api.module.video.application.create.VideoCreator
import tv.codely.scala_http_api.module.video.domain.{VideoCategory, VideoDuration, VideoId, VideoTitle}

import scala.concurrent.duration.Duration

final class VideoPostController(creator: VideoCreator) extends SprayJsonSupport with DefaultJsonProtocol {

  def post(id: String, title: String, duration: Duration, category: String): StandardRoute = {

    creator.create(VideoId(id), VideoTitle(title), VideoDuration(duration), VideoCategory(category))

    complete(HttpResponse(StatusCodes.NoContent))
  }
}
