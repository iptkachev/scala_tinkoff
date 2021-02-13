trait Animal {
  val sound: String
  def voice: Unit = println("voice: " + sound)
}

class Cat extends Animal {
  override val sound: String = "Meow!"
}

class Dog extends Animal {
  override val sound: String = "Woof!"
}

class Fish extends Animal {
  override val sound: String = "Fishes are silent!"

  override def voice: Unit = println(sound)
}