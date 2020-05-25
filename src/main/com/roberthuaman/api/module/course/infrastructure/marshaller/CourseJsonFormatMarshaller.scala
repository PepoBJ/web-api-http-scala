package com.roberthuaman.api.module.course.infrastructure.marshaller

import java.util.UUID

import com.roberthuaman.api.module.course.domain.{Course, CourseId, CourseName, CourseVideos}
import com.roberthuaman.api.module.video.infrastructure.marshaller.VideoJsonFormatMarshaller
import spray.json.DefaultJsonProtocol._
import spray.json.{DeserializationException, JsArray, JsString, JsValue, JsonFormat, RootJsonFormat}

object CourseJsonFormatMarshaller {
  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object CourseIdMarshaller extends JsonFormat[CourseId] {
    def write(value: CourseId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): CourseId = value match {
      case JsString(id) => CourseId(id)
      case _            => throw DeserializationException("Expected 1 string for CourseId")
    }
  }

  implicit object CourseNameMarshaller extends JsonFormat[CourseName] {
    def write(value: CourseName): JsValue = JsString(value.value)

    def read(value: JsValue): CourseName = value match {
      case JsString(name) => CourseName(name)
      case _              => throw DeserializationException("Expected 1 string for CourseName")
    }
  }

  implicit object CoursevideosMarshaller extends JsonFormat[CourseVideos] {
    def write(value: CourseVideos): JsValue =
      JsArray(value.value.map(video => VideoJsonFormatMarshaller.videoFormat.write(video)).toVector)

    def read(value: JsValue): CourseVideos = value match {
      case JsArray(videos) => CourseVideos(videos.map(video => VideoJsonFormatMarshaller.videoFormat.read(video)))
      case _               => throw DeserializationException("Expected 1 array for CourseVideos")
    }
  }

  implicit val videoFormat: RootJsonFormat[Course] = jsonFormat3(
    Course.apply(_: CourseId, _: CourseName, _: CourseVideos)
  )
}
