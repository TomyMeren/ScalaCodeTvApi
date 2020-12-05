package tv.codely.scala_http_api.module.user.infraestructure.marshaller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}
import tv.codely.scala_http_api.module.user.domain.{User, UserId, UserName}

object UserMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object UserIdMarshaller extends JsonFormat[UserId] {

    def write(value: UserId): JsValue = JsString(value.toString)

    def read(value: JsValue): UserId = value match {
      case JsString(id) => UserId(id)
      case _            => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit object UserNameMarshaller extends JsonFormat[UserName] {

    def write(value: UserName): JsValue = JsString(value.value)

    def read(value: JsValue): UserName = value match {
      case JsString(name) => UserName(name)
      case _              => throw DeserializationException("El stub name debe ser un solo caracted")
    }
  }

  implicit val itemFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserName))
}
