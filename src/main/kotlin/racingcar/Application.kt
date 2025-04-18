package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun inputCars(): List<String> {
    println("Enter the names of the cars (comma-seperated):");
    // Split the input string by commas
    val cars = Console.readLine().split(",");
    return cars;
}

fun main() {
    val cars = inputCars();
}


