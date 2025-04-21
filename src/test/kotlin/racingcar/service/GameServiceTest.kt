package racingcar.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.fixture.CarFixture

class GameServiceTest {
    private val service = GameService()

    @Test
    @DisplayName("[Success] pobi moves 4, won moves 5")
    fun `test racing all car`() {
        val fixture = CarFixture.VALID_CARS
        val testingCars = fixture.toDomain()

        service.raceAll(6, testingCars)

        Assertions.assertEquals(4, fixture.four.getDistance())
        Assertions.assertEquals(5, fixture.five.getDistance())
    }
}