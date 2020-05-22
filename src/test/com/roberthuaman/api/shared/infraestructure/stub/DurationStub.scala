package com.roberthuaman.api.shared.infraestructure.stub

import scala.concurrent.duration._

object DurationStub {
  def random: Duration = IntStub.randomUnsigned().minutes
}
