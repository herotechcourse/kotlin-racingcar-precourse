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

    fun findWinner():List<Car>{
        val maxPosition = getWinnerPosition()
        var winnerList = cars.filter{it.getPosition()==maxPosition}
        return winnerList
    }

    private fun getWinnerPosition():Int = cars.maxOf{ it.getPosition() }


}