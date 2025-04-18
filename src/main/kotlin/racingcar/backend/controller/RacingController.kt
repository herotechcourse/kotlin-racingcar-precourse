package racingcar.backend.controller

import racingcar.backend.dto.CarDto
import racingcar.backend.dto.CarNameRequest
import racingcar.backend.service.RacingService

class RacingController(
    private val racingService: RacingService
) {
    fun inputCarNames(carNameRequest: CarNameRequest): List<CarDto> {
        return racingService.inputCarNames(carNameRequest)
    }
}