package racingcar.car

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
        // given
        val car = Car("car", AlwaysMoveStrategy())
        // when
        car.drive()
        // then
        assertEquals("-",car.position)
    }

    @Test
    fun `drive fail`() {
        // given
        val car = Car("car",NeverMoveStrategy())
        // when
        car.drive()
        // then
        assertEquals("",car.position)
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