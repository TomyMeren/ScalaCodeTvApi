package tv.codely.scala_http_api.module.video.infraestructure.stub

import tv.codely.scala_http_api.shared.infraestruture.stub.{IntStub, StringStub}
import tv.codely.scala_http_api.module.video.domain.VideoCategory

object VideoCategoryStub {
  private val categories = Seq("Screencast","Interview")

  def apply(value: String): VideoCategory = VideoCategory(value)

  def random: VideoCategory = VideoCategory(categories(IntStub.randomBeetween(0,categories.length -1)))
}
