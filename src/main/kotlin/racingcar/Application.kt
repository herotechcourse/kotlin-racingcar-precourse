package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.core.Game
import racingcar.parser.Parser.parseCars
import racingcar.utils.ErrorMessages
import racingcar.utils.Printer.printWinners

fun main() {

  println("Enter car names (comma-separated): ")
  val carsString = Console.readLine()
  println("How many rounds will be played?")
  val rounds = Console.readLine().toIntOrNull()
  require(rounds != null) { ErrorMessages.ERROR_INVALID_ROUNDS }

  val parsedCars = parseCars(carsString)
  val game = Game(parsedCars, rounds)
  game.startRace()

  printWinners(game.getWinners())


}
