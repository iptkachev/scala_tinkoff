import scala.io.StdIn


object Main {
  def main(args: Array[String]) {
    val indexes: Array[Int] = StdIn.readLine().split(" ").map(x => x.toInt)
    val stringChars: Array[String] = StdIn.readLine().split("")
    val reversedString: String = stringChars.slice(0, indexes(0)).mkString("") +
      stringChars.slice(indexes(0), indexes(1) + 1).reverse.mkString("") +
      stringChars.slice(indexes(1) + 1, stringChars.length).mkString("")
    println(reversedString)
  }
}
