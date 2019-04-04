package com.hotrook

import java.net.URL

object DownloaderApp {

  def main(args: Array[String]): Unit = {
    require(args.size >= 2)

    val urlPath = args(0)
    val directoryPath = args(1)

    val posts = new PostDownloader().downloadPosts(new URL(urlPath))
    new FileWriter().writeToFile(posts, directoryPath)
  }
}
