package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

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
    val distanceScores: MutableMap<String, Int> = carNames
        .associateWith { 0 }
        .toMutableMap();
    announceRace(carNames, raceRounds);
    repeat(raceRounds) {
        val movementThreshold = 4;
        continueAnotherRound(distanceScores, movementThreshold);
    }
}

fun continueAnotherRound(distanceScores: MutableMap<String, Int>, movementThreshold: Int) {
    for ((name, score) in distanceScores) {
        val movementScore = Randoms.pickNumberInRange(0, 9);
        if (movementScore >= movementThreshold) distanceScores[name] = score + 1;
    }
    printCurrentRace(distanceScores);
}

fun printCurrentRace(distanceScores: Map<String, Int>) {
    val maxNameLength = maxOf("Race".length, distanceScores.keys.maxOf { it.length })
    val title = "Race".padEnd(maxNameLength)

    println("$title % Results")
    for ((carName, distance) in distanceScores) {
        val paddedName = carName.padEnd(maxNameLength)
        val distanceString = "-".repeat(distance)
        println("$paddedName : $distanceString")
    }
    println();
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
        if (car.isEmpty() || car.length > 5) {
            throw IllegalArgumentException("Car name must be 1-4 characters long")
        }
    }
}

fun validateRaceRounds(raceRounds: Int) {
    if (raceRounds < 1) {
        throw IllegalArgumentException("Race rounds must be at least 1")
    }
}
