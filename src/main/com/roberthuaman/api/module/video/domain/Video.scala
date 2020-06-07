package com.roberthuaman.api.module.video.domain

import scala.concurrent.duration.FiniteDuration

object Video {
  def apply(id: String, title: String, duration: FiniteDuration, category: String): Video = Video(
    VideoId(id),
    VideoTitle(title),
    VideoDuration(duration),
    VideoCategory(category)
  )
}

case class Video(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory)
