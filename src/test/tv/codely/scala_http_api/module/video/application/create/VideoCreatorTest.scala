package tv.codely.scala_http_api.module.video.application.search

import tv.codely.scala_http_api.module.video.VideoUnitTestCase
import tv.codely.scala_http_api.module.video.application.create.VideoCreator
import tv.codely.scala_http_api.module.video.domain.VideoStub

final class VideoCreatorTest extends VideoUnitTestCase {

  private val creator = new VideoCreator(repository)

  "Video Creator" should {
    "save a Video " in {
      val video = VideoStub.random

      shouldSaveVideo(video)

      creator.create(video.id, video.title, video.duration, video.category) should be()
    }
  }

}
