package racingcar.domain

import racingcar.domain.car.Car

class RaceResult(private val raceCompletedCars: Cars) {

    fun findCarsAtMaxPosition(): List<Car> {
        val maxPosition = raceCompletedCars.getMaxPosition()
        return raceCompletedCars.findAllAtSamePosition(maxPosition)
    }
}
