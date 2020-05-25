package com.roberthuaman.api.module.user.infrastructure.dependency_injection

import com.roberthuaman.api.module.user.application.search.UsersSearcher
import com.roberthuaman.api.module.user.infrastructure.repository.InMemoryUserRepository

final class UserModuleDependencyContainer {
  val repository = new InMemoryUserRepository

  val usersSearcher = new UsersSearcher(repository)
}
