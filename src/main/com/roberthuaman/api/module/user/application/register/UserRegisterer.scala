package com.roberthuaman.api.module.user.application.register

import com.roberthuaman.api.module.user.domain.{User, UserId, UserName, UserRepository}

final class UserRegisterer(repository: UserRepository) {
  def register(id: UserId, name: UserName): Unit = {
    val user = User(id, name)

    repository.save(user)
  }
}
