package racingcar

interface WinnerDeterminerInterface {
    fun findWinners(cars: List<Car>): List<String>
}
