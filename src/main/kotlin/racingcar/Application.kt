package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    // TODO: Implement the program

    //Step One: We need to get user input for car names and rounds.
    // We will use ReadLine to achieve this.(refactored for modularity and clarity)

    fun readValidatedCarNames(): List<String> {
        println("Please enter the names of cars (separated by commas):")
        val namesOfCars = Console.readLine().split(",").map {it.trim()}

        if(namesOfCars.any {it.length > 5}) {
            throw IllegalArgumentException("Name of car must not exceed 5 characters")
        }
        return namesOfCars
    }

    // 1.2 Convert user input rounds to a positive integer (greater than 1)
    fun readValidatedGameRounds(): Int {
        println("How many rounds will be played?")
        val gameRounds = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("Rounds must be a number")

        if (gameRounds <= 0) {
            throw IllegalArgumentException("Number of Rounds Must Be Greater than 0")
        }
        return gameRounds
    }

    val namesOfCars = readValidatedCarNames()
    val gameRounds = readValidatedGameRounds()



    //2. Create Car obj.
    val cars = namesOfCars.map {Car(it)}

    println("\nGame Results")

}

//3.Create fn that takes the Car obj as param.
//Loops through each car.
// Prints Car.
// Prints the cars name/progress.
// add spacing after each round

fun printGameRound(cars: List<Car>) {
    for (car in cars) {
        println("${car.name} : ${car.getGameProgress()}")
    }
    println()
}


//2.We need to create the cars:
// 2.1 Cars need a name
// 2.2 Cars need a current position they are in.
// 2.3 Give cars ability to move forward.
// 2.4 Track game progress.


//2.1 Cars need a name
class Car(val name: String) {
//2.2 Cars need a current position they are in
    var position: Int = 0
        private set

//2.3 Give cars ability to move forward.
    fun moveCar() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }

//2.4 Track game progress.
    fun getGameProgress(): String {
        return "-".repeat(position)
    }
}