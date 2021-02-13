// lists

val list1 = List(1, 3, 5, 7)
val list2 = List(2, 4, 6, 8)
val list3 = List(1, 3, 5, 8, 10, 12, 14)
for {
  x <- list1
  y <- list2
  z <- list3
  if x * y == z && x != y
} println(x, y)


// services
def service1: Either[String, Double]
def service2(res1: Double): Either[String, Int]
def service3: String
def service4(res1: Double, res2: Int, res3: String): Either[String, String]

def result = {
  for {
    res1 <- service1
    res2 <- service2(res1)
    res <- service4(res1, res2, service3)
  } yield res
}


// button checks
for {x <- Some(2); y <- Left("year")} yield x + y