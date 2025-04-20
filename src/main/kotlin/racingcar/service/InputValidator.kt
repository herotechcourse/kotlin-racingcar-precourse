package racingcar.service

import racingcar.exception.ExceptionMessage
import racingcar.model.Constants

object InputValidator {
    private val validCarNameRegex = Regex("^[a-zA-Z0-9]+$")

    fun validateCarNames(names: List<String>){
        if(names.isEmpty()){
            throw IllegalArgumentException(ExceptionMessage.NO_CARS_PROVIDED.message)
        }

        if(names.any {it.isBlank()}) {
            throw IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.message)
        }

        if(names.any{it.contains(" ")}) {
            throw IllegalArgumentException(ExceptionMessage.WHITESPACE_IN_CAR_NAME.message)
        }

        if (names.any{it.length > Constants.MAX_NAME_LENGTH }) {
            throw IllegalArgumentException(ExceptionMessage.TOO_LONG_CAR_NAME.message)
        }

        if (names.toSet().size != names.size) {
            throw IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_NAME.message)
        }

        if (names.any{!validCarNameRegex.matches(it)}){
            throw IllegalArgumentException(ExceptionMessage.INVALID_CHARACTER_IN_CAR_NAME.message)
        }

        if (names.size > Constants.MAX_CAR_COUNT){
            throw IllegalArgumentException(ExceptionMessage.EXCEED_MAX_CAR_COUNT.message)
        }
    }

    fun validateRounds(rounds: Int) {
        if (rounds <= 0){
            throw IllegalArgumentException(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }

        if (rounds > Constants.MAX_ROUND_COUNT) {
            throw IllegalArgumentException(ExceptionMessage.EXCEED_MAX_ROUND_COUNT.message)
        }
    }
}