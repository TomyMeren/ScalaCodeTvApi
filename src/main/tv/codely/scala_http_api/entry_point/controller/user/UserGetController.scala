package tv.codely.scala_http_api.entry_point.controller.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import spray.json.DefaultJsonProtocol
import tv.codely.scala_http_api.module.user.application.search.UserSearcher
import tv.codely.scala_http_api.module.user.infraestructure.marshaller.UserMarshaller._

/**
  * Vamos a ir añadiendo metodos que tenga el User. Get, Put Post. Lo que llamaremos controladores
  */

final class UserGetController(searcher: UserSearcher) extends SprayJsonSupport with DefaultJsonProtocol {

  def get(): StandardRoute = complete(searcher.all())

}
