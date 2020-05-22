package com.roberthuaman.api.user.infrastructure.stub

import java.util.UUID

import com.roberthuaman.api.shared.infraestructure.stub.UuidStub
import com.roberthuaman.api.user.domain.UserId

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
