// главное ковариатность - вперед по иерархии
// контрвариатность - назад к предкам по иерархии
// функции в scala - контрвариатностны по аргументам (!!! обратно не скомпилится)

// ковариатность - [+T] говорим что все классы потомки могут быть аргументами
// контрвариатность - наоборот
// http://groz.github.io/scala/intro/variance/

class Person (val name: String)

class Student(name: String, val course: Int) extends Person(name)

class Pair[+T](val first: T, val second: T) {
  def replaceFirst[B >: T](newValue: B): Pair[B] = {
    new Pair(newValue, second)
  }
}

def printNames(pair: Pair[Person]): Unit = {
  println("1: " + pair.first.name + "  2: " + pair.second.name)
}

val pair = new Pair(new Student("Pavel", 1), new Student("Oleg", 5))
printNames(pair.replaceFirst(new Person("Oliver")))