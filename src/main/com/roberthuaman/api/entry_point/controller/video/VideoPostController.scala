package com.roberthuaman.api.entry_point.controller.video

import scala.concurrent.duration.FiniteDuration
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.StandardRoute
import com.roberthuaman.api.module.video.application.create.VideoCreator
import akka.http.scaladsl.server.Directives.complete
import com.roberthuaman.api.module.video.domain.{VideoCategory, VideoDuration, VideoId, VideoTitle}

final class VideoPostController(creator: VideoCreator) {
  def post(id: String, title: String, duration: FiniteDuration, category: String): StandardRoute = {
    creator.create(VideoId(id), VideoTitle(title), VideoDuration(duration), VideoCategory(category))

    complete(HttpResponse(NoContent))
  }
}
