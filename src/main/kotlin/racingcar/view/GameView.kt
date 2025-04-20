package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

object GameView{

    fun readCarNames(): List<String>{
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()
        return input.split(",")
    }

    fun readRounds(): Int{
        println("How many rounds will be played? ")
        val number = Console.readLine().toIntOrNull()
        require(number != null && number > 0){ " Round count must be positive"}
        return number
    }

    fun printCarResult(cars:List<Car>){
        println()
        cars.forEach{car->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    fun printWinners(winners:List<Car>){
        val winnerCars = winners.joinToString(", "){ it.name }

        println("Winners : $winnerCars")
    }
}