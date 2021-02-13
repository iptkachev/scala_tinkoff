val l = List(1 to 2: _*)

def cond(num: Int): Option[Int] = {
  if (num % 3 == 0) Some(2 * num)
  else None
}

def foo(list: List[Int]): Int = {
  val edited_list = list.flatMap(cond)
  if (edited_list.isEmpty) 0
  else edited_list.head
}


def foo2(list: List[Int]): Int = {
  list.find(_ % 3 == 0).flatMap(x => Option(x * 2)).getOrElse(0)
}

println(foo2(l))
println(foo(l))

println((List(1,24) ++ List(56,8)).slice(0,2))