package tv.codely.scala_http_api.module.video.application.search


import tv.codely.scala_http_api.module.video.domain.VideoStub
import tv.codely.scala_http_api.module.video.VideoUnitTestCase
import tv.codely.scala_http_api.module.video.application.searcher.VideoSearcher

final class VideoSearcherTest extends VideoUnitTestCase {

  private val searcher = new VideoSearcher(repository)

  "Video Searcher" should {
    "search all existing videos" in {
      val existingvideo        = VideoStub.random
      val anotherExistingvideo = VideoStub.random
      val existingvideos       = Seq(existingvideo, anotherExistingvideo)

      shouldSearchAllvideos(existingvideos)

      searcher.all() should be(existingvideos)
    }
  }

}
