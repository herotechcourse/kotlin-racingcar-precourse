package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = readCarName()

}

fun readCarName(): List<String>{
    print("Enter the names of the cars (comma-separated): ")
    val input = Console.readLine();
    val carNames = input.split(",")
    val invalidNames = carNames.filter { name -> name.length > 5 }
            if (invalidNames.isNotEmpty()) {
            throw IllegalArgumentException("Car name(s) '${invalidNames.joinToString(", ")}' exceed 5 character limit.")
        }


    return carNames
}
