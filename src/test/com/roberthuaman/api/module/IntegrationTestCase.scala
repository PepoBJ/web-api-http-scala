package com.roberthuaman.api.module

import com.roberthuaman.api.module.shared.domain.MessagePublisher
import com.typesafe.config.ConfigFactory
import com.roberthuaman.api.module.shared.infrastructure.config.{DbConfig, MessageBrokerConfig}
import com.roberthuaman.api.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import com.roberthuaman.api.module.shared.infrastructure.message_broker.rabbitmq.RabbitMqChannelFactory
import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

import scala.concurrent.ExecutionContext

protected[api] trait IntegrationTestCase extends UnitTestCase {
  private val actorSystemName = "scala-http-api-integration-test"

  private val appConfig = ConfigFactory.load("application")
  private val dbConfig = DbConfig(appConfig.getConfig("database"))
  private val publisherConfig = MessageBrokerConfig(appConfig.getConfig("message-publisher"))

  protected val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig, publisherConfig)
  implicit protected val executionContext: ExecutionContext = sharedDependencies.executionContext

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
  protected val rabbitMqChannelFactory: RabbitMqChannelFactory = new RabbitMqChannelFactory(publisherConfig)
  protected val messagePublisher: MessagePublisher = sharedDependencies.messagePublisher
}
