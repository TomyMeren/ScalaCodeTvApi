package tv.codely.scala_http_api.module.video.domain

import scala.concurrent.duration.{Duration, DurationLong}

object VideoDuration {
  def apply(seconds: BigDecimal): VideoDuration = VideoDuration(seconds.longValue().seconds)
}

case class VideoDuration(value:Duration) {
  override def toString(): String = value.toSeconds.toString
}
