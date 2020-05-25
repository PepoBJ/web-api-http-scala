package com.roberthuaman.api.module

import org.scalamock.scalatest.MockFactory
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

protected[module] trait UnitTestCase extends AnyWordSpec with Matchers with MockFactory
