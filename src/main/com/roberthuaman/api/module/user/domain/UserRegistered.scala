package com.roberthuaman.api.module.user.domain

import com.roberthuaman.api.module.shared.domain.Message

object UserRegistered {
  def apply(id: String, name: String): UserRegistered = apply(UserId(id), UserName(name))

  def apply(user: User): UserRegistered = apply(user.id, user.name)
}

final case class UserRegistered(id: UserId, name: UserName) extends Message {
  override val subType: String = "user_registered"
}
