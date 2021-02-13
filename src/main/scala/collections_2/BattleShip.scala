package main.scala.collections_2

import scala.io.StdIn.readLine

object BattleShip {
  def main(args: Array[String]): Unit = {
    type Point = (Int, Int)
    type Field = Vector[Vector[Boolean]]
    type Ship = List[Point]
    type Fleet = Map[String, Ship]
    type Game = (Field, Fleet)

    val FieldSize = 10

    // определить, подходит ли корабль по своим характеристикам
    def validateShip(ship: Ship): Boolean = {
      if (ship.length > 4) false
      else if (ship.exists(x => x._1 != ship.head._1) && ship.exists(x => x._2 != ship.head._2)) false
      else true
    }

    // определить, можно ли его поставить
    def validatePosition(ship: Ship, field: Field): Boolean = {
      ! ship.map(checkPoint(field, _, FieldSize)).exists(x => x)
    }

    def checkPoint(field: Field, point: Point, bound_filter: Int): Boolean = {
      genAllPairs(
        List(point._1, point._1 - 1, point._1 + 1), List(point._2, point._2 - 1, point._2 + 1)
      ).filter(x => x._1 >= 0 &&  x._2 >= 0).filter(x => x._1 < bound_filter && x._2 < bound_filter)
        .exists(x => field(x._1)(x._2))
    }

    @scala.annotation.tailrec
    def genAllPairs(leftGraph: List[Int], rightGraph: List[Int], acc: List[(Int, Int)] = Nil): List[(Int, Int)] = {
      leftGraph match {
        case List() => acc
        case head_l +: restList_l => rightGraph match {
          case List() => acc
          case right => genAllPairs(restList_l, right, acc ++ right.map((head_l, _)))
        }
      }
    }

    // добавить корабль во флот
    def enrichFleet(fleet: Fleet, name: String, ship: Ship): Fleet = {
      fleet + (name -> ship)
    }

    // пометить клетки, которые занимает добавляемый корабль
    @scala.annotation.tailrec
    def markUsedCells(field: Field, ship: Ship): Field = {
      ship match {
        case List() => field
        case head +: restPoints =>
          markUsedCells(field.updated(head._1, field(head._1).updated(head._2, true)), restPoints)
      }
    }

    // логика вызовов методов выше
    def tryAddShip(game: Game, name: String, ship: Ship): Game = {
      val val_ship = validateShip(ship)
      val val_pos = validatePosition(ship, game._1)
      if (val_ship && val_pos) {
        val new_field = markUsedCells(game._1, ship)
        val new_fleet = enrichFleet(game._2, name, ship)
        (new_field, new_fleet)
      } else game
    }

    @scala.annotation.tailrec
    def playGame(names: List[String], map_ships: Map[String, List[Point]], game: Game, result_ships: List[String] = Nil): List[String] = {
      names match {
        case List() => result_ships
        case head +: restNames =>
          val new_game = tryAddShip(game, head, map_ships(head))
          if (game != new_game)
            playGame(restNames, map_ships, new_game, head +: result_ships)
          else
            playGame(restNames, map_ships, new_game, result_ships)
      }
    }

    var ships = Map[String, List[Point]]()
    val countShips = readLine.toInt
    val names = new Array[String](countShips)
    for (i <- 0 until countShips) {
      val (name, countPoints) = readLine().split(' ') match {
        case Array(name, countPoints) => (name, countPoints.toInt)
      }
      val points = LazyList.continually(readLine).take(countPoints).map(
        _.split(' ') match {
        case Array(x, y) => (x.toInt, y.toInt)
        }
      ).toList

      ships += (name -> points)
      names(i) = name
    }

    val field: Field = Vector.fill(FieldSize, FieldSize)(false)
    val fleet: Fleet = Map[String, Ship]()
    val game: Game = (field, fleet)
    val result_ships = playGame(names.toList, ships, game)
    result_ships.reverse.foreach(println)

//    println(validatePosition(List((0, 2), (0, 1)), field.updated(0, field(0).updated(0, true))))
  }
}
