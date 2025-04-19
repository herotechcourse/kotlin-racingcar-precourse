package racingcar

class Race(
    private val cars: List<Car>,
    private val rounds: Int,
    private var result: List<Car>? = null,
){
    fun play() {
        for (i in 0..< rounds) {
            cars.forEach { car ->
                car.move()
                displayRound(car)
            }
            println()

            // save result if it is the last round
            if (i == rounds - 1) {
                result = cars
            }
        }

        result?.let {
            val winners = getWinners(it)
            displayWinners(winners)
        }
    }

    private fun getWinners(result: List<Car>): List<String>{
        var maxDistance = result[0].distance

        result.forEach{ car ->
            if (car.distance > maxDistance) maxDistance = car.distance
        }

        val winners = result.filter { car ->
            car.distance == maxDistance
        }.map { car -> car.name }

        return winners
    }

    private fun displayRound(car: Car) {
        val dashes = "-".repeat(car.distance)
        println(car.name + " : " + dashes)
    }

    private fun displayWinners(winners: List<String>) {
        print("Winners : ")
        winners.forEachIndexed { index, winner ->
            print(winner)
            if (index != winners.size - 1) {
                print(", ")
            }
        }
    }
}