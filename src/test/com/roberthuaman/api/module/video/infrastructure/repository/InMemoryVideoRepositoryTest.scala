package com.roberthuaman.api.module.video.infrastructure.repository

import com.roberthuaman.api.module.video.VideoIntegrationTestCase
import com.roberthuaman.api.module.video.domain.VideoStub

final class InMemoryVideoRepositoryTest extends VideoIntegrationTestCase {
  "In memory video repository" should {
    "search all existing videos" in {
      val video = VideoStub.random
      val anotherVideo = VideoStub.random
      val videos = Seq(video, anotherVideo)

      repository.save(video)
      repository.save(anotherVideo)

      repository.all() should be(videos)
    }
  }
}
