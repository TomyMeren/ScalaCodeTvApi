package tv.codely.scala_http_api.entry_point

import tv.codely.scala_http_api.entry_point.controller.course.{CourseGetController, CoursePostController}
import tv.codely.scala_http_api.entry_point.controller.status.StatusGetController
import tv.codely.scala_http_api.entry_point.controller.user.UserGetController
import tv.codely.scala_http_api.entry_point.controller.video.{VideoGetController, VideoPostController}
import tv.codely.scala_http_api.module.course.infraestructure.dependency_injection.CourseModuleDependencyContainer
import tv.codely.scala_http_api.module.user.infraestructure.dependency_injection.UserModuleDependencyContainer
import tv.codely.scala_http_api.module.video.infraestructure.dependency_injection.VideoModuleDependencyContainer

/**
  * Declaramos todos los controladores de todos los bojetos
  */
final class EntryPointDependencyContainer(userDependencies: UserModuleDependencyContainer,
                                          VideoDependencies: VideoModuleDependencyContainer,
                                          courseDependencies: CourseModuleDependencyContainer) {

  val statusGetController = new StatusGetController

  val userGetController = new UserGetController(userDependencies.userSearcher)

  val videoGetController = new VideoGetController(VideoDependencies.videoSearcher)

  val videoPostController = new VideoPostController(VideoDependencies.videoCreator)

  val courseGetController = new CourseGetController(courseDependencies.courseSearcher)

  val coursePostController = new CoursePostController(courseDependencies.courseCreator)
}
