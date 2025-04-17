package racingcar.utils

interface InputValidator {
    fun validateCarName(carName: String): List<String>
    fun validateRounds(rounds: String): Int
}