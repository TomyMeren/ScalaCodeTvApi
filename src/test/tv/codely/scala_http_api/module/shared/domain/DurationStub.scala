package tv.codely.scala_http_api.module.shared.domain

import scala.concurrent.duration.{Duration, DurationLong}

object DurationStub {
  def random:Duration = IntStub.randomUnsigned().minutes
}