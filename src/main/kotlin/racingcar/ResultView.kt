package racingcar

object ResultView {
    fun printWinners(cars : List<Car>){
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        print("Winners : ${winners.joinToString (", ")}")

    }
}