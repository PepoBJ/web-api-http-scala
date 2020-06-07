package com.roberthuaman.api.module.user.application.search

import com.roberthuaman.api.module.user.UserUnitTestCase
import com.roberthuaman.api.module.user.domain.UserStub

final class UsersSearcherShould extends UserUnitTestCase {
  private val searcher = new UsersSearcher(repository)

  "search all existing users" in {
    val existingUser = UserStub.random
    val anotherExistingUser = UserStub.random
    val existingUsers = Seq(existingUser, anotherExistingUser)

    repositoryShouldFind(existingUsers)

    searcher.all().futureValue shouldBe existingUsers
  }
}
