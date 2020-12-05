package tv.codely.scala_http_api.entry_point

import spray.json._
import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import tv.codely.scala_http_api.module.user.infraestructure.marshaller.UserMarshaller
import tv.codely.scala_http_api.module.user.infraestructure.stub.UserStub

final class UserSpec extends AcceptanceScpec {

  "respond sytem users while requesting a stub" in get("/users") {

    val expectedUsers = Seq(
      UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
      UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
    )

    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
  }
}
