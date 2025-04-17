package racingcar

object Printer {

  fun printWinners(winners: List<Car>) {
    println("Winners : ${winners.joinToString(", ") { it.name }}")
  }

  fun printRound(cars: List<Car>) {
    println()
    cars.forEach {
      println("${it.name} : ${it.getProgress()}")
    }
  }
}
