// обощенный класс и обощенный тип для метода
final case class Named[A](name: String, value: A) {
  def mapValue[B](f: A => B): Named[B] = {
    Named(name, f(value))
  }
}

// 1
case class Pair[T, S](first: T, second: S) {
  def swap: Pair[S, T] = {
    Pair(second, first)
  }
}

val pair = Pair(123, "Oleg").swap
require(pair.first ==  "Oleg")
require(pair.second == 123)


// 2
// https://stackoverflow.com/questions/4465948/what-are-scala-context-and-view-bounds

case class Pair[T](first: T, second: T)(implicit ev: T => Ordered[T]) {
  def smaller: T =
    if (first < second) first
    else second
}

val p = Pair(BigInt("1000000000000000"),BigInt("7000000000000000"))
require(p.smaller == BigInt("1000000000000000"))