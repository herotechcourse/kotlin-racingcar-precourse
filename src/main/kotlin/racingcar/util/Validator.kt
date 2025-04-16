package racingcar.util

object Validator {

    fun validateNames(names: List<String>){
        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car names must be 5 characters or fewer.")
        }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException("Car names must be unique.")
        }
    }

    fun validateRoundNumber(input: String): Int{
        val number = input.toIntOrNull()
        if (number != null && number > 0) {
            return number
        } else {
            throw IllegalArgumentException("Please enter a valid number.")
        }
    }
}