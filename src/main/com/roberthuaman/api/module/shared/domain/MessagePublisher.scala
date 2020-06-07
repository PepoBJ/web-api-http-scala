package com.roberthuaman.api.module.shared.domain

trait MessagePublisher {
  def publish[T <: Message](message: T): Unit
}
