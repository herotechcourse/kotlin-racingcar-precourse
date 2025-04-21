package racingcar.domain

class RacingGame(private val cars: List<Car>, var curRoundNum:Int = 0) {
    fun createCarsFromInput(carNamesInputList: List<String>): RacingGame {
        val cars = carNamesInputList.map { Car(it) }
        return RacingGame(cars)
    }

    fun executeRound(){
        curRoundNum++
        cars.forEach{car-> car.moveIfRandomNumberIsOverFour()}
    }

}