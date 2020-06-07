package com.roberthuaman.api.module.video.domain

import scala.concurrent.duration._

object VideoDuration {
  def apply(seconds: BigDecimal): VideoDuration = VideoDuration(seconds.longValue().seconds)
}

case class VideoDuration(value: FiniteDuration)
