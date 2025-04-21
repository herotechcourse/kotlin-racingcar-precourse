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

}