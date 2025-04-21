package racingcar.models

import camp.nextstep.edu.missionutils.Console

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
            val numOfRounds = Console.readLine()
            return numOfRounds.toInt()
        }
    }
}