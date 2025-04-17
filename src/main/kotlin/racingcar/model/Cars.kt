package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.exception.ExceptionMessage
import racingcar.strategy.move.MoveStrategy
import racingcar.strategy.winner.WinnerStrategy

class Cars(names: List<String>){
    private val rawNames: List<String> = names

    init {
        validate(rawNames)
    }

    private val cars: List<Car> = rawNames.map { Car(CarName(it.trim())) }

    private fun validate(names: List<String>) {
        if(names.any{it.isBlank()}) {
            throw IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.message)
        }
        val trimmedNames = names.map{it.trim()}
        if(trimmedNames.distinct().size != trimmedNames.size){
            throw IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_NAME.message)
        }
    }

    fun moveAll(strategy: MoveStrategy){
        cars.forEach { car -> car.move(strategy) }
    }

    fun getAll(): List<Car> = cars

    fun findWinners(strategy: WinnerStrategy):List<Car>{
        return strategy.selectWinners(cars)
    }
}