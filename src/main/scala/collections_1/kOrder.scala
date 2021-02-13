package main.scala.collections_1

import scala.util.Random
import scala.io.StdIn

object kOrder {
  def main(args: Array[String]) {
    val k: Int = StdIn.readInt()
    val list: List[Int] = StdIn.readLine().split(" ").map(_.toInt).toList
    println(kOrder(list, k))
  }

  @scala.annotation.tailrec
  def kOrder(list: List[Int], k: Int): Int = {
    val split_by_element = list(Random.between(0, list.size))
    val (left, middle, right) = partition(list, split_by_element)
    if (0 <= k - 1 && k - 1 < left.size)
      kOrder(left, k)
    else if (k - 1 >= left.size && k - 1 < left.size + middle.size)
      middle.head
    else
      kOrder(right, k - (left.size + middle.size))
  }

  @scala.annotation.tailrec
  def partition(list: List[Int], split_element: Int,
                left: List[Int] = Nil,
                middle: List[Int] = Nil,
                right: List[Int] = Nil): (List[Int], List[Int], List[Int]) = {
    list match {
      case List() => (left, middle, right)
      case head +: restList =>
        if (head > split_element) partition(restList, split_element, left, middle, head +: right)
        else if (head < split_element) partition(restList, split_element, head +: left, middle, right)
        else partition(restList, split_element, left, head +: middle, right)
    }
  }
}

