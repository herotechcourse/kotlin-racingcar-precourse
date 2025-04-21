package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest : NsTest() {

    @Test
    fun `should print race result and winners correctly for a normal case`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.runRace(listOf("pobi", "woni", "jun"), 1)
                val result = output()

                assertThat(result).contains("Race Results")
                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni :")
                assertThat(result).contains("jun : -")
                assertThat(result).contains("Winners : pobi, jun")
            },
            4, 3, 5
        )
    }

    @Test
    fun ` should initialize cars with their names`() {
        val cars = CarRacing.initializeCars(listOf("pobi", "woni", "jun"))
        assertThat(cars).hasSize(3)
        assertThat(cars.map { it.name }).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `car should move when random number is 4 or more`() {
        val cars = CarRacing.initializeCars(listOf("pobi"))
        assertRandomNumberInRangeTest(
            {
                CarRacing.raceSingleRound(cars)
                assertThat(cars[0].getPosition()).isEqualTo(1)
            },
            5
        )
    }

    @Test
    fun `car should not move when random number is less than 4`() {
        val cars = CarRacing.initializeCars(listOf("pobi"))
        assertRandomNumberInRangeTest(
            {
                CarRacing.raceSingleRound(cars)
                assertThat(cars[0].getPosition()).isEqualTo(0)
            },
            3
        )
    }

    @Test
    fun `should run race and determine a single winner`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.runRace(listOf("pobi", "woni"), 1)
                val result = output()

                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni :")
                assertThat(result).contains("Winners : pobi")
            },
            4, 2
        )
    }

    @Test
    fun `should run race and determine multiple winners`() {
        assertRandomNumberInRangeTest(
            {
                CarRacing.runRace(listOf("pobi", "woni", "jun"), 1)
                val result = output()

                assertThat(result).contains("pobi : -")
                assertThat(result).contains("woni : -")
                assertThat(result).contains("jun :")
                assertThat(result).contains("Winners : pobi, woni")
            },
            5, 4, 2
        )
    }

    override fun runMain() {
    }
}
