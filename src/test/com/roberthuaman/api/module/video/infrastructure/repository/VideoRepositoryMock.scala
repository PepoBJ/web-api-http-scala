package com.roberthuaman.api.module.video.infrastructure.repository

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.video.domain.{Video, VideoRepository}
import org.scalamock.scalatest.MockFactory

import scala.concurrent.Future

protected[video] trait VideoRepositoryMock extends MockFactory {
  this: UnitTestCase => // Make mandatory to also extend UnitTestCase in order to avoid using mocks in any other kind of test.

  protected val repository: VideoRepository = mock[VideoRepository]

  protected def repositoryShouldSave(video: Video): Unit =
    (repository.save _)
      .expects(video)
      .returning(Future.unit)

  protected def repositoryShouldFind(videos: Seq[Video]): Unit =
    (repository.all _)
      .expects()
      .returning(Future.successful(videos))
}
