package tv.codely.scala_http_api.entry_point

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import spray.json._
import tv.codely.scala_http_api.module.course.infraestructure.marshaller.CourseMarshallerr
import tv.codely.scala_http_api.module.course.infraestructure.stub.CourseStub

final class CourseSpect extends AcceptanceScpec {

  "respond sytem courses while requesting a stub" in get("/courses") {

    val expectedCourse = Seq(
      CourseStub(
        id = "5654gdfg-260b-420a-b08c-654645645",
        title = "scala para tontos",
        numlecciones = 3,
        profesor = "tomy"
      )
    )

    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe CourseMarshallerr.marshall(expectedCourse) //TODO: volver a CourseMarshaller  - r
  }

}
