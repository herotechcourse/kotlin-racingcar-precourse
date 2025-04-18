package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest : NsTest()   {
    @Test
    fun `run round test`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jido"))
        val race = Race(cars)
        race.runRound { MOVING_FORWARD }
        assertThat(cars.all { it.position == 1 })
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}