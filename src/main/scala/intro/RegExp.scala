package main.scala.intro

import scala.io.StdIn

object RegExp {
  def main(args: Array[String]) {
    val test = StdIn.readLine()
    val pattern = "^[a-z](_?[a-z]+)*$".r
    println(pattern.findFirstIn(test).isDefined)
  }
}
