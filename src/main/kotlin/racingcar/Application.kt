package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    // TODO: Implement the program

    //Step One: We need to get user input for car names and rounds. We will use ReadLine to achieve this.
    println("Please enter the names of cars (separated by commas):")
    val namesOfCars = Console.readLine().split(",").map {it.trim()}

    /*We also need to validate user input and throw errors(IllegalArgumentException) if input does not meet req:
    1.1 No car name  should be longer than 5 characters
    1.2 Convert user input rounds to a positive integer (greater than 1)
    1.3 Validate user input and make sure it is greater than 0
    */


    // 1.1 No car name  should be longer than 5 characters
    if(namesOfCars.any {it.length > 5}) {
        throw IllegalArgumentException("Name of car must not exceed 5 characters")
    }

    // 1.2 Convert user input rounds to a positive integer (greater than 1)
    println("How many rounds will be played?")
    val gameRounds = Console.readLine().toInt()

    //1.3 Validate user input and make sure it is greater than 0

    if (gameRounds <= 0) {
        throw IllegalArgumentException("Number of Rounds Must Be Greater than 0")
    }


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