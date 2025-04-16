package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.Utils.parseCars
import racingcar.Utils.printResults
import racingcar.Utils.printWinners

fun main() {

  print("Enter car names (comma-separated): ")
  val carsString = Console.readLine()
  print("How many rounds will be played?\n")
  //TODO  make sure rounds is int
  val rounds = Console.readLine().toInt()

  val parsedCars = parseCars(carsString)
  val game = Game(parsedCars, rounds)
  game.startRace()

  printResults(parsedCars)
  printWinners(parsedCars)


}
