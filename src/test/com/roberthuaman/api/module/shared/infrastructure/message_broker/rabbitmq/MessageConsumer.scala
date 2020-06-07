package com.roberthuaman.api.module.shared.infrastructure.message_broker.rabbitmq

import com.roberthuaman.api.module.shared.domain.Message

trait MessageConsumer {
  def startConsuming(handler: Message => Boolean): Unit
  def hasMessagesToConsume: Boolean
  def isEmpty: Boolean = !hasMessagesToConsume
}
