package com.roberthuaman.api.entry_point.controller.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.Directives.complete
import spray.json.DefaultJsonProtocol
import com.roberthuaman.api.module.user.application.search.UsersSearcher
import com.roberthuaman.api.module.user.infrastructure.marshaller.UserJsonFormatMarshaller._

final class UserGetController(searcher: UsersSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
