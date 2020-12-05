package tv.codely.scala_http_api.module.video.infraestructure.stub

import tv.codely.scala_http_api.shared.infraestruture.stub.DurationStub
import tv.codely.scala_http_api.module.video.domain.VideoDuration

import scala.concurrent.duration.Duration

object VideoDurationStub {

  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
