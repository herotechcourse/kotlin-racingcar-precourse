package racingcar

fun main() {
  var carList = getCarNames()
  var totalRounds = getTotalRounds()
  val cars = carList.map { Car(it) }
  Simulation.race(cars, totalRounds)
}
