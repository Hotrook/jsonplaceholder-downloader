package com.hotrook

import java.io.File

import net.jadler.Jadler

import scala.reflect.io.Directory

object TestUtils {
  def createEmptyDirectory(directoryPath: String) = {
    val directory = new File(directoryPath)
    directory.mkdir()
  }


  def removeDirectoryRecursively(directoryPath :String) = {
    val directory = new Directory(new File(directoryPath))
    directory.deleteRecursively()
  }

  def loadFilesFromDirectory(directoryPath: String) = {
    val directory = new File(directoryPath)
    if (directory.exists() && directory.isDirectory) {
      directory.listFiles().toList
    } else {
      List()
    }
  }

  def configureJadler(body: String, path: String) = {
    Jadler.onRequest()
      .havingMethodEqualTo("GET")
      .havingPathEqualTo(path)
      .respond()
      .withBody(body)
      .withStatus(200)
  }



}
