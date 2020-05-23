package com.roberthuaman.api.module.video.domain

trait VideoRepository {
  def all(): Seq[Video]

  def save(video: Video): Unit
}
