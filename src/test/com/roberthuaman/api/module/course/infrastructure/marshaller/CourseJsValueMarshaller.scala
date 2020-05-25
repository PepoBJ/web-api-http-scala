package com.roberthuaman.api.module.course.infrastructure.marshaller

import com.roberthuaman.api.module.course.domain.Course
import com.roberthuaman.api.module.video.infrastructure.marshaller.VideoJsonFormatMarshaller
import spray.json.{JsArray, JsObject, JsString}

object CourseJsValueMarshaller {
  def marshall(courses: Seq[Course]): JsArray = JsArray(
    courses
      .map(v =>
        JsObject(
          "id" -> JsString(v.id.value.toString),
          "name" -> JsString(v.name.value),
          "videos" -> JsArray(v.videos.value.map(video => VideoJsonFormatMarshaller.videoFormat.write(video)).toVector)
        )
      )
      .toVector
  )
}
