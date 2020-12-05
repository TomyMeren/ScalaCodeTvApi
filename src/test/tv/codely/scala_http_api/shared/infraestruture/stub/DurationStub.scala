package tv.codely.scala_http_api.shared.infraestruture.stub

import scala.concurrent.duration.{Duration, DurationLong}

object DurationStub {
  def random:Duration = IntStub.randomUnsigned().minutes
}
