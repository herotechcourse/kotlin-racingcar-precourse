package racingcar

class Race(
    val rounds: Int,
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

        val bestPosition = sortedCars[0].position
        var winners = mutableListOf(sortedCars[0].name)
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
