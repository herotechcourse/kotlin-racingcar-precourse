package racingcar.core

import racingcar.repository.CarRepository
import racingcar.util.Convertor
import racingcar.util.Validator

class RaceCore(
    val names: String,
    val totalRound: Int,
    private val convertor: Convertor = Convertor,
    private val validator: Validator = Validator,
    private val carRepository: CarRepository = CarRepository(),
) {

    fun register() {
        convertor.convertNamesToCars(names).forEach {
            validator.validate(it.name)
            carRepository.save(it)
        }
    }
}