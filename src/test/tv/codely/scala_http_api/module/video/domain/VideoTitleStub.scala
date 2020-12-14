package tv.codely.scala_http_api.module.video.domain

import tv.codely.scala_http_api.module.shared.domain.{IntStub, StringStub}

object VideoTitleStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): VideoTitle = VideoTitle(value)

  def random: VideoTitle = VideoTitle(StringStub.random(IntStub.randomBeetween(minimumChars, maximumChars)))
}
