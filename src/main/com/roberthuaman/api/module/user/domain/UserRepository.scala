package com.roberthuaman.api.module.user.domain

trait UserRepository {
  def all(): Seq[User]
}
