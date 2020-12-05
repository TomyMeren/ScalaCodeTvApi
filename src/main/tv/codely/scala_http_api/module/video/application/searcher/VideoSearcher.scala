package tv.codely.scala_http_api.module.video.application.searcher

import tv.codely.scala_http_api.module.video.domain.{Video, VideoRepository}

final class VideoSearcher(repository:VideoRepository) {

  def all():Seq[Video] = repository.all()
}