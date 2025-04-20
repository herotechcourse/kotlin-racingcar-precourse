package racingcar

class RaceDisplay {
    fun showRound(round: Int) {
        println("\nRound $round")
    }

    fun showCarProgress(car: Car) {
        println("${car.name} : ${"-".repeat(car.position)}")
    }

    fun showWinners(winners: List<Car>) {
        println("\nFinal Result")
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}