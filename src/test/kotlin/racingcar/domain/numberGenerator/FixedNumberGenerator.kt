package racingcar.domain.numberGenerator

import racingcar.domain.numbergenerator.NumberGenerator

class FixedNumberGenerator(val numbers: MutableList<Int>) : NumberGenerator {

    init {
        require(numbers.all { it in START_RANGE..END_RANGE }) { NUMBER_OUT_OF_RANGE_ERROR }
    }

    override fun generate(): Int {
        return numbers.removeFirst()
    }

    companion object {
        private const val START_RANGE: Int = 0
        private const val END_RANGE: Int = 9

        private const val NUMBER_OUT_OF_RANGE_ERROR: String =
            "[ERROR] A number must be between $START_RANGE and $END_RANGE."
    }
}
