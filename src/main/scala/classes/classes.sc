class Doggi(val check: String) {
  // все, что ниже в теле класса, работает как конструктор
  println("Any actions")

  def woof(): Unit = println("Goy")
}

val dog = new Doggi("Gd")
dog.woof()


class Waiter(val name: String, var order: List[String]) {
  println(s"My name $name")

  def giveMe(name: String): Waiter = {
    order = name :: order
    this
  }
  def complete: List[String] = order.reverse
}

val w = new Waiter("Ivan", List())
val positions = w.giveMe("борщ").giveMe("хлеб").complete
println(positions)

trait testik(name: String) {
  def a(b: String): String
}

abstract class Tesla(name: String) {

}