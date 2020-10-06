package main.scala.manage_constructions

import scala.io.StdIn

object circles {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    for (i <- 1 until n; j <- 1 until n) {
      val res = BigInt(i).gcd(j)
      if (res == 1)
        println(s"$i $j")
    }
  }
}
