package tv.codely.scala_http_api.module.video.infraestructure.marshaller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsNumber, JsString, JsValue, JsonFormat, RootJsonFormat}
import tv.codely.scala_http_api.module.video.domain._

object VideoMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object VideoIdMarshaller extends JsonFormat[VideoId] {

    def write(value: VideoId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): VideoId = value match {
      case JsString(id) => VideoId(id)
      case _            => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object VideoTitleMarshaller extends JsonFormat[VideoTitle] {

    def write(value: VideoTitle): JsValue = JsString(value.value)

    def read(value: JsValue): VideoTitle = value match {
      case JsString(name) => VideoTitle(name)
      case _              => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object VideoDurationMarshaller extends JsonFormat[VideoDuration] {

    def write(value: VideoDuration): JsValue = JsNumber(value.value.toSeconds)

    def read(value: JsValue): VideoDuration = value match {
      case JsNumber(name) => VideoDuration(name)
      case _              => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object VideoCategoryMarshaller extends JsonFormat[VideoCategory] {

    def write(value: VideoCategory): JsValue = JsString(value.toString) //TODO: Pintaria el objecto¿?

    def read(value: JsValue): VideoCategory = value match {
      case JsString(cate) => VideoCategory(cate)
      case _              => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit val videoFormat: RootJsonFormat[Video] =
    jsonFormat4(Video.apply(_: VideoId, _: VideoTitle, _: VideoDuration, _: VideoCategory))
}
