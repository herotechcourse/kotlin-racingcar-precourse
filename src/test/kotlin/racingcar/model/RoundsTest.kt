package racingcar.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundsTest {

    @Test
    fun `should throw exception when count is less than MIN_COUNT`() {
        // Arrange
        val invalidCount = 0

        // Act
        // Assert
        assertThatThrownBy { Rounds(invalidCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round must be greater than or equal to 1")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 10])
    fun `should create Rounds when count is valid`(count: Int) {
        // Act
        // Assert
        assertThatCode { Rounds(count) }.doesNotThrowAnyException()
    }

    @Test
    fun `repeat should invoke action exactly count times`() {
        // Arrange
        val count = 4
        val rounds = Rounds(count)
        var invoked = 0

        // Act
        rounds.repeat { invoked++ }

        // Assert
        assertThat(invoked).isEqualTo(count)
    }
}
