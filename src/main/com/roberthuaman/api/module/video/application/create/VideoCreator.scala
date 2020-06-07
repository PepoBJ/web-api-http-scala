package com.roberthuaman.api.module.video.application.create

import com.roberthuaman.api.module.shared.domain.MessagePublisher
import com.roberthuaman.api.module.video.domain._

final class VideoCreator(repository: VideoRepository, publisher: MessagePublisher) {
  def create(id: VideoId, title: VideoTitle, duration: VideoDuration, category: VideoCategory): Unit = {
    val video = Video(id, title, duration, category)

    repository.save(video)

    publisher.publish(VideoCreated(video))
  }
}
