package racingcar.car

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CarTest{
    @Test
    fun `generate car`() {
        val car = Car("car")
        assertEquals(0,car.position.length )
    }

    @Test
    fun `drive success`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("car")
                car.drive()
                assertEquals("-",car.position)
            }, 4
        )
    }

    @Test
    fun `drive fail`() {
        assertRandomNumberInRangeTest(
            {
                val car = Car("car")
                assertEquals("",car.position)
            },3
        )
    }

    @Test
    fun `valid carName`() {
        val car = Car("hello")
        assertEquals("hello",car.carName)
    }

    @Test
    fun `invalid carName`() {
        assertThrows(IllegalArgumentException::class.java){
            Car("hello1")
        }
    }
}