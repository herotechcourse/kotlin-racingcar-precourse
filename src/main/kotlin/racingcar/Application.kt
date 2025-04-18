package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun inputCars(): List<String> {
    println("Enter the names of the cars (comma-seperated):");
    // Split the input string by commas
    val cars = Console.readLine().split(",");

    for (car in cars) {
        // Prohibit each car name to exceed 5 characters
        if (car.length > 5) {
            throw IllegalArgumentException("Each car name mush not exceed 5 characters.");
        }
    }
    return cars;
}

fun main() {
    val cars = inputCars();
}


