package racingcar

import racingcar.core.Game
import racingcar.parser.Parser.parseCars
import racingcar.utils.InputHandler
import racingcar.utils.Printer.printWinners

fun main() {


  val carsString = InputHandler.readCarNames()
  val rounds = InputHandler.readRoundCount()
  val parsedCars = parseCars(carsString)
  val game = Game(parsedCars, rounds)

  println("Race Results:")
  game.startRace()
  printWinners(game.getWinners())


}

