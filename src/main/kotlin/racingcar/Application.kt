package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.input.Names
import racingcar.input.Rounds

fun main() {
  println("Enter the names of the cars (comma-separated):")
  val players = Names.getInput(Console.readLine())
  println("How many rounds will be played?")
  val totalRounds = Rounds.getInput(Console.readLine())
  val playerList = players.map { Car(it) }
  Simulation.race(playerList, totalRounds)
}
