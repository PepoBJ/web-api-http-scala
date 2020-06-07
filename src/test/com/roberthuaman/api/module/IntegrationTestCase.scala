package com.roberthuaman.api.module

import com.typesafe.config.ConfigFactory
import com.roberthuaman.api.module.shared.infrastructure.config.DbConfig
import com.roberthuaman.api.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

import scala.concurrent.ExecutionContext

protected[api] trait IntegrationTestCase extends UnitTestCase {
  private val appConfig = ConfigFactory.load("application")
  private val dbConfig = DbConfig(appConfig.getConfig("database"))
  private val actorSystemName = "scala-http-api-integration-test"

  protected val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)
  implicit protected val executionContext: ExecutionContext = sharedDependencies.executionContext

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
}
