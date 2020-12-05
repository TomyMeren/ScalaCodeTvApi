package tv.codely.scala_http_api.module.video.infraestructure.stub

import java.util.UUID

import tv.codely.scala_http_api.shared.infraestruture.stub.UuidStub
import tv.codely.scala_http_api.module.video.domain.VideoId

object VideoIdStub {

  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value:UUID):VideoId = VideoId(value)

  def random: VideoId = VideoId(UuidStub.random)
}
