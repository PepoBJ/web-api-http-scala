package com.roberthuaman.api.module.user.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import com.roberthuaman.api.module.user.domain.{User, UserId, UserName}
import UserAttributesJsonFormatMarshaller._

object UserJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserName))
}
