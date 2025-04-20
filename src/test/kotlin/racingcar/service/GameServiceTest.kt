package racingcar.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.fixture.Fixture

class GameServiceTest {
    private val service = GameService()

    @Test
    @DisplayName("[Success] pobi moves 4, won moves 5")
    fun `test racing all car`() {
        val pobiCar = Car("pobi", Fixture.FourMovingNumberPicker)
        val wonCar = Car("won", Fixture.FiveMovingNumberPicker)
        val testingCars = Cars(mutableListOf(pobiCar, wonCar))

        service.raceAll(6, testingCars)

        Assertions.assertEquals(4, pobiCar.getDistance())
        Assertions.assertEquals(5, wonCar.getDistance())
    }
}