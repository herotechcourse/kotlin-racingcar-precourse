package racingcar

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarTest {

    @Test
    fun `getPositionInString return correct format`() {
        val testCar = Car("John")
        testCar.position = 3

        assertEquals("John: ---",testCar.getPositionInSting())
    }
}