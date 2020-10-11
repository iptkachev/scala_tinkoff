// Метод flatMap действует до первой "ошибки"-Left
Right(1).flatMap(_ => Left(2)).flatMap(_ => Left(3))

def check_right_fraction(fraction: (Int, Int), left_value: String): Either[String, Tuple2[Int, Int]] = {
  if (fraction._2.abs <= fraction._1.abs) Left(left_value) else Right(fraction)
}

def check_zero_division(fraction: (Int, Int)): Either[String, (Int, Int)] = {
  if (fraction._2 == 0) Left("Zero divisor") else Right(fraction)
}

def make_easier_fraction(fraction: Tuple2[Int, Int]): Tuple2[Int, Int] = {
  val shorter = BigInt(fraction._1).gcd(fraction._2).toInt
  (fraction._1 / shorter, fraction._2 / shorter)
}

def divide(p: (Int, Int))(q: (Int, Int)): Either[String, (Int, Int)] = {
  check_right_fraction(p, "Invalid input").flatMap{ p_checked =>
    check_right_fraction(q, "Invalid input").flatMap{ q_checked =>
      check_zero_division(p_checked._1 * q_checked._2, p_checked._2 * q_checked._1).flatMap{
        check_right_fraction(_, "Improper result").map(make_easier_fraction)
      }
    }
  }
}

println(divide((1, 2))((5, 4)))

println(BigInt(23).gcd(64))