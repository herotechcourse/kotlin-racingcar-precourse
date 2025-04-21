package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `does not move and returns self when random number is 3 or lower`() {
        //given
        val car = Car("pobi_test")

        //when
        val newCar = car.forwardCar(3)

        //then
        assertEquals(0, car.currentProgress)
        assertEquals(0, newCar.currentProgress)
        assertEquals(car, newCar)
    }

    @Test
    fun `moves forward and returns new instance when random number is 4 or higher`() {
        //given
        val car = Car("pobi_test")

        //when
        val newCar = car.forwardCar(4)

        //then
        assertEquals(0, car.currentProgress)
        assertEquals(1, newCar.currentProgress)
        assertNotEquals(car, newCar)
    }

    @Test
    fun `prints progress with correct dash format`() {
        //given
        val rounds = 2
        var car = Car("pobi_test")

        //when
        repeat(rounds) {
            car = car.forwardCar(4)
        }

        //then
        car.printProgress()
    }
}