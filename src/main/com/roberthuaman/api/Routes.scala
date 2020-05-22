package com.roberthuaman.api

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.roberthuaman.api.user.domain.User
import com.roberthuaman.api.user.infrastructure.UserMarshaller._

object Routes {
  private val systemUsers = Seq(
    User("deacd129-d419-4552-9bfc-0723c3c4f56a", "Robert"),
    User("b62f767f-7160-4405-a4af-39ebb3635c17", "Junior")
  )

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
      } ~
      path("users") {
        complete(systemUsers)
      }
  }
}
