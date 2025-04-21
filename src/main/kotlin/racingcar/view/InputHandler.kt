package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

class InputHandler {

    companion object {

        fun getCars(): MutableList<Car> {
            println("Enter the names of the cars (comma-separated):")
            val input = Console.readLine()
            val carNames : List<String> = input.split(',')
            val cars : MutableList<Car> = mutableListOf()
            for (rawName in carNames) {
                val name = rawName.trim()
                if (name.length > 5) {
                    throw IllegalArgumentException("Name of car is too long.")
                }
                else if (name.isEmpty()) {
                    throw IllegalArgumentException("Name of car does not exist.")
                }
                cars.add(Car(name, 0))
            }
            return cars
        }

        fun getNumberOfRounds(): Int {
            println("How many rounds will be played?")
            val input = Console.readLine()
            val numOfRounds: Int;
            try {
                numOfRounds = input.toInt()
            }
            catch (e: NumberFormatException) {
                throw IllegalArgumentException("Provided input is not an integer.")
            }
            if (numOfRounds < 1) {
                throw IllegalArgumentException("Provided input is not a positive.")
            }
            return numOfRounds
        }
    }
}