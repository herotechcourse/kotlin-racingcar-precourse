package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    private const val MAX_CAR_NAMES = 20
    private const val MIN_CAR_NAMES = 2
    private const val MIN_ROUNDS = 1
    private const val MAX_ROUNDS = 100
    private const val MIN_CHARS = 1
    private const val MAX_CHARS = 5

    fun readCarNames() : String {
        println("Enter the names of the cars (comma-separated):")
        val rawCarNames = Console.readLine()

        require (rawCarNames.isNotEmpty()) {
            "No car names provided."
        }

        return rawCarNames
    }

    fun validateCarNames(rawCarNames : String) : List<String> {
        val carNameList = rawCarNames.split(",")

        require (carNameList.size >= MIN_CAR_NAMES) {
            "At least $MIN_CAR_NAMES car names required."
        }
        require (carNameList.size <= MAX_CAR_NAMES ) {
            "Maximum $MAX_CAR_NAMES car names allowed."
        }
        carNameList.forEach {
            validateCarName(it)
        }

        return carNameList
    }

    fun readRounds() : String {
        println("How many rounds will be played?")
        val rawRounds = Console.readLine()

        require (rawRounds.isNotEmpty()) {
            "No number provided."
        }

        return rawRounds
    }

    fun validateRounds(rawRounds : String) : Int {
        val rounds = rawRounds.toIntOrNull()

        require (rounds != null) {
            "Input must be an Integer number."
        }
        require (rounds in MIN_ROUNDS..MAX_ROUNDS) {
            "Only rounds in range $MIN_ROUNDS - $MAX_ROUNDS accepted."
        }

        return rounds
    }

    private fun validateCarName(carName: String) {
        require (carName.isNotEmpty()) {
            "Car name cannot be empty and no trailing commas allowed."
        }
        require (carName.length in MIN_CHARS..MAX_CHARS) {
            "Each car name must be between $MIN_CHARS and $MAX_CHARS characters."
        }
        require (carName.all { it.isLetterOrDigit() }) {
            "Car name can only contain letters and digits. " +
                    "No spaces or special characters allowed."
        }
    }
}