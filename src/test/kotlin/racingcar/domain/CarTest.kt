package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.ExceptionMessage

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
    fun `throw IllegalArgumentException when provided invalid move condition less 0`() {
        //given
        val car = Car("pobi_test")

        //when
        val exception = assertThrows<IllegalArgumentException> {
            car.forwardCar(-1)
        }

        //then
        assertEquals(exception.message, ExceptionMessage.INVALID_MOVE_CONDITION.message)
    }

    @Test
    fun `throw IllegalArgumentException when provided invalid move condition exceed 10`() {
        //given
        val car = Car("pobi_test")

        //when
        val exception = assertThrows<IllegalArgumentException> {
            car.forwardCar(10)
        }

        //then
        assertEquals(exception.message, ExceptionMessage.INVALID_MOVE_CONDITION.message)
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