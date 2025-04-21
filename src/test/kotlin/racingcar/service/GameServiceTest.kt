package racingcar.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.fixture.CarFixture

class GameServiceTest {
    private val service = GameService()

    @Test
    @DisplayName("[Success] pobi moves 4, won moves 5, then winner is won")
    fun `test racing all car`() {
        val carFixture = CarFixture()
        val testingCars = carFixture.toDomain()

        service.raceAll(6, testingCars)
        val winner = service.findWinners(testingCars)
        Assertions.assertEquals(winner.winners.first().name, carFixture.getWon().getName())
    }

    @Test
    @DisplayName("[Success] pobi moves 4, won and mina move 5, then won and mina are winner")
    fun `test multi winners`() {
        val carFixture = CarFixture()
        val testingCars = carFixture.toDomain()

        service.raceAll(6, testingCars)
        val winners = service.findWinners(testingCars)
        Assertions.assertTrue { winners.winners.size == 2 }
        Assertions.assertEquals(winners.winners[1].name, carFixture.getMina().getName())
    }
}