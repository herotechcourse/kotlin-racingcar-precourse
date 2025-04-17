package racingcar.domain.numbergenerator

import java.util.*

class FixedNumberGenerator(val numbers: Queue<Int>) : NumberGenerator {

    override fun generate(): Int {
        require(numbers.peek() in START_RANGE..END_RANGE) { NUMBER_OUT_OF_RANGE_ERROR }
        return numbers.poll()
    }

    companion object {
        private const val START_RANGE: Int = 0
        private const val END_RANGE: Int = 9

        private const val NUMBER_OUT_OF_RANGE_ERROR: String =
            "[ERROR] A number must be between ${START_RANGE} and ${END_RANGE}."
    }
}
