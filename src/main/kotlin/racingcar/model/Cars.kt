package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.exception.ExceptionMessage

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

    fun moveAll(){
        cars.forEach { car ->
            val random=Randoms.pickNumberInRange(Rules.RANDOM_MIN, Rules.RANDOM_MAX)
            car.move(random)
        }
    }

    fun getAll(): List<Car> = cars

    fun findWinners():List<Car>{
        val max=cars.maxOf{it.position()}
        return cars.filter{it.isWinner(max)}
    }
}