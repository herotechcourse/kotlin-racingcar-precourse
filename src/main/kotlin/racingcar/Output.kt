package racingcar

object Output {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${it.getProgress()}") }
        println()
    }

    fun printWinners(cars: List<Car>) {
        val max = cars.maxOf { it.position }
        val winners = cars.filter { it.position == max }.joinToString(", ") { it.name }
        println("Winners : $winners")
    }
}