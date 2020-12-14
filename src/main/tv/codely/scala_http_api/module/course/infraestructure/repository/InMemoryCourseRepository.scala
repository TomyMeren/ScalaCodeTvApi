package tv.codely.scala_http_api.module.user.infraestructure.repository

import tv.codely.scala_http_api.module.course.domain.CourseRepository
import tv.codely.scala_http_api.module.video.domain.Video

private class InMemoryCourseRepository extends CourseRepository {

  val courses = ???

  def all(): Seq[Course] = courses

  def save(course: Course): Unit = courses = courses :+ course

}
