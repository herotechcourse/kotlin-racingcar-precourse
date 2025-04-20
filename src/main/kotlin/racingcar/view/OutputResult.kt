package racingcar.view
import racingcar.domain.Cars

object OutputResult {
    fun showResult(cars: Cars) {
        val winners = cars.getWinners()
            .joinToString(", ") { it.name }
        println("Winners : $winners")
    }
}
