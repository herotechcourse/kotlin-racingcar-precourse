package racingcar

class Race(private val carNames: List<String>, private val rounds: Int) {
    private val cars: List<Car>

    init {
        val tempCars = mutableListOf<Car>()
        for (name in carNames) {
            tempCars.add(Car(name))
        }
        cars = tempCars
    }

    fun beginRace() {
        println("\nRace Results")

        for (round in 0 until rounds) {
            positionCalculator()
            println("")
        }

        announceWinners()
    }

    private fun positionCalculator() {
        for (i in cars.indices) {
            val car = cars[i]
            car.move()
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
    }

    private fun announceWinners() {
        var maxPosition = -1
        val winners = mutableListOf<String>()

        for (car in cars) {
            val position = car.getPosition()
            if (position > maxPosition) {
                maxPosition = position
                winners.clear()
                winners.add(car.name)
            } else if (position == maxPosition) {
                winners.add(car.name)
            }
        }

        println("Winners : ${winners.joinToString(", ")}")
    }
}