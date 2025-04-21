package racingcar.core

import racingcar.repository.CarRepository
import racingcar.util.Convertor.convertCarsToNames
import racingcar.util.Convertor.convertNamesToCars
import racingcar.util.Generator.generateRandomNumber
import racingcar.util.Validator.validate

class RaceCore(
    val names: String,
    val totalRound: Int,
    private val carRepository: CarRepository,
) {

    fun run() {
        register()
        start()
        printWinner()
    }

    fun register() {
        convertNamesToCars(names).forEach {
            validate(it.name)
            carRepository.save(it)
        }
    }

    fun start() {
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

    fun printWinner() {
        val cars = carRepository.fetchAll()
        val maxProgress = cars.maxOf { it.currentProgress }

        val winners = convertCarsToNames(cars.filter { it.currentProgress == maxProgress })
        println("Winners : " + winners)
    }
}