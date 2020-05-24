package com.roberthuaman.api.module.course.domain

import com.roberthuaman.api.module.video.domain.Video

object Course {
  def apply(id: String, name: String, videos: Seq[Video]): Course = Course(
    CourseId(id),
    CourseName(name),
    CourseVideos(videos)
  )
}

case class Course(id: CourseId, name: CourseName, videos: CourseVideos)
