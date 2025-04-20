package racingcar

import racingcar.input.readLineAndGetRounds
import racingcar.input.readLineAndGetCars
import racingcar.output.printFromOutputManager
import racingcar.race.race

fun main() {
    val cars: Array<String> = getCarsFromDialog()
    val rounds: Int = getRoundNumbersFromDialog();

    race(cars, rounds);
    printFromOutputManager();
}

fun getCarsFromDialog(): Array<String> {
    println("Enter the names of the cars (comma-separated):");
    val cars: Array<String> = readLineAndGetCars();
    return cars;
}
fun getRoundNumbersFromDialog(): Int{
    println("How many rounds will be played?");
    val rounds: Int = readLineAndGetRounds();
    return rounds;
}