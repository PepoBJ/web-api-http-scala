package com.roberthuaman.api.module.user

import com.roberthuaman.api.module.IntegrationTestCase
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.roberthuaman.api.module.user.infrastructure.repository.InMemoryUserRepository

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container = new UserModuleDependencyContainer

  protected val repository: InMemoryUserRepository = container.repository
}
