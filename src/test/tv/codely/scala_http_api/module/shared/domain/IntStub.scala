package tv.codely.scala_http_api.shared.infraestruture.stub

import scala.util.Random

object IntStub {
  def random: Int = Random.nextInt()

  def randomUnsigned(max: Int = Int.MaxValue - 1):Int = randomBeetween(0, max)

  def randomBeetween(min:Int, max:Int):Int = Random.nextInt((max - min)  + 1) //TODO: entre 0 y ese valor??
}
