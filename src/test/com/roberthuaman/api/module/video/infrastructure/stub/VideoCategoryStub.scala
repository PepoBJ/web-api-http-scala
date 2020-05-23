package com.roberthuaman.api.module.video.infrastructure.stub

import com.roberthuaman.api.module.shared.stub.IntStub
import com.roberthuaman.api.module.video.domain.VideoCategory

object VideoCategoryStub {
  private val categories = Seq("Screencast", "Interviews")

  def apply(value: String): VideoCategory = VideoCategory(value)

  def random: VideoCategory = VideoCategory(categories(IntStub.randomBetween(min = 0, max = categories.size - 1)))
}
