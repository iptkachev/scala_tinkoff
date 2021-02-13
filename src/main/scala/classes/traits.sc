trait StringProcessor {
  def process(input: String): String
}

//tokenDeleter - в методе process обрабатывает строку, удаляя из неё перечисленные знаки препинания: запятая, двоеточие, точка с запятой.
//toLowerConvertor - заменяет все прописные буквы на строчные.
//shortener - если строка имеет размер больше 20 символов, он оставляет первые 20 и добавляет к ней "...".

val tokenDeleter = new StringProcessor {
  override def process(input: String): String = {
    input.replaceAll("[:;,]", "")
  }
}

val shortener = new StringProcessor {
  override def process(input: String): String = {
    input.toLowerCase()
  }
}

val toLowerConvertor = new StringProcessor {
  override def process(input: String): String = {
    if (input.length > 20) {
      input.slice(0, 20) + "..."
    } else {
      input
    }
  }
}

val d = "This is a Wonderful Test!"
println(toLowerConvertor.process(d))
val d = ",sdf,,:,ds ;. dsfd.,fg,"
println(d.length)
println(d.replaceAll("[,:;]", ""))