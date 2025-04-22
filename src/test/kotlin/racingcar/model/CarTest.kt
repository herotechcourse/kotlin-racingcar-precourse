package racingcar.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car
    private lateinit var fuel: Fuel

    @BeforeEach
    fun setUp() {
        fuel = GasStation()
        car = Car("avant", fuel = fuel)
    }


    @Test
    fun goTest() {
        car.go();
        assertEquals(car.getStatus(), 1)
    }
}