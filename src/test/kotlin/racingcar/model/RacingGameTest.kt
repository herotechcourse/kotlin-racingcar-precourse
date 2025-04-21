package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.main

class RacingGameTest : NsTest(){

    override fun runMain() {
        main()
    }

    @Test
    fun `test racing game start`() {
        assertSimpleTest {
            RacingGame(mutableListOf(Car("pobi")), 1).startGame()
        }
    }

    @Test
    fun `test one car winner`(){
        val cars = listOf(Car("pobi"), Car("woni"))
        val game = RacingGame(cars.toMutableList(), 1)
        assertRandomNumberInRangeTest(
            {
                game.startGame()
                val winner = game.findWinner()
                assertThat(winner).containsOnly(cars[0])
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `test two car winner`(){
        val cars = listOf(Car("pobi"), Car("woni"))
        val game = RacingGame(cars.toMutableList(), 1)
        assertRandomNumberInRangeTest(
            {
                game.startGame()
                val winner = game.findWinner()
                assertThat(winner).containsOnly(cars[0], cars[1])
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}