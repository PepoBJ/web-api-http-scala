package com.roberthuaman.api.module.shared.domain

import com.roberthuaman.api.module.shared.domain.Message.application

object Message {
  val application: String = "roberthuaman_scala_api"
}

abstract class Message {
  val subType: String
  lazy val `type`: String = s"$application.$subType"
}
