package com.roberthuaman.api.entry_point.controller.course

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import com.roberthuaman.api.module.course.application.search.CoursesSearcher
import spray.json.DefaultJsonProtocol
import com.roberthuaman.api.module.course.infrastructure.marshaller.CourseJsonFormatMarshaller._

final class CourseGetController(searcher: CoursesSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
