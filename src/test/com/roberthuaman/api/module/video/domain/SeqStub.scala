package com.roberthuaman.api.module.video.domain

import com.roberthuaman.api.module.shared.domain.IntStub

object SeqStub {
  def randomOf[T](apply: => T): Seq[T] = (0 to IntStub.randomBetween(1, 2)).map(_ => apply)
}
