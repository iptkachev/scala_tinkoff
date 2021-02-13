import scala.io.StdIn.readLine

val list = List(1,5,4,64,246,2,0)

println(list.takeWhile(_ % 2 != 0))

// 1
val list1 = List(10, 20, 30, 40, 50, 60, 70,
  80, 90, 100, 110, 120, 130, 140, 150)

list1.filter(_ < 100).filter(_ % 4 == 0)
  .map(_ / 4).init.foreach(println)


val rightGraph = List(4, 5, 6)

val leftGraph = List(50, 30, 60)

@scala.annotation.tailrec
def genPairGraph(leftGraph: List[Int], rightGraph: List[Int], acc: List[(Int, Int)] = Nil): List[(Int, Int)] = {
  leftGraph match {
    case List() => acc
    case head_l +: restList_l => rightGraph match {
      case List() => acc
      case right => genPairGraph(restList_l, right, acc ++ right.map((head_l, _)))
    }
  }
}

val res = genPairGraph(List(1,2,3), List(36, 74, 24))
res.foreach(println)

val points = LazyList.continually(readLine).take(3)