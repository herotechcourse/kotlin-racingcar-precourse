package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.player.Car
import racingcar.race.Simulation
import racingcar.setup.PromptNames
import racingcar.setup.PromptRounds


fun main() {
  println("Enter the names of the cars (comma-separated):")
  val playerNames = PromptNames.getInput(Console.readLine())

  println("How many rounds will be played?")
  val totalRounds = PromptRounds.getInput(Console.readLine())

  val players: List<Car> = playerNames.map { Car(it) }
  Simulation.race(players, totalRounds)
}
