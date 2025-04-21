package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.setup.PromptNames
import racingcar.setup.PromptRounds
import racingcar.race.Simulation
import racingcar.player.Car

fun main() {
  println("Enter the names of the cars (comma-separated):")
  val players = PromptNames.getInput(Console.readLine())
  println("How many rounds will be played?")
  val totalRounds = PromptRounds.getInput(Console.readLine())
  val playerList = players.map { Car(it) }
  Simulation.race(playerList, totalRounds)
}
