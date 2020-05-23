package com.roberthuaman.api.module.video.infrastructure.stub

import java.util.UUID

import com.roberthuaman.api.module.shared.stub.UuidStub
import com.roberthuaman.api.module.user.domain.UserId
import com.roberthuaman.api.module.video.domain.VideoId

object VideoIdStub {
  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value: UUID): VideoId = VideoId(value)

  def random: UserId = UserId(UuidStub.random)
}
