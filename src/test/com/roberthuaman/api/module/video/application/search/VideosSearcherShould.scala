package com.roberthuaman.api.module.video.application.search

import com.roberthuaman.api.module.video.VideoUnitTestCase
import com.roberthuaman.api.module.video.domain.VideoStub

final class VideosSearcherShould extends VideoUnitTestCase {
  private val searcher = new VideosSearcher(repository)

  "search all existing videos" in {
    val existingVideo = VideoStub.random
    val anotherExistingVideo = VideoStub.random
    val existingVideos = Seq(existingVideo, anotherExistingVideo)

    repositoryShouldFind(existingVideos)

    searcher.all().futureValue shouldBe existingVideos
  }
}
