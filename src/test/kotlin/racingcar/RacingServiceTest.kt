package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @packageName    : racingcar
 * @fileName       : RacingServiceTest
 * @author         : yong
 * @date           : 4/18/25
 * @description    :
 */
class RacingServiceTest {
    @Test
    fun TestCarMovementEachRound() {
        // given
        val names = listOf("woni", "jun", "pobi")
        val service = RacingService(names, 3)

        // when
        repeat(3) {
            service.moveCarForward(listOf(5, 5, 5))
        }

        // then
        val expected = """
        woni: ---
        jun: ---
        pobi: ---
        """.trimIndent()
        assertEquals(expected, service.getRaceResultString())
    }

    @Test
    fun carsMoveCorrectlyEachRound() {
        val expected3 = """
        woni: ---
        jun: ---
        pobi: ---
        """.trimIndent()

        val expected2 = """
        woni: --
        jun: --
        pobi: --
        """.trimIndent()

        val expected1 = """
        woni: -
        jun: -
        pobi: -
        """.trimIndent()


        // given
        val names = listOf("woni", "jun", "pobi")
        val service = RacingService(names, 3)

        // when, then
        service.moveCarForward(listOf(5, 5, 5))
        assertEquals(expected1, service.getRaceResultString())
        service.moveCarForward(listOf(5, 5, 5))
        assertEquals(expected2, service.getRaceResultString())
        service.moveCarForward(listOf(5, 5, 5))
        assertEquals(expected3, service.getRaceResultString())

    }

}