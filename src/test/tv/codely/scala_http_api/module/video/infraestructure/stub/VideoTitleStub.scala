package tv.codely.scala_http_api.module.video.infraestructure.stub

import tv.codely.scala_http_api.shared.infraestruture.stub.{IntStub, StringStub}
import tv.codely.scala_http_api.module.video.domain.VideoTitle

object VideoTitleStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): VideoTitle = VideoTitle(value)

  def random: VideoTitle = VideoTitle(
    StringStub.random(IntStub.randomBeetween(minimumChars,maximumChars)))
}
