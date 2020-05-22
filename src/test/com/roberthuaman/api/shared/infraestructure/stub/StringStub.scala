package com.roberthuaman.api.shared.infraestructure.stub

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = Random.alphanumeric take numChars mkString ""
}
