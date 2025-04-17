package racingcar

fun main() {
  val carNames = InputHandler.getCarNames()
  val totalRounds = InputHandler.getTotalRounds()
  val carList = carNames.map { Car(it) }
  Simulation.race(carList, totalRounds)
}
