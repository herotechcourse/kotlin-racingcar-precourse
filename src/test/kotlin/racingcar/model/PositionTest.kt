package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `Position cannot be negative`() {
        // Arrange
        val negativeValue: Int = -1

        // Act
        // Assert
        assertThatThrownBy { Position(negativeValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Position cannot be negative.")
    }

    @Test
    fun `initial Position should have value 0`() {
        // Arrange
        // Act
        val initialPosition: Position = Position.initial()

        // Assert
        assertThat(initialPosition).isEqualTo(Position(0))
    }

    @Test
    fun `move should return a new Position with value increased by 1`() {
        // Arrange
        val initialValue: Int = 0
        val position: Position = Position(initialValue)

        // Act
        val moved = position.move()

        // Assert
        assertThat(moved).isEqualTo(Position(initialValue + 1))
    }

    @Test
    fun `Position should support comparison operations`() {
        // Arrange
        val p1 = Position(1)
        val p2 = Position(2)

        // Act
        // Assert
        SoftAssertions.assertSoftly {
            assertThat(p1).isLessThan(p2)
            assertThat(p2).isGreaterThan(p1)
            assertThat(p1.compareTo(p1)).isZero()
        }
    }
}
