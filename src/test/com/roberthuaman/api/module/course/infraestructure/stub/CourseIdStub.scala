package com.roberthuaman.api.module.course.infraestructure.stub

import java.util.UUID

import com.roberthuaman.api.module.course.domain.CourseId
import com.roberthuaman.api.module.shared.stub.UuidStub

object CourseIdStub {
  def apply(value: String): CourseId = CourseIdStub(UuidStub(value))

  def apply(value: UUID): CourseId = CourseId(value)

  def random: CourseId = CourseId(UuidStub.random)
}
