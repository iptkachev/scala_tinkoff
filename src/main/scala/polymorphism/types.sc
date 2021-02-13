trait Vect extends Any{
  type Item
  type Aux[I] = Vect { type Item = I }
  def length: Int
  def get(index: Int): Item
  def set(index: Int, item: Item): Aux[Item]
}


final case class StringVect(str: String) extends AnyVal with Vect {
  type Item = Char
  def length                                 = str.length
  def get(index: Int)                        = str.charAt(index)
  def set(index: Int, item: Char): Aux[Char] = StringVect(str.updated(index, item))
}

final case class BoolVect64(values: Long) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 64
  def get(index: Int) = if (((values >> index) & 1) == 1) true else false
  def set(index: Int, item: Boolean): Aux[Boolean] = {
    // 1 << index - приводит к 32битному, т.к. 1 по умолчанию Int32
    if (item) {
      BoolVect64(values | (1L << index))
    } else {
      BoolVect64(values & ~(1L << index))
    }
  }
}

final case class BoolVect8(values: Byte) extends AnyVal with Vect {
  type Item = Boolean
  def length          = 8
  def get(index: Int) = if (((values >> index.toByte) & 1) == 1) true else false
  def set(index: Int, item: Boolean): Aux[Boolean] = {
    if (item) {
      BoolVect8((values | (1 << index.toByte)).toByte)
    } else {
      BoolVect8((values & ~(1 << index.toByte)).toByte)
    }
  }
}

def toList(vect: Vect): List[vect.Item] = {
  (0 until vect.length).map(vect.get(_)).toList
}


println(BoolVect8(1).get(179))
println(toList(BoolVect8(1)))