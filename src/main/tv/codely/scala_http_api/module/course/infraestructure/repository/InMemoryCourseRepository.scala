package tv.codely.scala_http_api.module.course.infraestructure.repository

import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

final class InMemoryCourseRepository extends CourseRepository {

  private var courses: Seq[Course] = Seq(
    Course(
      id = "5654gdfg-260b-420a-b08c-654645645",
      title = "scala para tontos",
      numLecciones = 3,
      profesor = "tomy"
    )
  )

  def all(): Seq[Course] = courses

  def save(course: Course): Unit = courses = courses :+ course

}
