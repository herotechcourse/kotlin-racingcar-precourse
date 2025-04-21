package racingcar.validator

interface InputValidator<I> {
    /**
     * @throws IllegalArgumentException if the input is invalid
     * @return the parsed/normalized input
     */
    fun validate(raw: String): I
}