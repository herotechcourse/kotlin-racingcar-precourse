package racingcar.utils

interface InputValidator {
    fun validateCarName(carName: String)
    fun validateRounds(rounds: String): Int
}