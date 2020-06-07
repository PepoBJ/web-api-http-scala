package com.roberthuaman.api.module.video.application.create

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.shared.infrastructure.MessagePublisherMock
import com.roberthuaman.api.module.video.domain.{VideoCreatedStub, VideoStub}
import com.roberthuaman.api.module.video.infrastructure.repository.VideoRepositoryMock

final class VideoCreatorShould extends UnitTestCase with VideoRepositoryMock with MessagePublisherMock {
  private val creator = new VideoCreator(repository, messagePublisher)

  "save a video" in {
    val video = VideoStub.random
    val videoCreated = VideoCreatedStub(video)

    repositoryShouldSave(video)

    publisherShouldPublish(videoCreated)

    creator.create(video.id, video.title, video.duration, video.category).shouldBe(())
  }
}
