package racingcar.backend.service

import racingcar.backend.domain.validator.RaceNameValidator
import racingcar.backend.dto.CarDto

class RacingService {
    private fun validateCarNames(nameList: List<String>) {
        nameList.forEach { carName ->
            RaceNameValidator.validateCarNameIsBlank(carName)
            RaceNameValidator.validateCarNameLength(carName)
        }
        RaceNameValidator.validateDuplicateCarNames(nameList)
        RaceNameValidator.validateMinimumNumberOfCars(nameList)
    }

    private fun convertToCarDto(nameList: List<String>): List<CarDto> {
        return nameList.map { carName ->
            CarDto(carName = carName)
        }
    }
}