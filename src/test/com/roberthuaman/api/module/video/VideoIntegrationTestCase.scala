package com.roberthuaman.api.module.video

import com.roberthuaman.api.module.IntegrationTestCase
import com.roberthuaman.api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

protected[video] trait VideoIntegrationTestCase extends IntegrationTestCase {
  private val container = new VideoModuleDependencyContainer

  protected val repository: InMemoryVideoRepository = container.repository
}
