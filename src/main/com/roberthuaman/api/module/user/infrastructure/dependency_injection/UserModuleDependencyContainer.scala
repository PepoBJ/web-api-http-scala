package com.roberthuaman.api.module.user.infrastructure.dependency_injection

import com.roberthuaman.api.module.shared.domain.MessagePublisher
import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import com.roberthuaman.api.module.user.application.register.UserRegisterer
import com.roberthuaman.api.module.user.application.search.UsersSearcher
import com.roberthuaman.api.module.user.domain.UserRepository
import com.roberthuaman.api.module.user.infrastructure.repository.DoobieMySqlUserRepository

import scala.concurrent.ExecutionContext

final class UserModuleDependencyContainer(
    doobieDbConnection: DoobieDbConnection,
    messagePublisher: MessagePublisher
)(implicit executionContext: ExecutionContext) {
  val repository: UserRepository = new DoobieMySqlUserRepository(doobieDbConnection)

  val usersSearcher: UsersSearcher = new UsersSearcher(repository)
  val userRegisterer: UserRegisterer = new UserRegisterer(repository, messagePublisher)
}
