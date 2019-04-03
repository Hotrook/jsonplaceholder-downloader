package com.hotrook

import java.net.URL

import play.api.libs.json.{JsValue, Json}

import scala.io.Source

class PostDownloader {

  def createList(jsonParsed: JsValue, result : List[JsValue]) : List[JsValue] = {
    jsonParsed.head.toOption match {
      case Some(value) => createList(jsonParsed.tail.get, value :: result)
      case None => result.reverse
    }
  }

  def downloadPosts(url: URL) = {
    val json = Source.fromURL(url).mkString
    val jsonParsed = Json.parse(json)

    createList(jsonParsed, List())
  }

}
