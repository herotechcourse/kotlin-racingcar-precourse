package racingcar

class RacingCar(val name: String) {
    private var distanceTraveled: Int = 0
    private var thresholdToMove: Int = 4
    private var distancePerStep: Int = 1

    fun tryMove(chance : Int) {
        if (isMoveable(chance)) {
            distanceTraveled += distancePerStep
        }
    }

    private fun isMoveable(chance : Int) : Boolean {
        return chance >= thresholdToMove
    }

    fun printState() {
        println("$name : ${getStateBar()}")
    }

    private fun getStateBar() : String {
        return "-".repeat(distanceTraveled)
    }

    fun getDistanceTraveled(): Int {
        return distanceTraveled
    }
}