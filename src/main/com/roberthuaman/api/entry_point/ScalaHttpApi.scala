package com.roberthuaman.api.entry_point

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import com.roberthuaman.api.module.shared.infrastructure.config.DbConfig
import com.roberthuaman.api.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.roberthuaman.api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object ScalaHttpApi {
  def main(args: Array[String]): Unit = {
    val appConfig = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host = serverConfig.getString("http-server.host")
    val port = serverConfig.getInt("http-server.port")

    val dbConfig = DbConfig(appConfig.getConfig("database"))

    val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)

    implicit val system: ActorSystem = sharedDependencies.actorSystem
    implicit val materializer: ActorMaterializer = sharedDependencies.materializer
    implicit val executionContext: ExecutionContext = sharedDependencies.executionContext

    val container = new EntryPointDependencyContainer(
      new UserModuleDependencyContainer(sharedDependencies.doobieDbConnection),
      new VideoModuleDependencyContainer(sharedDependencies.doobieDbConnection)
    )

    val routes = new Routes(container)

    val bindingFuture = Http().bindAndHandle(routes.all, host, port)

    bindingFuture.failed.foreach { t =>
      println(s"Failed to bind to http://$host:$port/:")
      pprint.log(t)
    }

    // let it run until user presses return
    println(s"Server online at http://$host:$port/\nPress RETURN to stop...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => sharedDependencies.actorSystem.terminate())
  }
}
