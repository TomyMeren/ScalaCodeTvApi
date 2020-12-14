package tv.codely.scala_http_api.module.course.infraestructure.marshaller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}
import tv.codely.scala_http_api.module.course.domain._

object CourseMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object CourseIdMarshaller extends JsonFormat[CourseId] {

    def write(value: CourseId): JsValue = JsString(value.id.toString)

    def read(value: JsValue): CourseId = value match {
      case JsString(id) => CourseId(id)
      case _            => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object CourseTitleMarshaller extends JsonFormat[CourseTitle] {

    def write(value: CourseTitle): JsValue = JsString(value.tittle)

    def read(value: JsValue): CourseTitle = value match {
      case JsString(title) => CourseTitle(title)
      case _               => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object CourseNumLeccionMarshaller extends JsonFormat[CourseNumLecciones] {

    def write(value: CourseNumLecciones): JsValue = JsString(value.toString)

    def read(value: JsValue): CourseNumLecciones = value match {
      case JsString(num) => CourseNumLecciones(num.toInt)
      case _             => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object CourseProffMarshaller extends JsonFormat[CourseProf] {

    def write(value: CourseProf): JsValue = JsString(value.toString)

    def read(value: JsValue): CourseProf = value match {
      case JsString(proff) => CourseProf(proff)
      case _               => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit val CourseFormat: RootJsonFormat[Course] =
    jsonFormat4(Course.apply(_: CourseId, _: CourseTitle, _: CourseNumLecciones, _: CourseProf))
}
