package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `create car with valid name`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
    }

    @Test
    fun `empty name throws exception`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `blank name throws exception`() {
        assertThrows<IllegalArgumentException> {
            Car("   ")
        }
    }

    @Test
    fun `name longer than 5 throws exception`() {
        assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
    }

    @Test
    fun `move increases position by 1`() {
        val car = Car("pobi")
        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
