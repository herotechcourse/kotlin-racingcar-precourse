package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine();
    val carNames = carNamesInput
        .split(",")
        .map { it.trim() };
    validateCarNames(carNames);

    println("How many rounds will be played?")
    val raceRoundsInput = Console.readLine();
    val raceRounds = raceRoundsInput.toInt();
    validateRaceRounds(raceRounds);

    runRace(carNames, raceRounds);
}

fun runRace(carNames: List<String>, raceRounds: Int) {
    announceRace(carNames, raceRounds);
}

fun announceRace(carNames: List<String>, raceRounds: Int) {
    println("PREPARING ANOTHER EPIC CAR RACE");
    println("THE RACE WILL TAKE");
    println(" => $raceRounds ROUND(S)");
    println("TODAY'S CARS ARE");
    println(carNames.joinToString(separator = "\n") { " => $it" });
    println("GET READY!!\nAND..\nGOOO##");
}

fun validateCarNames(carNames: List<String>) {
    for (car in carNames) {
        if (car.isEmpty() || car.length > 4) {
            throw IllegalArgumentException("Car name must be 1-4 characters long")
        }
    }
}

fun validateRaceRounds(raceRounds: Int) {
    if (raceRounds < 1) {
        throw IllegalArgumentException("Race rounds must be at least 1")
    }
}
