package racingcar.view
import racingcar.domain.Cars

object OutputResult {
    fun showResult(cars: Cars) {
        val winners = cars.getWinners()
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}
