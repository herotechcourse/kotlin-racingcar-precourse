package racingcar.util

import racingcar.Car
import racingcar.generator.FixedRandomNumberGenerator

object TestCarFactory {

    private val alwaysMoveGenerator = FixedRandomNumberGenerator(9)

    fun buildCar(name: String, position: Int): Car {
        val car = Car(name)
        repeat(position) {
            car.move(alwaysMoveGenerator)
        }
        return car
    }

}