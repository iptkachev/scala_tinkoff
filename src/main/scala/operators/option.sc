def divide(x: Int, y: Int): Option[Int] = {
  if (y != 0)
      Some(x / y)
  else
    None
}
// flatMap возвращает Option
println(divide(1, 7).flatMap(x => Option(x + 10)))
