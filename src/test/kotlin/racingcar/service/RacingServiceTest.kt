package racingcar.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.backend.dto.CarNameRequest
import racingcar.backend.service.RacingService

class RacingServiceTest {

    private val racingService = RacingService()

    @Test
    fun `should return list of CarDto from car name input`() {
        val request = CarNameRequest("pobi,woni")
        val result = racingService.inputCarNames(request)

        assertEquals(2, result.size)
        assertEquals("pobi", result[0].carName)
        assertEquals("woni", result[1].carName)
    }
}
