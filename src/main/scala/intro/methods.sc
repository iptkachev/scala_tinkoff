import math.{E, Pi, sqrt, pow}
import scala.math.BigDecimal.RoundingMode.HALF_UP

def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
  val p: Double = 1 / (sigma * sqrt(2 * Pi)) *
    pow(E, -pow((x - mu), 2) / 2 * pow(sigma, 2))
  p
}

normalDistribution(1, 1, 3)


def crispsWeight(weight: BigDecimal, potatoWaterRatio: Double,
                 crispWaterRatio: Double): BigDecimal = {
  val crispsWeight: BigDecimal = ((1 - potatoWaterRatio) * weight) /
    (1 - crispWaterRatio)
  crispsWeight.setScale(5, HALF_UP)
}

crispsWeight(90, 0.9, 0.1)

def isCapital(word: String, pos: Int): Boolean = {
  word(pos).isUpper
}

isCapital("ScalA ", 0)


