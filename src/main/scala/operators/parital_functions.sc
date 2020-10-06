// 1
val log: PartialFunction[Double, Double] = {
  case x if x > 0 => math.log(x)
}

val isEven: PartialFunction[Int, String] = {
  case x if x % 2 == 0 => x+" is even"
}

val test1 = List(1.0,4,-10, 0)
println(test1 collect log)

// 2
case class Jar(name: String, value: Int, price: Double)

val discount: PartialFunction[Jar, String] = {
  case Jar(name, value, price) if value >= 5 && value <= 10 => s"$name ${price * 0.05}"
  case Jar(name, value, price) if value > 10 => f"$name ${price * 0.1}"
}

val test2 = List(
  Jar("Морской синий 6л", 6, 3000.0),
  Jar("Огненно-красный 12л", 12, 5000.0),
  Jar("Зеленый 1л", 1, 500.0)
)

println(test2 collect discount)
