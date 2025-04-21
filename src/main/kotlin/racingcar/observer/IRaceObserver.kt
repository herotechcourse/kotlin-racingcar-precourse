package racingcar.observer

import racingcar.model.Car

interface IRaceObserver {
    fun notifyRound(round: Int, cars: List<Car>)
    fun notifyFinish(cars: List<Car>, winners: List<String>)
}
