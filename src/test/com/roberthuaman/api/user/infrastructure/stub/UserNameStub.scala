package com.roberthuaman.api.user.infrastructure.stub

import com.roberthuaman.api.shared.infraestructure.stub.{IntStub, StringStub}
import com.roberthuaman.api.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
