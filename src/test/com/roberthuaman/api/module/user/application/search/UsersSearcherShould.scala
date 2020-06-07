package com.roberthuaman.api.module.user.application.search

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.user.domain.UserStub
import com.roberthuaman.api.module.user.infrastructure.repository.UserRepositoryMock

final class UsersSearcherShould extends UnitTestCase with UserRepositoryMock {
  private val searcher = new UsersSearcher(repository)

  "search all existing users" in {
    val existingUser = UserStub.random
    val anotherExistingUser = UserStub.random
    val existingUsers = Seq(existingUser, anotherExistingUser)

    repositoryShouldFind(existingUsers)

    searcher.all().futureValue shouldBe existingUsers
  }
}
