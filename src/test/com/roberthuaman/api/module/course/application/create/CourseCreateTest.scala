package com.roberthuaman.api.module.course.application.create

import com.roberthuaman.api.module.course.CourseUnitTestCase
import com.roberthuaman.api.module.course.domain.CourseStub

final class CourseCreateTest extends CourseUnitTestCase {
  private val creator = new CourseCreator(repository)

  "Course creator" should {
    "save a course" in {
      val course = CourseStub.random

      repositoryShouldSaveCourse(course)

      creator.create(course.id, course.name, course.videos) should be(())
    }
  }
}
