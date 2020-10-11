import scala.util.Random

val list = List.fill(Random.nextInt(6))(Random.nextInt(100))
println(list)


@scala.annotation.tailrec
def merge(as: List[Int], bs: List[Int], acc: List[Int] = Nil): List[Int] = {
  as match {
    case List() => acc.reverse ++ bs
    case a +: restA => bs match {
      case List() => acc.reverse ++ as
      case b +: restB =>
        if (a < b) merge(restA, bs, a +: acc)
        else merge(as, restB, b +: acc)
    }
  }
}


def mergeSort(as: List[Int]): List[Int] = as match {
  case Nil | (_ :: Nil) => as
  case _ =>
    val (left, right) = as.splitAt(as.length / 2)
    val leftSorted = mergeSort(left)
    val rightSorted = mergeSort(right)
    merge(leftSorted, rightSorted)
}

mergeSort(List(4,6,8,3,2,6,23))
