case class Pet(name: String, says: String)

val pet = Pet("cat", "010")
val regex_robot = "[01]+".r

val kind = pet match {
  case Pet("Rex", _) => "dog"
  case Pet(_, "meow" | "nya")  => "cat"
  case Pet(_, regex_robot()) => "robot"
  case Pet(_, _) => "unknown"
}

println(kind)
