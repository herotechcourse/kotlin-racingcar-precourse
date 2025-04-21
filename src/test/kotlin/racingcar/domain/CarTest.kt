package racingcar.domain

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Throw IllegalArgumentException when carName is blank`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("   ")
        }
    }

    @Test
    fun `Throw IllegalArgumentException when carName exceed 5`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("abcdef")
        }
    }
}