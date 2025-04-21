package racingcar

import racingcar.model.RaceInputs
import racingcar.model.Car

class Race(raceInputs: RaceInputs) {
    val names: List<String> = raceInputs.cars
    val round: Int = raceInputs.round

    fun run() {
        val cars = createCarObj(names)
    }

    internal fun createCarObj(names:List<String>): List<Car> {
        return names.map {Car(it, 0)}
    }
}