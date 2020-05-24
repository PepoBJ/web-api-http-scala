package com.roberthuaman.api.module.course.application.search

import com.roberthuaman.api.module.course.domain.{Course, CourseRepository}

final class CoursesSearcher(repository: CourseRepository) {
  def all(): Seq[Course] = repository.all()
}
