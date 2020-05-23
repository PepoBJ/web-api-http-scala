package com.roberthuaman.api.module.user.infrastructure.stub

import java.util.UUID

import com.roberthuaman.api.module.shared.stub.UuidStub
import com.roberthuaman.api.module.user.domain.UserId

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
