package com.roberthuaman.api.module.user.infrastructure.stub

import com.roberthuaman.api.module.shared.stub.{IntStub, StringStub}
import com.roberthuaman.api.module.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
