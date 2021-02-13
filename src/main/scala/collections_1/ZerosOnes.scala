package main.scala.collections_1

object ZerosOnes {
  @scala.annotation.tailrec
  def split(input: List[Int], zeros: List[Int] = Nil, ones: List[Int] = Nil): (List[Int], List[Int]) = {
    input match {
      case Nil => (zeros, ones)
      case head +: restInput =>
        if (head == 0) split(restInput, head +: zeros, ones)
        else split(restInput, zeros, head +: ones)
    }
  }

  def main(args: Array[String]) {
    val ints: List[Int] = List(0,1,0,1,0,1,0,1,0,1)
    val (zeros, ones) = split(ints)
    println(zeros.mkString(", "))
    println(ones.mkString(", "))
  }
}
