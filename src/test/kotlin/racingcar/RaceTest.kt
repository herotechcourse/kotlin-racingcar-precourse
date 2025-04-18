package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `should be able to add race car names`() {
        val race = Race()
        race.setCarNames(listOf("pobi", "woni", "jun"))

        assertThat(race.carNames).isEqualTo(listOf("pobi", "woni", "jun"))
    }

    @Test
    fun `should be able to add race rounds`() {
        val race = Race()
        race.setRounds(42)

        assertThat(race.rounds).isEqualTo(42)
    }

    @Test
    fun `should be able to initialize an array of Cars, each with its own name`() {
        val race = Race()
        race.setCarNames(listOf("pobi", "woni", "jun"))
        race.initializeCars()

        assertThat(race.cars[0].name).isEqualTo("pobi")
        assertThat(race.cars[1].name).isEqualTo("woni")
        assertThat(race.cars[2].name).isEqualTo("jun")
    }
}