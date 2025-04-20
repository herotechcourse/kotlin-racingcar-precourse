package racingcar.io
import racingcar.model.Car

object RaceDisplay {
    fun displayLapProgress(cars: List<Car>, lapNumber: Int){
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun displayRaceWinners(cars: List<Car>, leadPosition: Int){
        val winners = cars.filter { car -> car.position == leadPosition }.map { car -> car.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}