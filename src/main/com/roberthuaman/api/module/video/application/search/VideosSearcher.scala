package com.roberthuaman.api.module.video.application.search

import com.roberthuaman.api.module.video.domain.{Video, VideoRepository}

final class VideosSearcher(repository: VideoRepository) {
  def all(): Seq[Video] = repository.all()
}
