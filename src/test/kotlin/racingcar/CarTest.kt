package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Engine

class CarTest {

    @Test
    @DisplayName("Car needs to change position by movement")
    fun move() {
        // given
        val engine = object : Engine {
            override fun move(): Int = 3
        }
        val car = Car(name = "test-car", position = 0, engine = engine)

        // when
        car.goForward()

        // then
        val expected = 3
        val actual = car.getPosition()
        assertEquals(expected, actual)
    }
}
