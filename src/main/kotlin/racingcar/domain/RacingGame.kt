package racingcar.domain
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class RacingGame(private val cars: List<Car>, private val rounds: Int) {

  init {
    require(rounds > 0) { "Number of rounds must be greater than 0." }
  }

  fun startRace() {
    println("\nRace Results")

    repeat(rounds) {
      cars.forEach { car ->
        val randomCarPosition = Randoms.pickNumberInRange(0, 9)
        car.moveForward(randomCarPosition)
      }
      displayRaceProgress()
      println()
    }

    displayWinners()
  }

  private fun displayRaceProgress() {
    cars.forEach {
      println("${it.name} : ${it.progress()}")
    }
  }

  private fun displayWinners() {
    val max = cars.maxOf { it.position }
    val winners = cars.filter { it.position == max }.map { it.name }
    println("Winners : ${winners.joinToString(", ")}")
  }
}
