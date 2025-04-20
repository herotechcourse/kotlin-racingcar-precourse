package racingcar.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @Test
    fun `car starts at position zero`(){
        val car = Car("TestCar")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `moveForward should increment position by one unit`(){
        val car = Car("TestCar")
        car.moveForward()
        assertThat(car.position).isEqualTo(1)
    }
}