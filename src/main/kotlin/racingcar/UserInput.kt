package racingcar

object UserInput {
    fun getCarNames(): Set<String> {
        println("Enter the names of the cars (comma-separated):")
        val carNames = readlnOrNull()?.split(",")?.map { it.trim() }
            ?: throw IllegalArgumentException("You need to provide car names")

        if (carNames.any { it.isEmpty() }) throw IllegalArgumentException("Each car name must not be empty")
        if (carNames.any { it.length > 5 }) throw IllegalArgumentException("Each car name must not be more than 5 characters")
        if (carNames.size < 2) throw IllegalArgumentException("At least two car names must be provided for a race")

        return carNames.toSet()
    }

    fun getNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val numberOfRounds = readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException("Invalid rounds number")

        return numberOfRounds
    }
}
