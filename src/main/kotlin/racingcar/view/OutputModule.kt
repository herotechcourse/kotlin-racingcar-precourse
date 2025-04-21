package racingcar.view

import racingcar.model.Car

interface OutputModule {
    fun outputEachRoundResult(cars: List<Car>)
    fun outputFinalWinner(cars: List<Car>): String
}