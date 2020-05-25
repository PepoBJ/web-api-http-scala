package com.roberthuaman.api.module.user.application.search

import com.roberthuaman.api.module.user.domain.{User, UserRepository}

final class UsersSearcher(repository: UserRepository) {
  def all(): Seq[User] = repository.all()
}
