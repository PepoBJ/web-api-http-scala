package com.roberthuaman.api.module.shared.infrastructure.marshaller

import spray.json._
import com.roberthuaman.api.module.shared.domain.Message
import com.roberthuaman.api.module.user.domain.UserRegistered
import com.roberthuaman.api.module.video.domain.VideoCreated
import spray.json.{
  DefaultJsonProtocol,
  DeserializationException,
  JsString,
  JsValue,
  RootJsonFormat,
  SerializationException
}
import com.roberthuaman.api.module.video.infrastructure.marshaller.VideoCreatedJsonFormatMarshaller._
import com.roberthuaman.api.module.user.infrastructure.marshaller.UserRegisteredJsonFormatMarshaller._

object MessageJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit object MessageMarshaller extends RootJsonFormat[Message] {
    override def write(m: Message): JsValue = m match {
      case vc: VideoCreated   => vc.toJson
      case ur: UserRegistered => ur.toJson
      case unknown            => throw new SerializationException(s"Unknown message type to write <${unknown.getClass}>")
    }

    override def read(jv: JsValue): Message = jv.asJsObject.getFields("type") match {
      case Seq(JsString("roberthuaman_scala_api.video_created"))   => jv.convertTo[VideoCreated]
      case Seq(JsString("roberthuaman_scala_api.user_registered")) => jv.convertTo[UserRegistered]
      case Seq(JsString(unknown)) =>
        throw DeserializationException(s"Unknown message type to read <$unknown>")
    }
  }
}
