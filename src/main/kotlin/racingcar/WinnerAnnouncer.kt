package racingcar

object WinnerAnnouncer {
    fun announceWinners(cars: List<Car>) {
        val maxPos = cars.maxOf { it.position }
        val winners = cars
            .filter { it.position == maxPos }
            .map { it.name }

        val joined = winners.joinToString(", ")
        println("Winners : $joined")
    }
}
