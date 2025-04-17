package racingcar.car

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CarTest{
    @Test
    fun `generate car`() {
        // given
        val car = Car("car")
        // when & then
        assertEquals(0,car.position.length )
    }

    @Test
    fun `drive success`() {

        assertRandomNumberInRangeTest(
            {
                // given
                val car = Car("car")
                // when
                car.drive()
                // then
                assertEquals("-",car.position)
            }, 4
        )
    }

    @Test
    fun `drive fail`() {
        assertRandomNumberInRangeTest(
            {
                // given
                val car = Car("car")
                // when & then
                assertEquals("",car.position)
            },3
        )
    }

    @Test
    fun `valid carName`() {
        // given
        val car = Car("hello")
        // when & then
        assertEquals("hello",car.carName)
    }

    @Test
    fun `invalid carName`() {
        assertThrows(IllegalArgumentException::class.java){
            Car("hello1")
        }
    }
}