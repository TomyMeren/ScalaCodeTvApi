package tv.codely.scala_http_api.module.course.domain

object Course {
  def apply(id: String, title: String, numLecciones: Int, profesor: String): Course = Course(
    CourseId(id),
    CourseTitle(title),
    CourseNumLecciones(numLecciones),
    CourseProf(profesor)
  )
}

case class Course(id: CourseId, title: CourseTitle, numLecciones: CourseNumLecciones, profesor: CourseProf)
