package com.roberthuaman.api.module.course.infrastructure.repository

import com.roberthuaman.api.module.course.domain.Course
import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import com.roberthuaman.api.module.video.domain.VideoRepository

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMySqlCourseRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
  extends VideoRepository {
  override def all(): Future[Seq[Course]] =
    db.read(sql"SELECT course_id, name, video_id FROM courses".query[Course].to[Seq])

  override def save(course: Course): Future[Unit] =
    sql"INSERT INTO videos(video_id, title, duration_in_seconds, category) VALUES (${course.id}, ${course.title}, ${course.duration}, ${course.category})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
