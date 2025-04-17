package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private val carName: CarName = CarName("pobi")

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 123])
    fun `car moves if power is 4 or greater`(power: Int) {
        val car = Car(carName, FixedPowerGenerator(power))
        car.move()
        assertEquals(Position(1), car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `car cannot moves if power is under 4`(power: Int) {
        val car = Car(carName, FixedPowerGenerator(power))
        car.move()
        assertEquals(Position(0), car.position)
    }
}
