package com.roberthuaman.api.module

import org.scalamock.scalatest.MockFactory
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.time.{Millis, Seconds, Span}

protected[module] trait UnitTestCase extends AnyWordSpec with Matchers with ScalaFutures with MockFactory {
//  implicit val defaultPatience: PatienceConfig =
//    PatienceConfig(timeout = Span(1, Seconds), interval = Span(100, Millis))
}
