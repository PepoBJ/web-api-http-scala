package com.roberthuaman.api.module.video.infrastructure.repository

import com.roberthuaman.api.module.video.VideoIntegrationTestCase
import com.roberthuaman.api.module.video.domain.VideoStub
import doobie.implicits._
import org.scalatest.BeforeAndAfterEach

final class DoobieMySqlVideoRepositoryShould extends VideoIntegrationTestCase with BeforeAndAfterEach {
  private def cleanVideosTable() =
    sql"TRUNCATE TABLE videos".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  override protected def beforeEach(): Unit = {
    super.beforeEach()
    cleanVideosTable()
  }

  "return an empty sequence if there're no videos" in {
    repository.all().futureValue shouldBe Seq.empty
  }

  "search all existing videos" in {
    val videos = VideoStub.randomSeq

    videos.foreach(v => repository.save(v).futureValue)

    repository.all().futureValue shouldBe videos
  }
}
