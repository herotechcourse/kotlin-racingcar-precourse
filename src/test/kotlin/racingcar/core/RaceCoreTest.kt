package racingcar.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.repository.CarRepository
import racingcar.util.ExceptionMessage

class RaceCoreTest {

    @Test
    fun `throw IllegalArgumentException when provided name is null or empty or less 1 characters`() {
        //given
        val invalidCarName = ""
        val carNames = "poby,jinju," + invalidCarName
        val core = RaceCore(carNames, 5, CarRepository())

        //when
        val exception = assertThrows<IllegalArgumentException> {
            core.register()
        }

        //then
        assertEquals(exception.message, ExceptionMessage.NAME_LENGTH_UNDER_1.message)
    }

    @Test
    fun `throw IllegalArgumentException when provided name exceed 5 characters`() {
        //given
        val invalidCarName = "bad*name"
        val carNames = "poby,jinju," + invalidCarName
        val core = RaceCore(carNames, 5, CarRepository())

        //when
        val exception = assertThrows<IllegalArgumentException> {
            core.register()
        }

        //then
        assertEquals(exception.message, ExceptionMessage.NAME_LENGTH_EXCEED_5.message)
    }

    @Test
    fun `register participants in RaceCore`() {
        //given
        val carNames = "poby,woni,jun"
        val carRepository = CarRepository()
        val core = RaceCore(carNames, 5, carRepository)

        //when
        core.register()

        //then
        val expectedRegisterNumber = 3
        assertEquals(carRepository.fetchAll().size, expectedRegisterNumber)
    }

    @Test
    fun `run progress each round and print current progress each participants`() {
        //given
        val carNames = "poby,woni,jun"
        val core = RaceCore(carNames, 5, CarRepository())

        //when
        //then
        core.register()
        core.run()
    }

    @Test
    fun `printWinner print winners who move max distance`() {
        //given
        val carNames = "poby,woni,jun"
        val core = RaceCore(carNames, 5, CarRepository())

        //when
        //then
        core.register()
        core.run()
        core.printWinner()
    }

}