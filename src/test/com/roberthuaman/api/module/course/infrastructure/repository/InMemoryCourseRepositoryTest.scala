package com.roberthuaman.api.module.course.infrastructure.repository

import com.roberthuaman.api.module.course.CourseIntegrationTestCase
import com.roberthuaman.api.module.course.domain.CourseStub

final class InMemoryCourseRepositoryTest extends CourseIntegrationTestCase {
  "In memory course repository" should {
    "search all existing courses" in {
      val course = CourseStub.random
      val anotherCourse = CourseStub.random
      val existingCourses = Seq(course, anotherCourse)

      repository.save(course)
      repository.save(anotherCourse)

      repository.all() should be(existingCourses)
    }
  }
}
