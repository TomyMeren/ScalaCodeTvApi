package tv.codely.scala_http_api.module.course.application.searcher

import tv.codely.scala_http_api.module.course.domain.{Course, CourseRepository}

final class CourseSearcher(repo: CourseRepository) {

  def all(): Seq[Course] = repo.all()

}
