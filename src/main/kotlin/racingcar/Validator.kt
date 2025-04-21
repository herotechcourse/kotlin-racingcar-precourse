package racingcar

object Validator {
    fun validateCarNames(input: String?): List<String> {
        val names = input?.split(",")?.map { it.trim() } ?: throw IllegalArgumentException("Input cannot be null")
        if (names.isEmpty()) throw IllegalArgumentException("At least one car name must be provided")
        names.forEach {
            if (it.isEmpty()) throw IllegalArgumentException("Car name cannot be empty")
            if (it.length > 5) throw IllegalArgumentException("Car name cannot be longer than 5 characters")
        }
        return names
    }

    fun validateRounds(input: String?): Int {
        val number = input?.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number")
        if (number <= 0) throw IllegalArgumentException("Number of rounds must be greater than 0")
        return number
    }
}