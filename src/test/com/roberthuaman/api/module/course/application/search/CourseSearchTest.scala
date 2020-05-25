package com.roberthuaman.api.module.course.application.search

import com.roberthuaman.api.module.course.CourseUnitTestCase
import com.roberthuaman.api.module.course.domain.CourseStub

final class CourseSearchTest extends CourseUnitTestCase {
  private val searcher = new CoursesSearcher(repository)

  "Course search" should {
    "search all existing courses" in {
      val course = CourseStub.random
      val anotherCourse = CourseStub.random
      val existingCourse = Seq(course, anotherCourse)

      repositoryShouldSearchAllCourses(existingCourse)

      searcher.all() should be(existingCourse)
    }
  }
}
