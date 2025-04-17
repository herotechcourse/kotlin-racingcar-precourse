package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.exception.ExceptionMessage
import racingcar.strategy.move.MoveStrategy
import racingcar.strategy.winner.WinnerStrategy
import racingcar.utils.Validator

class Cars(names: List<String>){

    init {
        Validator.validateCarNames(names)
    }

    private val cars: List<Car> = names.map { Car(CarName(it.trim())) }

    fun moveAll(strategy: MoveStrategy){
        cars.forEach { car -> car.move(strategy) }
    }

    fun getAll(): List<Car> = cars

    fun findWinners(strategy: WinnerStrategy):List<Car>{
        return strategy.selectWinners(cars)
    }
}