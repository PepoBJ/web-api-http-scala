package com.roberthuaman.api.module.course

import com.roberthuaman.api.module.IntegrationTestCase
import com.roberthuaman.api.module.course.infrastructure.dependency_injection.CourseModuleDependencyContainer
import com.roberthuaman.api.module.course.infrastructure.repository.InMemoryCourseRepository

protected[course] trait CourseIntegrationTestCase extends IntegrationTestCase {
  private val container = new CourseModuleDependencyContainer

  protected val repository: InMemoryCourseRepository = container.repository
}
