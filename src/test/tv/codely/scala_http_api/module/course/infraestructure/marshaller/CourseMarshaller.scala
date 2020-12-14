package tv.codely.scala_http_api.module.course.infraestructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import tv.codely.scala_http_api.module.course.domain.Course

object CourseMarshallerr {
  def marshall(course: Seq[Course]): JsArray = JsArray(
    course
      .map(
        curso =>
          JsObject(
            "id"       -> JsString(curso.id.toString),
            "title"    -> JsString(curso.title.tittle),
            "num_lecciones" -> JsNumber(curso.numLecciones.num),
            "profesor" -> JsString(curso.profesor.nombre),
          )
      )
      .toVector
  )
}
