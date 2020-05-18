package com.roberthuaman.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.Directives.{complete, get, path}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class ScalaHttpApiTest extends AnyWordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  private val routesWithDefinedResponses =
    get {
      path("status") {
        complete(
          HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}""")
        )
      }
    }

  "ScalaHttpApi" should {
    "respond successfully while requesting its status" in {
      Get("/status") ~> routesWithDefinedResponses ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
  }
}
