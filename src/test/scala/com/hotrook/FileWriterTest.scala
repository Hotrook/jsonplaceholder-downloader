package com.hotrook

import java.io.File

import com.hotrook.TestData._
import org.scalatest.{BeforeAndAfter, WordSpec}
import play.api.libs.json.Json

import scala.reflect.io.Directory

class FileWriterTest extends WordSpec with BeforeAndAfter {

  val postDirectory = "src/test/resources/posts"

  before {
    val directory = new File(postDirectory)
    directory.mkdir()
  }

  after {
    val directory = new Directory(new File(postDirectory))
    directory.deleteRecursively()
  }

  "FileWriter" should {
    "create directory and two files within when given 2-element list" in {
      val parsedPost1 = Json.parse(post1)
      val parsedPost2 = Json.parse(post2)
      val input = List(parsedPost1, parsedPost2)

      new FileWriter().writeToFile(input, postDirectory)

      val files = loadFilesFromDirectory(postDirectory)

      assert(files.size == 2)
      val file1 = files.find(_.getName.contains("0.txt")).get
      val file2 = files.find(_.getName.contains("1.txt")).get
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

  private def loadFilesFromDirectory(directoryPath: String) = {
    val directory = new File(directoryPath)
    if (directory.exists() && directory.isDirectory) {
      directory.listFiles().toList
    } else {
      List()
    }
  }


}
