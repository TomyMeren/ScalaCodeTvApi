package tv.codely.scala_http_api.module.user.infraestructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import tv.codely.scala_http_api.module.user.domain.User

object UserMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users.map(user =>
      JsObject(
        "id" -> JsString(user.id.toString),
        "name" -> JsString(user.name.value)
      )
    ).toVector
  )
}
