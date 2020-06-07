package com.roberthuaman.api.module.video.domain

import scala.concurrent.duration.FiniteDuration

object VideoStub {
  def apply(
      id: String = VideoIdStub.random.value.toString,
      title: String = VideoTitleStub.random.value.toString,
      duration: FiniteDuration = VideoDurationStub.random.value,
      category: String = VideoCategoryStub.random.toString
  ): Video = Video(id, title, duration, category)

  def random: Video = apply()

  def randomSeq: Seq[Video] = SeqStub.randomOf(apply())
}
