package com.roberthuaman.api.module.course.domain

import com.roberthuaman.api.module.video.domain.Video

object CourseStub {
  def apply(
      id: String = CourseIdStub.random.value.toString,
      name: String = CourseNameStub.random.toString,
      videos: Seq[Video] = CourseVideosStub.random.value
  ): Course = Course(id, name, videos)

  def random: Course = apply()
}
