package com.roberthuaman.api.module.user.infrastructure.dependency_injection

import com.roberthuaman.api.module.user.application.UsersSearcher

final class UserModuleDependencyContainer {
  val usersSearcher = new UsersSearcher
}
