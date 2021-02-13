package main.scala.collections_2

import scala.io.StdIn.readLine

object CollectionTwo {
  def main(args: Array[String]): Unit = {
    val list = LazyList.continually(readLine).takeWhile(_ != "END")
    var result = 0
    if (list.nonEmpty){
      result = list.zipWithIndex.tail.filter(_._2 % 2 != 0).map(_._1.toInt * 2).sum
    }
    println(result)
  }
}
