package com.roberthuaman.api.module.video.infrastructure.stub

import com.roberthuaman.api.module.shared.stub.DurationStub
import com.roberthuaman.api.module.video.domain.VideoDuration

import scala.concurrent.duration.Duration

object VideoDurationStub {
  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
