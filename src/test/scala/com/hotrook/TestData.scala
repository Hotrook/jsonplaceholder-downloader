package com.hotrook

object TestData {

  val post1 =
    """
      |{
      |  "userId": 1,
      |  "id": 1,
      |  "title": "test",
      |  "body": "test"
      |}
    """.stripMargin
  val post2 =
    """
      |{
      |  "userId": 2,
      |  "id": 2,
      |  "title": "test test",
      |  "body": "test test   "
      |}
    """.stripMargin
  val multiplePost = "[" + post1 + "," + post2 +"]"
  val hostname = "http://localhost:"
  val posts = "/posts"
  val noposts = "/noposts"


}
