package racingcar

interface Drivable {
    fun tryMove(chance : Int)
    fun getDistanceTraveled(): Int
}