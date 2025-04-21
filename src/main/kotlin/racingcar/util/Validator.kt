package racingcar.util

object Validator {

    fun validate(name: String) {
        if (name.isNullOrEmpty() || name.length < 1) {
            throw IllegalArgumentException(ExceptionMessage.NAME_LENGTH_UNDER_1.message)
        }
        if (name.length > 5) {
            throw IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEED_5.message)
        }
    }
}