package com.roberthuaman.api.module.video.domain

import java.util.UUID

import com.roberthuaman.api.module.shared.domain.UuidStub

object VideoIdStub {
  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value: UUID): VideoId = VideoId(value)

  def random: VideoId = VideoId(UuidStub.random)
}
