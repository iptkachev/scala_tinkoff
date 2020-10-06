
def middle[T](data: Iterable[T]) = {
  val middle_idx: Int = data.size / 2
  data.slice(middle_idx, middle_idx+1).head
}

//require(middle("Scala") == 'a')
//require(middle(Seq(1, 7, 5, 9)) == 5)