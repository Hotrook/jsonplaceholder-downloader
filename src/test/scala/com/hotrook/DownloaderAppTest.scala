package com.hotrook

import net.jadler.Jadler
import org.scalatest.{BeforeAndAfterAll, WordSpec}
import TestUtils._
import TestData._
import play.api.libs.json.Json

class DownloaderAppTest extends WordSpec with BeforeAndAfterAll {

  override protected def beforeAll(): Unit = {
    Jadler.initJadler()
    createEmptyDirectory(postDirectory)
    configureJadler(multiplePost, posts)
  }

  override protected def afterAll(): Unit = {
    Jadler.closeJadler()
    removeDirectoryRecursively(postDirectory)
  }

  "DownloaderApp" should {
    "download array of posts and save them to files" in {
      val url = hostname + Jadler.port() + posts
      val directory = "src/test/resources/posts"

      DownloaderApp.main(Array(url, directory))

      val files = loadFilesFromDirectory(postDirectory)

      val file1 = files.find(_.getName.contains("0.txt")).get
      val file2 = files.find(_.getName.contains("1.txt")).get
      assert(Json.parse(post1) == Json.parse(scala.io.Source.fromFile(file1).mkString))
      assert(Json.parse(post2) == Json.parse(scala.io.Source.fromFile(file2).mkString))
    }
  }
}
