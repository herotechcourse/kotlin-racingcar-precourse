package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `moves forward when random number is 4 or greater`() {
        val car = Car("pobi", object : IntGeneratorStrategy {
            override fun getIntValue(): Int = 4
        })

        car.tryMove()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `does not move when random number is less than 4`() {
        val car = Car("pobi", object : IntGeneratorStrategy {
            override fun getIntValue(): Int = 3
        })

        car.tryMove()

        assertThat(car.position).isEqualTo(0)
    }
}
