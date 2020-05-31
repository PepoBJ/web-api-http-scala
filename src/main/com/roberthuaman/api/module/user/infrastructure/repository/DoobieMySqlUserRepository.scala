package com.roberthuaman.api.module.user.infrastructure.repository

import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import com.roberthuaman.api.module.user.domain.{User, UserRepository}
import doobie.implicits._
import scala.concurrent.{ExecutionContext, Future}


final class DoobieMySqlUserRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
  extends UserRepository {
  override def all(): Future[Seq[User]] = {
    db.read(sql"SELECT user_id, name FROM users".query[User].to[Seq])
  }

  override def save(user: User): Future[Unit] =
    sql"INSERT INTO users(user_id, name) VALUES (${user.id}, ${user.name})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
