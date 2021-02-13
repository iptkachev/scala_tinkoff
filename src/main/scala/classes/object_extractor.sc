import scala.io.StdIn

object FacedString {
  def apply(input: String) = s"*_*$input*_*"

  def unapply(arg: String): Option[String] = {
    val stringPattern = "\\*_\\*(.*)\\*_\\*".r
    val text = stringPattern.findFirstMatchIn(arg)
    text.map(_.group(1))
  }
}

object ObjectExtractor {
  def main(args: Array[String]) {
    StdIn.readLine() match {
      case FacedString(str) => println(str)
      case _ => println("Could not recognize string")
    }
  }
}

val stringPattern = "\\*_\\*(.+)\\*_\\*".r
val text = stringPattern.findFirstMatchIn("*_**_*")
text.map(_.group(1))
