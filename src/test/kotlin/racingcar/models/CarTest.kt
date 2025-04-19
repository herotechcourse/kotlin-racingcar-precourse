package racingcar.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car does not move when range is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car moves one step when range is 4 or more`() {
        val car = Car("woni")
        car.move(4)
        assertThat(car.getPosition()).isEqualTo(1)

        car.move(5)
        assertThat(car.getPosition()).isEqualTo(2)
    }

    @Test
    fun `status returns name with correct number of dashes`() {
        val car = Car("jun")
        car.move(4)
        car.move(9)

        val expected = "jun : --"
        assertThat(car.status()).isEqualTo(expected)
    }
}
