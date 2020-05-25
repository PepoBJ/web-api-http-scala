package com.roberthuaman.api.module.video.application.create

import com.roberthuaman.api.module.video.VideoUnitTestCase
import com.roberthuaman.api.module.video.domain.VideoStub

final class VideoCreatorTest extends VideoUnitTestCase {
  private val creator = new VideoCreator(repository)

  "Videos Creator" should {
    "save a video" in {
      val video = VideoStub.random

      repositoryShouldSave(video)

      creator.create(video.id, video.title, video.duration, video.category) should be(())
    }
  }
}
