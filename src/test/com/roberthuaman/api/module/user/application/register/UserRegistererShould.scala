package com.roberthuaman.api.module.user.application.register

import com.roberthuaman.api.module.user.UserUnitTestCase
import com.roberthuaman.api.module.user.domain.UserStub

final class UserRegistererShould extends UserUnitTestCase {
  private val registerer = new UserRegisterer(repository)

  "save a user" in {
    val user = UserStub.random

    repositoryShouldSave(user)

    registerer.register(user.id, user.name) shouldBe (())
  }
}
