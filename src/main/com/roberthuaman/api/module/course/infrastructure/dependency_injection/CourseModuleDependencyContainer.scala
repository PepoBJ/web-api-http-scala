package com.roberthuaman.api.module.course.infrastructure.dependency_injection

import com.roberthuaman.api.module.course.application.create.CourseCreator
import com.roberthuaman.api.module.course.application.search.CoursesSearcher
import com.roberthuaman.api.module.course.infrastructure.repository.InMemoryCourseRepository

final class CourseModuleDependencyContainer {
  val repository = new InMemoryCourseRepository

  val coursesSearcher = new CoursesSearcher(repository)
  val courseCreator = new CourseCreator(repository)
}
