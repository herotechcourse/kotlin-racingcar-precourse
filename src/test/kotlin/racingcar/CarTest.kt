package racingcar

import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car forward moves test`(){
        val testCar = Car("car1")
        assert(testCar.getPosition() == 0)
        testCar.moveForward(MOVING_FORWARD)
        assert(testCar.getPosition() == 1)
    }

    @Test
    fun `car stays still test`(){
        val testCar = Car("car1")
        assert(testCar.getPosition() == 0)
        testCar.moveForward(STOP)
        assert(testCar.getPosition() == 0)
    }

    @Test
    fun `display position test`(){
        val testCar = Car("car1")
        testCar.moveForward(5)
        assert(testCar.getPositionStatus() == "car1 : -")
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}