package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    val car: Car = Car()

    @ParameterizedTest
    @ValueSource(strings = ["pobi", "woni", "jun"])
    fun `Add Score by given name`(carName: String) {
        //when
        car.addScore(carName)

        //then
        val score = car.getScore(carName)
        assertEquals(1, score)
    }
}