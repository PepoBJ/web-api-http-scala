package com.roberthuaman.api.module.shared.infrastructure

import com.roberthuaman.api.module.UnitTestCase
import com.roberthuaman.api.module.shared.domain.{Message, MessagePublisher}
import org.scalamock.scalatest.MockFactory

protected[module] trait MessagePublisherMock extends MockFactory {
  this: UnitTestCase => // Make mandatory to also extend UnitTestCase in order to avoid using mocks in any other kind of test.

  protected val messagePublisher: MessagePublisher = mock[MessagePublisher]

  protected def publisherShouldPublish(message: Message): Unit =
    (messagePublisher.publish _)
      .expects(message)
      .returning(())
}
