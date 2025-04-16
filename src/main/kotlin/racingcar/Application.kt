package racingcar

fun main() {
  var carList = getCarNames()
  var totalRounds = getTotalRounds()
  println("Inputed names: $carList")
  println("Inputed rounds: $totalRounds")
  val cars = carList.map { Car(it) }
  Simulation.run(cars, totalRounds)
}