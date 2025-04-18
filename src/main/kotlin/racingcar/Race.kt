package racingcar

class Race(
    val rounds: Long,
    val cars: List<Car>,
) {
    fun run() {
        println()
        println("Race Results")
        for (r in 1..rounds) {
            for (car in cars) {
                car.luckyMove()
            }
            displayCarsProgress()
        }
    }

    fun displayCarsProgress() {
        for (car in cars) {
            println(car.getProgress())
        }
        println()
    }

    fun displayWinners() {
        val sortedCars = cars.sortedByDescending { it.position }

        val bestCar = sortedCars.firstOrNull()
        val bestPosition = bestCar?.position
        var winners = if (bestCar !== null) mutableListOf(bestCar.name) else mutableListOf()
        for (i in 1 until sortedCars.size) {
            if (sortedCars[i].position == bestPosition) {
                winners.add(sortedCars[i].name)
            } else {
                break
            }
        }
        val winnersStr=winners.joinToString(", ")
        println("Winners : $winnersStr")
    }
}
