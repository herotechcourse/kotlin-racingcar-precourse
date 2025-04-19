package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest : NsTest() {
    @Test
    fun `test car movement`() {
        var car =
            Car(
                "pobi",
                0,
            )
        car
            .move(1)
            .move(2)
            .move(3)
            .move(4)
            .move(5)
            .move(6)
            .displayProgress()
        assertThat(output()).contains("pobi : --")
    }

    @Test
    fun `test a simple race game (always moving)`() {
        val alwaysMoveRandomGenerator: RandomNumberGenerator =
            object : RandomNumberGenerator {
                override fun pickNumberInRange(
                    startInclusive: Int,
                    endInclusive: Int,
                ): Int = MOVING_FORWARD
            }
        val gameCars = listOf(Car("pobi", 0), Car("woni", 0))
        val gameInput = Input(gameCars, 1)
        Game(gameInput).run(alwaysMoveRandomGenerator)
        assertThat(output()).contains("pobi : -", "woni : -", "Winners : pobi, woni")
    }

    @Test
    fun `test a simple race game (always stop)`() {
        val alwaysMoveRandomGenerator: RandomNumberGenerator =
            object : RandomNumberGenerator {
                override fun pickNumberInRange(
                    startInclusive: Int,
                    endInclusive: Int,
                ): Int = STOP
            }
        val gameCars = listOf(Car("pobi", 0), Car("woni", 0))
        val gameInput = Input(gameCars, 1)
        Game(gameInput).run(alwaysMoveRandomGenerator)
        assertThat(output()).contains("pobi : ", "woni : ", "Winners : pobi, woni")
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
