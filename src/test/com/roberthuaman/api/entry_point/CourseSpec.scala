package com.roberthuaman.api.entry_point

import scala.concurrent.duration._
import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import com.roberthuaman.api.module.course.domain.CourseStub
import spray.json._
import com.roberthuaman.api.module.course.infrastructure.marshaller.CourseJsValueMarshaller
import com.roberthuaman.api.module.video.domain.VideoStub

final class CourseSpec extends AcceptanceSpec {
  "save a course" in post(
    "/courses",
    """
      |{
      |  "id": "a00098af-d352-4cce-8372-2b48b97e6942",
      |  "name": "Scala Http Api",
      |  "videos": [
      |     {
      |       "id": "a00098af-d352-4cce-8372-2b77797e6942",
      |       "title": "Levantando el servidor",
      |       "duration": 15,
      |       "category": "Interview"
      |     }
      |  ]
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the system courses" in get("/courses") {
    val expectedCourses = Seq(
      CourseStub(
        id = "a00098af-d352-4cce-8372-2b48b97e6942",
        name = "Scala Http Api",
        videos = Seq(
          VideoStub(
            id = "a00098af-d352-4cce-8372-2b77797e6942",
            title = "Levantando el servidor",
            duration = 15.seconds,
            category = "Interview"
          )
        )
      )
    )

    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe CourseJsValueMarshaller.marshall(expectedCourses)
  }
}
