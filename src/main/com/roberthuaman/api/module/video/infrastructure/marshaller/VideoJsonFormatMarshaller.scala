package com.roberthuaman.api.module.video.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import VideoAttributesJsonFormatMarshaller._
import com.roberthuaman.api.module.video.domain._

object VideoJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit val videoFormat: RootJsonFormat[Video] = jsonFormat(
    Video.apply(_: VideoId, _: VideoTitle, _: VideoDuration, _: VideoCategory),
    "id",
    "title",
    "duration_in_seconds",
    "category"
  )
}
