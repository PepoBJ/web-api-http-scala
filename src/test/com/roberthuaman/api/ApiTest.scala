package com.roberthuaman.api

import org.scalatest.GivenWhenThen
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

final class ApiTest extends AnyWordSpec with GivenWhenThen {
  "Api" should {
    "greet" in {
      Given("a Api")

      val api = new Api

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = api.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
