package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `increase car position by 1`() {
        val position = Position(0)

        val increasedPosition = position.increase()

        assertEquals(Position(1), increasedPosition)
    }
}
