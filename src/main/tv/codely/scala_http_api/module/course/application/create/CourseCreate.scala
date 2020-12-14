package tv.codely.scala_http_api.module.course.application.create

import tv.codely.scala_http_api.module.course.domain._

final class CourseCreate(repo: CourseRepository) {

  def create(id: CourseId, title: CourseTitle, numLecciones: CourseNumLecciones, profesor: CourseProf): Unit = {
    val curso = Course(id, title, numLecciones, profesor)
    repo.save(curso)
  }
}
