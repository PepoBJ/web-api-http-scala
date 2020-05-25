package com.roberthuaman.api.module.course

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.course.domain.{Course, CourseRepository}

protected[course] trait CourseUnitTestCase extends UnitTestCase {
  protected val repository: CourseRepository = mock[CourseRepository]

  protected def repositoryShouldSaveCourse(course: Course): Unit =
    (repository.save _)
      .expects(course)
      .returning(())

  protected def repositoryShouldSearchAllCourses(courses: Seq[Course]): Unit =
    (repository.all _)
      .expects()
      .returning(courses)
}
