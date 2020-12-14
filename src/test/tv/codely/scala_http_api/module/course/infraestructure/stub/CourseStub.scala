package tv.codely.scala_http_api.module.course.infraestructure.stub

import tv.codely.scala_http_api.module.course.domain.Course

object CourseStub {
  def apply(id: String = "asdfdsfg55-fdsfdsag-gfdsg4s-dfgfdg44g-gfd344",
            title: String = "tituloRandom",
            numlecciones: Int = 2,
            profesor: String = "yo"): Course = Course(id, title, numlecciones, profesor)


  def random: Course = apply()
}
