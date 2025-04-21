package racingcar.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ExceptionMessage

class RaceCoreTest {

    @Test
    fun `throw IllegalArgumentException when provided name is null or empty or less 1 characters`() {
        //given
        val invalidCarName = ""
        val carNames = "poby,jinju," + invalidCarName
        val core = RaceCore(carNames, 5)

        //when
        val exception = assertThrows<IllegalArgumentException> {
            core.register()
        }

        //then
        assertEquals(exception.message, ExceptionMessage.NAME_LENGTH_UNDER_1.message)
    }

    @Test
    fun `throw IllegalArgumentException when provided name exceed 5 characters`() {
        //given
        val invalidCarName = "bad*name"
        val carNames = "poby,jinju," + invalidCarName
        val core = RaceCore(carNames, 5)

        //when
        val exception = assertThrows<IllegalArgumentException> {
            core.register()
        }

        //then
        assertEquals(exception.message, ExceptionMessage.NAME_LENGTH_EXCEED_5.message)
    }
}