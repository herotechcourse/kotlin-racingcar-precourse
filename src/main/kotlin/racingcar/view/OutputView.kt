package racingcar.view

import racingcar.model.Car

object OutputView {

    fun displayRaceStart(){
        println()
        println("Race Results")
    }

    fun displayRound(cars: List<Car>){
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}