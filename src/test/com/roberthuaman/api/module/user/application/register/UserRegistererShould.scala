package com.roberthuaman.api.module.user.application.register

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.shared.infrastructure.MessagePublisherMock
import com.roberthuaman.api.module.user.domain.{UserRegisteredStub, UserStub}
import com.roberthuaman.api.module.user.infrastructure.repository.UserRepositoryMock

final class UserRegistererShould extends UnitTestCase with UserRepositoryMock with MessagePublisherMock {
  private val registerer = new UserRegisterer(repository, messagePublisher)

  "save a user" in {
    val user = UserStub.random
    val userRegistered = UserRegisteredStub(user)

    repositoryShouldSave(user)
    publisherShouldPublish(userRegistered)

    registerer.register(user.id, user.name).shouldBe(())
  }
}
