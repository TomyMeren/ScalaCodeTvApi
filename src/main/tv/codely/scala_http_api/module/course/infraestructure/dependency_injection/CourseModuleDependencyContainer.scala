package tv.codely.scala_http_api.module.course.infraestructure.dependency_injection

import tv.codely.scala_http_api.module.course.application.create.CourseCreate
import tv.codely.scala_http_api.module.course.application.searcher.CourseSearcher
import tv.codely.scala_http_api.module.course.infraestructure.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {

  private val repository= new InMemoryCourseRepository

  val courseSearcher = new CourseSearcher(repository)

  val courseCreator = new CourseCreate(repository)


}
