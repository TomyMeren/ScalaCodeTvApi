package tv.codely.scala_http_api.module.video.infraestructure.dependency_injection

import tv.codely.scala_http_api.module.video.application.create.VideoCreator
import tv.codely.scala_http_api.module.video.application.searcher.VideoSearcher
import tv.codely.scala_http_api.module.video.infraestructure.repository.InMemoryRepository

final class VideoModuleDependencyContainer {
  private val repository = new InMemoryRepository

  val videoSearcher = new VideoSearcher(repository)

  val videoCreator = new VideoCreator(repository)
}
