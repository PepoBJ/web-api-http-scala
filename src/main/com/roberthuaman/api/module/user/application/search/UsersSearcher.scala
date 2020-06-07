package com.roberthuaman.api.module.user.application.search

import com.roberthuaman.api.module.user.domain.{User, UserRepository}

import scala.concurrent.Future

final class UsersSearcher(repository: UserRepository) {
  def all(): Future[Seq[User]] = repository.all()
}
