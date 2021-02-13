// object Point - объект компаньён, где можно реализовать статические методы
class Point(val x: Double, val y: Double, val z: Double) {
   override def toString: String = s"$x $y $z"
}

object Point {
  def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)

  def average(points: List[Point]): Point = {
    if (points.isEmpty) {
      return Point(0, 0, 0)
    }

    val sumPoint = points.foldLeft(Point(0, 0, 0)){
      (elem, acc) => Point(elem.x + acc.x, elem.y + acc.y, elem.z + acc.z)
    }
    Point(sumPoint.x / points.length, sumPoint.y / points.length, sumPoint.z / points.length)
  }

  def show(point: Point): String = {
    point.toString
  }
}

Point.average(List.empty[Point])

val a = """.*?\*(daf).*""".r
val postCodes = a.findFirstMatchIn("*daafsdfsd")
println(postCodes.map(_.group(1)))
