package com.roberthuaman.api.module.video.application.search

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.video.domain.VideoStub
import com.roberthuaman.api.module.video.infrastructure.repository.VideoRepositoryMock

final class VideosSearcherShould extends UnitTestCase with VideoRepositoryMock {
  private val searcher = new VideosSearcher(repository)

  "search all existing videos" in {
    val existingVideo = VideoStub.random
    val anotherExistingVideo = VideoStub.random
    val existingVideos = Seq(existingVideo, anotherExistingVideo)

    repositoryShouldFind(existingVideos)

    searcher.all().futureValue shouldBe existingVideos
  }
}
