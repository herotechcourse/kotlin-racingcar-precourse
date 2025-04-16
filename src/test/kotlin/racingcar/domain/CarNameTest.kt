package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @Test
    fun `Car names must not be empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            CarName("")
        }
        assertEquals("Car names must not be empty.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456", "more than five letters"])
    fun `Car names must not exceed 5 characters`(name: String) {
        val exception = assertThrows<IllegalArgumentException> {
            CarName(name)
        }
        assertEquals("Car names must not exceed 5 characters.", exception.message)
    }
}
