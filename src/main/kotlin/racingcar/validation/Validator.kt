package racingcar.validation

/**
 * General interface for input validation.
 */
fun interface Validator<String, T> {
    fun validate(input: String): T
}
