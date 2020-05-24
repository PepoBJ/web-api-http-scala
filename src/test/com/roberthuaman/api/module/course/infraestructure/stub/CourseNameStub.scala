package com.roberthuaman.api.module.course.infraestructure.stub

import com.roberthuaman.api.module.course.domain.CourseName
import com.roberthuaman.api.module.shared.stub.{IntStub, StringStub}

object CourseNameStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): CourseName = CourseName(value)

  def random: CourseName = CourseName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
