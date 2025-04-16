package racingcar

object InputView {

    fun parseCarNamesInput(carNamesInput: String): List<String> {
        val names = carNamesInput.split(",").map { it.trim() }

        if (names.isEmpty()) throw IllegalArgumentException("At least one car name must be provided")

        names.forEach{ name ->
            if (name.isEmpty()) throw IllegalArgumentException("Cars name cannot be empty")
            if (name.length > 5) throw IllegalArgumentException("Car names cannot exceed 5 characters. Car '$name' has ${name.length} characters")
        }
        return names
    }

    fun readCarNamesInput(): String {
        println("Enter the names of the cars (comma-separated):")
        return readln()
    }

    fun readAndParseRoundCountInput(): Int {

        println("Number of rounds:")
        val roundCount = readln().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid positive number")
        if (roundCount<=0) throw IllegalArgumentException("Number of rounds must be positive")
        return roundCount

    }
}