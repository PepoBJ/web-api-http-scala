package com.roberthuaman.api.module.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}
import com.roberthuaman.api.module.user.domain.User

object UserJsValueMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users
      .map(u =>
        JsObject(
          "id" -> JsString(u.id.value.toString),
          "name" -> JsString(u.name.value)
        )
      )
      .toVector
  )
}
