package com.roberthuaman.api.entry_point

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import com.typesafe.config.ConfigFactory
import org.scalatest.concurrent.ScalaFutures
import com.roberthuaman.api.module.shared.infrastructure.config.DbConfig
import com.roberthuaman.api.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.roberthuaman.api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

protected[entry_point] abstract class AcceptanceSpec
    extends AnyWordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {
  implicit val defaultPatience: PatienceConfig =
    PatienceConfig(timeout = Span(0.9, Seconds), interval = Span(15, Millis))

  private val appConfig = ConfigFactory.load("application")
  private val dbConfig = DbConfig(appConfig.getConfig("database"))
  private val actorSystemName = "scala-http-api-acceptance-test"

  private val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)

  protected val userDependencies = new UserModuleDependencyContainer(sharedDependencies.doobieDbConnection)
  protected val videoDependencies =
    new VideoModuleDependencyContainer(sharedDependencies.doobieDbConnection)(sharedDependencies.executionContext)

  private val routes = new Routes(new EntryPointDependencyContainer(userDependencies, videoDependencies))

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection

  protected def posting[T](path: String, request: String)(body: ⇒ T): T =
    HttpRequest(
      method = HttpMethods.POST,
      uri = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(body)

  protected def getting[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)
}
