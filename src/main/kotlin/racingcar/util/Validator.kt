package racingcar.util

object Validator {

    fun validate(name: String) {
        if (name.length < 1) {
            throw IllegalArgumentException("Name must not under 1 characters")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Name must not exceed 5 characters")
        }
    }
}