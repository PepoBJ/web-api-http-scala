package com.roberthuaman.api.module.shared.infrastructure.persistence.doobie

import cats.effect.{ContextShift, IO}
import doobie.Transactor
import doobie.syntax.ConnectionIOOps
import doobie.util.transactor.Transactor.Aux
import com.roberthuaman.api.module.shared.infrastructure.config.DbConfig
import doobie.util.ExecutionContexts

import scala.concurrent.Future

final class DoobieDbConnection(dbConfig: DbConfig) {
  implicit val cs: ContextShift[IO] = IO.contextShift(ExecutionContexts.synchronous)

  val transactor: Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    dbConfig.driver,
    dbConfig.url,
    dbConfig.user,
    dbConfig.password
  )

  def read[T](query: ConnectionIOOps[T]): Future[T] = query.transact(transactor).unsafeToFuture()
}
