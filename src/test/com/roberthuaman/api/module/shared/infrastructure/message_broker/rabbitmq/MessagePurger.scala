package com.roberthuaman.api.module.shared.infrastructure.message_broker.rabbitmq

trait MessagePurger {
  def purgeQueue(): Unit
}
