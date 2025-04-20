package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
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
    fun `feature test 1`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi, woni, kiki", "3")
                assertThat(output()).contains("pobi : --", "woni : --", "kiki : -", "Winners : pobi, woni")
            },
            2, 4, 4, 8, 0, 2, 7, 9, 0
        )
    }

    @Test
    fun `exception test`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `validateNames call throws exception when list of names is empty`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateNames(listOf("")) }
        }
    }

    @Test
    fun `validateNames call throws exception when number of competitors names is less than 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateNames(listOf("pobi")) }
        }
    }

    @Test
    fun `validateRound call throws exception when user types 0 rounds`() {
        assertThrows<IllegalArgumentException> {
            validateRoundInput("0")
        }.also { e ->
            assertThat(e.message).contains("Number must be greater than zero!")
        }
    }

    @Test
    fun `validateRoundInput call throws Exception when input is a non-numeric strings`() {
        assertThrows<IllegalArgumentException> {
            validateRoundInput("abc")
        }.also { e ->
            assertThat(e.message).contains("Invalid round number!")
        }
    }

    @Test
    fun `getWinners displays single winner`() {
        val cars = listOf(
            Competitor("pobi").apply { position = 3 },
            Competitor("woni").apply { position = 1 }
        )
        assertThat(getWinners(cars)).extracting("name").containsExactly("pobi")
    }

    @Test
    fun `getWinners handles all tied`() {
        val cars = List(3) { Competitor("car$it").apply { position = 2 } }
        assertThat(getWinners(cars)).hasSize(3)
    }


    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}

class CompetitorTest : NsTest() {
    @Test
    fun `move does not increment when random number is less than 4`() {
        assertRandomNumberInRangeTest(
            {
                val competitor = Competitor("pobi")
                competitor.move()
                competitor.move()
                assertThat(competitor.position).isEqualTo(0)
            },
            3, 3
        )
    }

    @Test
    fun `move does increment when random number is equals or greater than 4`() {
        assertRandomNumberInRangeTest(
            {
                val competitor = Competitor("pobi")
                competitor.move()
                competitor.move()
                assertThat(competitor.position).isEqualTo(1)
            },
            3, 4
        )
    }

    @Test
    fun `new competitor starts at position 0`() {
        val competitor = Competitor("pobi")
        assertThat(competitor.position).isEqualTo(0)

    }

    @Test
    fun `printPosition shows name with no dashes when position is 0`() {
        val competitor = Competitor("woni")
        competitor.printPosition()
        assertThat(output()).contains("woni :")
    }

    @Test
    fun `printPosition shows correct dashes after moving`() {
        assertRandomNumberInRangeTest(
            {
                val competitor = Competitor("kiki")
                competitor.move()
                competitor.move()
                competitor.printPosition()
                assertThat(output()).contains("kiki : --")
            },
            4, 4
        )
    }

    override fun runMain() {
        main()
    }
}
