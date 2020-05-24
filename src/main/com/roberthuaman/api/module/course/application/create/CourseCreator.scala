package com.roberthuaman.api.module.course.application.create

import com.roberthuaman.api.module.course.domain.{Course, CourseId, CourseName, CourseRepository, CourseVideos}

final class CourseCreator(repository: CourseRepository) {
  def create(id: CourseId, name: CourseName, videos: CourseVideos): Unit = {
    val course = Course(id, name, videos)

    repository.save(course)
  }
}
