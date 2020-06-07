package com.roberthuaman.api.module.user

import com.roberthuaman.api.module.IntegrationTestCase
import com.roberthuaman.api.module.user.domain.UserRepository
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container = new UserModuleDependencyContainer(doobieDbConnection)

  protected val repository: UserRepository = container.repository
}
