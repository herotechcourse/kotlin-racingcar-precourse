package racingcar.backend.service

import racingcar.backend.domain.validator.RaceNameValidator

class RacingService {
    private fun validateCarNames(nameList: List<String>) {
        nameList.forEach { carName ->
            RaceNameValidator.validateCarNameIsBlank(carName)
            RaceNameValidator.validateCarNameLength(carName)
        }
        RaceNameValidator.validateDuplicateCarNames(nameList)
        RaceNameValidator.validateMinimumNumberOfCars(nameList)
    }
}