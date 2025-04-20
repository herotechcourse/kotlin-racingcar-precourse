package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows


class CarTest {

    @Test
    fun `creates car with valid name` () {
        val car = Car("pobi")
        assertThat(car.getName()).isEqualTo("pobi")
        assertThat(car.getPosition()).isZero()
    }

    @Test
    fun `throws when name is blank`() {
        val ex = assertThrows<IllegalArgumentException> { Car("") }
        assertThat(ex.message).contains("must be  maximum 5 characters")
    }

    @Test
    fun `throws when name is too long`() {
        val name = "tooLongName"
        val ex = assertThrows<IllegalArgumentException> { Car(name) }
        assertThat(ex.message).contains("must be  maximum 5 characters")
    }

    @Test
    fun `move increments position when random meets threshold`() {
        val car = Car("pobi") { 4 }
        car.move()
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `move does not increment when random below threshold`() {
        val car = Car("pobi") { 3 }
        car.move()
        assertThat(car.getPosition()).isZero()
    }
}
