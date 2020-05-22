package com.roberthuaman.api.user.infrastructure

import java.util.UUID

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.roberthuaman.api.user.domain.{User, UserId, UserName}
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat, RootJsonFormat}

object UserMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object UserNameMarshaller extends JsonFormat[UserName] {
    def write(value: UserName): JsValue = JsString(value.value)

    def read(value: JsValue): UserName = value match {
      case JsString(name) => UserName(name)
      case _              => throw DeserializationException("Expected 1 string for UserName")
    }
  }

  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    def write(value: UserId): JsValue = JsString(value.value.toString)

    def read(value: JsValue): UserId = value match {
      case JsString(id) => UserId(id)
      case _            => throw DeserializationException("Expected 1 string for UserId")
    }
  }

  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserName))
}
