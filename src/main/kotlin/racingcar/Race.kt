package racingcar

class Race (private val cars: List<Car>, private val numberOfRounds: Int){
    fun startRace() {
        println("Race Results")
        repeat (numberOfRounds) {
            for (car in cars) {
                car.moveCar()
            }
            println()
        }
        calculateWinners()
    }

    private fun calculateWinners() {
        print("Winners : ")
        val maxDisplacement = cars.maxOf { it.displacement }
        val winners = mutableListOf<String>()
        for (car in cars) {
            if (car.displacement == maxDisplacement) {
                winners.add(car.carName)
            }
        }
        println(winners.joinToString(", "))
    }

    // For testing winners
    fun getWinners() :List<String> {
        val maxDisplacement = cars.maxOf { it.displacement }
        return cars.filter { it.displacement == maxDisplacement }.map { it.carName }
    }
}