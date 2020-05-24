package com.roberthuaman.api.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import com.roberthuaman.api.module.course.application.create.CourseCreator
import com.roberthuaman.api.module.course.domain.{CourseId, CourseName, CourseVideos}
import com.roberthuaman.api.module.video.domain.Video
import spray.json.DefaultJsonProtocol

final class CoursePostController(creator: CourseCreator) extends SprayJsonSupport with DefaultJsonProtocol {
  def post(id: String, name: String, videos: Seq[Video]): StandardRoute = {
    creator.create(CourseId(id), CourseName(name), CourseVideos(videos))

    complete(HttpResponse(NoContent))
  }
}
