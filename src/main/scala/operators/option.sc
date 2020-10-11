def divide(x: Int, y: Int): Option[Int] = {
  if (y != 0)
      Some(x / y)
  else
    None
}
// flatMap возвращает Option
println(divide(1, 0).flatMap(x => Option(x + 10)))
println(divide(1, 0).map(x => x + 10))

def indexOf(string: String, pattern: String): Option[Int] =
  Option(string.indexOf(pattern)).filter(_ >= 0)

val s = "sfdf[sdfds] dsg"
def brackets(s: String): Option[(Int, Int)] = {
  indexOf(s, "[")
  .flatMap{ start =>
    indexOf(s, "]").map(finish => (start, finish))
  }
}

def inside(s: String): Option[String] = {
  brackets(s).map{
    case (start, end) => s.substring(start + 1, end)
  }
}

println(inside(s))

