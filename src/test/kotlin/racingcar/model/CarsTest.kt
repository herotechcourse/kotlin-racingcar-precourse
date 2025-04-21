package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {

    private lateinit var cars: Cars

    @BeforeEach
    fun setUp() {
        cars = Cars(
            listOf(
                Car(Name("a")),
                Car(Name("b")),
                Car(Name("c"))
            )
        )
    }

    @Test
    fun `should reflect car movements accurately in LapReport`() {
        val powerGenerator = ListPowerGenerator(listOf(9, 4, 0))
        cars.moveAll(powerGenerator)

        val expected = setOf(
            LapStatus(Name("a"), Position(1)),
            LapStatus(Name("b"), Position(1)),
            LapStatus(Name("c"), Position(0))
        )
        assertThat(cars.toLapReport().statuses).containsExactlyInAnyOrderElementsOf(expected)
    }

    @Test
    fun `should not move any car when all power is below threshold`() {
        val powerGenerator = ListPowerGenerator(listOf(1, 2, 3))
        cars.moveAll(powerGenerator)

        val allZero = cars.toLapReport().statuses.all { it.position == Position(0) }
        assertThat(allZero).isTrue
    }

    @Test
    fun `should return all cars with highest position as winners`() {
        val powerGenerator = ListPowerGenerator(listOf(3, 4, 4))
        cars.moveAll(powerGenerator)

        val winners = cars.findWinners()
        assertThat(winners).containsExactlyInAnyOrder(Name("b"), Name("c"))
    }

}
