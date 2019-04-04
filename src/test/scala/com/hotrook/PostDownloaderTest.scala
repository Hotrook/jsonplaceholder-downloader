package com.hotrook

import java.net.URL

import net.jadler.Jadler
import org.scalatest._
import play.api.libs.json.Json
import TestData._

class PostDownloaderTest extends WordSpec
  with BeforeAndAfterAll
  with Matchers
  with TestUtils {

  override protected def beforeAll(): Unit = {
    Jadler.initJadler()
    configureJadler(multiplePost, posts)
    configureJadler("[]", noposts)
  }

  override protected def afterAll(): Unit = Jadler.closeJadler()

  "PostDownloader" should {

    "return List of multiple when json array with multiple result is returned" in {
      val url = new URL(hostname + Jadler.port() + posts )
      val result = new PostDownloader().downloadPosts(url)

      assert(result == List(Json.parse(post1), Json.parse(post2)))
    }

    "return empty List of multiple when emtpy json array is returned" in {
      val url = new URL(hostname + Jadler.port() + noposts)
      val result = new PostDownloader().downloadPosts(url)

      assert(result == List())
    }
  }
}
