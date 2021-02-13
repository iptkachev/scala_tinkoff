package main.scala.collections_2

object GeneticCross {
  def main(args: Array[String]): Unit = {
//    val points: List[Int] = Lesson.points // точки кроссинговера
//    val chr1: List[Char] = Lesson.chr1 // первая хромосома
//    val chr2: List[Char] = Lesson.chr2 // вторая хромосома

    val points: List[Int] = List(1, 3) // точки кроссинговера
    val chr1: List[Char] = List('x', 'x', 'x', 'x', 'x') // первая хромосома
    val chr2: List[Char] = List('y', 'y', 'y', 'y', 'y') // вторая хромосома

    val (chr1_e, chr2_e) = crossover(chr1, chr2, points)
    println(chr1_e.mkString)
    println(chr2_e.mkString)
  }

  @scala.annotation.tailrec
  def crossover[T](chr1: List[T], chr2: List[T], points: List[Int]): (List[T], List[T]) = {
    points match {
      case List() => (chr1, chr2)
      case head +: restPoints =>
        val (chr1_part1, chr1_part2) = chr1.splitAt(head)
        val (chr2_part1, chr2_part2) = chr2.splitAt(head)
        crossover(chr1_part1 ++ chr2_part2, chr2_part1 ++ chr1_part2, restPoints)
    }
  }
}
