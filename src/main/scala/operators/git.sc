
case class Name(name: String)
case class NameMail(name: String, email: String)

val input1 = List("oleg", "dfds@sdf.u", "dfds4334c2rfe", "dsfds")
val input2 = List("oleg sdfds@asd.ru", "dfds4334c2rfe", "dsfds")

val regex_name = "([a-zA-z]+)".r
val regex_mail = "\\w+@(\\w+\\.\\w+)".r
val regex_nameMail = "([a-zA-z]+)\\s+\\w+@(\\w+\\.\\w+)".r
val result = input1 match {
  case List(regex_nameMail(name, mail), rest@_*) => name.concat(" "+mail)
  case List(regex_name(name), regex_mail(mail), rest@_*) => name.concat(" "+mail)
  case _ => "invalid"
}
println(result)