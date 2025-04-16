package racingcar.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("avant")
    }


    @Test
    fun goTest() {
        car.go();
        assertEquals(car.getStatus(), 1)
    }
}