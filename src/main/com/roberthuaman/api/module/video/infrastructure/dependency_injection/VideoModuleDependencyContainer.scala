package com.roberthuaman.api.module.video.infrastructure.dependency_injection

import com.roberthuaman.api.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import com.roberthuaman.api.module.video.application.create.VideoCreator
import com.roberthuaman.api.module.video.application.search.VideosSearcher
import com.roberthuaman.api.module.video.domain.VideoRepository
import com.roberthuaman.api.module.video.infrastructure.repository.DoobieMySqlVideoRepository

import scala.concurrent.ExecutionContext

final class VideoModuleDependencyContainer(
    doobieDbConnection: DoobieDbConnection
)(implicit executionContext: ExecutionContext) {
  val repository: VideoRepository = new DoobieMySqlVideoRepository(doobieDbConnection)

  val videosSearcher: VideosSearcher = new VideosSearcher(repository)
  val videoCreator: VideoCreator = new VideoCreator(repository)
}
