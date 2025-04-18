package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms



fun main() {
    // TODO: Implement the program

    CarRacingGame.run()



}


class Car(val name: String){

    var position : Int = 0 // Assuming the car is stationary
    fun move(){
        if(Randoms.pickNumberInRange(0,9)>= 4){
            position++
        }
    }

    override fun toString(): String = "$name : ${"\uD83D\uDE97".repeat(position)}"

}

object CarRacingGame{
    private const val MAX_NAME_LENGTH = 5
    private const val  MIN_Rounds = 1


    fun run (){
        val cars = inputCars()
        val rounds = inputRounds()
        println("the expected rounds $rounds")
        race(cars, rounds)
        announceWinners(cars)
    }

    private fun inputCars(): List<Car> {
        println("Enter the names of the cars to race , seperated by commas : ")
        val names = Console.readLine().split(",").map { it.trim() }
        //println(names) // list of cars name
        validateCarNames(names)
        return names.map{Car (it)}

    }

    private fun validateCarNames(names:List<String>){
        names.forEach{
            if(it.isEmpty() || it.length > MAX_NAME_LENGTH){
                throw IllegalArgumentException("Car names must be between 1 and 5 characters long")
            }
        }
    }

    private fun inputRounds(): Int{
        println("How many rounds would you like to play?")
        val rounds = Console.readLine().toIntOrNull()?: throw IllegalArgumentException("Number of rounds must be a numeric value")
        if (rounds < MIN_Rounds){
            throw IllegalArgumentException("Number of rounds must be at least 1")

        }
        return rounds
    }

    private fun race(cars: List<Car>, rounds:Int){
        println("\nRace Results: ")
        repeat(rounds){
            cars.forEach {it.move()}
            println(cars.joinToString("\n") + "\n")
        }
    }
    private fun announceWinners(cars: List<Car>){
        val maxPosition = cars.maxOf {it.position}
        val winners = cars.filter {it.position == maxPosition}.map {it.name}
        println("Final Winners: ${winners.joinToString(",")}")
    }






}
