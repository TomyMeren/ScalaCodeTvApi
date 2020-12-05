package tv.codely.scala_http_api.module.video.infraestructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import tv.codely.scala_http_api.module.video.domain.Video

object VideoMarshaller {
  def marshall(videos: Seq[Video]): JsArray = JsArray(
    videos
      .map(
        video =>
          JsObject(
            "id"       -> JsString(video.id.toString),
            "title"    -> JsString(video.title.value),
            "duration" -> JsNumber(video.duration.value.toSeconds),
            "category" -> JsString(video.category.toString),
        )
      )
      .toVector
  )
}
