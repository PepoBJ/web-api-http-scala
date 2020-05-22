package com.roberthuaman.api

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.roberthuaman.api.user.infrastructure.marshaller.UserMarshaller
import com.roberthuaman.api.user.infrastructure.stub.UserStub
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import spray.json._

final class ScalaHttpApiTest extends AnyWordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  "ScalaHttpApi" should {
    "respond successfully while requesting its status" in {
      Get("/status") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }

    "return pong while asking a ping" in {
      Get("/ping") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"data":"pong"}"""
      }
    }

    "return all the system users" in {
      Get("/users") ~> Routes.all ~> check {
        val expectedUsers = Seq(
          UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Robert"),
          UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Junior")
        )

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
      }
    }
  }
}
