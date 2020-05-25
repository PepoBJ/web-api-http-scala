package com.roberthuaman.api.module.course.domain

import com.roberthuaman.api.module.video.domain.{
  Video,
  VideoCategoryStub,
  VideoDurationStub,
  VideoIdStub,
  VideoTitleStub
}

object CourseVideosStub {
  def apply(value: Seq[Video]): CourseVideos = CourseVideos(value)

  def random: CourseVideos = CourseVideos(
    Seq(
      Video(
        VideoIdStub.random.value.toString,
        VideoTitleStub.random.toString,
        VideoDurationStub.random.value,
        VideoCategoryStub.random.toString
      )
    )
  )
}
