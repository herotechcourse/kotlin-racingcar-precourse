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
    runRace(carNames, raceRounds);
}

fun runRace(carNames: List<String>, raceRounds: Int) {
    val announcer1 = """
        PREPARING ANOTHER EPIC CAR RACE
        THE RACE WILL TAKE
         => $raceRounds ROUND(S)      
        TODAY'S CARS ARE
    """.trimIndent()
    val announcer2 = """
        GET READY!!
        AND..
        GOOOO##        
    """.trimIndent()

    println(announcer1);
    for (car in carNames) println(" => $car");
    println(announcer2);
}

fun validateCarNames(carNames: List<String>) {
    for (car in carNames) {
        if (car.isEmpty() or (car.length > 4)) throw IllegalArgumentException("Name not allowed");
    }
}
