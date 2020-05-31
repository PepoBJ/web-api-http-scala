package com.roberthuaman.api.module.shared.infrastructure.persistence.doobie

import java.util.UUID

import doobie.Meta
import com.roberthuaman.api.module.video.domain.VideoCategory

import scala.concurrent.duration._

object TypesConversions {
  implicit val uuidMeta: Meta[UUID]                   = Meta[String].timap(UUID.fromString)(_.toString)
  implicit val durationMeta: Meta[FiniteDuration]           = Meta[Long].timap(_.seconds)(_.toSeconds)
  implicit val videoCategoryMeta: Meta[VideoCategory] = Meta[String].timap(VideoCategory.apply)(_.toString)
}
