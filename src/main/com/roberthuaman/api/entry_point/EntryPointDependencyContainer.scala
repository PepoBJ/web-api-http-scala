package com.roberthuaman.api.entry_point

import com.roberthuaman.api.entry_point.controller.course.{CourseGetController, CoursePostController}
import com.roberthuaman.api.entry_point.controller.status.StatusGetController
import com.roberthuaman.api.entry_point.controller.user.UserGetController
import com.roberthuaman.api.entry_point.controller.video.{VideoGetController, VideoPostController}
import com.roberthuaman.api.module.course.infraestructure.dependency_injection.CourseModuleDependencyContainer
import com.roberthuaman.api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.roberthuaman.api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
    userDependencies: UserModuleDependencyContainer,
    videoDependencies: VideoModuleDependencyContainer,
    courseDependencies: CourseModuleDependencyContainer
) {
  val statusGetController = new StatusGetController

  val userGetController = new UserGetController(userDependencies.usersSearcher)

  val videoGetController = new VideoGetController(videoDependencies.videosSearcher)
  val videoPostController = new VideoPostController(videoDependencies.videoCreator)

  val courseGetController = new CourseGetController(courseDependencies.coursesSearcher)
  val coursePostController = new CoursePostController(courseDependencies.courseCreator)
}
