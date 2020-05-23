package com.roberthuaman.api.module.video.infrastructure.stub

import com.roberthuaman.api.module.video.domain.Video

import scala.concurrent.duration.Duration

object VideoStub {
  def apply(
      id: String = VideoIdStub.random.value.toString,
      title: String = VideoTitleStub.random.toString,
      duration: Duration = VideoDurationStub.random.value,
      category: String = VideoCategoryStub.random.toString
  ): Video = Video(id, title, duration, category)

  def random: Video = apply()
}
