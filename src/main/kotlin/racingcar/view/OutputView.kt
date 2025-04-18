package racingcar.view
import racingcar.domain.Car

object OutputView{
    fun printRaceResults() = println("\nRace Results")
    fun printPosition(cars: List<Car>){
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}")}
        println()
    }
    fun printWinners(winners: List<String>){
        println("Winners : ${winners.joinToString(", " )}")
    }
}