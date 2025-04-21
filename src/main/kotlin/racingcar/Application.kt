package racingcar

class Car(val name: String, private val canMove: () -> Boolean) {
    var position: Int = 0
        private set
    fun moveForward() {
        if (canMove()) {
            position++
        }
    }

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}

class CarRacing(private val canMove: () -> Boolean) {
    private var cars: List<Car> = listOf()
    private var roundCount: Int = 0

    fun setCars(input: String) {
        val names = input.split(",").map { it.trim() }
        cars = names.map { name -> Car(name, canMove)}
    }

    fun setRoundCount(input: Int) {
        roundCount = input
    }

    fun race() {
        println()
        println("Race Results")
        repeat(roundCount) {
            for (car in cars) {
                car.moveForward()
                car.printStatus()
            }
            println()
        }
        getWinners()
    }

    private fun isValidNameLength(names: List<String>): Boolean {
        return !names.any { it.length > 5 }
    }

    private fun getWinners() {
        val max = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == max }
        printResult(winners)
    }

    private fun printResult(winners: List<Car>) {
        val names = winners.joinToString(", ") { it.name }
        println("Winners : $names")
    }
}

fun main() {
    // TODO: Implement the program
}
