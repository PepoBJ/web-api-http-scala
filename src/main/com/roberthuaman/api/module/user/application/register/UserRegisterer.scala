package com.roberthuaman.api.module.user.application.register

import com.roberthuaman.api.module.shared.domain.MessagePublisher
import com.roberthuaman.api.module.user.domain.{User, UserId, UserName, UserRegistered, UserRepository}

final class UserRegisterer(repository: UserRepository, publisher: MessagePublisher) {
  def register(id: UserId, name: UserName): Unit = {
    val user = User(id, name)

    repository.save(user)

    publisher.publish(UserRegistered(user))
  }
}
