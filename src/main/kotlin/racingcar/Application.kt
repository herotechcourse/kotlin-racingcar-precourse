package racingcar

import camp.nextstep.edu.missionutils.Console
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

    // 1.2 Convert user input rounds to a positive integer (greater that 1)
    println("How many rounds will be played?")
    val gameRounds = Console.readLine().toInt()

    //1.3 Validate user input and make sure it is greater than 0

    if (gameRounds <= 0) {
        throw IllegalArgumentException("Number of Rounds Must Be Greater than 0")
    }
}
