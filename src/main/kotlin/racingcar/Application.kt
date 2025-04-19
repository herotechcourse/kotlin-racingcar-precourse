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
            throw IllegalArgumentException("Each car name must not exceed 5 characters.");
        }
    }

    // Prohibit duplicate car names
    if (cars.size != cars.distinct().size) {
        throw IllegalArgumentException("Car name must be unique.");
    }
    return cars;
}

fun inputRound(): Int {
    println("How many rounds will be played?");

    // Read input from the console
    val rounds = Console.readLine().toInt();

    // Ensure the number of rounds is positive
    if (rounds <= 0) {
        throw IllegalArgumentException("Round must be positive.");
    }

    return rounds;
}

fun racingCars(cars: List<String>, trace: Array<String>, rounds: Int) {
    println("Race Result");
    println();

    // Repeat the race for the given number of rounds
    for (i in 0 until rounds) {
        for (j in 0 until cars.size.toInt()) {
            val num = Randoms.pickNumberInRange(0, 9);
            // if num is 4 or more car will move forward
            if (num >= 4) {
                trace[j] = trace[j] + '-';
            }
            println("${cars[j]} : ${trace[j]}");
        }
        println();
    }
}



fun main() {
    val cars = inputCars();
    val rounds = inputRound();

    val trace: Array<String> = Array(cars.size, {""});

    racingCars(cars, trace, rounds);
}


