package racingcar.util

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.Exceptions.validateCarNameLength
import racingcar.util.Exceptions.validateInteger
import racingcar.util.Exceptions.validateNotBlank

class ExceptionsTest {
    @Test
    fun `Throw an exception if a car name exceeds the maximum length`() {
        val carName = "siyeonson"
        assertThatThrownBy { carName.validateCarNameLength() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Constant.CAR_NAME_EXCEED_ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   "])
    fun `Throw an exception if a car name is blank`(carName: String) {
        assertThatThrownBy { carName.validateNotBlank() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Constant.CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE)
    }

    @Test
    fun `Throw an exception if the number of rounds is not a positive integer`() {
        val roundCount = "abc"
        assertThatThrownBy { roundCount.validateInteger() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Constant.ROUND_COUNT_TYPE_ERROR_MESSAGE)
    }
}