package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @Test
    fun `Car names must not be empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            CarName("")
        }
        assertEquals("Car names must not be empty.", exception.message)
    }
}
