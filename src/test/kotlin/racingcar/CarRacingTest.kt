package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("Car name validation and movement")
class CarRacingTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "abcdef"])
    fun `invalid car name throws exception`(name: String) {
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `car does not move when random below threshold`() {
        val car = Car("pobi")
        car.moveIfNecessary(3)
        assertThat(car.distance()).isEqualTo(0)
    }

    @Test
    fun `car moves when random meets threshold`() {
        val car = Car("pobi")
        car.moveIfNecessary(4)
        assertThat(car.distance()).isEqualTo(1)
    }

    @Test
    fun `single winner is correctly identified`() {
        val pobi = Car("pobi")
        val woni = Car("woni")
        pobi.moveIfNecessary(4)
        pobi.moveIfNecessary(4)
        woni.moveIfNecessary(4)

        val race = Race(listOf(pobi, woni), 0)
        assertThat(race.winners()).containsExactly("pobi")
    }

    @Test
    fun `multiple winners on tie`() {
        val pobi = Car("pobi")
        val woni = Car("woni")
        pobi.moveIfNecessary(4)
        woni.moveIfNecessary(4)

        val race = Race(listOf(pobi, woni), 0)
        assertThat(race.winners()).containsExactlyInAnyOrder("pobi", "woni")
    }
}
