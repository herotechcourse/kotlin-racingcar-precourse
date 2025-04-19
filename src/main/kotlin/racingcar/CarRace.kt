package racingcar

import camp.nextstep.edu.missionutils.Randoms

class CarRace {
    // Define constant for threshold
    val RANDOM_NUMBER_THRESHOLD: Int = 4
    val WINNERS_PREFIX = "Winners : "

    fun raceCarsAndPrintResults(carNames: List<String>, numberOfRounds: Int) {
        // Validate user inputs
        validateUserInputs(carNames, numberOfRounds)
        // Initialize Race result with car names and default value
        val raceResult = initializeRace(carNames)

        // Execute race for the rounds given and populate results
        executeRaceRoundsAndPrintResult(carNames, numberOfRounds, raceResult)

        printWinners(determineWinners(raceResult))
    }

    fun validateUserInputs(carNames: List<String>, numberOfRounds: Int) {
        require(carNames.isNotEmpty()) { "Car names cannot be empty" }
        require(numberOfRounds >= 0) { "Number of rounds must be non-negative" }
        require(carNames.none { it.isEmpty() }) { "Car name should not be empty" }
        require(carNames.none { it.length > 5 }) { "Car name length should not be more than 5" }
    }

    fun initializeRace(carNames: List<String>): HashMap<String, String> {
        return HashMap(carNames.associateWith { "" })
    }

    fun executeRaceRoundsAndPrintResult(
        carNames: List<String>,
        numberOfRounds: Int,
        raceResult: HashMap<String, String>,
    ) {
        println()
        println("Race Results")
        repeat(numberOfRounds) {
            runSingleRound(carNames, raceResult)
            displayRaceStatus(raceResult)
            println()
        }
    }

    fun runSingleRound(
        carNames: List<String>, raceResult: HashMap<String, String>,
        // Adding lambda function to make this method testable
        randomNumber: () -> Int = { Randoms.pickNumberInRange(0, 9) }
    ) {
        carNames.forEach { car ->
            if (randomNumber() >= RANDOM_NUMBER_THRESHOLD) {
                raceResult[car] = raceResult[car] + "-"
            }
        }
    }

    fun displayRaceStatus(raceResult: Map<String, String>) {
        raceResult.forEach { (car, result) -> println("$car : $result") }
    }

    fun determineWinners(raceResult: Map<String, String>): List<String> {
        val maxLength = raceResult.values.maxOfOrNull { it.length } ?: 0
        return raceResult.filterValues { it.length == maxLength }.keys.toList()
    }

    fun printWinners(winners: List<String>) {
        println(WINNERS_PREFIX + winners.joinToString(", "))
    }
}