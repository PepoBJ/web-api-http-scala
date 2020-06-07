package com.roberthuaman.api.entry_point

import com.roberthuaman.api.entry_point.controller.status.StatusGetController
import com.roberthuaman.api.entry_point.controller.user.{UserGetController, UserPostController}
import com.roberthuaman.api.entry_point.controller.video.{VideoGetController, VideoPostController}
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.roberthuaman.api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
    userDependencies: UserModuleDependencyContainer,
    videoDependencies: VideoModuleDependencyContainer
) {
  val statusGetController = new StatusGetController

  val userGetController = new UserGetController(userDependencies.usersSearcher)
  val userPostController = new UserPostController(userDependencies.userRegisterer)

  val videoGetController = new VideoGetController(videoDependencies.videosSearcher)
  val videoPostController = new VideoPostController(videoDependencies.videoCreator)
}
