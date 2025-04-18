package racingcar

object RaceSimulator {
    fun runRace(cars: List<Car>, rounds: Int) {
        println("Race Results")

        repeat(rounds) { round ->
            cars.forEach { car ->
                if (Movement.shouldMove()) {
                    car.position++
                }
            }
            printRoundResults(cars)
        }
    }

    private fun printRoundResults(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}
