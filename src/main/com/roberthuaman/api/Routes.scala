package com.roberthuaman.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object Routes {
  val all: Route = get {
    path("status") {
      complete(
        HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}""")
      )
    } ~
      path("ping") {
        complete(
          HttpEntity(ContentTypes.`application/json`, """{"data":"pong"}""")
        )
      }
  }
}
