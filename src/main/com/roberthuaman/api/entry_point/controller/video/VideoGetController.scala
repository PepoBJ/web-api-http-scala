package com.roberthuaman.api.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.StandardRoute
import akka.http.scaladsl.server.Directives.complete
import spray.json.DefaultJsonProtocol
import com.roberthuaman.api.module.video.application.search.VideosSearcher
import com.roberthuaman.api.module.video.infrastructure.marshaller.VideoJsonFormatMarshaller._

final class VideoGetController(searcher: VideosSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
