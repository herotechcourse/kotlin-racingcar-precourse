package racingcar.core

import racingcar.repository.CarRepository
import racingcar.util.Convertor.convertNamesToCars
import racingcar.util.Generator.generateRandomNumber
import racingcar.util.Validator.validate

class RaceCore(
    val names: String,
    val totalRound: Int,
    private val carRepository: CarRepository,
) {

    fun register() {
        convertNamesToCars(names).forEach {
            validate(it.name)
            carRepository.save(it)
        }
    }

    fun run() {
        println("Race Result")
        repeat(totalRound) {
            val cars = carRepository.fetchAll()
            cars.forEach {
                val car = it.forwardCar(generateRandomNumber())
                car.printProgress()
                carRepository.update(car)
            }
            println()
        }
    }
}