package com.hotrook

import com.hotrook.TestData._
import net.jadler.Jadler
import org.scalatest.{BeforeAndAfterAll, WordSpec}
import play.api.libs.json.Json

class DownloaderAppTest extends WordSpec with BeforeAndAfterAll with TestUtils {

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

      val file1 = getFile(files, "post0.json")
      val file2 = getFile(files, "post1.json")
      assert(Json.parse(post1) == Json.parse(scala.io.Source.fromFile(file1).mkString))
      assert(Json.parse(post2) == Json.parse(scala.io.Source.fromFile(file2).mkString))
    }
  }

}
