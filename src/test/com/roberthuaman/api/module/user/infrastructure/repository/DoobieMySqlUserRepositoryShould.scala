package com.roberthuaman.api.module.user.infrastructure.repository

import com.roberthuaman.api.module.user.UserIntegrationTestCase
import com.roberthuaman.api.module.user.domain.UserStub
import doobie.implicits._
import org.scalatest.BeforeAndAfterEach

final class DoobieMySqlUserRepositoryShould extends UserIntegrationTestCase with BeforeAndAfterEach {

  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanUsersTable()
  }

  "return an empty sequence if there're no users" in {
    repository.all().futureValue shouldBe Seq.empty
  }

  "search all existing users" in {
    val users = UserStub.randomSeq

    users.foreach(u => repository.save(u).futureValue)

    repository.all().futureValue shouldBe users
  }
}
