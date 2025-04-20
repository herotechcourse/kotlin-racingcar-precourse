package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
/**
 * Handles all input and output for the car racing game.
 */
object GameView{

    /**
     * Reads car names input from the user.
     * @return A list of car names entered by the user, split by commas.
     */
    fun readCarNames(): List<String>{
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()
        return input.split(",")
    }

    /**
     * Reads the number of race rounds from the user.
     * @return The number of rounds as an integer.
     * @throws IllegalArgumentException if input is not a positive integer.
     */
    fun readRounds(): Int{
        println("How many rounds will be played? ")
        val number = Console.readLine().toIntOrNull()
        require(number != null && number > 0){ " Round count must be positive"}
        return number
    }

    /**
     * Prints the current race status for each car.
     * Each car's position is represented by dashes ('-').
     * @param cars List of [Car] objects to display.
     */
    fun printCarResult(cars:List<Car>){
        println()
        cars.forEach{car->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    /**
     * Prints the winners of the race.
     * @param winners List of winning [Car] objects.
     */
    fun printWinners(winners:List<Car>){
        val winnerCars = winners.joinToString(", "){ it.name }

        println("Winners : $winnerCars")
    }

}
