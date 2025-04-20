package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.util.RandomValueGenerator

class RandomValueGeneratorTest {
    @Test
    fun `generate random number between 0 and 9`() {
        val values = (1..100).map { RandomValueGenerator.generateNumber() }
        values.forEach { value ->
            assertEquals(true, (value in 0..9))
        }
    }
}