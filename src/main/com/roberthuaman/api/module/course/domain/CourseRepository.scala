package com.roberthuaman.api.module.course.domain

trait CourseRepository {
  def all(): Seq[Course]

  def save(course: Course): Unit
}
