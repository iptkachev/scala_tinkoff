abstract class DiffList[A](calculate: List[A] => List[A]) {
  def prepend(s: List[A]): DiffList[A]

  def append(s: List[A]): DiffList[A]

  def result: List[A]
}

final class DiffListImpl[A](listFunc: List[A] => List[A]) extends DiffList[A](listFunc) {
  def prepend(s: List[A]): DiffList[A] = {
    new DiffListImpl(list => s ++ listFunc(list))
  }

  def append(s: List[A]): DiffList[A] = {
    new DiffListImpl(list => listFunc(s ++ list))
  }
  def result: List[A] = listFunc(Nil)
}

val l1 = List(1,2,3)
val l2 = List(4,5,6)
val dl = new DiffListImpl[Int](x => x.map(_ * 2))

val result = dl.append(l2).prepend(l1).result // List(1,2,3,4,5,6)