package com.roberthuaman.api.module.user.infrastructure.repository

import com.roberthuaman.api.module.user.UserIntegrationTestCase
import com.roberthuaman.api.module.user.domain.UserStub
import doobie.implicits._

final class DoobieMySqlUserRepositoryShould extends UserIntegrationTestCase {

  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "return an empty sequence if there're no users" in {
    cleanUsersTable()

    repository.all().futureValue shouldBe Seq.empty
  }

  "search all existing users" in {
    cleanUsersTable()

    val users = UserStub.randomSeq

    users.foreach(u => repository.save(u).futureValue)

    repository.all().futureValue shouldBe users
  }
}
