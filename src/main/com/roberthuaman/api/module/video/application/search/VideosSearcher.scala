package com.roberthuaman.api.module.video.application.search

import com.roberthuaman.api.module.video.domain.{Video, VideoRepository}

import scala.concurrent.Future

final class VideosSearcher(repository: VideoRepository) {
  def all(): Future[Seq[Video]] = repository.all()
}
