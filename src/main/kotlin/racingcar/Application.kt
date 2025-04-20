package racingcar

import racingcar.input.readLineAndGetRounds
import racingcar.input.readLineAndGetCars
import racingcar.output.printFromOutputManager
import racingcar.race.race

fun main() {
    println("Enter the names of the cars (comma-separated):");
    val cars: Array<String> = readLineAndGetCars();

    println("How many rounds will be played?");
    val rounds: Int = readLineAndGetRounds();

    race(cars, rounds);
    printFromOutputManager();
}