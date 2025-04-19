package racingcar.domain

import racingcar.domain.base.NumberPickerBase

class Car(private val name: String, private val randomNumberPicker: NumberPickerBase) {
    private var distance: Int = 0

    init {
        validateContainingSpaces(name)
        validateNameFormat(name)
        validateNameLength(name)
    }

    constructor(name: String) : this(name, RandomNumberPicker)

    private fun validateNameLength(name: String) {
        if (name.length > VALID_NAME_LENGTH) {
            throw IllegalArgumentException("car name must not exceed $VALID_NAME_LENGTH characters")
        }
    }

    private fun validateContainingSpaces(name: String) {
        if (name.contains(SPACE)) {
            throw IllegalArgumentException("car name must not contains spaces")
        }
    }

    private fun validateNameFormat(name: String) {
        require(isAlphaNumericOnly(name)) {
            "car name must contain only letters and digits"
        }
    }

    private fun isAlphaNumericOnly(name: String): Boolean = name.all { it.isLetterOrDigit() }

    fun move() {
        val number = randomNumberPicker.pick()
        if (number >= MOVABLE_POINT) distance++
    }

    fun getDistance(): Int = distance

    companion object {
        private const val VALID_NAME_LENGTH: Int = 5
        private const val SPACE = " "
        private const val MOVABLE_POINT = 4
    }
}