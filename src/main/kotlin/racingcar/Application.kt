package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms



fun main() {
    // TODO: Implement the program

    CarRacingGame.run()



}


class Car(val name: String){

}

object CarRacingGame{
    private const val MAX_NAME_LENGTH = 5


    fun run (){
        val cars = inputCars()
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






}
