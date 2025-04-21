package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `feature test`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "Winners : pobi")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `driveCount increases after drive`(){
        val car = Car("dong")
        car.drive()
        val afterDrive = car.driveCount

        assertEquals(afterDrive, 1)
    }

    @Test
    fun `checkWinner returns all cars with highest driveCount`(){
        val car1 = Car("1").apply { driveCount = 3 }
        val car2 = Car("2").apply { driveCount =5 }
        val car3 = Car("3").apply { driveCount =5 }

        val game = Game(listOf(car1, car2, car3))
        val winners = game.checkWinner()

        assertEquals(2, winners.size)
        assertTrue(winners.containsAll(listOf(car2, car3)))

    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
