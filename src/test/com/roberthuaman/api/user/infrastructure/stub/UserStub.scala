package com.roberthuaman.api.user.infrastructure.stub

import com.roberthuaman.api.user.domain.User

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UserNameStub.random.value
  ): User = User(id, name)

  def random: User = apply()
}
