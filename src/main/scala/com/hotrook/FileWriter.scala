package com.hotrook

import java.io
import java.io.{BufferedWriter, File}

import play.api.libs.json.JsValue

class FileWriter {
  def writeToFile(jsons: List[JsValue], directoryPath: String) = {
    val directory = new File(directoryPath)

    jsons.zipWithIndex.foreach {
      case (post, id) => writePostToFile(directory, post, id)
    }
  }

  private def writePostToFile(directory: File, post: JsValue, id: Int) = {
    val fileName = directory + "/post" + id + ".txt"
    val file = new File(fileName)
    file.createNewFile()

    val writer = new BufferedWriter(new io.FileWriter(file))
    writer.write(post.toString())
    writer.close()

  }
}
