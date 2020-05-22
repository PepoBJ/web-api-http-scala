package com.roberthuaman.api.user.infrastructure.marshaller

import com.roberthuaman.api.user.domain.User
import spray.json.{JsArray, JsObject, JsString}

object UserMarshaller {
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
