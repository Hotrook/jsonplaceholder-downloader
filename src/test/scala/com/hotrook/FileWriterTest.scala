package com.hotrook

import com.hotrook.TestData._
import org.scalatest.{BeforeAndAfter, WordSpec}
import play.api.libs.json.Json

class FileWriterTest extends WordSpec with BeforeAndAfter with TestUtils {

  before {
    createEmptyDirectory(postDirectory)
  }

  after {
    removeDirectoryRecursively(postDirectory)
  }

  "FileWriter" should {
    "create directory and two files within when given 2-element list" in {
      val parsedPost1 = Json.parse(post1)
      val parsedPost2 = Json.parse(post2)
      val input = List(parsedPost1, parsedPost2)

      new FileWriter().writeToFile(input, postDirectory)

      val files = loadFilesFromDirectory(postDirectory)

      assert(files.size == 2)
      val file1 = getFile(files, "post0.json")
      val file2 = getFile(files, "post1.json")
      assert(parsedPost1 == Json.parse(scala.io.Source.fromFile(file1).mkString))
      assert(parsedPost2 == Json.parse(scala.io.Source.fromFile(file2).mkString))
    }

    "no files are created when given empty list" in {
      val input = List()

      new FileWriter().writeToFile(input, postDirectory)
      val files = loadFilesFromDirectory(postDirectory)

      assert(files.size == 0)
    }
  }



}
